package yq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import in.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import kn.r1;
import lm.a1;
import lm.d1;
import lm.l2;
import lm.z0;
import nm.h0;
import nq.a2;
import nq.n1;
import vq.r0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,873:1\n1#2:874\n2624#3,3:875\n1855#3,2:888\n1855#3,2:896\n1855#3,2:898\n314#4,9:878\n323#4,2:890\n19#5:887\n153#6,4:892\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n505#1:875,3\n569#1:888,2\n726#1:896,2\n751#1:898,2\n545#1:878,9\n545#1:890,2\n561#1:887\n711#1:892,4\n*E\n"})
@z0
public class l<R> extends nq.n implements yq.c<R>, n<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f21717f = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "state");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final um.g f21718a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public Object f21720c;

    @os.m
    @x
    private volatile Object state = o.f21737f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public List<l<R>.a> f21719b = new ArrayList(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21721d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public Object f21722e = o.f21740i;

    @r1({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        @os.l
        public final Object f21723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final jn.q<Object, m<?>, Object, l2> f21724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final jn.q<Object, Object, Object, Object> f21725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.m
        public final Object f21726d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final Object f21727e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.m
        @in.f
        public final jn.q<m<?>, Object, Object, jn.l<Throwable, l2>> f21728f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.m
        @in.f
        public Object f21729g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @in.f
        public int f21730h = -1;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l Object obj, @os.l jn.q<Object, ? super m<?>, Object, l2> qVar, @os.m jn.q<Object, Object, Object, ? extends Object> qVar2, @os.l Object obj2, @os.m Object obj3, jn.q<? super m<?>, Object, Object, ? extends jn.l<? super Throwable, l2>> qVar3) {
            this.f21723a = obj;
            this.f21724b = qVar;
            this.f21725c = qVar2;
            this.f21726d = obj2;
            this.f21727e = obj3;
            this.f21728f = qVar3;
        }

        @os.m
        public final jn.l<Throwable, l2> a(@os.l m<?> mVar, @os.m Object obj) {
            jn.q<m<?>, Object, Object, jn.l<Throwable, l2>> qVar = this.f21728f;
            if (qVar != null) {
                return qVar.invoke(mVar, this.f21726d, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f21729g;
            l<R> lVar = l.this;
            if (obj instanceof r0) {
                ((r0) obj).q(this.f21730h, null, lVar.getContext());
                return;
            }
            n1 n1Var = obj instanceof n1 ? (n1) obj : null;
            if (n1Var != null) {
                n1Var.dispose();
            }
        }

        @os.m
        public final Object c(@os.m Object obj, @os.l um.d<? super R> dVar) {
            Object obj2 = this.f21727e;
            if (this.f21726d == o.l()) {
                l0.n(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((jn.l) obj2).invoke(dVar);
            }
            l0.n(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((jn.p) obj2).invoke(obj, dVar);
        }

        @os.m
        public final Object d(@os.m Object obj) {
            return this.f21725c.invoke(this.f21723a, this.f21726d, obj);
        }

        public final boolean e(@os.l l<R> lVar) {
            this.f21724b.invoke(this.f21723a, lVar, this.f21726d);
            return lVar.f21722e == o.f21740i;
        }
    }

    @xm.f(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {0}, l = {431, 434}, m = "doSelectSuspend", n = {"this"}, s = {"L$0"})
    public static final class b extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ l<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l<R> lVar, um.d<? super b> dVar) {
            super(dVar);
            this.this$0 = lVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.A(this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {TypedValues.TransitionType.TYPE_STAGGERED}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
    public static final class c extends xm.d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ l<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l<R> lVar, um.d<? super c> dVar) {
            super(dVar);
            this.this$0 = lVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.G(null, null, this);
        }
    }

    public l(@os.l um.g gVar) {
        this.f21718a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        return f21717f.get(this) == o.f21739h;
    }

    private final boolean E() {
        return f21717f.get(this) instanceof a;
    }

    public static /* synthetic */ void I(l lVar, a aVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        lVar.H(aVar, z10);
    }

    @z0
    public static /* synthetic */ <R> Object z(l<R> lVar, um.d<? super R> dVar) {
        return lVar.E() ? lVar.w(dVar) : lVar.A(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object A(um.d<? super R> dVar) {
        b bVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(this, dVar);
            }
        } else {
            bVar = new b(this, dVar);
        }
        Object objW = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                this = (l) bVar.L$0;
                d1.n(objW);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objW);
            }
        }
        d1.n(objW);
        bVar.L$0 = this;
        bVar.label = 1;
        if (N(bVar) == aVar) {
            return aVar;
        }
        bVar.L$0 = null;
        bVar.label = 2;
        objW = this.w(bVar);
        return objW == aVar ? aVar : objW;
    }

    public final l<R>.a B(Object obj) {
        List<l<R>.a> list = this.f21719b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        for (Object obj3 : list) {
            if (((a) obj3).f21723a == obj) {
                obj2 = obj3;
                break;
            }
        }
        l<R>.a aVar = (a) obj2;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public final boolean C() {
        Object obj = f21717f.get(this);
        return obj == o.f21737f || (obj instanceof List);
    }

    public final void F(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object G(l<R>.a aVar, Object obj, um.d<? super R> dVar) {
        c cVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(this, dVar);
            }
        } else {
            cVar = new c(this, dVar);
        }
        Object objC = cVar.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 == 0) {
            d1.n(objC);
            Object objD = aVar.d(obj);
            cVar.label = 1;
            objC = aVar.c(objD, cVar);
            if (objC == obj2) {
                return obj2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(objC);
        }
        return objC;
    }

    @in.i(name = "register")
    public final void H(@os.l l<R>.a aVar, boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21717f;
        if (atomicReferenceFieldUpdater.get(this) instanceof a) {
            return;
        }
        if (!z10) {
            u(aVar.f21723a);
        }
        if (!aVar.e(this)) {
            atomicReferenceFieldUpdater.set(this, aVar);
            return;
        }
        if (!z10) {
            List<l<R>.a> list = this.f21719b;
            l0.m(list);
            list.add(aVar);
        }
        aVar.f21729g = this.f21720c;
        aVar.f21730h = this.f21721d;
        this.f21720c = null;
        this.f21721d = -1;
    }

    public final void J(Object obj) {
        l<R>.a aVarB = B(obj);
        l0.m(aVarB);
        aVarB.f21729g = null;
        aVarB.f21730h = -1;
        H(aVarB, true);
    }

    @os.l
    public final r K(@os.l Object obj, @os.m Object obj2) {
        return o.d(L(obj, obj2));
    }

    public final int L(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21717f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof nq.p) {
                l<R>.a aVarB = B(obj);
                if (aVarB == null) {
                    continue;
                } else {
                    jn.l<Throwable, l2> lVarA = aVarB.a(this, obj2);
                    if (j.d.a(atomicReferenceFieldUpdater, this, obj3, aVarB)) {
                        this.f21722e = obj2;
                        if (o.o((nq.p) obj3, lVarA)) {
                            return 0;
                        }
                        this.f21722e = null;
                        return 2;
                    }
                }
            } else {
                if (l0.g(obj3, o.f21738g) ? true : obj3 instanceof a) {
                    return 3;
                }
                if (l0.g(obj3, o.f21739h)) {
                    return 2;
                }
                if (l0.g(obj3, o.f21737f)) {
                    if (j.d.a(atomicReferenceFieldUpdater, this, obj3, nm.x.k(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (j.d.a(atomicReferenceFieldUpdater, this, obj3, h0.F4((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    public final void M(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, ? extends Object> lVar, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!j.d.a(atomicReferenceFieldUpdater, obj, obj2, lVar.invoke(obj2)));
    }

    public final Object N(um.d<? super l2> dVar) {
        nq.q qVar = new nq.q(wm.c.e(dVar), 1);
        qVar.F();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21717f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == o.f21737f) {
                if (j.d.a(f21717f, this, obj, qVar)) {
                    qVar.H(this);
                    break;
                }
            } else {
                if (!(obj instanceof List)) {
                    if (obj instanceof a) {
                        qVar.g(l2.f10208a, ((a) obj).a(this, this.f21722e));
                        break;
                    }
                    throw new IllegalStateException(("unexpected state: " + obj).toString());
                }
                if (j.d.a(f21717f, this, obj, o.f21737f)) {
                    Iterator it = ((Iterable) obj).iterator();
                    while (it.hasNext()) {
                        J(it.next());
                    }
                }
            }
        }
        Object objZ = qVar.z();
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        if (objZ == aVar) {
            xm.h.c(dVar);
        }
        return objZ == aVar ? objZ : l2.f10208a;
    }

    @Override // yq.c
    public <P, Q> void a(@os.l i<? super P, ? extends Q> iVar, P p10, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar) {
        I(this, new a(iVar.d(), iVar.a(), iVar.c(), p10, pVar, iVar.b()), false, 1, null);
    }

    @Override // yq.c
    public void b(@os.l e eVar, @os.l jn.l<? super um.d<? super R>, ? extends Object> lVar) {
        I(this, new a(eVar.d(), eVar.a(), eVar.c(), o.l(), lVar, eVar.b()), false, 1, null);
    }

    @Override // yq.c
    public <P, Q> void c(@os.l i<? super P, ? extends Q> iVar, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar) {
        a(iVar, null, pVar);
    }

    @Override // nq.b4
    public void d(@os.l r0<?> r0Var, int i10) {
        this.f21720c = r0Var;
        this.f21721d = i10;
    }

    @Override // yq.c
    public <Q> void e(@os.l g<? extends Q> gVar, @os.l jn.p<? super Q, ? super um.d<? super R>, ? extends Object> pVar) {
        I(this, new a(gVar.d(), gVar.a(), gVar.c(), null, pVar, gVar.b()), false, 1, null);
    }

    @Override // yq.m
    public void f(@os.m Object obj) {
        this.f21722e = obj;
    }

    @Override // yq.m
    public void g(@os.l n1 n1Var) {
        this.f21720c = n1Var;
    }

    @Override // yq.m
    @os.l
    public um.g getContext() {
        return this.f21718a;
    }

    @Override // yq.c
    @an.h
    @lm.k(level = lm.m.ERROR, message = "Replaced with the same extension function", replaceWith = @a1(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @a2
    public void h(long j10, @os.l jn.l<? super um.d<? super R>, ? extends Object> lVar) {
        yq.b.a(this, j10, lVar);
    }

    @Override // yq.m
    public boolean i(@os.l Object obj, @os.m Object obj2) {
        return L(obj, obj2) == 0;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
        invoke2(th2);
        return l2.f10208a;
    }

    public final void u(Object obj) {
        List<l<R>.a> list = this.f21719b;
        l0.m(list);
        List<l<R>.a> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).f21723a == obj) {
                throw new IllegalStateException(c0.a.a("Cannot use select clauses on the same object: ", obj).toString());
            }
        }
    }

    public final void v(l<R>.a aVar) {
        List<l<R>.a> list = this.f21719b;
        if (list == null) {
            return;
        }
        for (l<R>.a aVar2 : list) {
            if (aVar2 != aVar) {
                aVar2.b();
            }
        }
        f21717f.set(this, o.f21738g);
        this.f21722e = o.f21740i;
        this.f21719b = null;
    }

    public final Object w(um.d<? super R> dVar) {
        Object obj = f21717f.get(this);
        l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        l<R>.a aVar = (a) obj;
        Object obj2 = this.f21722e;
        v(aVar);
        return aVar.c(aVar.d(obj2), dVar);
    }

    @os.m
    @z0
    public Object x(@os.l um.d<? super R> dVar) {
        return z(this, dVar);
    }

    @Override // nq.o
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21717f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == o.f21738g) {
                return;
            }
        } while (!j.d.a(atomicReferenceFieldUpdater, this, obj, o.f21739h));
        List<l<R>.a> list = this.f21719b;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
        this.f21722e = o.f21740i;
        this.f21719b = null;
    }
}
