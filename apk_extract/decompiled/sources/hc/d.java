package hc;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5290g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5291h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5292i;

    @Override // hc.c
    public final String toString() {
        String str = this.f5287b;
        String str2 = this.f5288c;
        int i8 = this.f5289d;
        String str3 = this.f5290g;
        String str4 = this.f5291h;
        int i9 = this.f5292i;
        int i10 = this.e;
        String str5 = this.f5286a;
        int i11 = this.f;
        StringBuilder sbP = h0.a.p("P2PConnectDevice(deviceName='", str, "', deviceMac='", str2, "', deviceBrand=");
        sbP.append(i8);
        sbP.append(", ssid='");
        sbP.append(str3);
        sbP.append("', password='");
        sbP.append(str4);
        sbP.append("', channel=");
        sbP.append(i9);
        sbP.append(", serviceType=");
        sbP.append(i10);
        sbP.append(", devicePID='");
        sbP.append(str5);
        sbP.append("', deviceType='");
        return h0.a.m(sbP, "')", i11);
    }
}
