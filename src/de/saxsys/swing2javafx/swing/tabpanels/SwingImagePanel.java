package de.saxsys.swing2javafx.swing.tabpanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.model.DetailImageListener;
import de.saxsys.swing2javafx.model.DetailImageModel;

public class SwingImagePanel extends JPanel implements DetailImageListener {

    /**
     * 
     */
    private static final long serialVersionUID = 451711070740552334L;
    
    private Controller controller;
    
    private JTextField pathField;
    private JTextField sizeField;
    private JLabel imageLabel;
    
    public SwingImagePanel(Controller controller) {
        this.controller = controller;
        this.initGui();
        this.controller.addDetailListener(this);        
    }
    
    private void initGui() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        this.pathField = new JTextField();
        this.pathField.setEditable(false);
        
        this.sizeField = new JTextField();
        this.sizeField.setEditable(false);
        
        this.imageLabel = new JLabel();
        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.NORTHWEST;
        this.add(this.pathField, gc);
        
        gc.gridy = 1;
        this.add(this.sizeField, gc);
        
        gc.gridy = 2;
        gc.fill = GridBagConstraints.BOTH;
        gc.weighty = 1;
        this.add(this.imageLabel, gc);
    }
    
    @Override
    public void updateDetailImageModel(final DetailImageModel imageModel) {
        SwingUtilities.invokeLater(new Runnable() {            
            @Override
            public void run() {
                pathField.setText(imageModel.getPath());
                sizeField.setText(imageModel.getSize()); 
                
                ImageIcon unscaled = new ImageIcon(imageModel.getPath());
//                Image unscaledImage = unscaled.getImage();
//                Image scaledImage = unscaledImage.getScaledInstance(400, 100, Image.SCALE_FAST);        
//                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                imageLabel.setIcon(unscaled);               
            }
        });        
    }

    
}
