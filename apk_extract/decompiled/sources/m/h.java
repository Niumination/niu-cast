package m;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m4.l f7552b;

    public /* synthetic */ h(m4.l lVar, int i8) {
        this.f7551a = i8;
        this.f7552b = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f7551a;
        m4.l lVar = this.f7552b;
        switch (i8) {
            case 0:
                lVar.cancel(true);
                break;
            default:
                lVar.cancel(true);
                break;
        }
    }
}
