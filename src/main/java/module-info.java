module com.logicommerce.sdktest {
	requires transitive com.logicommerce.sdk;
	requires transitive java.logging;
	requires com.logicommerce.utilities;
	requires org.apache.httpcomponents.client5.httpclient5;
	requires org.apache.httpcomponents.core5.httpcore5;

	requires transitive async.http.client;
	requires transitive org.reactivestreams;
	requires transitive io.netty.codec.http;
	requires transitive io.netty.buffer;

	opens com.logicommerce.sdktest.resources;
	
	exports com.logicommerce.sdktest;
	exports com.logicommerce.sdktest.definition;
	exports com.logicommerce.sdktest.models;
	exports com.logicommerce.sdktest.models.order;
	exports com.logicommerce.sdktest.resources;
	exports com.logicommerce.sdktest.resources.connection;
}