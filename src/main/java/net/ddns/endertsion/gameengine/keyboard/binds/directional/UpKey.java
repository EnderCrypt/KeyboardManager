package net.ddns.endertsion.gameengine.keyboard.binds.directional;

import java.awt.event.KeyEvent;

import net.ddns.endertsion.gameengine.keyboard.BindType;

/**
 * keybind for the up arrow OR W key (as in WASD)
 * @author EnderCrypt
 */
public class UpKey extends AbstractDirectionalKey
{
	public UpKey(BindType bindType)
	{
		super(bindType, KeyEvent.VK_UP, KeyEvent.VK_W);
	}
}
