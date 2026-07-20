package ks;

import java.io.UnsupportedEncodingException;
import org.fusesource.jansi.internal.Kernel32;

/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static String a(int i10) {
        byte[] bArr = new byte[160];
        Kernel32.FormatMessageW(Kernel32.f12471p, 0L, i10, 0, bArr, 160, null);
        try {
            return new String(bArr, "UTF-16LE").trim();
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static String b() {
        return a(Kernel32.GetLastError());
    }
}
