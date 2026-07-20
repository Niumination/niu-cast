package e2;

import b1.e;
import c1.y;
import f1.k3;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
@b1.b
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f4043a = new y("");

    public static int a(Deque<CharSequence> stack, CharSequence encoded, int start, k3.b<String, b> builder) {
        int length = encoded.length();
        char cCharAt = 0;
        int i10 = start;
        while (i10 < length && (cCharAt = encoded.charAt(i10)) != '&' && cCharAt != '?' && cCharAt != '!' && cCharAt != ':' && cCharAt != ',') {
            i10++;
        }
        stack.push(d(encoded.subSequence(start, i10)));
        if (cCharAt == '!' || cCharAt == '?' || cCharAt == ':' || cCharAt == ',') {
            String strK = f4043a.k(stack);
            if (strK.length() > 0) {
                builder.i(strK, b.fromCode(cCharAt));
            }
        }
        int iA = i10 + 1;
        if (cCharAt != '?' && cCharAt != ',') {
            while (iA < length) {
                iA += a(stack, encoded, iA, builder);
                if (encoded.charAt(iA) == '?' || encoded.charAt(iA) == ',') {
                    iA++;
                    break;
                }
            }
        }
        stack.pop();
        return iA - start;
    }

    @e
    public static k3<String, b> b(String encoded) {
        k3.b bVarBuilder = k3.builder();
        int length = encoded.length();
        int iA = 0;
        while (iA < length) {
            iA += a(new ArrayDeque(), encoded, iA, bVarBuilder);
        }
        return bVarBuilder.d();
    }

    public static k3<String, b> c(CharSequence... encodedChunks) {
        return b(f4043a.n(encodedChunks));
    }

    public static CharSequence d(CharSequence s10) {
        return new StringBuilder(s10).reverse();
    }
}
