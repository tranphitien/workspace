package oop;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class NotifyMessage {
	private static Label lblWinerOrDraw = new Label(oop.views.CaroGameView.rateGroup, SWT.NONE);
	private static Label lblRedScore = new Label(oop.views.CaroGameView.rateGroup, SWT.NONE);
	private static Label lblBlueScore = new Label(oop.views.CaroGameView.rateGroup, SWT.NONE);
	
	public static void notifyWinerOrDraw(){
		
		if(Player.whoWiner == Player.PLAYER_A){
			lblWinerOrDraw.setBounds(10, 127, 161, 39);
			lblWinerOrDraw.setAlignment(SWT.CENTER);
			lblWinerOrDraw.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 16, SWT.BOLD));
			lblWinerOrDraw.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
			lblWinerOrDraw.setText("RED is winer");
		}
		else if(Player.whoWiner == Player.PLAYER_B){
			lblWinerOrDraw.setBounds(10, 127, 161, 39);
			lblWinerOrDraw.setAlignment(SWT.CENTER);
			lblWinerOrDraw.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 16, SWT.BOLD));
			lblWinerOrDraw.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
			lblWinerOrDraw.setText("BLUE is winer");
		}
		else if(Player.whoWiner == Player.DRAW){
			lblWinerOrDraw.setBounds(10, 127, 161, 39);
			lblWinerOrDraw.setAlignment(SWT.CENTER);
			lblWinerOrDraw.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 16, SWT.BOLD));
			lblWinerOrDraw.setForeground(SWTResourceManager.getColor(255, 140, 0));
			lblWinerOrDraw.setText("Ohh, Draw :)");
		}
		else{
			clearNotifyMessage();
		}
	}
	
	public static void notifyScore(){
		
		lblRedScore.setForeground(SWTResourceManager.getColor(128, 0, 0));
		lblRedScore.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 32, SWT.BOLD | SWT.ITALIC));
		lblRedScore.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblRedScore.setBounds(24, 58, 49, 43);
		lblRedScore.setText("" + Player.timesWinOfA);
		
		lblBlueScore.setForeground(SWTResourceManager.getColor(128, 0, 0));
		lblBlueScore.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 32, SWT.BOLD | SWT.ITALIC));
		lblBlueScore.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblBlueScore.setBounds(113, 58, 49, 43);
		lblBlueScore.setText("" + Player.timesWinOfB);
	}
	
	public static void clearNotifyMessage(){
		lblWinerOrDraw.setText("");
	}
	
}
