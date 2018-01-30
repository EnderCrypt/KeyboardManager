package net.ddns.endercrypt.library.keyboardmanager.listener.group;

import java.util.Optional;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;
import net.ddns.endercrypt.library.keyboardmanager.listener.KeyboardListener;
import net.ddns.endercrypt.library.keyboardmanager.listener.ListenerGroups;

/**
 * this class allows holding and switching out a StandardListenerGroup on the go, whitout having to remove/add anything to the {@link ListenerGroups} class
 * @author EnderCrypt
 */
public class ListenerGroupContainer implements ListenerGroup
{
	private Optional<StandardListenerGroup> elementOptional = Optional.empty();

	public ListenerGroupContainer()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * removes the currently active StandardListenerGroup from this container
	 */
	public void removeListenerGroup()
	{
		elementOptional = Optional.empty();
	}

	/**
	 * sets the currently active StandardListenerGroup to be triggered from keybinds
	 * @param a StandardListenerGroup (if null, effectivly uses {@link removeListenerGroup()} )
	 */
	public void setListenerGroup(StandardListenerGroup element)
	{
		elementOptional = Optional.ofNullable(element);
	}

	@Override
	public void bind(KeyboardBindFilter keyboardBindFilter, KeyboardListener keyboardListener)
	{
		elementOptional.ifPresent((e) -> e.bind(keyboardBindFilter, keyboardListener));
	}

	@Override
	public void trigger(KeyboardEvent keyboardEvent)
	{
		elementOptional.ifPresent((e) -> e.trigger(keyboardEvent));
	}

	@Override
	public void clear()
	{
		elementOptional.ifPresent((e) -> e.clear());
	}
}
