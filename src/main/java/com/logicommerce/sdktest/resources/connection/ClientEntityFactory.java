package com.logicommerce.sdktest.resources.connection;

import java.nio.charset.StandardCharsets;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import com.logicommerce.sdk.resources.MultipartBody;
import com.logicommerce.sdk.resources.MultipartPart;

final class ClientEntityFactory {

	private static final ContentType MULTIPART_CONTENT_TYPE = ContentType.create("multipart/form-data");
	private static final ContentType TEXT_PART_CONTENT_TYPE = ContentType.TEXT_PLAIN.withCharset(StandardCharsets.UTF_8);

	private ClientEntityFactory() {
	}

	static HttpEntity create(ClientAttributes attributes) {
		if (attributes.hasMultipartBody()) {
			return createMultipart(attributes.getMultipartBody());
		}
		if (attributes.hasBody()) {
			return new StringEntity(attributes.getBody());
		}
		return null;
	}

	private static HttpEntity createMultipart(MultipartBody body) {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create()
			.setMode(HttpMultipartMode.LEGACY)
			.setContentType(MULTIPART_CONTENT_TYPE)
			.setCharset(StandardCharsets.UTF_8);
		body.getParts().forEach(part -> addPart(builder, part));
		return builder.build();
	}

	private static void addPart(MultipartEntityBuilder builder, MultipartPart part) {
		if (part.isFile()) {
			builder.addBinaryBody(part.name(), part.content(), toContentType(part.contentType()), part.fileName());
		} else {
			builder.addTextBody(part.name(), part.value(), TEXT_PART_CONTENT_TYPE);
		}
	}

	private static ContentType toContentType(String value) {
		if (value == null || value.isBlank()) {
			return ContentType.APPLICATION_OCTET_STREAM;
		}
		try {
			ContentType contentType = ContentType.parse(value);
			return contentType != null ? contentType : ContentType.APPLICATION_OCTET_STREAM;
		} catch (IllegalArgumentException e) {
			return ContentType.APPLICATION_OCTET_STREAM;
		}
	}

}
