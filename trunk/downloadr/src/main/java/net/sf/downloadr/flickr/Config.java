package net.sf.downloadr.flickr;

public class Config {
	private String apiKey;
	private String sharedSecret;

	public String getApiKey() {
		return this.apiKey;
	}

	public String getSharedSecret() {
		return this.sharedSecret;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public void setSharedSecret(String sharedSecret) {
		this.sharedSecret = sharedSecret;
	}
}
