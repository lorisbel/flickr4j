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

	private Collection<String> photoIds = new LinkedList<String>();

	public Photoset(String id, String title, String description, String secret) {
		super();
		this.id = id.trim();
		this.title = title == null ? "" : title.trim();
		this.description = description == null ? "" : description.trim();
		this.secret = secret;
	}

	void providePhotoIds(Collection<String> photoIds) {
		this.photoIds = photoIds;
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

	public Collection<String> getPhotoIds() {
		return Collections.unmodifiableCollection(this.photoIds);
	}
}
