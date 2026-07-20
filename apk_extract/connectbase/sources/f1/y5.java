package f1;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class y5<K, V> extends k3<K, V> {
    static final k3<Object, Object> EMPTY = new y5(null, new Object[0], 0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f5616g = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5617i = 128;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5618n = 32768;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5619p = 255;

    @b1.d
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5620v = 65535;

    @b1.e
    final transient Object[] alternatingKeysAndValues;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.a
    public final transient Object f5621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f5622f;

    public static class a<K, V> extends t3<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient k3<K, V> f5623e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient Object[] f5624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final transient int f5625g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final transient int f5626i;

        /* JADX INFO: renamed from: f1.y5$a$a, reason: collision with other inner class name */
        public class C0134a extends i3<Map.Entry<K, V>> {
            public C0134a() {
            }

            @Override // f1.e3
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f5626i;
            }

            @Override // java.util.List
            public Map.Entry<K, V> get(int index) {
                c1.h0.C(index, a.this.f5626i);
                int i10 = index * 2;
                Object obj = a.this.f5624f[a.this.f5625g + i10];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f5624f[i10 + (a.this.f5625g ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        }

        public a(k3<K, V> map, Object[] alternatingKeysAndValues, int keyOffset, int size) {
            this.f5623e = map;
            this.f5624f = alternatingKeysAndValues;
            this.f5625g = keyOffset;
            this.f5626i = size;
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) object;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f5623e.get(key));
        }

        @Override // f1.e3
        public int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        @Override // f1.t3
        public i3<Map.Entry<K, V>> createAsList() {
            return new C0134a();
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f5626i;
        }

        @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public x7<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    public static final class b<K> extends t3<K> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient k3<K, ?> f5627e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient i3<K> f5628f;

        public b(k3<K, ?> map, i3<K> list) {
            this.f5627e = map;
            this.f5628f = list;
        }

        @Override // f1.t3, f1.e3
        public i3<K> asList() {
            return this.f5628f;
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            return this.f5627e.get(object) != null;
        }

        @Override // f1.e3
        public int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f5627e.size();
        }

        @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public x7<K> iterator() {
            return asList().iterator();
        }
    }

    public static final class c extends i3<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient Object[] f5629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f5630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f5631e;

        public c(Object[] alternatingKeysAndValues, int offset, int size) {
            this.f5629c = alternatingKeysAndValues;
            this.f5630d = offset;
            this.f5631e = size;
        }

        @Override // java.util.List
        public Object get(int index) {
            c1.h0.C(index, this.f5631e);
            Object obj = this.f5629c[(index * 2) + this.f5630d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f5631e;
        }
    }

    public y5(@gm.a Object hashTable, Object[] alternatingKeysAndValues, int size) {
        this.f5621e = hashTable;
        this.alternatingKeysAndValues = alternatingKeysAndValues;
        this.f5622f = size;
    }

    @gm.a
    public static Object a(Object[] alternatingKeysAndValues, int n10, int tableSize, int keyOffset) {
        k3.b.a aVar = null;
        if (n10 == 1) {
            Object obj = alternatingKeysAndValues[keyOffset];
            Objects.requireNonNull(obj);
            Object obj2 = alternatingKeysAndValues[keyOffset ^ 1];
            Objects.requireNonNull(obj2);
            b0.a(obj, obj2);
            return null;
        }
        int i10 = tableSize - 1;
        int i11 = -1;
        if (tableSize <= 128) {
            byte[] bArr = new byte[tableSize];
            Arrays.fill(bArr, (byte) -1);
            int i12 = 0;
            for (int i13 = 0; i13 < n10; i13++) {
                int i14 = (i13 * 2) + keyOffset;
                int i15 = (i12 * 2) + keyOffset;
                Object obj3 = alternatingKeysAndValues[i14];
                Objects.requireNonNull(obj3);
                Object obj4 = alternatingKeysAndValues[i14 ^ 1];
                Objects.requireNonNull(obj4);
                b0.a(obj3, obj4);
                int iC = z2.c(obj3.hashCode());
                while (true) {
                    int i16 = iC & i10;
                    int i17 = bArr[i16] & 255;
                    if (i17 == 255) {
                        bArr[i16] = (byte) i15;
                        if (i12 < i13) {
                            alternatingKeysAndValues[i15] = obj3;
                            alternatingKeysAndValues[i15 ^ 1] = obj4;
                        }
                        i12++;
                        break;
                    }
                    if (obj3.equals(alternatingKeysAndValues[i17])) {
                        int i18 = i17 ^ 1;
                        Object obj5 = alternatingKeysAndValues[i18];
                        Objects.requireNonNull(obj5);
                        aVar = new k3.b.a(obj3, obj4, obj5);
                        alternatingKeysAndValues[i18] = obj4;
                        break;
                    }
                    iC = i16 + 1;
                }
            }
            return i12 == n10 ? bArr : new Object[]{bArr, Integer.valueOf(i12), aVar};
        }
        if (tableSize <= 32768) {
            short[] sArr = new short[tableSize];
            Arrays.fill(sArr, (short) -1);
            int i19 = 0;
            for (int i20 = 0; i20 < n10; i20++) {
                int i21 = (i20 * 2) + keyOffset;
                int i22 = (i19 * 2) + keyOffset;
                Object obj6 = alternatingKeysAndValues[i21];
                Objects.requireNonNull(obj6);
                Object obj7 = alternatingKeysAndValues[i21 ^ 1];
                Objects.requireNonNull(obj7);
                b0.a(obj6, obj7);
                int iC2 = z2.c(obj6.hashCode());
                while (true) {
                    int i23 = iC2 & i10;
                    int i24 = sArr[i23] & lm.g2.f10190d;
                    if (i24 == 65535) {
                        sArr[i23] = (short) i22;
                        if (i19 < i20) {
                            alternatingKeysAndValues[i22] = obj6;
                            alternatingKeysAndValues[i22 ^ 1] = obj7;
                        }
                        i19++;
                        break;
                    }
                    if (obj6.equals(alternatingKeysAndValues[i24])) {
                        int i25 = i24 ^ 1;
                        Object obj8 = alternatingKeysAndValues[i25];
                        Objects.requireNonNull(obj8);
                        aVar = new k3.b.a(obj6, obj7, obj8);
                        alternatingKeysAndValues[i25] = obj7;
                        break;
                    }
                    iC2 = i23 + 1;
                }
            }
            return i19 == n10 ? sArr : new Object[]{sArr, Integer.valueOf(i19), aVar};
        }
        int[] iArr = new int[tableSize];
        Arrays.fill(iArr, -1);
        int i26 = 0;
        int i27 = 0;
        while (i26 < n10) {
            int i28 = (i26 * 2) + keyOffset;
            int i29 = (i27 * 2) + keyOffset;
            Object obj9 = alternatingKeysAndValues[i28];
            Objects.requireNonNull(obj9);
            Object obj10 = alternatingKeysAndValues[i28 ^ 1];
            Objects.requireNonNull(obj10);
            b0.a(obj9, obj10);
            int iC3 = z2.c(obj9.hashCode());
            while (true) {
                int i30 = iC3 & i10;
                int i31 = iArr[i30];
                if (i31 == i11) {
                    iArr[i30] = i29;
                    if (i27 < i26) {
                        alternatingKeysAndValues[i29] = obj9;
                        alternatingKeysAndValues[i29 ^ 1] = obj10;
                    }
                    i27++;
                    break;
                }
                if (obj9.equals(alternatingKeysAndValues[i31])) {
                    int i32 = i31 ^ 1;
                    Object obj11 = alternatingKeysAndValues[i32];
                    Objects.requireNonNull(obj11);
                    aVar = new k3.b.a(obj9, obj10, obj11);
                    alternatingKeysAndValues[i32] = obj10;
                    break;
                }
                iC3 = i30 + 1;
                i11 = -1;
            }
            i26++;
            i11 = -1;
        }
        return i27 == n10 ? iArr : new Object[]{iArr, Integer.valueOf(i27), aVar};
    }

    public static <K, V> y5<K, V> create(int n10, Object[] alternatingKeysAndValues) {
        return create(n10, alternatingKeysAndValues, null);
    }

    @gm.a
    public static Object createHashTableOrThrow(Object[] alternatingKeysAndValues, int n10, int tableSize, int keyOffset) {
        Object objA = a(alternatingKeysAndValues, n10, tableSize, keyOffset);
        if (objA instanceof Object[]) {
            throw ((k3.b.a) ((Object[]) objA)[2]).a();
        }
        return objA;
    }

    @Override // f1.k3
    public t3<Map.Entry<K, V>> createEntrySet() {
        return new a(this, this.alternatingKeysAndValues, 0, this.f5622f);
    }

    @Override // f1.k3
    public t3<K> createKeySet() {
        return new b(this, new c(this.alternatingKeysAndValues, 0, this.f5622f));
    }

    @Override // f1.k3
    public e3<V> createValues() {
        return new c(this.alternatingKeysAndValues, 1, this.f5622f);
    }

    @Override // f1.k3, java.util.Map
    @gm.a
    public V get(@gm.a Object obj) {
        V v10 = (V) get(this.f5621e, this.alternatingKeysAndValues, this.f5622f, 0, obj);
        if (v10 == null) {
            return null;
        }
        return v10;
    }

    @Override // f1.k3
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f5622f;
    }

    public static <K, V> y5<K, V> create(int n10, Object[] alternatingKeysAndValues, k3.b<K, V> builder) {
        if (n10 == 0) {
            return (y5) EMPTY;
        }
        if (n10 == 1) {
            Object obj = alternatingKeysAndValues[0];
            Objects.requireNonNull(obj);
            Object obj2 = alternatingKeysAndValues[1];
            Objects.requireNonNull(obj2);
            b0.a(obj, obj2);
            return new y5<>(null, alternatingKeysAndValues, 1);
        }
        c1.h0.d0(n10, alternatingKeysAndValues.length >> 1);
        Object objA = a(alternatingKeysAndValues, n10, t3.chooseTableSize(n10), 0);
        if (objA instanceof Object[]) {
            Object[] objArr = (Object[]) objA;
            k3.b.a aVar = (k3.b.a) objArr[2];
            if (builder == null) {
                throw aVar.a();
            }
            builder.f5019e = aVar;
            Object obj3 = objArr[0];
            int iIntValue = ((Integer) objArr[1]).intValue();
            alternatingKeysAndValues = Arrays.copyOf(alternatingKeysAndValues, iIntValue * 2);
            objA = obj3;
            n10 = iIntValue;
        }
        return new y5<>(objA, alternatingKeysAndValues, n10);
    }

    @gm.a
    public static Object get(@gm.a Object hashTableObject, Object[] alternatingKeysAndValues, int size, int keyOffset, @gm.a Object key) {
        if (key == null) {
            return null;
        }
        if (size == 1) {
            Object obj = alternatingKeysAndValues[keyOffset];
            Objects.requireNonNull(obj);
            if (!obj.equals(key)) {
                return null;
            }
            Object obj2 = alternatingKeysAndValues[keyOffset ^ 1];
            Objects.requireNonNull(obj2);
            return obj2;
        }
        if (hashTableObject == null) {
            return null;
        }
        if (hashTableObject instanceof byte[]) {
            byte[] bArr = (byte[]) hashTableObject;
            int length = bArr.length - 1;
            int iC = z2.c(key.hashCode());
            while (true) {
                int i10 = iC & length;
                int i11 = bArr[i10] & 255;
                if (i11 == 255) {
                    return null;
                }
                if (key.equals(alternatingKeysAndValues[i11])) {
                    return alternatingKeysAndValues[i11 ^ 1];
                }
                iC = i10 + 1;
            }
        } else if (hashTableObject instanceof short[]) {
            short[] sArr = (short[]) hashTableObject;
            int length2 = sArr.length - 1;
            int iC2 = z2.c(key.hashCode());
            while (true) {
                int i12 = iC2 & length2;
                int i13 = sArr[i12] & lm.g2.f10190d;
                if (i13 == 65535) {
                    return null;
                }
                if (key.equals(alternatingKeysAndValues[i13])) {
                    return alternatingKeysAndValues[i13 ^ 1];
                }
                iC2 = i12 + 1;
            }
        } else {
            int[] iArr = (int[]) hashTableObject;
            int length3 = iArr.length - 1;
            int iC3 = z2.c(key.hashCode());
            while (true) {
                int i14 = iC3 & length3;
                int i15 = iArr[i14];
                if (i15 == -1) {
                    return null;
                }
                if (key.equals(alternatingKeysAndValues[i15])) {
                    return alternatingKeysAndValues[i15 ^ 1];
                }
                iC3 = i14 + 1;
            }
        }
    }
}
