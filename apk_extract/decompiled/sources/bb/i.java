package bb;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i extends FunctionReferenceImpl implements Function1 {
    public i(Object obj) {
        super(1, obj, l.class, "onSwitchToShareNetwork", "onSwitchToShareNetwork(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z2) {
        ((l) this.receiver).d(z2);
    }
}
