package net.ddns.endercrypt.library.keyboardmanager.listener.group;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;
import net.ddns.endercrypt.library.keyboardmanager.listener.KeyboardListener;

public interface ListenerGroup
{
	/**
	 * method for binding a key stroke (or multiple) to a callback listener
	 * @param keyboardBindFilter such a <code>new SpecificKey</code> or <code>new LeftKey</code>
	 * @param keyboardListener
	 */
	public void bind(KeyboardBindFilter keyboardBindFilter, KeyboardListener keyboardListener);

	/**
	 * simulates a key press by passing the {@link KeyboardEvent} into any active keyboard listeners
	 * @param keyboardEvent
	 */
	public void trigger(KeyboardEvent keyboardEvent);

	/**
	 * clears all the keylisteners in this keyboard listener group
	 */
	public void clear();
}
