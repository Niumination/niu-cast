package nm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import lm.l2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,522:1\n1#2:523\n26#3:524\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n*L\n484#1:524\n*E\n"})
public class y extends x {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kn.r1({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt$binarySearchBy$1\n*L\n1#1,522:1\n*E\n"})
    public static final class a<T> extends kn.n0 implements jn.l<T, Integer> {

        /* JADX INFO: Incorrect field signature: TK; */
        final /* synthetic */ Comparable $key;
        final /* synthetic */ jn.l<T, K> $selector;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (Ljn/l<-TT;+TK;>;TK;)V */
        public a(jn.l lVar, Comparable comparable) {
            super(1);
            this.$selector = lVar;
            this.$key = comparable;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.l
        @os.l
        public final Integer invoke(T t10) {
            return Integer.valueOf(rm.g.l((Comparable) this.$selector.invoke(t10), this.$key));
        }
    }

    public static final <T, K extends Comparable<? super K>> int A(@os.l List<? extends T> list, @os.m K k10, int i10, int i11, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "selector");
        return u(list, i10, i11, new a(lVar, k10));
    }

    public static /* synthetic */ int B(List list, Comparable comparable, int i10, int i11, jn.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "selector");
        return u(list, i10, i11, new a(lVar, comparable));
    }

    @lm.f1(version = "1.6")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <E> List<E> C(int i10, @lm.b jn.l<? super List<E>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.b bVar = new om.b(i10);
        lVar.invoke(bVar);
        return x.a(bVar);
    }

    @lm.f1(version = "1.6")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <E> List<E> D(@lm.b jn.l<? super List<E>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.b bVar = new om.b();
        lVar.invoke(bVar);
        return x.a(bVar);
    }

    @os.l
    public static final Object[] E(@os.l Collection<?> collection) {
        kn.l0.p(collection, "collection");
        int i10 = 0;
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] objArr = new Object[collection.size()];
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return objArr;
    }

    @os.l
    public static final <T> T[] F(@os.l Collection<?> collection, @os.l T[] tArr) {
        Object[] objArr;
        kn.l0.p(collection, "collection");
        kn.l0.p(tArr, dc.d.f3685p);
        int i10 = 0;
        if (collection.isEmpty()) {
            return (T[]) x.n(0, tArr);
        }
        if (tArr.length < collection.size()) {
            objArr = tArr;
            objArr = (T[]) m.a(tArr, collection.size());
        }
        objArr = tArr;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return (T[]) x.n(collection.size(), objArr);
    }

    @an.f
    public static final <T> boolean G(Collection<? extends T> collection, Collection<? extends T> collection2) {
        kn.l0.p(collection, "<this>");
        kn.l0.p(collection2, "elements");
        return collection.containsAll(collection2);
    }

    @os.l
    public static <T> List<T> H() {
        return k0.INSTANCE;
    }

    @os.l
    public static tn.l I(@os.l Collection<?> collection) {
        kn.l0.p(collection, "<this>");
        return new tn.l(0, collection.size() - 1, 1);
    }

    public static <T> int J(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        return list.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Ljn/a<+TR;>;)TR; */
    @lm.f1(version = "1.3")
    @an.f
    public static final Object K(Collection collection, jn.a aVar) {
        kn.l0.p(aVar, "defaultValue");
        return collection.isEmpty() ? aVar.invoke() : collection;
    }

    @an.f
    public static final <T> boolean L(Collection<? extends T> collection) {
        kn.l0.p(collection, "<this>");
        return !collection.isEmpty();
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final <T> boolean M(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @an.f
    public static final <T> List<T> N() {
        return k0.INSTANCE;
    }

    @os.l
    public static <T> List<T> O(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return tArr.length > 0 ? p.t(tArr) : k0.INSTANCE;
    }

    @os.l
    public static <T> List<T> P(@os.m T t10) {
        return t10 != null ? x.k(t10) : k0.INSTANCE;
    }

    @os.l
    public static <T> List<T> Q(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return r.Ta(tArr);
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <T> List<T> R() {
        return new ArrayList();
    }

    @os.l
    public static <T> List<T> S(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new j(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T> List<T> T(@os.l List<? extends T> list) {
        kn.l0.p(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : x.k(list.get(0));
        }
        return k0.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <T> Collection<T> U(Collection<? extends T> collection) {
        return collection == 0 ? k0.INSTANCE : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <T> List<T> V(List<? extends T> list) {
        return list == 0 ? k0.INSTANCE : list;
    }

    public static final void W(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException(k.b.a("fromIndex (", i11, ") is less than zero."));
        }
        if (i12 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
    }

    @lm.f1(version = "1.3")
    @os.l
    public static final <T> List<T> X(@os.l Iterable<? extends T> iterable, @os.l rn.f fVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(fVar, "random");
        List<T> listX5 = h0.X5(iterable);
        h0.e5(listX5, fVar);
        return listX5;
    }

    @lm.f1(version = "1.3")
    @lm.z0
    public static void Y() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @lm.f1(version = "1.3")
    @lm.z0
    public static void Z() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <T> List<T> p(int i10, jn.l<? super Integer, ? extends T> lVar) {
        kn.l0.p(lVar, "init");
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(lVar.invoke(Integer.valueOf(i11)));
        }
        return arrayList;
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <T> List<T> q(int i10, jn.l<? super Integer, ? extends T> lVar) {
        kn.l0.p(lVar, "init");
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(lVar.invoke(Integer.valueOf(i11)));
        }
        return arrayList;
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <T> ArrayList<T> r() {
        return new ArrayList<>();
    }

    @os.l
    public static <T> ArrayList<T> s(@os.l T... tArr) {
        kn.l0.p(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new j(tArr, true));
    }

    @os.l
    public static final <T> Collection<T> t(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return new j(tArr, false);
    }

    public static final <T> int u(@os.l List<? extends T> list, int i10, int i11, @os.l jn.l<? super T, Integer> lVar) {
        kn.l0.p(list, "<this>");
        kn.l0.p(lVar, "comparison");
        W(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iIntValue = lVar.invoke(list.get(i13)).intValue();
            if (iIntValue < 0) {
                i10 = i13 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final <T extends Comparable<? super T>> int v(@os.l List<? extends T> list, @os.m T t10, int i10, int i11) {
        kn.l0.p(list, "<this>");
        W(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iL = rm.g.l(list.get(i13), t10);
            if (iL < 0) {
                i10 = i13 + 1;
            } else {
                if (iL <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final <T> int w(@os.l List<? extends T> list, T t10, @os.l Comparator<? super T> comparator, int i10, int i11) {
        kn.l0.p(list, "<this>");
        kn.l0.p(comparator, "comparator");
        W(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iCompare = comparator.compare(list.get(i13), t10);
            if (iCompare < 0) {
                i10 = i13 + 1;
            } else {
                if (iCompare <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int x(List list, int i10, int i11, jn.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = list.size();
        }
        return u(list, i10, i11, lVar);
    }

    public static /* synthetic */ int y(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return v(list, comparable, i10, i11);
    }

    public static /* synthetic */ int z(List list, Object obj, Comparator comparator, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = list.size();
        }
        return w(list, obj, comparator, i10, i11);
    }
}
