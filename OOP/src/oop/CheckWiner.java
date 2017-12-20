package oop;

public class CheckWiner {
	private byte width = 0, height = 0;
	private Cell[][] cell;
	
	public static boolean won = false;
	public static byte numberOfCellToWin = 5;
	
	public CheckWiner(){
		this.width = DrawTable.width;
		this.height = DrawTable.height;
		this.cell = DrawTable.cell;
	}
	
	public boolean checkWinwer(){
		
		for(byte i = 0; i < width; i++){
			for(byte j = 0; j < height; j++){
				//check the current player
				if(cell[i][j].currentPlayer == true){
					//Save cell index
					Cell.XClickBefore = i;
					Cell.YClickBefore = j;
					
					if (checkColumn(i, j)){
						return true;
					}
					else if(checkRow(i, j)){
						return true;
					}
					else if(checkCross(i, j)){
						return true;
					}
					else{
						return false;
					}
				}
			}
		}
		return false;
	}
	
	private boolean checkColumn(byte curColumn, byte curRow){
		byte numberAppear = 0;
		byte illegalWin = 0;
		byte step = 0;
		
		for(byte i = curRow; i < height; i++){
			if(cell[curColumn][i].cellPlayer == cell[curColumn][curRow].cellPlayer){
				numberAppear++;
				DrawTable.winCellInfo[step][0] = curColumn;
				DrawTable.winCellInfo[step][1] = i;
				step++;
			}
			//check intercept
			else if(cell[curColumn][i].cellPlayer != 0){
				illegalWin++;
				break;
			}
			else{
				break;
			}
		}
		for(int i = curRow - 1; i >= 0; i--){
			if(cell[curColumn][i].cellPlayer == cell[curColumn][curRow].cellPlayer){
				numberAppear++;
				DrawTable.winCellInfo[step][0] = curColumn;
				DrawTable.winCellInfo[step][1] = (byte) i;
				step++;
			}
			//check intercept
			else if(cell[curColumn][i].cellPlayer != 0){
				illegalWin++;
				break;
			}
			else{
				break;
			}
		}
		
		if(illegalWin < 2){
			return checkNumberAppear(numberAppear, curColumn, curRow);
		}
		else{
			return false;
		}
	}
	
	private boolean checkRow(byte curColumn, byte curRow){
		byte numberAppear = 0;
		byte illegalWin = 0;
		byte step = 0;
		
		for(byte i = curColumn; i < width; i++){
			if(cell[i][curRow].cellPlayer == cell[curColumn][curRow].cellPlayer){
				numberAppear++;
				DrawTable.winCellInfo[step][0] = i;
				DrawTable.winCellInfo[step][1] = curRow;
				step++;
			}
			//check intercept
			else if(cell[i][curRow].cellPlayer != 0){
				illegalWin++;
				break;
			}
			else{
				break;
			}
		}
		for(int i = curColumn - 1; i >= 0; i--){
			if(cell[i][curRow].cellPlayer == cell[curColumn][curRow].cellPlayer){
				numberAppear++;
				DrawTable.winCellInfo[step][0] = (byte) i;
				DrawTable.winCellInfo[step][1] = curRow;
				step++;
			}
			//check intercept
			else if(cell[i][curRow].cellPlayer != 0){
				illegalWin++;
				break;
			}
			else{
				break;
			}
		}
		
		if(illegalWin < 2){
			return checkNumberAppear(numberAppear, curColumn, curRow);
		}
		else{
			return false;
		}
	}
	
	private boolean checkCross(byte curColumn, byte curRow){
		byte numberAppear = 0;
		byte illegalWin = 0;
		byte step = 0;
		
		//we are going to verify from left (lower) to right (higher)
		for(int i = 0; i < (height > width ? width:height); i++){
			if(((curColumn - i) >= 0) && ((curRow + i) < height)){
				if(cell[curColumn - i][curRow + i].cellPlayer == cell[curColumn][curRow].cellPlayer){
					numberAppear++;
					DrawTable.winCellInfo[step][0] = (byte) (curColumn - i);
					DrawTable.winCellInfo[step][1] = (byte) (curRow + i);
					step++;
				}
				//check intercept
				else if(cell[curColumn - i][curRow + i].cellPlayer != 0){
					illegalWin++;
					break;
				}
				else{
					break;
				}
			}
			else{
				break;
			}
		}
		for(int i = 1; i < (height > width ? width:height); i++){
			if(((curColumn + i) < width) && ((curRow - i) >= 0)){
				if(cell[curColumn + i][curRow - i].cellPlayer == cell[curColumn][curRow].cellPlayer){
					numberAppear++;
					DrawTable.winCellInfo[step][0] = (byte) (curColumn + i);
					DrawTable.winCellInfo[step][1] = (byte) (curRow - i);
					step++;
				}
				//check intercept
				else if(cell[curColumn + i][curRow - i].cellPlayer != 0){
					illegalWin++;
					break;
				}
				else{
					break;
				}
			}
			else{
				break;
			}
		}
		
		if(numberAppear < CheckWiner.numberOfCellToWin){
			
			numberAppear = 0;
			illegalWin = 0;
			step = 0;
			
			//we are going to verify from left (higher) to right (lower)
			for(int i = 0; i < (height > width ? width:height); i++){
				if(((curColumn - i) >= 0) && ((curRow - i) >= 0)){
					if(cell[curColumn - i][curRow - i].cellPlayer == cell[curColumn][curRow].cellPlayer){
						numberAppear++;
						DrawTable.winCellInfo[step][0] = (byte) (curColumn - i);
						DrawTable.winCellInfo[step][1] = (byte) (curRow - i);
						step++;
					}
					//check intercept
					else if(cell[curColumn - i][curRow - i].cellPlayer != 0){
						illegalWin++;
						break;
					}
					else{
						break;
					}
				}
				else{
					break;
				}
			}
			for(int i = 1; i < (height > width ? width:height); i++){
				if(((curColumn + i) < width) && ((curRow + i) < height)){
					if(cell[curColumn + i][curRow + i].cellPlayer == cell[curColumn][curRow].cellPlayer){
						numberAppear++;
						DrawTable.winCellInfo[step][0] = (byte) (curColumn + i);
						DrawTable.winCellInfo[step][1] = (byte) (curRow + i);
						step++;
					}
					//check intercept
					else if(cell[curColumn + i][curRow + i].cellPlayer != 0){
						illegalWin++;
						break;
					}
					else{
						break;
					}
				}
				else{
					break;
				}
			}
		}
		
		if(illegalWin < 2){
			return checkNumberAppear(numberAppear, curColumn, curRow);
		}
		else{
			return false;
		}
	}
	
	private boolean checkNumberAppear(byte numberAppear, byte curColumn, byte curRow){
		if(numberAppear == CheckWiner.numberOfCellToWin){
			if(cell[curColumn][curRow].cellPlayer == Player.PLAYER_A){
				Player.whoWiner = Player.PLAYER_A;
				Player.timesWinOfA++;
				if(Player.timesWinOfA > 99){
					Player.timesWinOfA = (byte) (Player.timesWinOfA - Player.timesWinOfB);
					Player.timesWinOfB = 0;
				}
			}
			else if(cell[curColumn][curRow].cellPlayer == Player.PLAYER_B){
				Player.whoWiner = Player.PLAYER_B;
				Player.timesWinOfB++;
				if(Player.timesWinOfB > 99){
					Player.timesWinOfB = (byte) (Player.timesWinOfB - Player.timesWinOfA);
					Player.timesWinOfA = 0;
				}
			}
			CheckWiner.won = true;
			return true;
		}
		else{
			return false;
		}
	}
	
}
