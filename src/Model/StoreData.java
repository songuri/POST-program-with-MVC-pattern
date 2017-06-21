package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;


public class StoreData {
	public Scanner scan;
	private ArrayList<MENU> myItemMenu = new ArrayList<MENU>();
	private ArrayList<DRINK> myItemDrink = new ArrayList<DRINK>();
	
	private ArrayList<TABLE> myTable = new ArrayList<TABLE>();
	private ArrayList<ITEM> DataRecord = new ArrayList<ITEM>();
	private StringBuffer _time = new StringBuffer();
	
	public StoreData(){
		MENU Ramen =new MENU("Ramen", 5000);
		MENU SteamEgg = new MENU("SteamEgg" , 7000);
		DRINK soju = new DRINK("soju" , 2000);
		DRINK beer = new DRINK("beer" , 2500);
		
		myItemMenu.add(Ramen);
		myItemMenu.add(SteamEgg);
		myItemDrink.add(beer);
		myItemDrink.add(soju);
		
		TABLE table1 =new TABLE(1);
		TABLE table2 = new TABLE(2);
		TABLE table3 =new TABLE(3);
		
		myTable.add(table1);
		myTable.add(table2);
		myTable.add(table3);
	}
	
	public void addDrinkToTable(int itemNumber, int tableNumber){
		for(TABLE a : myTable){
			if(a.tableNumber == tableNumber){
				a.addDrink(myItemDrink.get(itemNumber-1));
			}
		}
		System.out.println("item"+ itemNumber);
		System.out.println("table"+ tableNumber);
	}
	public void addMenuToTable(int itemNumber, int tableNumber){
		
			
		for(TABLE a : myTable){
			if(a.tableNumber == tableNumber){
				a.addMenu(myItemMenu.get(itemNumber-1));
			}
		}
		
		
	}
	public void RecordTable(int _tableNumber){
		int n1,n2;
		n1 = myTable.get(_tableNumber).GetDrinkList().size();
		n2 = myTable.get(_tableNumber).GetMenuList().size();
		ArrayList<DRINK> temp;
		temp = myTable.get(_tableNumber).GetDrinkList();
		for(int i = 0 ; i < n1 ; i++){
			RecordItem(temp.get(i));
		}
		temp.clear();
		ArrayList<MENU> temp2;
		temp2 = myTable.get(_tableNumber).GetMenuList();
		for(int i = 0 ; i < n2 ; i++){
			RecordItem(temp2.get(i));
		}
		temp2.clear();
		
	}
	public void RecordItem(ITEM _item){//한가지씩 만 받아서 기록 ㅇ.
		for(int i = 0 ; i < DataRecord.size() ; i ++){
			if(DataRecord.get(i).GetName() == _item.GetName()){
				DataRecord.get(i).plusCount();
				return ;
			}
		}
		ITEM _t = _item;
		DataRecord.add(_t);
	}
	public StringBuffer getTableInfo(int tableNumber){
		return myTable.get(tableNumber-1).ShowTable();
	}
	public StringBuffer ShowTodayRecord(){
		StringBuffer sb = new StringBuffer();
		System.out.println("*********************");
		System.out.println("********TODAY********");
		System.out.println("*********************");
		for(int i = 0 ; i < DataRecord.size(); i++){
			sb.append(i);
			sb.append(" ");
			sb.append(DataRecord.get(i).GetName());
			sb.append(" ");
			sb.append(DataRecord.get(i).getCount());
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println("*********************");
		System.out.println("*********************");
		
		System.out.println("\n\n");
		return sb;
	}
	public void WriteItem() throws IOException{
		
		BufferedWriter _writer = new BufferedWriter(new FileWriter("/Users/kimyoungho/Documents/workspace/POST/src/MAIN/History.txt",true));
		
		_writer.write(this.Ontime().toString());
		_writer.write(this.ShowTodayRecord().toString());
		_writer.close();
	}
	public StringBuffer Ontime(){
		StringBuffer sb = new StringBuffer();
		Calendar oCalendar = Calendar.getInstance( );
		sb.append(oCalendar.get(Calendar.YEAR));
		sb.append("-");
		sb.append((oCalendar.get(Calendar.MONTH) + 1));
		sb.append("-");
		sb.append( oCalendar.get(Calendar.DAY_OF_MONTH));
		sb.append("  ");
		sb.append(oCalendar.get(Calendar.HOUR_OF_DAY));
		sb.append(" : ");
		sb.append(oCalendar.get(Calendar.MINUTE));
		sb.append("\n");
		
		return sb;
		
	}//시간을출력하는 메소드.

	public void PayMentSystem(int _tableNumber){
		_tableNumber--;
		//계산전에 기록 부터한다.
		RecordTable(_tableNumber);
		myTable.get(_tableNumber).clearTable();
		
	} // TODO 일단 기록 후결제를 하도록 하고 추후 카드와 현금결제로 나누도록 한다.
	

}
