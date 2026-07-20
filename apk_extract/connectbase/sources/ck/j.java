package ck;

import c1.h0;
import f1.i3;
import f1.k3;
import f1.x7;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import vj.d0;
import vj.o1;
import vj.p1;
import vj.t0;
import vj.u;
import vj.y2;
import wj.f2;

/* JADX INFO: loaded from: classes2.dex */
@t0
public abstract class j extends o1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Logger f1515l = Logger.getLogger(j.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o1.f f1517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1518i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public u f1520k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Object, b> f1516g = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p1 f1519j = new f2();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y2 f1521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f1522b;

        public a(y2 y2Var, List<b> list) {
            this.f1521a = y2Var;
            this.f1522b = list;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o1.i f1524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f1525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h f1526d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final p1 f1527e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public u f1528f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public o1.k f1529g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1530h;

        public class a extends f {
            public a() {
            }

            @Override // ck.f, vj.o1.f
            public void q(u uVar, o1.k kVar) {
                if (j.this.f1516g.containsKey(b.this.f1523a)) {
                    b bVar = b.this;
                    bVar.f1528f = uVar;
                    bVar.f1529g = kVar;
                    if (bVar.f1530h || j.this.f1518i) {
                        return;
                    }
                    if (uVar == u.IDLE) {
                        bVar.f1526d.f();
                    }
                    j.this.D();
                }
            }

            @Override // ck.f
            public o1.f t() {
                return j.this.f1517h;
            }
        }

        public b(j jVar, Object obj, p1 p1Var, Object obj2, o1.k kVar) {
            this(obj, p1Var, obj2, kVar, null, false);
        }

        public static Object b(b bVar) {
            return bVar.f1525c;
        }

        public a g() {
            return new a();
        }

        public void h() {
            if (this.f1530h) {
                return;
            }
            j.this.f1516g.remove(this.f1523a);
            this.f1530h = true;
            j.f1515l.log(Level.FINE, "Child balancer {0} deactivated", this.f1523a);
        }

        public final Object i() {
            return this.f1525c;
        }

        @b1.e
        public final o1.k j() {
            return this.f1529g;
        }

        public final u k() {
            return this.f1528f;
        }

        public final d0 l() {
            o1.i iVar = this.f1524b;
            if (iVar == null || iVar.f17217a.isEmpty()) {
                return null;
            }
            return this.f1524b.f17217a.get(0);
        }

        public final Object m() {
            return this.f1523a;
        }

        @b1.e
        public final h n() {
            return this.f1526d;
        }

        public final p1 o() {
            return this.f1527e;
        }

        @b1.e
        public final o1.i p() {
            return this.f1524b;
        }

        public final o1.j q(o1.h hVar) {
            o1.k kVar = this.f1529g;
            if (kVar == null) {
                return null;
            }
            return kVar.a(hVar).f17213a;
        }

        public final boolean r() {
            return this.f1530h;
        }

        public final void s() {
            this.f1530h = false;
        }

        public void t(p1 p1Var) {
            this.f1530h = false;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Address = ");
            sb2.append(this.f1523a);
            sb2.append(", state = ");
            sb2.append(this.f1528f);
            sb2.append(", picker type: ");
            sb2.append(this.f1529g.getClass());
            sb2.append(", lb: ");
            sb2.append(this.f1526d.h().getClass());
            sb2.append(this.f1530h ? ", deactivated" : "");
            return sb2.toString();
        }

        public final void u(o1.k kVar) {
            this.f1529g = kVar;
        }

        public final void v(u uVar) {
            this.f1528f = uVar;
        }

        public final void w() {
            this.f1530h = true;
        }

        public final void x(o1.i iVar) {
            h0.F(iVar, "Missing address list for child");
            this.f1524b = iVar;
        }

        public void y() {
            this.f1526d.g();
            this.f1528f = u.SHUTDOWN;
            j.f1515l.log(Level.FINE, "Child balancer {0} deleted", this.f1523a);
        }

        public b(Object obj, p1 p1Var, Object obj2, o1.k kVar, o1.i iVar, boolean z10) {
            this.f1523a = obj;
            this.f1527e = p1Var;
            this.f1530h = z10;
            this.f1529g = kVar;
            this.f1525c = obj2;
            h hVar = new h(g());
            this.f1526d = hVar;
            this.f1528f = z10 ? u.IDLE : u.CONNECTING;
            this.f1524b = iVar;
            if (z10) {
                return;
            }
            hVar.t(p1Var);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f1533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1534b;

        public c(d0 d0Var) {
            h0.F(d0Var, "eag");
            this.f1533a = new String[d0Var.f17080a.size()];
            Iterator<SocketAddress> it = d0Var.f17080a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                this.f1533a[i10] = it.next().toString();
                i10++;
            }
            Arrays.sort(this.f1533a);
            this.f1534b = Arrays.hashCode(this.f1533a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.f1534b == this.f1534b) {
                String[] strArr = cVar.f1533a;
                int length = strArr.length;
                String[] strArr2 = this.f1533a;
                if (length == strArr2.length) {
                    return Arrays.equals(strArr, strArr2);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f1534b;
        }

        public String toString() {
            return Arrays.toString(this.f1533a);
        }
    }

    public j(o1.f fVar) {
        this.f1517h = (o1.f) h0.F(fVar, "helper");
        f1515l.log(Level.FINE, "Created");
    }

    @gm.j
    public static u m(@gm.j u uVar, u uVar2) {
        if (uVar == null) {
            return uVar2;
        }
        u uVar3 = u.READY;
        return (uVar == uVar3 || uVar2 == uVar3 || uVar == (uVar3 = u.CONNECTING) || uVar2 == uVar3 || uVar == (uVar3 = u.IDLE) || uVar2 == uVar3) ? uVar3 : uVar;
    }

    public final void A(Object obj) {
        this.f1516g.remove(obj);
    }

    public final void B(List<b> list) {
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            it.next().y();
        }
    }

    public final void C(o1.i iVar, Map<Object, b> map) {
        for (Map.Entry<Object, b> entry : map.entrySet()) {
            Object obj = entry.getValue().f1525c;
            b bVar = this.f1516g.get(entry.getKey());
            o1.i iVarP = p(entry.getKey(), iVar, obj);
            bVar.x(iVarP);
            if (!bVar.f1530h) {
                bVar.f1526d.d(iVarP);
            }
        }
    }

    public abstract void D();

    @Override // vj.o1
    public y2 a(o1.i iVar) {
        try {
            this.f1518i = true;
            a aVarH = h(iVar);
            if (!aVarH.f1521a.r()) {
                return aVarH.f1521a;
            }
            D();
            B(aVarH.f1522b);
            return aVarH.f1521a;
        } finally {
            this.f1518i = false;
        }
    }

    @Override // vj.o1
    public void c(y2 y2Var) {
        if (this.f1520k != u.READY) {
            this.f1517h.q(u.TRANSIENT_FAILURE, t(y2Var));
        }
    }

    @Override // vj.o1
    public void g() {
        f1515l.log(Level.FINE, "Shutdown");
        Iterator<b> it = this.f1516g.values().iterator();
        while (it.hasNext()) {
            it.next().y();
        }
        this.f1516g.clear();
    }

    public final a h(o1.i iVar) {
        f1515l.log(Level.FINE, "Received resolution result: {0}", iVar);
        Map<Object, b> mapN = n(iVar);
        if (mapN.isEmpty()) {
            y2 y2VarU = y2.f17563t.u("NameResolver returned no usable address. " + iVar);
            c(y2VarU);
            return new a(y2VarU, null);
        }
        for (b bVar : l(mapN)) {
            bVar.t(bVar.f1527e);
        }
        C(iVar, mapN);
        return new a(y2.f17548e, y(mapN.keySet()));
    }

    public final Collection<b> l(Map<Object, b> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Object, b> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (this.f1516g.containsKey(key)) {
                b bVar = this.f1516g.get(key);
                if (bVar.f1530h) {
                    arrayList.add(bVar);
                }
            } else {
                this.f1516g.put(key, entry.getValue());
            }
        }
        return arrayList;
    }

    public Map<Object, b> n(o1.i iVar) {
        HashMap map = new HashMap();
        Iterator<d0> it = iVar.f17217a.iterator();
        while (it.hasNext()) {
            c cVar = new c(it.next());
            b bVar = this.f1516g.get(cVar);
            if (bVar != null) {
                map.put(cVar, bVar);
            } else {
                map.put(cVar, o(cVar, null, w(), iVar));
            }
        }
        return map;
    }

    public b o(Object obj, Object obj2, o1.k kVar, o1.i iVar) {
        return new b(this, obj, this.f1519j, obj2, kVar);
    }

    public o1.i p(Object obj, o1.i iVar, Object obj2) {
        c cVar;
        if (obj instanceof d0) {
            cVar = new c((d0) obj);
        } else {
            h0.e(obj instanceof c, "key is wrong type");
            cVar = (c) obj;
        }
        for (d0 d0Var : iVar.f17217a) {
            if (cVar.equals(new c(d0Var))) {
                h0.F(d0Var, obj + " no longer present in load balancer children");
                o1.i.a aVarE = iVar.e();
                aVarE.f17220a = Collections.singletonList(d0Var);
                aVarE.f17221b = vj.a.e().d(o1.f17199e, Boolean.TRUE).a();
                aVarE.f17222c = obj2;
                return aVarE.a();
            }
        }
        d0Var = null;
        h0.F(d0Var, obj + " no longer present in load balancer children");
        o1.i.a aVarE2 = iVar.e();
        aVarE2.f17220a = Collections.singletonList(d0Var);
        aVarE2.f17221b = vj.a.e().d(o1.f17199e, Boolean.TRUE).a();
        aVarE2.f17222c = obj2;
        return aVarE2.a();
    }

    @b1.e
    public final b q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof d0) {
            obj = new c((d0) obj);
        }
        return this.f1516g.get(obj);
    }

    @b1.e
    public final b r(d0 d0Var) {
        return q(new c(d0Var));
    }

    @b1.e
    public final Collection<b> s() {
        return this.f1516g.values();
    }

    public o1.k t(y2 y2Var) {
        return new o1.e(o1.g.f(y2Var));
    }

    public final o1.f u() {
        return this.f1517h;
    }

    @b1.e
    public final k3<Object, b> v() {
        return k3.copyOf((Map) this.f1516g);
    }

    public o1.k w() {
        return new o1.e(o1.g.g());
    }

    public final List<b> x() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f1516g.values()) {
            if (!bVar.f1530h && bVar.f1528f == u.READY) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public final List<b> y(Set<Object> set) {
        ArrayList arrayList = new ArrayList();
        x7 it = i3.copyOf((Collection) this.f1516g.keySet()).iterator();
        while (it.hasNext()) {
            E next = it.next();
            if (!set.contains(next)) {
                b bVar = this.f1516g.get(next);
                bVar.h();
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void z(b bVar, y2 y2Var) {
        bVar.f1526d.c(y2Var);
    }
}
