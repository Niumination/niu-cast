package se;

import android.util.Log;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o4 f9833b;

    public /* synthetic */ j4(o4 o4Var, int i8) {
        this.f9832a = i8;
        this.f9833b = o4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9832a) {
            case 0:
                Intrinsics.checkNotNullParameter("P2p wifi off timeout", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "P2p wifi off timeout", null);
                }
                o4.m(this.f9833b, "0", 10, -1, "pc");
                break;
            case 1:
                Intrinsics.checkNotNullParameter("P2p disconnect timeout", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "P2p disconnect timeout", null);
                }
                o4.m(this.f9833b, "0", 11, -1, "pc");
                break;
            case 2:
                Intrinsics.checkNotNullParameter("P2p Connect timeout", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "P2p Connect timeout", null);
                }
                o4.m(this.f9833b, "0", 6, -1, "pc");
                break;
            case 3:
                Intrinsics.checkNotNullParameter("P2p Reset timeout", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "P2p Reset timeout", null);
                }
                o4.m(this.f9833b, "0", 21, -1, "pc");
                break;
            default:
                o4 o4Var = this.f9833b;
                o4Var.f9915h = null;
                i2 i2Var = new i2(0, null, null, null, null);
                o4Var.f9918k.add(i2Var);
                o4Var.r();
                h4 h4Var = o4Var.f9914g;
                if (h4Var != null && h4Var.q()) {
                    if (h4Var.r()) {
                        we.h.h("P2pConnectController-" + o4Var.f9912c, "P2p GO connect over group client recover directly");
                        h4Var.n(i2Var, 2);
                    } else {
                        h4Var.n(i2Var, 2);
                    }
                    o4Var.f9921n = true;
                } else if (h4Var != null) {
                    h4Var.m(i2Var, 2);
                }
                break;
        }
    }
}
