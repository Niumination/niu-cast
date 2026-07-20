package v4;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class n extends p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() != d5.c.NULL) {
            return Long.valueOf(bVar.nextLong());
        }
        bVar.nextNull();
        return null;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            dVar.nullValue();
        } else {
            dVar.value(number.toString());
        }
    }
}
