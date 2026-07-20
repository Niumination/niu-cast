package y4;

import java.io.IOException;
import java.util.Currency;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        String strNextString = bVar.nextString();
        try {
            return Currency.getInstance(strNextString);
        } catch (IllegalArgumentException e) {
            StringBuilder sbY = a1.a.y("Failed parsing '", strNextString, "' as Currency; at path ");
            sbY.append(bVar.getPreviousPath());
            throw new v4.a0(sbY.toString(), e);
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        dVar.value(((Currency) obj).getCurrencyCode());
    }
}
