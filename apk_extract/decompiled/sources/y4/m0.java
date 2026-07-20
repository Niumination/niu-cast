package y4;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() != d5.c.NULL) {
            return Double.valueOf(bVar.nextDouble());
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
            dVar.value(number.doubleValue());
        }
    }
}
