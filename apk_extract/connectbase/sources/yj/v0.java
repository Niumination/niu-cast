package yj;

import io.netty.buffer.ByteBuf;
import wj.r3;

/* JADX INFO: loaded from: classes2.dex */
public class v0 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuf f21297a;

    public v0(ByteBuf byteBuf) {
        this.f21297a = byteBuf;
    }

    @Override // wj.r3
    public int a() {
        return this.f21297a.writableBytes();
    }

    @Override // wj.r3
    public void b(byte b10) {
        this.f21297a.writeByte(b10);
    }

    public ByteBuf c() {
        return this.f21297a;
    }

    @Override // wj.r3
    public int e() {
        return this.f21297a.readableBytes();
    }

    @Override // wj.r3
    public void release() {
        this.f21297a.release();
    }

    @Override // wj.r3
    public void write(byte[] bArr, int i10, int i11) {
        this.f21297a.writeBytes(bArr, i10, i11);
    }
}
