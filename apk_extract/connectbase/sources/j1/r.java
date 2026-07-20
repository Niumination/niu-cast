package j1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public interface r {
    int bits();

    q hashBytes(ByteBuffer input);

    q hashBytes(byte[] input);

    q hashBytes(byte[] input, int off, int len);

    q hashInt(int input);

    q hashLong(long input);

    <T> q hashObject(@i0 T instance, o<? super T> funnel);

    q hashString(CharSequence input, Charset charset);

    q hashUnencodedChars(CharSequence input);

    s newHasher();

    s newHasher(int expectedInputSize);
}
