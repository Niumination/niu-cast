package wj;

import androidx.core.app.NotificationCompat;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class x2 extends vj.j2<x2> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Logger f19536u = Logger.getLogger(x2.class.getName());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final z1<? extends Executor> f19537v = new g3(v0.K);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final vj.o0 f19538w = new c();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final vj.a0 f19539x = vj.a0.c();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final vj.t f19540y = vj.t.a();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f19541z = TimeUnit.SECONDS.toMillis(120);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f19546e;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @gm.j
    public vj.b f19558q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @gm.j
    public vj.l2 f19561t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1.b f19542a = new c1.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<vj.v2> f19543b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<vj.o2> f19544c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<vj.u2.a> f19545d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public vj.o0 f19547f = f19538w;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z1<? extends Executor> f19548g = f19537v;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vj.a0 f19549h = f19539x;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public vj.t f19550i = f19540y;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f19551j = f19541z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public vj.y.c f19552k = vj.y.k();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19553l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19554m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19555n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19556o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f19557p = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public vj.v0 f19559r = vj.v0.w();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public o.b f19560s = o.a();

    public interface b {
        d1 a(List<? extends vj.u2.a> list);
    }

    public static final class c extends vj.o0 {
        public c() {
        }

        @Override // vj.o0
        public List<vj.t2> a() {
            return Collections.emptyList();
        }

        @Override // vj.o0
        @gm.j
        public vj.q2<?, ?> c(String str, @gm.j String str2) {
            return null;
        }

        public c(a aVar) {
        }
    }

    public x2(b bVar) {
        this.f19546e = (b) c1.h0.F(bVar, "clientTransportServersBuilder");
    }

    @t1.e("ClientTransportServersBuilder is required, use a constructor")
    public static vj.j2<?> m(int i10) {
        throw new UnsupportedOperationException("ClientTransportServersBuilder is required, use a constructor");
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public x2 a(vj.c cVar) {
        return b(((vj.c) c1.h0.F(cVar, "bindableService")).bindService());
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public x2 b(vj.t2 t2Var) {
        this.f19542a.a((vj.t2) c1.h0.F(t2Var, NotificationCompat.CATEGORY_SERVICE));
        return this;
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public x2 d(vj.u2.a aVar) {
        this.f19545d.add((vj.u2.a) c1.h0.F(aVar, "factory"));
        return this;
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public x2 e(vj.v2 v2Var) {
        this.f19543b.add((vj.v2) c1.h0.F(v2Var, "filter"));
        return this;
    }

    public x2 G(vj.l2 l2Var) {
        l2Var.getClass();
        this.f19561t = l2Var;
        return this;
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public x2 h(@gm.j vj.t tVar) {
        if (tVar == null) {
            tVar = f19540y;
        }
        this.f19550i = tVar;
        return this;
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public x2 i(@gm.j vj.a0 a0Var) {
        if (a0Var == null) {
            a0Var = f19539x;
        }
        this.f19549h = a0Var;
        return this;
    }

    public x2 J() {
        return k(q1.n0.INSTANCE);
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public x2 k(@gm.j Executor executor) {
        this.f19548g = executor != null ? new k0<>(executor) : f19537v;
        return this;
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public x2 l(@gm.j vj.o0 o0Var) {
        if (o0Var == null) {
            o0Var = f19538w;
        }
        this.f19547f = o0Var;
        return this;
    }

    public vj.v0 M() {
        return this.f19559r;
    }

    public z1<? extends Executor> N() {
        return this.f19548g;
    }

    @b1.e
    public List<? extends vj.u2.a> O() {
        boolean z10;
        vj.u2.a aVar;
        ArrayList arrayList = new ArrayList();
        List<vj.o2> listB = vj.m0.b();
        List<vj.u2.a> listC = vj.m0.c();
        if (listB != null) {
            arrayList.addAll(listC);
            this.f19544c.addAll(listB);
            z10 = true;
        } else {
            z10 = false;
        }
        vj.u2.a aVar2 = null;
        if (!z10 && this.f19553l) {
            try {
                Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
                Class cls2 = Boolean.TYPE;
                aVar = (vj.u2.a) cls.getDeclaredMethod("getServerStreamTracerFactory", cls2, cls2, cls2).invoke(null, Boolean.valueOf(this.f19554m), Boolean.valueOf(this.f19555n), Boolean.valueOf(this.f19556o));
            } catch (ClassNotFoundException e10) {
                f19536u.log(Level.FINE, "Unable to apply census stats", (Throwable) e10);
                aVar = null;
            } catch (IllegalAccessException e11) {
                f19536u.log(Level.FINE, "Unable to apply census stats", (Throwable) e11);
                aVar = null;
            } catch (NoSuchMethodException e12) {
                f19536u.log(Level.FINE, "Unable to apply census stats", (Throwable) e12);
                aVar = null;
            } catch (InvocationTargetException e13) {
                f19536u.log(Level.FINE, "Unable to apply census stats", (Throwable) e13);
                aVar = null;
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        if (!z10 && this.f19557p) {
            try {
                aVar2 = (vj.u2.a) Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getServerStreamTracerFactory", null).invoke(null, null);
            } catch (ClassNotFoundException e14) {
                f19536u.log(Level.FINE, "Unable to apply census stats", (Throwable) e14);
            } catch (IllegalAccessException e15) {
                f19536u.log(Level.FINE, "Unable to apply census stats", (Throwable) e15);
            } catch (NoSuchMethodException e16) {
                f19536u.log(Level.FINE, "Unable to apply census stats", (Throwable) e16);
            } catch (InvocationTargetException e17) {
                f19536u.log(Level.FINE, "Unable to apply census stats", (Throwable) e17);
            }
            if (aVar2 != null) {
                arrayList.add(aVar2);
            }
        }
        arrayList.addAll(this.f19545d);
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public x2 n(long j10, TimeUnit timeUnit) {
        c1.h0.p(j10 > 0, "handshake timeout is %s, but must be positive", j10);
        this.f19551j = ((TimeUnit) c1.h0.F(timeUnit, "unit")).toMillis(j10);
        return this;
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public x2 o(vj.o2 o2Var) {
        this.f19544c.add((vj.o2) c1.h0.F(o2Var, "interceptor"));
        return this;
    }

    public x2 R(@gm.j vj.b bVar) {
        this.f19558q = bVar;
        return this;
    }

    public void S(vj.y.c cVar) {
        this.f19552k = (vj.y.c) c1.h0.F(cVar, "ticker");
    }

    public void T(boolean z10) {
        this.f19553l = z10;
    }

    public void U(boolean z10) {
        this.f19555n = z10;
    }

    public void V(boolean z10) {
        this.f19556o = z10;
    }

    public void W(boolean z10) {
        this.f19554m = z10;
    }

    public void X(boolean z10) {
        this.f19557p = z10;
    }

    @Override // vj.j2
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public x2 A(File file, File file2) {
        throw new UnsupportedOperationException("TLS not supported in ServerImplBuilder");
    }

    @Override // vj.j2
    public vj.i2 f() {
        return new w2(this, this.f19546e.a(O()), vj.w.f17452f);
    }

    @Override // vj.j2
    public vj.j2 g(vj.l2 l2Var) {
        l2Var.getClass();
        this.f19561t = l2Var;
        return this;
    }

    @Override // vj.j2
    public vj.j2 j() {
        return k(q1.n0.INSTANCE);
    }

    @Override // vj.j2
    public vj.j2 y(@gm.j vj.b bVar) {
        this.f19558q = bVar;
        return this;
    }
}
