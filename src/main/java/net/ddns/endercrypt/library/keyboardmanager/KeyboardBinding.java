package net.ddns.endercrypt.library.keyboardmanager;

import net.ddns.endercrypt.library.keyboardmanager.listener.KeyboardListener;

/**
 * class representing a keybind + callback
 * @author EnderCrypt
 */
public class KeyboardBinding
{
	private final KeyboardBindFilter keyboardBindFilter;
	private final KeyboardListener keyboardListener;

	public KeyboardBinding(KeyboardBindFilter keyboardBindFilter, KeyboardListener keyboardListener)
	{
		this.keyboardBindFilter = keyboardBindFilter;
		this.keyboardListener = keyboardListener;
	}

	/**
	 * getter for the KeyboardFilter
	 * @return the KeyboardBindFilter
	 */
	public KeyboardBindFilter getKeyboardBindFilter()
	{
		return keyboardBindFilter;
	}

	/**
	 * getter for the KeyboardListener
	 * @return the KeyboardListener
	 */
	public KeyboardListener getKeyboardListener()
	{
		return keyboardListener;
	}

	/**
	 * triggers the keyboard listener in this bind
	 * @param keyboardEvent
	 */
	public void trigger(KeyboardEvent keyboardEvent)
	{
		try
		{
			keyboardListener.trigger(keyboardEvent);
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}
}
