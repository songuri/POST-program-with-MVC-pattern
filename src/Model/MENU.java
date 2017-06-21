package Model;

public class MENU extends ITEM{
	public MENU(String _name , int _price){
		this.SetName(_name);
		this.SetPrice(_price);
	}
	public MENU(MENU _du){ // 복사 생성자 
		this.SetName(_du.GetName());
		this.SetPrice(_du.GetPrice());
		super.count++;
	}


	
}