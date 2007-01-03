package net.sf.downloadr.flickr;

import java.util.Collection;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RestResponse implements Response {
	private String status;
	private Collection<Element> results;
	private String errorCode;
	private String errorMessage;

	private static final String RESPONSE_STATUS_SUCCESS = "ok";
	private static final String RESPONSE_STATUS_ERROR = "fail";

	public RestResponse(Document responseDocument) {
		this.parse(responseDocument);
	}

	@SuppressWarnings("unchecked")
	private void parse(Document document) {
        Element rspElement = document.getDocumentElement();
        rspElement.normalize();
        status = rspElement.getAttribute("stat");
        if(isOk()) {
            results = FlickrXmlParser.getChildElements(rspElement);
        }
        else if(isInError()) {
            Element errElement = (Element)rspElement.getElementsByTagName("err").item(0);
            errorCode = errElement.getAttribute("code");
            errorMessage = errElement.getAttribute("msg");
        }
        else {
        	throw new FlickrServiceException("Unknown response :" + status);
        }
	}

	public String getStatus() {
		return this.status;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public boolean isOk() {
		return RESPONSE_STATUS_SUCCESS.equals(status);
	}

	public boolean isInError() {
		return RESPONSE_STATUS_ERROR.equals(status);
	}

	public Collection getResults() {
		return this.results;
	}

	public Element getResult() {
		return this.results.iterator().next();
	}
}
