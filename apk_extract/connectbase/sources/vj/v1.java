package vj;

import io.netty.util.internal.StringUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@hm.c
public final class v1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f17425d = "-bin";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ boolean f17429h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f17430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f17424c = Logger.getLogger(v1.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f<byte[]> f17426e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d<String> f17427f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l1.b f17428g = l1.b.d().w();

    public class a implements f<byte[]> {
        @Override // vj.v1.f
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        @Override // vj.v1.f
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(byte[] bArr) {
            return bArr;
        }
    }

    public class b implements d<String> {
        @Override // vj.v1.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String b(String str) {
            return str;
        }

        @Override // vj.v1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(String str) {
            return str;
        }
    }

    public interface d<T> {
        String a(T t10);

        T b(String str);
    }

    public interface f<T> {
        byte[] a(T t10);

        T b(byte[] bArr);
    }

    @e0("https://github.com/grpc/grpc-java/issues/6575")
    public interface g<T> {
        InputStream a(T t10);

        T b(InputStream inputStream);
    }

    public final class h<T> implements Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i<T> f17434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17435b;

        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f17437a = true;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f17438b;

            public a() {
                this.f17438b = h.this.f17435b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f17437a) {
                    return true;
                }
                while (this.f17438b < v1.this.f17431b) {
                    h hVar = h.this;
                    if (v1.e(v1.this, hVar.f17434a.a(), v1.this.v(this.f17438b))) {
                        this.f17437a = true;
                        return true;
                    }
                    this.f17438b++;
                }
                return false;
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f17437a = false;
                h hVar = h.this;
                v1 v1Var = v1.this;
                int i10 = this.f17438b;
                this.f17438b = i10 + 1;
                return (T) v1Var.H(i10, hVar.f17434a);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public /* synthetic */ h(v1 v1Var, i iVar, int i10, a aVar) {
            this(iVar, i10);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new a();
        }

        public h(i<T> iVar, int i10) {
            this.f17434a = iVar;
            this.f17435b = i10;
        }
    }

    @hm.b
    public static abstract class i<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final BitSet f17440e = b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f17443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f17444d;

        public /* synthetic */ i(String str, boolean z10, Object obj, a aVar) {
            this(str, z10, obj);
        }

        public static BitSet b() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
                bitSet.set(c10);
            }
            for (char c11 = y5.a.H; c11 <= 'z'; c11 = (char) (c11 + 1)) {
                bitSet.set(c11);
            }
            return bitSet;
        }

        public static <T> i<T> e(String str, d<T> dVar) {
            return new c(str, false, dVar);
        }

        public static <T> i<T> f(String str, f<T> fVar) {
            return new e(str, fVar);
        }

        @e0("https://github.com/grpc/grpc-java/issues/6575")
        public static <T> i<T> g(String str, g<T> gVar) {
            return new j(str, gVar);
        }

        public static <T> i<T> h(String str, boolean z10, d<T> dVar) {
            return new c(str, z10, dVar);
        }

        public static <T> i<T> i(String str, boolean z10, m<T> mVar) {
            return new l(str, z10, mVar);
        }

        public static String n(String str, boolean z10) {
            c1.h0.F(str, "name");
            c1.h0.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                v1.f17424c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i10 = 0; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (!z10 || cCharAt != ':' || i10 != 0) {
                    c1.h0.j(f17440e.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, str);
                }
            }
            return str;
        }

        @b1.e
        public byte[] a() {
            return this.f17443c;
        }

        @gm.j
        public final <M> M c(Class<M> cls) {
            if (cls.isInstance(this.f17444d)) {
                return cls.cast(this.f17444d);
            }
            return null;
        }

        public final String d() {
            return this.f17442b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f17442b.equals(((i) obj).f17442b);
        }

        public final int hashCode() {
            return this.f17442b.hashCode();
        }

        public final String j() {
            return this.f17441a;
        }

        public abstract T k(byte[] bArr);

        public boolean l() {
            return false;
        }

        public abstract byte[] m(T t10);

        public String toString() {
            return j.c.a(new StringBuilder("Key{name='"), this.f17442b, "'}");
        }

        public i(String str, boolean z10, Object obj) {
            String str2 = (String) c1.h0.F(str, "name");
            this.f17441a = str2;
            String strN = n(str2.toLowerCase(Locale.ROOT), z10);
            this.f17442b = strN;
            this.f17443c = strN.getBytes(c1.f.f1177a);
            this.f17444d = obj;
        }
    }

    public static final class k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<T> f17446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f17447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile byte[] f17448c;

        public k(g<T> gVar, T t10) {
            this.f17446a = gVar;
            this.f17447b = t10;
        }

        public static <T> k<T> a(i<T> iVar, T t10) {
            g gVarB = b(iVar);
            gVarB.getClass();
            return new k<>(gVarB, t10);
        }

        @gm.j
        public static <T> g<T> b(i<T> iVar) {
            return (g) iVar.c(g.class);
        }

        public byte[] c() {
            if (this.f17448c == null) {
                synchronized (this) {
                    try {
                        if (this.f17448c == null) {
                            this.f17448c = v1.B(e());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return this.f17448c;
        }

        public <T2> T2 d(i<T2> iVar) {
            g gVarB;
            return (!iVar.l() || (gVarB = b(iVar)) == null) ? iVar.k(c()) : (T2) gVarB.b(e());
        }

        public InputStream e() {
            return (InputStream) c1.h0.F(this.f17446a.a(this.f17447b), "null marshaller.toStream()");
        }
    }

    @hm.b
    public interface m<T> {
        byte[] a(T t10);

        T b(byte[] bArr);
    }

    public v1(byte[]... bArr) {
        this(bArr.length / 2, (Object[]) bArr);
    }

    public static byte[] B(InputStream inputStream) {
        try {
            return l1.h.u(inputStream);
        } catch (IOException e10) {
            throw new RuntimeException("failure reading serialized stream", e10);
        }
    }

    public static boolean e(v1 v1Var, byte[] bArr, byte[] bArr2) {
        v1Var.getClass();
        return Arrays.equals(bArr, bArr2);
    }

    @gm.j
    public Object[] A() {
        Object[] objArr = new Object[this.f17431b * 2];
        for (int i10 = 0; i10 < this.f17431b; i10++) {
            int i11 = i10 * 2;
            objArr[i11] = v(i10);
            objArr[i11 + 1] = G(i10);
        }
        return objArr;
    }

    public final Object C(int i10) {
        return this.f17430a[(i10 * 2) + 1];
    }

    public final void D(int i10, Object obj) {
        if (this.f17430a instanceof byte[][]) {
            k(h());
        }
        this.f17430a[(i10 * 2) + 1] = obj;
    }

    public final void E(int i10, byte[] bArr) {
        this.f17430a[(i10 * 2) + 1] = bArr;
    }

    public final byte[] F(int i10) {
        Object objC = C(i10);
        return objC instanceof byte[] ? (byte[]) objC : ((k) objC).c();
    }

    public final Object G(int i10) {
        Object objC = C(i10);
        return objC instanceof byte[] ? objC : ((k) objC).e();
    }

    public final <T> T H(int i10, i<T> iVar) {
        Object objC = C(i10);
        return objC instanceof byte[] ? iVar.k((byte[]) objC) : (T) ((k) objC).d(iVar);
    }

    public final boolean g(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public final int h() {
        Object[] objArr = this.f17430a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public boolean i(i<?> iVar) {
        for (int i10 = 0; i10 < this.f17431b; i10++) {
            if (Arrays.equals(iVar.a(), v(i10))) {
                return true;
            }
        }
        return false;
    }

    @e0("https://github.com/grpc/grpc-java/issues/4691")
    public <T> void j(i<T> iVar) {
        if (o()) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = this.f17431b;
            if (i10 >= i12) {
                Arrays.fill(this.f17430a, i11 * 2, i12 * 2, (Object) null);
                this.f17431b = i11;
                return;
            } else {
                if (!Arrays.equals(iVar.a(), v(i10))) {
                    u(i11, v(i10));
                    D(i11, C(i10));
                    i11++;
                }
                i10++;
            }
        }
    }

    public final void k(int i10) {
        Object[] objArr = new Object[i10];
        if (!o()) {
            System.arraycopy(this.f17430a, 0, objArr, 0, this.f17431b * 2);
        }
        this.f17430a = objArr;
    }

    @gm.j
    public <T> T l(i<T> iVar) {
        for (int i10 = this.f17431b - 1; i10 >= 0; i10--) {
            if (Arrays.equals(iVar.a(), v(i10))) {
                return (T) H(i10, iVar);
            }
        }
        return null;
    }

    @gm.j
    public <T> Iterable<T> m(i<T> iVar) {
        for (int i10 = 0; i10 < this.f17431b; i10++) {
            if (Arrays.equals(iVar.a(), v(i10))) {
                return new h(iVar, i10);
            }
        }
        return null;
    }

    public int n() {
        return this.f17431b;
    }

    public final boolean o() {
        return this.f17431b == 0;
    }

    public Set<String> p() {
        if (o()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f17431b);
        for (int i10 = 0; i10 < this.f17431b; i10++) {
            hashSet.add(new String(v(i10), 0));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final int q() {
        return this.f17431b * 2;
    }

    public final void r() {
        int i10 = this.f17431b;
        if (i10 * 2 == 0 || i10 * 2 == h()) {
            k(Math.max(this.f17431b * 4, 8));
        }
    }

    public void s(v1 v1Var) {
        if (v1Var.o()) {
            return;
        }
        int iH = h() - (this.f17431b * 2);
        if (o() || iH < v1Var.f17431b * 2) {
            k((v1Var.f17431b * 2) + (this.f17431b * 2));
        }
        System.arraycopy(v1Var.f17430a, 0, this.f17430a, this.f17431b * 2, v1Var.f17431b * 2);
        this.f17431b += v1Var.f17431b;
    }

    public void t(v1 v1Var, Set<i<?>> set) {
        c1.h0.F(v1Var, "other");
        HashMap map = new HashMap(set.size());
        for (i<?> iVar : set) {
            map.put(ByteBuffer.wrap(iVar.a()), iVar);
        }
        for (int i10 = 0; i10 < v1Var.f17431b; i10++) {
            if (map.containsKey(ByteBuffer.wrap(v1Var.v(i10)))) {
                r();
                u(this.f17431b, v1Var.v(i10));
                D(this.f17431b, v1Var.C(i10));
                this.f17431b++;
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Metadata(");
        for (int i10 = 0; i10 < this.f17431b; i10++) {
            if (i10 != 0) {
                sb2.append(StringUtil.COMMA);
            }
            byte[] bArrV = v(i10);
            Charset charset = c1.f.f1177a;
            String str = new String(bArrV, charset);
            sb2.append(str);
            sb2.append(fl.h.f6043c);
            if (str.endsWith(f17425d)) {
                sb2.append(f17428g.l(F(i10)));
            } else {
                sb2.append(new String(F(i10), charset));
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public final void u(int i10, byte[] bArr) {
        this.f17430a[i10 * 2] = bArr;
    }

    public final byte[] v(int i10) {
        return (byte[]) this.f17430a[i10 * 2];
    }

    public <T> void w(i<T> iVar, T t10) {
        c1.h0.F(iVar, cb.b.c.f1408o);
        c1.h0.F(t10, "value");
        r();
        u(this.f17431b, iVar.a());
        if (iVar.l()) {
            D(this.f17431b, k.a(iVar, t10));
        } else {
            E(this.f17431b, iVar.m(t10));
        }
        this.f17431b++;
    }

    public <T> boolean x(i<T> iVar, T t10) {
        c1.h0.F(iVar, cb.b.c.f1408o);
        c1.h0.F(t10, "value");
        for (int i10 = 0; i10 < this.f17431b; i10++) {
            if (Arrays.equals(iVar.a(), v(i10)) && t10.equals(H(i10, iVar))) {
                int i11 = i10 * 2;
                int i12 = (i10 + 1) * 2;
                int i13 = (this.f17431b * 2) - i12;
                Object[] objArr = this.f17430a;
                System.arraycopy(objArr, i12, objArr, i11, i13);
                int i14 = this.f17431b - 1;
                this.f17431b = i14;
                u(i14, null);
                E(this.f17431b, null);
                return true;
            }
        }
        return false;
    }

    public <T> Iterable<T> y(i<T> iVar) {
        if (o()) {
            return null;
        }
        int i10 = 0;
        int i11 = 0;
        ArrayList arrayList = null;
        while (true) {
            int i12 = this.f17431b;
            if (i10 >= i12) {
                Arrays.fill(this.f17430a, i11 * 2, i12 * 2, (Object) null);
                this.f17431b = i11;
                return arrayList;
            }
            if (Arrays.equals(iVar.a(), v(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(H(i10, iVar));
            } else {
                u(i11, v(i10));
                D(i11, C(i10));
                i11++;
            }
            i10++;
        }
    }

    @gm.j
    public byte[][] z() {
        int i10 = this.f17431b;
        byte[][] bArr = new byte[i10 * 2][];
        Object[] objArr = this.f17430a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, i10 * 2);
        } else {
            for (int i11 = 0; i11 < this.f17431b; i11++) {
                int i12 = i11 * 2;
                bArr[i12] = v(i11);
                bArr[i12 + 1] = F(i11);
            }
        }
        return bArr;
    }

    public v1(int i10, byte[]... bArr) {
        this(i10, (Object[]) bArr);
    }

    public static class c<T> extends i<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d<T> f17432f;

        public c(String str, boolean z10, d<T> dVar) {
            super(str, z10, dVar);
            c1.h0.y(!str.endsWith(v1.f17425d), "ASCII header is named %s.  Only binary headers may end with %s", str, v1.f17425d);
            this.f17432f = (d) c1.h0.F(dVar, "marshaller");
        }

        @Override // vj.v1.i
        public T k(byte[] bArr) {
            return this.f17432f.b(new String(bArr, c1.f.f1177a));
        }

        @Override // vj.v1.i
        public byte[] m(T t10) {
            return ((String) c1.h0.F(this.f17432f.a(t10), "null marshaller.toAsciiString()")).getBytes(c1.f.f1177a);
        }

        public /* synthetic */ c(String str, boolean z10, d dVar, a aVar) {
            this(str, z10, dVar);
        }
    }

    public static final class l<T> extends i<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final m<T> f17449f;

        public l(String str, boolean z10, m<T> mVar) {
            super(str, z10, mVar);
            c1.h0.y(!str.endsWith(v1.f17425d), "ASCII header is named %s.  Only binary headers may end with %s", str, v1.f17425d);
            this.f17449f = (m) c1.h0.F(mVar, "marshaller");
        }

        @Override // vj.v1.i
        public T k(byte[] bArr) {
            return this.f17449f.b(bArr);
        }

        @Override // vj.v1.i
        public byte[] m(T t10) {
            return (byte[]) c1.h0.F(this.f17449f.a(t10), "null marshaller.toAsciiString()");
        }

        public /* synthetic */ l(String str, boolean z10, m mVar, a aVar) {
            this(str, z10, mVar);
        }
    }

    public v1(int i10, Object[] objArr) {
        this.f17431b = i10;
        this.f17430a = objArr;
    }

    public static class e<T> extends i<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final f<T> f17433f;

        public e(String str, f<T> fVar) {
            super(str, false, fVar);
            c1.h0.y(str.endsWith(v1.f17425d), "Binary header is named %s. It must end with %s", str, v1.f17425d);
            c1.h0.e(str.length() > 4, "empty key name");
            this.f17433f = (f) c1.h0.F(fVar, "marshaller is null");
        }

        @Override // vj.v1.i
        public T k(byte[] bArr) {
            return this.f17433f.b(bArr);
        }

        @Override // vj.v1.i
        public byte[] m(T t10) {
            return (byte[]) c1.h0.F(this.f17433f.a(t10), "null marshaller.toBytes()");
        }

        public /* synthetic */ e(String str, f fVar, a aVar) {
            this(str, fVar);
        }
    }

    public static class j<T> extends i<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final g<T> f17445f;

        public j(String str, g<T> gVar) {
            super(str, false, gVar);
            c1.h0.y(str.endsWith(v1.f17425d), "Binary header is named %s. It must end with %s", str, v1.f17425d);
            c1.h0.e(str.length() > 4, "empty key name");
            this.f17445f = (g) c1.h0.F(gVar, "marshaller is null");
        }

        @Override // vj.v1.i
        public T k(byte[] bArr) {
            return this.f17445f.b(new ByteArrayInputStream(bArr));
        }

        @Override // vj.v1.i
        public boolean l() {
            return true;
        }

        @Override // vj.v1.i
        public byte[] m(T t10) {
            return v1.B((InputStream) c1.h0.F(this.f17445f.a(t10), "null marshaller.toStream()"));
        }

        public /* synthetic */ j(String str, g gVar, a aVar) {
            this(str, gVar);
        }
    }

    public v1() {
    }
}
