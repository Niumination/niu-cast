package ze;

import java.nio.charset.Charset;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f11435a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j4.c f11436b = p1.e;

    public static n1 a(String str, s0 s0Var) {
        boolean z2 = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            z2 = true;
        }
        BitSet bitSet = m1.f11379d;
        return new n1(str, z2, s0Var);
    }
}
