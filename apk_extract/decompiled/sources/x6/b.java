package x6;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f10870a;

    public b(c cVar) {
        this.f10870a = cVar;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        c cVar = this.f10870a;
        Handler handler = (Handler) cVar.f1435c;
        if (handler != null) {
            handler.removeCallbacks(cVar.q);
        }
        try {
            cVar.m(location);
            LocationManager locationManager = (LocationManager) ((Context) cVar.f1434b).getApplicationContext().getSystemService("location");
            if (locationManager != null) {
                locationManager.removeUpdates(cVar.f10881r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i8, Bundle bundle) {
    }
}
