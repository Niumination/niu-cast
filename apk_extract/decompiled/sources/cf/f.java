package cf;

import af.k6;
import af.l1;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import ze.p1;
import ze.t0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef.d f1525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.d f1526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ef.d f1527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ef.d f1528d;
    public static final ef.d e;
    public static final ef.d f;

    static {
        qj.j jVar = ef.d.f4910g;
        f1525a = new ef.d("https", jVar);
        f1526b = new ef.d("http", jVar);
        qj.j jVar2 = ef.d.e;
        f1527c = new ef.d("POST", jVar2);
        f1528d = new ef.d("GET", jVar2);
        e = new ef.d(l1.f417j.f11380a, "application/grpc");
        f = new ef.d("te", "trailers");
    }

    public static void a(ArrayList arrayList, p1 p1Var) {
        Logger logger = k6.f405a;
        Charset charset = t0.f11435a;
        int i8 = p1Var.f11400b * 2;
        byte[][] bArr = new byte[i8][];
        Object[] objArr = p1Var.f11399a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, i8);
        } else {
            for (int i9 = 0; i9 < p1Var.f11400b; i9++) {
                int i10 = i9 * 2;
                bArr[i10] = p1Var.e(i9);
                int i11 = i10 + 1;
                Object obj = p1Var.f11399a[i11];
                if (!(obj instanceof byte[])) {
                    o.d.y(obj);
                    throw null;
                }
                bArr[i11] = (byte[]) obj;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < i8; i13 += 2) {
            byte[] bArr2 = bArr[i13];
            byte[] bArr3 = bArr[i13 + 1];
            if (k6.a(bArr2, k6.f406b)) {
                bArr[i12] = bArr2;
                bArr[i12 + 1] = t0.f11436b.c(bArr3).getBytes(h4.f.f5247a);
            } else {
                int length = bArr3.length;
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        bArr[i12] = bArr2;
                        bArr[i12 + 1] = bArr3;
                    } else {
                        byte b9 = bArr3[i14];
                        if (b9 < 32 || b9 > 126) {
                            StringBuilder sbY = a1.a.y("Metadata key=", new String(bArr2, h4.f.f5247a), ", value=");
                            sbY.append(Arrays.toString(bArr3));
                            sbY.append(" contains invalid ASCII characters");
                            k6.f405a.warning(sbY.toString());
                        } else {
                            i14++;
                        }
                    }
                }
            }
            i12 += 2;
        }
        if (i12 != i8) {
            bArr = (byte[][]) Arrays.copyOfRange(bArr, 0, i12);
        }
        for (int i15 = 0; i15 < bArr.length; i15 += 2) {
            qj.j jVarOf = qj.j.of(bArr[i15]);
            if (jVarOf.size() != 0 && jVarOf.getByte(0) != 58) {
                arrayList.add(new ef.d(jVarOf, qj.j.of(bArr[i15 + 1])));
            }
        }
    }

    public static ArrayList b(p1 p1Var) {
        p1Var.a(l1.f417j);
        p1Var.a(l1.f418k);
        p1Var.a(l1.f419l);
        ArrayList arrayList = new ArrayList(p1Var.f11400b + 2);
        arrayList.add(new ef.d("200", ef.d.f4909d));
        arrayList.add(e);
        a(arrayList, p1Var);
        return arrayList;
    }
}
