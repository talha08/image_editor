/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_editor;

import java.util.EventObject;

/**
 *
 * @author Xenon
 */
public class ResizeEvent extends EventObject{
    private int width, height;

    public ResizeEvent(Object o) {
        super(o);
    }
    
    public ResizeEvent(Object o, int x, int y) {
        super(o);
        
        this.width = x;
        this.height = y;
    }
    
    public void setwidth(int width)
    {
        this.width = width;
    }
    
    public void setheight(int height)
    {
        this.height = height;
    }
    
    public int getwidth()
    {
        return width;
    }
    
    public int getheight()
    {
        return height;
    }
}
