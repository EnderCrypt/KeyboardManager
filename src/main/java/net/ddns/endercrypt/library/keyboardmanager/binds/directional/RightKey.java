package net.ddns.endercrypt.library.keyboardmanager.binds.directional;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;

/**
 * keybind for the right arrow OR D key (as in WASD)
 * @author EnderCrypt
 */
public class RightKey extends AbstractDirectionalKey
{
	public RightKey(BindType bindType)
	{
		super(bindType, KeyEvent.VK_RIGHT, KeyEvent.VK_D);
	}
}
