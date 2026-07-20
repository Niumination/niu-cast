package k3;

import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class s9 {
    public static df.m a(String statusLine) throws ProtocolException {
        dj.d0 d0Var;
        int i8;
        String strSubstring;
        Intrinsics.checkNotNullParameter(statusLine, "statusLine");
        if (StringsKt__StringsJVMKt.startsWith$default(statusLine, "HTTP/1.", false, 2, null)) {
            i8 = 9;
            if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            int iCharAt = statusLine.charAt(7) - '0';
            if (iCharAt == 0) {
                d0Var = dj.d0.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                d0Var = dj.d0.HTTP_1_1;
            }
        } else {
            if (!StringsKt__StringsJVMKt.startsWith$default(statusLine, "ICY ", false, 2, null)) {
                throw new ProtocolException(h0.a.i("Unexpected status line: ", statusLine));
            }
            d0Var = dj.d0.HTTP_1_0;
            i8 = 4;
        }
        int i9 = i8 + 3;
        if (statusLine.length() < i9) {
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
        try {
            String strSubstring2 = statusLine.substring(i8, i9);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int i10 = Integer.parseInt(strSubstring2);
            if (statusLine.length() <= i9) {
                strSubstring = "";
            } else {
                if (statusLine.charAt(i9) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                strSubstring = statusLine.substring(i8 + 4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            }
            return new df.m(d0Var, i10, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
    }
}
