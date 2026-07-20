package f1;

import com.google.j2objc.annotations.Weak;
import f1.s4.j;
import f1.s4.o;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
public class s4<K, V, E extends j<K, V, E>, S extends o<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final h0<Object, Object, f> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient k<K, V, E, S> entryHelper;

    @u1.b
    @gm.a
    transient Set<Map.Entry<K, V>> entrySet;
    final c1.m<Object> keyEquivalence;

    @u1.b
    @gm.a
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient o<K, V, E, S>[] segments;

    @u1.b
    @gm.a
    transient Collection<V> values;

    public class a implements h0<Object, Object, f> {
        @Override // f1.s4.h0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public h0<Object, Object, f> b(ReferenceQueue<Object> queue, f entry) {
            return this;
        }

        @Override // f1.s4.h0
        public void clear() {
        }

        @Override // f1.s4.h0
        @gm.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public f a() {
            return null;
        }

        @Override // f1.s4.h0
        @gm.a
        public Object get() {
            return null;
        }
    }

    public static class a0<K> extends d<K, r4.a, a0<K>> implements x<K, r4.a, a0<K>> {

        public static final class a<K> implements k<K, r4.a, a0<K>, b0<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?> f5251a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f5251a;
            }

            @Override // f1.s4.k
            public q a() {
                return q.STRONG;
            }

            @Override // f1.s4.k
            public void c(o segment, j entry, r4.a value) {
            }

            @Override // f1.s4.k
            public q d() {
                return q.WEAK;
            }

            @Override // f1.s4.k
            public o e(s4 map, int initialCapacity) {
                return new b0(map, initialCapacity);
            }

            @Override // f1.s4.k
            @gm.a
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public a0<K> b(b0<K> segment, a0<K> entry, @gm.a a0<K> newNext) {
                K k10 = entry.get();
                if (k10 == null) {
                    return null;
                }
                return f(segment, k10, entry.f5258a, newNext);
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public a0<K> f(b0<K> segment, K key, int hash, @gm.a a0<K> next) {
                return next == null ? new a0<>(((b0) segment).queueForKeys, key, hash) : new b(((b0) segment).queueForKeys, key, hash, next);
            }

            public b0<K> j(s4<K, r4.a, a0<K>, b0<K>> map, int initialCapacity) {
                return new b0<>(map, initialCapacity);
            }

            public void k(b0<K> segment, a0<K> entry, r4.a value) {
            }
        }

        public a0(ReferenceQueue<K> queue, K key, int hash) {
            super(queue, key, hash);
        }

        public final r4.a a() {
            return r4.a.VALUE;
        }

        @Override // f1.s4.j
        public Object getValue() {
            return r4.a.VALUE;
        }

        public static final class b<K> extends a0<K> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final a0<K> f5252b;

            public b(ReferenceQueue<K> queue, K key, int hash, a0<K> next) {
                super(queue, key, hash);
                this.f5252b = next;
            }

            public a0<K> b() {
                return this.f5252b;
            }

            @Override // f1.s4.d, f1.s4.j
            public j getNext() {
                return this.f5252b;
            }

            @Override // f1.s4.a0, f1.s4.j
            public Object getValue() {
                return r4.a.VALUE;
            }

            public /* synthetic */ b(ReferenceQueue referenceQueue, Object obj, int i10, a0 a0Var, a aVar) {
                this(referenceQueue, obj, i10, a0Var);
            }
        }

        public a0(ReferenceQueue referenceQueue, Object obj, int i10, a aVar) {
            super(referenceQueue, obj, i10);
        }
    }

    public static final class b0<K> extends o<K, r4.a, a0<K>, b0<K>> {
        private final ReferenceQueue<K> queueForKeys;

        public b0(s4<K, r4.a, a0<K>, b0<K>> map, int initialCapacity) {
            super(map, initialCapacity);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // f1.s4.o
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // f1.s4.o
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // f1.s4.o
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // f1.s4.o
        public a0<K> castForTesting(j<K, r4.a, ?> entry) {
            return (a0) entry;
        }

        @Override // f1.s4.o
        public b0<K> self() {
            return this;
        }
    }

    public static abstract class c<K, V, E extends j<K, V, E>> implements j<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f5253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5254b;

        public c(K key, int hash) {
            this.f5253a = key;
            this.f5254b = hash;
        }

        @Override // f1.s4.j
        public final int getHash() {
            return this.f5254b;
        }

        @Override // f1.s4.j
        public final K getKey() {
            return this.f5253a;
        }

        @Override // f1.s4.j
        @gm.a
        public E getNext() {
            return null;
        }
    }

    public static class c0<K, V> extends d<K, V, c0<K, V>> implements x<K, V, c0<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public volatile V f5255b;

        public static final class a<K, V> implements k<K, V, c0<K, V>, d0<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f5256a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f5256a;
            }

            @Override // f1.s4.k
            public q a() {
                return q.STRONG;
            }

            @Override // f1.s4.k
            public void c(o segment, j entry, Object value) {
                ((c0) entry).f5255b = value;
            }

            @Override // f1.s4.k
            public q d() {
                return q.WEAK;
            }

            @Override // f1.s4.k
            public o e(s4 map, int initialCapacity) {
                return new d0(map, initialCapacity);
            }

            @Override // f1.s4.k
            @gm.a
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public c0<K, V> b(d0<K, V> d0Var, c0<K, V> c0Var, @gm.a c0<K, V> c0Var2) {
                K k10 = c0Var.get();
                if (k10 == null) {
                    return null;
                }
                c0<K, V> c0VarF = f(d0Var, k10, c0Var.f5258a, c0Var2);
                c0VarF.f5255b = (V) c0Var.f5255b;
                return c0VarF;
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public c0<K, V> f(d0<K, V> segment, K key, int hash, @gm.a c0<K, V> next) {
                return next == null ? new c0<>(((d0) segment).queueForKeys, key, hash) : new b(((d0) segment).queueForKeys, key, hash, next);
            }

            public d0<K, V> j(s4<K, V, c0<K, V>, d0<K, V>> map, int initialCapacity) {
                return new d0<>(map, initialCapacity);
            }

            public void k(d0<K, V> segment, c0<K, V> entry, V value) {
                entry.f5255b = value;
            }
        }

        public /* synthetic */ c0(ReferenceQueue referenceQueue, Object obj, int i10, a aVar) {
            this(referenceQueue, obj, i10);
        }

        @Override // f1.s4.j
        @gm.a
        public final V getValue() {
            return this.f5255b;
        }

        public static final class b<K, V> extends c0<K, V> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final c0<K, V> f5257c;

            public b(ReferenceQueue<K> queue, K key, int hash, c0<K, V> next) {
                super(queue, key, hash);
                this.f5257c = next;
            }

            public c0<K, V> c() {
                return this.f5257c;
            }

            @Override // f1.s4.d, f1.s4.j
            public j getNext() {
                return this.f5257c;
            }

            public /* synthetic */ b(ReferenceQueue referenceQueue, Object obj, int i10, c0 c0Var, a aVar) {
                this(referenceQueue, obj, i10, c0Var);
            }
        }

        public c0(ReferenceQueue<K> queue, K key, int hash) {
            super(queue, key, hash);
            this.f5255b = null;
        }
    }

    public static abstract class d<K, V, E extends j<K, V, E>> extends WeakReference<K> implements j<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5258a;

        public d(ReferenceQueue<K> queue, K key, int hash) {
            super(key, queue);
            this.f5258a = hash;
        }

        @Override // f1.s4.j
        public final int getHash() {
            return this.f5258a;
        }

        @Override // f1.s4.j
        public final K getKey() {
            return get();
        }

        @gm.a
        public E getNext() {
            return null;
        }
    }

    public static final class d0<K, V> extends o<K, V, c0<K, V>, d0<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public d0(s4<K, V, c0<K, V>, d0<K, V>> map, int initialCapacity) {
            super(map, initialCapacity);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // f1.s4.o
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // f1.s4.o
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // f1.s4.o
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // f1.s4.o
        public c0<K, V> castForTesting(j<K, V, ?> entry) {
            return (c0) entry;
        }

        @Override // f1.s4.o
        public d0<K, V> self() {
            return this;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<s4<?, ?, ?, ?>> f5259a;

        public e(s4<?, ?, ?, ?> map) {
            this.f5259a = new WeakReference<>(map);
        }

        @Override // java.lang.Runnable
        public void run() {
            s4<?, ?, ?, ?> s4Var = this.f5259a.get();
            if (s4Var == null) {
                throw new CancellationException();
            }
            for (o<?, ?, E, S> oVar : s4Var.segments) {
                oVar.runCleanup();
            }
        }
    }

    public static class e0<K, V> extends d<K, V, e0<K, V>> implements g0<K, V, e0<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h0<K, V, e0<K, V>> f5260b;

        public static final class a<K, V> implements k<K, V, e0<K, V>, f0<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f5261a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f5261a;
            }

            @Override // f1.s4.k
            public q a() {
                return q.WEAK;
            }

            @Override // f1.s4.k
            public q d() {
                return q.WEAK;
            }

            @Override // f1.s4.k
            public o e(s4 map, int initialCapacity) {
                return new f0(map, initialCapacity);
            }

            @Override // f1.s4.k
            @gm.a
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public e0<K, V> b(f0<K, V> segment, e0<K, V> entry, @gm.a e0<K, V> newNext) {
                K k10 = entry.get();
                if (k10 == null || o.isCollected(entry)) {
                    return null;
                }
                e0<K, V> e0VarF = f(segment, k10, entry.f5258a, newNext);
                e0VarF.f5260b = entry.f5260b.b(((f0) segment).queueForValues, e0VarF);
                return e0VarF;
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public e0<K, V> f(f0<K, V> segment, K key, int hash, @gm.a e0<K, V> next) {
                return next == null ? new e0<>(((f0) segment).queueForKeys, key, hash) : new b(((f0) segment).queueForKeys, key, hash, next);
            }

            public f0<K, V> j(s4<K, V, e0<K, V>, f0<K, V>> map, int initialCapacity) {
                return new f0<>(map, initialCapacity);
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void c(f0<K, V> segment, e0<K, V> entry, V value) {
                h0 h0Var = entry.f5260b;
                entry.f5260b = new i0(((f0) segment).queueForValues, value, entry);
                h0Var.clear();
            }
        }

        public static final class b<K, V> extends e0<K, V> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final e0<K, V> f5262c;

            public b(ReferenceQueue<K> queue, K key, int hash, e0<K, V> next) {
                super(queue, key, hash);
                this.f5262c = next;
            }

            public e0<K, V> c() {
                return this.f5262c;
            }

            @Override // f1.s4.d, f1.s4.j
            public j getNext() {
                return this.f5262c;
            }
        }

        public e0(ReferenceQueue<K> queue, K key, int hash) {
            super(queue, key, hash);
            this.f5260b = s4.unsetWeakValueReference();
        }

        @Override // f1.s4.j
        public final V getValue() {
            return this.f5260b.get();
        }

        @Override // f1.s4.g0
        public final h0<K, V, e0<K, V>> getValueReference() {
            return this.f5260b;
        }
    }

    public static final class f implements j<Object, Object, f> {
        public f() {
            throw new AssertionError();
        }

        public f a() {
            throw new AssertionError();
        }

        @Override // f1.s4.j
        public int getHash() {
            throw new AssertionError();
        }

        @Override // f1.s4.j
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // f1.s4.j
        public j getNext() {
            throw new AssertionError();
        }

        @Override // f1.s4.j
        public Object getValue() {
            throw new AssertionError();
        }
    }

    public static final class f0<K, V> extends o<K, V, e0<K, V>, f0<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public f0(s4<K, V, e0<K, V>, f0<K, V>> map, int initialCapacity) {
            super(map, initialCapacity);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // f1.s4.o
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // f1.s4.o
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // f1.s4.o
        public h0<K, V, e0<K, V>> getWeakValueReferenceForTesting(j<K, V, ?> e10) {
            return castForTesting((j) e10).f5260b;
        }

        @Override // f1.s4.o
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // f1.s4.o
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // f1.s4.o
        public h0<K, V, e0<K, V>> newWeakValueReferenceForTesting(j<K, V, ?> e10, V value) {
            return new i0(this.queueForValues, value, castForTesting((j) e10));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.s4.o
        public void setWeakValueReferenceForTesting(j<K, V, ?> e10, h0<K, V, ? extends j<K, V, ?>> valueReference) {
            e0<K, V> e0VarCastForTesting = castForTesting((j) e10);
            h0 h0Var = e0VarCastForTesting.f5260b;
            e0VarCastForTesting.f5260b = valueReference;
            h0Var.clear();
        }

        @Override // f1.s4.o
        @gm.a
        public e0<K, V> castForTesting(@gm.a j<K, V, ?> entry) {
            return (e0) entry;
        }

        @Override // f1.s4.o
        public f0<K, V> self() {
            return this;
        }
    }

    public final class g extends s4<K, V, E, S>.i<Map.Entry<K, V>> {
        public g(final s4 this$0) {
            super();
        }

        public Map.Entry<K, V> f() {
            return c();
        }

        @Override // f1.s4.i, java.util.Iterator
        public Object next() {
            return c();
        }
    }

    public interface g0<K, V, E extends j<K, V, E>> extends j<K, V, E> {
        h0<K, V, E> getValueReference();
    }

    public final class h extends n<Map.Entry<K, V>> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            s4.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            Map.Entry entry;
            Object key;
            Object obj;
            return (o10 instanceof Map.Entry) && (key = (entry = (Map.Entry) o10).getKey()) != null && (obj = s4.this.get(key)) != null && s4.this.valueEquivalence().equivalent(entry.getValue(), obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return s4.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new g(s4.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            Map.Entry entry;
            Object key;
            return (o10 instanceof Map.Entry) && (key = (entry = (Map.Entry) o10).getKey()) != null && s4.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return s4.this.size();
        }
    }

    public interface h0<K, V, E extends j<K, V, E>> {
        E a();

        h0<K, V, E> b(ReferenceQueue<V> queue, E entry);

        void clear();

        @gm.a
        V get();
    }

    public abstract class i<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5265b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public o<K, V, E, S> f5266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public AtomicReferenceArray<E> f5267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.a
        public E f5268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.a
        public s4<K, V, E, S>.j0 f5269f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @gm.a
        public s4<K, V, E, S>.j0 f5270g;

        public i() {
            this.f5264a = s4.this.segments.length - 1;
            a();
        }

        public final void a() {
            this.f5269f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i10 = this.f5264a;
                if (i10 < 0) {
                    return;
                }
                o<K, V, E, S>[] oVarArr = s4.this.segments;
                this.f5264a = i10 - 1;
                o<K, V, E, S> oVar = oVarArr[i10];
                this.f5266c = oVar;
                if (oVar.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f5266c.table;
                    this.f5267d = atomicReferenceArray;
                    this.f5265b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E entry) {
            o<K, V, E, S> oVar;
            try {
                Object key = entry.getKey();
                Object liveValue = s4.this.getLiveValue(entry);
                if (liveValue == null) {
                    return false;
                }
                this.f5269f = new j0(key, liveValue);
                return true;
            } finally {
                this.f5266c.postReadCleanup();
            }
        }

        public s4<K, V, E, S>.j0 c() {
            s4<K, V, E, S>.j0 j0Var = this.f5269f;
            if (j0Var == null) {
                throw new NoSuchElementException();
            }
            this.f5270g = j0Var;
            a();
            return this.f5270g;
        }

        public boolean d() {
            E e10 = this.f5268e;
            if (e10 == null) {
                return false;
            }
            while (true) {
                this.f5268e = (E) e10.getNext();
                E e11 = this.f5268e;
                if (e11 == null) {
                    return false;
                }
                if (b(e11)) {
                    return true;
                }
                e10 = this.f5268e;
            }
        }

        public boolean e() {
            while (true) {
                int i10 = this.f5265b;
                if (i10 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f5267d;
                this.f5265b = i10 - 1;
                E e10 = atomicReferenceArray.get(i10);
                this.f5268e = e10;
                if (e10 != null && (b(e10) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5269f != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            f1.b0.e(this.f5270g != null);
            s4.this.remove(this.f5270g.f5273a);
            this.f5270g = null;
        }
    }

    public static final class i0<K, V, E extends j<K, V, E>> extends WeakReference<V> implements h0<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final E f5272a;

        public i0(ReferenceQueue<V> queue, V referent, E entry) {
            super(referent, queue);
            this.f5272a = entry;
        }

        @Override // f1.s4.h0
        public E a() {
            return this.f5272a;
        }

        @Override // f1.s4.h0
        public h0<K, V, E> b(ReferenceQueue<V> queue, E entry) {
            return new i0(queue, get(), entry);
        }
    }

    public interface j<K, V, E extends j<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    public final class j0 extends f1.g<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f5273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f5274b;

        public j0(K key, V value) {
            this.f5273a = key;
            this.f5274b = value;
        }

        @Override // f1.g, java.util.Map.Entry
        public boolean equals(@gm.a Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) object;
            return this.f5273a.equals(entry.getKey()) && this.f5274b.equals(entry.getValue());
        }

        @Override // f1.g, java.util.Map.Entry
        public K getKey() {
            return this.f5273a;
        }

        @Override // f1.g, java.util.Map.Entry
        public V getValue() {
            return this.f5274b;
        }

        @Override // f1.g, java.util.Map.Entry
        public int hashCode() {
            return this.f5274b.hashCode() ^ this.f5273a.hashCode();
        }

        @Override // f1.g, java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = (V) s4.this.put(this.f5273a, v10);
            this.f5274b = v10;
            return v11;
        }
    }

    public interface k<K, V, E extends j<K, V, E>, S extends o<K, V, E, S>> {
        q a();

        E b(S segment, E entry, @gm.a E newNext);

        void c(S segment, E entry, V value);

        q d();

        S e(s4<K, V, E, S> map, int initialCapacity);

        E f(S segment, K key, int hash, @gm.a E next);
    }

    public final class l extends s4<K, V, E, S>.i<K> {
        public l(final s4 this$0) {
            super();
        }

        @Override // f1.s4.i, java.util.Iterator
        public K next() {
            return c().f5273a;
        }
    }

    public final class m extends n<K> {
        public m() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            s4.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return s4.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return s4.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new l(s4.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return s4.this.remove(o10) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return s4.this.size();
        }
    }

    public static abstract class n<E> extends AbstractSet<E> {
        public n() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return s4.a(this).toArray();
        }

        public n(a aVar) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) s4.a(this).toArray(tArr);
        }
    }

    public static final class p<K, V> extends b<K, V> {
        private static final long serialVersionUID = 3;

        public p(q keyStrength, q valueStrength, c1.m<Object> keyEquivalence, c1.m<Object> valueEquivalence, int concurrencyLevel, ConcurrentMap<K, V> delegate) {
            super(keyStrength, valueStrength, keyEquivalence, valueEquivalence, concurrencyLevel, delegate);
        }

        @b1.d
        private void readObject(ObjectInputStream in2) throws ClassNotFoundException, IOException {
            in2.defaultReadObject();
            this.delegate = readMapMaker(in2).i();
            readEntries(in2);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            writeMapTo(out);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class q {
        public static final q STRONG = new a("STRONG", 0);
        public static final q WEAK = new b("WEAK", 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ q[] f5277a = a();

        public final enum a extends q {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.s4.q
            public c1.m<Object> defaultEquivalence() {
                return c1.m.equals();
            }
        }

        public final enum b extends q {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.s4.q
            public c1.m<Object> defaultEquivalence() {
                return c1.m.identity();
            }
        }

        public q(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ q[] a() {
            return new q[]{STRONG, WEAK};
        }

        public static q valueOf(String name) {
            return (q) Enum.valueOf(q.class, name);
        }

        public static q[] values() {
            return (q[]) f5277a.clone();
        }

        public abstract c1.m<Object> defaultEquivalence();

        public q(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static class r<K> extends c<K, r4.a, r<K>> implements x<K, r4.a, r<K>> {

        public static final class a<K> implements k<K, r4.a, r<K>, s<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?> f5278a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f5278a;
            }

            @Override // f1.s4.k
            public q a() {
                return q.STRONG;
            }

            @Override // f1.s4.k
            public void c(o segment, j entry, r4.a value) {
            }

            @Override // f1.s4.k
            public q d() {
                return q.STRONG;
            }

            @Override // f1.s4.k
            public o e(s4 map, int initialCapacity) {
                return new s(map, initialCapacity);
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public r<K> b(s<K> segment, r<K> entry, @gm.a r<K> newNext) {
                return f(segment, entry.f5253a, entry.f5254b, newNext);
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public r<K> f(s<K> segment, K key, int hash, @gm.a r<K> next) {
                return next == null ? new r<>(key, hash) : new b(key, hash, next);
            }

            public s<K> j(s4<K, r4.a, r<K>, s<K>> map, int initialCapacity) {
                return new s<>(map, initialCapacity);
            }

            public void k(s<K> segment, r<K> entry, r4.a value) {
            }
        }

        public static final class b<K> extends r<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final r<K> f5279c;

            public b(K key, int hash, r<K> next) {
                super(key, hash);
                this.f5279c = next;
            }

            public r<K> b() {
                return this.f5279c;
            }

            @Override // f1.s4.c, f1.s4.j
            public j getNext() {
                return this.f5279c;
            }

            @Override // f1.s4.r, f1.s4.j
            public Object getValue() {
                return r4.a.VALUE;
            }
        }

        public r(K key, int hash) {
            super(key, hash);
        }

        public final r4.a a() {
            return r4.a.VALUE;
        }

        @Override // f1.s4.j
        public Object getValue() {
            return r4.a.VALUE;
        }

        public r(Object obj, int i10, a aVar) {
            super(obj, i10);
        }
    }

    public static final class s<K> extends o<K, r4.a, r<K>, s<K>> {
        public s(s4<K, r4.a, r<K>, s<K>> map, int initialCapacity) {
            super(map, initialCapacity);
        }

        @Override // f1.s4.o
        public r<K> castForTesting(j<K, r4.a, ?> entry) {
            return (r) entry;
        }

        @Override // f1.s4.o
        public s<K> self() {
            return this;
        }
    }

    public static class t<K, V> extends c<K, V, t<K, V>> implements x<K, V, t<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public volatile V f5280c;

        public static final class a<K, V> implements k<K, V, t<K, V>, u<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f5281a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f5281a;
            }

            @Override // f1.s4.k
            public q a() {
                return q.STRONG;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f1.s4.k
            public void c(o segment, j entry, Object value) {
                ((t) entry).f5280c = value;
            }

            @Override // f1.s4.k
            public q d() {
                return q.STRONG;
            }

            @Override // f1.s4.k
            public o e(s4 map, int initialCapacity) {
                return new u(map, initialCapacity);
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public t<K, V> b(u<K, V> segment, t<K, V> entry, @gm.a t<K, V> newNext) {
                t<K, V> tVarF = f(segment, entry.f5253a, entry.f5254b, newNext);
                tVarF.f5280c = entry.f5280c;
                return tVarF;
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public t<K, V> f(u<K, V> segment, K key, int hash, @gm.a t<K, V> next) {
                return next == null ? new t<>(key, hash) : new b(key, hash, next);
            }

            public u<K, V> j(s4<K, V, t<K, V>, u<K, V>> map, int initialCapacity) {
                return new u<>(map, initialCapacity);
            }

            public void k(u<K, V> segment, t<K, V> entry, V value) {
                entry.f5280c = value;
            }
        }

        public static final class b<K, V> extends t<K, V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final t<K, V> f5282d;

            public b(K key, int hash, t<K, V> next) {
                super(key, hash);
                this.f5282d = next;
            }

            public t<K, V> c() {
                return this.f5282d;
            }

            @Override // f1.s4.c, f1.s4.j
            public j getNext() {
                return this.f5282d;
            }
        }

        public /* synthetic */ t(Object obj, int i10, a aVar) {
            this(obj, i10);
        }

        @Override // f1.s4.j
        @gm.a
        public final V getValue() {
            return this.f5280c;
        }

        public t(K key, int hash) {
            super(key, hash);
            this.f5280c = null;
        }
    }

    public static final class u<K, V> extends o<K, V, t<K, V>, u<K, V>> {
        public u(s4<K, V, t<K, V>, u<K, V>> map, int initialCapacity) {
            super(map, initialCapacity);
        }

        @Override // f1.s4.o
        @gm.a
        public t<K, V> castForTesting(@gm.a j<K, V, ?> entry) {
            return (t) entry;
        }

        @Override // f1.s4.o
        public u<K, V> self() {
            return this;
        }
    }

    public static class v<K, V> extends c<K, V, v<K, V>> implements g0<K, V, v<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile h0<K, V, v<K, V>> f5283c;

        public static final class a<K, V> implements k<K, V, v<K, V>, w<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f5284a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f5284a;
            }

            @Override // f1.s4.k
            public q a() {
                return q.WEAK;
            }

            @Override // f1.s4.k
            public q d() {
                return q.STRONG;
            }

            @Override // f1.s4.k
            public o e(s4 map, int initialCapacity) {
                return new w(map, initialCapacity);
            }

            @Override // f1.s4.k
            @gm.a
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public v<K, V> b(w<K, V> wVar, v<K, V> vVar, @gm.a v<K, V> vVar2) {
                if (o.isCollected(vVar)) {
                    return null;
                }
                v<K, V> vVarF = f(wVar, vVar.f5253a, vVar.f5254b, vVar2);
                vVarF.f5283c = vVar.f5283c.b(((w) wVar).queueForValues, vVarF);
                return vVarF;
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public v<K, V> f(w<K, V> segment, K key, int hash, @gm.a v<K, V> next) {
                return next == null ? new v<>(key, hash) : new b(key, hash, next);
            }

            public w<K, V> j(s4<K, V, v<K, V>, w<K, V>> map, int initialCapacity) {
                return new w<>(map, initialCapacity);
            }

            @Override // f1.s4.k
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void c(w<K, V> segment, v<K, V> entry, V value) {
                h0<K, V, v<K, V>> h0Var = entry.f5283c;
                entry.f5283c = new i0(((w) segment).queueForValues, value, entry);
                h0Var.clear();
            }
        }

        public static final class b<K, V> extends v<K, V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final v<K, V> f5285d;

            public b(K key, int hash, v<K, V> next) {
                super(key, hash);
                this.f5285d = next;
            }

            public v<K, V> c() {
                return this.f5285d;
            }

            @Override // f1.s4.c, f1.s4.j
            public j getNext() {
                return this.f5285d;
            }
        }

        public /* synthetic */ v(Object obj, int i10, a aVar) {
            this(obj, i10);
        }

        @Override // f1.s4.j
        @gm.a
        public final V getValue() {
            return this.f5283c.get();
        }

        @Override // f1.s4.g0
        public final h0<K, V, v<K, V>> getValueReference() {
            return this.f5283c;
        }

        public v(K key, int hash) {
            super(key, hash);
            this.f5283c = s4.unsetWeakValueReference();
        }
    }

    public static final class w<K, V> extends o<K, V, v<K, V>, w<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public w(s4<K, V, v<K, V>, w<K, V>> map, int initialCapacity) {
            super(map, initialCapacity);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // f1.s4.o
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // f1.s4.o
        public h0<K, V, v<K, V>> getWeakValueReferenceForTesting(j<K, V, ?> e10) {
            return castForTesting((j) e10).f5283c;
        }

        @Override // f1.s4.o
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // f1.s4.o
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // f1.s4.o
        public h0<K, V, v<K, V>> newWeakValueReferenceForTesting(j<K, V, ?> e10, V value) {
            return new i0(this.queueForValues, value, castForTesting((j) e10));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.s4.o
        public void setWeakValueReferenceForTesting(j<K, V, ?> e10, h0<K, V, ? extends j<K, V, ?>> valueReference) {
            v<K, V> vVarCastForTesting = castForTesting((j) e10);
            h0<K, V, v<K, V>> h0Var = vVarCastForTesting.f5283c;
            vVarCastForTesting.f5283c = valueReference;
            h0Var.clear();
        }

        @Override // f1.s4.o
        @gm.a
        public v<K, V> castForTesting(@gm.a j<K, V, ?> entry) {
            return (v) entry;
        }

        @Override // f1.s4.o
        public w<K, V> self() {
            return this;
        }
    }

    public interface x<K, V, E extends j<K, V, E>> extends j<K, V, E> {
    }

    public final class y extends s4<K, V, E, S>.i<V> {
        public y(final s4 this$0) {
            super();
        }

        @Override // f1.s4.i, java.util.Iterator
        public V next() {
            return c().f5274b;
        }
    }

    public final class z extends AbstractCollection<V> {
        public z() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            s4.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o10) {
            return s4.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return s4.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new y(s4.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return s4.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return s4.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) s4.a(this).toArray(tArr);
        }
    }

    public s4(r4 builder, k<K, V, E, S> entryHelper) {
        this.concurrencyLevel = Math.min(builder.b(), 65536);
        this.keyEquivalence = builder.d();
        this.entryHelper = entryHelper;
        int iMin = Math.min(builder.c(), 1073741824);
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        int i13 = 1;
        while (i13 < this.concurrencyLevel) {
            i12++;
            i13 <<= 1;
        }
        this.segmentShift = 32 - i12;
        this.segmentMask = i13 - 1;
        this.segments = newSegmentArray(i13);
        int i14 = iMin / i13;
        while (i11 < (i13 * i14 < iMin ? i14 + 1 : i14)) {
            i11 <<= 1;
        }
        while (true) {
            o<K, V, E, S>[] oVarArr = this.segments;
            if (i10 >= oVarArr.length) {
                return;
            }
            oVarArr[i10] = createSegment(i11);
            i10++;
        }
    }

    public static <E> ArrayList<E> a(Collection<E> c10) {
        ArrayList<E> arrayList = new ArrayList<>(c10.size());
        h4.a(arrayList, c10.iterator());
        return arrayList;
    }

    public static <K, V> s4<K, V, ? extends j<K, V, ?>, ?> create(r4 builder) {
        q qVarE = builder.e();
        q qVar = q.STRONG;
        if (qVarE == qVar && builder.f() == qVar) {
            return new s4<>(builder, t.a.h());
        }
        if (builder.e() == qVar && builder.f() == q.WEAK) {
            return new s4<>(builder, v.a.h());
        }
        q qVarE2 = builder.e();
        q qVar2 = q.WEAK;
        if (qVarE2 == qVar2 && builder.f() == qVar) {
            return new s4<>(builder, c0.a.h());
        }
        if (builder.e() == qVar2 && builder.f() == qVar2) {
            return new s4<>(builder, e0.a.h());
        }
        throw new AssertionError();
    }

    public static <K> s4<K, r4.a, ? extends j<K, r4.a, ?>, ?> createWithDummyValues(r4 builder) {
        q qVarE = builder.e();
        q qVar = q.STRONG;
        if (qVarE == qVar && builder.f() == qVar) {
            return new s4<>(builder, r.a.h());
        }
        q qVarE2 = builder.e();
        q qVar2 = q.WEAK;
        if (qVarE2 == qVar2 && builder.f() == qVar) {
            return new s4<>(builder, a0.a.h());
        }
        if (builder.f() == qVar2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    @b1.d
    private void readObject(ObjectInputStream in2) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    public static int rehash(int h10) {
        int i10 = h10 + ((h10 << 15) ^ (-12931));
        int i11 = i10 ^ (i10 >>> 10);
        int i12 = i11 + (i11 << 3);
        int i13 = i12 ^ (i12 >>> 6);
        int i14 = (i13 << 2) + (i13 << 14) + i13;
        return (i14 >>> 16) ^ i14;
    }

    public static <K, V, E extends j<K, V, E>> h0<K, V, E> unsetWeakValueReference() {
        return (h0<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (o<K, V, E, S> oVar : this.segments) {
            oVar.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@gm.a Object key) {
        if (key == null) {
            return false;
        }
        int iHash = hash(key);
        return segmentFor(iHash).containsKey(key, iHash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@gm.a Object obj) {
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        o<K, V, E, S>[] oVarArr = this.segments;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            int length = oVarArr.length;
            long j11 = 0;
            for (?? r10 = z10; r10 < length; r10++) {
                o<K, V, E, S> oVar = oVarArr[r10];
                int i11 = oVar.count;
                AtomicReferenceArray<E> atomicReferenceArray = oVar.table;
                for (?? r13 = z10; r13 < atomicReferenceArray.length(); r13++) {
                    for (E next = atomicReferenceArray.get(r13); next != null; next = next.getNext()) {
                        V liveValue = oVar.getLiveValue(next);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j11 += (long) oVar.modCount;
                z10 = false;
            }
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
            z10 = false;
        }
        return z10;
    }

    @b1.e
    public E copyEntry(E e10, E e11) {
        return (E) segmentFor(e10.getHash()).copyEntry(e10, e11);
    }

    public o<K, V, E, S> createSegment(int initialCapacity) {
        return this.entryHelper.e(this, initialCapacity);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        h hVar = new h();
        this.entrySet = hVar;
        return hVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    public V get(@gm.a Object key) {
        if (key == null) {
            return null;
        }
        int iHash = hash(key);
        return segmentFor(iHash).get(key, iHash);
    }

    @gm.a
    public E getEntry(@gm.a Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return (E) segmentFor(iHash).getEntry(obj, iHash);
    }

    @gm.a
    public V getLiveValue(E e10) {
        if (e10.getKey() == null) {
            return null;
        }
        return (V) e10.getValue();
    }

    public int hash(Object key) {
        return rehash(this.keyEquivalence.hash(key));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        o<K, V, E, S>[] oVarArr = this.segments;
        long j10 = 0;
        for (int i10 = 0; i10 < oVarArr.length; i10++) {
            if (oVarArr[i10].count != 0) {
                return false;
            }
            j10 += (long) oVarArr[i10].modCount;
        }
        if (j10 == 0) {
            return true;
        }
        for (int i11 = 0; i11 < oVarArr.length; i11++) {
            if (oVarArr[i11].count != 0) {
                return false;
            }
            j10 -= (long) oVarArr[i11].modCount;
        }
        return j10 == 0;
    }

    @b1.e
    public boolean isLiveForTesting(j<K, V, ?> entry) {
        return segmentFor(entry.getHash()).getLiveValueForTesting(entry) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        m mVar = new m();
        this.keySet = mVar;
        return mVar;
    }

    @b1.e
    public q keyStrength() {
        return this.entryHelper.d();
    }

    public final o<K, V, E, S>[] newSegmentArray(int ssize) {
        return new o[ssize];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    @t1.a
    public V put(K key, V value) {
        key.getClass();
        value.getClass();
        int iHash = hash(key);
        return segmentFor(iHash).put(key, iHash, value, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m10) {
        for (Map.Entry<? extends K, ? extends V> entry : m10.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @gm.a
    @t1.a
    public V putIfAbsent(K key, V value) {
        key.getClass();
        value.getClass();
        int iHash = hash(key);
        return segmentFor(iHash).put(key, iHash, value, true);
    }

    public void reclaimKey(E entry) {
        int hash = entry.getHash();
        segmentFor(hash).reclaimKey(entry, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(h0<K, V, E> h0Var) {
        j jVarA = h0Var.a();
        int hash = jVarA.getHash();
        segmentFor(hash).reclaimValue(jVarA.getKey(), hash, h0Var);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    @t1.a
    public V remove(@gm.a Object key) {
        if (key == null) {
            return null;
        }
        int iHash = hash(key);
        return segmentFor(iHash).remove(key, iHash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @gm.a
    @t1.a
    public V replace(K key, V value) {
        key.getClass();
        value.getClass();
        int iHash = hash(key);
        return segmentFor(iHash).replace(key, iHash, value);
    }

    public o<K, V, E, S> segmentFor(int hash) {
        return this.segments[this.segmentMask & (hash >>> this.segmentShift)];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j10 = 0;
        for (o<K, V, E, S> oVar : this.segments) {
            j10 += (long) oVar.count;
        }
        return o1.l.z(j10);
    }

    @b1.e
    public c1.m<Object> valueEquivalence() {
        return this.entryHelper.a().defaultEquivalence();
    }

    @b1.e
    public q valueStrength() {
        return this.entryHelper.a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        z zVar = new z();
        this.values = zVar;
        return zVar;
    }

    public Object writeReplace() {
        return new p(this.entryHelper.d(), this.entryHelper.a(), this.keyEquivalence, this.entryHelper.a().defaultEquivalence(), this.concurrencyLevel, this);
    }

    public static abstract class b<K, V> extends t1<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final c1.m<Object> keyEquivalence;
        final q keyStrength;
        final c1.m<Object> valueEquivalence;
        final q valueStrength;

        public b(q keyStrength, q valueStrength, c1.m<Object> keyEquivalence, c1.m<Object> valueEquivalence, int concurrencyLevel, ConcurrentMap<K, V> delegate) {
            this.keyStrength = keyStrength;
            this.valueStrength = valueStrength;
            this.keyEquivalence = keyEquivalence;
            this.valueEquivalence = valueEquivalence;
            this.concurrencyLevel = concurrencyLevel;
            this.delegate = delegate;
        }

        @b1.d
        public void readEntries(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                }
                this.delegate.put((K) object, (V) objectInputStream.readObject());
            }
        }

        @b1.d
        public r4 readMapMaker(ObjectInputStream in2) throws IOException {
            return new r4().g(in2.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        public void writeMapTo(ObjectOutputStream out) throws IOException {
            out.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                out.writeObject(entry.getKey());
                out.writeObject(entry.getValue());
            }
            out.writeObject(null);
        }

        @Override // f1.t1, f1.d2, f1.j2
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @t1.a
    public boolean remove(@gm.a Object key, @gm.a Object value) {
        if (key == null || value == null) {
            return false;
        }
        int iHash = hash(key);
        return segmentFor(iHash).remove(key, iHash, value);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @t1.a
    public boolean replace(K key, @gm.a V oldValue, V newValue) {
        key.getClass();
        newValue.getClass();
        if (oldValue == null) {
            return false;
        }
        int iHash = hash(key);
        return segmentFor(iHash).replace(key, iHash, oldValue, newValue);
    }

    public static abstract class o<K, V, E extends j<K, V, E>, S extends o<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final s4<K, V, E, S> map;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();

        @gm.a
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public o(s4<K, V, E, S> map, int initialCapacity) {
            this.map = map;
            initTable(newEntryArray(initialCapacity));
        }

        public static <K, V, E extends j<K, V, E>> boolean isCollected(E entry) {
            return entry.getValue() == null;
        }

        public abstract E castForTesting(j<K, V, ?> entry);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i10 = 0; i10 < atomicReferenceArray.length(); i10++) {
                        atomicReferenceArray.set(i10, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        @t1.a
        public boolean clearValueForTesting(K k10, int i10, h0<K, V, ? extends j<K, V, ?>> h0Var) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (j next = e10; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        if (((g0) next).getValueReference() != h0Var) {
                            return false;
                        }
                        atomicReferenceArray.set(length, (E) removeFromChain(e10, next));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(Object key, int hash) {
            try {
                boolean z10 = false;
                if (this.count == 0) {
                    return false;
                }
                j liveEntry = getLiveEntry(key, hash);
                if (liveEntry != null && liveEntry.getValue() != null) {
                    z10 = true;
                }
                return z10;
            } finally {
                postReadCleanup();
            }
        }

        @b1.e
        public boolean containsValue(Object value) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        for (E next = atomicReferenceArray.get(i10); next != null; next = next.getNext()) {
                            V liveValue = getLiveValue(next);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(value, liveValue)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        @gm.a
        public E copyEntry(E e10, E e11) {
            return (E) this.map.entryHelper.b(self(), e10, e11);
        }

        public E copyForTesting(j<K, V, ?> jVar, @gm.a j<K, V, ?> jVar2) {
            return (E) this.map.entryHelper.b(self(), castForTesting(jVar), castForTesting(jVar2));
        }

        @u1.a("this")
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends K> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimKey((j) referencePoll);
                i10++;
            } while (i10 != 16);
        }

        @u1.a("this")
        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends V> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimValue((h0) referencePoll);
                i10++;
            } while (i10 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @u1.a("this")
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i10 = this.count;
            AtomicReferenceArray<E> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i11 = 0; i11 < length; i11++) {
                E next = atomicReferenceArray.get(i11);
                if (next != null) {
                    j next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, next);
                    } else {
                        j jVar = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                jVar = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, jVar);
                        while (next != jVar) {
                            int hash3 = next.getHash() & length2;
                            j jVarCopyEntry = copyEntry(next, (j) atomicReferenceArrayNewEntryArray.get(hash3));
                            if (jVarCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, jVarCopyEntry);
                            } else {
                                i10--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArrayNewEntryArray;
            this.count = i10;
        }

        @gm.a
        public V get(Object obj, int i10) {
            try {
                j liveEntry = getLiveEntry(obj, i10);
                if (liveEntry == null) {
                    return null;
                }
                V v10 = (V) liveEntry.getValue();
                if (v10 == null) {
                    tryDrainReferenceQueues();
                }
                return v10;
            } finally {
                postReadCleanup();
            }
        }

        @gm.a
        public E getEntry(Object obj, int i10) {
            if (this.count == 0) {
                return null;
            }
            for (E e10 = (E) getFirst(i10); e10 != null; e10 = (E) e10.getNext()) {
                if (e10.getHash() == i10) {
                    Object key = e10.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return e10;
                    }
                }
            }
            return null;
        }

        @gm.a
        public E getFirst(int hash) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(hash & (atomicReferenceArray.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        @gm.a
        public E getLiveEntry(Object obj, int i10) {
            return (E) getEntry(obj, i10);
        }

        @gm.a
        public V getLiveValue(E e10) {
            if (e10.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v10 = (V) e10.getValue();
            if (v10 != null) {
                return v10;
            }
            tryDrainReferenceQueues();
            return null;
        }

        @gm.a
        public V getLiveValueForTesting(j<K, V, ?> entry) {
            return getLiveValue(castForTesting(entry));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public h0<K, V, E> getWeakValueReferenceForTesting(j<K, V, ?> entry) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> newTable) {
            this.threshold = (newTable.length() * 3) / 4;
            this.table = newTable;
        }

        public void maybeClearReferenceQueues() {
        }

        @u1.a("this")
        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int size) {
            return new AtomicReferenceArray<>(size);
        }

        public E newEntryForTesting(K k10, int i10, @gm.a j<K, V, ?> jVar) {
            return (E) this.map.entryHelper.f(self(), k10, i10, castForTesting(jVar));
        }

        public h0<K, V, E> newWeakValueReferenceForTesting(j<K, V, ?> entry, V value) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @u1.a("this")
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        @gm.a
        public V put(K k10, int i10, V v10, boolean z10) {
            lock();
            try {
                preWriteCleanup();
                int i11 = this.count + 1;
                if (i11 > this.threshold) {
                    expand();
                    i11 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (j next = e10; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        V v11 = (V) next.getValue();
                        if (v11 == null) {
                            this.modCount++;
                            setValue(next, v10);
                            this.count = this.count;
                            return null;
                        }
                        if (z10) {
                            return v11;
                        }
                        this.modCount++;
                        setValue(next, v10);
                        return v11;
                    }
                }
                this.modCount++;
                j jVarF = this.map.entryHelper.f(self(), k10, i10, e10);
                setValue(jVarF, v10);
                atomicReferenceArray.set(length, (E) jVarF);
                this.count = i11;
                return null;
            } finally {
                unlock();
            }
        }

        @t1.a
        public boolean reclaimKey(E e10, int i10) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                E e11 = atomicReferenceArray.get(length);
                for (j next = e11; next != null; next = next.getNext()) {
                    if (next == e10) {
                        this.modCount++;
                        j jVarRemoveFromChain = removeFromChain(e11, next);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, (E) jVarRemoveFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        @t1.a
        public boolean reclaimValue(K k10, int i10, h0<K, V, E> h0Var) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (j next = e10; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        if (((g0) next).getValueReference() != h0Var) {
                            return false;
                        }
                        this.modCount++;
                        j jVarRemoveFromChain = removeFromChain(e10, next);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, (E) jVarRemoveFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        @gm.a
        @t1.a
        public V remove(Object obj, int i10) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (j next = e10; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v10 = (V) next.getValue();
                        if (v10 == null && !isCollected(next)) {
                            return null;
                        }
                        this.modCount++;
                        j jVarRemoveFromChain = removeFromChain(e10, next);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, (E) jVarRemoveFromChain);
                        this.count = i11;
                        return v10;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        @u1.a("this")
        public boolean removeEntryForTesting(E e10) {
            int hash = e10.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            E e11 = atomicReferenceArray.get(length);
            for (j next = e11; next != null; next = next.getNext()) {
                if (next == e10) {
                    this.modCount++;
                    j jVarRemoveFromChain = removeFromChain(e11, next);
                    int i10 = this.count - 1;
                    atomicReferenceArray.set(length, (E) jVarRemoveFromChain);
                    this.count = i10;
                    return true;
                }
            }
            return false;
        }

        @gm.a
        @u1.a("this")
        public E removeFromChain(E e10, E e11) {
            int i10 = this.count;
            E e12 = (E) e11.getNext();
            while (e10 != e11) {
                j jVarCopyEntry = copyEntry(e10, e12);
                if (jVarCopyEntry != null) {
                    e12 = (E) jVarCopyEntry;
                } else {
                    i10--;
                }
                e10 = (E) e10.getNext();
            }
            this.count = i10;
            return e12;
        }

        @gm.a
        public E removeFromChainForTesting(j<K, V, ?> jVar, j<K, V, ?> jVar2) {
            return (E) removeFromChain(castForTesting(jVar), castForTesting(jVar2));
        }

        @t1.a
        public boolean removeTableEntryForTesting(j<K, V, ?> entry) {
            return removeEntryForTesting(castForTesting(entry));
        }

        public boolean replace(K k10, int i10, V v10, V v11) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (j next = e10; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        Object value = next.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v10, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(next, v11);
                            return true;
                        }
                        if (isCollected(next)) {
                            this.modCount++;
                            j jVarRemoveFromChain = removeFromChain(e10, next);
                            int i11 = this.count - 1;
                            atomicReferenceArray.set(length, (E) jVarRemoveFromChain);
                            this.count = i11;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i10, j<K, V, ?> jVar) {
            this.table.set(i10, (E) castForTesting(jVar));
        }

        public void setValue(E entry, V value) {
            this.map.entryHelper.c(self(), entry, value);
        }

        public void setValueForTesting(j<K, V, ?> entry, V value) {
            this.map.entryHelper.c(self(), castForTesting(entry), value);
        }

        public void setWeakValueReferenceForTesting(j<K, V, ?> entry, h0<K, V, ? extends j<K, V, ?>> valueReference) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public boolean remove(Object obj, int i10, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                j next = e10;
                while (true) {
                    boolean z10 = false;
                    if (next == null) {
                        return false;
                    }
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        if (this.map.valueEquivalence().equivalent(obj2, next.getValue())) {
                            z10 = true;
                        } else if (!isCollected(next)) {
                            return false;
                        }
                        this.modCount++;
                        j jVarRemoveFromChain = removeFromChain(e10, next);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, (E) jVarRemoveFromChain);
                        this.count = i11;
                        return z10;
                    }
                    next = next.getNext();
                }
            } finally {
                unlock();
            }
        }

        @gm.a
        public V replace(K k10, int i10, V v10) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (j next = e10; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        V v11 = (V) next.getValue();
                        if (v11 == null) {
                            if (isCollected(next)) {
                                this.modCount++;
                                j jVarRemoveFromChain = removeFromChain(e10, next);
                                int i11 = this.count - 1;
                                atomicReferenceArray.set(length, (E) jVarRemoveFromChain);
                                this.count = i11;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(next, v10);
                        return v11;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }
}
