package dn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kn.l0;
import lm.a1;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "ByteStreamsKt")
public final class b {

    public static final class a extends nm.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3751a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3753c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BufferedInputStream f3754d;

        public a(BufferedInputStream bufferedInputStream) {
            this.f3754d = bufferedInputStream;
        }

        public final boolean c() {
            return this.f3753c;
        }

        public final int e() {
            return this.f3751a;
        }

        public final boolean f() {
            return this.f3752b;
        }

        public final void g() throws IOException {
            if (this.f3752b || this.f3753c) {
                return;
            }
            int i10 = this.f3754d.read();
            this.f3751a = i10;
            this.f3752b = true;
            this.f3753c = i10 == -1;
        }

        public final void h(boolean z10) {
            this.f3753c = z10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            g();
            return !this.f3753c;
        }

        public final void i(int i10) {
            this.f3751a = i10;
        }

        public final void j(boolean z10) {
            this.f3752b = z10;
        }

        @Override // nm.u
        public byte nextByte() throws IOException {
            g();
            if (this.f3753c) {
                throw new NoSuchElementException("Input stream is over.");
            }
            byte b10 = (byte) this.f3751a;
            this.f3752b = false;
            return b10;
        }
    }

    @an.f
    public static final BufferedInputStream a(InputStream inputStream, int i10) {
        l0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i10);
    }

    @an.f
    public static final BufferedOutputStream b(OutputStream outputStream, int i10) {
        l0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i10);
    }

    public static /* synthetic */ BufferedInputStream c(InputStream inputStream, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        l0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i10);
    }

    public static /* synthetic */ BufferedOutputStream d(OutputStream outputStream, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        l0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i10);
    }

    @an.f
    public static final BufferedReader e(InputStream inputStream, Charset charset) {
        l0.p(inputStream, "<this>");
        l0.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    public static /* synthetic */ BufferedReader f(InputStream inputStream, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(inputStream, "<this>");
        l0.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    @an.f
    public static final BufferedWriter g(OutputStream outputStream, Charset charset) {
        l0.p(outputStream, "<this>");
        l0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    public static /* synthetic */ BufferedWriter h(OutputStream outputStream, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(outputStream, "<this>");
        l0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    @an.f
    public static final ByteArrayInputStream i(String str, Charset charset) {
        l0.p(str, "<this>");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "getBytes(...)");
        return new ByteArrayInputStream(bytes);
    }

    public static /* synthetic */ ByteArrayInputStream j(String str, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(str, "<this>");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "getBytes(...)");
        return new ByteArrayInputStream(bytes);
    }

    public static final long k(@os.l InputStream inputStream, @os.l OutputStream outputStream, int i10) throws IOException {
        l0.p(inputStream, "<this>");
        l0.p(outputStream, "out");
        byte[] bArr = new byte[i10];
        int i11 = inputStream.read(bArr);
        long j10 = 0;
        while (i11 >= 0) {
            outputStream.write(bArr, 0, i11);
            j10 += (long) i11;
            i11 = inputStream.read(bArr);
        }
        return j10;
    }

    public static /* synthetic */ long l(InputStream inputStream, OutputStream outputStream, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return k(inputStream, outputStream, i10);
    }

    @an.f
    public static final ByteArrayInputStream m(byte[] bArr) {
        l0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr);
    }

    @an.f
    public static final ByteArrayInputStream n(byte[] bArr, int i10, int i11) {
        l0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr, i10, i11);
    }

    @os.l
    public static final nm.u o(@os.l BufferedInputStream bufferedInputStream) {
        l0.p(bufferedInputStream, "<this>");
        return new a(bufferedInputStream);
    }

    @f1(version = "1.3")
    @os.l
    public static final byte[] p(@os.l InputStream inputStream) {
        l0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        l0.o(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @lm.l(errorSince = "1.5", warningSince = "1.3")
    @lm.k(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @a1(expression = "readBytes()", imports = {}))
    @os.l
    public static final byte[] q(@os.l InputStream inputStream, int i10) {
        l0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i10, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        l0.o(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static /* synthetic */ byte[] r(InputStream inputStream, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        return q(inputStream, i10);
    }

    @an.f
    public static final InputStreamReader s(InputStream inputStream, Charset charset) {
        l0.p(inputStream, "<this>");
        l0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    public static /* synthetic */ InputStreamReader t(InputStream inputStream, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(inputStream, "<this>");
        l0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    @an.f
    public static final OutputStreamWriter u(OutputStream outputStream, Charset charset) {
        l0.p(outputStream, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    public static /* synthetic */ OutputStreamWriter v(OutputStream outputStream, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(outputStream, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }
}
