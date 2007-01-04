package net.sf.downloadr.flickr;

import java.net.URL;
import java.util.List;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;


public class FlickrServiceImplTest extends AbstractDependencyInjectionSpringContextTests {
	private FlickrServiceImpl flickrServiceImpl;
	private Authorisation authorisation;

	@Override
	protected String[] getConfigLocations() {
		return new String[] {"/applicationContext.xml"};
	}

	public void testGetPhotoSets() {
		List<Photoset> photosets = flickrServiceImpl.getPhotosets(authorisation.getUserId());
		assertFalse(photosets == null || photosets.isEmpty());
		Photoset firstPhotoset = photosets.get(1);
		assertEquals("Sydney, December 2007", firstPhotoset.getTitle());
		assertEquals("72157594416086046", firstPhotoset.getId());
		assertEquals(30, firstPhotoset.getPhotoIds().size());
	}

	public void testGetPhotosInASet() {
		List<String> photos = flickrServiceImpl.getPhotoIds("72157594416086046");
		assertFalse(photos == null || photos.isEmpty());
		assertEquals(30, photos.size());

		assertEquals("320058054", photos.get(0));
		assertEquals("320057990", photos.get(1));
	}

	public void testGetPhoto() {
		Photo photo = flickrServiceImpl.getPhoto("320057674");
		assertNotNull(photo);
		assertNotNull(photo.getOriginalPhotoUrl());
	}

	public void testLookupUser() throws Exception {
		assertEquals("25851484@N00", flickrServiceImpl.lookupUserId(new URL("http://www.flickr.com/photos/srirang")));
	}

	public void setFlickrServiceImpl(FlickrServiceImpl restFlickrService) {
		this.flickrServiceImpl = restFlickrService;
	}

	public void setAuthorisation(Authorisation authorisation) {
		this.authorisation = authorisation;
	}
}
