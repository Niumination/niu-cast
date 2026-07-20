package tl;

import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(level = lm.m.WARNING, message = "AbstractOutput is deprecated and will be merged with Input in 2.0.0", replaceWith = @lm.a1(expression = "Output", imports = {}))
@f0
public abstract class c implements Appendable, q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final bm.h<ul.b> f15806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final d f15807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public q f15808d;

    public c(int i10, @os.l bm.h<ul.b> hVar) {
        kn.l0.p(hVar, "pool");
        this.f15805a = i10;
        this.f15806b = hVar;
        this.f15807c = new d();
        this.f15808d = q.BIG_ENDIAN;
    }

    @lm.k(level = lm.m.ERROR, message = "This is no longer supported. All operations are big endian by default. Use readXXXLittleEndian to read primitives in little endian")
    public static /* synthetic */ void f0() {
    }

    @lm.k(level = lm.m.ERROR, message = "Will be removed. Override flush(buffer) properly.")
    public static /* synthetic */ void k0() {
    }

    @lm.k(level = lm.m.HIDDEN, message = "Will be removed in future releases.")
    @lm.z0
    public static /* synthetic */ void u0() {
    }

    public final ul.b A() {
        ul.b bVarW0 = this.f15806b.W0();
        bVarW0.p0(8);
        E(bVarW0);
        return bVarW0;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void B(ByteBuffer byteBuffer) {
        q0.a.e(this, byteBuffer);
    }

    public final void B1(int i10) {
        this.f15807c.f15815g = i10;
    }

    public final void D1(@os.l ul.b bVar) {
        kn.l0.p(bVar, "newValue");
        o(bVar);
    }

    public final void E(@os.l ul.b bVar) {
        kn.l0.p(bVar, "buffer");
        if (bVar.f2() != null) {
            throw new IllegalStateException("It should be a single buffer chunk.");
        }
        p(bVar, bVar, 0);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void F(long[] jArr, int i10, int i11) {
        q0.a.k(this, jArr, i10, i11);
    }

    public final int F0() {
        return this.f15807c.f15812d;
    }

    public final void I1(int i10) {
        this.f15807c.f15813e = i10;
    }

    public final int J0() {
        d dVar = this.f15807c;
        return dVar.f15813e - dVar.f15812d;
    }

    public final void J1(int i10) {
        this.f15807c.f15814f = i10;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void M0(short s10) {
        q0.a.o(this, s10);
    }

    public abstract void O();

    public final ul.b O0() {
        return this.f15807c.f15809a;
    }

    public final int P0() {
        d dVar = this.f15807c;
        return (dVar.f15812d - dVar.f15814f) + dVar.f15815g;
    }

    public final ul.b Q0() {
        return this.f15807c.f15810b;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void R0(byte[] bArr, int i10, int i11) {
        q0.a.g(this, bArr, i10, i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void S0(o0 o0Var) {
        kn.l0.p(o0Var, "buffer");
        E(o0Var);
    }

    public final void S1(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "value");
        this.f15807c.m(byteBuffer);
    }

    @ul.d
    @os.l
    public final ul.b T0(int i10) {
        ul.b bVar;
        d dVar = this.f15807c;
        int i11 = dVar.f15813e;
        int i12 = dVar.f15812d;
        if (i11 - i12 < i10 || (bVar = dVar.f15810b) == null) {
            return A();
        }
        bVar.c(i12);
        return bVar;
    }

    public final int U0(e eVar, int i10) throws n0 {
        if (1 <= i10 && i10 < 128) {
            eVar.d1((byte) i10);
            return 1;
        }
        if (i10 <= 2047) {
            ByteBuffer byteBuffer = eVar.f15820a;
            m mVar = eVar.f15821b;
            int i11 = mVar.f15874c;
            int i12 = mVar.f15872a - i11;
            if (i12 < 2) {
                throw new n0("2 bytes character", 2, i12);
            }
            byteBuffer.put(i11, (byte) (((i10 >> 6) & 31) | 192));
            byteBuffer.put(i11 + 1, (byte) (128 | (i10 & 63)));
            eVar.b(2);
            return 2;
        }
        ByteBuffer byteBuffer2 = eVar.f15820a;
        m mVar2 = eVar.f15821b;
        int i13 = mVar2.f15874c;
        int i14 = mVar2.f15872a - i13;
        if (i14 < 3) {
            throw new n0("3 bytes character", 3, i14);
        }
        byteBuffer2.put(i13, (byte) (((i10 >> 12) & 15) | 224));
        byteBuffer2.put(i13 + 1, (byte) (((i10 >> 6) & 63) | 128));
        byteBuffer2.put(i13 + 2, (byte) (128 | (i10 & 63)));
        eVar.b(3);
        return 3;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void V1(double[] dArr, int i10, int i11) {
        q0.a.h(this, dArr, i10, i11);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void Y(o0 o0Var, int i10) {
        q0.a.f(this, o0Var, i10);
    }

    public final void Y1(int i10) {
        this.f15807c.f15812d = i10;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void a0(long j10, byte b10) {
        q0.a.a(this, j10, b10);
    }

    @lm.k(level = lm.m.HIDDEN, message = "There is no need to do that anymore.")
    @lm.z0
    public final void b(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException(kn.l0.C("It should be non-negative size increment: ", Integer.valueOf(i10)).toString());
        }
        d dVar = this.f15807c;
        int i11 = dVar.f15813e;
        int i12 = dVar.f15812d;
        if (i10 <= i11 - i12) {
            dVar.f15812d = i12 + i10;
            return;
        }
        StringBuilder sbA = h.b.a("Unable to mark more bytes than available: ", i10, " > ");
        d dVar2 = this.f15807c;
        sbA.append(dVar2.f15813e - dVar2.f15812d);
        throw new IllegalStateException(sbA.toString().toString());
    }

    public abstract void b0(@os.l ByteBuffer byteBuffer, int i10, int i11);

    public final void b2(ul.b bVar) {
        this.f15807c.f15809a = bVar;
    }

    public final void c() {
        ul.b bVarL0 = l0();
        if (bVarL0 != ul.b.f16311i.a()) {
            if (bVarL0.f2() != null) {
                throw new IllegalStateException("Check failed.");
            }
            bVarL0.v0();
            bVarL0.q0(this.f15805a);
            bVarL0.p0(8);
            m mVar = bVarL0.f15821b;
            int i10 = mVar.f15874c;
            d dVar = this.f15807c;
            dVar.f15812d = i10;
            dVar.f15814f = i10;
            dVar.f15813e = mVar.f15872a;
        }
    }

    public final void c1() {
        close();
    }

    @Override // tl.q0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            e0();
        } finally {
            O();
        }
    }

    @ul.d
    public final void d() {
        d dVar = this.f15807c;
        ul.b bVar = dVar.f15810b;
        if (bVar == null) {
            return;
        }
        dVar.f15812d = bVar.f15821b.f15874c;
    }

    @Override // tl.q0
    public final void d1(byte b10) throws n0 {
        d dVar = this.f15807c;
        int i10 = dVar.f15812d;
        if (i10 >= dVar.f15813e) {
            j2(b10);
        } else {
            dVar.f15812d = i10 + 1;
            dVar.f15811c.put(i10, b10);
        }
    }

    public final void e0() {
        ul.b bVarH2 = h2();
        if (bVarH2 == null) {
            return;
        }
        ul.b bVarF2 = bVarH2;
        do {
            try {
                ByteBuffer byteBuffer = bVarF2.f15820a;
                m mVar = bVarF2.f15821b;
                int i10 = mVar.f15873b;
                b0(byteBuffer, i10, mVar.f15874c - i10);
                bVarF2 = bVarF2.f2();
            } finally {
                n.k(bVarH2, this.f15806b);
            }
        } while (bVarF2 != null);
    }

    @Override // tl.q0
    @os.l
    public Appendable f1(@os.l char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "csq");
        d1.X(this, cArr, i10, i11, jq.f.f8800b);
        return this;
    }

    @lm.k(message = "There is no need to update/reset this value anymore.")
    public final void f2(int i10) {
    }

    @Override // tl.q0
    public final void flush() {
        e0();
    }

    @Override // tl.q0
    public final void g(@os.l q qVar) {
        kn.l0.p(qVar, "value");
        this.f15808d = qVar;
        if (qVar != q.BIG_ENDIAN) {
            throw new IllegalArgumentException("Only BIG_ENDIAN is supported. Use corresponding functions to read/writein the little endian");
        }
    }

    public final int g0() {
        return this.f15807c.f15815g;
    }

    public final void g2(ul.b bVar) {
        this.f15807c.f15810b = bVar;
    }

    @Override // java.lang.Appendable
    @os.l
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public c append(char c10) {
        d dVar = this.f15807c;
        int i10 = dVar.f15812d;
        int i11 = 3;
        if (dVar.f15813e - i10 < 3) {
            q(c10);
            return this;
        }
        ByteBuffer byteBuffer = dVar.f15811c;
        if (c10 >= 0 && c10 < 128) {
            byteBuffer.put(i10, (byte) c10);
            i11 = 1;
        } else if (128 <= c10 && c10 < 2048) {
            byteBuffer.put(i10, (byte) (((c10 >> 6) & 31) | 192));
            byteBuffer.put(i10 + 1, (byte) ((c10 & '?') | 128));
            i11 = 2;
        } else if (2048 <= c10 && c10 < 0) {
            byteBuffer.put(i10, (byte) (((c10 >> '\f') & 15) | 224));
            byteBuffer.put(i10 + 1, (byte) (((c10 >> 6) & 63) | 128));
            byteBuffer.put(i10 + 2, (byte) ((c10 & '?') | 128));
        } else {
            if (0 > c10 || c10 >= 0) {
                ul.j.p(c10);
                throw new lm.y();
            }
            byteBuffer.put(i10, (byte) (((c10 >> 18) & 7) | p5.m0.f12864d));
            byteBuffer.put(i10 + 1, (byte) (((c10 >> '\f') & 63) | 128));
            byteBuffer.put(i10 + 2, (byte) (((c10 >> 6) & 63) | 128));
            byteBuffer.put(i10 + 3, (byte) ((c10 & '?') | 128));
            i11 = 4;
        }
        this.f15807c.f15812d = i10 + i11;
        return this;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void h0(float[] fArr, int i10, int i11) {
        q0.a.i(this, fArr, i10, i11);
    }

    @os.m
    public final ul.b h2() {
        d dVar = this.f15807c;
        ul.b bVar = dVar.f15809a;
        if (bVar == null) {
            return null;
        }
        ul.b bVar2 = dVar.f15810b;
        if (bVar2 != null) {
            bVar2.c(dVar.f15812d);
        }
        d dVar2 = this.f15807c;
        dVar2.f15809a = null;
        dVar2.f15810b = null;
        dVar2.f15812d = 0;
        dVar2.f15813e = 0;
        dVar2.f15814f = 0;
        dVar2.f15815g = 0;
        ql.f.f14043b.getClass();
        S1(ql.f.f14044c);
        return bVar;
    }

    @lm.z0
    public final int i2(int i10, @os.l jn.l<? super e, Integer> lVar) {
        kn.l0.p(lVar, "block");
        try {
            int iIntValue = lVar.invoke(T0(i10)).intValue();
            if (iIntValue < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative");
            }
            d();
            return iIntValue;
        } catch (Throwable th2) {
            d();
            throw th2;
        }
    }

    @Override // tl.q0
    @os.l
    public final q j() {
        return this.f15808d;
    }

    @os.l
    public final ul.b j0() {
        return T0(1);
    }

    public final void j2(byte b10) throws n0 {
        A().d1(b10);
        this.f15807c.f15812d++;
    }

    @Override // java.lang.Appendable
    @os.l
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public c append(@os.m CharSequence charSequence) {
        if (charSequence == null) {
            append(d6.a.E, 0, 4);
        } else {
            append(charSequence, 0, charSequence.length());
        }
        return this;
    }

    public final void k2(@os.l ul.b bVar) {
        kn.l0.p(bVar, "chunkBuffer");
        ul.b bVar2 = this.f15807c.f15810b;
        if (bVar2 == null) {
            o(bVar);
        } else {
            o2(bVar2, bVar, this.f15806b);
        }
    }

    @os.l
    public final ul.b l0() {
        ul.b bVar = this.f15807c.f15809a;
        return bVar == null ? ul.b.f16311i.a() : bVar;
    }

    public final void l2(@os.l v vVar) {
        kn.l0.p(vVar, "p");
        ul.b bVarJ2 = vVar.J2();
        if (bVarJ2 == null) {
            vVar.z2();
            return;
        }
        ul.b bVar = this.f15807c.f15810b;
        if (bVar == null) {
            o(bVarJ2);
        } else {
            o2(bVar, bVarJ2, vVar.f15789a);
        }
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void m1(short[] sArr, int i10, int i11) {
        q0.a.l(this, sArr, i10, i11);
    }

    public final void m2(@os.l v vVar, int i10) throws EOFException {
        kn.l0.p(vVar, "p");
        while (i10 > 0) {
            b bVar = vVar.f15790b;
            int i11 = bVar.f15801d - bVar.f15800c;
            if (i11 > i10) {
                ul.b bVarI2 = vVar.i2(1);
                if (bVarI2 == null) {
                    throw pl.h.a(1);
                }
                int i12 = bVarI2.f15821b.f15873b;
                try {
                    s0.h(this, bVarI2, i10);
                    m mVar = bVarI2.f15821b;
                    int i13 = mVar.f15873b;
                    if (i13 < i12) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (i13 == mVar.f15874c) {
                        vVar.E(bVarI2);
                        return;
                    } else {
                        vVar.f15790b.f15800c = i13;
                        return;
                    }
                } catch (Throwable th2) {
                    m mVar2 = bVarI2.f15821b;
                    int i14 = mVar2.f15873b;
                    if (i14 < i12) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (i14 == mVar2.f15874c) {
                        vVar.E(bVarI2);
                    } else {
                        vVar.f15790b.f15800c = i14;
                    }
                    throw th2;
                }
            }
            i10 -= i11;
            ul.b bVarI3 = vVar.I2();
            if (bVarI3 == null) {
                throw new EOFException("Unexpected end of packet");
            }
            E(bVarI3);
        }
    }

    @Override // java.lang.Appendable
    @os.l
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public c append(@os.m CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            return append(d6.a.E, i10, i11);
        }
        d1.V(this, charSequence, i10, i11, jq.f.f8800b);
        return this;
    }

    public final void n2(@os.l v vVar, long j10) throws EOFException {
        kn.l0.p(vVar, "p");
        while (j10 > 0) {
            b bVar = vVar.f15790b;
            long j11 = bVar.f15801d - bVar.f15800c;
            if (j11 > j10) {
                ul.b bVarI2 = vVar.i2(1);
                if (bVarI2 == null) {
                    throw pl.h.a(1);
                }
                int i10 = bVarI2.f15821b.f15873b;
                try {
                    s0.h(this, bVarI2, (int) j10);
                    m mVar = bVarI2.f15821b;
                    int i11 = mVar.f15873b;
                    if (i11 < i10) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (i11 == mVar.f15874c) {
                        vVar.E(bVarI2);
                        return;
                    } else {
                        vVar.f15790b.f15800c = i11;
                        return;
                    }
                } catch (Throwable th2) {
                    m mVar2 = bVarI2.f15821b;
                    int i12 = mVar2.f15873b;
                    if (i12 < i10) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (i12 == mVar2.f15874c) {
                        vVar.E(bVarI2);
                    } else {
                        vVar.f15790b.f15800c = i12;
                    }
                    throw th2;
                }
            }
            j10 -= j11;
            ul.b bVarI3 = vVar.I2();
            if (bVarI3 == null) {
                throw new EOFException("Unexpected end of packet");
            }
            E(bVarI3);
        }
    }

    public final void o(@os.l ul.b bVar) {
        kn.l0.p(bVar, "head");
        ul.b bVarE = n.e(bVar);
        long jO = n.o(bVar);
        m mVar = bVarE.f15821b;
        long j10 = jO - ((long) (mVar.f15874c - mVar.f15873b));
        if (j10 >= 2147483647L) {
            throw ql.d.a(j10, "total size increase");
        }
        p(bVar, bVarE, (int) j10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002a  */
    public final void o2(ul.b bVar, ul.b bVar2, bm.h<ul.b> hVar) {
        bVar.c(this.f15807c.f15812d);
        m mVar = bVar.f15821b;
        int i10 = mVar.f15874c - mVar.f15873b;
        m mVar2 = bVar2.f15821b;
        int i11 = mVar2.f15874c - mVar2.f15873b;
        int iC = w0.c();
        if (i11 < iC) {
            int i12 = bVar.f15822c;
            m mVar3 = bVar.f15821b;
            int i13 = mVar3.f15872a;
            if (i11 > (i13 - mVar3.f15874c) + (i12 - i13)) {
                i11 = -1;
            }
        } else {
            i11 = -1;
        }
        if (i10 >= iC || i10 > bVar2.f15821b.f15875d || !ul.c.a(bVar2)) {
            i10 = -1;
        }
        if (i11 == -1 && i10 == -1) {
            o(bVar2);
            return;
        }
        if (i10 != -1 && i11 > i10) {
            if (i11 != -1 && i10 >= i11) {
                throw new IllegalStateException(e0.a.a("prep = ", i10, ", app = ", i11));
            }
            p2(bVar2, bVar);
            return;
        }
        m mVar4 = bVar.f15821b;
        int i14 = mVar4.f15872a;
        f.a(bVar, bVar2, (bVar.f15822c - i14) + (i14 - mVar4.f15874c));
        d();
        ul.b bVarY1 = bVar2.Y1();
        if (bVarY1 != null) {
            o(bVarY1);
        }
        bVar2.j2(hVar);
    }

    public final void p(ul.b bVar, ul.b bVar2, int i10) {
        d dVar = this.f15807c;
        ul.b bVar3 = dVar.f15810b;
        if (bVar3 == null) {
            dVar.f15809a = bVar;
            dVar.f15815g = 0;
        } else {
            bVar3.l2(bVar);
            int i11 = this.f15807c.f15812d;
            bVar3.c(i11);
            d dVar2 = this.f15807c;
            dVar2.f15815g = (i11 - dVar2.f15814f) + dVar2.f15815g;
        }
        d dVar3 = this.f15807c;
        dVar3.f15810b = bVar2;
        dVar3.f15815g += i10;
        S1(bVar2.f15820a);
        m mVar = bVar2.f15821b;
        int i12 = mVar.f15874c;
        d dVar4 = this.f15807c;
        dVar4.f15812d = i12;
        dVar4.f15814f = mVar.f15873b;
        dVar4.f15813e = mVar.f15872a;
    }

    @os.l
    public final bm.h<ul.b> p0() {
        return this.f15806b;
    }

    public final void p2(ul.b bVar, ul.b bVar2) {
        f.c(bVar, bVar2);
        d dVar = this.f15807c;
        ul.b bVar3 = dVar.f15809a;
        if (bVar3 == null) {
            throw new IllegalStateException("head should't be null since it is already handled in the fast-path");
        }
        if (bVar3 == bVar2) {
            dVar.f15809a = bVar;
        } else {
            while (true) {
                ul.b bVarF2 = bVar3.f2();
                kn.l0.m(bVarF2);
                if (bVarF2 == bVar2) {
                    break;
                } else {
                    bVar3 = bVarF2;
                }
            }
            bVar3.l2(bVar);
        }
        bVar2.j2(this.f15806b);
        this.f15807c.f15810b = n.e(bVar);
    }

    public final void q(char c10) {
        int i10 = 3;
        ul.b bVarT0 = T0(3);
        try {
            ByteBuffer byteBuffer = bVarT0.f15820a;
            int i11 = bVarT0.f15821b.f15874c;
            if (c10 >= 0 && c10 < 128) {
                byteBuffer.put(i11, (byte) c10);
                i10 = 1;
            } else if (128 <= c10 && c10 < 2048) {
                byteBuffer.put(i11, (byte) (((c10 >> 6) & 31) | 192));
                byteBuffer.put(i11 + 1, (byte) ((c10 & '?') | 128));
                i10 = 2;
            } else if (2048 <= c10 && c10 < 0) {
                byteBuffer.put(i11, (byte) (((c10 >> '\f') & 15) | 224));
                byteBuffer.put(i11 + 1, (byte) (((c10 >> 6) & 63) | 128));
                byteBuffer.put(i11 + 2, (byte) ((c10 & '?') | 128));
            } else {
                if (0 > c10 || c10 >= 0) {
                    ul.j.p(c10);
                    throw new lm.y();
                }
                byteBuffer.put(i11, (byte) (((c10 >> 18) & 7) | p5.m0.f12864d));
                byteBuffer.put(i11 + 1, (byte) (((c10 >> '\f') & 63) | 128));
                byteBuffer.put(i11 + 2, (byte) (((c10 >> 6) & 63) | 128));
                byteBuffer.put(i11 + 3, (byte) ((c10 & '?') | 128));
                i10 = 4;
            }
            bVarT0.b(i10);
            if (i10 < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative");
            }
            d();
        } catch (Throwable th2) {
            d();
            throw th2;
        }
    }

    public final /* synthetic */ ul.b q0() {
        return T0(1);
    }

    @lm.k(message = "Use writeText instead", replaceWith = @lm.a1(expression = "this.writeText(cs)", imports = {}))
    public final void q2(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "cs");
        d1.Y(this, charSequence, 0, 0, null, 14, null);
    }

    @lm.k(message = "Use writeText instead", replaceWith = @lm.a1(expression = "writeText(s)", imports = {}))
    public final void r2(@os.l String str) {
        kn.l0.p(str, p6.s.f13016a);
        d1.Y(this, str, 0, 0, null, 14, null);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void reset() {
    }

    public final int t(int i10, int i11, jn.p<? super e, ? super Integer, Integer> pVar) {
        if (i10 >= i11) {
            return i10;
        }
        int iIntValue = pVar.invoke(T0(1), Integer.valueOf(i10)).intValue();
        d();
        while (iIntValue < i11) {
            iIntValue = pVar.invoke(A(), Integer.valueOf(iIntValue)).intValue();
            d();
        }
        return iIntValue;
    }

    public final int v0() {
        return this.f15807c.f15813e;
    }

    public final int w0() {
        return this.f15807c.f15814f;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeDouble(double d10) {
        q0.a.c(this, d10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFloat(float f10) {
        q0.a.d(this, f10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeInt(int i10) {
        q0.a.m(this, i10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeLong(long j10) {
        q0.a.n(this, j10);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Use appendNewChunk instead", replaceWith = @lm.a1(expression = "appendNewChunk()", imports = {}))
    public final /* synthetic */ o0 y() {
        return (o0) A();
    }

    @os.l
    public final ByteBuffer y0() {
        return this.f15807c.f15811c;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void z1(int[] iArr, int i10, int i11) {
        q0.a.j(this, iArr, i10, i11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@os.l bm.h<ul.b> hVar) {
        this(0, hVar);
        kn.l0.p(hVar, "pool");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c() {
        this(ul.b.f16315w);
        ul.b.f16311i.getClass();
    }
}
