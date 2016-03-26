/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_editor;

import java.awt.Dialog;
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
public class ResizeFrame extends Dialog{
    private JLabel setx;
    private JLabel sety;
    private JTextField x;
    private JTextField y;
    private JButton ok;
    
    public ResizeFrame()
    {
      //  super("Resize");
        super(new JFrame(), ModalityType.APPLICATION_MODAL);
        setx = new JLabel("Width:");
        sety = new JLabel("Height:");
        x = new JTextField("600", 5);
        y = new JTextField("400", 5);
        ok = new JButton("Ok");
        
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                String width = x.getText();
                String height = y.getText();
                
                ResizeEvent re = new ResizeEvent(ae, Integer.parseInt(width), Integer.parseInt(height));
                dispose();
            }
            
        });
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(setx, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(x, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(sety, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(y, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(ok, gbc);
        
        setTitle("Resize");
        setSize(300, 200);
        setVisible(true);
        //setLocation(600, 250);
        setAlwaysOnTop(true);
        
        
    }
    
   
}
