package f1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class i5 {
    @t1.a
    public static Object a(@gm.a Object element, int index) {
        if (element != null) {
            return element;
        }
        throw new NullPointerException(h.a.a("at index ", index));
    }

    @t1.a
    public static Object[] b(Object... array) {
        c(array, array.length);
        return array;
    }

    @t1.a
    public static Object[] c(Object[] array, int length) {
        for (int i10 = 0; i10 < length; i10++) {
            a(array[i10], i10);
        }
        return array;
    }

    public static <T> T[] d(@m5 T t10, T[] tArr) {
        T[] tArr2 = (T[]) o5.c(tArr, tArr.length + 1);
        tArr2[0] = t10;
        System.arraycopy(tArr, 0, tArr2, 1, tArr.length);
        return tArr2;
    }

    public static <T> T[] e(T[] tArr, @m5 T t10) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr.length] = t10;
        return tArr2;
    }

    @b1.c
    public static <T> T[] f(T[] tArr, T[] tArr2, Class<T> cls) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static Object[] g(Object[] elements, int offset, int length) {
        c1.h0.f0(offset, offset + length, elements.length);
        if (length == 0) {
            return new Object[0];
        }
        Object[] objArr = new Object[length];
        System.arraycopy(elements, offset, objArr, 0, length);
        return objArr;
    }

    @t1.a
    public static Object[] h(Iterable<?> elements, Object[] array) {
        Iterator<?> it = elements.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            array[i10] = it.next();
            i10++;
        }
        return array;
    }

    @b1.c
    public static <T> T[] i(Class<T> cls, int i10) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i10));
    }

    public static <T> T[] j(T[] tArr, int i10) {
        return (T[]) o5.c(tArr, i10);
    }

    public static void k(Object[] array, int i10, int j10) {
        Object obj = array[i10];
        array[i10] = array[j10];
        array[j10] = obj;
    }

    public static Object[] l(Collection<?> c10) {
        return h(c10, new Object[c10.size()]);
    }

    public static <T> T[] m(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) o5.c(tArr, size);
        }
        h(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public static <T> T[] n(Object[] objArr, int i10, int i11, T[] tArr) {
        c1.h0.f0(i10, i10 + i11, objArr.length);
        if (tArr.length < i11) {
            tArr = (T[]) o5.c(tArr, i11);
        } else if (tArr.length > i11) {
            tArr[i11] = null;
        }
        System.arraycopy(objArr, i10, tArr, 0, i11);
        return tArr;
    }
}
