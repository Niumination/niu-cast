package y4;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        String strNextString = bVar.nextString();
        try {
            return x4.s.parseBigDecimal(strNextString);
        } catch (NumberFormatException e) {
            StringBuilder sbY = a1.a.y("Failed parsing '", strNextString, "' as BigDecimal; at path ");
            sbY.append(bVar.getPreviousPath());
            throw new v4.a0(sbY.toString(), e);
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        dVar.value((BigDecimal) obj);
    }
}
