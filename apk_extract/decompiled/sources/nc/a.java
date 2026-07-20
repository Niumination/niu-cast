package nc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f8149d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f8150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f8151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeMap f8152c = new TreeMap();

    public a(Class cls) {
        this.f8150a = cls;
        this.f8151b = b(cls.getSuperclass());
        for (Field field : cls.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers()) && !this.f8152c.containsKey(field.getName())) {
                this.f8152c.put(field.getName(), new b(field, this));
            }
        }
        for (Method method : cls.getDeclaredMethods()) {
            if (!Modifier.isStatic(method.getModifiers())) {
                int length = method.getParameterTypes().length;
                String name = method.getName();
                if (name.length() > 3 || name.startsWith("is")) {
                    if (length == 0) {
                        if (name.startsWith("get")) {
                            String strD = d(name.substring(3));
                            if (!this.f8152c.containsKey(strD)) {
                                this.f8152c.put(strD, new b(strD, this));
                            }
                            ((b) this.f8152c.get(strD)).b(method);
                        } else if (name.startsWith("is")) {
                            String strD2 = d(name.substring(2));
                            if (!this.f8152c.containsKey(strD2)) {
                                this.f8152c.put(strD2, new b(strD2, this));
                            }
                            ((b) this.f8152c.get(strD2)).b(method);
                        }
                    } else if (length == 1 && name.startsWith("set")) {
                        String strD3 = d(name.substring(3));
                        if (!this.f8152c.containsKey(strD3)) {
                            this.f8152c.put(strD3, new b(strD3, this));
                        }
                        b bVar = (b) this.f8152c.get(strD3);
                        bVar.getClass();
                        Class<?> cls2 = method.getParameterTypes()[0];
                        if (bVar.f8156d == null) {
                            bVar.f8156d = cls2;
                        }
                        bVar.f8158h.put(cls2, method);
                        method.setAccessible(true);
                    }
                }
            }
        }
        Iterator it = this.f8152c.values().iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.c() == null && bVar2.d() == null && !Modifier.isPublic(bVar2.e.getModifiers())) {
                it.remove();
            }
        }
    }

    public static a b(Class cls) {
        ThreadLocal threadLocal = f8149d;
        if (threadLocal.get() == null) {
            threadLocal.set(new HashMap());
        }
        if (cls == null) {
            return null;
        }
        if (!((Map) threadLocal.get()).containsKey(cls)) {
            ((Map) threadLocal.get()).put(cls, new a(cls));
        }
        return (a) ((Map) threadLocal.get()).get(cls);
    }

    public static String d(String str) {
        if (str.length() < 2) {
            return str.toLowerCase();
        }
        if (Character.isUpperCase(str.charAt(0)) && Character.isUpperCase(str.charAt(1))) {
            return str;
        }
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    public final Collection a() {
        TreeMap treeMap = new TreeMap((Map) this.f8152c);
        for (a aVar = this.f8151b; aVar != null; aVar = aVar.f8151b) {
            TreeMap treeMap2 = aVar.f8152c;
            for (String str : treeMap2.keySet()) {
                if (!treeMap.containsKey(str)) {
                    treeMap.put(str, treeMap2.get(str));
                }
            }
        }
        return treeMap.values();
    }

    public final boolean c(String str) {
        a aVar;
        return this.f8152c.containsKey(str) || ((aVar = this.f8151b) != null && aVar.c(str));
    }
}
