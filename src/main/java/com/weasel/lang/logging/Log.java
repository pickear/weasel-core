package com.weasel.lang.logging;

/**
 * @author Dylan
 * @mail pickear@gmail.com
 * @time 2014年7月17日
 */
public interface Log {

	boolean isDebugEnabled();

	boolean isTraceEnabled();

	void error(String s, Throwable e);

	void error(String s);

	void debug(String s);

	void trace(String s);

	void warn(String s);
	
	void info(String s);
}
