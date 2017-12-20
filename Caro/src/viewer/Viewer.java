package viewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Viewer {

	protected Shell shell;
	private Text txtWidth;
	private Text txtHeight;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Viewer window = new Viewer();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		shell.setSize(854, 504);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Group grpConfiguration = new Group(shell, SWT.NONE);
		grpConfiguration.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		grpConfiguration.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpConfiguration.setBounds(10, 10, 150, 122);
		
		txtWidth = new Text(grpConfiguration, SWT.BORDER);
		txtWidth.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.NORMAL));
		txtWidth.setBounds(71, 29, 66, 21);
		
		Label lblWidth = new Label(grpConfiguration, SWT.NONE);
		lblWidth.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblWidth.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		lblWidth.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lblWidth.setBounds(10, 27, 55, 21);
		lblWidth.setText("Width");
		
		Label lblHeight = new Label(grpConfiguration, SWT.NONE);
		lblHeight.setText("Height");
		lblHeight.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lblHeight.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		lblHeight.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblHeight.setBounds(10, 54, 55, 21);
		
		Button btnAi = new Button(grpConfiguration, SWT.RADIO);
		btnAi.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		btnAi.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		btnAi.setBounds(10, 94, 46, 16);
		btnAi.setText("AI");
		
		Button btnHuman = new Button(grpConfiguration, SWT.RADIO);
		btnHuman.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		btnHuman.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		btnHuman.setText("Human");
		btnHuman.setBounds(61, 94, 79, 16);
		
		txtHeight = new Text(grpConfiguration, SWT.BORDER);
		txtHeight.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.NORMAL));
		txtHeight.setBounds(71, 54, 66, 21);
		
		Group grpScore = new Group(shell, SWT.NONE);
		grpScore.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		grpScore.setBounds(10, 145, 150, 115);
		
		Label lblRed = new Label(grpScore, SWT.NONE);
		lblRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblRed.setForeground(SWTResourceManager.getColor(204, 0, 0));
		lblRed.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 16, SWT.BOLD));
		lblRed.setBounds(10, 21, 43, 30);
		lblRed.setText("RED");
		
		Label lblBlue = new Label(grpScore, SWT.NONE);
		lblBlue.setText("BLUE");
		lblBlue.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblBlue.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 16, SWT.BOLD));
		lblBlue.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblBlue.setBounds(85, 21, 55, 30);
		
		Label label = new Label(grpScore, SWT.SEPARATOR);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		label.setBounds(69, 17, 2, 86);
		
		Label lblRedScore = new Label(grpScore, SWT.NONE);
		lblRedScore.setAlignment(SWT.CENTER);
		lblRedScore.setText("0");
		lblRedScore.setForeground(SWTResourceManager.getColor(204, 0, 0));
		lblRedScore.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 18, SWT.NORMAL));
		lblRedScore.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblRedScore.setBounds(10, 63, 43, 30);
		
		Label lblBlueScore = new Label(grpScore, SWT.NONE);
		lblBlueScore.setText("0");
		lblBlueScore.setForeground(SWTResourceManager.getColor(0, 51, 255));
		lblBlueScore.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 18, SWT.NORMAL));
		lblBlueScore.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblBlueScore.setAlignment(SWT.CENTER);
		lblBlueScore.setBounds(85, 63, 43, 30);
		
		Label label_1 = new Label(grpScore, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		label_1.setBounds(10, 15, 130, 2);
		
		Group grpControl = new Group(shell, SWT.NONE);
		grpControl.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		grpControl.setBounds(10, 272, 150, 128);
		
		Button btnNewMatch = new Button(grpControl, SWT.NONE);
		btnNewMatch.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		btnNewMatch.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		btnNewMatch.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		btnNewMatch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewMatch.setBounds(22, 18, 106, 30);
		btnNewMatch.setText("New Match");
		
		Button btnNewGame = new Button(grpControl, SWT.NONE);
		btnNewGame.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		btnNewGame.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		btnNewGame.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		btnNewGame.setBounds(22, 54, 106, 30);
		btnNewGame.setText("New Game");
		
		Button btnUndu = new Button(grpControl, SWT.CENTER);
		btnUndu.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		btnUndu.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		btnUndu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		btnUndu.setBounds(22, 90, 52, 25);
		btnUndu.setText("Undu");
		
		Button btnRedu = new Button(grpControl, SWT.NONE);
		btnRedu.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		btnRedu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		btnRedu.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 12, SWT.BOLD));
		btnRedu.setBounds(76, 90, 52, 25);
		btnRedu.setText("Redu");
		
		Canvas canvas = new Canvas(shell, SWT.BORDER);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setBounds(178, 10, 24, 22);

	}
}
