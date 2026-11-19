package com.logicommerce.sdktest.resources;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.logicommerce.sdk.resources.MultipartBody;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdk.resources.Response;

class ConnectionHelperMultipartTest {

	private static final String UNREACHABLE_URL = "http://localhost:1";
	private static final byte[] BINARY_CONTENT = { (byte) 0x89, 'P', 'N', 'G', (byte) 0xFF, 0x00, (byte) 0x80 };

	private static final String HEADERS_END = "\r\n\r\n";
	private static final String CONTENT_TYPE = "content-type:";
	private static final String CONTENT_LENGTH = "content-length:";

	private ServerSocket server;
	private Thread serverThread;
	private String receivedMethod;
	private String receivedContentType;
	private byte[] receivedBody;

	@BeforeEach
	void setUp() throws IOException {
		server = new ServerSocket(0, 1, InetAddress.getLoopbackAddress());
		serverThread = new Thread(this::serve);
		serverThread.start();
	}

	@AfterEach
	void tearDown() throws IOException, InterruptedException {
		server.close();
		serverThread.join();
	}

	@Test
	void testPostSendsMultipartBodyWithUnchangedFileBytes() throws PluginResourceException {
		MultipartBody body = new MultipartBody()
			.text("body", "Año nuevo")
			.file("attachments[]", "año.png", "image/png", BINARY_CONTENT);

		Response response = new ConnectionHelper().init(serverUrl())
			.contentType("application/json")
			.post(body);

		String content = new String(receivedBody, StandardCharsets.UTF_8);
		assertEquals(201, response.getStatusCode());
		assertEquals("POST", receivedMethod);
		assertTrue(receivedContentType.startsWith("multipart/form-data; boundary="));
		assertFalse(receivedContentType.contains("ISO-8859-1"));
		assertTrue(content.contains("Año nuevo"));
		assertTrue(content.contains("name=\"attachments[]\"; filename=\"año.png\""));
		assertTrue(contains(receivedBody, BINARY_CONTENT));
	}

	@Test
	void testPutSendsMultipartBody() throws PluginResourceException {
		new ConnectionHelper().init(serverUrl()).put(new MultipartBody().text("status", "5"));

		assertEquals("PUT", receivedMethod);
		assertTrue(receivedContentType.startsWith("multipart/form-data; boundary="));
	}

	@Test
	void testRejectsBodyLargerThanDefaultMaximum() {
		MultipartBody body = bodyOfSize(MultipartBody.MAX_SIZE + 1);

		assertThrows(PluginResourceException.class, () -> new ConnectionHelper().init(UNREACHABLE_URL).post(body));
	}

	@Test
	void testMaximumCannotExceedDefault() {
		MultipartBody body = bodyOfSize(MultipartBody.MAX_SIZE + 1);

		assertThrows(PluginResourceException.class,
			() -> new ConnectionHelper().init(UNREACHABLE_URL).multipartMaxSize(Integer.MAX_VALUE).put(body));
	}

	@Test
	void testRejectsBodyLargerThanConfiguredMaximum() {
		assertThrows(PluginResourceException.class,
			() -> new ConnectionHelper().init(UNREACHABLE_URL).multipartMaxSize(5).post(bodyOfSize(6)));
	}

	@Test
	void testAcceptsBodyEqualToConfiguredMaximumAndIgnoresNonPositiveMaximum() throws PluginResourceException {
		Response response = new ConnectionHelper().init(serverUrl())
			.multipartMaxSize(5)
			.multipartMaxSize(0)
			.post(bodyOfSize(5));

		assertEquals(201, response.getStatusCode());
	}

	private void serve() {
		while (!server.isClosed()) {
			try (Socket socket = server.accept()) {
				handle(socket.getInputStream(), socket.getOutputStream());
			} catch (IOException e) {
				return;
			}
		}
	}

	private void handle(InputStream input, OutputStream output) throws IOException {
		String headers = readHeaders(input);
		String[] lines = headers.split("\r\n");
		receivedMethod = lines[0].split(" ")[0];
		receivedContentType = headerValue(lines, CONTENT_TYPE);
		receivedBody = input.readNBytes(Integer.parseInt(headerValue(lines, CONTENT_LENGTH)));
		output.write("HTTP/1.1 201 Created\r\nContent-Length: 2\r\nConnection: close\r\n\r\n{}".getBytes(StandardCharsets.US_ASCII));
		output.flush();
	}

	private static String readHeaders(InputStream input) throws IOException {
		ByteArrayOutputStream headers = new ByteArrayOutputStream();
		while (!headers.toString(StandardCharsets.ISO_8859_1).endsWith(HEADERS_END)) {
			int next = input.read();
			if (next < 0) {
				throw new IOException("Connection closed before the end of the headers");
			}
			headers.write(next);
		}
		return headers.toString(StandardCharsets.ISO_8859_1);
	}

	private static String headerValue(String[] lines, String name) {
		return Arrays.stream(lines)
			.filter(line -> line.toLowerCase(Locale.ROOT).startsWith(name))
			.map(line -> line.substring(name.length()).trim())
			.findFirst()
			.orElse("0");
	}

	private String serverUrl() {
		return "http://localhost:" + server.getLocalPort();
	}

	private static MultipartBody bodyOfSize(int size) {
		return new MultipartBody().file("attachments[]", "file.bin", "application/octet-stream", new byte[size]);
	}

	private static boolean contains(byte[] content, byte[] expected) {
		for (int i = 0; i <= content.length - expected.length; i++) {
			if (Arrays.equals(content, i, i + expected.length, expected, 0, expected.length)) {
				return true;
			}
		}
		return false;
	}

}
