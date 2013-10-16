package de.saxsys.swing2javafx.swing;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import de.saxsys.swing2javafx.main.Controller;

public class Swing2JavaFxFrame extends JFrame  {

    /**
     * 
     */
    private static final long serialVersionUID = 3953881253956471908L;

    private Controller controller;
    
    private JComponent configPanel;
    private JComponent loggerPanel;
    private JComponent tabbPanel;
        
    public Swing2JavaFxFrame(Controller controller) {
        super("Swing2JavaFX");
        this.controller = controller;
        this.initGui();
    }
    
    private void initGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        
        this.setLayout(new BorderLayout());
        
        JComponent configPanel = this.getConfigPanel();
        JComponent loggerPanel = this.getLoggerPanel();
        JComponent tabbPanel = this.getTabbPanel();
        
        JSplitPane horizontalSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        horizontalSplit.add(configPanel);
        horizontalSplit.add(tabbPanel);
        horizontalSplit.setDividerLocation(300);
        
        JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        verticalSplit.add(horizontalSplit);
        verticalSplit.add(loggerPanel);
        verticalSplit.setDividerLocation(500);
        
        this.add(verticalSplit, BorderLayout.CENTER);
    }
    
    private JComponent getConfigPanel() {
        if(this.configPanel == null) {
            this.configPanel = new SwingConfigPanel(this.controller);
        }
        
        return this.configPanel;
    }
    
    private JComponent getLoggerPanel() {
        if(this.loggerPanel == null) {
            this.loggerPanel = new SwingLoggerPanel();
        }
        
        return this.loggerPanel;
    }
    
    private JComponent getTabbPanel() {
        if(this.tabbPanel == null) {
            this.tabbPanel = new SwingTabPanel(this.controller);
        }
        
        return this.tabbPanel;
    }    
}
