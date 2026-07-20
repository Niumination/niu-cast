package vi;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g extends FunctionReferenceImpl implements Function2 {
    public static final g INSTANCE = new g();

    public g() {
        super(2, j.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), (k) obj2);
    }

    public final k invoke(long j8, k kVar) {
        int i8 = j.f10602a;
        return new k(j8, kVar, 0);
    }
}
