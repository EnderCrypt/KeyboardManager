package net.ddns.endercrypt.library.keyboardmanager.listener.group;

import java.util.HashSet;
import java.util.Set;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardBinding;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;
import net.ddns.endercrypt.library.keyboardmanager.listener.KeyboardListener;

public class KeyboardListenerGroup
{
	private Set<KeyboardBinding> bindings = new HashSet<>();

	/**
	 * method for binding a key stroke (or multiple) to a callback listener
	 * @param keyboardBindFilter such a <code>new SpecificKey</code> or <code>new LeftKey</code>
	 * @param keyboardListener
	 */
	public void bind(KeyboardBindFilter keyboardBindFilter, KeyboardListener keyboardListener)
	{
		synchronized (bindings)
		{
			bindings.add(new KeyboardBinding(keyboardBindFilter, keyboardListener));
		}
	}

	public void trigger(KeyboardEvent keyboardEvent)
	{
		synchronized (bindings)
		{
			for (KeyboardBinding binding : bindings)
			{
				if (binding.getKeyboardBindFilter().check(keyboardEvent))
				{
					binding.getKeyboardListener().trigger(keyboardEvent);
				}
			}
		}
	}
}
