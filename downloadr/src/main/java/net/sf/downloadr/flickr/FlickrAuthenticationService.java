package net.sf.downloadr.flickr;

public interface FlickrAuthenticationService {
	public String getFrob() throws FlickrServiceException;
	public String getToken() throws FlickrServiceException;
	public String login() throws FlickrServiceException;
}
