package am;

import bm.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kn.l0;
import os.l;
import ql.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends tl.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final WritableByteChannel f413e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@l h<ul.b> hVar, @l WritableByteChannel writableByteChannel) {
        super(hVar);
        l0.p(hVar, "pool");
        l0.p(writableByteChannel, "channel");
        this.f413e = writableByteChannel;
    }

    @Override // tl.c
    public void O() throws IOException {
        this.f413e.close();
    }

    @Override // tl.c
    public void b0(@l ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        l0.p(byteBuffer, "source");
        ByteBuffer byteBufferJ = i.j(byteBuffer, i10, i11);
        while (byteBufferJ.hasRemaining()) {
            this.f413e.write(byteBufferJ);
        }
    }

    @l
    public final WritableByteChannel s2() {
        return this.f413e;
    }
}
