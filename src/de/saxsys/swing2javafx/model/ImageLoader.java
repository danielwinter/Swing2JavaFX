package de.saxsys.swing2javafx.model;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class ImageLoader {

    public List<File> loadFiles(String path) {
        File file = new File(path);
        File[] imageFiles = file.listFiles(new FilenameFilter() {            
            @Override
            public boolean accept(File dir, String name) {
                String lowerCase = name.toLowerCase();
                return lowerCase.endsWith(".png") || lowerCase.endsWith(".jpg");
            }
        });
        return Arrays.asList(imageFiles);        
    }
    
    public String loadFileSize(String path) {
        File file = new File(path);        
        return "Größe: " +file.length() +" bytes";
    }
}
