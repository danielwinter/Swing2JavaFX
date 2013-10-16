package de.saxsys.swing2javafx.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class SwingLoggerPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 4332434701383754183L;

    private JScrollPane loggerPane;
    private JTextArea loggerArea;
    
    public SwingLoggerPanel() {
        this.initGui();
    }
    
    private void initGui() {
        this.setLayout(new BorderLayout());
        this.setBorder(new TitledBorder("Logger"));
        
        this.loggerArea = new JTextArea();
        this.loggerPane = new JScrollPane(this.loggerArea);
      this.loggerPane.setPreferredSize(new Dimension(1024, 200));
        
        this.add(this.loggerPane, BorderLayout.CENTER);
    }
}
