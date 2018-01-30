package net.ddns.endercrypt.library.keyboardmanager.listener.group;

import java.util.Optional;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardBindFilter;
import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;
import net.ddns.endercrypt.library.keyboardmanager.listener.KeyboardListener;

public class ListenerGroupContainer implements ListenerGroup
{
	private Optional<StandardListenerGroup> elementOptional = Optional.empty();

	public ListenerGroupContainer()
	{
		// TODO Auto-generated constructor stub
	}

	public void removeListenerGroup()
	{
		elementOptional = Optional.empty();
	}

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
