package l1;

import f1.i3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public abstract class k {

    public final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Charset f9593a;

        public a(Charset charset) {
            charset.getClass();
            this.f9593a = charset;
        }

        @Override // l1.g
        public k a(Charset charset) {
            return charset.equals(this.f9593a) ? k.this : new g.a(charset);
        }

        @Override // l1.g
        public InputStream m() throws IOException {
            return new g0(k.this.m(), this.f9593a, 8192);
        }

        public String toString() {
            return k.this.toString() + ".asByteSource(" + this.f9593a + ")";
        }
    }

    public static class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c1.m0 f9595b = c1.m0.l("\r\n|\n|\r");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f9596a;

        public class a extends f1.c<String> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Iterator<String> f9597c;

            public a() {
                this.f9597c = b.f9595b.n(b.this.f9596a).iterator();
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public String a() {
                if (this.f9597c.hasNext()) {
                    String next = this.f9597c.next();
                    if (this.f9597c.hasNext() || !next.isEmpty()) {
                        return next;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public b(CharSequence seq) {
            seq.getClass();
            this.f9596a = seq;
        }

        @Override // l1.k
        public boolean i() {
            return this.f9596a.length() == 0;
        }

        @Override // l1.k
        public long j() {
            return this.f9596a.length();
        }

        @Override // l1.k
        public c1.c0<Long> k() {
            return c1.c0.of(Long.valueOf(this.f9596a.length()));
        }

        @Override // l1.k
        public Reader m() {
            return new i(this.f9596a);
        }

        @Override // l1.k
        public String n() {
            return this.f9596a.toString();
        }

        @Override // l1.k
        @gm.a
        public String o() {
            a aVar = new a();
            if (aVar.hasNext()) {
                return aVar.next();
            }
            return null;
        }

        @Override // l1.k
        public i3<String> p() {
            return i3.copyOf(new a());
        }

        @Override // l1.k
        @e0
        public <T> T q(y<T> processor) throws IOException {
            a aVar = new a();
            while (aVar.hasNext() && processor.b(aVar.next())) {
            }
            return processor.a();
        }

        public final Iterator<String> t() {
            return new a();
        }

        public String toString() {
            return "CharSource.wrap(" + c1.c.k(this.f9596a, 30, "...") + ")";
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<? extends k> f9599a;

        public c(Iterable<? extends k> sources) {
            sources.getClass();
            this.f9599a = sources;
        }

        @Override // l1.k
        public boolean i() throws IOException {
            Iterator<? extends k> it = this.f9599a.iterator();
            while (it.hasNext()) {
                if (!it.next().i()) {
                    return false;
                }
            }
            return true;
        }

        @Override // l1.k
        public long j() throws IOException {
            Iterator<? extends k> it = this.f9599a.iterator();
            long j10 = 0;
            while (it.hasNext()) {
                j10 += it.next().j();
            }
            return j10;
        }

        @Override // l1.k
        public c1.c0<Long> k() {
            Iterator<? extends k> it = this.f9599a.iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                c1.c0<Long> c0VarK = it.next().k();
                if (!c0VarK.isPresent()) {
                    return c1.c0.absent();
                }
                jLongValue += c0VarK.get().longValue();
            }
            return c1.c0.of(Long.valueOf(jLongValue));
        }

        @Override // l1.k
        public Reader m() throws IOException {
            return new d0(this.f9599a.iterator());
        }

        public String toString() {
            return "CharSource.concat(" + this.f9599a + ")";
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f9600c = new d();

        public d() {
            super((CharSequence) "");
        }

        @Override // l1.k.b
        public String toString() {
            return "CharSource.empty()";
        }
    }

    public static class e extends b {
        public e(String seq) {
            super(seq);
        }

        @Override // l1.k
        public long e(Appendable appendable) throws IOException {
            appendable.append(this.f9596a);
            return this.f9596a.length();
        }

        @Override // l1.k
        public long f(j sink) throws IOException {
            sink.getClass();
            n nVarB = n.b();
            try {
                ((Writer) nVarB.c(sink.b())).write((String) this.f9596a);
                long length = this.f9596a.length();
                nVarB.close();
                return length;
            } catch (Throwable th2) {
                try {
                    throw nVarB.d(th2);
                } catch (Throwable th3) {
                    nVarB.close();
                    throw th3;
                }
            }
        }

        @Override // l1.k.b, l1.k
        public Reader m() {
            return new StringReader((String) this.f9596a);
        }
    }

    public static k b(Iterable<? extends k> sources) {
        return new c(sources);
    }

    public static k c(Iterator<? extends k> sources) {
        return new c(i3.copyOf(sources));
    }

    public static k d(k... sources) {
        return new c(i3.copyOf(sources));
    }

    public static k h() {
        return d.f9600c;
    }

    public static k r(CharSequence charSequence) {
        return charSequence instanceof String ? new e(charSequence) : new b(charSequence);
    }

    public g a(Charset charset) {
        return new a(charset);
    }

    @t1.a
    public long e(Appendable appendable) throws IOException {
        appendable.getClass();
        n nVarB = n.b();
        try {
            long jB = l.b((Reader) nVarB.c(m()), appendable);
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

    @t1.a
    public long f(j sink) throws IOException {
        sink.getClass();
        n nVarB = n.b();
        try {
            long jB = l.b((Reader) nVarB.c(m()), (Writer) nVarB.c(sink.b()));
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

    public final long g(Reader reader) throws IOException {
        long j10 = 0;
        while (true) {
            long jSkip = reader.skip(Long.MAX_VALUE);
            if (jSkip == 0) {
                return j10;
            }
            j10 += jSkip;
        }
    }

    public boolean i() throws IOException {
        c1.c0<Long> c0VarK = k();
        if (c0VarK.isPresent()) {
            return c0VarK.get().longValue() == 0;
        }
        n nVarB = n.b();
        try {
            boolean z10 = ((Reader) nVarB.c(m())).read() == -1;
            nVarB.close();
            return z10;
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    public long j() throws IOException {
        c1.c0<Long> c0VarK = k();
        if (c0VarK.isPresent()) {
            return c0VarK.get().longValue();
        }
        n nVarB = n.b();
        try {
            long jG = g((Reader) nVarB.c(m()));
            nVarB.close();
            return jG;
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    public c1.c0<Long> k() {
        return c1.c0.absent();
    }

    public BufferedReader l() throws IOException {
        Reader readerM = m();
        return readerM instanceof BufferedReader ? (BufferedReader) readerM : new BufferedReader(readerM);
    }

    public abstract Reader m() throws IOException;

    public String n() throws IOException {
        n nVarB = n.b();
        try {
            String strK = l.k((Reader) nVarB.c(m()));
            nVarB.close();
            return strK;
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    @gm.a
    public String o() throws IOException {
        n nVarB = n.b();
        try {
            String line = ((BufferedReader) nVarB.c(l())).readLine();
            nVarB.close();
            return line;
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    public i3<String> p() throws IOException {
        n nVarB = n.b();
        try {
            BufferedReader bufferedReader = (BufferedReader) nVarB.c(l());
            ArrayList arrayList = new ArrayList();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    i3<String> i3VarCopyOf = i3.copyOf((Collection) arrayList);
                    nVarB.close();
                    return i3VarCopyOf;
                }
                arrayList.add(line);
            }
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
    @e0
    public <T> T q(y<T> yVar) throws IOException {
        yVar.getClass();
        n nVarB = n.b();
        try {
            T t10 = (T) l.h((Reader) nVarB.c(m()), yVar);
            nVarB.close();
            return t10;
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
