package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class w2<K, V> extends x2<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5516i = 2;

    @b1.c
    @b1.d
    private static final long serialVersionUID = 0;

    @b1.e
    transient int expectedValuesPerKey;

    public w2(int expectedKeys, int expectedValuesPerKey) {
        super(d0.createWithExpectedSize(expectedKeys));
        this.expectedValuesPerKey = 2;
        c1.h0.d(expectedValuesPerKey >= 0);
        this.expectedValuesPerKey = expectedValuesPerKey;
    }

    public static <K, V> w2<K, V> create() {
        return new w2<>();
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int i10 = stream.readInt();
        setMap(d0.createWithExpectedSize(12));
        i6.e(this, stream, i10);
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        i6.j(this, stream);
    }

    @Override // f1.m, f1.h, f1.v4, f1.j6
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // f1.e, f1.v4
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean containsEntry(@gm.a Object key, @gm.a Object value) {
        return super.containsEntry(key, value);
    }

    @Override // f1.e, f1.v4
    public /* bridge */ /* synthetic */ boolean containsKey(@gm.a Object key) {
        return super.containsKey(key);
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean containsValue(@gm.a Object value) {
        return super.containsValue(value);
    }

    @Override // f1.m, f1.e, f1.h, f1.v4
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // f1.m, f1.h, f1.v4, f1.o4
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object object) {
        return super.equals(object);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.m, f1.e, f1.v4, f1.o4
    public /* bridge */ /* synthetic */ Set get(@m5 Object key) {
        return super.get(key);
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ b5 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.m, f1.e, f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean put(@m5 Object key, @m5 Object value) {
        return super.put(key, value);
    }

    @Override // f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean putAll(v4 multimap) {
        return super.putAll(multimap);
    }

    @Override // f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean remove(@gm.a Object key, @gm.a Object value) {
        return super.remove(key, value);
    }

    @Override // f1.m, f1.e, f1.v4, f1.o4
    @t1.a
    public /* bridge */ /* synthetic */ Set removeAll(@gm.a Object key) {
        return super.removeAll(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.m, f1.e, f1.h, f1.v4, f1.o4
    @t1.a
    public /* bridge */ /* synthetic */ Set replaceValues(@m5 Object key, Iterable values) {
        return super.replaceValues(key, values);
    }

    @Override // f1.e, f1.v4
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // f1.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // f1.e, f1.h, f1.v4
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <K, V> w2<K, V> create(int expectedKeys, int expectedValuesPerKey) {
        return new w2<>(expectedKeys, expectedValuesPerKey);
    }

    @Override // f1.m, f1.e
    public Set<V> createCollection() {
        return e0.createWithExpectedSize(this.expectedValuesPerKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean putAll(@m5 Object key, Iterable values) {
        return super.putAll(key, values);
    }

    public static <K, V> w2<K, V> create(v4<? extends K, ? extends V> multimap) {
        return new w2<>(multimap);
    }

    public w2() {
        this(12, 2);
    }

    public w2(v4<? extends K, ? extends V> multimap) {
        super(d0.createWithExpectedSize(multimap.keySet().size()));
        this.expectedValuesPerKey = 2;
        putAll(multimap);
    }
}
