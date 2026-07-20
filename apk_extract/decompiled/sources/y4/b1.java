package y4;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(bVar.nextString(), "_");
        String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        if (strNextToken2 == null && strNextToken3 == null) {
            return new Locale(strNextToken);
        }
        return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        Locale locale = (Locale) obj;
        dVar.value(locale == null ? null : locale.toString());
    }
}
