package yj;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class k0 extends wj.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuf f21071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21072b;

    public k0(ByteBuf byteBuf) {
        this.f21071a = (ByteBuf) c1.h0.F(byteBuf, "buffer");
    }

    @Override // wj.i2
    public void B0(ByteBuffer byteBuffer) {
        this.f21071a.readBytes(byteBuffer);
    }

    @Override // wj.b, wj.i2
    public boolean G0() {
        return this.f21071a.hasArray();
    }

    @Override // wj.i2
    public void P1(OutputStream outputStream, int i10) {
        try {
            this.f21071a.readBytes(outputStream, i10);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // wj.b, wj.i2
    public byte[] S() {
        return this.f21071a.array();
    }

    @Override // wj.b, wj.i2
    public int U1() {
        return this.f21071a.readerIndex() + this.f21071a.arrayOffset();
    }

    public ByteBuf c() {
        return this.f21071a;
    }

    @Override // wj.b, wj.i2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f21072b) {
            return;
        }
        this.f21072b = true;
        this.f21071a.release();
    }

    @Override // wj.i2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public k0 u(int i10) {
        return new k0(this.f21071a.readRetainedSlice(i10));
    }

    @Override // wj.i2
    public int e() {
        return this.f21071a.readableBytes();
    }

    @Override // wj.b, wj.i2
    public ByteBuffer i() {
        int iNioBufferCount = this.f21071a.nioBufferCount();
        ByteBuf byteBuf = this.f21071a;
        return iNioBufferCount == 1 ? byteBuf.nioBuffer() : byteBuf.nioBuffers()[0];
    }

    @Override // wj.b, wj.i2
    public boolean l() {
        return this.f21071a.nioBufferCount() > 0;
    }

    @Override // wj.b, wj.i2
    public boolean markSupported() {
        return true;
    }

    @Override // wj.i2
    public void p1(byte[] bArr, int i10, int i11) {
        this.f21071a.readBytes(bArr, i10, i11);
    }

    @Override // wj.i2
    public int readUnsignedByte() {
        return this.f21071a.readUnsignedByte();
    }

    @Override // wj.b, wj.i2
    public void reset() {
        this.f21071a.resetReaderIndex();
    }

    @Override // wj.i2
    public void skipBytes(int i10) {
        this.f21071a.skipBytes(i10);
    }

    @Override // wj.i2
    public void touch() {
        this.f21071a.touch();
    }

    @Override // wj.b, wj.i2
    public void y1() {
        this.f21071a.markReaderIndex();
    }
}
