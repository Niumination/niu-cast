package sq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kn.r1;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.n1;
import nq.r2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,731:1\n28#2,4:732\n28#2,4:738\n28#2,4:760\n28#2,4:767\n28#2,4:779\n28#2,4:793\n28#2,4:807\n20#3:736\n20#3:742\n20#3:764\n20#3:771\n20#3:783\n20#3:797\n20#3:811\n329#4:737\n1#5:743\n94#6,2:744\n96#6,2:747\n98#6:750\n94#6,2:772\n96#6,2:775\n98#6:778\n94#6,2:800\n96#6,2:803\n98#6:806\n13579#7:746\n13580#7:749\n13579#7:774\n13580#7:777\n13579#7:802\n13580#7:805\n314#8,9:751\n323#8,2:765\n314#8,9:784\n323#8,2:798\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n351#1:732,4\n391#1:738,4\n485#1:760,4\n506#1:767,4\n626#1:779,4\n661#1:793,4\n689#1:807,4\n351#1:736\n391#1:742\n485#1:764\n506#1:771\n626#1:783\n661#1:797\n689#1:811\n373#1:737\n453#1:744,2\n453#1:747,2\n453#1:750\n529#1:772,2\n529#1:775,2\n529#1:778\n676#1:800,2\n676#1:803,2\n676#1:806\n453#1:746\n453#1:749\n529#1:774\n529#1:777\n676#1:802\n676#1:805\n483#1:751,9\n483#1:765,2\n660#1:784,9\n660#1:798,2\n*E\n"})
public class k0<T> extends tq.b<m0> implements e0<T>, sq.c<T>, tq.r<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f15284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final pq.i f15285g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public Object[] f15286i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f15287n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f15288p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f15289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f15290w;

    public static final class a implements n1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        @os.l
        public final k0<?> f15291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @in.f
        public long f15292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        @in.f
        public final Object f15293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @in.f
        @os.l
        public final um.d<l2> f15294d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l k0<?> k0Var, long j10, @os.m Object obj, @os.l um.d<? super l2> dVar) {
            this.f15291a = k0Var;
            this.f15292b = j10;
            this.f15293c = obj;
            this.f15294d = dVar;
        }

        @Override // nq.n1
        public void dispose() {
            this.f15291a.C(this);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15295a;

        static {
            int[] iArr = new int[pq.i.values().length];
            try {
                iArr[pq.i.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[pq.i.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[pq.i.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15295a = iArr;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {372, 379, 382}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class c<T> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ k0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k0<T> k0Var, um.d<? super c> dVar) {
            super(dVar);
            this.this$0 = k0Var;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k0.E(this.this$0, null, this);
        }
    }

    public k0(int i10, int i11, @os.l pq.i iVar) {
        this.f15283e = i10;
        this.f15284f = i11;
        this.f15285g = iVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Object E(k0<T> k0Var, j<? super T> jVar, um.d<?> dVar) throws Throwable {
        c cVar;
        k0<T> k0Var2;
        Throwable th2;
        m0 m0Var;
        j<? super T> jVar2;
        nq.l2 l2Var;
        j jVar3;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(k0Var, dVar);
            }
        } else {
            cVar = new c(k0Var, dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                m0Var = (m0) cVar.L$2;
                j<? super T> jVar4 = (j) cVar.L$1;
                k0<T> k0Var3 = (k0) cVar.L$0;
                try {
                    d1.n(obj);
                    jVar2 = jVar4;
                    k0Var = k0Var3;
                    try {
                        l2Var = (nq.l2) cVar.getContext().get(nq.l2.f11882k);
                        jVar3 = jVar2;
                    } catch (Throwable th3) {
                        k0Var2 = k0Var;
                        th2 = th3;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    k0Var2 = k0Var3;
                }
            } else {
                if (i11 != 2 && i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                nq.l2 l2Var2 = (nq.l2) cVar.L$3;
                m0Var = (m0) cVar.L$2;
                j jVar5 = (j) cVar.L$1;
                k0Var2 = (k0) cVar.L$0;
                try {
                    d1.n(obj);
                    jVar3 = jVar5;
                    l2Var = l2Var2;
                    k0Var = k0Var2;
                } catch (Throwable th5) {
                    th2 = th5;
                }
            }
            k0Var2.m(m0Var);
            throw th2;
        }
        d1.n(obj);
        m0 m0VarI = k0Var.i();
        try {
            if (jVar instanceof y0) {
                cVar.L$0 = k0Var;
                cVar.L$1 = jVar;
                cVar.L$2 = m0VarI;
                cVar.label = 1;
                if (((y0) jVar).a(cVar) == aVar) {
                    return aVar;
                }
            }
            jVar2 = jVar;
            m0Var = m0VarI;
            l2Var = (nq.l2) cVar.getContext().get(nq.l2.f11882k);
            jVar3 = jVar2;
        } catch (Throwable th6) {
            k0Var2 = k0Var;
            th2 = th6;
            m0Var = m0VarI;
        }
        while (true) {
            Object objZ = k0Var.Z(m0Var);
            if (objZ == l0.f15308a) {
                cVar.L$0 = k0Var;
                cVar.L$1 = jVar3;
                cVar.L$2 = m0Var;
                cVar.L$3 = l2Var;
                cVar.label = 2;
                if (k0Var.B(m0Var, cVar) == aVar) {
                    return aVar;
                }
            } else {
                if (l2Var != null) {
                    r2.x(l2Var);
                }
                cVar.L$0 = k0Var;
                cVar.L$1 = jVar3;
                cVar.L$2 = m0Var;
                cVar.L$3 = l2Var;
                cVar.label = 3;
                if (jVar3.emit(objZ, cVar) == aVar) {
                    return aVar;
                }
            }
        }
    }

    public static <T> Object J(k0<T> k0Var, T t10, um.d<? super l2> dVar) {
        Object objK;
        return (!k0Var.b(t10) && (objK = k0Var.K(t10, dVar)) == wm.a.COROUTINE_SUSPENDED) ? objK : l2.f10208a;
    }

    public static /* synthetic */ void Q() {
    }

    public final Object B(m0 m0Var, um.d<? super l2> dVar) {
        l2 l2Var;
        nq.q qVar = new nq.q(wm.c.e(dVar), 1);
        qVar.F();
        synchronized (this) {
            try {
                if (Y(m0Var) < 0) {
                    m0Var.f15311b = qVar;
                } else {
                    c1.a aVar = c1.Companion;
                    qVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
                }
                l2Var = l2.f10208a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Object objZ = qVar.z();
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        if (objZ == aVar2) {
            xm.h.c(dVar);
        }
        return objZ == aVar2 ? objZ : l2Var;
    }

    public final void C(a aVar) {
        synchronized (this) {
            if (aVar.f15292b < O()) {
                return;
            }
            Object[] objArr = this.f15286i;
            kn.l0.m(objArr);
            if (l0.f(objArr, aVar.f15292b) != aVar) {
                return;
            }
            l0.g(objArr, aVar.f15292b, l0.f15308a);
            D();
            l2 l2Var = l2.f10208a;
        }
    }

    public final void D() {
        if (this.f15284f != 0 || this.f15290w > 1) {
            Object[] objArr = this.f15286i;
            kn.l0.m(objArr);
            while (this.f15290w > 0 && l0.f(objArr, (O() + ((long) U())) - 1) == l0.f15308a) {
                this.f15290w--;
                l0.g(objArr, O() + ((long) U()), null);
            }
        }
    }

    public final void F(long j10) {
        Object[] objArr;
        if (this.f16022b != 0 && (objArr = this.f16021a) != null) {
            for (Object obj : objArr) {
                if (obj != null) {
                    m0 m0Var = (m0) obj;
                    long j11 = m0Var.f15310a;
                    if (j11 >= 0 && j11 < j10) {
                        m0Var.f15310a = j10;
                    }
                }
            }
        }
        this.f15288p = j10;
    }

    @Override // tq.b
    @os.l
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public m0 j() {
        return new m0();
    }

    @Override // tq.b
    @os.l
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public m0[] k(int i10) {
        return new m0[i10];
    }

    public final void I() {
        Object[] objArr = this.f15286i;
        kn.l0.m(objArr);
        l0.g(objArr, O(), null);
        this.f15289v--;
        long jO = O() + 1;
        if (this.f15287n < jO) {
            this.f15287n = jO;
        }
        if (this.f15288p < jO) {
            F(jO);
        }
    }

    public final Object K(T t10, um.d<? super l2> dVar) {
        um.d<l2>[] dVarArrM;
        a aVar;
        nq.q qVar = new nq.q(wm.c.e(dVar), 1);
        qVar.F();
        um.d<l2>[] dVarArrM2 = tq.c.f16028a;
        synchronized (this) {
            try {
                if (W(t10)) {
                    c1.a aVar2 = c1.Companion;
                    qVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
                    dVarArrM = M(dVarArrM2);
                    aVar = null;
                } else {
                    a aVar3 = new a(this, ((long) U()) + O(), t10, qVar);
                    L(aVar3);
                    this.f15290w++;
                    if (this.f15284f == 0) {
                        dVarArrM2 = M(dVarArrM2);
                    }
                    dVarArrM = dVarArrM2;
                    aVar = aVar3;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (aVar != null) {
            nq.s.a(qVar, aVar);
        }
        for (um.d<l2> dVar2 : dVarArrM) {
            if (dVar2 != null) {
                c1.a aVar4 = c1.Companion;
                dVar2.resumeWith(c1.m59constructorimpl(l2.f10208a));
            }
        }
        Object objZ = qVar.z();
        wm.a aVar5 = wm.a.COROUTINE_SUSPENDED;
        if (objZ == aVar5) {
            xm.h.c(dVar);
        }
        return objZ == aVar5 ? objZ : l2.f10208a;
    }

    public final void L(Object obj) {
        int iU = U();
        Object[] objArrV = this.f15286i;
        if (objArrV == null) {
            objArrV = V(null, 0, 2);
        } else if (iU >= objArrV.length) {
            objArrV = V(objArrV, iU, objArrV.length * 2);
        }
        l0.g(objArrV, O() + ((long) iU), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [um.d<lm.l2>[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final um.d<l2>[] M(um.d<l2>[] dVarArr) {
        Object[] objArr;
        m0 m0Var;
        um.d<? super l2> dVar;
        int length = dVarArr.length;
        if (this.f16022b != 0 && (objArr = this.f16021a) != null) {
            int length2 = objArr.length;
            int i10 = 0;
            while (i10 < length2) {
                Object obj = objArr[i10];
                if (obj == null || (dVar = (m0Var = (m0) obj).f15311b) == null || Y(m0Var) < 0) {
                    dVarArr = dVarArr;
                } else {
                    if (length >= dVarArr.length) {
                        dVarArr = dVarArr;
                        dVarArr = dVarArr;
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) dVarArr, Math.max(2, dVarArr.length * 2));
                        kn.l0.o(objArrCopyOf, "copyOf(this, newSize)");
                        dVarArr = objArrCopyOf;
                    }
                    dVarArr = dVarArr;
                    dVarArr = dVarArr;
                    ((um.d[]) dVarArr)[length] = dVar;
                    m0Var.f15311b = null;
                    length++;
                }
                i10++;
                dVarArr = dVarArr;
            }
            dVarArr = dVarArr;
        }
        return (um.d[]) dVarArr;
    }

    public final long N() {
        return O() + ((long) this.f15289v);
    }

    public final long O() {
        return Math.min(this.f15288p, this.f15287n);
    }

    public final T P() {
        Object[] objArr = this.f15286i;
        kn.l0.m(objArr);
        return (T) l0.f(objArr, (this.f15287n + ((long) T())) - 1);
    }

    public final Object R(long j10) {
        Object[] objArr = this.f15286i;
        kn.l0.m(objArr);
        Object objF = l0.f(objArr, j10);
        return objF instanceof a ? ((a) objF).f15293c : objF;
    }

    public final long S() {
        return O() + ((long) this.f15289v) + ((long) this.f15290w);
    }

    public final int T() {
        return (int) ((O() + ((long) this.f15289v)) - this.f15287n);
    }

    public final int U() {
        return this.f15289v + this.f15290w;
    }

    public final Object[] V(Object[] objArr, int i10, int i11) {
        if (i11 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i11];
        this.f15286i = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jO = O();
        for (int i12 = 0; i12 < i10; i12++) {
            long j10 = ((long) i12) + jO;
            l0.g(objArr2, j10, l0.f(objArr, j10));
        }
        return objArr2;
    }

    public final boolean W(T t10) {
        if (this.f16022b == 0) {
            return X(t10);
        }
        if (this.f15289v >= this.f15284f && this.f15288p <= this.f15287n) {
            int i10 = b.f15295a[this.f15285g.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 == 2) {
                return true;
            }
        }
        L(t10);
        int i11 = this.f15289v + 1;
        this.f15289v = i11;
        if (i11 > this.f15284f) {
            I();
        }
        if (T() > this.f15283e) {
            a0(this.f15287n + 1, this.f15288p, N(), S());
        }
        return true;
    }

    public final boolean X(T t10) {
        if (this.f15283e == 0) {
            return true;
        }
        L(t10);
        int i10 = this.f15289v + 1;
        this.f15289v = i10;
        if (i10 > this.f15283e) {
            I();
        }
        this.f15288p = O() + ((long) this.f15289v);
        return true;
    }

    public final long Y(m0 m0Var) {
        long j10 = m0Var.f15310a;
        if (j10 < N()) {
            return j10;
        }
        if (this.f15284f <= 0 && j10 <= O() && this.f15290w != 0) {
            return j10;
        }
        return -1L;
    }

    public final Object Z(m0 m0Var) {
        Object obj;
        um.d<l2>[] dVarArrB0 = tq.c.f16028a;
        synchronized (this) {
            try {
                long jY = Y(m0Var);
                if (jY < 0) {
                    obj = l0.f15308a;
                } else {
                    long j10 = m0Var.f15310a;
                    Object objR = R(jY);
                    m0Var.f15310a = jY + 1;
                    dVarArrB0 = b0(j10);
                    obj = objR;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        for (um.d<l2> dVar : dVarArrB0) {
            if (dVar != null) {
                c1.a aVar = c1.Companion;
                dVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
            }
        }
        return obj;
    }

    @Override // sq.j0, sq.i
    @os.m
    public Object a(@os.l j<? super T> jVar, @os.l um.d<?> dVar) {
        return E(this, jVar, dVar);
    }

    public final void a0(long j10, long j11, long j12, long j13) {
        long jMin = Math.min(j11, j10);
        for (long jO = O(); jO < jMin; jO++) {
            Object[] objArr = this.f15286i;
            kn.l0.m(objArr);
            l0.g(objArr, jO, null);
        }
        this.f15287n = j10;
        this.f15288p = j11;
        this.f15289v = (int) (j12 - jMin);
        this.f15290w = (int) (j13 - j12);
    }

    @Override // sq.e0
    public boolean b(T t10) {
        int i10;
        boolean z10;
        um.d<l2>[] dVarArrM = tq.c.f16028a;
        synchronized (this) {
            if (W(t10)) {
                dVarArrM = M(dVarArrM);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (um.d<l2> dVar : dVarArrM) {
            if (dVar != null) {
                c1.a aVar = c1.Companion;
                dVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
            }
        }
        return z10;
    }

    @os.l
    public final um.d<l2>[] b0(long j10) {
        long j11;
        long j12;
        long j13;
        Object[] objArr;
        if (j10 > this.f15288p) {
            return tq.c.f16028a;
        }
        long jO = O();
        long j14 = ((long) this.f15289v) + jO;
        if (this.f15284f == 0 && this.f15290w > 0) {
            j14++;
        }
        if (this.f16022b != 0 && (objArr = this.f16021a) != null) {
            for (Object obj : objArr) {
                if (obj != null) {
                    long j15 = ((m0) obj).f15310a;
                    if (j15 >= 0 && j15 < j14) {
                        j14 = j15;
                    }
                }
            }
        }
        if (j14 <= this.f15288p) {
            return tq.c.f16028a;
        }
        long jN = N();
        int iMin = this.f16022b > 0 ? Math.min(this.f15290w, this.f15284f - ((int) (jN - j14))) : this.f15290w;
        um.d<l2>[] dVarArr = tq.c.f16028a;
        long j16 = ((long) this.f15290w) + jN;
        if (iMin > 0) {
            dVarArr = new um.d[iMin];
            Object[] objArr2 = this.f15286i;
            kn.l0.m(objArr2);
            long j17 = jN;
            int i10 = 0;
            while (true) {
                if (jN >= j16) {
                    j11 = j14;
                    j12 = j16;
                    break;
                }
                Object objF = l0.f(objArr2, jN);
                j11 = j14;
                vq.u0 u0Var = l0.f15308a;
                if (objF != u0Var) {
                    kn.l0.n(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objF;
                    int i11 = i10 + 1;
                    j12 = j16;
                    dVarArr[i10] = aVar.f15294d;
                    l0.g(objArr2, jN, u0Var);
                    l0.g(objArr2, j17, aVar.f15293c);
                    j13 = 1;
                    j17++;
                    if (i11 >= iMin) {
                        break;
                    }
                    i10 = i11;
                } else {
                    j12 = j16;
                    j13 = 1;
                }
                jN += j13;
                j14 = j11;
                j16 = j12;
            }
            jN = j17;
        } else {
            j11 = j14;
            j12 = j16;
        }
        int i12 = (int) (jN - jO);
        long j18 = this.f16022b == 0 ? jN : j11;
        long jMax = Math.max(this.f15287n, jN - ((long) Math.min(this.f15283e, i12)));
        if (this.f15284f == 0 && jMax < j12) {
            Object[] objArr3 = this.f15286i;
            kn.l0.m(objArr3);
            if (kn.l0.g(l0.f(objArr3, jMax), l0.f15308a)) {
                jN++;
                jMax++;
            }
        }
        a0(jMax, j18, jN, j12);
        D();
        return !(dVarArr.length == 0) ? M(dVarArr) : dVarArr;
    }

    @Override // tq.r
    @os.l
    public i<T> c(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return l0.e(this, gVar, i10, iVar);
    }

    public final long c0() {
        long j10 = this.f15287n;
        if (j10 < this.f15288p) {
            this.f15288p = j10;
        }
        return j10;
    }

    @Override // sq.j0
    @os.l
    public List<T> e() {
        synchronized (this) {
            int iT = T();
            if (iT == 0) {
                return nm.k0.INSTANCE;
            }
            ArrayList arrayList = new ArrayList(iT);
            Object[] objArr = this.f15286i;
            kn.l0.m(objArr);
            for (int i10 = 0; i10 < iT; i10++) {
                arrayList.add(l0.f(objArr, this.f15287n + ((long) i10)));
            }
            return arrayList;
        }
    }

    @Override // sq.e0, sq.j
    @os.m
    public Object emit(T t10, @os.l um.d<? super l2> dVar) {
        return J(this, t10, dVar);
    }

    @Override // sq.e0
    public void f() {
        synchronized (this) {
            a0(N(), this.f15288p, N(), S());
            l2 l2Var = l2.f10208a;
        }
    }
}
