package wj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.w f18315a;

    public a0(vj.w wVar) {
        this.f18315a = wVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        vj.w wVarC = this.f18315a.c();
        try {
            a();
        } finally {
            this.f18315a.q(wVarC);
        }
    }
}
