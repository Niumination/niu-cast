package se;

import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.util.Log;
import com.welink.protocol.utils.DeviceInfo;
import k3.lb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h5 extends we.g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final k f9773o = new k(c5.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public lc.a f9775d;
    public r6 e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f9783n;

    public h5(Context context, com.welink.protocol.nfbd.g gVar) {
        super(false, "TranConnectionControllerHandlerThread");
        this.f9776g = -1;
        this.f9783n = new Object();
        h0.a.D("TranConnectionController init, ", context.getPackageName(), "TranConnectionController");
    }

    public final void j(Integer num, String str, String str2, DeviceInfo devinfo, ScanResult result) {
        Intrinsics.checkNotNullParameter(devinfo, "devinfo");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.f9774c) {
            lc.a aVar = this.f9775d;
            if (aVar != null) {
                aVar.invoke(result, devinfo);
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter("Send file activity not foreground", "mes");
        if (lb.f6529c >= 2) {
            Log.w("welinkBLE", "Send file activity not foreground", null);
        }
    }

    public final void k(String str) {
        this.f = str;
        o.d.z("Setting PidInfo: ", str, "TranConnectionController");
    }

    public final void l(int i8) {
        we.h.b("TranConnectionController", "setting scenario: " + i8 + ", notify: false");
        if (i8 < 0 || (i8 >= 14 && i8 != 251)) {
            we.h.d("Scenario is invalid", null);
        } else {
            this.f9776g = i8;
        }
    }

    public final void m(String str) {
        o.d.z("Setting DeviceName: ", str, "TranConnectionController");
    }

    public final void n() {
        synchronized (this.f9783n) {
            try {
                int i8 = this.f9782m;
                if (i8 > 0) {
                    int i9 = i8 - 1;
                    this.f9782m = i9;
                    if (i9 == 0) {
                        this.f9775d = null;
                        Intrinsics.checkNotNullParameter("Stop scaning success", "mes");
                        if (lb.f6529c >= 2) {
                            Log.w("welinkBLE", "Stop scaning success", null);
                        }
                    } else {
                        Intrinsics.checkNotNullParameter("Other scanning request is pending, ignore this", "mes");
                        if (lb.f6529c >= 2) {
                            Log.w("welinkBLE", "Other scanning request is pending, ignore this", null);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
