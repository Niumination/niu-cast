package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.EOFException;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final void a(@os.l e eVar, @os.l ByteBuffer byteBuffer) throws EOFException {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        int iRemaining = byteBuffer.remaining();
        ByteBuffer byteBuffer2 = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= iRemaining)) {
            new l.s("buffer content", iRemaining).a();
            throw new lm.y();
        }
        ql.i.b(byteBuffer2, byteBuffer, i10);
        l2 l2Var = l2.f10208a;
        eVar.h(iRemaining);
    }

    public static final void b(@os.l e eVar, @os.l ByteBuffer byteBuffer) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        ByteBuffer byteBuffer2 = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15872a - i10;
        if (i11 < iRemaining) {
            throw new n0("buffer content", iRemaining, i11);
        }
        ql.i.e(byteBuffer, byteBuffer2, i10);
        eVar.b(iRemaining);
    }
}
