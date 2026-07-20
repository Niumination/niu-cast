package com.transsion.core.utils;

import android.text.TextUtils;
import com.transsion.core.log.LogUtils;
import java.net.NetworkInterface;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class MacUtil {
    private static final String TAG = "MacUtil";

    public static String getLocalMacAddress() {
        String macAddr = getMacAddr();
        LogUtils.i("get mac from M+");
        return TextUtils.isEmpty(macAddr) ? "" : EncoderUtil.EncoderByAlgorithm(macAddr);
    }

    private static String getMacAddr() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b9 : hardwareAddress) {
                            sb2.append(String.format("%02X:", Byte.valueOf(b9)));
                        }
                        if (sb2.length() > 0) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                        return sb2.toString();
                    }
                    return "";
                }
            }
        } catch (Exception e) {
            LogUtils.i("get mac is error: " + e.getMessage());
        }
        return "";
    }
}
