package networking;


public interface MessageHandler {

	/**
	 * Handle an incoming message
	 * @param msg The received message
	 * @param username An identifier for the source (e.g. nickname)
	 */
	public void handleMessage(String msg, String username);
	
	/**
	 * Log an event
	 * @param msg Message to log
	 */
	public void log(String msg);

}