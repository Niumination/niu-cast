package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    @Override // androidx.transition.ViewUtilsBase
    @a({"NewApi"})
    public void setTransitionVisibility(@NonNull View view, int i10) {
        if (sTryHiddenSetTransitionVisibility) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }
}
