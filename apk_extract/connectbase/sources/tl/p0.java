package tl;

import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {
    public static final int a(@os.l e eVar, @os.l ByteBuffer byteBuffer, int i10) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(byteBuffer, "dst");
        m mVar = eVar.f15821b;
        int i11 = mVar.f15874c;
        int i12 = mVar.f15873b;
        if (i11 <= i12) {
            return -1;
        }
        int iMin = Math.min(i11 - i12, i10);
        d(eVar, byteBuffer, iMin);
        return iMin;
    }

    public static /* synthetic */ int b(e eVar, ByteBuffer byteBuffer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = byteBuffer.remaining();
        }
        return a(eVar, byteBuffer, i10);
    }

    public static final int c(@os.l e eVar, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(lVar, "block");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c - i10;
        ByteBuffer byteBufferN = ql.f.n(byteBuffer, i10, i11);
        lVar.invoke(byteBufferN);
        if (byteBufferN.limit() != i11) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        int iPosition = byteBufferN.position();
        eVar.h(iPosition);
        return iPosition;
    }

    public static final void d(@os.l e eVar, @os.l ByteBuffer byteBuffer, int i10) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(byteBuffer, "dst");
        ByteBuffer byteBuffer2 = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i11 = mVar.f15873b;
        if (!(mVar.f15874c - i11 >= i10)) {
            new l.s("buffer content", i10).a();
            throw new lm.y();
        }
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i10);
            ql.i.b(byteBuffer2, byteBuffer, i11);
            byteBuffer.limit(iLimit);
            l2 l2Var = l2.f10208a;
            eVar.h(i10);
        } catch (Throwable th2) {
            byteBuffer.limit(iLimit);
            throw th2;
        }
    }

    public static final int e(@os.l e eVar, int i10, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(lVar, "block");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i11 = mVar.f15874c;
        int i12 = mVar.f15872a - i11;
        ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
        lVar.invoke(byteBufferN);
        if (byteBufferN.limit() != i12) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        int iPosition = byteBufferN.position();
        eVar.b(iPosition);
        return iPosition;
    }

    public static int f(e eVar, int i10, jn.l lVar, int i11, Object obj) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(lVar, "block");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15872a - i12;
        ByteBuffer byteBufferN = ql.f.n(byteBuffer, i12, i13);
        lVar.invoke(byteBufferN);
        if (byteBufferN.limit() != i13) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        int iPosition = byteBufferN.position();
        eVar.b(iPosition);
        return iPosition;
    }
}
