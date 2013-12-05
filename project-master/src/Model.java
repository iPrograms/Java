
/***************************************************************************************************************
 *
 *@Author Manzoor Ahmed
 *CS 151 project 
 * 
 **************************************************************************************************************/
import java.awt.*;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model {

	private  Pit[][] board;//the main board that contains pits
	private int ahead;     // the stones ahead of a Pit
	private ArrayList<ChangeListener> listener;

	//default constructor with number of stones in each Pit
	Model(int stones)
	{
		board =new Pit[2][7];
		listener = new ArrayList<ChangeListener>();

        //put stones in each Pit
		for(int i=0;i<2; i++){
			for(int j=0;j<7;j++){
				board[i][j]= new Pit(stones);
			}
		}
		board[0][6] = new Pit(0); //left mancala initialy no stones
		board[1][6] = new Pit(0); //right mancala initialy no stones
	}
	
	/**********************************************************************
	 * Adds a change listener to the Pit
     * @param listener the change listener to add
	 * ********************************************************************/
	public void addChangeListener(ChangeListener cl){
		listener.add(cl);
	}
	
	/******************************************************************** 
	 *Get stones that are ahead of this cell 
	 *@param row, row of the grid
	 *@param col, col of the grid 
	 * *******************************************************************/
	public int getAheadPitStones(int row, int col){
		
		//if first row (player 2's side) 
		if(row == 0){
		   return board[1][col].getStones();
		}
		//if second row (player1's side)
		else{
			return board[0][col].getStones();
		}
	}
	
	/********************************************************************
	 * solve the mancola
	 * If player1 is selected, then row =0, if player2 is select row =1
	 * @param player, player1 or player2
	 * @param col, column
	 * *******************************************************************/
	public void solve(String player, int col){
		
		if(player.equalsIgnoreCase("player1")){
			
			//the number of pits we need to move and place a stone
			int needToMovePits = board[1][col].getStones();
			//empty the pit
			board[1][col].setStones(0);
			
			// keep adding stones till we run out
			
			
			
			
		}
		if(player.equalsIgnoreCase("player2")){
			
			
			
			
		}
		notifyListeners();//data has been changed
	}
	
	/**************************************************************
	 *Any time data gets updated, call this method 
	 * ************************************************************/
	private void notifyListeners(){	
		
		// Notify all observers of the change to the Pits
		ChangeEvent event = new ChangeEvent(this);
		
		for (ChangeListener lis : listener){
			lis.stateChanged(event);
		}
	}
	
	/*********************************************************
	 * return copy of the board, needed in View
	 * *******************************************************/
	public int[][] getData(){
		int[][] all = new int[2][8];
		
		for(int i=0;i<2; i++){
			for(int j=0;j<7;j++){
				all[i][j]=board[i][j].getStones();
			}
		}
		return all;
	}
	
	/***********************************************************
	 * Get the stones in right mancala ( player1's mancala)
	 * ********************************************************/
	public int getRightMancalaStones(){
		return board[1][7].getStones();
	}
	
	/***********************************************************
	 * Get the stones in left mancala ( player2's mancala)
	 * ********************************************************/
	public int getLeftMancalaStones(){
		return board[0][0].getStones();
	}
	
	/**************************************************************
	 * Increments left mancala's stones by 1 stone
	 * ************************************************************/
	public void addStoneToLeftMancala(){
		addStone(0,0);
	}
	
	/***************************************************************
	 * Increments rigth mancala's stones by 1 stone
	 * *************************************************************/
	public void addStoneToRightMancala(){
		addStone(1,7);
	}
	
	/*****************************************************************
	 * Add a stone to a given pit
	 * @param row, the row of the board
	 * @param col, the col of the board
	 * ***************************************************************/
	private void addStone(int row,int col){
		int totalStones =	board[row][col].getStones();
		board[row][col].setStones(totalStones+1);
	}
	
	/*************************************************************
	 * delete this after solving manchala
	 * ***********************************************************/
	
	public static void main(String[] args){	
		
		Model model = new Model(3);
		
		for(int i=0;i<2; i++){
			System.out.println();
			for(int j=0;j<7;j++){
				System.out.print("("+model.board[i][j].toString()+")");
			}
		}
		
		
	}
}

