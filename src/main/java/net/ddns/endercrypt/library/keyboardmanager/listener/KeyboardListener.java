package net.ddns.endercrypt.library.keyboardmanager.listener;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;

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
