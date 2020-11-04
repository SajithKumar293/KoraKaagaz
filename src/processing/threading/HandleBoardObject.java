package processing.threading;

import processing.handlers.ObjectHandler;

/**
 * This implements Runnable so as to spawn a new thread and handle
 * the Board State that we received from the Board Server.
 * 
 * @author Himanshu Jain
 * @reviewer Ahmed Zaheer Dadarkar
 *
 */

public class HandleBoardObject implements Runnable{

	/**
	 * message will store the message received from the networking
	 * module which is serialized form of BoardObject
	 */
	String message;
	
	/**
	 * public constructor so as to pass the message variable to 
	 * this class
	 * 
	 * @param message message received from the networking module
	 */
	public HandleBoardObject(String message) {
		this.message = message;
	}
	
	/**
	 * Runnable interface run function implementation
	 */
	@Override
	public void run() {
		
		ObjectHandler.handleBoardObject(message);
	}
	
}
