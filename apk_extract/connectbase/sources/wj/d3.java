package wj;

/* JADX INFO: loaded from: classes2.dex */
public final class d3 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f18478e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.j
    public final vj.x1.c f18479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.j
    public vj.x1.c f18481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18482d;

    public d3(@gm.j q1 q1Var, boolean z10) {
        if (q1Var == null) {
            this.f18479a = null;
        } else {
            this.f18479a = vj.x1.c.a(q1Var);
        }
        this.f18480b = z10;
        if (z10) {
            return;
        }
        this.f18481c = this.f18479a;
    }

    public boolean a() {
        return this.f18480b;
    }

    @gm.j
    public vj.x1.c b() {
        c1.h0.h0(!c(), "still waiting on service config");
        return this.f18481c;
    }

    public boolean c() {
        return !this.f18482d && this.f18480b;
    }

    public void d(@gm.j vj.x1.c cVar) {
        c1.h0.h0(this.f18480b, "unexpected service config update");
        boolean z10 = this.f18482d;
        this.f18482d = true;
        if (!z10) {
            if (cVar == null) {
                this.f18481c = this.f18479a;
                return;
            }
            if (cVar.f17531a == null) {
                this.f18481c = cVar;
                return;
            }
            vj.x1.c cVar2 = this.f18479a;
            if (cVar2 != null) {
                this.f18481c = cVar2;
                return;
            } else {
                this.f18481c = cVar;
                return;
            }
        }
        if (cVar == null) {
            vj.x1.c cVar3 = this.f18479a;
            if (cVar3 != null) {
                this.f18481c = cVar3;
                return;
            } else {
                this.f18481c = null;
                return;
            }
        }
        if (cVar.f17531a == null) {
            this.f18481c = cVar;
            return;
        }
        vj.x1.c cVar4 = this.f18481c;
        if (cVar4 == null || cVar4.f17531a == null) {
            return;
        }
        this.f18481c = cVar;
    }
}
