package p2;

import com.google.gson.annotations.SerializedName;
import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    @SerializedName("filePath")
    private String mFilePath;

    @SerializedName("fileSize")
    private long mFileSize;

    public k() {
    }

    public String a() {
        return this.mFilePath;
    }

    public long b() {
        return this.mFileSize;
    }

    public void c(String str) {
        this.mFilePath = str;
    }

    public void d(long j10) {
        this.mFileSize = j10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SendFileResponse{filePath=");
        sb2.append(this.mFilePath);
        sb2.append(", fileSize=");
        return k0.a(sb2, this.mFileSize, rs.f.f14860b);
    }

    public k(String str, long j10) {
        this.mFilePath = str;
        this.mFileSize = j10;
    }
}
