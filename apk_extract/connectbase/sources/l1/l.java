package l1;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9601a = 2048;

    public static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9602a = new a();

        @Override // java.io.Writer, java.lang.Appendable
        public Appendable append(char c10) throws IOException {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int c10) {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Appendable append(@gm.a CharSequence csq) throws IOException {
            return this;
        }

        @Override // java.io.Writer
        public void write(char[] cbuf, int off, int len) {
            c1.h0.f0(off, len + off, cbuf.length);
        }

        @Override // java.io.Writer
        public void write(String str, int off, int len) {
            c1.h0.f0(off, len + off, str.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@gm.a CharSequence csq) {
            return this;
        }

        @Override // java.io.Writer
        public void write(String str) {
            str.getClass();
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@gm.a CharSequence csq, int start, int end) {
            c1.h0.f0(start, end, csq == null ? 4 : csq.length());
            return this;
        }

        @Override // java.io.Writer
        public void write(char[] cbuf) {
            cbuf.getClass();
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c10) {
            return this;
        }
    }

    public static Writer a(Appendable target) {
        return target instanceof Writer ? (Writer) target : new l1.a(target);
    }

    @t1.a
    public static long b(Readable from, Appendable to2) throws IOException {
        if (from instanceof Reader) {
            return to2 instanceof StringBuilder ? c((Reader) from, (StringBuilder) to2) : d((Reader) from, a(to2));
        }
        from.getClass();
        to2.getClass();
        CharBuffer charBufferAllocate = CharBuffer.allocate(2048);
        long jRemaining = 0;
        while (from.read(charBufferAllocate) != -1) {
            charBufferAllocate.flip();
            to2.append(charBufferAllocate);
            jRemaining += (long) charBufferAllocate.remaining();
            charBufferAllocate.clear();
        }
        return jRemaining;
    }

    @t1.a
    public static long c(Reader from, StringBuilder to2) throws IOException {
        from.getClass();
        to2.getClass();
        char[] cArr = new char[2048];
        long j10 = 0;
        while (true) {
            int i10 = from.read(cArr);
            if (i10 == -1) {
                return j10;
            }
            to2.append(cArr, 0, i10);
            j10 += (long) i10;
        }
    }

    @t1.a
    public static long d(Reader from, Writer to2) throws IOException {
        from.getClass();
        to2.getClass();
        char[] cArr = new char[2048];
        long j10 = 0;
        while (true) {
            int i10 = from.read(cArr);
            if (i10 == -1) {
                return j10;
            }
            to2.write(cArr, 0, i10);
            j10 += (long) i10;
        }
    }

    public static CharBuffer e() {
        return CharBuffer.allocate(2048);
    }

    @t1.a
    public static long f(Readable readable) throws IOException {
        CharBuffer charBufferAllocate = CharBuffer.allocate(2048);
        long j10 = 0;
        while (true) {
            long j11 = readable.read(charBufferAllocate);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            charBufferAllocate.clear();
        }
    }

    public static Writer g() {
        return a.f9602a;
    }

    @t1.a
    @e0
    public static <T> T h(Readable readable, y<T> processor) throws IOException {
        String strB;
        readable.getClass();
        processor.getClass();
        z zVar = new z(readable);
        do {
            strB = zVar.b();
            if (strB == null) {
                break;
            }
        } while (processor.b(strB));
        return processor.a();
    }

    public static List<String> i(Readable r10) throws IOException {
        ArrayList arrayList = new ArrayList();
        z zVar = new z(r10);
        while (true) {
            String strB = zVar.b();
            if (strB == null) {
                return arrayList;
            }
            arrayList.add(strB);
        }
    }

    public static void j(Reader reader, long n10) throws IOException {
        reader.getClass();
        while (n10 > 0) {
            long jSkip = reader.skip(n10);
            if (jSkip == 0) {
                throw new EOFException();
            }
            n10 -= jSkip;
        }
    }

    public static String k(Readable r10) throws IOException {
        return l(r10).toString();
    }

    public static StringBuilder l(Readable r10) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        if (r10 instanceof Reader) {
            c((Reader) r10, sb2);
        } else {
            b(r10, sb2);
        }
        return sb2;
    }
}
