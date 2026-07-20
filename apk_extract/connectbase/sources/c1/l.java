package c1;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@k
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b1.c
    public static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f1195a = new WeakHashMap();

    @b1.c
    public static final class a<T extends Enum<T>> extends i<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        public a(Class<T> enumClass) {
            enumClass.getClass();
            this.enumClass = enumClass;
        }

        @Override // c1.i, c1.t
        public boolean equals(@gm.a Object object) {
            if (object instanceof a) {
                return this.enumClass.equals(((a) object).enumClass);
            }
            return false;
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
        }

        @Override // c1.i
        public String doBackward(T enumValue) {
            return enumValue.name();
        }

        @Override // c1.i
        public T doForward(String str) {
            return (T) Enum.valueOf(this.enumClass, str);
        }
    }

    @b1.c
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> enumClass) {
        Map<String, WeakReference<? extends Enum<?>>> mapD;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map = f1195a;
        synchronized (map) {
            try {
                mapD = map.get(enumClass);
                if (mapD == null) {
                    mapD = d(enumClass);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mapD;
    }

    @b1.c
    public static Field b(Enum<?> enumValue) {
        try {
            return enumValue.getDeclaringClass().getDeclaredField(enumValue.name());
        } catch (NoSuchFieldException e10) {
            throw new AssertionError(e10);
        }
    }

    public static <T extends Enum<T>> c0<T> c(Class<T> enumClass, String value) {
        enumClass.getClass();
        value.getClass();
        return g0.d(enumClass, value);
    }

    @b1.c
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> d(Class<T> enumClass) {
        HashMap map = new HashMap();
        for (Enum r10 : EnumSet.allOf(enumClass)) {
            map.put(r10.name(), new WeakReference(r10));
        }
        f1195a.put(enumClass, map);
        return map;
    }

    @b1.c
    public static <T extends Enum<T>> i<String, T> e(Class<T> enumClass) {
        return new a(enumClass);
    }
}
