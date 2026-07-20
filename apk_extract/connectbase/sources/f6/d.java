package f6;

import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5852a = "MacUtil";

    public static String a() {
        String strB = b();
        d6.a.P("get mac from M+");
        return TextUtils.isEmpty(strB) ? "" : c.b(strB, "SHA-256");
    }

    public static String b() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b10 : hardwareAddress) {
                            sb2.append(String.format("%02X:", Byte.valueOf(b10)));
                        }
                        if (sb2.length() > 0) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                        return sb2.toString();
                    }
                    return "";
                }
            }
        } catch (Exception e10) {
            d6.a.P("get mac is error: " + e10.getMessage());
        }
        return "";
    }
}
