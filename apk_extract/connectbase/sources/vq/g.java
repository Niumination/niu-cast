package vq;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.r1;
import vq.g;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n107#1,7:270\n1#2:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n115#1:270,7\n*E\n"})
public abstract class g<N extends g<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17840a = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17841b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_prev");

    @os.m
    @in.x
    private volatile Object _next;

    @os.m
    @in.x
    private volatile Object _prev;

    public g(@os.m N n10) {
        this._prev = n10;
    }

    public static final Object a(g gVar) {
        gVar.getClass();
        return f17840a.get(gVar);
    }

    private final void n(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, ? extends Object> lVar, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!j.d.a(atomicReferenceFieldUpdater, obj, obj2, lVar.invoke(obj2)));
    }

    public final void b() {
        f17841b.lazySet(this, null);
    }

    public final N c() {
        N n10 = (N) g();
        while (n10 != null && n10.h()) {
            n10 = (N) f17841b.get(n10);
        }
        return n10;
    }

    public final N d() {
        g gVarE;
        N n10 = (N) e();
        kn.l0.m(n10);
        while (n10.h() && (gVarE = n10.e()) != null) {
            n10 = (N) gVarE;
        }
        return n10;
    }

    @os.m
    public final N e() {
        Object objA = a(this);
        if (objA == f.f17836b) {
            return null;
        }
        return (N) objA;
    }

    public final Object f() {
        return f17840a.get(this);
    }

    @os.m
    public final N g() {
        return (N) f17841b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return j.d.a(f17840a, this, null, f.f17836b);
    }

    @os.m
    public final N k(@os.l jn.a aVar) {
        Object objA = a(this);
        if (objA != f.f17836b) {
            return (N) objA;
        }
        aVar.invoke();
        throw new lm.y();
    }

    public final void l() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            g gVarC = c();
            g gVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17841b;
            do {
                obj = atomicReferenceFieldUpdater.get(gVarD);
            } while (!j.d.a(atomicReferenceFieldUpdater, gVarD, obj, ((g) obj) == null ? null : gVarC));
            if (gVarC != null) {
                f17840a.set(gVarC, gVarD);
            }
            if (!gVarD.h() || gVarD.i()) {
                if (gVarC == null || !gVarC.h()) {
                    return;
                }
            }
        }
    }

    public final boolean m(@os.l N n10) {
        return j.d.a(f17840a, this, null, n10);
    }
}
