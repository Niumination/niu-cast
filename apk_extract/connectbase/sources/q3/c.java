package q3;

import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import s3.g;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f13813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f13814b;

    public c(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f13813a = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(g.f14982o));
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f13814b = cipher2;
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(g.f14982o));
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public byte[] a(String str) {
        Cipher cipher = this.f13813a;
        if (cipher != null) {
            try {
                return cipher.doFinal(str.getBytes("UTF-8"));
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        }
        return null;
    }

    public byte[] b(byte[] bArr) {
        Cipher cipher = this.f13814b;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        }
        return null;
    }

    public byte[] c(byte[] bArr) {
        Cipher cipher = this.f13813a;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        }
        return null;
    }
}
