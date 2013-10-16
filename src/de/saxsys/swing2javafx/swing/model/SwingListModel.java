package de.saxsys.swing2javafx.swing.model;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import de.saxsys.swing2javafx.model.ImageModel;

public class SwingListModel extends DefaultListModel<String>{

    /**
     * 
     */
    private static final long serialVersionUID = 1198467542513790334L;

    private ImageModel imageModel;
    
    public SwingListModel() {
        this.imageModel = new ImageModel();
        this.fireContentsChanged(imageModel, 0, getSize());
    }
    
    public SwingListModel(ImageModel imageModel) {
        this.imageModel = imageModel;
        this.fireContentsChanged(imageModel, 0, getSize());
    }
    
    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
        this.fireContentsChanged(imageModel, 0, getSize());
    }    
    
    @Override
    public int getSize() {
        return this.imageModel.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.imageModel.get(index);
    }

}
