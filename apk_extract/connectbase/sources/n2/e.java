package n2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11298a = 1;

    @SerializedName("files")
    private List<String> mFiles;

    @SerializedName(dc.d.f3692w)
    private String mId;

    @SerializedName("isAgreeReceiveFile")
    private int mIsAgreeReceiveFile;

    @SerializedName("packageName")
    private String mPackageName;

    @SerializedName("savePath")
    private String mSavePath;

    public e() {
    }

    public List<String> a() {
        return this.mFiles;
    }

    public String b() {
        return this.mId;
    }

    public int c() {
        return this.mIsAgreeReceiveFile;
    }

    public String d() {
        return this.mPackageName;
    }

    public String e() {
        return this.mSavePath;
    }

    public void f(List<String> list) {
        this.mFiles = list;
    }

    public void g(String str) {
        this.mId = str;
    }

    public void h(int i10) {
        this.mIsAgreeReceiveFile = i10;
    }

    public void i(String str) {
        this.mPackageName = str;
    }

    public void j(String str) {
        this.mSavePath = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ConfirmReceiveRequest{isAgreeReceiveFile=");
        sb2.append(this.mIsAgreeReceiveFile);
        sb2.append(", files=");
        sb2.append(this.mFiles);
        sb2.append(", savePath=");
        sb2.append(this.mSavePath);
        sb2.append(", packageName=");
        return l.a.a(sb2, this.mPackageName, rs.f.f14860b);
    }

    public e(int i10, List<String> list, String str) {
        this.mIsAgreeReceiveFile = i10;
        this.mFiles = list;
        this.mSavePath = str;
    }

    public e(int i10, List<String> list, String str, String str2, String str3) {
        this.mIsAgreeReceiveFile = i10;
        this.mFiles = list;
        this.mSavePath = str;
        this.mPackageName = str2;
        this.mId = str3;
    }
}
