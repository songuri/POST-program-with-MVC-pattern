package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.*;


public class UserInterFace{
	
	private JFrame frame;
    private JLabel label;
    public JPanel panel;
    public JPanel panel2;
    
    public JButton table1;
    public JButton table2;
    public JButton table3;
    
    public JButton payment;
    
    public JButton soju;
    public JButton beer;
    public JButton SteamEgg;
    public JButton Ramen;
    public JButton exit;
    
    private JTextArea text1;
    private JTextArea text2;
    private JTextArea text3;
    private JTextArea menulist;
    private JTextArea today;
   
	
    public UserInterFace()  {
    	frame = new JFrame("View");
    	panel = new JPanel();
    	panel2 = new JPanel();
    	
    	GridLayout layout = new GridLayout(2,4);
    	GridLayout layout2 = new GridLayout(4,1);
    	GridLayout layout3 = new GridLayout(3,1);
    	panel.setLayout(layout2);
    	panel2.setLayout(layout3);
   
 
    	text1 = new JTextArea("1", 10, 10);
    	text2 = new JTextArea("2", 10, 10);
    	text3 = new JTextArea("3", 10, 10);
    	menulist = new JTextArea("MenuList", 10, 10);
    	today =new JTextArea("Today", 10, 10);
    	frame.setLayout(layout);                                         
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(600,500);        
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frm = frame.getSize();
        int xpos =(int)(screen.getWidth()/2 -frm.getWidth()/2);
        int ypos = (int)(screen.getHeight()/2 - frm.getHeight()/2);
        frame.setLocation(xpos, ypos);
        
        table1 = new JButton("table1");
        table2 = new JButton("table2");
        table3 = new JButton("table3");
        
        soju = new JButton("suju");
        beer = new JButton("beer");
        SteamEgg  =  new JButton("SteamEgg");
        Ramen = new JButton("Ramen");
        
        payment = new JButton("PayMent");
        exit = new JButton("Exit");
        
        panel.add(SteamEgg);
        panel.add(beer);
        panel.add(soju);
        panel.add(Ramen);
        
        panel2.add(payment);
        panel2.add(today);
        panel2.add(exit);
      
      
        
        frame.add(table1);
        frame.add(table2);
        frame.add(table3);
        
        frame.add(panel);
        
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        
        frame.add(panel2);
        
        
     
        frame.setVisible(true);
    }
    
    public void update(int choiceNumber , StringBuffer buffer){
    	switch(choiceNumber){
    	case 1:
    		text1.setText(buffer.toString());
    		System.out.println(buffer.toString());
    		break;
    	case 2:
    		text2.setText(buffer.toString());
    		System.out.println(buffer.toString());
    		break;
    	case 3:
    		text3.setText(buffer.toString());
    		System.out.println(buffer.toString());
    		break;
    	case 4:
    		menulist.setText(buffer.toString());
    		System.out.println(buffer.toString());
    		break;
    	case 5:
    		today.setText(buffer.toString());
    		System.out.println(buffer.toString());
    		break;
    	}
    }
   
	
	
}
