package j1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@l
public abstract class d implements s {
    @Override // j1.s
    @t1.a
    public <T> s h(@i0 T instance, o<? super T> funnel) {
        funnel.funnel(instance, this);
        return this;
    }

    @Override // j1.s, j1.j0
    @t1.a
    public final s putBoolean(boolean z10) {
        return c(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s a(byte[] bytes) {
        return e(bytes, 0, bytes.length);
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s b(char c10) {
        c((byte) c10);
        c((byte) (c10 >>> '\b'));
        return this;
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s d(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            b(charSequence.charAt(i10));
        }
        return this;
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s e(byte[] bytes, int off, int len) {
        c1.h0.f0(off, off + len, bytes.length);
        for (int i10 = 0; i10 < len; i10++) {
            c(bytes[off + i10]);
        }
        return this;
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s f(ByteBuffer b10) {
        if (b10.hasArray()) {
            e(b10.array(), b10.position() + b10.arrayOffset(), b10.remaining());
            b10.position(b10.limit());
        } else {
            for (int iRemaining = b10.remaining(); iRemaining > 0; iRemaining--) {
                c(b10.get());
            }
        }
        return this;
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s g(CharSequence charSequence, Charset charset) {
        return a(charSequence.toString().getBytes(charset));
    }

    @Override // j1.s, j1.j0
    @t1.a
    public j0 putBoolean(boolean z10) {
        return c(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // j1.s, j1.j0
    @t1.a
    public final s putDouble(double d10) {
        return putLong(Double.doubleToRawLongBits(d10));
    }

    @Override // j1.s, j1.j0
    @t1.a
    public final s putFloat(float f10) {
        return putInt(Float.floatToRawIntBits(f10));
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s putInt(int i10) {
        c((byte) i10);
        c((byte) (i10 >>> 8));
        c((byte) (i10 >>> 16));
        c((byte) (i10 >>> 24));
        return this;
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s putLong(long l10) {
        for (int i10 = 0; i10 < 64; i10 += 8) {
            c((byte) (l10 >>> i10));
        }
        return this;
    }

    @Override // j1.s, j1.j0
    @t1.a
    public s putShort(short s10) {
        c((byte) s10);
        c((byte) (s10 >>> 8));
        return this;
    }
}
