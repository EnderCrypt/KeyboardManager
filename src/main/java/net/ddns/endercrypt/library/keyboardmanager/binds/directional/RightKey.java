package net.ddns.endercrypt.library.keyboardmanager.binds.directional;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.binds.MultiKey;

/**
 * keybind for the right arrow OR D key (as in WASD)
 * @author EnderCrypt
 */
public class RightKey extends MultiKey
{
	public RightKey(BindType bindType)
	{
		super(bindType, KeyEvent.VK_RIGHT, KeyEvent.VK_D);
	}
}
