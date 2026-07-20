package wd;

import androidx.dynamicanimation.animation.FloatValueHolder;
import com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner;
import java.lang.ref.WeakReference;
import jd.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Lambda implements Function0 {
    final /* synthetic */ OSLiquidContainerRootLayoutInner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(OSLiquidContainerRootLayoutInner oSLiquidContainerRootLayoutInner) {
        super(0);
        this.this$0 = oSLiquidContainerRootLayoutInner;
    }

    @Override // kotlin.jvm.functions.Function0
    public final i invoke() {
        jd.e eVar = new jd.e();
        eVar.f6154a = 1.05f;
        eVar.f = new FloatValueHolder();
        eVar.f6161j = new WeakReference(this.this$0);
        eVar.f6163l = true;
        return eVar.a();
    }
}
