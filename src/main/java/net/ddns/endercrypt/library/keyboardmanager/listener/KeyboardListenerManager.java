package net.ddns.endercrypt.library.keyboardmanager.listener;

import java.util.HashSet;
import java.util.Set;

import net.ddns.endercrypt.library.keyboardmanager.listener.group.KeyboardListenerGroup;

public class KeyboardListenerManager
{
	private KeyboardListenerGroup globalListenerGroup = new KeyboardListenerGroup();

	private Set<KeyboardListenerGroup> listenerGroups = new HashSet<>();

	public KeyboardListenerManager()
	{
		listenerGroups.add(globalListenerGroup);
	}

	public KeyboardListenerGroup getGlobalGroup()
	{
		return globalListenerGroup;
	}

	public boolean add(KeyboardListenerGroup listenerGroup)
	{
		if (listenerGroup == globalListenerGroup)
		{
			throw new IllegalArgumentException("Cannot add global listener");
		}
		return listenerGroups.add(globalListenerGroup);
	}

	public boolean remove(KeyboardListenerGroup listenerGroup)
	{
		if (listenerGroup == globalListenerGroup)
		{
			throw new IllegalArgumentException("Cannot remove global listener");
		}
		return listenerGroups.remove(globalListenerGroup);
	}
}
