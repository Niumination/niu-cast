package o2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12068a = 26000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12069b = 27000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12070c = 1000;

    @SerializedName(dc.d.f3692w)
    private int mId;

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    public d(int i10, int i11) {
        this.mId = i10;
        this.mPort = i11;
    }

    public int a() {
        return this.mId;
    }

    public int b() {
        return this.mPort;
    }

    public void c(int i10) {
        this.mId = i10;
    }

    public void d(int i10) {
        this.mPort = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ExtendScreenResponse{id=");
        sb2.append(this.mId);
        sb2.append(", port=");
        return u.a.a(sb2, this.mPort, rs.f.f14860b);
    }
}
