package se;

import android.util.Log;
import k3.gc;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f10025b;

    public /* synthetic */ v0(z0 z0Var, int i8) {
        this.f10024a = 4;
        this.f10025b = z0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z0 z0Var = this.f10025b;
        switch (this.f10024a) {
            case 0:
                q5.a aVar = z0Var.f10076b;
                Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                Intrinsics.checkNotNullParameter("onServiceDisabled", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TranConnectManager"), "onServiceDisabled");
                }
                break;
            case 1:
                z0Var.f10076b.getClass();
                break;
            case 2:
                q5.a aVar2 = z0Var.f10076b;
                Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                Intrinsics.checkNotNullParameter("onServiceEnabled", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TranConnectManager"), "onServiceEnabled");
                }
                lc.a aVar3 = mc.b.f7960c;
                if (aVar3 != null) {
                    Lazy lazy = mc.b.f7958a;
                    mc.b.i(aVar3);
                }
                break;
            case 3:
                z0Var.f10076b.getClass();
                break;
            case 4:
                z0Var.f10076b.getClass();
                break;
            default:
                z0Var.f10076b.getClass();
                break;
        }
    }

    public /* synthetic */ v0(z0 z0Var, int i8, byte b9) {
        this.f10024a = i8;
        this.f10025b = z0Var;
    }
}
