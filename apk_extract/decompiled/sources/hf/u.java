package hf;

import af.p5;
import k3.v8;
import ze.c2;
import ze.d2;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5332b;

    public /* synthetic */ u(Object obj, boolean z2) {
        this.f5332b = obj;
        this.f5331a = z2;
    }

    @Override // ze.d2
    public ze.i e(c2 c2Var) {
        v8.c("asyncUnaryRequestCall is only for clientSendsOneMessage methods", ((p5) c2Var).f511b.f11422a.clientSendsOneMessage());
        o oVar = new o(c2Var, this.f5331a);
        c2Var.b(2);
        return new t(this, oVar, c2Var);
    }
}
