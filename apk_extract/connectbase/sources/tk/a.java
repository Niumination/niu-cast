package tk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kn.l0;
import lm.a1;
import lm.k;
import lm.m;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@k(level = m.WARNING, message = "ByteBufferPool is moved to `io` module", replaceWith = @a1(expression = "ByteBufferPool", imports = {"io.ktor.utils.io.pool.ByteBufferPool"}))
public final class a extends bm.d<ByteBuffer> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15765i;

    public a(int i10, int i11) {
        super(i11);
        this.f15765i = i10;
    }

    @Override // bm.d
    @l
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public ByteBuffer n() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.f15765i);
        l0.o(byteBufferAllocateDirect, "allocateDirect(bufferSize)");
        return byteBufferAllocateDirect;
    }

    @Override // bm.d
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public void t(@l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "instance");
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (byteBuffer.capacity() != this.f15765i) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @Override // bm.d
    @l
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public ByteBuffer d(@l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "instance");
        byteBuffer.clear();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }
}
