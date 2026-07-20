package v1;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    @Deprecated
    public p() {
    }

    public static k parseReader(Reader reader) throws u, l {
        try {
            d2.a aVar = new d2.a(reader);
            k reader2 = parseReader(aVar);
            if (!reader2.isJsonNull() && aVar.peek() != d2.c.END_DOCUMENT) {
                throw new u("Did not consume the entire document.");
            }
            return reader2;
        } catch (d2.e e10) {
            throw new u(e10);
        } catch (IOException e11) {
            throw new l(e11);
        } catch (NumberFormatException e12) {
            throw new u(e12);
        }
    }

    public static k parseString(String str) throws u {
        return parseReader(new StringReader(str));
    }

    @Deprecated
    public k parse(String str) throws u {
        return parseString(str);
    }

    @Deprecated
    public k parse(Reader reader) throws u, l {
        return parseReader(reader);
    }

    @Deprecated
    public k parse(d2.a aVar) throws u, l {
        return parseReader(aVar);
    }

    public static k parseReader(d2.a aVar) throws u, l {
        boolean zIsLenient = aVar.isLenient();
        aVar.setLenient(true);
        try {
            try {
                k kVar = x1.o.parse(aVar);
                aVar.setLenient(zIsLenient);
                return kVar;
            } catch (OutOfMemoryError e10) {
                throw new o("Failed parsing JSON source: " + aVar + " to Json", e10);
            } catch (StackOverflowError e11) {
                throw new o("Failed parsing JSON source: " + aVar + " to Json", e11);
            }
        } catch (Throwable th2) {
            aVar.setLenient(zIsLenient);
            throw th2;
        }
    }
}
