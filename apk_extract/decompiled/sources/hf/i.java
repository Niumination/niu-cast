package hf;

import k3.t8;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends m4.j {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ze.j f5310j;

    public i(ze.j jVar) {
        this.f5310j = jVar;
    }

    @Override // m4.j
    public final void g() {
        this.f5310j.a("GrpcFuture was cancelled", null);
    }

    @Override // m4.j
    public final String h() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f5310j, "clientCall");
        return aVarA.toString();
    }
}
