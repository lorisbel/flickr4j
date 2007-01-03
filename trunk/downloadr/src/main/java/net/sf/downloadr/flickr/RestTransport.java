package net.sf.downloadr.flickr;

import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

public class RestTransport implements Transport {
	private static final Log LOG = LogFactory.getLog(RestTransport.class);

	private Config config;

	public Response callMethod(String methodName, List<ServiceArgument> serviceArguments) throws FlickrServiceException {
		URL serviceUrl = createMethodCallWithApiKey(methodName, serviceArguments);
		URLConnection connection;
		Document doc = null;
		try {
			LOG.debug("Sending REST request :" + serviceUrl);
			connection = serviceUrl.openConnection();
			BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
	        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        doc = docBuilder.parse(bis);
		}
		catch (Exception e) {
			throw new FlickrServiceException(e);
		}
        return new RestResponse(doc);
	}

	public Response callMethod(String methodName, ServiceArgument serviceArgument) throws FlickrServiceException {
		return this.callMethod(methodName, Arrays.asList(new ServiceArgument[] {serviceArgument}));
	}

	public URL createMethodCallWithApiKey(String methodName, List<ServiceArgument> serviceArguments) {
		serviceArguments = new ArrayList<ServiceArgument>(serviceArguments);
		ServiceArgument apiKey = new ServiceArgument("api_key", config.getApiKey());
		ServiceArgument method = new ServiceArgument("method", methodName);
		serviceArguments.add(method);
		serviceArguments.add(apiKey);
		URL serviceUrl = createMethodCall("http://api.flickr.com/services/rest/?", serviceArguments);
		return serviceUrl;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public static URL createMethodCall(String transportUrl, List serviceArguments) {
		URL serviceUrl;
		try {
			StringBuffer serviceParameters = new StringBuffer(transportUrl);
			for (Object arg : serviceArguments) {
				ServiceArgument serviceArgument = (ServiceArgument)arg;
				serviceParameters.append(serviceArgument);
				serviceParameters.append("&");
			}
			int trimTo = serviceParameters.lastIndexOf("&");
			serviceUrl = trimTo == -1 ? new URL(serviceParameters.toString()) : new URL(serviceParameters.substring(0, trimTo));
		} catch (MalformedURLException e) {
			throw new FlickrServiceException(e);
		}
		return serviceUrl;
	}
}
