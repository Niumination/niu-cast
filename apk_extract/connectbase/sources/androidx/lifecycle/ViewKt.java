package androidx.lifecycle;

import android.view.View;
import kn.l0;
import lm.a1;
import lm.k;
import lm.m;

/* JADX INFO: loaded from: classes.dex */
public final class ViewKt {
    @k(level = m.HIDDEN, message = "Replaced by View.findViewTreeLifecycleOwner() from lifecycle module", replaceWith = @a1(expression = "findViewTreeLifecycleOwner()", imports = {"androidx.lifecycle.findViewTreeLifecycleOwner"}))
    public static final /* synthetic */ LifecycleOwner findViewTreeLifecycleOwner(View view) {
        l0.p(view, "<this>");
        return ViewTreeLifecycleOwner.get(view);
    }
}
