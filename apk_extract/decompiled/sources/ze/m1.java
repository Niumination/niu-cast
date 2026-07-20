package ze;

import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;
import k3.v8;
import k3.w8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BitSet f11379d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f11381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11382c;

    static {
        BitSet bitSet = new BitSet(127);
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        for (char c9 = '0'; c9 <= '9'; c9 = (char) (c9 + 1)) {
            bitSet.set(c9);
        }
        for (char c10 = 'a'; c10 <= 'z'; c10 = (char) (c10 + 1)) {
            bitSet.set(c10);
        }
        f11379d = bitSet;
    }

    public m1(String str, boolean z2, Object obj) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        v8.i(lowerCase, "name");
        v8.c("token must have at least 1 tchar", !lowerCase.isEmpty());
        if (lowerCase.equals("connection")) {
            p1.f11397c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
        }
        for (int i8 = 0; i8 < lowerCase.length(); i8++) {
            char cCharAt = lowerCase.charAt(i8);
            if ((!z2 || cCharAt != ':' || i8 != 0) && !f11379d.get(cCharAt)) {
                throw new IllegalArgumentException(w8.a("Invalid character '%s' in key name '%s'", Character.valueOf(cCharAt), lowerCase));
            }
        }
        this.f11380a = lowerCase;
        this.f11381b = lowerCase.getBytes(h4.f.f5247a);
        this.f11382c = obj;
    }

    public abstract Object a(byte[] bArr);

    public abstract byte[] b(Object obj);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f11380a.equals(((m1) obj).f11380a);
    }

    public final int hashCode() {
        return this.f11380a.hashCode();
    }

    public final String toString() {
        return h0.a.n(new StringBuilder("Key{name='"), this.f11380a, "'}");
    }
}
