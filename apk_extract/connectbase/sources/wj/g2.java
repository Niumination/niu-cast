package wj;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class g2 extends vj.o1.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.e f18695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.v1 f18696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vj.w1<?, ?> f18697c;

    public g2(vj.w1<?, ?> w1Var, vj.v1 v1Var, vj.e eVar) {
        this.f18697c = (vj.w1) c1.h0.F(w1Var, "method");
        this.f18696b = (vj.v1) c1.h0.F(v1Var, "headers");
        this.f18695a = (vj.e) c1.h0.F(eVar, "callOptions");
    }

    @Override // vj.o1.h
    public vj.e a() {
        return this.f18695a;
    }

    @Override // vj.o1.h
    public vj.v1 b() {
        return this.f18696b;
    }

    @Override // vj.o1.h
    public vj.w1<?, ?> c() {
        return this.f18697c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g2.class != obj.getClass()) {
            return false;
        }
        g2 g2Var = (g2) obj;
        return c1.b0.a(this.f18695a, g2Var.f18695a) && c1.b0.a(this.f18696b, g2Var.f18696b) && c1.b0.a(this.f18697c, g2Var.f18697c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f18695a, this.f18696b, this.f18697c});
    }

    public final String toString() {
        return "[method=" + this.f18697c + " headers=" + this.f18696b + " callOptions=" + this.f18695a + "]";
    }
}
