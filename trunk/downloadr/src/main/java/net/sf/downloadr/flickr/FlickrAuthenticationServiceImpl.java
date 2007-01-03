package net.sf.downloadr.flickr;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.downloadr.SignatureGenerator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

public class FlickrAuthenticationServiceImpl implements FlickrAuthenticationService {
	private static final Log LOG = LogFactory.getLog(FlickrAuthenticationServiceImpl.class);

	private Config config;
	private SignatureGenerator signatureGenerator;

	public String getFrob() throws FlickrServiceException {
		return this.getFrobArgument().getValue();
	}

	public ServiceArgument getFrobArgument() throws FlickrServiceException {
		URL serviceUrl;
		URLConnection connection;
		Document doc = null;
		try {
			serviceUrl = prepareSignedMethodCall("flickr.auth.getFrob", new ServiceArgument[] {});
			connection = serviceUrl.openConnection();
			BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
	        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        doc = docBuilder.parse(bis);
		} catch (Exception e) {
			throw new FlickrServiceException(e);
		}
        String frob = doc.getDocumentElement().getTextContent().trim();
        LOG.debug("Frob = " + frob);
        return new ServiceArgument("frob", frob);
	}

	@SuppressWarnings("unchecked")
	private URL prepareSignedMethodCall(String methodName, ServiceArgument[] serviceArguments) {
		ServiceArgument method = new ServiceArgument("method", methodName);
		List args = new ArrayList(Arrays.asList(serviceArguments));
		args.add(method);
		URL serviceUrl = sign(args);
        return serviceUrl;
	}

	public String getToken() throws FlickrServiceException {
		URL serviceUrl;
		URLConnection connection;
		Document doc = null;
		try {
			serviceUrl = prepareSignedMethodCall("flickr.auth.getToken", new ServiceArgument[] {getFrobArgument()});
			connection = serviceUrl.openConnection();
			BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
	        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        doc = docBuilder.parse(bis);
		} catch (Exception e) {
			throw new FlickrServiceException(e);
		}
        String token = doc.getDocumentElement().getTextContent().trim();
        LOG.debug("Token = " + token);
        return token;
	}

	@SuppressWarnings("unchecked")
	private URL sign(List serviceArguments) {
		return signedMethodCall("http://api.flickr.com/services/rest/?", serviceArguments);
	}

	@SuppressWarnings("unchecked")
	private URL signedMethodCall(String transportUrl, List serviceArguments) {
		serviceArguments = new ArrayList(serviceArguments);
		serviceArguments.add(new ServiceArgument("api_key", config.getApiKey()));
		ServiceArgument signature = new ServiceArgument("api_sig", signatureGenerator.generateSignature(serviceArguments));
		serviceArguments.add(signature);
		URL serviceUrl = RestTransport.createMethodCall(transportUrl, serviceArguments);
        return serviceUrl;
	}

	public String login() throws FlickrServiceException {
		return signedMethodCall("http://api.flickr.com/services/auth/?", Arrays.asList(new ServiceArgument[] {getFrobArgument(), new ServiceArgument("perms", "read")})).toString();
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public void setSignatureGenerator(SignatureGenerator signatureGenerator) {
		this.signatureGenerator = signatureGenerator;
	}
}
