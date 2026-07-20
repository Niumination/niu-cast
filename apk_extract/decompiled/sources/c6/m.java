package c6;

import com.permissionx.guolindev.request.InvisibleFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Lambda implements Function0 {
    final /* synthetic */ InvisibleFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(InvisibleFragment invisibleFragment) {
        super(0);
        this.this$0 = invisibleFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m51invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m51invoke() {
        InvisibleFragment invisibleFragment = this.this$0;
        if (invisibleFragment.b()) {
            invisibleFragment.d(new g(invisibleFragment));
        }
    }
}
