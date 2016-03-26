/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_editor;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;



/**
 *
 * @author Xenon
 */
public class Editor extends Canvas implements ImageObserver{
    private JButton openbtn;
    private Image img;
    private JLabel imageLabel;
    int iw;
    int ih;
    int x;
    int y;
    int adjX=0;
    int adjY=0;
    int adjW=0;
    int adjH=0;
    Dimension ds;
    double radian=0.0;
    boolean flag;
    Graphics temp;
    Image image;
    
    public Editor()
    {
        flag = false;
        temp = null;
      BufferedImage image;
        try {
            image = ImageIO.read(new File("res\\xyz.jpg"));
        } catch (IOException ex) {
            System.out.println("Error");
        }
        //img =  getToolkit().getImage("res\\xyz.jpg");
        ds = new Dimension(800, 600);
       // BufferedImage image = (BufferedImage) img;
      //  image = img;
    }
    
public void paint(Graphics g)
    {
        temp = g;
        //if(temp == null)temp =g;
       // if(flag==true)rotateImage(g);
       // else {
      /*  Graphics2D g2d=(Graphics2D)g;
        setImageBounds();
        g2d.translate(x,y);
        g2d.drawImage(img,0,0,iw,ih,this);*/
       if(flag == true) {
           temp = rotateImage(temp);
            //image = img;
       }
       else temp =zoom(temp);
       flag = false;
    }

    public Graphics zoom(Graphics g)
    {
        Graphics2D g2d=(Graphics2D)g;
        setImageBounds();
        g2d.translate(x,y);
        g2d.drawImage(image,0,0,iw,ih,this);
        
        return g2d;
    }


         public Graphics rotateImage(Graphics g){
 
                Graphics2D g2d=(Graphics2D)g;
 
               
                int iw=img.getWidth(this);

                int ih=img.getHeight(this);
  
                int mX=(int)ds.getWidth()/2;
 
                int mY=(int)ds.getHeight()/2;                     
  
                g2d.translate(mX,mY);
  
                g2d.rotate(radian);
 
                g2d.drawImage(img,-img.getWidth(this)/2,-img.getHeight(this)/2,iw,ih,this);
                
                return g2d;
            }
 
            public void rotateClockwise(){
                        radian+=Math.PI/2;
            }
  
            public void rotateCounterClockwise(){
                        radian-=Math.PI/2;
            }

            
            
            

    public void setImageBounds()
    {

        x=(int)ds.getWidth()/2-img.getWidth(this)/2+adjX;
        y=(int)ds.getHeight()/2-img.getHeight(this)/2+adjY;
        iw=img.getWidth(this)+adjW;
        ih=img.getHeight(this)+adjH;

    }

    public void zoomIn()
    {
        adjX-=20;
        adjY-=20;
        adjW+=30;
        adjH+=30;
    }
    public void zoomOut()
    {
      //  if(x<(int)ds.getWidth()/2-img.getWidth(this)/2)
      //  {
            adjX+=20;
            adjY+=20;
            adjW-=30;
            adjH-=30;
       // }
    }
   
    public void setFlag(boolean b)
    {
        flag =b;
    }
}
