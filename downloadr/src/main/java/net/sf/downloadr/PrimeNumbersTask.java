/*
 * PrimeNumbersTask.java
 *
 * Created on 29 December 2006, 11:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.sf.downloadr;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author hoeusar
 */
public class PrimeNumbersTask extends SwingWorker<List<Integer>, Integer> {
    private JTextArea textArea;
    private int totalPhotos;

     PrimeNumbersTask(JTextArea textArea, int totalPhotos) { 
         this.textArea = textArea;
         this.totalPhotos = totalPhotos;
     }

     @Override
     public List<Integer> doInBackground() {
         List<Integer> photosDownloaded = new ArrayList<Integer>();
         while (photosDownloaded.size() < totalPhotos && !isCancelled()) {
             photosDownloaded.add(47);
             photosDownloaded.add(47);
             publish(47);
             int progress = 100 * photosDownloaded.size() / totalPhotos;
             if (progress <= 100) {
                setProgress(progress);
             }
         }
         return photosDownloaded;
     }

     @Override
     protected void process(List<Integer> chunks) {
         for (int number : chunks) {
             textArea.append(number + "\n");
         }
     }
}