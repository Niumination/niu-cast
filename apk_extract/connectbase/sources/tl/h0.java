package tl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {
    public static final int a(@os.l g0 g0Var, @os.l ByteBuffer byteBuffer, int i10) throws Throwable {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(byteBuffer, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            return 0;
        }
        int i11 = 0;
        do {
            try {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                m mVar = bVarJ.f15821b;
                byteBuffer.limit(Math.min(iLimit, (mVar.f15874c - mVar.f15873b) + iPosition));
                int iRemaining = byteBuffer.remaining();
                ql.i.b(bVarJ.f15820a, byteBuffer, bVarJ.f15821b.f15873b);
                byteBuffer.limit(iLimit);
                i11 += iRemaining;
                if (!byteBuffer.hasRemaining() || i11 >= i10) {
                    ul.k.e(g0Var, bVarJ);
                    break;
                }
                try {
                    bVarJ = ul.k.m(g0Var, bVarJ);
                } catch (Throwable th2) {
                    th = th2;
                    z10 = false;
                    if (z10) {
                        ul.k.e(g0Var, bVarJ);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } while (bVarJ != null);
        return i11;
    }

    public static /* synthetic */ int b(g0 g0Var, ByteBuffer byteBuffer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = byteBuffer.remaining();
        }
        return a(g0Var, byteBuffer, i10);
    }

    public static final void c(@os.l g0 g0Var, @os.l ByteBuffer byteBuffer, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(byteBuffer, "dst");
        if (a(g0Var, byteBuffer, i10) < i10) {
            throw pl.h.a(i10);
        }
    }

    public static /* synthetic */ void d(g0 g0Var, ByteBuffer byteBuffer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = byteBuffer.remaining();
        }
        c(g0Var, byteBuffer, i10);
    }
}
