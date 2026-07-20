package n2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    public b0(int i10) {
        this.mPort = i10;
    }

    public int a() {
        return this.mPort;
    }

    public void b(int i10) {
        this.mPort = i10;
    }

    public String toString() {
        return u.a.a(new StringBuilder("RetryEncoderRequest{port="), this.mPort, rs.f.f14860b);
    }
}
