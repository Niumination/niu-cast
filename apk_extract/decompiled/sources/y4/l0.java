package y4;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() != d5.c.NULL) {
            return Float.valueOf((float) bVar.nextDouble());
        }
        bVar.nextNull();
        return null;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        Number numberValueOf = (Number) obj;
        if (numberValueOf == null) {
            dVar.nullValue();
            return;
        }
        if (!(numberValueOf instanceof Float)) {
            numberValueOf = Float.valueOf(numberValueOf.floatValue());
        }
        dVar.value(numberValueOf);
    }
}
