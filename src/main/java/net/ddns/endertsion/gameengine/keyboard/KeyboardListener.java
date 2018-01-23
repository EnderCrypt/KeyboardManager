package net.ddns.endertsion.gameengine.keyboard;

/**
 * implementable method for creating keylistener callbacks
 * @author EnderCrypt
 */
@FunctionalInterface
public interface KeyboardListener
{
	/**
	 * listener method, gets activated when the bind gets triggered
	 * @param keyboardEvent
	 */
	void trigger(KeyboardEvent keyboardEvent);
}
