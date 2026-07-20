package re;

import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import com.transsion.hubsdk.view.TranUnionRenderEffect;
import com.transsion.hubsdk.view.TranView;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class l implements lh.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranView f14477a;

    @Override // lh.k
    public void a(Window window, int i10) {
        m().setSystemUiVisibility(window, i10);
    }

    @Override // lh.k
    public boolean b(View view, boolean z10, float f10, int i10) {
        return m().enableBackdropBlurFilter(view, z10, f10, i10);
    }

    @Override // lh.k
    public void c(View view) {
        if (cc.a.g(m().getClass(), "clearUnionRenderEffect", View.class) == null) {
            return;
        }
        m().clearUnionRenderEffect(view);
    }

    @Override // lh.k
    public boolean d(View view, boolean z10) {
        if (cc.a.g(m().getClass(), "forceRenderSdrUnderHdr", View.class, Boolean.TYPE) == null) {
            return false;
        }
        return m().forceRenderSdrUnderHdr(view, z10);
    }

    @Override // lh.k
    public boolean e(View view, boolean z10, float f10) {
        return m().enableBackdropBlurFilter(view, z10, f10);
    }

    @Override // lh.k
    public boolean f(View view, Consumer<View> consumer) {
        if (cc.a.g(m().getClass(), "setOnUnionRenderFrameAvailableListener", View.class, Consumer.class) == null) {
            return false;
        }
        return m().setOnUnionRenderFrameAvailableListener(view, consumer);
    }

    @Override // lh.k
    public boolean g(View view) {
        return false;
    }

    @Override // lh.k
    public boolean h(View view) {
        return false;
    }

    @Override // lh.k
    public boolean i(View view, boolean z10) {
        if (cc.a.g(m().getClass(), "setPromoteLayerEnabled", View.class, Boolean.TYPE) == null) {
            return false;
        }
        return m().setPromoteLayerEnabled(view, z10);
    }

    @Override // lh.k
    public rb.l j(View view) {
        TranUnionRenderEffect unionRenderEffect;
        if (cc.a.g(m().getClass(), "getUnionRenderEffect", View.class) == null || (unionRenderEffect = m().getUnionRenderEffect(view)) == null || unionRenderEffect.getUnionRenderObject() == null) {
            return null;
        }
        return new rb.l(unionRenderEffect);
    }

    @Override // lh.k
    public void k(View view, rb.l lVar) {
        if (cc.a.g(m().getClass(), "setUnionRenderEffect", View.class, TranUnionRenderEffect.class) == null) {
            return;
        }
        m().setUnionRenderEffect(view, lVar == null ? null : lVar.E());
    }

    @Override // lh.k
    public void l(View view, Bitmap bitmap) {
        if (cc.a.g(m().getClass(), "setMaterialNoise", View.class, Bitmap.class) == null) {
            return;
        }
        m().setMaterialNoise(view, bitmap);
    }

    public final TranView m() {
        if (this.f14477a == null) {
            this.f14477a = new TranView();
        }
        return this.f14477a;
    }
}
