package n2;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11300a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11301b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11302c = 0;

    @SerializedName(dc.d.f3692w)
    private int mId;

    @SerializedName(HomeKeyReceiver.f2161e)
    private int mReason;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private int mStatus;

    public j0(int i10, int i11, int i12) {
        this.mId = i10;
        this.mStatus = i11;
        this.mReason = i12;
    }

    public int a() {
        return this.mId;
    }

    public int b() {
        return this.mReason;
    }

    public int c() {
        return this.mStatus;
    }

    public void d(int i10) {
        this.mId = i10;
    }

    public void e(int i10) {
        this.mReason = i10;
    }

    public void f(int i10) {
        this.mStatus = i10;
    }
}
