package j1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@l
public abstract class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f8358a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    @t1.a
    public final s j(int bytes) {
        try {
            n(this.f8358a.array(), 0, bytes);
            return this;
        } finally {
            this.f8358a.clear();
        }
    }

    public abstract void k(byte b10);

    public void l(ByteBuffer b10) {
        if (b10.hasArray()) {
            n(b10.array(), b10.position() + b10.arrayOffset(), b10.remaining());
            b10.position(b10.limit());
            return;
        }
        for (int iRemaining = b10.remaining(); iRemaining > 0; iRemaining--) {
            k(b10.get());
        }
    }

    public void m(byte[] b10) {
        n(b10, 0, b10.length);
    }

    public void n(byte[] b10, int off, int len) {
        for (int i10 = off; i10 < off + len; i10++) {
            k(b10[i10]);
        }
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public s a(byte[] bytes) {
        bytes.getClass();
        m(bytes);
        return this;
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public s b(char c10) {
        this.f8358a.putChar(c10);
        return j(2);
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s c(byte b10) {
        k(b10);
        return this;
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public s e(byte[] bytes, int off, int len) {
        c1.h0.f0(off, off + len, bytes.length);
        n(bytes, off, len);
        return this;
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public s f(ByteBuffer bytes) {
        l(bytes);
        return this;
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public s putInt(int i10) {
        this.f8358a.putInt(i10);
        return j(4);
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public s putLong(long l10) {
        this.f8358a.putLong(l10);
        return j(8);
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public s putShort(short s10) {
        this.f8358a.putShort(s10);
        return j(2);
    }
}
