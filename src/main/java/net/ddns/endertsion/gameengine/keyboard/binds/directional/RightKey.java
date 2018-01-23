package net.ddns.endertsion.gameengine.keyboard.binds.directional;

import java.awt.event.KeyEvent;

import net.ddns.endertsion.gameengine.keyboard.BindType;

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
