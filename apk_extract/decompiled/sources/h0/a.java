package h0;

import android.graphics.Canvas;
import android.util.Log;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import k3.t0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import l3.a2;
import l3.c0;
import l3.y0;
import m3.c;
import we.h;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void A(a2 a2Var) {
        if (a2Var != null) {
            throw new ClassCastException();
        }
    }

    public static String B(String str, String str2) {
        return str + str2;
    }

    public static void C(int i8, String str, String str2) {
        h.b(str2, str + i8);
    }

    public static void D(String str, String str2, String str3) {
        h.h(str3, str + str2);
    }

    public static int a(byte b9, ArrayList arrayList, int i8, int i9) {
        arrayList.add(Byte.valueOf(b9));
        return i8 + i9;
    }

    public static int b(int i8, int i9, int i10) {
        return c0.q(i8) + i9 + i10;
    }

    public static int c(int i8, int i9, int i10, int i11) {
        return c0.q(i8) + i9 + i10 + i11;
    }

    public static int d(CharSequence charSequence, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return charSequence.length();
    }

    public static int e(Object[] objArr, int i8, String str, String str2, StringBuilder sb2, int i9, int i10) {
        String str3 = String.format(str, Arrays.copyOf(objArr, i8));
        Intrinsics.checkNotNullExpressionValue(str3, str2);
        sb2.append(str3);
        return i9 + i10;
    }

    public static Object f(CharSequence charSequence, int i8, Function1 function1) {
        return function1.invoke(Character.valueOf(charSequence.charAt(i8)));
    }

    public static String g(int i8, String str) {
        return i8 + str;
    }

    public static String h(int i8, String str, String str2) {
        return str + i8 + str2;
    }

    public static String i(String str, String str2) {
        return str + str2;
    }

    public static String j(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String k(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String l(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String m(StringBuilder sb2, String str, int i8) {
        sb2.append(i8);
        sb2.append(str);
        return sb2.toString();
    }

    public static String n(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public static String o(Object[] objArr, int i8, String str, String str2, String str3) {
        String str4 = String.format(str, Arrays.copyOf(objArr, i8));
        Intrinsics.checkNotNullExpressionValue(str4, str2);
        return str3.concat(str4);
    }

    public static StringBuilder p(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append(str5);
        return sb2;
    }

    public static HashMap q(Class cls, t0 t0Var) {
        HashMap map = new HashMap();
        map.put(cls, t0Var);
        return map;
    }

    public static HashMap r(Class cls, c cVar) {
        HashMap map = new HashMap();
        map.put(cls, cVar);
        return map;
    }

    public static Map s(HashMap map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static void t(int i8, Canvas canvas, int i9, int i10) {
        InlineMarker.finallyStart(i8);
        canvas.restoreToCount(i9);
        InlineMarker.finallyEnd(i10);
    }

    public static void u(int i8, String str, String str2) {
        h.h(str2, str + i8);
    }

    public static void v(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize, SurfaceCombination surfaceCombination, SurfaceConfig.ConfigType configType2, SurfaceConfig.ConfigSize configSize2) {
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
    }

    public static void w(String str, String str2, String str3) {
        Log.e(str3, str + str2);
    }

    public static void x(String str, String str2, String str3, Throwable th2) {
        Log.e(str3, str + str2, th2);
    }

    public static void y(HashMap map) {
        Collections.unmodifiableMap(new HashMap(map));
    }

    public static /* synthetic */ void z(y0 y0Var) {
        if (y0Var != null) {
            throw new ClassCastException();
        }
    }
}
