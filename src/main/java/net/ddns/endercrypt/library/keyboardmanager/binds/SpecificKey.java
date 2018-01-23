package net.ddns.endercrypt.library.keyboardmanager.binds;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;

/**
 * Keybind for a single key
 * @author EnderCrypt
 * @see KeyEvent
 */
public class SpecificKey implements KeyboardBindFilter
{
	private BindType bindType;
	private int keyCode;

	public SpecificKey(BindType bindType, int keyCode)
	{
		this.bindType = bindType;
		this.keyCode = keyCode;
	}

	@Override
	public boolean check(KeyboardEvent keyboardEvent)
	{
		if (keyboardEvent.getBindType() != bindType)
		{
			return false;
		}
		if (keyboardEvent.getKeyCode() != keyCode)
		{
			return false;
		}
		return true;
	}
}
