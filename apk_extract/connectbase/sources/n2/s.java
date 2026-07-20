package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11313a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11314b = 0;

    @SerializedName("orientation")
    private int mOrientation;

    @SerializedName("qualityMode")
    private int mQualityMode;

    @SerializedName("resolutionFps")
    private int mResolutionFps;

    @SerializedName("resolutionHeight")
    private int mResolutionHeight;

    @SerializedName("resolutionWidth")
    private int mResolutionWidth;

    public s() {
    }

    public int a() {
        return this.mOrientation;
    }

    public int b() {
        return this.mQualityMode;
    }

    public int c() {
        return this.mResolutionFps;
    }

    public int d() {
        return this.mResolutionHeight;
    }

    public int e() {
        return this.mResolutionWidth;
    }

    public void f(int i10) {
        this.mOrientation = i10;
    }

    public void g(int i10) {
        this.mQualityMode = i10;
    }

    public void h(int i10) {
        this.mResolutionFps = i10;
    }

    public void i(int i10) {
        this.mResolutionHeight = i10;
    }

    public void j(int i10) {
        this.mResolutionWidth = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("OpenExtendScreenRequest{resolutionWidth=");
        sb2.append(this.mResolutionWidth);
        sb2.append(", resolutionHeight=");
        sb2.append(this.mResolutionHeight);
        sb2.append(", orientation=");
        sb2.append(this.mOrientation);
        sb2.append(", qualityMode=");
        sb2.append(this.mQualityMode);
        sb2.append(", resolutionFps=");
        return u.a.a(sb2, this.mResolutionFps, rs.f.f14860b);
    }

    public s(int i10, int i11, int i12, int i13, int i14) {
        this.mResolutionWidth = i10;
        this.mResolutionHeight = i11;
        this.mOrientation = i12;
        this.mQualityMode = i13;
        this.mResolutionFps = i14;
    }
}
