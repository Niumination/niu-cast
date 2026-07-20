package ar;

import in.x;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jn.q;
import kn.h0;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.u1;
import lm.l2;
import nq.a2;
import nq.b4;
import nq.g2;
import nq.n1;
import nq.p;
import nq.s;
import nq.x0;
import os.l;
import vq.r0;
import xm.h;
import yq.i;
import yq.j;
import yq.m;
import yq.n;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n332#2,12:311\n1#3:323\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n175#1:311,12\n*E\n"})
public class b extends ar.e implements ar.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public static final AtomicReferenceFieldUpdater f681i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public final q<m<?>, Object, Object, jn.l<Throwable, l2>> f682h;

    @os.m
    @x
    private volatile Object owner;

    @r1({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    public final class a implements p<l2>, b4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        @l
        public final nq.q<l2> f683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        @in.f
        public final Object f684b;

        /* JADX INFO: renamed from: ar.b$a$a, reason: collision with other inner class name */
        public static final class C0022a extends n0 implements jn.l<Throwable, l2> {
            final /* synthetic */ b this$0;
            final /* synthetic */ a this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0022a(b bVar, a aVar) {
                super(1);
                this.this$0 = bVar;
                this.this$1 = aVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
                invoke2(th2);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l Throwable th2) {
                this.this$0.f(this.this$1.f684b);
            }
        }

        /* JADX INFO: renamed from: ar.b$a$b, reason: collision with other inner class name */
        @r1({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner$tryResume$token$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
        public static final class C0023b extends n0 implements jn.l<Throwable, l2> {
            final /* synthetic */ b this$0;
            final /* synthetic */ a this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0023b(b bVar, a aVar) {
                super(1);
                this.this$0 = bVar;
                this.this$1 = aVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
                invoke2(th2);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l Throwable th2) {
                b.f681i.set(this.this$0, this.this$1.f684b);
                this.this$0.f(this.this$1.f684b);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.m nq.q<? super l2> qVar, Object obj) {
            this.f683a = qVar;
            this.f684b = obj;
        }

        @Override // nq.p
        @g2
        public void F() {
            this.f683a.F();
        }

        @Override // nq.p
        public void H(@l jn.l<? super Throwable, l2> lVar) {
            this.f683a.H(lVar);
        }

        @Override // nq.p
        @g2
        public void M(@l Object obj) {
            this.f683a.M(obj);
        }

        @Override // nq.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void g(@l l2 l2Var, @os.m jn.l<? super Throwable, l2> lVar) {
            b.f681i.set(b.this, this.f684b);
            this.f683a.g(l2Var, new C0022a(b.this, this));
        }

        @Override // nq.p
        @a2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void G(@l nq.n0 n0Var, @l l2 l2Var) {
            this.f683a.G(n0Var, l2Var);
        }

        @Override // nq.p
        public boolean c(@os.m Throwable th2) {
            return this.f683a.c(th2);
        }

        @Override // nq.b4
        public void d(@l r0<?> r0Var, int i10) {
            this.f683a.d(r0Var, i10);
        }

        @Override // nq.p
        public Object e(l2 l2Var, Object obj) {
            return this.f683a.e(l2Var, obj);
        }

        @os.m
        @g2
        public Object f(@l l2 l2Var, @os.m Object obj) {
            return this.f683a.e(l2Var, obj);
        }

        @Override // um.d
        @l
        public um.g getContext() {
            return this.f683a.getContext();
        }

        @Override // nq.p
        @os.m
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object I(@l l2 l2Var, @os.m Object obj, @os.m jn.l<? super Throwable, l2> lVar) {
            Object objI = this.f683a.I(l2Var, obj, new C0023b(b.this, this));
            if (objI != null) {
                b.f681i.set(b.this, this.f684b);
            }
            return objI;
        }

        @Override // nq.p
        public boolean isActive() {
            return this.f683a.isActive();
        }

        @Override // nq.p
        public boolean isCancelled() {
            return this.f683a.isCancelled();
        }

        @Override // nq.p
        public boolean isCompleted() {
            return this.f683a.isCompleted();
        }

        @Override // nq.p
        @os.m
        @g2
        public Object j(@l Throwable th2) {
            return this.f683a.j(th2);
        }

        @Override // nq.p
        @a2
        public void l(@l nq.n0 n0Var, @l Throwable th2) {
            this.f683a.l(n0Var, th2);
        }

        @Override // um.d
        public void resumeWith(@l Object obj) {
            this.f683a.resumeWith(obj);
        }
    }

    /* JADX INFO: renamed from: ar.b$b, reason: collision with other inner class name */
    @r1({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    public final class C0024b<Q> implements n<Q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        @l
        public final n<Q> f686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        @in.f
        public final Object f687b;

        public C0024b(@os.m n<Q> nVar, Object obj) {
            this.f686a = nVar;
            this.f687b = obj;
        }

        @Override // nq.b4
        public void d(@l r0<?> r0Var, int i10) {
            this.f686a.d(r0Var, i10);
        }

        @Override // yq.m
        public void f(@os.m Object obj) {
            b.f681i.set(b.this, this.f687b);
            this.f686a.f(obj);
        }

        @Override // yq.m
        public void g(@l n1 n1Var) {
            this.f686a.g(n1Var);
        }

        @Override // yq.m
        @l
        public um.g getContext() {
            return this.f686a.getContext();
        }

        @Override // yq.m
        public boolean i(@l Object obj, @os.m Object obj2) {
            boolean zI = this.f686a.i(obj, obj2);
            b bVar = b.this;
            if (zI) {
                b.f681i.set(bVar, this.f687b);
            }
            return zI;
        }
    }

    public /* synthetic */ class c extends h0 implements q<b, m<?>, Object, l2> {
        public static final c INSTANCE = new c();

        public c() {
            super(3, b.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(b bVar, m<?> mVar, Object obj) {
            invoke2(bVar, mVar, obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l b bVar, @l m<?> mVar, @os.m Object obj) {
            bVar.C(mVar, obj);
        }
    }

    public /* synthetic */ class d extends h0 implements q<b, Object, Object, Object> {
        public static final d INSTANCE = new d();

        public d() {
            super(3, b.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@l b bVar, @os.m Object obj, @os.m Object obj2) {
            return bVar.B(obj, obj2);
        }
    }

    public static final class e extends n0 implements q<m<?>, Object, Object, jn.l<? super Throwable, ? extends l2>> {

        public static final class a extends n0 implements jn.l<Throwable, l2> {
            final /* synthetic */ Object $owner;
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Object obj) {
                super(1);
                this.this$0 = bVar;
                this.$owner = obj;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
                invoke2(th2);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l Throwable th2) {
                this.this$0.f(this.$owner);
            }
        }

        public e() {
            super(3);
        }

        @Override // jn.q
        @l
        public final jn.l<Throwable, l2> invoke(@l m<?> mVar, @os.m Object obj, @os.m Object obj2) {
            return new a(b.this, obj);
        }
    }

    public b(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner = z10 ? null : ar.c.f689a;
        this.f682h = new e();
    }

    public static /* synthetic */ void x() {
    }

    public static Object z(b bVar, Object obj, um.d<? super l2> dVar) {
        Object objA;
        return (!bVar.d(obj) && (objA = bVar.A(obj, dVar)) == wm.a.COROUTINE_SUSPENDED) ? objA : l2.f10208a;
    }

    public final Object A(Object obj, um.d<? super l2> dVar) {
        nq.q qVarB = s.b(wm.c.e(dVar));
        try {
            m(new a(qVarB, obj));
            Object objZ = qVarB.z();
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (objZ == aVar) {
                h.c(dVar);
            }
            return objZ == aVar ? objZ : l2.f10208a;
        } catch (Throwable th2) {
            qVarB.Q();
            throw th2;
        }
    }

    @os.m
    public Object B(@os.m Object obj, @os.m Object obj2) {
        if (!l0.g(obj2, ar.c.f690b)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public void C(@l m<?> mVar, @os.m Object obj) {
        if (obj != null && g(obj)) {
            mVar.f(ar.c.f690b);
        } else {
            l0.n(mVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            s(new C0024b((n) mVar, obj), obj);
        }
    }

    public final int D(Object obj) {
        while (!c()) {
            if (obj == null) {
                return 1;
            }
            int iY = y(obj);
            if (iY == 1) {
                return 2;
            }
            if (iY == 2) {
                return 1;
            }
        }
        f681i.set(this, obj);
        return 0;
    }

    @Override // ar.a
    public boolean d(@os.m Object obj) {
        int iD = D(obj);
        if (iD == 0) {
            return true;
        }
        if (iD == 1) {
            return false;
        }
        if (iD != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // ar.a
    public boolean e() {
        return a() == 0;
    }

    @Override // ar.a
    public void f(@os.m Object obj) {
        while (e()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f681i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != ar.c.f689a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (j.d.a(atomicReferenceFieldUpdater, this, obj2, ar.c.f689a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    @Override // ar.a
    public boolean g(@l Object obj) {
        return y(obj) == 1;
    }

    @Override // ar.a
    @os.m
    public Object h(@os.m Object obj, @l um.d<? super l2> dVar) {
        return z(this, obj, dVar);
    }

    @Override // ar.a
    @l
    public i<Object, ar.a> i() {
        c cVar = c.INSTANCE;
        l0.n(cVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        q qVar = (q) u1.q(cVar, 3);
        d dVar = d.INSTANCE;
        l0.n(dVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new j(this, qVar, (q) u1.q(dVar, 3), this.f682h);
    }

    @l
    public String toString() {
        return "Mutex@" + x0.b(this) + "[isLocked=" + e() + ",owner=" + f681i.get(this) + ']';
    }

    public final int y(Object obj) {
        while (e()) {
            Object obj2 = f681i.get(this);
            if (obj2 != ar.c.f689a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }
}
