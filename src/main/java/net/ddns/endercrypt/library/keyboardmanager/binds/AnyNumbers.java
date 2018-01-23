package net.ddns.endercrypt.library.keyboardmanager.binds;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;

/**
 * keybind for all the numbers on the keyboard
 * @author EnderCrypt
 * @see KeyEvent
 */
public class AnyNumbers extends BindRange
{
	public AnyNumbers(BindType bindType)
	{
		super(bindType, KeyEvent.VK_0, KeyEvent.VK_9);
	}
}