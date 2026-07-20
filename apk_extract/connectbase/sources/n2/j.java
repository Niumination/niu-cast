package n2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    @SerializedName("fps")
    private int mFps;

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    public j() {
    }

    public int a() {
        return this.mFps;
    }

    public int b() {
        return this.mPort;
    }

    public void c(int i10) {
        this.mFps = i10;
    }

    public void d(int i10) {
        this.mPort = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DisplayFpsControlDto{fps=");
        sb2.append(this.mFps);
        sb2.append(", port=");
        return u.a.a(sb2, this.mPort, rs.f.f14860b);
    }

    public j(int i10, int i11) {
        this.mFps = i10;
        this.mPort = i11;
    }
}
