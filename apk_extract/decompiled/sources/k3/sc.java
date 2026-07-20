package k3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class sc {
    public static final qj.s a(qj.x xVar) {
        Intrinsics.checkNotNullParameter(xVar, "<this>");
        return new qj.s(xVar);
    }

    public static final qj.t b(qj.z zVar) {
        Intrinsics.checkNotNullParameter(zVar, "<this>");
        return new qj.t(zVar);
    }

    public static final boolean c(AssertionError assertionError) {
        Logger logger = qj.o.f9207a;
        Intrinsics.checkNotNullParameter(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt__StringsKt.contains$default(message, "getsockname failed", false, 2, (Object) null) : false;
    }

    public static final qj.c d(Socket socket) throws IOException {
        Logger logger = qj.o.f9207a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        qj.y yVar = new qj.y(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        qj.q sink = new qj.q(outputStream, yVar);
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new qj.c(yVar, sink);
    }

    public static final qj.d e(InputStream inputStream) {
        Logger logger = qj.o.f9207a;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return new qj.d(inputStream, new qj.b0());
    }

    public static final qj.d f(Socket socket) throws IOException {
        Logger logger = qj.o.f9207a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        qj.y yVar = new qj.y(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        qj.d source = new qj.d(inputStream, yVar);
        Intrinsics.checkNotNullParameter(source, "source");
        return new qj.d(yVar, source);
    }
}
