package nm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class z extends y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n*L\n1#1,70:1\n*E\n"})
    public static final class a<T> implements Iterable<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.a<Iterator<T>> f11698a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.a<? extends Iterator<? extends T>> aVar) {
            this.f11698a = aVar;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<T> iterator() {
            return this.f11698a.invoke();
        }
    }

    @an.f
    public static final <T> Iterable<T> a0(jn.a<? extends Iterator<? extends T>> aVar) {
        kn.l0.p(aVar, "iterator");
        return new a(aVar);
    }

    @lm.z0
    public static <T> int b0(@os.l Iterable<? extends T> iterable, int i10) {
        kn.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }

    @os.m
    @lm.z0
    public static final <T> Integer c0(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @os.l
    public static <T> List<T> d0(@os.l Iterable<? extends Iterable<? extends T>> iterable) {
        kn.l0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            d0.r0(arrayList, it.next());
        }
        return arrayList;
    }

    @os.l
    public static final <T, R> lm.t0<List<T>, List<R>> e0(@os.l Iterable<? extends lm.t0<? extends T, ? extends R>> iterable) {
        kn.l0.p(iterable, "<this>");
        int iB0 = b0(iterable, 10);
        ArrayList arrayList = new ArrayList(iB0);
        ArrayList arrayList2 = new ArrayList(iB0);
        for (lm.t0<? extends T, ? extends R> t0Var : iterable) {
            arrayList.add(t0Var.getFirst());
            arrayList2.add(t0Var.getSecond());
        }
        return new lm.t0<>(arrayList, arrayList2);
    }
}
