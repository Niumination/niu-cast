package y4;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        try {
            int iNextInt = bVar.nextInt();
            if (iNextInt <= 65535 && iNextInt >= -32768) {
                return Short.valueOf((short) iNextInt);
            }
            StringBuilder sbU = a1.a.u(iNextInt, "Lossy conversion from ", " to short; at path ");
            sbU.append(bVar.getPreviousPath());
            throw new v4.a0(sbU.toString());
        } catch (NumberFormatException e) {
            throw new v4.a0(e);
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            dVar.nullValue();
        } else {
            dVar.value(number.shortValue());
        }
    }
}
