package net.sf.downloadr.flickr;

import java.util.List;

public interface Transport {
	Response callMethod(String methodName, ServiceArgument serviceArgument) throws FlickrServiceException;
	Response callMethod(String methodName, List<ServiceArgument> serviceArguments) throws FlickrServiceException;
}
