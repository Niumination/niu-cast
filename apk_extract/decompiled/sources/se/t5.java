package se;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Message;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t5 implements NsdManager.ResolveListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b6 f10005a;

    public t5(b6 b6Var) {
        this.f10005a = b6Var;
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onResolveFailed(NsdServiceInfo serviceInfo, int i8) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        we.h.b("TranLanController", "onResolveFailed, " + serviceInfo + ", " + i8);
        b6 b6Var = this.f10005a;
        synchronized (b6Var.p) {
            try {
                for (v5 v5Var : b6Var.p.values()) {
                    if (Intrinsics.areEqual(v5Var.f10034a.getServiceName(), serviceInfo.getServiceName())) {
                        v5Var.f10037d = false;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        b6 b6Var2 = this.f10005a;
        b6Var2.f9674n = false;
        b6.k(b6Var2);
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
        we.h.b("TranLanController", "onServiceResolved, " + nsdServiceInfo);
        if (nsdServiceInfo != null) {
            b6 b6Var = this.f10005a;
            k kVar = b6.u;
            b6Var.getClass();
            Message messageObtain = Message.obtain();
            messageObtain.what = 7936;
            messageObtain.obj = nsdServiceInfo;
            Intrinsics.checkNotNull(messageObtain);
            b6Var.i(messageObtain);
        }
        b6 b6Var2 = this.f10005a;
        synchronized (b6Var2.p) {
            try {
                for (v5 v5Var : b6Var2.p.values()) {
                    if (Intrinsics.areEqual(v5Var.f10034a.getServiceName(), nsdServiceInfo != null ? nsdServiceInfo.getServiceName() : null)) {
                        v5Var.f10037d = false;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        b6 b6Var3 = this.f10005a;
        b6Var3.f9674n = false;
        b6.k(b6Var3);
    }
}
