package net.sf.downloadr.flickr;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Photoset {
	private String id;
	private String title;
	private String description;
	private String secret;

	private Collection<Photo> photos = new LinkedList<Photo>();

	public Photoset(String id, String title, String description, String secret) {
		super();
		this.id = id.trim();
		this.title = title == null ? "" : title.trim();
		this.description = description == null ? "" : description.trim();
		this.secret = secret;
	}

	void providePhotos(Collection<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public String getSecret() {
		return this.secret;
	}

	public Collection<Photo> getPhotos() {
		return Collections.unmodifiableCollection(this.photos);
	}
}
