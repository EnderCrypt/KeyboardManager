package net.ddns.endercrypt.library.keyboardmanager.binds;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;

/**
 * keybind for multiple keys
 * @author EnderCrypt
 * @see KeyEvent
 */
public class MultiKey implements KeyboardBindFilter
{
	private BindType bindType;
	private int[] keys;

	public MultiKey(BindType bindType, int... keys)
	{
		this.bindType = bindType;
		this.keys = keys;
	}

	@Override
	public boolean check(KeyboardEvent keyboardEvent)
	{
		if (keyboardEvent.getBindType() == bindType)
		{
			for (int key : keys)
			{
				if (keyboardEvent.getKeyCode() == key)
				{
					return true;
				}
			}
		}
		return false;
	}
}
