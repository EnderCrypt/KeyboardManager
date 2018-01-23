package net.ddns.endertsion.gameengine.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

public class KeyboardManager
{
	private List<Binding> bindings = new ArrayList<>();

	private Set<Integer> keysDown = new HashSet<>();

	public void install(JFrame jFrame)
	{
		jFrame.setFocusTraversalKeysEnabled(false);
		jFrame.addKeyListener(new InternalKeyboardListener());
	}

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

	private void trigger(KeyboardEvent keyboardEvent)
	{
		for (Binding binding : bindings)
		{
			KeyboardBindFilter filter = binding.keyboardBindFilter;
			KeyboardListener listener = binding.keyboardListener;

			if (filter.check(keyboardEvent))
			{
				listener.trigger(keyboardEvent);
			}
		}
	}

	private void keyPress(int keyCode)
	{
		synchronized (keysDown)
		{
			keysDown.add(keyCode);
		}
		trigger(createKeyboardEvent(keyCode, BindType.PRESS));
	}

	private void keyRelease(int keyCode)
	{
		synchronized (keysDown)
		{
			keysDown.remove(keyCode);
		}
		trigger(createKeyboardEvent(keyCode, BindType.RELEASE));
	}

	public void bind(KeyboardBindFilter keyboardBindFilter, KeyboardListener keyboardListener)
	{
		synchronized (bindings)
		{
			bindings.add(new Binding(keyboardBindFilter, keyboardListener));
		}
	}

	public void resetBinds()
	{
		bindings.clear();
	}

	private KeyboardEvent createKeyboardEvent(int keyCode, BindType bindType)
	{
		return new KeyboardEvent(keyCode, bindType, this);
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + " [keysDown=" + keysDown + "]";
	}

	private class Binding
	{
		private final KeyboardBindFilter keyboardBindFilter;
		private final KeyboardListener keyboardListener;

		private Binding(KeyboardBindFilter keyboardBindFilter, KeyboardListener keyboardListener)
		{
			this.keyboardBindFilter = keyboardBindFilter;
			this.keyboardListener = keyboardListener;
		}
	}

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