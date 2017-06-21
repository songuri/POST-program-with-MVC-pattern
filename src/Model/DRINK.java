package Model;

public class DRINK extends ITEM{
	private int NumLeft;
	public DRINK(String _name , int _price){
		this.SetName(_name);
		this.SetPrice(_price);
		
	}
	public DRINK(DRINK _du){
		this.SetName(_du.GetName());
		this.SetPrice(_du.GetPrice());
		super.count++;
	}
	
	public int NumLeft(){
		return NumLeft;
	}//TODO 남은 수량을 관리하는 코드가 필요하다.
	
}