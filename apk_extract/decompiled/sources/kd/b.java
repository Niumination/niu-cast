package kd;

import android.view.ViewTreeObserver;
import com.transsion.widgetslib.view.damping.OSSmartScrollbar;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6823a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6824b;

    public b(OSSmartScrollbar oSSmartScrollbar) {
        this.f6824b = new WeakReference(oSSmartScrollbar);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        switch (this.f6823a) {
            case 0:
                ((d) this.f6824b).f();
                return;
            default:
                OSSmartScrollbar oSSmartScrollbar = (OSSmartScrollbar) ((WeakReference) this.f6824b).get();
                if (oSSmartScrollbar == null) {
                    return;
                }
                oSSmartScrollbar.getScrollRange();
                oSSmartScrollbar.getScrollOffset();
                oSSmartScrollbar.getScrollExtent();
                throw null;
        }
    }

    public b(d dVar) {
        this.f6824b = dVar;
    }
}
