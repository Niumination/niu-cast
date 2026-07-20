package ni;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n extends FunctionReferenceImpl implements Function2 {
    public static final n INSTANCE = new n();

    public n() {
        super(2, o.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), (v) obj2);
    }

    public final v invoke(long j8, v vVar) {
        v vVar2 = o.f8306a;
        m mVar = vVar.e;
        Intrinsics.checkNotNull(mVar);
        return new v(j8, vVar, mVar, 0);
    }
}
