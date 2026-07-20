package fp;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f6259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f6260b;

    public interface a {
        int getNumber();
    }

    public interface b<T extends a> {
        T findValueByNumber(int i10);
    }

    static {
        byte[] bArr = new byte[0];
        f6259a = bArr;
        f6260b = ByteBuffer.wrap(bArr);
    }

    public static boolean a(byte[] bArr) {
        return y.f(bArr, 0, bArr.length);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }
}
