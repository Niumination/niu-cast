package y4;

import java.io.IOException;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        BitSet bitSet = new BitSet();
        bVar.beginArray();
        d5.c cVarPeek = bVar.peek();
        int i8 = 0;
        while (cVarPeek != d5.c.END_ARRAY) {
            int i9 = f1.f11055a[cVarPeek.ordinal()];
            boolean zNextBoolean = true;
            if (i9 == 1 || i9 == 2) {
                int iNextInt = bVar.nextInt();
                if (iNextInt == 0) {
                    zNextBoolean = false;
                } else if (iNextInt != 1) {
                    StringBuilder sbU = a1.a.u(iNextInt, "Invalid bitset value ", ", expected 0 or 1; at path ");
                    sbU.append(bVar.getPreviousPath());
                    throw new v4.a0(sbU.toString());
                }
            } else {
                if (i9 != 3) {
                    throw new v4.a0("Invalid bitset value type: " + cVarPeek + "; at path " + bVar.getPath());
                }
                zNextBoolean = bVar.nextBoolean();
            }
            if (zNextBoolean) {
                bitSet.set(i8);
            }
            i8++;
            cVarPeek = bVar.peek();
        }
        bVar.endArray();
        return bitSet;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        dVar.beginArray();
        int length = bitSet.length();
        for (int i8 = 0; i8 < length; i8++) {
            dVar.value(bitSet.get(i8) ? 1L : 0L);
        }
        dVar.endArray();
    }
}
