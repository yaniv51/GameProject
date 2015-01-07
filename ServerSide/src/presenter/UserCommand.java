package presenter;

import java.util.HashMap;
import model_.Model;

public class UserCommand {
	
	private HashMap<String, Command> userCommands;
	
	//c'tor
	public UserCommand() {
		userCommands = new HashMap<String, UserCommand.Command>();
		userCommands.put("SelectGame", new SelectDomainCommand());
		userCommands.put("SelectAlgoritm", new SelectAlgorithmCommand());
		userCommands.put("insert", new UserSetActionCommand());
		userCommands.put("hint", new getHintCommand());
		userCommands.put("exit", new saveGameCommand());
	}

	public void getCommands(Model gameModel, String select, String selection) throws Exception {
		
		Command command = userCommands.get(select);
		if(command == null)
			throw new Exception("not a legal command");
		if (selection == null) // impossible if enter play/exit
			command.doCommand(gameModel, select);
		else
			command.doCommand(gameModel, selection);
	}

	//command interface
	private interface Command {

		void doCommand(Model gameModel, String select);

	}

	//select game domain command
	private class SelectDomainCommand implements Command {

		public void doCommand(Model gameModel, String select) {
			String[] arr = select.split(":");

			int depth = Integer.parseInt(arr[1]);
			gameModel.selectDomain(arr[0]);
			gameModel.setHardLevel(depth);

		}

	}

	//select algorithm command
	private class SelectAlgorithmCommand implements Command {
		public void doCommand(Model gameModel, String select) {
			gameModel.selectAlgorithm(select);
		}
	}

	//user action point command
	private class UserSetActionCommand implements Command {
		@Override
		public void doCommand(Model gameModel, String select) {
		/*	String[] points = select.split(",");
			int row = Integer.parseInt(points[0]);
			int column = Integer.parseInt(points[1]);*/
		}
	}
	
	//when "exit" entered, save game solutions
	private class saveGameCommand implements Command {

		@Override
		public void doCommand(Model gameModel, String select) {
			try {
				gameModel.saveGame();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//get hint command
   private class getHintCommand implements Command {

		@Override
		public void doCommand(Model gameModel, String select) {
			/*int depth = Integer.parseInt(select);
			gameModel.setHintDepth(depth);
			Thread s = new Thread(new TaskRunnableHint(gameModel));
			s.start();*/
			
			
		}
	}



}
