package e1;

import c1.o0;
import c1.u0;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import f1.h4;
import f1.k3;
import f1.t3;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import q1.c3;
import q1.e3;
import q1.h1;
import q1.l2;
import q1.n0;
import q1.p0;
import q1.s1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
public class m<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    public static final int O = 1073741824;
    public static final int P = 65536;
    public static final int Q = 3;
    public static final int R = 63;
    public static final int S = 16;
    public static final Logger T = Logger.getLogger(m.class.getName());
    public static final a0<Object, Object> U = new a();
    public static final Queue<?> V = new b();
    public final u0 H;
    public final f I;
    public final e1.a.b J;

    @gm.a
    public final e1.g<? super K, V> K;

    @u1.b
    @RetainedWith
    @gm.a
    public Set<K> L;

    @u1.b
    @RetainedWith
    @gm.a
    public Collection<V> M;

    @u1.b
    @RetainedWith
    @gm.a
    public Set<Map.Entry<K, V>> N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r<K, V>[] f3947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c1.m<Object> f3949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c1.m<Object> f3950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t f3951g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t f3952i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f3953n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e1.b0<K, V> f3954p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f3955v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f3956w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f3957x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Queue<e1.z<K, V>> f3958y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final e1.v<K, V> f3959z;

    public class a implements a0<Object, Object> {
        @Override // e1.m.a0
        @gm.a
        public e1.t<Object, Object> a() {
            return null;
        }

        @Override // e1.m.a0
        public void b(Object newValue) {
        }

        @Override // e1.m.a0
        public int c() {
            return 0;
        }

        @Override // e1.m.a0
        public boolean d() {
            return false;
        }

        @Override // e1.m.a0
        public a0<Object, Object> e(ReferenceQueue<Object> queue, @gm.a Object value, e1.t<Object, Object> entry) {
            return this;
        }

        @Override // e1.m.a0
        @gm.a
        public Object f() {
            return null;
        }

        @Override // e1.m.a0
        @gm.a
        public Object get() {
            return null;
        }

        @Override // e1.m.a0
        public boolean isActive() {
            return false;
        }
    }

    public interface a0<K, V> {
        @gm.a
        e1.t<K, V> a();

        void b(@gm.a V newValue);

        int c();

        boolean d();

        a0<K, V> e(ReferenceQueue<V> queue, @gm.a V value, e1.t<K, V> entry);

        V f() throws ExecutionException;

        @gm.a
        V get();

        boolean isActive();
    }

    public class b extends AbstractQueue<Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return t3.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object o10) {
            return true;
        }

        @Override // java.util.Queue
        @gm.a
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        @gm.a
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    public final class b0 extends AbstractCollection<V> {
        public b0() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            m.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o10) {
            return m.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return m.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new z(m.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return m.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return m.T(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) m.T(this).toArray(eArr);
        }
    }

    public abstract class c<T> extends AbstractSet<T> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            m.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return m.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return m.T(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) m.T(this).toArray(eArr);
        }
    }

    public static final class c0<K, V> extends e0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f3962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f3963e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f3964f;

        public c0(ReferenceQueue<K> queue, K key, int hash, @gm.a e1.t<K, V> next) {
            super(queue, key, hash, next);
            this.f3962d = Long.MAX_VALUE;
            this.f3963e = m.G();
            this.f3964f = q.INSTANCE;
        }

        @Override // e1.m.e0, e1.t
        public long getAccessTime() {
            return this.f3962d;
        }

        @Override // e1.m.e0, e1.t
        public e1.t<K, V> getNextInAccessQueue() {
            return this.f3963e;
        }

        @Override // e1.m.e0, e1.t
        public e1.t<K, V> getPreviousInAccessQueue() {
            return this.f3964f;
        }

        @Override // e1.m.e0, e1.t
        public void setAccessTime(long time) {
            this.f3962d = time;
        }

        @Override // e1.m.e0, e1.t
        public void setNextInAccessQueue(e1.t<K, V> next) {
            this.f3963e = next;
        }

        @Override // e1.m.e0, e1.t
        public void setPreviousInAccessQueue(e1.t<K, V> previous) {
            this.f3964f = previous;
        }
    }

    public static abstract class d<K, V> implements e1.t<K, V> {
        @Override // e1.t
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public e1.t<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public e1.t<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public e1.t<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public e1.t<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public e1.t<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public a0<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public void setAccessTime(long time) {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public void setNextInAccessQueue(e1.t<K, V> next) {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public void setNextInWriteQueue(e1.t<K, V> next) {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public void setPreviousInAccessQueue(e1.t<K, V> previous) {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public void setPreviousInWriteQueue(e1.t<K, V> previous) {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public void setValueReference(a0<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public void setWriteTime(long time) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class d0<K, V> extends e0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f3965d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f3966e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f3967f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile long f3968g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f3969i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f3970n;

        public d0(ReferenceQueue<K> queue, K key, int hash, @gm.a e1.t<K, V> next) {
            super(queue, key, hash, next);
            this.f3965d = Long.MAX_VALUE;
            this.f3966e = m.G();
            q qVar = q.INSTANCE;
            this.f3967f = qVar;
            this.f3968g = Long.MAX_VALUE;
            this.f3969i = qVar;
            this.f3970n = qVar;
        }

        @Override // e1.m.e0, e1.t
        public long getAccessTime() {
            return this.f3965d;
        }

        @Override // e1.m.e0, e1.t
        public e1.t<K, V> getNextInAccessQueue() {
            return this.f3966e;
        }

        @Override // e1.m.e0, e1.t
        public e1.t<K, V> getNextInWriteQueue() {
            return this.f3969i;
        }

        @Override // e1.m.e0, e1.t
        public e1.t<K, V> getPreviousInAccessQueue() {
            return this.f3967f;
        }

        @Override // e1.m.e0, e1.t
        public e1.t<K, V> getPreviousInWriteQueue() {
            return this.f3970n;
        }

        @Override // e1.m.e0, e1.t
        public long getWriteTime() {
            return this.f3968g;
        }

        @Override // e1.m.e0, e1.t
        public void setAccessTime(long time) {
            this.f3965d = time;
        }

        @Override // e1.m.e0, e1.t
        public void setNextInAccessQueue(e1.t<K, V> next) {
            this.f3966e = next;
        }

        @Override // e1.m.e0, e1.t
        public void setNextInWriteQueue(e1.t<K, V> next) {
            this.f3969i = next;
        }

        @Override // e1.m.e0, e1.t
        public void setPreviousInAccessQueue(e1.t<K, V> previous) {
            this.f3967f = previous;
        }

        @Override // e1.m.e0, e1.t
        public void setPreviousInWriteQueue(e1.t<K, V> previous) {
            this.f3970n = previous;
        }

        @Override // e1.m.e0, e1.t
        public void setWriteTime(long time) {
            this.f3968g = time;
        }
    }

    public static final class e<K, V> extends AbstractQueue<e1.t<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1.t<K, V> f3971a = new a(this);

        public class a extends d<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Weak
            public e1.t<K, V> f3972a = this;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Weak
            public e1.t<K, V> f3973b = this;

            public a(final e this$0) {
            }

            @Override // e1.m.d, e1.t
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // e1.m.d, e1.t
            public e1.t<K, V> getNextInAccessQueue() {
                return this.f3972a;
            }

            @Override // e1.m.d, e1.t
            public e1.t<K, V> getPreviousInAccessQueue() {
                return this.f3973b;
            }

            @Override // e1.m.d, e1.t
            public void setAccessTime(long time) {
            }

            @Override // e1.m.d, e1.t
            public void setNextInAccessQueue(e1.t<K, V> next) {
                this.f3972a = next;
            }

            @Override // e1.m.d, e1.t
            public void setPreviousInAccessQueue(e1.t<K, V> previous) {
                this.f3973b = previous;
            }
        }

        public class b extends f1.l<e1.t<K, V>> {
            public b(e1.t firstOrNull) {
                super(firstOrNull);
            }

            @Override // f1.l
            @gm.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e1.t<K, V> a(e1.t<K, V> previous) {
                e1.t<K, V> nextInAccessQueue = previous.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.f3971a) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(e1.t<K, V> entry) {
            m.d(entry.getPreviousInAccessQueue(), entry.getNextInAccessQueue());
            m.d(this.f3971a.getPreviousInAccessQueue(), entry);
            m.d(entry, this.f3971a);
            return true;
        }

        @Override // java.util.Queue
        @gm.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e1.t<K, V> peek() {
            e1.t<K, V> nextInAccessQueue = this.f3971a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f3971a) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        @gm.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e1.t<K, V> poll() {
            e1.t<K, V> nextInAccessQueue = this.f3971a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f3971a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            e1.t<K, V> nextInAccessQueue = this.f3971a.getNextInAccessQueue();
            while (true) {
                e1.t<K, V> tVar = this.f3971a;
                if (nextInAccessQueue == tVar) {
                    tVar.setNextInAccessQueue(tVar);
                    e1.t<K, V> tVar2 = this.f3971a;
                    tVar2.setPreviousInAccessQueue(tVar2);
                    return;
                } else {
                    e1.t<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    m.H(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o10) {
            return ((e1.t) o10).getNextInAccessQueue() != q.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f3971a.getNextInAccessQueue() == this.f3971a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<e1.t<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        @t1.a
        public boolean remove(Object o10) {
            e1.t tVar = (e1.t) o10;
            e1.t<K, V> previousInAccessQueue = tVar.getPreviousInAccessQueue();
            e1.t<K, V> nextInAccessQueue = tVar.getNextInAccessQueue();
            m.d(previousInAccessQueue, nextInAccessQueue);
            m.H(tVar);
            return nextInAccessQueue != q.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i10 = 0;
            for (e1.t<K, V> nextInAccessQueue = this.f3971a.getNextInAccessQueue(); nextInAccessQueue != this.f3971a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i10++;
            }
            return i10;
        }
    }

    public static class e0<K, V> extends WeakReference<K> implements e1.t<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public final e1.t<K, V> f3976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile a0<K, V> f3977c;

        public e0(ReferenceQueue<K> queue, K key, int hash, @gm.a e1.t<K, V> next) {
            super(key, queue);
            this.f3977c = m.U();
            this.f3975a = hash;
            this.f3976b = next;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public int getHash() {
            return this.f3975a;
        }

        @Override // e1.t
        public K getKey() {
            return get();
        }

        @Override // e1.t
        public e1.t<K, V> getNext() {
            return this.f3976b;
        }

        public e1.t<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public e1.t<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public e1.t<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public e1.t<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public a0<K, V> getValueReference() {
            return this.f3977c;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long time) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(e1.t<K, V> next) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(e1.t<K, V> next) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(e1.t<K, V> previous) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(e1.t<K, V> previous) {
            throw new UnsupportedOperationException();
        }

        @Override // e1.t
        public void setValueReference(a0<K, V> valueReference) {
            this.f3977c = valueReference;
        }

        public void setWriteTime(long time) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class f {
        static final int ACCESS_MASK = 1;
        public static final f STRONG;
        public static final f STRONG_ACCESS;
        public static final f STRONG_ACCESS_WRITE;
        public static final f STRONG_WRITE;
        public static final f WEAK;
        public static final f WEAK_ACCESS;
        public static final f WEAK_ACCESS_WRITE;
        static final int WEAK_MASK = 4;
        public static final f WEAK_WRITE;
        static final int WRITE_MASK = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ f[] f3978a;
        static final f[] factories;

        public final enum a extends f {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next) {
                return new w(key, hash, next);
            }
        }

        public final enum b extends f {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> copyEntry(r<K, V> segment, e1.t<K, V> original, e1.t<K, V> newNext, K key) {
                e1.t<K, V> tVarCopyEntry = super.copyEntry(segment, original, newNext, key);
                copyAccessEntry(original, tVarCopyEntry);
                return tVarCopyEntry;
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next) {
                return new u(key, hash, next);
            }
        }

        public final enum c extends f {
            public c(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> copyEntry(r<K, V> segment, e1.t<K, V> original, e1.t<K, V> newNext, K key) {
                e1.t<K, V> tVarCopyEntry = super.copyEntry(segment, original, newNext, key);
                copyWriteEntry(original, tVarCopyEntry);
                return tVarCopyEntry;
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next) {
                return new y(key, hash, next);
            }
        }

        public final enum d extends f {
            public d(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> copyEntry(r<K, V> segment, e1.t<K, V> original, e1.t<K, V> newNext, K key) {
                e1.t<K, V> tVarCopyEntry = super.copyEntry(segment, original, newNext, key);
                copyAccessEntry(original, tVarCopyEntry);
                copyWriteEntry(original, tVarCopyEntry);
                return tVarCopyEntry;
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next) {
                return new v(key, hash, next);
            }
        }

        public final enum e extends f {
            public e(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next) {
                return new e0(segment.keyReferenceQueue, key, hash, next);
            }
        }

        /* JADX INFO: renamed from: e1.m$f$f, reason: collision with other inner class name */
        public final enum C0092f extends f {
            public C0092f(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> copyEntry(r<K, V> segment, e1.t<K, V> original, e1.t<K, V> newNext, K key) {
                e1.t<K, V> tVarCopyEntry = super.copyEntry(segment, original, newNext, key);
                copyAccessEntry(original, tVarCopyEntry);
                return tVarCopyEntry;
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next) {
                return new c0(segment.keyReferenceQueue, key, hash, next);
            }
        }

        public final enum g extends f {
            public g(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> copyEntry(r<K, V> segment, e1.t<K, V> original, e1.t<K, V> newNext, K key) {
                e1.t<K, V> tVarCopyEntry = super.copyEntry(segment, original, newNext, key);
                copyWriteEntry(original, tVarCopyEntry);
                return tVarCopyEntry;
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next) {
                return new g0(segment.keyReferenceQueue, key, hash, next);
            }
        }

        public final enum h extends f {
            public h(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> copyEntry(r<K, V> segment, e1.t<K, V> original, e1.t<K, V> newNext, K key) {
                e1.t<K, V> tVarCopyEntry = super.copyEntry(segment, original, newNext, key);
                copyAccessEntry(original, tVarCopyEntry);
                copyWriteEntry(original, tVarCopyEntry);
                return tVarCopyEntry;
            }

            @Override // e1.m.f
            public <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next) {
                return new d0(segment.keyReferenceQueue, key, hash, next);
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            STRONG = aVar;
            b bVar = new b("STRONG_ACCESS", 1);
            STRONG_ACCESS = bVar;
            c cVar = new c("STRONG_WRITE", 2);
            STRONG_WRITE = cVar;
            d dVar = new d("STRONG_ACCESS_WRITE", 3);
            STRONG_ACCESS_WRITE = dVar;
            e eVar = new e("WEAK", 4);
            WEAK = eVar;
            C0092f c0092f = new C0092f("WEAK_ACCESS", 5);
            WEAK_ACCESS = c0092f;
            g gVar = new g("WEAK_WRITE", 6);
            WEAK_WRITE = gVar;
            h hVar = new h("WEAK_ACCESS_WRITE", 7);
            WEAK_ACCESS_WRITE = hVar;
            f3978a = a();
            factories = new f[]{aVar, bVar, cVar, dVar, eVar, c0092f, gVar, hVar};
        }

        public f(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ f[] a() {
            return new f[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static f getFactory(t tVar, boolean z10, boolean z11) {
            return factories[((tVar == t.WEAK ? (char) 4 : (char) 0) | (z10 ? 1 : 0) ? 1 : 0) | (z11 ? 2 : 0)];
        }

        public static f valueOf(String name) {
            return (f) Enum.valueOf(f.class, name);
        }

        public static f[] values() {
            return (f[]) f3978a.clone();
        }

        public <K, V> void copyAccessEntry(e1.t<K, V> original, e1.t<K, V> newEntry) {
            newEntry.setAccessTime(original.getAccessTime());
            m.d(original.getPreviousInAccessQueue(), newEntry);
            m.d(newEntry, original.getNextInAccessQueue());
            m.H(original);
        }

        public <K, V> e1.t<K, V> copyEntry(r<K, V> segment, e1.t<K, V> original, e1.t<K, V> newNext, K key) {
            return newEntry(segment, key, original.getHash(), newNext);
        }

        public <K, V> void copyWriteEntry(e1.t<K, V> original, e1.t<K, V> newEntry) {
            newEntry.setWriteTime(original.getWriteTime());
            m.e(original.getPreviousInWriteQueue(), newEntry);
            m.e(newEntry, original.getNextInWriteQueue());
            m.I(original);
        }

        public abstract <K, V> e1.t<K, V> newEntry(r<K, V> segment, K key, int hash, @gm.a e1.t<K, V> next);

        public f(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static class f0<K, V> extends WeakReference<V> implements a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1.t<K, V> f3979a;

        public f0(ReferenceQueue<V> queue, V referent, e1.t<K, V> entry) {
            super(referent, queue);
            this.f3979a = entry;
        }

        @Override // e1.m.a0
        public e1.t<K, V> a() {
            return this.f3979a;
        }

        @Override // e1.m.a0
        public void b(V newValue) {
        }

        @Override // e1.m.a0
        public int c() {
            return 1;
        }

        @Override // e1.m.a0
        public boolean d() {
            return false;
        }

        @Override // e1.m.a0
        public a0<K, V> e(ReferenceQueue<V> queue, V value, e1.t<K, V> entry) {
            return new f0(queue, value, entry);
        }

        @Override // e1.m.a0
        public V f() {
            return get();
        }

        @Override // e1.m.a0
        public boolean isActive() {
            return true;
        }
    }

    public final class g extends m<K, V>.i<Map.Entry<K, V>> {
        public g(final m this$0) {
            super();
        }

        public Map.Entry<K, V> f() {
            return c();
        }

        @Override // e1.m.i, java.util.Iterator
        public Object next() {
            return c();
        }
    }

    public static final class g0<K, V> extends e0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f3980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f3981e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f3982f;

        public g0(ReferenceQueue<K> queue, K key, int hash, @gm.a e1.t<K, V> next) {
            super(queue, key, hash, next);
            this.f3980d = Long.MAX_VALUE;
            this.f3981e = m.G();
            this.f3982f = q.INSTANCE;
        }

        @Override // e1.m.e0, e1.t
        public e1.t<K, V> getNextInWriteQueue() {
            return this.f3981e;
        }

        @Override // e1.m.e0, e1.t
        public e1.t<K, V> getPreviousInWriteQueue() {
            return this.f3982f;
        }

        @Override // e1.m.e0, e1.t
        public long getWriteTime() {
            return this.f3980d;
        }

        @Override // e1.m.e0, e1.t
        public void setNextInWriteQueue(e1.t<K, V> next) {
            this.f3981e = next;
        }

        @Override // e1.m.e0, e1.t
        public void setPreviousInWriteQueue(e1.t<K, V> previous) {
            this.f3982f = previous;
        }

        @Override // e1.m.e0, e1.t
        public void setWriteTime(long time) {
            this.f3980d = time;
        }
    }

    public final class h extends m<K, V>.c<Map.Entry<K, V>> {
        public h() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            Map.Entry entry;
            Object key;
            Object obj;
            return (o10 instanceof Map.Entry) && (key = (entry = (Map.Entry) o10).getKey()) != null && (obj = m.this.get(key)) != null && m.this.f3950f.equivalent(entry.getValue(), obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new g(m.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            Map.Entry entry;
            Object key;
            return (o10 instanceof Map.Entry) && (key = (entry = (Map.Entry) o10).getKey()) != null && m.this.remove(key, entry.getValue());
        }
    }

    public static final class h0<K, V> extends s<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3984b;

        public h0(ReferenceQueue<V> queue, V referent, e1.t<K, V> entry, int weight) {
            super(queue, referent, entry);
            this.f3984b = weight;
        }

        @Override // e1.m.s, e1.m.a0
        public int c() {
            return this.f3984b;
        }

        @Override // e1.m.s, e1.m.a0
        public a0<K, V> e(ReferenceQueue<V> queue, V value, e1.t<K, V> entry) {
            return new h0(queue, value, entry, this.f3984b);
        }
    }

    public abstract class i<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3986b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public r<K, V> f3987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public AtomicReferenceArray<e1.t<K, V>> f3988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.a
        public e1.t<K, V> f3989e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.a
        public m<K, V>.l0 f3990f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @gm.a
        public m<K, V>.l0 f3991g;

        public i() {
            this.f3985a = m.this.f3947c.length - 1;
            a();
        }

        public final void a() {
            this.f3990f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i10 = this.f3985a;
                if (i10 < 0) {
                    return;
                }
                r<K, V>[] rVarArr = m.this.f3947c;
                this.f3985a = i10 - 1;
                r<K, V> rVar = rVarArr[i10];
                this.f3987c = rVar;
                if (rVar.count != 0) {
                    AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.f3987c.table;
                    this.f3988d = atomicReferenceArray;
                    this.f3986b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(e1.t<K, V> entry) {
            r<K, V> rVar;
            try {
                long jA = m.this.H.a();
                K key = entry.getKey();
                Object objV = m.this.v(entry, jA);
                if (objV == null) {
                    return false;
                }
                this.f3990f = new l0(key, objV);
                return true;
            } finally {
                this.f3987c.postReadCleanup();
            }
        }

        public m<K, V>.l0 c() {
            m<K, V>.l0 l0Var = this.f3990f;
            if (l0Var == null) {
                throw new NoSuchElementException();
            }
            this.f3991g = l0Var;
            a();
            return this.f3991g;
        }

        public boolean d() {
            e1.t<K, V> tVar = this.f3989e;
            if (tVar == null) {
                return false;
            }
            while (true) {
                this.f3989e = tVar.getNext();
                e1.t<K, V> tVar2 = this.f3989e;
                if (tVar2 == null) {
                    return false;
                }
                if (b(tVar2)) {
                    return true;
                }
                tVar = this.f3989e;
            }
        }

        public boolean e() {
            while (true) {
                int i10 = this.f3986b;
                if (i10 < 0) {
                    return false;
                }
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.f3988d;
                this.f3986b = i10 - 1;
                e1.t<K, V> tVar = atomicReferenceArray.get(i10);
                this.f3989e = tVar;
                if (tVar != null && (b(tVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3990f != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            c1.h0.g0(this.f3991g != null);
            m.this.remove(this.f3991g.f4000a);
            this.f3991g = null;
        }
    }

    public static final class i0<K, V> extends x<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3993b;

        public i0(V referent, int weight) {
            super(referent);
            this.f3993b = weight;
        }

        @Override // e1.m.x, e1.m.a0
        public int c() {
            return this.f3993b;
        }
    }

    public final class j extends m<K, V>.i<K> {
        public j(final m this$0) {
            super();
        }

        @Override // e1.m.i, java.util.Iterator
        public K next() {
            return c().f4000a;
        }
    }

    public static final class j0<K, V> extends f0<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3994b;

        public j0(ReferenceQueue<V> queue, V referent, e1.t<K, V> entry, int weight) {
            super(queue, referent, entry);
            this.f3994b = weight;
        }

        @Override // e1.m.f0, e1.m.a0
        public int c() {
            return this.f3994b;
        }

        @Override // e1.m.f0, e1.m.a0
        public a0<K, V> e(ReferenceQueue<V> queue, V value, e1.t<K, V> entry) {
            return new j0(queue, value, entry, this.f3994b);
        }
    }

    public final class k extends m<K, V>.c<K> {
        public k() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return m.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j(m.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return m.this.remove(o10) != null;
        }
    }

    public static final class k0<K, V> extends AbstractQueue<e1.t<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1.t<K, V> f3996a = new a(this);

        public class a extends d<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Weak
            public e1.t<K, V> f3997a = this;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Weak
            public e1.t<K, V> f3998b = this;

            public a(final k0 this$0) {
            }

            @Override // e1.m.d, e1.t
            public e1.t<K, V> getNextInWriteQueue() {
                return this.f3997a;
            }

            @Override // e1.m.d, e1.t
            public e1.t<K, V> getPreviousInWriteQueue() {
                return this.f3998b;
            }

            @Override // e1.m.d, e1.t
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // e1.m.d, e1.t
            public void setNextInWriteQueue(e1.t<K, V> next) {
                this.f3997a = next;
            }

            @Override // e1.m.d, e1.t
            public void setPreviousInWriteQueue(e1.t<K, V> previous) {
                this.f3998b = previous;
            }

            @Override // e1.m.d, e1.t
            public void setWriteTime(long time) {
            }
        }

        public class b extends f1.l<e1.t<K, V>> {
            public b(e1.t firstOrNull) {
                super(firstOrNull);
            }

            @Override // f1.l
            @gm.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e1.t<K, V> a(e1.t<K, V> previous) {
                e1.t<K, V> nextInWriteQueue = previous.getNextInWriteQueue();
                if (nextInWriteQueue == k0.this.f3996a) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(e1.t<K, V> entry) {
            m.e(entry.getPreviousInWriteQueue(), entry.getNextInWriteQueue());
            m.e(this.f3996a.getPreviousInWriteQueue(), entry);
            m.e(entry, this.f3996a);
            return true;
        }

        @Override // java.util.Queue
        @gm.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e1.t<K, V> peek() {
            e1.t<K, V> nextInWriteQueue = this.f3996a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f3996a) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        @gm.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e1.t<K, V> poll() {
            e1.t<K, V> nextInWriteQueue = this.f3996a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f3996a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            e1.t<K, V> nextInWriteQueue = this.f3996a.getNextInWriteQueue();
            while (true) {
                e1.t<K, V> tVar = this.f3996a;
                if (nextInWriteQueue == tVar) {
                    tVar.setNextInWriteQueue(tVar);
                    e1.t<K, V> tVar2 = this.f3996a;
                    tVar2.setPreviousInWriteQueue(tVar2);
                    return;
                } else {
                    e1.t<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    m.I(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o10) {
            return ((e1.t) o10).getNextInWriteQueue() != q.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f3996a.getNextInWriteQueue() == this.f3996a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<e1.t<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        @t1.a
        public boolean remove(Object o10) {
            e1.t tVar = (e1.t) o10;
            e1.t<K, V> previousInWriteQueue = tVar.getPreviousInWriteQueue();
            e1.t<K, V> nextInWriteQueue = tVar.getNextInWriteQueue();
            m.e(previousInWriteQueue, nextInWriteQueue);
            m.I(tVar);
            return nextInWriteQueue != q.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i10 = 0;
            for (e1.t<K, V> nextInWriteQueue = this.f3996a.getNextInWriteQueue(); nextInWriteQueue != this.f3996a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i10++;
            }
            return i10;
        }
    }

    public static final class l<K, V> extends p<K, V> implements e1.l<K, V>, Serializable {
        private static final long serialVersionUID = 1;

        @gm.a
        transient e1.l<K, V> autoDelegate;

        public l(m<K, V> cache) {
            super(cache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (e1.l<K, V>) recreateCacheBuilder().b(this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // e1.l, c1.t
        public V apply(K key) {
            return this.autoDelegate.apply(key);
        }

        @Override // e1.l
        public V get(K key) throws ExecutionException {
            return this.autoDelegate.get(key);
        }

        @Override // e1.l
        public k3<K, V> getAll(Iterable<? extends K> keys) throws ExecutionException {
            return this.autoDelegate.getAll(keys);
        }

        @Override // e1.l
        public V getUnchecked(K key) {
            return this.autoDelegate.getUnchecked(key);
        }

        @Override // e1.l
        public void refresh(K key) {
            this.autoDelegate.refresh(key);
        }
    }

    public final class l0 implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f4000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f4001b;

        public l0(K key, V value) {
            this.f4000a = key;
            this.f4001b = value;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@gm.a Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) object;
            return this.f4000a.equals(entry.getKey()) && this.f4001b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4000a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4001b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f4001b.hashCode() ^ this.f4000a.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = (V) m.this.put(this.f4000a, v10);
            this.f4001b = v10;
            return v11;
        }

        public String toString() {
            return this.f4000a + "=" + this.f4001b;
        }
    }

    /* JADX INFO: renamed from: e1.m$m, reason: collision with other inner class name */
    public static class C0093m<K, V> implements a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile a0<K, V> f4003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l2<V> f4004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o0 f4005c;

        public C0093m() {
            this(m.U());
        }

        public static /* synthetic */ Object g(C0093m c0093m, Object obj) {
            c0093m.m(obj);
            return obj;
        }

        @Override // e1.m.a0
        public e1.t<K, V> a() {
            return null;
        }

        @Override // e1.m.a0
        public void b(@gm.a V newValue) {
            if (newValue != null) {
                m(newValue);
            } else {
                this.f4003a = m.U();
            }
        }

        @Override // e1.m.a0
        public int c() {
            return this.f4003a.c();
        }

        @Override // e1.m.a0
        public boolean d() {
            return true;
        }

        @Override // e1.m.a0
        public a0<K, V> e(ReferenceQueue<V> queue, @gm.a V value, e1.t<K, V> entry) {
            return this;
        }

        @Override // e1.m.a0
        public V f() throws ExecutionException {
            return (V) e3.f(this.f4004b);
        }

        @Override // e1.m.a0
        public V get() {
            return this.f4003a.get();
        }

        public long h() {
            return this.f4005c.g(TimeUnit.NANOSECONDS);
        }

        public final s1<V> i(Throwable t10) {
            return h1.n(t10);
        }

        @Override // e1.m.a0
        public boolean isActive() {
            return this.f4003a.isActive();
        }

        public a0<K, V> j() {
            return this.f4003a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final /* synthetic */ Object k(Object obj) {
            m(obj);
            return obj;
        }

        public s1<V> l(K key, e1.g<? super K, V> loader) {
            try {
                this.f4005c.k();
                V v10 = this.f4003a.get();
                if (v10 == null) {
                    V vLoad = loader.load(key);
                    return m(vLoad) ? this.f4004b : h1.o(vLoad);
                }
                s1<V> s1VarReload = loader.reload(key, v10);
                return s1VarReload == null ? h1.o(null) : q1.r.N(s1VarReload, new c1.t() { // from class: e1.n
                    @Override // c1.t
                    public final Object apply(Object obj) {
                        this.f4027a.m(obj);
                        return obj;
                    }
                }, n0.INSTANCE);
            } catch (Throwable th2) {
                s1<V> s1VarN = n(th2) ? this.f4004b : h1.n(th2);
                if (th2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return s1VarN;
            }
        }

        @t1.a
        public boolean m(@gm.a V newValue) {
            return this.f4004b.B(newValue);
        }

        @t1.a
        public boolean n(Throwable t10) {
            return this.f4004b.C(t10);
        }

        public C0093m(a0<K, V> oldValue) {
            this.f4004b = l2.F();
            this.f4005c = new o0();
            this.f4003a = oldValue;
        }
    }

    public static class n<K, V> extends o<K, V> implements e1.l<K, V> {
        private static final long serialVersionUID = 1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(e1.d<? super K, ? super V> builder, e1.g<? super K, V> loader) {
            super(new m(builder, loader), null);
            loader.getClass();
        }

        private void readObject(ObjectInputStream in2) throws InvalidObjectException {
            throw new InvalidObjectException("Use LoadingSerializationProxy");
        }

        @Override // e1.l, c1.t
        public final V apply(K key) {
            return getUnchecked(key);
        }

        @Override // e1.l
        public V get(K key) throws ExecutionException {
            return this.localCache.w(key);
        }

        @Override // e1.l
        public k3<K, V> getAll(Iterable<? extends K> keys) throws ExecutionException {
            return this.localCache.r(keys);
        }

        @Override // e1.l
        @t1.a
        public V getUnchecked(K key) {
            try {
                return get(key);
            } catch (ExecutionException e10) {
                throw new c3(e10.getCause());
            }
        }

        @Override // e1.l
        public void refresh(K key) {
            this.localCache.P(key);
        }

        @Override // e1.m.o
        public Object writeReplace() {
            return new l(this.localCache);
        }
    }

    public static class o<K, V> implements e1.c<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final m<K, V> localCache;

        public class a extends e1.g<Object, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callable f4006a;

            public a(final o this$0, final Callable val$valueLoader) {
                this.f4006a = val$valueLoader;
            }

            @Override // e1.g
            public V load(Object obj) throws Exception {
                return (V) this.f4006a.call();
            }
        }

        public /* synthetic */ o(m mVar, a aVar) {
            this(mVar);
        }

        private void readObject(ObjectInputStream in2) throws InvalidObjectException {
            throw new InvalidObjectException("Use ManualSerializationProxy");
        }

        @Override // e1.c
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // e1.c
        public void cleanUp() {
            this.localCache.c();
        }

        @Override // e1.c
        public V get(K key, final Callable<? extends V> valueLoader) throws ExecutionException {
            valueLoader.getClass();
            return this.localCache.q(key, new a(this, valueLoader));
        }

        @Override // e1.c
        public k3<K, V> getAllPresent(Iterable<?> keys) {
            return this.localCache.s(keys);
        }

        @Override // e1.c
        @gm.a
        public V getIfPresent(Object key) {
            return this.localCache.u(key);
        }

        @Override // e1.c
        public void invalidate(Object key) {
            key.getClass();
            this.localCache.remove(key);
        }

        @Override // e1.c
        public void invalidateAll(Iterable<?> keys) {
            this.localCache.y(keys);
        }

        @Override // e1.c
        public void put(K key, V value) {
            this.localCache.put(key, value);
        }

        @Override // e1.c
        public void putAll(Map<? extends K, ? extends V> m10) {
            this.localCache.putAll(m10);
        }

        @Override // e1.c
        public long size() {
            return this.localCache.C();
        }

        @Override // e1.c
        public e1.h stats() {
            e1.a.C0089a c0089a = new e1.a.C0089a();
            c0089a.g(this.localCache.J);
            for (r<K, V> rVar : this.localCache.f3947c) {
                c0089a.g(rVar.statsCounter);
            }
            return c0089a.f();
        }

        public Object writeReplace() {
            return new p(this.localCache);
        }

        public o(e1.d<? super K, ? super V> builder) {
            this(new m(builder, null));
        }

        @Override // e1.c
        public void invalidateAll() {
            this.localCache.clear();
        }

        public o(m<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    public static class p<K, V> extends e1.j<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;

        @gm.a
        transient e1.c<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final c1.m<Object> keyEquivalence;
        final t keyStrength;
        final e1.g<? super K, V> loader;
        final long maxWeight;
        final e1.v<? super K, ? super V> removalListener;

        @gm.a
        final u0 ticker;
        final c1.m<Object> valueEquivalence;
        final t valueStrength;
        final e1.b0<K, V> weigher;

        public p(m<K, V> cache) {
            this(cache.f3951g, cache.f3952i, cache.f3949e, cache.f3950f, cache.f3956w, cache.f3955v, cache.f3953n, cache.f3954p, cache.f3948d, cache.f3959z, cache.H, cache.K);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = (e1.c<K, V>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        public e1.d<K, V> recreateCacheBuilder() {
            e1.d<K, V> dVar = (e1.d<K, V>) e1.d.D().H(this.keyStrength).I(this.valueStrength).z(this.keyEquivalence).L(this.valueEquivalence).e(this.concurrencyLevel).G(this.removalListener);
            dVar.f3893a = false;
            long j10 = this.expireAfterWriteNanos;
            if (j10 > 0) {
                dVar.g(j10, TimeUnit.NANOSECONDS);
            }
            long j11 = this.expireAfterAccessNanos;
            if (j11 > 0) {
                dVar.f(j11, TimeUnit.NANOSECONDS);
            }
            e1.b0 b0Var = this.weigher;
            if (b0Var != e1.d.f.INSTANCE) {
                dVar.O(b0Var);
                long j12 = this.maxWeight;
                if (j12 != -1) {
                    dVar.C(j12);
                }
            } else {
                long j13 = this.maxWeight;
                if (j13 != -1) {
                    dVar.B(j13);
                }
            }
            u0 u0Var = this.ticker;
            if (u0Var != null) {
                dVar.K(u0Var);
            }
            return dVar;
        }

        public p(t keyStrength, t valueStrength, c1.m<Object> keyEquivalence, c1.m<Object> valueEquivalence, long expireAfterWriteNanos, long expireAfterAccessNanos, long maxWeight, e1.b0<K, V> weigher, int concurrencyLevel, e1.v<? super K, ? super V> removalListener, u0 ticker, e1.g<? super K, V> loader) {
            this.keyStrength = keyStrength;
            this.valueStrength = valueStrength;
            this.keyEquivalence = keyEquivalence;
            this.valueEquivalence = valueEquivalence;
            this.expireAfterWriteNanos = expireAfterWriteNanos;
            this.expireAfterAccessNanos = expireAfterAccessNanos;
            this.maxWeight = maxWeight;
            this.weigher = weigher;
            this.concurrencyLevel = concurrencyLevel;
            this.removalListener = removalListener;
            this.ticker = (ticker == u0.b() || ticker == e1.d.f3891x) ? null : ticker;
            this.loader = loader;
        }

        @Override // e1.j, f1.j2
        public e1.c<K, V> delegate() {
            return this.delegate;
        }
    }

    public enum q implements e1.t<Object, Object> {
        INSTANCE;

        public static /* synthetic */ q[] a() {
            return new q[]{INSTANCE};
        }

        @Override // e1.t
        public long getAccessTime() {
            return 0L;
        }

        @Override // e1.t
        public int getHash() {
            return 0;
        }

        @Override // e1.t
        @gm.a
        public Object getKey() {
            return null;
        }

        @Override // e1.t
        @gm.a
        public e1.t<Object, Object> getNext() {
            return null;
        }

        @Override // e1.t
        public e1.t<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // e1.t
        public e1.t<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // e1.t
        public e1.t<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // e1.t
        public e1.t<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // e1.t
        @gm.a
        public a0<Object, Object> getValueReference() {
            return null;
        }

        @Override // e1.t
        public long getWriteTime() {
            return 0L;
        }

        @Override // e1.t
        public void setAccessTime(long time) {
        }

        @Override // e1.t
        public void setNextInAccessQueue(e1.t<Object, Object> next) {
        }

        @Override // e1.t
        public void setNextInWriteQueue(e1.t<Object, Object> next) {
        }

        @Override // e1.t
        public void setPreviousInAccessQueue(e1.t<Object, Object> previous) {
        }

        @Override // e1.t
        public void setPreviousInWriteQueue(e1.t<Object, Object> previous) {
        }

        @Override // e1.t
        public void setValueReference(a0<Object, Object> valueReference) {
        }

        @Override // e1.t
        public void setWriteTime(long time) {
        }
    }

    public static class s<K, V> extends SoftReference<V> implements a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1.t<K, V> f4008a;

        public s(ReferenceQueue<V> queue, V referent, e1.t<K, V> entry) {
            super(referent, queue);
            this.f4008a = entry;
        }

        @Override // e1.m.a0
        public e1.t<K, V> a() {
            return this.f4008a;
        }

        @Override // e1.m.a0
        public void b(V newValue) {
        }

        public int c() {
            return 1;
        }

        @Override // e1.m.a0
        public boolean d() {
            return false;
        }

        public a0<K, V> e(ReferenceQueue<V> queue, V value, e1.t<K, V> entry) {
            return new s(queue, value, entry);
        }

        @Override // e1.m.a0
        public V f() {
            return get();
        }

        @Override // e1.m.a0
        public boolean isActive() {
            return true;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class t {
        public static final t STRONG = new a("STRONG", 0);
        public static final t SOFT = new b("SOFT", 1);
        public static final t WEAK = new c("WEAK", 2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ t[] f4009a = a();

        public final enum a extends t {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.t
            public c1.m<Object> defaultEquivalence() {
                return c1.m.equals();
            }

            @Override // e1.m.t
            public <K, V> a0<K, V> referenceValue(r<K, V> segment, e1.t<K, V> entry, V value, int weight) {
                return weight == 1 ? new x(value) : new i0(value, weight);
            }
        }

        public final enum b extends t {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.t
            public c1.m<Object> defaultEquivalence() {
                return c1.m.identity();
            }

            @Override // e1.m.t
            public <K, V> a0<K, V> referenceValue(r<K, V> segment, e1.t<K, V> entry, V value, int weight) {
                return weight == 1 ? new s(segment.valueReferenceQueue, value, entry) : new h0(segment.valueReferenceQueue, value, entry, weight);
            }
        }

        public final enum c extends t {
            public c(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // e1.m.t
            public c1.m<Object> defaultEquivalence() {
                return c1.m.identity();
            }

            @Override // e1.m.t
            public <K, V> a0<K, V> referenceValue(r<K, V> segment, e1.t<K, V> entry, V value, int weight) {
                return weight == 1 ? new f0(segment.valueReferenceQueue, value, entry) : new j0(segment.valueReferenceQueue, value, entry, weight);
            }
        }

        public t(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ t[] a() {
            return new t[]{STRONG, SOFT, WEAK};
        }

        public static t valueOf(String name) {
            return (t) Enum.valueOf(t.class, name);
        }

        public static t[] values() {
            return (t[]) f4009a.clone();
        }

        public abstract c1.m<Object> defaultEquivalence();

        public abstract <K, V> a0<K, V> referenceValue(r<K, V> segment, e1.t<K, V> entry, V value, int weight);

        public t(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static final class u<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f4010e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f4011f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f4012g;

        public u(K key, int hash, @gm.a e1.t<K, V> next) {
            super(key, hash, next);
            this.f4010e = Long.MAX_VALUE;
            this.f4011f = m.G();
            this.f4012g = q.INSTANCE;
        }

        @Override // e1.m.d, e1.t
        public long getAccessTime() {
            return this.f4010e;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getNextInAccessQueue() {
            return this.f4011f;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getPreviousInAccessQueue() {
            return this.f4012g;
        }

        @Override // e1.m.d, e1.t
        public void setAccessTime(long time) {
            this.f4010e = time;
        }

        @Override // e1.m.d, e1.t
        public void setNextInAccessQueue(e1.t<K, V> next) {
            this.f4011f = next;
        }

        @Override // e1.m.d, e1.t
        public void setPreviousInAccessQueue(e1.t<K, V> previous) {
            this.f4012g = previous;
        }
    }

    public static final class v<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f4013e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f4014f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f4015g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile long f4016i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f4017n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f4018p;

        public v(K key, int hash, @gm.a e1.t<K, V> next) {
            super(key, hash, next);
            this.f4013e = Long.MAX_VALUE;
            this.f4014f = m.G();
            q qVar = q.INSTANCE;
            this.f4015g = qVar;
            this.f4016i = Long.MAX_VALUE;
            this.f4017n = qVar;
            this.f4018p = qVar;
        }

        @Override // e1.m.d, e1.t
        public long getAccessTime() {
            return this.f4013e;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getNextInAccessQueue() {
            return this.f4014f;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getNextInWriteQueue() {
            return this.f4017n;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getPreviousInAccessQueue() {
            return this.f4015g;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getPreviousInWriteQueue() {
            return this.f4018p;
        }

        @Override // e1.m.d, e1.t
        public long getWriteTime() {
            return this.f4016i;
        }

        @Override // e1.m.d, e1.t
        public void setAccessTime(long time) {
            this.f4013e = time;
        }

        @Override // e1.m.d, e1.t
        public void setNextInAccessQueue(e1.t<K, V> next) {
            this.f4014f = next;
        }

        @Override // e1.m.d, e1.t
        public void setNextInWriteQueue(e1.t<K, V> next) {
            this.f4017n = next;
        }

        @Override // e1.m.d, e1.t
        public void setPreviousInAccessQueue(e1.t<K, V> previous) {
            this.f4015g = previous;
        }

        @Override // e1.m.d, e1.t
        public void setPreviousInWriteQueue(e1.t<K, V> previous) {
            this.f4018p = previous;
        }

        @Override // e1.m.d, e1.t
        public void setWriteTime(long time) {
            this.f4016i = time;
        }
    }

    public static class w<K, V> extends d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f4019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public final e1.t<K, V> f4021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile a0<K, V> f4022d = m.U();

        public w(K key, int hash, @gm.a e1.t<K, V> next) {
            this.f4019a = key;
            this.f4020b = hash;
            this.f4021c = next;
        }

        @Override // e1.m.d, e1.t
        public int getHash() {
            return this.f4020b;
        }

        @Override // e1.m.d, e1.t
        public K getKey() {
            return this.f4019a;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getNext() {
            return this.f4021c;
        }

        @Override // e1.m.d, e1.t
        public a0<K, V> getValueReference() {
            return this.f4022d;
        }

        @Override // e1.m.d, e1.t
        public void setValueReference(a0<K, V> valueReference) {
            this.f4022d = valueReference;
        }
    }

    public static class x<K, V> implements a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f4023a;

        public x(V referent) {
            this.f4023a = referent;
        }

        @Override // e1.m.a0
        public e1.t<K, V> a() {
            return null;
        }

        @Override // e1.m.a0
        public void b(V newValue) {
        }

        @Override // e1.m.a0
        public int c() {
            return 1;
        }

        @Override // e1.m.a0
        public boolean d() {
            return false;
        }

        @Override // e1.m.a0
        public a0<K, V> e(ReferenceQueue<V> queue, V value, e1.t<K, V> entry) {
            return this;
        }

        @Override // e1.m.a0
        public V f() {
            return get();
        }

        @Override // e1.m.a0
        public V get() {
            return this.f4023a;
        }

        @Override // e1.m.a0
        public boolean isActive() {
            return true;
        }
    }

    public static final class y<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f4024e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f4025f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Weak
        public e1.t<K, V> f4026g;

        public y(K key, int hash, @gm.a e1.t<K, V> next) {
            super(key, hash, next);
            this.f4024e = Long.MAX_VALUE;
            this.f4025f = m.G();
            this.f4026g = q.INSTANCE;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getNextInWriteQueue() {
            return this.f4025f;
        }

        @Override // e1.m.d, e1.t
        public e1.t<K, V> getPreviousInWriteQueue() {
            return this.f4026g;
        }

        @Override // e1.m.d, e1.t
        public long getWriteTime() {
            return this.f4024e;
        }

        @Override // e1.m.d, e1.t
        public void setNextInWriteQueue(e1.t<K, V> next) {
            this.f4025f = next;
        }

        @Override // e1.m.d, e1.t
        public void setPreviousInWriteQueue(e1.t<K, V> previous) {
            this.f4026g = previous;
        }

        @Override // e1.m.d, e1.t
        public void setWriteTime(long time) {
            this.f4024e = time;
        }
    }

    public final class z extends m<K, V>.i<V> {
        public z(final m this$0) {
            super();
        }

        @Override // e1.m.i, java.util.Iterator
        public V next() {
            return c().f4001b;
        }
    }

    public m(e1.d<? super K, ? super V> dVar, @gm.a e1.g<? super K, V> gVar) {
        this.f3948d = Math.min(dVar.j(), 65536);
        t tVarO = dVar.o();
        this.f3951g = tVarO;
        this.f3952i = dVar.v();
        this.f3949e = dVar.n();
        this.f3950f = dVar.u();
        long jP = dVar.p();
        this.f3953n = jP;
        this.f3954p = (e1.b0<K, V>) dVar.w();
        this.f3955v = dVar.k();
        this.f3956w = dVar.l();
        this.f3957x = dVar.q();
        e1.d.e eVar = (e1.v<K, V>) dVar.r();
        this.f3959z = eVar;
        this.f3958y = eVar == e1.d.e.INSTANCE ? (Queue<e1.z<K, V>>) V : new ConcurrentLinkedQueue();
        this.H = dVar.t(N());
        this.I = f.getFactory(tVarO, V(), Z());
        this.J = dVar.f3908p.get();
        this.K = gVar;
        int iMin = Math.min(dVar.m(), 1073741824);
        if (j() && !h()) {
            iMin = (int) Math.min(iMin, jP);
        }
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        int i13 = 1;
        while (i13 < this.f3948d && (!j() || ((long) i13) * 20 <= this.f3953n)) {
            i12++;
            i13 <<= 1;
        }
        this.f3946b = 32 - i12;
        this.f3945a = i13 - 1;
        this.f3947c = new r[i13];
        int i14 = iMin / i13;
        while (i11 < (i14 * i13 < iMin ? i14 + 1 : i14)) {
            i11 <<= 1;
        }
        if (j()) {
            long j10 = this.f3953n;
            long j11 = i13;
            long j12 = (j10 / j11) + 1;
            long j13 = j10 % j11;
            while (true) {
                r<K, V>[] rVarArr = this.f3947c;
                if (i10 >= rVarArr.length) {
                    return;
                }
                if (i10 == j13) {
                    j12--;
                }
                rVarArr[i10] = g(i11, j12, dVar.f3908p.get());
                i10++;
            }
        } else {
            while (true) {
                r<K, V>[] rVarArr2 = this.f3947c;
                if (i10 >= rVarArr2.length) {
                    return;
                }
                rVarArr2[i10] = g(i11, -1L, dVar.f3908p.get());
                i10++;
            }
        }
    }

    public static <K, V> e1.t<K, V> G() {
        return q.INSTANCE;
    }

    public static <K, V> void H(e1.t<K, V> nulled) {
        q qVar = q.INSTANCE;
        nulled.setNextInAccessQueue(qVar);
        nulled.setPreviousInAccessQueue(qVar);
    }

    public static <K, V> void I(e1.t<K, V> nulled) {
        q qVar = q.INSTANCE;
        nulled.setNextInWriteQueue(qVar);
        nulled.setPreviousInWriteQueue(qVar);
    }

    public static int R(int h10) {
        int i10 = h10 + ((h10 << 15) ^ (-12931));
        int i11 = i10 ^ (i10 >>> 10);
        int i12 = i11 + (i11 << 3);
        int i13 = i12 ^ (i12 >>> 6);
        int i14 = (i13 << 2) + (i13 << 14) + i13;
        return (i14 >>> 16) ^ i14;
    }

    public static <E> ArrayList<E> T(Collection<E> c10) {
        ArrayList<E> arrayList = new ArrayList<>(c10.size());
        h4.a(arrayList, c10.iterator());
        return arrayList;
    }

    public static <K, V> a0<K, V> U() {
        return (a0<K, V>) U;
    }

    public static <K, V> void d(e1.t<K, V> previous, e1.t<K, V> next) {
        previous.setNextInAccessQueue(next);
        next.setPreviousInAccessQueue(previous);
    }

    public static <K, V> void e(e1.t<K, V> previous, e1.t<K, V> next) {
        previous.setNextInWriteQueue(next);
        next.setPreviousInWriteQueue(previous);
    }

    public static <E> Queue<E> i() {
        return (Queue<E>) V;
    }

    @b1.e
    public boolean A(e1.t<K, V> entry, long now) {
        return S(entry.getHash()).getLiveValue(entry, now) != null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    @gm.a
    public Map<K, V> B(Set<? extends K> set, e1.g<? super K, V> gVar) throws Throwable {
        gVar.getClass();
        set.getClass();
        o0 o0VarC = o0.c();
        boolean z10 = true;
        boolean z11 = false;
        try {
            try {
                try {
                    Map<? super K, V> mapLoadAll = gVar.loadAll(set);
                    if (mapLoadAll == null) {
                        this.J.d(o0VarC.g(TimeUnit.NANOSECONDS));
                        throw new e1.g.c(gVar + " returned null map from loadAll");
                    }
                    o0VarC.l();
                    for (Map.Entry<K, V> entry : mapLoadAll.entrySet()) {
                        K key = entry.getKey();
                        V value = entry.getValue();
                        if (key == null || value == null) {
                            z11 = true;
                        } else {
                            put(key, value);
                        }
                    }
                    if (!z11) {
                        this.J.e(o0VarC.g(TimeUnit.NANOSECONDS));
                        return mapLoadAll;
                    }
                    this.J.d(o0VarC.g(TimeUnit.NANOSECONDS));
                    throw new e1.g.c(gVar + " returned null keys or values from loadAll");
                } catch (e1.g.e e10) {
                    try {
                        throw e10;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z10) {
                            this.J.d(o0VarC.g(TimeUnit.NANOSECONDS));
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    throw new ExecutionException(e11);
                }
            } catch (Error e12) {
                throw new p0(e12);
            } catch (InterruptedException e13) {
                Thread.currentThread().interrupt();
                throw new ExecutionException(e13);
            } catch (RuntimeException e14) {
                throw new c3(e14);
            }
        } catch (Throwable th3) {
            th = th3;
            z10 = false;
            if (!z10) {
                this.J.d(o0VarC.g(TimeUnit.NANOSECONDS));
            }
            throw th;
        }
    }

    public long C() {
        long jMax = 0;
        for (r<K, V> rVar : this.f3947c) {
            jMax += (long) Math.max(0, rVar.count);
        }
        return jMax;
    }

    @b1.e
    public e1.t<K, V> D(K key, int hash, @gm.a e1.t<K, V> next) {
        r<K, V> rVarS = S(hash);
        rVarS.lock();
        try {
            return rVarS.newEntry(key, hash, next);
        } finally {
            rVarS.unlock();
        }
    }

    public final r<K, V>[] E(int ssize) {
        return new r[ssize];
    }

    @b1.e
    public a0<K, V> F(e1.t<K, V> entry, V value, int weight) {
        int hash = entry.getHash();
        t tVar = this.f3952i;
        r<K, V> rVarS = S(hash);
        value.getClass();
        return tVar.referenceValue(rVarS, entry, value, weight);
    }

    public void J() {
        while (true) {
            e1.z<K, V> zVarPoll = this.f3958y.poll();
            if (zVarPoll == null) {
                return;
            }
            try {
                this.f3959z.onRemoval(zVarPoll);
            } catch (Throwable th2) {
                T.log(Level.WARNING, "Exception thrown by removal listener", th2);
            }
        }
    }

    public void K(e1.t<K, V> entry) {
        int hash = entry.getHash();
        S(hash).reclaimKey(entry, hash);
    }

    public void L(a0<K, V> valueReference) {
        e1.t<K, V> tVarA = valueReference.a();
        int hash = tVarA.getHash();
        S(hash).reclaimValue(tVarA.getKey(), hash, valueReference);
    }

    public boolean M() {
        return m();
    }

    public boolean N() {
        return O() || M();
    }

    public boolean O() {
        return p() || Q();
    }

    public void P(K key) {
        key.getClass();
        int iX = x(key);
        S(iX).refresh(key, iX, this.K, false);
    }

    public boolean Q() {
        return this.f3957x > 0;
    }

    public r<K, V> S(int hash) {
        return this.f3947c[this.f3945a & (hash >>> this.f3946b)];
    }

    public boolean V() {
        return W() || M();
    }

    public boolean W() {
        return m() || j();
    }

    public boolean X() {
        return this.f3951g != t.STRONG;
    }

    public boolean Y() {
        return this.f3952i != t.STRONG;
    }

    public boolean Z() {
        return a0() || O();
    }

    public boolean a0() {
        return p();
    }

    public void c() {
        for (r<K, V> rVar : this.f3947c) {
            rVar.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (r<K, V> rVar : this.f3947c) {
            rVar.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@gm.a Object key) {
        if (key == null) {
            return false;
        }
        int iX = x(key);
        return S(iX).containsKey(key, iX);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@gm.a Object obj) {
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        long jA = this.H.a();
        r<K, V>[] rVarArr = this.f3947c;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            int length = rVarArr.length;
            long j11 = 0;
            for (?? r12 = z10; r12 < length; r12++) {
                r<K, V> rVar = rVarArr[r12];
                int i11 = rVar.count;
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = rVar.table;
                for (?? r15 = z10; r15 < atomicReferenceArray.length(); r15++) {
                    e1.t<K, V> next = atomicReferenceArray.get(r15);
                    while (next != null) {
                        r<K, V>[] rVarArr2 = rVarArr;
                        V liveValue = rVar.getLiveValue(next, jA);
                        long j12 = jA;
                        if (liveValue != null && this.f3950f.equivalent(obj, liveValue)) {
                            return true;
                        }
                        next = next.getNext();
                        rVarArr = rVarArr2;
                        jA = j12;
                    }
                }
                j11 += (long) rVar.modCount;
                jA = jA;
                z10 = false;
            }
            long j13 = jA;
            r<K, V>[] rVarArr3 = rVarArr;
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
            rVarArr = rVarArr3;
            jA = j13;
            z10 = false;
        }
        return z10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @b1.c
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.N;
        if (set != null) {
            return set;
        }
        h hVar = new h();
        this.N = hVar;
        return hVar;
    }

    @b1.e
    public e1.t<K, V> f(e1.t<K, V> original, e1.t<K, V> newNext) {
        return S(original.getHash()).copyEntry(original, newNext);
    }

    public r<K, V> g(int initialCapacity, long maxSegmentWeight, e1.a.b statsCounter) {
        return new r<>(this, initialCapacity, maxSegmentWeight, statsCounter);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    @t1.a
    public V get(@gm.a Object key) {
        if (key == null) {
            return null;
        }
        int iX = x(key);
        return S(iX).get(key, iX);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @gm.a
    public V getOrDefault(@gm.a Object key, @gm.a V defaultValue) {
        V v10 = get(key);
        return v10 != null ? v10 : defaultValue;
    }

    public boolean h() {
        return this.f3954p != e1.d.f.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        r<K, V>[] rVarArr = this.f3947c;
        long j10 = 0;
        for (r<K, V> rVar : rVarArr) {
            if (rVar.count != 0) {
                return false;
            }
            j10 += (long) rVar.modCount;
        }
        if (j10 == 0) {
            return true;
        }
        for (r<K, V> rVar2 : rVarArr) {
            if (rVar2.count != 0) {
                return false;
            }
            j10 -= (long) rVar2.modCount;
        }
        return j10 == 0;
    }

    public boolean j() {
        return this.f3953n >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.L;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.L = kVar;
        return kVar;
    }

    public boolean l() {
        return p() || m();
    }

    public boolean m() {
        return this.f3955v > 0;
    }

    public boolean p() {
        return this.f3956w > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    @t1.a
    public V put(K key, V value) {
        key.getClass();
        value.getClass();
        int iX = x(key);
        return S(iX).put(key, iX, value, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m10) {
        for (Map.Entry<? extends K, ? extends V> entry : m10.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @gm.a
    public V putIfAbsent(K key, V value) {
        key.getClass();
        value.getClass();
        int iX = x(key);
        return S(iX).put(key, iX, value, true);
    }

    @t1.a
    public V q(K key, e1.g<? super K, V> loader) throws ExecutionException {
        key.getClass();
        int iX = x(key);
        return S(iX).get(key, iX, loader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k3<K, V> r(Iterable<? extends K> keys) throws ExecutionException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i10 = 0;
        int i11 = 0;
        for (K k10 : keys) {
            Object obj = get(k10);
            if (!linkedHashMap.containsKey(k10)) {
                linkedHashMap.put(k10, obj);
                if (obj == null) {
                    i11++;
                    linkedHashSet.add(k10);
                } else {
                    i10++;
                }
            }
        }
        try {
            if (!linkedHashSet.isEmpty()) {
                try {
                    Map mapB = B(Collections.unmodifiableSet(linkedHashSet), this.K);
                    for (Object obj2 : linkedHashSet) {
                        Object obj3 = mapB.get(obj2);
                        if (obj3 == null) {
                            throw new e1.g.c("loadAll failed to return a value for " + obj2);
                        }
                        linkedHashMap.put(obj2, obj3);
                    }
                } catch (e1.g.e unused) {
                    for (Object obj4 : linkedHashSet) {
                        i11--;
                        linkedHashMap.put(obj4, q(obj4, this.K));
                    }
                }
            }
            k3<K, V> k3VarCopyOf = k3.copyOf((Map) linkedHashMap);
            this.J.a(i10);
            this.J.b(i11);
            return k3VarCopyOf;
        } catch (Throwable th2) {
            this.J.a(i10);
            this.J.b(i11);
            throw th2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    @t1.a
    public V remove(@gm.a Object key) {
        if (key == null) {
            return null;
        }
        int iX = x(key);
        return S(iX).remove(key, iX);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @gm.a
    @t1.a
    public V replace(K key, V value) {
        key.getClass();
        value.getClass();
        int iX = x(key);
        return S(iX).replace(key, iX, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k3<K, V> s(Iterable<?> keys) {
        k3.b bVarBuilder = k3.builder();
        int i10 = 0;
        int i11 = 0;
        for (Object obj : keys) {
            V v10 = get(obj);
            if (v10 == null) {
                i11++;
            } else {
                bVarBuilder.i(obj, v10);
                i10++;
            }
        }
        this.J.a(i10);
        this.J.b(i11);
        return bVarBuilder.c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return o1.l.z(C());
    }

    @gm.a
    public e1.t<K, V> t(@gm.a Object key) {
        if (key == null) {
            return null;
        }
        int iX = x(key);
        return S(iX).getEntry(key, iX);
    }

    @gm.a
    public V u(Object key) {
        key.getClass();
        int iX = x(key);
        V v10 = S(iX).get(key, iX);
        if (v10 == null) {
            this.J.b(1);
        } else {
            this.J.a(1);
        }
        return v10;
    }

    @gm.a
    public V v(e1.t<K, V> entry, long now) {
        V v10;
        if (entry.getKey() == null || (v10 = entry.getValueReference().get()) == null || z(entry, now)) {
            return null;
        }
        return v10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.M;
        if (collection != null) {
            return collection;
        }
        b0 b0Var = new b0();
        this.M = b0Var;
        return b0Var;
    }

    public V w(K key) throws ExecutionException {
        return q(key, this.K);
    }

    public int x(@gm.a Object key) {
        return R(this.f3949e.hash(key));
    }

    public void y(Iterable<?> keys) {
        Iterator<?> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public boolean z(e1.t<K, V> entry, long now) {
        entry.getClass();
        if (!m() || now - entry.getAccessTime() < this.f3955v) {
            return p() && now - entry.getWriteTime() >= this.f3956w;
        }
        return true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @t1.a
    public boolean remove(@gm.a Object key, @gm.a Object value) {
        if (key == null || value == null) {
            return false;
        }
        int iX = x(key);
        return S(iX).remove(key, iX, value);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @t1.a
    public boolean replace(K key, @gm.a V oldValue, V newValue) {
        key.getClass();
        newValue.getClass();
        if (oldValue == null) {
            return false;
        }
        int iX = x(key);
        return S(iX).replace(key, iX, oldValue, newValue);
    }

    public static class r<K, V> extends ReentrantLock {

        @u1.a("this")
        final Queue<e1.t<K, V>> accessQueue;
        volatile int count;

        @gm.a
        final ReferenceQueue<K> keyReferenceQueue;

        @Weak
        final m<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<e1.t<K, V>> recencyQueue;
        final e1.a.b statsCounter;

        @gm.a
        volatile AtomicReferenceArray<e1.t<K, V>> table;
        int threshold;

        @u1.a("this")
        long totalWeight;

        @gm.a
        final ReferenceQueue<V> valueReferenceQueue;

        @u1.a("this")
        final Queue<e1.t<K, V>> writeQueue;

        public r(m<K, V> mVar, int i10, long j10, e1.a.b bVar) {
            this.map = mVar;
            this.maxSegmentWeight = j10;
            bVar.getClass();
            this.statsCounter = bVar;
            initTable(newEntryArray(i10));
            this.keyReferenceQueue = mVar.X() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = mVar.Y() ? new ReferenceQueue<>() : null;
            this.recencyQueue = mVar.W() ? new ConcurrentLinkedQueue() : (Queue<e1.t<K, V>>) m.V;
            this.writeQueue = mVar.a0() ? new k0() : (Queue<e1.t<K, V>>) m.V;
            this.accessQueue = mVar.W() ? new e() : (Queue<e1.t<K, V>>) m.V;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final /* synthetic */ void b(Object obj, int i10, C0093m c0093m, s1 s1Var) {
            try {
                getAndRecordStats(obj, i10, c0093m, s1Var);
            } catch (Throwable th2) {
                m.T.log(Level.WARNING, "Exception thrown during refresh", th2);
                c0093m.n(th2);
            }
        }

        public void cleanUp() {
            runLockedCleanup(this.map.H.a());
            runUnlockedCleanup();
        }

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.H.a());
                    AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                    for (int i10 = 0; i10 < atomicReferenceArray.length(); i10++) {
                        for (e1.t<K, V> next = atomicReferenceArray.get(i10); next != null; next = next.getNext()) {
                            if (next.getValueReference().isActive()) {
                                K key = next.getKey();
                                V v10 = next.getValueReference().get();
                                enqueueNotification(key, next.getHash(), v10, next.getValueReference().c(), (key == null || v10 == null) ? e1.u.COLLECTED : e1.u.EXPLICIT);
                            }
                        }
                    }
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        atomicReferenceArray.set(i11, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        public void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        public void clearReferenceQueues() {
            if (this.map.X()) {
                clearKeyReferenceQueue();
            }
            if (this.map.Y()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        public boolean containsKey(Object key, int hash) {
            try {
                if (this.count == 0) {
                    return false;
                }
                e1.t<K, V> liveEntry = getLiveEntry(key, hash, this.map.H.a());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        @b1.e
        public boolean containsValue(Object value) {
            try {
                if (this.count != 0) {
                    long jA = this.map.H.a();
                    AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        for (e1.t<K, V> next = atomicReferenceArray.get(i10); next != null; next = next.getNext()) {
                            V liveValue = getLiveValue(next, jA);
                            if (liveValue != null && this.map.f3950f.equivalent(value, liveValue)) {
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
        @u1.a("this")
        public e1.t<K, V> copyEntry(e1.t<K, V> original, e1.t<K, V> newNext) {
            K key = original.getKey();
            if (key == null) {
                return null;
            }
            a0<K, V> valueReference = original.getValueReference();
            V v10 = valueReference.get();
            if (v10 == null && valueReference.isActive()) {
                return null;
            }
            e1.t<K, V> tVarCopyEntry = this.map.I.copyEntry(this, original, newNext, key);
            tVarCopyEntry.setValueReference(valueReference.e(this.valueReferenceQueue, v10, tVarCopyEntry));
            return tVarCopyEntry;
        }

        @u1.a("this")
        public void drainKeyReferenceQueue() {
            int i10 = 0;
            do {
                Reference<? extends K> referencePoll = this.keyReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.K((e1.t) referencePoll);
                i10++;
            } while (i10 != 16);
        }

        @u1.a("this")
        public void drainRecencyQueue() {
            while (true) {
                e1.t<K, V> tVarPoll = this.recencyQueue.poll();
                if (tVarPoll == null) {
                    return;
                }
                if (this.accessQueue.contains(tVarPoll)) {
                    this.accessQueue.add(tVarPoll);
                }
            }
        }

        @u1.a("this")
        public void drainReferenceQueues() {
            if (this.map.X()) {
                drainKeyReferenceQueue();
            }
            if (this.map.Y()) {
                drainValueReferenceQueue();
            }
        }

        @u1.a("this")
        public void drainValueReferenceQueue() {
            int i10 = 0;
            do {
                Reference<? extends V> referencePoll = this.valueReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.L((a0) referencePoll);
                i10++;
            } while (i10 != 16);
        }

        @u1.a("this")
        public void enqueueNotification(@gm.a K key, int hash, @gm.a V value, int weight, e1.u cause) {
            this.totalWeight -= (long) weight;
            if (cause.wasEvicted()) {
                this.statsCounter.c();
            }
            if (this.map.f3958y != m.V) {
                this.map.f3958y.offer(e1.z.create(key, value, cause));
            }
        }

        @u1.a("this")
        public void evictEntries(e1.t<K, V> newest) {
            if (this.map.j()) {
                drainRecencyQueue();
                if (newest.getValueReference().c() > this.maxSegmentWeight && !removeEntry(newest, newest.getHash(), e1.u.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    e1.t<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), e1.u.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        @u1.a("this")
        public void expand() {
            AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i10 = this.count;
            AtomicReferenceArray<e1.t<K, V>> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i11 = 0; i11 < length; i11++) {
                e1.t<K, V> next = atomicReferenceArray.get(i11);
                if (next != null) {
                    e1.t<K, V> next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, next);
                    } else {
                        e1.t<K, V> tVar = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                tVar = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, tVar);
                        while (next != tVar) {
                            int hash3 = next.getHash() & length2;
                            e1.t<K, V> tVarCopyEntry = copyEntry(next, atomicReferenceArrayNewEntryArray.get(hash3));
                            if (tVarCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, tVarCopyEntry);
                            } else {
                                removeCollectedEntry(next);
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

        @u1.a("this")
        public void expireEntries(long now) {
            e1.t<K, V> tVarPeek;
            e1.t<K, V> tVarPeek2;
            drainRecencyQueue();
            do {
                tVarPeek = this.writeQueue.peek();
                if (tVarPeek == null || !this.map.z(tVarPeek, now)) {
                    do {
                        tVarPeek2 = this.accessQueue.peek();
                        if (tVarPeek2 == null || !this.map.z(tVarPeek2, now)) {
                            return;
                        }
                    } while (removeEntry(tVarPeek2, tVarPeek2.getHash(), e1.u.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(tVarPeek, tVarPeek.getHash(), e1.u.EXPIRED));
            throw new AssertionError();
        }

        @t1.a
        public V get(K key, int hash, e1.g<? super K, V> loader) throws ExecutionException {
            e1.t<K, V> entry;
            key.getClass();
            loader.getClass();
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(key, hash)) != null) {
                        long jA = this.map.H.a();
                        V liveValue = getLiveValue(entry, jA);
                        if (liveValue != null) {
                            recordRead(entry, jA);
                            this.statsCounter.a(1);
                            V vScheduleRefresh = scheduleRefresh(entry, key, hash, liveValue, jA, loader);
                            postReadCleanup();
                            return vScheduleRefresh;
                        }
                        a0<K, V> valueReference = entry.getValueReference();
                        if (valueReference.d()) {
                            V vWaitForLoadingValue = waitForLoadingValue(entry, key, valueReference);
                            postReadCleanup();
                            return vWaitForLoadingValue;
                        }
                    }
                    V vLockedGetOrLoad = lockedGetOrLoad(key, hash, loader);
                    postReadCleanup();
                    return vLockedGetOrLoad;
                } catch (ExecutionException e10) {
                    Throwable cause = e10.getCause();
                    if (cause instanceof Error) {
                        throw new p0((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new c3(cause);
                    }
                    throw e10;
                }
            } catch (Throwable th2) {
                postReadCleanup();
                throw th2;
            }
        }

        @t1.a
        public V getAndRecordStats(K k10, int i10, C0093m<K, V> c0093m, s1<V> s1Var) throws Throwable {
            V v10;
            try {
                v10 = (V) e3.f(s1Var);
                try {
                    if (v10 != null) {
                        this.statsCounter.e(c0093m.h());
                        storeLoadedValue(k10, i10, c0093m, v10);
                        return v10;
                    }
                    throw new e1.g.c("CacheLoader returned null for key " + k10 + ".");
                } catch (Throwable th2) {
                    th = th2;
                    if (v10 == null) {
                        this.statsCounter.d(c0093m.h());
                        removeLoadingValue(k10, i10, c0093m);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                v10 = null;
            }
        }

        @gm.a
        public e1.t<K, V> getEntry(Object key, int hash) {
            for (e1.t<K, V> first = getFirst(hash); first != null; first = first.getNext()) {
                if (first.getHash() == hash) {
                    K key2 = first.getKey();
                    if (key2 == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.f3949e.equivalent(key, key2)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public e1.t<K, V> getFirst(int hash) {
            AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(hash & (atomicReferenceArray.length() - 1));
        }

        @gm.a
        public e1.t<K, V> getLiveEntry(Object key, int hash, long now) {
            e1.t<K, V> entry = getEntry(key, hash);
            if (entry == null) {
                return null;
            }
            if (!this.map.z(entry, now)) {
                return entry;
            }
            tryExpireEntries(now);
            return null;
        }

        public V getLiveValue(e1.t<K, V> entry, long now) {
            if (entry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v10 = entry.getValueReference().get();
            if (v10 == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.z(entry, now)) {
                return v10;
            }
            tryExpireEntries(now);
            return null;
        }

        @u1.a("this")
        public e1.t<K, V> getNextEvictable() {
            for (e1.t<K, V> tVar : this.accessQueue) {
                if (tVar.getValueReference().c() > 0) {
                    return tVar;
                }
            }
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<e1.t<K, V>> newTable) {
            this.threshold = (newTable.length() * 3) / 4;
            if (!this.map.h()) {
                int i10 = this.threshold;
                if (i10 == this.maxSegmentWeight) {
                    this.threshold = i10 + 1;
                }
            }
            this.table = newTable;
        }

        @gm.a
        public C0093m<K, V> insertLoadingValueReference(K k10, int i10, boolean z10) {
            lock();
            try {
                long jA = this.map.H.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                e1.t<K, V> tVar = (e1.t) atomicReferenceArray.get(length);
                for (e1.t next = tVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i10 && key != null && this.map.f3949e.equivalent(k10, key)) {
                        a0<K, V> valueReference = next.getValueReference();
                        if (!valueReference.d() && (!z10 || jA - next.getWriteTime() >= this.map.f3957x)) {
                            this.modCount++;
                            C0093m<K, V> c0093m = new C0093m<>(valueReference);
                            next.setValueReference(c0093m);
                            return c0093m;
                        }
                        return null;
                    }
                }
                this.modCount++;
                C0093m<K, V> c0093m2 = new C0093m<>();
                e1.t<K, V> tVarNewEntry = newEntry(k10, i10, tVar);
                tVarNewEntry.setValueReference(c0093m2);
                atomicReferenceArray.set(length, tVarNewEntry);
                return c0093m2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public s1<V> loadAsync(final K key, final int hash, final C0093m<K, V> loadingValueReference, e1.g<? super K, V> loader) {
            final s1<V> s1VarL = loadingValueReference.l(key, loader);
            s1VarL.addListener(new Runnable() { // from class: e1.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4028a.b(key, hash, loadingValueReference, s1VarL);
                }
            }, n0.INSTANCE);
            return s1VarL;
        }

        public V loadSync(K key, int hash, C0093m<K, V> loadingValueReference, e1.g<? super K, V> loader) throws ExecutionException {
            return getAndRecordStats(key, hash, loadingValueReference, loadingValueReference.l(key, loader));
        }

        public V lockedGetOrLoad(K key, int hash, e1.g<? super K, V> loader) throws ExecutionException {
            C0093m<K, V> c0093m;
            boolean z10;
            a0<K, V> a0Var;
            V vLoadSync;
            lock();
            try {
                long jA = this.map.H.a();
                preWriteCleanup(jA);
                int i10 = this.count - 1;
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                e1.t<K, V> tVarNewEntry = tVar;
                while (true) {
                    c0093m = null;
                    if (tVarNewEntry == null) {
                        z10 = true;
                        a0Var = null;
                        break;
                    }
                    K key2 = tVarNewEntry.getKey();
                    if (tVarNewEntry.getHash() == hash && key2 != null && this.map.f3949e.equivalent(key, key2)) {
                        a0<K, V> valueReference = tVarNewEntry.getValueReference();
                        if (valueReference.d()) {
                            z10 = false;
                        } else {
                            V v10 = valueReference.get();
                            if (v10 == null) {
                                enqueueNotification(key2, hash, v10, valueReference.c(), e1.u.COLLECTED);
                            } else {
                                if (!this.map.z(tVarNewEntry, jA)) {
                                    recordLockedRead(tVarNewEntry, jA);
                                    this.statsCounter.a(1);
                                    unlock();
                                    postWriteCleanup();
                                    return v10;
                                }
                                enqueueNotification(key2, hash, v10, valueReference.c(), e1.u.EXPIRED);
                            }
                            this.writeQueue.remove(tVarNewEntry);
                            this.accessQueue.remove(tVarNewEntry);
                            this.count = i10;
                            z10 = true;
                        }
                        a0Var = valueReference;
                        break;
                    }
                    tVarNewEntry = tVarNewEntry.getNext();
                }
                if (z10) {
                    c0093m = new C0093m<>();
                    if (tVarNewEntry == null) {
                        tVarNewEntry = newEntry(key, hash, tVar);
                        tVarNewEntry.setValueReference(c0093m);
                        atomicReferenceArray.set(length, tVarNewEntry);
                    } else {
                        tVarNewEntry.setValueReference(c0093m);
                    }
                }
                unlock();
                postWriteCleanup();
                if (!z10) {
                    return waitForLoadingValue(tVarNewEntry, key, a0Var);
                }
                try {
                    synchronized (tVarNewEntry) {
                        vLoadSync = loadSync(key, hash, c0093m, loader);
                    }
                    this.statsCounter.b(1);
                    return vLoadSync;
                } catch (Throwable th2) {
                    this.statsCounter.b(1);
                    throw th2;
                }
            } catch (Throwable th3) {
                unlock();
                postWriteCleanup();
                throw th3;
            }
        }

        @u1.a("this")
        public e1.t<K, V> newEntry(K key, int hash, @gm.a e1.t<K, V> next) {
            f fVar = this.map.I;
            key.getClass();
            return fVar.newEntry(this, key, hash, next);
        }

        public AtomicReferenceArray<e1.t<K, V>> newEntryArray(int size) {
            return new AtomicReferenceArray<>(size);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        @u1.a("this")
        public void preWriteCleanup(long now) {
            runLockedCleanup(now);
        }

        @gm.a
        @t1.a
        public V put(K key, int hash, V value, boolean onlyIfAbsent) {
            int i10;
            lock();
            try {
                long jA = this.map.H.a();
                preWriteCleanup(jA);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.f3949e.equivalent(key, key2)) {
                        a0<K, V> valueReference = next.getValueReference();
                        V v10 = valueReference.get();
                        if (v10 != null) {
                            if (onlyIfAbsent) {
                                recordLockedRead(next, jA);
                            } else {
                                this.modCount++;
                                enqueueNotification(key, hash, v10, valueReference.c(), e1.u.REPLACED);
                                setValue(next, key, value, jA);
                                evictEntries(next);
                            }
                            return v10;
                        }
                        this.modCount++;
                        if (valueReference.isActive()) {
                            enqueueNotification(key, hash, v10, valueReference.c(), e1.u.COLLECTED);
                            setValue(next, key, value, jA);
                            i10 = this.count;
                        } else {
                            setValue(next, key, value, jA);
                            i10 = this.count + 1;
                        }
                        this.count = i10;
                        evictEntries(next);
                        return null;
                    }
                }
                this.modCount++;
                e1.t<K, V> tVarNewEntry = newEntry(key, hash, tVar);
                setValue(tVarNewEntry, key, value, jA);
                atomicReferenceArray.set(length, tVarNewEntry);
                this.count++;
                evictEntries(tVarNewEntry);
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @t1.a
        public boolean reclaimKey(e1.t<K, V> entry, int hash) {
            lock();
            try {
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    if (next == entry) {
                        this.modCount++;
                        e1.t<K, V> tVarRemoveValueFromChain = removeValueFromChain(tVar, next, next.getKey(), hash, next.getValueReference().get(), next.getValueReference(), e1.u.COLLECTED);
                        int i10 = this.count - 1;
                        atomicReferenceArray.set(length, tVarRemoveValueFromChain);
                        this.count = i10;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @t1.a
        public boolean reclaimValue(K key, int hash, a0<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.f3949e.equivalent(key, key2)) {
                        if (next.getValueReference() != valueReference) {
                            return false;
                        }
                        this.modCount++;
                        e1.t<K, V> tVarRemoveValueFromChain = removeValueFromChain(tVar, next, key2, hash, valueReference.get(), valueReference, e1.u.COLLECTED);
                        int i10 = this.count - 1;
                        atomicReferenceArray.set(length, tVarRemoveValueFromChain);
                        this.count = i10;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        @u1.a("this")
        public void recordLockedRead(e1.t<K, V> entry, long now) {
            if (this.map.M()) {
                entry.setAccessTime(now);
            }
            this.accessQueue.add(entry);
        }

        public void recordRead(e1.t<K, V> entry, long now) {
            if (this.map.M()) {
                entry.setAccessTime(now);
            }
            this.recencyQueue.add(entry);
        }

        @u1.a("this")
        public void recordWrite(e1.t<K, V> entry, int weight, long now) {
            drainRecencyQueue();
            this.totalWeight += (long) weight;
            if (this.map.M()) {
                entry.setAccessTime(now);
            }
            if (this.map.O()) {
                entry.setWriteTime(now);
            }
            this.accessQueue.add(entry);
            this.writeQueue.add(entry);
        }

        @gm.a
        @t1.a
        public V refresh(K k10, int i10, e1.g<? super K, V> gVar, boolean z10) {
            C0093m<K, V> c0093mInsertLoadingValueReference = insertLoadingValueReference(k10, i10, z10);
            if (c0093mInsertLoadingValueReference == null) {
                return null;
            }
            s1<V> s1VarLoadAsync = loadAsync(k10, i10, c0093mInsertLoadingValueReference, gVar);
            if (s1VarLoadAsync.isDone()) {
                try {
                    return (V) e3.f(s1VarLoadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        @gm.a
        public V remove(Object key, int hash) {
            e1.u uVar;
            lock();
            try {
                preWriteCleanup(this.map.H.a());
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.f3949e.equivalent(key, key2)) {
                        a0<K, V> valueReference = next.getValueReference();
                        V v10 = valueReference.get();
                        if (v10 == null) {
                            if (!valueReference.isActive()) {
                                break;
                            }
                            uVar = e1.u.COLLECTED;
                        } else {
                            uVar = e1.u.EXPLICIT;
                        }
                        e1.u uVar2 = uVar;
                        this.modCount++;
                        e1.t<K, V> tVarRemoveValueFromChain = removeValueFromChain(tVar, next, key2, hash, v10, valueReference, uVar2);
                        int i10 = this.count - 1;
                        atomicReferenceArray.set(length, tVarRemoveValueFromChain);
                        this.count = i10;
                        return v10;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @u1.a("this")
        public void removeCollectedEntry(e1.t<K, V> entry) {
            enqueueNotification(entry.getKey(), entry.getHash(), entry.getValueReference().get(), entry.getValueReference().c(), e1.u.COLLECTED);
            this.writeQueue.remove(entry);
            this.accessQueue.remove(entry);
        }

        @t1.a
        @u1.a("this")
        @b1.e
        public boolean removeEntry(e1.t<K, V> entry, int hash, e1.u cause) {
            AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & hash;
            e1.t<K, V> tVar = atomicReferenceArray.get(length);
            for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                if (next == entry) {
                    this.modCount++;
                    e1.t<K, V> tVarRemoveValueFromChain = removeValueFromChain(tVar, next, next.getKey(), hash, next.getValueReference().get(), next.getValueReference(), cause);
                    int i10 = this.count - 1;
                    atomicReferenceArray.set(length, tVarRemoveValueFromChain);
                    this.count = i10;
                    return true;
                }
            }
            return false;
        }

        @gm.a
        @u1.a("this")
        public e1.t<K, V> removeEntryFromChain(e1.t<K, V> first, e1.t<K, V> entry) {
            int i10 = this.count;
            e1.t<K, V> next = entry.getNext();
            while (first != entry) {
                e1.t<K, V> tVarCopyEntry = copyEntry(first, next);
                if (tVarCopyEntry != null) {
                    next = tVarCopyEntry;
                } else {
                    removeCollectedEntry(first);
                    i10--;
                }
                first = first.getNext();
            }
            this.count = i10;
            return next;
        }

        @t1.a
        public boolean removeLoadingValue(K key, int hash, C0093m<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.f3949e.equivalent(key, key2)) {
                        if (next.getValueReference() != valueReference) {
                            break;
                        }
                        if (valueReference.isActive()) {
                            next.setValueReference(valueReference.j());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(tVar, next));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @gm.a
        @u1.a("this")
        public e1.t<K, V> removeValueFromChain(e1.t<K, V> first, e1.t<K, V> entry, @gm.a K key, int hash, V value, a0<K, V> valueReference, e1.u cause) {
            enqueueNotification(key, hash, value, valueReference.c(), cause);
            this.writeQueue.remove(entry);
            this.accessQueue.remove(entry);
            if (!valueReference.d()) {
                return removeEntryFromChain(first, entry);
            }
            valueReference.b(null);
            return first;
        }

        public boolean replace(K key, int hash, V oldValue, V newValue) {
            lock();
            try {
                long jA = this.map.H.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null) {
                        if (this.map.f3949e.equivalent(key, key2)) {
                            a0<K, V> valueReference = next.getValueReference();
                            V v10 = valueReference.get();
                            if (v10 != null) {
                                if (!this.map.f3950f.equivalent(oldValue, v10)) {
                                    recordLockedRead(next, jA);
                                    break;
                                }
                                this.modCount++;
                                enqueueNotification(key, hash, v10, valueReference.c(), e1.u.REPLACED);
                                setValue(next, key, newValue, jA);
                                evictEntries(next);
                                return true;
                            }
                            if (!valueReference.isActive()) {
                                break;
                            }
                            this.modCount++;
                            e1.t<K, V> tVarRemoveValueFromChain = removeValueFromChain(tVar, next, key2, hash, v10, valueReference, e1.u.COLLECTED);
                            int i10 = this.count - 1;
                            atomicReferenceArray.set(length, tVarRemoveValueFromChain);
                            this.count = i10;
                            break;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void runLockedCleanup(long now) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(now);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.J();
        }

        public V scheduleRefresh(e1.t<K, V> entry, K key, int hash, V oldValue, long now, e1.g<? super K, V> loader) {
            V vRefresh;
            return (!this.map.Q() || now - entry.getWriteTime() <= this.map.f3957x || entry.getValueReference().d() || (vRefresh = refresh(key, hash, loader, true)) == null) ? oldValue : vRefresh;
        }

        @u1.a("this")
        public void setValue(e1.t<K, V> entry, K key, V value, long now) {
            a0<K, V> valueReference = entry.getValueReference();
            int iWeigh = this.map.f3954p.weigh(key, value);
            c1.h0.h0(iWeigh >= 0, "Weights must be non-negative");
            entry.setValueReference(this.map.f3952i.referenceValue(this, entry, value, iWeigh));
            recordWrite(entry, iWeigh, now);
            valueReference.b(value);
        }

        @t1.a
        public boolean storeLoadedValue(K key, int hash, C0093m<K, V> oldValueReference, V newValue) {
            lock();
            try {
                long jA = this.map.H.a();
                preWriteCleanup(jA);
                int i10 = this.count + 1;
                if (i10 > this.threshold) {
                    expand();
                    i10 = this.count + 1;
                }
                int i11 = i10;
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.f3949e.equivalent(key, key2)) {
                        a0<K, V> valueReference = next.getValueReference();
                        V v10 = valueReference.get();
                        if (oldValueReference != valueReference && (v10 != null || valueReference == m.U)) {
                            enqueueNotification(key, hash, newValue, 0, e1.u.REPLACED);
                            return false;
                        }
                        this.modCount++;
                        if (oldValueReference.isActive()) {
                            enqueueNotification(key, hash, v10, oldValueReference.c(), v10 == null ? e1.u.COLLECTED : e1.u.REPLACED);
                            i11--;
                        }
                        setValue(next, key, newValue, jA);
                        this.count = i11;
                        evictEntries(next);
                        return true;
                    }
                }
                this.modCount++;
                e1.t<K, V> tVarNewEntry = newEntry(key, hash, tVar);
                setValue(tVarNewEntry, key, newValue, jA);
                atomicReferenceArray.set(length, tVarNewEntry);
                this.count = i11;
                evictEntries(tVarNewEntry);
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long now) {
            if (tryLock()) {
                try {
                    expireEntries(now);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(e1.t<K, V> e10, K key, a0<K, V> valueReference) throws ExecutionException {
            if (!valueReference.d()) {
                throw new AssertionError();
            }
            c1.h0.x0(!Thread.holdsLock(e10), "Recursive load of: %s", key);
            try {
                V vF = valueReference.f();
                if (vF != null) {
                    recordRead(e10, this.map.H.a());
                    this.statsCounter.b(1);
                    return vF;
                }
                throw new e1.g.c("CacheLoader returned null for key " + key + ".");
            } catch (Throwable th2) {
                this.statsCounter.b(1);
                throw th2;
            }
        }

        @gm.a
        public V get(Object key, int hash) {
            try {
                if (this.count != 0) {
                    long jA = this.map.H.a();
                    e1.t<K, V> liveEntry = getLiveEntry(key, hash, jA);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v10 = liveEntry.getValueReference().get();
                    if (v10 != null) {
                        recordRead(liveEntry, jA);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), hash, v10, jA, this.map.K);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        public boolean remove(Object key, int hash, Object value) {
            e1.u uVar;
            lock();
            try {
                preWriteCleanup(this.map.H.a());
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.f3949e.equivalent(key, key2)) {
                        a0<K, V> valueReference = next.getValueReference();
                        V v10 = valueReference.get();
                        if (this.map.f3950f.equivalent(value, v10)) {
                            uVar = e1.u.EXPLICIT;
                        } else {
                            if (v10 != null || !valueReference.isActive()) {
                                break;
                                break;
                            }
                            uVar = e1.u.COLLECTED;
                        }
                        this.modCount++;
                        e1.t<K, V> tVarRemoveValueFromChain = removeValueFromChain(tVar, next, key2, hash, v10, valueReference, uVar);
                        int i10 = this.count - 1;
                        atomicReferenceArray.set(length, tVarRemoveValueFromChain);
                        this.count = i10;
                        return uVar == e1.u.EXPLICIT;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @gm.a
        public V replace(K key, int hash, V newValue) {
            lock();
            try {
                long jA = this.map.H.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<e1.t<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                e1.t<K, V> tVar = atomicReferenceArray.get(length);
                for (e1.t<K, V> next = tVar; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null) {
                        if (this.map.f3949e.equivalent(key, key2)) {
                            a0<K, V> valueReference = next.getValueReference();
                            V v10 = valueReference.get();
                            if (v10 == null) {
                                if (!valueReference.isActive()) {
                                    break;
                                }
                                this.modCount++;
                                e1.t<K, V> tVarRemoveValueFromChain = removeValueFromChain(tVar, next, key2, hash, v10, valueReference, e1.u.COLLECTED);
                                int i10 = this.count - 1;
                                atomicReferenceArray.set(length, tVarRemoveValueFromChain);
                                this.count = i10;
                                break;
                            }
                            this.modCount++;
                            enqueueNotification(key, hash, v10, valueReference.c(), e1.u.REPLACED);
                            setValue(next, key, newValue, jA);
                            evictEntries(next);
                            return v10;
                        }
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }
    }
}
