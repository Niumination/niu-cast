package j1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@b1.a
@l
public interface j0 {
    @t1.a
    j0 a(byte[] bytes);

    @t1.a
    j0 b(char c10);

    @t1.a
    j0 c(byte b10);

    @t1.a
    j0 d(CharSequence charSequence);

    @t1.a
    j0 e(byte[] bytes, int off, int len);

    @t1.a
    j0 f(ByteBuffer bytes);

    @t1.a
    j0 g(CharSequence charSequence, Charset charset);

    @t1.a
    j0 putBoolean(boolean b10);

    @t1.a
    j0 putDouble(double d10);

    @t1.a
    j0 putFloat(float f10);

    @t1.a
    j0 putInt(int i10);

    @t1.a
    j0 putLong(long l10);

    @t1.a
    j0 putShort(short s10);
}
