package p2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    @SerializedName("height")
    private int mHeight;

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    @SerializedName("width")
    private int mWidth;

    public i(int i10, int i11, int i12) {
        this.mWidth = i10;
        this.mHeight = i11;
        this.mPort = i12;
    }

    public int a() {
        return this.mHeight;
    }

    public int b() {
        return this.mWidth;
    }

    public void c(int i10) {
        this.mHeight = i10;
    }

    public void d(int i10) {
        this.mPort = i10;
    }

    public void e(int i10) {
        this.mWidth = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FoldFeatureSyncRequest{foldWidth=");
        sb2.append(this.mWidth);
        sb2.append(", foldHeight=");
        return u.a.a(sb2, this.mHeight, rs.f.f14860b);
    }
}
