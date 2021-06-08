package com.rohit.ds_algo;

public class TicTacToe {

	int n=0;
	int[][] board;
	TicTacToe(int n){
		this.n = n;
		board = new int[n][n];
	}
	
	
	boolean move(int player, int row, int col) throws IllegalArgumentException{
		if(row<0 || col<0 || row>=n || col>=n)
			throw new IllegalArgumentException("Invalid cell move");
		if(board[row][col]!=0)
			throw new IllegalArgumentException("wrong move");
		if(player!=-1 && player!=1)
			throw new IllegalArgumentException("Wrong Player");
		
		board[row][col] = player;
		boolean rowP =true, colP=true, diagP=true, rDiagP=true;
		for(int i=0; i<n; ++i) {
			if(board[row][i]!=player)
				rowP=false;
			if(board[i][col]!=player)
				colP=false;
			if(board[i][i]!=player)
				diagP=false;
			if(board[n-i-1][n-i-1]!=player)
				rDiagP=false;
		}
		if(rowP||colP||diagP||rDiagP)
			return true;
		else return false;
	}
	
	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe(3);
		if(ticTacToe.move(1, 0, 0)) {
			System.out.println("player 1 won the match");
		}
		if(ticTacToe.move(-1, 0, 2)) {
			System.out.println("player -1 won the match");
		}
		if(ticTacToe.move(1, 2, 2)) {
			System.out.println("player 1 won the match");
		}
		if(ticTacToe.move(-1, 1, 1)) {
			System.out.println("player -1 won the match");
		}
		if(ticTacToe.move(1, 2, 0)) {
			System.out.println("player 1 won the match");
		}
		if(ticTacToe.move(-1, 1, 0)) {
			System.out.println("player -1 won the match");
		}
		if(ticTacToe.move(1, 2, 1)) {
			System.out.println("player 1 won the match");
		}
	}
}
