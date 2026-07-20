package q1;

import f1.b5;
import f1.j6;
import f1.k3;
import f1.l5;
import f1.o3;
import f1.p4;
import f1.t3;
import f1.u3;
import f1.w4;
import f1.x7;
import f1.y4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class j2 implements k2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f13565c = Logger.getLogger(j2.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v1.a<d> f13566d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v1.a<d> f13567e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f13568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1.i3<i2> f13569b;

    public class a implements v1.a<d> {
        @Override // q1.v1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d listener) {
            listener.b();
        }

        public String toString() {
            return "healthy()";
        }
    }

    public class b implements v1.a<d> {
        @Override // q1.v1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d listener) {
            listener.c();
        }

        public String toString() {
            return "stopped()";
        }
    }

    public static final class c extends Throwable {
        public c() {
        }

        public c(a aVar) {
        }
    }

    public static abstract class d {
        public void a(i2 service) {
        }

        public void b() {
        }

        public void c() {
        }
    }

    public static final class e extends q {
        public e() {
        }

        @Override // q1.q
        public void m() {
            u();
        }

        @Override // q1.q
        public void n() {
            v();
        }

        public e(a aVar) {
        }
    }

    public static final class f extends i2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i2 f13570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<g> f13571b;

        public f(i2 service, WeakReference<g> state) {
            this.f13570a = service;
            this.f13571b = state;
        }

        @Override // q1.i2.a
        public void a(i2.b from, Throwable failure) {
            g gVar = this.f13571b.get();
            if (gVar != null) {
                if (!(this.f13570a instanceof e)) {
                    j2.f13565c.log(Level.SEVERE, "Service " + this.f13570a + " has failed in the " + from + " state.", failure);
                }
                gVar.n(this.f13570a, from, i2.b.FAILED);
            }
        }

        @Override // q1.i2.a
        public void b() {
            g gVar = this.f13571b.get();
            if (gVar != null) {
                gVar.n(this.f13570a, i2.b.STARTING, i2.b.RUNNING);
            }
        }

        @Override // q1.i2.a
        public void c() {
            g gVar = this.f13571b.get();
            if (gVar != null) {
                gVar.n(this.f13570a, i2.b.NEW, i2.b.STARTING);
                if (this.f13570a instanceof e) {
                    return;
                }
                j2.f13565c.log(Level.FINE, "Starting {0}.", this.f13570a);
            }
        }

        @Override // q1.i2.a
        public void d(i2.b from) {
            g gVar = this.f13571b.get();
            if (gVar != null) {
                gVar.n(this.f13570a, from, i2.b.STOPPING);
            }
        }

        @Override // q1.i2.a
        public void e(i2.b from) {
            g gVar = this.f13571b.get();
            if (gVar != null) {
                if (!(this.f13570a instanceof e)) {
                    j2.f13565c.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.f13570a, from});
                }
                gVar.n(this.f13570a, from, i2.b.TERMINATED);
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y1 f13572a = new y1(false);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @u1.a("monitor")
        public final j6<i2.b, i2> f13573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @u1.a("monitor")
        public final b5<i2.b> f13574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @u1.a("monitor")
        public final Map<i2, c1.o0> f13575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @u1.a("monitor")
        public boolean f13576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @u1.a("monitor")
        public boolean f13577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f13578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final y1.a f13579h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final y1.a f13580i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final v1<d> f13581j;

        public class a implements c1.t<Map.Entry<i2, Long>, Long> {
            public a(final g this$0) {
            }

            @Override // c1.t
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long apply(Map.Entry<i2, Long> input) {
                return input.getValue();
            }
        }

        public class b implements v1.a<d> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i2 f13582a;

            public b(final g this$0, final i2 val$service) {
                this.f13582a = val$service;
            }

            @Override // q1.v1.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(d listener) {
                listener.a(this.f13582a);
            }

            public String toString() {
                return "failed({service=" + this.f13582a + "})";
            }
        }

        public final class c extends y1.a {
            public c() {
                super(g.this.f13572a);
            }

            @Override // q1.y1.a
            @u1.a("ServiceManagerState.this.monitor")
            public boolean a() {
                int iCount = g.this.f13574c.count(i2.b.RUNNING);
                g gVar = g.this;
                return iCount == gVar.f13578g || gVar.f13574c.contains(i2.b.STOPPING) || g.this.f13574c.contains(i2.b.TERMINATED) || g.this.f13574c.contains(i2.b.FAILED);
            }
        }

        public final class d extends y1.a {
            public d() {
                super(g.this.f13572a);
            }

            @Override // q1.y1.a
            @u1.a("ServiceManagerState.this.monitor")
            public boolean a() {
                return g.this.f13574c.count(i2.b.FAILED) + g.this.f13574c.count(i2.b.TERMINATED) == g.this.f13578g;
            }
        }

        public g(f1.e3<i2> services) {
            j6<i2.b, i2> j6VarA = w4.c(i2.b.class).g().a();
            this.f13573b = j6VarA;
            this.f13574c = j6VarA.keys();
            this.f13575d = new IdentityHashMap();
            this.f13579h = new c();
            this.f13580i = new d();
            this.f13581j = new v1<>();
            this.f13578g = services.size();
            j6VarA.putAll(i2.b.NEW, services);
        }

        public void a(d listener, Executor executor) {
            this.f13581j.b(listener, executor);
        }

        public void b() {
            this.f13572a.q(this.f13579h);
            try {
                f();
            } finally {
                this.f13572a.D();
            }
        }

        public void c(long timeout, TimeUnit unit) throws TimeoutException {
            this.f13572a.g();
            try {
                if (this.f13572a.N(this.f13579h, timeout, unit)) {
                    f();
                    this.f13572a.D();
                } else {
                    throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + y4.n(this.f13573b, c1.j0.n(t3.of(i2.b.NEW, i2.b.STARTING))));
                }
            } catch (Throwable th2) {
                this.f13572a.D();
                throw th2;
            }
        }

        public void d() {
            this.f13572a.q(this.f13580i);
            this.f13572a.D();
        }

        public void e(long timeout, TimeUnit unit) throws TimeoutException {
            this.f13572a.g();
            try {
                if (this.f13572a.N(this.f13580i, timeout, unit)) {
                    this.f13572a.D();
                } else {
                    throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + y4.n(this.f13573b, new c1.j0.i(c1.j0.n(EnumSet.of(i2.b.TERMINATED, i2.b.FAILED)))));
                }
            } catch (Throwable th2) {
                this.f13572a.D();
                throw th2;
            }
        }

        @u1.a("monitor")
        public void f() {
            b5<i2.b> b5Var = this.f13574c;
            i2.b bVar = i2.b.RUNNING;
            if (b5Var.count(bVar) == this.f13578g) {
                return;
            }
            throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + y4.n(this.f13573b, new c1.j0.i(c1.j0.m(bVar))));
        }

        public void g() {
            c1.h0.h0(!this.f13572a.f13768b.isHeldByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.f13581j.c();
        }

        public void h(final i2 service) {
            v1<d> v1Var = this.f13581j;
            b bVar = new b(this, service);
            v1Var.f(bVar, bVar);
        }

        public void i() {
            v1<d> v1Var = this.f13581j;
            v1.a<d> aVar = j2.f13566d;
            v1Var.f(aVar, aVar);
        }

        public void j() {
            v1<d> v1Var = this.f13581j;
            v1.a<d> aVar = j2.f13567e;
            v1Var.f(aVar, aVar);
        }

        public void k() {
            this.f13572a.g();
            try {
                if (!this.f13577f) {
                    this.f13576e = true;
                    this.f13572a.D();
                    return;
                }
                ArrayList arrayList = new ArrayList();
                x7<i2> it = l().values().iterator();
                while (it.hasNext()) {
                    i2 next = it.next();
                    if (next.state() != i2.b.NEW) {
                        arrayList.add(next);
                    }
                }
                throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + arrayList);
            } catch (Throwable th2) {
                this.f13572a.D();
                throw th2;
            }
        }

        public u3<i2.b, i2> l() {
            u3.a aVarBuilder = u3.builder();
            this.f13572a.g();
            try {
                for (Map.Entry<i2.b, i2> entry : this.f13573b.entries()) {
                    if (!(entry.getValue() instanceof e)) {
                        aVarBuilder.q(entry);
                    }
                }
                this.f13572a.D();
                return aVarBuilder.a();
            } catch (Throwable th2) {
                this.f13572a.D();
                throw th2;
            }
        }

        public k3<i2, Long> m() {
            this.f13572a.g();
            try {
                ArrayList arrayListU = p4.u(this.f13575d.size());
                for (Map.Entry<i2, c1.o0> entry : this.f13575d.entrySet()) {
                    i2 key = entry.getKey();
                    c1.o0 value = entry.getValue();
                    if (!value.f1227b && !(key instanceof e)) {
                        arrayListU.add(new f1.f3(key, Long.valueOf(value.g(TimeUnit.MILLISECONDS))));
                    }
                }
                this.f13572a.D();
                Collections.sort(arrayListU, l5.natural().onResultOf(new a()));
                return k3.copyOf(arrayListU);
            } catch (Throwable th2) {
                this.f13572a.D();
                throw th2;
            }
        }

        public void n(final i2 service, i2.b from, i2.b to2) {
            service.getClass();
            c1.h0.d(from != to2);
            this.f13572a.g();
            try {
                this.f13577f = true;
                if (this.f13576e) {
                    c1.h0.B0(this.f13573b.remove(from, service), "Service %s not at the expected location in the state map %s", service, from);
                    c1.h0.B0(this.f13573b.put(to2, service), "Service %s in the state map unexpectedly at %s", service, to2);
                    c1.o0 o0VarC = this.f13575d.get(service);
                    if (o0VarC == null) {
                        o0VarC = c1.o0.c();
                        this.f13575d.put(service, o0VarC);
                    }
                    i2.b bVar = i2.b.RUNNING;
                    if (to2.compareTo(bVar) >= 0 && o0VarC.f1227b) {
                        o0VarC.l();
                        if (!(service instanceof e)) {
                            j2.f13565c.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, o0VarC});
                        }
                    }
                    i2.b bVar2 = i2.b.FAILED;
                    if (to2 == bVar2) {
                        h(service);
                    }
                    if (this.f13574c.count(bVar) == this.f13578g) {
                        i();
                    } else if (this.f13574c.count(i2.b.TERMINATED) + this.f13574c.count(bVar2) == this.f13578g) {
                        j();
                    }
                }
            } finally {
                this.f13572a.D();
                g();
            }
        }

        public void o(i2 service) {
            this.f13572a.g();
            try {
                if (this.f13575d.get(service) == null) {
                    this.f13575d.put(service, c1.o0.c());
                }
            } finally {
                this.f13572a.D();
            }
        }
    }

    public j2(Iterable<? extends i2> services) {
        f1.i3<i2> i3VarCopyOf = f1.i3.copyOf(services);
        if (i3VarCopyOf.isEmpty()) {
            f13565c.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new c(null));
            i3VarCopyOf = f1.i3.of(new e());
        }
        g gVar = new g(i3VarCopyOf);
        this.f13568a = gVar;
        this.f13569b = i3VarCopyOf;
        WeakReference weakReference = new WeakReference(gVar);
        x7<i2> it = i3VarCopyOf.iterator();
        while (it.hasNext()) {
            i2 next = it.next();
            next.e(new f(next, weakReference), n0.INSTANCE);
            c1.h0.u(next.state() == i2.b.NEW, "Can only manage NEW services, %s", next);
        }
        this.f13568a.k();
    }

    @Override // q1.k2
    public o3 a() {
        return this.f13568a.l();
    }

    public void e(d listener, Executor executor) {
        this.f13568a.a(listener, executor);
    }

    public void f() {
        this.f13568a.b();
    }

    public void g(long timeout, TimeUnit unit) throws TimeoutException {
        this.f13568a.c(timeout, unit);
    }

    public void h() {
        this.f13568a.d();
    }

    public void i(long timeout, TimeUnit unit) throws TimeoutException {
        this.f13568a.e(timeout, unit);
    }

    public boolean j() {
        x7<i2> it = this.f13569b.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    public u3<i2.b, i2> k() {
        return this.f13568a.l();
    }

    @t1.a
    public j2 l() {
        x7<i2> it = this.f13569b.iterator();
        while (it.hasNext()) {
            c1.h0.x0(it.next().state() == i2.b.NEW, "Not all services are NEW, cannot start %s", this);
        }
        x7<i2> it2 = this.f13569b.iterator();
        while (it2.hasNext()) {
            i2 next = it2.next();
            try {
                this.f13568a.o(next);
                next.d();
            } catch (IllegalStateException e10) {
                f13565c.log(Level.WARNING, "Unable to start Service " + next, (Throwable) e10);
            }
        }
        return this;
    }

    public k3<i2, Long> m() {
        return this.f13568a.m();
    }

    @t1.a
    public j2 n() {
        x7<i2> it = this.f13569b.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
        return this;
    }

    public String toString() {
        return c1.z.b(j2.class).j("services", f1.c0.d(this.f13569b, new c1.j0.i(c1.j0.o(e.class)))).toString();
    }
}
