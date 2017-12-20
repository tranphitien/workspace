package oop;

public class CheckDraw {
	
	public static boolean checkDraw(){
		for(int i = 0; i < DrawTable.width; i++){
			for(int j = 0; j < DrawTable.height; j++){
				if(DrawTable.cell[i][j].cellPlayer == 0){
					return false;
				}
			}
		}
		Player.whoWiner = Player.DRAW;
		return true;
	}
}
