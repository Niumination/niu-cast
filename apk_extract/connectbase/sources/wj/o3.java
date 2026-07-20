package wj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f19142a = Logger.getLogger(o3.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f19143b = vj.v1.f17425d.getBytes(c1.f.f1177a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i10 = length; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10 - length]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr) {
        for (byte b10 : bArr) {
            if (b10 < 32 || b10 > 126) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] c(byte[][] bArr, int i10) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(bArr[i11]);
        }
        while (i10 < bArr.length) {
            byte[] bArr2 = bArr[i10];
            byte[] bArr3 = bArr[i10 + 1];
            if (a(bArr2, f19143b)) {
                int i12 = 0;
                for (int i13 = 0; i13 <= bArr3.length; i13++) {
                    if (i13 == bArr3.length || bArr3[i13] == 44) {
                        byte[] bArrG = l1.b.d().g(new String(bArr3, i12, i13 - i12, c1.f.f1177a));
                        arrayList.add(bArr2);
                        arrayList.add(bArrG);
                        i12 = i13 + 1;
                    }
                }
            } else {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            }
            i10 += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public static byte[][] d(vj.v1 v1Var) {
        byte[][] bArrH = vj.f1.h(v1Var);
        if (bArrH == null) {
            return new byte[0][];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < bArrH.length; i11 += 2) {
            byte[] bArr = bArrH[i11];
            byte[] bArr2 = bArrH[i11 + 1];
            if (a(bArr, f19143b)) {
                bArrH[i10] = bArr;
                bArrH[i10 + 1] = vj.f1.f17137b.l(bArr2).getBytes(c1.f.f1177a);
            } else {
                if (b(bArr2)) {
                    bArrH[i10] = bArr;
                    bArrH[i10 + 1] = bArr2;
                } else {
                    String str = new String(bArr, c1.f.f1177a);
                    Logger logger = f19142a;
                    StringBuilder sbA = e.a.a("Metadata key=", str, ", value=");
                    sbA.append(Arrays.toString(bArr2));
                    sbA.append(" contains invalid ASCII characters");
                    logger.warning(sbA.toString());
                }
            }
            i10 += 2;
        }
        return i10 == bArrH.length ? bArrH : (byte[][]) Arrays.copyOfRange(bArrH, 0, i10);
    }

    @gm.c
    public static byte[][] e(byte[][] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10 += 2) {
            byte[] bArr2 = bArr[i10];
            int i11 = i10 + 1;
            byte[] bArr3 = bArr[i11];
            if (a(bArr2, f19143b)) {
                for (byte b10 : bArr3) {
                    if (b10 == 44) {
                        return c(bArr, i10);
                    }
                }
                bArr[i11] = l1.b.d().g(new String(bArr3, c1.f.f1177a));
            }
        }
        return bArr;
    }
}
