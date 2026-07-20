package nm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCollectionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionsJVM.kt\nkotlin/collections/CollectionsKt__CollectionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,131:1\n1#2:132\n*E\n"})
public class x {
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <E> List<E> a(@os.l List<E> list) {
        kn.l0.p(list, "builder");
        return ((om.b) list).build();
    }

    @lm.f1(version = "1.3")
    @an.f
    @lm.z0
    public static final <E> List<E> b(int i10, jn.l<? super List<E>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.b bVar = new om.b(i10);
        lVar.invoke(bVar);
        return a(bVar);
    }

    @lm.f1(version = "1.3")
    @an.f
    @lm.z0
    public static final <E> List<E> c(jn.l<? super List<E>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.b bVar = new om.b();
        lVar.invoke(bVar);
        return a(bVar);
    }

    @lm.f1(version = "1.3")
    @an.f
    @lm.z0
    public static final int d(int i10) {
        if (i10 < 0) {
            if (!an.m.a(1, 3, 0)) {
                throw new ArithmeticException("Count overflow has happened.");
            }
            y.Y();
        }
        return i10;
    }

    @lm.f1(version = "1.3")
    @an.f
    @lm.z0
    public static final int e(int i10) {
        if (i10 < 0) {
            if (!an.m.a(1, 3, 0)) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            y.Z();
        }
        return i10;
    }

    @an.f
    public static final Object[] f(Collection<?> collection) {
        kn.l0.p(collection, "collection");
        return kn.v.a(collection);
    }

    @an.f
    public static final <T> T[] g(Collection<?> collection, T[] tArr) {
        kn.l0.p(collection, "collection");
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) kn.v.b(collection, tArr);
    }

    @os.l
    public static final <T> Object[] h(@os.l T[] tArr, boolean z10) {
        kn.l0.p(tArr, "<this>");
        if (z10 && kn.l0.g(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kn.l0.o(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <E> List<E> i() {
        return new om.b();
    }

    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <E> List<E> j(int i10) {
        return new om.b(i10);
    }

    @os.l
    public static <T> List<T> k(T t10) {
        List<T> listSingletonList = Collections.singletonList(t10);
        kn.l0.o(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    @lm.f1(version = "1.2")
    @os.l
    public static final <T> List<T> l(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        List<T> listX5 = h0.X5(iterable);
        Collections.shuffle(listX5);
        return listX5;
    }

    @lm.f1(version = "1.2")
    @os.l
    public static <T> List<T> m(@os.l Iterable<? extends T> iterable, @os.l Random random) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(random, "random");
        List<T> listX5 = h0.X5(iterable);
        Collections.shuffle(listX5, random);
        return listX5;
    }

    @os.l
    public static <T> T[] n(int i10, @os.l T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        if (i10 < tArr.length) {
            tArr[i10] = null;
        }
        return tArr;
    }

    @an.f
    public static final <T> List<T> o(Enumeration<T> enumeration) {
        kn.l0.p(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        kn.l0.o(list, "list(...)");
        return list;
    }
}
