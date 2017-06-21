package Model;
 

abstract public class ITEM {
	private String name;
	private int price;
	protected int count;
	public ITEM(){
		count = 0;
	}
	public void SetName(String _name){
		this.name = _name;
	}
	public void SetPrice(int _price){
		this.price = _price;
	}
	public String GetName(){
		return this.name;
	}
	public int GetPrice(){
		return this.price;
	}
	
	public void plusCount(){
		count++;
	}
	public int getCount(){
		return count;
	}
}



