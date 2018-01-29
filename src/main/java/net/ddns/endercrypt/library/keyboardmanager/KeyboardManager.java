package net.ddns.endercrypt.library.keyboardmanager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

public class KeyboardManager
{
	private List<KeyboardBinding> bindings = new ArrayList<>();

	private Set<Integer> keysDown = new HashSet<>();

	/**
	 * installs listeners on a JFrame
	 * 
	 * @param jFrame
	 */
	public void install(JFrame jFrame)
	{
		jFrame.setFocusTraversalKeysEnabled(false);
		jFrame.addKeyListener(new InternalKeyboardListener());
	}

	/**
	 * checks which keys are being held down, and triggers the callback
	 * this method should problably be called 30 or 60 times a second, depending on how many
	 * times you want HOLD listeners to trigger
	 */
	public void triggerHeldKeys()
	{
		synchronized (keysDown)
		{
			for (int keyCode : keysDown)
			{
				trigger(createKeyboardEvent(keyCode, BindType.HOLD));
			}
		}
	}

	/**
	 * checks if a specific key (KeyCode) i being held down
	 * @param keyCode
	 * @return
	 */
	public boolean keyIsHeld(int keyCode)
	{
		synchronized (keysDown)
		{
			for (int keyDown : keysDown)
			{
				if (keyCode == keyDown)
				{
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * simulates a keyboard event (pres, releae, hold)
	 * @param keyboardEvent
	 */
	private void trigger(KeyboardEvent keyboardEvent)
	{
		for (KeyboardBinding binding : bindings)
		{
			if (binding.getKeyboardBindFilter().check(keyboardEvent))
			{
				binding.getKeyboardListener().trigger(keyboardEvent);
			}
		}
	}

	/**
	 * changes the internal state to hold a specific key down
	 * @param keyCode
	 */
	private void keyPress(int keyCode)
	{
		synchronized (keysDown)
		{
			keysDown.add(keyCode);
		}
		trigger(createKeyboardEvent(keyCode, BindType.PRESS));
	}

	/**
	 * changes the internal state to release a specific key down
	 * @param keyCode
	 */
	private void keyRelease(int keyCode)
	{
		synchronized (keysDown)
		{
			keysDown.remove(keyCode);
		}
		trigger(createKeyboardEvent(keyCode, BindType.RELEASE));
	}

	/**
	 * clears all the current keybindings
	 */
	public void resetBinds()
	{
		bindings.clear();
	}

	/**
	 * creates a new KeyboardEvent instance
	 * @param keyCode
	 * @param bindType
	 * @return
	 */
	private KeyboardEvent createKeyboardEvent(int keyCode, BindType bindType)
	{
		return new KeyboardEvent(keyCode, bindType, this);
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + " [keysDown=" + keysDown + "]";
	}

	/**
	 * keylistener for installing into a JFrame
	 * @author EnderCrypt
	 */
	private class InternalKeyboardListener implements KeyListener
	{
		@Override
		public void keyTyped(KeyEvent e)
		{
			// unused
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			int keyCode = e.getKeyCode();
			keyPress(keyCode);
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			int keyCode = e.getKeyCode();
			keyRelease(keyCode);
		}
	}
}
