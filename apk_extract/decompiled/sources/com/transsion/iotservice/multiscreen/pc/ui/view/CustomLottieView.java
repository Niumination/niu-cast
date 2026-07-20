package com.transsion.iotservice.multiscreen.pc.ui.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/view/CustomLottieView;", "Lcom/airbnb/lottie/LottieAnimationView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CustomLottieView extends LottieAnimationView {
    public CustomLottieView(Context context) {
        super(context);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public final void d() {
        String log = "playAnimation: " + getImageAssetsFolder() + ",isPlaying:" + this.e.j();
        Intrinsics.checkNotNullParameter("CustomLottieView", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CustomLottieView"), log);
        }
        super.d();
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public final void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        String strN = d.n("onRestoreInstanceState: ", getImageAssetsFolder(), "CustomLottieView", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CustomLottieView"), strN);
        }
        super.onRestoreInstanceState(state);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public final Parcelable onSaveInstanceState() {
        String strN = d.n("onSaveInstanceState: ", getImageAssetsFolder(), "CustomLottieView", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CustomLottieView"), strN);
        }
        super.onSaveInstanceState();
        return null;
    }

    public CustomLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomLottieView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
    }
}
