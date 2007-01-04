package net.sf.downloadr.flickr;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FlickrServiceImpl implements FlickrService {
	private Transport transport;

	public List<Photoset> getPhotosets(String userId) throws FlickrServiceException {
		ServiceArgument userIdArg = new ServiceArgument("user_id", userId);
		Response response = transport.callMethod("flickr.photosets.getList", Arrays.asList(new ServiceArgument[] {userIdArg}));
		if (response.isInError()) {
			throw new FlickrServiceException("Error getting photosets for user", response);
		}
		List<Photoset> photosets = FlickrXmlParser.extractPhotosets(response);
		for (Photoset photoset : photosets) {
			photoset.providePhotoIds(getPhotoIds(photoset.getId()));
		}
		return photosets;
	}

	List<String> getPhotoIds(String photosetId) {
		ServiceArgument userIdArg = new ServiceArgument("photoset_id", photosetId);
		Response response = transport.callMethod("flickr.photosets.getPhotos", Arrays.asList(new ServiceArgument[] {userIdArg}));
		if (response.isInError()) {
			throw new FlickrServiceException("Error getting photos in photoset for user", response);
		}
		return FlickrXmlParser.extractPhotoIds(response);
	}

	public Photo getPhoto(String photoId) throws FlickrServiceException {
		ServiceArgument userIdArg = new ServiceArgument("photo_id", photoId);
		Response response = transport.callMethod("flickr.photos.getInfo", Arrays.asList(new ServiceArgument[] {userIdArg}));
		if (response.isInError()) {
			throw new FlickrServiceException("Error getting photo", response);
		}
		Photo photo = FlickrXmlParser.extractPhoto(response);
		photo.provideSizesAndUrls(getPhotoSizesAndUrls(photoId));
		return photo;
	}

	public String lookupUserId(URL photosPageUrl) {
		ServiceArgument userIdArg = new ServiceArgument("url", photosPageUrl.toString());
		Response response = transport.callMethod("flickr.urls.lookupUser", Arrays.asList(new ServiceArgument[] {userIdArg}));
		if (response.isInError()) {
			throw new FlickrServiceException("Error getting photo", response);
		}
		return FlickrXmlParser.extractUserId(response);
	}

	Map<String, URL> getPhotoSizesAndUrls(String photoId) throws FlickrServiceException {
		ServiceArgument userIdArg = new ServiceArgument("photo_id", photoId);
		Response response = transport.callMethod("flickr.photos.getSizes", Arrays.asList(new ServiceArgument[] {userIdArg}));
		if (response.isInError()) {
			throw new FlickrServiceException("Error getting photo", response);
		}
		return FlickrXmlParser.extractPhotoSizeUrl(response);
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}
}
