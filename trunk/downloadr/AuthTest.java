package net.sf.downloadr.flickr;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.aetrion.flickr.FlickrException;
import com.aetrion.flickr.REST;
import com.aetrion.flickr.RequestContext;
import com.aetrion.flickr.Transport;
import com.aetrion.flickr.auth.Auth;
import com.aetrion.flickr.auth.AuthInterface;
import com.aetrion.flickr.auth.Permission;

import junit.framework.TestCase;

public class AuthTest extends TestCase {
	public void testAuth() throws ParserConfigurationException, IOException, SAXException, FlickrException {
		Transport transport = new REST();
		transport.setHost("www.flickr.com");
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setSharedSecret("0f6fbdc8b92f4e14");
		AuthInterface authInterface = new AuthInterface("e84a2e3fcb116e90a42884d9d3a2036d", transport);
		String frob = authInterface.getFrob();
		System.out.println(frob);
		assertNotNull(frob);
		assertEquals(24, frob.length());

		URL authUrl = authInterface.buildAuthenticationUrl(Permission.READ, frob);
		assertNotNull(authUrl);
		System.out.println(authUrl);
		Auth auth = authInterface.getToken(frob);
		assertNotNull(auth);
		assertEquals(24, auth.getToken().length());
		System.out.println(auth.getToken());
		String token = "1656176-a3bf00fc2ba3f938";
		String userId = "25851484@N00";
	}
}
