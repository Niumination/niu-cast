package gd;

import android.animation.ValueAnimator;
import android.view.animation.PathInterpolator;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements ValueAnimator.AnimatorUpdateListener {
    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator it) {
        PathInterpolator pathInterpolator = OSBottomSheetPanel.K;
        Intrinsics.checkNotNullParameter(it, "it");
    }
}
