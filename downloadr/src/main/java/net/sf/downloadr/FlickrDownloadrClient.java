package net.sf.downloadr;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.SingletonBeanFactoryLocator;

public class FlickrDownloadrClient {
	public static void main(String[] args) {
		System.out.println("FlickrDownloadr v0.0.1");
		if (args.length != 2) {
			System.out.println("Incorrect usage");
			showUsage();
			System.exit(-1);
		}

		String targetDirectory = args[1];
		if (!new File(targetDirectory).exists()) {
			System.out.println(targetDirectory + " does not exist, it will be created");
		}
		System.out.println("Will download photos to " + new File(targetDirectory).getAbsolutePath());
		URL photoPageUrl = null;
		String flickrUsername = null;
		String user = args[0];
		try {
			photoPageUrl = new URL(user);
			System.out.println("Will download photos from " + photoPageUrl);
		}
		catch (MalformedURLException e) {
			System.out.println(user + " does not look like a URL, treating it as your flickr username");
			flickrUsername = user;
			System.out.println("Will download photos for user " + flickrUsername);
		}
		BeanFactory beanFactory = SingletonBeanFactoryLocator.getInstance().useBeanFactory(FlickrDownloadrClient.class.getPackage().getName()).getFactory();
		FlickrDownloadr flickrDownloadr = (FlickrDownloadr)beanFactory.getBean(FlickrDownloadr.class.getName());
		try {
			if (photoPageUrl != null) {
				flickrDownloadr.downloadFlickr(photoPageUrl, targetDirectory);
			}
			else if (flickrUsername != null) {
				flickrDownloadr.downloadFlickr(flickrUsername, targetDirectory);
			}
		} catch (IOException e) {
			System.out.println("Error downloading photos from flickr\n");
			e.printStackTrace();
		}
	}

	private static void showUsage() {
		System.out.println("Usage: ");
		System.out.println("\tFlickrDownloadr <flickr_username> <target_directory> or ");
		System.out.println("\tFlickrDownloadr <your_photo_page_url> <target_directory>");
		System.out.println("Example:");
		System.out.println("\tFlickrDownloadr johnq /home/johnq/flickr");
		System.out.println("\tFlickrDownloadr http://www.flickr.com/photos/johnq /home/johnq/flickr");
	}
}
