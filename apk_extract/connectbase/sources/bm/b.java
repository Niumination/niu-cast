package bm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kn.l0;
import kn.w;
import os.l;
import tl.f0;

/* JADX INFO: loaded from: classes2.dex */
@f0
public final class b extends d<ByteBuffer> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f967i;

    /* JADX WARN: Illegal instructions before constructor call */
    public b() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    public final int A() {
        return this.f967i;
    }

    @Override // bm.d
    @l
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public ByteBuffer n() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f967i);
        l0.m(byteBufferAllocate);
        return byteBufferAllocate;
    }

    @Override // bm.d
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void t(@l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "instance");
        if (byteBuffer.capacity() != this.f967i) {
            throw new IllegalStateException("Check failed.");
        }
        if (byteBuffer.isDirect()) {
            throw new IllegalStateException("Check failed.");
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

    public /* synthetic */ b(int i10, int i11, int i12, w wVar) {
        this((i12 & 1) != 0 ? 2000 : i10, (i12 & 2) != 0 ? 4096 : i11);
    }

    public b(int i10, int i11) {
        super(i10);
        this.f967i = i11;
    }
}
