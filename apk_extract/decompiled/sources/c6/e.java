package c6;

import com.permissionx.guolindev.request.InvisibleFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Lambda implements Function0 {
    final /* synthetic */ boolean $granted;
    final /* synthetic */ InvisibleFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(boolean z2, InvisibleFragment invisibleFragment) {
        super(0);
        this.$granted = z2;
        this.this$0 = invisibleFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m43invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m43invoke() {
        a aVar = null;
        if (this.$granted) {
            r rVar = this.this$0.f2290b;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar = null;
            }
            rVar.f.add("android.permission.BODY_SENSORS_BACKGROUND");
            r rVar2 = this.this$0.f2290b;
            if (rVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar2 = null;
            }
            rVar2.f1444g.remove("android.permission.BODY_SENSORS_BACKGROUND");
            r rVar3 = this.this$0.f2290b;
            if (rVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar3 = null;
            }
            rVar3.f1445h.remove("android.permission.BODY_SENSORS_BACKGROUND");
            a aVar2 = this.this$0.f2291c;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("task");
            } else {
                aVar = aVar2;
            }
            aVar.g();
            return;
        }
        this.this$0.shouldShowRequestPermissionRationale("android.permission.BODY_SENSORS_BACKGROUND");
        r rVar4 = this.this$0.f2290b;
        if (rVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pb");
            rVar4 = null;
        }
        rVar4.getClass();
        r rVar5 = this.this$0.f2290b;
        if (rVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pb");
            rVar5 = null;
        }
        rVar5.getClass();
        r rVar6 = this.this$0.f2290b;
        if (rVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pb");
            rVar6 = null;
        }
        rVar6.getClass();
        a aVar3 = this.this$0.f2291c;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("task");
        } else {
            aVar = aVar3;
        }
        aVar.g();
    }
}
