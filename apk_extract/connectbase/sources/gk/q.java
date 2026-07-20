package gk;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<String, o> f6689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<jn.p<dk.b, nk.s, Boolean>> f6690b;

    public q() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ q d(q qVar, Map map, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = qVar.f6689a;
        }
        if ((i10 & 2) != 0) {
            list = qVar.f6690b;
        }
        return qVar.c(map, list);
    }

    @os.l
    public final Map<String, o> a() {
        return this.f6689a;
    }

    @os.l
    public final List<jn.p<dk.b, nk.s, Boolean>> b() {
        return this.f6690b;
    }

    @os.l
    public final q c(@os.l Map<String, o> map, @os.l List<? extends jn.p<? super dk.b, ? super nk.s, Boolean>> list) {
        kn.l0.p(map, "encoders");
        kn.l0.p(list, "conditions");
        return new q(map, list);
    }

    @os.l
    public final List<jn.p<dk.b, nk.s, Boolean>> e() {
        return this.f6690b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return kn.l0.g(this.f6689a, qVar.f6689a) && kn.l0.g(this.f6690b, qVar.f6690b);
    }

    @os.l
    public final Map<String, o> f() {
        return this.f6689a;
    }

    public int hashCode() {
        return this.f6690b.hashCode() + (this.f6689a.hashCode() * 31);
    }

    @os.l
    public String toString() {
        return "CompressionOptions(encoders=" + this.f6689a + ", conditions=" + this.f6690b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(@os.l Map<String, o> map, @os.l List<? extends jn.p<? super dk.b, ? super nk.s, Boolean>> list) {
        kn.l0.p(map, "encoders");
        kn.l0.p(list, "conditions");
        this.f6689a = map;
        this.f6690b = list;
    }

    public q(Map map, List list, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? nm.d1.z() : map, (i10 & 2) != 0 ? nm.k0.INSTANCE : list);
    }
}
