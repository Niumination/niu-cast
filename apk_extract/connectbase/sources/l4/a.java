package l4;

import android.net.MacAddress;
import rs.f;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MacAddress f9687c;

    public a(String str, String str2, MacAddress macAddress) {
        this.f9685a = str;
        this.f9686b = str2;
        this.f9687c = macAddress;
    }

    public MacAddress a() {
        return this.f9687c;
    }

    public String b() {
        return this.f9686b;
    }

    public String c() {
        return this.f9685a;
    }

    public void d(MacAddress macAddress) {
        this.f9687c = macAddress;
    }

    public void e(String str) {
        this.f9686b = str;
    }

    public void f(String str) {
        this.f9685a = str;
    }

    public String toString() {
        return "SoftApConfigurationInfo{mSsid='" + this.f9685a + "', mPassphrase='" + this.f9686b + "', mBssid=" + this.f9687c + f.f14860b;
    }
}
