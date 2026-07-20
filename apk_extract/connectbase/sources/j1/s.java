package j1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@b1.a
@l
public interface s extends j0 {
    @Override // j1.j0
    @t1.a
    s a(byte[] bytes);

    @Override // j1.j0
    @t1.a
    s b(char c10);

    @Override // j1.j0
    @t1.a
    s c(byte b10);

    @Override // j1.j0
    @t1.a
    s d(CharSequence charSequence);

    @Override // j1.j0
    @t1.a
    s e(byte[] bytes, int off, int len);

    @Override // j1.j0
    @t1.a
    s f(ByteBuffer bytes);

    @Override // j1.j0
    @t1.a
    s g(CharSequence charSequence, Charset charset);

    @t1.a
    <T> s h(@i0 T instance, o<? super T> funnel);

    @Deprecated
    int hashCode();

    q i();

    @Override // j1.j0
    @t1.a
    s putBoolean(boolean b10);

    @Override // j1.j0
    @t1.a
    s putDouble(double d10);

    @Override // j1.j0
    @t1.a
    s putFloat(float f10);

    @Override // j1.j0
    @t1.a
    s putInt(int i10);

    @Override // j1.j0
    @t1.a
    s putLong(long l10);

    @Override // j1.j0
    @t1.a
    s putShort(short s10);
}
