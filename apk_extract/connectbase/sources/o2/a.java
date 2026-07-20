package o2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12066a = 25000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12067b = 1000;

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    public a(int i10) {
        this.mPort = i10;
    }

    public int a() {
        return this.mPort;
    }

    public void b(int i10) {
        this.mPort = i10;
    }

    public String toString() {
        return u.a.a(new StringBuilder("ExtendScreenControlPort{port="), this.mPort, rs.f.f14860b);
    }
}
