package de.saxsys.swing2javafx.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class ImageModel {

    private SimpleListProperty<File> fileList;
    
    private List<ImageListener> listener;
    
    public ImageModel() {
        this.fileList = new SimpleListProperty<>(FXCollections.observableArrayList(new ArrayList<File>()));
        this.listener = new ArrayList<>();
    }

    public List<File> getFileList() {
        return fileList.get();
    }

    public SimpleListProperty<File> fileList() {
        return this.fileList;
    }
    
    public void setFileList(List<File> fileList) {
        this.fileList.set(FXCollections.observableArrayList(fileList));
        this.notifyListener();
    }
    
    public int size() {
        return fileList.size();
    }
    
    public String get(int index) {
        return this.fileList.get(index).getAbsolutePath();
    }
    
    public File getFile(int index) {
        return this.fileList.get(index);
    }
    
    public void addListener(ImageListener listener) {
        this.listener.add(listener);
    }
    
    public void notifyListener() {
        for(ImageListener listener : this.listener) {
            listener.updateImageModel(this);
        }
    }
    
}
