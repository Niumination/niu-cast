package wj;

import androidx.core.app.NotificationManagerCompat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m2<ReqT> implements wj.s {

    @b1.e
    public static final vj.v1.i<String> A;

    @b1.e
    public static final vj.v1.i<String> B;
    public static final vj.y2 C;
    public static Random D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.w1<ReqT, ?> f18819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18820b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f18822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vj.v1 f18823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.j
    public final n2 f18824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.j
    public final x0 f18825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18826h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f18828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f18829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f18830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @gm.j
    public final e0 f18831m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public z f18837s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @hm.a("lock")
    public long f18838t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public wj.t f18839u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @hm.a("lock")
    public v f18840v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @hm.a("lock")
    public v f18841w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f18842x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public vj.y2 f18843y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f18844z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18821c = new vj.c3(new a());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f18827i = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @hm.a("lock")
    public final b1 f18832n = new b1();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile b0 f18833o = new b0(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f18834p = new AtomicBoolean();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f18835q = new AtomicInteger();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f18836r = new AtomicInteger();

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            vj.y2 y2VarU = vj.y2.n(th2).u("Uncaught exception in the SynchronizationContext. Re-thrown.");
            y2VarU.getClass();
            throw new vj.a3(y2VarU);
        }
    }

    public class a0 implements s {
        public a0() {
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.y(new c0(d0Var));
        }
    }

    public class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18847a;

        public b(String str) {
            this.f18847a = str;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.t(this.f18847a);
        }
    }

    public static final class b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final List<s> f18850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Collection<d0> f18851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Collection<d0> f18852d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18853e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.j
        public final d0 f18854f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f18855g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f18856h;

        public b0(@gm.j List<s> list, Collection<d0> collection, Collection<d0> collection2, @gm.j d0 d0Var, boolean z10, boolean z11, boolean z12, int i10) {
            this.f18850b = list;
            this.f18851c = (Collection) c1.h0.F(collection, "drainedSubstreams");
            this.f18854f = d0Var;
            this.f18852d = collection2;
            this.f18855g = z10;
            this.f18849a = z11;
            this.f18856h = z12;
            this.f18853e = i10;
            c1.h0.h0(!z11 || list == null, "passThrough should imply buffer is null");
            c1.h0.h0((z11 && d0Var == null) ? false : true, "passThrough should imply winningSubstream != null");
            c1.h0.h0(!z11 || (collection.size() == 1 && collection.contains(d0Var)) || (collection.size() == 0 && d0Var.f18883b), "passThrough should imply winningSubstream is drained");
            c1.h0.h0((z10 && d0Var == null) ? false : true, "cancelled should imply committed");
        }

        @gm.c
        public b0 a(d0 d0Var) {
            Collection collectionUnmodifiableCollection;
            c1.h0.h0(!this.f18856h, "hedging frozen");
            c1.h0.h0(this.f18854f == null, "already committed");
            if (this.f18852d == null) {
                collectionUnmodifiableCollection = Collections.singleton(d0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f18852d);
                arrayList.add(d0Var);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new b0(this.f18850b, this.f18851c, collectionUnmodifiableCollection, this.f18854f, this.f18855g, this.f18849a, this.f18856h, this.f18853e + 1);
        }

        @gm.c
        public b0 b() {
            return new b0(this.f18850b, this.f18851c, this.f18852d, this.f18854f, true, this.f18849a, this.f18856h, this.f18853e);
        }

        @gm.c
        public b0 c(d0 d0Var) {
            List<s> list;
            boolean z10;
            Collection collectionEmptyList;
            c1.h0.h0(this.f18854f == null, "Already committed");
            List<s> list2 = this.f18850b;
            if (this.f18851c.contains(d0Var)) {
                collectionEmptyList = Collections.singleton(d0Var);
                list = null;
                z10 = true;
            } else {
                list = list2;
                z10 = false;
                collectionEmptyList = Collections.emptyList();
            }
            return new b0(list, collectionEmptyList, this.f18852d, d0Var, this.f18855g, z10, this.f18856h, this.f18853e);
        }

        @gm.c
        public b0 d() {
            return this.f18856h ? this : new b0(this.f18850b, this.f18851c, this.f18852d, this.f18854f, this.f18855g, this.f18849a, true, this.f18853e);
        }

        @gm.c
        public b0 e(d0 d0Var) {
            ArrayList arrayList = new ArrayList(this.f18852d);
            arrayList.remove(d0Var);
            return new b0(this.f18850b, this.f18851c, Collections.unmodifiableCollection(arrayList), this.f18854f, this.f18855g, this.f18849a, this.f18856h, this.f18853e);
        }

        @gm.c
        public b0 f(d0 d0Var, d0 d0Var2) {
            ArrayList arrayList = new ArrayList(this.f18852d);
            arrayList.remove(d0Var);
            arrayList.add(d0Var2);
            return new b0(this.f18850b, this.f18851c, Collections.unmodifiableCollection(arrayList), this.f18854f, this.f18855g, this.f18849a, this.f18856h, this.f18853e);
        }

        @gm.c
        public b0 g(d0 d0Var) {
            d0Var.f18883b = true;
            if (!this.f18851c.contains(d0Var)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f18851c);
            arrayList.remove(d0Var);
            return new b0(this.f18850b, Collections.unmodifiableCollection(arrayList), this.f18852d, this.f18854f, this.f18855g, this.f18849a, this.f18856h, this.f18853e);
        }

        @gm.c
        public b0 h(d0 d0Var) {
            Collection collectionUnmodifiableCollection;
            c1.h0.h0(!this.f18849a, "Already passThrough");
            if (d0Var.f18883b) {
                collectionUnmodifiableCollection = this.f18851c;
            } else if (this.f18851c.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(d0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f18851c);
                arrayList.add(d0Var);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = collectionUnmodifiableCollection;
            d0 d0Var2 = this.f18854f;
            boolean z10 = d0Var2 != null;
            List<s> list = this.f18850b;
            if (z10) {
                c1.h0.h0(d0Var2 == d0Var, "Another RPC attempt has already committed");
                list = null;
            }
            return new b0(list, collection, this.f18852d, this.f18854f, this.f18855g, z10, this.f18856h, this.f18853e);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ boolean f18857g = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f18858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0 f18859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Future f18860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f18861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Future f18862e;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m2.this.f18844z = true;
                m2 m2Var = m2.this;
                wj.t tVar = m2Var.f18839u;
                z zVar = m2Var.f18837s;
                tVar.b(zVar.f18932a, zVar.f18933b, zVar.f18934c);
            }
        }

        public c(Collection collection, d0 d0Var, Future future, boolean z10, Future future2) {
            this.f18858a = collection;
            this.f18859b = d0Var;
            this.f18860c = future;
            this.f18861d = z10;
            this.f18862e = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d0 d0Var : this.f18858a) {
                if (d0Var != this.f18859b) {
                    d0Var.f18882a.a(m2.C);
                }
            }
            Future future = this.f18860c;
            if (future != null) {
                future.cancel(false);
                if (!this.f18861d && m2.this.f18836r.decrementAndGet() == Integer.MIN_VALUE) {
                    m2.this.f18821c.execute(new a());
                }
            }
            Future future2 = this.f18862e;
            if (future2 != null) {
                future2.cancel(false);
            }
            m2.this.s0();
        }
    }

    public final class c0 implements wj.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ boolean f18865c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f18866a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f18868a;

            public a(vj.v1 v1Var) {
                this.f18868a = v1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                m2.this.f18839u.f(this.f18868a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v f18870a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f18871b;

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    m2.this.o0(bVar.f18871b);
                }
            }

            public b(v vVar, d0 d0Var) {
                this.f18870a = vVar;
                this.f18871b = d0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (this.f18870a.f18921a) {
                    try {
                        v vVar = this.f18870a;
                        if (vVar.f18923c) {
                            return;
                        }
                        vVar.b();
                        m2.this.f18820b.execute(new a());
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m2.this.f18844z = true;
                m2 m2Var = m2.this;
                wj.t tVar = m2Var.f18839u;
                z zVar = m2Var.f18837s;
                tVar.b(zVar.f18932a, zVar.f18933b, zVar.f18934c);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d0 f18875a;

            public d(d0 d0Var) {
                this.f18875a = d0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                m2.this.o0(this.f18875a);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k3.a f18877a;

            public e(k3.a aVar) {
                this.f18877a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                m2.this.f18839u.a(this.f18877a);
            }
        }

        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m2.this.f18844z) {
                    return;
                }
                m2.this.f18839u.d();
            }
        }

        public c0(d0 d0Var) {
            this.f18866a = d0Var;
        }

        @Override // wj.k3
        public void a(k3.a aVar) {
            b0 b0Var = m2.this.f18833o;
            c1.h0.h0(b0Var.f18854f != null, "Headers should be received prior to messages.");
            if (b0Var.f18854f != this.f18866a) {
                v0.f(aVar);
            } else {
                m2.this.f18821c.execute(new e(aVar));
            }
        }

        @Override // wj.t
        public void b(vj.y2 y2Var, wj.t.a aVar, vj.v1 v1Var) {
            v vVar;
            synchronized (m2.this.f18827i) {
                m2 m2Var = m2.this;
                m2Var.f18833o = m2Var.f18833o.g(this.f18866a);
                m2.this.f18832n.a(y2Var.f17568a);
            }
            if (m2.this.f18836r.decrementAndGet() == Integer.MIN_VALUE) {
                m2.this.f18821c.execute(new c());
                return;
            }
            d0 d0Var = this.f18866a;
            if (d0Var.f18884c) {
                m2.this.l0(d0Var);
                if (m2.this.f18833o.f18854f == this.f18866a) {
                    m2.this.v0(y2Var, aVar, v1Var);
                    return;
                }
                return;
            }
            wj.t.a aVar2 = wj.t.a.MISCARRIED;
            if (aVar == aVar2 && m2.this.f18835q.incrementAndGet() > 1000) {
                m2.this.l0(this.f18866a);
                if (m2.this.f18833o.f18854f == this.f18866a) {
                    m2.this.v0(vj.y2.f17562s.u("Too many transparent retries. Might be a bug in gRPC").t(new vj.a3(y2Var)), aVar, v1Var);
                    return;
                }
                return;
            }
            if (m2.this.f18833o.f18854f == null) {
                if (aVar == aVar2 || (aVar == wj.t.a.REFUSED && m2.this.f18834p.compareAndSet(false, true))) {
                    d0 d0VarM0 = m2.this.m0(this.f18866a.f18885d, true);
                    if (d0VarM0 == null) {
                        return;
                    }
                    m2 m2Var2 = m2.this;
                    if (m2Var2.f18826h) {
                        synchronized (m2Var2.f18827i) {
                            m2 m2Var3 = m2.this;
                            m2Var3.f18833o = m2Var3.f18833o.f(this.f18866a, d0VarM0);
                        }
                    }
                    m2.this.f18820b.execute(new d(d0VarM0));
                    return;
                }
                if (aVar == wj.t.a.DROPPED) {
                    m2 m2Var4 = m2.this;
                    if (m2Var4.f18826h) {
                        m2Var4.p0();
                    }
                } else {
                    m2.this.f18834p.set(true);
                    if (m2.this.f18826h) {
                        w wVarH = h(y2Var, v1Var);
                        if (wVarH.f18924a) {
                            m2.this.u0(wVarH.f18925b);
                        }
                        synchronized (m2.this.f18827i) {
                            try {
                                m2 m2Var5 = m2.this;
                                m2Var5.f18833o = m2Var5.f18833o.e(this.f18866a);
                                if (wVarH.f18924a) {
                                    m2 m2Var6 = m2.this;
                                    if (!m2Var6.q0(m2Var6.f18833o)) {
                                        if (!m2.this.f18833o.f18852d.isEmpty()) {
                                        }
                                    }
                                    return;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } else {
                        y yVarI = i(y2Var, v1Var);
                        if (yVarI.f18930a) {
                            d0 d0VarM1 = m2.this.m0(this.f18866a.f18885d + 1, false);
                            if (d0VarM1 == null) {
                                return;
                            }
                            synchronized (m2.this.f18827i) {
                                m2 m2Var7 = m2.this;
                                vVar = new v(m2Var7.f18827i);
                                m2Var7.f18840v = vVar;
                            }
                            vVar.c(m2.this.f18822d.schedule(new b(vVar, d0VarM1), yVarI.f18931b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                }
            }
            m2.this.l0(this.f18866a);
            if (m2.this.f18833o.f18854f == this.f18866a) {
                m2.this.v0(y2Var, aVar, v1Var);
            }
        }

        @Override // wj.k3
        public void d() {
            if (m2.this.s()) {
                m2.this.f18821c.execute(new f());
            }
        }

        @Override // wj.t
        public void f(vj.v1 v1Var) {
            if (this.f18866a.f18885d > 0) {
                vj.v1.i<String> iVar = m2.A;
                v1Var.j(iVar);
                v1Var.w(iVar, String.valueOf(this.f18866a.f18885d));
            }
            m2.this.l0(this.f18866a);
            if (m2.this.f18833o.f18854f == this.f18866a) {
                e0 e0Var = m2.this.f18831m;
                if (e0Var != null) {
                    e0Var.c();
                }
                m2.this.f18821c.execute(new a(v1Var));
            }
        }

        @gm.j
        public final Integer g(vj.v1 v1Var) {
            String str = (String) v1Var.l(m2.B);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final w h(vj.y2 y2Var, vj.v1 v1Var) {
            Integer numG = g(v1Var);
            boolean zContains = m2.this.f18825g.f19534c.contains(y2Var.f17568a);
            boolean z10 = (m2.this.f18831m == null || (!zContains && (numG == null || numG.intValue() >= 0))) ? false : !m2.this.f18831m.b();
            if (zContains && !z10 && !y2Var.r() && numG != null && numG.intValue() > 0) {
                numG = 0;
            }
            return new w(zContains && !z10, numG);
        }

        public final y i(vj.y2 y2Var, vj.v1 v1Var) {
            long nanos = 0;
            boolean z10 = false;
            if (m2.this.f18824f == null) {
                return new y(false, 0L);
            }
            boolean zContains = m2.this.f18824f.f19103f.contains(y2Var.f17568a);
            Integer numG = g(v1Var);
            boolean z11 = (m2.this.f18831m == null || (!zContains && (numG == null || numG.intValue() >= 0))) ? false : !m2.this.f18831m.b();
            m2 m2Var = m2.this;
            if (m2Var.f18824f.f19098a > this.f18866a.f18885d + 1 && !z11) {
                if (numG == null) {
                    if (zContains) {
                        nanos = (long) (m2.D.nextDouble() * m2Var.f18842x);
                        m2 m2Var2 = m2.this;
                        double d10 = m2Var2.f18842x;
                        n2 n2Var = m2Var2.f18824f;
                        m2Var2.f18842x = Math.min((long) (d10 * n2Var.f19101d), n2Var.f19100c);
                        z10 = true;
                    }
                } else if (numG.intValue() >= 0) {
                    nanos = TimeUnit.MILLISECONDS.toNanos(numG.intValue());
                    m2 m2Var3 = m2.this;
                    m2Var3.f18842x = m2Var3.f18824f.f19099b;
                    z10 = true;
                }
            }
            return new y(z10, nanos);
        }
    }

    public class d implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.s f18880a;

        public d(vj.s sVar) {
            this.f18880a = sVar;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.f(this.f18880a);
        }
    }

    public static final class d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wj.s f18882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f18885d;

        public d0(int i10) {
            this.f18885d = i10;
        }
    }

    public class e implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.y f18886a;

        public e(vj.y yVar) {
            this.f18886a = yVar;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.r(this.f18886a);
        }
    }

    public static final class e0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f18888e = 1000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f18892d;

        public e0(float f10, float f11) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f18892d = atomicInteger;
            this.f18891c = (int) (f11 * 1000.0f);
            int i10 = (int) (f10 * 1000.0f);
            this.f18889a = i10;
            this.f18890b = i10 / 2;
            atomicInteger.set(i10);
        }

        @b1.e
        public boolean a() {
            return this.f18892d.get() > this.f18890b;
        }

        @b1.e
        public boolean b() {
            int i10;
            int i11;
            do {
                i10 = this.f18892d.get();
                if (i10 == 0) {
                    return false;
                }
                i11 = i10 + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            } while (!this.f18892d.compareAndSet(i10, Math.max(i11, 0)));
            return i11 > this.f18890b;
        }

        @b1.e
        public void c() {
            int i10;
            int i11;
            do {
                i10 = this.f18892d.get();
                i11 = this.f18889a;
                if (i10 == i11) {
                    return;
                }
            } while (!this.f18892d.compareAndSet(i10, Math.min(this.f18891c + i10, i11)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e0)) {
                return false;
            }
            e0 e0Var = (e0) obj;
            return this.f18889a == e0Var.f18889a && this.f18891c == e0Var.f18891c;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.f18889a), Integer.valueOf(this.f18891c)});
        }
    }

    public class f implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.a0 f18893a;

        public f(vj.a0 a0Var) {
            this.f18893a = a0Var;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.m(this.f18893a);
        }
    }

    public class g implements s {
        public g() {
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.flush();
        }
    }

    public class h implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18896a;

        public h(boolean z10) {
            this.f18896a = z10;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.o(this.f18896a);
        }
    }

    public class i implements s {
        public i() {
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.v();
        }
    }

    public class j implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18899a;

        public j(int i10) {
            this.f18899a = i10;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.h(this.f18899a);
        }
    }

    public class k implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18901a;

        public k(int i10) {
            this.f18901a = i10;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.i(this.f18901a);
        }
    }

    public class l implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18903a;

        public l(boolean z10) {
            this.f18903a = z10;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.e(this.f18903a);
        }
    }

    public class m implements s {
        public m() {
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.n();
        }
    }

    public class n implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18906a;

        public n(int i10) {
            this.f18906a = i10;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.b(this.f18906a);
        }
    }

    public class o implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f18908a;

        public o(Object obj) {
            this.f18908a = obj;
        }

        @Override // wj.m2.s
        public void a(d0 d0Var) {
            d0Var.f18882a.j(m2.this.f18819a.f17483d.a((ReqT) this.f18908a));
            d0Var.f18882a.flush();
        }
    }

    public class p extends vj.n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.n f18910a;

        public p(vj.n nVar) {
            this.f18910a = nVar;
        }

        @Override // vj.n.a
        public vj.n a(vj.n.b bVar, vj.v1 v1Var) {
            return this.f18910a;
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m2.this.f18844z) {
                return;
            }
            m2.this.f18839u.d();
        }
    }

    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.y2 f18913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wj.t.a f18914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ vj.v1 f18915c;

        public r(vj.y2 y2Var, wj.t.a aVar, vj.v1 v1Var) {
            this.f18913a = y2Var;
            this.f18914b = aVar;
            this.f18915c = v1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            m2.this.f18844z = true;
            m2.this.f18839u.b(this.f18913a, this.f18914b, this.f18915c);
        }
    }

    public interface s {
        void a(d0 d0Var);
    }

    public class t extends vj.n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0 f18917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hm.a("lock")
        public long f18918c;

        public t(d0 d0Var) {
            this.f18917b = d0Var;
        }

        @Override // vj.b3
        public void h(long j10) {
            if (m2.this.f18833o.f18854f != null) {
                return;
            }
            synchronized (m2.this.f18827i) {
                try {
                    if (m2.this.f18833o.f18854f == null) {
                        d0 d0Var = this.f18917b;
                        if (!d0Var.f18883b) {
                            long j11 = this.f18918c + j10;
                            this.f18918c = j11;
                            m2 m2Var = m2.this;
                            long j12 = m2Var.f18838t;
                            if (j11 <= j12) {
                                return;
                            }
                            if (j11 > m2Var.f18829k) {
                                d0Var.f18884c = true;
                            } else {
                                long jAddAndGet = m2Var.f18828j.f18920a.addAndGet(j11 - j12);
                                m2 m2Var2 = m2.this;
                                m2Var2.f18838t = this.f18918c;
                                if (jAddAndGet > m2Var2.f18830l) {
                                    this.f18917b.f18884c = true;
                                }
                            }
                            d0 d0Var2 = this.f18917b;
                            Runnable runnableK0 = d0Var2.f18884c ? m2.this.k0(d0Var2) : null;
                            if (runnableK0 != null) {
                                runnableK0.run();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f18920a = new AtomicLong();

        @b1.e
        public long a(long j10) {
            return this.f18920a.addAndGet(j10);
        }
    }

    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hm.a("lock")
        public Future<?> f18922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hm.a("lock")
        public boolean f18923c;

        public v(Object obj) {
            this.f18921a = obj;
        }

        @hm.a("lock")
        public boolean a() {
            return this.f18923c;
        }

        @hm.a("lock")
        @gm.a
        public Future<?> b() {
            this.f18923c = true;
            return this.f18922b;
        }

        public void c(Future<?> future) {
            boolean z10;
            synchronized (this.f18921a) {
                try {
                    z10 = this.f18923c;
                    if (!z10) {
                        this.f18922b = future;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z10) {
                future.cancel(false);
            }
        }
    }

    public static final class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final Integer f18925b;

        public w(boolean z10, @gm.j Integer num) {
            this.f18924a = z10;
            this.f18925b = num;
        }
    }

    public final class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f18926a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d0 f18928a;

            public a(d0 d0Var) {
                this.f18928a = d0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                v vVar;
                boolean z10;
                e0 e0Var;
                synchronized (m2.this.f18827i) {
                    try {
                        x xVar = x.this;
                        vVar = null;
                        if (xVar.f18926a.f18923c) {
                            z10 = true;
                        } else {
                            m2 m2Var = m2.this;
                            m2Var.f18833o = m2Var.f18833o.a(this.f18928a);
                            m2 m2Var2 = m2.this;
                            if (m2Var2.q0(m2Var2.f18833o) && ((e0Var = m2.this.f18831m) == null || e0Var.a())) {
                                m2 m2Var3 = m2.this;
                                vVar = new v(m2Var3.f18827i);
                                m2Var3.f18841w = vVar;
                            } else {
                                m2 m2Var4 = m2.this;
                                m2Var4.f18833o = m2Var4.f18833o.d();
                                m2.this.f18841w = null;
                            }
                            z10 = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (z10) {
                    this.f18928a.f18882a.y(new c0(this.f18928a));
                    this.f18928a.f18882a.a(vj.y2.f17549f.u("Unneeded hedging"));
                } else {
                    if (vVar != null) {
                        m2 m2Var5 = m2.this;
                        vVar.c(m2Var5.f18822d.schedule(new x(vVar), m2.this.f18825g.f19533b, TimeUnit.NANOSECONDS));
                    }
                    m2.this.o0(this.f18928a);
                }
            }
        }

        public x(v vVar) {
            this.f18926a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            m2 m2Var = m2.this;
            d0 d0VarM0 = m2Var.m0(m2Var.f18833o.f18853e, false);
            if (d0VarM0 == null) {
                return;
            }
            m2.this.f18820b.execute(new a(d0VarM0));
        }
    }

    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18931b;

        public y(boolean z10, long j10) {
            this.f18930a = z10;
            this.f18931b = j10;
        }
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.y2 f18932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final wj.t.a f18933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vj.v1 f18934c;

        public z(vj.y2 y2Var, wj.t.a aVar, vj.v1 v1Var) {
            this.f18932a = y2Var;
            this.f18933b = aVar;
            this.f18934c = v1Var;
        }
    }

    static {
        vj.v1.d<String> dVar = vj.v1.f17427f;
        A = vj.v1.i.e("grpc-previous-rpc-attempts", dVar);
        B = vj.v1.i.e("grpc-retry-pushback-ms", dVar);
        C = vj.y2.f17549f.u("Stream thrown away because RetriableStream committed");
        D = new Random();
    }

    public m2(vj.w1<ReqT, ?> w1Var, vj.v1 v1Var, u uVar, long j10, long j11, Executor executor, ScheduledExecutorService scheduledExecutorService, @gm.j n2 n2Var, @gm.j x0 x0Var, @gm.j e0 e0Var) {
        this.f18819a = w1Var;
        this.f18828j = uVar;
        this.f18829k = j10;
        this.f18830l = j11;
        this.f18820b = executor;
        this.f18822d = scheduledExecutorService;
        this.f18823e = v1Var;
        this.f18824f = n2Var;
        if (n2Var != null) {
            this.f18842x = n2Var.f19099b;
        }
        this.f18825g = x0Var;
        c1.h0.e(n2Var == null || x0Var == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f18826h = x0Var != null;
        this.f18831m = e0Var;
    }

    @b1.e
    public static void x0(Random random) {
        D = random;
    }

    @Override // wj.s
    public final void a(vj.y2 y2Var) {
        d0 d0Var;
        d0 d0Var2 = new d0(0);
        d0Var2.f18882a = new y1();
        Runnable runnableK0 = k0(d0Var2);
        if (runnableK0 != null) {
            synchronized (this.f18827i) {
                this.f18833o = this.f18833o.h(d0Var2);
            }
            runnableK0.run();
            v0(y2Var, wj.t.a.PROCESSED, new vj.v1());
            return;
        }
        synchronized (this.f18827i) {
            try {
                if (this.f18833o.f18851c.contains(this.f18833o.f18854f)) {
                    d0Var = this.f18833o.f18854f;
                } else {
                    this.f18843y = y2Var;
                    d0Var = null;
                }
                this.f18833o = this.f18833o.b();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (d0Var != null) {
            d0Var.f18882a.a(y2Var);
        }
    }

    @Override // wj.j3
    public final void b(int i10) {
        b0 b0Var = this.f18833o;
        if (b0Var.f18849a) {
            b0Var.f18854f.f18882a.b(i10);
        } else {
            n0(new n(i10));
        }
    }

    @Override // wj.s
    public final vj.a c() {
        return this.f18833o.f18854f != null ? this.f18833o.f18854f.f18882a.c() : vj.a.f17046c;
    }

    @Override // wj.j3
    public final void e(boolean z10) {
        n0(new l(z10));
    }

    @Override // wj.j3
    public final void f(vj.s sVar) {
        n0(new d(sVar));
    }

    @Override // wj.j3
    public final void flush() {
        b0 b0Var = this.f18833o;
        if (b0Var.f18849a) {
            b0Var.f18854f.f18882a.flush();
        } else {
            n0(new g());
        }
    }

    @Override // wj.s
    public final void h(int i10) {
        n0(new j(i10));
    }

    @Override // wj.s
    public final void i(int i10) {
        n0(new k(i10));
    }

    @Override // wj.j3
    public final void j(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    @gm.j
    @gm.c
    public final Runnable k0(d0 d0Var) {
        Future<?> future;
        Future<?> future2;
        synchronized (this.f18827i) {
            try {
                if (this.f18833o.f18854f != null) {
                    return null;
                }
                Collection<d0> collection = this.f18833o.f18851c;
                this.f18833o = this.f18833o.c(d0Var);
                this.f18828j.a(-this.f18838t);
                v vVar = this.f18840v;
                boolean z10 = vVar != null ? vVar.f18923c : false;
                if (vVar != null) {
                    vVar.f18923c = true;
                    Future<?> future3 = vVar.f18922b;
                    this.f18840v = null;
                    future = future3;
                } else {
                    future = null;
                }
                v vVar2 = this.f18841w;
                if (vVar2 != null) {
                    vVar2.f18923c = true;
                    Future<?> future4 = vVar2.f18922b;
                    this.f18841w = null;
                    future2 = future4;
                } else {
                    future2 = null;
                }
                return new c(collection, d0Var, future, z10, future2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l0(d0 d0Var) {
        Runnable runnableK0 = k0(d0Var);
        if (runnableK0 != null) {
            this.f18820b.execute(runnableK0);
        }
    }

    @Override // wj.s
    public final void m(vj.a0 a0Var) {
        n0(new f(a0Var));
    }

    @gm.j
    public final d0 m0(int i10, boolean z10) {
        int i11;
        do {
            i11 = this.f18836r.get();
            if (i11 < 0) {
                return null;
            }
        } while (!this.f18836r.compareAndSet(i11, i11 + 1));
        d0 d0Var = new d0(i10);
        d0Var.f18882a = r0(y0(this.f18823e, i10), new p(new t(d0Var)), i10, z10);
        return d0Var;
    }

    @Override // wj.j3
    public void n() {
        n0(new m());
    }

    public final void n0(s sVar) {
        Collection<d0> collection;
        synchronized (this.f18827i) {
            try {
                if (!this.f18833o.f18849a) {
                    this.f18833o.f18850b.add(sVar);
                }
                collection = this.f18833o.f18851c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator<d0> it = collection.iterator();
        while (it.hasNext()) {
            sVar.a(it.next());
        }
    }

    @Override // wj.s
    public final void o(boolean z10) {
        n0(new h(z10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
    
        r0 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
    
        if (r0.hasNext() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
    
        r4 = (wj.m2.s) r0.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
    
        if ((r4 instanceof wj.m2.a0) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
    
        r4 = r8.f18833o;
        r5 = r4.f18854f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
    
        if (r5 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        if (r5 == r9) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        if (r4.f18855g == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o0(wj.m2.d0 r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L4:
            java.lang.Object r4 = r8.f18827i
            monitor-enter(r4)
            wj.m2$b0 r5 = r8.f18833o     // Catch: java.lang.Throwable -> L11
            wj.m2$d0 r6 = r5.f18854f     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L14
            if (r6 == r9) goto L14
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L11:
            r8 = move-exception
            goto Lb0
        L14:
            boolean r6 = r5.f18855g     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L1a
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L1a:
            java.util.List<wj.m2$s> r6 = r5.f18850b     // Catch: java.lang.Throwable -> L11
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L11
            if (r0 != r6) goto L5b
            wj.m2$b0 r0 = r5.h(r9)     // Catch: java.lang.Throwable -> L11
            r8.f18833o = r0     // Catch: java.lang.Throwable -> L11
            boolean r0 = r8.s()     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto L30
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L30:
            wj.m2$q r1 = new wj.m2$q     // Catch: java.lang.Throwable -> L11
            r1.<init>()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
        L36:
            if (r1 == 0) goto L3e
            java.util.concurrent.Executor r8 = r8.f18821c
            r8.execute(r1)
            return
        L3e:
            if (r2 != 0) goto L4a
            wj.s r0 = r9.f18882a
            wj.m2$c0 r1 = new wj.m2$c0
            r1.<init>(r9)
            r0.y(r1)
        L4a:
            wj.s r0 = r9.f18882a
            wj.m2$b0 r1 = r8.f18833o
            wj.m2$d0 r1 = r1.f18854f
            if (r1 != r9) goto L55
            vj.y2 r8 = r8.f18843y
            goto L57
        L55:
            vj.y2 r8 = wj.m2.C
        L57:
            r0.a(r8)
            return
        L5b:
            boolean r6 = r9.f18883b     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L61
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L61:
            int r6 = r0 + 128
            java.util.List<wj.m2$s> r7 = r5.f18850b     // Catch: java.lang.Throwable -> L11
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L11
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L11
            if (r3 != 0) goto L7b
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L11
            java.util.List<wj.m2$s> r5 = r5.f18850b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L11
            goto L87
        L7b:
            r3.clear()     // Catch: java.lang.Throwable -> L11
            java.util.List<wj.m2$s> r5 = r5.f18850b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L11
        L87:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            java.util.Iterator r0 = r3.iterator()
        L8c:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lad
            java.lang.Object r4 = r0.next()
            wj.m2$s r4 = (wj.m2.s) r4
            r4.a(r9)
            boolean r4 = r4 instanceof wj.m2.a0
            if (r4 == 0) goto La0
            r2 = 1
        La0:
            wj.m2$b0 r4 = r8.f18833o
            wj.m2$d0 r5 = r4.f18854f
            if (r5 == 0) goto La9
            if (r5 == r9) goto La9
            goto Lad
        La9:
            boolean r4 = r4.f18855g
            if (r4 == 0) goto L8c
        Lad:
            r0 = r6
            goto L4
        Lb0:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: wj.m2.o0(wj.m2$d0):void");
    }

    public final void p0() {
        Future<?> future;
        synchronized (this.f18827i) {
            try {
                v vVar = this.f18841w;
                future = null;
                if (vVar != null) {
                    vVar.f18923c = true;
                    Future<?> future2 = vVar.f18922b;
                    this.f18841w = null;
                    future = future2;
                }
                this.f18833o = this.f18833o.d();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    @hm.a("lock")
    public final boolean q0(b0 b0Var) {
        return b0Var.f18854f == null && b0Var.f18853e < this.f18825g.f19532a && !b0Var.f18856h;
    }

    @Override // wj.s
    public final void r(vj.y yVar) {
        n0(new e(yVar));
    }

    public abstract wj.s r0(vj.v1 v1Var, vj.n.a aVar, int i10, boolean z10);

    @Override // wj.j3
    public final boolean s() {
        Iterator<d0> it = this.f18833o.f18851c.iterator();
        while (it.hasNext()) {
            if (it.next().f18882a.s()) {
                return true;
            }
        }
        return false;
    }

    public abstract void s0();

    @Override // wj.s
    public final void t(String str) {
        n0(new b(str));
    }

    @gm.j
    @gm.c
    public abstract vj.y2 t0();

    public final void u0(@gm.j Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            p0();
            return;
        }
        synchronized (this.f18827i) {
            try {
                v vVar = this.f18841w;
                if (vVar == null) {
                    return;
                }
                vVar.f18923c = true;
                Future<?> future = vVar.f18922b;
                v vVar2 = new v(this.f18827i);
                this.f18841w = vVar2;
                if (future != null) {
                    future.cancel(false);
                }
                vVar2.c(this.f18822d.schedule(new x(vVar2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // wj.s
    public final void v() {
        n0(new i());
    }

    public final void v0(vj.y2 y2Var, wj.t.a aVar, vj.v1 v1Var) {
        this.f18837s = new z(y2Var, aVar, v1Var);
        if (this.f18836r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f18821c.execute(new r(y2Var, aVar, v1Var));
        }
    }

    public final void w0(ReqT reqt) {
        b0 b0Var = this.f18833o;
        if (b0Var.f18849a) {
            b0Var.f18854f.f18882a.j(this.f18819a.f17483d.a(reqt));
        } else {
            n0(new o(reqt));
        }
    }

    @Override // wj.s
    public void x(b1 b1Var) {
        b0 b0Var;
        synchronized (this.f18827i) {
            b1Var.b("closed", this.f18832n);
            b0Var = this.f18833o;
        }
        if (b0Var.f18854f != null) {
            b1 b1Var2 = new b1();
            b0Var.f18854f.f18882a.x(b1Var2);
            b1Var.b("committed", b1Var2);
            return;
        }
        b1 b1Var3 = new b1();
        for (d0 d0Var : b0Var.f18851c) {
            b1 b1Var4 = new b1();
            d0Var.f18882a.x(b1Var4);
            b1Var3.a(b1Var4);
        }
        b1Var.b("open", b1Var3);
    }

    @Override // wj.s
    public final void y(wj.t tVar) {
        v vVar;
        e0 e0Var;
        this.f18839u = tVar;
        vj.y2 y2VarT0 = t0();
        if (y2VarT0 != null) {
            a(y2VarT0);
            return;
        }
        synchronized (this.f18827i) {
            this.f18833o.f18850b.add(new a0());
        }
        d0 d0VarM0 = m0(0, false);
        if (d0VarM0 == null) {
            return;
        }
        if (this.f18826h) {
            synchronized (this.f18827i) {
                try {
                    this.f18833o = this.f18833o.a(d0VarM0);
                    if (q0(this.f18833o) && ((e0Var = this.f18831m) == null || e0Var.a())) {
                        vVar = new v(this.f18827i);
                        this.f18841w = vVar;
                    } else {
                        vVar = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (vVar != null) {
                vVar.c(this.f18822d.schedule(new x(vVar), this.f18825g.f19533b, TimeUnit.NANOSECONDS));
            }
        }
        o0(d0VarM0);
    }

    @b1.e
    public final vj.v1 y0(vj.v1 v1Var, int i10) {
        vj.v1 v1Var2 = new vj.v1();
        v1Var2.s(v1Var);
        if (i10 > 0) {
            v1Var2.w(A, String.valueOf(i10));
        }
        return v1Var2;
    }
}
