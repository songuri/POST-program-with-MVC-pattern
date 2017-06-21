package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

//import Model.INTERFACE;

import Model.*;
import View.UserInterFace;

public class POST implements ActionListener{
	StoreData model;
	UserInterFace view;
	private int currentTableNumber;
	
	public POST(){
		currentTableNumber = -1;
		model = new StoreData();
		view = new UserInterFace();
		
	  view.table1.addActionListener(this);
	  view.table2.addActionListener(this);
	  view.table3.addActionListener(this);
	  view.beer.addActionListener(this);
	  view.soju.addActionListener(this);
	  view.Ramen.addActionListener(this);
	  view.SteamEgg.addActionListener(this);
	  view.payment.addActionListener(this);
	  view.exit.addActionListener(this);
	}
	@Override
    public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    
    	if(obj == view.table1)
    		currentTableNumber =1;
    	else if (obj == view.table2)
    		currentTableNumber = 2;
    	else if(obj == view.table3)
    		currentTableNumber = 3;
    	
    	/***************************/
    	if(currentTableNumber >0){
    		
    	if(obj == view.beer){
    		//System.out.println("asfasfasf");
    		model.addDrinkToTable(1, currentTableNumber);
    		this.update(currentTableNumber);
    	}else if(obj == view.Ramen){
    		model.addDrinkToTable(1, currentTableNumber);
    		this.update(currentTableNumber);
    	}else if(obj == view.soju){
    		model.addDrinkToTable(2, currentTableNumber);
    		this.update(currentTableNumber);
    	}else if(obj == view.SteamEgg){
    		model.addDrinkToTable(2, currentTableNumber);
    		this.update(currentTableNumber);
    	}
    	if(obj == view.payment){
    		model.PayMentSystem(currentTableNumber);
    		this.update(5);
    	}
    	if(obj == view.exit){
    		try {
				model.WriteItem();
				System.exit(1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	}
		
	}
	public void update(int ct){
		StringBuffer info = new StringBuffer();
		if(ct == currentTableNumber){
		info = model.getTableInfo(currentTableNumber);
		}
		if(ct == 5){
			info = model.ShowTodayRecord();
			StringBuffer info2 = new StringBuffer();
			view.update(currentTableNumber, info2);
		}
		view.update(ct, info);
		
	}
	 public static void main(String args[]){
	    	new POST();
	    }
}