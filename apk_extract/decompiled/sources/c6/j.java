package c6;

import com.permissionx.guolindev.request.InvisibleFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends Lambda implements Function0 {
    final /* synthetic */ Boolean $granted;
    final /* synthetic */ InvisibleFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(InvisibleFragment invisibleFragment, Boolean bool) {
        super(0);
        this.this$0 = invisibleFragment;
        this.$granted = bool;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m48invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m48invoke() {
        InvisibleFragment invisibleFragment = this.this$0;
        Boolean granted = this.$granted;
        Intrinsics.checkNotNullExpressionValue(granted, "granted");
        boolean zBooleanValue = granted.booleanValue();
        if (invisibleFragment.b()) {
            invisibleFragment.d(new d(zBooleanValue, invisibleFragment));
        }
    }
}
