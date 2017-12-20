package oop;

import org.eclipse.swt.SWT;

public class DrawTable {
	private static byte MAX_WIDTH 	= 30;
	private static byte MIN_WIDTH 	= 1;
	private static byte MAX_HEIGHT 	= 30;
	private static byte MIN_HEIGHT 	= 1;
	private static int 	X_BEGIN 	= 254;
	private static int 	Y_BEGIN 	= 24;
	private static byte W_CELL 		= 33;
	private static byte H_CELL 		= 33;
	
	private boolean cFlag = false;
	
	public static byte width = 0, height = 0;
	public static byte winCellInfo[][] = new byte[CheckWiner.numberOfCellToWin][2];
	
	public static Cell[][] cell = null;
	
	public boolean initTable(byte width, byte height){
		if((width > MAX_WIDTH)||(width < MIN_WIDTH)||(height > MAX_HEIGHT)||(height < MIN_HEIGHT)){
			return false;
		}
		else{
			if(cFlag){
				destroyTable();
			}
			cFlag = true;
			DrawTable.width = width;
			DrawTable.height = height;
			return true;
		}
	}
	
	public void createTable(){
		cell = new Cell[width][height];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				cell[i][j] = new Cell(oop.views.CaroGameView.myparent, SWT.BORDER);
				cell[i][j].setBounds(X_BEGIN + i*W_CELL, Y_BEGIN + j*H_CELL, W_CELL, H_CELL);
			}
		}
	}
	
	public void destroyTable(){
		Player.whoPlayer = 0;
		CheckWiner.won = false;
		NotifyMessage.clearNotifyMessage();
		Player.computerDone = true;
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				cell[i][j].cellPlayer = 0;
				cell[i][j].currentPlayer = false;
				cell[i][j].winCellFlag = false;
				cell[i][j].dispose();
			}
		}
		for(int i = 0; i < CheckWiner.numberOfCellToWin; i++){
			winCellInfo[i][0] = 0;
			winCellInfo[i][1] = 0;
		}
	}
	
	public static void reDrawTable(){
		for(int i = 0; i < DrawTable.width; i++){
			for(int j = 0; j < DrawTable.height; j++){
				DrawTable.cell[i][j].redraw();
			}
		}
	}
	
	public static void drawWinLine(){
		if((Player.whoWiner == Player.PLAYER_A) || (Player.whoWiner == Player.PLAYER_B)){
			for(int i = 0; i < CheckWiner.numberOfCellToWin; i++){
				cell[winCellInfo[i][0]][winCellInfo[i][1]].winCellFlag = true;
				cell[winCellInfo[i][0]][winCellInfo[i][1]].redraw();
			}
		}
	}
}
