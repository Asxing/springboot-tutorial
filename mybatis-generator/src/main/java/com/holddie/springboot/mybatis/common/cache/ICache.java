package com.holddie.springboot.mybatis.common.cache;


/**
 * 缓存接口
 * @author HoldDie
 * @version v1.0.0
 * @email HoldDie@163.com
 * @date 2018/5/18 18:42
 */
public interface ICache<T> {
	
	/**
	 * Get an item from the cache, nontransactionally
	 * @param key 主键key
	 * @return the cached object or <tt>null</tt>
	 */
	public T get(Object key);
	/**
	 * Add an item to the cache, nontransactionally, with
	 * failfast semantics
	 * @param key 主键key
	 * @param value 对应的value
	 */
	public void put(Object key, T value);
	
	/**
	 * 往缓存中写入内容
	 * @param key 主键key
	 * @param value 对应的value
	 * @param exp	超时时间，单位为秒
	 */
	public void put(Object key, T value, int exp);
	
	/**
	 * Remove an item from the cache
	 */
	public void remove(Object key);
	/**
	 * Clear the cache
	 */
	public void clear();
}
