package net.ddns.endercrypt.library.keyboardmanager.binds.directional;

import net.ddns.endercrypt.library.keyboardmanager.BindType;
import net.ddns.endercrypt.library.keyboardmanager.binds.MultiKey;
import net.ddns.endercrypt.library.keyboardmanager.binds.SpecificKey;

/**
 * abstract helper class for implementing directional keybinds
 * @author EnderCrypt
 */
public abstract class AbstractDirectionalKey extends MultiKey
{
	protected AbstractDirectionalKey(BindType bindType, int... keys)
	{
		super(bindType, generateKeys(bindType, keys));
	}

	private static SpecificKey[] generateKeys(BindType bindType, int[] keys)
	{
		SpecificKey[] specificKeys = new SpecificKey[keys.length];
		for (int i = 0; i < keys.length; i++)
		{
			specificKeys[i] = new SpecificKey(bindType, keys[i]);
		}
		return specificKeys;
	}
}
