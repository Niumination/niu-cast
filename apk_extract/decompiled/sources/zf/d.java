package zf;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k3.bb;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f11492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f11493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f11494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f11495d;
    public static final ArrayList e;

    static {
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', 'Z')), (Iterable) new CharRange('0', '9'));
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listPlus));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        f11492a = CollectionsKt.toSet(arrayList);
        f11493b = CollectionsKt.toSet(CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', 'Z')), (Iterable) new CharRange('0', '9')));
        CollectionsKt.toSet(CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'f'), (Iterable) new CharRange('A', 'F')), (Iterable) new CharRange('0', '9')));
        Set of2 = SetsKt.setOf((Object[]) new Character[]{':', '/', '?', '#', '[', ']', '@', '!', Character.valueOf(Typography.dollar), Character.valueOf(Typography.amp), '\'', '(', ')', '*', ',', ';', '=', '-', '.', '_', '~', '+'});
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(of2));
        Iterator it2 = of2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        f11494c = arrayList2;
        f11495d = SetsKt.setOf((Object[]) new Character[]{':', '@', '!', Character.valueOf(Typography.dollar), Character.valueOf(Typography.amp), '\'', '(', ')', '*', '+', ',', ';', '=', '-', '.', '_', '~'});
        SetsKt.plus(f11493b, (Iterable) SetsKt.setOf((Object[]) new Character[]{'!', '#', Character.valueOf(Typography.dollar), Character.valueOf(Typography.amp), '+', '-', '.', '^', '_', '`', '|', '~'}));
        List listListOf = CollectionsKt.listOf((Object[]) new Character[]{'-', '.', '_', '~'});
        ArrayList arrayList3 = new ArrayList(CollectionsKt.i(listListOf));
        Iterator it3 = listListOf.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Byte.valueOf((byte) ((Character) it3.next()).charValue()));
        }
        e = arrayList3;
    }

    public static final int a(char c9) {
        if ('0' <= c9 && c9 < ':') {
            return c9 - '0';
        }
        if ('A' <= c9 && c9 < 'G') {
            return c9 - '7';
        }
        if ('a' > c9 || c9 >= 'g') {
            return -1;
        }
        return c9 - 'W';
    }

    public static final String b(String str, int i8, int i9, boolean z2) throws k0 {
        int i10 = i8;
        while (i10 < i9) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '%' || (z2 && cCharAt == '+')) {
                int i11 = i9 - i8;
                if (i11 > 255) {
                    i11 /= 3;
                }
                StringBuilder sb2 = new StringBuilder(i11);
                if (i10 > i8) {
                    sb2.append((CharSequence) str, i8, i10);
                }
                byte[] bArr = null;
                while (i10 < i9) {
                    char cCharAt2 = str.charAt(i10);
                    if (z2 && cCharAt2 == '+') {
                        sb2.append(' ');
                    } else if (cCharAt2 == '%') {
                        if (bArr == null) {
                            bArr = new byte[(i9 - i10) / 3];
                        }
                        int i12 = 0;
                        while (i10 < i9 && str.charAt(i10) == '%') {
                            int i13 = i10 + 2;
                            if (i13 >= i9) {
                                throw new k0("Incomplete trailing HEX escape: " + str.subSequence(i10, str.length()).toString() + ", in " + ((Object) str) + " at " + i10);
                            }
                            int i14 = i10 + 1;
                            int iA = a(str.charAt(i14));
                            int iA2 = a(str.charAt(i13));
                            if (iA == -1 || iA2 == -1) {
                                throw new k0("Wrong HEX escape: %" + str.charAt(i14) + str.charAt(i13) + ", in " + ((Object) str) + ", at " + i10);
                            }
                            bArr[i12] = (byte) ((iA * 16) + iA2);
                            i10 += 3;
                            i12++;
                        }
                        sb2.append(StringsKt__StringsJVMKt.decodeToString$default(bArr, 0, i12, false, 4, null));
                    } else {
                        sb2.append(cCharAt2);
                    }
                    i10++;
                }
                String string = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
            i10++;
        }
        if (i8 == 0 && i9 == str.length()) {
            return str.toString();
        }
        String strSubstring = str.substring(i8, i9);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String c(String str, int i8, int i9, int i10) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return b(str, i8, i9, false);
    }

    public static String d(String str, int i8, int i9, boolean z2, int i10) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            z2 = false;
        }
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return b(str, i8, i9, z2);
    }

    public static final String e(String input, final boolean z2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        final StringBuilder sb2 = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "newEncoder(...)");
        int length = input.length();
        Intrinsics.checkNotNullParameter(charsetEncoderNewEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        wi.a aVar = new wi.a();
        bb.b(charsetEncoderNewEncoder, aVar, input, 0, length);
        f(aVar, new Function1() { // from class: zf.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Byte b9 = (Byte) obj;
                byte bByteValue = b9.byteValue();
                boolean zContains = d.f11492a.contains(b9);
                StringBuilder sb3 = sb2;
                if (zContains || d.e.contains(b9)) {
                    sb3.append((char) bByteValue);
                } else if (z2 && bByteValue == 32) {
                    sb3.append('+');
                } else {
                    sb3.append(d.g(bByteValue));
                }
                return Unit.INSTANCE;
            }
        });
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final void f(wi.a aVar, Function1 function1) {
        dc.d block = new dc.d(1, function1);
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        while (!aVar.T()) {
            block.invoke(aVar);
        }
    }

    public static final String g(byte b9) {
        int i8 = (b9 & UByte.MAX_VALUE) >> 4;
        int i9 = b9 & 15;
        return StringsKt.concatToString(new char[]{'%', (char) ((i8 < 0 || i8 >= 10) ? ((char) (i8 + 65)) - '\n' : i8 + 48), (char) ((i9 < 0 || i9 >= 10) ? ((char) (i9 + 65)) - '\n' : i9 + 48)});
    }
}
