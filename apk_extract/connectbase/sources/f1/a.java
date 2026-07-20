package f1;

import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class a<K, V> extends d2<K, V> implements w<K, V>, Serializable {

    @b1.c
    @b1.d
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Map<K, V> f4686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<K> f4687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<V> f4688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<Map.Entry<K, V>> f4689d;

    @RetainedWith
    transient a<V, K> inverse;

    /* JADX INFO: renamed from: f1.a$a, reason: collision with other inner class name */
    public class C0109a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public Map.Entry<K, V> f4690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f4691b;

        public C0109a(final Iterator val$iterator) {
            this.f4691b = val$iterator;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f4691b.next();
            this.f4690a = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4691b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry<K, V> entry = this.f4690a;
            if (entry == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            V value = entry.getValue();
            this.f4691b.remove();
            a.this.q(value);
            this.f4690a = null;
        }
    }

    public class b extends e2<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map.Entry<K, V> f4693a;

        public b(Map.Entry<K, V> delegate) {
            this.f4693a = delegate;
        }

        @Override // f1.e2, f1.j2
        /* JADX INFO: renamed from: l */
        public Map.Entry<K, V> delegate() {
            return this.f4693a;
        }

        @Override // f1.e2, java.util.Map.Entry
        public V setValue(V value) {
            a.this.checkValue(value);
            c1.h0.h0(a.this.entrySet().contains(this), "entry no longer in map");
            if (c1.b0.a(value, getValue())) {
                return value;
            }
            c1.h0.u(!a.this.containsValue(value), "value already present: %s", value);
            V value2 = this.f4693a.setValue(value);
            c1.h0.h0(c1.b0.a(value, a.this.get(getKey())), "entry no longer in map");
            a.this.r(getKey(), true, value2, value);
            return value2;
        }
    }

    public class c extends l2<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f4695a;

        public c() {
            this.f4695a = a.this.f4686a.entrySet();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public void clear() {
            a.this.clear();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            return t4.p(delegate(), o10);
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c10) {
            return standardContainsAll(c10);
        }

        @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return a.this.entrySetIterator();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object object) {
            if (!this.f4695a.contains(object) || !(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) object;
            a.this.inverse.f4686a.remove(entry.getValue());
            this.f4695a.remove(entry);
            return true;
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c10) {
            return standardRemoveAll(c10);
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c10) {
            return standardRetainAll(c10);
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ c(a aVar, C0109a c0109a) {
            this();
        }

        @Override // f1.l2, f1.s1, f1.j2
        public Set<Map.Entry<K, V>> delegate() {
            return this.f4695a;
        }
    }

    public static class d<K, V> extends a<K, V> {

        @b1.c
        @b1.d
        private static final long serialVersionUID = 0;

        public d(Map<K, V> backward, a<V, K> forward) {
            super(backward, forward, null);
        }

        @b1.c
        @b1.d
        private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
            stream.defaultReadObject();
            Object object = stream.readObject();
            Objects.requireNonNull(object);
            setInverse((a) object);
        }

        @b1.c
        @b1.d
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(inverse());
        }

        @Override // f1.a
        @m5
        public K checkKey(@m5 K key) {
            return this.inverse.checkValue(key);
        }

        @Override // f1.a
        @m5
        public V checkValue(@m5 V value) {
            return this.inverse.checkKey(value);
        }

        @Override // f1.a, f1.d2, f1.j2
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        @b1.c
        @b1.d
        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // f1.a, f1.d2, java.util.Map, f1.w
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public class e extends l2<K> {
        public e() {
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public void clear() {
            a.this.clear();
        }

        @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new t4.e(a.this.entrySet().iterator());
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object key) {
            if (!contains(key)) {
                return false;
            }
            a.this.m(key);
            return true;
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> keysToRemove) {
            return standardRemoveAll(keysToRemove);
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> keysToRetain) {
            return standardRetainAll(keysToRetain);
        }

        public /* synthetic */ e(a aVar, C0109a c0109a) {
            this();
        }

        @Override // f1.l2, f1.s1, f1.j2
        public Set<K> delegate() {
            return a.this.f4686a.keySet();
        }
    }

    public class f extends l2<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<V> f4698a;

        public f() {
            this.f4698a = a.this.inverse.keySet();
        }

        @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new t4.f(a.this.entrySet().iterator());
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // f1.j2
        public String toString() {
            return standardToString();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ f(a aVar, C0109a c0109a) {
            this();
        }

        @Override // f1.l2, f1.s1, f1.j2
        public Set<V> delegate() {
            return this.f4698a;
        }
    }

    public /* synthetic */ a(Map map, a aVar, C0109a c0109a) {
        this(map, aVar);
    }

    @t1.a
    @m5
    public K checkKey(@m5 K key) {
        return key;
    }

    @t1.a
    @m5
    public V checkValue(@m5 V value) {
        return value;
    }

    @Override // f1.d2, java.util.Map
    public void clear() {
        this.f4686a.clear();
        this.inverse.f4686a.clear();
    }

    @Override // f1.d2, java.util.Map
    public boolean containsValue(@gm.a Object value) {
        return this.inverse.containsKey(value);
    }

    @Override // f1.d2, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f4689d;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.f4689d = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new C0109a(this.f4686a.entrySet().iterator());
    }

    @Override // f1.w
    @gm.a
    @t1.a
    public V forcePut(@m5 K key, @m5 V value) {
        return l(key, value, true);
    }

    @Override // f1.w
    public w<V, K> inverse() {
        return this.inverse;
    }

    @Override // f1.d2, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f4687b;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.f4687b = eVar;
        return eVar;
    }

    @gm.a
    public final V l(@m5 K key, @m5 V value, boolean force) {
        checkKey(key);
        checkValue(value);
        boolean zContainsKey = containsKey(key);
        if (zContainsKey && c1.b0.a(value, get(key))) {
            return value;
        }
        if (force) {
            inverse().remove(value);
        } else {
            c1.h0.u(!containsValue(value), "value already present: %s", value);
        }
        V vPut = this.f4686a.put(key, value);
        r(key, zContainsKey, vPut, value);
        return vPut;
    }

    @t1.a
    @m5
    public final V m(@gm.a Object key) {
        V vRemove = this.f4686a.remove(key);
        q(vRemove);
        return vRemove;
    }

    public a<V, K> makeInverse(Map<V, K> backward) {
        return new d(backward, this);
    }

    @Override // f1.d2, java.util.Map, f1.w
    @gm.a
    @t1.a
    public V put(@m5 K key, @m5 V value) {
        return l(key, value, false);
    }

    @Override // f1.d2, java.util.Map, f1.w
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final void q(@m5 V oldValue) {
        this.inverse.f4686a.remove(oldValue);
    }

    public final void r(@m5 K key, boolean containedKey, @gm.a V oldValue, @m5 V newValue) {
        if (containedKey) {
            q(oldValue);
        }
        this.inverse.f4686a.put(newValue, key);
    }

    @Override // f1.d2, java.util.Map
    @gm.a
    @t1.a
    public V remove(@gm.a Object key) {
        if (containsKey(key)) {
            return m(key);
        }
        return null;
    }

    public void setDelegates(Map<K, V> forward, Map<V, K> backward) {
        c1.h0.g0(this.f4686a == null);
        c1.h0.g0(this.inverse == null);
        c1.h0.d(forward.isEmpty());
        c1.h0.d(backward.isEmpty());
        c1.h0.d(forward != backward);
        this.f4686a = forward;
        this.inverse = makeInverse(backward);
    }

    public void setInverse(a<V, K> inverse) {
        this.inverse = inverse;
    }

    public a(Map<K, V> forward, Map<V, K> backward) {
        setDelegates(forward, backward);
    }

    @Override // f1.d2, f1.j2
    public Map<K, V> delegate() {
        return this.f4686a;
    }

    @Override // f1.d2, java.util.Map, f1.w
    public Set<V> values() {
        Set<V> set = this.f4688c;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.f4688c = fVar;
        return fVar;
    }

    public a(Map<K, V> backward, a<V, K> forward) {
        this.f4686a = backward;
        this.inverse = forward;
    }
}
