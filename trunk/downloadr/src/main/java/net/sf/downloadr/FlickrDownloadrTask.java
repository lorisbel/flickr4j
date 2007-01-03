package net.sf.downloadr;

import java.io.IOException;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class FlickrDownloadrTask extends SwingWorker<Void, StringBuffer> {

	private FlickrDownloadr flickrDownloadr;
	private String targetDirectory;
	private String username;
	private JTextArea textArea;

	public FlickrDownloadrTask(JTextArea textArea, FlickrDownloadr flickrDownloadr, String username, String targetDirectory) {
		this.textArea = textArea;
		this.flickrDownloadr = flickrDownloadr;
		this.username = username;
		this.targetDirectory = targetDirectory;
	}

	@Override
	protected Void doInBackground() throws Exception {
		StringBuffer buffer = new StringBuffer();
    	try {
    		buffer.append(flickrDownloadr.downloadFlickr(username, targetDirectory));
    		publish(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			buffer.append(e);
		}
		return null;
	}

	@Override
	protected void process(List<StringBuffer> chunks) {
		this.textArea.append(chunks.get(chunks.size() - 1).toString());
	}
}
