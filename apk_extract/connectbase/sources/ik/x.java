package ik;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<y> f8201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f8202c;

    public x(@os.l String str, @os.l List<y> list) {
        Double d10;
        Object next;
        String str2;
        Double dH0;
        kn.l0.p(str, "value");
        kn.l0.p(list, "params");
        this.f8200a = str;
        this.f8201b = list;
        Iterator<T> it = list.iterator();
        do {
            d10 = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kn.l0.g(((y) next).f8206a, p6.q.f13010a));
        y yVar = (y) next;
        double dDoubleValue = 1.0d;
        if (yVar != null && (str2 = yVar.f8207b) != null && (dH0 = jq.c0.H0(str2)) != null) {
            double dDoubleValue2 = dH0.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                d10 = dH0;
            }
            if (d10 != null) {
                dDoubleValue = d10.doubleValue();
            }
        }
        this.f8202c = dDoubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ x d(x xVar, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = xVar.f8200a;
        }
        if ((i10 & 2) != 0) {
            list = xVar.f8201b;
        }
        return xVar.c(str, list);
    }

    @os.l
    public final String a() {
        return this.f8200a;
    }

    @os.l
    public final List<y> b() {
        return this.f8201b;
    }

    @os.l
    public final x c(@os.l String str, @os.l List<y> list) {
        kn.l0.p(str, "value");
        kn.l0.p(list, "params");
        return new x(str, list);
    }

    @os.l
    public final List<y> e() {
        return this.f8201b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kn.l0.g(this.f8200a, xVar.f8200a) && kn.l0.g(this.f8201b, xVar.f8201b);
    }

    public final double f() {
        return this.f8202c;
    }

    @os.l
    public final String g() {
        return this.f8200a;
    }

    public int hashCode() {
        return this.f8201b.hashCode() + (this.f8200a.hashCode() * 31);
    }

    @os.l
    public String toString() {
        return "HeaderValue(value=" + this.f8200a + ", params=" + this.f8201b + ')';
    }

    public x(String str, List list, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? nm.k0.INSTANCE : list);
    }
}
