package net.sf.downloadr.flickr;

import java.net.URL;
import java.util.Arrays;

import junit.framework.TestCase;

public class RestTransportTest extends TestCase {

	private RestTransport restTransport;

	@Override
	protected void setUp() throws Exception {
		this.restTransport = new RestTransport();
		Config testConfig = new Config();
		testConfig.setApiKey("apiKeyForTesting");
		testConfig.setSharedSecret("sharedSecretForTesting");
		this.restTransport.setConfig(testConfig);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		this.restTransport = null;
		super.tearDown();
	}

	public void testCreateMethodCall() {
		ServiceArgument arg1 = new ServiceArgument("foo", "1");
		ServiceArgument arg2 = new ServiceArgument("baz", "2");
		ServiceArgument arg3 = new ServiceArgument("bar", "3");

		URL url = RestTransport.createMethodCall("http://flickr.com/service/?", Arrays.asList(new ServiceArgument[] {}));
		assertEquals("http://flickr.com/service/?", url.toString());

		url = RestTransport.createMethodCall("http://flickr.com/service/?", Arrays.asList(new ServiceArgument[] {arg1}));
		assertEquals("http://flickr.com/service/?foo=1", url.toString());

		url = RestTransport.createMethodCall("http://flickr.com/service/?", Arrays.asList(new ServiceArgument[] {arg3}));
		assertEquals("http://flickr.com/service/?bar=3", url.toString());

		url = RestTransport.createMethodCall("http://flickr.com/service/?", Arrays.asList(new ServiceArgument[] {arg1, arg2, arg3}));
		assertEquals("http://flickr.com/service/?foo=1&baz=2&bar=3", url.toString());

		url = restTransport.createMethodCallWithApiKey("myMethod", Arrays.asList(new ServiceArgument[] {}));
		assertEquals("http://api.flickr.com/services/rest/?method=myMethod&api_key=apiKeyForTesting", url.toString());
	}
}
