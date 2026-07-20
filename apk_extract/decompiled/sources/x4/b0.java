package x4;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f10833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f10834b = new a0();

    public b0(Appendable appendable) {
        this.f10833a = appendable;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) throws IOException {
        this.f10833a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(int i8) throws IOException {
        this.f10833a.append((char) i8);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) throws IOException {
        this.f10833a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i8, int i9) throws IOException {
        Objects.requireNonNull(str);
        this.f10833a.append(str, i8, i9 + i8);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i8, int i9) throws IOException {
        this.f10833a.append(charSequence, i8, i9);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i8, int i9) throws IOException {
        this.f10833a.append(charSequence, i8, i9);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i8, int i9) throws IOException {
        a0 a0Var = this.f10834b;
        a0Var.f10831a = cArr;
        a0Var.f10832b = null;
        this.f10833a.append(a0Var, i8, i9 + i8);
    }
}
