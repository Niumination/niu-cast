package tl;

import java.io.EOFException;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public static final /* synthetic */ void a(a aVar, int i10) {
        kn.l0.p(aVar, "<this>");
        d((w) aVar, i10);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public static final /* synthetic */ void b(s sVar, int i10) {
        kn.l0.p(sVar, "<this>");
        sVar.l0().b(i10);
        sVar.d();
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public static final /* synthetic */ void c(v vVar, int i10) {
        kn.l0.p(vVar, "<this>");
        d(vVar, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Binary compatibility.")
    @lm.z0
    public static final void d(@os.l w wVar, int i10) {
        kn.l0.p(wVar, "<this>");
        b bVar = wVar.f15790b;
        wVar.F2((bVar.f15801d - bVar.f15800c) - i10);
    }

    public static final boolean e(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        return byteBuffer.hasArray() && !byteBuffer.isReadOnly();
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public static final /* synthetic */ ByteBuffer f(a aVar, int i10) {
        kn.l0.p(aVar, "<this>");
        ul.b bVarI2 = aVar.i2(i10);
        if (bVarI2 == null) {
            return null;
        }
        return p(bVarI2);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public static final /* synthetic */ ByteBuffer g(s sVar, int i10) {
        kn.l0.p(sVar, "<this>");
        return p(sVar.T0(i10));
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public static final /* synthetic */ ByteBuffer h(v vVar, int i10) {
        kn.l0.p(vVar, "<this>");
        ul.b bVarI2 = vVar.i2(i10);
        if (bVarI2 == null) {
            return null;
        }
        return p(bVarI2);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public static final /* synthetic */ ByteBuffer i(w wVar, int i10) {
        kn.l0.p(wVar, "<this>");
        ul.b bVarI2 = wVar.i2(i10);
        if (bVarI2 == null) {
            return null;
        }
        return p(bVarI2);
    }

    public static final int j(v vVar, ByteBuffer byteBuffer, int i10) {
        ul.b bVarI2;
        while (byteBuffer.hasRemaining() && (bVarI2 = vVar.i2(1)) != null) {
            int iRemaining = byteBuffer.remaining();
            m mVar = bVarI2.f15821b;
            int i11 = mVar.f15874c - mVar.f15873b;
            if (iRemaining < i11) {
                p0.d(bVarI2, byteBuffer, iRemaining);
                vVar.f15790b.f15800c = bVarI2.f15821b.f15873b;
                return i10 + iRemaining;
            }
            p0.d(bVarI2, byteBuffer, i11);
            vVar.A2(bVarI2);
            i10 += i11;
        }
        return i10;
    }

    public static final int k(@os.l v vVar, @os.l ByteBuffer byteBuffer) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(byteBuffer, "dst");
        return j(vVar, byteBuffer, 0);
    }

    @lm.k(message = "Use read {} instead.")
    public static final void l(@os.l a aVar, int i10, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarI2 = aVar.i2(i10);
        if (bVarI2 == null) {
            throw pl.h.a(i10);
        }
        m mVar = bVarI2.f15821b;
        int i11 = mVar.f15873b;
        try {
            ByteBuffer byteBuffer = bVarI2.f15820a;
            int i12 = mVar.f15874c - i11;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
            lVar.invoke(byteBufferN);
            if (byteBufferN.limit() != i12) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            bVarI2.h(byteBufferN.position());
            m mVar2 = bVarI2.f15821b;
            int i13 = mVar2.f15873b;
            if (i13 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i13 == mVar2.f15874c) {
                aVar.E(bVarI2);
            } else {
                aVar.f15790b.f15800c = i13;
            }
        } catch (Throwable th2) {
            m mVar3 = bVarI2.f15821b;
            int i14 = mVar3.f15873b;
            if (i14 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i14 == mVar3.f15874c) {
                aVar.E(bVarI2);
            } else {
                aVar.f15790b.f15800c = i14;
            }
            throw th2;
        }
    }

    public static final void m(@os.l v vVar, int i10, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarI2 = vVar.i2(i10);
        if (bVarI2 == null) {
            throw pl.h.a(i10);
        }
        m mVar = bVarI2.f15821b;
        int i11 = mVar.f15873b;
        try {
            ByteBuffer byteBuffer = bVarI2.f15820a;
            int i12 = mVar.f15874c - i11;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
            lVar.invoke(byteBufferN);
            if (byteBufferN.limit() != i12) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            bVarI2.h(byteBufferN.position());
            m mVar2 = bVarI2.f15821b;
            int i13 = mVar2.f15873b;
            if (i13 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i13 == mVar2.f15874c) {
                vVar.E(bVarI2);
            } else {
                vVar.f15790b.f15800c = i13;
            }
        } catch (Throwable th2) {
            m mVar3 = bVarI2.f15821b;
            int i14 = mVar3.f15873b;
            if (i14 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i14 == mVar3.f15874c) {
                vVar.E(bVarI2);
            } else {
                vVar.f15790b.f15800c = i14;
            }
            throw th2;
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Removed")
    public static final void n(w wVar, int i10, jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(wVar, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarI2 = wVar.i2(i10);
        if (bVarI2 == null) {
            throw pl.h.a(i10);
        }
        m mVar = bVarI2.f15821b;
        int i11 = mVar.f15873b;
        try {
            ByteBuffer byteBuffer = bVarI2.f15820a;
            int i12 = mVar.f15874c - i11;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
            lVar.invoke(byteBufferN);
            if (byteBufferN.limit() != i12) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            bVarI2.h(byteBufferN.position());
            m mVar2 = bVarI2.f15821b;
            int i13 = mVar2.f15873b;
            if (i13 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i13 == mVar2.f15874c) {
                wVar.E(bVarI2);
            } else {
                wVar.f15790b.f15800c = i13;
            }
        } catch (Throwable th2) {
            m mVar3 = bVarI2.f15821b;
            int i14 = mVar3.f15873b;
            if (i14 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i14 == mVar3.f15874c) {
                wVar.E(bVarI2);
            } else {
                wVar.f15790b.f15800c = i14;
            }
            throw th2;
        }
    }

    public static final int o(@os.l v vVar, @os.l ByteBuffer byteBuffer) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(byteBuffer, "dst");
        int iJ = j(vVar, byteBuffer, 0);
        if (!byteBuffer.hasRemaining()) {
            return iJ;
        }
        throw new EOFException("Not enough data in packet to fill buffer: " + byteBuffer.remaining() + " more bytes required");
    }

    @os.l
    public static final ByteBuffer p(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        return ql.f.n(byteBuffer, i10, mVar.f15872a - i10);
    }

    public static final int q(@os.l s sVar, int i10, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(sVar, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarT0 = sVar.T0(i10);
        try {
            ByteBuffer byteBuffer = bVarT0.f15820a;
            m mVar = bVarT0.f15821b;
            int i11 = mVar.f15874c;
            int i12 = mVar.f15872a - i11;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
            lVar.invoke(byteBufferN);
            if (byteBufferN.limit() != i12) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            int iPosition = byteBufferN.position();
            bVarT0.b(iPosition);
            if (iPosition < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative");
            }
            sVar.d();
            return iPosition;
        } catch (Throwable th2) {
            sVar.d();
            throw th2;
        }
    }

    public static final void r(@os.l s sVar, int i10, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(sVar, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarT0 = sVar.T0(i10);
        try {
            ByteBuffer byteBuffer = bVarT0.f15820a;
            m mVar = bVarT0.f15821b;
            int i11 = mVar.f15874c;
            int i12 = mVar.f15872a - i11;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
            lVar.invoke(byteBufferN);
            if (byteBufferN.limit() != i12) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            int iPosition = byteBufferN.position();
            bVarT0.b(iPosition);
            if (iPosition < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative");
            }
            sVar.d();
        } catch (Throwable th2) {
            sVar.d();
            throw th2;
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Should be resolved to member function instead")
    public static final /* synthetic */ void s(s sVar, ByteBuffer byteBuffer) {
        kn.l0.p(sVar, "<this>");
        kn.l0.p(byteBuffer, "src");
        r0.a(sVar, byteBuffer);
    }
}
