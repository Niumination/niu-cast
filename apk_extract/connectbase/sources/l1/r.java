package l1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.a
@b1.d
public final class r extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f9617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.a("this")
    public OutputStream f9618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.a
    @u1.a("this")
    public c f9619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.a
    @u1.a("this")
    public File f9620f;

    public class a extends g {
        public a() {
        }

        public void finalize() {
            try {
                r.this.reset();
            } catch (Throwable th2) {
                th2.printStackTrace(System.err);
            }
        }

        @Override // l1.g
        public InputStream m() throws IOException {
            return r.this.h();
        }
    }

    public class b extends g {
        public b() {
        }

        @Override // l1.g
        public InputStream m() throws IOException {
            return r.this.h();
        }
    }

    public static class c extends ByteArrayOutputStream {
        public c() {
        }

        public byte[] b() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int c() {
            return ((ByteArrayOutputStream) this).count;
        }

        public c(a aVar) {
        }
    }

    public r(int fileThreshold) {
        this(fileThreshold, false);
    }

    public g c() {
        return this.f9617c;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f9618d.close();
    }

    @gm.a
    @b1.e
    public synchronized File d() {
        return this.f9620f;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.f9618d.flush();
    }

    public final synchronized InputStream h() throws IOException {
        if (this.f9620f != null) {
            return new FileInputStream(this.f9620f);
        }
        Objects.requireNonNull(this.f9619e);
        return new ByteArrayInputStream(this.f9619e.b(), 0, this.f9619e.c());
    }

    @u1.a("this")
    public final void k(int len) throws IOException {
        c cVar = this.f9619e;
        if (cVar == null || cVar.c() + len <= this.f9615a) {
            return;
        }
        File fileB = i0.f9587a.b("FileBackedOutputStream");
        if (this.f9616b) {
            fileB.deleteOnExit();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileB);
            fileOutputStream.write(this.f9619e.b(), 0, this.f9619e.c());
            fileOutputStream.flush();
            this.f9618d = fileOutputStream;
            this.f9620f = fileB;
            this.f9619e = null;
        } catch (IOException e10) {
            fileB.delete();
            throw e10;
        }
    }

    public synchronized void reset() throws IOException {
        try {
            try {
                close();
                c cVar = this.f9619e;
                if (cVar == null) {
                    this.f9619e = new c();
                } else {
                    cVar.reset();
                }
                this.f9618d = this.f9619e;
                File file = this.f9620f;
                if (file != null) {
                    this.f9620f = null;
                    if (!file.delete()) {
                        throw new IOException("Could not delete: " + file);
                    }
                }
            } catch (Throwable th2) {
                if (this.f9619e == null) {
                    this.f9619e = new c();
                } else {
                    this.f9619e.reset();
                }
                this.f9618d = this.f9619e;
                File file2 = this.f9620f;
                if (file2 != null) {
                    this.f9620f = null;
                    if (!file2.delete()) {
                        throw new IOException("Could not delete: " + file2);
                    }
                }
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int b10) throws IOException {
        k(1);
        this.f9618d.write(b10);
    }

    public r(int fileThreshold, boolean resetOnFinalize) {
        c1.h0.k(fileThreshold >= 0, "fileThreshold must be non-negative, but was %s", fileThreshold);
        this.f9615a = fileThreshold;
        this.f9616b = resetOnFinalize;
        c cVar = new c();
        this.f9619e = cVar;
        this.f9618d = cVar;
        if (resetOnFinalize) {
            this.f9617c = new a();
        } else {
            this.f9617c = new b();
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] b10) throws IOException {
        write(b10, 0, b10.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] b10, int off, int len) throws IOException {
        k(len);
        this.f9618d.write(b10, off, len);
    }
}
