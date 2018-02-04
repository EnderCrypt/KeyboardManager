package net.ddns.endercrypt.library.keyboardmanager.listener;

import java.util.HashSet;
import java.util.Set;

import net.ddns.endercrypt.library.keyboardmanager.KeyboardEvent;
import net.ddns.endercrypt.library.keyboardmanager.listener.group.StandardListenerGroup;
import net.ddns.endercrypt.library.keyboardmanager.listener.group.ListenerGroup;

/**
 * listener group manager, manages all the keylistener group objects,
 * these allow you to selectifly choose which 'group' of listeners
 * that should be activated, usefull for when making an application
 * with multiple parts/rooms/windows, and only one listener (the focused)
 * should be able to recieve KeyEvents
 * <br><br>
 * the "GlobalGroup" is a listener that will always get activated, regardless of what
 * it cannot be disabled or re-enabled
 * @author EnderCrypt
 */
public class ListenerGroups
{
	private ListenerGroup globalListenerGroup = new StandardListenerGroup();

	private Set<ListenerGroup> listenerGroups = new HashSet<>();

	public ListenerGroups()
	{
		listenerGroups.add(globalListenerGroup);
	}

	/**
	 * returns the global listener group, this group cant be removed/added
	 * @return
	 */
	public ListenerGroup global()
	{
		return globalListenerGroup;
	}

	/**
	 * this method effectivly enables a keyboard listener group for recieving keyevents
	 * @param listenerGroup
	 * @return a boolean true if added, false if it was already in
	 */
	public boolean add(ListenerGroup listenerGroup)
	{
		if (listenerGroup == globalListenerGroup)
		{
			throw new IllegalArgumentException("Cannot add global listener");
		}
		return listenerGroups.add(globalListenerGroup);
	}

	/**
	 * this method disables a keyboard listener, it will not recieve keyevents after this
	 * @param listenerGroup
	 * @return true if removed successfully, false if the keylistener was already disabled (non-existant)
	 */
	public boolean remove(ListenerGroup listenerGroup)
	{
		if (listenerGroup == globalListenerGroup)
		{
			throw new IllegalArgumentException("Cannot remove global listener");
		}
		return listenerGroups.remove(globalListenerGroup);
	}

	/**
	 * simulates a key press by passing the {@link KeyboardEvent} into any active {@link StandardListenerGroup}
	 * @param keyboardEvent
	 */
	public void trigger(KeyboardEvent keyboardEvent)
	{
		for (ListenerGroup listenerGroup : listenerGroups)
		{
			listenerGroup.trigger(keyboardEvent);
		}
	}

	/**
	 * clears all the keyboard listener groups
	 */
	public void clear()
	{
		listenerGroups.clear();
		listenerGroups.add(globalListenerGroup);
	}
}
