package androidx.lifecycle;

import android.view.View;
import kn.l0;
import lm.a1;
import lm.k;
import lm.m;

/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    @k(level = m.HIDDEN, message = "Replaced by View.findViewTreeViewModelStoreOwner in ViewTreeViewModelStoreOwner", replaceWith = @a1(expression = "View.findViewTreeViewModelStoreOwner", imports = {"androidx.lifecycle.ViewTreeViewModelStoreOwner"}))
    public static final /* synthetic */ ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        l0.p(view, "view");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
