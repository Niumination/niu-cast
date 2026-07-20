package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.content.pm.Signature;
import android.provider.Settings;
import com.transsion.core.utils.EncoderUtil;
import java.io.Serializable;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInfo extends OneBaseInfo implements Serializable {
    public String pkg;
    public String signatures;
    public String ssaid;

    public PackageInfo(Context context) {
        String lowerCase;
        this.pkg = "";
        this.signatures = "";
        this.ssaid = "";
        this.pkg = context.getPackageName();
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                lowerCase = "";
            } else {
                byte[] bArrDigest = messageDigest.digest(signatureArr[0].toByteArray());
                StringBuilder sb2 = new StringBuilder();
                for (byte b9 : bArrDigest) {
                    sb2.append(Integer.toHexString((b9 & UByte.MAX_VALUE) | 256).substring(1, 3));
                }
                lowerCase = sb2.toString().toLowerCase();
            }
        } catch (Exception unused) {
        }
        this.signatures = lowerCase;
        try {
            this.ssaid = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused2) {
        }
        if (this.ssaid == null) {
            this.ssaid = "";
        }
    }
}
