package kotlin.io.encoding;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.core.pool.TranssionPoolExecutor;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a5\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b¨\u0006\u000e"}, d2 = {"platformCharsToBytes", "", "Lkotlin/io/encoding/Base64;", TranssionPoolExecutor.DEFAULT_SOURCE_EXECUTOR_NAME, "", "startIndex", "", "endIndex", "platformEncodeToString", "", "platformEncodeIntoByteArray", "destination", "destinationOffset", "platformEncodeToByteArray", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Base64JVMKt {
    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final byte[] platformCharsToBytes(Base64 base64, CharSequence source, int i8, int i9) {
        Intrinsics.checkNotNullParameter(base64, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(source instanceof String)) {
            return base64.charsToBytesImpl$kotlin_stdlib(source, i8, i9);
        }
        String str = (String) source;
        base64.checkSourceBounds$kotlin_stdlib(str.length(), i8, i9);
        String strSubstring = str.substring(i8, i9);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Charset charset = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strSubstring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final int platformEncodeIntoByteArray(Base64 base64, byte[] source, byte[] destination, int i8, int i9, int i10) {
        Intrinsics.checkNotNullParameter(base64, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return base64.encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, i8, i9, i10);
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final byte[] platformEncodeToByteArray(Base64 base64, byte[] source, int i8, int i9) {
        Intrinsics.checkNotNullParameter(base64, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return base64.encodeToByteArrayImpl$kotlin_stdlib(source, i8, i9);
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final String platformEncodeToString(Base64 base64, byte[] source, int i8, int i9) {
        Intrinsics.checkNotNullParameter(base64, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return new String(base64.encodeToByteArrayImpl$kotlin_stdlib(source, i8, i9), Charsets.ISO_8859_1);
    }
}
