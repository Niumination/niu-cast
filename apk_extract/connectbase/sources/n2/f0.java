package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    @SerializedName("fileName")
    private String mFileName;

    @SerializedName("packageName")
    private String mPackageName;

    @SerializedName("savePath")
    private String mSavePath;

    @SerializedName("sendPath")
    private String mSendPath;

    @SerializedName("sessionId")
    private String mSessionId;

    @SerializedName("source")
    private int mSource;

    public f0() {
    }

    public String a() {
        return this.mFileName;
    }

    public String b() {
        return this.mPackageName;
    }

    public String c() {
        return this.mSavePath;
    }

    public String d() {
        return this.mSendPath;
    }

    public String e() {
        return this.mSessionId;
    }

    public int f() {
        return this.mSource;
    }

    public void g(String str) {
        this.mFileName = str;
    }

    public void h(String str) {
        this.mPackageName = str;
    }

    public void i(String str) {
        this.mSavePath = str;
    }

    public void j(String str) {
        this.mSendPath = str;
    }

    public void k(String str) {
        this.mSessionId = str;
    }

    public void l(int i10) {
        this.mSource = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("EnterFileIdInfoRequest{sessionId='");
        sb2.append(this.mSessionId);
        sb2.append("', packageName='");
        sb2.append(this.mPackageName);
        sb2.append("', fileName='");
        sb2.append(this.mFileName);
        sb2.append("', source=");
        return u.a.a(sb2, this.mSource, rs.f.f14860b);
    }

    public f0(String str, String str2, String str3, int i10, String str4, String str5) {
        this.mSessionId = str;
        this.mPackageName = str2;
        this.mFileName = str3;
        this.mSource = i10;
        this.mSendPath = str4;
        this.mSavePath = str5;
    }
}
