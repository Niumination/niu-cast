package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1100c;

    public /* synthetic */ b(int i8, Object obj, Object obj2) {
        this.f1098a = i8;
        this.f1099b = obj;
        this.f1100c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1098a) {
            case 0:
                ((Consumer) this.f1099b).accept((Location) this.f1100c);
                break;
            case 1:
                ((LocationManagerCompat.LocationListenerTransport) this.f1099b).lambda$onLocationChanged$1((List) this.f1100c);
                break;
            default:
                ((LocationManagerCompat.LocationListenerTransport) this.f1099b).lambda$onLocationChanged$0((Location) this.f1100c);
                break;
        }
    }
}
