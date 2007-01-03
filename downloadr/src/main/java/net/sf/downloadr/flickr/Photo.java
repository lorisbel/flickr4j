package net.sf.downloadr.flickr;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Photo {

	private String id;
	private String title;
	private String description;
	private String secret;
	private URL photoPageUrl;
	private Map<String, URL> sizesAndUrls = new HashMap<String, URL>();

	public static final String PHOTO_SIZE_SQUARE = "square";
	public static final String PHOTO_SIZE_THUMBNAIL = "thumbnail";
	public static final String PHOTO_SIZE_SMALL = "small";
	public static final String PHOTO_SIZE_MEDIUM = "medium";
	public static final String PHOTO_SIZE_ORIGINAL = "original";

	public Photo(String id, String title, String description, String secret, URL photoPageUrl) {
		this.id = id.trim();
		this.title = title == null ? "" : title.trim();
		this.description = description == null ? "" : description.trim();
		this.secret = secret;
		this.photoPageUrl = photoPageUrl;
	}

	void provideSizesAndUrls(Map<String, URL> sizesAndUrls) {
		this.sizesAndUrls = sizesAndUrls;
	}

	public String getId() {
		return this.id;
	}

	public String getSecret() {
		return this.secret;
	}

	public String getDescription() {
		return this.description;
	}

	public String getTitle() {
		return this.title;
	}

	public URL getUrl() {
		return this.photoPageUrl;
	}

	public URL getOriginalPhotoUrl() {
		return this.sizesAndUrls.get(Photo.PHOTO_SIZE_ORIGINAL);
	}
}
