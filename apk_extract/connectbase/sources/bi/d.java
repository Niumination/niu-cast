package bi;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<Map<Class, d>> f840d = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, e> f843c;

    public d(Class cls) {
        this.f841a = cls;
        this.f842b = a(cls.getSuperclass());
        g();
    }

    public static d a(Class cls) {
        ThreadLocal<Map<Class, d>> threadLocal = f840d;
        if (threadLocal.get() == null) {
            threadLocal.set(new HashMap());
        }
        if (cls == null) {
            return null;
        }
        if (!threadLocal.get().containsKey(cls)) {
            threadLocal.get().put(cls, new d(cls));
        }
        return threadLocal.get().get(cls);
    }

    public Field b(String str) {
        try {
            return this.f841a.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public Collection<e> c() {
        TreeMap treeMap = new TreeMap(this.f843c);
        for (d dVar = this.f842b; dVar != null; dVar = dVar.f842b) {
            d(treeMap, dVar.f843c);
        }
        return treeMap.values();
    }

    public final void d(Map<String, e> map, Map<String, e> map2) {
        for (String str : map2.keySet()) {
            if (!map.containsKey(str)) {
                map.put(str, map2.get(str));
            }
        }
    }

    public d e() {
        return this.f842b;
    }

    public e f(String str) {
        while (this != null) {
            e eVar = this.f843c.get(str);
            if (eVar != null) {
                return eVar;
            }
            this = this.f842b;
        }
        return null;
    }

    public final void g() {
        this.f843c = new TreeMap();
        for (Field field : this.f841a.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers()) && !this.f843c.containsKey(field.getName())) {
                this.f843c.put(field.getName(), new e(field, this));
            }
        }
        for (Method method : this.f841a.getDeclaredMethods()) {
            if (!Modifier.isStatic(method.getModifiers())) {
                int length = method.getParameterTypes().length;
                String name = method.getName();
                if (name.length() > 3 || name.startsWith("is")) {
                    if (length == 0) {
                        if (name.startsWith("get")) {
                            String strI = i(name.substring(3));
                            if (!this.f843c.containsKey(strI)) {
                                this.f843c.put(strI, new e(strI, this));
                            }
                            this.f843c.get(strI).f(method);
                        } else if (name.startsWith("is")) {
                            String strI2 = i(name.substring(2));
                            if (!this.f843c.containsKey(strI2)) {
                                this.f843c.put(strI2, new e(strI2, this));
                            }
                            this.f843c.get(strI2).f(method);
                        }
                    } else if (length == 1 && name.startsWith("set")) {
                        String strI3 = i(name.substring(3));
                        if (!this.f843c.containsKey(strI3)) {
                            this.f843c.put(strI3, new e(strI3, this));
                        }
                        this.f843c.get(strI3).d(method);
                    }
                }
            }
        }
        Iterator<e> it = this.f843c.values().iterator();
        while (it.hasNext()) {
            if (it.next().m()) {
                it.remove();
            }
        }
    }

    public boolean h(String str) {
        d dVar;
        return this.f843c.containsKey(str) || ((dVar = this.f842b) != null && dVar.h(str));
    }

    public final String i(String str) {
        if (str.length() < 2) {
            return str.toLowerCase();
        }
        if (Character.isUpperCase(str.charAt(0)) && Character.isUpperCase(str.charAt(1))) {
            return str;
        }
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }
}
