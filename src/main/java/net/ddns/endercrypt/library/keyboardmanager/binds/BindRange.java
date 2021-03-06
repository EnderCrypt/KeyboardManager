package net.ddns.endercrypt.library.keyboardmanager.binds;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;

/**
 * keybind for binding a range of keys, use 2 values from {@link KeyEvent}
 * @author EnderCrypt
 * @see KeyEvent
 */
public class BindRange implements KeyboardBindFilter
{
	protected final BindType bindType;
	protected final int minRange, maxRange;

	public BindRange(BindType bindType, int minRange, int maxRange)
	{
		this.bindType = bindType;
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	@Override
	public boolean check(KeyboardEvent keyboardEvent)
	{
		if (keyboardEvent.getBindType() == bindType)
		{
			int keyCode = keyboardEvent.getKeyCode();
			if ((keyCode >= minRange) && (keyCode <= maxRange))
			{
				return true;
			}
		}
		return false;
	}
}
