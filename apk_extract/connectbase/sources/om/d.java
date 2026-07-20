package om;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kn.l0;
import kn.r1;
import kn.w;
import nm.p;
import nm.v0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,727:1\n1#2:728\n*E\n"})
public final class d<K, V> implements Map<K, V>, Serializable, ln.g {

    @l
    public static final a Companion = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12311a = -1640531527;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12312b = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12313c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12314d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final d f12315e;

    @m
    private om.e<K, V> entriesView;

    @l
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;

    @l
    private K[] keysArray;

    @m
    private om.f<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;

    @l
    private int[] presenceArray;
    private int size;

    @m
    private V[] valuesArray;

    @m
    private g<V> valuesView;

    public static final class a {
        public a() {
        }

        public final int c(int i10) {
            if (i10 < 1) {
                i10 = 1;
            }
            return Integer.highestOneBit(i10 * 3);
        }

        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }

        @l
        public final d e() {
            return d.f12315e;
        }

        public a(w wVar) {
        }
    }

    public static final class b<K, V> extends C0313d<K, V> implements Iterator<Map.Entry<K, V>>, ln.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@l d<K, V> dVar) {
            super(dVar);
            l0.p(dVar, "map");
        }

        @Override // java.util.Iterator
        @l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            a();
            if (this.f12319b >= ((d) this.f12318a).length) {
                throw new NoSuchElementException();
            }
            int i10 = this.f12319b;
            this.f12319b = i10 + 1;
            this.f12320c = i10;
            c<K, V> cVar = new c<>(this.f12318a, i10);
            g();
            return cVar;
        }

        public final void l(@l StringBuilder sb2) {
            l0.p(sb2, "sb");
            if (this.f12319b >= ((d) this.f12318a).length) {
                throw new NoSuchElementException();
            }
            int i10 = this.f12319b;
            this.f12319b = i10 + 1;
            this.f12320c = i10;
            Object obj = ((d) this.f12318a).keysArray[this.f12320c];
            if (obj == this.f12318a) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append(fl.h.f6043c);
            Object[] objArr = ((d) this.f12318a).valuesArray;
            l0.m(objArr);
            Object obj2 = objArr[this.f12320c];
            if (obj2 == this.f12318a) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            g();
        }

        public final int m() {
            if (this.f12319b >= ((d) this.f12318a).length) {
                throw new NoSuchElementException();
            }
            int i10 = this.f12319b;
            this.f12319b = i10 + 1;
            this.f12320c = i10;
            Object obj = ((d) this.f12318a).keysArray[this.f12320c];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((d) this.f12318a).valuesArray;
            l0.m(objArr);
            Object obj2 = objArr[this.f12320c];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            g();
            return iHashCode2;
        }
    }

    public static final class c<K, V> implements Map.Entry<K, V>, ln.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final d<K, V> f12316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12317b;

        public c(@l d<K, V> dVar, int i10) {
            l0.p(dVar, "map");
            this.f12316a = dVar;
            this.f12317b = i10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@m Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (l0.g(entry.getKey(), getKey()) && l0.g(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((d) this.f12316a).keysArray[this.f12317b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((d) this.f12316a).valuesArray;
            l0.m(objArr);
            return (V) objArr[this.f12317b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            this.f12316a.checkIsMutable$kotlin_stdlib();
            Object[] objArrA = this.f12316a.a();
            int i10 = this.f12317b;
            V v11 = (V) objArrA[i10];
            objArrA[i10] = v10;
            return v11;
        }

        @l
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append(fl.h.f6043c);
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    /* JADX INFO: renamed from: om.d$d, reason: collision with other inner class name */
    @r1({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,727:1\n1#2:728\n*E\n"})
    public static class C0313d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final d<K, V> f12318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12321d;

        public C0313d(@l d<K, V> dVar) {
            l0.p(dVar, "map");
            this.f12318a = dVar;
            this.f12320c = -1;
            this.f12321d = ((d) dVar).modCount;
            g();
        }

        public final void a() {
            if (((d) this.f12318a).modCount != this.f12321d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int c() {
            return this.f12319b;
        }

        public final int e() {
            return this.f12320c;
        }

        @l
        public final d<K, V> f() {
            return this.f12318a;
        }

        public final void g() {
            while (this.f12319b < ((d) this.f12318a).length) {
                int[] iArr = ((d) this.f12318a).presenceArray;
                int i10 = this.f12319b;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.f12319b = i10 + 1;
                }
            }
        }

        public final void h(int i10) {
            this.f12319b = i10;
        }

        public final boolean hasNext() {
            return this.f12319b < ((d) this.f12318a).length;
        }

        public final void i(int i10) {
            this.f12320c = i10;
        }

        public final void remove() {
            a();
            if (this.f12320c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.f12318a.checkIsMutable$kotlin_stdlib();
            this.f12318a.v(this.f12320c);
            this.f12320c = -1;
            this.f12321d = ((d) this.f12318a).modCount;
        }
    }

    public static final class e<K, V> extends C0313d<K, V> implements Iterator<K>, ln.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@l d<K, V> dVar) {
            super(dVar);
            l0.p(dVar, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            a();
            if (this.f12319b >= ((d) this.f12318a).length) {
                throw new NoSuchElementException();
            }
            int i10 = this.f12319b;
            this.f12319b = i10 + 1;
            this.f12320c = i10;
            K k10 = (K) ((d) this.f12318a).keysArray[this.f12320c];
            g();
            return k10;
        }
    }

    public static final class f<K, V> extends C0313d<K, V> implements Iterator<V>, ln.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@l d<K, V> dVar) {
            super(dVar);
            l0.p(dVar, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            a();
            if (this.f12319b >= ((d) this.f12318a).length) {
                throw new NoSuchElementException();
            }
            int i10 = this.f12319b;
            this.f12319b = i10 + 1;
            this.f12320c = i10;
            Object[] objArr = ((d) this.f12318a).valuesArray;
            l0.m(objArr);
            V v10 = (V) objArr[this.f12320c];
            g();
            return v10;
        }
    }

    static {
        d dVar = new d(0);
        dVar.isReadOnly = true;
        f12315e = dVar;
    }

    public d(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i10, int i11) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i10;
        this.length = i11;
        this.hashShift = Companion.d(iArr2.length);
    }

    private final void f(int i10) {
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        if (i10 > getCapacity$kotlin_stdlib()) {
            int iE = nm.c.Companion.e(getCapacity$kotlin_stdlib(), i10);
            this.keysArray = (K[]) om.c.e(this.keysArray, iE);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) om.c.e(vArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iE);
            l0.o(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            int iC = Companion.c(iE);
            if (iC > this.hashArray.length) {
                t(iC);
            }
        }
    }

    private final void g(int i10) {
        if (w(i10)) {
            t(this.hashArray.length);
        } else {
            f(this.length + i10);
        }
    }

    private final void s() {
        this.modCount++;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new i(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final V[] a() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) om.c.d(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    public final int addKey$kotlin_stdlib(K k10) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iL = l(k10);
            int i10 = this.maxProbeDistance * 2;
            int length = this.hashArray.length / 2;
            if (i10 > length) {
                i10 = length;
            }
            int i11 = 0;
            while (true) {
                int i12 = this.hashArray[iL];
                if (i12 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        g(1);
                        break;
                    }
                    int i13 = this.length;
                    int i14 = i13 + 1;
                    this.length = i14;
                    this.keysArray[i13] = k10;
                    this.presenceArray[i13] = iL;
                    this.hashArray[iL] = i14;
                    this.size = size() + 1;
                    s();
                    if (i11 > this.maxProbeDistance) {
                        this.maxProbeDistance = i11;
                    }
                    return i13;
                }
                if (l0.g(this.keysArray[i12 - 1], k10)) {
                    return -i12;
                }
                i11++;
                if (i11 > i10) {
                    t(this.hashArray.length * 2);
                    break;
                }
                iL = iL == 0 ? this.hashArray.length - 1 : iL - 1;
            }
        }
    }

    @l
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        d dVar = f12315e;
        l0.n(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    public final void c() {
        int i10;
        V[] vArr = this.valuesArray;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.length;
            if (i11 >= i10) {
                break;
            }
            if (this.presenceArray[i11] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                i12++;
            }
            i11++;
        }
        om.c.g(this.keysArray, i12, i10);
        if (vArr != null) {
            om.c.g(vArr, i12, this.length);
        }
        this.length = i12;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        v0 it = new tn.l(0, this.length - 1, 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            int[] iArr = this.presenceArray;
            int i10 = iArr[iNextInt];
            if (i10 >= 0) {
                this.hashArray[i10] = 0;
                iArr[iNextInt] = -1;
            }
        }
        om.c.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            om.c.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        s();
    }

    public final boolean containsAllEntries$kotlin_stdlib(@l Collection<?> collection) {
        l0.p(collection, p6.m.f13003a);
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@l Map.Entry<? extends K, ? extends V> entry) {
        l0.p(entry, "entry");
        int iH = h(entry.getKey());
        if (iH < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        l0.m(vArr);
        return l0.g(vArr[iH], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final boolean e(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    @l
    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@m Object obj) {
        return obj == this || ((obj instanceof Map) && e((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @m
    public V get(Object obj) {
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        l0.m(vArr);
        return vArr[iH];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    @l
    public Set<Map.Entry<K, V>> getEntries() {
        om.e<K, V> eVar = this.entriesView;
        if (eVar != null) {
            return eVar;
        }
        om.e<K, V> eVar2 = new om.e<>(this);
        this.entriesView = eVar2;
        return eVar2;
    }

    @l
    public Set<K> getKeys() {
        om.f<K> fVar = this.keysView;
        if (fVar != null) {
            return fVar;
        }
        om.f<K> fVar2 = new om.f<>(this);
        this.keysView = fVar2;
        return fVar2;
    }

    public int getSize() {
        return this.size;
    }

    @l
    public Collection<V> getValues() {
        g<V> gVar = this.valuesView;
        if (gVar != null) {
            return gVar;
        }
        g<V> gVar2 = new g<>(this);
        this.valuesView = gVar2;
        return gVar2;
    }

    public final int h(K k10) {
        int iL = l(k10);
        int i10 = this.maxProbeDistance;
        while (true) {
            int i11 = this.hashArray[iL];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (l0.g(this.keysArray[i12], k10)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            iL = iL == 0 ? this.hashArray.length - 1 : iL - 1;
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iM = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            iM += bVarEntriesIterator$kotlin_stdlib.m();
        }
        return iM;
    }

    public final int i(V v10) {
        int i10 = this.length;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.presenceArray[i10] >= 0) {
                V[] vArr = this.valuesArray;
                l0.m(vArr);
                if (l0.g(vArr[i10], v10)) {
                    return i10;
                }
            }
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public final int j() {
        return this.hashArray.length;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @l
    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    public final int l(K k10) {
        return ((k10 != null ? k10.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    public final boolean m(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        g(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (q(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Map
    @m
    public V put(K k10, V v10) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(k10);
        V[] vArrA = a();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrA[iAddKey$kotlin_stdlib] = v10;
            return null;
        }
        int i10 = (-iAddKey$kotlin_stdlib) - 1;
        V v11 = vArrA[i10];
        vArrA[i10] = v10;
        return v11;
    }

    @Override // java.util.Map
    public void putAll(@l Map<? extends K, ? extends V> map) {
        l0.p(map, TypedValues.TransitionType.S_FROM);
        checkIsMutable$kotlin_stdlib();
        m(map.entrySet());
    }

    public final boolean q(Map.Entry<? extends K, ? extends V> entry) {
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] vArrA = a();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrA[iAddKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i10 = (-iAddKey$kotlin_stdlib) - 1;
        if (l0.g(entry.getValue(), vArrA[i10])) {
            return false;
        }
        vArrA[i10] = entry.getValue();
        return true;
    }

    public final boolean r(int i10) {
        int iL = l(this.keysArray[i10]);
        int i11 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[iL] == 0) {
                iArr[iL] = i10 + 1;
                this.presenceArray[i10] = iL;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            iL = iL == 0 ? iArr.length - 1 : iL - 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @m
    public V remove(Object obj) {
        int iRemoveKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (iRemoveKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        l0.m(vArr);
        V v10 = vArr[iRemoveKey$kotlin_stdlib];
        om.c.f(vArr, iRemoveKey$kotlin_stdlib);
        return v10;
    }

    public final boolean removeEntry$kotlin_stdlib(@l Map.Entry<? extends K, ? extends V> entry) {
        l0.p(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iH = h(entry.getKey());
        if (iH < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        l0.m(vArr);
        if (!l0.g(vArr[iH], entry.getValue())) {
            return false;
        }
        v(iH);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k10) {
        checkIsMutable$kotlin_stdlib();
        int iH = h(k10);
        if (iH < 0) {
            return -1;
        }
        v(iH);
        return iH;
    }

    public final boolean removeValue$kotlin_stdlib(V v10) {
        checkIsMutable$kotlin_stdlib();
        int i10 = i(v10);
        if (i10 < 0) {
            return false;
        }
        v(i10);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public final void t(int i10) {
        s();
        if (this.length > size()) {
            c();
        }
        int[] iArr = this.hashArray;
        int i11 = 0;
        if (i10 != iArr.length) {
            this.hashArray = new int[i10];
            this.hashShift = Companion.d(i10);
        } else {
            p.K1(iArr, 0, 0, iArr.length);
        }
        while (i11 < this.length) {
            int i12 = i11 + 1;
            if (!r(i11)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i11 = i12;
        }
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i10 = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            bVarEntriesIterator$kotlin_stdlib.l(sb2);
            i10++;
        }
        sb2.append("}");
        String string = sb2.toString();
        l0.o(string, "toString(...)");
        return string;
    }

    public final void u(int i10) {
        int i11 = this.maxProbeDistance * 2;
        int length = this.hashArray.length / 2;
        if (i11 > length) {
            i11 = length;
        }
        int i12 = i11;
        int i13 = 0;
        int i14 = i10;
        do {
            i10 = i10 == 0 ? this.hashArray.length - 1 : i10 - 1;
            i13++;
            if (i13 > this.maxProbeDistance) {
                this.hashArray[i14] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i15 = iArr[i10];
            if (i15 == 0) {
                iArr[i14] = 0;
                return;
            }
            if (i15 < 0) {
                iArr[i14] = -1;
            } else {
                int i16 = i15 - 1;
                int iL = l(this.keysArray[i16]) - i10;
                int[] iArr2 = this.hashArray;
                if ((iL & (iArr2.length - 1)) >= i13) {
                    iArr2[i14] = i15;
                    this.presenceArray[i16] = i14;
                }
                i12--;
            }
            i14 = i10;
            i13 = 0;
            i12--;
        } while (i12 >= 0);
        this.hashArray[i14] = -1;
    }

    public final void v(int i10) {
        om.c.f(this.keysArray, i10);
        u(this.presenceArray[i10]);
        this.presenceArray[i10] = -1;
        this.size = size() - 1;
        s();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @l
    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public final boolean w(int i10) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i11 = this.length;
        int i12 = capacity$kotlin_stdlib - i11;
        int size = i11 - size();
        return i12 < i10 && i12 + size >= i10 && size >= getCapacity$kotlin_stdlib() / 4;
    }

    public d() {
        this(8);
    }

    public d(int i10) {
        this(om.c.d(i10), null, new int[i10], new int[Companion.c(i10)], 2, 0);
    }
}
