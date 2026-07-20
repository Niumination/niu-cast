package l1;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public abstract class f {

    public final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Charset f9551a;

        @Override // l1.j
        public Writer b() throws IOException {
            return new OutputStreamWriter(f.this.c(), this.f9551a);
        }

        public String toString() {
            return f.this.toString() + ".asCharSink(" + this.f9551a + ")";
        }

        public b(Charset charset) {
            charset.getClass();
            this.f9551a = charset;
        }
    }

    public j a(Charset charset) {
        return new b(charset);
    }

    public OutputStream b() throws IOException {
        OutputStream outputStreamC = c();
        return outputStreamC instanceof BufferedOutputStream ? (BufferedOutputStream) outputStreamC : new BufferedOutputStream(outputStreamC);
    }

    public abstract OutputStream c() throws IOException;

    public void d(byte[] bytes) throws IOException {
        bytes.getClass();
        n nVarB = n.b();
        try {
            OutputStream outputStream = (OutputStream) nVarB.c(c());
            outputStream.write(bytes);
            outputStream.flush();
            nVarB.close();
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    @t1.a
    public long e(InputStream input) throws IOException {
        input.getClass();
        n nVarB = n.b();
        try {
            OutputStream outputStream = (OutputStream) nVarB.c(c());
            long jB = h.b(input, outputStream);
            outputStream.flush();
            nVarB.close();
            return jB;
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }
}
