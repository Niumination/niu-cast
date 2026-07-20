package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f1102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1104d;

    public /* synthetic */ c(Object obj, Executor executor, Object obj2, int i8) {
        this.f1101a = i8;
        this.f1103c = obj;
        this.f1102b = executor;
        this.f1104d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1101a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f1103c).lambda$onGnssMeasurementsReceived$0(this.f1102b, (GnssMeasurementsEvent) this.f1104d);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f1103c).lambda$onGpsStatusChanged$3(this.f1102b, (GnssStatusCompat) this.f1104d);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f1103c).lambda$onSatelliteStatusChanged$3(this.f1102b, (GnssStatus) this.f1104d);
                break;
        }
    }
}
