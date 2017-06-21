package Model;
import Model.*;

import java.util.ArrayList;

public class TABLE {
	private ArrayList<MENU> menuList = new ArrayList<MENU>();
	private ArrayList<DRINK> drinkList = new ArrayList<DRINK>();
	public int tableNumber;
	
	public TABLE(int i){
		tableNumber = i;
	}
	public void addMenu(MENU _item){
		MENU _add = new MENU(_item);
		for(int i = 0 ; i < this.menuList.size() ; i++){
			if(_item.GetName() == this.menuList.get(i).GetName()){
				this.menuList.get(i).plusCount();
				return;
			}
		}
		menuList.add(_add);
	}
	public void addDrink(DRINK _item){
		DRINK _add = new DRINK(_item);
		for(int i = 0 ; i < this.drinkList.size() ; i++){
			if(_item.GetName() == this.drinkList.get(i).GetName()){
				this.drinkList.get(i).plusCount();
				return;
			}
		}
		
		drinkList.add(_add);
	}
	public void clearTable(){
		menuList.clear();
		drinkList.clear();
	}
	public Boolean isTable(){
		return menuList.isEmpty() && drinkList.isEmpty();
	}
	public int Total(){
		int sum = 0 ;
		for(int i = 0 ; i < menuList.size(); i++)
			sum += menuList.get(i).GetPrice() * menuList.get(i).getCount();
		for(int i = 0 ; i < drinkList.size() ; i ++)
			sum += drinkList.get(i).GetPrice() * drinkList.get(i).getCount();
		return sum;
	}
	public StringBuffer ShowTable(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.tableNumber);
		sb.append(" table");
		sb.append("\n");
		for(int i = 0 ; i < menuList.size(); i++){
			sb.append(menuList.get(i).GetName());
			sb.append(" ");
			sb.append(menuList.get(i).getCount());
			sb.append("\n");
		}
		for(int i = 0 ; i < drinkList.size() ; i ++){
			sb.append(drinkList.get(i).GetName());
			sb.append(" ");
			sb.append(drinkList.get(i).getCount());
			sb.append("\n");
		}
		sb.append("총계 : ");
		sb.append(this.Total());
		sb.append(" ");
		//System.out.println(sb.toString());
		return sb;
		
	}

	public ArrayList<DRINK> GetDrinkList(){
		return drinkList;
	}
	public ArrayList<MENU> GetMenuList(){
		return menuList;
	}

}
