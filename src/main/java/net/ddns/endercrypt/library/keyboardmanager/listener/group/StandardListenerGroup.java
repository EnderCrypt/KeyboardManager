package net.ddns.endercrypt.library.keyboardmanager.listener.group;

import java.util.HashSet;
import java.util.Set;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardBinding;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;
import net.ddns.endercrypt.library.keyboardmanager.listener.KeyboardListener;
import net.ddns.endercrypt.library.keyboardmanager.listener.ListenerGroups;

/**
 * class representing a group of keyboard listener, this class must be added to a {@link ListenerGroups} to recieve events
 * @author EnderCrypt
 */
public class StandardListenerGroup implements ListenerGroup
{
	private Set<KeyboardBinding> bindings = new HashSet<>();

	@Override
	public void bind(KeyboardBindFilter keyboardBindFilter, KeyboardListener keyboardListener)
	{
		synchronized (bindings)
		{
			bindings.add(new KeyboardBinding(keyboardBindFilter, keyboardListener));
		}
	}

	@Override
	public void trigger(KeyboardEvent keyboardEvent)
	{
		synchronized (bindings)
		{
			for (KeyboardBinding binding : bindings)
			{
				binding.attemptTrigger(keyboardEvent);
			}
		}
	}

	@Override
	public void clear()
	{
		bindings.clear();
	}
}
