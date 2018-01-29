package net.ddns.endercrypt.library.keyboardmanager.listener.group;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.listener.KeyboardListener;

public class KeyboardListenerGroup
{
	public KeyboardListenerGroup()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * method for binding a key stroke (or multiple) to a callback listener
	 * @param keyboardBindFilter such a <code>new SpecificKey</code> or <code>new LeftKey</code>
	 * @param keyboardListener
	 */
	public void bind(KeyboardBindFilter keyboardBindFilter, KeyboardListener keyboardListener)
	{
		/*
		synchronized (bindings)
		{
			bindings.add(new Binding(keyboardBindFilter, keyboardListener));
		}
		*/
	}

	public void trigger()
	{

	}

}
