package wj;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s0 implements i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i2 f19257a;

    public s0(i2 i2Var) {
        this.f19257a = (i2) c1.h0.F(i2Var, "buf");
    }

    @Override // wj.i2
    public void B0(ByteBuffer byteBuffer) {
        this.f19257a.B0(byteBuffer);
    }

    @Override // wj.i2
    public boolean G0() {
        return this.f19257a.G0();
    }

    @Override // wj.i2
    public void P1(OutputStream outputStream, int i10) throws IOException {
        this.f19257a.P1(outputStream, i10);
    }

    @Override // wj.i2
    public byte[] S() {
        return this.f19257a.S();
    }

    @Override // wj.i2
    public int U1() {
        return this.f19257a.U1();
    }

    @Override // wj.i2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19257a.close();
    }

    @Override // wj.i2
    public int e() {
        return this.f19257a.e();
    }

    @Override // wj.i2
    @gm.j
    public ByteBuffer i() {
        return this.f19257a.i();
    }

    @Override // wj.i2
    public boolean l() {
        return this.f19257a.l();
    }

    @Override // wj.i2
    public boolean markSupported() {
        return this.f19257a.markSupported();
    }

    @Override // wj.i2
    public void p1(byte[] bArr, int i10, int i11) {
        this.f19257a.p1(bArr, i10, i11);
    }

    @Override // wj.i2
    public int readInt() {
        return this.f19257a.readInt();
    }

    @Override // wj.i2
    public int readUnsignedByte() {
        return this.f19257a.readUnsignedByte();
    }

    @Override // wj.i2
    public void reset() {
        this.f19257a.reset();
    }

    @Override // wj.i2
    public void skipBytes(int i10) {
        this.f19257a.skipBytes(i10);
    }

    public String toString() {
        return c1.z.c(this).j("delegate", this.f19257a).toString();
    }

    @Override // wj.i2
    public void touch() {
        this.f19257a.touch();
    }

    @Override // wj.i2
    public i2 u(int i10) {
        return this.f19257a.u(i10);
    }

    @Override // wj.i2
    public void y1() {
        this.f19257a.y1();
    }
}
