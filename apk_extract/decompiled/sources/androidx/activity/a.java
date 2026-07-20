package androidx.activity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f806b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f805a = i8;
        this.f806b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f805a;
        Object obj = this.f806b;
        switch (i8) {
            case 0:
                ComponentActivity.ReportFullyDrawnExecutorImpl.execute$lambda$0((ComponentActivity.ReportFullyDrawnExecutorImpl) obj);
                break;
            default:
                ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$0((ComponentActivity) obj);
                break;
        }
    }
}
