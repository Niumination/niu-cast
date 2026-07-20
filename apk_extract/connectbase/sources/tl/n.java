package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final int a(long j10) {
        return (int) Math.min(j10, 2147483647L);
    }

    public static final int b(long j10, @os.l String str) {
        kn.l0.p(str, "message");
        if (j10 <= 2147483647L) {
            return (int) j10;
        }
        throw new IllegalArgumentException(str);
    }

    @os.l
    public static final ul.b c(@os.l ul.b bVar) {
        kn.l0.p(bVar, "<this>");
        ul.b bVarO = bVar.o();
        ul.b bVarF2 = bVar.f2();
        return bVarF2 == null ? bVarO : d(bVarF2, bVarO, bVarO);
    }

    public static final ul.b d(ul.b bVar, ul.b bVar2, ul.b bVar3) {
        while (true) {
            ul.b bVarO = bVar.o();
            bVar3.l2(bVarO);
            bVar = bVar.f2();
            if (bVar == null) {
                return bVar2;
            }
            bVar3 = bVarO;
        }
    }

    @os.l
    public static final ul.b e(@os.l ul.b bVar) {
        kn.l0.p(bVar, "<this>");
        while (true) {
            ul.b bVarF2 = bVar.f2();
            if (bVarF2 == null) {
                return bVar;
            }
            bVar = bVarF2;
        }
    }

    public static final void f(@os.l ul.b bVar, @os.l jn.l<? super ul.b, l2> lVar) {
        kn.l0.p(bVar, "<this>");
        kn.l0.p(lVar, "block");
        do {
            lVar.invoke(bVar);
            bVar = bVar.f2();
        } while (bVar != null);
    }

    public static final boolean g(@os.l ul.b bVar) {
        kn.l0.p(bVar, "<this>");
        do {
            m mVar = bVar.f15821b;
            if (mVar.f15874c - mVar.f15873b > 0) {
                return false;
            }
            bVar = bVar.f2();
        } while (bVar != null);
        return true;
    }

    public static final long h(@os.l e eVar, @os.l ByteBuffer byteBuffer, long j10, long j11, long j12, long j13) {
        kn.l0.p(eVar, "$this$peekTo");
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        long jLimit = ((long) byteBuffer.limit()) - j10;
        m mVar = eVar.f15821b;
        long jMin = Math.min(jLimit, Math.min(j13, mVar.f15874c - mVar.f15873b));
        ql.f.e(eVar.f15820a, byteBuffer, ((long) eVar.f15821b.f15873b) + j11, jMin, j10);
        return jMin;
    }

    @os.l
    public static final byte[] i(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        if (i10 == 0) {
            return ul.k.f16328a;
        }
        byte[] bArr = new byte[i10];
        l.N(eVar, bArr, 0, 0, 6, null);
        return bArr;
    }

    public static byte[] j(e eVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            m mVar = eVar.f15821b;
            i10 = mVar.f15874c - mVar.f15873b;
        }
        return i(eVar, i10);
    }

    public static final void k(@os.m ul.b bVar, @os.l bm.h<ul.b> hVar) {
        kn.l0.p(hVar, "pool");
        while (bVar != null) {
            ul.b bVarY1 = bVar.Y1();
            bVar.j2(hVar);
            bVar = bVarY1;
        }
    }

    public static final void l(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        o0.H.getClass();
        m(o0Var, o0.M);
    }

    @lm.k(level = lm.m.WARNING, message = "IoBuffer now contains ObjectPool reference", replaceWith = @lm.a1(expression = "releaseImpl()", imports = {}))
    public static final void m(@os.l o0 o0Var, @os.l bm.h<o0> hVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(hVar, "pool");
        if (o0Var.k2()) {
            ul.b bVarG2 = o0Var.g2();
            bm.h<ul.b> hVar2 = o0Var.f16319f;
            if (hVar2 == null) {
                hVar2 = hVar;
            }
            if (!(bVarG2 instanceof o0)) {
                hVar2.recycle(o0Var);
            } else {
                o0Var.n2();
                ((o0) bVarG2).j2(hVar);
            }
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ long n(o0 o0Var) {
        kn.l0.p(o0Var, "buffer");
        return o(o0Var);
    }

    @ul.d
    public static final long o(@os.l ul.b bVar) {
        kn.l0.p(bVar, "<this>");
        return p(bVar, 0L);
    }

    public static final long p(ul.b bVar, long j10) {
        do {
            m mVar = bVar.f15821b;
            j10 += (long) (mVar.f15874c - mVar.f15873b);
            bVar = bVar.f2();
        } while (bVar != null);
        return j10;
    }
}
