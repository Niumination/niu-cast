package se;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class a6 implements NsdManager.RegistrationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b6 f9649a;

    public a6(b6 b6Var) {
        this.f9649a = b6Var;
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onRegistrationFailed(NsdServiceInfo serviceInfo, int i8) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        we.h.b("TranLanController", "onRegistrationFailed");
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onServiceRegistered(NsdServiceInfo serviceInfo) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        we.h.b("TranLanController", "onServiceRegistered: " + serviceInfo + ", hashCode: " + serviceInfo.hashCode());
        b6 b6Var = this.f9649a;
        b6Var.f9669i.put(serviceInfo.getServiceName(), Boolean.TRUE);
        b6Var.f9672l = serviceInfo.getServiceName();
        String serviceName = serviceInfo.getServiceName();
        Intrinsics.checkNotNullExpressionValue(serviceName, "getServiceName(...)");
        if (!new Regex("^transConnectService[\\-_*][A-Za-z0-9]+[\\-_*]\\d+$").matches(serviceName)) {
            String serviceName2 = serviceInfo.getServiceName();
            Intrinsics.checkNotNullExpressionValue(serviceName2, "getServiceName(...)");
            if (!new Regex("^transConnectService[\\-_*][A-Za-z0-9]+$").matches(serviceName2)) {
                we.h.c("TranLanController", "Invalid service name: " + serviceInfo.getServiceName(), null);
                return;
            }
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 7938;
        messageObtain.obj = serviceInfo;
        Intrinsics.checkNotNull(messageObtain);
        b6Var.i(messageObtain);
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onServiceUnregistered(NsdServiceInfo serviceInfo) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        we.h.b("TranLanController", "onServiceUnregistered, " + serviceInfo + ", hashCode: " + serviceInfo.hashCode());
        b6 b6Var = this.f9649a;
        if (b6Var.f9669i.containsKey(serviceInfo.getServiceName())) {
            b6Var.f9669i.remove(serviceInfo.getServiceName());
            b6Var.f9672l = null;
        } else if (b6Var.f9669i.containsKey(b6Var.f9672l)) {
            TypeIntrinsics.asMutableMap(b6Var.f9669i).remove(b6Var.f9672l);
            b6Var.f9672l = null;
        } else {
            we.h.c("TranLanController", "Unknown service unregistered: " + serviceInfo.getServiceName(), null);
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 7939;
        Intrinsics.checkNotNull(messageObtain);
        b6Var.i(messageObtain);
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i8) {
        we.h.b("TranLanController", "onUnregistrationFailed");
    }
}
