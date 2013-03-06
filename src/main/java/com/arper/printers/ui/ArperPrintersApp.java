package com.arper.printers.ui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.print.PrintService;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arper.printers.impl.ShortcutServiceImpl;
import com.arper.printers.services.PrinterService;
import com.arper.printers.services.impl.PrinterServiceImpl;
import com.arper.printers.ui.about.AboutUsDialog;
import com.arper.printers.ui.renderers.PrintRenderer;
import com.melloware.jintellitype.JIntellitype;
import org.apache.commons.lang.SystemUtils;

/**
 *
 * @author owentar
 */
public class ArperPrintersApp extends javax.swing.JFrame {
    
    private static final Logger logger = LoggerFactory.getLogger(ArperPrintersApp.class);
    
    private TrayIcon trayIcon;
    
    // TODO: inject dependency
    private PrinterService printerService = new PrinterServiceImpl();
    
    private PrintService selectedPrinter;
    private List<PrintService> printersOptions;
    
    /**
     * Creates new form ArperPrintersApp
     */
    public ArperPrintersApp() {
        printersOptions = printerService.getPrinters();
        selectedPrinter = printerService.getDefaultPrinter();
        
        loadSystemTry();
        
        initComponents();
    }

    public List<PrintService> getPrintersOptions() {
        return printersOptions;
    }

    public void setSelectedPrinter(PrintService selectedPrinter) {
        this.selectedPrinter = selectedPrinter;
    }

    public PrintService getSelectedPrinter() {
        return selectedPrinter;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        filters = new javax.swing.JPanel();
        lblSellPoint = new javax.swing.JLabel();
        sellPoint = new javax.swing.JLabel();
        lblPrinter = new javax.swing.JLabel();
        printers = new javax.swing.JComboBox();
        tblDocuments = new javax.swing.JScrollPane();
        documents = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setIconImage(createImage("favicon.ico"));

        lblSellPoint.setText("Cajas:");

        sellPoint.setText("Caja 1");

        lblPrinter.setText("Impresora:");

        printers.setRenderer(new PrintRenderer());

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${printersOptions}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, printers);
        bindingGroup.addBinding(jComboBoxBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedPrinter}"), printers, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout filtersLayout = new javax.swing.GroupLayout(filters);
        filters.setLayout(filtersLayout);
        filtersLayout.setHorizontalGroup(
            filtersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSellPoint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sellPoint)
                .addGap(92, 92, 92)
                .addComponent(lblPrinter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printers, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        filtersLayout.setVerticalGroup(
            filtersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSellPoint)
                    .addComponent(lblPrinter)
                    .addComponent(printers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellPoint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        documents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha de Emisión", "Descripcion", "Tipo Documento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDocuments.setViewportView(documents);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblDocuments))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    	// To unregister them just call unregisterHotKey with the unique identifier
    	shutdownShortcut();
    	System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        AboutUsDialog aboutUsDialog = new AboutUsDialog(this, true);
        aboutUsDialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        trayIcon.displayMessage("Titulo", "Mensaje de prueba", TrayIcon.MessageType.INFO);
    }//GEN-LAST:event_openMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	final ArperPrintersApp arperPrintersApp = new ArperPrintersApp();
        
        loadShortcut(arperPrintersApp);
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArperPrintersApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArperPrintersApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArperPrintersApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArperPrintersApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               arperPrintersApp.setVisible(true);
            }
        });
    }
    
    private void loadSystemTry() {
        if (SystemTray.isSupported()) {
            SystemTray systemTray = SystemTray.getSystemTray();
            
            Image image = createImage("src/main/resources/favicon.ico");
            trayIcon = new TrayIcon(image, "Arper Printer");
            trayIcon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    ArperPrintersApp.this.setVisible(true);
                }
            });
            
            try{ 
                systemTray.add(trayIcon);
            } catch(AWTException e) {
                logger.error("Tray Icon could not be added", e);
            }
        } else {
            logger.error("System Tray is not supported");
        }
    }
    
    private Image createImage(String imagePath) {
        return (new ImageIcon(imagePath)).getImage();
    }
    
    private static void loadShortcut(ArperPrintersApp arperPrintersApp) {
        if (SystemUtils.IS_OS_WINDOWS) {
            JIntellitype.setLibraryLocation("src/main/resources/JIntellitype64.dll");
            JIntellitype.getInstance();
            // Assign global hotkeys to ALT+SHIFT+B
            JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_ALT + JIntellitype.MOD_SHIFT, (int)'B');
            //assign this class to be a HotKeyListener

            JIntellitype.getInstance().addHotKeyListener(new ShortcutServiceImpl(arperPrintersApp));
        }
    }
    
    private static void shutdownShortcut() {
        if (SystemUtils.IS_OS_WINDOWS) {
            JIntellitype.getInstance().unregisterHotKey(1);
            JIntellitype.getInstance().cleanUp();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JTable documents;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel filters;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel lblPrinter;
    private javax.swing.JLabel lblSellPoint;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JComboBox printers;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JLabel sellPoint;
    private javax.swing.JScrollPane tblDocuments;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
