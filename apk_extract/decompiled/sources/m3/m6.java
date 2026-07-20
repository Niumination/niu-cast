package m3;

import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class m6 {
    public static final byte[] a(int i8) {
        char[] cArr = zg.k.f11590a;
        wi.a aVar = new wi.a();
        while (lh.a.f(aVar) < i8) {
            String str = (String) ni.u.b(zg.p.f11600b.F());
            if (str == null) {
                zg.p.f11601c.start();
                str = (String) li.l0.q(new zg.j(null));
            }
            lh.a.n(aVar, str, 0, 0, 14);
        }
        return wi.o.c(aVar, i8);
    }

    public static final String b(byte[] bytes) {
        char[] cArr = zg.k.f11590a;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char[] cArr2 = new char[bytes.length * 2];
        int i8 = 0;
        for (byte b9 : bytes) {
            int i9 = i8 + 1;
            int i10 = (b9 & UByte.MAX_VALUE) >> 4;
            char[] cArr3 = zg.k.f11590a;
            cArr2[i8] = cArr3[i10];
            i8 += 2;
            cArr2[i9] = cArr3[b9 & 15];
        }
        return StringsKt.concatToString(cArr2);
    }
}
