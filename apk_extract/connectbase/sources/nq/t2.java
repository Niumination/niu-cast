package nq;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 9 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 10 CompletionHandler.common.kt\nkotlinx/coroutines/CompletionHandler_commonKt\n+ 11 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 12 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 13 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1454:1\n706#1,2:1461\n367#1,2:1471\n369#1,4:1476\n373#1,4:1482\n377#1,2:1489\n367#1,2:1491\n369#1,4:1496\n373#1,4:1502\n377#1,2:1509\n178#1,2:1518\n707#1:1520\n178#1,2:1521\n178#1,2:1540\n178#1,2:1555\n706#1,2:1557\n706#1,2:1559\n178#1,2:1561\n706#1,2:1563\n178#1,2:1565\n178#1,2:1572\n178#1,2:1574\n1#2:1455\n1#2:1480\n1#2:1500\n28#3,4:1456\n28#3,4:1523\n28#3,4:1567\n28#3,4:1576\n20#4:1460\n20#4:1527\n20#4:1571\n20#4:1580\n288#5,2:1463\n288#5,2:1465\n19#6:1467\n163#7:1468\n163#7:1469\n153#7,4:1583\n75#8:1470\n75#8:1481\n75#8:1501\n75#8:1514\n341#9,3:1473\n344#9,3:1486\n341#9,3:1493\n344#9,3:1506\n341#9,3:1511\n344#9,3:1515\n47#10:1528\n22#11:1529\n22#11:1530\n13#11:1551\n13#11:1554\n13#11:1581\n13#11:1582\n13#11:1587\n13#11:1588\n134#12:1531\n73#12,3:1532\n135#12,5:1535\n314#13,9:1542\n323#13,2:1552\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n250#1:1461,2\n332#1:1471,2\n332#1:1476,4\n332#1:1482,4\n332#1:1489,2\n364#1:1491,2\n364#1:1496,4\n364#1:1502,4\n364#1:1509,2\n381#1:1518,2\n426#1:1520\n461#1:1521,2\n553#1:1540,2\n594#1:1555,2\n621#1:1557,2\n630#1:1559,2\n694#1:1561,2\n723#1:1563,2\n736#1:1565,2\n809#1:1572,2\n831#1:1574,2\n332#1:1480\n364#1:1500\n213#1:1456,4\n478#1:1523,4\n739#1:1567,4\n884#1:1576,4\n213#1:1460\n478#1:1527\n739#1:1571\n884#1:1580\n261#1:1463,2\n265#1:1465,2\n273#1:1467\n279#1:1468\n281#1:1469\n1218#1:1583,4\n284#1:1470\n332#1:1481\n364#1:1501\n372#1:1514\n332#1:1473,3\n332#1:1486,3\n364#1:1493,3\n364#1:1506,3\n368#1:1511,3\n368#1:1515,3\n483#1:1528\n495#1:1529\n505#1:1530\n561#1:1551\n577#1:1554\n924#1:1581\n974#1:1582\n1237#1:1587\n1259#1:1588\n526#1:1531\n526#1:1532,3\n526#1:1535,5\n559#1:1542,9\n559#1:1552,2\n*E\n"})
@lm.k(level = lm.m.ERROR, message = "This is internal API and may be removed in the future releases")
public class t2 implements l2, x, d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f11929a = AtomicReferenceFieldUpdater.newUpdater(t2.class, Object.class, "_state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f11930b = AtomicReferenceFieldUpdater.newUpdater(t2.class, Object.class, "_parentHandle");

    @os.m
    @in.x
    private volatile Object _parentHandle;

    @os.m
    @in.x
    private volatile Object _state;

    @kn.r1({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    public static final class a<T> extends q<T> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @os.l
        public final t2 f11931n;

        public a(@os.l um.d<? super T> dVar, @os.l t2 t2Var) {
            super(dVar, 1);
            this.f11931n = t2Var;
        }

        @Override // nq.q
        @os.l
        public String O() {
            return "AwaitContinuation";
        }

        @Override // nq.q
        @os.l
        public Throwable x(@os.l l2 l2Var) {
            Throwable thE;
            Object objV0 = this.f11931n.V0();
            if (!(objV0 instanceof c) || (thE = ((c) objV0).e()) == null) {
                return objV0 instanceof d0 ? ((d0) objV0).f11836a : l2Var.O();
            }
            return thE;
        }
    }

    public static final class b extends s2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final t2 f11932e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final c f11933f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final w f11934g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.m
        public final Object f11935i;

        public b(@os.l t2 t2Var, @os.l c cVar, @os.l w wVar, @os.m Object obj) {
            this.f11932e = t2Var;
            this.f11933f = cVar;
            this.f11934g = wVar;
            this.f11935i = obj;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
            invoke2(th2);
            return lm.l2.f10208a;
        }

        @Override // nq.f0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@os.m Throwable th2) {
            this.f11932e.r0(this.f11933f, this.f11934g, this.f11935i);
        }
    }

    @kn.r1({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    public static final class c implements e2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final AtomicIntegerFieldUpdater f11936b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final AtomicReferenceFieldUpdater f11937c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final AtomicReferenceFieldUpdater f11938d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");

        @os.m
        @in.x
        private volatile Object _exceptionsHolder;

        @in.x
        private volatile int _isCompleting;

        @os.m
        @in.x
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final y2 f11939a;

        public c(@os.l y2 y2Var, boolean z10, @os.m Throwable th2) {
            this.f11939a = y2Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@os.l Throwable th2) {
            Throwable thE = e();
            if (thE == null) {
                l(th2);
                return;
            }
            if (th2 == thE) {
                return;
            }
            Object obj = f11938d.get(this);
            if (obj == null) {
                k(th2);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th2);
                    return;
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
            if (th2 == obj) {
                return;
            }
            ArrayList<Throwable> arrayListC = c();
            arrayListC.add(obj);
            arrayListC.add(th2);
            k(arrayListC);
        }

        @Override // nq.e2
        @os.l
        public y2 b() {
            return this.f11939a;
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        public final Object d() {
            return f11938d.get(this);
        }

        @os.m
        public final Throwable e() {
            return (Throwable) f11937c.get(this);
        }

        public final boolean f() {
            return e() != null;
        }

        public final boolean g() {
            return f11936b.get(this) != 0;
        }

        public final boolean h() {
            return f11938d.get(this) == u2.f11956h;
        }

        @os.l
        public final List<Throwable> i(@os.m Throwable th2) {
            ArrayList arrayListC;
            Object obj = f11938d.get(this);
            if (obj == null) {
                arrayListC = c();
            } else if (obj instanceof Throwable) {
                ArrayList arrayListC2 = c();
                arrayListC2.add(obj);
                arrayListC = arrayListC2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayListC = (ArrayList) obj;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (th2 != null && !kn.l0.g(th2, thE)) {
                arrayListC.add(th2);
            }
            k(u2.f11956h);
            return arrayListC;
        }

        @Override // nq.e2
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z10) {
            f11936b.set(this, z10 ? 1 : 0);
        }

        public final void k(Object obj) {
            f11938d.set(this, obj);
        }

        public final void l(@os.m Throwable th2) {
            f11937c.set(this, th2);
        }

        @os.l
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + f11938d.get(this) + ", list=" + this.f11939a + ']';
        }
    }

    public final class d extends s2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final yq.m<?> f11940e;

        public d(yq.m<?> mVar) {
            this.f11940e = mVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
            invoke2(th2);
            return lm.l2.f10208a;
        }

        @Override // nq.f0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@os.m Throwable th2) {
            Object objV0 = t2.this.V0();
            if (!(objV0 instanceof d0)) {
                objV0 = u2.h(objV0);
            }
            this.f11940e.i(t2.this, objV0);
        }
    }

    public final class e extends s2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final yq.m<?> f11942e;

        public e(yq.m<?> mVar) {
            this.f11942e = mVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
            invoke2(th2);
            return lm.l2.f10208a;
        }

        @Override // nq.f0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@os.m Throwable th2) {
            this.f11942e.i(t2.this, lm.l2.f10208a);
        }
    }

    @kn.r1({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,367:1\n526#2:368\n*E\n"})
    public static final class f extends vq.a0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t2 f11944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f11945e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(vq.a0 a0Var, t2 t2Var, Object obj) {
            super(a0Var);
            this.f11944d = t2Var;
            this.f11945e = obj;
        }

        @Override // vq.b
        @os.m
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(@os.l vq.a0 a0Var) {
            if (this.f11944d.V0() == this.f11945e) {
                return null;
            }
            return vq.z.a();
        }
    }

    @kn.r1({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n*L\n958#1:1455,6\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {956, 958}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
    public static final class g extends xm.k implements jn.p<gq.o<? super l2>, um.d<? super lm.l2>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public g(um.d<? super g> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            g gVar = t2.this.new g(dVar);
            gVar.L$0 = obj;
            return gVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super l2> oVar, @os.m um.d<? super lm.l2> dVar) {
            return ((g) create(oVar, dVar)).invokeSuspend(lm.l2.f10208a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0067  */
        /* JADX WARN: Code duplicated, block: B:24:0x006b  */
        /* JADX WARN: Code duplicated, block: B:26:0x007e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0069 -> B:27:0x007f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007c -> B:27:0x007f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
            /*
                r6 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L24
                if (r1 != r2) goto L1c
                java.lang.Object r1 = r6.L$2
                vq.a0 r1 = (vq.a0) r1
                java.lang.Object r3 = r6.L$1
                vq.y r3 = (vq.y) r3
                java.lang.Object r4 = r6.L$0
                gq.o r4 = (gq.o) r4
                lm.d1.n(r7)
                goto L7f
            L1c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L24:
                lm.d1.n(r7)
                goto L84
            L28:
                lm.d1.n(r7)
                java.lang.Object r7 = r6.L$0
                gq.o r7 = (gq.o) r7
                nq.t2 r1 = nq.t2.this
                java.lang.Object r1 = r1.V0()
                boolean r4 = r1 instanceof nq.w
                if (r4 == 0) goto L46
                nq.w r1 = (nq.w) r1
                nq.x r1 = r1.f11972e
                r6.label = r3
                java.lang.Object r6 = r7.a(r1, r6)
                if (r6 != r0) goto L84
                return r0
            L46:
                boolean r3 = r1 instanceof nq.e2
                if (r3 == 0) goto L84
                nq.e2 r1 = (nq.e2) r1
                nq.y2 r1 = r1.b()
                if (r1 == 0) goto L84
                java.lang.Object r3 = r1.n()
                java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
                kn.l0.n(r3, r4)
                vq.a0 r3 = (vq.a0) r3
                r4 = r7
                r5 = r3
                r3 = r1
                r1 = r5
            L61:
                boolean r7 = kn.l0.g(r1, r3)
                if (r7 != 0) goto L84
                boolean r7 = r1 instanceof nq.w
                if (r7 == 0) goto L7f
                r7 = r1
                nq.w r7 = (nq.w) r7
                nq.x r7 = r7.f11972e
                r6.L$0 = r4
                r6.L$1 = r3
                r6.L$2 = r1
                r6.label = r2
                java.lang.Object r7 = r4.a(r7, r6)
                if (r7 != r0) goto L7f
                return r0
            L7f:
                vq.a0 r1 = r1.o()
                goto L61
            L84:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: nq.t2.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public /* synthetic */ class h extends kn.h0 implements jn.q<t2, yq.m<?>, Object, lm.l2> {
        public static final h INSTANCE = new h();

        public h() {
            super(3, t2.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ lm.l2 invoke(t2 t2Var, yq.m<?> mVar, Object obj) {
            invoke2(t2Var, mVar, obj);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l t2 t2Var, @os.l yq.m<?> mVar, @os.m Object obj) {
            t2Var.r1(mVar, obj);
        }
    }

    public /* synthetic */ class i extends kn.h0 implements jn.q<t2, Object, Object, Object> {
        public static final i INSTANCE = new i();

        public i() {
            super(3, t2.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l t2 t2Var, @os.m Object obj, @os.m Object obj2) {
            return t2Var.q1(obj, obj2);
        }
    }

    public /* synthetic */ class j extends kn.h0 implements jn.q<t2, yq.m<?>, Object, lm.l2> {
        public static final j INSTANCE = new j();

        public j() {
            super(3, t2.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ lm.l2 invoke(t2 t2Var, yq.m<?> mVar, Object obj) {
            invoke2(t2Var, mVar, obj);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l t2 t2Var, @os.l yq.m<?> mVar, @os.m Object obj) {
            t2Var.x1(mVar, obj);
        }
    }

    public t2(boolean z10) {
        this._state = z10 ? u2.f11958j : u2.f11957i;
    }

    public static /* synthetic */ CancellationException F1(t2 t2Var, Throwable th2, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return t2Var.E1(th2, str);
    }

    public static /* synthetic */ void K0() {
    }

    public static /* synthetic */ void M0() {
    }

    private final void f1(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, lm.l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public static /* synthetic */ m2 x0(t2 t2Var, String str, Throwable th2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            th2 = null;
        }
        if (str == null) {
            str = t2Var.m0();
        }
        return new m2(str, th2, t2Var);
    }

    @os.m
    public final Throwable A() {
        Object objV0 = V0();
        if (objV0 instanceof e2) {
            throw new IllegalStateException("This job has not completed yet");
        }
        return E0(objV0);
    }

    public final w A0(e2 e2Var) {
        w wVar = e2Var instanceof w ? (w) e2Var : null;
        if (wVar != null) {
            return wVar;
        }
        y2 y2VarB = e2Var.b();
        if (y2VarB != null) {
            return m1(y2VarB);
        }
        return null;
    }

    public final int A1(Object obj) {
        if (obj instanceof q1) {
            if (((q1) obj).f11902a) {
                return 0;
            }
            if (!j.d.a(f11929a, this, obj, u2.f11958j)) {
                return -1;
            }
            u1();
            return 1;
        }
        if (!(obj instanceof d2)) {
            return 0;
        }
        if (!j.d.a(f11929a, this, obj, ((d2) obj).f11837a)) {
            return -1;
        }
        u1();
        return 1;
    }

    @os.m
    public final Object B0() throws Throwable {
        Object objV0 = V0();
        if (objV0 instanceof e2) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (objV0 instanceof d0) {
            throw ((d0) objV0).f11836a;
        }
        return u2.h(objV0);
    }

    @os.m
    public final Throwable C0() {
        Object objV0 = V0();
        if (objV0 instanceof c) {
            Throwable thE = ((c) objV0).e();
            if (thE != null) {
                return thE;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objV0 instanceof e2) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objV0 instanceof d0) {
            return ((d0) objV0).f11836a;
        }
        return null;
    }

    public final String C1(Object obj) {
        if (!(obj instanceof c)) {
            if (obj instanceof e2) {
                return ((e2) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof d0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        if (cVar.f()) {
            return "Cancelling";
        }
        return cVar.g() ? "Completing" : "Active";
    }

    public final boolean D0() {
        Object objV0 = V0();
        return (objV0 instanceof d0) && ((d0) objV0).a();
    }

    public final Throwable E0(Object obj) {
        d0 d0Var = obj instanceof d0 ? (d0) obj : null;
        if (d0Var != null) {
            return d0Var.f11836a;
        }
        return null;
    }

    @os.l
    public final CancellationException E1(@os.l Throwable th2, @os.m String str) {
        CancellationException m2Var = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (m2Var == null) {
            if (str == null) {
                str = m0();
            }
            m2Var = new m2(str, th2, this);
        }
        return m2Var;
    }

    public final Throwable G0(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new m2(m0(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list2 = list;
        Iterator<T> it = list2.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Throwable) next) instanceof CancellationException);
        Throwable th2 = (Throwable) next;
        if (th2 != null) {
            return th2;
        }
        Throwable th3 = list.get(0);
        if (th3 instanceof v3) {
            for (Object obj2 : list2) {
                Throwable th4 = (Throwable) obj2;
                if (th4 != th3 && (th4 instanceof v3)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th5 = (Throwable) obj;
            if (th5 != null) {
                return th5;
            }
        }
        return th3;
    }

    @g2
    @os.l
    public final String G1() {
        return l1() + rs.f.f14859a + C1(V0()) + rs.f.f14860b;
    }

    public boolean H0() {
        return true;
    }

    public final boolean H1(e2 e2Var, Object obj) throws Throwable {
        if (!j.d.a(f11929a, this, e2Var, u2.g(obj))) {
            return false;
        }
        s1(null);
        t1(obj);
        o0(e2Var, obj);
        return true;
    }

    @os.l
    public final yq.g<?> I0() {
        h hVar = h.INSTANCE;
        kn.l0.n(hVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        jn.q qVar = (jn.q) kn.u1.q(hVar, 3);
        i iVar = i.INSTANCE;
        kn.l0.n(iVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new yq.h(this, qVar, (jn.q) kn.u1.q(iVar, 3), null, 8, null);
    }

    @Override // nq.l2
    @os.l
    public final yq.e J1() {
        j jVar = j.INSTANCE;
        kn.l0.n(jVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new yq.f(this, (jn.q) kn.u1.q(jVar, 3), null, 4, null);
    }

    public final boolean K1(e2 e2Var, Throwable th2) throws Throwable {
        y2 y2VarN0 = N0(e2Var);
        if (y2VarN0 == null) {
            return false;
        }
        if (!j.d.a(f11929a, this, e2Var, new c(y2VarN0, false, th2))) {
            return false;
        }
        n1(y2VarN0, th2);
        return true;
    }

    public boolean L0() {
        return false;
    }

    public final Object L1(Object obj, Object obj2) {
        if (!(obj instanceof e2)) {
            return u2.f11949a;
        }
        if ((!(obj instanceof q1) && !(obj instanceof s2)) || (obj instanceof w) || (obj2 instanceof d0)) {
            return M1((e2) obj, obj2);
        }
        return H1((e2) obj, obj2) ? obj2 : u2.f11951c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final Object M1(e2 e2Var, Object obj) throws Throwable {
        y2 y2VarN0 = N0(e2Var);
        if (y2VarN0 == null) {
            return u2.f11951c;
        }
        c cVar = e2Var instanceof c ? (c) e2Var : null;
        if (cVar == null) {
            cVar = new c(y2VarN0, false, null);
        }
        kn.k1.h hVar = new kn.k1.h();
        synchronized (cVar) {
            if (cVar.g()) {
                return u2.f11949a;
            }
            cVar.j(true);
            if (cVar != e2Var && !j.d.a(f11929a, this, e2Var, cVar)) {
                return u2.f11951c;
            }
            boolean zF = cVar.f();
            d0 d0Var = obj instanceof d0 ? (d0) obj : null;
            if (d0Var != null) {
                cVar.a(d0Var.f11836a);
            }
            ?? E = zF ? 0 : cVar.e();
            hVar.element = E;
            lm.l2 l2Var = lm.l2.f10208a;
            if (E != 0) {
                n1(y2VarN0, E);
            }
            w wVarA0 = A0(e2Var);
            return (wVarA0 == null || !N1(cVar, wVarA0, obj)) ? z0(cVar, obj) : u2.f11950b;
        }
    }

    public final y2 N0(e2 e2Var) {
        y2 y2VarB = e2Var.b();
        if (y2VarB != null) {
            return y2VarB;
        }
        if (e2Var instanceof q1) {
            return new y2();
        }
        if (e2Var instanceof s2) {
            w1((s2) e2Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + e2Var).toString());
    }

    public final boolean N1(c cVar, w wVar, Object obj) {
        while (l2.a.g(wVar.f11972e, false, false, new b(this, cVar, wVar, obj), 1, null) == a3.f11823a) {
            wVar = m1(wVar);
            if (wVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // nq.l2
    @os.l
    public final CancellationException O() {
        Object objV0 = V0();
        if (!(objV0 instanceof c)) {
            if (objV0 instanceof e2) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objV0 instanceof d0) {
                return F1(this, ((d0) objV0).f11836a, null, 1, null);
            }
            return new m2(x0.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((c) objV0).e();
        if (thE != null) {
            CancellationException cancellationExceptionE1 = E1(thE, x0.a(this) + " is cancelling");
            if (cancellationExceptionE1 != null) {
                return cancellationExceptionE1;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // nq.x
    public final void P0(@os.l d3 d3Var) throws Throwable {
        c0(d3Var);
    }

    @os.m
    public final v R0() {
        return (v) f11930b.get(this);
    }

    @Override // nq.l2
    @os.l
    public final n1 S1(boolean z10, boolean z11, @os.l jn.l<? super Throwable, lm.l2> lVar) {
        s2 s2VarK1 = k1(lVar, z10);
        while (true) {
            Object objV0 = V0();
            if (objV0 instanceof q1) {
                q1 q1Var = (q1) objV0;
                if (!q1Var.f11902a) {
                    v1(q1Var);
                } else if (j.d.a(f11929a, this, objV0, s2VarK1)) {
                    return s2VarK1;
                }
            } else {
                Throwable thE = null;
                if (!(objV0 instanceof e2)) {
                    if (z11) {
                        d0 d0Var = objV0 instanceof d0 ? (d0) objV0 : null;
                        lVar.invoke(d0Var != null ? d0Var.f11836a : null);
                    }
                    return a3.f11823a;
                }
                y2 y2VarB = ((e2) objV0).b();
                if (y2VarB == null) {
                    kn.l0.n(objV0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    w1((s2) objV0);
                } else {
                    n1 n1Var = a3.f11823a;
                    if (z10 && (objV0 instanceof c)) {
                        synchronized (objV0) {
                            try {
                                thE = ((c) objV0).e();
                                if (thE == null || ((lVar instanceof w) && !((c) objV0).g())) {
                                    if (V(objV0, y2VarB, s2VarK1)) {
                                        if (thE == null) {
                                            return s2VarK1;
                                        }
                                        n1Var = s2VarK1;
                                    }
                                }
                                lm.l2 l2Var = lm.l2.f10208a;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                    if (thE != null) {
                        if (z11) {
                            lVar.invoke(thE);
                        }
                        return n1Var;
                    }
                    if (V(objV0, y2VarB, s2VarK1)) {
                        return s2VarK1;
                    }
                }
            }
        }
    }

    public final boolean V(Object obj, y2 y2Var, s2 s2Var) {
        int iA;
        f fVar = new f(s2Var, this, obj);
        do {
            iA = y2Var.p().A(s2Var, y2Var, fVar);
            if (iA == 1) {
                return true;
            }
        } while (iA != 2);
        return false;
    }

    @os.m
    public final Object V0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11929a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof vq.m0)) {
                return obj;
            }
            ((vq.m0) obj).b(this);
        }
    }

    public final void W(Throwable th2, List<? extends Throwable> list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th3 : list) {
            if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                lm.p.a(th2, th3);
            }
        }
    }

    public boolean W0(@os.l Throwable th2) {
        return false;
    }

    public void X(@os.m Object obj) {
    }

    public void X0(@os.l Throwable th2) throws Throwable {
        throw th2;
    }

    @os.m
    public final Object Y(@os.l um.d<Object> dVar) throws Throwable {
        Object objV0;
        do {
            objV0 = V0();
            if (!(objV0 instanceof e2)) {
                if (objV0 instanceof d0) {
                    throw ((d0) objV0).f11836a;
                }
                return u2.h(objV0);
            }
        } while (A1(objV0) < 0);
        return Z(dVar);
    }

    public final void Y0(@os.m l2 l2Var) {
        if (l2Var == null) {
            z1(a3.f11823a);
            return;
        }
        l2Var.start();
        v vVarO = l2Var.o(this);
        z1(vVarO);
        if (isCompleted()) {
            vVarO.dispose();
            z1(a3.f11823a);
        }
    }

    public final Object Z(um.d<Object> dVar) {
        a aVar = new a(wm.c.e(dVar), this);
        aVar.F();
        s.a(aVar, S1(false, true, new e3(aVar)));
        Object objZ = aVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objZ;
    }

    public final boolean Z0(e2 e2Var) {
        return (e2Var instanceof c) && ((c) e2Var).f();
    }

    public final boolean a0(@os.m Throwable th2) {
        return c0(th2);
    }

    public final boolean a1() {
        return V0() instanceof d0;
    }

    @Override // nq.l2
    public void b(@os.m CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new m2(m0(), null, this);
        }
        d0(cancellationException);
    }

    public boolean b1() {
        return false;
    }

    @Override // nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean c(Throwable th2) throws Throwable {
        Throwable m2Var;
        if (th2 == null || (m2Var = F1(this, th2, null, 1, null)) == null) {
            m2Var = new m2(m0(), null, this);
        }
        d0(m2Var);
        return true;
    }

    public final boolean c0(@os.m Object obj) throws Throwable {
        Object objH1 = u2.f11949a;
        if (L0() && (objH1 = h0(obj)) == u2.f11950b) {
            return true;
        }
        vq.u0 u0Var = u2.f11949a;
        if (objH1 == u0Var) {
            objH1 = h1(obj);
        }
        if (objH1 == u0Var || objH1 == u2.f11950b) {
            return true;
        }
        if (objH1 == u2.f11952d) {
            return false;
        }
        X(objH1);
        return true;
    }

    @Override // nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    public void d0(@os.l Throwable th2) throws Throwable {
        c0(th2);
    }

    public final boolean d1() {
        Object objV0;
        do {
            objV0 = V0();
            if (!(objV0 instanceof e2)) {
                return false;
            }
        } while (A1(objV0) < 0);
        return true;
    }

    public final Object e1(um.d<? super lm.l2> dVar) {
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        s.a(qVar, S1(false, true, new f3(qVar)));
        Object objZ = qVar.z();
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        if (objZ == aVar) {
            xm.h.c(dVar);
        }
        return objZ == aVar ? objZ : lm.l2.f10208a;
    }

    @Override // um.g.b, um.g
    public <R> R fold(R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
        return (R) um.g.b.a.a(this, r10, pVar);
    }

    public final Void g1(jn.l<Object, lm.l2> lVar) {
        while (true) {
            lVar.invoke(V0());
        }
    }

    @Override // um.g.b, um.g
    @os.m
    public <E extends um.g.b> E get(@os.l um.g.c<E> cVar) {
        return (E) um.g.b.a.b(this, cVar);
    }

    @Override // um.g.b
    @os.l
    public final um.g.c<?> getKey() {
        return l2.f11882k;
    }

    @Override // nq.l2
    @os.m
    public l2 getParent() {
        v vVarR0 = R0();
        if (vVarR0 != null) {
            return vVarR0.getParent();
        }
        return null;
    }

    public final Object h0(Object obj) {
        Object objL1;
        do {
            Object objV0 = V0();
            if (!(objV0 instanceof e2) || ((objV0 instanceof c) && ((c) objV0).g())) {
                return u2.f11949a;
            }
            objL1 = L1(objV0, new d0(s0(obj), false, 2, null));
        } while (objL1 == u2.f11951c);
        return objL1;
    }

    public final Object h1(Object obj) throws Throwable {
        Throwable thS0 = null;
        while (true) {
            Object objV0 = V0();
            if (objV0 instanceof c) {
                synchronized (objV0) {
                    if (((c) objV0).h()) {
                        return u2.f11952d;
                    }
                    boolean zF = ((c) objV0).f();
                    if (obj != null || !zF) {
                        if (thS0 == null) {
                            thS0 = s0(obj);
                        }
                        ((c) objV0).a(thS0);
                    }
                    Throwable thE = zF ? null : ((c) objV0).e();
                    if (thE != null) {
                        n1(((c) objV0).f11939a, thE);
                    }
                    return u2.f11949a;
                }
            }
            if (!(objV0 instanceof e2)) {
                return u2.f11952d;
            }
            if (thS0 == null) {
                thS0 = s0(obj);
            }
            e2 e2Var = (e2) objV0;
            if (!e2Var.isActive()) {
                Object objL1 = L1(objV0, new d0(thS0, false, 2, null));
                if (objL1 == u2.f11949a) {
                    throw new IllegalStateException(("Cannot happen in " + objV0).toString());
                }
                if (objL1 != u2.f11951c) {
                    return objL1;
                }
            } else if (K1(e2Var, thS0)) {
                return u2.f11949a;
            }
        }
    }

    public final boolean i0(Throwable th2) {
        if (b1()) {
            return true;
        }
        boolean z10 = th2 instanceof CancellationException;
        v vVarR0 = R0();
        if (vVarR0 == null || vVarR0 == a3.f11823a) {
            return z10;
        }
        return vVarR0.k(th2) || z10;
    }

    public final boolean i1(@os.m Object obj) {
        Object objL1;
        do {
            objL1 = L1(V0(), obj);
            if (objL1 == u2.f11949a) {
                return false;
            }
            if (objL1 == u2.f11950b) {
                return true;
            }
        } while (objL1 == u2.f11951c);
        X(objL1);
        return true;
    }

    @Override // nq.l2
    public boolean isActive() {
        Object objV0 = V0();
        return (objV0 instanceof e2) && ((e2) objV0).isActive();
    }

    @Override // nq.l2
    public final boolean isCancelled() {
        Object objV0 = V0();
        return (objV0 instanceof d0) || ((objV0 instanceof c) && ((c) objV0).f());
    }

    @Override // nq.l2
    public final boolean isCompleted() {
        return !(V0() instanceof e2);
    }

    @os.m
    public final Object j1(@os.m Object obj) {
        Object objL1;
        do {
            objL1 = L1(V0(), obj);
            if (objL1 == u2.f11949a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, E0(obj));
            }
        } while (objL1 == u2.f11951c);
        return objL1;
    }

    @Override // nq.l2
    @os.l
    public final n1 k0(@os.l jn.l<? super Throwable, lm.l2> lVar) {
        return S1(false, true, lVar);
    }

    public final s2 k1(jn.l<? super Throwable, lm.l2> lVar, boolean z10) {
        s2 k2Var;
        if (z10) {
            k2Var = lVar instanceof n2 ? (n2) lVar : null;
            if (k2Var == null) {
                k2Var = new j2(lVar);
            }
        } else {
            k2Var = lVar instanceof s2 ? (s2) lVar : null;
            if (k2Var == null) {
                k2Var = new k2(lVar);
            }
        }
        k2Var.f11924d = this;
        return k2Var;
    }

    @os.l
    public String l1() {
        return x0.a(this);
    }

    @os.l
    public String m0() {
        return "Job was cancelled";
    }

    public final w m1(vq.a0 a0Var) {
        while (a0Var.q()) {
            a0Var = a0Var.p();
        }
        while (true) {
            a0Var = a0Var.o();
            if (!a0Var.q()) {
                if (a0Var instanceof w) {
                    return (w) a0Var;
                }
                if (a0Var instanceof y2) {
                    return null;
                }
            }
        }
    }

    @Override // um.g.b, um.g
    @os.l
    public um.g minusKey(@os.l um.g.c<?> cVar) {
        return um.g.b.a.c(this, cVar);
    }

    public boolean n0(@os.l Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        return c0(th2) && H0();
    }

    public final void n1(y2 y2Var, Throwable th2) throws Throwable {
        s1(th2);
        Object objN = y2Var.n();
        kn.l0.n(objN, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        g0 g0Var = null;
        for (vq.a0 a0VarO = (vq.a0) objN; !kn.l0.g(a0VarO, y2Var); a0VarO = a0VarO.o()) {
            if (a0VarO instanceof n2) {
                s2 s2Var = (s2) a0VarO;
                try {
                    s2Var.invoke(th2);
                } catch (Throwable th3) {
                    if (g0Var != null) {
                        lm.p.a(g0Var, th3);
                    } else {
                        g0Var = new g0("Exception in completion handler " + s2Var + " for " + this, th3);
                        lm.l2 l2Var = lm.l2.f10208a;
                    }
                }
            }
        }
        if (g0Var != null) {
            X0(g0Var);
        }
        i0(th2);
    }

    @Override // nq.l2
    @os.l
    public final v o(@os.l x xVar) {
        n1 n1VarG = l2.a.g(this, true, false, new w(xVar), 2, null);
        kn.l0.n(n1VarG, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (v) n1VarG;
    }

    public final void o0(e2 e2Var, Object obj) throws Throwable {
        v vVarR0 = R0();
        if (vVarR0 != null) {
            vVarR0.dispose();
            z1(a3.f11823a);
        }
        d0 d0Var = obj instanceof d0 ? (d0) obj : null;
        Throwable th2 = d0Var != null ? d0Var.f11836a : null;
        if (!(e2Var instanceof s2)) {
            y2 y2VarB = e2Var.b();
            if (y2VarB != null) {
                o1(y2VarB, th2);
                return;
            }
            return;
        }
        try {
            ((s2) e2Var).invoke(th2);
        } catch (Throwable th3) {
            X0(new g0("Exception in completion handler " + e2Var + " for " + this, th3));
        }
    }

    public final void o1(y2 y2Var, Throwable th2) throws Throwable {
        Object objN = y2Var.n();
        kn.l0.n(objN, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        g0 g0Var = null;
        for (vq.a0 a0VarO = (vq.a0) objN; !kn.l0.g(a0VarO, y2Var); a0VarO = a0VarO.o()) {
            if (a0VarO instanceof s2) {
                s2 s2Var = (s2) a0VarO;
                try {
                    s2Var.invoke(th2);
                } catch (Throwable th3) {
                    if (g0Var != null) {
                        lm.p.a(g0Var, th3);
                    } else {
                        g0Var = new g0("Exception in completion handler " + s2Var + " for " + this, th3);
                        lm.l2 l2Var = lm.l2.f10208a;
                    }
                }
            }
        }
        if (g0Var != null) {
            X0(g0Var);
        }
    }

    public final <T extends s2> void p1(y2 y2Var, Throwable th2) throws Throwable {
        Object objN = y2Var.n();
        kn.l0.n(objN, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        g0 g0Var = null;
        for (vq.a0 a0VarO = (vq.a0) objN; !kn.l0.g(a0VarO, y2Var); a0VarO = a0VarO.o()) {
            kn.l0.P();
            if (a0VarO != null) {
                s2 s2Var = (s2) a0VarO;
                try {
                    s2Var.invoke(th2);
                } catch (Throwable th3) {
                    if (g0Var != null) {
                        lm.p.a(g0Var, th3);
                    } else {
                        g0Var = new g0("Exception in completion handler " + s2Var + " for " + this, th3);
                        lm.l2 l2Var = lm.l2.f10208a;
                    }
                }
            }
        }
        if (g0Var != null) {
            X0(g0Var);
        }
    }

    @Override // um.g
    @os.l
    public um.g plus(@os.l um.g gVar) {
        return um.g.b.a.d(this, gVar);
    }

    @Override // nq.d3
    @os.l
    public CancellationException q0() {
        Throwable thE;
        Object objV0 = V0();
        if (objV0 instanceof c) {
            thE = ((c) objV0).e();
        } else if (objV0 instanceof d0) {
            thE = ((d0) objV0).f11836a;
        } else {
            if (objV0 instanceof e2) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objV0).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new m2("Parent job is " + C1(objV0), thE, this);
    }

    public final Object q1(Object obj, Object obj2) throws Throwable {
        if (obj2 instanceof d0) {
            throw ((d0) obj2).f11836a;
        }
        return obj2;
    }

    public final void r0(c cVar, w wVar, Object obj) {
        w wVarM1 = m1(wVar);
        if (wVarM1 == null || !N1(cVar, wVarM1, obj)) {
            X(z0(cVar, obj));
        }
    }

    public final void r1(yq.m<?> mVar, Object obj) {
        Object objV0;
        do {
            objV0 = V0();
            if (!(objV0 instanceof e2)) {
                if (!(objV0 instanceof d0)) {
                    objV0 = u2.h(objV0);
                }
                mVar.f(objV0);
                return;
            }
        } while (A1(objV0) < 0);
        mVar.g(S1(false, true, new d(mVar)));
    }

    public final Throwable s0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            return th2 == null ? new m2(m0(), null, this) : th2;
        }
        kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((d3) obj).q0();
    }

    public void s1(@os.m Throwable th2) {
    }

    @Override // nq.l2
    public final boolean start() {
        int iA1;
        do {
            iA1 = A1(V0());
            if (iA1 == 0) {
                return false;
            }
        } while (iA1 != 1);
        return true;
    }

    @Override // nq.l2
    @os.m
    public final Object t(@os.l um.d<? super lm.l2> dVar) {
        if (d1()) {
            Object objE1 = e1(dVar);
            return objE1 == wm.a.COROUTINE_SUSPENDED ? objE1 : lm.l2.f10208a;
        }
        r2.y(dVar.getContext());
        return lm.l2.f10208a;
    }

    @os.l
    public final m2 t0(@os.m String str, @os.m Throwable th2) {
        if (str == null) {
            str = m0();
        }
        return new m2(str, th2, this);
    }

    public void t1(@os.m Object obj) {
    }

    @os.l
    public String toString() {
        return G1() + '@' + x0.b(this);
    }

    public void u1() {
    }

    public final void v1(q1 q1Var) {
        y2 y2Var = new y2();
        Object d2Var = y2Var;
        if (!q1Var.f11902a) {
            d2Var = new d2(y2Var);
        }
        j.d.a(f11929a, this, q1Var, d2Var);
    }

    public final void w1(s2 s2Var) {
        s2Var.h(new y2());
        j.d.a(f11929a, this, s2Var, s2Var.o());
    }

    public final void x1(yq.m<?> mVar, Object obj) {
        if (d1()) {
            mVar.g(S1(false, true, new e(mVar)));
        } else {
            mVar.f(lm.l2.f10208a);
        }
    }

    @Override // nq.l2
    @os.l
    public final gq.m<l2> y() {
        return gq.q.b(new g(null));
    }

    @Override // nq.l2
    @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @os.l
    public l2 y0(@os.l l2 l2Var) {
        return l2Var;
    }

    public final void y1(@os.l s2 s2Var) {
        Object objV0;
        do {
            objV0 = V0();
            if (!(objV0 instanceof s2)) {
                if (!(objV0 instanceof e2) || ((e2) objV0).b() == null) {
                    return;
                }
                s2Var.v();
                return;
            }
            if (objV0 != s2Var) {
                return;
            }
        } while (!j.d.a(f11929a, this, objV0, u2.f11958j));
    }

    public final Object z0(c cVar, Object obj) throws Throwable {
        boolean zF;
        Throwable thG0;
        d0 d0Var = obj instanceof d0 ? (d0) obj : null;
        Throwable th2 = d0Var != null ? d0Var.f11836a : null;
        synchronized (cVar) {
            zF = cVar.f();
            List<Throwable> listI = cVar.i(th2);
            thG0 = G0(cVar, listI);
            if (thG0 != null) {
                W(thG0, listI);
            }
        }
        if (thG0 != null && thG0 != th2) {
            obj = new d0(thG0, false, 2, null);
        }
        if (thG0 != null && (i0(thG0) || W0(thG0))) {
            kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((d0) obj).b();
        }
        if (!zF) {
            s1(thG0);
        }
        t1(obj);
        j.d.a(f11929a, this, cVar, u2.g(obj));
        o0(cVar, obj);
        return obj;
    }

    public final void z1(@os.m v vVar) {
        f11930b.set(this, vVar);
    }
}
