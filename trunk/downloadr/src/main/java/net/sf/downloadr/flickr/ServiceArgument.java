package net.sf.downloadr.flickr;


public class ServiceArgument implements Comparable {
	private String name;
	private String value;

	public ServiceArgument(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public int compareTo(Object another) {
		return this.name.compareTo(((ServiceArgument)another).name);
	}

	@Override
	public String toString() {
		return this.name + "=" + this.value;
	}

	public String getPrefix() {
		return "method".equalsIgnoreCase(this.name) ? "?" : "&";
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}
}
