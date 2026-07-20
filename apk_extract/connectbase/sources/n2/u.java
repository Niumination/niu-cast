package n2;

import com.google.gson.annotations.SerializedName;
import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11317a = "SECURE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11318b = "LOCK";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11319c = -1;

    @SerializedName("isPause")
    private boolean mIsPause;

    @SerializedName("displayId")
    private int mPort;

    @SerializedName(HomeKeyReceiver.f2161e)
    private String mReason;

    public u() {
    }

    public String a() {
        return this.mReason;
    }

    public int b() {
        return this.mPort;
    }

    public boolean c() {
        return this.mIsPause;
    }

    public void d(String str) {
        this.mReason = str;
    }

    public void e(boolean z10) {
        this.mIsPause = z10;
    }

    public void f(int i10) {
        this.mPort = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PauseCastRequest{causeBy='");
        sb2.append(this.mReason);
        sb2.append("', isPause=");
        sb2.append(this.mIsPause);
        sb2.append(", port=");
        return u.a.a(sb2, this.mPort, rs.f.f14860b);
    }

    public u(String str, int i10, boolean z10) {
        this.mReason = str;
        this.mPort = i10;
        this.mIsPause = z10;
    }
}
