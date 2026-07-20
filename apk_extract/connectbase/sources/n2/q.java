package n2;

import com.google.gson.annotations.SerializedName;
import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    @SerializedName("fileId")
    private String mFileId;

    @SerializedName("filePath")
    private String mFilePath;

    @SerializedName("fileSource")
    private int mFileSource;

    @SerializedName(HomeKeyReceiver.f2161e)
    private int mReason;

    public q() {
        this.mFilePath = "";
        this.mFileId = "";
    }

    public String a() {
        return this.mFileId;
    }

    public String b() {
        return this.mFilePath;
    }

    public int c() {
        return this.mFileSource;
    }

    public int d() {
        return this.mReason;
    }

    public void e(String str) {
        this.mFileId = str;
    }

    public void f(String str) {
        this.mFilePath = str;
    }

    public void g(int i10) {
        this.mFileSource = i10;
    }

    public void h(int i10) {
        this.mReason = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NotifyPeerFileTransferFailRequest{filePath='");
        sb2.append(this.mFilePath);
        sb2.append("', fileId='");
        sb2.append(this.mFileId);
        sb2.append("', fileSource=");
        sb2.append(this.mFileSource);
        sb2.append(", reason=");
        return u.a.a(sb2, this.mReason, rs.f.f14860b);
    }

    public q(String str, String str2, int i10, int i11) {
        this.mFilePath = str;
        this.mFileId = str2;
        this.mFileSource = i10;
        this.mReason = i11;
    }
}
