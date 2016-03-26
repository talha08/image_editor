/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Xenon
 */
public class Tools extends JPanel{
    private JLabel brightnessLabel;
    private JLabel contrastLabel;
    private JSlider brightnessSlider;
    private JSlider contrastSlider;
    private Dimension dim;
    private Toolbtns toolbtns;
    
    public Tools()
    {
        dim = getPreferredSize();
        dim.width =200;
        
        toolbtns = new Toolbtns(dim);
        brightnessLabel = new JLabel(" Brightness");
        contrastLabel = new JLabel(" Contrast");
        brightnessSlider = new JSlider(0, 100, 40);
        contrastSlider = new JSlider(0,100,40);
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.weightx = 1;
        gbc.weighty =0.1;
        gbc.gridx =0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy=0;
        add(brightnessLabel, gbc);
        
        gbc.gridy=1;
        add(brightnessSlider, gbc);
        
        gbc.gridy =2;
        add(contrastLabel, gbc);
        
        gbc.gridy =3;
        add(contrastSlider, gbc);
        
        gbc.gridy =4;
        gbc.weighty =2.0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(toolbtns, gbc);
        
        Border inner = BorderFactory.createLineBorder(Color.BLUE, 1, true);
        Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outer, inner));
    }
    
    public void setZoomPlusListener(ZoomPlusListener listener)
    {
        toolbtns.setZoomPlusListener(listener);
    }
    
    public void setZoomMinusListener(ZoomMinusListener listener)
    {
        toolbtns.setZoomMinusListener(listener);
    }
    
    public void setClockWiseListener(ClockWiseListener listener)
    {
        toolbtns.setClockWiseListener(listener);
    }
    
    public void setCounterClockWiseListener(CounterClockWiseListener listener)
    {
        toolbtns.setCounterClockWiseListener(listener);
    }
}
