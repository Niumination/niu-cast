package xq;

import in.x;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kn.k1;
import kn.l0;
import kn.r1;
import kn.w;
import lm.l2;
import nq.x0;
import vq.p0;
import vq.u0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 7 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1033:1\n285#1:1036\n283#1:1037\n283#1:1038\n285#1:1039\n280#1:1045\n281#1,5:1046\n291#1:1052\n283#1:1053\n284#1:1054\n283#1:1060\n284#1:1061\n280#1:1062\n288#1:1063\n283#1:1064\n283#1:1067\n284#1:1068\n285#1:1069\n93#2:1034\n93#2:1051\n1#3:1035\n28#4,4:1040\n28#4,4:1055\n20#5:1044\n20#5:1059\n90#6:1065\n610#7:1066\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n281#1:1036\n288#1:1037\n289#1:1038\n298#1:1039\n347#1:1045\n375#1:1046,5\n398#1:1052\n445#1:1053\n446#1:1054\n482#1:1060\n483#1:1061\n489#1:1062\n498#1:1063\n498#1:1064\n576#1:1067\n577#1:1068\n578#1:1069\n119#1:1034\n395#1:1051\n347#1:1040,4\n478#1:1055,4\n347#1:1044\n478#1:1059\n515#1:1065\n522#1:1066\n*E\n"})
public final class a implements Executor, Closeable {
    public static final int H = 21;
    public static final long I = 2097151;
    public static final long J = 4398044413952L;
    public static final int K = 42;
    public static final long L = 9223367638808264704L;
    public static final int M = 1;
    public static final int N = 2097150;
    public static final long O = 2097151;
    public static final long P = -2097152;
    public static final long Q = 2097152;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final C0534a f20470i = new C0534a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final AtomicLongFieldUpdater f20471n = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final AtomicLongFieldUpdater f20472p = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f20473v = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @in.f
    @os.l
    public static final u0 f20474w = new u0("NOT_IN_STACK");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f20475x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f20476y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f20477z = 1;

    @x
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    public final int f20478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    public final int f20479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    public final long f20480c;

    @x
    private volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @in.f
    @os.l
    public final String f20481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @in.f
    @os.l
    public final f f20482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @in.f
    @os.l
    public final f f20483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @in.f
    @os.l
    public final p0<c> f20484g;

    @x
    private volatile long parkedWorkersStack;

    /* JADX INFO: renamed from: xq.a$a, reason: collision with other inner class name */
    public static final class C0534a {
        public C0534a() {
        }

