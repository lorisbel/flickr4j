package net.sf.downloadr;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * @author hoeusar
 */
public class SignatureGeneratorTest extends AbstractDependencyInjectionSpringContextTests {
	private SignatureGenerator signatureGenerator;

	@Override
	protected String[] getConfigLocations() {
		return new String[] {"/applicationContext.xml"};
	}

	public void testMd5() {
		assertEquals("c39c2b8d06430ea47c60c5fe3d7943bb", signatureGenerator.md5("0f6fbdc8b92f4e14api_keye84a2e3fcb116e90a42884d9d3a2036dmethodflickr.auth.getFrob"));
	}

	public void setSignatureGenerator(SignatureGenerator signatureGenerator) {
		this.signatureGenerator = signatureGenerator;
	}
}
