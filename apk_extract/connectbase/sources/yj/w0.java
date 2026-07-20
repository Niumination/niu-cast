package yj;

import io.netty.buffer.ByteBufAllocator;
import wj.r3;
import wj.s3;

/* JADX INFO: loaded from: classes2.dex */
public class w0 implements s3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21298b = 4096;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21299c = 1048576;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBufAllocator f21300a;

    public w0(ByteBufAllocator byteBufAllocator) {
        this.f21300a = byteBufAllocator;
    }

    @Override // wj.s3
    public r3 a(int i10) {
        int iMin = Math.min(1048576, Math.max(4096, i10));
        return new v0(this.f21300a.buffer(iMin, iMin));
    }
}
