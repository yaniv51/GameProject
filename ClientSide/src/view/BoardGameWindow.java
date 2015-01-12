package view;

import java.io.IOException;

import model.algorithm.State;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class BoardGameWindow extends BasikWindow implements View {

	String action;
	
	public BoardGameWindow() {
		super();
	}

	@Override
	void initWidgets() {

		shell.setLayout(new GridLayout(2, false));

		// create bar menu
		Menu menuBar = new Menu(shell, SWT.BAR);
		// create the File item's drop menu
		Menu fileMenu = new Menu(menuBar);
		// Create all the items in the bar menu
		MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
		fileItem.setText("File");
		fileItem.setMenu(fileMenu);
		// Create all the items in the File dropdown menu
		MenuItem openPropItem = new MenuItem(fileMenu, SWT.NONE);
		openPropItem.setText("Open Properties");
		MenuItem exutItem = new MenuItem(fileMenu, SWT.NONE);
		exutItem.setText("Exit");
		shell.setMenuBar(menuBar);

		// play button
		Button play = new Button(shell, SWT.PUSH);
		play.setText("Play");
		play.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));

		Canvas board = new Canvas(shell, SWT.BORDER);
		board.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 10));

		// create domain buttons
		String domainName[] = { "TicTacToe", "Reversi" };
		Combo domain = new Combo(shell, SWT.NONE | SWT.READ_ONLY);
		domain.setText("Choose Game");
		for (int i = 0; i < domainName.length; i++)
			domain.add(domainName[i]);
		domain.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		// create algorithm buttons
		String alorithmName[] = { "MiniMax", "MiniMaxAlphaBeta" };
		Combo algorithm = new Combo(shell, SWT.DROP_DOWN);
		algorithm.setText("Choose Algorithm");
		for (int i = 0; i < alorithmName.length; i++)
			algorithm.add(alorithmName[i]);
		algorithm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		// create hard level buttons
		Combo hardLevel = new Combo(shell, SWT.DROP_DOWN);
		hardLevel.setText("Choose Hard Level");
		for (int i = 0; i < 3; i++)
			hardLevel.add(Integer.toString(i+1));
		hardLevel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		//hint button
		Button hint = new Button(shell, SWT.PUSH);
		hint.setText("Get Hint");
		hint.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		
		
		//      Listeners     ///
		domain.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(domain.getText());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		algorithm.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(algorithm.getText());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		
		hardLevel.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(hardLevel.getText());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		// To Do: show hint
		  play.addSelectionListener(new SelectionListener() {
		  
		  @Override public void widgetSelected(SelectionEvent arg0) {
			  System.out.println(domain.getText());
			  String s = domain.getText();
			 action =  "SelectGame "+domain.getText()+":"+hardLevel.getText()+",SelectAlgoritm "+algorithm.getText()+",play";
			 action.split(",");
			 System.out.println(action);
			 
			  
		  }

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub 
			} });
	}

	@Override
	public void doTask() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserPoints() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startView() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayCurrentState(State game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUserAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gameOver(int gameOver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printHint(String hint) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Group domain = new Group(shell, SWT.SHADOW_OUT);
	 * domain.setText("Choose Game"); Button tttButton = new Button(domain,
	 * SWT.RADIO); tttButton.setText("TicTacToe"); Button reversiButton =
	 * new Button(domain, SWT.RADIO); reversiButton.setText("Reversi");
	 * domain.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
	 * 1,1)); domain.setLayout(new GridLayout(2, false));
	-------------------------------------
	 * Group alorithm = new Group(shell, SWT.SHADOW_OUT);
	 * alorithm.setText("Choose Algorithm"); alorithm.setLayout(new
	 * GridLayout(2, false)); new Button(alorithm,
	 * SWT.RADIO).setText("MiniMax"); new Button(alorithm,
	 * SWT.RADIO).setText("MiniMaxAlphaBeta"); alorithm.setLayoutData(new
	 * GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
	 * ---------------------------
	 Group hardLevel = new Group(shell, SWT.SHADOW_OUT);
	hardLevel.setText("Choose Hard Level");
	hardLevel.setLayout(new GridLayout(3, false));
	for (int i = 1; i < 4; i++)
		new Button(hardLevel, SWT.RADIO).setText(Integer.toString(i));
	hardLevel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false,
			1, 1));*/

}
