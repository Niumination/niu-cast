package y4;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        try {
            String strNextString = bVar.nextString();
            if (strNextString.equals("null")) {
                return null;
            }
            return new URI(strNextString);
        } catch (URISyntaxException e) {
            throw new v4.v(e);
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        URI uri = (URI) obj;
        dVar.value(uri == null ? null : uri.toASCIIString());
    }
}
