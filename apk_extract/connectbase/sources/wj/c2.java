package wj;

import f1.p4;
import f1.x7;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@vj.e0("https://github.com/grpc/grpc-java/issues/10383")
public final class c2 extends vj.o1 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Logger f18410p = Logger.getLogger(c2.class.getName());

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @b1.e
    public static final int f18411q = 250;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f18412r = "GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vj.o1.f f18413g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f18415i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @gm.j
    public vj.c3.d f18418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public vj.u f18419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public vj.u f18420n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f18421o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<SocketAddress, h> f18414h = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f18416j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18417k = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18422a;

        static {
            int[] iArr = new int[vj.u.values().length];
            f18422a = iArr;
            try {
                iArr[vj.u.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18422a[vj.u.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18422a[vj.u.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18422a[vj.u.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18422a[vj.u.SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c2.this.f18418l = null;
            if (c2.this.f18415i.d()) {
                c2.this.f();
            }
        }
    }

    @b1.e
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<vj.d0> f18427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18429c;

        public d(List<vj.d0> list) {
            this.f18427a = list == null ? Collections.emptyList() : list;
        }

        public SocketAddress a() {
            if (f()) {
                return this.f18427a.get(this.f18428b).f17080a.get(this.f18429c);
            }
            throw new IllegalStateException("Index is past the end of the address group list");
        }

        public List<vj.d0> b() {
            return Collections.singletonList(new vj.d0(a(), c()));
        }

        public vj.a c() {
            if (f()) {
                return this.f18427a.get(this.f18428b).f17081b;
            }
            throw new IllegalStateException("Index is off the end of the address group list");
        }

        public boolean d() {
            if (!f()) {
                return false;
            }
            vj.d0 d0Var = this.f18427a.get(this.f18428b);
            int i10 = this.f18429c + 1;
            this.f18429c = i10;
            if (i10 < d0Var.f17080a.size()) {
                return true;
            }
            int i11 = this.f18428b + 1;
            this.f18428b = i11;
            this.f18429c = 0;
            return i11 < this.f18427a.size();
        }

        public boolean e() {
            return this.f18428b == 0 && this.f18429c == 0;
        }

        public boolean f() {
            return this.f18428b < this.f18427a.size();
        }

        public void g() {
            this.f18428b = 0;
            this.f18429c = 0;
        }

        public boolean h(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f18427a.size(); i10++) {
                int iIndexOf = this.f18427a.get(i10).f17080a.indexOf(socketAddress);
                if (iIndexOf != -1) {
                    this.f18428b = i10;
                    this.f18429c = iIndexOf;
                    return true;
                }
            }
            return false;
        }

        public int i() {
            List<vj.d0> list = this.f18427a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void j(f1.i3<vj.d0> i3Var) {
            List<vj.d0> listEmptyList = i3Var;
            if (i3Var == null) {
                listEmptyList = Collections.emptyList();
            }
            this.f18427a = listEmptyList;
            g();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.j
        public final Boolean f18430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final Long f18431b;

        public e(@gm.j Boolean bool) {
            this(bool, null);
        }

        public e(@gm.j Boolean bool, @gm.j Long l10) {
            this.f18430a = bool;
            this.f18431b = l10;
        }
    }

    public static final class f extends vj.o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.g f18432a;

        public f(vj.o1.g gVar) {
            this.f18432a = (vj.o1.g) c1.h0.F(gVar, "result");
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            return this.f18432a;
        }

        public String toString() {
            return c1.z.b(f.class).j("result", this.f18432a).toString();
        }
    }

    public final class g extends vj.o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c2 f18433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f18434b = new AtomicBoolean(false);

        public g(c2 c2Var) {
            this.f18433a = (c2) c1.h0.F(c2Var, "pickFirstLeafLoadBalancer");
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            if (this.f18434b.compareAndSet(false, true)) {
                vj.c3 c3VarM = c2.this.f18413g.m();
                final c2 c2Var = this.f18433a;
                Objects.requireNonNull(c2Var);
                c3VarM.execute(new Runnable() { // from class: wj.d2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c2Var.f();
                    }
                });
            }
            return vj.o1.g.g();
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.j f18436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vj.u f18437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f18438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18439d = false;

        public h(vj.o1.j jVar, vj.u uVar, c cVar) {
            this.f18436a = jVar;
            this.f18437b = uVar;
            this.f18438c = cVar;
        }

        public final vj.u f() {
            return this.f18438c.f18424a.f17279a;
        }

        public vj.u g() {
            return this.f18437b;
        }

        public vj.o1.j h() {
            return this.f18436a;
        }

        public boolean i() {
            return this.f18439d;
        }

        public final void j(vj.u uVar) {
            this.f18437b = uVar;
            if (uVar == vj.u.READY || uVar == vj.u.TRANSIENT_FAILURE) {
                this.f18439d = true;
            } else if (uVar == vj.u.IDLE) {
                this.f18439d = false;
            }
        }
    }

    public c2(vj.o1.f fVar) {
        vj.u uVar = vj.u.IDLE;
        this.f18419m = uVar;
        this.f18420n = uVar;
        this.f18421o = v0.i(f18412r, true);
        this.f18413g = (vj.o1.f) c1.h0.F(fVar, "helper");
    }

    @Override // vj.o1
    public vj.y2 a(vj.o1.i iVar) {
        vj.u uVar;
        e eVar;
        Boolean bool;
        if (this.f18419m == vj.u.SHUTDOWN) {
            return vj.y2.f17558o.u("Already shut down");
        }
        List<vj.d0> list = iVar.f17217a;
        if (list.isEmpty()) {
            vj.y2 y2VarU = vj.y2.f17563t.u("NameResolver returned no usable address. addrs=" + iVar.f17217a + ", attrs=" + iVar.f17218b);
            c(y2VarU);
            return y2VarU;
        }
        Iterator<vj.d0> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                vj.y2 y2VarU2 = vj.y2.f17563t.u("NameResolver returned address list with null endpoint. addrs=" + iVar.f17217a + ", attrs=" + iVar.f17218b);
                c(y2VarU2);
                return y2VarU2;
            }
        }
        this.f18417k = true;
        Object obj = iVar.f17219c;
        if ((obj instanceof e) && (bool = (eVar = (e) obj).f18430a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(list);
            Collections.shuffle(arrayList, eVar.f18431b != null ? new Random(eVar.f18431b.longValue()) : new Random());
            list = arrayList;
        }
        f1.i3<vj.d0> i3VarE = f1.i3.builder().l(list).e();
        d dVar = this.f18415i;
        if (dVar == null) {
            this.f18415i = new d(i3VarE);
        } else if (this.f18419m == vj.u.READY) {
            SocketAddress socketAddressA = dVar.a();
            this.f18415i.j(i3VarE);
            if (this.f18415i.h(socketAddressA)) {
                this.f18414h.get(socketAddressA).f18436a.j(this.f18415i.b());
                return vj.y2.f17548e;
            }
            this.f18415i.g();
        } else {
            dVar.j(i3VarE);
        }
        HashSet<SocketAddress> hashSet = new HashSet(this.f18414h.keySet());
        HashSet hashSet2 = new HashSet();
        x7<vj.d0> it2 = i3VarE.iterator();
        while (it2.hasNext()) {
            hashSet2.addAll(it2.next().f17080a);
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                this.f18414h.remove(socketAddress).f18436a.h();
            }
        }
        if (hashSet.size() == 0 || (uVar = this.f18419m) == vj.u.CONNECTING || uVar == vj.u.READY) {
            vj.u uVar2 = vj.u.CONNECTING;
            this.f18419m = uVar2;
            x(uVar2, new f(vj.o1.g.g()));
            o();
            f();
        } else {
            vj.u uVar3 = vj.u.IDLE;
            if (uVar == uVar3) {
                x(uVar3, new g(this));
            } else if (uVar == vj.u.TRANSIENT_FAILURE) {
                o();
                f();
            }
        }
        return vj.y2.f17548e;
    }

    @Override // vj.o1
    public void c(vj.y2 y2Var) {
        Iterator<h> it = this.f18414h.values().iterator();
        while (it.hasNext()) {
            it.next().f18436a.h();
        }
        this.f18414h.clear();
        x(vj.u.TRANSIENT_FAILURE, new f(vj.o1.g.f(y2Var)));
    }

    @Override // vj.o1
    public void f() {
        d dVar = this.f18415i;
        if (dVar == null || !dVar.f() || this.f18419m == vj.u.SHUTDOWN) {
            return;
        }
        SocketAddress socketAddressA = this.f18415i.a();
        vj.o1.j jVarP = this.f18414h.containsKey(socketAddressA) ? this.f18414h.get(socketAddressA).f18436a : p(socketAddressA, this.f18415i.c());
        int i10 = a.f18422a[this.f18414h.get(socketAddressA).f18437b.ordinal()];
        if (i10 == 1) {
            jVarP.g();
            this.f18414h.get(socketAddressA).j(vj.u.CONNECTING);
            v();
        } else {
            if (i10 == 2) {
                if (this.f18421o) {
                    v();
                    return;
                } else {
                    jVarP.g();
                    return;
                }
            }
            if (i10 == 3) {
                f18410p.warning("Requesting a connection even though we have a READY subchannel");
            } else {
                if (i10 != 4) {
                    return;
                }
                this.f18415i.d();
                f();
            }
        }
    }

    @Override // vj.o1
    public void g() {
        f18410p.log(Level.FINE, "Shutting down, currently have {} subchannels created", Integer.valueOf(this.f18414h.size()));
        vj.u uVar = vj.u.SHUTDOWN;
        this.f18419m = uVar;
        this.f18420n = uVar;
        o();
        Iterator<h> it = this.f18414h.values().iterator();
        while (it.hasNext()) {
            it.next().f18436a.h();
        }
        this.f18414h.clear();
    }

    public final void o() {
        vj.c3.d dVar = this.f18418l;
        if (dVar != null) {
            dVar.a();
            this.f18418l = null;
        }
    }

    public final vj.o1.j p(SocketAddress socketAddress, vj.a aVar) {
        c cVar = new c();
        final vj.o1.j jVarF = this.f18413g.f(new vj.o1.b.a().e(p4.t(new vj.d0(socketAddress, aVar))).b(vj.o1.f17197c, cVar).c());
        if (jVarF == null) {
            f18410p.warning("Was not able to create subchannel for " + socketAddress);
            throw new IllegalStateException("Can't create subchannel");
        }
        h hVar = new h(jVarF, vj.u.IDLE, cVar);
        cVar.f18425b = hVar;
        this.f18414h.put(socketAddress, hVar);
        if (jVarF.d().f17048a.get(vj.o1.f17198d) == null) {
            cVar.f18424a = vj.v.a(vj.u.READY);
        }
        jVarF.i(new vj.o1.l() { // from class: wj.b2
            @Override // vj.o1.l
            public final void a(vj.v vVar) {
                this.f18345a.t(jVarF, vVar);
            }
        });
        return jVarF;
    }

    public final SocketAddress q(vj.o1.j jVar) {
        return jVar.b().f17080a.get(0);
    }

    @b1.e
    public vj.u r() {
        return this.f18420n;
    }

    public final boolean s() {
        d dVar = this.f18415i;
        if (dVar == null || dVar.f() || this.f18414h.size() < this.f18415i.i()) {
            return false;
        }
        Iterator<h> it = this.f18414h.values().iterator();
        while (it.hasNext()) {
            if (!it.next().f18439d) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void t(vj.o1.j jVar, vj.v vVar) {
        vj.u uVar = vVar.f17279a;
        h hVar = this.f18414h.get(q(jVar));
        if (hVar == null || hVar.f18436a != jVar || uVar == vj.u.SHUTDOWN) {
            return;
        }
        vj.u uVar2 = vj.u.IDLE;
        if (uVar == uVar2) {
            this.f18413g.p();
        }
        hVar.j(uVar);
        vj.u uVar3 = this.f18419m;
        vj.u uVar4 = vj.u.TRANSIENT_FAILURE;
        if (uVar3 == uVar4 || this.f18420n == uVar4) {
            if (uVar == vj.u.CONNECTING) {
                return;
            }
            if (uVar == uVar2) {
                f();
                return;
            }
        }
        int i10 = a.f18422a[uVar.ordinal()];
        if (i10 == 1) {
            this.f18415i.g();
            this.f18419m = uVar2;
            x(uVar2, new g(this));
            return;
        }
        if (i10 == 2) {
            vj.u uVar5 = vj.u.CONNECTING;
            this.f18419m = uVar5;
            x(uVar5, new f(vj.o1.g.g()));
            return;
        }
        if (i10 == 3) {
            w(hVar);
            this.f18415i.h(q(jVar));
            this.f18419m = vj.u.READY;
            y(hVar);
            return;
        }
        if (i10 != 4) {
            throw new IllegalArgumentException("Unsupported state:" + uVar);
        }
        if (this.f18415i.f() && this.f18414h.get(this.f18415i.a()).f18436a == jVar && this.f18415i.d()) {
            o();
            f();
        }
        if (s()) {
            this.f18419m = uVar4;
            x(uVar4, new f(vj.o1.g.f(vVar.f17280b)));
            int i11 = this.f18416j + 1;
            this.f18416j = i11;
            if (i11 >= this.f18415i.i() || this.f18417k) {
                this.f18417k = false;
                this.f18416j = 0;
                this.f18413g.p();
            }
        }
    }

    public final void v() {
        if (this.f18421o) {
            vj.c3.d dVar = this.f18418l;
            if (dVar == null || !dVar.b()) {
                try {
                    this.f18418l = this.f18413g.m().c(new b(), 250L, TimeUnit.MILLISECONDS, this.f18413g.l());
                } catch (NullPointerException unused) {
                }
            }
        }
    }

    public final void w(h hVar) {
        o();
        for (h hVar2 : this.f18414h.values()) {
            if (!hVar2.f18436a.equals(hVar.f18436a)) {
                hVar2.f18436a.h();
            }
        }
        this.f18414h.clear();
        hVar.j(vj.u.READY);
        this.f18414h.put(q(hVar.f18436a), hVar);
    }

    public final void x(vj.u uVar, vj.o1.k kVar) {
        if (uVar == this.f18420n && (uVar == vj.u.IDLE || uVar == vj.u.CONNECTING)) {
            return;
        }
        this.f18420n = uVar;
        this.f18413g.q(uVar, kVar);
    }

    public final void y(h hVar) {
        vj.u uVar = hVar.f18437b;
        vj.u uVar2 = vj.u.READY;
        if (uVar != uVar2) {
            return;
        }
        if (hVar.f() == uVar2) {
            x(uVar2, new vj.o1.e(vj.o1.g.h(hVar.f18436a)));
            return;
        }
        vj.u uVarF = hVar.f();
        vj.u uVar3 = vj.u.TRANSIENT_FAILURE;
        if (uVarF == uVar3) {
            x(uVar3, new f(vj.o1.g.f(hVar.f18438c.f18424a.f17280b)));
        } else if (this.f18420n != uVar3) {
            x(hVar.f(), new f(vj.o1.g.g()));
        }
    }

    public final class c implements vj.o1.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vj.v f18424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f18425b;

        public c() {
            this.f18424a = vj.v.a(vj.u.IDLE);
        }

        @Override // vj.o1.l
        public void a(vj.v vVar) {
            c2.f18410p.log(Level.FINE, "Received health status {0} for subchannel {1}", new Object[]{vVar, this.f18425b.f18436a});
            this.f18424a = vVar;
            try {
                c2 c2Var = c2.this;
                h hVar = c2Var.f18414h.get(c2Var.f18415i.a());
                if (hVar == null || hVar.f18438c != this) {
                    return;
                }
                c2.this.y(this.f18425b);
            } catch (IllegalStateException unused) {
                c2.f18410p.fine("Health listener received state change after subchannel was removed");
            }
        }

        public /* synthetic */ c(c2 c2Var, a aVar) {
            this();
        }
    }
}
