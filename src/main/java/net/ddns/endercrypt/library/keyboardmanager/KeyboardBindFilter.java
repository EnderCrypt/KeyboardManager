package net.ddns.endercrypt.library.keyboardmanager;

/**
 * interface for creating custom keybinds
 * @author EnderCrypt
 */
public interface KeyboardBindFilter
{
	public boolean check(KeyboardEvent keyboardEvent);
}
