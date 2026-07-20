package vq;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.r1;
import lm.l2;
import nq.g2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n73#1,3:369\n1#2:368\n*S KotlinDebug\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n*L\n134#1:369,3\n*E\n"})
@g2
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17790a = AtomicReferenceFieldUpdater.newUpdater(a0.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17791b = AtomicReferenceFieldUpdater.newUpdater(a0.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17792c = AtomicReferenceFieldUpdater.newUpdater(a0.class, Object.class, "_removedRef");

    @os.m
    @in.x
    private volatile Object _next = this;

    @os.m
    @in.x
    private volatile Object _prev = this;

    @os.m
    @in.x
    private volatile Object _removedRef;

    @lm.z0
    public static abstract class a extends vq.b<a0> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @in.f
        @os.l
        public final a0 f17793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        @in.f
        public a0 f17794c;

        public a(@os.l a0 a0Var) {
            this.f17793b = a0Var;
        }

        @Override // vq.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(@os.l a0 a0Var, @os.m Object obj) {
            boolean z10 = obj == null;
            a0 a0Var2 = z10 ? this.f17793b : this.f17794c;
            if (a0Var2 != null && j.d.a(a0.f17790a, a0Var, this, a0Var2) && z10) {
                a0 a0Var3 = this.f17793b;
                a0 a0Var4 = this.f17794c;
                kn.l0.m(a0Var4);
                a0Var3.l(a0Var4);
            }
        }
    }

    @r1({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n*L\n1#1,367:1\n*E\n"})
    public static final class b extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ jn.a<Boolean> f17795d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a0 a0Var, jn.a<Boolean> aVar) {
            super(a0Var);
            this.f17795d = aVar;
        }

        @Override // vq.b
        @os.m
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(@os.l a0 a0Var) {
            if (this.f17795d.invoke().booleanValue()) {
                return null;
            }
            return z.a();
        }
    }

    private final void r(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @lm.z0
    public final int A(@os.l a0 a0Var, @os.l a0 a0Var2, @os.l a aVar) {
        f17791b.lazySet(a0Var, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17790a;
        atomicReferenceFieldUpdater.lazySet(a0Var, a0Var2);
        aVar.f17794c = a0Var2;
        if (j.d.a(atomicReferenceFieldUpdater, this, a0Var2, aVar)) {
            return aVar.b(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final void B(@os.l a0 a0Var, @os.l a0 a0Var2) {
    }

    public final void e(@os.l a0 a0Var) {
        while (!p().g(a0Var, this)) {
        }
    }

    public final boolean f(@os.l a0 a0Var, @os.l jn.a<Boolean> aVar) {
        int iA;
        b bVar = new b(a0Var, aVar);
        do {
            iA = p().A(a0Var, this, bVar);
            if (iA == 1) {
                return true;
            }
        } while (iA != 2);
        return false;
    }

    @lm.z0
    public final boolean g(@os.l a0 a0Var, @os.l a0 a0Var2) {
        f17791b.lazySet(a0Var, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17790a;
        atomicReferenceFieldUpdater.lazySet(a0Var, a0Var2);
        if (!j.d.a(atomicReferenceFieldUpdater, this, a0Var2, a0Var)) {
            return false;
        }
        a0Var.l(a0Var2);
        return true;
    }

    public final boolean h(@os.l a0 a0Var) {
        f17791b.lazySet(a0Var, this);
        f17790a.lazySet(a0Var, this);
        while (n() == this) {
            if (j.d.a(f17790a, this, this, a0Var)) {
                a0Var.l(this);
                return true;
            }
        }
        return false;
    }

    public final a0 i(m0 m0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            a0 a0Var = (a0) f17791b.get(this);
            a0 a0Var2 = a0Var;
            while (true) {
                a0 a0Var3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = f17790a;
                    obj = atomicReferenceFieldUpdater.get(a0Var2);
                    if (obj == this) {
                        if (a0Var != a0Var2 && !j.d.a(f17791b, this, a0Var, a0Var2)) {
                            break;
                        }
                        return a0Var2;
                    }
                    if (q()) {
                        return null;
                    }
                    if (obj == m0Var) {
                        return a0Var2;
                    }
                    if (obj instanceof m0) {
                        ((m0) obj).b(a0Var2);
                        break;
                    }
                    if (!(obj instanceof o0)) {
                        kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        a0Var3 = a0Var2;
                        a0Var2 = (a0) obj;
                    } else {
                        if (a0Var3 != null) {
                            break;
                        }
                        a0Var2 = (a0) f17791b.get(a0Var2);
                    }
                }
                if (!j.d.a(atomicReferenceFieldUpdater, a0Var3, a0Var2, ((o0) obj).f17869a)) {
                    break;
                }
                a0Var2 = a0Var3;
            }
        }
    }

    public final a0 j(a0 a0Var) {
        while (a0Var.q()) {
            a0Var = (a0) f17791b.get(a0Var);
        }
        return a0Var;
    }

    public final void l(a0 a0Var) {
        a0 a0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17791b;
        do {
            a0Var2 = (a0) atomicReferenceFieldUpdater.get(a0Var);
            if (n() != a0Var) {
                return;
            }
        } while (!j.d.a(f17791b, a0Var, a0Var2, this));
        if (q()) {
            a0Var.i(null);
        }
    }

    @os.l
    public final Object n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17790a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof m0)) {
                return obj;
            }
            ((m0) obj).b(this);
        }
    }

    @os.l
    public final a0 o() {
        return z.f(n());
    }

    @os.l
    public final a0 p() {
        a0 a0VarI = i(null);
        return a0VarI == null ? j((a0) f17791b.get(this)) : a0VarI;
    }

    public boolean q() {
        return n() instanceof o0;
    }

    @lm.z0
    @os.l
    public final a t(@os.l a0 a0Var, @os.l jn.a<Boolean> aVar) {
        return new b(a0Var, aVar);
    }

    @os.l
    public String toString() {
        return new kn.e1(this) { // from class: vq.a0.c
            @Override // kn.e1, un.p
            @os.m
            public Object get() {
                return nq.x0.a(this.receiver);
            }
        } + '@' + nq.x0.b(this);
    }

    @os.m
    public a0 u() {
        Object objN = n();
        o0 o0Var = objN instanceof o0 ? (o0) objN : null;
        if (o0Var != null) {
            return o0Var.f17869a;
        }
        return null;
    }

    public boolean v() {
        return x() == null;
    }

    @os.m
    @lm.z0
    public final a0 x() {
        Object objN;
        a0 a0Var;
        do {
            objN = n();
            if (objN instanceof o0) {
                return ((o0) objN).f17869a;
            }
            if (objN == this) {
                return (a0) objN;
            }
            kn.l0.n(objN, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            a0Var = (a0) objN;
        } while (!j.d.a(f17790a, this, objN, a0Var.z()));
        a0Var.i(null);
        return null;
    }

    public final o0 z() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17792c;
        o0 o0Var = (o0) atomicReferenceFieldUpdater.get(this);
        if (o0Var != null) {
            return o0Var;
        }
        o0 o0Var2 = new o0(this);
        atomicReferenceFieldUpdater.lazySet(this, o0Var2);
        return o0Var2;
    }
}
