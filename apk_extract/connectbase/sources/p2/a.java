package p2;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    @SerializedName("bSsid")
    private String mBSsid;

    @SerializedName("password")
    private String mPassword;

    @SerializedName("ssid")
    private String mSsid;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private int mStatus;

    public a() {
    }

    public String a() {
        return this.mBSsid;
    }

    public String b() {
        return this.mPassword;
    }

    public String c() {
        return this.mSsid;
    }

    public int d() {
        return this.mStatus;
    }

    public void e(String str) {
        this.mBSsid = str;
    }

    public void f(String str) {
        this.mPassword = str;
    }

    public void g(String str) {
        this.mSsid = str;
    }

    public void h(int i10) {
        this.mStatus = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ApInfoResponse{status=");
        sb2.append(this.mStatus);
        sb2.append(", ssid='");
        sb2.append(this.mSsid);
        sb2.append("', password='");
        sb2.append(this.mPassword);
        sb2.append("', bSsid='");
        return j.c.a(sb2, this.mBSsid, "'}");
    }

    public a(int i10, String str, String str2, String str3) {
        this.mStatus = i10;
        this.mSsid = str;
        this.mPassword = str2;
        this.mBSsid = str3;
    }
}
