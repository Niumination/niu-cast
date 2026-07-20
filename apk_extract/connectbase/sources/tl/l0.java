package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {
    @lm.k(message = "Use peekTo(Memory) instead.")
    public static final int a(@os.l g0 g0Var, @os.l e eVar, int i10, int i11, int i12) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(eVar, RtspHeaders.Values.DESTINATION);
        vl.a.c(eVar, i10, i11, i12);
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i13 = mVar.f15874c;
        long j10 = i13;
        long j11 = i10;
        long j12 = i11;
        int i14 = mVar.f15872a - i13;
        if (i12 > i14) {
            i12 = i14;
        }
        int iV0 = (int) g0Var.V0(byteBuffer, j10, j11, j12, i12);
        eVar.b(iV0);
        return iV0;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int b(g0 g0Var, o0 o0Var, int i10, int i11, int i12) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(o0Var, RtspHeaders.Values.DESTINATION);
        return a(g0Var, o0Var, i10, i11, i12);
    }

    public static /* synthetic */ int c(g0 g0Var, e eVar, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        if ((i13 & 8) != 0) {
            i12 = Integer.MAX_VALUE;
        }
        return a(g0Var, eVar, i10, i11, i12);
    }

    public static /* synthetic */ int d(g0 g0Var, o0 o0Var, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        if ((i13 & 8) != 0) {
            i12 = Integer.MAX_VALUE;
        }
        return b(g0Var, o0Var, i10, i11, i12);
    }
}
