package n2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11299a = 1;

    @SerializedName("contents")
    private List<String> mContents;

    @SerializedName("fileSizes")
    private List<Long> mFileSizes;

    @SerializedName(dc.d.f3692w)
    private String mId;

    @SerializedName("packageName")
    private String mPackageName;

    @SerializedName("savePath")
    private String mSavePath;

    @SerializedName("transportMode")
    private int mTransportMode;

    public g0() {
    }

    public List<String> a() {
        return this.mContents;
    }

    public List<Long> b() {
        return this.mFileSizes;
    }

    public String c() {
        return this.mPackageName;
    }

    public String d() {
        return this.mSavePath;
    }

    public int e() {
        return this.mTransportMode;
    }

    public void f(List<String> list) {
        this.mContents = list;
    }

    public void g(List<Long> list) {
        this.mFileSizes = list;
    }

    public void h(String str) {
        this.mPackageName = str;
    }

    public void i(String str) {
        this.mSavePath = str;
    }

    public void j(int i10) {
        this.mTransportMode = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("RequestFileSyncRequest{transportMode=");
        sb2.append(this.mTransportMode);
        sb2.append(", contents=");
        sb2.append(this.mContents);
        sb2.append(", fileSize=");
        sb2.append(this.mFileSizes);
        sb2.append(", savePath=");
        sb2.append(this.mSavePath);
        sb2.append(", packageName=");
        return l.a.a(sb2, this.mPackageName, rs.f.f14860b);
    }

    public g0(int i10, List<String> list, List<Long> list2, String str, String str2, String str3) {
        this.mTransportMode = i10;
        this.mContents = list;
        this.mFileSizes = list2;
        this.mPackageName = str;
        this.mSavePath = str2;
        this.mId = str3;
    }
}
