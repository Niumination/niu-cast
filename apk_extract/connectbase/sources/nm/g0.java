package nm;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\n_CollectionsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1963#2,14:169\n2333#2,14:183\n*S KotlinDebug\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n*L\n89#1:169,14\n126#1:183,14\n*E\n"})
public class g0 extends e0 {
    @os.l
    public static <R> List<R> f1(@os.l Iterable<?> iterable, @os.l Class<R> cls) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(cls, "klass");
        return (List) g1(iterable, new ArrayList(), cls);
    }

    @os.l
    public static final <C extends Collection<? super R>, R> C g1(@os.l Iterable<?> iterable, @os.l C c10, @os.l Class<R> cls) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c10.add(obj);
            }
        }
        return c10;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Comparable h1(Iterable iterable) {
        kn.l0.p(iterable, "<this>");
        return h0.P3(iterable);
    }

    @lm.f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Double i1(Iterable iterable) {
        kn.l0.p(iterable, "<this>");
        return h0.Q3(iterable);
    }

    @lm.f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Float j1(Iterable iterable) {
        kn.l0.p(iterable, "<this>");
        return h0.R3(iterable);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T k1(Iterable<? extends T> iterable, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        Object obj = (Object) itA.next();
        if (itA.hasNext()) {
            R rInvoke = lVar.invoke(obj);
            do {
                Object obj2 = (Object) itA.next();
                R rInvoke2 = lVar.invoke(obj2);
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    obj = (Object) obj2;
                    rInvoke = rInvoke2;
                }
            } while (itA.hasNext());
        }
        return (T) obj;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Object l1(Iterable iterable, Comparator comparator) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        return h0.V3(iterable, comparator);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Comparable m1(Iterable iterable) {
        kn.l0.p(iterable, "<this>");
        return h0.h4(iterable);
    }

    @lm.f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Double n1(Iterable iterable) {
        kn.l0.p(iterable, "<this>");
        return h0.i4(iterable);
    }

    @lm.f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Float o1(Iterable iterable) {
        kn.l0.p(iterable, "<this>");
        return h0.j4(iterable);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T p1(Iterable<? extends T> iterable, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = f0.a(iterable, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        Object obj = (Object) itA.next();
        if (itA.hasNext()) {
            R rInvoke = lVar.invoke(obj);
            do {
                Object obj2 = (Object) itA.next();
                R rInvoke2 = lVar.invoke(obj2);
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    obj = (Object) obj2;
                    rInvoke = rInvoke2;
                }
            } while (itA.hasNext());
        }
        return (T) obj;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Object q1(Iterable iterable, Comparator comparator) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        return h0.n4(iterable, comparator);
    }

    public static <T> void r1(@os.l List<T> list) {
        kn.l0.p(list, "<this>");
        Collections.reverse(list);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final <T> BigDecimal s1(Iterable<? extends T> iterable, jn.l<? super T, ? extends BigDecimal> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(it.next()));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final <T> BigInteger t1(Iterable<? extends T> iterable, jn.l<? super T, ? extends BigInteger> lVar) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(it.next()));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @os.l
    public static final <T extends Comparable<? super T>> SortedSet<T> u1(@os.l Iterable<? extends T> iterable) {
        kn.l0.p(iterable, "<this>");
        return (SortedSet) h0.Q5(iterable, new TreeSet());
    }

    @os.l
    public static final <T> SortedSet<T> v1(@os.l Iterable<? extends T> iterable, @os.l Comparator<? super T> comparator) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(comparator, "comparator");
        return (SortedSet) h0.Q5(iterable, new TreeSet(comparator));
    }
}
