package se;

import androidx.work.WorkRequest;
import com.welink.protocol.nfbd.NearDevice;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o4 f9836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f9838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f9839d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f9840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f9841i;

    public /* synthetic */ k4(o4 o4Var, NearDevice nearDevice, String str, String str2, int i8, String str3, long j8) {
        this.f9836a = o4Var;
        this.f9837b = nearDevice;
        this.f9838c = str;
        this.f9839d = str2;
        this.e = i8;
        this.f9840h = str3;
        this.f9841i = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NearDevice nearDevice = this.f9837b;
        o4 o4Var = this.f9836a;
        o4Var.f9915h = nearDevice;
        int i8 = this.e;
        i2 i2Var = new i2(this.f9838c, this.f9839d, i8, this.f9840h, 0, 0, nearDevice, ye.h.a(i8));
        o4Var.f = i2Var;
        int i9 = nearDevice.p;
        int i10 = 2;
        String str = o4Var.f9912c;
        if (i9 != 2) {
            o4Var.f9917j.add(i2Var);
            i10 = 1;
        } else {
            o4Var.f9918k.add(i2Var);
            int i11 = nearDevice.e;
            if (i11 == 8 || i11 == 1 || i11 == 9 || i11 == 251) {
                long j8 = this.f9841i;
                o4Var.p = j8;
                we.h.h(h0.a.i("P2pConnectController-", str), "P2p owner connect wait timeout: " + j8 + ", for air cast");
            } else {
                o4Var.p = WorkRequest.MIN_BACKOFF_MILLIS;
                we.h.h("P2pConnectController-" + str, "P2p owner connect wait timeout: 10000, for file transfer");
            }
        }
        o4Var.r();
        h4 h4Var = o4Var.f9914g;
        if (h4Var == null || !h4Var.q()) {
            if (h4Var != null) {
                h4Var.m(i2Var, i10);
                return;
            }
            return;
        }
        if (h4Var.r()) {
            we.h.h("P2pConnectController-" + str, "P2p GO connect over group client recover directly");
            h4Var.n(i2Var, i10);
        } else {
            h4Var.n(i2Var, i10);
        }
        o4Var.f9921n = true;
    }
}
