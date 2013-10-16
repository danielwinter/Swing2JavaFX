package de.saxsys.swing2javafx.swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;

import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.model.ImageListener;
import de.saxsys.swing2javafx.model.ImageModel;
import de.saxsys.swing2javafx.swing.model.SwingListModel;

public class SwingConfigPanel extends JPanel implements ImageListener {

    /**
     * 
     */
    private static final long serialVersionUID = 5578170610755478485L;

    private Controller controller;

    private SwingListModel listModel;
    private JList<String> fileList;
    private JTextField pathField;

    public SwingConfigPanel(Controller controller) {
        this.controller = controller;
        this.initGui();
        this.controller.addListener(this);
    }

    private void initGui() {
        this.setBorder(new TitledBorder("Einstellungen"));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        this.pathField = new JTextField();
        this.pathField.setEditable(false);
        JButton button = new JButton("Ordner auswählen");
        button.addActionListener(new FileListener());

        this.listModel = new SwingListModel();
        this.fileList = new JList<>(this.listModel);
        this.fileList.setBorder(new TitledBorder("Bilder"));
        this.fileList.addListSelectionListener(new FileListSelectionListener());

        gc.insets = new Insets(3, 3, 3, 3);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        this.add(this.pathField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 0;
        gc.anchor = GridBagConstraints.NORTHEAST;
        this.add(button, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1;
        gc.weighty = 1;
        this.add(this.fileList, gc);

        this.setPreferredSize(new Dimension(300, 768));
    }

    private class FileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int chooserValue = fileChooser.showOpenDialog(null);
            if (chooserValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                SwingConfigPanel.this.pathField.setText(file.getAbsolutePath());
                SwingConfigPanel.this.controller.loadImages(file.getAbsolutePath());
            }
        }
    }

    private class FileListSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                JList<String> list = (JList<String>) e.getSource();
                String imagePath = list.getSelectedValue();
                SwingConfigPanel.this.controller.loadImage(imagePath);
               
            }
        }
    }

    @Override
    public void updateImageModel(ImageModel imageModel) {
        this.listModel.setImageModel(imageModel);
    }
}
