package pq;

import ik.y0;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.n0;
import kn.r1;
import kn.u1;
import lm.a1;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.a2;
import nq.b4;
import nq.x0;
import vq.h1;
import vq.l0;
import vq.r0;
import vq.s0;
import vq.t0;
import vq.u0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3055:1\n273#1,6:3058\n280#1,68:3065\n374#1,18:3156\n244#1:3174\n269#1,10:3175\n280#1,48:3186\n395#1:3234\n334#1,14:3235\n399#1,3:3250\n244#1:3263\n269#1,10:3264\n280#1,68:3275\n244#1:3353\n269#1,10:3354\n280#1,68:3365\n244#1:3437\n269#1,10:3438\n280#1,68:3449\n886#1,52:3519\n964#1,8:3575\n858#1:3583\n882#1,33:3584\n974#1:3617\n916#1,14:3618\n935#1,3:3633\n979#1,6:3636\n886#1,52:3650\n964#1,8:3706\n858#1:3714\n882#1,33:3715\n974#1:3748\n916#1,14:3749\n935#1,3:3764\n979#1,6:3767\n858#1:3782\n882#1,48:3783\n935#1,3:3832\n858#1:3835\n882#1,48:3836\n935#1,3:3885\n244#1:3897\n269#1,10:3898\n280#1,68:3909\n858#1:3978\n882#1,48:3979\n935#1,3:4028\n1#2:3056\n3038#3:3057\n3038#3:3064\n3038#3:3185\n3038#3:3274\n3038#3:3364\n3038#3:3436\n3038#3:3448\n3038#3:3518\n3038#3:3781\n3038#3:3888\n3038#3:3889\n3052#3:3890\n3052#3:3891\n3051#3:3892\n3051#3:3893\n3051#3:3894\n3052#3:3895\n3051#3:3896\n3038#3:3908\n3039#3:4031\n3038#3:4032\n3038#3:4033\n3038#3:4034\n3039#3:4035\n3038#3:4036\n3039#3:4059\n3038#3:4060\n3038#3:4061\n3039#3:4062\n3038#3:4112\n3039#3:4113\n3039#3:4114\n3039#3:4132\n3039#3:4133\n314#4,9:3133\n323#4,2:3150\n332#4,4:3152\n336#4,8:3253\n314#4,9:3344\n323#4,2:3434\n332#4,4:3571\n336#4,8:3642\n332#4,4:3702\n336#4,8:3773\n220#5:3142\n221#5:3145\n220#5:3146\n221#5:3149\n61#6,2:3143\n61#6,2:3147\n61#6,2:3261\n269#7:3249\n269#7:3343\n269#7:3433\n269#7:3517\n269#7:3977\n882#8:3632\n882#8:3763\n882#8:3831\n882#8:3884\n882#8:4027\n37#9,11:4037\n37#9,11:4048\n72#10,3:4063\n46#10,8:4066\n72#10,3:4074\n46#10,8:4077\n46#10,8:4085\n72#10,3:4093\n46#10,8:4096\n46#10,8:4104\n766#11:4115\n857#11,2:4116\n2310#11,14:4118\n766#11:4134\n857#11,2:4135\n2310#11,14:4137\n766#11:4151\n857#11,2:4152\n2310#11,14:4154\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3058,6\n113#1:3065,68\n154#1:3156,18\n154#1:3174\n154#1:3175,10\n154#1:3186,48\n154#1:3234\n154#1:3235,14\n154#1:3250,3\n194#1:3263\n194#1:3264,10\n194#1:3275,68\n225#1:3353\n225#1:3354,10\n225#1:3365,68\n391#1:3437\n391#1:3438,10\n391#1:3449,68\n667#1:3519,52\n696#1:3575,8\n696#1:3583\n696#1:3584,33\n696#1:3617\n696#1:3618,14\n696#1:3633,3\n696#1:3636,6\n732#1:3650,52\n748#1:3706,8\n748#1:3714\n748#1:3715,33\n748#1:3748\n748#1:3749,14\n748#1:3764,3\n748#1:3767,6\n781#1:3782\n781#1:3783,48\n781#1:3832,3\n971#1:3835\n971#1:3836,48\n971#1:3885,3\n1464#1:3897\n1464#1:3898,10\n1464#1:3909,68\n1512#1:3978\n1512#1:3979,48\n1512#1:4028,3\n70#1:3057\n113#1:3064\n154#1:3185\n194#1:3274\n225#1:3364\n278#1:3436\n391#1:3448\n606#1:3518\n771#1:3781\n1007#1:3888\n1056#1:3889\n1374#1:3890\n1376#1:3891\n1406#1:3892\n1416#1:3893\n1425#1:3894\n1426#1:3895\n1433#1:3896\n1464#1:3908\n1865#1:4031\n1867#1:4032\n1869#1:4033\n1882#1:4034\n1893#1:4035\n1894#1:4036\n2196#1:4059\n2209#1:4060\n2219#1:4061\n2222#1:4062\n2539#1:4112\n2541#1:4113\n2566#1:4114\n2628#1:4132\n2629#1:4133\n134#1:3133,9\n134#1:3150,2\n153#1:3152,4\n153#1:3253,8\n221#1:3344,9\n221#1:3434,2\n695#1:3571,4\n695#1:3642,8\n746#1:3702,4\n746#1:3773,8\n138#1:3142\n138#1:3145\n141#1:3146\n141#1:3149\n138#1:3143,2\n141#1:3147,2\n183#1:3261,2\n154#1:3249\n194#1:3343\n225#1:3433\n391#1:3517\n1464#1:3977\n696#1:3632\n748#1:3763\n781#1:3831\n971#1:3884\n1512#1:4027\n2098#1:4037,11\n2153#1:4048,11\n2361#1:4063,3\n2361#1:4066,8\n2416#1:4074,3\n2416#1:4077,8\n2435#1:4085,8\n2465#1:4093,3\n2465#1:4096,8\n2526#1:4104,8\n2575#1:4115\n2575#1:4116,2\n2576#1:4118,14\n2640#1:4134\n2640#1:4135,2\n2641#1:4137,14\n2681#1:4151\n2681#1:4152,2\n2682#1:4154,14\n*E\n"})
public class j<E> implements pq.l<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final AtomicLongFieldUpdater f13248d = AtomicLongFieldUpdater.newUpdater(j.class, "sendersAndCloseStatus");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final AtomicLongFieldUpdater f13249e = AtomicLongFieldUpdater.newUpdater(j.class, "receivers");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicLongFieldUpdater f13250f = AtomicLongFieldUpdater.newUpdater(j.class, "bufferEnd");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final AtomicLongFieldUpdater f13251g = AtomicLongFieldUpdater.newUpdater(j.class, "completedExpandBuffersAndPauseFlag");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f13252i = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "sendSegment");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f13253n = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "receiveSegment");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f13254p = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "bufferEndSegment");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f13255v = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_closeCause");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f13256w = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "closeHandler");

    @os.m
    @in.x
    private volatile Object _closeCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    @in.f
    public final jn.l<E, l2> f13258b;

    @in.x
    private volatile long bufferEnd;

    @os.m
    @in.x
    private volatile Object bufferEndSegment;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final jn.q<yq.m<?>, Object, Object, jn.l<Throwable, l2>> f13259c;

    @os.m
    @in.x
    private volatile Object closeHandler;

    @in.x
    private volatile long completedExpandBuffersAndPauseFlag;

    @os.m
    @in.x
    private volatile Object receiveSegment;

    @in.x
    private volatile long receivers;

    @os.m
    @in.x
    private volatile Object sendSegment;

    @in.x
    private volatile long sendersAndCloseStatus;

    @r1({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n886#2,52:3056\n964#2,8:3112\n858#2:3120\n882#2,33:3121\n974#2:3154\n916#2,14:3155\n935#2,3:3170\n979#2,6:3173\n332#3,4:3108\n336#3,8:3179\n882#4:3169\n61#5,2:3187\n61#5,2:3190\n1#6:3189\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1590#1:3056,52\n1627#1:3112,8\n1627#1:3120\n1627#1:3121,33\n1627#1:3154\n1627#1:3155,14\n1627#1:3170,3\n1627#1:3173,6\n1625#1:3108,4\n1625#1:3179,8\n1627#1:3169\n1663#1:3187,2\n1708#1:3190,2\n*E\n"})
    public final class a implements pq.n<E>, b4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public Object f13260a = pq.k.f13289x;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public nq.q<? super Boolean> f13261b;

        public a() {
        }

        @Override // pq.n
        @in.i(name = y0.b.f8223h)
        @lm.k(level = lm.m.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object a(um.d dVar) {
            return pq.n.a.a(this, dVar);
        }

        @Override // pq.n
        @os.m
        public Object b(@os.l um.d<? super Boolean> dVar) {
            q<E> qVar;
            j<E> jVar = j.this;
            q<E> qVar2 = (q) j.f13253n.get(jVar);
            while (!jVar.r()) {
                long andIncrement = j.f13249e.getAndIncrement(jVar);
                int i10 = pq.k.f13267b;
                long j10 = andIncrement / ((long) i10);
                int i11 = (int) (andIncrement % ((long) i10));
                if (qVar2.f17877c != j10) {
                    q<E> qVarC0 = jVar.c0(j10, qVar2);
                    if (qVarC0 == null) {
                        continue;
                    } else {
                        qVar = qVarC0;
                    }
                } else {
                    qVar = qVar2;
                }
                Object objB1 = jVar.B1(qVar, i11, andIncrement, null);
                if (objB1 == pq.k.f13280o) {
                    throw new IllegalStateException("unreachable");
                }
                if (objB1 != pq.k.f13282q) {
                    if (objB1 == pq.k.f13281p) {
                        return h(qVar, i11, andIncrement, dVar);
                    }
                    qVar.b();
                    this.f13260a = objB1;
                    return Boolean.TRUE;
                }
                if (andIncrement < jVar.p0()) {
                    qVar.b();
                }
                qVar2 = qVar;
            }
            return Boolean.valueOf(i());
        }

        @Override // nq.b4
        public void d(@os.l r0<?> r0Var, int i10) {
            nq.q<? super Boolean> qVar = this.f13261b;
            if (qVar != null) {
                qVar.d(r0Var, i10);
            }
        }

        public final Object h(q<E> qVar, int i10, long j10, um.d<? super Boolean> dVar) {
            Boolean bool;
            j<E> jVar = j.this;
            nq.q<? super Boolean> qVarB = nq.s.b(wm.c.e(dVar));
            try {
                this.f13261b = qVarB;
                Object objB1 = jVar.B1(qVar, i10, j10, this);
                if (objB1 != pq.k.f13280o) {
                    l0.a aVar = null;
                    if (objB1 == pq.k.f13282q) {
                        if (j10 < jVar.p0()) {
                            qVar.b();
                        }
                        q<E> qVar2 = (q) j.f13253n.get(jVar);
                        while (true) {
                            if (jVar.r()) {
                                j();
                                break;
                            }
                            long andIncrement = j.f13249e.getAndIncrement(jVar);
                            int i11 = pq.k.f13267b;
                            long j11 = andIncrement / ((long) i11);
                            int i12 = (int) (andIncrement % ((long) i11));
                            if (qVar2.f17877c != j11) {
                                q<E> qVarC0 = jVar.c0(j11, qVar2);
                                if (qVarC0 != null) {
                                    qVar2 = qVarC0;
                                }
                            }
                            Object objB2 = jVar.B1(qVar2, i12, andIncrement, this);
                            if (objB2 == pq.k.f13280o) {
                                jVar.T0(this, qVar2, i12);
                                break;
                            }
                            if (objB2 == pq.k.f13282q) {
                                if (andIncrement < jVar.p0()) {
                                    qVar2.b();
                                }
                            } else {
                                if (objB2 == pq.k.f13281p) {
                                    throw new IllegalStateException("unexpected");
                                }
                                qVar2.b();
                                this.f13260a = objB2;
                                this.f13261b = null;
                                bool = Boolean.TRUE;
                                jn.l<E, l2> lVar = jVar.f13258b;
                                if (lVar != null) {
                                    aVar = new l0.a(lVar, objB2, qVarB.getContext());
                                }
                            }
                        }
                    } else {
                        qVar.b();
                        this.f13260a = objB1;
                        this.f13261b = null;
                        bool = Boolean.TRUE;
                        jn.l<E, l2> lVar2 = jVar.f13258b;
                        if (lVar2 != null) {
                            aVar = new l0.a(lVar2, objB1, qVarB.getContext());
                        }
                    }
                    qVarB.g(bool, aVar);
                    break;
                }
                jVar.T0(this, qVar, i10);
                Object objZ = qVarB.z();
                if (objZ == wm.a.COROUTINE_SUSPENDED) {
                    xm.h.c(dVar);
                }
                return objZ;
            } catch (Throwable th2) {
                qVarB.Q();
                throw th2;
            }
        }

        public final boolean i() throws Throwable {
            this.f13260a = pq.k.z();
            Throwable thG0 = j.this.g0();
            if (thG0 == null) {
                return false;
            }
            throw t0.o(thG0);
        }

        public final void j() {
            nq.q<? super Boolean> qVar = this.f13261b;
            kn.l0.m(qVar);
            this.f13261b = null;
            this.f13260a = pq.k.z();
            Throwable thG0 = j.this.g0();
            if (thG0 == null) {
                c1.a aVar = c1.Companion;
                qVar.resumeWith(c1.m59constructorimpl(Boolean.FALSE));
            } else {
                c1.a aVar2 = c1.Companion;
                qVar.resumeWith(c1.m59constructorimpl(d1.a(thG0)));
            }
        }

        public final boolean k(E e10) {
            nq.q<? super Boolean> qVar = this.f13261b;
            kn.l0.m(qVar);
            this.f13261b = null;
            this.f13260a = e10;
            Boolean bool = Boolean.TRUE;
            jn.l<E, l2> lVar = j.this.f13258b;
            return pq.k.F(qVar, bool, lVar != null ? new l0.a(lVar, e10, qVar.getContext()) : null);
        }

        public final void l() {
            nq.q<? super Boolean> qVar = this.f13261b;
            kn.l0.m(qVar);
            this.f13261b = null;
            this.f13260a = pq.k.z();
            Throwable thG0 = j.this.g0();
            if (thG0 == null) {
                c1.a aVar = c1.Companion;
                qVar.resumeWith(c1.m59constructorimpl(Boolean.FALSE));
            } else {
                c1.a aVar2 = c1.Companion;
                qVar.resumeWith(c1.m59constructorimpl(d1.a(thG0)));
            }
        }

        @Override // pq.n
        public E next() throws Throwable {
            E e10 = (E) this.f13260a;
            if (e10 == pq.k.f13289x) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.f13260a = pq.k.f13289x;
            if (e10 != pq.k.f13279n) {
                return e10;
            }
            throw t0.o(j.this.m0());
        }
    }

    public static final class b implements b4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final nq.p<Boolean> f13263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ nq.q<Boolean> f13264b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@os.l nq.p<? super Boolean> pVar) {
            this.f13263a = pVar;
            kn.l0.n(pVar, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f13264b = (nq.q) pVar;
        }

        @os.l
        public final nq.p<Boolean> a() {
            return this.f13263a;
        }

        @Override // nq.b4
        public void d(@os.l r0<?> r0Var, int i10) {
            this.f13264b.d(r0Var, i10);
        }
    }

    public /* synthetic */ class c extends kn.h0 implements jn.q<j<?>, yq.m<?>, Object, l2> {
        public static final c INSTANCE = new c();

        public c() {
            super(3, j.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(j<?> jVar, yq.m<?> mVar, Object obj) {
            invoke2(jVar, mVar, obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l j<?> jVar, @os.l yq.m<?> mVar, @os.m Object obj) {
            jVar.g1(mVar, obj);
        }
    }

    public /* synthetic */ class d extends kn.h0 implements jn.q<j<?>, Object, Object, Object> {
        public static final d INSTANCE = new d();

        public d() {
            super(3, j.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l j<?> jVar, @os.m Object obj, @os.m Object obj2) {
            return jVar.V0(obj, obj2);
        }
    }

    public /* synthetic */ class e extends kn.h0 implements jn.q<j<?>, yq.m<?>, Object, l2> {
        public static final e INSTANCE = new e();

        public e() {
            super(3, j.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(j<?> jVar, yq.m<?> mVar, Object obj) {
            invoke2(jVar, mVar, obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l j<?> jVar, @os.l yq.m<?> mVar, @os.m Object obj) {
            jVar.g1(mVar, obj);
        }
    }

    public /* synthetic */ class f extends kn.h0 implements jn.q<j<?>, Object, Object, Object> {
        public static final f INSTANCE = new f();

        public f() {
            super(3, j.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l j<?> jVar, @os.m Object obj, @os.m Object obj2) {
            return jVar.W0(obj, obj2);
        }
    }

    public /* synthetic */ class g extends kn.h0 implements jn.q<j<?>, yq.m<?>, Object, l2> {
        public static final g INSTANCE = new g();

        public g() {
            super(3, j.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(j<?> jVar, yq.m<?> mVar, Object obj) {
            invoke2(jVar, mVar, obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l j<?> jVar, @os.l yq.m<?> mVar, @os.m Object obj) {
            jVar.g1(mVar, obj);
        }
    }

    public /* synthetic */ class h extends kn.h0 implements jn.q<j<?>, Object, Object, Object> {
        public static final h INSTANCE = new h();

        public h() {
            super(3, j.class, "processResultSelectReceiveOrNull", "processResultSelectReceiveOrNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l j<?> jVar, @os.m Object obj, @os.m Object obj2) {
            return jVar.X0(obj, obj2);
        }
    }

    public /* synthetic */ class i extends kn.h0 implements jn.q<j<?>, yq.m<?>, Object, l2> {
        public static final i INSTANCE = new i();

        public i() {
            super(3, j.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(j<?> jVar, yq.m<?> mVar, Object obj) throws IllegalAccessException, InvocationTargetException {
            invoke2(jVar, mVar, obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l j<?> jVar, @os.l yq.m<?> mVar, @os.m Object obj) throws IllegalAccessException, InvocationTargetException {
            jVar.h1(mVar, obj);
        }
    }

    /* JADX INFO: renamed from: pq.j$j, reason: collision with other inner class name */
    public /* synthetic */ class C0331j extends kn.h0 implements jn.q<j<?>, Object, Object, Object> {
        public static final C0331j INSTANCE = new C0331j();

        public C0331j() {
            super(3, j.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l j<?> jVar, @os.m Object obj, @os.m Object obj2) {
            return jVar.Y0(obj, obj2);
        }
    }

    public static final class k extends n0 implements jn.q<yq.m<?>, Object, Object, jn.l<? super Throwable, ? extends l2>> {
        final /* synthetic */ j<E> this$0;

        public static final class a extends n0 implements jn.l<Throwable, l2> {
            final /* synthetic */ Object $element;
            final /* synthetic */ yq.m<?> $select;
            final /* synthetic */ j<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, j<E> jVar, yq.m<?> mVar) {
                super(1);
                this.$element = obj;
                this.this$0 = jVar;
                this.$select = mVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) throws IllegalAccessException, InvocationTargetException {
                invoke2(th2);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l Throwable th2) throws IllegalAccessException, InvocationTargetException {
                if (this.$element != pq.k.z()) {
                    l0.b(this.this$0.f13258b, this.$element, this.$select.getContext());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(j<E> jVar) {
            super(3);
            this.this$0 = jVar;
        }

        @Override // jn.q
        @os.l
        public final jn.l<Throwable, l2> invoke(@os.l yq.m<?> mVar, @os.m Object obj, @os.m Object obj2) {
            return new a(obj2, this.this$0, mVar);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {}, l = {739}, m = "receiveCatching-JP2dKIU$suspendImpl", n = {}, s = {})
    public static final class l<E> extends xm.d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ j<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(j<E> jVar, um.d<? super l> dVar) {
            super(dVar);
            this.this$0 = jVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objA1 = j.a1(this.this$0, this);
            return objA1 == wm.a.COROUTINE_SUSPENDED ? objA1 : p.b(objA1);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {0, 0, 0, 0}, l = {3056}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", n = {"this", "segment", "index", "r"}, s = {"L$0", "L$1", "I$0", "J$0"})
    public static final class m extends xm.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ j<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(j<E> jVar, um.d<? super m> dVar) {
            super(dVar);
            this.this$0 = jVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objB1 = this.this$0.b1(null, 0, 0L, this);
            return objB1 == wm.a.COROUTINE_SUSPENDED ? objB1 : p.b(objB1);
        }
    }

    @r1({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n*L\n1#1,3055:1\n*E\n"})
    public static final class n extends n0 implements jn.q {
        public static final n INSTANCE = new n();

        public n() {
            super(3);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((q) obj, ((Number) obj2).intValue(), ((Number) obj3).longValue());
        }

        @os.l
        public final Void invoke(@os.l q<E> qVar, int i10, long j10) {
            throw new IllegalStateException("unexpected");
        }
    }

    @r1({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,3055:1\n*E\n"})
    public static final class o extends n0 implements jn.r {
        public static final o INSTANCE = new o();

        public o() {
            super(4);
        }

        @Override // jn.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((q<Object>) obj, ((Number) obj2).intValue(), obj3, ((Number) obj4).longValue());
        }

        @os.l
        public final Void invoke(@os.l q<E> qVar, int i10, E e10, long j10) {
            throw new IllegalStateException("unexpected");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(int i10, @os.m jn.l<? super E, l2> lVar) {
        this.f13257a = i10;
        this.f13258b = lVar;
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Invalid channel capacity: ", i10, ", should be >=0").toString());
        }
        this.bufferEnd = pq.k.E(i10);
        this.completedExpandBuffersAndPauseFlag = f13250f.get(this);
        q<Object> qVar = new q<>(0L, null, this, 3);
        this.sendSegment = qVar;
        this.receiveSegment = qVar;
        if (C0()) {
            qVar = pq.k.f13266a;
            kn.l0.n(qVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = qVar;
        this.f13259c = lVar != 0 ? new k(this) : null;
        this._closeCause = pq.k.A;
    }

    @a2
    public static /* synthetic */ void B0() {
    }

    private final void E0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final void I0() {
        long j10;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13248d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                jW = pq.k.w(j10 & pq.k.G, 2);
            } else if (i10 != 1) {
                return;
            } else {
                jW = pq.k.w(j10 & pq.k.G, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, jW));
    }

    public static /* synthetic */ <E> Object Z0(j<E> jVar, um.d<? super E> dVar) throws Throwable {
        q<E> qVar = (q) f13253n.get(jVar);
        while (!jVar.r()) {
            long andIncrement = f13249e.getAndIncrement(jVar);
            int i10 = pq.k.f13267b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (qVar.f17877c != j10) {
                q<E> qVarC0 = jVar.c0(j10, qVar);
                if (qVarC0 == null) {
                    continue;
                } else {
                    qVar = qVarC0;
                }
            }
            Object objB1 = jVar.B1(qVar, i11, andIncrement, null);
            if (objB1 == pq.k.f13280o) {
                throw new IllegalStateException("unexpected");
            }
            if (objB1 != pq.k.f13282q) {
                if (objB1 == pq.k.f13281p) {
                    return jVar.f1(qVar, i11, andIncrement, dVar);
                }
                qVar.b();
                return objB1;
            }
            if (andIncrement < jVar.p0()) {
                qVar.b();
            }
        }
        throw t0.o(jVar.m0());
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static <E> Object a1(j<E> jVar, um.d<? super p<? extends E>> dVar) {
        l lVar;
        if (dVar instanceof l) {
            lVar = (l) dVar;
            int i10 = lVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                lVar.label = i10 - Integer.MIN_VALUE;
            } else {
                lVar = new l(jVar, dVar);
            }
        } else {
            lVar = new l(jVar, dVar);
        }
        l lVar2 = lVar;
        Object obj = lVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = lVar2.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return ((p) obj).f13310a;
        }
        d1.n(obj);
        q<E> qVar = (q) f13253n.get(jVar);
        while (!jVar.r()) {
            long andIncrement = f13249e.getAndIncrement(jVar);
            int i12 = pq.k.f13267b;
            long j10 = andIncrement / ((long) i12);
            int i13 = (int) (andIncrement % ((long) i12));
            if (qVar.f17877c != j10) {
                q<E> qVarC0 = jVar.c0(j10, qVar);
                if (qVarC0 == null) {
                    continue;
                } else {
                    qVar = qVarC0;
                }
            }
            Object objB1 = jVar.B1(qVar, i13, andIncrement, null);
            if (objB1 == pq.k.f13280o) {
                throw new IllegalStateException("unexpected");
            }
            if (objB1 != pq.k.f13282q) {
                if (objB1 == pq.k.f13281p) {
                    lVar2.label = 1;
                    Object objB2 = jVar.b1(qVar, i13, andIncrement, lVar2);
                    return objB2 == aVar ? aVar : objB2;
                }
                qVar.b();
                p.f13308b.getClass();
                return p.c(objB1);
            }
            if (andIncrement < jVar.p0()) {
                qVar.b();
            }
        }
        return p.f13308b.a(jVar.g0());
    }

    public static /* synthetic */ Object d1(j jVar, Object obj, jn.l lVar, jn.q qVar, jn.a aVar, jn.q qVar2, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
        }
        if ((i10 & 16) != 0) {
            qVar2 = n.INSTANCE;
        }
        q<E> qVar3 = (q) f13253n.get(jVar);
        while (!jVar.r()) {
            long andIncrement = f13249e.getAndIncrement(jVar);
            int i11 = pq.k.f13267b;
            long j10 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (qVar3.f17877c != j10) {
                q<E> qVarC0 = jVar.c0(j10, qVar3);
                if (qVarC0 == null) {
                    continue;
                } else {
                    qVar3 = qVarC0;
                }
            }
            Object objB1 = jVar.B1(qVar3, i12, andIncrement, obj);
            if (objB1 == pq.k.f13280o) {
                b4 b4Var = obj instanceof b4 ? (b4) obj : null;
                if (b4Var != null) {
                    jVar.T0(b4Var, qVar3, i12);
                }
                return qVar.invoke(qVar3, Integer.valueOf(i12), Long.valueOf(andIncrement));
            }
            if (objB1 != pq.k.f13282q) {
                if (objB1 == pq.k.f13281p) {
                    return qVar2.invoke(qVar3, Integer.valueOf(i12), Long.valueOf(andIncrement));
                }
                qVar3.b();
                return lVar.invoke(objB1);
            }
            if (andIncrement < jVar.p0()) {
                qVar3.b();
            }
        }
        return aVar.invoke();
    }

    public static /* synthetic */ void h0() {
    }

    public static /* synthetic */ void i0() {
    }

    public static /* synthetic */ void j0() {
    }

    public static /* synthetic */ void k0() {
    }

    public static /* synthetic */ void l0() {
    }

    public static <E> Object m1(j<E> jVar, E e10, um.d<? super l2> dVar) throws IllegalAccessException, InvocationTargetException {
        q<E> qVar = (q) f13252i.get(jVar);
        while (true) {
            long andIncrement = f13248d.getAndIncrement(jVar);
            long j10 = pq.k.G & andIncrement;
            boolean zV0 = jVar.v0(andIncrement, false);
            int i10 = pq.k.f13267b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (qVar.f17877c != j11) {
                q<E> qVarD0 = jVar.d0(j11, qVar);
                if (qVarD0 != null) {
                    qVar = qVarD0;
                } else if (zV0) {
                    Object objP0 = jVar.P0(e10, dVar);
                    if (objP0 != wm.a.COROUTINE_SUSPENDED) {
                        break;
                    }
                    return objP0;
                }
            }
            int iD1 = jVar.D1(qVar, i11, e10, j10, null, zV0);
            if (iD1 == 0) {
                qVar.b();
                break;
            }
            if (iD1 != 1) {
                if (iD1 == 2) {
                    if (!zV0) {
                        break;
                    }
                    qVar.r();
                    Object objP1 = jVar.P0(e10, dVar);
                    if (objP1 != wm.a.COROUTINE_SUSPENDED) {
                        break;
                    }
                    return objP1;
                }
                if (iD1 == 3) {
                    Object objS1 = jVar.s1(qVar, i11, e10, j10, dVar);
                    if (objS1 != wm.a.COROUTINE_SUSPENDED) {
                        break;
                    }
                    return objS1;
                }
                if (iD1 == 4) {
                    if (j10 < f13249e.get(jVar)) {
                        qVar.b();
                    }
                    Object objP2 = jVar.P0(e10, dVar);
                    if (objP2 != wm.a.COROUTINE_SUSPENDED) {
                        break;
                    }
                    return objP2;
                }
                if (iD1 == 5) {
                    qVar.b();
                }
            } else {
                break;
            }
        }
        return l2.f10208a;
    }

    public static final boolean o(j jVar, long j10) {
        return jVar.v0(j10, false);
    }

    public static <E> Object o1(j<E> jVar, E e10, um.d<? super Boolean> dVar) throws IllegalAccessException, InvocationTargetException {
        q<E> qVar;
        nq.q qVar2 = new nq.q(wm.c.e(dVar), 1);
        qVar2.F();
        if (jVar.f13258b != null) {
            throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`");
        }
        b bVar = new b(qVar2);
        q<E> qVar3 = (q) f13252i.get(jVar);
        while (true) {
            long andIncrement = f13248d.getAndIncrement(jVar);
            long j10 = andIncrement & pq.k.G;
            boolean zV0 = jVar.v0(andIncrement, false);
            int i10 = pq.k.f13267b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (qVar3.f17877c != j11) {
                q<E> qVarD0 = jVar.d0(j11, qVar3);
                if (qVarD0 != null) {
                    qVar = qVarD0;
                } else if (zV0) {
                    c1.a aVar = c1.Companion;
                    qVar2.resumeWith(c1.m59constructorimpl(Boolean.FALSE));
                    break;
                }
            } else {
                qVar = qVar3;
            }
            q<E> qVar4 = qVar;
            int iD1 = jVar.D1(qVar, i11, e10, j10, bVar, zV0);
            if (iD1 == 0) {
                qVar4.b();
                c1.a aVar2 = c1.Companion;
            } else {
                if (iD1 != 1) {
                    if (iD1 == 2) {
                        if (!zV0) {
                            jVar.U0(bVar, qVar4, i11);
                            break;
                        }
                        qVar4.r();
                        c1.a aVar3 = c1.Companion;
                    } else {
                        if (iD1 == 3) {
                            throw new IllegalStateException("unexpected");
                        }
                        if (iD1 != 4) {
                            if (iD1 == 5) {
                                qVar4.b();
                            }
                            qVar3 = qVar4;
                        } else {
                            if (j10 < f13249e.get(jVar)) {
                                qVar4.b();
                            }
                            c1.a aVar4 = c1.Companion;
                        }
                    }
                    qVar2.resumeWith(c1.m59constructorimpl(Boolean.FALSE));
                    break;
                }
                c1.a aVar5 = c1.Companion;
            }
            qVar2.resumeWith(c1.m59constructorimpl(Boolean.TRUE));
            break;
        }
        Object objZ = qVar2.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objZ;
    }

    public static Object q1(j jVar, Object obj, Object obj2, jn.a aVar, jn.p pVar, jn.a aVar2, jn.r rVar, int i10, Object obj3) throws IllegalAccessException, InvocationTargetException {
        q<E> qVar;
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        jn.r rVar2 = (i10 & 32) != 0 ? o.INSTANCE : rVar;
        q<E> qVar2 = (q) f13252i.get(jVar);
        while (true) {
            long andIncrement = f13248d.getAndIncrement(jVar);
            long j10 = andIncrement & pq.k.G;
            boolean zV0 = jVar.v0(andIncrement, false);
            int i11 = pq.k.f13267b;
            long j11 = j10 / ((long) i11);
            int i12 = (int) (j10 % ((long) i11));
            if (qVar2.f17877c != j11) {
                q<E> qVarD0 = jVar.d0(j11, qVar2);
                if (qVarD0 != null) {
                    qVar = qVarD0;
                } else if (zV0) {
                    return aVar2.invoke();
                }
            } else {
                qVar = qVar2;
            }
            int iD1 = jVar.D1(qVar, i12, obj, j10, obj2, zV0);
            if (iD1 == 0) {
                qVar.b();
                return aVar.invoke();
            }
            if (iD1 == 1) {
                return aVar.invoke();
            }
            if (iD1 == 2) {
                if (zV0) {
                    qVar.r();
                    return aVar2.invoke();
                }
                b4 b4Var = obj2 instanceof b4 ? (b4) obj2 : null;
                if (b4Var != null) {
                    jVar.U0(b4Var, qVar, i12);
                }
                return pVar.invoke(qVar, Integer.valueOf(i12));
            }
            if (iD1 == 3) {
                return rVar2.invoke(qVar, Integer.valueOf(i12), obj, Long.valueOf(j10));
            }
            if (iD1 == 4) {
                if (j10 < f13249e.get(jVar)) {
                    qVar.b();
                }
                return aVar2.invoke();
            }
            if (iD1 == 5) {
                qVar.b();
            }
            qVar2 = qVar;
        }
    }

    public static /* synthetic */ void s0(j jVar, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i10 & 1) != 0) {
            j10 = 1;
        }
        jVar.r0(j10);
    }

    @a2
    public static /* synthetic */ void w0() {
    }

    @a2
    public static /* synthetic */ void y0() {
    }

    public boolean A0() {
        return false;
    }

    public final boolean A1(q<E> qVar, int i10, long j10) {
        while (true) {
            Object objY = qVar.y(i10);
            if (objY instanceof b4) {
                if (j10 < f13249e.get(this)) {
                    if (qVar.t(i10, objY, new j0((b4) objY))) {
                        return true;
                    }
                } else if (qVar.t(i10, objY, pq.k.f13274i)) {
                    if (x1(objY, qVar, i10)) {
                        qVar.C(i10, pq.k.f13271f);
                        return true;
                    }
                    qVar.C(i10, pq.k.f13277l);
                    qVar.z(i10, false);
                    return false;
                }
            } else {
                if (objY == pq.k.f13277l) {
                    return false;
                }
                if (objY == null) {
                    if (qVar.t(i10, objY, pq.k.f13272g)) {
                        return true;
                    }
                } else {
                    if (objY == pq.k.f13271f || objY == pq.k.f13275j || objY == pq.k.f13276k || objY == pq.k.f13278m || objY == pq.k.f13279n) {
                        return true;
                    }
                    if (objY != pq.k.f13273h) {
                        throw new IllegalStateException(("Unexpected cell state: " + objY).toString());
                    }
                }
            }
        }
    }

    @Override // pq.f0
    @os.l
    public yq.g<p<E>> B() {
        e eVar = e.INSTANCE;
        kn.l0.n(eVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        jn.q qVar = (jn.q) u1.q(eVar, 3);
        f fVar = f.INSTANCE;
        kn.l0.n(fVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new yq.h(this, qVar, (jn.q) u1.q(fVar, 3), this.f13259c);
    }

    public final Object B1(q<E> qVar, int i10, long j10, Object obj) {
        Object objY = qVar.y(i10);
        if (objY == null) {
            if (j10 >= (f13248d.get(this) & pq.k.G)) {
                if (obj == null) {
                    return pq.k.f13281p;
                }
                if (qVar.t(i10, objY, obj)) {
                    a0();
                    return pq.k.f13280o;
                }
            }
        } else if (objY == pq.k.f13271f && qVar.t(i10, objY, pq.k.f13276k)) {
            a0();
            return qVar.A(i10);
        }
        return C1(qVar, i10, j10, obj);
    }

    @Override // pq.f0
    @os.l
    public yq.g<E> C() {
        g gVar = g.INSTANCE;
        kn.l0.n(gVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        jn.q qVar = (jn.q) u1.q(gVar, 3);
        h hVar = h.INSTANCE;
        kn.l0.n(hVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new yq.h(this, qVar, (jn.q) u1.q(hVar, 3), this.f13259c);
    }

    public final boolean C0() {
        long j10 = f13250f.get(this);
        return j10 == 0 || j10 == Long.MAX_VALUE;
    }

    public final Object C1(q<E> qVar, int i10, long j10, Object obj) {
        while (true) {
            Object objY = qVar.y(i10);
            if (objY == null || objY == pq.k.f13272g) {
                if (j10 < (f13248d.get(this) & pq.k.G)) {
                    if (qVar.t(i10, objY, pq.k.f13275j)) {
                        a0();
                        return pq.k.f13282q;
                    }
                } else {
                    if (obj == null) {
                        return pq.k.f13281p;
                    }
                    if (qVar.t(i10, objY, obj)) {
                        a0();
                        return pq.k.f13280o;
                    }
                }
            } else {
                if (objY != pq.k.f13271f) {
                    u0 u0Var = pq.k.f13277l;
                    if (objY != u0Var && objY != pq.k.f13275j) {
                        if (objY == pq.k.f13279n) {
                            a0();
                            return pq.k.f13282q;
                        }
                        if (objY != pq.k.f13274i && qVar.t(i10, objY, pq.k.f13273h)) {
                            boolean z10 = objY instanceof j0;
                            if (z10) {
                                objY = ((j0) objY).f13265a;
                            }
                            if (x1(objY, qVar, i10)) {
                                qVar.C(i10, pq.k.f13276k);
                                a0();
                                return qVar.A(i10);
                            }
                            qVar.C(i10, u0Var);
                            qVar.z(i10, false);
                            if (z10) {
                                a0();
                            }
                            return pq.k.f13282q;
                        }
                    }
                    return pq.k.f13282q;
                }
                if (qVar.t(i10, objY, pq.k.f13276k)) {
                    a0();
                    return qVar.A(i10);
                }
            }
        }
    }

    @Override // pq.f0
    @os.l
    public Object D() {
        q<E> qVar;
        long j10 = f13249e.get(this);
        long j11 = f13248d.get(this);
        if (v0(j11, true)) {
            return p.f13308b.a(g0());
        }
        if (j10 >= (j11 & pq.k.G)) {
            p.f13308b.getClass();
            return p.f13309c;
        }
        Object obj = pq.k.f13278m;
        q<E> qVar2 = (q) f13253n.get(this);
        while (!r()) {
            long andIncrement = f13249e.getAndIncrement(this);
            int i10 = pq.k.f13267b;
            long j12 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (qVar2.f17877c != j12) {
                q<E> qVarC0 = c0(j12, qVar2);
                if (qVarC0 == null) {
                    continue;
                } else {
                    qVar = qVarC0;
                }
            } else {
                qVar = qVar2;
            }
            Object objB1 = B1(qVar, i11, andIncrement, obj);
            if (objB1 == pq.k.f13280o) {
                b4 b4Var = obj instanceof b4 ? (b4) obj : null;
                if (b4Var != null) {
                    T0(b4Var, qVar, i11);
                }
                H1(andIncrement);
                qVar.r();
                p.f13308b.getClass();
                return p.f13309c;
            }
            if (objB1 != pq.k.f13282q) {
                if (objB1 == pq.k.f13281p) {
                    throw new IllegalStateException("unexpected");
                }
                qVar.b();
                p.f13308b.getClass();
                return p.c(objB1);
            }
            if (andIncrement < p0()) {
                qVar.b();
            }
            qVar2 = qVar;
        }
        return p.f13308b.a(g0());
    }

    public final void D0(AtomicLongFieldUpdater atomicLongFieldUpdater, jn.l<? super Long, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    public final int D1(q<E> qVar, int i10, E e10, long j10, Object obj, boolean z10) {
        qVar.B(i10, e10);
        if (z10) {
            return E1(qVar, i10, e10, j10, obj, z10);
        }
        Object objY = qVar.y(i10);
        if (objY == null) {
            if (Q(j10)) {
                if (qVar.t(i10, null, pq.k.f13271f)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (qVar.t(i10, null, obj)) {
                    return 2;
                }
            }
        } else if (objY instanceof b4) {
            qVar.B(i10, null);
            if (w1(objY, e10)) {
                qVar.C(i10, pq.k.f13276k);
                R0();
                return 0;
            }
            if (qVar.v(i10, pq.k.f13278m) != pq.k.f13278m) {
                qVar.z(i10, true);
            }
            return 5;
        }
        return E1(qVar, i10, e10, j10, obj, z10);
    }

    public final int E1(q<E> qVar, int i10, E e10, long j10, Object obj, boolean z10) {
        while (true) {
            Object objY = qVar.y(i10);
            if (objY == null) {
                if (!Q(j10) || z10) {
                    if (z10) {
                        if (qVar.t(i10, null, pq.k.f13277l)) {
                            qVar.z(i10, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (qVar.t(i10, null, obj)) {
                            return 2;
                        }
                    }
                } else if (qVar.t(i10, null, pq.k.f13271f)) {
                    return 1;
                }
            } else {
                if (objY != pq.k.f13272g) {
                    u0 u0Var = pq.k.f13278m;
                    if (objY == u0Var) {
                        qVar.B(i10, null);
                        return 5;
                    }
                    if (objY == pq.k.f13275j) {
                        qVar.B(i10, null);
                        return 5;
                    }
                    if (objY == pq.k.f13279n) {
                        qVar.B(i10, null);
                        J();
                        return 4;
                    }
                    qVar.B(i10, null);
                    if (objY instanceof j0) {
                        objY = ((j0) objY).f13265a;
                    }
                    if (w1(objY, e10)) {
                        qVar.C(i10, pq.k.f13276k);
                        R0();
                        return 0;
                    }
                    if (qVar.v(i10, u0Var) != u0Var) {
                        qVar.z(i10, true);
                    }
                    return 5;
                }
                if (qVar.t(i10, objY, pq.k.f13271f)) {
                    return 1;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long F0(q<E> qVar) {
        do {
            int i10 = pq.k.f13267b;
            while (true) {
                i10--;
                if (-1 < i10) {
                    long j10 = (qVar.f17877c * ((long) pq.k.f13267b)) + ((long) i10);
                    if (j10 >= f13249e.get(this)) {
                        while (true) {
                            Object objY = qVar.y(i10);
                            if (objY != null && objY != pq.k.f13272g) {
                                if (objY != pq.k.f13271f) {
                                    break;
                                }
                                return j10;
                            }
                            if (qVar.t(i10, objY, pq.k.f13279n)) {
                                qVar.r();
                                break;
                            }
                        }
                    } else {
                        return -1L;
                    }
                }
            }
            qVar = (q) qVar.g();
        } while (qVar != null);
        return -1L;
    }

    public final void F1(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13249e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j10) {
                return;
            }
        } while (!f13249e.compareAndSet(this, j11, j10));
    }

    public final void G0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13248d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, pq.k.w(pq.k.G & j10, 1)));
    }

    public final void G1(long j10) {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13248d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            j12 = pq.k.G & j11;
            if (j12 >= j10) {
                return;
            }
        } while (!f13248d.compareAndSet(this, j11, pq.k.w(j12, (int) (j11 >> 60))));
    }

    public final void H0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13248d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, pq.k.w(pq.k.G & j10, 3)));
    }

    public final void H1(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j12;
        if (C0()) {
            return;
        }
        while (f13250f.get(this) <= j10) {
        }
        int i10 = pq.k.f13268c;
        for (int i11 = 0; i11 < i10; i11++) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f13250f;
            long j13 = atomicLongFieldUpdater2.get(this);
            if (j13 == (4611686018427387903L & f13251g.get(this)) && j13 == atomicLongFieldUpdater2.get(this)) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater3 = f13251g;
        do {
            j11 = atomicLongFieldUpdater3.get(this);
        } while (!atomicLongFieldUpdater3.compareAndSet(this, j11, pq.k.v(j11 & 4611686018427387903L, true)));
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater4 = f13250f;
            long j14 = atomicLongFieldUpdater4.get(this);
            atomicLongFieldUpdater = f13251g;
            long j15 = atomicLongFieldUpdater.get(this);
            long j16 = j15 & 4611686018427387903L;
            boolean z10 = (4611686018427387904L & j15) != 0;
            if (j14 == j16 && j14 == atomicLongFieldUpdater4.get(this)) {
                break;
            } else if (!z10) {
                atomicLongFieldUpdater.compareAndSet(this, j15, pq.k.v(j16, true));
            }
        }
        do {
            j12 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j12, pq.k.v(j12 & 4611686018427387903L, false)));
    }

    @Override // pq.g0
    public boolean J() {
        return v0(f13248d.get(this), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J0(long j10, q<E> qVar) {
        q<E> qVar2;
        q<E> qVar3;
        while (qVar.f17877c < j10 && (qVar3 = (q) qVar.e()) != null) {
            qVar = qVar3;
        }
        while (true) {
            if (!qVar.h() || (qVar2 = (q) qVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13254p;
                while (true) {
                    r0 r0Var = (r0) atomicReferenceFieldUpdater.get(this);
                    if (r0Var.f17877c >= qVar.f17877c) {
                        return;
                    }
                    if (!qVar.s()) {
                        break;
                    }
                    if (j.d.a(atomicReferenceFieldUpdater, this, r0Var, qVar)) {
                        if (r0Var.o()) {
                            r0Var.l();
                            return;
                        }
                        return;
                    } else if (qVar.o()) {
                        qVar.l();
                    }
                }
            } else {
                qVar = qVar2;
            }
        }
    }

    public void K0() {
    }

    @Override // pq.g0
    @os.m
    public Object L(E e10, @os.l um.d<? super l2> dVar) {
        return m1(this, e10, dVar);
    }

    public final void L0(nq.p<? super p<? extends E>> pVar) {
        c1.a aVar = c1.Companion;
        pVar.resumeWith(c1.m59constructorimpl(new p(p.f13308b.a(g0()))));
    }

    public final void M0(nq.p<? super E> pVar) {
        c1.a aVar = c1.Companion;
        pVar.resumeWith(c1.m59constructorimpl(d1.a(m0())));
    }

    public final void N0(yq.m<?> mVar) {
        mVar.f(pq.k.z());
    }

    public final void O0(E e10, yq.m<?> mVar) throws IllegalAccessException, InvocationTargetException {
        jn.l<E, l2> lVar = this.f13258b;
        if (lVar != null) {
            l0.b(lVar, e10, mVar.getContext());
        }
        mVar.f(pq.k.z());
    }

    public final Object P0(E e10, um.d<? super l2> dVar) throws IllegalAccessException, InvocationTargetException {
        h1 h1VarD;
        nq.q qVar = new nq.q(wm.c.e(dVar), 1);
        qVar.F();
        jn.l<E, l2> lVar = this.f13258b;
        if (lVar == null || (h1VarD = l0.d(lVar, e10, null, 2, null)) == null) {
            Throwable thO0 = o0();
            c1.a aVar = c1.Companion;
            qVar.resumeWith(c1.m59constructorimpl(d1.a(thO0)));
        } else {
            lm.p.a(h1VarD, o0());
            c1.a aVar2 = c1.Companion;
            qVar.resumeWith(c1.m59constructorimpl(d1.a(h1VarD)));
        }
        Object objZ = qVar.z();
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        if (objZ == aVar3) {
            xm.h.c(dVar);
        }
        return objZ == aVar3 ? objZ : l2.f10208a;
    }

    public final boolean Q(long j10) {
        return j10 < f13250f.get(this) || j10 < f13249e.get(this) + ((long) this.f13257a);
    }

    public final void Q0(E e10, nq.p<? super l2> pVar) throws IllegalAccessException, InvocationTargetException {
        jn.l<E, l2> lVar = this.f13258b;
        if (lVar != null) {
            l0.b(lVar, e10, pVar.getContext());
        }
        Throwable thO0 = o0();
        c1.a aVar = c1.Companion;
        pVar.resumeWith(c1.m59constructorimpl(d1.a(thO0)));
    }

    public boolean R(@os.m Throwable th2) {
        if (th2 == null) {
            th2 = new CancellationException("Channel was cancelled");
        }
        return V(th2, true);
    }

    public void R0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(q<E> qVar, long j10) {
        Object objC = vq.s.c(null, 1, null);
        loop0: while (qVar != null) {
            for (int i10 = pq.k.f13267b - 1; -1 < i10; i10--) {
                if ((qVar.f17877c * ((long) pq.k.f13267b)) + ((long) i10) < j10) {
                    break loop0;
                }
                while (true) {
                    Object objY = qVar.y(i10);
                    if (objY != null && objY != pq.k.f13272g) {
                        if (!(objY instanceof j0)) {
                            if (!(objY instanceof b4)) {
                                break;
                            }
                            if (qVar.t(i10, objY, pq.k.f13279n)) {
                                objC = vq.s.h(objC, objY);
                                qVar.z(i10, true);
                                break;
                            }
                        } else {
                            if (qVar.t(i10, objY, pq.k.f13279n)) {
                                objC = vq.s.h(objC, ((j0) objY).f13265a);
                                qVar.z(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (qVar.t(i10, objY, pq.k.f13279n)) {
                            qVar.r();
                            break;
                        }
                    }
                }
            }
            qVar = (q) qVar.g();
        }
        if (objC != null) {
            if (!(objC instanceof ArrayList)) {
                l1((b4) objC, true);
                return;
            }
            kn.l0.n(objC, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objC;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                l1((b4) arrayList.get(size), true);
            }
        }
    }

    public void S0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T() {
        if (C0()) {
            if (f13254p.get(this) != pq.k.f13266a) {
                throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (((q) f13253n.get(this)).f17877c > ((q) f13254p.get(this)).f17877c) {
            throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        List listO = nm.y.O(f13253n.get(this), f13252i.get(this), f13254p.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listO) {
            if (((q) obj) != pq.k.f13266a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j10 = ((q) next).f17877c;
            do {
                Object next2 = it.next();
                long j11 = ((q) next2).f17877c;
                if (j10 > j11) {
                    next = next2;
                    j10 = j11;
                }
            } while (it.hasNext());
        }
        q qVar = (q) next;
        if (qVar.g() != 0) {
            throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
        }
        while (qVar.e() != 0) {
            S sE = qVar.e();
            kn.l0.m(sE);
            if (((q) sE).g() != 0) {
                S sE2 = qVar.e();
                kn.l0.m(sE2);
                if (((q) sE2).g() != qVar) {
                    throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                }
            }
            int i10 = pq.k.f13267b;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object objY = qVar.y(i12);
                if (!kn.l0.g(objY, pq.k.f13271f) && !(objY instanceof b4)) {
                    if (kn.l0.g(objY, pq.k.f13278m) ? true : kn.l0.g(objY, pq.k.f13277l) ? true : kn.l0.g(objY, pq.k.f13279n)) {
                        if (!(qVar.x(i12) == null)) {
                            throw new IllegalStateException("Check failed.");
                        }
                        i11++;
                    } else {
                        if (!(kn.l0.g(objY, pq.k.f13275j) ? true : kn.l0.g(objY, pq.k.f13276k))) {
                            throw new IllegalStateException(("Unexpected segment cell state: " + objY + ".\nChannel state: " + this).toString());
                        }
                        if (!(qVar.x(i12) == null)) {
                            throw new IllegalStateException("Check failed.");
                        }
                    }
                }
            }
            if (i11 == pq.k.f13267b) {
                if (!(qVar == f13253n.get(this) || qVar == f13252i.get(this) || qVar == f13254p.get(this))) {
                    throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
                }
            }
            S sE3 = qVar.e();
            kn.l0.m(sE3);
            qVar = (q) sE3;
        }
    }

    public final void T0(b4 b4Var, q<E> qVar, int i10) {
        S0();
        b4Var.d(qVar, i10);
    }

    public final q<E> U() {
        Object obj = f13254p.get(this);
        q qVar = (q) f13252i.get(this);
        if (qVar.f17877c > ((q) obj).f17877c) {
            obj = qVar;
        }
        q qVar2 = (q) f13253n.get(this);
        if (qVar2.f17877c > ((q) obj).f17877c) {
            obj = qVar2;
        }
        return (q) vq.f.d((vq.g) obj);
    }

    public final void U0(b4 b4Var, q<E> qVar, int i10) {
        b4Var.d(qVar, i10 + pq.k.f13267b);
    }

    public boolean V(@os.m Throwable th2, boolean z10) {
        if (z10) {
            G0();
        }
        boolean zA = j.d.a(f13255v, this, pq.k.A, th2);
        if (z10) {
            H0();
        } else {
            I0();
        }
        J();
        K0();
        if (zA) {
            t0();
        }
        return zA;
    }

    public final Object V0(Object obj, Object obj2) throws Throwable {
        if (obj2 != pq.k.z()) {
            return obj2;
        }
        throw m0();
    }

    public final void W(long j10) throws IllegalAccessException, InvocationTargetException {
        i1(X(j10));
    }

    public final Object W0(Object obj, Object obj2) {
        Object objC;
        if (obj2 == pq.k.z()) {
            objC = p.f13308b.a(g0());
        } else {
            p.f13308b.getClass();
            objC = p.c(obj2);
        }
        return p.b(objC);
    }

    public final q<E> X(long j10) {
        q<E> qVarU = U();
        if (A0()) {
            long jF0 = F0(qVarU);
            if (jF0 != -1) {
                Z(jF0);
            }
        }
        S(qVarU, j10);
        return qVarU;
    }

    public final Object X0(Object obj, Object obj2) throws Throwable {
        if (obj2 != pq.k.z()) {
            return obj2;
        }
        if (g0() == null) {
            return null;
        }
        throw m0();
    }

    public final void Y() {
        J();
    }

    public final Object Y0(Object obj, Object obj2) throws Throwable {
        if (obj2 != pq.k.z()) {
            return this;
        }
        throw o0();
    }

    public final void Z(long j10) {
        h1 h1VarD;
        q<E> qVar = (q) f13253n.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f13249e;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(((long) this.f13257a) + j11, f13250f.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j11, j11 + 1)) {
                int i10 = pq.k.f13267b;
                long j12 = j11 / ((long) i10);
                int i11 = (int) (j11 % ((long) i10));
                if (qVar.f17877c != j12) {
                    q<E> qVarC0 = c0(j12, qVar);
                    if (qVarC0 == null) {
                        continue;
                    } else {
                        qVar = qVarC0;
                    }
                }
                Object objB1 = B1(qVar, i11, j11, null);
                if (objB1 != pq.k.f13282q) {
                    qVar.b();
                    jn.l<E, l2> lVar = this.f13258b;
                    if (lVar != null && (h1VarD = l0.d(lVar, objB1, null, 2, null)) != null) {
                        throw h1VarD;
                    }
                } else if (j11 < p0()) {
                    qVar.b();
                }
            }
        }
    }

    public final void a0() {
        if (C0()) {
            return;
        }
        q<E> qVar = (q) f13254p.get(this);
        while (true) {
            long andIncrement = f13250f.getAndIncrement(this);
            int i10 = pq.k.f13267b;
            long j10 = andIncrement / ((long) i10);
            if (p0() <= andIncrement) {
                if (qVar.f17877c < j10 && qVar.e() != 0) {
                    J0(j10, qVar);
                }
                s0(this, 0L, 1, null);
                return;
            }
            if (qVar.f17877c != j10) {
                q<E> qVarB0 = b0(j10, qVar, andIncrement);
                if (qVarB0 == null) {
                    continue;
                } else {
                    qVar = qVarB0;
                }
            }
            if (z1(qVar, (int) (andIncrement % ((long) i10)), andIncrement)) {
                s0(this, 0L, 1, null);
                return;
            }
            s0(this, 0L, 1, null);
        }
    }

    @Override // pq.f0
    public final void b(@os.m CancellationException cancellationException) {
        R(cancellationException);
    }

    public final q<E> b0(long j10, q<E> qVar, long j11) {
        Object objG;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13254p;
        jn.p pVar = (jn.p) pq.k.y();
        loop0: while (true) {
            objG = vq.f.g(qVar, j10, pVar);
            if (!s0.h(objG)) {
                r0 r0VarF = s0.f(objG);
                while (true) {
                    r0 r0Var = (r0) atomicReferenceFieldUpdater.get(this);
                    if (r0Var.f17877c >= r0VarF.f17877c) {
                        break loop0;
                    }
                    if (!r0VarF.s()) {
                        break;
                    }
                    if (j.d.a(atomicReferenceFieldUpdater, this, r0Var, r0VarF)) {
                        if (!r0Var.o()) {
                            break loop0;
                        }
                        r0Var.l();
                        break loop0;
                    }
                    if (r0VarF.o()) {
                        r0VarF.l();
                    }
                }
            } else {
                break;
            }
        }
        if (s0.h(objG)) {
            Y();
            J0(j10, qVar);
            s0(this, 0L, 1, null);
            return null;
        }
        q<E> qVar2 = (q) s0.f(objG);
        long j12 = qVar2.f17877c;
        if (j12 <= j10) {
            return qVar2;
        }
        int i10 = pq.k.f13267b;
        if (f13250f.compareAndSet(this, j11 + 1, ((long) i10) * j12)) {
            r0((qVar2.f17877c * ((long) i10)) - j11);
            return null;
        }
        s0(this, 0L, 1, null);
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b1(q<E> qVar, int i10, long j10, um.d<? super p<? extends E>> dVar) {
        m mVar;
        p pVar;
        if (dVar instanceof m) {
            mVar = (m) dVar;
            int i11 = mVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                mVar.label = i11 - Integer.MIN_VALUE;
            } else {
                mVar = new m(this, dVar);
            }
        } else {
            mVar = new m(this, dVar);
        }
        Object objZ = mVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = mVar.label;
        if (i12 == 0) {
            d1.n(objZ);
            mVar.L$0 = this;
            mVar.L$1 = qVar;
            mVar.I$0 = i10;
            mVar.J$0 = j10;
            mVar.label = 1;
            nq.q qVarB = nq.s.b(wm.c.e(mVar));
            try {
                kn.l0.n(qVarB, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");
                e0 e0Var = new e0(qVarB);
                Object objB1 = B1(qVar, i10, j10, e0Var);
                if (objB1 != pq.k.f13280o) {
                    l0.a aVar2 = null;
                    if (objB1 == pq.k.f13282q) {
                        if (j10 < p0()) {
                            qVar.b();
                        }
                        q<E> qVar2 = (q) f13253n.get(this);
                        while (true) {
                            if (r()) {
                                L0(qVarB);
                                break;
                            }
                            long andIncrement = f13249e.getAndIncrement(this);
                            int i13 = pq.k.f13267b;
                            long j11 = andIncrement / ((long) i13);
                            int i14 = (int) (andIncrement % ((long) i13));
                            if (qVar2.f17877c != j11) {
                                q<E> qVarC0 = c0(j11, qVar2);
                                if (qVarC0 != null) {
                                    qVar2 = qVarC0;
                                }
                            }
                            Object objB2 = B1(qVar2, i14, andIncrement, e0Var);
                            if (objB2 == pq.k.f13280o) {
                                T0(e0Var, qVar2, i14);
                                break;
                            }
                            if (objB2 == pq.k.f13282q) {
                                if (andIncrement < p0()) {
                                    qVar2.b();
                                }
                            } else {
                                if (objB2 == pq.k.f13281p) {
                                    throw new IllegalStateException("unexpected");
                                }
                                qVar2.b();
                                p.f13308b.getClass();
                                pVar = new p(p.c(objB2));
                                jn.l<E, l2> lVar = this.f13258b;
                                if (lVar != null) {
                                    aVar2 = new l0.a(lVar, objB2, qVarB.getContext());
                                }
                            }
                        }
                    } else {
                        qVar.b();
                        p.f13308b.getClass();
                        pVar = new p(p.c(objB1));
                        jn.l<E, l2> lVar2 = this.f13258b;
                        if (lVar2 != null) {
                            aVar2 = new l0.a(lVar2, objB1, qVarB.getContext());
                        }
                    }
                    qVarB.g(pVar, aVar2);
                    break;
                }
                T0(e0Var, qVar, i10);
                objZ = qVarB.z();
                if (objZ == wm.a.COROUTINE_SUSPENDED) {
                    xm.h.c(mVar);
                }
                if (objZ == aVar) {
                    return aVar;
                }
            } catch (Throwable th2) {
                qVarB.Q();
                throw th2;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(objZ);
        }
        return ((p) objZ).f13310a;
    }

    @Override // pq.f0
    public final boolean c(@os.m Throwable th2) {
        return R(th2);
    }

    public final q<E> c0(long j10, q<E> qVar) {
        Object objG;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13253n;
        jn.p pVar = (jn.p) pq.k.y();
        loop0: while (true) {
            objG = vq.f.g(qVar, j10, pVar);
            if (!s0.h(objG)) {
                r0 r0VarF = s0.f(objG);
                while (true) {
                    r0 r0Var = (r0) atomicReferenceFieldUpdater.get(this);
                    if (r0Var.f17877c >= r0VarF.f17877c) {
                        break loop0;
                    }
                    if (!r0VarF.s()) {
                        break;
                    }
                    if (j.d.a(atomicReferenceFieldUpdater, this, r0Var, r0VarF)) {
                        if (!r0Var.o()) {
                            break loop0;
                        }
                        r0Var.l();
                        break loop0;
                    }
                    if (r0VarF.o()) {
                        r0VarF.l();
                    }
                }
            } else {
                break;
            }
        }
        if (s0.h(objG)) {
            Y();
            if (qVar.f17877c * ((long) pq.k.f13267b) >= p0()) {
                return null;
            }
            qVar.b();
            return null;
        }
        q<E> qVar2 = (q) s0.f(objG);
        if (!C0() && j10 <= f13250f.get(this) / ((long) pq.k.f13267b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f13254p;
            while (true) {
                r0 r0Var2 = (r0) atomicReferenceFieldUpdater2.get(this);
                if (r0Var2.f17877c >= qVar2.f17877c || !qVar2.s()) {
                    break;
                }
                if (j.d.a(atomicReferenceFieldUpdater2, this, r0Var2, qVar2)) {
                    if (!r0Var2.o()) {
                        break;
                    }
                    r0Var2.l();
                    break;
                }
                if (qVar2.o()) {
                    qVar2.l();
                }
            }
        }
        long j11 = qVar2.f17877c;
        if (j11 <= j10) {
            return qVar2;
        }
        int i10 = pq.k.f13267b;
        F1(j11 * ((long) i10));
        if (qVar2.f17877c * ((long) i10) >= p0()) {
            return null;
        }
        qVar2.b();
        return null;
    }

    public final <R> R c1(Object obj, jn.l<? super E, ? extends R> lVar, jn.q<? super q<E>, ? super Integer, ? super Long, ? extends R> qVar, jn.a<? extends R> aVar, jn.q<? super q<E>, ? super Integer, ? super Long, ? extends R> qVar2) {
        q<E> qVar3 = (q) f13253n.get(this);
        while (!r()) {
            long andIncrement = f13249e.getAndIncrement(this);
            int i10 = pq.k.f13267b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (qVar3.f17877c != j10) {
                q<E> qVarC0 = c0(j10, qVar3);
                if (qVarC0 == null) {
                    continue;
                } else {
                    qVar3 = qVarC0;
                }
            }
            u0 u0Var = (Object) B1(qVar3, i11, andIncrement, obj);
            if (u0Var == pq.k.f13280o) {
                b4 b4Var = obj instanceof b4 ? (b4) obj : null;
                if (b4Var != null) {
                    T0(b4Var, qVar3, i11);
                }
                return qVar.invoke(qVar3, Integer.valueOf(i11), Long.valueOf(andIncrement));
            }
            if (u0Var != pq.k.f13282q) {
                if (u0Var == pq.k.f13281p) {
                    return qVar2.invoke(qVar3, Integer.valueOf(i11), Long.valueOf(andIncrement));
                }
                qVar3.b();
                return lVar.invoke(u0Var);
            }
            if (andIncrement < p0()) {
                qVar3.b();
            }
        }
        return aVar.invoke();
    }

    @Override // pq.f0
    public final void cancel() {
        R(null);
    }

    public final q<E> d0(long j10, q<E> qVar) {
        Object objG;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13252i;
        jn.p pVar = (jn.p) pq.k.y();
        loop0: while (true) {
            objG = vq.f.g(qVar, j10, pVar);
            if (!s0.h(objG)) {
                r0 r0VarF = s0.f(objG);
                while (true) {
                    r0 r0Var = (r0) atomicReferenceFieldUpdater.get(this);
                    if (r0Var.f17877c >= r0VarF.f17877c) {
                        break loop0;
                    }
                    if (!r0VarF.s()) {
                        break;
                    }
                    if (j.d.a(atomicReferenceFieldUpdater, this, r0Var, r0VarF)) {
                        if (!r0Var.o()) {
                            break loop0;
                        }
                        r0Var.l();
                        break loop0;
                    }
                    if (r0VarF.o()) {
                        r0VarF.l();
                    }
                }
            } else {
                break;
            }
        }
        if (s0.h(objG)) {
            J();
            if (qVar.f17877c * ((long) pq.k.f13267b) >= f13249e.get(this)) {
                return null;
            }
            qVar.b();
            return null;
        }
        q<E> qVar2 = (q) s0.f(objG);
        long j11 = qVar2.f17877c;
        if (j11 <= j10) {
            return qVar2;
        }
        int i10 = pq.k.f13267b;
        G1(j11 * ((long) i10));
        if (qVar2.f17877c * ((long) i10) >= f13249e.get(this)) {
            return null;
        }
        qVar2.b();
        return null;
    }

    public final Object e0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, ? extends Object> lVar, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!j.d.a(atomicReferenceFieldUpdater, obj, obj2, lVar.invoke(obj2)));
        return obj2;
    }

    public final void e1(q<E> qVar, int i10, long j10, b4 b4Var, jn.l<? super E, l2> lVar, jn.a<l2> aVar) {
        u0 u0Var = (Object) B1(qVar, i10, j10, b4Var);
        if (u0Var == pq.k.f13280o) {
            T0(b4Var, qVar, i10);
            return;
        }
        if (u0Var != pq.k.f13282q) {
            qVar.b();
            lVar.invoke(u0Var);
            return;
        }
        if (j10 < p0()) {
            qVar.b();
        }
        q<E> qVar2 = (q) f13253n.get(this);
        while (!r()) {
            long andIncrement = f13249e.getAndIncrement(this);
            int i11 = pq.k.f13267b;
            long j11 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (qVar2.f17877c != j11) {
                q<E> qVarC0 = c0(j11, qVar2);
                if (qVarC0 == null) {
                    continue;
                } else {
                    qVar2 = qVarC0;
                }
            }
            u0 u0Var2 = (Object) B1(qVar2, i12, andIncrement, b4Var);
            if (u0Var2 == pq.k.f13280o) {
                if (b4Var == null) {
                    b4Var = null;
                }
                if (b4Var != null) {
                    T0(b4Var, qVar2, i12);
                }
                l2 l2Var = l2.f10208a;
                return;
            }
            if (u0Var2 != pq.k.f13282q) {
                if (u0Var2 == pq.k.f13281p) {
                    throw new IllegalStateException("unexpected");
                }
                qVar2.b();
                lVar.invoke(u0Var2);
                return;
            }
            if (andIncrement < p0()) {
                qVar2.b();
            }
        }
        aVar.invoke();
    }

    @Override // pq.g0
    public boolean f(@os.m Throwable th2) {
        return V(th2, false);
    }

    public final long f0() {
        return f13250f.get(this);
    }

    public final Object f1(q<E> qVar, int i10, long j10, um.d<? super E> dVar) {
        nq.q qVarB = nq.s.b(wm.c.e(dVar));
        try {
            Object objB1 = B1(qVar, i10, j10, qVarB);
            if (objB1 != pq.k.f13280o) {
                l0.a aVar = null;
                aVar = null;
                if (objB1 == pq.k.f13282q) {
                    if (j10 < p0()) {
                        qVar.b();
                    }
                    q<E> qVar2 = (q) f13253n.get(this);
                    while (true) {
                        if (r()) {
                            M0(qVarB);
                            break;
                        }
                        long andIncrement = f13249e.getAndIncrement(this);
                        int i11 = pq.k.f13267b;
                        long j11 = andIncrement / ((long) i11);
                        int i12 = (int) (andIncrement % ((long) i11));
                        if (qVar2.f17877c != j11) {
                            q<E> qVarC0 = c0(j11, qVar2);
                            if (qVarC0 != null) {
                                qVar2 = qVarC0;
                            }
                        }
                        objB1 = B1(qVar2, i12, andIncrement, qVarB);
                        if (objB1 == pq.k.f13280o) {
                            nq.q qVar3 = qVarB != null ? qVarB : null;
                            if (qVar3 == null) {
                                break;
                            }
                            T0(qVar3, qVar2, i12);
                            break;
                        }
                        if (objB1 == pq.k.f13282q) {
                            if (andIncrement < p0()) {
                                qVar2.b();
                            }
                        } else {
                            if (objB1 == pq.k.f13281p) {
                                throw new IllegalStateException("unexpected");
                            }
                            qVar2.b();
                            jn.l<E, l2> lVar = this.f13258b;
                            if (lVar != null) {
                                aVar = new l0.a(lVar, objB1, qVarB.getContext());
                            }
                        }
                    }
                } else {
                    qVar.b();
                    jn.l<E, l2> lVar2 = this.f13258b;
                    if (lVar2 != null) {
                        aVar = new l0.a(lVar2, objB1, qVarB.getContext());
                    }
                }
                qVarB.g(objB1, aVar);
                break;
            }
            T0(qVarB, qVar, i10);
            Object objZ = qVarB.z();
            if (objZ == wm.a.COROUTINE_SUSPENDED) {
                xm.h.c(dVar);
            }
            return objZ;
        } catch (Throwable th2) {
            qVarB.Q();
            throw th2;
        }
    }

    @os.m
    public final Throwable g0() {
        return (Throwable) f13255v.get(this);
    }

    public final void g1(yq.m<?> mVar, Object obj) {
        q<E> qVar = (q) f13253n.get(this);
        while (!r()) {
            long andIncrement = f13249e.getAndIncrement(this);
            int i10 = pq.k.f13267b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (qVar.f17877c != j10) {
                q<E> qVarC0 = c0(j10, qVar);
                if (qVarC0 == null) {
                    continue;
                } else {
                    qVar = qVarC0;
                }
            }
            Object objB1 = B1(qVar, i11, andIncrement, mVar);
            if (objB1 == pq.k.f13280o) {
                b4 b4Var = mVar instanceof b4 ? (b4) mVar : null;
                if (b4Var != null) {
                    T0(b4Var, qVar, i11);
                    return;
                }
                return;
            }
            if (objB1 != pq.k.f13282q) {
                if (objB1 == pq.k.f13281p) {
                    throw new IllegalStateException("unexpected");
                }
                qVar.b();
                mVar.f(objB1);
                return;
            }
            if (andIncrement < p0()) {
                qVar.b();
            }
        }
        N0(mVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h1(@os.l yq.m<?> mVar, @os.m Object obj) throws IllegalAccessException, InvocationTargetException {
        q<E> qVar = (q) f13252i.get(this);
        while (true) {
            long andIncrement = f13248d.getAndIncrement(this);
            long j10 = pq.k.G & andIncrement;
            boolean zV0 = v0(andIncrement, false);
            int i10 = pq.k.f13267b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (qVar.f17877c != j11) {
                q<E> qVarD0 = d0(j11, qVar);
                if (qVarD0 != null) {
                    qVar = qVarD0;
                } else if (zV0) {
                    break;
                }
            }
            int iD1 = D1(qVar, i11, obj, j10, mVar, zV0);
            if (iD1 == 0) {
                qVar.b();
            } else if (iD1 != 1) {
                if (iD1 == 2) {
                    if (zV0) {
                        qVar.r();
                        break;
                    }
                    b4 b4Var = mVar instanceof b4 ? (b4) mVar : null;
                    if (b4Var != null) {
                        U0(b4Var, qVar, i11);
                        return;
                    }
                    return;
                }
                if (iD1 == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iD1 == 4) {
                    if (j10 >= f13249e.get(this)) {
                        break;
                    }
                    qVar.b();
                    break;
                } else if (iD1 == 5) {
                    qVar.b();
                }
            }
            mVar.f(l2.f10208a);
            return;
        }
        O0(obj, mVar);
    }

    @Override // pq.g0
    public void i(@os.l jn.l<? super Throwable, l2> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13256w;
        if (j.d.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != pq.k.f13290y) {
                if (obj == pq.k.f13291z) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!j.d.a(f13256w, this, pq.k.f13290y, pq.k.f13291z));
        lVar.invoke(g0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i1(q<E> qVar) throws IllegalAccessException, InvocationTargetException {
        jn.l<E, l2> lVar = this.f13258b;
        Object objC = vq.s.c(null, 1, null);
        h1 h1VarC = null;
        loop0: do {
            for (int i10 = pq.k.f13267b - 1; -1 < i10; i10--) {
                long j10 = (qVar.f17877c * ((long) pq.k.f13267b)) + ((long) i10);
                while (true) {
                    Object objY = qVar.y(i10);
                    if (objY == pq.k.f13276k) {
                        break loop0;
                    }
                    if (objY != pq.k.f13271f) {
                        if (objY != pq.k.f13272g && objY != null) {
                            if (!(objY instanceof b4) && !(objY instanceof j0)) {
                                u0 u0Var = pq.k.f13274i;
                                if (objY != u0Var && objY != pq.k.f13273h) {
                                    if (objY != u0Var) {
                                        break;
                                    }
                                } else {
                                    break loop0;
                                }
                            } else {
                                if (j10 < f13249e.get(this)) {
                                    break loop0;
                                }
                                b4 b4Var = objY instanceof j0 ? ((j0) objY).f13265a : (b4) objY;
                                if (qVar.t(i10, objY, pq.k.f13279n)) {
                                    if (lVar != null) {
                                        h1VarC = l0.c(lVar, qVar.x(i10), h1VarC);
                                    }
                                    objC = vq.s.h(objC, b4Var);
                                    qVar.B(i10, null);
                                    qVar.r();
                                    break;
                                }
                            }
                        } else {
                            if (qVar.t(i10, objY, pq.k.f13279n)) {
                                qVar.r();
                                break;
                            }
                        }
                    } else {
                        if (j10 < f13249e.get(this)) {
                            break loop0;
                        }
                        if (qVar.t(i10, objY, pq.k.f13279n)) {
                            if (lVar != null) {
                                h1VarC = l0.c(lVar, qVar.x(i10), h1VarC);
                            }
                            qVar.B(i10, null);
                            qVar.r();
                            break;
                        }
                    }
                }
            }
            qVar = (q) qVar.g();
        } while (qVar != null);
        if (objC != null) {
            if (objC instanceof ArrayList) {
                kn.l0.n(objC, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) objC;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    l1((b4) arrayList.get(size), false);
                }
            } else {
                l1((b4) objC, false);
            }
        }
        if (h1VarC != null) {
            throw h1VarC;
        }
    }

    @Override // pq.f0
    public boolean isEmpty() {
        if (r() || q0()) {
            return false;
        }
        return !r();
    }

    @Override // pq.f0
    @os.l
    public pq.n<E> iterator() {
        return new a();
    }

    public final void j1(b4 b4Var) {
        l1(b4Var, true);
    }

    public final void k1(b4 b4Var) {
        l1(b4Var, false);
    }

    public final void l1(b4 b4Var, boolean z10) {
        if (b4Var instanceof b) {
            nq.p<Boolean> pVar = ((b) b4Var).f13263a;
            c1.a aVar = c1.Companion;
            pVar.resumeWith(c1.m59constructorimpl(Boolean.FALSE));
            return;
        }
        if (b4Var instanceof nq.p) {
            um.d dVar = (um.d) b4Var;
            c1.a aVar2 = c1.Companion;
            w.a.a(z10 ? m0() : o0(), dVar);
        } else if (b4Var instanceof e0) {
            nq.q<p<? extends E>> qVar = ((e0) b4Var).f13242a;
            c1.a aVar3 = c1.Companion;
            qVar.resumeWith(c1.m59constructorimpl(new p(p.f13308b.a(g0()))));
        } else if (b4Var instanceof a) {
            ((a) b4Var).l();
        } else if (b4Var instanceof yq.m) {
            ((yq.m) b4Var).i(this, pq.k.z());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + b4Var).toString());
        }
    }

    @Override // pq.g0
    @os.l
    public yq.i<E, j<E>> m() {
        i iVar = i.INSTANCE;
        kn.l0.n(iVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        jn.q qVar = (jn.q) u1.q(iVar, 3);
        C0331j c0331j = C0331j.INSTANCE;
        kn.l0.n(c0331j, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new yq.j(this, qVar, (jn.q) u1.q(c0331j, 3), null, 8, null);
    }

    public final Throwable m0() {
        Throwable thG0 = g0();
        return thG0 == null ? new v(r.f13314a) : thG0;
    }

    @Override // pq.f0
    @os.m
    public Object n(@os.l um.d<? super E> dVar) {
        return Z0(this, dVar);
    }

    public final long n0() {
        return f13249e.get(this);
    }

    @os.m
    public Object n1(E e10, @os.l um.d<? super Boolean> dVar) {
        return o1(this, e10, dVar);
    }

    @os.l
    public final Throwable o0() {
        Throwable thG0 = g0();
        return thG0 == null ? new w(r.f13314a) : thG0;
    }

    @Override // pq.g0
    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        return g0.a.c(this, e10);
    }

    public final long p0() {
        return f13248d.get(this) & pq.k.G;
    }

    public final <R> R p1(E e10, @os.m Object obj, @os.l jn.a<? extends R> aVar, @os.l jn.p<? super q<E>, ? super Integer, ? extends R> pVar, @os.l jn.a<? extends R> aVar2, @os.l jn.r<? super q<E>, ? super Integer, ? super E, ? super Long, ? extends R> rVar) throws IllegalAccessException, InvocationTargetException {
        q<E> qVar;
        q<E> qVar2 = (q) f13252i.get(this);
        while (true) {
            long andIncrement = f13248d.getAndIncrement(this);
            long j10 = andIncrement & pq.k.G;
            boolean zV0 = v0(andIncrement, false);
            int i10 = pq.k.f13267b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (qVar2.f17877c != j11) {
                q<E> qVarD0 = d0(j11, qVar2);
                if (qVarD0 != null) {
                    qVar = qVarD0;
                } else if (zV0) {
                    return aVar2.invoke();
                }
            } else {
                qVar = qVar2;
            }
            int iD1 = D1(qVar, i11, e10, j10, obj, zV0);
            if (iD1 == 0) {
                qVar.b();
                return aVar.invoke();
            }
            if (iD1 == 1) {
                return aVar.invoke();
            }
            if (iD1 == 2) {
                if (zV0) {
                    qVar.r();
                    return aVar2.invoke();
                }
                b4 b4Var = obj instanceof b4 ? (b4) obj : null;
                if (b4Var != null) {
                    U0(b4Var, qVar, i11);
                }
                return pVar.invoke(qVar, Integer.valueOf(i11));
            }
            if (iD1 == 3) {
                return rVar.invoke(qVar, Integer.valueOf(i11), e10, Long.valueOf(j10));
            }
            if (iD1 == 4) {
                if (j10 < f13249e.get(this)) {
                    qVar.b();
                }
                return aVar2.invoke();
            }
            if (iD1 == 5) {
                qVar.b();
            }
            qVar2 = qVar;
        }
    }

    @Override // pq.f0
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @a1(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return (E) f0.a.h(this);
    }

    public final boolean q0() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13253n;
            q<E> qVarC0 = (q) atomicReferenceFieldUpdater.get(this);
            AtomicLongFieldUpdater atomicLongFieldUpdater = f13249e;
            long j10 = atomicLongFieldUpdater.get(this);
            if (p0() <= j10) {
                return false;
            }
            int i10 = pq.k.f13267b;
            long j11 = j10 / ((long) i10);
            if (qVarC0.f17877c == j11 || (qVarC0 = c0(j11, qVarC0)) != null) {
                qVarC0.b();
                if (u0(qVarC0, (int) (j10 % ((long) i10)), j10)) {
                    return true;
                }
                atomicLongFieldUpdater.compareAndSet(this, j10, j10 + 1);
            } else if (((q) atomicReferenceFieldUpdater.get(this)).f17877c < j11) {
                return false;
            }
        }
    }

    @Override // pq.f0
    public boolean r() {
        return v0(f13248d.get(this), true);
    }

    public final void r0(long j10) {
        if ((f13251g.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            while ((f13251g.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final void r1(q<E> qVar, int i10, E e10, long j10, b4 b4Var, jn.a<l2> aVar, jn.a<l2> aVar2) throws IllegalAccessException, InvocationTargetException {
        q<E> qVar2;
        b4 b4Var2 = b4Var;
        int iD1 = D1(qVar, i10, e10, j10, b4Var, false);
        if (iD1 == 0) {
            qVar.b();
            aVar.invoke();
            return;
        }
        if (iD1 == 1) {
            aVar.invoke();
            return;
        }
        if (iD1 == 2) {
            U0(b4Var2, qVar, i10);
            return;
        }
        if (iD1 == 4) {
            if (j10 < f13249e.get(this)) {
                qVar.b();
            }
            aVar2.invoke();
            return;
        }
        if (iD1 != 5) {
            throw new IllegalStateException("unexpected");
        }
        qVar.b();
        q<E> qVar3 = (q) f13252i.get(this);
        while (true) {
            long andIncrement = f13248d.getAndIncrement(this);
            long j11 = andIncrement & pq.k.G;
            boolean zV0 = v0(andIncrement, false);
            int i11 = pq.k.f13267b;
            long j12 = j11 / ((long) i11);
            int i12 = (int) (j11 % ((long) i11));
            if (qVar3.f17877c != j12) {
                q<E> qVarD0 = d0(j12, qVar3);
                if (qVarD0 != null) {
                    qVar2 = qVarD0;
                } else if (zV0) {
                    aVar2.invoke();
                    return;
                }
            } else {
                qVar2 = qVar3;
            }
            q<E> qVar4 = qVar2;
            int iD2 = D1(qVar2, i12, e10, j11, b4Var, zV0);
            if (iD2 == 0) {
                qVar4.b();
                aVar.invoke();
                return;
            }
            if (iD2 == 1) {
                aVar.invoke();
                return;
            }
            if (iD2 == 2) {
                if (zV0) {
                    qVar4.r();
                    aVar2.invoke();
                    return;
                }
                if (b4Var2 == null) {
                    b4Var2 = null;
                }
                if (b4Var2 != null) {
                    U0(b4Var2, qVar4, i12);
                }
                l2 l2Var = l2.f10208a;
                return;
            }
            if (iD2 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iD2 == 4) {
                if (j11 < f13249e.get(this)) {
                    qVar4.b();
                }
                aVar2.invoke();
                return;
            } else {
                if (iD2 == 5) {
                    qVar4.b();
                }
                qVar3 = qVar4;
            }
        }
    }

    @Override // pq.f0
    @os.m
    public Object s(@os.l um.d<? super p<? extends E>> dVar) {
        return a1(this, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0111  */
    /* JADX WARN: Code duplicated, block: B:63:0x0116 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x0117  */
    public final Object s1(q<E> qVar, int i10, E e10, long j10, um.d<? super l2> dVar) {
        Object objM59constructorimpl;
        Object objZ;
        wm.a aVar;
        q<E> qVar2;
        nq.q qVarB = nq.s.b(wm.c.e(dVar));
        try {
            int iD1 = D1(qVar, i10, e10, j10, qVarB, false);
            if (iD1 == 0) {
                qVar.b();
                c1.a aVar2 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(l2.f10208a);
            } else {
                if (iD1 != 1) {
                    if (iD1 != 2) {
                        if (iD1 != 4) {
                            if (iD1 != 5) {
                                throw new IllegalStateException("unexpected");
                            }
                            qVar.b();
                            q<E> qVar3 = (q) f13252i.get(this);
                            while (true) {
                                long andIncrement = f13248d.getAndIncrement(this);
                                long j11 = andIncrement & pq.k.G;
                                boolean zV0 = v0(andIncrement, false);
                                int i11 = pq.k.f13267b;
                                long j12 = j11 / ((long) i11);
                                int i12 = (int) (j11 % ((long) i11));
                                if (qVar3.f17877c != j12) {
                                    q<E> qVarD0 = d0(j12, qVar3);
                                    if (qVarD0 != null) {
                                        qVar2 = qVarD0;
                                    } else if (zV0) {
                                    }
                                } else {
                                    qVar2 = qVar3;
                                }
                                q<E> qVar4 = qVar2;
                                int iD2 = D1(qVar2, i12, e10, j11, qVarB, zV0);
                                if (iD2 == 0) {
                                    qVar4.b();
                                    c1.a aVar3 = c1.Companion;
                                    objM59constructorimpl = c1.m59constructorimpl(l2.f10208a);
                                } else if (iD2 == 1) {
                                    c1.a aVar4 = c1.Companion;
                                    objM59constructorimpl = c1.m59constructorimpl(l2.f10208a);
                                } else if (iD2 == 2) {
                                    if (!zV0) {
                                        nq.q qVar5 = qVarB != null ? qVarB : null;
                                        if (qVar5 == null) {
                                            break;
                                        }
                                        U0(qVar5, qVar4, i12);
                                        break;
                                    }
                                    qVar4.r();
                                } else {
                                    if (iD2 == 3) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    if (iD2 != 4) {
                                        if (iD2 == 5) {
                                            qVar4.b();
                                        }
                                        qVar3 = qVar4;
                                    } else if (j11 < f13249e.get(this)) {
                                        qVar4.b();
                                    }
                                }
                            }
                        } else if (j10 < f13249e.get(this)) {
                            qVar.b();
                        }
                        Q0(e10, qVarB);
                        break;
                    } else {
                        U0(qVarB, qVar, i10);
                    }
                    objZ = qVarB.z();
                    aVar = wm.a.COROUTINE_SUSPENDED;
                    if (objZ == aVar) {
                        xm.h.c(dVar);
                    }
                    if (objZ == aVar) {
                        return objZ;
                    }
                    return l2.f10208a;
                }
                c1.a aVar5 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(l2.f10208a);
            }
            qVarB.resumeWith(objM59constructorimpl);
            objZ = qVarB.z();
            aVar = wm.a.COROUTINE_SUSPENDED;
            if (objZ == aVar) {
                xm.h.c(dVar);
            }
            if (objZ == aVar) {
                return objZ;
            }
            return l2.f10208a;
        } catch (Throwable th2) {
            qVarB.Q();
            throw th2;
        }
    }

    public final void t0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13256w;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!j.d.a(atomicReferenceFieldUpdater, this, obj, obj == null ? pq.k.f13290y : pq.k.f13291z));
        if (obj == null) {
            return;
        }
        ((jn.l) obj).invoke(g0());
    }

    public final boolean t1(long j10) {
        if (v0(j10, false)) {
            return false;
        }
        return !Q(j10 & pq.k.G);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public String toString() {
        String string;
        StringBuilder sb2 = new StringBuilder();
        int i10 = (int) (f13248d.get(this) >> 60);
        if (i10 == 2) {
            sb2.append("closed,");
        } else if (i10 == 3) {
            sb2.append("cancelled,");
        }
        sb2.append("capacity=" + this.f13257a + StringUtil.COMMA);
        sb2.append("data=[");
        int i11 = 0;
        List listO = nm.y.O(f13253n.get(this), f13252i.get(this), f13254p.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listO) {
            if (((q) obj) != pq.k.f13266a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j10 = ((q) next).f17877c;
            do {
                Object next2 = it.next();
                long j11 = ((q) next2).f17877c;
                if (j10 > j11) {
                    next = next2;
                    j10 = j11;
                }
            } while (it.hasNext());
        }
        q qVar = (q) next;
        long j12 = f13249e.get(this);
        long jP0 = p0();
        loop2: while (true) {
            int i12 = pq.k.f13267b;
            for (int i13 = i11; i13 < i12; i13++) {
                long j13 = (qVar.f17877c * ((long) pq.k.f13267b)) + ((long) i13);
                if (j13 >= jP0 && j13 >= j12) {
                    break loop2;
                }
                Object objY = qVar.y(i13);
                Object objX = qVar.x(i13);
                if (objY instanceof nq.p) {
                    string = (j13 >= j12 || j13 < jP0) ? (j13 >= jP0 || j13 < j12) ? "cont" : "send" : "receive";
                } else if (objY instanceof yq.m) {
                    string = (j13 >= j12 || j13 < jP0) ? (j13 >= jP0 || j13 < j12) ? "select" : "onSend" : "onReceive";
                } else if (objY instanceof e0) {
                    string = "receiveCatching";
                } else if (objY instanceof b) {
                    string = "sendBroadcast";
                } else if (objY instanceof j0) {
                    string = em.a.a("EB(", objY, ')');
                } else if (kn.l0.g(objY, pq.k.f13273h) ? true : kn.l0.g(objY, pq.k.f13274i)) {
                    string = "resuming_sender";
                } else {
                    if (!(objY == null ? true : kn.l0.g(objY, pq.k.f13272g) ? true : kn.l0.g(objY, pq.k.f13276k) ? true : kn.l0.g(objY, pq.k.f13275j) ? true : kn.l0.g(objY, pq.k.f13278m) ? true : kn.l0.g(objY, pq.k.f13277l) ? true : kn.l0.g(objY, pq.k.f13279n))) {
                        string = objY.toString();
                    }
                }
                if (objX != null) {
                    sb2.append("(" + string + StringUtil.COMMA + objX + "),");
                } else {
                    sb2.append(string + StringUtil.COMMA);
                }
            }
            qVar = (q) qVar.e();
            if (qVar == null) {
                break;
            }
            i11 = 0;
        }
        if (jq.j0.r7(sb2) == ',') {
            kn.l0.o(sb2.deleteCharAt(sb2.length() - 1), "this.deleteCharAt(index)");
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // pq.f0
    @an.h
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @a1(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object u(@os.l um.d<? super E> dVar) {
        return f0.a.i(this, dVar);
    }

    public final boolean u0(q<E> qVar, int i10, long j10) {
        Object objY;
        do {
            objY = qVar.y(i10);
            if (objY != null && objY != pq.k.f13272g) {
                if (objY == pq.k.f13271f) {
                    return true;
                }
                if (objY == pq.k.f13277l || objY == pq.k.f13279n || objY == pq.k.f13276k || objY == pq.k.f13275j) {
                    return false;
                }
                if (objY == pq.k.f13274i) {
                    return true;
                }
                return objY != pq.k.f13273h && j10 == f13249e.get(this);
            }
        } while (!qVar.t(i10, objY, pq.k.f13275j));
        a0();
        return false;
    }

    public boolean u1() {
        return t1(f13248d.get(this));
    }

    public final boolean v0(long j10, boolean z10) throws IllegalAccessException, InvocationTargetException {
        int i10 = (int) (j10 >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            X(j10 & pq.k.G);
            if (z10 && q0()) {
                return false;
            }
        } else {
            if (i10 != 3) {
                throw new IllegalStateException(h.a.a("unexpected close status: ", i10).toString());
            }
            W(j10 & pq.k.G);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public final String v1() {
        String strA;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder("S=");
        sb3.append(p0());
        sb3.append(",R=");
        sb3.append(f13249e.get(this));
        sb3.append(",B=");
        sb3.append(f13250f.get(this));
        sb3.append(",B'=");
        sb3.append(f13251g.get(this));
        sb3.append(",C=");
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13248d;
        sb3.append((int) (atomicLongFieldUpdater.get(this) >> 60));
        sb3.append(StringUtil.COMMA);
        sb2.append(sb3.toString());
        int i10 = (int) (atomicLongFieldUpdater.get(this) >> 60);
        if (i10 == 1) {
            sb2.append("CANCELLATION_STARTED,");
        } else if (i10 == 2) {
            sb2.append("CLOSED,");
        } else if (i10 == 3) {
            sb2.append("CANCELLED,");
        }
        StringBuilder sb4 = new StringBuilder("SEND_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13252i;
        sb4.append(x0.b(atomicReferenceFieldUpdater.get(this)));
        sb4.append(",RCV_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f13253n;
        sb4.append(x0.b(atomicReferenceFieldUpdater2.get(this)));
        sb2.append(sb4.toString());
        if (!C0()) {
            sb2.append(",EB_SEGM=" + x0.b(f13254p.get(this)));
        }
        sb2.append("  ");
        List listO = nm.y.O(atomicReferenceFieldUpdater2.get(this), atomicReferenceFieldUpdater.get(this), f13254p.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listO) {
            if (((q) obj) != pq.k.f13266a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j10 = ((q) next).f17877c;
            do {
                Object next2 = it.next();
                long j11 = ((q) next2).f17877c;
                if (j10 > j11) {
                    next = next2;
                    j10 = j11;
                }
            } while (it.hasNext());
        }
        q qVar = (q) next;
        do {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(x0.b(qVar));
            sb5.append("=[");
            sb5.append(qVar.h() ? "*" : "");
            sb5.append(qVar.f17877c);
            sb5.append(",prev=");
            q qVar2 = (q) qVar.g();
            sb5.append(qVar2 != null ? x0.b(qVar2) : null);
            sb5.append(StringUtil.COMMA);
            sb2.append(sb5.toString());
            int i11 = pq.k.f13267b;
            for (int i12 = 0; i12 < i11; i12++) {
                Object objY = qVar.y(i12);
                Object objX = qVar.x(i12);
                if (objY instanceof nq.p) {
                    strA = "cont";
                } else if (objY instanceof yq.m) {
                    strA = "select";
                } else if (objY instanceof e0) {
                    strA = "receiveCatching";
                } else if (objY instanceof b) {
                    strA = "send(broadcast)";
                } else {
                    strA = objY instanceof j0 ? em.a.a("EB(", objY, ')') : String.valueOf(objY);
                }
                sb2.append("[" + i12 + "]=(" + strA + StringUtil.COMMA + objX + "),");
            }
            StringBuilder sb6 = new StringBuilder("next=");
            q qVar3 = (q) qVar.e();
            sb6.append(qVar3 != null ? x0.b(qVar3) : null);
            sb6.append("]  ");
            sb2.append(sb6.toString());
            qVar = (q) qVar.e();
        } while (qVar != null);
        return sb2.toString();
    }

    @Override // pq.g0
    @os.l
    public Object w(E e10) throws IllegalAccessException, InvocationTargetException {
        q<E> qVar;
        p.b bVar;
        l2 l2Var;
        if (t1(f13248d.get(this))) {
            p.f13308b.getClass();
            return p.f13309c;
        }
        Object obj = pq.k.f13277l;
        q<E> qVar2 = (q) f13252i.get(this);
        while (true) {
            long andIncrement = f13248d.getAndIncrement(this);
            long j10 = andIncrement & pq.k.G;
            boolean zV0 = v0(andIncrement, false);
            int i10 = pq.k.f13267b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (qVar2.f17877c != j11) {
                q<E> qVarD0 = d0(j11, qVar2);
                if (qVarD0 != null) {
                    qVar = qVarD0;
                } else if (zV0) {
                    break;
                }
            } else {
                qVar = qVar2;
            }
            int iD1 = D1(qVar, i11, e10, j10, obj, zV0);
            if (iD1 == 0) {
                qVar.b();
                bVar = p.f13308b;
                l2Var = l2.f10208a;
            } else if (iD1 == 1) {
                bVar = p.f13308b;
                l2Var = l2.f10208a;
            } else {
                if (iD1 == 2) {
                    if (zV0) {
                        qVar.r();
                        break;
                    }
                    b4 b4Var = obj instanceof b4 ? (b4) obj : null;
                    if (b4Var != null) {
                        U0(b4Var, qVar, i11);
                    }
                    qVar.r();
                    p.f13308b.getClass();
                    return p.f13309c;
                }
                if (iD1 == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iD1 == 4) {
                    if (j10 >= f13249e.get(this)) {
                        break;
                    }
                    qVar.b();
                    break;
                }
                if (iD1 == 5) {
                    qVar.b();
                }
                qVar2 = qVar;
            }
            bVar.getClass();
            return p.c(l2Var);
        }
        return p.f13308b.a(o0());
    }

    public final boolean w1(Object obj, E e10) {
        if (obj instanceof yq.m) {
            return ((yq.m) obj).i(this, e10);
        }
        if (obj instanceof e0) {
            kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            e0 e0Var = (e0) obj;
            nq.q<p<? extends E>> qVar = e0Var.f13242a;
            p.f13308b.getClass();
            p pVar = new p(p.c(e10));
            jn.l<E, l2> lVar = this.f13258b;
            return pq.k.F(qVar, pVar, lVar != null ? new l0.a(lVar, e10, e0Var.f13242a.getContext()) : null);
        }
        if (obj instanceof a) {
            kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).k(e10);
        }
        if (!(obj instanceof nq.p)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        nq.p pVar2 = (nq.p) obj;
        jn.l<E, l2> lVar2 = this.f13258b;
        return pq.k.F(pVar2, e10, lVar2 != null ? new l0.a(lVar2, e10, pVar2.getContext()) : null);
    }

    @Override // pq.f0
    @os.l
    public yq.g<E> x() {
        c cVar = c.INSTANCE;
        kn.l0.n(cVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        jn.q qVar = (jn.q) u1.q(cVar, 3);
        d dVar = d.INSTANCE;
        kn.l0.n(dVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new yq.h(this, qVar, (jn.q) u1.q(dVar, 3), this.f13259c);
    }

    public final boolean x0(long j10) {
        return v0(j10, true);
    }

    public final boolean x1(Object obj, q<E> qVar, int i10) {
        if (obj instanceof nq.p) {
            kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return pq.k.G((nq.p) obj, l2.f10208a, null, 2, null);
        }
        if (obj instanceof yq.m) {
            kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            yq.r rVarK = ((yq.l) obj).K(this, l2.f10208a);
            if (rVarK == yq.r.REREGISTER) {
                qVar.B(i10, null);
            }
            return rVarK == yq.r.SUCCESSFUL;
        }
        if (obj instanceof b) {
            return pq.k.G(((b) obj).f13263a, Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final void y1(AtomicLongFieldUpdater atomicLongFieldUpdater, jn.l<? super Long, Long> lVar, Object obj) {
        long j10;
        do {
            j10 = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j10, lVar.invoke(Long.valueOf(j10)).longValue()));
    }

    public final boolean z0(long j10) {
        return v0(j10, false);
    }

    public final boolean z1(q<E> qVar, int i10, long j10) {
        Object objY = qVar.y(i10);
        if (!(objY instanceof b4) || j10 < f13249e.get(this) || !qVar.t(i10, objY, pq.k.f13274i)) {
            return A1(qVar, i10, j10);
        }
        if (x1(objY, qVar, i10)) {
            qVar.C(i10, pq.k.f13271f);
            return true;
        }
        qVar.C(i10, pq.k.f13277l);
        qVar.z(i10, false);
        return false;
    }

    public /* synthetic */ j(int i10, jn.l lVar, int i11, kn.w wVar) {
        this(i10, (i11 & 2) != 0 ? null : lVar);
    }
}
