package x1;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import v1.u;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    public static final class b extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f19988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f19989b = new a();

        public static class a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public char[] f19990a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f19991b;

            public a() {
            }

            public void a(char[] cArr) {
                this.f19990a = cArr;
                this.f19991b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f19990a[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f19990a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f19990a, i10, i11 - i10);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f19991b == null) {
                    this.f19991b = new String(this.f19990a);
                }
                return this.f19991b;
            }

            public a(a aVar) {
            }
        }

        public b(Appendable appendable) {
            this.f19988a = appendable;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f19988a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) throws IOException {
            this.f19989b.a(cArr);
            this.f19988a.append(this.f19989b, i10, i11 + i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            this.f19988a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i10, int i11) throws IOException {
            this.f19988a.append(charSequence, i10, i11);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i10) throws IOException {
            this.f19988a.append((char) i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i10, int i11) throws IOException {
            this.f19988a.append(charSequence, i10, i11);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) throws IOException {
            Objects.requireNonNull(str);
            this.f19988a.append(str, i10, i11 + i10);
        }
    }

    private o() {
        throw new UnsupportedOperationException();
    }

    public static v1.k parse(d2.a aVar) throws v1.o {
        boolean z10;
        try {
            try {
                aVar.peek();
                z10 = false;
                try {
                    return y1.o.JSON_ELEMENT.read(aVar);
                } catch (EOFException e10) {
                    e = e10;
                    if (z10) {
                        return v1.m.INSTANCE;
                    }
                    throw new u(e);
                }
            } catch (EOFException e11) {
                e = e11;
                z10 = true;
            }
        } catch (d2.e e12) {
            throw new u(e12);
        } catch (IOException e13) {
            throw new v1.l(e13);
        } catch (NumberFormatException e14) {
            throw new u(e14);
        }
    }

    public static void write(v1.k kVar, d2.d dVar) throws IOException {
        y1.o.JSON_ELEMENT.write(dVar, kVar);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }
}
