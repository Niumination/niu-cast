package l1;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public class a extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f9499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9500b;

    public a(Appendable target) {
        target.getClass();
        this.f9499a = target;
    }

    public final void b() throws IOException {
        if (this.f9500b) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9500b = true;
        Appendable appendable = this.f9499a;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        b();
        Appendable appendable = this.f9499a;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) throws IOException {
        b();
        this.f9499a.append(new String(cbuf, off, len));
    }

    @Override // java.io.Writer
    public void write(int c10) throws IOException {
        b();
        this.f9499a.append((char) c10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c10) throws IOException {
        b();
        this.f9499a.append(c10);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        str.getClass();
        b();
        this.f9499a.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@gm.a CharSequence charSeq) throws IOException {
        b();
        this.f9499a.append(charSeq);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@gm.a CharSequence charSeq, int start, int end) throws IOException {
        b();
        this.f9499a.append(charSeq, start, end);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int off, int len) throws IOException {
        str.getClass();
        b();
        this.f9499a.append(str, off, len + off);
    }
}
