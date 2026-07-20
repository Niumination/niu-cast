package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11315a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11316b = 1;

    @SerializedName("mode")
    private int mMode;

    @SerializedName("notificationId")
    private String mNotificationId;

    public t() {
    }

    public int a() {
        return this.mMode;
    }

    public String b() {
        return this.mNotificationId;
    }

    public void c(int i10) {
        this.mMode = i10;
    }

    public void d(String str) {
        this.mNotificationId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("OpenNotificationRequest{notificationId='");
        sb2.append(this.mNotificationId);
        sb2.append("', mode=");
        return u.a.a(sb2, this.mMode, rs.f.f14860b);
    }

    public t(String str, int i10) {
        this.mNotificationId = str;
        this.mMode = i10;
    }
}
