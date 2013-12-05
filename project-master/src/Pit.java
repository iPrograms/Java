/*
 * 
 * **/
public class Pit {

	private int stones;//stones in the pit
	
	//Constructor with default number of stones
	Pit(int number){
		this.stones=number;
	}

	/***********************************************
	 * default # of stones  put in the cell
	 *@param stones, the stones to be put in the cel 
	 * **********************************************/
	public void setStones(int stones){
		this.stones = stones;
	}
	
	/**************************************************
	 * get the number of stones in the pit
	 * ************************************************/
	public int getStones(){
		return this.stones;
	}
	
	/****************************************************
	 * add one stone to the pit
	 * **************************************************/
	public void addStone(){
		this.stones++;
	}
	
	/****************************************************
	 *take one stone from the pit 
	 * ****************************************************/
	public void subtractStone(){
		this.stones--;
	}
	
	public String toString(){
		return Integer.toString(stones);
	}
}
