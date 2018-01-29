package net.ddns.endercrypt.library.keyboardmanager.binds.directional;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.binds.MultiKey;

/**
 * keybind for the left arrow OR A key (as in WASD)
 * @author EnderCrypt
 */
public class LeftKey extends MultiKey
{
	public LeftKey(BindType bindType)
	{
		super(bindType, KeyEvent.VK_LEFT, KeyEvent.VK_A);
	}
}
