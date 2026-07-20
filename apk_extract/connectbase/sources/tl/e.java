package tl;

import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@ul.d
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f15818d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f15819e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ByteBuffer f15820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final m f15821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15822c;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ void b() {
        }

        @ul.d
        public static /* synthetic */ void c() {
        }

        @os.l
        public final e a() {
            o0.H.getClass();
            return o0.L;
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15823a;

        public b(int i10) {
            this.f15823a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("newReadPosition shouldn't be negative: ", Integer.valueOf(this.f15823a)));
        }
    }

    public static final class c extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f15825b;

        public c(int i10, e eVar) {
            this.f15824a = i10;
            this.f15825b = eVar;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("newReadPosition shouldn't be ahead of the read position: " + this.f15824a + " > " + this.f15825b.f15821b.f15873b);
        }
    }

    public static final class d extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15826a;

        public d(int i10) {
            this.f15826a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("endGap shouldn't be negative: ", Integer.valueOf(this.f15826a)));
        }
    }

    /* JADX INFO: renamed from: tl.e$e, reason: collision with other inner class name */
    public static final class C0407e extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15827a;

        public C0407e(int i10) {
            this.f15827a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("startGap shouldn't be negative: ", Integer.valueOf(this.f15827a)));
        }
    }

    public /* synthetic */ e(ByteBuffer byteBuffer, kn.w wVar) {
        this(byteBuffer);
    }

    public static void F0(e eVar, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rewind");
        }
        if ((i11 & 1) != 0) {
            m mVar = eVar.f15821b;
            i10 = mVar.f15873b - mVar.f15875d;
        }
        eVar.y0(i10);
    }

    public static void k(e eVar, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: discardExact");
        }
        if ((i11 & 1) != 0) {
            m mVar = eVar.f15821b;
            i10 = mVar.f15874c - mVar.f15873b;
        }
        eVar.h(i10);
    }

    @lm.k(message = "Will be removed. Inherit Buffer and add required fields instead.")
    @f0
    public static /* synthetic */ void t() {
    }

    public final int A() {
        return this.f15821b.f15872a;
    }

    @os.l
    public final ByteBuffer E() {
        return this.f15820a;
    }

    public final void J0(@os.m Object obj) {
        this.f15821b.f15876e = obj;
    }

    public final int O() {
        return this.f15821b.f15873b;
    }

    public final void O0(int i10) {
        this.f15821b.f15872a = i10;
    }

    public final void P0(int i10) {
        this.f15821b.f15873b = i10;
    }

    public final void Q0(int i10) {
        this.f15821b.f15875d = i10;
    }

    public final int Q1() {
        return this.f15822c;
    }

    public final void S0(int i10) {
        this.f15821b.f15874c = i10;
    }

    public final int T0() {
        m mVar = this.f15821b;
        int i10 = mVar.f15873b;
        if (i10 == mVar.f15874c) {
            return -1;
        }
        return this.f15820a.get(i10) & 255;
    }

    public final int U0() {
        m mVar = this.f15821b;
        int i10 = mVar.f15873b;
        if (i10 == mVar.f15874c) {
            return -1;
        }
        mVar.f15873b = i10 + 1;
        return this.f15820a.get(i10) & 255;
    }

    @ul.d
    public final void b(int i10) {
        m mVar = this.f15821b;
        int i11 = mVar.f15874c;
        int i12 = i11 + i10;
        if (i10 < 0 || i12 > mVar.f15872a) {
            i.c(i10, mVar.f15872a - i11);
            throw new lm.y();
        }
        mVar.f15874c = i12;
    }

    public final int b0() {
        m mVar = this.f15821b;
        return mVar.f15874c - mVar.f15873b;
    }

    @lm.z0
    public final boolean c(int i10) {
        m mVar = this.f15821b;
        int i11 = mVar.f15872a;
        int i12 = mVar.f15874c;
        if (i10 < i12) {
            i.c(i10 - i12, i11 - i12);
            throw new lm.y();
        }
        if (i10 < i11) {
            mVar.f15874c = i10;
            return true;
        }
        if (i10 == i11) {
            mVar.f15874c = i10;
            return false;
        }
        i.c(i10 - i12, i11 - i12);
        throw new lm.y();
    }

    @lm.k(level = lm.m.ERROR, message = "Use discardExact instead.")
    public final int d(int i10) {
        m mVar = this.f15821b;
        int iMin = Math.min(i10, mVar.f15874c - mVar.f15873b);
        h(iMin);
        return iMin;
    }

    public final void d1(byte b10) throws n0 {
        m mVar = this.f15821b;
        int i10 = mVar.f15874c;
        if (i10 == mVar.f15872a) {
            throw new n0("No free space in the buffer to write a byte");
        }
        this.f15820a.put(i10, b10);
        this.f15821b.f15874c = i10 + 1;
    }

    public final int e0() {
        return this.f15821b.f15875d;
    }

    public final int f0() {
        return this.f15821b.f15874c;
    }

    public final int g0() {
        m mVar = this.f15821b;
        return mVar.f15872a - mVar.f15874c;
    }

    public final void h(int i10) {
        if (i10 == 0) {
            return;
        }
        m mVar = this.f15821b;
        int i11 = mVar.f15873b;
        int i12 = i11 + i10;
        if (i10 < 0 || i12 > mVar.f15874c) {
            i.d(i10, mVar.f15874c - i11);
            throw new lm.y();
        }
        mVar.f15873b = i12;
    }

    public final void j0() {
        this.f15821b.f15872a = this.f15822c;
    }

    public final void k0() {
        l0(0);
        j0();
    }

    public final void l0(int i10) {
        if (!(i10 >= 0)) {
            new b(i10).a();
            throw new lm.y();
        }
        m mVar = this.f15821b;
        if (!(i10 <= mVar.f15873b)) {
            new c(i10, this).a();
            throw new lm.y();
        }
        mVar.f15873b = i10;
        if (mVar.f15875d > i10) {
            mVar.f15875d = i10;
        }
    }

    public final void n(int i10) {
        if (i10 >= 0) {
            m mVar = this.f15821b;
            if (i10 <= mVar.f15874c) {
                if (mVar.f15873b != i10) {
                    mVar.f15873b = i10;
                    return;
                }
                return;
            }
        }
        m mVar2 = this.f15821b;
        int i11 = mVar2.f15873b;
        i.d(i10 - i11, mVar2.f15874c - i11);
        throw new lm.y();
    }

    @os.l
    public e o() {
        e eVar = new e(this.f15820a);
        eVar.p(eVar);
        return eVar;
    }

    public void p(@os.l e eVar) {
        kn.l0.p(eVar, "copy");
        m mVar = this.f15821b;
        int i10 = mVar.f15872a;
        m mVar2 = eVar.f15821b;
        mVar2.f15872a = i10;
        mVar2.f15875d = mVar.f15875d;
        mVar2.f15873b = mVar.f15873b;
        mVar2.f15874c = mVar.f15874c;
    }

    public final void p0(int i10) {
        if (!(i10 >= 0)) {
            new d(i10).a();
            throw new lm.y();
        }
        int i11 = this.f15822c - i10;
        m mVar = this.f15821b;
        if (i11 >= mVar.f15874c) {
            mVar.f15872a = i11;
            return;
        }
        if (i11 < 0) {
            i.e(this, i10);
        }
        if (i11 < this.f15821b.f15875d) {
            i.g(this, i10);
        }
        m mVar2 = this.f15821b;
        if (mVar2.f15873b != mVar2.f15874c) {
            i.f(this, i10);
            return;
        }
        mVar2.f15872a = i11;
        mVar2.f15873b = i11;
        mVar2.f15874c = i11;
    }

    @os.m
    public final Object q() {
        return this.f15821b.f15876e;
    }

    public final void q0(int i10) {
        if (!(i10 >= 0)) {
            new C0407e(i10).a();
            throw new lm.y();
        }
        m mVar = this.f15821b;
        int i11 = mVar.f15873b;
        if (i11 >= i10) {
            mVar.f15875d = i10;
            return;
        }
        if (i11 != mVar.f15874c) {
            i.k(this, i10);
            throw new lm.y();
        }
        if (i10 > mVar.f15872a) {
            i.l(this, i10);
            throw new lm.y();
        }
        mVar.f15874c = i10;
        mVar.f15873b = i10;
        mVar.f15875d = i10;
    }

    public final byte readByte() throws EOFException {
        m mVar = this.f15821b;
        int i10 = mVar.f15873b;
        if (i10 == mVar.f15874c) {
            throw new EOFException("No readable bytes available.");
        }
        mVar.f15873b = i10 + 1;
        return this.f15820a.get(i10);
    }

    public void reset() {
        k0();
        v0();
    }

    @lm.k(level = lm.m.ERROR, message = "Use discardExact instead.")
    public final long t1(long j10) {
        m mVar = this.f15821b;
        int iMin = (int) Math.min(j10, mVar.f15874c - mVar.f15873b);
        h(iMin);
        return iMin;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Buffer(");
        m mVar = this.f15821b;
        sb2.append(mVar.f15874c - mVar.f15873b);
        sb2.append(" used, ");
        m mVar2 = this.f15821b;
        sb2.append(mVar2.f15872a - mVar2.f15874c);
        sb2.append(" free, ");
        m mVar3 = this.f15821b;
        sb2.append((this.f15822c - mVar3.f15872a) + mVar3.f15875d);
        sb2.append(" reserved of ");
        return u.a.a(sb2, this.f15822c, ')');
    }

    public final void u0() {
        m mVar = this.f15821b;
        mVar.f15875d = 0;
        mVar.f15873b = 0;
        mVar.f15874c = this.f15822c;
    }

    public final void v0() {
        w0(this.f15822c - this.f15821b.f15875d);
    }

    public final void w0(int i10) {
        m mVar = this.f15821b;
        int i11 = mVar.f15875d;
        mVar.f15873b = i11;
        mVar.f15874c = i11;
        mVar.f15872a = i10;
    }

    public final int y() {
        return this.f15822c - this.f15821b.f15872a;
    }

    public final void y0(int i10) {
        m mVar = this.f15821b;
        int i11 = mVar.f15873b;
        int i12 = i11 - i10;
        int i13 = mVar.f15875d;
        if (i12 >= i13) {
            mVar.f15873b = i12;
        } else {
            i.j(i10, i11 - i13);
            throw new lm.y();
        }
    }

    public e(ByteBuffer byteBuffer) {
        this.f15820a = byteBuffer;
        this.f15821b = new m(byteBuffer.limit());
        this.f15822c = byteBuffer.limit();
    }
}
