package ql;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final void a(@os.l ByteBuffer byteBuffer, @os.l byte[] bArr, long j10, int i10) {
        l0.p(byteBuffer, "$this$copyTo");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.c(byteBuffer, bArr, j10, i10, 0);
    }

    public static final void b(@os.l ByteBuffer byteBuffer, @os.l byte[] bArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$copyTo");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.a(byteBuffer, bArr, i10, i11, 0);
    }

    public static final byte c(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$get");
        if (j10 < 2147483647L) {
            return byteBuffer.get((int) j10);
        }
        throw d.a(j10, "index");
    }

    public static final byte d(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$get");
        return byteBuffer.get(i10);
    }

    public static final void e(@os.l ByteBuffer byteBuffer, int i10, byte b10) {
        l0.p(byteBuffer, "$this$set");
        byteBuffer.put(i10, b10);
    }

    public static final void f(@os.l ByteBuffer byteBuffer, long j10, byte b10) {
        l0.p(byteBuffer, "$this$set");
        if (j10 >= 2147483647L) {
            throw d.a(j10, "index");
        }
        byteBuffer.put((int) j10, b10);
    }

    public static final void g(@os.l ByteBuffer byteBuffer, int i10, byte b10) {
        l0.p(byteBuffer, "$this$storeAt");
        byteBuffer.put(i10, b10);
    }

    public static final void h(@os.l ByteBuffer byteBuffer, long j10, byte b10) {
        l0.p(byteBuffer, "$this$storeAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, "index");
        }
        byteBuffer.put((int) j10, b10);
    }
}
