package hc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5289d;
    public int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5286a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5287b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5288c = "";
    public int f = 3;

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f5288c = str;
    }

    public String toString() {
        String str = this.f5287b;
        String str2 = this.f5288c;
        int i8 = this.f5289d;
        int i9 = this.e;
        String str3 = this.f5286a;
        int i10 = this.f;
        StringBuilder sbP = h0.a.p("ConnectableDevice(deviceName='", str, "', deviceMac='", str2, "', deviceBrand=");
        sbP.append(i8);
        sbP.append(", serviceType=");
        sbP.append(i9);
        sbP.append(", devicePID='");
        sbP.append(str3);
        sbP.append("', deviceType=");
        sbP.append(i10);
        sbP.append(")");
        return sbP.toString();
    }
}
