package j1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public abstract class c implements r {
    @Override // j1.r
    public q hashBytes(byte[] input) {
        return hashBytes(input, 0, input.length);
    }

    @Override // j1.r
    public q hashInt(int input) {
        return newHasher(4).putInt(input).i();
    }

    @Override // j1.r
    public q hashLong(long input) {
        return newHasher(8).putLong(input).i();
    }

    @Override // j1.r
    public <T> q hashObject(@i0 T instance, o<? super T> funnel) {
        return newHasher().h(instance, funnel).i();
    }

    @Override // j1.r
    public q hashString(CharSequence input, Charset charset) {
        return newHasher().g(input, charset).i();
    }

    @Override // j1.r
    public q hashUnencodedChars(CharSequence input) {
        return newHasher(input.length() * 2).d(input).i();
    }

    @Override // j1.r
    public s newHasher(int expectedInputSize) {
        c1.h0.k(expectedInputSize >= 0, "expectedInputSize must be >= 0 but was %s", expectedInputSize);
        return newHasher();
    }

    @Override // j1.r
    public q hashBytes(byte[] input, int off, int len) {
        c1.h0.f0(off, off + len, input.length);
        return newHasher(len).e(input, off, len).i();
    }

    @Override // j1.r
    public q hashBytes(ByteBuffer input) {
        return newHasher(input.remaining()).f(input).i();
    }
}
