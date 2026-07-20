package qg;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f9112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9113b;

    public s0(r0 r0Var, int i8) {
        this.f9112a = r0Var;
        this.f9113b = i8;
    }

    @Override // qg.r0
    public final String a() {
        return this.f9112a.a();
    }

    @Override // qg.r0
    public final int getPort() {
        return this.f9113b;
    }

    @Override // qg.r0
    public final u getType() {
        return this.f9112a.getType();
    }
}
