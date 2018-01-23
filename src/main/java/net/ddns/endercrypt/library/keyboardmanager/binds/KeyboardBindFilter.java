package net.ddns.endercrypt.library.keyboardmanager.binds;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;

/**
 * implementable interface for creating custom keybinds
 * @author EnderCrypt
 */
public interface KeyboardBindFilter
{
	/**
	 * method for checking if a keybind should trigger
	 * @param keyboardEvent
	 * @return boolean true/false whether the keybind should trigger
	 */
	public boolean check(KeyboardEvent keyboardEvent);
}
