package androidx.core.location;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f1113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1114c;

    public /* synthetic */ f(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i8) {
        this.f1112a = i8;
        this.f1113b = locationListenerTransport;
        this.f1114c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1112a) {
            case 0:
                this.f1113b.lambda$onProviderEnabled$4(this.f1114c);
                break;
            default:
                this.f1113b.lambda$onProviderDisabled$5(this.f1114c);
                break;
        }
    }
}
