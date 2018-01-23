package net.ddns.endertsion.gameengine.keyboard;

import java.awt.event.KeyEvent;

/**
 * class representing a keyboard event, contain information about which key it relates to, and if shift, ctrl etc are being pressed
 * @author EnderCrypt
 */
public class KeyboardEvent
{
	private int keyCode;
	private BindType bindType;
	private boolean shift, ctrl, meta;

	public KeyboardEvent(int keyCode, BindType bindType, KeyboardManager keyboardManager)
	{
		this.keyCode = keyCode;
		this.bindType = bindType;

		shift = keyboardManager.keyIsHeld(KeyEvent.VK_SHIFT);
		ctrl = keyboardManager.keyIsHeld(KeyEvent.VK_CONTROL);
		meta = keyboardManager.keyIsHeld(KeyEvent.VK_META);
	}

	/**
	 * returns the keycode, this is a code from {@link KeyEvent}
	 * @return numeric KeyEvent
	 */
	public int getKeyCode()
	{
		return keyCode;
	}

	/**
	 * returns the bind type of the event (press, hold, release)
	 * @return bindtype
	 */
	public BindType getBindType()
	{
		return bindType;
	}

	/**
	 * return whether or not shift is held
	 * @return boolean
	 */
	public boolean isShiftHeld()
	{
		return shift;
	}

	/**
	 * return whether or not ctrl is held
	 * @return boolean
	 */
	public boolean isCtrlHeld()
	{
		return ctrl;
	}

	/**
	 * return whether or not meta is held
	 * @return boolean
	 */
	public boolean isMetaHeld()
	{
		return meta;
	}
}
