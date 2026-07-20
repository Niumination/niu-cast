package cf;

import af.l1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f1504b;

    public /* synthetic */ c0(h0 h0Var, int i8) {
        this.f1503a = i8;
        this.f1504b = h0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1503a) {
            case 0:
                l1.b(this.f1504b.e);
                break;
            case 1:
                this.f1504b.n();
                break;
            case 2:
                this.f1504b.k(null);
                break;
            default:
                h0 h0Var = this.f1504b;
                h0Var.k(Long.valueOf(h0Var.f1535a.f1516n));
                break;
        }
    }
}
