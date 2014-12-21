
package com.aysidisi.plainspringwebapp.config.cache;

import java.math.BigInteger;
import java.util.HashMap;

import com.aysidisi.plainspringwebapp.web.account.model.Account;

public class WebSocketSessionCache
{
	private static WebSocketSessionCache INSTANCE = new WebSocketSessionCache();
	
	public static WebSocketSessionCache getInstance()
	{
		return INSTANCE;
	}

	private final HashMap<String, HashMap<BigInteger, Account>> cache = new HashMap<String, HashMap<BigInteger, Account>>();
	
	private WebSocketSessionCache()
	{
	}
	
	public HashMap<String, HashMap<BigInteger, Account>> getWebSocketSessionCache()
	{
		return this.cache;
	}
	
	public HashMap<BigInteger, Account> getWebSocketSessionCacheBySubject(final String subject)
	{
		return this.cache.get(subject);
	}
}