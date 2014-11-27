package com.weasel.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

import com.weasel.core.helper.DemonPredict;

/**
 * @author Dylan
 * @mail pickear@gmail.com
 * @time 2014年7月17日
 */
public final class Langs {

	private Langs(){}
	
	public static Throwable toUnwrap(Throwable e) {
        DemonPredict.notNull(e, "e can not be null");

        Throwable unwrap = e;
        for (; ; ) {
            if (unwrap instanceof InvocationTargetException) {
                unwrap = ((InvocationTargetException) unwrap).getTargetException();
                continue;
            }

            if (unwrap instanceof UndeclaredThrowableException) {
                unwrap = ((UndeclaredThrowableException) unwrap).getUndeclaredThrowable();
                continue;
            }

            return unwrap;
        }
    }
}
