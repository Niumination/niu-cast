package sq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,428:1\n18#2:429\n18#2:443\n28#3,4:430\n28#3,4:437\n20#4:434\n20#4:441\n13579#5,2:435\n329#6:442\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n315#1:429\n396#1:443\n324#1:430,4\n352#1:437,4\n324#1:434\n352#1:441\n348#1:435,2\n385#1:442\n*E\n"})
public final class v0<T> extends tq.b<x0> implements f0<T>, c<T>, tq.r<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f15378f = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_state");

    @os.m
    @in.x
    private volatile Object _state;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15379e;

    @xm.f(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {384, 396, TypedValues.CycleType.TYPE_CURVE_FIT}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ v0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v0<T> v0Var, um.d<? super a> dVar) {
            super(dVar);
            this.this$0 = v0Var;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a(null, this);
        }
    }

    public v0(@os.l Object obj) {
        this._state = obj;
    }

    public static /* synthetic */ void r() {
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b2 A[Catch: all -> 0x0076, TryCatch #1 {all -> 0x0076, blocks: (B:35:0x00aa, B:37:0x00b2, B:39:0x00b7, B:50:0x00dc, B:52:0x00e2, B:41:0x00bd, B:45:0x00c4, B:24:0x0072, B:34:0x009b, B:29:0x0085, B:31:0x0089), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b7 A[Catch: all -> 0x0076, TryCatch #1 {all -> 0x0076, blocks: (B:35:0x00aa, B:37:0x00b2, B:39:0x00b7, B:50:0x00dc, B:52:0x00e2, B:41:0x00bd, B:45:0x00c4, B:24:0x0072, B:34:0x009b, B:29:0x0085, B:31:0x0089), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e2 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #1 {all -> 0x0076, blocks: (B:35:0x00aa, B:37:0x00b2, B:39:0x00b7, B:50:0x00dc, B:52:0x00e2, B:41:0x00bd, B:45:0x00c4, B:24:0x0072, B:34:0x009b, B:29:0x0085, B:31:0x0089), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [tq.d] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, sq.x0] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, sq.j] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e0 -> B:35:0x00aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f2 -> B:35:0x00aa). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // sq.j0, sq.i
    @os.m
    public java.lang.Object a(@os.l sq.j<? super T> r11, @os.l um.d<?> r12) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sq.v0.a(sq.j, um.d):java.lang.Object");
    }

    @Override // sq.e0
    public boolean b(T t10) {
        setValue(t10);
        return true;
    }

    @Override // tq.r
    @os.l
    public i<T> c(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return w0.d(this, gVar, i10, iVar);
    }

    @Override // sq.f0
    public boolean compareAndSet(T t10, T t11) {
        if (t10 == null) {
            t10 = (T) tq.u.f16062a;
        }
        if (t11 == null) {
            t11 = (T) tq.u.f16062a;
        }
        return s(t10, t11);
    }

    @Override // sq.j0
    @os.l
    public List<T> e() {
        return nm.x.k(getValue());
    }

    @Override // sq.e0, sq.j
    @os.m
    public Object emit(T t10, @os.l um.d<? super l2> dVar) {
        setValue(t10);
        return l2.f10208a;
    }

    @Override // sq.e0
    public void f() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // sq.f0, sq.u0
    public T getValue() {
        vq.u0 u0Var = tq.u.f16062a;
        T t10 = (T) f15378f.get(this);
        if (t10 == u0Var) {
            return null;
        }
        return t10;
    }

    @Override // tq.b
    public tq.d j() {
        return new x0();
    }

    @Override // tq.b
    public tq.d[] k(int i10) {
        return new x0[i10];
    }

    @os.l
    public x0 p() {
        return new x0();
    }

    @os.l
    public x0[] q(int i10) {
        return new x0[i10];
    }

    public final boolean s(Object obj, Object obj2) {
        int i10;
        Object obj3;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15378f;
            Object obj4 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kn.l0.g(obj4, obj)) {
                return false;
            }
            if (kn.l0.g(obj4, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i11 = this.f15379e;
            if ((i11 & 1) != 0) {
                this.f15379e = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.f15379e = i12;
            Object obj5 = this.f16021a;
            l2 l2Var = l2.f10208a;
            while (true) {
                x0[] x0VarArr = (x0[]) obj5;
                if (x0VarArr != null) {
                    for (x0 x0Var : x0VarArr) {
                        if (x0Var != null) {
                            x0Var.h();
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.f15379e;
                    if (i10 == i12) {
                        this.f15379e = i12 + 1;
                        return true;
                    }
                    obj3 = this.f16021a;
                    l2 l2Var2 = l2.f10208a;
                }
                obj5 = obj3;
                i12 = i10;
            }
        }
    }

    @Override // sq.f0
    public void setValue(T t10) {
        if (t10 == null) {
            t10 = (T) tq.u.f16062a;
        }
        s(null, t10);
    }
}
