package ql;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes2.dex */
@in.g
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f14043b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final ByteBuffer f14044c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ByteBuffer f14045a;

    public static final class a {
        public a() {
        }

        @os.l
        public final ByteBuffer a() {
            return f.f14044c;
        }

        public a(w wVar) {
        }
    }

    static {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        l0.p(byteBufferOrder, "buffer");
        f14044c = byteBufferOrder;
    }

    @ul.d
    public /* synthetic */ f(ByteBuffer byteBuffer) {
        this.f14045a = byteBuffer;
    }

    public static final /* synthetic */ f b(ByteBuffer byteBuffer) {
        return new f(byteBuffer);
    }

    @ul.d
    @os.l
    public static ByteBuffer c(@os.l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "buffer");
        return byteBuffer;
    }

    public static final void d(ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, int i10, int i11, int i12) {
        l0.p(byteBuffer, "arg0");
        l0.p(byteBuffer2, RtspHeaders.Values.DESTINATION);
        if (byteBuffer.hasArray() && byteBuffer2.hasArray() && !byteBuffer.isReadOnly() && !byteBuffer2.isReadOnly()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i10, byteBuffer2.array(), byteBuffer2.arrayOffset() + i12, i11);
            return;
        }
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.limit(i10 + i11);
        ByteBuffer byteBufferDuplicate2 = byteBuffer2.duplicate();
        byteBufferDuplicate2.position(i12);
        byteBufferDuplicate2.put(byteBufferDuplicate);
    }

    public static final void e(ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, long j10, long j11, long j12) {
        l0.p(byteBuffer, "arg0");
        l0.p(byteBuffer2, RtspHeaders.Values.DESTINATION);
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        int i10 = (int) j10;
        if (j11 >= 2147483647L) {
            throw d.a(j11, "length");
        }
        int i11 = (int) j11;
        if (j12 >= 2147483647L) {
            throw d.a(j12, "destinationOffset");
        }
        d(byteBuffer, byteBuffer2, i10, i11, (int) j12);
    }

    public static boolean f(ByteBuffer byteBuffer, Object obj) {
        return (obj instanceof f) && l0.g(byteBuffer, ((f) obj).f14045a);
    }

    public static final boolean g(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return l0.g(byteBuffer, byteBuffer2);
    }

    public static final long i(ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "arg0");
        return byteBuffer.limit();
    }

    public static final int j(ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "arg0");
        return byteBuffer.limit();
    }

    public static int k(ByteBuffer byteBuffer) {
        return byteBuffer.hashCode();
    }

    public static final byte l(ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "arg0");
        return byteBuffer.get(i10);
    }

    public static final byte m(ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "arg0");
        if (j10 < 2147483647L) {
            return byteBuffer.get((int) j10);
        }
        throw d.a(j10, "index");
    }

    @os.l
    public static final ByteBuffer n(ByteBuffer byteBuffer, int i10, int i11) {
        l0.p(byteBuffer, "arg0");
        ByteBuffer byteBufferJ = i.j(byteBuffer, i10, i11);
        l0.p(byteBufferJ, "buffer");
        return byteBufferJ;
    }

    @os.l
    public static final ByteBuffer o(ByteBuffer byteBuffer, long j10, long j11) {
        l0.p(byteBuffer, "arg0");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        int i10 = (int) j10;
        if (j11 < 2147483647L) {
            return n(byteBuffer, i10, (int) j11);
        }
        throw d.a(j11, "length");
    }

    public static final void p(ByteBuffer byteBuffer, int i10, byte b10) {
        l0.p(byteBuffer, "arg0");
        byteBuffer.put(i10, b10);
    }

    public static final void q(ByteBuffer byteBuffer, long j10, byte b10) {
        l0.p(byteBuffer, "arg0");
        if (j10 >= 2147483647L) {
            throw d.a(j10, "index");
        }
        byteBuffer.put((int) j10, b10);
    }

    public static String r(ByteBuffer byteBuffer) {
        return "Memory(buffer=" + byteBuffer + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f14045a, obj);
    }

    @os.l
    public final ByteBuffer h() {
        return this.f14045a;
    }

    public int hashCode() {
        return this.f14045a.hashCode();
    }

    public final /* synthetic */ ByteBuffer s() {
        return this.f14045a;
    }

    public String toString() {
        return r(this.f14045a);
    }
}
