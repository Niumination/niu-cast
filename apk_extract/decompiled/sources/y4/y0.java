package y4;

import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        String strNextString = bVar.nextString();
        try {
            return UUID.fromString(strNextString);
        } catch (IllegalArgumentException e) {
            StringBuilder sbY = a1.a.y("Failed parsing '", strNextString, "' as UUID; at path ");
            sbY.append(bVar.getPreviousPath());
            throw new v4.a0(sbY.toString(), e);
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        UUID uuid = (UUID) obj;
        dVar.value(uuid == null ? null : uuid.toString());
    }
}
