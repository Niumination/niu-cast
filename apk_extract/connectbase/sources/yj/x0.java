package yj;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
@gm.c
public final class x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x0 f21301c = new x0(vj.a.f17046c, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.a f21302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.j
    public final vj.v0.f f21303b;

    public x0(vj.a aVar, @gm.j vj.v0.f fVar) {
        this.f21302a = (vj.a) c1.h0.F(aVar, "attributes");
        this.f21303b = fVar;
    }

    public vj.a a() {
        return this.f21302a;
    }

    @gm.j
    public vj.v0.f b() {
        return this.f21303b;
    }

    public x0 c(vj.a aVar) {
        return new x0(aVar, this.f21303b);
    }

    public x0 d(@gm.j vj.v0.f fVar) {
        return new x0(this.f21302a, fVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return c1.b0.a(this.f21302a, x0Var.f21302a) && c1.b0.a(this.f21303b, x0Var.f21303b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f21302a, this.f21303b});
    }

    public String toString() {
        return c1.z.c(this).j("attributes", this.f21302a).j("security", this.f21303b).toString();
    }
}
