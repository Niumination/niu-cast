package ni;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j extends FunctionReferenceImpl implements Function3 {
    public static final j INSTANCE = new j();

    public j() {
        super(3, m.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(m mVar, Object obj, Object obj2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = m.f8295d;
        mVar.getClass();
        if (obj2 == o.f8315l) {
            obj2 = new s(mVar.o());
        }
        return new u(obj2);
    }
}
