package gq;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.a1;
import lm.f1;
import lm.s0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\n_SequencesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,172:1\n1433#2,14:173\n1839#2,14:187\n*S KotlinDebug\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n*L\n89#1:173,14\n126#1:187,14\n*E\n"})
public class u extends s {

    public static final class a extends n0 implements jn.l<Object, Boolean> {
        final /* synthetic */ Class<R> $klass;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<R> cls) {
            super(1);
            this.$klass = cls;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.m Object obj) {
            return Boolean.valueOf(this.$klass.isInstance(obj));
        }
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Object A(m mVar, Comparator comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        return v.I1(mVar, comparator);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Comparable B(m mVar) {
        l0.p(mVar, "<this>");
        return v.U1(mVar);
    }

    @f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Double C(m mVar) {
        l0.p(mVar, "<this>");
        return v.V1(mVar);
    }

    @f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Float D(m mVar) {
        l0.p(mVar, "<this>");
        return v.W1(mVar);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T E(m<? extends T> mVar, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = t.a(mVar, "<this>", lVar, "selector");
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
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Object F(m mVar, Comparator comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        return v.a2(mVar, comparator);
    }

    @s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @f1(version = "1.4")
    public static final <T> BigDecimal G(m<? extends T> mVar, jn.l<? super T, ? extends BigDecimal> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(...)");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(it.next()));
            l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @f1(version = "1.4")
    public static final <T> BigInteger H(m<? extends T> mVar, jn.l<? super T, ? extends BigInteger> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(...)");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(it.next()));
            l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @os.l
    public static final <T extends Comparable<? super T>> SortedSet<T> I(@os.l m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return (SortedSet) v.a3(mVar, new TreeSet());
    }

    @os.l
    public static final <T> SortedSet<T> J(@os.l m<? extends T> mVar, @os.l Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        return (SortedSet) v.a3(mVar, new TreeSet(comparator));
    }

    @os.l
    public static final <R> m<R> u(@os.l m<?> mVar, @os.l Class<R> cls) {
        l0.p(mVar, "<this>");
        l0.p(cls, "klass");
        m<R> mVarP0 = v.p0(mVar, new a(cls));
        l0.n(mVarP0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return mVarP0;
    }

    @os.l
    public static final <C extends Collection<? super R>, R> C v(@os.l m<?> mVar, @os.l C c10, @os.l Class<R> cls) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(cls, "klass");
        for (Object obj : mVar) {
            if (cls.isInstance(obj)) {
                c10.add(obj);
            }
        }
        return c10;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Comparable w(m mVar) {
        l0.p(mVar, "<this>");
        return v.C1(mVar);
    }

    @f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Double x(m mVar) {
        l0.p(mVar, "<this>");
        return v.D1(mVar);
    }

    @f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Float y(m mVar) {
        l0.p(mVar, "<this>");
        return v.E1(mVar);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T z(m<? extends T> mVar, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = t.a(mVar, "<this>", lVar, "selector");
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
}
