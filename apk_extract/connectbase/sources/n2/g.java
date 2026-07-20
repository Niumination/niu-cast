package n2;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private int mStatus;

    public g(int i10, int i11) {
        this.mPort = i10;
        this.mStatus = i11;
    }

    public int a() {
        return this.mPort;
    }

    public int b() {
        return this.mStatus;
    }

    public void c(int i10) {
        this.mPort = i10;
    }

    public void d(int i10) {
        this.mStatus = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DecoderStatusRequest{port=");
        sb2.append(this.mPort);
        sb2.append(", status=");
        return u.a.a(sb2, this.mStatus, rs.f.f14860b);
    }
}
