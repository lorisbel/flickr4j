package net.sf.downloadr.flickr;

public class FlickrServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FlickrServiceException(Throwable throwable) {
		super(throwable);
	}

	public FlickrServiceException(String message) {
		super(message);
	}

	public FlickrServiceException(String message, Response response) {
		super(message + ": Error Message :" + response.getErrorMessage() + ", Error code :" + response.getErrorCode());
	}
}
