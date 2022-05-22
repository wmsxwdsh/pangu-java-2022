package com.pangu.utils.reflect;

/**
 * <pre>
 *     author: Blankj
 *     time  : 2018/01/12
 *     desc  :
 * </pre>
 */
public class PrivateConstructors {

    public final String string;

    private PrivateConstructors() {
        this(null);
    }

    private PrivateConstructors(String string) {
        this.string = string;
    }
}
