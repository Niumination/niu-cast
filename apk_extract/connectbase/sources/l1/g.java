package l1;

import f1.i3;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public abstract class g {

    public class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Charset f9554a;

        public a(Charset charset) {
            charset.getClass();
            this.f9554a = charset;
        }

        @Override // l1.k
        public g a(Charset charset) {
            return charset.equals(this.f9554a) ? g.this : new k.a(charset);
        }

        @Override // l1.k
        public Reader m() throws IOException {
            return new InputStreamReader(g.this.m(), this.f9554a);
        }

        @Override // l1.k
        public String n() throws IOException {
            return new String(g.this.o(), this.f9554a);
        }

        public String toString() {
            return g.this.toString() + ".asCharSource(" + this.f9554a + ")";
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<? extends g> f9559a;

        public c(Iterable<? extends g> sources) {
            sources.getClass();
            this.f9559a = sources;
        }

        @Override // l1.g
        public boolean k() throws IOException {
            Iterator<? extends g> it = this.f9559a.iterator();
            while (it.hasNext()) {
                if (!it.next().k()) {
                    return false;
                }
            }
            return true;
        }

        @Override // l1.g
        public InputStream m() throws IOException {
            return new c0(this.f9559a.iterator());
        }

        @Override // l1.g
        public long p() throws IOException {
            Iterator<? extends g> it = this.f9559a.iterator();
            long jP = 0;
            while (it.hasNext()) {
                jP += it.next().p();
                if (jP < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return jP;
        }

        @Override // l1.g
        public c1.c0<Long> q() {
            Iterable<? extends g> iterable = this.f9559a;
            if (!(iterable instanceof Collection)) {
                return c1.c0.absent();
            }
            Iterator<? extends g> it = iterable.iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                c1.c0<Long> c0VarQ = it.next().q();
                if (!c0VarQ.isPresent()) {
                    return c1.c0.absent();
                }
                jLongValue += c0VarQ.get().longValue();
                if (jLongValue < 0) {
                    return c1.c0.of(Long.MAX_VALUE);
                }
            }
            return c1.c0.of(Long.valueOf(jLongValue));
        }

        public String toString() {
            return "ByteSource.concat(" + this.f9559a + ")";
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f9560d = new d();

        public d() {
            super(new byte[0]);
        }

        @Override // l1.g
        public k a(Charset charset) {
            charset.getClass();
            return k.d.f9600c;
        }

        @Override // l1.g.b, l1.g
        public byte[] o() {
            return this.f9556a;
        }

        @Override // l1.g.b
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    public final class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9562b;

        public e(long offset, long length) {
            c1.h0.p(offset >= 0, "offset (%s) may not be negative", offset);
            c1.h0.p(length >= 0, "length (%s) may not be negative", length);
            this.f9561a = offset;
            this.f9562b = length;
        }

        @Override // l1.g
        public boolean k() throws IOException {
            return this.f9562b == 0 || super.k();
        }

        @Override // l1.g
        public InputStream l() throws IOException {
            return t(g.this.l());
        }

        @Override // l1.g
        public InputStream m() throws IOException {
            return t(g.this.m());
        }

        @Override // l1.g
        public c1.c0<Long> q() {
            c1.c0<Long> c0VarQ = g.this.q();
            if (!c0VarQ.isPresent()) {
                return c1.c0.absent();
            }
            long jLongValue = c0VarQ.get().longValue();
            return c1.c0.of(Long.valueOf(Math.min(this.f9562b, jLongValue - Math.min(this.f9561a, jLongValue))));
        }

        @Override // l1.g
        public g r(long offset, long length) {
            c1.h0.p(offset >= 0, "offset (%s) may not be negative", offset);
            c1.h0.p(length >= 0, "length (%s) may not be negative", length);
            long j10 = this.f9562b - offset;
            return j10 <= 0 ? d.f9560d : g.this.r(this.f9561a + offset, Math.min(length, j10));
        }

        public final InputStream t(InputStream in2) throws IOException {
            long j10 = this.f9561a;
            if (j10 > 0) {
                try {
                    if (h.t(in2, j10) < this.f9561a) {
                        in2.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } catch (Throwable th2) {
                    n nVarB = n.b();
                    nVarB.c(in2);
                    try {
                        throw nVarB.d(th2);
                    } catch (Throwable th3) {
                        nVarB.close();
                        throw th3;
                    }
                }
            }
            return h.f(in2, this.f9562b);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(g.this.toString());
            sb2.append(".slice(");
            sb2.append(this.f9561a);
            sb2.append(", ");
            return k.d.a(sb2, this.f9562b, ")");
        }
    }

    public static g b(Iterable<? extends g> sources) {
        return new c(sources);
    }

    public static g c(Iterator<? extends g> sources) {
        return new c(i3.copyOf(sources));
    }

    public static g d(g... sources) {
        return new c(i3.copyOf(sources));
    }

    public static g i() {
        return d.f9560d;
    }

    public static g s(byte[] b10) {
        return new b(b10);
    }

    public k a(Charset charset) {
        return new a(charset);
    }

    public boolean e(g other) throws IOException {
        int iN;
        other.getClass();
        byte[] bArrD = h.d();
        byte[] bArr = new byte[8192];
        n nVarB = n.b();
        try {
            InputStream inputStream = (InputStream) nVarB.c(m());
            InputStream inputStream2 = (InputStream) nVarB.c(other.m());
            do {
                iN = h.n(inputStream, bArrD, 0, bArrD.length);
                if (iN == h.n(inputStream2, bArr, 0, 8192) && Arrays.equals(bArrD, bArr)) {
                }
                nVarB.close();
                return false;
            } while (iN == bArrD.length);
            nVarB.close();
            return true;
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
    public long f(OutputStream output) throws IOException {
        output.getClass();
        n nVarB = n.b();
        try {
            long jB = h.b((InputStream) nVarB.c(m()), output);
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
    public long g(f sink) throws IOException {
        sink.getClass();
        n nVarB = n.b();
        try {
            long jB = h.b((InputStream) nVarB.c(m()), (OutputStream) nVarB.c(sink.c()));
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

    public final long h(InputStream in2) throws IOException {
        long j10 = 0;
        while (true) {
            long jT = h.t(in2, 2147483647L);
            if (jT <= 0) {
                return j10;
            }
            j10 += jT;
        }
    }

    public j1.q j(j1.r hashFunction) throws IOException {
        j1.s sVarNewHasher = hashFunction.newHasher();
        f(new j1.p.e(sVarNewHasher));
        return sVarNewHasher.i();
    }

    public boolean k() throws IOException {
        c1.c0<Long> c0VarQ = q();
        if (c0VarQ.isPresent()) {
            return c0VarQ.get().longValue() == 0;
        }
        n nVarB = n.b();
        try {
            boolean z10 = ((InputStream) nVarB.c(m())).read() == -1;
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

    public InputStream l() throws IOException {
        InputStream inputStreamM = m();
        return inputStreamM instanceof BufferedInputStream ? (BufferedInputStream) inputStreamM : new BufferedInputStream(inputStreamM);
    }

    public abstract InputStream m() throws IOException;

    @t1.a
    @e0
    public <T> T n(l1.e<T> eVar) throws IOException {
        eVar.getClass();
        n nVarB = n.b();
        try {
            T t10 = (T) h.o((InputStream) nVarB.c(m()), eVar);
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

    public byte[] o() throws IOException {
        n nVarB = n.b();
        try {
            InputStream inputStream = (InputStream) nVarB.c(m());
            c1.c0<Long> c0VarQ = q();
            byte[] bArrV = c0VarQ.isPresent() ? h.v(inputStream, c0VarQ.get().longValue()) : h.u(inputStream);
            nVarB.close();
            return bArrV;
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    public long p() throws IOException {
        c1.c0<Long> c0VarQ = q();
        if (c0VarQ.isPresent()) {
            return c0VarQ.get().longValue();
        }
        n nVarB = n.b();
        try {
            long jH = h((InputStream) nVarB.c(m()));
            nVarB.close();
            return jH;
        } catch (IOException unused) {
            nVarB.close();
            n nVarB2 = n.b();
            try {
                long jE = h.e((InputStream) nVarB2.c(m()));
                nVarB2.close();
                return jE;
            } catch (Throwable th2) {
                try {
                    throw nVarB2.d(th2);
                } catch (Throwable th3) {
                    nVarB2.close();
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            nVarB.close();
            throw th4;
        }
    }

    public c1.c0<Long> q() {
        return c1.c0.absent();
    }

    public g r(long offset, long length) {
        return new e(offset, length);
    }

    public static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f9556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9558c;

        public b(byte[] bytes, int offset, int length) {
            this.f9556a = bytes;
            this.f9557b = offset;
            this.f9558c = length;
        }

        @Override // l1.g
        public long f(OutputStream output) throws IOException {
            output.write(this.f9556a, this.f9557b, this.f9558c);
            return this.f9558c;
        }

        @Override // l1.g
        public j1.q j(j1.r hashFunction) throws IOException {
            return hashFunction.hashBytes(this.f9556a, this.f9557b, this.f9558c);
        }

        @Override // l1.g
        public boolean k() {
            return this.f9558c == 0;
        }

        @Override // l1.g
        public InputStream l() {
            return m();
        }

        @Override // l1.g
        public InputStream m() {
            return new ByteArrayInputStream(this.f9556a, this.f9557b, this.f9558c);
        }

        @Override // l1.g
        @e0
        public <T> T n(l1.e<T> processor) throws IOException {
            processor.b(this.f9556a, this.f9557b, this.f9558c);
            return processor.a();
        }

        @Override // l1.g
        public byte[] o() {
            byte[] bArr = this.f9556a;
            int i10 = this.f9557b;
            return Arrays.copyOfRange(bArr, i10, this.f9558c + i10);
        }

        @Override // l1.g
        public long p() {
            return this.f9558c;
        }

        @Override // l1.g
        public c1.c0<Long> q() {
            return c1.c0.of(Long.valueOf(this.f9558c));
        }

        @Override // l1.g
        public g r(long offset, long length) {
            c1.h0.p(offset >= 0, "offset (%s) may not be negative", offset);
            c1.h0.p(length >= 0, "length (%s) may not be negative", length);
            long jMin = Math.min(offset, this.f9558c);
            return new b(this.f9556a, this.f9557b + ((int) jMin), (int) Math.min(length, ((long) this.f9558c) - jMin));
        }

        public String toString() {
            return "ByteSource.wrap(" + c1.c.k(l1.b.a().m(this.f9556a, this.f9557b, this.f9558c), 30, "...") + ")";
        }

        public b(byte[] bytes) {
            this(bytes, 0, bytes.length);
        }
    }
}
