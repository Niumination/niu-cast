package rq;

import in.x;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jn.p;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.l2;
import lm.y;
import q1.w2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
public final class b<K, V> extends nm.g<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f14790b = AtomicIntegerFieldUpdater.newUpdater(b.class, "_size");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f14791c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "core");

    @x
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final ReferenceQueue<K> f14792a;

    @os.m
    @x
    private volatile Object core;

    public final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final AtomicIntegerFieldUpdater f14793g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final AtomicReferenceArray f14797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final AtomicReferenceArray f14798e;

        @x
        private volatile int load;

        /* JADX INFO: renamed from: rq.b$a$a, reason: collision with other inner class name */
        @r1({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
        public final class C0365a<E> implements Iterator<E>, ln.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final p<K, V, E> f14800a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f14801b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public K f14802c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public V f14803d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0365a(p<? super K, ? super V, ? extends E> pVar) {
                this.f14800a = pVar;
                a();
            }

            public final void a() {
                K k10;
                while (true) {
                    int i10 = this.f14801b + 1;
                    this.f14801b = i10;
                    if (i10 >= a.this.f14794a) {
                        return;
                    }
                    k kVar = (k) a.this.f14797d.get(this.f14801b);
                    if (kVar != null && (k10 = (K) kVar.get()) != null) {
                        this.f14802c = k10;
                        Object obj = (V) a.this.f14798e.get(this.f14801b);
                        if (obj instanceof l) {
                            obj = (V) ((l) obj).f14846a;
                        }
                        if (obj != null) {
                            this.f14803d = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @os.l
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                rq.c.e();
                throw new y();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f14801b < a.this.f14794a;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.Iterator
            public E next() {
                if (this.f14801b >= a.this.f14794a) {
                    throw new NoSuchElementException();
                }
                p<K, V, E> pVar = this.f14800a;
                K k10 = this.f14802c;
                if (k10 == false) {
                    l0.S(cb.b.c.f1408o);
                    k10 = (K) l2.f10208a;
                }
                V v10 = this.f14803d;
                if (v10 == false) {
                    l0.S("value");
                    v10 = (V) l2.f10208a;
                }
                E e10 = (E) pVar.invoke(k10, v10);
                a();
                return e10;
            }
        }

        public a(int i10) {
            this.f14794a = i10;
            this.f14795b = Integer.numberOfLeadingZeros(i10) + 1;
            this.f14796c = (i10 * 2) / 3;
            this.f14797d = new AtomicReferenceArray(i10);
            this.f14798e = new AtomicReferenceArray(i10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object i(a aVar, Object obj, Object obj2, k kVar, int i10, Object obj3) {
            if ((i10 & 4) != 0) {
                kVar = null;
            }
            return aVar.h(obj, obj2, kVar);
        }

        public final void d(@os.l k<?> kVar) {
            int iF = f(kVar.f14845a);
            while (true) {
                k<?> kVar2 = (k) this.f14797d.get(iF);
                if (kVar2 == null) {
                    return;
                }
                if (kVar2 == kVar) {
                    k(iF);
                    return;
                } else {
                    if (iF == 0) {
                        iF = this.f14794a;
                    }
                    iF--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @os.m
        public final V e(@os.l K k10) {
            int iF = f(k10.hashCode());
            while (true) {
                k kVar = (k) this.f14797d.get(iF);
                if (kVar == null) {
                    return null;
                }
                T t10 = kVar.get();
                if (l0.g(k10, t10)) {
                    V v10 = (V) this.f14798e.get(iF);
                    return v10 instanceof l ? (V) ((l) v10).f14846a : v10;
                }
                if (t10 == 0) {
                    k(iF);
                }
                if (iF == 0) {
                    iF = this.f14794a;
                }
                iF--;
            }
        }

        public final int f(int i10) {
            return (i10 * (-1640531527)) >>> this.f14795b;
        }

        @os.l
        public final <E> Iterator<E> g(@os.l p<? super K, ? super V, ? extends E> pVar) {
            return new C0365a(pVar);
        }

        @os.m
        public final Object h(@os.l K k10, @os.m V v10, @os.m k<K> kVar) {
            int i10;
            Object obj;
            int iF = f(k10.hashCode());
            boolean z10 = false;
            while (true) {
                k kVar2 = (k) this.f14797d.get(iF);
                if (kVar2 != null) {
                    T t10 = kVar2.get();
                    if (l0.g(k10, t10)) {
                        if (!z10) {
                            break;
                        }
                        f14793g.decrementAndGet(this);
                        break;
                    }
                    if (t10 == 0) {
                        k(iF);
                    }
                    if (iF == 0) {
                        iF = this.f14794a;
                    }
                    iF--;
                } else if (v10 != null) {
                    if (!z10) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14793g;
                        do {
                            i10 = atomicIntegerFieldUpdater.get(this);
                            if (i10 >= this.f14796c) {
                                return rq.c.f14811c;
                            }
                        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1));
                        z10 = true;
                    }
                    if (kVar == null) {
                        kVar = new k<>(k10, b.this.f14792a);
                    }
                    if (w2.a(this.f14797d, iF, null, kVar)) {
                        break;
                    }
                } else {
                    return null;
                }
            }
            do {
                obj = this.f14798e.get(iF);
                if (obj instanceof l) {
                    return rq.c.f14811c;
                }
            } while (!w2.a(this.f14798e, iF, obj, v10));
            return obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @os.l
        public final b<K, V>.a j() {
            Object obj;
            while (true) {
                int iE = b.this.e();
                if (iE < 4) {
                    iE = 4;
                }
                b<K, V>.a aVar = (b<K, V>.a) b.this.new a(Integer.highestOneBit(iE) * 4);
                int i10 = this.f14794a;
                for (int i11 = 0; i11 < i10; i11++) {
                    k kVar = (k) this.f14797d.get(i11);
                    Object obj2 = kVar != null ? kVar.get() : null;
                    if (kVar != null && obj2 == null) {
                        k(i11);
                    }
                    do {
                        obj = this.f14798e.get(i11);
                        if (obj instanceof l) {
                            obj = ((l) obj).f14846a;
                            break;
                        }
                    } while (!w2.a(this.f14798e, i11, obj, rq.c.d(obj)));
                    if (obj2 == null || obj == null || aVar.h(obj2, obj, kVar) != rq.c.f14811c) {
                    }
                }
                return aVar;
            }
        }

        public final void k(int i10) {
            Object obj;
            do {
                obj = this.f14798e.get(i10);
                if (obj == null || (obj instanceof l)) {
                    return;
                }
            } while (!w2.a(this.f14798e, i10, obj, null));
            b.this.l();
        }

        public final void l(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, jn.l<? super Integer, Integer> lVar, Object obj) {
            int i10;
            do {
                i10 = atomicIntegerFieldUpdater.get(obj);
            } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i10, lVar.invoke(Integer.valueOf(i10)).intValue()));
        }
    }

    /* JADX INFO: renamed from: rq.b$b, reason: collision with other inner class name */
    public static final class C0366b<K, V> implements Map.Entry<K, V>, ln.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f14805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f14806b;

        public C0366b(K k10, V v10) {
            this.f14805a = k10;
            this.f14806b = v10;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f14805a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f14806b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            rq.c.e();
            throw new y();
        }
    }

    public final class c<E> extends nm.h<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final p<K, V, E> f14807a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(p<? super K, ? super V, ? extends E> pVar) {
            this.f14807a = pVar;
        }

        @Override // nm.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e10) {
            rq.c.e();
            throw new y();
        }

        @Override // nm.h
        public int getSize() {
            return b.this.e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @os.l
        public Iterator<E> iterator() {
            a aVar = (a) b.f14791c.get(b.this);
            p<K, V, E> pVar = this.f14807a;
            aVar.getClass();
            return aVar.new C0365a(pVar);
        }
    }

    public static final class d extends n0 implements p<K, V, Map.Entry<K, V>> {
        public static final d INSTANCE = new d();

        public d() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final Map.Entry<K, V> invoke(@os.l K k10, @os.l V v10) {
            return new C0366b(k10, v10);
        }
    }

    public static final class e extends n0 implements p<K, V, K> {
        public static final e INSTANCE = new e();

        public e() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final K invoke(@os.l K k10, @os.l V v10) {
            return k10;
        }
    }

    public b() {
        this(false, 1, null);
    }

    @Override // nm.g
    @os.l
    public Set<Map.Entry<K, V>> a() {
        return new c(d.INSTANCE);
    }

    @Override // nm.g
    @os.l
    public Set<K> c() {
        return new c(e.INSTANCE);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = c().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // nm.g
    public int e() {
        return f14790b.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @os.m
    public V get(@os.m Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) f14791c.get(this)).e(obj);
    }

    public final void j(k<?> kVar) {
        ((a) f14791c.get(this)).d(kVar);
    }

    public final void l() {
        f14790b.decrementAndGet(this);
    }

    public final synchronized V m(K k10, V v10) {
        V v11;
        a aVarJ = (a) f14791c.get(this);
        while (true) {
            v11 = (V) a.i(aVarJ, k10, v10, null, 4, null);
            if (v11 == rq.c.f14811c) {
                aVarJ = aVarJ.j();
                f14791c.set(this, aVarJ);
            }
        }
        return v11;
    }

    @Override // nm.g, java.util.AbstractMap, java.util.Map
    @os.m
    public V put(@os.l K k10, @os.l V v10) {
        V vM = (V) a.i((a) f14791c.get(this), k10, v10, null, 4, null);
        if (vM == rq.c.f14811c) {
            vM = m(k10, v10);
        }
        if (vM == null) {
            f14790b.incrementAndGet(this);
        }
        return vM;
    }

    public final void q() {
        if (this.f14792a == null) {
            throw new IllegalStateException("Must be created with weakRefQueue = true");
        }
        while (true) {
            try {
                Reference<? extends K> referenceRemove = this.f14792a.remove();
                l0.n(referenceRemove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                j((k) referenceRemove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @os.m
    public V remove(@os.m Object obj) {
        if (obj == 0) {
            return null;
        }
        V vM = (V) a.i((a) f14791c.get(this), obj, null, null, 4, null);
        if (vM == rq.c.f14811c) {
            vM = m(obj, null);
        }
        if (vM != null) {
            f14790b.decrementAndGet(this);
        }
        return vM;
    }

    public /* synthetic */ b(boolean z10, int i10, w wVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public b(boolean z10) {
        this.core = new a(16);
        this.f14792a = z10 ? new ReferenceQueue<>() : null;
    }
}
