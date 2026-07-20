package ql;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final void a(@os.l ByteBuffer byteBuffer, @os.l byte[] bArr, int i10, int i11, int i12) {
        l0.p(byteBuffer, "$this$copyTo");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            byteBuffer.duplicate().get(bArr, i12, i11);
        } else {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i10, bArr, i12, i11);
        }
    }

    public static final void b(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, int i10) {
        l0.p(byteBuffer, "$this$copyTo");
        l0.p(byteBuffer2, RtspHeaders.Values.DESTINATION);
        int iRemaining = byteBuffer2.remaining();
        if (byteBuffer.hasArray() && !byteBuffer.isReadOnly() && byteBuffer2.hasArray() && !byteBuffer2.isReadOnly()) {
            int iPosition = byteBuffer2.position();
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i10, byteBuffer2.array(), byteBuffer2.arrayOffset() + iPosition, iRemaining);
            byteBuffer2.position(iPosition + iRemaining);
        } else {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.limit(iRemaining + i10);
            byteBufferDuplicate.position(i10);
            byteBuffer2.put(byteBufferDuplicate);
        }
    }

    public static final void c(@os.l ByteBuffer byteBuffer, @os.l byte[] bArr, long j10, int i10, int i11) {
        l0.p(byteBuffer, "$this$copyTo");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        a(byteBuffer, bArr, (int) j10, i10, i11);
    }

    public static final void d(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, long j10) {
        l0.p(byteBuffer, "$this$copyTo");
        l0.p(byteBuffer2, RtspHeaders.Values.DESTINATION);
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        b(byteBuffer, byteBuffer2, (int) j10);
    }

    public static final void e(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, int i10) {
        l0.p(byteBuffer, "$this$copyTo");
        l0.p(byteBuffer2, RtspHeaders.Values.DESTINATION);
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            j(byteBuffer2, i10, byteBuffer.remaining()).put(byteBuffer);
            return;
        }
        byte[] bArrArray = byteBuffer.array();
        l0.o(bArrArray, "array()");
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining();
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrArray, iPosition, iRemaining).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.d(f.c(byteBufferOrder), byteBuffer2, 0, iRemaining, i10);
        byteBuffer.position(byteBuffer.limit());
    }

    public static final void f(@os.l ByteBuffer byteBuffer, int i10, int i11, byte b10) {
        l0.p(byteBuffer, "$this$fill");
        int i12 = i11 + i10;
        while (i10 < i12) {
            byteBuffer.put(i10, b10);
            i10++;
        }
    }

    public static final void g(@os.l ByteBuffer byteBuffer, long j10, long j11, byte b10) {
        l0.p(byteBuffer, "$this$fill");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        int i10 = (int) j10;
        if (j11 >= 2147483647L) {
            throw d.a(j11, "count");
        }
        f(byteBuffer, i10, (int) j11, b10);
    }

    public static final ByteBuffer h(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.o(byteBufferDuplicate, "");
        return byteBufferDuplicate;
    }

    public static final ByteBuffer i(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        l0.o(byteBufferSlice, "");
        return byteBufferSlice;
    }

    @os.l
    public static final ByteBuffer j(@os.l ByteBuffer byteBuffer, int i10, int i11) {
        l0.p(byteBuffer, "<this>");
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.o(byteBufferDuplicate, "");
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.limit(i10 + i11);
        ByteBuffer byteBufferSlice = byteBufferDuplicate.slice();
        l0.o(byteBufferSlice, "");
        return byteBufferSlice;
    }

    public static final ByteBuffer k(ByteBuffer byteBuffer) {
        return byteBuffer;
    }
}
