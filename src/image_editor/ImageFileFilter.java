/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_editor;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Xenon
 */
public class ImageFileFilter extends FileFilter{

    public boolean accept(File file) {
        if(file.isDirectory())
            return true;
        
        switch(getFileExtension(file.getName()))
        {
            case "jpg":
            case "png":
            case "jpeg":
                return true;
            default:
                return false;
        }
    }

    public String getDescription() {
        return "Image File(*.png, *.jpg, *.jpeg)";
    }
    
    private String getFileExtension(String name)
    {
        int pointIndex = name.lastIndexOf(".");
        
        if(pointIndex == -1)
            return null;
        if(pointIndex == name.length()-1)
            return null;
        return name.substring(pointIndex+1, name.length());
    }
}
