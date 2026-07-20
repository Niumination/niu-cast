package ig;

import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wi.k;
import wi.n;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nh.b f5865a = new nh.b(128, 65536, 0);

    public static final wi.a a(k kVar, Cipher cipher, Function1 header) {
        int iRemaining;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(header, "header");
        ByteBuffer buffer = (ByteBuffer) lg.a.f7423a.R();
        nh.b bVar = f5865a;
        Object objR = bVar.R();
        boolean z2 = true;
        try {
            wi.a aVar = new wi.a();
            buffer.clear();
            header.invoke(aVar);
            while (true) {
                if (buffer.hasRemaining()) {
                    Intrinsics.checkNotNullParameter(kVar, "<this>");
                    Intrinsics.checkNotNullParameter(buffer, "buffer");
                    int iRemaining2 = buffer.remaining();
                    n.a(kVar, buffer);
                    iRemaining = iRemaining2 - buffer.remaining();
                } else {
                    iRemaining = 0;
                }
                buffer.flip();
                if (!buffer.hasRemaining() && (iRemaining == -1 || kVar.T())) {
                    break;
                    break;
                }
                ((ByteBuffer) objR).clear();
                if (cipher.getOutputSize(buffer.remaining()) > ((ByteBuffer) objR).remaining()) {
                    if (z2) {
                        bVar.h0(objR);
                    }
                    objR = ByteBuffer.allocate(cipher.getOutputSize(buffer.remaining()));
                    z2 = false;
                }
                cipher.update(buffer, (ByteBuffer) objR);
                ((ByteBuffer) objR).flip();
                lh.a.j(aVar, (ByteBuffer) objR);
                buffer.compact();
            }
            buffer.hasRemaining();
            ((ByteBuffer) objR).hasRemaining();
            int outputSize = cipher.getOutputSize(0);
            if (outputSize != 0) {
                if (outputSize > ((ByteBuffer) objR).capacity()) {
                    byte[] bArrDoFinal = cipher.doFinal();
                    Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                    lh.a.k(aVar, bArrDoFinal, 0, bArrDoFinal.length);
                } else {
                    ((ByteBuffer) objR).clear();
                    cipher.doFinal(b.f5864a, (ByteBuffer) objR);
                    ((ByteBuffer) objR).flip();
                    if (((ByteBuffer) objR).hasRemaining()) {
                        lh.a.j(aVar, (ByteBuffer) objR);
                    } else {
                        byte[] bArrDoFinal2 = cipher.doFinal();
                        Intrinsics.checkNotNullExpressionValue(bArrDoFinal2, "doFinal(...)");
                        lh.a.k(aVar, bArrDoFinal2, 0, bArrDoFinal2.length);
                    }
                }
            }
            return aVar;
        } finally {
            lg.a.f7423a.h0(buffer);
            if (1 != 0) {
                bVar.h0(objR);
            }
        }
    }
}
