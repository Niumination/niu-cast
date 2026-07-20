package gl;

import fl.t0;
import java.nio.ByteBuffer;
import kn.l0;
import lm.a1;
import lm.m;

/* JADX INFO: loaded from: classes2.dex */
@t0
@lm.k(level = m.WARNING, message = "ByteBufferPool is moved to `io` module", replaceWith = @a1(expression = "ByteBufferPool", imports = {"io.ktor.utils.io.pool.ByteBufferPool"}))
public final class a extends bm.d<ByteBuffer> {
    public a() {
        super(2048);
    }

    @Override // bm.d
    @os.l
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public ByteBuffer n() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4098);
        l0.o(byteBufferAllocate, "allocate(DEFAULT_BUFFER_SIZE)");
        return byteBufferAllocate;
    }

    @Override // bm.d
    @os.l
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public ByteBuffer d(@os.l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "instance");
        byteBuffer.clear();
        return byteBuffer;
    }
}