        public C0534a(w wVar) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20485a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f20485a = iArr;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i10, int i11, long j10, @os.l String str) {
        this.f20478a = i10;
        this.f20479b = i11;
        this.f20480c = j10;
        this.f20481d = str;
        if (i10 < 1) {
            throw new IllegalArgumentException(k.b.a("Core pool size ", i10, " should be at least 1").toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(e0.a.a("Max pool size ", i11, " should be greater than or equals to core pool size ", i10).toString());
        }
        if (i11 > 2097150) {
            throw new IllegalArgumentException(k.b.a("Max pool size ", i11, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j10 <= 0) {
            throw new IllegalArgumentException(j1.g.a("Idle worker keep alive time ", j10, " must be positive").toString());
        }
        this.f20482e = new f(false);
        this.f20483f = new f(false);
        this.f20484g = new p0<>((i10 + 1) * 2);
        this.controlState = ((long) i10) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void A(a aVar, Runnable runnable, l lVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = o.f20528i;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.y(runnable, lVar, z10);
    }

    public static /* synthetic */ boolean O0(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f20472p.get(aVar);
        }
        return aVar.J0(j10);
    }

    public final int E() {
        return (int) ((f20472p.get(this) & L) >> 42);
    }

    public final boolean F0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f20472p;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) ((L & j10) >> 42)) == 0) {
                return false;
            }
        } while (!f20472p.compareAndSet(this, j10, j10 - 4398046511104L));
        return true;
    }

    public final boolean J0(long j10) {
        int i10 = ((int) (2097151 & j10)) - ((int) ((j10 & J) >> 21));
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 < this.f20478a) {
            int iK = k();
            if (iK == 1 && this.f20478a > 1) {
                k();
            }
            if (iK > 0) {
                return true;
            }
        }
        return false;
    }

    public final int O() {
        return (int) (f20472p.get(this) & 2097151);
    }

    public final boolean P0() {
        c cVarJ0;
        do {
            cVarJ0 = j0();
            if (cVarJ0 == null) {
                return false;
            }
        } while (!c.m().compareAndSet(cVarJ0, -1, 0));
        LockSupport.unpark(cVarJ0);
        return true;
    }

    public final long b0() {
        return f20472p.addAndGet(this, 2097152L);
    }

    public final boolean c(k kVar) {
        return kVar.f20517b.q() == 1 ? this.f20483f.a(kVar) : this.f20482e.a(kVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        u0(10000L);
    }

    public final int d(long j10) {
        return (int) ((j10 & L) >> 42);
    }

    public final int e0() {
        return (int) (f20472p.incrementAndGet(this) & 2097151);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@os.l Runnable runnable) {
        A(this, runnable, null, false, 6, null);
    }

    public final void f0(AtomicLongFieldUpdater atomicLongFieldUpdater, jn.l<? super Long, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    public final int g0(c cVar) {
        Object objJ = cVar.j();
        while (objJ != f20474w) {
            if (objJ == null) {
                return 0;
            }
            c cVar2 = (c) objJ;
            int i10 = cVar2.i();
            if (i10 != 0) {
                return i10;
            }
            objJ = cVar2.j();
        }
        return -1;
    }

    public final int h(long j10) {
        return (int) ((j10 & J) >> 21);
    }

    public final boolean isTerminated() {
        return f20473v.get(this) != 0;
    }

    public final c j0() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f20471n;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c cVarB = this.f20484g.b((int) (2097151 & j10));
            if (cVarB == null) {
                return null;
            }
            long j11 = (2097152 + j10) & P;
            int iG0 = g0(cVarB);
            if (iG0 >= 0 && f20471n.compareAndSet(this, j10, ((long) iG0) | j11)) {
                cVarB.w(f20474w);
                return cVarB;
            }
        }
    }

    public final int k() {
        synchronized (this.f20484g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f20472p;
                long j10 = atomicLongFieldUpdater.get(this);
                int i10 = (int) (j10 & 2097151);
                int i11 = i10 - ((int) ((j10 & J) >> 21));
                if (i11 < 0) {
                    i11 = 0;
                }
                if (i11 >= this.f20478a) {
                    return 0;
                }
                if (i10 >= this.f20479b) {
                    return 0;
                }
                int i12 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i12 <= 0 || this.f20484g.b(i12) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i12);
                this.f20484g.c(i12, cVar);
                if (i12 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i13 = i11 + 1;
                cVar.start();
                return i13;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean k0(@os.l c cVar) {
        long j10;
        long j11;
        int i10;
        if (cVar.j() != f20474w) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f20471n;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            j11 = (2097152 + j10) & P;
            i10 = cVar.i();
            cVar.w(this.f20484g.b((int) (2097151 & j10)));
        } while (!f20471n.compareAndSet(this, j10, j11 | ((long) i10)));
        return true;
    }

    public final void l0(@os.l c cVar, int i10, int i11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f20471n;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int iG0 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & P;
            if (iG0 == i10) {
                iG0 = i11 == 0 ? g0(cVar) : i11;
            }
            if (iG0 >= 0 && f20471n.compareAndSet(this, j10, j11 | ((long) iG0))) {
                return;
            }
        }
    }

    @os.l
    public final k n(@os.l Runnable runnable, @os.l l lVar) {
        long jA = o.f20525f.a();
        if (!(runnable instanceof k)) {
            return new n(runnable, jA, lVar);
        }
        k kVar = (k) runnable;
        kVar.f20516a = jA;
        kVar.f20517b = lVar;
        return kVar;
    }

    public final int o(long j10) {
        return (int) (j10 & 2097151);
    }

    public final c p() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !l0.g(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public final long p0() {
        return f20472p.addAndGet(this, 4398046511104L);
    }

    public final void q() {
        f20472p.addAndGet(this, P);
    }

    public final void q0(@os.l k kVar) {
        nq.b bVarB;
        try {
            kVar.run();
            bVarB = nq.c.b();
            if (bVarB == null) {
                return;
            }
        } catch (Throwable th2) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
                bVarB = nq.c.b();
                if (bVarB == null) {
                    return;
                }
            } catch (Throwable th3) {
                nq.b bVarB2 = nq.c.b();
                if (bVarB2 != null) {
                    bVarB2.f();
                }
                throw th3;
            }
        }
        bVarB.f();
    }

    public final int t() {
        return (int) (f20472p.getAndDecrement(this) & 2097151);
    }

    @os.l
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f20484g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iA; i15++) {
            c cVarB = this.f20484g.b(i15);
            if (cVarB != null) {
                int iF = cVarB.f20487a.f();
                int i16 = b.f20485a[cVarB.f20489c.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iF);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(iF);
                    sb3.append(y5.a.J);
                    arrayList.add(sb3.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (iF > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(iF);
                        sb4.append(kl.f.f9273f);
                        arrayList.add(sb4.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = f20472p.get(this);
        return this.f20481d + '@' + x0.b(this) + "[Pool Size {core = " + this.f20478a + ", max = " + this.f20479b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f20482e.c() + ", global blocking queue size = " + this.f20483f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((J & j10) >> 21)) + ", CPUs acquired = " + (this.f20478a - ((int) ((L & j10) >> 42))) + "}]";
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    public final void u0(long j10) throws InterruptedException {
        int i10;
        k kVarH;
        if (f20473v.compareAndSet(this, 0, 1)) {
            c cVarP = p();
            synchronized (this.f20484g) {
                i10 = (int) (f20472p.get(this) & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    c cVarB = this.f20484g.b(i11);
                    l0.m(cVarB);
                    c cVar = cVarB;
                    if (cVar != cVarP) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        cVar.f20487a.g(this.f20483f);
                    }
                    if (i11 == i10) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            this.f20483f.b();
            this.f20482e.b();
            while (true) {
                if (cVarP == null) {
                    kVarH = this.f20482e.h();
                    if (kVarH == null && (kVarH = this.f20483f.h()) == null) {
                        break;
                    }
                } else {
                    kVarH = cVarP.h(true);
                    if (kVarH == null) {
                        kVarH = this.f20482e.h();
                        if (kVarH == null) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                q0(kVarH);
            }
            if (cVarP != null) {
                cVarP.z(d.TERMINATED);
            }
            f20471n.set(this, 0L);
            f20472p.set(this, 0L);
        }
    }

    public final void v0(long j10, boolean z10) {
        if (z10 || P0() || J0(j10)) {
            return;
        }
        P0();
    }

    public final void w0() {
        if (P0() || O0(this, 0L, 1, null)) {
            return;
        }
        P0();
    }

    public final void y(@os.l Runnable runnable, @os.l l lVar, boolean z10) {
        nq.b bVarB = nq.c.b();
        if (bVarB != null) {
            bVarB.e();
        }
        k kVarN = n(runnable, lVar);
        boolean z11 = false;
        boolean z12 = kVarN.f20517b.q() == 1;
        long jAddAndGet = z12 ? f20472p.addAndGet(this, 2097152L) : 0L;
        c cVarP = p();
        k kVarY0 = y0(cVarP, kVarN, z10);
        if (kVarY0 != null && !c(kVarY0)) {
            throw new RejectedExecutionException(j.c.a(new StringBuilder(), this.f20481d, " was terminated"));
        }
        if (z10 && cVarP != null) {
            z11 = true;
        }
        if (z12) {
            v0(jAddAndGet, z11);
        } else {
            if (z11) {
                return;
            }
            w0();
        }
    }

    public final k y0(c cVar, k kVar, boolean z10) {
        if (cVar == null || cVar.f20489c == d.TERMINATED) {
            return kVar;
        }
        if (kVar.f20517b.q() == 0 && cVar.f20489c == d.BLOCKING) {
            return kVar;
        }
        cVar.f20493g = true;
        return cVar.f20487a.a(kVar, z10);
    }

    @r1({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1033:1\n298#2:1034\n285#2:1035\n299#2,4:1036\n304#2:1040\n294#2,2:1041\n294#2,2:1045\n280#2:1052\n289#2:1053\n283#2:1054\n280#2:1055\n1#3:1043\n90#4:1044\n28#5,4:1047\n20#6:1051\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n665#1:1034\n665#1:1035\n665#1:1036,4\n679#1:1040\n753#1:1041,2\n807#1:1045,2\n855#1:1052\n881#1:1053\n881#1:1054\n963#1:1055\n790#1:1044\n851#1:1047,4\n851#1:1051\n*E\n"})
    public final class c extends Thread {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @os.l
        public static final AtomicIntegerFieldUpdater f20486n = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        @os.l
        public final q f20487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final k1.h<k> f20488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @in.f
        @os.l
        public d f20489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f20490d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f20491e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f20492f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @in.f
        public boolean f20493g;
        private volatile int indexInArray;

        @os.m
        private volatile Object nextParkedWorker;

        @x
        private volatile int workerCtl;

        public c() {
            setDaemon(true);
            this.f20487a = new q();
            this.f20488b = new k1.h<>();
            this.f20489c = d.DORMANT;
            this.nextParkedWorker = a.f20474w;
            this.f20492f = rn.f.Default.nextInt();
        }

        @os.l
        public static final AtomicIntegerFieldUpdater m() {
            return f20486n;
        }

        public final k A(int i10) {
            int i11 = (int) (a.f20472p.get(a.this) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int iQ = q(i11);
            a aVar = a.this;
            long jMin = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                iQ++;
                if (iQ > i11) {
                    iQ = 1;
                }
                c cVarB = aVar.f20484g.b(iQ);
                if (cVarB != null && cVarB != this) {
                    long jP = cVarB.f20487a.p(i10, this.f20488b);
                    if (jP == -1) {
                        k1.h<k> hVar = this.f20488b;
                        k kVar = hVar.element;
                        hVar.element = null;
                        return kVar;
                    }
                    if (jP > 0) {
                        jMin = Math.min(jMin, jP);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f20491e = jMin;
            return null;
        }

        public final void B() {
            a aVar = a.this;
            synchronized (aVar.f20484g) {
                try {
                    if (aVar.isTerminated()) {
                        return;
                    }
                    AtomicLongFieldUpdater atomicLongFieldUpdater = a.f20472p;
                    if (((int) (atomicLongFieldUpdater.get(aVar) & 2097151)) <= aVar.f20478a) {
                        return;
                    }
                    if (f20486n.compareAndSet(this, -1, 1)) {
                        int i10 = this.indexInArray;
                        v(0);
                        aVar.l0(this, i10, 0);
                        int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(aVar) & 2097151);
                        if (andDecrement != i10) {
                            c cVarB = aVar.f20484g.b(andDecrement);
                            l0.m(cVarB);
                            c cVar = cVarB;
                            aVar.f20484g.c(i10, cVar);
                            cVar.v(i10);
                            aVar.l0(cVar, andDecrement, i10);
                        }
                        aVar.f20484g.c(andDecrement, null);
                        l2 l2Var = l2.f10208a;
                        this.f20489c = d.TERMINATED;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final void b(int i10) {
            if (i10 == 0) {
                return;
            }
            a.f20472p.addAndGet(a.this, a.P);
            if (this.f20489c != d.TERMINATED) {
                this.f20489c = d.DORMANT;
            }
        }

        public final void c(int i10) {
            if (i10 != 0 && z(d.BLOCKING)) {
                a.this.w0();
            }
        }

        public final void d(k kVar) {
            int iQ = kVar.f20517b.q();
            n(iQ);
            c(iQ);
            a.this.q0(kVar);
            b(iQ);
        }

        public final k e(boolean z10) {
            k kVarS;
            k kVarS2;
            if (z10) {
                boolean z11 = q(a.this.f20478a * 2) == 0;
                if (z11 && (kVarS2 = s()) != null) {
                    return kVarS2;
                }
                k kVarH = this.f20487a.h();
                if (kVarH != null) {
                    return kVarH;
                }
                if (!z11 && (kVarS = s()) != null) {
                    return kVarS;
                }
            } else {
                k kVarS3 = s();
                if (kVarS3 != null) {
                    return kVarS3;
                }
            }
            return A(3);
        }

        public final k f() {
            k kVarM = this.f20487a.m(true);
            if (kVarM != null) {
                return kVarM;
            }
            k kVarH = a.this.f20483f.h();
            return kVarH == null ? A(1) : kVarH;
        }

        public final k g() {
            k kVarM = this.f20487a.m(false);
            if (kVarM != null) {
                return kVarM;
            }
            k kVarH = a.this.f20483f.h();
            return kVarH == null ? A(2) : kVarH;
        }

        @os.m
        public final k h(boolean z10) {
            return x() ? e(z10) : f();
        }

        public final int i() {
            return this.indexInArray;
        }

        @os.m
        public final Object j() {
            return this.nextParkedWorker;
        }

        @os.l
        public final a k() {
            return a.this;
        }

        public final int l() {
            return this.workerCtl;
        }

        public final void n(int i10) {
            this.f20490d = 0L;
            if (this.f20489c == d.PARKING) {
                this.f20489c = d.BLOCKING;
            }
        }

        public final boolean o() {
            return this.nextParkedWorker != a.f20474w;
        }

        public final boolean p() {
            return this.f20489c == d.BLOCKING;
        }

        public final int q(int i10) {
            int i11 = this.f20492f;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f20492f = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i15 & i14 : (Integer.MAX_VALUE & i14) % i10;
        }

        public final void r() {
            if (this.f20490d == 0) {
                this.f20490d = System.nanoTime() + a.this.f20480c;
            }
            LockSupport.parkNanos(a.this.f20480c);
            if (System.nanoTime() - this.f20490d >= 0) {
                this.f20490d = 0L;
                B();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            u();
        }

        public final k s() {
            if (q(2) == 0) {
                k kVarH = a.this.f20482e.h();
                return kVarH != null ? kVarH : a.this.f20483f.h();
            }
            k kVarH2 = a.this.f20483f.h();
            return kVarH2 != null ? kVarH2 : a.this.f20482e.h();
        }

        public final long t() {
            boolean z10 = this.f20489c == d.CPU_ACQUIRED;
            k kVarG = z10 ? g() : f();
            if (kVarG == null) {
                long j10 = this.f20491e;
                if (j10 == 0) {
                    return -1L;
                }
                return j10;
            }
            a.this.q0(kVarG);
            if (!z10) {
                a.f20472p.addAndGet(a.this, a.P);
            }
            return 0L;
        }

        public final void u() {
            loop0: while (true) {
                boolean z10 = false;
                while (true) {
                    if (a.this.isTerminated() || this.f20489c == d.TERMINATED) {
                        break loop0;
                    }
                    k kVarH = h(this.f20493g);
                    if (kVarH != null) {
                        this.f20491e = 0L;
                        d(kVarH);
                        break;
                    }
                    this.f20493g = false;
                    if (this.f20491e == 0) {
                        y();
                    } else {
                        if (z10) {
                            z(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f20491e);
                            this.f20491e = 0L;
                            break;
                        }
                        z10 = true;
                    }
                }
            }
            z(d.TERMINATED);
        }

        public final void v(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.this.f20481d);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void w(@os.m Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean x() {
            long j10;
            if (this.f20489c == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = a.f20472p;
            do {
                j10 = atomicLongFieldUpdater.get(aVar);
                if (((int) ((a.L & j10) >> 42)) == 0) {
                    return false;
                }
            } while (!a.f20472p.compareAndSet(aVar, j10, j10 - 4398046511104L));
            this.f20489c = d.CPU_ACQUIRED;
            return true;
        }

        public final void y() {
            if (!o()) {
                a.this.k0(this);
                return;
            }
            f20486n.set(this, -1);
            while (o() && f20486n.get(this) == -1 && !a.this.isTerminated() && this.f20489c != d.TERMINATED) {
                z(d.PARKING);
                Thread.interrupted();
                r();
            }
        }

        public final boolean z(@os.l d dVar) {
            d dVar2 = this.f20489c;
            boolean z10 = dVar2 == d.CPU_ACQUIRED;
            if (z10) {
                a.f20472p.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f20489c = dVar;
            }
            return z10;
        }

        public c(a aVar, int i10) {
            this();
            v(i10);
        }
    }

    public /* synthetic */ a(int i10, int i11, long j10, String str, int i12, w wVar) {
        this(i10, i11, (i12 & 4) != 0 ? o.f20524e : j10, (i12 & 8) != 0 ? o.f20520a : str);
    }
}
