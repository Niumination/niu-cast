package dj;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStreamReader f4600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qj.h f4601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Charset f4602d;

    public k0(qj.h source, Charset charset) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.f4601c = source;
        this.f4602d = charset;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f4599a = true;
        InputStreamReader inputStreamReader = this.f4600b;
        if (inputStreamReader != null) {
            inputStreamReader.close();
        } else {
            this.f4601c.close();
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cbuf, int i8, int i9) throws IOException {
        Intrinsics.checkNotNullParameter(cbuf, "cbuf");
        if (this.f4599a) {
            throw new IOException("Stream closed");
        }
        InputStreamReader inputStreamReader = this.f4600b;
        if (inputStreamReader == null) {
            qj.h readBomAsCharset = this.f4601c;
            InputStream inputStreamJ0 = readBomAsCharset.j0();
            byte[] bArr = ej.b.f4964a;
            Intrinsics.checkNotNullParameter(readBomAsCharset, "$this$readBomAsCharset");
            Charset UTF_8 = this.f4602d;
            Intrinsics.checkNotNullParameter(UTF_8, "default");
            int iX = readBomAsCharset.x(ej.b.f4967d);
            if (iX != -1) {
                if (iX == 0) {
                    UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                } else if (iX == 1) {
                    UTF_8 = StandardCharsets.UTF_16BE;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_16BE");
                } else if (iX == 2) {
                    UTF_8 = StandardCharsets.UTF_16LE;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_16LE");
                } else if (iX == 3) {
                    UTF_8 = Charsets.INSTANCE.UTF32_BE();
                } else {
                    if (iX != 4) {
                        throw new AssertionError();
                    }
                    UTF_8 = Charsets.INSTANCE.UTF32_LE();
                }
            }
            inputStreamReader = new InputStreamReader(inputStreamJ0, UTF_8);
            this.f4600b = inputStreamReader;
        }
        return inputStreamReader.read(cbuf, i8, i9);
    }
}
