package io.netty.util.collection;

import fl.h;
import io.netty.util.internal.MathUtil;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import rs.f;

/* JADX INFO: loaded from: classes3.dex */
public class CharObjectHashMap<V> implements CharObjectMap<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE = new Object();
    private final Iterable<CharObjectMap.PrimitiveEntry<V>> entries;
    private final Set<Map.Entry<Character, V>> entrySet;
    private final Set<Character> keySet;
    private char[] keys;
    private final float loadFactor;
    private int mask;
    private int maxSize;
    private int size;
    private V[] values;

    public final class EntrySet extends AbstractSet<Map.Entry<Character, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Character, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CharObjectHashMap.this.size();
        }
    }

    public final class KeySet extends AbstractSet<Character> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CharObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CharObjectHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Character> iterator() {
            return new Iterator<Character>() { // from class: io.netty.util.collection.CharObjectHashMap.KeySet.1
                private final Iterator<Map.Entry<Character, V>> iter;

                {
                    this.iter = CharObjectHashMap.this.entrySet.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.iter.remove();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Character next() {
                    return this.iter.next().getKey();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return CharObjectHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Iterator<CharObjectMap.PrimitiveEntry<V>> it = CharObjectHashMap.this.entries().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                if (!collection.contains(Character.valueOf(it.next().key()))) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CharObjectHashMap.this.size();
        }
    }

    public final class MapEntry implements Map.Entry<Character, V> {
        private final int entryIndex;

        public MapEntry(int i10) {
            this.entryIndex = i10;
        }

        private void verifyExists() {
            if (CharObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            verifyExists();
            return (V) CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            verifyExists();
            V v11 = (V) CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
            CharObjectHashMap.this.values[this.entryIndex] = CharObjectHashMap.toInternal(v10);
            return v11;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public Character getKey() {
            verifyExists();
            return Character.valueOf(CharObjectHashMap.this.keys[this.entryIndex]);
        }
    }

    public final class MapIterator implements Iterator<Map.Entry<Character, V>> {
        private final CharObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<Character, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.iter.next();
            return new MapEntry(((PrimitiveIterator) this.iter).entryIndex);
        }
    }

    public final class PrimitiveIterator implements Iterator<CharObjectMap.PrimitiveEntry<V>>, CharObjectMap.PrimitiveEntry<V> {
        private int entryIndex;
        private int nextIndex;
        private int prevIndex;

        private PrimitiveIterator() {
            this.prevIndex = -1;
            this.nextIndex = -1;
            this.entryIndex = -1;
        }

        private void scanNext() {
            do {
                int i10 = this.nextIndex + 1;
                this.nextIndex = i10;
                if (i10 == CharObjectHashMap.this.values.length) {
                    return;
                }
            } while (CharObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != CharObjectHashMap.this.values.length;
        }

        @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
        public char key() {
            return CharObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i10 = this.prevIndex;
            if (i10 == -1) {
                throw new IllegalStateException("next must be called before each remove.");
            }
            if (CharObjectHashMap.this.removeAt(i10)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
        public void setValue(V v10) {
            CharObjectHashMap.this.values[this.entryIndex] = CharObjectHashMap.toInternal(v10);
        }

        @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
        public V value() {
            return (V) CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Iterator
        public CharObjectMap.PrimitiveEntry<V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.prevIndex = this.nextIndex;
            scanNext();
            this.entryIndex = this.prevIndex;
            return this;
        }
    }

    public CharObjectHashMap() {
        this(8, 0.5f);
    }

    private int calcMaxSize(int i10) {
        return Math.min(i10 - 1, (int) (i10 * this.loadFactor));
    }

    private void growSize() {
        int i10 = this.size + 1;
        this.size = i10;
        if (i10 > this.maxSize) {
            char[] cArr = this.keys;
            if (cArr.length != Integer.MAX_VALUE) {
                rehash(cArr.length << 1);
            } else {
                throw new IllegalStateException("Max capacity reached at size=" + this.size);
            }
        }
    }

    private static int hashCode(char c10) {
        return c10;
    }

    private int hashIndex(char c10) {
        return this.mask & hashCode(c10);
    }

    private int indexOf(char c10) {
        int iHashIndex = hashIndex(c10);
        int iProbeNext = iHashIndex;
        while (this.values[iProbeNext] != null) {
            if (c10 == this.keys[iProbeNext]) {
                return iProbeNext;
            }
            iProbeNext = probeNext(iProbeNext);
            if (iProbeNext == iHashIndex) {
                return -1;
            }
        }
        return -1;
    }

    private char objectToKey(Object obj) {
        return ((Character) obj).charValue();
    }

    private int probeNext(int i10) {
        return this.mask & (i10 + 1);
    }

    private void rehash(int i10) {
        V[] vArr;
        char[] cArr = this.keys;
        V[] vArr2 = this.values;
        this.keys = new char[i10];
        this.values = (V[]) new Object[i10];
        this.maxSize = calcMaxSize(i10);
        this.mask = i10 - 1;
        for (int i11 = 0; i11 < vArr2.length; i11++) {
            V v10 = vArr2[i11];
            if (v10 != null) {
                char c10 = cArr[i11];
                int iHashIndex = hashIndex(c10);
                while (true) {
                    vArr = this.values;
                    if (vArr[iHashIndex] == null) {
                        break;
                    } else {
                        iHashIndex = probeNext(iHashIndex);
                    }
                }
                this.keys[iHashIndex] = c10;
                vArr[iHashIndex] = v10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeAt(int i10) {
        this.size--;
        this.keys[i10] = 0;
        this.values[i10] = null;
        int iProbeNext = probeNext(i10);
        V v10 = this.values[iProbeNext];
        int i11 = i10;
        while (v10 != null) {
            char c10 = this.keys[iProbeNext];
            int iHashIndex = hashIndex(c10);
            if ((iProbeNext < iHashIndex && (iHashIndex <= i11 || i11 <= iProbeNext)) || (iHashIndex <= i11 && i11 <= iProbeNext)) {
                char[] cArr = this.keys;
                cArr[i11] = c10;
                V[] vArr = this.values;
                vArr[i11] = v10;
                cArr[iProbeNext] = 0;
                vArr[iProbeNext] = null;
                i11 = iProbeNext;
            }
            V[] vArr2 = this.values;
            iProbeNext = probeNext(iProbeNext);
            v10 = vArr2[iProbeNext];
        }
        return i11 != i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toExternal(T t10) {
        if (t10 == NULL_VALUE) {
            return null;
        }
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toInternal(T t10) {
        return t10 == null ? (T) NULL_VALUE : t10;
    }

    @Override // java.util.Map
    public void clear() {
        Arrays.fill(this.keys, (char) 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // io.netty.util.collection.CharObjectMap
    public boolean containsKey(char c10) {
        return indexOf(c10) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Object internal = toInternal(obj);
        for (V v10 : this.values) {
            if (v10 != null && v10.equals(internal)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.netty.util.collection.CharObjectMap
    public Iterable<CharObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Character, V>> entrySet() {
        return this.entrySet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharObjectMap)) {
            return false;
        }
        CharObjectMap charObjectMap = (CharObjectMap) obj;
        if (this.size != charObjectMap.size()) {
            return false;
        }
        int i10 = 0;
        while (true) {
            V[] vArr = this.values;
            if (i10 >= vArr.length) {
                return true;
            }
            V v10 = vArr[i10];
            if (v10 != null) {
                Object obj2 = charObjectMap.get(this.keys[i10]);
                if (v10 == NULL_VALUE) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (!v10.equals(obj2)) {
                    return false;
                }
            }
            i10++;
        }
    }

    @Override // io.netty.util.collection.CharObjectMap
    public V get(char c10) {
        int iIndexOf = indexOf(c10);
        if (iIndexOf == -1) {
            return null;
        }
        return (V) toExternal(this.values[iIndexOf]);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public Set<Character> keySet() {
        return this.keySet;
    }

    public String keyToString(char c10) {
        return Character.toString(c10);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Character, ? extends V> map) {
        if (!(map instanceof CharObjectHashMap)) {
            for (Map.Entry<? extends Character, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), (Object) entry.getValue());
            }
            return;
        }
        CharObjectHashMap charObjectHashMap = (CharObjectHashMap) map;
        int i10 = 0;
        while (true) {
            V[] vArr = charObjectHashMap.values;
            if (i10 >= vArr.length) {
                return;
            }
            V v10 = vArr[i10];
            if (v10 != null) {
                put(charObjectHashMap.keys[i10], v10);
            }
            i10++;
        }
    }

    @Override // io.netty.util.collection.CharObjectMap
    public V remove(char c10) {
        int iIndexOf = indexOf(c10);
        if (iIndexOf == -1) {
            return null;
        }
        V v10 = this.values[iIndexOf];
        removeAt(iIndexOf);
        return (V) toExternal(v10);
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.size * 4);
        sb2.append(f.f14859a);
        boolean z10 = true;
        int i10 = 0;
        while (true) {
            V[] vArr = this.values;
            if (i10 >= vArr.length) {
                sb2.append(f.f14860b);
                return sb2.toString();
            }
            V v10 = vArr[i10];
            if (v10 != null) {
                if (!z10) {
                    sb2.append(", ");
                }
                sb2.append(keyToString(this.keys[i10]));
                sb2.append(h.f6043c);
                sb2.append(v10 == this ? "(this Map)" : toExternal(v10));
                z10 = false;
            }
            i10++;
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new AbstractCollection<V>() { // from class: io.netty.util.collection.CharObjectHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: io.netty.util.collection.CharObjectHashMap.2.1
                    final CharObjectHashMap<V>.PrimitiveIterator iter;

                    {
                        this.iter = new PrimitiveIterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.iter.next().value();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.iter.remove();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return CharObjectHashMap.this.size;
            }
        };
    }

    public CharObjectHashMap(int i10) {
        this(i10, 0.5f);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return containsKey(objectToKey(obj));
    }

    @Override // java.util.Map
    public int hashCode() {
        int iHashCode = this.size;
        for (char c10 : this.keys) {
            iHashCode ^= hashCode(c10);
        }
        return iHashCode;
    }

    @Override // io.netty.util.collection.CharObjectMap
    public V put(char c10, V v10) {
        int iHashIndex = hashIndex(c10);
        int iProbeNext = iHashIndex;
        do {
            Object[] objArr = this.values;
            Object obj = objArr[iProbeNext];
            if (obj == null) {
                this.keys[iProbeNext] = c10;
                objArr[iProbeNext] = toInternal(v10);
                growSize();
                return null;
            }
            if (this.keys[iProbeNext] == c10) {
                objArr[iProbeNext] = toInternal(v10);
                return (V) toExternal(obj);
            }
            iProbeNext = probeNext(iProbeNext);
        } while (iProbeNext != iHashIndex);
        throw new IllegalStateException("Unable to insert");
    }

    public CharObjectHashMap(int i10, float f10) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<CharObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.CharObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (f10 > 0.0f && f10 <= 1.0f) {
            this.loadFactor = f10;
            int iSafeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i10);
            this.mask = iSafeFindNextPositivePowerOfTwo - 1;
            this.keys = new char[iSafeFindNextPositivePowerOfTwo];
            this.values = (V[]) new Object[iSafeFindNextPositivePowerOfTwo];
            this.maxSize = calcMaxSize(iSafeFindNextPositivePowerOfTwo);
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return get(objectToKey(obj));
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return remove(objectToKey(obj));
    }

    @Override // java.util.Map
    public V put(Character ch2, V v10) {
        return put(objectToKey(ch2), v10);
    }
}
