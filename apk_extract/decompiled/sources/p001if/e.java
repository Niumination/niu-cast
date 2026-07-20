package p001if;

import ze.f0;
import ze.q;
import ze.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f5802a;

    public e(f fVar) {
        this.f5802a = fVar;
    }

    @Override // ze.f0
    public final void m(q qVar, z0 z0Var) {
        f fVar = this.f5802a;
        if (fVar.f5807g.f5811d.containsKey(fVar.f5803a)) {
            fVar.f5806d = qVar;
            fVar.e = z0Var;
            if (fVar.f) {
                return;
            }
            h hVar = fVar.f5807g;
            if (hVar.f) {
                return;
            }
            if (qVar == q.IDLE) {
                fVar.f5804b.e();
            }
            hVar.h();
        }
    }

    @Override // p001if.a
    public final f0 n() {
        return this.f5802a.f5807g.e;
    }
}
