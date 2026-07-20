package wj;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import wj.j.b;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public final class n1 extends vj.r1 implements vj.a1<vj.v0.b> {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @b1.e
    public static final Logger f18950n0 = Logger.getLogger(n1.class.getName());

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @b1.e
    public static final Pattern f18951o0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final long f18952p0 = -1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final long f18953q0 = 5;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    @b1.e
    public static final vj.y2 f18954r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @b1.e
    public static final vj.y2 f18955s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    @b1.e
    public static final vj.y2 f18956t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final q1 f18957u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final vj.x0 f18958v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final vj.k<Object, Object> f18959w0;
    public final vj.f A;
    public final List<vj.o> B;

    @gm.j
    public final String C;
    public vj.x1 D;
    public boolean E;

    @gm.j
    public u F;

    @gm.j
    public volatile vj.o1.k G;
    public boolean H;
    public final Set<e1> I;

    @gm.j
    public Collection<w.g<?, ?>> J;
    public final Object K;
    public final Set<a2> L;
    public final d0 M;
    public final a0 N;
    public final AtomicBoolean O;
    public boolean P;
    public boolean Q;
    public volatile boolean R;
    public final CountDownLatch S;
    public final wj.o.b T;
    public final wj.o U;
    public final wj.q V;
    public final vj.h W;
    public final vj.v0 X;
    public final w Y;
    public x Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.c1 f18960a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public q1 f18961a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18962b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @gm.j
    public final q1 f18963b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.j
    public final String f18964c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f18965c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vj.z1 f18966d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final boolean f18967d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vj.x1.b f18968e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final m2.u f18969e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wj.j f18970f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final long f18971f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wj.v f18972g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final long f18973g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @gm.j
    public final vj.g f18974h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final boolean f18975h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final wj.v f18976i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final vj.y.c f18977i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final wj.v f18978j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final r1.a f18979j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y f18980k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @b1.e
    public final a1<Object> f18981k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Executor f18982l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final o f18983l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z1<? extends Executor> f18984m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final l2 f18985m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z1<? extends Executor> f18986n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r f18987o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final r f18988p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final n3 f18989q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f18990r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @b1.e
    public final vj.c3 f18991s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f18992t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final vj.a0 f18993u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final vj.t f18994v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c1.q0<c1.o0> f18995w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f18996x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final wj.y f18997y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final wj.k.a f18998z;

    public class a extends vj.x0 {
        @Override // vj.x0
        public vj.x0.b a(vj.o1.h hVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n1.this.P0(true);
        }
    }

    public final class c implements wj.o.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n3 f19004a;

        public c(n3 n3Var) {
            this.f19004a = n3Var;
        }

        @Override // wj.o.b
        public wj.o a() {
            return new wj.o(this.f19004a);
        }
    }

    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f19006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vj.u f19007b;

        public d(Runnable runnable, vj.u uVar) {
            this.f19006a = runnable;
            this.f19007b = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n1.this.f18997y.c(this.f19006a, n1.this.f18982l, this.f19007b);
        }
    }

    public final class e extends vj.o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.g f19009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f19010b;

        public e(Throwable th2) {
            this.f19010b = th2;
            this.f19009a = vj.o1.g.e(vj.y2.f17562s.u("Panic! This is a bug!").t(th2));
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            return this.f19009a;
        }

        public String toString() {
            return c1.z.b(e.class).j("panicPickResult", this.f19009a).toString();
        }
    }

    public final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n1.this.O.get()) {
                return;
            }
            n1 n1Var = n1.this;
            if (n1Var.F == null) {
                return;
            }
            n1Var.P0(false);
            n1.this.Q0();
        }
    }

    public final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n1.this.R0();
            if (n1.this.G != null) {
                n1.this.G.b();
            }
            u uVar = n1.this.F;
            if (uVar != null) {
                uVar.f19039a.e();
            }
        }
    }

    public final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n1.this.O.get()) {
                return;
            }
            n1 n1Var = n1.this;
            if (n1Var.E) {
                n1Var.b1();
            }
            Iterator<e1> it = n1.this.I.iterator();
            while (it.hasNext()) {
                it.next().c0();
            }
            Iterator<a2> it2 = n1.this.L.iterator();
            while (it2.hasNext()) {
                it2.next().r();
            }
        }
    }

    public final class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n1.this.W.a(vj.h.a.INFO, "Entering SHUTDOWN state");
            n1.this.f18997y.b(vj.u.SHUTDOWN);
        }
    }

    public final class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n1.this.P) {
                return;
            }
            n1 n1Var = n1.this;
            n1Var.P = true;
            n1Var.Y0();
        }
    }

    public final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q1.l2 f19017a;

        public k(q1.l2 l2Var) {
            this.f19017a = l2Var;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            vj.v0.b.a aVar = new vj.v0.b.a();
            n1.this.U.d(aVar);
            n1.this.V.g(aVar);
            n1 n1Var = n1.this;
            aVar.f17298a = n1Var.f18962b;
            aVar.f17299b = n1Var.f18997y.a();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(n1.this.I);
            arrayList.addAll(n1.this.L);
            aVar.i(arrayList);
            this.f19017a.B(aVar.a());
        }
    }

    public class l implements Thread.UncaughtExceptionHandler {
        public l() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            n1.f18950n0.log(Level.SEVERE, "[" + n1.this.f18960a + "] Uncaught exception in the SynchronizationContext. Panic!", th2);
            n1.this.a1(th2);
        }
    }

    public class m extends r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f19020b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(vj.x1 x1Var, String str) {
            super(x1Var);
            this.f19020b = str;
        }

        @Override // wj.r0, vj.x1
        public String a() {
            return this.f19020b;
        }
    }

    public class n extends vj.k<Object, Object> {
        @Override // vj.k
        public void a(String str, Throwable th2) {
        }

        @Override // vj.k
        public void c() {
        }

        @Override // vj.k
        public boolean d() {
            return false;
        }

        @Override // vj.k
        public void e(int i10) {
        }

        @Override // vj.k
        public void f(Object obj) {
        }

        @Override // vj.k
        public void h(vj.k.a<Object> aVar, vj.v1 v1Var) {
        }
    }

    public final class o implements wj.r.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile m2.e0 f19021a;

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n1.this.R0();
            }
        }

        public final class b<ReqT> extends m2<ReqT> {
            public final /* synthetic */ vj.w1 E;
            public final /* synthetic */ vj.v1 F;
            public final /* synthetic */ vj.e G;
            public final /* synthetic */ n2 H;
            public final /* synthetic */ x0 I;
            public final /* synthetic */ vj.w J;

            /* JADX WARN: Illegal instructions before constructor call */
            public b(vj.w1 w1Var, vj.v1 v1Var, vj.e eVar, n2 n2Var, x0 x0Var, vj.w wVar) {
                this.E = w1Var;
                this.F = v1Var;
                this.G = eVar;
                this.H = n2Var;
                this.I = x0Var;
                this.J = wVar;
                m2.u uVar = n1.this.f18969e0;
                n1 n1Var = n1.this;
                super(w1Var, v1Var, uVar, n1Var.f18971f0, n1Var.f18973g0, n1Var.S0(eVar), n1.this.f18976i.m(), n2Var, x0Var, o.this.f19021a);
            }

            @Override // wj.m2
            public wj.s r0(vj.v1 v1Var, vj.n.a aVar, int i10, boolean z10) {
                vj.e eVarY = this.G.y(aVar);
                vj.n[] nVarArrH = v0.h(eVarY, v1Var, i10, z10);
                wj.u uVarC = o.this.c(new g2(this.E, v1Var, eVarY));
                vj.w wVarC = this.J.c();
                try {
                    return uVarC.k(this.E, v1Var, eVarY, nVarArrH);
                } finally {
                    this.J.q(wVarC);
                }
            }

            @Override // wj.m2
            public void s0() {
                n1.this.N.d(this);
            }

            @Override // wj.m2
            public vj.y2 t0() {
                return n1.this.N.a(this);
            }
        }

        public o() {
        }

        @Override // wj.r.e
        public wj.s a(vj.w1<?, ?> w1Var, vj.e eVar, vj.v1 v1Var, vj.w wVar) {
            if (n1.this.f18975h0) {
                q1.b bVar = (q1.b) eVar.j(q1.b.f19181g);
                return new b(w1Var, v1Var, eVar, bVar == null ? null : bVar.f19186e, bVar != null ? bVar.f19187f : null, wVar);
            }
            wj.u uVarC = c(new g2(w1Var, v1Var, eVar));
            vj.w wVarC = wVar.c();
            try {
                return uVarC.k(w1Var, v1Var, eVar, v0.h(eVar, v1Var, 0, false));
            } finally {
                wVar.q(wVarC);
            }
        }

        public final wj.u c(vj.o1.h hVar) {
            vj.o1.k kVar = n1.this.G;
            if (n1.this.O.get()) {
                return n1.this.M;
            }
            if (kVar == null) {
                n1.this.f18991s.execute(new a());
                return n1.this.M;
            }
            wj.u uVarN = v0.n(kVar.a(hVar), hVar.a().m());
            return uVarN != null ? uVarN : n1.this.M;
        }

        public /* synthetic */ o(n1 n1Var, a aVar) {
            this();
        }
    }

    public static final class p<ReqT, RespT> extends vj.h0<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.x0 f19024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.f f19025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Executor f19026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final vj.w1<ReqT, RespT> f19027d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final vj.w f19028e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public vj.e f19029f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public vj.k<ReqT, RespT> f19030g;

        public class a extends wj.a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vj.k.a f19031b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f19032c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(vj.k.a aVar, vj.y2 y2Var) {
                super(p.this.f19028e);
                this.f19031b = aVar;
                this.f19032c = y2Var;
            }

            @Override // wj.a0
            public void a() {
                this.f19031b.a(this.f19032c, new vj.v1());
            }
        }

        public p(vj.x0 x0Var, vj.f fVar, Executor executor, vj.w1<ReqT, RespT> w1Var, vj.e eVar) {
            this.f19024a = x0Var;
            this.f19025b = fVar;
            this.f19027d = w1Var;
            Executor executor2 = eVar.f17087b;
            executor = executor2 != null ? executor2 : executor;
            this.f19026c = executor;
            this.f19029f = eVar.t(executor);
            this.f19028e = vj.w.o();
        }

        @Override // vj.h0, vj.a2, vj.k
        public void a(@gm.j String str, @gm.j Throwable th2) {
            vj.k<ReqT, RespT> kVar = this.f19030g;
            if (kVar != null) {
                kVar.a(str, th2);
            }
        }

        @Override // vj.h0, vj.k
        public void h(vj.k.a<RespT> aVar, vj.v1 v1Var) {
            vj.x0.b bVarA = this.f19024a.a(new g2(this.f19027d, v1Var, this.f19029f));
            vj.y2 y2Var = bVarA.f17507a;
            if (!y2Var.r()) {
                k(aVar, v0.s(y2Var));
                this.f19030g = n1.f18959w0;
                return;
            }
            vj.l lVar = bVarA.f17509c;
            q1.b bVarF = ((q1) bVarA.f17508b).f(this.f19027d);
            if (bVarF != null) {
                this.f19029f = this.f19029f.x(q1.b.f19181g, bVarF);
            }
            if (lVar != null) {
                this.f19030g = lVar.a(this.f19027d, this.f19029f, this.f19025b);
            } else {
                this.f19030g = this.f19025b.g(this.f19027d, this.f19029f);
            }
            this.f19030g.h(aVar, v1Var);
        }

        @Override // vj.h0, vj.a2
        public vj.k<ReqT, RespT> i() {
            return this.f19030g;
        }

        public final void k(vj.k.a<RespT> aVar, vj.y2 y2Var) {
            this.f19026c.execute(new a(aVar, y2Var));
        }
    }

    public final class q implements r1.a {
        public q() {
        }

        @Override // wj.r1.a
        public void a() {
            c1.h0.h0(n1.this.O.get(), "Channel must have been shut down");
            n1 n1Var = n1.this;
            n1Var.Q = true;
            n1Var.e1(false);
            n1.this.Y0();
            n1.this.Z0();
        }

        @Override // wj.r1.a
        public void b() {
        }

        @Override // wj.r1.a
        public void c(boolean z10) {
            n1 n1Var = n1.this;
            n1Var.f18981k0.e(n1Var.M, z10);
        }

        @Override // wj.r1.a
        public void d(vj.y2 y2Var) {
            c1.h0.h0(n1.this.O.get(), "Channel must have been shut down");
        }

        @Override // wj.r1.a
        public vj.a e(vj.a aVar) {
            return aVar;
        }

        public /* synthetic */ q(n1 n1Var, a aVar) {
            this();
        }
    }

    @b1.e
    public static final class r implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z1<? extends Executor> f19035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f19036b;

        public r(z1<? extends Executor> z1Var) {
            this.f19035a = (z1) c1.h0.F(z1Var, "executorPool");
        }

        public synchronized Executor a() {
            try {
                if (this.f19036b == null) {
                    this.f19036b = (Executor) c1.h0.V(this.f19035a.a(), "%s.getObject()", this.f19036b);
                }
            } catch (Throwable th2) {
                throw th2;
            }
            return this.f19036b;
        }

        public synchronized void b() {
            Executor executor = this.f19036b;
            if (executor != null) {
                this.f19036b = this.f19035a.b(executor);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    public final class s extends a1<Object> {
        public s() {
        }

        @Override // wj.a1
        public void b() {
            n1.this.R0();
        }

        @Override // wj.a1
        public void c() {
            if (n1.this.O.get()) {
                return;
            }
            n1.this.c1();
        }

        public /* synthetic */ s(n1 n1Var, a aVar) {
            this();
        }
    }

    public class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n1.this.F == null) {
                return;
            }
            n1.this.Q0();
        }

        public /* synthetic */ t(n1 n1Var, a aVar) {
            this();
        }
    }

    public final class v extends vj.x1.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f19057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.x1 f19058b;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f19060a;

            public a(vj.y2 y2Var) {
                this.f19060a = y2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.e(this.f19060a);
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.x1.g f19062a;

            public b(vj.x1.g gVar) {
                this.f19062a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                q1 q1Var;
                Object obj;
                vj.x1 x1Var = n1.this.D;
                v vVar = v.this;
                if (x1Var != vVar.f19058b) {
                    return;
                }
                vj.x1.g gVar = this.f19062a;
                List<vj.d0> list = gVar.f17533a;
                vj.h hVar = n1.this.W;
                vj.h.a aVar = vj.h.a.DEBUG;
                hVar.b(aVar, "Resolved address: {0}, config={1}", list, gVar.f17534b);
                n1 n1Var = n1.this;
                x xVar = n1Var.Z;
                x xVar2 = x.SUCCESS;
                if (xVar != xVar2) {
                    n1Var.W.b(vj.h.a.INFO, "Address resolved: {0}", list);
                    n1.this.Z = xVar2;
                }
                vj.x1.g gVar2 = this.f19062a;
                vj.x1.c cVar = gVar2.f17535c;
                p2.b bVar = (p2.b) gVar2.f17534b.f17048a.get(p2.f19159e);
                vj.x0 x0Var = (vj.x0) this.f19062a.f17534b.f17048a.get(vj.x0.f17506a);
                q1 q1Var2 = (cVar == null || (obj = cVar.f17532b) == null) ? null : (q1) obj;
                vj.y2 y2Var = cVar != null ? cVar.f17531a : null;
                n1 n1Var2 = n1.this;
                if (n1Var2.f18967d0) {
                    if (q1Var2 == null) {
                        q1Var2 = n1Var2.f18963b0;
                        if (q1Var2 != null) {
                            n1Var2.Y.r(q1Var2.c());
                            n1.this.W.a(vj.h.a.INFO, "Received no service config, using default service config");
                        } else if (y2Var == null) {
                            q1Var2 = n1.f18957u0;
                            n1Var2.Y.r(null);
                        } else {
                            if (!n1Var2.f18965c0) {
                                n1Var2.W.a(vj.h.a.INFO, "Fallback to error due to invalid first service config without default config");
                                v.this.a(cVar.f17531a);
                                if (bVar != null) {
                                    bVar.a(cVar.f17531a);
                                    return;
                                }
                                return;
                            }
                            q1Var2 = n1Var2.f18961a0;
                        }
                    } else if (x0Var != null) {
                        n1Var2.Y.r(x0Var);
                        if (q1Var2.c() != null) {
                            n1.this.W.a(aVar, "Method configs in service config will be discarded due to presence ofconfig-selector");
                        }
                    } else {
                        n1Var2.Y.r(q1Var2.c());
                    }
                    if (!q1Var2.equals(n1.this.f18961a0)) {
                        n1.this.W.b(vj.h.a.INFO, "Service config changed{0}", q1Var2 == n1.f18957u0 ? " to empty" : "");
                        n1 n1Var3 = n1.this;
                        n1Var3.f18961a0 = q1Var2;
                        n1Var3.f18983l0.f19021a = q1Var2.f19178d;
                    }
                    try {
                        n1.this.f18965c0 = true;
                    } catch (RuntimeException e10) {
                        n1.f18950n0.log(Level.WARNING, "[" + n1.this.f18960a + "] Unexpected exception from parsing service config", (Throwable) e10);
                    }
                    q1Var = q1Var2;
                } else {
                    if (q1Var2 != null) {
                        n1Var2.W.a(vj.h.a.INFO, "Service config from name resolver discarded by channel settings");
                    }
                    n1 n1Var4 = n1.this;
                    q1Var = n1Var4.f18963b0;
                    if (q1Var == null) {
                        q1Var = n1.f18957u0;
                    }
                    if (x0Var != null) {
                        n1Var4.W.a(vj.h.a.INFO, "Config selector from name resolver discarded by channel settings");
                    }
                    n1.this.Y.r(q1Var.c());
                }
                vj.a aVar2 = this.f19062a.f17534b;
                v vVar2 = v.this;
                if (vVar2.f19057a == n1.this.F) {
                    aVar2.getClass();
                    vj.a.b bVarC = new vj.a.b(aVar2).c(vj.x0.f17506a);
                    Map<String, ?> map = q1Var.f19180f;
                    if (map != null) {
                        bVarC.d(vj.o1.f17196b, map).a();
                    }
                    vj.a aVarA = bVarC.a();
                    wj.j.b bVar2 = v.this.f19057a.f19039a;
                    vj.o1.i.a aVar3 = new vj.o1.i.a();
                    aVar3.f17220a = list;
                    aVar3.f17221b = aVarA;
                    aVar3.f17222c = q1Var.f19179e;
                    vj.y2 y2VarH = bVar2.h(aVar3.a());
                    if (bVar != null) {
                        bVar.a(y2VarH);
                    }
                }
            }
        }

        public v(u uVar, vj.x1 x1Var) {
            this.f19057a = (u) c1.h0.F(uVar, "helperImpl");
            this.f19058b = (vj.x1) c1.h0.F(x1Var, "resolver");
        }

        @Override // vj.x1.e, vj.x1.f
        public void a(vj.y2 y2Var) {
            c1.h0.e(!y2Var.r(), "the error status must not be OK");
            n1.this.f18991s.execute(new a(y2Var));
        }

        @Override // vj.x1.e
        public void c(vj.x1.g gVar) {
            n1.this.f18991s.execute(new b(gVar));
        }

        public final void e(vj.y2 y2Var) {
            n1.f18950n0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{n1.this.f18960a, y2Var});
            n1.this.Y.p();
            n1 n1Var = n1.this;
            x xVar = n1Var.Z;
            x xVar2 = x.ERROR;
            if (xVar != xVar2) {
                n1Var.W.b(vj.h.a.WARNING, "Failed to resolve name: {0}", y2Var);
                n1.this.Z = xVar2;
            }
            u uVar = this.f19057a;
            if (uVar != n1.this.F) {
                return;
            }
            uVar.f19039a.c(y2Var);
        }
    }

    public class w extends vj.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<vj.x0> f19064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vj.f f19066c;

        public class a extends vj.f {
            public a() {
            }

            @Override // vj.f
            public String b() {
                return w.this.f19065b;
            }

            @Override // vj.f
            public <RequestT, ResponseT> vj.k<RequestT, ResponseT> g(vj.w1<RequestT, ResponseT> w1Var, vj.e eVar) {
                Executor executorS0 = n1.this.S0(eVar);
                n1 n1Var = n1.this;
                wj.r rVar = new wj.r(w1Var, executorS0, eVar, n1Var.f18983l0, n1Var.R ? null : n1.this.f18976i.m(), n1.this.U, null);
                n1 n1Var2 = n1.this;
                rVar.f19223o = n1Var2.f18992t;
                rVar.f19224p = n1Var2.f18993u;
                rVar.f19225q = n1Var2.f18994v;
                return rVar;
            }
        }

        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (n1.this.J == null) {
                    if (w.this.f19064a.get() == n1.f18958v0) {
                        w.this.f19064a.set(null);
                    }
                    n1.this.N.b(n1.f18955s0);
                }
            }
        }

        public final class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (w.this.f19064a.get() == n1.f18958v0) {
                    w.this.f19064a.set(null);
                }
                Collection<g<?, ?>> collection = n1.this.J;
                if (collection != null) {
                    Iterator<g<?, ?>> it = collection.iterator();
                    while (it.hasNext()) {
                        it.next().a("Channel is forcefully shutdown", null);
                    }
                }
                n1.this.N.c(n1.f18954r0);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n1.this.R0();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
        public class e<ReqT, RespT> extends vj.k<ReqT, RespT> {
            public e() {
            }

            @Override // vj.k
            public void a(@gm.j String str, @gm.j Throwable th2) {
            }

            @Override // vj.k
            public void c() {
            }

            @Override // vj.k
            public void e(int i10) {
            }

            @Override // vj.k
            public void f(ReqT reqt) {
            }

            @Override // vj.k
            public void h(vj.k.a<RespT> aVar, vj.v1 v1Var) {
                aVar.a(n1.f18955s0, new vj.v1());
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f19073a;

            public f(g gVar) {
                this.f19073a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (w.this.f19064a.get() != n1.f18958v0) {
                    this.f19073a.v();
                    return;
                }
                n1 n1Var = n1.this;
                if (n1Var.J == null) {
                    n1Var.J = new LinkedHashSet();
                    n1 n1Var2 = n1.this;
                    n1Var2.f18981k0.e(n1Var2.K, true);
                }
                n1.this.J.add(this.f19073a);
            }
        }

        public final class g<ReqT, RespT> extends c0<ReqT, RespT> {

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final vj.w f19075m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final vj.w1<ReqT, RespT> f19076n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final vj.e f19077o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final long f19078p;

            public class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f19080a;

                public a(Runnable runnable) {
                    this.f19080a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f19080a.run();
                    g gVar = g.this;
                    n1.this.f18991s.execute(new b());
                }
            }

            public final class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (n1.this.J != null) {
                        g gVar = g.this;
                        n1.this.J.remove(gVar);
                        if (n1.this.J.isEmpty()) {
                            n1 n1Var = n1.this;
                            n1Var.f18981k0.e(n1Var.K, false);
                            n1 n1Var2 = n1.this;
                            n1Var2.J = null;
                            if (n1Var2.O.get()) {
                                n1.this.N.b(n1.f18955s0);
                            }
                        }
                    }
                }
            }

            public g(vj.w wVar, vj.w1<ReqT, RespT> w1Var, vj.e eVar) {
                super(n1.this.S0(eVar), n1.this.f18980k, eVar.f17086a);
                this.f19075m = wVar;
                this.f19076n = w1Var;
                this.f19077o = eVar;
                this.f19078p = n1.this.f18977i0.a();
            }

            @Override // wj.c0
            public void m() {
                n1.this.f18991s.execute(new b());
            }

            public void v() {
                vj.w wVarC = this.f19075m.c();
                try {
                    vj.k<ReqT, RespT> kVarO = w.this.o(this.f19076n, this.f19077o.x(vj.n.f17186a, Long.valueOf(n1.this.f18977i0.a() - this.f19078p)));
                    this.f19075m.q(wVarC);
                    Runnable runnableT = t(kVarO);
                    if (runnableT == null) {
                        n1.this.f18991s.execute(new b());
                    } else {
                        n1.this.S0(this.f19077o).execute(new a(runnableT));
                    }
                } catch (Throwable th2) {
                    this.f19075m.q(wVarC);
                    throw th2;
                }
            }
        }

        public /* synthetic */ w(n1 n1Var, String str, a aVar) {
            this(str);
        }

        @Override // vj.f
        public String b() {
            return this.f19065b;
        }

        @Override // vj.f
        public <ReqT, RespT> vj.k<ReqT, RespT> g(vj.w1<ReqT, RespT> w1Var, vj.e eVar) {
            if (this.f19064a.get() != n1.f18958v0) {
                return o(w1Var, eVar);
            }
            n1.this.f18991s.execute(new d());
            if (this.f19064a.get() != n1.f18958v0) {
                return o(w1Var, eVar);
            }
            if (n1.this.O.get()) {
                return new e();
            }
            g gVar = new g(vj.w.o(), w1Var, eVar);
            n1.this.f18991s.execute(new f(gVar));
            return gVar;
        }

        public final <ReqT, RespT> vj.k<ReqT, RespT> o(vj.w1<ReqT, RespT> w1Var, vj.e eVar) {
            vj.x0 x0Var = this.f19064a.get();
            if (x0Var == null) {
                return this.f19066c.g(w1Var, eVar);
            }
            if (!(x0Var instanceof q1.c)) {
                return new p(x0Var, this.f19066c, n1.this.f18982l, w1Var, eVar);
            }
            q1.b bVarF = ((q1.c) x0Var).f19188b.f(w1Var);
            if (bVarF != null) {
                eVar = eVar.x(q1.b.f19181g, bVarF);
            }
            return this.f19066c.g(w1Var, eVar);
        }

        public void p() {
            if (this.f19064a.get() == n1.f18958v0) {
                r(null);
            }
        }

        public void q() {
            n1.this.f18991s.execute(new c());
        }

        public void r(@gm.j vj.x0 x0Var) {
            Collection<g<?, ?>> collection;
            vj.x0 x0Var2 = this.f19064a.get();
            this.f19064a.set(x0Var);
            if (x0Var2 != n1.f18958v0 || (collection = n1.this.J) == null) {
                return;
            }
            Iterator<g<?, ?>> it = collection.iterator();
            while (it.hasNext()) {
                it.next().v();
            }
        }

        public void shutdown() {
            n1.this.f18991s.execute(new b());
        }

        public w(String str) {
            this.f19064a = new AtomicReference<>(n1.f18958v0);
            this.f19066c = new a();
            this.f19065b = (String) c1.h0.F(str, "authority");
        }
    }

    public enum x {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    public static final class y implements ScheduledExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f19084a;

        public /* synthetic */ y(ScheduledExecutorService scheduledExecutorService, a aVar) {
            this(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.f19084a.awaitTermination(j10, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f19084a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.f19084a.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
            return (T) this.f19084a.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f19084a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f19084a.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
            return this.f19084a.schedule(callable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f19084a.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f19084a.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.f19084a.submit(callable);
        }

        public y(ScheduledExecutorService scheduledExecutorService) {
            this.f19084a = (ScheduledExecutorService) c1.h0.F(scheduledExecutorService, "delegate");
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.f19084a.invokeAll(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (T) this.f19084a.invokeAny(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f19084a.schedule(runnable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.f19084a.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t10) {
            return this.f19084a.submit(runnable, t10);
        }
    }

    public final class z extends wj.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.b f19085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.c1 f19086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final wj.p f19087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final wj.q f19088d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<vj.d0> f19089e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e1 f19090f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19091g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19092h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public vj.c3.d f19093i;

        public final class a extends e1.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.o1.l f19095a;

            public a(vj.o1.l lVar) {
                this.f19095a = lVar;
            }

            @Override // wj.e1.l
            public void a(e1 e1Var) {
                n1.this.f18981k0.e(e1Var, true);
            }

            @Override // wj.e1.l
            public void b(e1 e1Var) {
                n1.this.f18981k0.e(e1Var, false);
            }

            @Override // wj.e1.l
            public void c(e1 e1Var, vj.v vVar) {
                c1.h0.h0(this.f19095a != null, "listener is null");
                this.f19095a.a(vVar);
            }

            @Override // wj.e1.l
            public void d(e1 e1Var) {
                n1.this.I.remove(e1Var);
                n1.this.X.D(e1Var);
                n1.this.Z0();
            }
        }

        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                z.this.f19090f.n(n1.f18956t0);
            }
        }

        public z(vj.o1.b bVar) {
            c1.h0.F(bVar, d6.a.F);
            this.f19089e = bVar.f17202a;
            if (n1.this.f18964c != null) {
                bVar = bVar.e().e(l(bVar.f17202a)).c();
            }
            this.f19085a = bVar;
            vj.c1 c1VarB = vj.c1.b("Subchannel", n1.this.A.b());
            this.f19086b = c1VarB;
            wj.q qVar = new wj.q(c1VarB, n1.this.f18990r, n1.this.f18989q.a(), "Subchannel for " + bVar.f17202a);
            this.f19088d = qVar;
            this.f19087c = new wj.p(qVar, n1.this.f18989q);
        }

        @Override // vj.o1.j
        public vj.f a() {
            c1.h0.h0(this.f19091g, "not started");
            return new l3(this.f19090f, n1.this.f18987o.a(), n1.this.f18976i.m(), n1.this.T.a(), new AtomicReference(null));
        }

        @Override // vj.o1.j
        public List<vj.d0> c() {
            n1.this.f18991s.e();
            c1.h0.h0(this.f19091g, "not started");
            return this.f19089e;
        }

        @Override // vj.o1.j
        public vj.a d() {
            return this.f19085a.f17203b;
        }

        @Override // vj.o1.j
        public vj.h e() {
            return this.f19087c;
        }

        @Override // vj.o1.j
        public Object f() {
            c1.h0.h0(this.f19091g, "Subchannel is not started");
            return this.f19090f;
        }

        @Override // vj.o1.j
        public void g() {
            n1.this.f18991s.e();
            c1.h0.h0(this.f19091g, "not started");
            this.f19090f.b();
        }

        @Override // vj.o1.j
        public void h() {
            vj.c3.d dVar;
            n1.this.f18991s.e();
            if (this.f19090f == null) {
                this.f19092h = true;
                return;
            }
            if (!this.f19092h) {
                this.f19092h = true;
            } else {
                if (!n1.this.Q || (dVar = this.f19093i) == null) {
                    return;
                }
                dVar.a();
                this.f19093i = null;
            }
            n1 n1Var = n1.this;
            if (n1Var.Q) {
                this.f19090f.n(n1.f18955s0);
            } else {
                this.f19093i = n1Var.f18991s.c(new k1(new b()), 5L, TimeUnit.SECONDS, n1.this.f18976i.m());
            }
        }

        @Override // vj.o1.j
        public void i(vj.o1.l lVar) {
            n1.this.f18991s.e();
            c1.h0.h0(!this.f19091g, "already started");
            c1.h0.h0(!this.f19092h, "already shutdown");
            c1.h0.h0(!n1.this.Q, "Channel is being terminated");
            this.f19091g = true;
            List<vj.d0> list = this.f19085a.f17202a;
            String strB = n1.this.A.b();
            n1 n1Var = n1.this;
            String str = n1Var.C;
            wj.k.a aVar = n1Var.f18998z;
            wj.v vVar = n1Var.f18976i;
            ScheduledExecutorService scheduledExecutorServiceM = vVar.m();
            n1 n1Var2 = n1.this;
            c1.q0<c1.o0> q0Var = n1Var2.f18995w;
            vj.c3 c3Var = n1Var2.f18991s;
            a aVar2 = new a(lVar);
            n1 n1Var3 = n1.this;
            e1 e1Var = new e1(list, strB, str, aVar, vVar, scheduledExecutorServiceM, q0Var, c3Var, aVar2, n1Var3.X, n1Var3.T.a(), this.f19088d, this.f19086b, this.f19087c, n1.this.B);
            n1 n1Var4 = n1.this;
            wj.q qVar = n1Var4.V;
            vj.v0.c.b.a aVar3 = new vj.v0.c.b.a();
            aVar3.f17318a = "Child Subchannel started";
            aVar3.f17319b = vj.v0.c.b.EnumC0456b.CT_INFO;
            aVar3.f17320c = Long.valueOf(n1Var4.f18989q.a());
            aVar3.f17322e = e1Var;
            qVar.e(aVar3.a());
            this.f19090f = e1Var;
            n1.this.X.h(e1Var);
            n1.this.I.add(e1Var);
        }

        @Override // vj.o1.j
        public void j(List<vj.d0> list) {
            n1.this.f18991s.e();
            this.f19089e = list;
            if (n1.this.f18964c != null) {
                list = l(list);
            }
            this.f19090f.f0(list);
        }

        @Override // wj.e
        public vj.a1<vj.v0.b> k() {
            c1.h0.h0(this.f19091g, "not started");
            return this.f19090f;
        }

        public final List<vj.d0> l(List<vj.d0> list) {
            ArrayList arrayList = new ArrayList();
            for (vj.d0 d0Var : list) {
                List<SocketAddress> list2 = d0Var.f17080a;
                vj.a aVar = d0Var.f17081b;
                aVar.getClass();
                arrayList.add(new vj.d0(list2, new vj.a.b(aVar).c(vj.d0.f17079d).a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public String toString() {
            return this.f19086b.toString();
        }
    }

    static {
        vj.y2 y2Var = vj.y2.f17563t;
        f18954r0 = y2Var.u("Channel shutdownNow invoked");
        f18955s0 = y2Var.u("Channel shutdown invoked");
        f18956t0 = y2Var.u("Subchannel shutdown invoked");
        f18957u0 = q1.a();
        f18958v0 = new a();
        f18959w0 = new n();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public n1(o1 o1Var, wj.v vVar, wj.k.a aVar, z1<? extends Executor> z1Var, c1.q0<c1.o0> q0Var, List<vj.l> list, n3 n3Var) {
        vj.c3 c3Var = new vj.c3(new l());
        this.f18991s = c3Var;
        this.f18997y = new wj.y();
        this.I = new HashSet(16, 0.75f);
        this.K = new Object();
        this.L = new HashSet(1, 0.75f);
        this.N = new a0();
        this.O = new AtomicBoolean(false);
        this.S = new CountDownLatch(1);
        this.Z = x.NO_RESOLUTION;
        this.f18961a0 = f18957u0;
        this.f18965c0 = false;
        this.f18969e0 = new m2.u();
        this.f18977i0 = vj.y.k();
        q qVar = new q();
        this.f18979j0 = qVar;
        this.f18981k0 = new s();
        this.f18983l0 = new o();
        String str = (String) c1.h0.F(o1Var.f19116f, TypedValues.AttributesType.S_TARGET);
        this.f18962b = str;
        vj.c1 c1VarB = vj.c1.b("Channel", str);
        this.f18960a = c1VarB;
        this.f18989q = (n3) c1.h0.F(n3Var, "timeProvider");
        z1<? extends Executor> z1Var2 = (z1) c1.h0.F(o1Var.f19111a, "executorPool");
        this.f18984m = z1Var2;
        Executor executor = (Executor) c1.h0.F(z1Var2.a(), "executor");
        this.f18982l = executor;
        this.f18974h = o1Var.f19117g;
        this.f18972g = vVar;
        r rVar = new r((z1) c1.h0.F(o1Var.f19112b, "offloadExecutorPool"));
        this.f18988p = rVar;
        wj.n nVar = new wj.n(vVar, o1Var.f19118h, rVar);
        this.f18976i = nVar;
        this.f18978j = new wj.n(vVar, null, rVar);
        y yVar = new y(nVar.m());
        this.f18980k = yVar;
        this.f18990r = o1Var.f19133w;
        wj.q qVar2 = new wj.q(c1VarB, o1Var.f19133w, n3Var.a(), n.a.a("Channel for '", str, "'"));
        this.V = qVar2;
        wj.p pVar = new wj.p(qVar2, n3Var);
        this.W = pVar;
        vj.g2 g2Var = o1Var.A;
        g2Var = g2Var == null ? v0.F : g2Var;
        boolean z10 = o1Var.f19131u;
        this.f18975h0 = z10;
        wj.j jVar = new wj.j(o1Var.f19122l);
        this.f18970f = jVar;
        vj.z1 z1Var3 = o1Var.f19114d;
        this.f18966d = z1Var3;
        r2 r2Var = new r2(z10, o1Var.f19127q, o1Var.f19128r, jVar);
        String str2 = o1Var.f19121k;
        this.f18964c = str2;
        vj.x1.b.a aVar2 = new vj.x1.b.a();
        aVar2.f17522a = Integer.valueOf(o1Var.J.b());
        g2Var.getClass();
        aVar2.f17523b = g2Var;
        aVar2.f17524c = c3Var;
        aVar2.f17526e = yVar;
        aVar2.f17525d = r2Var;
        aVar2.f17527f = pVar;
        aVar2.f17528g = rVar;
        aVar2.f17529h = str2;
        vj.x1.b bVarA = aVar2.a();
        this.f18968e = bVarA;
        this.D = U0(str, str2, z1Var3, bVarA, nVar.a2());
        this.f18986n = (z1) c1.h0.F(z1Var, "balancerRpcExecutorPool");
        this.f18987o = new r(z1Var);
        d0 d0Var = new d0(executor, c3Var);
        this.M = d0Var;
        d0Var.f(qVar);
        this.f18998z = aVar;
        Map<String, ?> map = o1Var.f19134x;
        if (map != null) {
            vj.x1.c cVarA = r2Var.a(map);
            vj.y2 y2Var = cVarA.f17531a;
            c1.h0.x0(y2Var == null, "Default config is invalid: %s", y2Var);
            q1 q1Var = (q1) cVarA.f17532b;
            this.f18963b0 = q1Var;
            this.f18961a0 = q1Var;
        } else {
            this.f18963b0 = null;
        }
        boolean z11 = o1Var.f19135y;
        this.f18967d0 = z11;
        w wVar = new w(this.D.a());
        this.Y = wVar;
        vj.b bVar = o1Var.f19136z;
        this.A = vj.m.b(bVar != null ? bVar.b(wVar) : wVar, list);
        this.B = new ArrayList(o1Var.f19115e);
        this.f18995w = (c1.q0) c1.h0.F(q0Var, "stopwatchSupplier");
        long j10 = o1Var.f19126p;
        if (j10 == -1) {
            this.f18996x = j10;
        } else {
            c1.h0.p(j10 >= o1.O, "invalid idleTimeoutMillis %s", j10);
            this.f18996x = o1Var.f19126p;
        }
        this.f18985m0 = new l2(new t(), c3Var, nVar.m(), q0Var.get());
        this.f18992t = o1Var.f19123m;
        this.f18993u = (vj.a0) c1.h0.F(o1Var.f19124n, "decompressorRegistry");
        this.f18994v = (vj.t) c1.h0.F(o1Var.f19125o, "compressorRegistry");
        this.C = o1Var.f19120j;
        this.f18973g0 = o1Var.f19129s;
        this.f18971f0 = o1Var.f19130t;
        c cVar = new c(n3Var);
        this.T = cVar;
        this.U = cVar.a();
        vj.v0 v0Var = o1Var.f19132v;
        v0Var.getClass();
        this.X = v0Var;
        v0Var.e(this);
        if (z11) {
            return;
        }
        if (this.f18963b0 != null) {
            pVar.a(vj.h.a.INFO, "Service config look-up disabled, using default service config");
        }
        this.f18965c0 = true;
    }

    @b1.e
    public static vj.x1 U0(String str, @gm.j String str2, vj.z1 z1Var, vj.x1.b bVar, Collection<Class<? extends SocketAddress>> collection) {
        p2 p2Var = new p2(V0(str, z1Var, bVar, collection), new wj.m(new h0.a(), bVar.f(), bVar.f17516c), bVar.f17516c);
        return str2 == null ? p2Var : new m(p2Var, str2);
    }

    public static vj.x1 V0(String str, vj.z1 z1Var, vj.x1.b bVar, Collection<Class<? extends SocketAddress>> collection) {
        URI uri;
        StringBuilder sb2 = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e10) {
            sb2.append(e10.getMessage());
            uri = null;
        }
        vj.y1 y1VarG = uri != null ? z1Var.g(uri.getScheme()) : null;
        String str2 = "";
        if (y1VarG == null && !f18951o0.matcher(str).matches()) {
            try {
                uri = new URI(z1Var.e(), "", "/" + str, null);
                y1VarG = z1Var.g(uri.getScheme());
            } catch (URISyntaxException e11) {
                throw new IllegalArgumentException(e11);
            }
        }
        if (y1VarG == null) {
            if (sb2.length() > 0) {
                str2 = " (" + ((Object) sb2) + ")";
            }
            throw new IllegalArgumentException(String.format("Could not find a NameResolverProvider for %s%s", str, str2));
        }
        if (collection != null && !collection.containsAll(y1VarG.c())) {
            throw new IllegalArgumentException(String.format("Address types of NameResolver '%s' for '%s' not supported by transport", uri.getScheme(), str));
        }
        vj.x1 x1VarB = y1VarG.b(uri, bVar);
        if (x1VarB != null) {
            return x1VarB;
        }
        if (sb2.length() > 0) {
            str2 = " (" + ((Object) sb2) + ")";
        }
        throw new IllegalArgumentException(String.format("cannot create a NameResolver for %s%s", str, str2));
    }

    public final void P0(boolean z10) {
        this.f18985m0.i(z10);
    }

    public final void Q0() {
        e1(true);
        this.M.u(null);
        this.W.a(vj.h.a.INFO, "Entering IDLE state");
        this.f18997y.b(vj.u.IDLE);
        if (this.f18981k0.a(this.K, this.M)) {
            R0();
        }
    }

    @b1.e
    public void R0() {
        this.f18991s.e();
        if (this.O.get() || this.H) {
            return;
        }
        if (this.f18981k0.d()) {
            P0(false);
        } else {
            c1();
        }
        if (this.F != null) {
            return;
        }
        this.W.a(vj.h.a.INFO, "Exiting idle mode");
        u uVar = new u();
        wj.j jVar = this.f18970f;
        jVar.getClass();
        uVar.f19039a = jVar.new b(uVar);
        this.F = uVar;
        this.D.d(new v(uVar, this.D));
        this.E = true;
    }

    public final Executor S0(vj.e eVar) {
        Executor executor = eVar.f17087b;
        return executor == null ? this.f18982l : executor;
    }

    @b1.e
    public vj.x0 T0() {
        return this.Y.f19064a.get();
    }

    public final void W0(vj.v vVar) {
        vj.u uVar = vVar.f17279a;
        if (uVar == vj.u.TRANSIENT_FAILURE || uVar == vj.u.IDLE) {
            b1();
        }
    }

    @b1.e
    public boolean X0() {
        return this.H;
    }

    public final void Y0() {
        if (this.P) {
            Iterator<e1> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().a(f18954r0);
            }
            Iterator<a2> it2 = this.L.iterator();
            while (it2.hasNext()) {
                it2.next().f18318a.a(f18954r0);
            }
        }
    }

    public final void Z0() {
        if (!this.R && this.O.get() && this.I.isEmpty() && this.L.isEmpty()) {
            this.W.a(vj.h.a.INFO, "Terminated");
            this.X.A(this);
            this.f18984m.b(this.f18982l);
            this.f18987o.b();
            this.f18988p.b();
            this.f18976i.close();
            this.R = true;
            this.S.countDown();
        }
    }

    @b1.e
    public void a1(Throwable th2) {
        if (this.H) {
            return;
        }
        this.H = true;
        P0(true);
        e1(false);
        g1(new e(th2));
        this.Y.r(null);
        this.W.a(vj.h.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.f18997y.b(vj.u.TRANSIENT_FAILURE);
    }

    @Override // vj.f
    public String b() {
        return this.A.b();
    }

    public final void b1() {
        this.f18991s.e();
        if (this.E) {
            this.D.b();
        }
    }

    public final void c1() {
        long j10 = this.f18996x;
        if (j10 == -1) {
            return;
        }
        this.f18985m0.l(j10, TimeUnit.MILLISECONDS);
    }

    @Override // vj.r1
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public n1 s() {
        this.W.a(vj.h.a.DEBUG, "shutdown() called");
        if (!this.O.compareAndSet(false, true)) {
            return this;
        }
        this.f18991s.execute(new i());
        this.Y.shutdown();
        this.f18991s.execute(new b());
        return this;
    }

    @Override // vj.m1
    public vj.c1 e() {
        return this.f18960a;
    }

    public final void e1(boolean z10) {
        this.f18991s.e();
        if (z10) {
            c1.h0.h0(this.E, "nameResolver is not started");
            c1.h0.h0(this.F != null, "lbHelper is null");
        }
        vj.x1 x1Var = this.D;
        if (x1Var != null) {
            x1Var.c();
            this.E = false;
            if (z10) {
                this.D = U0(this.f18962b, this.f18964c, this.f18966d, this.f18968e, this.f18976i.a2());
            } else {
                this.D = null;
            }
        }
        u uVar = this.F;
        if (uVar != null) {
            uVar.f19039a.g();
            this.F = null;
        }
        this.G = null;
    }

    @Override // vj.r1
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public n1 t() {
        this.W.a(vj.h.a.DEBUG, "shutdownNow() called");
        s();
        this.Y.q();
        this.f18991s.execute(new j());
        return this;
    }

    @Override // vj.f
    public <ReqT, RespT> vj.k<ReqT, RespT> g(vj.w1<ReqT, RespT> w1Var, vj.e eVar) {
        return this.A.g(w1Var, eVar);
    }

    public final void g1(vj.o1.k kVar) {
        this.G = kVar;
        this.M.u(kVar);
    }

    @Override // vj.r1
    public boolean h(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.S.await(j10, timeUnit);
    }

    @Override // vj.r1
    public void i() {
        this.f18991s.execute(new f());
    }

    @Override // vj.a1
    public q1.s1<vj.v0.b> j() {
        q1.l2 l2VarF = q1.l2.F();
        this.f18991s.execute(new k(l2VarF));
        return l2VarF;
    }

    @Override // vj.r1
    public vj.u l(boolean z10) {
        vj.u uVarA = this.f18997y.a();
        if (z10 && uVarA == vj.u.IDLE) {
            this.f18991s.execute(new g());
        }
        return uVarA;
    }

    @Override // vj.r1
    public boolean o() {
        return this.O.get();
    }

    @Override // vj.r1
    public boolean p() {
        return this.R;
    }

    @Override // vj.r1
    public void q(vj.u uVar, Runnable runnable) {
        this.f18991s.execute(new d(runnable, uVar));
    }

    @Override // vj.r1
    public void r() {
        this.f18991s.execute(new h());
    }

    public String toString() {
        return c1.z.c(this).e("logId", this.f18960a.f17063c).j(TypedValues.AttributesType.S_TARGET, this.f18962b).toString();
    }

    public final class u extends vj.o1.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wj.j.b f19039a;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a2 f19041a;

            public a(a2 a2Var) {
                this.f19041a = a2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (n1.this.Q) {
                    this.f19041a.s();
                }
                if (n1.this.R) {
                    return;
                }
                n1.this.L.add(this.f19041a);
            }
        }

        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n1.this.b1();
            }
        }

        public final class c extends e1.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a2 f19044a;

            public c(a2 a2Var) {
                this.f19044a = a2Var;
            }

            @Override // wj.e1.l
            public void c(e1 e1Var, vj.v vVar) {
                n1.this.W0(vVar);
                this.f19044a.y(vVar);
            }

            @Override // wj.e1.l
            public void d(e1 e1Var) {
                n1.this.L.remove(this.f19044a);
                n1.this.X.D(e1Var);
                this.f19044a.z();
                n1.this.Z0();
            }
        }

        public final class d extends vj.f0<d> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final vj.s1<?> f19046a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vj.g f19047b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f19048c;

            public class a implements o1.c {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ u f19050a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ wj.v f19051b;

                public a(u uVar, wj.v vVar) {
                    this.f19050a = uVar;
                    this.f19051b = vVar;
                }

                @Override // wj.o1.c
                public wj.v a() {
                    return this.f19051b;
                }
            }

            public d(vj.g gVar, String str) {
                vj.d dVar;
                wj.v vVar;
                this.f19047b = gVar;
                this.f19048c = str;
                if (gVar instanceof f) {
                    vVar = n1.this.f18972g;
                    dVar = null;
                } else {
                    wj.v.b bVarE1 = n1.this.f18972g.E1(gVar);
                    if (bVarE1 == null) {
                        this.f19046a = vj.n0.b(str, gVar);
                        return;
                    } else {
                        wj.v vVar2 = bVarE1.f19353a;
                        dVar = bVarE1.f19354b;
                        vVar = vVar2;
                    }
                }
                o1 o1Var = new o1(str, gVar, dVar, new a(u.this, vVar), new o1.e(n1.this.f18968e.f17514a));
                o1Var.f19114d = n1.this.f18966d;
                this.f19046a = o1Var;
            }

            @Override // vj.f0
            public vj.s1<?> J() {
                return this.f19046a;
            }
        }

        public final class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.o1.k f19053a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vj.u f19054b;

            public e(vj.o1.k kVar, vj.u uVar) {
                this.f19053a = kVar;
                this.f19054b = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar = u.this;
                if (uVar != n1.this.F) {
                    return;
                }
                n1.this.g1(this.f19053a);
                vj.u uVar2 = this.f19054b;
                if (uVar2 != vj.u.SHUTDOWN) {
                    n1.this.W.b(vj.h.a.INFO, "Entering {0} state with picker: {1}", uVar2, this.f19053a);
                    n1.this.f18997y.b(this.f19054b);
                }
            }
        }

        public final class f extends vj.g {
            public f() {
            }

            @Override // vj.g
            public vj.g a() {
                return this;
            }
        }

        public u() {
        }

        @Override // vj.o1.f
        public vj.r1 a(List<vj.d0> list, String str) {
            c1.h0.h0(!n1.this.R, "Channel is terminated");
            long jA = n1.this.f18989q.a();
            vj.c1 c1VarB = vj.c1.b("OobChannel", null);
            vj.c1 c1VarB2 = vj.c1.b("Subchannel-OOB", str);
            wj.q qVar = new wj.q(c1VarB, n1.this.f18990r, jA, "OobChannel for " + list);
            n1 n1Var = n1.this;
            z1<? extends Executor> z1Var = n1Var.f18986n;
            ScheduledExecutorService scheduledExecutorServiceM = n1Var.f18978j.m();
            n1 n1Var2 = n1.this;
            vj.c3 c3Var = n1Var2.f18991s;
            wj.o oVarA = n1Var2.T.a();
            n1 n1Var3 = n1.this;
            a2 a2Var = new a2(str, z1Var, scheduledExecutorServiceM, c3Var, oVarA, qVar, n1Var3.X, n1Var3.f18989q);
            wj.q qVar2 = n1.this.V;
            vj.v0.c.b.a aVar = new vj.v0.c.b.a();
            aVar.f17318a = "Child OobChannel created";
            vj.v0.c.b.EnumC0456b enumC0456b = vj.v0.c.b.EnumC0456b.CT_INFO;
            aVar.f17319b = enumC0456b;
            aVar.f17320c = Long.valueOf(jA);
            aVar.f17321d = a2Var;
            qVar2.e(aVar.a());
            wj.q qVar3 = new wj.q(c1VarB2, n1.this.f18990r, jA, "Subchannel for " + list);
            wj.p pVar = new wj.p(qVar3, n1.this.f18989q);
            n1 n1Var4 = n1.this;
            String str2 = n1Var4.C;
            wj.k.a aVar2 = n1Var4.f18998z;
            wj.v vVar = n1Var4.f18978j;
            ScheduledExecutorService scheduledExecutorServiceM2 = vVar.m();
            n1 n1Var5 = n1.this;
            c1.q0<c1.o0> q0Var = n1Var5.f18995w;
            vj.c3 c3Var2 = n1Var5.f18991s;
            c cVar = new c(a2Var);
            n1 n1Var6 = n1.this;
            e1 e1Var = new e1(list, str, str2, aVar2, vVar, scheduledExecutorServiceM2, q0Var, c3Var2, cVar, n1Var6.X, n1Var6.T.a(), qVar3, c1VarB2, pVar, n1.this.B);
            vj.v0.c.b.a aVar3 = new vj.v0.c.b.a();
            aVar3.f17318a = "Child Subchannel created";
            aVar3.f17319b = enumC0456b;
            aVar3.f17320c = Long.valueOf(jA);
            aVar3.f17322e = e1Var;
            qVar.e(aVar3.a());
            n1.this.X.h(a2Var);
            n1.this.X.h(e1Var);
            a2Var.A(e1Var);
            n1.this.f18991s.execute(new a(a2Var));
            return a2Var;
        }

        @Override // vj.o1.f
        public vj.r1 b(vj.d0 d0Var, String str) {
            return a(Collections.singletonList(d0Var), str);
        }

        @Override // vj.o1.f
        @Deprecated
        public vj.s1<?> d(String str) {
            return e(str, new f()).A(g());
        }

        @Override // vj.o1.f
        public vj.s1<?> e(String str, vj.g gVar) {
            c1.h0.F(gVar, "channelCreds");
            c1.h0.h0(!n1.this.R, "Channel is terminated");
            return new d(gVar, str).k(n1.this.f18982l).z(n1.this.f18988p.a()).x(n1.this.f18990r).C(n1.this.f18968e.f17515b).I(n1.this.C);
        }

        @Override // vj.o1.f
        public String g() {
            return n1.this.A.b();
        }

        @Override // vj.o1.f
        public vj.h i() {
            return n1.this.W;
        }

        @Override // vj.o1.f
        public vj.x1.b j() {
            return n1.this.f18968e;
        }

        @Override // vj.o1.f
        public vj.z1 k() {
            return n1.this.f18966d;
        }

        @Override // vj.o1.f
        public ScheduledExecutorService l() {
            return n1.this.f18980k;
        }

        @Override // vj.o1.f
        public vj.c3 m() {
            return n1.this.f18991s;
        }

        @Override // vj.o1.f
        public vj.g n() {
            return n1.this.f18974h == null ? new f() : n1.this.f18974h;
        }

        @Override // vj.o1.f
        public void p() {
            n1.this.f18991s.e();
            n1.this.f18991s.execute(new b());
        }

        @Override // vj.o1.f
        public void q(vj.u uVar, vj.o1.k kVar) {
            n1.this.f18991s.e();
            c1.h0.F(uVar, "newState");
            c1.h0.F(kVar, "newPicker");
            n1.this.f18991s.execute(new e(kVar, uVar));
        }

        @Override // vj.o1.f
        public void r(vj.r1 r1Var, List<vj.d0> list) {
            c1.h0.e(r1Var instanceof a2, "channel must have been returned from createOobChannel");
            ((a2) r1Var).B(list);
        }

        @Override // vj.o1.f
        public void s(vj.r1 r1Var, vj.d0 d0Var) {
            r(r1Var, Collections.singletonList(d0Var));
        }

        @Override // vj.o1.f
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public wj.e f(vj.o1.b bVar) {
            n1.this.f18991s.e();
            c1.h0.h0(!n1.this.Q, "Channel is being terminated");
            return n1.this.new z(bVar);
        }

        public /* synthetic */ u(n1 n1Var, a aVar) {
            this();
        }
    }

    public final class a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hm.a("lock")
        public Collection<wj.s> f19000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hm.a("lock")
        public vj.y2 f19001c;

        public a0() {
            this.f18999a = new Object();
            this.f19000b = new HashSet();
        }

        @gm.j
        public vj.y2 a(m2<?> m2Var) {
            synchronized (this.f18999a) {
                try {
                    vj.y2 y2Var = this.f19001c;
                    if (y2Var != null) {
                        return y2Var;
                    }
                    this.f19000b.add(m2Var);
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void b(vj.y2 y2Var) {
            synchronized (this.f18999a) {
                try {
                    if (this.f19001c != null) {
                        return;
                    }
                    this.f19001c = y2Var;
                    boolean zIsEmpty = this.f19000b.isEmpty();
                    if (zIsEmpty) {
                        n1.this.M.n(y2Var);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void c(vj.y2 y2Var) {
            ArrayList arrayList;
            b(y2Var);
            synchronized (this.f18999a) {
                arrayList = new ArrayList(this.f19000b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((wj.s) it.next()).a(y2Var);
            }
            n1.this.M.a(y2Var);
        }

        public void d(m2<?> m2Var) {
            vj.y2 y2Var;
            synchronized (this.f18999a) {
                try {
                    this.f19000b.remove(m2Var);
                    if (this.f19000b.isEmpty()) {
                        y2Var = this.f19001c;
                        this.f19000b = new HashSet();
                    } else {
                        y2Var = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (y2Var != null) {
                n1.this.M.n(y2Var);
            }
        }

        public /* synthetic */ a0(n1 n1Var, a aVar) {
            this();
        }
    }
}
