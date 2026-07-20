package j1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@l
public abstract class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f8373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8375c;

    public f(int chunkSize, int bufferSize) {
        c1.h0.d(bufferSize % chunkSize == 0);
        this.f8373a = ByteBuffer.allocate(bufferSize + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f8374b = bufferSize;
        this.f8375c = chunkSize;
    }

    @Override // j1.s
    public final q i() {
        k();
        this.f8373a.flip();
        if (this.f8373a.remaining() > 0) {
            n(this.f8373a);
            ByteBuffer byteBuffer = this.f8373a;
            byteBuffer.position(byteBuffer.limit());
        }
        return j();
    }

    public abstract q j();

    public final void k() {
        this.f8373a.flip();
        while (this.f8373a.remaining() >= this.f8375c) {
            m(this.f8373a);
        }
        this.f8373a.compact();
    }

    public final void l() {
        if (this.f8373a.remaining() < 8) {
            k();
        }
    }

    public abstract void m(ByteBuffer bb2);

    public void n(ByteBuffer bb2) {
        bb2.position(bb2.limit());
        bb2.limit(this.f8375c + 7);
        while (true) {
            int iPosition = bb2.position();
            int i10 = this.f8375c;
            if (iPosition >= i10) {
                bb2.limit(i10);
                bb2.flip();
                m(bb2);
                return;
            }
            bb2.putLong(0L);
        }
    }

    @t1.a
    public final s o(ByteBuffer readBuffer) {
        if (readBuffer.remaining() <= this.f8373a.remaining()) {
            this.f8373a.put(readBuffer);
            l();
            return this;
        }
        int iPosition = this.f8374b - this.f8373a.position();
        for (int i10 = 0; i10 < iPosition; i10++) {
            this.f8373a.put(readBuffer.get());
        }
        k();
        while (readBuffer.remaining() >= this.f8375c) {
            m(readBuffer);
        }
        this.f8373a.put(readBuffer);
        return this;
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public final s b(char c10) {
        this.f8373a.putChar(c10);
        l();
        return this;
    }

    @Override // j1.s, j1.j0
    @t1.a
    public final s c(byte b10) {
        this.f8373a.put(b10);
        l();
        return this;
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public final s e(byte[] bytes, int off, int len) {
        return o(ByteBuffer.wrap(bytes, off, len).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public final s f(ByteBuffer readBuffer) {
        ByteOrder byteOrderOrder = readBuffer.order();
        try {
            readBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return o(readBuffer);
        } finally {
            readBuffer.order(byteOrderOrder);
        }
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public final s putInt(int i10) {
        this.f8373a.putInt(i10);
        l();
        return this;
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public final s putLong(long l10) {
        this.f8373a.putLong(l10);
        l();
        return this;
    }

    @Override // j1.d, j1.s, j1.j0
    @t1.a
    public final s putShort(short s10) {
        this.f8373a.putShort(s10);
        l();
        return this;
    }

    public f(int chunkSize) {
        this(chunkSize, chunkSize);
    }
}
