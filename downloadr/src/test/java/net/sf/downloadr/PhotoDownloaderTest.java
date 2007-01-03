package net.sf.downloadr;

import java.net.URL;

import junit.framework.TestCase;

public class PhotoDownloaderTest extends TestCase {
	public void testDownloadUrl() throws Exception {
		URL url = new URL("http://farm1.static.flickr.com/128/320057674_f26708c378_o.jpg");
		new PhotoDownloader().downloadUrl(url, "target/test.jpg");
	}
}
