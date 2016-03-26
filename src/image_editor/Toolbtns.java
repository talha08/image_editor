/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_editor;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Xenon
 */
public class Toolbtns extends JPanel{
    private JButton rotateCC;
    private JButton rotateC;
    private JButton zoomPlus;
    private JButton zoomMinus;
    private JToggleButton crop;
    private JButton resize;
    private JButton flipHorizontal;
    private JButton flipVertical;
    private JButton undo;
    private JButton redo;
    private JButton text;
    
    private ZoomPlusListener zpl;
    private ZoomMinusListener zml;
    
    private ClockWiseListener cwl;
    private CounterClockWiseListener ccwl; 
    
    
    public Toolbtns(Dimension d)
    {
        Dimension dim = getPreferredSize();
        dim = d;
        rotateC = new JButton("Rotate CW");
        rotateCC = new JButton("Rotate CCW");
        zoomPlus = new JButton("Zoom +");
        zoomMinus = new JButton("Zoom -");
        resize = new JButton("Resize");
        flipHorizontal = new JButton("Flip Horizontal");
        flipVertical = new JButton("Flip Vertical");
        undo = new JButton("Undo");
        redo = new JButton("Redo");
        text = new JButton("Text");
        crop = new JToggleButton("Crop");
        
      //  zoomMinus.setEnabled(false);
        
        rotateC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 if(cwl != null) cwl.eventOccurered();
            }
        });
        rotateCC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 if(ccwl != null) ccwl.eventOccurered();
            }
        });
        zoomPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(zpl != null) zpl.eventOccurered();
            }
        });
        zoomMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(zml != null) zml.eventOccurered();
            }
        });
        resize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
               new ResizeFrame();
            }
        });
        flipHorizontal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        flipVertical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        redo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.weightx =1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx=0;
        gbc.gridy=0;
        add(rotateC, gbc);
        
        gbc.gridx=1;
        gbc.gridy=0;
        add(rotateCC, gbc);
        
        gbc.gridx=0;
        gbc.gridy=2;
        add(zoomPlus, gbc);
        
        gbc.gridx=1;
        gbc.gridy=2;
        add(zoomMinus, gbc);
        
        gbc.gridx=0;
        gbc.gridy=3;
        add(flipHorizontal, gbc);
        
        gbc.gridx=1;
        gbc.gridy=3;
        add(flipVertical, gbc);
        
        gbc.gridx=0;
        gbc.gridy=4;
        add(undo, gbc);
        
        gbc.gridx=1;
        gbc.gridy=4;
        add(redo, gbc);
        
        gbc.gridx=0;
        gbc.gridy=5;
        add(resize, gbc);
        
        gbc.gridx=1;
        gbc.gridy=5;
        add(crop, gbc);
        
        gbc.gridx=0;
        gbc.gridy=6;
        add(text, gbc);
    }
    
    public void setZoomPlusListener(ZoomPlusListener listener)
    {
        this.zpl = listener;
    }
    
    public void setZoomMinusListener(ZoomMinusListener listener)
    {
        this.zml = listener;
    }

    void setClockWiseListener(ClockWiseListener listener) {
        this.cwl = listener; 
    }

    void setCounterClockWiseListener(CounterClockWiseListener listener) {
        this.ccwl =  listener;
    }
}
