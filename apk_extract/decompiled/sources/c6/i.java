package c6;

import android.provider.Settings;
import com.permissionx.guolindev.request.InvisibleFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends Lambda implements Function0 {
    final /* synthetic */ InvisibleFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(InvisibleFragment invisibleFragment) {
        super(0);
        this.this$0 = invisibleFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m47invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m47invoke() {
        r rVar = null;
        a aVar = null;
        if (Settings.System.canWrite(this.this$0.requireContext())) {
            a aVar2 = this.this$0.f2291c;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("task");
            } else {
                aVar = aVar2;
            }
            aVar.g();
            return;
        }
        r rVar2 = this.this$0.f2290b;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pb");
            rVar2 = null;
        }
        rVar2.getClass();
        r rVar3 = this.this$0.f2290b;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pb");
        } else {
            rVar = rVar3;
        }
        rVar.getClass();
    }
}
