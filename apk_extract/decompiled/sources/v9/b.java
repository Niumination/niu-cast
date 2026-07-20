package v9;

import android.view.View;
import com.transsion.hubsdk.view.TranUnionRenderEffect;
import com.transsion.hubsdk.view.TranView;
import com.transsion.widgetslib.view.liquid.effect.OSLiquidContainer;
import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ga.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranView f10528a;

    @Override // ga.b
    public final void a(OSLiquidContainer oSLiquidContainer, e9.a aVar) {
        if (o9.d(c().getClass(), "setUnionRenderEffect", View.class, TranUnionRenderEffect.class) == null) {
            return;
        }
        c().setUnionRenderEffect(oSLiquidContainer, aVar == null ? null : aVar.b());
    }

    @Override // ga.b
    public final e9.a b(View view) {
        TranUnionRenderEffect unionRenderEffect;
        if (o9.d(c().getClass(), "getUnionRenderEffect", View.class) == null || (unionRenderEffect = c().getUnionRenderEffect(view)) == null || unionRenderEffect.getUnionRenderObject() == null) {
            return null;
        }
        return new e9.a(unionRenderEffect);
    }

    public final TranView c() {
        if (this.f10528a == null) {
            this.f10528a = new TranView();
        }
        return this.f10528a;
    }
}
