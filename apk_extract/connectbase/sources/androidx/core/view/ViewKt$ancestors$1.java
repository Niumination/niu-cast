package androidx.core.view;

import android.view.ViewParent;
import jn.l;
import kn.h0;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends h0 implements l<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // jn.l
    public final ViewParent invoke(@os.l ViewParent viewParent) {
        l0.p(viewParent, "p0");
        return viewParent.getParent();
    }
}
