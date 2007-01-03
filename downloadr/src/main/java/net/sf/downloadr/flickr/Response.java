package net.sf.downloadr.flickr;

import java.util.Collection;
import org.w3c.dom.Element;

public interface Response {
	String getStatus();
	String getErrorMessage();
	String getErrorCode();
	boolean isInError();
	Collection getResults();
	Element getResult();
}
