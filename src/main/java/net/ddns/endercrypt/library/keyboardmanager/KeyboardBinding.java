package net.ddns.endercrypt.library.keyboardmanager;

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

	public KeyboardBindFilter getKeyboardBindFilter()
	{
		return keyboardBindFilter;
	}

	public KeyboardListener getKeyboardListener()
	{
		return keyboardListener;
	}
}
