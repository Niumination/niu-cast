package com.transsion.core.deviceinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class SysProp {
    private static Method sysPropGet;
    private static Method sysPropSet;

    static {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("get")) {
                    sysPropGet = method;
                } else if (name.equals("set")) {
                    sysPropSet = method;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private SysProp() {
    }

    public static String get(String str, String str2) {
        try {
            return (String) sysPropGet.invoke(null, str, str2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return str2;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return str2;
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
            return str2;
        }
    }

    public static void set(String str, String str2) {
        try {
            sysPropSet.invoke(null, str, str2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
        }
    }
}
