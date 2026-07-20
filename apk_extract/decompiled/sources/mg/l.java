package mg;

import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yf.a f8071a = new yf.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final yf.a f8072b = new yf.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final yf.a f8073c = new yf.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final yf.a f8074d = new yf.a();
    public static final yf.a e = new yf.a();
    public static final yf.a f = new yf.a();

    public static Object a(r rVar, Object obj, ih.a aVar, ContinuationImpl continuationImpl) {
        wg.c cVarK = rVar.k();
        zg.a aVar2 = wg.e.f10760a;
        Intrinsics.checkNotNullParameter(cVarK, "<this>");
        cVarK.c().i().e(wg.e.f10760a, aVar);
        wg.b bVarE = rVar.k().e();
        if (obj == null) {
            obj = cg.e.f1675a;
        }
        Object objB = bVarE.b(rVar, obj, continuationImpl);
        return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
    }
}
