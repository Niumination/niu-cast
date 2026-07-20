package n2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    @SerializedName("appName")
    private String mAppName;

    @SerializedName("appType")
    private int mAppType;

    @SerializedName("canReparent")
    private boolean mCanReparent;

    @SerializedName("iconBase64")
    private String mIconBase64;

    @SerializedName("packageName")
    private String mPackageName;

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    public i() {
    }

    public String a() {
        return this.mAppName;
    }

    public int b() {
        return this.mAppType;
    }

    public String c() {
        return this.mIconBase64;
    }

    public String d() {
        return this.mPackageName;
    }

    public int e() {
        return this.mPort;
    }

    public boolean f() {
        return this.mCanReparent;
    }

    public void g(String str) {
        this.mAppName = str;
    }

    public void h(int i10) {
        this.mAppType = i10;
    }

    public void i(boolean z10) {
        this.mCanReparent = z10;
    }

    public void j(String str) {
        this.mIconBase64 = str;
    }

    public void k(String str) {
        this.mPackageName = str;
    }

    public void l(int i10) {
        this.mPort = i10;
    }

    public String toString() {
        return "DisplayActivityChangedRequest{port=" + this.mPort + ", appName='" + this.mAppName + "', iconBase64='" + this.mIconBase64 + "', packageName='" + this.mPackageName + "', canReparent=" + this.mCanReparent + rs.f.f14860b;
    }

    public i(int i10, String str, String str2, String str3, boolean z10, int i11) {
        this.mPort = i10;
        this.mAppName = str;
        this.mIconBase64 = str2;
        this.mPackageName = str3;
        this.mCanReparent = z10;
        this.mAppType = i11;
    }
}
