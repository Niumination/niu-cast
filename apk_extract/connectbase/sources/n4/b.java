package n4;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    @SerializedName("Password")
    private String mPassword;

    @SerializedName("Port")
    private int mPort;

    @SerializedName("Ssid")
    private String mSsid;

    public b() {
    }

    public String a() {
        return this.mPassword;
    }

    public int b() {
        return this.mPort;
    }

    public String c() {
        return this.mSsid;
    }

    public void d(String str) {
        this.mPassword = str;
    }

    public void e(int i10) {
        this.mPort = i10;
    }

    public void f(String str) {
        this.mSsid = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("WifiP2PInfo{ssid='");
        sb2.append(this.mSsid);
        sb2.append("', password='");
        sb2.append(this.mPassword);
        sb2.append("', port=");
        return u.a.a(sb2, this.mPort, rs.f.f14860b);
    }

    public b(String str, String str2, int i10) {
        this.mSsid = str;
        this.mPassword = str2;
        this.mPort = i10;
    }
}
