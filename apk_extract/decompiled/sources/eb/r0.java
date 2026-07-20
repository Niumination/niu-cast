package eb;

import android.util.Log;
import androidx.lifecycle.Observer;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ li.g2 f4791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ li.l f4792c;

    public /* synthetic */ r0(li.g2 g2Var, li.l lVar, int i8) {
        this.f4790a = i8;
        this.f4791b = g2Var;
        this.f4792c = lVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        switch (this.f4790a) {
            case 0:
                if (((Boolean) obj).booleanValue()) {
                    Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
                    Intrinsics.checkNotNullParameter("openBluetooth success", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("PCConnectSwitchManager"), "openBluetooth success");
                    }
                    this.f4791b.h(null);
                    na.a.b(this.f4792c, Boolean.TRUE);
                }
                break;
            default:
                if (((Boolean) obj).booleanValue()) {
                    Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
                    Intrinsics.checkNotNullParameter("openWifi success", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("PCConnectSwitchManager"), "openWifi success");
                    }
                    this.f4791b.h(null);
                    na.a.b(this.f4792c, Boolean.TRUE);
                }
                break;
        }
    }
}
