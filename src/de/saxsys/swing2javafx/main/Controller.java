package de.saxsys.swing2javafx.main;

import java.io.File;
import java.util.List;

import de.saxsys.swing2javafx.model.DetailImageListener;
import de.saxsys.swing2javafx.model.DetailImageModel;
import de.saxsys.swing2javafx.model.ImageListener;
import de.saxsys.swing2javafx.model.ImageLoader;
import de.saxsys.swing2javafx.model.ImageModel;

public class Controller {

    ImageModel imageModel;
    DetailImageModel detailImageModel;
    
    public Controller() {
        this.imageModel = new ImageModel();
        this.detailImageModel = new DetailImageModel();
    }

    public void loadImages(String path) {
        ImageLoader loader = new ImageLoader();
        List<File> loadFiles = loader.loadFiles(path);
        this.imageModel.setFileList(loadFiles);
    }

    public void loadImage(String path) {
        ImageLoader loader = new ImageLoader();
        String size = loader.loadFileSize(path);
        this.detailImageModel.setData(path, size);
//        this.detailImageModel.setImage(path);
    }

    public ImageModel getImageModel() {
        return this.imageModel;
    }
    
    public DetailImageModel getDetailImageModel() {
        return this.detailImageModel;
    }

    public void addListener(ImageListener listener) {
        this.imageModel.addListener(listener);
    }

    public void addDetailListener(DetailImageListener listener) {
       this.detailImageModel.addListener(listener);        
    }
}
