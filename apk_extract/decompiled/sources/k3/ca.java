package k3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ca {
    public static void a(int i8, int i9, d6.v rect, float[] array) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(array, "array");
        float f = rect.f4361a;
        float f4 = i8;
        float f10 = f / f4;
        array[0] = f10;
        float f11 = rect.f4362b;
        float f12 = i9;
        float f13 = f11 / f12;
        array[1] = f13;
        array[2] = f10;
        float f14 = (f11 + rect.f4364d) / f12;
        array[3] = f14;
        float f15 = (f + rect.f4363c) / f4;
        array[4] = f15;
        array[5] = f13;
        array[6] = f15;
        array[7] = f14;
    }
}
