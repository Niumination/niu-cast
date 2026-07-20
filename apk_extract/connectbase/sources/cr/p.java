package cr;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f3447a = Logger.getLogger(p.class.getName());

    public class a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f3448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OutputStream f3449b;

        public a(b0 b0Var, OutputStream outputStream) {
            this.f3448a = b0Var;
            this.f3449b = outputStream;
        }

        @Override // cr.z
        public void Z0(cr.c cVar, long j10) throws IOException {
            d0.b(cVar.f3404b, 0L, j10);
            while (j10 > 0) {
                this.f3448a.h();
                w wVar = cVar.f3403a;
                int iMin = (int) Math.min(j10, wVar.f3488c - wVar.f3487b);
                this.f3449b.write(wVar.f3486a, wVar.f3487b, iMin);
                int i10 = wVar.f3487b + iMin;
                wVar.f3487b = i10;
                long j11 = iMin;
                j10 -= j11;
                cVar.f3404b -= j11;
                if (i10 == wVar.f3488c) {
                    cVar.f3403a = wVar.b();
                    x.a(wVar);
                }
            }
        }

        @Override // cr.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f3449b.close();
        }

        @Override // cr.z
        public b0 f() {
            return this.f3448a;
        }

        @Override // cr.z, java.io.Flushable
        public void flush() throws IOException {
            this.f3449b.flush();
        }

        public String toString() {
            return "sink(" + this.f3449b + ")";
        }
    }

    public class b implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f3450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InputStream f3451b;

        public b(b0 b0Var, InputStream inputStream) {
            this.f3450a = b0Var;
            this.f3451b = inputStream;
        }

        @Override // cr.a0
        public long Y0(cr.c cVar, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
            }
            if (j10 == 0) {
                return 0L;
            }
            try {
                this.f3450a.h();
                w wVarS0 = cVar.S0(1);
                int i10 = this.f3451b.read(wVarS0.f3486a, wVarS0.f3488c, (int) Math.min(j10, 8192 - wVarS0.f3488c));
                if (i10 != -1) {
                    wVarS0.f3488c += i10;
                    long j11 = i10;
                    cVar.f3404b += j11;
                    return j11;
                }
                if (wVarS0.f3487b != wVarS0.f3488c) {
                    return -1L;
                }
                cVar.f3403a = wVarS0.b();
                x.a(wVarS0);
                return -1L;
            } catch (AssertionError e10) {
                if (p.e(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        }

        @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f3451b.close();
        }

        @Override // cr.a0
        public b0 f() {
            return this.f3450a;
        }

        public String toString() {
            return "source(" + this.f3451b + ")";
        }
    }

    public class c implements z {
        @Override // cr.z
        public void Z0(cr.c cVar, long j10) throws IOException {
            cVar.skip(j10);
        }

        @Override // cr.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // cr.z
        public b0 f() {
            return b0.f3397d;
        }

        @Override // cr.z, java.io.Flushable
        public void flush() throws IOException {
        }
    }

    public class d extends cr.a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Socket f3452l;

        public d(Socket socket) {
            this.f3452l = socket;
        }

        @Override // cr.a
        public IOException r(@gm.j IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(RtspHeaders.Values.TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // cr.a
        public void w() {
            try {
                this.f3452l.close();
            } catch (AssertionError e10) {
                if (!p.e(e10)) {
                    throw e10;
                }
                p.f3447a.log(Level.WARNING, "Failed to close timed out socket " + this.f3452l, (Throwable) e10);
            } catch (Exception e11) {
                p.f3447a.log(Level.WARNING, "Failed to close timed out socket " + this.f3452l, (Throwable) e11);
            }
        }
    }

    public static z a(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static z b() {
        return new c();
    }

    public static cr.d c(z zVar) {
        return new u(zVar);
    }

    public static e d(a0 a0Var) {
        return new v(a0Var);
    }

    public static boolean e(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static z f(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static z g(OutputStream outputStream) {
        return h(outputStream, new b0());
    }

    public static z h(OutputStream outputStream, b0 b0Var) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (b0Var != null) {
            return new a(b0Var, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static z i(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        d dVar = new d(socket);
        return new cr.a.C0079a(h(socket.getOutputStream(), dVar));
    }

    @is.a
    public static z j(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return g(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static a0 k(File file) throws FileNotFoundException {
        if (file != null) {
            return l(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static a0 l(InputStream inputStream) {
        return m(inputStream, new b0());
    }

    public static a0 m(InputStream inputStream, b0 b0Var) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (b0Var != null) {
            return new b(b0Var, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static a0 n(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        d dVar = new d(socket);
        return new cr.a.b(m(socket.getInputStream(), dVar));
    }

    @is.a
    public static a0 o(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return l(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static cr.a p(Socket socket) {
        return new d(socket);
    }
}
