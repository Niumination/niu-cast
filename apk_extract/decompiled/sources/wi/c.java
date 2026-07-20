package wi;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f10765a;

    public c(InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.f10765a = input;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f10765a.close();
    }

    @Override // wi.e
    public final long d0(a sink, long j8) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 == 0) {
            return 0L;
        }
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount (" + j8 + ") < 0").toString());
        }
        boolean z2 = false;
        try {
            h hVarL = sink.l(1);
            byte[] data = hVarL.f10776a;
            int i8 = hVarL.f10778c;
            long j10 = this.f10765a.read(data, i8, (int) Math.min(j8, data.length - i8));
            int i9 = j10 == -1 ? 0 : (int) j10;
            if (i9 == 1) {
                Intrinsics.checkNotNullParameter(data, "data");
                hVarL.f10778c += i9;
                sink.f10764c += (long) i9;
            } else {
                if (i9 < 0 || i9 > hVarL.a()) {
                    throw new IllegalStateException(("Invalid number of bytes written: " + i9 + ". Should be in 0.." + hVarL.a()).toString());
                }
                if (i9 != 0) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    hVarL.f10778c += i9;
                    sink.f10764c += (long) i9;
                } else if (q.d(hVarL)) {
                    sink.g();
                }
            }
            return j10;
        } catch (AssertionError e) {
            Intrinsics.checkNotNullParameter(e, "<this>");
            if (e.getCause() != null) {
                String message = e.getMessage();
                if (message != null ? StringsKt__StringsKt.contains$default(message, "getsockname failed", false, 2, (Object) null) : false) {
                    z2 = true;
                }
            }
            if (z2) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    public final String toString() {
        return "RawSource(" + this.f10765a + ')';
    }
}
