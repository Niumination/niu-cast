package n2;

import com.google.gson.annotations.SerializedName;
import ik.y0;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11320a = -1;

    @SerializedName("filePath")
    private String mFilePath;

    @SerializedName("fileSize")
    private long mFileSize;

    @SerializedName(dc.d.f3692w)
    private String mId;

    @SerializedName("targetVideoPort")
    private int mTargetVideoPort;

    @SerializedName(y0.a.f8215h)
    private int mType;

    public v() {
        this.mFilePath = "";
        this.mType = 1;
        this.mId = "";
    }

    public String a() {
        return this.mFilePath;
    }

    public long b() {
        return this.mFileSize;
    }

    public String c() {
        return this.mId;
    }

    public int d() {
        return this.mTargetVideoPort;
    }

    public int e() {
        return this.mType;
    }

    public void f(String str) {
        this.mFilePath = str;
    }

    public void g(long j10) {
        this.mFileSize = j10;
    }

    public void h(String str) {
        this.mId = str;
    }

    public void i(int i10) {
        this.mTargetVideoPort = i10;
    }

    public void j(int i10) {
        this.mType = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PeerSendFileRequest{filePath='");
        sb2.append(this.mFilePath);
        sb2.append("', fileSize=");
        sb2.append(this.mFileSize);
        sb2.append(", targetVideoPort=");
        sb2.append(this.mTargetVideoPort);
        sb2.append(", type=");
        sb2.append(this.mType);
        sb2.append(", id=");
        return l.a.a(sb2, this.mId, rs.f.f14860b);
    }

    public v(String str, long j10, int i10) {
        this.mType = 1;
        this.mId = "";
        this.mFilePath = str;
        this.mFileSize = j10;
        this.mTargetVideoPort = i10;
    }
}
