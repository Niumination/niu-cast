package tl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {
    public static final void a(@os.l q0 q0Var, @os.l ByteBuffer byteBuffer) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(byteBuffer, "bb");
        int iLimit = byteBuffer.limit();
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (true) {
            try {
                int iRemaining = byteBuffer.remaining();
                m mVar = bVarO.f15821b;
                byteBuffer.limit(byteBuffer.position() + Math.min(iRemaining, mVar.f15872a - mVar.f15874c));
                k.b(bVarO, byteBuffer);
                byteBuffer.limit(iLimit);
                if (!byteBuffer.hasRemaining()) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }
}
