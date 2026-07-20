package p2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12763a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12764b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12765c = 1;

    @SerializedName(dc.d.f3692w)
    private String mId;

    @SerializedName("isReceive")
    private int mIsReceive;

    @SerializedName("packageName")
    private String mPackageName;

    @SerializedName("path")
    private String mPath;

    @SerializedName("savePath")
    private String mSavePath;

    @SerializedName("transportMode")
    private int mTransportMode;

    public o() {
        this.mPath = "";
        this.mSavePath = "";
        this.mPackageName = "";
        this.mId = "";
    }

    public String a() {
        return this.mId;
    }

    public int b() {
        return this.mIsReceive;
    }

    public String c() {
        return this.mPackageName;
    }

    public String d() {
        return this.mPath;
    }

    public String e() {
        return this.mSavePath;
    }

    public int f() {
        return this.mTransportMode;
    }

    public void g(String str) {
        this.mId = str;
    }

    public void h(int i10) {
        this.mIsReceive = i10;
    }

    public void i(String str) {
        this.mPackageName = str;
    }

    public void j(String str) {
        this.mPath = str;
    }

    public void k(String str) {
        this.mSavePath = str;
    }

    public void l(int i10) {
        this.mTransportMode = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("RequestSendFileResponse{isReceive=");
        sb2.append(this.mIsReceive);
        sb2.append(", path=");
        sb2.append(this.mPath);
        sb2.append(", transportMode=");
        sb2.append(this.mTransportMode);
        sb2.append(", savePath=");
        sb2.append(this.mSavePath);
        sb2.append(", packageName=");
        return l.a.a(sb2, this.mPackageName, rs.f.f14860b);
    }

    public o(int i10, String str, int i11, String str2, String str3) {
        this.mId = "";
        this.mIsReceive = i11;
        this.mPath = str;
        this.mTransportMode = i10;
        this.mSavePath = str2;
        this.mPackageName = str3;
    }
}
