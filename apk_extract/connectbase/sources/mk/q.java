package mk;

import fl.a1;
import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
@c0
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public ByteBuffer f10823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f10824c = ByteBuffer.allocate(4);

    public final boolean a() {
        return this.f10822a > 0;
    }

    public final void b(@os.l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "bb");
        int i10 = this.f10822a;
        ByteBuffer byteBuffer2 = this.f10823b;
        l0.m(byteBuffer2);
        this.f10822a = i10 - a1.g(byteBuffer, byteBuffer2, this.f10822a);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final void c(int i10, @os.l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "bb");
        if (this.f10822a != 0) {
            throw new IllegalStateException("remaining should be 0");
        }
        this.f10822a = i10;
        ByteBuffer byteBuffer2 = this.f10823b;
        if (byteBuffer2 != null) {
            l0.m(byteBuffer2);
            if (byteBuffer2.capacity() < i10) {
                this.f10823b = ByteBuffer.allocate(i10);
            }
        } else {
            this.f10823b = ByteBuffer.allocate(i10);
        }
        ByteBuffer byteBuffer3 = this.f10823b;
        l0.m(byteBuffer3);
        byteBuffer3.clear();
        b(byteBuffer);
    }

    @os.l
    public final ByteBuffer d(@os.m Integer num) {
        ByteBuffer byteBuffer = this.f10823b;
        l0.m(byteBuffer);
        byteBuffer.flip();
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        if (num != null) {
            this.f10824c.clear();
            this.f10824c.asIntBuffer().put(num.intValue());
            this.f10824c.clear();
            l0.o(byteBufferSlice, "view");
            ByteBuffer byteBuffer2 = this.f10824c;
            l0.o(byteBuffer2, "maskBuffer");
            s.a(byteBufferSlice, byteBuffer2);
        }
        this.f10823b = null;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBufferSlice.asReadOnlyBuffer();
        l0.o(byteBufferAsReadOnlyBuffer, "buffer!!.run {\n        f….asReadOnlyBuffer()\n    }");
        return byteBufferAsReadOnlyBuffer;
    }
}
