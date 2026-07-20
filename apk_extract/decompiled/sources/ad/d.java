package ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Message;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayDeque;
import k3.dd;
import m3.f0;
import y6.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f95a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f96b;

    public /* synthetic */ d(int i8) {
        this.f95a = i8;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        j jVar;
        Thread thread;
        switch (this.f95a) {
            case 0:
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (this.f96b) {
                        this.f96b = false;
                    } else {
                        try {
                            if (c.i(context)) {
                                i.a(context).i();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
                break;
            default:
                String action = intent.getAction();
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    if ("android.location.PROVIDERS_CHANGED".equals(action)) {
                        if (z6.b.f(context, "android.permission.ACCESS_FINE_LOCATION") || z6.b.f(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                            try {
                                LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                                if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")) {
                                }
                                e8.b bVarN = e8.b.n(9999);
                                bVarN.getClass();
                                if (e8.b.m() && e8.b.f4710g == 0 && bVarN.k() != null) {
                                    Message message = new Message();
                                    message.what = TypedValues.PositionType.TYPE_DRAWPATH;
                                    bVarN.k().b(message, 3000L);
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    break;
                } else if (this.f96b) {
                    this.f96b = false;
                    break;
                } else {
                    try {
                        if (f0.d(context) && dd.l(context)) {
                            if (e8.b.f != null) {
                                e8.b bVar = e8.b.f;
                                bVar.getClass();
                                if (e8.b.m() && e8.b.f4710g == 0 && bVar.k() != null) {
                                    bVar.k().f();
                                }
                            }
                            if (e8.b.m() && e8.b.f4710g == 0) {
                                for (y6.d dVar : (ArrayDeque) y6.g.a().f11095a) {
                                    if ((dVar instanceof j) && (thread = (jVar = (j) dVar).f11088b) != null && !thread.isInterrupted()) {
                                        jVar.f11088b.interrupt();
                                    }
                                }
                            }
                            break;
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        return;
                    }
                }
                break;
        }
    }
}
