package ef;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Logger;
import kotlin.UByte;
import qj.t;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f4945a = Logger.getLogger(j.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final qj.j f4946b = qj.j.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public static int a(t tVar) {
        return (tVar.readByte() & UByte.MAX_VALUE) | ((tVar.readByte() & UByte.MAX_VALUE) << 16) | ((tVar.readByte() & UByte.MAX_VALUE) << 8);
    }

    public static int b(int i8, byte b9, short s2) throws IOException {
        if ((b9 & 8) != 0) {
            i8--;
        }
        if (s2 <= i8) {
            return (short) (i8 - s2);
        }
        c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Integer.valueOf(i8));
        throw null;
    }

    public static void c(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }
}
