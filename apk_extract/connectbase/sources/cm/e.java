package cm;

import bm.h;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kn.l0;
import os.l;
import ql.i;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends tl.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final OutputStream f1673e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@l h<ul.b> hVar, @l OutputStream outputStream) {
        super(hVar);
        l0.p(hVar, "pool");
        l0.p(outputStream, "stream");
        this.f1673e = outputStream;
    }

    @Override // tl.c
    public void O() throws IOException {
        this.f1673e.close();
    }

    @Override // tl.c
    public void b0(@l ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        l0.p(byteBuffer, "source");
        if (byteBuffer.hasArray() && !byteBuffer.isReadOnly()) {
            this.f1673e.write(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11);
            return;
        }
        byte[] bArrW0 = a.a().W0();
        ByteBuffer byteBufferJ = i.j(byteBuffer, i10, i11);
        while (true) {
            try {
                int iMin = Math.min(byteBufferJ.remaining(), bArrW0.length);
                if (iMin == 0) {
                    a.f1671b.recycle(bArrW0);
                    return;
                } else {
                    byteBufferJ.get(bArrW0, 0, iMin);
                    this.f1673e.write(bArrW0, 0, iMin);
                }
            } catch (Throwable th2) {
                a.f1671b.recycle(bArrW0);
                throw th2;
            }
        }
    }
}
