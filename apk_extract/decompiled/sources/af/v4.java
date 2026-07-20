package af;

import com.google.protobuf.MessageLite;

/* JADX INFO: loaded from: classes3.dex */
public final class v4 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x2 f635b;

    public v4(x2 x2Var, Object obj) {
        this.f635b = x2Var;
        this.f634a = obj;
    }

    @Override // af.x4
    public final void a(e5 e5Var) {
        b0 b0Var = e5Var.f245a;
        gf.b bVar = this.f635b.f683a.f11425d;
        bVar.getClass();
        b0Var.i(new gf.a((MessageLite) this.f634a, bVar.f5181a));
        e5Var.f245a.flush();
    }
}
