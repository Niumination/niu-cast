package ti;

import com.transsion.iotcardsdk.bean.AppActionKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import li.r0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a extends FunctionReferenceImpl implements Function3 {
    public static final a INSTANCE = new a();

    public a() {
        super(3, b.class, AppActionKt.REGISTER, "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((b) obj, (f) obj2, obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(b bVar, f fVar, Object obj) {
        long j8 = bVar.f10219a;
        if (j8 <= 0) {
            ((e) fVar).e = Unit.INSTANCE;
            return;
        }
        i2.e eVar = new i2.e(17, fVar, bVar);
        Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        e eVar2 = (e) fVar;
        CoroutineContext coroutineContext = eVar2.f10228a;
        eVar2.f10230c = r0.b(coroutineContext).g(j8, eVar, coroutineContext);
    }
}
