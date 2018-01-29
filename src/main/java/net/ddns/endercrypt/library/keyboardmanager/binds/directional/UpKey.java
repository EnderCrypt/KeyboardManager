package net.ddns.endercrypt.library.keyboardmanager.binds.directional;

import java.awt.event.KeyEvent;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.binds.MultiKey;

/**
 * keybind for the up arrow OR W key (as in WASD)
 * @author EnderCrypt
 */
public class UpKey extends MultiKey
{
	public UpKey(BindType bindType)
	{
		super(bindType, KeyEvent.VK_UP, KeyEvent.VK_W);
	}
}