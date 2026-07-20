package nm;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nArraysJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,61:1\n26#2:62\n*S KotlinDebug\n*F\n+ 1 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n18#1:62\n*E\n"})
public class m {
    @os.l
    public static final <T> T[] a(@os.l T[] tArr, int i10) {
        kn.l0.p(tArr, "reference");
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i10);
        kn.l0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) objNewInstance);
    }

    @lm.f1(version = "1.3")
    @in.i(name = "contentDeepHashCode")
    @lm.z0
    public static final <T> int b(@os.m T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    @lm.f1(version = "1.3")
    public static final void c(int i10, int i11) {
        if (i10 <= i11) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i11 + ").");
    }

    public static final <T> T[] d(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        kn.l0.P();
        return (T[]) new Object[0];
    }

    @an.f
    public static final String e(byte[] bArr, Charset charset) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(charset, "charset");
        return new String(bArr, charset);
    }

    public static final <T> T[] f(Collection<? extends T> collection) {
        kn.l0.p(collection, "<this>");
        kn.l0.P();
        return (T[]) collection.toArray(new Object[0]);
    }
}
