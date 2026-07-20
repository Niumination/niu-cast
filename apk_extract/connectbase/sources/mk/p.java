package mk;

import fl.a1;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
@c0
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ArrayBlockingQueue<g> f10818a = new ArrayBlockingQueue<>(1024);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public ByteBuffer f10819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public ByteBuffer f10820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10821d;

    public final void a(@os.l g gVar) throws InterruptedException {
        l0.p(gVar, "f");
        this.f10818a.put(gVar);
    }

    public final int b(g gVar, boolean z10) {
        int i10;
        int iRemaining = gVar.f10775h.remaining();
        if (iRemaining < 126) {
            i10 = 2;
        } else {
            i10 = iRemaining <= 32767 ? 4 : 10;
        }
        return f(z10) + i10;
    }

    public final boolean c() {
        return (this.f10818a.isEmpty() && this.f10819b == null) ? false : true;
    }

    public final boolean d() {
        return this.f10821d;
    }

    public final int e() {
        return this.f10818a.remainingCapacity();
    }

    public final int f(boolean z10) {
        return z10 ? 4 : 0;
    }

    public final ByteBuffer g(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.f10820c;
        if (byteBuffer2 == null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferC = a1.c(byteBuffer, 0, 1, null);
        s.a(byteBufferC, byteBuffer2);
        return byteBufferC == null ? byteBuffer : byteBufferC;
    }

    public final void h(@os.l ByteBuffer byteBuffer) {
        g gVarPeek;
        l0.p(byteBuffer, "buffer");
        while (l(byteBuffer) && (gVarPeek = this.f10818a.peek()) != null) {
            boolean z10 = this.f10821d;
            j(z10);
            if (byteBuffer.remaining() < b(gVarPeek, z10)) {
                return;
            }
            i(gVarPeek, byteBuffer, z10);
            this.f10818a.remove();
            this.f10819b = g(gVarPeek.f10775h);
        }
    }

    public final void i(g gVar, ByteBuffer byteBuffer, boolean z10) {
        ByteBuffer byteBufferDuplicate;
        int iRemaining = gVar.f10775h.remaining();
        if (iRemaining >= 126) {
            iRemaining = iRemaining <= 65535 ? 126 : 127;
        }
        byteBuffer.put((byte) ((gVar.f10768a ? 128 : 0) | (gVar.f10772e ? 64 : 0) | (gVar.f10773f ? 32 : 0) | (gVar.f10774g ? 16 : 0) | gVar.f10769b.getOpcode()));
        byteBuffer.put((byte) ((z10 ? 128 : 0) | iRemaining));
        if (iRemaining == 126) {
            byteBuffer.putShort((short) gVar.f10775h.remaining());
        } else if (iRemaining == 127) {
            byteBuffer.putLong(gVar.f10775h.remaining());
        }
        ByteBuffer byteBuffer2 = this.f10820c;
        if (byteBuffer2 == null || (byteBufferDuplicate = byteBuffer2.duplicate()) == null) {
            return;
        }
        a1.h(byteBufferDuplicate, byteBuffer, 0, 2, null);
    }

    public final void j(boolean z10) {
        if (!z10) {
            this.f10820c = null;
            return;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(fl.a0.c().hashCode());
        byteBufferAllocate.clear();
        this.f10820c = byteBufferAllocate;
    }

    public final void k(boolean z10) {
        this.f10821d = z10;
    }

    public final boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.f10819b;
        if (byteBuffer2 == null) {
            return true;
        }
        a1.h(byteBuffer2, byteBuffer, 0, 2, null);
        if (byteBuffer2.hasRemaining()) {
            return false;
        }
        this.f10819b = null;
        return true;
    }
}
