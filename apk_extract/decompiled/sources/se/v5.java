package se;

import android.net.nsd.NsdServiceInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NsdServiceInfo f10034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t5 f10035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u5 f10036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10037d;

    public v5(NsdServiceInfo service, t5 t5Var, u5 u5Var) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.f10034a = service;
        this.f10035b = t5Var;
        this.f10036c = u5Var;
        this.f10037d = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(v5.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranLanController.ServiceRequest");
        v5 v5Var = (v5) obj;
        return this.f10034a == v5Var.f10034a && this.f10035b == v5Var.f10035b && this.f10036c == v5Var.f10036c;
    }

    public final int hashCode() {
        NsdServiceInfo nsdServiceInfo = this.f10034a;
        return nsdServiceInfo.getServiceType().hashCode() + nsdServiceInfo.getServiceName().hashCode();
    }

    public final String toString() {
        return "ServiceRequest(service=" + this.f10034a + ", listener=" + this.f10035b + ", callback=" + this.f10036c + ", isRegistered=" + this.f10037d + ")";
    }
}
