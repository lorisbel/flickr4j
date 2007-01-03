package net.sf.downloadr.flickr;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class FlickrXmlParser {
	public static List<Photoset> extractPhotosets(Response response) {
		List<Photoset> photosets = new ArrayList<Photoset>();
		NodeList photosetElements = response.getResult().getElementsByTagName("photoset");
		for (int i = 0; i < photosetElements.getLength(); i++) {
            Element photosetElement = (Element)photosetElements.item(i);
			Photoset photoset = extractPhotoset(photosetElement);
			photosets.add(photoset);
		}
		return photosets;
	}

	private static Photoset extractPhotoset(Element photosetElement) {
		Photoset photoset = new Photoset(photosetElement.getAttribute("id"), getChildValue(photosetElement, "title"), getChildValue(photosetElement, "description"), photosetElement.getAttribute("secret"));
		return photoset;
	}

	public static Photo extractPhoto(Response response) {
		Element photoElement = (Element)response.getResult();
		URL imageUrl;
		try {
			imageUrl = new URL(photoElement.getElementsByTagName("urls").item(0).getTextContent().trim());
		}
		catch (Exception e) {
			throw new FlickrServiceException(e);
		}
		Photo photo = new Photo(photoElement.getAttribute("id"), getChildValue(photoElement, "title"), getChildValue(photoElement, "description"), photoElement.getAttribute("secret"), imageUrl);
		return photo;
	}

	public static List<Photo> extractPhotos(Response photosResponse) {
		NodeList photosList = photosResponse.getResult().getElementsByTagName("photo");
		List<Photo> photos = new ArrayList<Photo>(photosList.getLength());
		for (int i = 0; i < photosList.getLength(); i++) {
			Element photoElement = (Element)photosList.item(i);
			photos.add(new Photo(photoElement.getAttribute("id"), getChildValue(photoElement, "title"), getChildValue(photoElement, "description"), photoElement.getAttribute("secret"), null));
		}
		return photos;
	}

	public static Map<String, URL> extractPhotoSizeUrl(Response photoSizeResponse) {
		NodeList photosetElements = photoSizeResponse.getResult().getElementsByTagName("size");
		Map<String, URL> sizesAndUrls = new HashMap<String, URL>();
		for (int i = 0; i < photosetElements.getLength(); i++) {
            Element photosetElement = (Element)photosetElements.item(i);
            try {
            	sizesAndUrls.put(photosetElement.getAttribute("label").toLowerCase(), new URL(photosetElement.getAttribute("source")));
    		}
    		catch (Exception e) {
    			throw new FlickrServiceException(e);
    		}
		}
		return sizesAndUrls;
	}

	public static String extractUserId(Response lookupUserResponse) {
		return lookupUserResponse.getResult().getAttribute("id").trim();
	}

	public static Collection getChildElements(Node node) {
		List<Node> elements = new ArrayList<Node>();
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node childNode = nodes.item(i);
			if (childNode instanceof Element) {
				elements.add(childNode);
			}
		}
		return elements;
	}

	public static String getValue(Element element) {
		if (element != null) {
			Node dataNode = element.getFirstChild();
			if (dataNode != null) {
				return ((Text) dataNode).getData();
			}
		}
		return null;
	}

	public static Element getChild(Element element, String name) {
		return (Element) element.getElementsByTagName(name).item(0);
	}

	public static String getChildValue(Element element, String name) {
		return getValue(getChild(element, name));
	}
}
