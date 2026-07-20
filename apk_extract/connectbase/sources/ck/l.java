package ck;

import c1.h0;
import f1.d2;
import f1.i3;
import f1.t3;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import vj.c3;
import vj.d0;
import vj.o1;
import vj.t0;
import vj.u;
import vj.v;
import vj.v1;
import vj.y2;
import wj.e3;
import wj.n3;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class l extends o1 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final vj.a.c<d> f1536q = new vj.a.c<>("endpointTrackerKey");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b1.e
    public final e f1537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @b1.e
    public final Map<SocketAddress, d> f1538h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c3 f1539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o1.f f1540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ck.h f1541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n3 f1542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ScheduledExecutorService f1543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c3.d f1544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f1545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final vj.h f1546p;

    public class b extends ck.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o1.f f1547a;

        public b(o1.f fVar) {
            this.f1547a = new ck.i(fVar);
        }

        @Override // ck.f, vj.o1.f
        public o1.j f(o1.b bVar) {
            i iVar = l.this.new i(bVar, this.f1547a);
            List<d0> list = bVar.f17202a;
            if (l.n(list) && l.this.f1538h.containsKey(list.get(0).f17080a.get(0))) {
                d dVar = l.this.f1538h.get(list.get(0).f17080a.get(0));
                dVar.c(iVar);
                if (dVar.f1555d != null) {
                    iVar.o();
                }
            }
            return iVar;
        }

        @Override // ck.f, vj.o1.f
        public void q(u uVar, o1.k kVar) {
            this.f1547a.q(uVar, l.this.new h(kVar));
        }

        @Override // ck.f
        public o1.f t() {
            return this.f1547a;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f1549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vj.h f1550b;

        public c(g gVar, vj.h hVar) {
            this.f1549a = gVar;
            this.f1550b = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = l.this;
            lVar.f1545o = Long.valueOf(lVar.f1542l.a());
            l.this.f1537g.v();
            for (j jVar : j.b(this.f1549a, this.f1550b)) {
                l lVar2 = l.this;
                jVar.a(lVar2.f1537g, lVar2.f1545o.longValue());
            }
            l lVar3 = l.this;
            lVar3.f1537g.s(lVar3.f1545o);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f1552a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f1555d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1556e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile a f1553b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f1554c = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set<i> f1557f = new HashSet();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public AtomicLong f1558a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public AtomicLong f1559b;

            public a() {
                this.f1558a = new AtomicLong();
                this.f1559b = new AtomicLong();
            }

            public void a() {
                this.f1558a.set(0L);
                this.f1559b.set(0L);
            }
        }

        public d(g gVar) {
            this.f1552a = gVar;
        }

        @b1.e
        public long b() {
            return this.f1553b.f1559b.get() + this.f1553b.f1558a.get();
        }

        public boolean c(i iVar) {
            if (p() && !iVar.p()) {
                iVar.o();
            } else if (!p() && iVar.p()) {
                iVar.r();
            }
            iVar.q(this);
            return this.f1557f.add(iVar);
        }

        public boolean d(i iVar) {
            return this.f1557f.contains(iVar);
        }

        public void e() {
            int i10 = this.f1556e;
            this.f1556e = i10 == 0 ? 0 : i10 - 1;
        }

        public void f(long j10) {
            this.f1555d = Long.valueOf(j10);
            this.f1556e++;
            Iterator<i> it = this.f1557f.iterator();
            while (it.hasNext()) {
                it.next().o();
            }
        }

        public double g() {
            return this.f1554c.f1559b.get() / i();
        }

        @b1.e
        public Set<i> h() {
            return t3.copyOf((Collection) this.f1557f);
        }

        public long i() {
            return this.f1554c.f1559b.get() + this.f1554c.f1558a.get();
        }

        public void j(boolean z10) {
            g gVar = this.f1552a;
            if (gVar.f1567e == null && gVar.f1568f == null) {
                return;
            }
            if (z10) {
                this.f1553b.f1558a.getAndIncrement();
            } else {
                this.f1553b.f1559b.getAndIncrement();
            }
        }

        public boolean k(long j10) {
            return j10 > Math.min(this.f1552a.f1564b.longValue() * ((long) this.f1556e), Math.max(this.f1552a.f1564b.longValue(), this.f1552a.f1565c.longValue())) + this.f1555d.longValue();
        }

        public boolean l(i iVar) {
            iVar.n();
            return this.f1557f.remove(iVar);
        }

        public void m() {
            this.f1553b.a();
            this.f1554c.a();
        }

        public void n() {
            this.f1556e = 0;
        }

        public void o(g gVar) {
            this.f1552a = gVar;
        }

        public boolean p() {
            return this.f1555d != null;
        }

        public double q() {
            return this.f1554c.f1558a.get() / i();
        }

        public void r() {
            this.f1554c.a();
            a aVar = this.f1553b;
            this.f1553b = this.f1554c;
            this.f1554c = aVar;
        }

        public void s() {
            h0.h0(this.f1555d != null, "not currently ejected");
            this.f1555d = null;
            Iterator<i> it = this.f1557f.iterator();
            while (it.hasNext()) {
                it.next().r();
            }
        }

        public String toString() {
            return "EndpointTracker{subchannels=" + this.f1557f + rs.f.f14860b;
        }
    }

    public static class e extends d2<Set<SocketAddress>, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Set<SocketAddress>, d> f1560a = new HashMap();

        public void m() {
            for (d dVar : this.f1560a.values()) {
                if (dVar.p()) {
                    dVar.s();
                }
                dVar.n();
            }
        }

        public double q() {
            if (this.f1560a.isEmpty()) {
                return 0.0d;
            }
            Iterator<d> it = this.f1560a.values().iterator();
            int i10 = 0;
            int i11 = 0;
            while (it.hasNext()) {
                i11++;
                if (it.next().p()) {
                    i10++;
                }
            }
            return (((double) i10) / ((double) i11)) * 100.0d;
        }

        public final /* synthetic */ void r(g gVar, Set set) {
            this.f1560a.putIfAbsent(set, new d(gVar));
        }

        public void s(Long l10) {
            for (d dVar : this.f1560a.values()) {
                if (!dVar.p()) {
                    dVar.e();
                }
                if (dVar.p() && dVar.k(l10.longValue())) {
                    dVar.s();
                }
            }
        }

        public void t(final g gVar, Set<Set<SocketAddress>> set) {
            set.forEach(new Consumer() { // from class: ck.m
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f1612a.r(gVar, (Set) obj);
                }
            });
        }

        public void u() {
            Iterator<d> it = this.f1560a.values().iterator();
            while (it.hasNext()) {
                it.next().m();
            }
        }

        public void v() {
            Iterator<d> it = this.f1560a.values().iterator();
            while (it.hasNext()) {
                it.next().r();
            }
        }

        public void w(g gVar) {
            Iterator<d> it = this.f1560a.values().iterator();
            while (it.hasNext()) {
                it.next().o(gVar);
            }
        }

        @Override // f1.d2, f1.j2
        public Map<Set<SocketAddress>, d> delegate() {
            return this.f1560a;
        }
    }

    public static class f implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f1561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.h f1562b;

        public f(g gVar, vj.h hVar) {
            this.f1561a = gVar;
            this.f1562b = hVar;
        }

        @Override // ck.l.j
        public void a(e eVar, long j10) {
            List<d> listO = l.o(eVar, this.f1561a.f1568f.f1580d.intValue());
            if (listO.size() < this.f1561a.f1568f.f1579c.intValue() || listO.size() == 0) {
                return;
            }
            for (d dVar : listO) {
                if (eVar.q() >= this.f1561a.f1566d.intValue()) {
                    return;
                }
                if (dVar.i() >= this.f1561a.f1568f.f1580d.intValue()) {
                    if (dVar.g() > ((double) this.f1561a.f1568f.f1577a.intValue()) / 100.0d) {
                        this.f1562b.b(vj.h.a.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", dVar, Double.valueOf(dVar.g()));
                        if (new Random().nextInt(100) < this.f1561a.f1568f.f1578b.intValue()) {
                            dVar.f(j10);
                        }
                    }
                }
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f1563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f1564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f1565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f1566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f1567e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f1568f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final e3.b f1569g;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Long f1570a = 10000000000L;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f1571b = 30000000000L;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f1572c = 300000000000L;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Integer f1573d = 10;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f1574e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public b f1575f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public e3.b f1576g;

            public g a() {
                h0.g0(this.f1576g != null);
                return new g(this.f1570a, this.f1571b, this.f1572c, this.f1573d, this.f1574e, this.f1575f, this.f1576g);
            }

            public a b(Long l10) {
                h0.d(l10 != null);
                this.f1571b = l10;
                return this;
            }

            public a c(e3.b bVar) {
                h0.g0(bVar != null);
                this.f1576g = bVar;
                return this;
            }

            public a d(b bVar) {
                this.f1575f = bVar;
                return this;
            }

            public a e(Long l10) {
                h0.d(l10 != null);
                this.f1570a = l10;
                return this;
            }

            public a f(Integer num) {
                h0.d(num != null);
                this.f1573d = num;
                return this;
            }

            public a g(Long l10) {
                h0.d(l10 != null);
                this.f1572c = l10;
                return this;
            }

            public a h(c cVar) {
                this.f1574e = cVar;
                return this;
            }
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f1577a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f1578b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f1579c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Integer f1580d;

            public static class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Integer f1581a = 85;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public Integer f1582b = 100;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Integer f1583c = 5;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Integer f1584d = 50;

                public b a() {
                    return new b(this.f1581a, this.f1582b, this.f1583c, this.f1584d);
                }

                public a b(Integer num) {
                    boolean z10 = false;
                    h0.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z10 = true;
                    }
                    h0.d(z10);
                    this.f1582b = num;
                    return this;
                }

                public a c(Integer num) {
                    h0.d(num != null);
                    h0.d(num.intValue() >= 0);
                    this.f1583c = num;
                    return this;
                }

                public a d(Integer num) {
                    h0.d(num != null);
                    h0.d(num.intValue() >= 0);
                    this.f1584d = num;
                    return this;
                }

                public a e(Integer num) {
                    boolean z10 = false;
                    h0.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z10 = true;
                    }
                    h0.d(z10);
                    this.f1581a = num;
                    return this;
                }
            }

            public b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f1577a = num;
                this.f1578b = num2;
                this.f1579c = num3;
                this.f1580d = num4;
            }
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f1585a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f1586b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f1587c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Integer f1588d;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Integer f1589a = 1900;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public Integer f1590b = 100;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Integer f1591c = 5;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Integer f1592d = 100;

                public c a() {
                    return new c(this.f1589a, this.f1590b, this.f1591c, this.f1592d);
                }

                public a b(Integer num) {
                    boolean z10 = false;
                    h0.d(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z10 = true;
                    }
                    h0.d(z10);
                    this.f1590b = num;
                    return this;
                }

                public a c(Integer num) {
                    h0.d(num != null);
                    h0.d(num.intValue() >= 0);
                    this.f1591c = num;
                    return this;
                }

                public a d(Integer num) {
                    h0.d(num != null);
                    h0.d(num.intValue() >= 0);
                    this.f1592d = num;
                    return this;
                }

                public a e(Integer num) {
                    h0.d(num != null);
                    this.f1589a = num;
                    return this;
                }
            }

            public c(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f1585a = num;
                this.f1586b = num2;
                this.f1587c = num3;
                this.f1588d = num4;
            }
        }

        public boolean a() {
            return (this.f1567e == null && this.f1568f == null) ? false : true;
        }

        public g(Long l10, Long l11, Long l12, Integer num, c cVar, b bVar, e3.b bVar2) {
            this.f1563a = l10;
            this.f1564b = l11;
            this.f1565c = l12;
            this.f1566d = num;
            this.f1567e = cVar;
            this.f1568f = bVar;
            this.f1569g = bVar2;
        }
    }

    public class h extends o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o1.k f1593a;

        public class a extends vj.n.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final d f1595a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @gm.j
            public final vj.n.a f1596b;

            /* JADX INFO: renamed from: ck.l$h$a$a, reason: collision with other inner class name */
            public class C0067a extends ck.d {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ vj.n f1598b;

                public C0067a(vj.n nVar) {
                    this.f1598b = nVar;
                }

                @Override // ck.d, vj.b3
                public void i(y2 y2Var) {
                    a.this.f1595a.j(y2Var.r());
                    o().i(y2Var);
                }

                @Override // ck.d
                public vj.n o() {
                    return this.f1598b;
                }
            }

            public class b extends vj.n {
                public b() {
                }

                @Override // vj.b3
                public void i(y2 y2Var) {
                    a.this.f1595a.j(y2Var.r());
                }
            }

            public a(@gm.j d dVar, vj.n.a aVar) {
                this.f1595a = dVar;
                this.f1596b = aVar;
            }

            @Override // vj.n.a
            public vj.n a(vj.n.b bVar, v1 v1Var) {
                vj.n.a aVar = this.f1596b;
                return aVar != null ? new C0067a(aVar.a(bVar, v1Var)) : new b();
            }
        }

        public h(o1.k kVar) {
            this.f1593a = kVar;
        }

        @Override // vj.o1.k
        public o1.g a(o1.h hVar) {
            o1.g gVarA = this.f1593a.a(hVar);
            o1.j jVar = gVarA.f17213a;
            if (jVar == null) {
                return gVarA;
            }
            vj.a aVarD = jVar.d();
            return o1.g.i(jVar, new a((d) aVarD.f17048a.get(l.f1536q), gVarA.f17214b));
        }
    }

    public class i extends ck.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o1.j f1601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f1602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public v f1604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public o1.l f1605e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final vj.h f1606f;

        public class a implements o1.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final o1.l f1608a;

            public a(o1.l lVar) {
                this.f1608a = lVar;
            }

            @Override // vj.o1.l
            public void a(v vVar) {
                i iVar = i.this;
                iVar.f1604d = vVar;
                if (iVar.f1603c) {
                    return;
                }
                this.f1608a.a(vVar);
            }
        }

        public i(o1.b bVar, o1.f fVar) {
            o1.b.C0454b<o1.l> c0454b = o1.f17197c;
            o1.l lVar = (o1.l) bVar.c(c0454b);
            if (lVar != null) {
                this.f1605e = lVar;
                this.f1601a = fVar.f(bVar.e().b(c0454b, new a(lVar)).c());
            } else {
                this.f1601a = fVar.f(bVar);
            }
            this.f1606f = this.f1601a.e();
        }

        @Override // ck.g, vj.o1.j
        public vj.a d() {
            if (this.f1602b == null) {
                return this.f1601a.d();
            }
            vj.a aVarD = this.f1601a.d();
            aVarD.getClass();
            return new vj.a.b(aVarD).d(l.f1536q, this.f1602b).a();
        }

        @Override // ck.g, vj.o1.j
        public void h() {
            d dVar = this.f1602b;
            if (dVar != null) {
                dVar.l(this);
            }
            super.h();
        }

        @Override // ck.g, vj.o1.j
        public void i(o1.l lVar) {
            if (this.f1605e != null) {
                super.i(lVar);
            } else {
                this.f1605e = lVar;
                super.i(new a(lVar));
            }
        }

        @Override // ck.g, vj.o1.j
        public void j(List<d0> list) {
            if (l.n(c()) && l.n(list)) {
                if (l.this.f1537g.containsValue(this.f1602b)) {
                    this.f1602b.l(this);
                }
                SocketAddress socketAddress = list.get(0).f17080a.get(0);
                if (l.this.f1538h.containsKey(socketAddress)) {
                    l.this.f1538h.get(socketAddress).c(this);
                }
            } else if (!l.n(c()) || l.n(list)) {
                if (!l.n(c()) && l.n(list)) {
                    SocketAddress socketAddress2 = list.get(0).f17080a.get(0);
                    if (l.this.f1538h.containsKey(socketAddress2)) {
                        l.this.f1538h.get(socketAddress2).c(this);
                    }
                }
            } else if (l.this.f1538h.containsKey(b().f17080a.get(0))) {
                d dVar = l.this.f1538h.get(b().f17080a.get(0));
                dVar.l(this);
                dVar.m();
            }
            this.f1601a.j(list);
        }

        @Override // ck.g
        public o1.j k() {
            return this.f1601a;
        }

        public void n() {
            this.f1602b = null;
        }

        public void o() {
            this.f1603c = true;
            this.f1605e.a(v.b(y2.f17563t));
            this.f1606f.b(vj.h.a.INFO, "Subchannel ejected: {0}", this);
        }

        public boolean p() {
            return this.f1603c;
        }

        public void q(d dVar) {
            this.f1602b = dVar;
        }

        public void r() {
            this.f1603c = false;
            v vVar = this.f1604d;
            if (vVar != null) {
                this.f1605e.a(vVar);
                this.f1606f.b(vj.h.a.INFO, "Subchannel unejected: {0}", this);
            }
        }

        @Override // ck.g
        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.f1601a.c() + rs.f.f14860b;
        }
    }

    public interface j {
        @gm.j
        static List<j> b(g gVar, vj.h hVar) {
            i3.a aVarBuilder = i3.builder();
            if (gVar.f1567e != null) {
                aVarBuilder.j(new k(gVar, hVar));
            }
            if (gVar.f1568f != null) {
                aVarBuilder.j(new f(gVar, hVar));
            }
            return aVarBuilder.e();
        }

        void a(e eVar, long j10);
    }

    public static class k implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f1610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.h f1611b;

        public k(g gVar, vj.h hVar) {
            h0.e(gVar.f1567e != null, "success rate ejection config is null");
            this.f1610a = gVar;
            this.f1611b = hVar;
        }

        @b1.e
        public static double c(Collection<Double> collection) {
            Iterator<Double> it = collection.iterator();
            double dDoubleValue = 0.0d;
            while (it.hasNext()) {
                dDoubleValue += it.next().doubleValue();
            }
            return dDoubleValue / ((double) collection.size());
        }

        @b1.e
        public static double d(Collection<Double> collection, double d10) {
            Iterator<Double> it = collection.iterator();
            double d11 = 0.0d;
            while (it.hasNext()) {
                double dDoubleValue = it.next().doubleValue() - d10;
                d11 += dDoubleValue * dDoubleValue;
            }
            return Math.sqrt(d11 / ((double) collection.size()));
        }

        @Override // ck.l.j
        public void a(e eVar, long j10) {
            List<d> listO = l.o(eVar, this.f1610a.f1567e.f1588d.intValue());
            if (listO.size() < this.f1610a.f1567e.f1587c.intValue() || listO.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = listO.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(((d) it.next()).q()));
            }
            double dC = c(arrayList);
            double d10 = d(arrayList, dC);
            double dIntValue = dC - (((double) (this.f1610a.f1567e.f1585a.intValue() / 1000.0f)) * d10);
            for (d dVar : listO) {
                if (eVar.q() >= this.f1610a.f1566d.intValue()) {
                    return;
                }
                if (dVar.q() < dIntValue) {
                    this.f1611b.b(vj.h.a.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", dVar, Double.valueOf(dVar.q()), Double.valueOf(dC), Double.valueOf(d10), Double.valueOf(dIntValue));
                    if (new Random().nextInt(100) < this.f1610a.f1567e.f1586b.intValue()) {
                        dVar.f(j10);
                    }
                }
            }
        }
    }

    public l(o1.f fVar, n3 n3Var) {
        vj.h hVarI = fVar.i();
        this.f1546p = hVarI;
        b bVar = new b((o1.f) h0.F(fVar, "helper"));
        this.f1540j = bVar;
        this.f1541k = new ck.h(bVar);
        this.f1537g = new e();
        this.f1539i = (c3) h0.F(fVar.m(), "syncContext");
        this.f1543m = (ScheduledExecutorService) h0.F(fVar.l(), "timeService");
        this.f1542l = n3Var;
        hVarI.a(vj.h.a.DEBUG, "OutlierDetection lb created.");
    }

    public static boolean n(List<d0> list) {
        Iterator<d0> it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().f17080a.size();
            if (size > 1) {
                return false;
            }
        }
        return true;
    }

    public static List<d> o(e eVar, int i10) {
        ArrayList arrayList = new ArrayList();
        for (d dVar : eVar.values()) {
            if (dVar.i() >= i10) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    @Override // vj.o1
    public y2 a(o1.i iVar) {
        this.f1546p.b(vj.h.a.DEBUG, "Received resolution result: {0}", iVar);
        g gVar = (g) iVar.f17219c;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        for (d0 d0Var : iVar.f17217a) {
            t3 t3VarCopyOf = t3.copyOf((Collection) d0Var.f17080a);
            hashSet.add(t3VarCopyOf);
            for (SocketAddress socketAddress : d0Var.f17080a) {
                if (map.containsKey(socketAddress)) {
                    this.f1546p.b(vj.h.a.WARNING, "Unexpected duplicated address {0} belongs to multiple endpoints", socketAddress);
                }
                map.put(socketAddress, t3VarCopyOf);
            }
        }
        this.f1537g.keySet().retainAll(hashSet);
        this.f1537g.w(gVar);
        this.f1537g.t(gVar, hashSet);
        this.f1538h.clear();
        for (Map.Entry entry : map.entrySet()) {
            this.f1538h.put((SocketAddress) entry.getKey(), this.f1537g.get(entry.getValue()));
        }
        this.f1541k.t(gVar.f1569g.f18607a);
        if (gVar.a()) {
            Long lValueOf = this.f1545o == null ? gVar.f1563a : Long.valueOf(Math.max(0L, gVar.f1563a.longValue() - (this.f1542l.a() - this.f1545o.longValue())));
            c3.d dVar = this.f1544n;
            if (dVar != null) {
                dVar.a();
                this.f1537g.u();
            }
            this.f1544n = this.f1539i.d(new c(gVar, this.f1546p), lValueOf.longValue(), gVar.f1563a.longValue(), TimeUnit.NANOSECONDS, this.f1543m);
        } else {
            c3.d dVar2 = this.f1544n;
            if (dVar2 != null) {
                dVar2.a();
                this.f1545o = null;
                this.f1537g.m();
            }
        }
        ck.h hVar = this.f1541k;
        o1.i.a aVarE = iVar.e();
        aVarE.f17222c = gVar.f1569g.f18608b;
        hVar.d(aVarE.a());
        return y2.f17548e;
    }

    @Override // vj.o1
    public void c(y2 y2Var) {
        this.f1541k.c(y2Var);
    }

    @Override // vj.o1
    public void g() {
        this.f1541k.g();
    }
}
