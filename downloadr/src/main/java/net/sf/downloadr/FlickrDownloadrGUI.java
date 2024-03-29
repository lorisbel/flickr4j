/*
 * FlickrDownloadrGUI.java
 *
 * Created on 29 December 2006, 10:43
 */

package net.sf.downloadr;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JCheckBox;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.SingletonBeanFactoryLocator;

/**
 *
 * @author  hoeusar
 */
public class FlickrDownloadrGUI extends javax.swing.JFrame {
    
    /** Creates new form FlickrDownloadrGUI */
    public FlickrDownloadrGUI() {
        setPlatformLnF();
        initBeans();
        initComponents();
    }

    private void initBeans() throws FatalBeanException, BeansException, RuntimeException {
        new SwingWorker<BeanFactory, Void>() {
            @Override
            protected BeanFactory doInBackground() throws Exception {
                return SingletonBeanFactoryLocator.getInstance().useBeanFactory(FlickrDownloadrClient.class.getPackage().getName()).getFactory();
            }
            @Override
            protected void done() {
                try {
                    flickrDownloadr = (FlickrDownloadr)get().getBean(FlickrDownloadr.class.getName());
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }.execute();
    }

    private void setPlatformLnF() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        preferencesDialog = new javax.swing.JDialog();
        proxyEnabled = new javax.swing.JCheckBox();
        proxyHostLabel = new javax.swing.JLabel();
        proxyPortLabel = new javax.swing.JLabel();
        proxyHost = new javax.swing.JTextField();
        proxyPort = new javax.swing.JTextField();
        savePreferences = new javax.swing.JButton();
        socksEnabled = new javax.swing.JCheckBox();
        proxyAuthEnabled = new javax.swing.JCheckBox();
        proxyUsernameLabel = new javax.swing.JLabel();
        proxyPasswordLabel = new javax.swing.JLabel();
        proxyUsername = new javax.swing.JTextField();
        proxyPassword = new javax.swing.JPasswordField();
        aboutDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        targetDirLabel = new javax.swing.JLabel();
        flickrUsername = new javax.swing.JTextField();
        targetDir = new javax.swing.JTextField();
        browseAction = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        preferencesMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        preferencesDialog.setTitle("Preferences");
        preferencesDialog.setLocationByPlatform(true);
        preferencesDialog.setMinimumSize(new java.awt.Dimension(300, 240));
        preferencesDialog.setModal(true);
        proxyEnabled.setText("Enable proxy");
        proxyEnabled.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        proxyEnabled.setMargin(new java.awt.Insets(0, 0, 0, 0));
        proxyEnabled.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                enableProxyStateChanged(evt);
            }
        });

        proxyHostLabel.setText("Porxy host:");
        proxyHostLabel.setEnabled(false);

        proxyPortLabel.setText("Proxy port:");
        proxyPortLabel.setEnabled(false);

        proxyHost.setEnabled(false);

        proxyPort.setEnabled(false);

        savePreferences.setText("Save");

        socksEnabled.setText("Use SOCKS");
        socksEnabled.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        socksEnabled.setEnabled(false);
        socksEnabled.setMargin(new java.awt.Insets(0, 0, 0, 0));
        socksEnabled.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                socksEnabledStateChanged(evt);
            }
        });
        socksEnabled.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                socksEnabledItemStateChanged(evt);
            }
        });
        socksEnabled.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                socksEnabledPropertyChange(evt);
            }
        });

        proxyAuthEnabled.setText("Enable authentication");
        proxyAuthEnabled.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        proxyAuthEnabled.setEnabled(false);
        proxyAuthEnabled.setMargin(new java.awt.Insets(0, 0, 0, 0));
        proxyAuthEnabled.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                proxyAuthEnabledItemStateChanged(evt);
            }
        });
        proxyAuthEnabled.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                proxyAuthEnabledPropertyChange(evt);
            }
        });

        proxyUsernameLabel.setText("Proxy user name:");
        proxyUsernameLabel.setEnabled(false);

        proxyPasswordLabel.setText("Proxy password:");
        proxyPasswordLabel.setEnabled(false);

        proxyUsername.setEnabled(false);

        proxyPassword.setEnabled(false);

        javax.swing.GroupLayout preferencesDialogLayout = new javax.swing.GroupLayout(preferencesDialog.getContentPane());
        preferencesDialog.getContentPane().setLayout(preferencesDialogLayout);
        preferencesDialogLayout.setHorizontalGroup(
            preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preferencesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(proxyEnabled)
                .addContainerGap(464, Short.MAX_VALUE))
            .addGroup(preferencesDialogLayout.createSequentialGroup()
                .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, preferencesDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(socksEnabled)
                            .addComponent(proxyAuthEnabled)
                            .addGroup(preferencesDialogLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(proxyUsernameLabel)
                                    .addComponent(proxyPasswordLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(proxyPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(proxyUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, preferencesDialogLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proxyHostLabel)
                            .addComponent(proxyPortLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proxyHost, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proxyPort, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(269, 269, 269))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preferencesDialogLayout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(savePreferences)
                .addGap(194, 194, 194))
        );
        preferencesDialogLayout.setVerticalGroup(
            preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preferencesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(proxyEnabled, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyHostLabel)
                    .addComponent(proxyHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyPortLabel)
                    .addComponent(proxyPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(socksEnabled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proxyAuthEnabled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyUsernameLabel)
                    .addComponent(proxyUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(preferencesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyPasswordLabel)
                    .addComponent(proxyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(savePreferences)
                .addContainerGap())
        );
        aboutDialog.setTitle("About Flickr Downloadr");
        aboutDialog.setLocationByPlatform(true);
        aboutDialog.setMinimumSize(new java.awt.Dimension(320, 130));
        aboutDialog.setModal(true);
        aboutDialog.setResizable(false);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24));
        jLabel1.setText("Flickr Downloadr");

        jLabel2.setText("Version 0.0.1");

        javax.swing.GroupLayout aboutDialogLayout = new javax.swing.GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutDialogLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flickr Downloadr");
        setLocationByPlatform(true);
        setResizable(false);
        usernameLabel.setText("Flickr Username:");

        targetDirLabel.setText("Target Directory:");

        browseAction.setText("Browse");

        jButton1.setText("Download");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");
        exitMenuItem.setMnemonic('X');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('E');
        editMenu.setText("Edit");
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        preferencesMenuItem.setMnemonic('P');
        preferencesMenuItem.setText("Preferences");
        preferencesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferencesMenuItemActionPerformed(evt);
            }
        });

        editMenu.add(preferencesMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('H');
        helpMenu.setText("Help");
        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });

        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel)
                            .addComponent(targetDirLabel))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(flickrUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(targetDir, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(browseAction))))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(flickrUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetDirLabel)
                    .addComponent(targetDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseAction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void socksEnabledPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_socksEnabledPropertyChange
        if ("enabled".equals(evt.getPropertyName())) {
            changeProxyAuthState((((Boolean)evt.getNewValue()).booleanValue()));
            this.proxyAuthEnabled.setEnabled((((Boolean)evt.getNewValue()).booleanValue()));
        }
    }//GEN-LAST:event_socksEnabledPropertyChange

    private void socksEnabledStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_socksEnabledStateChanged
        
    }//GEN-LAST:event_socksEnabledStateChanged

    private void proxyAuthEnabledPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_proxyAuthEnabledPropertyChange
        if ("enabled".equals(evt.getPropertyName())) {
            changeProxyAuthState(((Boolean)evt.getNewValue()).booleanValue());
        }
    }//GEN-LAST:event_proxyAuthEnabledPropertyChange

    private void changeProxyAuthState(boolean enabled) {
        this.proxyUsernameLabel.setEnabled(enabled);
        this.proxyUsername.setEnabled(enabled);
        this.proxyPasswordLabel.setEnabled(enabled);
        this.proxyPassword.setEnabled(enabled);
    }

    private void proxyAuthEnabledItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_proxyAuthEnabledItemStateChanged
        changeProxyAuthState((((JCheckBox)evt.getSource()).isSelected()));
    }//GEN-LAST:event_proxyAuthEnabledItemStateChanged

    private void socksEnabledItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_socksEnabledItemStateChanged
        this.proxyAuthEnabled.setEnabled((((JCheckBox)evt.getSource()).isSelected()));
    }//GEN-LAST:event_socksEnabledItemStateChanged

    private void enableProxyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_enableProxyStateChanged
        boolean enabled = (((JCheckBox)evt.getSource()).isSelected());
        this.proxyHost.setEnabled(enabled);
        this.proxyPort.setEnabled(enabled);
        this.proxyHostLabel.setEnabled(enabled);
        this.proxyPortLabel.setEnabled(enabled);
        this.socksEnabled.setEnabled(enabled);
    }//GEN-LAST:event_enableProxyStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrimeNumbersTask task = new PrimeNumbersTask(this.textArea, 100);
         task.addPropertyChangeListener(
             new PropertyChangeListener() {
                 public  void propertyChange(PropertyChangeEvent evt) {
                     if ("progress".equals(evt.getPropertyName())) {
                    	 progressBar.setValue((Integer)evt.getNewValue());
                     }
                 }
             });
         task.execute();
         try {
            System.out.println(task.get());
         }
         catch (Exception e) {
             throw new RuntimeException(e);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        this.aboutDialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void preferencesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferencesMenuItemActionPerformed
        this.preferencesDialog.setVisible(true);
    }//GEN-LAST:event_preferencesMenuItemActionPerformed
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlickrDownloadrGUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog aboutDialog;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton browseAction;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTextField flickrUsername;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JDialog preferencesDialog;
    private javax.swing.JMenuItem preferencesMenuItem;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JCheckBox proxyAuthEnabled;
    private javax.swing.JCheckBox proxyEnabled;
    private javax.swing.JTextField proxyHost;
    private javax.swing.JLabel proxyHostLabel;
    private javax.swing.JPasswordField proxyPassword;
    private javax.swing.JLabel proxyPasswordLabel;
    private javax.swing.JTextField proxyPort;
    private javax.swing.JLabel proxyPortLabel;
    private javax.swing.JTextField proxyUsername;
    private javax.swing.JLabel proxyUsernameLabel;
    private javax.swing.JButton savePreferences;
    private javax.swing.JCheckBox socksEnabled;
    private javax.swing.JTextField targetDir;
    private javax.swing.JLabel targetDirLabel;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

    private FlickrDownloadr flickrDownloadr;
}
