package af;

import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class x2 implements b0 {
    public static final ze.k1 E;
    public static final ze.k1 F;
    public static final ze.q2 G;
    public static final Random H;
    public final /* synthetic */ ze.r1 A;
    public final /* synthetic */ ze.f B;
    public final /* synthetic */ ze.y C;
    public final /* synthetic */ k0 D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.r1 f683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ze.v2 f685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f686d;
    public final ze.p1 e;
    public final g5 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o1 f687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o5.c f690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f5 f693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t1 f694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile b5 f695o;
    public final AtomicBoolean p;
    public final AtomicInteger q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f696r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public qf.c f697s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f698t;
    public d0 u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d2 f699v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d2 f700w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f701x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ze.q2 f702y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f703z;

    static {
        ze.p2 p2Var = ze.p1.f11398d;
        BitSet bitSet = ze.m1.f11379d;
        E = new ze.k1("grpc-previous-rpc-attempts", p2Var);
        F = new ze.k1("grpc-retry-pushback-ms", p2Var);
        G = ze.q2.f.h("Stream thrown away because RetriableStream committed");
        H = new Random();
    }

    public x2(k0 k0Var, ze.r1 r1Var, ze.p1 p1Var, ze.f fVar, g5 g5Var, o1 o1Var, ze.y yVar) {
        this.D = k0Var;
        this.A = r1Var;
        this.B = fVar;
        this.C = yVar;
        j3 j3Var = (j3) k0Var.f375b;
        o5.c cVar = j3Var.U;
        long j8 = j3Var.V;
        long j10 = j3Var.W;
        Executor executor = fVar.f11348b;
        executor = executor == null ? j3Var.f352h : executor;
        ScheduledExecutorService scheduledExecutorService = j3Var.f.f520a.f1560d;
        f5 f5Var = (f5) k0Var.f374a;
        this.f685c = new ze.v2(new q4());
        this.f689i = new Object();
        this.f694n = new t1(0);
        this.f695o = new b5(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
        this.p = new AtomicBoolean();
        this.q = new AtomicInteger();
        this.f696r = new AtomicInteger();
        this.f683a = r1Var;
        this.f690j = cVar;
        this.f691k = j8;
        this.f692l = j10;
        this.f684b = executor;
        this.f686d = scheduledExecutorService;
        this.e = p1Var;
        this.f = g5Var;
        if (g5Var != null) {
            this.f701x = g5Var.f294b;
        }
        this.f687g = o1Var;
        v8.c("Should not provide both retryPolicy and hedgingPolicy", g5Var == null || o1Var == null);
        this.f688h = o1Var != null;
        this.f693m = f5Var;
    }

    public static void l(x2 x2Var, Integer num) {
        x2Var.getClass();
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            x2Var.r();
            return;
        }
        synchronized (x2Var.f689i) {
            try {
                d2 d2Var = x2Var.f700w;
                if (d2Var != null) {
                    d2Var.f213a = true;
                    ScheduledFuture scheduledFuture = (ScheduledFuture) d2Var.f215c;
                    d2 d2Var2 = new d2(x2Var.f689i);
                    x2Var.f700w = d2Var2;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    d2Var2.g(x2Var.f686d.schedule(new e(22, x2Var, d2Var2), num.intValue(), TimeUnit.MILLISECONDS));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // af.i6
    public final void a(ze.o oVar) {
        p(new s4(oVar, 0));
    }

    @Override // af.b0
    public final void b(int i8) {
        p(new u4(i8, 1));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0068 A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:27:0x0047, B:29:0x0057, B:31:0x005b, B:35:0x0068, B:38:0x0074), top: B:50:0x0047 }] */
    @Override // af.b0
    public final void c(d0 d0Var) {
        ze.q2 q2Var;
        d2 d2Var;
        this.u = d0Var;
        r rVar = ((j3) this.D.f375b).E;
        synchronized (rVar.f538a) {
            try {
                q2Var = (ze.q2) rVar.f540c;
                d2Var = null;
                if (q2Var == null) {
                    ((HashSet) rVar.f539b).add(this);
                    q2Var = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (q2Var != null) {
            h(q2Var);
            return;
        }
        synchronized (this.f689i) {
            this.f695o.f187b.add(new a5(this));
        }
        e5 e5VarO = o(0, false);
        if (e5VarO == null) {
            return;
        }
        if (this.f688h) {
            synchronized (this.f689i) {
                try {
                    this.f695o = this.f695o.a(e5VarO);
                    if (s(this.f695o)) {
                        f5 f5Var = this.f693m;
                        if (f5Var == null) {
                            d2Var = new d2(this.f689i);
                            this.f700w = d2Var;
                        } else {
                            if (f5Var.f288d.get() > f5Var.f286b) {
                                d2Var = new d2(this.f689i);
                                this.f700w = d2Var;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            if (d2Var != null) {
                d2Var.g(this.f686d.schedule(new e(22, this, d2Var), this.f687g.f481b, TimeUnit.NANOSECONDS));
            }
        }
        q(e5VarO);
    }

    @Override // af.b0
    public final void d(ze.b0 b0Var) {
        p(new s4(b0Var, 2));
    }

    @Override // af.i6
    public final void e(int i8) {
        b5 b5Var = this.f695o;
        if (b5Var.f186a) {
            b5Var.f.f245a.e(i8);
        } else {
            p(new u4(i8, 2));
        }
    }

    @Override // af.b0
    public final void f(int i8) {
        p(new u4(i8, 0));
    }

    @Override // af.i6
    public final void flush() {
        b5 b5Var = this.f695o;
        if (b5Var.f186a) {
            b5Var.f.f245a.flush();
        } else {
            p(new t4(0));
        }
    }

    @Override // af.i6
    public final void g() {
        p(new t4(2));
    }

    @Override // af.b0
    public final void h(ze.q2 q2Var) {
        e5 e5Var;
        e5 e5Var2 = new e5(0);
        e5Var2.f245a = new b4();
        r4 r4VarN = n(e5Var2);
        if (r4VarN != null) {
            synchronized (this.f689i) {
                this.f695o = this.f695o.e(e5Var2);
            }
            r4VarN.run();
            t(q2Var, c0.PROCESSED, new ze.p1());
            return;
        }
        synchronized (this.f689i) {
            try {
                if (this.f695o.f188c.contains(this.f695o.f)) {
                    e5Var = this.f695o.f;
                } else {
                    this.f702y = q2Var;
                    e5Var = null;
                }
                b5 b5Var = this.f695o;
                this.f695o = new b5(b5Var.f187b, b5Var.f188c, b5Var.f189d, b5Var.f, true, b5Var.f186a, b5Var.f191h, b5Var.e);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (e5Var != null) {
            e5Var.f245a.h(q2Var);
        }
    }

    @Override // af.i6
    public final void i(gf.a aVar) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    @Override // af.i6
    public final boolean isReady() {
        Iterator it = this.f695o.f188c.iterator();
        while (it.hasNext()) {
            if (((e5) it.next()).f245a.isReady()) {
                return true;
            }
        }
        return false;
    }

    @Override // af.b0
    public final void j(t1 t1Var) {
        b5 b5Var;
        synchronized (this.f689i) {
            t1Var.a(this.f694n, "closed");
            b5Var = this.f695o;
        }
        if (b5Var.f != null) {
            t1 t1Var2 = new t1(0);
            b5Var.f.f245a.j(t1Var2);
            t1Var.a(t1Var2, "committed");
            return;
        }
        t1 t1Var3 = new t1(0);
        for (e5 e5Var : b5Var.f188c) {
            t1 t1Var4 = new t1(0);
            e5Var.f245a.j(t1Var4);
            t1Var3.f594b.add(String.valueOf(t1Var4));
        }
        t1Var.a(t1Var3, "open");
    }

    @Override // af.b0
    public final void k() {
        p(new t4(1));
    }

    @Override // af.b0
    public final void m(ze.z zVar) {
        p(new s4(zVar, 1));
    }

    public final r4 n(e5 e5Var) {
        Collection collectionEmptyList;
        boolean z2;
        List list;
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        synchronized (this.f689i) {
            try {
                if (this.f695o.f != null) {
                    return null;
                }
                Collection collection = this.f695o.f188c;
                b5 b5Var = this.f695o;
                v8.n(b5Var.f == null, "Already committed");
                if (b5Var.f188c.contains(e5Var)) {
                    list = null;
                    collectionEmptyList = Collections.singleton(e5Var);
                    z2 = true;
                } else {
                    collectionEmptyList = Collections.emptyList();
                    z2 = false;
                    list = b5Var.f187b;
                }
                this.f695o = new b5(list, collectionEmptyList, b5Var.f189d, e5Var, b5Var.f190g, z2, b5Var.f191h, b5Var.e);
                ((AtomicLong) this.f690j.f8405a).addAndGet(-this.f698t);
                d2 d2Var = this.f699v;
                if (d2Var != null) {
                    d2Var.f213a = true;
                    ScheduledFuture scheduledFuture3 = (ScheduledFuture) d2Var.f215c;
                    this.f699v = null;
                    scheduledFuture = scheduledFuture3;
                } else {
                    scheduledFuture = null;
                }
                d2 d2Var2 = this.f700w;
                if (d2Var2 != null) {
                    d2Var2.f213a = true;
                    ScheduledFuture scheduledFuture4 = (ScheduledFuture) d2Var2.f215c;
                    this.f700w = null;
                    scheduledFuture2 = scheduledFuture4;
                } else {
                    scheduledFuture2 = null;
                }
                return new r4(this, collection, e5Var, scheduledFuture, scheduledFuture2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final e5 o(int i8, boolean z2) {
        AtomicInteger atomicInteger;
        int i9;
        do {
            atomicInteger = this.f696r;
            i9 = atomicInteger.get();
            if (i9 < 0) {
                return null;
            }
        } while (!atomicInteger.compareAndSet(i9, i9 + 1));
        e5 e5Var = new e5(i8);
        w4 w4Var = new w4(new y4(this, e5Var));
        ze.p1 p1Var = new ze.p1();
        p1Var.d(this.e);
        if (i8 > 0) {
            p1Var.f(E, String.valueOf(i8));
        }
        ze.f fVar = this.B;
        fVar.getClass();
        List list = fVar.e;
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(w4Var);
        ze.d dVarB = ze.f.b(fVar);
        dVarB.e = Collections.unmodifiableList(arrayList);
        ze.f fVar2 = new ze.f(dVarB);
        ze.n[] nVarArrD = l1.d(fVar2, p1Var, i8, z2);
        ze.r1 r1Var = this.A;
        e0 e0VarA = this.D.a(new i4(r1Var, p1Var, fVar2));
        ze.y yVar = this.C;
        ze.y yVarC = yVar.c();
        try {
            b0 b0VarF = e0VarA.f(r1Var, p1Var, fVar2, nVarArrD);
            yVar.k(yVarC);
            e5Var.f245a = b0VarF;
            return e5Var;
        } catch (Throwable th2) {
            yVar.k(yVarC);
            throw th2;
        }
    }

    public final void p(x4 x4Var) {
        Collection collection;
        synchronized (this.f689i) {
            try {
                if (!this.f695o.f186a) {
                    this.f695o.f187b.add(x4Var);
                }
                collection = this.f695o.f188c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            x4Var.a((e5) it.next());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008b, code lost:
    
        r0 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
    
        if (r0.hasNext() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0095, code lost:
    
        r4 = (af.x4) r0.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
    
        if ((r4 instanceof af.a5) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a2, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        r4 = r8.f695o;
        r5 = r4.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a7, code lost:
    
        if (r5 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a9, code lost:
    
        if (r5 == r9) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ae, code lost:
    
        if (r4.f190g == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(af.e5 r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L4:
            java.lang.Object r4 = r8.f689i
            monitor-enter(r4)
            af.b5 r5 = r8.f695o     // Catch: java.lang.Throwable -> L11
            af.e5 r6 = r5.f     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L14
            if (r6 == r9) goto L14
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L38
        L11:
            r8 = move-exception
            goto Lb3
        L14:
            boolean r6 = r5.f190g     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L1a
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L38
        L1a:
            java.util.List r6 = r5.f187b     // Catch: java.lang.Throwable -> L11
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L11
            if (r0 != r6) goto L5e
            af.b5 r0 = r5.e(r9)     // Catch: java.lang.Throwable -> L11
            r8.f695o = r0     // Catch: java.lang.Throwable -> L11
            boolean r0 = r8.isReady()     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto L30
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L30:
            af.f r1 = new af.f     // Catch: java.lang.Throwable -> L11
            r0 = 8
            r1.<init>(r8, r0)     // Catch: java.lang.Throwable -> L11
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
        L38:
            if (r1 == 0) goto L40
            ze.v2 r8 = r8.f685c
            r8.execute(r1)
            return
        L40:
            if (r2 != 0) goto L4d
            af.b0 r0 = r9.f245a
            af.l6 r1 = new af.l6
            r2 = 5
            r1.<init>(r2, r8, r9)
            r0.c(r1)
        L4d:
            af.b0 r0 = r9.f245a
            af.b5 r1 = r8.f695o
            af.e5 r1 = r1.f
            if (r1 != r9) goto L58
            ze.q2 r8 = r8.f702y
            goto L5a
        L58:
            ze.q2 r8 = af.x2.G
        L5a:
            r0.h(r8)
            return
        L5e:
            boolean r6 = r9.f246b     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L64
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L64:
            int r6 = r0 + 128
            java.util.List r7 = r5.f187b     // Catch: java.lang.Throwable -> L11
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L11
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L11
            if (r3 != 0) goto L7e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f187b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L11
            goto L8a
        L7e:
            r3.clear()     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f187b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L11
        L8a:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            java.util.Iterator r0 = r3.iterator()
        L8f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lb0
            java.lang.Object r4 = r0.next()
            af.x4 r4 = (af.x4) r4
            r4.a(r9)
            boolean r4 = r4 instanceof af.a5
            if (r4 == 0) goto La3
            r2 = 1
        La3:
            af.b5 r4 = r8.f695o
            af.e5 r5 = r4.f
            if (r5 == 0) goto Lac
            if (r5 == r9) goto Lac
            goto Lb0
        Lac:
            boolean r4 = r4.f190g
            if (r4 == 0) goto L8f
        Lb0:
            r0 = r6
            goto L4
        Lb3:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: af.x2.q(af.e5):void");
    }

    public final void r() {
        ScheduledFuture scheduledFuture;
        synchronized (this.f689i) {
            try {
                d2 d2Var = this.f700w;
                scheduledFuture = null;
                if (d2Var != null) {
                    d2Var.f213a = true;
                    ScheduledFuture scheduledFuture2 = (ScheduledFuture) d2Var.f215c;
                    this.f700w = null;
                    scheduledFuture = scheduledFuture2;
                }
                b5 b5Var = this.f695o;
                if (!b5Var.f191h) {
                    b5Var = new b5(b5Var.f187b, b5Var.f188c, b5Var.f189d, b5Var.f, b5Var.f190g, b5Var.f186a, true, b5Var.e);
                }
                this.f695o = b5Var;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final boolean s(b5 b5Var) {
        if (b5Var.f == null) {
            if (b5Var.e < this.f687g.f480a && !b5Var.f191h) {
                return true;
            }
        }
        return false;
    }

    public final void t(ze.q2 q2Var, c0 c0Var, ze.p1 p1Var) {
        this.f697s = new qf.c(q2Var, 2, c0Var, p1Var);
        if (this.f696r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f685c.execute(new a(2, this, q2Var, c0Var, p1Var));
        }
    }

    public final void u(Object obj) {
        b5 b5Var = this.f695o;
        if (!b5Var.f186a) {
            p(new v4(this, obj));
            return;
        }
        b0 b0Var = b5Var.f.f245a;
        gf.b bVar = this.f683a.f11425d;
        bVar.getClass();
        b0Var.i(new gf.a((MessageLite) obj, bVar.f5181a));
    }
}
