package net.ddns.endercrypt.library.keyboardmanager;

/**
 * interface for creating custom keybinds
 * @author EnderCrypt
 */
public interface KeyboardBindFilter
{
	/**
	 * this method gets called to check if a keyboardevent qualifies for the specific bind
	 * @param keyboardEvent
	 * @return a boolean true if the filter qualifies the keyboard event
	 */
	public boolean check(KeyboardEvent keyboardEvent);
}
