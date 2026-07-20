package kotlin.text;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0001\n\u0000\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010\r\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a,\u0010\u0014\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u0019\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u001a\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a<\u0010\u001b\u001a\u00020\u0012*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a,\u0010\u001b\u001a\u00020\u0012*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a(\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0002\u001a@\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0000\u001a\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002\u001a\u0016\u0010-\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010-\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a&\u0010.\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a&\u0010/\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a&\u00100\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a$\u00101\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a\u0014\u00102\u001a\u000203*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0002\u001a@\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0000\u001a \u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012H\u0002\u001a \u0010:\u001a\u00020,2\u0006\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002\u001a\u001c\u0010;\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u0016\u0010\r\u001a\u00020\u0001*\u0002032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010<\u001a\u000203*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010<\u001a\u000203*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020=2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010>\u001a\u00020=*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010>\u001a\u00020=*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010?\u001a\u00020\u0012*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010?\u001a\u00020\u0012*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020,2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010@\u001a\u00020,*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010@\u001a\u00020,*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001\u001a$\u0010A\u001a\u00020\u0001*\u00020,2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u0012H\u0003\u001a\u001c\u0010F\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a,\u0010G\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0003\u001a,\u0010I\u001a\u00020,*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0003\u001a<\u0010J\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020O2\u0006\u0010H\u001a\u00020\u0012H\u0002\u001a$\u0010P\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0012H\u0002\u001a\u001c\u0010Q\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u001c\u0010R\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u001c\u0010S\u001a\u00020,*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a5\u0010T\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00012\u0006\u0010N\u001a\u00020O2\u0006\u0010V\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010W\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0082\b\u001a\u0015\u0010X\u001a\u00020,*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0082\b\u001a,\u0010Y\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\u0012H\u0002\u001a,\u0010\\\u001a\u00020K*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u0001H\u0002\u001a,\u0010]\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u0001H\u0002\u001a\u0014\u0010^\u001a\u00020_*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations", "()V", "getBYTE_TO_LOWER_CASE_HEX_DIGITS", "()[I", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "toHexString", "", "format", "Lkotlin/text/HexFormat;", "startIndex", "", "endIndex", "toHexStringNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "byteToDigits", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringSlowPath", "formatByteAt", "index", "bytePrefix", "byteSuffix", "destination", "", "destinationOffset", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "checkFormatLength", "formatLength", "", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArraySlowPath", "parseByteAt", "", "parsedByteArrayMaxSize", "stringLength", "charsPerSet", "charsPerElement", "elementsPerSet", "elementSeparatorLength", "wholeElementsPerSet", "checkNewLineAt", "hexToByte", "", "hexToShort", "hexToInt", "hexToLong", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toCharArrayIfNotEmpty", "hexToIntImpl", "typeHexLength", "hexToLongImpl", "checkPrefixSuffixNumberOfDigits", "", "prefix", "suffix", "ignoreCase", "", "checkNumberOfDigits", "checkZeroDigits", "parseInt", "parseLong", "checkContainsAt", "part", "partName", "decimalFromHexDigitAt", "longDecimalFromHexDigitAt", "throwInvalidNumberOfDigits", "specifier", "expected", "throwNotContainedAt", "throwInvalidPrefixSuffix", "throwInvalidDigitAt", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1249:1\n1198#1,7:1251\n1198#1,7:1258\n1198#1,7:1265\n1198#1,7:1272\n1198#1,7:1279\n1198#1,7:1286\n1198#1,7:1293\n1198#1,7:1300\n1209#1,5:1307\n1209#1,5:1312\n1198#1,7:1317\n1198#1,7:1324\n1209#1,5:1331\n1218#1,5:1336\n1#2:1250\n1188#3,3:1341\n1188#3,3:1344\n1188#3,3:1347\n1188#3,3:1350\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n457#1:1251,7\n490#1:1258,7\n494#1:1265,7\n497#1:1272,7\n538#1:1279,7\n541#1:1286,7\n546#1:1293,7\n551#1:1300,7\n558#1:1307,5\n559#1:1312,5\n1153#1:1317,7\n1155#1:1324,7\n1183#1:1331,5\n1191#1:1336,5\n43#1:1341,3\n44#1:1344,3\n55#1:1347,3\n56#1:1350,3\n*E\n"})
public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;
    private static final int[] HEX_DIGITS_TO_DECIMAL;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[256];
        int i8 = 0;
        for (int i9 = 0; i9 < 256; i9++) {
            iArr[i9] = LOWER_CASE_HEX_DIGITS.charAt(i9 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(i9 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr2[i10] = UPPER_CASE_HEX_DIGITS.charAt(i10 & 15) | (UPPER_CASE_HEX_DIGITS.charAt(i10 >> 4) << '\b');
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[256];
        for (int i11 = 0; i11 < 256; i11++) {
            iArr3[i11] = -1;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < LOWER_CASE_HEX_DIGITS.length()) {
            iArr3[LOWER_CASE_HEX_DIGITS.charAt(i12)] = i13;
            i12++;
            i13++;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < UPPER_CASE_HEX_DIGITS.length()) {
            iArr3[UPPER_CASE_HEX_DIGITS.charAt(i14)] = i15;
            i14++;
            i15++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] jArr = new long[256];
        for (int i16 = 0; i16 < 256; i16++) {
            jArr[i16] = -1;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < LOWER_CASE_HEX_DIGITS.length()) {
            jArr[LOWER_CASE_HEX_DIGITS.charAt(i17)] = i18;
            i17++;
            i18++;
        }
        int i19 = 0;
        while (i8 < UPPER_CASE_HEX_DIGITS.length()) {
            jArr[UPPER_CASE_HEX_DIGITS.charAt(i8)] = i19;
            i8++;
            i19++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    private static final long charsPerSet(long j8, int i8, int i9) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j10 = i8;
        return ((j10 - 1) * ((long) i9)) + (j8 * j10);
    }

    private static final int checkContainsAt(String str, int i8, int i9, String str2, boolean z2, String str3) {
        if (str2.length() == 0) {
            return i8;
        }
        int length = str2.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!CharsKt__CharKt.equals(str2.charAt(i10), str.charAt(i8 + i10), z2)) {
                throwNotContainedAt(str, i8, i9, str2, str3);
            }
        }
        return str2.length() + i8;
    }

    private static final int checkFormatLength(long j8) {
        if (0 <= j8 && j8 <= 2147483647L) {
            return (int) j8;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m379toStringimpl(ULong.m333constructorimpl(j8))));
    }

    private static final int checkNewLineAt(String str, int i8, int i9) {
        if (str.charAt(i8) == '\r') {
            int i10 = i8 + 1;
            return (i10 >= i9 || str.charAt(i10) != '\n') ? i10 : i8 + 2;
        }
        if (str.charAt(i8) == '\n') {
            return i8 + 1;
        }
        StringBuilder sbU = a1.a.u(i8, "Expected a new line at index ", ", but was ");
        sbU.append(str.charAt(i8));
        throw new NumberFormatException(sbU.toString());
    }

    private static final void checkNumberOfDigits(String str, int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if (i11 < 1) {
            throwInvalidNumberOfDigits(str, i8, i9, "at least", 1);
        } else if (i11 > i10) {
            checkZeroDigits(str, i8, (i11 + i8) - i10);
        }
    }

    private static final void checkPrefixSuffixNumberOfDigits(String str, int i8, int i9, String str2, String str3, boolean z2, int i10) {
        if ((i9 - i8) - str2.length() <= str3.length()) {
            throwInvalidPrefixSuffix(str, i8, i9, str2, str3);
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i11 = 0; i11 < length; i11++) {
                if (!CharsKt__CharKt.equals(str2.charAt(i11), str.charAt(i8 + i11), z2)) {
                    throwNotContainedAt(str, i8, i9, str2, "prefix");
                }
            }
            i8 += str2.length();
        }
        int length2 = i9 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i12 = 0; i12 < length3; i12++) {
                if (!CharsKt__CharKt.equals(str3.charAt(i12), str.charAt(length2 + i12), z2)) {
                    throwNotContainedAt(str, length2, i9, str3, "suffix");
                }
            }
        }
        checkNumberOfDigits(str, i8, length2, i10);
    }

    private static final void checkZeroDigits(String str, int i8, int i9) {
        while (i8 < i9) {
            if (str.charAt(i8) != '0') {
                StringBuilder sbU = a1.a.u(i8, "Expected the hexadecimal digit '0' at index ", ", but was '");
                sbU.append(str.charAt(i8));
                sbU.append("'.\nThe result won't fit the type being parsed.");
                throw new NumberFormatException(sbU.toString());
            }
            i8++;
        }
    }

    private static final int decimalFromHexDigitAt(String str, int i8) {
        int i9;
        char cCharAt = str.charAt(i8);
        if ((cCharAt >>> '\b') == 0 && (i9 = HEX_DIGITS_TO_DECIMAL[cCharAt]) >= 0) {
            return i9;
        }
        throwInvalidDigitAt(str, i8);
        throw new KotlinNothingValueException();
    }

    private static final int formatByteAt(byte[] bArr, int i8, String str, String str2, int[] iArr, char[] cArr, int i9) {
        return toCharArrayIfNotEmpty(str2, cArr, formatByteAt(bArr, i8, iArr, cArr, toCharArrayIfNotEmpty(str, cArr, i9)));
    }

    private static final int formattedStringLength(int i8, int i9, int i10, int i11) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j8 = i9;
        return checkFormatLength((((long) i8) * (((((long) i10) + 2) + ((long) i11)) + j8)) - j8);
    }

    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    @ExperimentalStdlibApi
    public static /* synthetic */ void getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations() {
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte hexToByte(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByte(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte[] hexToByteArray(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByteArray(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String str, int i8, int i9, HexFormat.BytesHexFormat bytesHexFormat) {
        return bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix() ? hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(str, i8, i9, bytesHexFormat) : hexToByteArrayNoLineAndGroupSeparatorSlowPath(str, i8, i9, bytesHexFormat);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String str, int i8, int i9, HexFormat.BytesHexFormat bytesHexFormat) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        long length = byteSeparator.length();
        long length2 = ((long) bytePrefix.length()) + 2 + ((long) byteSuffix.length()) + length;
        long j8 = i9 - i8;
        int i10 = (int) ((j8 + length) / length2);
        if ((((long) i10) * length2) - length != j8) {
            return null;
        }
        boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
        byte[] bArr = new byte[i10];
        if (bytePrefix.length() != 0) {
            int length3 = bytePrefix.length();
            for (int i11 = 0; i11 < length3; i11++) {
                if (!CharsKt__CharKt.equals(bytePrefix.charAt(i11), str.charAt(i8 + i11), ignoreCase$kotlin_stdlib)) {
                    throwNotContainedAt(str, i8, i9, bytePrefix, "byte prefix");
                }
            }
            i8 += bytePrefix.length();
        }
        String strL = o.d.l(byteSuffix, byteSeparator, bytePrefix);
        int i12 = i10 - 1;
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[i13] = parseByteAt(str, i8);
            i8 += 2;
            if (strL.length() != 0) {
                int length4 = strL.length();
                for (int i14 = 0; i14 < length4; i14++) {
                    if (!CharsKt__CharKt.equals(strL.charAt(i14), str.charAt(i8 + i14), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, i8, i9, strL, "byte suffix + byte separator + byte prefix");
                    }
                }
                i8 = strL.length() + i8;
            }
        }
        bArr[i12] = parseByteAt(str, i8);
        int i15 = i8 + 2;
        if (byteSuffix.length() != 0) {
            int length5 = byteSuffix.length();
            for (int i16 = 0; i16 < length5; i16++) {
                if (!CharsKt__CharKt.equals(byteSuffix.charAt(i16), str.charAt(i15 + i16), ignoreCase$kotlin_stdlib)) {
                    throwNotContainedAt(str, i15, i9, byteSuffix, "byte suffix");
                }
            }
        }
        return bArr;
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String str, int i8, int i9, HexFormat.BytesHexFormat bytesHexFormat) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i10 = i9 - i8;
        int i11 = 2;
        if (length == 0) {
            if ((i10 & 1) != 0) {
                return null;
            }
            int i12 = i10 >> 1;
            byte[] bArr = new byte[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                bArr[i14] = parseByteAt(str, i13);
                i13 += 2;
            }
            return bArr;
        }
        if (i10 % 3 != 2) {
            return null;
        }
        int i15 = (i10 / 3) + 1;
        byte[] bArr2 = new byte[i15];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        bArr2[0] = parseByteAt(str, 0);
        for (int i16 = 1; i16 < i15; i16++) {
            if (str.charAt(i11) != cCharAt) {
                String byteSeparator = bytesHexFormat.getByteSeparator();
                boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
                if (byteSeparator.length() != 0) {
                    int length2 = byteSeparator.length();
                    for (int i17 = 0; i17 < length2; i17++) {
                        if (!CharsKt__CharKt.equals(byteSeparator.charAt(i17), str.charAt(i11 + i17), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, i11, i9, byteSeparator, "byte separator");
                        }
                    }
                    byteSeparator.length();
                }
            }
            bArr2[i16] = parseByteAt(str, i11 + 1);
            i11 += 3;
        }
        return bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00da  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:45:0x010e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0124  */
    /* JADX WARN: Code duplicated, block: B:49:0x0127  */
    /* JADX WARN: Code duplicated, block: B:51:0x012e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0140  */
    /* JADX WARN: Code duplicated, block: B:66:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00fc A[SYNTHETIC] */
    @ExperimentalStdlibApi
    private static final byte[] hexToByteArraySlowPath(String str, int i8, int i9, HexFormat.BytesHexFormat bytesHexFormat) {
        int i10;
        int i11;
        int i12;
        int i13;
        int length;
        int i14;
        int i15;
        int i16;
        int length2;
        int i17;
        int i18;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
        int i19 = parsedByteArrayMaxSize(i9 - i8, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        byte[] bArr = new byte[i19];
        int length3 = i8;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        while (length3 < i9) {
            if (i21 == bytesPerLine) {
                length3 = checkNewLineAt(str, length3, i9);
                i10 = 0;
            } else {
                if (i22 == bytesPerGroup) {
                    if (groupSeparator.length() == 0) {
                        i12 = i21;
                    } else {
                        int length4 = groupSeparator.length();
                        int i23 = 0;
                        while (i23 < length4) {
                            int i24 = i21;
                            int i25 = length4;
                            if (!CharsKt__CharKt.equals(groupSeparator.charAt(i23), str.charAt(length3 + i23), ignoreCase$kotlin_stdlib)) {
                                throwNotContainedAt(str, length3, i9, groupSeparator, "group separator");
                            }
                            i23++;
                            i21 = i24;
                            length4 = i25;
                        }
                        i12 = i21;
                        length3 += groupSeparator.length();
                    }
                    i10 = i12;
                } else {
                    int i26 = i21;
                    if (i22 != 0) {
                        if (byteSeparator.length() == 0) {
                            i11 = i22;
                        } else {
                            int length5 = byteSeparator.length();
                            int i27 = 0;
                            while (i27 < length5) {
                                int i28 = length5;
                                int i29 = i22;
                                if (!CharsKt__CharKt.equals(byteSeparator.charAt(i27), str.charAt(length3 + i27), ignoreCase$kotlin_stdlib)) {
                                    throwNotContainedAt(str, length3, i9, byteSeparator, "byte separator");
                                }
                                i27++;
                                length5 = i28;
                                i22 = i29;
                            }
                            i11 = i22;
                            length3 += byteSeparator.length();
                        }
                        i10 = i26;
                        i22 = i11;
                    } else {
                        i10 = i26;
                    }
                }
                int i30 = i10 + 1;
                i13 = i22 + 1;
                if (bytePrefix.length() == 0) {
                    i15 = i13;
                } else {
                    length = bytePrefix.length();
                    i14 = 0;
                    while (i14 < length) {
                        int i31 = length;
                        int i32 = i13;
                        if (!CharsKt__CharKt.equals(bytePrefix.charAt(i14), str.charAt(length3 + i14), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, length3, i9, bytePrefix, "byte prefix");
                        }
                        i14++;
                        length = i31;
                        i13 = i32;
                    }
                    i15 = i13;
                    length3 += bytePrefix.length();
                }
                if (i9 - 2 < length3) {
                    throwInvalidNumberOfDigits(str, length3, i9, "exactly", 2);
                }
                i16 = i20 + 1;
                bArr[i20] = parseByteAt(str, length3);
                length3 += 2;
                if (byteSuffix.length() == 0) {
                    i18 = i16;
                } else {
                    length2 = byteSuffix.length();
                    i17 = 0;
                    while (i17 < length2) {
                        int i33 = i16;
                        if (!CharsKt__CharKt.equals(byteSuffix.charAt(i17), str.charAt(length3 + i17), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, length3, i9, byteSuffix, "byte suffix");
                        }
                        i17++;
                        i16 = i33;
                    }
                    i18 = i16;
                    length3 = byteSuffix.length() + length3;
                }
                i21 = i30;
                i20 = i18;
                i22 = i15;
            }
            i22 = 0;
            int i34 = i10 + 1;
            i13 = i22 + 1;
            if (bytePrefix.length() == 0) {
                i15 = i13;
            } else {
                length = bytePrefix.length();
                i14 = 0;
                while (i14 < length) {
                    int i35 = length;
                    int i36 = i13;
                    if (!CharsKt__CharKt.equals(bytePrefix.charAt(i14), str.charAt(length3 + i14), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, length3, i9, bytePrefix, "byte prefix");
                    }
                    i14++;
                    length = i35;
                    i13 = i36;
                }
                i15 = i13;
                length3 += bytePrefix.length();
            }
            if (i9 - 2 < length3) {
                throwInvalidNumberOfDigits(str, length3, i9, "exactly", 2);
            }
            i16 = i20 + 1;
            bArr[i20] = parseByteAt(str, length3);
            length3 += 2;
            if (byteSuffix.length() == 0) {
                i18 = i16;
            } else {
                length2 = byteSuffix.length();
                i17 = 0;
                while (i17 < length2) {
                    int i37 = i16;
                    if (!CharsKt__CharKt.equals(byteSuffix.charAt(i17), str.charAt(length3 + i17), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, length3, i9, byteSuffix, "byte suffix");
                    }
                    i17++;
                    i16 = i37;
                }
                i18 = i16;
                length3 = byteSuffix.length() + length3;
            }
            i21 = i34;
            i20 = i18;
            i22 = i15;
        }
        if (i20 == i19) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i20);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final int hexToInt(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToInt(str, 0, str.length(), format);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final int hexToIntImpl(String str, int i8, int i9, HexFormat hexFormat, int i10) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i8, i9, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i8, i9, i10);
            return parseInt(str, i8, i9);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i8, i9, prefix, suffix, number.getIgnoreCase(), i10);
        return parseInt(str, prefix.length() + i8, i9 - suffix.length());
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final long hexToLong(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLong(str, 0, str.length(), format);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long hexToLongImpl(String str, int i8, int i9, HexFormat hexFormat, int i10) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i8, i9, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i8, i9, i10);
            return parseLong(str, i8, i9);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i8, i9, prefix, suffix, number.getIgnoreCase(), i10);
        return parseLong(str, prefix.length() + i8, i9 - suffix.length());
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final short hexToShort(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToShort(str, 0, str.length(), format);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    private static final long longDecimalFromHexDigitAt(String str, int i8) {
        char cCharAt = str.charAt(i8);
        if ((cCharAt >>> '\b') == 0) {
            long j8 = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
            if (j8 >= 0) {
                return j8;
            }
        }
        throwInvalidDigitAt(str, i8);
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String str, int i8) {
        int[] iArr;
        int i9;
        int i10;
        char cCharAt = str.charAt(i8);
        if ((cCharAt >>> '\b') != 0 || (i9 = (iArr = HEX_DIGITS_TO_DECIMAL)[cCharAt]) < 0) {
            throwInvalidDigitAt(str, i8);
            throw new KotlinNothingValueException();
        }
        int i11 = i8 + 1;
        char cCharAt2 = str.charAt(i11);
        if ((cCharAt2 >>> '\b') == 0 && (i10 = iArr[cCharAt2]) >= 0) {
            return (byte) ((i9 << 4) | i10);
        }
        throwInvalidDigitAt(str, i11);
        throw new KotlinNothingValueException();
    }

    private static final int parseInt(String str, int i8, int i9) {
        int i10;
        int i11 = 0;
        while (i8 < i9) {
            int i12 = i11 << 4;
            char cCharAt = str.charAt(i8);
            if ((cCharAt >>> '\b') != 0 || (i10 = HEX_DIGITS_TO_DECIMAL[cCharAt]) < 0) {
                throwInvalidDigitAt(str, i8);
                throw new KotlinNothingValueException();
            }
            i11 = i12 | i10;
            i8++;
        }
        return i11;
    }

    private static final long parseLong(String str, int i8, int i9) {
        long j8 = 0;
        while (i8 < i9) {
            long j10 = j8 << 4;
            char cCharAt = str.charAt(i8);
            if ((cCharAt >>> '\b') == 0) {
                long j11 = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                if (j11 >= 0) {
                    j8 = j10 | j11;
                    i8++;
                }
            }
            throwInvalidDigitAt(str, i8);
            throw new KotlinNothingValueException();
        }
        return j8;
    }

    public static final int parsedByteArrayMaxSize(int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        long jCharsPerSet;
        if (i8 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j8 = ((long) i13) + 2 + ((long) i14);
        long jCharsPerSet2 = charsPerSet(j8, i10, i12);
        if (i9 <= i10) {
            jCharsPerSet = charsPerSet(j8, i9, i12);
        } else {
            jCharsPerSet = charsPerSet(jCharsPerSet2, i9 / i10, i11);
            int i15 = i9 % i10;
            if (i15 != 0) {
                jCharsPerSet = jCharsPerSet + ((long) i11) + charsPerSet(j8, i15, i12);
            }
        }
        long j10 = i8;
        long jWholeElementsPerSet = wholeElementsPerSet(j10, jCharsPerSet, 1);
        long j11 = j10 - ((jCharsPerSet + 1) * jWholeElementsPerSet);
        long jWholeElementsPerSet2 = wholeElementsPerSet(j11, jCharsPerSet2, i11);
        long j12 = j11 - ((jCharsPerSet2 + ((long) i11)) * jWholeElementsPerSet2);
        long jWholeElementsPerSet3 = wholeElementsPerSet(j12, j8, i12);
        return (int) ((jWholeElementsPerSet2 * ((long) i10)) + (jWholeElementsPerSet * ((long) i9)) + jWholeElementsPerSet3 + ((long) (j12 - ((j8 + ((long) i12)) * jWholeElementsPerSet3) > 0 ? 1 : 0)));
    }

    private static final Void throwInvalidDigitAt(String str, int i8) {
        StringBuilder sbU = a1.a.u(i8, "Expected a hexadecimal digit at index ", ", but was ");
        sbU.append(str.charAt(i8));
        throw new NumberFormatException(sbU.toString());
    }

    private static final void throwInvalidNumberOfDigits(String str, int i8, int i9, String str2, int i10) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i8, i9);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i10 + " hexadecimal digits at index " + i8 + ", but was \"" + strSubstring + "\" of length " + (i9 - i8));
    }

    private static final void throwInvalidPrefixSuffix(String str, int i8, int i9, String str2, String str3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i8, i9);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        StringBuilder sbP = h0.a.p("Expected a hexadecimal number with prefix \"", str2, "\" and suffix \"", str3, "\", but was ");
        sbP.append(strSubstring);
        throw new NumberFormatException(sbP.toString());
    }

    private static final void throwNotContainedAt(String str, int i8, int i9, String str2, String str3) {
        int iCoerceAtMost = RangesKt.coerceAtMost(str2.length() + i8, i9);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i8, iCoerceAtMost);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        StringBuilder sbP = h0.a.p("Expected ", str3, " \"", str2, "\" at index ");
        sbP.append(i8);
        sbP.append(", but was ");
        sbP.append(strSubstring);
        throw new NumberFormatException(sbP.toString());
    }

    private static final int toCharArrayIfNotEmpty(String str, char[] cArr, int i8) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                int length2 = str.length();
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                str.getChars(0, length2, cArr, i8);
            } else {
                cArr[i8] = str.charAt(0);
            }
        }
        return str.length() + i8;
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte[] bArr, HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringImpl(long j8, HexFormat.NumberHexFormat numberHexFormat, String str, int i8) {
        if ((i8 & 3) != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i9 = i8 >> 2;
        int minLength = numberHexFormat.getMinLength();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(minLength - i9, 0);
        String prefix = numberHexFormat.getPrefix();
        String suffix = numberHexFormat.getSuffix();
        boolean removeLeadingZeros = numberHexFormat.getRemoveLeadingZeros();
        int iCheckFormatLength = checkFormatLength(((long) prefix.length()) + ((long) iCoerceAtLeast) + ((long) i9) + ((long) suffix.length()));
        char[] cArr = new char[iCheckFormatLength];
        int charArrayIfNotEmpty = toCharArrayIfNotEmpty(prefix, cArr, 0);
        if (iCoerceAtLeast > 0) {
            int i10 = iCoerceAtLeast + charArrayIfNotEmpty;
            ArraysKt.fill(cArr, str.charAt(0), charArrayIfNotEmpty, i10);
            charArrayIfNotEmpty = i10;
        }
        int i11 = i8;
        for (int i12 = 0; i12 < i9; i12++) {
            i11 -= 4;
            int i13 = (int) ((j8 >> i11) & 15);
            removeLeadingZeros = removeLeadingZeros && i13 == 0 && (i11 >> 2) >= minLength;
            if (!removeLeadingZeros) {
                cArr[charArrayIfNotEmpty] = str.charAt(i13);
                charArrayIfNotEmpty++;
            }
        }
        int charArrayIfNotEmpty2 = toCharArrayIfNotEmpty(suffix, cArr, charArrayIfNotEmpty);
        return charArrayIfNotEmpty2 == iCheckFormatLength ? StringsKt__StringsJVMKt.concatToString(cArr) : StringsKt__StringsJVMKt.concatToString$default(cArr, 0, charArrayIfNotEmpty2, 1, null);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringNoLineAndGroupSeparator(byte[] bArr, int i8, int i9, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        return bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix() ? toHexStringShortByteSeparatorNoPrefixAndSuffix(bArr, i8, i9, bytesHexFormat, iArr) : toHexStringNoLineAndGroupSeparatorSlowPath(bArr, i8, i9, bytesHexFormat, iArr);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] bArr, int i8, int i9, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        char[] cArr = new char[formattedStringLength(i9 - i8, byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        int byteAt = formatByteAt(bArr, i8, bytePrefix, byteSuffix, iArr, cArr, 0);
        while (true) {
            i8++;
            if (i8 >= i9) {
                return StringsKt__StringsJVMKt.concatToString(cArr);
            }
            byteAt = formatByteAt(bArr, i8, bytePrefix, byteSuffix, iArr, cArr, toCharArrayIfNotEmpty(byteSeparator, cArr, byteAt));
        }
    }

    @ExperimentalStdlibApi
    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] bArr, int i8, int i9, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i10 = i9 - i8;
        int byteAt = 0;
        if (length == 0) {
            char[] cArr = new char[checkFormatLength(((long) i10) * 2)];
            while (i8 < i9) {
                byteAt = formatByteAt(bArr, i8, iArr, cArr, byteAt);
                i8++;
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        char[] cArr2 = new char[checkFormatLength((((long) i10) * 3) - 1)];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        int byteAt2 = formatByteAt(bArr, i8, iArr, cArr2, 0);
        for (int i11 = i8 + 1; i11 < i9; i11++) {
            cArr2[byteAt2] = cCharAt;
            byteAt2 = formatByteAt(bArr, i11, iArr, cArr2, byteAt2 + 1);
        }
        return StringsKt__StringsJVMKt.concatToString(cArr2);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringSlowPath(byte[] bArr, int i8, int i9, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int i10;
        int i11;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        int i12 = formattedStringLength(i9 - i8, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        char[] cArr = new char[i12];
        int charArrayIfNotEmpty = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = i8; i15 < i9; i15++) {
            if (i13 == bytesPerLine) {
                cArr[charArrayIfNotEmpty] = '\n';
                charArrayIfNotEmpty++;
                i10 = 0;
                i11 = 0;
            } else if (i14 == bytesPerGroup) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(groupSeparator, cArr, charArrayIfNotEmpty);
                i10 = i13;
                i11 = 0;
            } else {
                i10 = i13;
                i11 = i14;
            }
            if (i11 != 0) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(byteSeparator, cArr, charArrayIfNotEmpty);
            }
            charArrayIfNotEmpty = formatByteAt(bArr, i15, bytePrefix, byteSuffix, iArr, cArr, charArrayIfNotEmpty);
            i14 = i11 + 1;
            i13 = i10 + 1;
        }
        if (charArrayIfNotEmpty == i12) {
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    private static final long wholeElementsPerSet(long j8, long j10, int i8) {
        if (j8 <= 0 || j10 <= 0) {
            return 0L;
        }
        long j11 = i8;
        return (j8 + j11) / (j10 + j11);
    }

    @ExperimentalStdlibApi
    private static final byte hexToByte(String str, int i8, int i9, HexFormat hexFormat) {
        return (byte) hexToIntImpl(str, i8, i9, hexFormat, 2);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArray(String str, int i8, int i9, HexFormat hexFormat) {
        byte[] bArrHexToByteArrayNoLineAndGroupSeparator;
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i8, i9, str.length());
        if (i8 == i9) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        return (!bytes.getNoLineAndGroupSeparator() || (bArrHexToByteArrayNoLineAndGroupSeparator = hexToByteArrayNoLineAndGroupSeparator(str, i8, i9, bytes)) == null) ? hexToByteArraySlowPath(str, i8, i9, bytes) : bArrHexToByteArrayNoLineAndGroupSeparator;
    }

    @ExperimentalStdlibApi
    private static final int hexToInt(String str, int i8, int i9, HexFormat hexFormat) {
        return hexToIntImpl(str, i8, i9, hexFormat, 8);
    }

    @ExperimentalStdlibApi
    public static final long hexToLong(String str, int i8, int i9, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLongImpl(str, i8, i9, format, 16);
    }

    @ExperimentalStdlibApi
    private static final short hexToShort(String str, int i8, int i9, HexFormat hexFormat) {
        return (short) hexToIntImpl(str, i8, i9, hexFormat, 4);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte[] bArr, int i8, int i9, HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i8, i9, bArr.length);
        if (i8 == i9) {
            return "";
        }
        int[] iArr = format.getUpperCase() ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytes = format.getBytes();
        return bytes.getNoLineAndGroupSeparator() ? toHexStringNoLineAndGroupSeparator(bArr, i8, i9, bytes, iArr) : toHexStringSlowPath(bArr, i8, i9, bytes, iArr);
    }

    public static final int formattedStringLength(int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        if (i8 > 0) {
            int i15 = i8 - 1;
            int i16 = i15 / i9;
            int i17 = (i9 - 1) / i10;
            int i18 = i8 % i9;
            if (i18 != 0) {
                i9 = i18;
            }
            int i19 = (i17 * i16) + ((i9 - 1) / i10);
            return checkFormatLength(((((long) i13) + 2 + ((long) i14)) * ((long) i8)) + (((long) ((i15 - i16) - i19)) * ((long) i12)) + (((long) i19) * ((long) i11)) + ((long) i16));
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static /* synthetic */ byte hexToByte$default(String str, int i8, int i9, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, i8, i9, hexFormat);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, int i8, int i9, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, i8, i9, hexFormat);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i8, int i9, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, i8, i9, hexFormat);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i8, int i9, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, i8, i9, hexFormat);
    }

    public static /* synthetic */ short hexToShort$default(String str, int i8, int i9, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, i8, i9, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i8, int i9, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = bArr.length;
        }
        if ((i10 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, i8, i9, hexFormat);
    }

    private static final int formatByteAt(byte[] bArr, int i8, int[] iArr, char[] cArr, int i9) {
        int i10 = iArr[bArr[i8] & UByte.MAX_VALUE];
        cArr[i9] = (char) (i10 >> 8);
        cArr[i9 + 1] = (char) (i10 & 255);
        return i9 + 2;
    }

    public static /* synthetic */ String toHexString$default(byte b9, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(b9, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(short s2, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(s2, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte b9, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((b9 >> 4) & 15), str.charAt(b9 & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(b9 & UByte.MAX_VALUE) - 24) >> 2, 1), 0, 2, null);
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        return toHexStringImpl(b9, number, str, 8);
    }

    public static /* synthetic */ String toHexString$default(int i8, HexFormat hexFormat, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(i8, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(long j8, HexFormat hexFormat, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(j8, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(short s2, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((s2 >> 12) & 15), str.charAt((s2 >> 8) & 15), str.charAt((s2 >> 4) & 15), str.charAt(s2 & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(s2 & UShort.MAX_VALUE) - 16) >> 2, 3), 0, 2, null);
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        return toHexStringImpl(s2, number, str, 16);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(int i8, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((i8 >> 28) & 15), str.charAt((i8 >> 24) & 15), str.charAt((i8 >> 20) & 15), str.charAt((i8 >> 16) & 15), str.charAt((i8 >> 12) & 15), str.charAt((i8 >> 8) & 15), str.charAt((i8 >> 4) & 15), str.charAt(i8 & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(i8) >> 2, 7), 0, 2, null);
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        return toHexStringImpl(i8, number, str, 32);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(long j8, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((int) ((j8 >> 60) & 15)), str.charAt((int) ((j8 >> 56) & 15)), str.charAt((int) ((j8 >> 52) & 15)), str.charAt((int) ((j8 >> 48) & 15)), str.charAt((int) ((j8 >> 44) & 15)), str.charAt((int) ((j8 >> 40) & 15)), str.charAt((int) ((j8 >> 36) & 15)), str.charAt((int) ((j8 >> 32) & 15)), str.charAt((int) ((j8 >> 28) & 15)), str.charAt((int) ((j8 >> 24) & 15)), str.charAt((int) ((j8 >> 20) & 15)), str.charAt((int) ((j8 >> 16) & 15)), str.charAt((int) ((j8 >> 12) & 15)), str.charAt((int) ((j8 >> 8) & 15)), str.charAt((int) ((j8 >> 4) & 15)), str.charAt((int) (15 & j8))};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(j8) >> 2, 15), 0, 2, null);
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        return toHexStringImpl(j8, number, str, 64);
    }
}
