package net.sf.downloadr;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import net.sf.downloadr.flickr.FlickrService;
import net.sf.downloadr.flickr.Photo;
import net.sf.downloadr.flickr.Photoset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FlickrDownloadr {
	private static final Log LOG = LogFactory.getLog(FlickrDownloadr.class);

	private FlickrService flickrService;

	public StringBuffer downloadFlickr(String flickrUsername, String targetDirectory) throws IOException {
		URL photosPageUrl = new URL("http://www.flickr.com/photos/" + flickrUsername);
		return this.downloadFlickr(photosPageUrl, targetDirectory);
	}

	public StringBuffer downloadFlickr(URL photosPageUrl, String relativeTargetDirectory) throws IOException {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Looking up url :" + photosPageUrl);
		System.out.println("\nLooking up url :" + photosPageUrl);
		String userId = flickrService.lookupUserId(photosPageUrl);
		LOG.debug("User id is :" + userId);
		System.out.println("Locating photosets...");
		buffer.append("\nLocating photosets...");
		Collection<Photoset> photosets = flickrService.getPhotosets(userId);
		System.out.println("Found " + photosets.size() + " photo sets");
		buffer.append("\nFound " + photosets.size() + " photo sets");
		System.out.println("Downloading...");
		buffer.append("\nDownloading...");

		String targetDirectory = new File(relativeTargetDirectory).getAbsolutePath();
		for (Photoset photoset : photosets) {
			System.out.println("Photoset: " + photoset.getTitle() + " with " + photoset.getPhotos().size() + " photos");
			buffer.append("\nPhotoset: " + photoset.getTitle() + " with " + photoset.getPhotos().size() + " photos");
			String photosetDirectory = targetDirectory + File.separator + photoset.getTitle();
			new File(photosetDirectory).mkdirs();
			for (Photo emptyPhoto : photoset.getPhotos()) {
				Photo photo = flickrService.getPhoto(emptyPhoto.getId());
				String targetFilename = photosetDirectory + File.separator + photo.getTitle() + ".jpg";
				if (!new OverwritePhotoPolicy().shouldOverwrite(photo, targetFilename)) {
					System.out.println(photo.getTitle() + " already exisits...download skipped");
					buffer.append("\n" + photo.getTitle() + " already exisits...download skipped");
					continue;
				}
				buffer.append(new PhotoDownloader().downloadOriginalPhoto(photo, targetFilename));
			}
		}
		return buffer;
	}

	public void setFlickrService(FlickrService flickrService) {
		this.flickrService = flickrService;
	}
}
