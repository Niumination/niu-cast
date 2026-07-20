package l3;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f7328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f7329b;

    static {
        Charset.forName("US-ASCII");
        f7328a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f7329b = bArr;
        ByteBuffer.wrap(bArr);
    }
}
