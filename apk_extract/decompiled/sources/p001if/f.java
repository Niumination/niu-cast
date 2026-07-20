package p001if;

import af.h4;
import af.l;
import ze.b1;
import ze.q;
import ze.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f5803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f5804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h4 f5805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f5806d;
    public z0 e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f5807g;

    public f(h hVar, g gVar, h4 h4Var) {
        l lVar = b1.f11328c;
        this.f5807g = hVar;
        this.f5803a = gVar;
        this.f5805c = h4Var;
        this.f = false;
        this.e = lVar;
        d dVar = new d(new e(this));
        this.f5804b = dVar;
        this.f5806d = q.CONNECTING;
        dVar.i(h4Var);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Address = ");
        sb2.append(this.f5803a);
        sb2.append(", state = ");
        sb2.append(this.f5806d);
        sb2.append(", picker type: ");
        sb2.append(this.e.getClass());
        sb2.append(", lb: ");
        sb2.append(this.f5804b.g().getClass());
        sb2.append(this.f ? ", deactivated" : "");
        return sb2.toString();
    }
}
