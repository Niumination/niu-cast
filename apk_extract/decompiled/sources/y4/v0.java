package y4;

import java.io.IOException;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        String strNextString = bVar.nextString();
        if (strNextString.equals("null")) {
            return null;
        }
        return new URL(strNextString);
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        URL url = (URL) obj;
        dVar.value(url == null ? null : url.toExternalForm());
    }
}
