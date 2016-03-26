/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

/**
 *
 * @author Xenon
 */
public class MainFrame extends JFrame{
    private JMenuBar menuBar;
    private Editor imageEditor;
    private Tools tools;
    private JFileChooser fileChooser;
//    private JPanel imageContainer;
    
    public MainFrame()
    {
        super("Simple Image Editor");
        
        menuBar = new JMenuBar();
        imageEditor = new Editor();
        tools = new Tools();
        fileChooser = new JFileChooser();
    //    imageContainer = new JPanel();
        
        tools.setZoomPlusListener(new ZoomPlusListener() {
            public void eventOccurered() {
                System.out.println("ooooo");
                imageEditor.zoomIn();
                imageEditor.repaint();
                revalidate();
            }
        });
        
        tools.setZoomMinusListener(new ZoomMinusListener() {
            public void eventOccurered() {
                imageEditor.zoomOut();
                imageEditor.repaint();
                revalidate();
            }
        });
        
        tools.setClockWiseListener(new ClockWiseListener(){
            public void eventOccurered(){
                imageEditor.setFlag(true);
                imageEditor.rotateClockwise();
                imageEditor.repaint();
               //imageEditor.setFlag(false);
                revalidate();
            }
        });
        
        tools.setCounterClockWiseListener(new CounterClockWiseListener(){
            public void eventOccurered(){
                imageEditor.setFlag(true);
                imageEditor.rotateCounterClockwise();
                imageEditor.repaint();
                //imageEditor.setFlag(false);
                revalidate();
            }
        });
        
        
        
        JMenu fileMenu = new JMenu("FILE");
        JMenu aboutMenu = new JMenu("About");
        JMenu effectsMenu = new JMenu("Effects");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveas = new JMenuItem("Save As");
        JMenuItem saveall = new JMenuItem("Save All");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem about = new JMenuItem("About Us");
        JMenuItem invertColor = new JMenuItem("Invert Colour");
        JMenuItem greyScale = new JMenuItem("Gray Scale");
        JMenuItem sepiaTone = new JMenuItem("Sepia Tone");
        JMenuItem gaussianBlur = new JMenuItem("Gaussian Blur");
        JMenuItem bulge = new JMenuItem("Bulge Effect");
        
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                    System.out.println(fileChooser.getSelectedFile());
            }
        });
        
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        saveas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 fileChooser.showSaveDialog(MainFrame.this);
            }
        });
        
        saveall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               aboutframe();
            }
        });
        
        invertColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        
        greyScale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        
        sepiaTone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        
        gaussianBlur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        
        bulge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(saveas);
        fileMenu.add(saveall);
        fileMenu.add(exit);
        aboutMenu.add(about);
        effectsMenu.add(invertColor);
        effectsMenu.add(greyScale);
        effectsMenu.add(gaussianBlur);
        effectsMenu.add(sepiaTone);
        effectsMenu.add(bulge);
        
        menuBar.add(fileMenu);
        menuBar.add(effectsMenu);
        menuBar.add(aboutMenu);
        
        setLayout(new BorderLayout(5, 5));
        
        //imageContainer.add(imageEditor);
        
        add(menuBar, BorderLayout.NORTH);
        add(tools, BorderLayout.WEST);
        add(imageEditor, BorderLayout.CENTER);
        
      // Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //System.out.println(JFrame.EXIT_ON_CLOSE);
       // setExtendedState(JFrame.NORMAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(1200, 700));
        setMinimumSize(new Dimension(1100, 700));
        setMaximumSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
    }
    
    private void aboutframe()
    {
        JFrame aboutFrame = new JFrame("About us");
        JTextArea studentArea = new JTextArea("Farzad Bin Fazle\nReg. No.:2012331005\nDept. of CSE, SUST\n\n"
                 +"Md. Abu Talha\nReg. No.:2012331008\nDept. of CSE, SUST\n");
        JLabel aboutLabel= new JLabel("ABOUT");
        JTextArea superVisorArea = new JTextArea("Md. \nLecturer, Dept of CSE, SUST\n");
         
        studentArea.setEditable(false);
        superVisorArea.setEditable(false);
        
        studentArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
        superVisorArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        Border inner = BorderFactory.createTitledBorder("Developped By:");
        Border outer = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        
        studentArea.setBorder(BorderFactory.createCompoundBorder(outer, inner));
        
        inner = BorderFactory.createTitledBorder("Under SuperVision of:");
        
        superVisorArea.setBorder(BorderFactory.createCompoundBorder(outer, inner));
        
        aboutLabel.setFont(new Font("Tahoma", Font.BOLD, 42));
        
        aboutFrame.setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.gridx =0;
        gc.weightx=1;
        
        gc.gridy=0;
        gc.weighty =1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        aboutFrame.add(aboutLabel, gc);
        
        gc.gridy=1;
        gc.weighty =1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        aboutFrame.add(studentArea, gc);
        
        gc.gridy=2;
        gc.weighty =1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        aboutFrame.add(superVisorArea, gc);
        
        aboutFrame.setPreferredSize(new Dimension(800, 600));
        aboutFrame.setMinimumSize(new Dimension(800, 600));
        aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        aboutFrame.setVisible(true);
    }        
    
}
