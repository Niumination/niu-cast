package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f1106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1108d;

    public /* synthetic */ d(Object obj, Executor executor, int i8, int i9) {
        this.f1105a = i9;
        this.f1108d = obj;
        this.f1106b = executor;
        this.f1107c = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1105a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f1108d).lambda$onStatusChanged$1(this.f1106b, this.f1107c);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f1108d).lambda$onGpsStatusChanged$2(this.f1106b, this.f1107c);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f1108d).lambda$onFirstFix$2(this.f1106b, this.f1107c);
                break;
        }
    }
}
