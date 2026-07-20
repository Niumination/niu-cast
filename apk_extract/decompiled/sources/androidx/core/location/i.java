package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f1122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Executor f1123c;

    public /* synthetic */ i(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i8) {
        this.f1121a = i8;
        this.f1122b = preRGnssStatusTransport;
        this.f1123c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1121a) {
            case 0:
                this.f1122b.lambda$onStopped$1(this.f1123c);
                break;
            default:
                this.f1122b.lambda$onStarted$0(this.f1123c);
                break;
        }
    }
}
