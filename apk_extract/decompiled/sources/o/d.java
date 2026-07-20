package o;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.UInt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import we.h;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static void A(StringBuilder sb2, String str, String str2, String str3, String str4) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
    }

    public static void B(String str, String str2, String str3) {
        Log.d(str3, str + str2);
    }

    public static int a(int i8, int i9, int i10, int i11) {
        return ((i8 * i9) + i10) * i11;
    }

    public static int b(UInt uInt, int i8) {
        return UInt.m254constructorimpl(uInt.getData() + i8);
    }

    public static int c(IntRange intRange, int i8) {
        return intRange.getEndInclusive().intValue() + i8;
    }

    public static ClassCastException d(Object obj) {
        obj.getClass();
        return new ClassCastException();
    }

    public static Object e(int i8) {
        return DescriptorProtos.getDescriptor().getMessageTypes().get(i8);
    }

    public static String f(int i8, int i9, String str, String str2) {
        return str + i8 + str2 + i9;
    }

    public static String g(int i8, int i9, String str, String str2, String str3) {
        return str + i8 + str2 + i9 + str3;
    }

    public static String h(int i8, String str, String str2) {
        String str3 = str + i8;
        Intrinsics.checkNotNullParameter(str3, str2);
        return str3;
    }

    public static String i(RecyclerView recyclerView, StringBuilder sb2) {
        sb2.append(recyclerView.exceptionLabel());
        return sb2.toString();
    }

    public static String j(String str, long j8) {
        return str + j8;
    }

    public static String k(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String l(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m(String str, String str2, String str3, String str4, int i8) {
        String str5 = str + i8;
        Intrinsics.checkNotNullParameter(str2, str3);
        Intrinsics.checkNotNullParameter(str5, str4);
        return str5;
    }

    public static String n(String str, String str2, String str3, String str4, String str5) {
        String str6 = str + str2;
        Intrinsics.checkNotNullParameter(str3, str4);
        Intrinsics.checkNotNullParameter(str6, str5);
        return str6;
    }

    public static String o(String str, boolean z2, String str2, String str3, String str4) {
        String str5 = str + z2;
        Intrinsics.checkNotNullParameter(str2, str3);
        Intrinsics.checkNotNullParameter(str5, str4);
        return str5;
    }

    public static String p(StringBuilder sb2, long j8, String str) {
        sb2.append(j8);
        sb2.append(str);
        return sb2.toString();
    }

    public static String q(Object[] objArr, int i8, String str, String str2) {
        String str3 = String.format(str, Arrays.copyOf(objArr, i8));
        Intrinsics.checkNotNullExpressionValue(str3, str2);
        return str3;
    }

    public static StringBuilder r(int i8, int i9, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i8);
        sb2.append(str2);
        sb2.append(i9);
        sb2.append(str3);
        return sb2;
    }

    public static StringBuilder s(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        return sb2;
    }

    public static StringBuilder t(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        return sb2;
    }

    public static ArrayList u(LinkedHashMap linkedHashMap, Object obj) {
        ArrayList arrayList = new ArrayList();
        linkedHashMap.put(obj, arrayList);
        return arrayList;
    }

    public static ArrayList v(Map map, Object obj) {
        ArrayList arrayList = new ArrayList();
        map.put(obj, arrayList);
        return arrayList;
    }

    public static Iterator w(Iterable iterable, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(iterable, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return iterable.iterator();
    }

    public static void x(int i8, String str, String str2) {
        Log.d(str2, str + i8);
    }

    public static /* synthetic */ void y(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void z(String str, String str2, String str3) {
        h.b(str3, str + str2);
    }
}
