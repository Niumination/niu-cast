package se;

import android.net.nsd.NsdManager$ServiceInfoCallback;
import android.net.nsd.NsdServiceInfo;
import android.os.Message;
import android.util.Log;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class u5 implements NsdManager$ServiceInfoCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NsdServiceInfo f10017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b6 f10018b;

    public u5(b6 b6Var, NsdServiceInfo mRequestService) {
        Intrinsics.checkNotNullParameter(mRequestService, "mRequestService");
        this.f10018b = b6Var;
        this.f10017a = mRequestService;
    }

    public final void onServiceInfoCallbackRegistrationFailed(int i8) {
        Intrinsics.checkNotNullParameter("TranLanController", "tag");
        Intrinsics.checkNotNullParameter("onServiceInfoCallbackRegistrationFailed", "mes");
        if (lb.f6529c >= 1) {
            Log.e("TranLanController", "TransConnect:onServiceInfoCallbackRegistrationFailed", null);
        }
        b6 b6Var = this.f10018b;
        b6Var.f9674n = false;
        b6.k(b6Var);
    }

    public final void onServiceInfoCallbackUnregistered() {
        we.h.b("TranLanController", "onServiceInfoCallbackUnregistered");
        b6 b6Var = this.f10018b;
        b6Var.f9674n = false;
        b6.k(b6Var);
    }

    public final void onServiceLost() {
        we.h.b("TranLanController", "onServiceLost");
        b6.j(this.f10018b, this.f10017a);
        b6 b6Var = this.f10018b;
        b6Var.f9674n = false;
        b6.k(b6Var);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0064  */
    /* JADX WARN: Code duplicated, block: B:12:0x0074  */
    /* JADX WARN: Code duplicated, block: B:7:0x004c  */
    /* JADX WARN: Code duplicated, block: B:9:0x005a  */
    public final void onServiceUpdated(NsdServiceInfo service) {
        Intrinsics.checkNotNullParameter(service, "service");
        we.h.b("TranLanController", "onServiceUpdated, " + service);
        String serviceType = service.getServiceType();
        Intrinsics.checkNotNullExpressionValue(serviceType, "getServiceType(...)");
        if (!new Regex(".*_tran[^.]*\\._tcp.*").matches(serviceType)) {
            String serviceType2 = service.getServiceType();
            Intrinsics.checkNotNullExpressionValue(serviceType2, "getServiceType(...)");
            if (!new Regex(".*_tran[^.]*\\._udp.*").matches(serviceType2)) {
                o.d.z("Unknown Service Type: ", service.getServiceType(), "TranLanController");
            } else if (Intrinsics.areEqual(service.getServiceName(), this.f10018b.f9672l)) {
                o.d.z("Same machine: ", this.f10018b.f9672l, "TranLanController");
            } else if (Intrinsics.areEqual(service.getServiceName(), this.f10017a.getServiceName())) {
                b6 b6Var = this.f10018b;
                b6Var.getClass();
                Message messageObtain = Message.obtain();
                messageObtain.what = 7936;
                messageObtain.obj = service;
                Intrinsics.checkNotNull(messageObtain);
                b6Var.i(messageObtain);
            }
        } else if (Intrinsics.areEqual(service.getServiceName(), this.f10018b.f9672l)) {
            o.d.z("Same machine: ", this.f10018b.f9672l, "TranLanController");
        } else if (Intrinsics.areEqual(service.getServiceName(), this.f10017a.getServiceName())) {
            b6 b6Var2 = this.f10018b;
            b6Var2.getClass();
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 7936;
            messageObtain2.obj = service;
            Intrinsics.checkNotNull(messageObtain2);
            b6Var2.i(messageObtain2);
        }
        b6 b6Var3 = this.f10018b;
        b6Var3.f9674n = false;
        b6.k(b6Var3);
    }
}
