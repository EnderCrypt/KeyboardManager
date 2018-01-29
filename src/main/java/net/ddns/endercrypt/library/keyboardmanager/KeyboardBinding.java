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
	 * checks if the KeyboardEvent fits this bind, if it does then it will trigger the callback and return true
	 * @param keyboardEvent
	 * @return true if bind fits
	 */
	public boolean attemptTrigger(KeyboardEvent keyboardEvent)
	{
		if (check(keyboardEvent))
		{
			trigger(keyboardEvent);
			return true;
		}
		return false;
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
	 * checks if the KeyboardEvent is appropriate for this bind using the keyboardBindFilter in this bind
	 * @param keyboardEvent
	 * @return
	 */
	public boolean check(KeyboardEvent keyboardEvent)
	{
		return keyboardBindFilter.check(keyboardEvent);
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
