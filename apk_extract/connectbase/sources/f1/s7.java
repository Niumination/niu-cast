package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public class s7<K, V> extends n<K, V> {

    @b1.c
    @b1.d
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient Comparator<? super K> f5287i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public transient Comparator<? super V> f5288n;

    public s7(Comparator<? super K> keyComparator, Comparator<? super V> valueComparator) {
        super(new TreeMap(keyComparator));
        this.f5287i = keyComparator;
        this.f5288n = valueComparator;
    }

    public static <K extends Comparable, V extends Comparable> s7<K, V> create() {
        return new s7<>(l5.natural(), l5.natural());
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        Comparator<? super K> comparator = (Comparator) stream.readObject();
        comparator.getClass();
        this.f5287i = comparator;
        Comparator<? super V> comparator2 = (Comparator) stream.readObject();
        comparator2.getClass();
        this.f5288n = comparator2;
        setMap(new TreeMap(this.f5287i));
        i6.d(this, stream);
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(keyComparator());
        stream.writeObject(valueComparator());
        i6.j(this, stream);
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

    @Override // f1.e, f1.h
    public Map<K, Collection<V>> createAsMap() {
        return createMaybeNavigableAsMap();
    }

    @Override // f1.m, f1.e, f1.h, f1.v4
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // f1.m, f1.h, f1.v4, f1.o4
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object object) {
        return super.equals(object);
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Deprecated
    public Comparator<? super K> keyComparator() {
        return this.f5287i;
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

    @Override // f1.p, f1.m, f1.e, f1.v4, f1.o4
    @t1.a
    public /* bridge */ /* synthetic */ SortedSet removeAll(@gm.a Object key) {
        return super.removeAll(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.p, f1.m, f1.e, f1.h, f1.v4, f1.o4
    @t1.a
    public /* bridge */ /* synthetic */ SortedSet replaceValues(@m5 Object key, Iterable values) {
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

    @Override // f1.u6
    public Comparator<? super V> valueComparator() {
        return this.f5288n;
    }

    @Override // f1.p, f1.e, f1.h, f1.v4
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <K, V> s7<K, V> create(Comparator<? super K> keyComparator, Comparator<? super V> valueComparator) {
        keyComparator.getClass();
        valueComparator.getClass();
        return new s7<>(keyComparator, valueComparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean putAll(@m5 Object key, Iterable values) {
        return super.putAll(key, values);
    }

    @Override // f1.n, f1.p, f1.m, f1.h, f1.v4, f1.j6
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) super.asMap();
    }

    @Override // f1.p, f1.m, f1.e
    public SortedSet<V> createCollection() {
        return new TreeSet(this.f5288n);
    }

    @Override // f1.n, f1.h, f1.v4
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    public s7(Comparator<? super K> keyComparator, Comparator<? super V> valueComparator, v4<? extends K, ? extends V> multimap) {
        this(keyComparator, valueComparator);
        putAll(multimap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.e
    public Collection<V> createCollection(@m5 K key) {
        if (key == 0) {
            keyComparator().compare(key, key);
        }
        return super.createCollection(key);
    }

    @Override // f1.p, f1.m, f1.e, f1.v4, f1.o4
    @b1.c
    public NavigableSet<V> get(@m5 K key) {
        return (NavigableSet) super.get((Object) key);
    }

    public static <K extends Comparable, V extends Comparable> s7<K, V> create(v4<? extends K, ? extends V> multimap) {
        return new s7<>(l5.natural(), l5.natural(), multimap);
    }
}
