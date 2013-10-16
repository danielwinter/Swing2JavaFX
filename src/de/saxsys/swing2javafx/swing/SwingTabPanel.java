package de.saxsys.swing2javafx.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import de.saxsys.swing2javafx.javafx.tabpane.FXAboutPane;
import de.saxsys.swing2javafx.javafx.tabpane.swing.FXAboutPaneForSwing;
import de.saxsys.swing2javafx.javafx.tabpane.swing.FXFXMLPaneForSwing;
import de.saxsys.swing2javafx.javafx.tabpane.swing.FXImagePaneForSwing;
import de.saxsys.swing2javafx.javafx.tabpane.swing.FXTablePaneForSwing;
import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.swing.tabpanels.SwingAboutPanel;
import de.saxsys.swing2javafx.swing.tabpanels.SwingImagePanel;
import de.saxsys.swing2javafx.swing.tabpanels.SwingTablePanel;

public class SwingTabPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 3185738119727437344L;

    private Controller controller;
    
    private JTabbedPane tabbedPane;
    
    private FXTablePaneForSwing fxTable;
    private FXAboutPaneForSwing fxAbout;
    private FXImagePaneForSwing fxImage;
    private FXFXMLPaneForSwing fxmlPanel;
    
    private SwingTablePanel swingTable;
    private SwingAboutPanel aboutPanel;
    private SwingImagePanel swingImage;
    
    public SwingTabPanel(Controller controller) {
        this.controller = controller;
        this.initTabs();
        this.initGui();
    }

    private void initGui() {
        this.setLayout(new BorderLayout());
        this.setBorder(new TitledBorder("Features"));

        JTabbedPane tabbedPane = this.getTabbedPane();
        
        this.add(tabbedPane, BorderLayout.CENTER);        
        this.setPreferredSize(new Dimension(1024, 768));
    }
    
    private void initTabs() {
        this.fxTable = new FXTablePaneForSwing();
        this.swingTable = new SwingTablePanel();
        
        this.fxImage = new FXImagePaneForSwing(this.controller);
        this.swingImage = new SwingImagePanel(this.controller);
        this.fxmlPanel = new FXFXMLPaneForSwing(this.controller);
        
        this.fxAbout = new FXAboutPaneForSwing();
        this.aboutPanel = new SwingAboutPanel();
    }
    
    private JTabbedPane getTabbedPane() {
        if(this.tabbedPane == null) {
            this.tabbedPane = new JTabbedPane();
           
            this.tabbedPane.add("FX-Tabelle", this.fxTable);
            this.tabbedPane.add("Swing-Tabelle", this.swingTable);
            this.tabbedPane.add("FX-Bild", this.fxImage);
            this.tabbedPane.add("Swing-Bild", this.swingImage);
            this.tabbedPane.add("FX-Lizenzinformationen", this.fxAbout);
            this.tabbedPane.add("Swing-Lizenzinformationen", this.aboutPanel);
            this.tabbedPane.add("FX-FXML", this.fxmlPanel);
        }
        
        return this.tabbedPane;
    }
}
