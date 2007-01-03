package net.sf.downloadr.flickr;

import org.apache.commons.lang.StringUtils;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class FlickrAuthenticationServiceImplTest extends AbstractDependencyInjectionSpringContextTests {
	private FlickrAuthenticationServiceImpl flickrAuthenticationServiceImpl;

	@Override
	protected String[] getConfigLocations() {
		return new String[] {"/applicationContext.xml"};
	}

	public void testGetFrob() {
		String frob = flickrAuthenticationServiceImpl.getFrob();
		assertEquals(24, frob.length());
	}

	public void testLoginUrl() {
		String loginUrl = flickrAuthenticationServiceImpl.login();
		assertFalse(StringUtils.isEmpty(loginUrl));
		System.out.println(loginUrl);
	}

	public void setFlickrAuthenticationServiceImpl(FlickrAuthenticationServiceImpl flickrAuthenticationServiceImpl) {
		this.flickrAuthenticationServiceImpl = flickrAuthenticationServiceImpl;
	}
}
