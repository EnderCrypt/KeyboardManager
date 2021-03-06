package net.ddns.endercrypt.library.keyboardmanager.binds.directional;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.binds.MultiKey;

/**
 * keybind for the down arrow OR S key (as in WASD)
 * @author EnderCrypt
 */
public class DownKey extends MultiKey
{
	public DownKey(BindType bindType)
	{
		super(bindType, KeyEvent.VK_DOWN, KeyEvent.VK_S);
	}
}
