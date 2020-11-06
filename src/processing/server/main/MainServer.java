package processing.server.main;

import networking.CommunicatorFactory;

/**
 * Main class of main server.
 * This will start the main server to listen for Board Requests.
 * 
 * @author Himanshu Jain
 * @reviewer Ahmed Zaheer Dadarkar
 */

public class MainServer {

	// main function
	public static void main(String[] args) {
		
		/**
		 * The port number of the Main Server is fixed and saved in ServerState
		 * get the communicator from the networking module using the same port 
		 * number and save the resultant communicator in the ServerState.
		 */
		ServerState.communicator = CommunicatorFactory.getCommunicator(
				ServerState.portNumber.port
		);
		
		/**
		 *  call the start function of the networking module to continuously listen
		 *  on the given port.
		 */
		ServerState.communicator.start();
		
		/**
		 * Now Client can make a new board request to the server, for that Main Server
		 * need to subscribe for this request to the networking module.
		 */
		ServerState.communicator.subscribeForNotifications(
				"NewBoard",
				new NewBoardRequestHandler()
		);
		
		/**
		 * Client can also make existing board request so subscribing for existing board
		 * request, to the networking module.
		 */
		ServerState.communicator.subscribeForNotifications(
				"ExistingBoard", 
				new BoardRequestHandler()
		);
		
	}

}
