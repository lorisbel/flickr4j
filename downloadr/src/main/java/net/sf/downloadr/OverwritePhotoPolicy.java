package net.sf.downloadr;

import java.io.File;

import net.sf.downloadr.flickr.Photo;

public class OverwritePhotoPolicy {
	public boolean shouldOverwrite(Photo photo, String targetFilename) {
		File fileToDownload = new File(targetFilename);
		if (fileToDownload.exists() && fileToDownload.length() != 0) {
			return false;
		}
		return true;
	}
}
