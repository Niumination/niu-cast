package hf;

import k3.a9;
import k3.v8;
import ze.c2;
import ze.p1;
import ze.q2;
import ze.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends a9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c2 f5320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f5322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5323d;
    public boolean e = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5324h = false;

    public o(c2 c2Var, boolean z2) {
        this.f5320a = c2Var;
        this.f5321b = z2;
    }

    @Override // hf.v
    public final void onCompleted() {
        this.f5320a.a(q2.e, new p1());
        this.f5324h = true;
    }

    @Override // hf.v
    public final void onError(Throwable th2) {
        p1 p1VarF = q2.f(th2);
        if (p1VarF == null) {
            p1VarF = new p1();
        }
        this.f5320a.a(q2.d(th2), p1VarF);
        this.e = true;
    }

    @Override // hf.v
    public final void onNext(Object obj) {
        if (this.f5322c && this.f5321b) {
            throw new s2(q2.f.h("call already cancelled. Use ServerCallStreamObserver.setOnCancelHandler() to disable this exception"));
        }
        v8.n(!this.e, "Stream was terminated by error, no further calls are allowed");
        v8.n(!this.f5324h, "Stream is already completed, no further calls are allowed");
        if (!this.f5323d) {
            this.f5320a.c(new p1());
            this.f5323d = true;
        }
        this.f5320a.d(obj);
    }
}
