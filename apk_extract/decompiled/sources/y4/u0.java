package y4;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() != d5.c.NULL) {
            return new StringBuffer(bVar.nextString());
        }
        bVar.nextNull();
        return null;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        StringBuffer stringBuffer = (StringBuffer) obj;
        dVar.value(stringBuffer == null ? null : stringBuffer.toString());
    }
}
