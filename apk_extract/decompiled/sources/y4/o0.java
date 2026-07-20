package y4;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        d5.c cVarPeek = bVar.peek();
        if (cVarPeek != d5.c.NULL) {
            return cVarPeek == d5.c.BOOLEAN ? Boolean.toString(bVar.nextBoolean()) : bVar.nextString();
        }
        bVar.nextNull();
        return null;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        dVar.value((String) obj);
    }
}
