package wd;

import com.transsion.widgetslib.view.liquid.effect.OSLiquidContainer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Lambda implements Function0 {
    final /* synthetic */ OSLiquidContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(OSLiquidContainer oSLiquidContainer) {
        super(0);
        this.this$0 = oSLiquidContainer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final e9.a invoke() {
        e9.b tranView = this.this$0.getTranView();
        OSLiquidContainer oSLiquidContainer = this.this$0;
        tranView.getClass();
        if (oSLiquidContainer == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        String str = l9.a.f7348i;
        e9.a aVarB = tranView.a().b(oSLiquidContainer);
        if (aVarB != null) {
            return aVarB;
        }
        e9.a aVar = new e9.a();
        aVar.c(str, true);
        return aVar;
    }
}
