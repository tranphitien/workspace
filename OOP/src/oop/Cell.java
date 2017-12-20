package oop;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


public class Cell extends Canvas{
	
	private CheckWiner checkWiner = new CheckWiner();
	
	public byte cellPlayer = 0;
	public boolean currentPlayer = false;
	public boolean winCellFlag = false;
	
	public static int XClickBefore = 0;
	public static int YClickBefore = 0;
	private static int XOldClickBefore = 0;
	private static int YOldClickBefore = 0;
	
	public Cell(Composite parent, int style) {
		super(parent, style);
		
		addListener(SWT.Paint, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				
				if(cellPlayer == Player.PLAYER_A){
					if(currentPlayer||winCellFlag){
						arg0.gc.drawImage(Icons.imageA0, 0, 0);
						currentPlayer = false;
					}
					else{
						arg0.gc.drawImage(Icons.imageA, 0, 0);
					}
				}
				else if(cellPlayer == Player.PLAYER_B){
					if(currentPlayer||winCellFlag){
						arg0.gc.drawImage(Icons.imageB0, 0, 0);
						currentPlayer = false;
					}
					else{
						arg0.gc.drawImage(Icons.imageB, 0, 0);
					}
				}
				else{
					arg0.gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
					arg0.gc.fillRectangle(0, 0, 30, 30);
				}
			}
        });
        
		addListener(SWT.MouseDown, new Listener(){

			@Override
			public void handleEvent(Event arg0) {
				if(!CheckWiner.won){
					if(Player.modePlayer == Player.HUMAN_HUMAN){
						//Human and human mode
						if((cellPlayer != Player.PLAYER_A)&&(cellPlayer != Player.PLAYER_B)){
							//Check to lose player plays first.
							if(Player.whoWiner == Player.PLAYER_A){
								Player.whoPlayer = Player.PLAYER_B;
								cellPlayer = Player.PLAYER_B;
								Player.whoWiner = 0;
							}
							else if(Player.whoWiner == Player.PLAYER_B){
								Player.whoPlayer = Player.PLAYER_A;
								cellPlayer = Player.PLAYER_A;
								Player.whoWiner = 0;
							}
							else{
								if((Player.whoPlayer == Player.PLAYER_A)){
									Player.whoPlayer = Player.PLAYER_B;
									cellPlayer = Player.PLAYER_B;
								}
								else{
									Player.whoPlayer = Player.PLAYER_A;
									cellPlayer = Player.PLAYER_A;
								}
							}
							
							currentPlayer = true;
							
							redraw();
							
							//Check winer or draw
							if(checkWiner.checkWinwer() || CheckDraw.checkDraw()){
								NotifyMessage.notifyWinerOrDraw();
								NotifyMessage.notifyScore();
								DrawTable.drawWinLine();
							}
						}
					}
					else{
						//Human and Computer mode
						//Playing if computer done
						if(Player.computerDone){
							if((cellPlayer != Player.PLAYER_A)&&(cellPlayer != Player.PLAYER_B)){
								cellPlayer = Player.PLAYER_A;
								Player.computerDone = false;
								
								currentPlayer = true;
								
								redraw();
								
								//Check winer or draw
								if(checkWiner.checkWinwer() || CheckDraw.checkDraw()){
									NotifyMessage.notifyWinerOrDraw();
									NotifyMessage.notifyScore();
									DrawTable.drawWinLine();
								}
							}
						}
					}	
				}
			}
		});
		
		addListener(SWT.MouseUp, new Listener(){

			@Override
			public void handleEvent(Event arg0) {
				if(Player.firstPlayer != 0){
					DrawTable.cell[XOldClickBefore][YOldClickBefore].redraw();
				}
				else{
					Player.firstPlayer = cellPlayer;
				}
				XOldClickBefore = XClickBefore;
				YOldClickBefore = YClickBefore;
				
				if(Player.modePlayer == Player.HUMAN_COMPUTER){
					Computer.play();
				}
			}
			
		});
	}
}
