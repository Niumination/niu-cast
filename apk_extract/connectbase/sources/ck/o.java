package ck;

import c1.h0;
import c1.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import vj.o1;
import vj.t0;
import vj.u;

/* JADX INFO: loaded from: classes2.dex */
@t0
public class o extends j {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f1614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o1.k f1615n;

    @b1.e
    public static final class a extends o1.k {
        @Override // vj.o1.k
        public o1.g a(o1.h hVar) {
            return o1.g.g();
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return a.class.hashCode();
        }
    }

    @b1.e
    public static class b extends o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<o1.k> f1616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f1617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1618c;

        public b(List<o1.k> list, AtomicInteger atomicInteger) {
            h0.e(!list.isEmpty(), "empty list");
            this.f1616a = list;
            this.f1617b = (AtomicInteger) h0.F(atomicInteger, "index");
            Iterator<o1.k> it = list.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += it.next().hashCode();
            }
            this.f1618c = iHashCode;
        }

        @Override // vj.o1.k
        public o1.g a(o1.h hVar) {
            return this.f1616a.get(d()).a(hVar);
        }

        @b1.e
        public List<o1.k> c() {
            return this.f1616a;
        }

        public final int d() {
            return (this.f1617b.getAndIncrement() & Integer.MAX_VALUE) % this.f1616a.size();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar == this) {
                return true;
            }
            return this.f1618c == bVar.f1618c && this.f1617b == bVar.f1617b && this.f1616a.size() == bVar.f1616a.size() && new HashSet(this.f1616a).containsAll(bVar.f1616a);
        }

        public int hashCode() {
            return this.f1618c;
        }

        public String toString() {
            return z.b(b.class).j("subchannelPickers", this.f1616a).toString();
        }
    }

    public o(o1.f fVar) {
        super(fVar);
        this.f1614m = new AtomicInteger(new Random().nextInt());
        this.f1615n = new a();
    }

    private void F(u uVar, o1.k kVar) {
        if (uVar == this.f1520k && kVar.equals(this.f1615n)) {
            return;
        }
        this.f1517h.q(uVar, kVar);
        this.f1520k = uVar;
        this.f1615n = kVar;
    }

    @Override // ck.j
    public void D() {
        List<j.b> listX = x();
        if (!listX.isEmpty()) {
            F(u.READY, E(listX));
            return;
        }
        Iterator<j.b> it = this.f1516g.values().iterator();
        while (it.hasNext()) {
            u uVar = it.next().f1528f;
            u uVar2 = u.CONNECTING;
            if (uVar == uVar2 || uVar == u.IDLE) {
                F(uVar2, new a());
                return;
            }
        }
        F(u.TRANSIENT_FAILURE, E(this.f1516g.values()));
    }

    public o1.k E(Collection<j.b> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<j.b> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f1529g);
        }
        return new b(arrayList, this.f1614m);
    }
}
