package k3;

import java.io.EOFException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class bb {
    public static final String a(CharsetDecoder charsetDecoder, wi.k input, int i8) throws EOFException {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        StringBuilder dst = new StringBuilder((int) Math.min(i8, input.getBuffer().f10764c));
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Charset charset = charsetDecoder.charset();
        Intrinsics.checkNotNull(charset);
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            String strB = wi.p.b(input);
            dst.append((CharSequence) strB);
            strB.getClass();
        } else {
            lh.a.e(input);
            Intrinsics.checkNotNullParameter(input, "<this>");
            Intrinsics.checkNotNullParameter(input, "<this>");
            byte[] byteArray = wi.o.d(input, -1);
            Intrinsics.checkNotNullParameter(byteArray, "array");
            xi.a aVar = xi.a.f11006c;
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            xi.a aVar2 = new xi.a(byteArray);
            Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
            Charset charset2 = charsetDecoder.charset();
            Intrinsics.checkNotNull(charset2);
            Intrinsics.checkNotNullParameter(aVar2, "<this>");
            Intrinsics.checkNotNullParameter(charset2, "charset");
            dst.append((CharSequence) new String(byteArray, charset2));
        }
        String string = dst.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final void b(CharsetEncoder charsetEncoder, wi.a dst, CharSequence input, int i8, int i9) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(dst, "destination");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i8 >= i9) {
            return;
        }
        do {
            Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(dst, "dst");
            byte[] bArrA = ab.a(charsetEncoder, input, i8, i9);
            dst.o(bArrA, 0, bArrA.length);
            int length = bArrA.length;
            if (length < 0) {
                throw new IllegalStateException("Check failed.");
            }
            i8 += length;
        } while (i8 < i9);
    }
}
