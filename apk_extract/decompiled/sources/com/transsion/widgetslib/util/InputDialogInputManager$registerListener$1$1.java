package com.transsion.widgetslib.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/transsion/widgetslib/util/InputDialogInputManager$registerListener$1$1", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InputDialogInputManager$registerListener$1$1 extends WindowInsetsAnimationCompat.Callback {
    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat insets, List runningAnimations) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        Iterator it = runningAnimations.iterator();
        while (it.hasNext()) {
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) it.next();
            if (windowInsetsAnimationCompat.getTypeMask() == WindowInsetsCompat.Type.ime()) {
                insets.isVisible(WindowInsetsCompat.Type.ime());
                Intrinsics.checkNotNullExpressionValue(insets.getInsets(WindowInsetsCompat.Type.ime()), "insets.getInsets(WindowInsetsCompat.Type.ime())");
                windowInsetsAnimationCompat.getFraction();
                throw null;
            }
        }
        return insets;
    }
}
