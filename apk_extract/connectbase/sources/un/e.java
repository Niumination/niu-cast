package un;

import kn.l0;
import kn.r1;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nKClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n+ 2 KClassesImpl.kt\nkotlin/reflect/KClassesImplKt\n*L\n1#1,48:1\n9#2:49\n*S KotlinDebug\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n*L\n26#1:49\n*E\n"})
@in.i(name = "KClasses")
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @an.h
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @os.l
    public static final <T> T a(@os.l d<T> dVar, @os.m Object obj) {
        l0.p(dVar, "<this>");
        if (dVar.r(obj)) {
            l0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + dVar.v());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.h
    @p2(markerClass = {lm.r.class})
    @os.m
    @f1(version = "1.4")
    public static final <T> T b(@os.l d<T> dVar, @os.m Object obj) {
        l0.p(dVar, "<this>");
        if (!dVar.r(obj)) {
            return null;
        }
        l0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
        return obj;
    }
}
