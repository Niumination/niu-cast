package gd;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSBottomSheetPanel f5146b;

    public /* synthetic */ j(OSBottomSheetPanel oSBottomSheetPanel, int i8) {
        this.f5145a = i8;
        this.f5146b = oSBottomSheetPanel;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animation) {
        switch (this.f5145a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f5146b.f2997c = null;
                break;
            case 1:
                Intrinsics.checkNotNullParameter(animation, "animation");
                OSBottomSheetPanel oSBottomSheetPanel = this.f5146b;
                oSBottomSheetPanel.f2996b = null;
                OSBaseBottomSheetDialog oSBaseBottomSheetDialog = oSBottomSheetPanel.f2999h;
                if (oSBaseBottomSheetDialog != null && !oSBaseBottomSheetDialog.isFinishing()) {
                    oSBaseBottomSheetDialog.finish();
                    break;
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                OSBaseBottomSheetDialog oSBaseBottomSheetDialog2 = this.f5146b.f2999h;
                Intrinsics.checkNotNull(oSBaseBottomSheetDialog2);
                oSBaseBottomSheetDialog2.finish();
                break;
        }
    }
}
