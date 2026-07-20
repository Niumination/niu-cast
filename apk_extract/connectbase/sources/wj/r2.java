package wj;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@b1.e
public final class r2 extends vj.x1.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f19256d;

    public r2(boolean z10, int i10, int i11, j jVar) {
        this.f19253a = z10;
        this.f19254b = i10;
        this.f19255c = i11;
        this.f19256d = (j) c1.h0.F(jVar, "autoLoadBalancerFactory");
    }

    @Override // vj.x1.i
    public vj.x1.c a(Map<String, ?> map) {
        Object obj;
        try {
            vj.x1.c cVarF = this.f19256d.f(map);
            if (cVarF == null) {
                obj = null;
            } else {
                vj.y2 y2Var = cVarF.f17531a;
                if (y2Var != null) {
                    return new vj.x1.c(y2Var);
                }
                obj = cVarF.f17532b;
            }
            return vj.x1.c.a(q1.b(map, this.f19253a, this.f19254b, this.f19255c, obj));
        } catch (RuntimeException e10) {
            return vj.x1.c.b(vj.y2.f17550g.u("failed to parse service config").t(e10));
        }
    }
}
