package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(level = lm.m.WARNING, message = "AbstractInput is deprecated and will be merged with Input in 2.0.0", replaceWith = @lm.a1(expression = "Input", imports = {}))
public abstract class a implements g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final C0406a f15788d = new C0406a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final bm.h<ul.b> f15789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final tl.b f15790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15791c;

    /* JADX INFO: renamed from: tl.a$a, reason: collision with other inner class name */
    public static final class C0406a {
        public C0406a() {
        }

        public C0406a(kn.w wVar) {
        }
    }

    public static final class b extends ul.h {
        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
        }
    }

    public static final class c extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15792a;

        public c(int i10) {
            this.f15792a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("Negative discard is not allowed: ", Integer.valueOf(this.f15792a)));
        }
    }

    public static final class d implements Appendable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ char[] f15795c;

        public d(int i10, char[] cArr) {
            this.f15794b = i10;
            this.f15795c = cArr;
            this.f15793a = i10;
        }

        @Override // java.lang.Appendable
        @os.l
        public Appendable append(char c10) {
            char[] cArr = this.f15795c;
            int i10 = this.f15793a;
            this.f15793a = i10 + 1;
            cArr[i10] = c10;
            return this;
        }

        @Override // java.lang.Appendable
        @os.l
        public Appendable append(@os.m CharSequence charSequence) {
            if (charSequence instanceof String) {
                String str = (String) charSequence;
                c1.c(str, this.f15795c, this.f15793a);
                this.f15793a = str.length() + this.f15793a;
            } else if (charSequence != null) {
                int length = charSequence.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char[] cArr = this.f15795c;
                    int i11 = this.f15793a;
                    this.f15793a = i11 + 1;
                    cArr[i11] = charSequence.charAt(i10);
                }
            }
            return this;
        }

        @Override // java.lang.Appendable
        @os.l
        public Appendable append(@os.m CharSequence charSequence, int i10, int i11) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class e extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f15796a;

        public e(long j10) {
            this.f15796a = j10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("tailRemaining shouldn't be negative: ", Long.valueOf(this.f15796a)));
        }
    }

    public a() {
        this((ul.b) null, 0L, (bm.h) null, 7, (kn.w) null);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static /* synthetic */ void D1() {
    }

    private final void H2(ul.b bVar) {
        this.f15790b.f(bVar);
        this.f15790b.h(bVar.f15820a);
        tl.b bVar2 = this.f15790b;
        m mVar = bVar.f15821b;
        bVar2.f15800c = mVar.f15873b;
        bVar2.f15801d = mVar.f15874c;
    }

    @lm.z0
    public static /* synthetic */ void J0() {
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static /* synthetic */ void J1() {
    }

    @lm.z0
    public static /* synthetic */ void P0() {
    }

    private final ul.b U0() {
        return this.f15790b.f15798a;
    }

    @lm.k(level = lm.m.ERROR, message = "Not supported anymore. All operations are big endian by default.")
    public static /* synthetic */ void l0() {
    }

    @lm.z0
    public static /* synthetic */ void q0() {
    }

    public static /* synthetic */ int u2(a aVar, Appendable appendable, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        return aVar.s2(appendable, i10, i11);
    }

    @lm.z0
    public static /* synthetic */ void v0() {
    }

    public static /* synthetic */ String v2(a aVar, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
        }
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        return aVar.t2(i10, i11);
    }

    @lm.z0
    public static /* synthetic */ void y0() {
    }

    public final boolean A(long j10) {
        ul.b bVarE = n.e(this.f15790b.f15798a);
        tl.b bVar = this.f15790b;
        long j11 = ((long) (bVar.f15801d - bVar.f15800c)) + bVar.f15802e;
        do {
            ul.b bVarE0 = e0();
            if (bVarE0 == null) {
                this.f15791c = true;
                return false;
            }
            m mVar = bVarE0.f15821b;
            int i10 = mVar.f15874c - mVar.f15873b;
            if (bVarE == ul.b.f16311i.a()) {
                H2(bVarE0);
                bVarE = bVarE0;
            } else {
                bVarE.l2(bVarE0);
                G2(this.f15790b.f15802e + ((long) i10));
            }
            j11 += (long) i10;
        } while (j11 < j10);
        return true;
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final int A1(o0 o0Var) {
        kn.l0.p(o0Var, "buffer");
        ul.b bVarK2 = k2(1);
        if (bVarK2 == null) {
            return -1;
        }
        m mVar = o0Var.f15821b;
        int i10 = mVar.f15872a - mVar.f15874c;
        m mVar2 = bVarK2.f15821b;
        int iMin = Math.min(i10, mVar2.f15874c - mVar2.f15873b);
        l.w0(o0Var, bVarK2, iMin);
        return iMin;
    }

    @os.l
    public final ul.b A2(@os.l ul.b bVar) {
        kn.l0.p(bVar, "head");
        ul.b bVarY1 = bVar.Y1();
        if (bVarY1 == null) {
            bVarY1 = ul.b.f16311i.a();
        }
        H2(bVarY1);
        long j10 = this.f15790b.f15802e;
        m mVar = bVarY1.f15821b;
        G2(j10 - ((long) (mVar.f15874c - mVar.f15873b)));
        bVar.j2(this.f15789a);
        return bVarY1;
    }

    @lm.k(level = lm.m.ERROR, message = "Binary compatibility.")
    public final void B2(@os.l ul.b bVar) {
        kn.l0.p(bVar, "newHead");
        H2(bVar);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void C1(o0 o0Var, int i10) {
        g0.a.p(this, o0Var, i10);
    }

    public final void C2(int i10) {
        this.f15790b.f15801d = i10;
    }

    public final void D2(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "value");
        this.f15790b.h(byteBuffer);
    }

    @os.m
    @lm.z0
    public final ul.b E(@os.l ul.b bVar) {
        kn.l0.p(bVar, "current");
        return O(bVar, ul.b.f16311i.a());
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void E0(int[] iArr, int i10, int i11) {
        g0.a.t(this, iArr, i10, i11);
    }

    public final void E2(int i10) {
        this.f15790b.f15800c = i10;
    }

    public final int F0() {
        return this.f15790b.f15800c;
    }

    @Override // tl.g0
    public final int G() {
        ul.b bVarL2;
        ul.b bVarP0 = p0();
        tl.b bVar = this.f15790b;
        if (bVar.f15801d - bVar.f15800c > 0) {
            return bVarP0.T0();
        }
        if ((bVar.f15802e == 0 && this.f15791c) || (bVarL2 = l2(1, bVarP0)) == null) {
            return -1;
        }
        return bVarL2.T0();
    }

    public final void G2(long j10) {
        if (j10 >= 0) {
            this.f15790b.f15802e = j10;
        } else {
            new e(j10).a();
            throw new lm.y();
        }
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int H0(o0 o0Var, int i10) {
        return g0.a.e(this, o0Var, i10);
    }

    public final /* synthetic */ boolean I1() {
        return x0.f(this);
    }

    @os.m
    public final ul.b I2() {
        ul.b bVarP0 = p0();
        ul.b bVarF2 = bVarP0.f2();
        ul.b bVarA = ul.b.f16311i.a();
        if (bVarP0 == bVarA) {
            return null;
        }
        if (bVarF2 == null) {
            H2(bVarA);
            G2(0L);
        } else {
            H2(bVarF2);
            long j10 = this.f15790b.f15802e;
            m mVar = bVarF2.f15821b;
            G2(j10 - ((long) (mVar.f15874c - mVar.f15873b)));
        }
        bVarP0.l2(null);
        return bVarP0;
    }

    @os.m
    public final ul.b J2() {
        ul.b bVarP0 = p0();
        ul.b bVarA = ul.b.f16311i.a();
        if (bVarP0 == bVarA) {
            return null;
        }
        H2(bVarA);
        G2(0L);
        return bVarP0;
    }

    public final boolean K2(@os.l ul.b bVar) {
        kn.l0.p(bVar, "chain");
        ul.b bVarE = n.e(p0());
        m mVar = bVar.f15821b;
        int i10 = mVar.f15874c - mVar.f15873b;
        if (i10 == 0) {
            return false;
        }
        m mVar2 = bVarE.f15821b;
        if (mVar2.f15872a - mVar2.f15874c < i10) {
            return false;
        }
        f.a(bVarE, bVar, i10);
        if (p0() == bVarE) {
            this.f15790b.f15801d = bVarE.f15821b.f15874c;
            return true;
        }
        G2(this.f15790b.f15802e + ((long) i10));
        return true;
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int L0(ByteBuffer byteBuffer, int i10) {
        return g0.a.d(this, byteBuffer, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Not supported anymore.")
    /* JADX INFO: renamed from: L2, reason: merged with bridge method [inline-methods] */
    public final void F2(int i10) {
        tl.b bVar = this.f15790b;
        int i11 = bVar.f15801d - i10;
        if (i11 < 0) {
            throw new IllegalArgumentException("Unable to update position to negative. newRemaining is too big.");
        }
        bVar.f15800c = i11;
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void N0(short[] sArr, int i10, int i11) {
        g0.a.v(this, sArr, i10, i11);
    }

    public final ul.b O(ul.b bVar, ul.b bVar2) {
        while (bVar != bVar2) {
            ul.b bVarY1 = bVar.Y1();
            bVar.j2(this.f15789a);
            if (bVarY1 == null) {
                H2(bVar2);
                G2(0L);
                bVar = bVar2;
            } else {
                m mVar = bVarY1.f15821b;
                if (mVar.f15874c > mVar.f15873b) {
                    H2(bVarY1);
                    long j10 = this.f15790b.f15802e;
                    m mVar2 = bVarY1.f15821b;
                    G2(j10 - ((long) (mVar2.f15874c - mVar2.f15873b)));
                    return bVarY1;
                }
                bVar = bVarY1;
            }
        }
        return y();
    }

    public final int O0() {
        tl.b bVar = this.f15790b;
        return bVar.f15801d - bVar.f15800c;
    }

    @os.l
    public final bm.h<ul.b> Q0() {
        return this.f15789a;
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void R(long[] jArr, int i10, int i11) {
        g0.a.u(this, jArr, i10, i11);
    }

    public final long S0() {
        tl.b bVar = this.f15790b;
        return ((long) (bVar.f15801d - bVar.f15800c)) + bVar.f15802e;
    }

    public final void S1() {
        if (this.f15791c) {
            return;
        }
        this.f15791c = true;
    }

    public final long T0() {
        return this.f15790b.f15802e;
    }

    @Override // tl.g0
    public final long V0(@os.l ByteBuffer byteBuffer, long j10, long j11, long j12, long j13) {
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        g2(j12 + j11);
        ul.b bVarP0 = p0();
        long jMin = Math.min(j13, ((long) byteBuffer.limit()) - j10);
        long j14 = j10;
        ul.b bVarF2 = bVarP0;
        long j15 = 0;
        long j16 = j11;
        while (j15 < j12 && j15 < jMin) {
            m mVar = bVarF2.f15821b;
            long j17 = mVar.f15874c - mVar.f15873b;
            if (j17 > j16) {
                long jMin2 = Math.min(j17 - j16, jMin - j15);
                ql.f.e(bVarF2.f15820a, byteBuffer, ((long) bVarF2.f15821b.f15873b) + j16, jMin2, j14);
                j15 += jMin2;
                j14 += jMin2;
                j16 = 0;
            } else {
                j16 -= j17;
            }
            bVarF2 = bVarF2.f2();
            if (bVarF2 == null) {
                break;
            }
        }
        return j15;
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int W(int[] iArr, int i10, int i11) {
        return g0.a.i(this, iArr, i10, i11);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int W1(byte[] bArr, int i10, int i11) {
        return g0.a.f(this, bArr, i10, i11);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void X1(float[] fArr, int i10, int i11) {
        g0.a.s(this, fArr, i10, i11);
    }

    public final Void Y1(int i10, int i11) {
        throw new IllegalArgumentException(e0.a.a("min should be less or equal to max but min = ", i10, ", max = ", i11));
    }

    public final void b(ul.b bVar) {
        m mVar = bVar.f15821b;
        if (mVar.f15874c - mVar.f15873b == 0) {
            A2(bVar);
        }
    }

    @os.m
    @ul.d
    public final ul.b b0(@os.l ul.b bVar) {
        kn.l0.p(bVar, "current");
        return E(bVar);
    }

    public final Void b2(int i10) {
        throw new IllegalStateException(k.b.a("minSize of ", i10, " is too big (should be less than 8)"));
    }

    public final void c(@os.l ul.b bVar) {
        kn.l0.p(bVar, "chain");
        ul.b.e eVar = ul.b.f16311i;
        if (bVar == eVar.a()) {
            return;
        }
        long jO = n.o(bVar);
        if (this.f15790b.f15798a != eVar.a()) {
            n.e(this.f15790b.f15798a).l2(bVar);
            G2(this.f15790b.f15802e + jO);
        } else {
            H2(bVar);
            tl.b bVar2 = this.f15790b;
            G2(jO - ((long) (bVar2.f15801d - bVar2.f15800c)));
        }
    }

    public final boolean c1(int i10) {
        tl.b bVar = this.f15790b;
        return ((long) (bVar.f15801d - bVar.f15800c)) + bVar.f15802e >= ((long) i10);
    }

    @Override // tl.g0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        z2();
        if (!this.f15791c) {
            this.f15791c = true;
        }
        n();
    }

    public final void d(ul.b bVar) {
        ul.b bVarE = n.e(this.f15790b.f15798a);
        if (bVarE != ul.b.f16311i.a()) {
            bVarE.l2(bVar);
            G2(n.o(bVar) + this.f15790b.f15802e);
            return;
        }
        H2(bVar);
        if (!(this.f15790b.f15802e == 0)) {
            new b().a();
            throw new lm.y();
        }
        ul.b bVarF2 = bVar.f2();
        G2(bVarF2 != null ? n.o(bVarF2) : 0L);
    }

    @os.m
    public ul.b e0() {
        ul.b bVarW0 = this.f15789a.W0();
        try {
            bVarW0.p0(8);
            ByteBuffer byteBuffer = bVarW0.f15820a;
            m mVar = bVarW0.f15821b;
            int i10 = mVar.f15874c;
            int iF0 = f0(byteBuffer, i10, mVar.f15872a - i10);
            if (iF0 == 0) {
                this.f15791c = true;
                m mVar2 = bVarW0.f15821b;
                if (mVar2.f15874c <= mVar2.f15873b) {
                    bVarW0.j2(this.f15789a);
                    return null;
                }
            }
            bVarW0.b(iF0);
            return bVarW0;
        } catch (Throwable th2) {
            bVarW0.j2(this.f15789a);
            throw th2;
        }
    }

    public abstract int f0(@os.l ByteBuffer byteBuffer, int i10, int i11);

    public final Void f2(int i10) throws EOFException {
        throw new EOFException("Not enough data in packet (" + S0() + ") to read " + i10 + " byte(s)");
    }

    @Override // tl.g0
    public final void g(@os.l q qVar) {
        kn.l0.p(qVar, "newOrder");
        if (qVar != q.BIG_ENDIAN) {
            throw new IllegalArgumentException("Only BIG_ENDIAN is supported.");
        }
    }

    @ul.d
    public final void g0(@os.l ul.b bVar) {
        kn.l0.p(bVar, "current");
        ul.b bVarF2 = bVar.f2();
        if (bVarF2 == null) {
            j0(bVar);
            return;
        }
        m mVar = bVar.f15821b;
        int i10 = mVar.f15874c - mVar.f15873b;
        int iMin = Math.min(i10, 8 - (bVar.f15822c - mVar.f15872a));
        if (bVarF2.f15821b.f15875d < iMin) {
            j0(bVar);
            return;
        }
        i.i(bVarF2, iMin);
        if (i10 > iMin) {
            bVar.j0();
            int i11 = bVar.f15821b.f15874c;
            tl.b bVar2 = this.f15790b;
            bVar2.f15801d = i11;
            G2(bVar2.f15802e + ((long) iMin));
            return;
        }
        H2(bVarF2);
        long j10 = this.f15790b.f15802e;
        m mVar2 = bVarF2.f15821b;
        G2(j10 - ((long) ((mVar2.f15874c - mVar2.f15873b) - iMin)));
        bVar.Y1();
        bVar.j2(this.f15789a);
    }

    public final boolean g2(long j10) {
        if (j10 <= 0) {
            return true;
        }
        tl.b bVar = this.f15790b;
        long j11 = bVar.f15801d - bVar.f15800c;
        if (j11 >= j10 || j11 + bVar.f15802e >= j10) {
            return true;
        }
        return A(j10);
    }

    public final Void h(int i10) throws EOFException {
        throw new EOFException(k.b.a("at least ", i10, " characters required but no bytes available"));
    }

    public final Void h2(int i10, int i11) throws ul.f {
        throw new ul.f(e0.a.a("Premature end of stream: expected at least ", i10, " chars but had only ", i11));
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int i1(float[] fArr, int i10, int i11) {
        return g0.a.h(this, fArr, i10, i11);
    }

    @os.m
    @lm.z0
    public final ul.b i2(int i10) {
        ul.b bVarP0 = p0();
        tl.b bVar = this.f15790b;
        return bVar.f15801d - bVar.f15800c >= i10 ? bVarP0 : l2(i10, bVarP0);
    }

    @Override // tl.g0
    @os.l
    public final q j() {
        return q.BIG_ENDIAN;
    }

    public final void j0(ul.b bVar) {
        if (this.f15791c && bVar.f2() == null) {
            m mVar = bVar.f15821b;
            int i10 = mVar.f15873b;
            tl.b bVar2 = this.f15790b;
            bVar2.f15800c = i10;
            bVar2.f15801d = mVar.f15874c;
            G2(0L);
            return;
        }
        m mVar2 = bVar.f15821b;
        int i11 = mVar2.f15874c - mVar2.f15873b;
        int iMin = Math.min(i11, 8 - (bVar.f15822c - mVar2.f15872a));
        if (i11 > iMin) {
            k0(bVar, i11, iMin);
        } else {
            ul.b bVarW0 = this.f15789a.W0();
            bVarW0.p0(8);
            bVarW0.l2(bVar.Y1());
            f.a(bVarW0, bVar, i11);
            H2(bVarW0);
        }
        bVar.j2(this.f15789a);
    }

    @os.m
    @lm.z0
    public final ul.b j2(int i10, @os.l ul.b bVar) {
        kn.l0.p(bVar, "head");
        tl.b bVar2 = this.f15790b;
        return bVar2.f15801d - bVar2.f15800c >= i10 ? bVar : l2(i10, bVar);
    }

    public final boolean k() {
        tl.b bVar = this.f15790b;
        return (bVar.f15800c == bVar.f15801d && bVar.f15802e == 0) ? false : true;
    }

    public final void k0(ul.b bVar, int i10, int i11) {
        ul.b bVarW0 = this.f15789a.W0();
        ul.b bVarW1 = this.f15789a.W0();
        bVarW0.p0(8);
        bVarW1.p0(8);
        bVarW0.l2(bVarW1);
        bVarW1.l2(bVar.Y1());
        f.a(bVarW0, bVar, i10 - i11);
        f.a(bVarW1, bVar, i11);
        H2(bVarW0);
        G2(n.o(bVarW1));
    }

    @os.m
    @ul.d
    public final ul.b k2(int i10) {
        return l2(i10, p0());
    }

    public final ul.b l2(int i10, ul.b bVar) {
        while (true) {
            tl.b bVar2 = this.f15790b;
            int i11 = bVar2.f15801d - bVar2.f15800c;
            if (i11 >= i10) {
                return bVar;
            }
            ul.b bVarF2 = bVar.f2();
            if (bVarF2 == null && (bVarF2 = y()) == null) {
                return null;
            }
            if (i11 == 0) {
                if (bVar != ul.b.f16311i.a()) {
                    A2(bVar);
                }
                bVar = bVarF2;
            } else {
                int iA = f.a(bVar, bVarF2, i10 - i11);
                int i12 = bVar.f15821b.f15874c;
                tl.b bVar3 = this.f15790b;
                bVar3.f15801d = i12;
                G2(bVar3.f15802e - ((long) iA));
                m mVar = bVarF2.f15821b;
                if (mVar.f15874c > mVar.f15873b) {
                    bVarF2.q0(iA);
                } else {
                    bVar.l2(null);
                    bVar.l2(bVarF2.Y1());
                    bVarF2.j2(this.f15789a);
                }
                m mVar2 = bVar.f15821b;
                if (mVar2.f15874c - mVar2.f15873b >= i10) {
                    return bVar;
                }
                if (i10 > 8) {
                    b2(i10);
                    throw new lm.y();
                }
            }
        }
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void m0(double[] dArr, int i10, int i11) {
        g0.a.r(this, dArr, i10, i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public final void m2(int i10, jn.l<? super tl.e, l2> lVar) {
        kn.l0.p(lVar, "block");
        ul.b bVarI2 = i2(i10);
        if (bVarI2 == null) {
            throw pl.h.a(i10);
        }
        int i11 = bVarI2.f15821b.f15873b;
        try {
            lVar.invoke(bVarI2);
            m mVar = bVarI2.f15821b;
            int i12 = mVar.f15873b;
            if (i12 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i12 == mVar.f15874c) {
                E(bVarI2);
            } else {
                this.f15790b.f15800c = i12;
            }
        } catch (Throwable th2) {
            int i13 = bVarI2.f15821b.f15873b;
            if (i13 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i13 == bVarI2.f15821b.f15874c) {
                E(bVarI2);
            } else {
                this.f15790b.f15800c = i13;
            }
            throw th2;
        }
    }

    public abstract void n();

    @Override // tl.g0
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public final boolean B1() {
        tl.b bVar = this.f15790b;
        return bVar.f15801d - bVar.f15800c == 0 && bVar.f15802e == 0 && (this.f15791c || y() == null);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public final void n2(jn.l<? super tl.e, l2> lVar) {
        kn.l0.p(lVar, "block");
        ul.b bVarI2 = i2(1);
        if (bVarI2 == null) {
            throw pl.h.a(1);
        }
        int i10 = bVarI2.f15821b.f15873b;
        try {
            lVar.invoke(bVarI2);
            m mVar = bVarI2.f15821b;
            int i11 = mVar.f15873b;
            if (i11 < i10) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i11 == mVar.f15874c) {
                E(bVarI2);
            } else {
                this.f15790b.f15800c = i11;
            }
        } catch (Throwable th2) {
            int i12 = bVarI2.f15821b.f15873b;
            if (i12 < i10) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i12 == bVarI2.f15821b.f15874c) {
                E(bVarI2);
            } else {
                this.f15790b.f15800c = i12;
            }
            throw th2;
        }
    }

    public final int o(int i10) {
        if (i10 >= 0) {
            return p(i10, 0);
        }
        new c(i10).a();
        throw new lm.y();
    }

    public final int o2(Appendable appendable, int i10, int i11) throws Throwable {
        int i12;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = false;
        if (i11 == 0 && i10 == 0) {
            return 0;
        }
        if (B1()) {
            if (i10 == 0) {
                return 0;
            }
            h(i10);
            throw new lm.y();
        }
        if (i11 < i10) {
            Y1(i10, i11);
            throw new lm.y();
        }
        ul.b bVarJ = ul.k.j(this, 1);
        if (bVarJ == null) {
            i12 = 0;
        } else {
            i12 = 0;
            boolean z15 = false;
            do {
                try {
                    ByteBuffer byteBuffer = bVarJ.f15820a;
                    m mVar = bVarJ.f15821b;
                    int i13 = mVar.f15873b;
                    int i14 = mVar.f15874c;
                    int i15 = i13;
                    while (true) {
                        if (i15 >= i14) {
                            bVarJ.h(i14 - i13);
                            z11 = true;
                            break;
                        }
                        int i16 = i15 + 1;
                        byte b10 = byteBuffer.get(i15);
                        int i17 = b10 & 255;
                        if ((b10 & 128) != 128) {
                            char c10 = (char) i17;
                            if (i12 == i11) {
                                z13 = false;
                            } else {
                                appendable.append(c10);
                                i12++;
                                z13 = true;
                            }
                            if (z13) {
                                i15 = i16;
                            }
                        }
                        bVarJ.h(i15 - i13);
                        z11 = false;
                        break;
                    }
                    if (z11) {
                        z12 = true;
                    } else {
                        if (i12 != i11) {
                            z15 = true;
                        }
                        z12 = false;
                    }
                    if (!z12) {
                        ul.k.e(this, bVarJ);
                        break;
                    }
                    try {
                        bVarJ = ul.k.m(this, bVarJ);
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = false;
                        if (z10) {
                            ul.k.e(this, bVarJ);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z10 = true;
                }
            } while (bVarJ != null);
            z14 = z15;
        }
        if (z14) {
            return y2(appendable, i10 - i12, i11 - i12) + i12;
        }
        if (i12 >= i10) {
            return i12;
        }
        h2(i10, i12);
        throw new lm.y();
    }

    public final int p(int i10, int i11) {
        while (i10 != 0) {
            ul.b bVarI2 = i2(1);
            if (bVarI2 == null) {
                return i11;
            }
            m mVar = bVarI2.f15821b;
            int iMin = Math.min(mVar.f15874c - mVar.f15873b, i10);
            bVarI2.h(iMin);
            this.f15790b.f15800c += iMin;
            b(bVarI2);
            i10 -= iMin;
            i11 += iMin;
        }
        return i11;
    }

    @os.l
    public final ul.b p0() {
        tl.b bVar = this.f15790b;
        ul.b bVar2 = bVar.f15798a;
        bVar2.n(bVar.f15800c);
        return bVar2;
    }

    public final int p2(byte[] bArr, int i10, int i11, int i12) {
        while (i11 != 0) {
            ul.b bVarI2 = i2(1);
            if (bVarI2 == null) {
                return i12;
            }
            m mVar = bVarI2.f15821b;
            int iMin = Math.min(i11, mVar.f15874c - mVar.f15873b);
            l.F(bVarI2, bArr, i10, iMin);
            m mVar2 = bVarI2.f15821b;
            int i13 = mVar2.f15873b;
            this.f15790b.f15800c = i13;
            if (iMin == i11 && mVar2.f15874c - i13 != 0) {
                return i12 + iMin;
            }
            b(bVarI2);
            i10 += iMin;
            i11 -= iMin;
            i12 += iMin;
        }
        return i12;
    }

    public final long q(long j10, long j11) {
        ul.b bVarI2;
        while (j10 != 0 && (bVarI2 = i2(1)) != null) {
            m mVar = bVarI2.f15821b;
            int iMin = (int) Math.min(mVar.f15874c - mVar.f15873b, j10);
            bVarI2.h(iMin);
            this.f15790b.f15800c += iMin;
            b(bVarI2);
            long j12 = iMin;
            j10 -= j12;
            j11 += j12;
        }
        return j11;
    }

    public final int q2(@os.l char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, RtspHeaders.Values.DESTINATION);
        if (B1()) {
            return -1;
        }
        return s2(new d(i10, cArr), 0, i11);
    }

    public final byte r2() throws EOFException {
        tl.b bVar = this.f15790b;
        int i10 = bVar.f15800c;
        if (i10 >= bVar.f15801d) {
            ul.b bVarI2 = i2(1);
            if (bVarI2 == null) {
                throw pl.h.a(1);
            }
            byte b10 = bVarI2.readByte();
            ul.k.e(this, bVarI2);
            return b10;
        }
        byte b11 = bVar.f15799b.get(i10);
        tl.b bVar2 = this.f15790b;
        bVar2.f15800c = i10;
        ul.b bVar3 = bVar2.f15798a;
        bVar3.n(i10);
        E(bVar3);
        return b11;
    }

    @Override // tl.g0
    public final byte readByte() {
        tl.b bVar = this.f15790b;
        int i10 = bVar.f15800c;
        int i11 = i10 + 1;
        if (i11 >= bVar.f15801d) {
            return r2();
        }
        bVar.f15800c = i11;
        return bVar.f15799b.get(i10);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ double readDouble() {
        return m0.a(this);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ float readFloat() {
        return m0.c(this);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void readFully(byte[] bArr, int i10, int i11) throws EOFException {
        kn.l0.p(bArr, "dst");
        int iB = i0.b(this, bArr, i10, i11);
        if (iB == i11) {
            return;
        }
        throw new EOFException("Not enough data in packet to fill buffer: " + (i11 - iB) + " more bytes required");
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ int readInt() {
        return m0.e(this);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ long readLong() {
        return m0.g(this);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ short readShort() {
        return m0.k(this);
    }

    public final int s2(@os.l Appendable appendable, int i10, int i11) throws IOException {
        kn.l0.p(appendable, "out");
        if (i11 < S0()) {
            return o2(appendable, i10, i11);
        }
        String strZ = d1.z(this, (int) S0(), null, 2, null);
        appendable.append(strZ);
        return strZ.length();
    }

    public final void t(int i10) throws EOFException {
        if (o(i10) != i10) {
            throw new EOFException(k.b.a("Unable to discard ", i10, " bytes due to end of packet"));
        }
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int t0(long[] jArr, int i10, int i11) {
        return g0.a.j(this, jArr, i10, i11);
    }

    @Override // tl.g0
    public final long t1(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        return q(j10, 0L);
    }

    @os.l
    public final String t2(int i10, int i11) throws Throwable {
        if (i10 == 0 && (i11 == 0 || B1())) {
            return "";
        }
        long jS0 = S0();
        if (jS0 > 0 && i11 >= jS0) {
            return d1.z(this, (int) jS0, null, 2, null);
        }
        int i12 = i10 >= 16 ? i10 : 16;
        if (i12 > i11) {
            i12 = i11;
        }
        StringBuilder sb2 = new StringBuilder(i12);
        o2(sb2, i10, i11);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public final int u0() {
        return this.f15790b.f15801d;
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int v(double[] dArr, int i10, int i11) {
        return g0.a.g(this, dArr, i10, i11);
    }

    @os.l
    public final ByteBuffer w0() {
        return this.f15790b.f15799b;
    }

    @os.l
    public final String w2(int i10) {
        return t2(i10, i10);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void x0(ByteBuffer byteBuffer, int i10) {
        g0.a.o(this, byteBuffer, i10);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int x1(short[] sArr, int i10, int i11) {
        return g0.a.k(this, sArr, i10, i11);
    }

    public final void x2(@os.l Appendable appendable, int i10) throws IOException {
        kn.l0.p(appendable, "out");
        s2(appendable, i10, i10);
    }

    public final ul.b y() {
        if (this.f15791c) {
            return null;
        }
        ul.b bVarE0 = e0();
        if (bVarE0 == null) {
            this.f15791c = true;
            return null;
        }
        d(bVarE0);
        return bVarE0;
    }

    public final int y2(Appendable appendable, int i10, int i11) throws Throwable {
        int i12;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        ul.b bVarM;
        int i13;
        int i14 = 1;
        ul.b bVarJ = ul.k.j(this, 1);
        if (bVarJ == null) {
            i13 = 0;
        } else {
            int i15 = 1;
            int i16 = 0;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i17 = mVar.f15874c;
                    int i18 = mVar.f15873b;
                    int i19 = i17 - i18;
                    if (i19 >= i15) {
                        try {
                            ByteBuffer byteBuffer = bVarJ.f15820a;
                            int i20 = i18;
                            int i21 = 0;
                            int i22 = 0;
                            int i23 = 0;
                            while (true) {
                                if (i20 < i17) {
                                    i20++;
                                    byte b10 = byteBuffer.get(i20);
                                    int i24 = b10 & 255;
                                    byteBuffer = byteBuffer;
                                    i12 = -1;
                                    if ((b10 & 128) == 0) {
                                        if (i21 != 0) {
                                            ul.j.o(i21);
                                            throw new lm.y();
                                        }
                                        char c10 = (char) i24;
                                        if (i16 == i11) {
                                            z10 = false;
                                        } else {
                                            appendable.append(c10);
                                            i16++;
                                            z10 = true;
                                        }
                                        if (!z10) {
                                            try {
                                                bVarJ.h(i20 - i18);
                                                i14 = 1;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                i14 = 1;
                                                m mVar2 = bVarJ.f15821b;
                                                int i25 = mVar2.f15874c;
                                                int i26 = mVar2.f15873b;
                                                throw th;
                                            }
                                        }
                                        i14 = 1;
                                        th = th2;
                                        i14 = 1;
                                        m mVar3 = bVarJ.f15821b;
                                        int i27 = mVar3.f15874c;
                                        int i28 = mVar3.f15873b;
                                        throw th;
                                    }
                                    if (i21 == 0) {
                                        int i29 = 128;
                                        i22 = i24;
                                        i23 = i21;
                                        int i30 = 1;
                                        while (i30 < 7) {
                                            i30++;
                                            if ((i22 & i29) == 0) {
                                                break;
                                            }
                                            i22 &= ~i29;
                                            i29 >>= 1;
                                            i23++;
                                        }
                                        i21 = i23 - 1;
                                        if (i23 > i17 - i20) {
                                            bVarJ.h(i20 - i18);
                                            i12 = i23;
                                            i14 = 1;
                                        }
                                        i14 = 1;
                                    } else {
                                        i22 = (i22 << 6) | (b10 & 127);
                                        i21--;
                                        if (i21 == 0) {
                                            if (!ul.j.l(i22)) {
                                                if (!ul.j.m(i22)) {
                                                    i14 = 1;
                                                    ul.j.p(i22);
                                                    throw new lm.y();
                                                }
                                                char cK = (char) ul.j.k(i22);
                                                if (i16 == i11) {
                                                    z11 = false;
                                                } else {
                                                    appendable.append(cK);
                                                    i16++;
                                                    z11 = true;
                                                }
                                                if (z11) {
                                                    char cN = (char) ul.j.n(i22);
                                                    if (i16 == i11) {
                                                        z12 = false;
                                                    } else {
                                                        appendable.append(cN);
                                                        i16++;
                                                        z12 = true;
                                                    }
                                                    if (!z12) {
                                                    }
                                                }
                                                i14 = 1;
                                                bVarJ.h(((i20 - i18) - i23) + 1);
                                                m mVar4 = bVarJ.f15821b;
                                                int i210 = mVar4.f15874c;
                                                int i211 = mVar4.f15873b;
                                                throw th;
                                            }
                                            char c11 = (char) i22;
                                            if (i16 == i11) {
                                                z13 = false;
                                            } else {
                                                appendable.append(c11);
                                                i16++;
                                                z13 = true;
                                            }
                                            if (!z13) {
                                                bVarJ.h(((i20 - i18) - i23) + 1);
                                                i14 = 1;
                                            }
                                            i14 = 1;
                                            i22 = 0;
                                        } else {
                                            i14 = 1;
                                        }
                                    }
                                } else {
                                    bVarJ.h(i17 - i18);
                                    i12 = 0;
                                }
                                if (i12 == 0) {
                                    i15 = i14;
                                } else {
                                    i15 = i12 > 0 ? i12 : 0;
                                }
                                m mVar5 = bVarJ.f15821b;
                                i19 = mVar5.f15874c - mVar5.f15873b;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    if (i19 == 0) {
                        try {
                            bVarM = ul.k.m(this, bVarJ);
                        } catch (Throwable th4) {
                            th = th4;
                            i14 = 0;
                            if (i14 != 0) {
                                ul.k.e(this, bVarJ);
                            }
                            throw th;
                        }
                    } else if (i19 < i15 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(this, bVarJ);
                        bVarM = ul.k.j(this, i15);
                    } else {
                        bVarM = bVarJ;
                    }
                    if (bVarM == null) {
                        i14 = 0;
                        break;
                    }
                    bVarJ = bVarM;
                } catch (Throwable th5) {
                    th = th5;
                }
            } while (i15 > 0);
            if (i14 != 0) {
                ul.k.e(this, bVarJ);
            }
            i13 = i16;
        }
        if (i13 >= i10) {
            return i13;
        }
        h2(i10, i13);
        throw new lm.y();
    }

    public final void z2() {
        ul.b bVarP0 = p0();
        ul.b bVarA = ul.b.f16311i.a();
        if (bVarP0 != bVarA) {
            H2(bVarA);
            G2(0L);
            n.k(bVarP0, this.f15789a);
        }
    }

    public a(@os.l ul.b bVar, long j10, @os.l bm.h<ul.b> hVar) {
        kn.l0.p(bVar, "head");
        kn.l0.p(hVar, "pool");
        this.f15789a = hVar;
        this.f15790b = new tl.b(bVar, j10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(ul.b bVar, long j10, bm.h hVar, int i10, kn.w wVar) {
        bVar = (i10 & 1) != 0 ? ul.b.f16311i.a() : bVar;
        j10 = (i10 & 2) != 0 ? n.o(bVar) : j10;
        if ((i10 & 4) != 0) {
            ul.b.f16311i.getClass();
            hVar = ul.b.f16315w;
        }
        this(bVar, j10, (bm.h<ul.b>) hVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(o0 o0Var, long j10, bm.h hVar, int i10, kn.w wVar) {
        if ((i10 & 1) != 0) {
            o0.H.getClass();
            o0Var = o0.L;
        }
        j10 = (i10 & 2) != 0 ? n.o(o0Var) : j10;
        if ((i10 & 4) != 0) {
            ul.b.f16311i.getClass();
            hVar = ul.b.f16315w;
        }
        this(o0Var, j10, hVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ a(o0 o0Var, long j10, bm.h hVar) {
        this((ul.b) o0Var, j10, (bm.h<ul.b>) hVar);
        kn.l0.p(o0Var, "head");
        kn.l0.p(hVar, "pool");
    }
}
