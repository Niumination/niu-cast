package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nDebugStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugStrings.kt\nkotlinx/coroutines/DebugStringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class x0 {
    @os.l
    public static final String a(@os.l Object obj) {
        return obj.getClass().getSimpleName();
    }

    @os.l
    public static final String b(@os.l Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @os.l
    public static final String c(@os.l um.d<?> dVar) {
        Object objM59constructorimpl;
        if (dVar instanceof vq.m) {
            return dVar.toString();
        }
        try {
            lm.c1.a aVar = lm.c1.Companion;
            objM59constructorimpl = lm.c1.m59constructorimpl(dVar + '@' + b(dVar));
        } catch (Throwable th2) {
            lm.c1.a aVar2 = lm.c1.Companion;
            objM59constructorimpl = lm.c1.m59constructorimpl(lm.d1.a(th2));
        }
        if (lm.c1.m62exceptionOrNullimpl(objM59constructorimpl) != null) {
            objM59constructorimpl = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) objM59constructorimpl;
    }
}
