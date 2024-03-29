package net.sf.downloadr.flickr;

import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.TestCase;

import org.w3c.dom.Document;

public class FlickrXmlParserTest extends TestCase {
	private Response photosetResponse = new RestResponse(createDocument("/photosetResponse.xml"));
	private Response photoResponse = new RestResponse(createDocument("/photoResponse.xml"));
	private Response photoSizeResponse = new RestResponse(createDocument("/photoSizeResponse.xml"));
	private Response photosResponse = new RestResponse(createDocument("/photosResponse.xml"));
	private Response lookupUserResponse = new RestResponse(createDocument("/lookupUserResponse.xml"));

	private Document createDocument(String documentName) {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getClass().getResourceAsStream(documentName));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void testParsePhotosetResponse() {
		List<Photoset> photosets = FlickrXmlParser.extractPhotosets(photosetResponse);
		assertNotNull(photosets);
		assertEquals(12, photosets.size());

		Photoset photoset = photosets.get(0);
		assertEquals("Sydney, December 2007", photoset.getTitle());
		assertEquals("", photoset.getDescription());
		assertEquals("72157594416086046", photoset.getId());
		assertEquals("39a6d1ca42", photoset.getSecret());
	}

	public void testParsePhotoResponse() {
		Photo photo = FlickrXmlParser.extractPhoto(photoResponse);
		assertNotNull(photo);
		assertEquals("320058054", photo.getId());
		assertEquals("http://www.flickr.com/photos/srirang/320058054/", photo.getUrl().toString());
		assertEquals("DSC01489", photo.getTitle());
		assertEquals("", photo.getDescription());
		assertEquals("39a6d1ca42", photo.getSecret());
	}

	public void testParsePhotoSizeResponse() {
		Map<String, URL> sizesAndUrls = FlickrXmlParser.extractPhotoSizeUrl(photoSizeResponse);
		assertEquals("http://farm1.static.flickr.com/133/320058054_39a6d1ca42_s.jpg", sizesAndUrls.get(Photo.PHOTO_SIZE_SQUARE).toString());
		assertEquals("http://farm1.static.flickr.com/133/320058054_39a6d1ca42_t.jpg", sizesAndUrls.get(Photo.PHOTO_SIZE_THUMBNAIL).toString());
		assertEquals("http://farm1.static.flickr.com/133/320058054_39a6d1ca42_m.jpg", sizesAndUrls.get(Photo.PHOTO_SIZE_SMALL).toString());
		assertEquals("http://farm1.static.flickr.com/133/320058054_39a6d1ca42.jpg", sizesAndUrls.get(Photo.PHOTO_SIZE_MEDIUM).toString());
		assertEquals("http://farm1.static.flickr.com/133/320058054_39a6d1ca42_o.jpg", sizesAndUrls.get(Photo.PHOTO_SIZE_ORIGINAL).toString());
	}

	public void testParsePhotosResponse() {
		List<String> photoIds = FlickrXmlParser.extractPhotoIds(photosResponse);
		assertEquals(30, photoIds.size());
		assertEquals("320058054", photoIds.get(0));
		assertEquals("320057990", photoIds.get(1));
	}

	public void testParseUserLookupResponse() {
		assertEquals("25851484@N00", FlickrXmlParser.extractUserId(lookupUserResponse));
	}
}
