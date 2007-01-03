package net.sf.downloadr.flickr;

import java.net.URL;
import java.util.List;


public interface FlickrService {
	List<Photoset> getPhotosets(String userId) throws FlickrServiceException;
	Photo getPhoto(String photoId) throws FlickrServiceException;
	String lookupUserId(URL photosPageUrl);
}
