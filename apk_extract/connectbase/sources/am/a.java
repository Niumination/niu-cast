package am;

import bm.h;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import kn.l0;
import kn.w;
import os.l;
import ql.i;
import tl.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends tl.a implements g0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final ReadableByteChannel f412e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@l ReadableByteChannel readableByteChannel, @l h<ul.b> hVar) {
        super((ul.b) null, 0L, hVar, 3, (w) null);
        l0.p(readableByteChannel, "channel");
        l0.p(hVar, "pool");
        this.f412e = readableByteChannel;
        if ((readableByteChannel instanceof SelectableChannel) && ((SelectableChannel) readableByteChannel).isBlocking()) {
            throw new IllegalArgumentException("Non-blocking channels are not supported");
        }
    }

    @Override // tl.a
    public int f0(@l ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        int i12 = this.f412e.read(i.j(byteBuffer, i10, i11));
        if (i12 < 0) {
            return 0;
        }
        return i12;
    }

    @Override // tl.a
    public void n() throws IOException {
        this.f412e.close();
    }
}
