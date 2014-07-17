package com.weasel.lang.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dylan
 * @mail pickear@gmail.com
 * @time 2014年7月17日
 */
public class JdkLogger implements Log {
	
	private Logger log;
	
	public JdkLogger(String clazz){
		log = Logger.getLogger(clazz);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		log.addHandler(handler);
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isLoggable(Level.FINE);
	}

	@Override
	public boolean isTraceEnabled() {
		return log.isLoggable(Level.FINER);
	}

	@Override
	public void error(String s, Throwable e) {
		log.log(Level.SEVERE, s,e);
	}

	@Override
	public void error(String s) {
		log.log(Level.SEVERE, s);
	}

	@Override
	public void debug(String s) {
		log.log(Level.FINE, s);
	}

	@Override
	public void trace(String s) {
		log.log(Level.FINE, s);
	}

	@Override
	public void warn(String s) {
		log.log(Level.WARNING, s);
	}

	@Override
	public void info(String s) {
		log.log(Level.INFO, s);
	}

}
