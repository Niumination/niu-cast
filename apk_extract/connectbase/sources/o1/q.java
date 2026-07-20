package o1;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@f
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f12044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f12045b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(16);
        a(linkedHashMap, linkedHashMap2, Boolean.TYPE, Boolean.class);
        a(linkedHashMap, linkedHashMap2, Byte.TYPE, Byte.class);
        a(linkedHashMap, linkedHashMap2, Character.TYPE, Character.class);
        a(linkedHashMap, linkedHashMap2, Double.TYPE, Double.class);
        a(linkedHashMap, linkedHashMap2, Float.TYPE, Float.class);
        a(linkedHashMap, linkedHashMap2, Integer.TYPE, Integer.class);
        a(linkedHashMap, linkedHashMap2, Long.TYPE, Long.class);
        a(linkedHashMap, linkedHashMap2, Short.TYPE, Short.class);
        a(linkedHashMap, linkedHashMap2, Void.TYPE, Void.class);
        f12044a = Collections.unmodifiableMap(linkedHashMap);
        f12045b = Collections.unmodifiableMap(linkedHashMap2);
    }

    public static void a(Map<Class<?>, Class<?>> forward, Map<Class<?>, Class<?>> backward, Class<?> key, Class<?> value) {
        forward.put(key, value);
        backward.put(value, key);
    }

    public static Set<Class<?>> b() {
        return f12044a.keySet();
    }

    public static Set<Class<?>> c() {
        return f12045b.keySet();
    }

    public static boolean d(Class<?> type) {
        Map<Class<?>, Class<?>> map = f12045b;
        type.getClass();
        return map.containsKey(type);
    }

    public static <T> Class<T> e(Class<T> type) {
        type.getClass();
        Class<T> cls = (Class) f12045b.get(type);
        return cls == null ? type : cls;
    }

    public static <T> Class<T> f(Class<T> type) {
        type.getClass();
        Class<T> cls = (Class) f12044a.get(type);
        return cls == null ? type : cls;
    }
}
