package lq;

import kn.l0;
import kn.r1;
import lm.f1;
import lm.l2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nmeasureTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n1#1,121:1\n50#1,7:122\n113#1,7:129\n*S KotlinDebug\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n21#1:122,7\n83#1:129,7\n*E\n"})
public final class n {
    @f1(version = "1.9")
    @p2(markerClass = {l.class})
    public static final long a(@os.l jn.a<l2> aVar) {
        l0.p(aVar, "block");
        s.b.f10267b.getClass();
        p pVar = p.f10262b;
        long jE = pVar.e();
        aVar.invoke();
        return pVar.d(jE);
    }

    @f1(version = "1.9")
    @p2(markerClass = {l.class})
    public static final long b(@os.l s.b bVar, @os.l jn.a<l2> aVar) {
        l0.p(bVar, "<this>");
        l0.p(aVar, "block");
        bVar.getClass();
        p pVar = p.f10262b;
        long jE = pVar.e();
        aVar.invoke();
        return pVar.d(jE);
    }

    @f1(version = "1.9")
    @p2(markerClass = {l.class})
    public static final long c(@os.l s sVar, @os.l jn.a<l2> aVar) {
        l0.p(sVar, "<this>");
        l0.p(aVar, "block");
        r rVarA = sVar.a();
        aVar.invoke();
        return rVarA.a();
    }

    @f1(version = "1.9")
    @p2(markerClass = {l.class})
    @os.l
    public static final <T> t<T> d(@os.l jn.a<? extends T> aVar) {
        l0.p(aVar, "block");
        s.b.f10267b.getClass();
        p pVar = p.f10262b;
        return new t<>(aVar.invoke(), pVar.d(pVar.e()));
    }

    @f1(version = "1.9")
    @p2(markerClass = {l.class})
    @os.l
    public static final <T> t<T> e(@os.l s.b bVar, @os.l jn.a<? extends T> aVar) {
        l0.p(bVar, "<this>");
        l0.p(aVar, "block");
        bVar.getClass();
        p pVar = p.f10262b;
        return new t<>(aVar.invoke(), pVar.d(pVar.e()));
    }

    @f1(version = "1.9")
    @p2(markerClass = {l.class})
    @os.l
    public static final <T> t<T> f(@os.l s sVar, @os.l jn.a<? extends T> aVar) {
        l0.p(sVar, "<this>");
        l0.p(aVar, "block");
        return new t<>(aVar.invoke(), sVar.a().a());
    }
}
