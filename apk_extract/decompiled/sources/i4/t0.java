package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;
import k3.d9;
import k3.g9;
import k3.i9;
import k3.m9;

/* JADX INFO: loaded from: classes.dex */
public abstract class t0 implements Map, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient s1 f5691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient s1 f5692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient a0 f5693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient w1 f5694d;

    public static <K, V> m0 builder() {
        return new m0(4);
    }

    public static <K, V> m0 builderWithExpectedSize(int i8) {
        d9.b(i8, "expectedSize");
        return new m0(i8);
    }

    public static void checkNoConflict(boolean z2, String str, Object obj, Object obj2) {
        if (!z2) {
            throw conflictException(str, obj, obj2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> t0 copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof t0) && !(map instanceof SortedMap)) {
            t0 t0Var = (t0) map;
            if (!t0Var.isPartialView()) {
                return t0Var;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k8, V v3) {
        d9.a(k8, v3);
        return new AbstractMap.SimpleImmutableEntry(k8, v3);
    }

    public static <K, V> t0 of() {
        return u4.EMPTY;
    }

    @SafeVarargs
    public static <K, V> t0 ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf(Arrays.asList(entryArr));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public w1 asMultimap() {
        if (isEmpty()) {
            return w1.of();
        }
        w1 w1Var = this.f5694d;
        if (w1Var != null) {
            return w1Var;
        }
        w1 w1Var2 = new w1(new r0(this, null), size(), null);
        this.f5694d = w1Var2;
        return w1Var2;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract s1 createEntrySet();

    public abstract s1 createKeySet();

    public abstract a0 createValues();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return m9.a(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public h5 keyIterator() {
        return new k0(entrySet().iterator());
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<Object, Object> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return i9.a(this);
    }

    public Object writeReplace() {
        return new s0(this);
    }

    public static <K, V> t0 of(K k8, V v3) {
        d9.a(k8, v3);
        return u4.create(1, new Object[]{k8, v3});
    }

    @Override // java.util.Map
    public s1 entrySet() {
        s1 s1Var = this.f5691a;
        if (s1Var != null) {
            return s1Var;
        }
        s1 s1VarCreateEntrySet = createEntrySet();
        this.f5691a = s1VarCreateEntrySet;
        return s1VarCreateEntrySet;
    }

    @Override // java.util.Map
    public s1 keySet() {
        s1 s1Var = this.f5692b;
        if (s1Var != null) {
            return s1Var;
        }
        s1 s1VarCreateKeySet = createKeySet();
        this.f5692b = s1VarCreateKeySet;
        return s1VarCreateKeySet;
    }

    @Override // java.util.Map
    public a0 values() {
        a0 a0Var = this.f5693c;
        if (a0Var != null) {
            return a0Var;
        }
        a0 a0VarCreateValues = createValues();
        this.f5693c = a0VarCreateValues;
        return a0VarCreateValues;
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        return u4.create(2, new Object[]{k8, v3, k10, v8});
    }

    public static <K, V> t0 copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        boolean z2 = iterable instanceof Collection;
        m0 m0Var = new m0(z2 ? ((Collection) iterable).size() : 4);
        if (z2) {
            int size = ((Collection) iterable).size() * 2;
            Object[] objArr = m0Var.f5643a;
            if (size > objArr.length) {
                m0Var.f5643a = Arrays.copyOf(objArr, g9.a(objArr.length, size));
            }
        }
        for (Map.Entry<? extends K, ? extends V> entry : iterable) {
            m0Var.b(entry.getKey(), entry.getValue());
        }
        return m0Var.a();
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8, K k11, V v10) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        d9.a(k11, v10);
        return u4.create(3, new Object[]{k8, v3, k10, v8, k11, v10});
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        d9.a(k11, v10);
        d9.a(k12, v11);
        return u4.create(4, new Object[]{k8, v3, k10, v8, k11, v10, k12, v11});
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        d9.a(k11, v10);
        d9.a(k12, v11);
        d9.a(k13, v12);
        return u4.create(5, new Object[]{k8, v3, k10, v8, k11, v10, k12, v11, k13, v12});
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        d9.a(k11, v10);
        d9.a(k12, v11);
        d9.a(k13, v12);
        d9.a(k14, v13);
        return u4.create(6, new Object[]{k8, v3, k10, v8, k11, v10, k12, v11, k13, v12, k14, v13});
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        d9.a(k11, v10);
        d9.a(k12, v11);
        d9.a(k13, v12);
        d9.a(k14, v13);
        d9.a(k15, v14);
        return u4.create(7, new Object[]{k8, v3, k10, v8, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14});
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        d9.a(k11, v10);
        d9.a(k12, v11);
        d9.a(k13, v12);
        d9.a(k14, v13);
        d9.a(k15, v14);
        d9.a(k16, v15);
        return u4.create(8, new Object[]{k8, v3, k10, v8, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15});
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15, K k17, V v16) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        d9.a(k11, v10);
        d9.a(k12, v11);
        d9.a(k13, v12);
        d9.a(k14, v13);
        d9.a(k15, v14);
        d9.a(k16, v15);
        d9.a(k17, v16);
        return u4.create(9, new Object[]{k8, v3, k10, v8, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15, k17, v16});
    }

    public static <K, V> t0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15, K k17, V v16, K k18, V v17) {
        d9.a(k8, v3);
        d9.a(k10, v8);
        d9.a(k11, v10);
        d9.a(k12, v11);
        d9.a(k13, v12);
        d9.a(k14, v13);
        d9.a(k15, v14);
        d9.a(k16, v15);
        d9.a(k17, v16);
        d9.a(k18, v17);
        return u4.create(10, new Object[]{k8, v3, k10, v8, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15, k17, v16, k18, v17});
    }
}
