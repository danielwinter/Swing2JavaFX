package de.saxsys.swing2javafx.swing.tabpanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javafx.scene.text.Text;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.saxsys.swing2javafx.model.AboutInformation;

public class SwingAboutPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 3292928700491173146L;

    private static final String RESOURCES_LOGO_ETEO_JPG = "/resources/ETEO_Brand_on_white_CMYK.png";
    
    public SwingAboutPanel() {
        final AboutInformation aboutInfo = new AboutInformation("ETEO ist ein Warenzeichen der Saxonia Systems AG.", 
                "01059 Dresden, FFP 2",  "Registierungsnummer: 0123456789", "Scrumboard V1.0");
        this.initGui(aboutInfo);
    }
    
    public SwingAboutPanel(final AboutInformation aboutInfo) {       
        this.initGui(aboutInfo);
    }
    
    private void initGui(AboutInformation aboutInfo) {
        this.setLayout(new BorderLayout());
        
        this.add(this.getTitleInfoPanel(aboutInfo), BorderLayout.CENTER);
        this.add(this.getBottomLabel(aboutInfo), BorderLayout.SOUTH);
    }
    
    private JPanel getTitleInfoPanel(AboutInformation aboutInfo) {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 2));
        
        ImageIcon unscaled = new ImageIcon(this.getClass().getResource(RESOURCES_LOGO_ETEO_JPG));
        Image unscaledImage = unscaled.getImage();
        Image scaledImage = unscaledImage.getScaledInstance(400, 100, Image.SCALE_FAST);        
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel eteoLabel = new JLabel(scaledIcon);
        
        JPanel titleInformation = this.getTtileInformation(aboutInfo);        
        
        titlePanel.add(eteoLabel);
        titlePanel.add(titleInformation);
        return titlePanel;
    }
    
    private JPanel getTtileInformation(AboutInformation aboutInfo) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        final JLabel titleText = new JLabel(aboutInfo.getVersion());
        final JLabel registryNumberText = new JLabel(aboutInfo.getRegistryNumber());
        final JLabel addressText = new JLabel(aboutInfo.getAddress());
        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.NONE;
        panel.add(titleText, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        panel.add(registryNumberText, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        panel.add(addressText, gc);
        
        return panel;
    }
    
    private JLabel getBottomLabel(AboutInformation aboutInfo) {
        JLabel bottomLabel = new JLabel(aboutInfo.getTrademark());
        bottomLabel.setHorizontalAlignment(JLabel.CENTER);
        return bottomLabel;
    }
}
