package cf;

import af.k6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p0 {
    static {
        Logger.getLogger(p0.class.getName());
    }

    public static byte[][] a(ArrayList arrayList) {
        int size = arrayList.size() * 2;
        byte[][] bArr = new byte[size][];
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            ef.d dVar = (ef.d) it.next();
            int i9 = i8 + 1;
            bArr[i8] = dVar.f4912a.toByteArray();
            i8 += 2;
            bArr[i9] = dVar.f4913b.toByteArray();
        }
        Logger logger = k6.f405a;
        int i10 = 0;
        while (i10 < size) {
            byte[] bArr2 = bArr[i10];
            int i11 = i10 + 1;
            byte[] bArr3 = bArr[i11];
            byte[] bArr4 = k6.f406b;
            if (k6.a(bArr2, bArr4)) {
                for (byte b9 : bArr3) {
                    if (b9 == 44) {
                        ArrayList arrayList2 = new ArrayList(size + 10);
                        for (int i12 = 0; i12 < i10; i12++) {
                            arrayList2.add(bArr[i12]);
                        }
                        while (i10 < size) {
                            byte[] bArr5 = bArr[i10];
                            byte[] bArr6 = bArr[i10 + 1];
                            if (k6.a(bArr5, bArr4)) {
                                int i13 = 0;
                                for (int i14 = 0; i14 <= bArr6.length; i14++) {
                                    if (i14 == bArr6.length || bArr6[i14] == 44) {
                                        byte[] bArrA = j4.e.f6102c.a(new String(bArr6, i13, i14 - i13, h4.f.f5247a));
                                        arrayList2.add(bArr5);
                                        arrayList2.add(bArrA);
                                        i13 = i14 + 1;
                                    }
                                }
                            } else {
                                arrayList2.add(bArr5);
                                arrayList2.add(bArr6);
                            }
                            i10 += 2;
                        }
                        return (byte[][]) arrayList2.toArray(new byte[0][]);
                    }
                }
                bArr[i11] = j4.e.f6102c.a(new String(bArr3, h4.f.f5247a));
            }
            i10 += 2;
        }
        return bArr;
    }
}
