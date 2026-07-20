package af;

import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f405a = Logger.getLogger(k6.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f406b = "-bin".getBytes(h4.f.f5247a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i8 = length; i8 < bArr.length; i8++) {
            if (bArr[i8] != bArr2[i8 - length]) {
                return false;
            }
        }
        return true;
    }
}
