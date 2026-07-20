package ql;

import java.nio.ByteBuffer;
import kn.l0;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
@z0
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final e f14042a = new e();

    @Override // ql.a
    public void a(@os.l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "instance");
    }

    @Override // ql.a
    @os.l
    public ByteBuffer b(long j10) {
        if (j10 < 2147483647L) {
            return c((int) j10);
        }
        throw d.a(j10, ik.f.b.f7973h);
    }

    @Override // ql.a
    @os.l
    public ByteBuffer c(int i10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i10);
        l0.o(byteBufferAllocate, "allocate(size)");
        return f.c(byteBufferAllocate);
    }
}
