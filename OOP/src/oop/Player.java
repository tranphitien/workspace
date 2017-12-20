package oop;

public class Player {
	public static byte PLAYER_A = 1;
	public static byte PLAYER_B = 2;
	public static byte DRAW		= 3;
	
	public static byte HUMAN_HUMAN = 1;
	public static byte HUMAN_COMPUTER = 0;
	
	public static byte timesWinOfA = 0;
	public static byte timesWinOfB = 0;

	public static byte modePlayer = HUMAN_COMPUTER;
	public static boolean computerDone = true;
	
	public static byte firstPlayer = 0;
	public static byte whoPlayer = 0;
	public static byte whoWiner = 0;
}
