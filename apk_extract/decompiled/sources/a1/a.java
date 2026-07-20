package a1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static ArrayList A(int i8, HashMap map, ArrayList arrayList, int i9, String str) {
        map.put(Integer.valueOf(i8), arrayList);
        ArrayList arrayList2 = new ArrayList(i9);
        arrayList2.add(str);
        return arrayList2;
    }

    public static Iterator B(Sequence sequence, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(sequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return sequence.iterator();
    }

    public static FqName C(String str, FqName fqName, String str2) {
        FqName fqNameChild = fqName.child(Name.identifier(str));
        Intrinsics.checkNotNullExpressionValue(fqNameChild, str2);
        return fqNameChild;
    }

    public static void D(int i8, int i9, Function1 function1) {
        function1.invoke(Integer.valueOf(i8 + i9));
    }

    public static double a(double d7, double d10, double d11) {
        return (Math.sin(d7) * d10) + d11;
    }

    public static float b(float f, float f4, float f10, float f11) {
        return ((f - f4) * f10) + f11;
    }

    public static int c(int i8, int i9, int i10) {
        return (Integer.hashCode(i8) + i9) * i10;
    }

    public static int d(int i8, int i9, int i10, int i11) {
        return ((i8 - i9) / i10) + i11;
    }

    public static int e(int i8, int i9, String str) {
        return (str.hashCode() + i8) * i9;
    }

    public static int f(long j8, int i8, int i9) {
        return (Long.hashCode(j8) + i8) * i9;
    }

    public static int g(boolean z2, int i8, int i9) {
        return (Boolean.hashCode(z2) + i8) * i9;
    }

    public static long h(long j8, long j10) {
        return ULong.m333constructorimpl(ULong.m333constructorimpl(j8) * j10);
    }

    public static Object i(int i8, ArrayList arrayList) {
        return arrayList.get(arrayList.size() - i8);
    }

    public static Object j(int i8, List list) {
        return list.get(list.size() - i8);
    }

    public static Object k(byte[] bArr, int i8, Function1 function1) {
        return function1.invoke(UByte.m171boximpl(UByteArray.m235getw2LRezQ(bArr, i8)));
    }

    public static Object l(int[] iArr, int i8, Function1 function1) {
        return function1.invoke(UInt.m248boximpl(UIntArray.m314getpVg5ArA(iArr, i8)));
    }

    public static Object m(long[] jArr, int i8, Function1 function1) {
        return function1.invoke(ULong.m327boximpl(ULongArray.m393getsVKNKU(jArr, i8)));
    }

    public static Object n(short[] sArr, int i8, Function1 function1) {
        return function1.invoke(UShort.m434boximpl(UShortArray.m498getMh2AYeg(sArr, i8)));
    }

    public static String o(int i8, String str) {
        return str + i8;
    }

    public static String p(Object obj, String str) {
        return str + obj;
    }

    public static String q(StringBuilder sb2, char c9, String str) {
        sb2.append(c9);
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, str);
        return string;
    }

    public static String r(StringBuilder sb2, int i8, char c9) {
        sb2.append(i8);
        sb2.append(c9);
        return sb2.toString();
    }

    public static String s(StringBuilder sb2, String str, char c9) {
        sb2.append(str);
        sb2.append(c9);
        return sb2.toString();
    }

    public static String t(Locale locale, String str, String str2, Locale locale2, String str3) {
        Intrinsics.checkNotNullExpressionValue(locale, str);
        String lowerCase = str2.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase, str3);
        return lowerCase;
    }

    public static StringBuilder u(int i8, String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i8);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder v(CharSequence charSequence, String str, CharSequence charSequence2, String str2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(charSequence2, str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(charSequence3);
        return sb2;
    }

    public static StringBuilder w(CharSequence charSequence, String str, Function1 function1, String str2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(charSequence2);
        return sb2;
    }

    public static StringBuilder x(CharSequence charSequence, String str, Function2 function2, String str2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function2, str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(charSequence2);
        return sb2;
    }

    public static StringBuilder y(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2;
    }

    public static StringBuilder z(String str, SimpleTypeMarker simpleTypeMarker, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(simpleTypeMarker);
        sb2.append(str2);
        return sb2;
    }
}
