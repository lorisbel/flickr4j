package net.sf.downloadr.flickr;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class ConfigTest extends AbstractDependencyInjectionSpringContextTests {
	private Config config;

	@Override
	protected String[] getConfigLocations() {
		return new String[] {"/applicationContext.xml"};
	}

	public void testConfig() {
		assertNotNull(config);
		assertEquals(32, config.getApiKey().length());
		assertEquals(16, config.getSharedSecret().length());
	}

	public void setConfig(Config config) {
		this.config = config;
	}
}
