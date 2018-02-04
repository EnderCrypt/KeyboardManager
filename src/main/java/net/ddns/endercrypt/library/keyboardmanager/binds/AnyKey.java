package net.ddns.endercrypt.library.keyboardmanager.binds;

import java.awt.event.KeyEvent;
import java.util.Optional;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;

/**
 * keybind for all keys
 * @author EnderCrypt
 * @see KeyEvent
 */
public class AnyKey implements KeyboardBindFilter
{
	private Optional<BindType> bindType;

	/**
	 * catches all key and events regardless of BindType (press, hold, release)
	 */
	public AnyKey()
	{
		this.bindType = Optional.empty();
	}

	/**
	 * catches all keys on either press, hold, release
	 * @param bindType
	 */
	public AnyKey(BindType bindType)
	{
		this.bindType = Optional.of(bindType);
	}

	@Override
	public boolean check(KeyboardEvent keyboardEvent)
	{
		if (bindType.isPresent())
		{
			return (keyboardEvent.getBindType().equals(bindType.get()));
		}
		return true;
	}
}