package oop.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import oop.DrawTable;
import oop.NotifyMessage;
import oop.Player;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class CaroGameView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "oop.views.CaroGameView";
	private Text txtWidth;
	private Text txtHeight;
	public static  Composite myparent;
	public static Group rateGroup;
	
	DrawTable drawtable = new DrawTable();
	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	/**
	 * The constructor.
	 */
	public CaroGameView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		myparent = parent;
		parent.setLayout(null);
		
		Group grpTable = new Group(parent, SWT.NONE);
		grpTable.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		grpTable.setBounds(10, 20, 192, 189);
		
		final Label lblInvalidNumber = new Label(grpTable, SWT.NONE);
		lblInvalidNumber.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblInvalidNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblInvalidNumber.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 13, SWT.BOLD));
		lblInvalidNumber.setBounds(38, 152, 127, 27);
		
		
		Button btnNewgame = new Button(grpTable, SWT.NONE);
		btnNewgame.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!drawtable.initTable(getWidth(),  getHeight())){
					//display error message
					lblInvalidNumber.setText("Invalid Number");
				}
				else{
					//clear error message
					lblInvalidNumber.setText("");
					Player.timesWinOfA = 0;
					Player.timesWinOfB = 0;
					NotifyMessage.notifyScore();
					drawtable.createTable();
				}
			}
		});
		btnNewgame.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 10, SWT.BOLD));
		btnNewgame.setLocation(102, 94);
		btnNewgame.setSize(80, 42);
		btnNewgame.setText("New Game");
		
		Label lblWidth = new Label(grpTable, SWT.NONE);
		lblWidth.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblWidth.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblWidth.setLocation(14, 24);
		lblWidth.setSize(64, 21);
		lblWidth.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 14, SWT.BOLD));
		lblWidth.setText("Width");
		
		Label lblHeight = new Label(grpTable, SWT.NONE);
		lblHeight.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblHeight.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblHeight.setLocation(14, 57);
		lblHeight.setSize(64, 27);
		lblHeight.setText("Height");
		lblHeight.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 14, SWT.BOLD));
		
		Button btnRePlay = new Button(grpTable, SWT.NONE);
		btnRePlay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!drawtable.initTable(getWidth(),  getHeight())){
					//display error message
					lblInvalidNumber.setText("Invalid Number");
				}
				else{
					//clear error message
					lblInvalidNumber.setText("");
					NotifyMessage.notifyScore();
					drawtable.createTable();
				}
			}
		});
		btnRePlay.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 10, SWT.BOLD));
		btnRePlay.setLocation(14, 94);
		btnRePlay.setSize(82, 42);
		btnRePlay.setText("Re-Play");
		
		txtWidth = new Text(grpTable, SWT.BORDER);
		txtWidth.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.NORMAL));
		txtWidth.setLocation(106, 23);
		txtWidth.setSize(76, 21);
		
		txtHeight = new Text(grpTable, SWT.BORDER);
		txtHeight.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.NORMAL));
		txtHeight.setLocation(106, 55);
		txtHeight.setSize(76, 21);
		
		Group grpRate = new Group(parent, SWT.NONE);
		grpRate.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		grpRate.setBounds(10, 228, 192, 176);
		rateGroup = grpRate;
		
		Label lblRed = new Label(grpRate, SWT.NONE);
		lblRed.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblRed.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 15, SWT.BOLD));
		lblRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblRed.setBounds(24, 36, 49, 24);
		lblRed.setText("RED");
		
		Label lblBlue = new Label(grpRate, SWT.NONE);
		lblBlue.setText("BLUE");
		lblBlue.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblBlue.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 15, SWT.BOLD));
		lblBlue.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblBlue.setBounds(113, 36, 58, 24);
		
		Label label = new Label(grpRate, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(24, 28, 147, 2);
		
		Label label_1 = new Label(grpRate, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(90, 30, 2, 89);
		
		Group grpSelectPlayer = new Group(parent, SWT.NONE);
		grpSelectPlayer.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		grpSelectPlayer.setBounds(10, 418, 192, 71);
		
		Button btnPlayerVsPlayer = new Button(grpSelectPlayer, SWT.RADIO);
		btnPlayerVsPlayer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Player.modePlayer = Player.HUMAN_HUMAN;
			}
		});
		btnPlayerVsPlayer.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		btnPlayerVsPlayer.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		btnPlayerVsPlayer.setBounds(10, 10, 172, 24);
		btnPlayerVsPlayer.setText("Player vs Player");
		
		Button btnPlayerVsComputer = new Button(grpSelectPlayer, SWT.RADIO);
		btnPlayerVsComputer.setSelection(true);
		btnPlayerVsComputer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Player.modePlayer = Player.HUMAN_COMPUTER;
			}
		});
		btnPlayerVsComputer.setText("Player vs Computer");
		btnPlayerVsComputer.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		btnPlayerVsComputer.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		btnPlayerVsComputer.setBounds(10, 37, 172, 24);
		
	}
	
	private byte getWidth(){
		byte width = Byte.parseByte(txtWidth.getText());
		return width;
	}
	
	private byte getHeight(){
		byte height = Byte.parseByte(txtHeight.getText());
		return height;
	}
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}
