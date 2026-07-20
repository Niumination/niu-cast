package ke;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.view.OSLoadingView;
import com.transsion.widgetslib.view.damping.DampingLayout;
import com.transsion.widgetslib.widget.FootOperationBar;
import com.transsion.widgetslib.widget.OSMaskImageView;
import com.transsion.widgetslistitemlayout.OSListItemView;
import kotlin.jvm.internal.Intrinsics;
import pd.e;
import rd.g;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6853b;

    public /* synthetic */ d(Object obj, int i8) {
        this.f6852a = i8;
        this.f6853b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animation) {
        boolean zIsSelected;
        switch (this.f6852a) {
            case 0:
                super.onAnimationEnd(animation);
                ((OSListItemView) this.f6853b).getClass();
                break;
            case 1:
                super.onAnimationEnd(animation);
                e eVar = (e) this.f6853b;
                eVar.e.setAlpha(0);
                eVar.f8742k = false;
                break;
            case 2:
                Intrinsics.checkNotNullParameter(animation, "animation");
                ((View) this.f6853b).setAlpha(1.0f);
                break;
            case 3:
                Intrinsics.checkNotNullParameter(animation, "animation");
                OSLoadingView oSLoadingView = (OSLoadingView) this.f6853b;
                oSLoadingView.getMAnimCircle().start();
                oSLoadingView.getMAnimAppeal().start();
                oSLoadingView.getMAnimRepel().start();
                break;
            case 4:
                super.onAnimationEnd(animation);
                DampingLayout dampingLayout = (DampingLayout) this.f6853b;
                dampingLayout.mIsRefreshing = false;
                dampingLayout.mIsAbortRefreshing = false;
                dampingLayout.mTextRefreshing.setText(R$string.os_dampingl_refresh_finish);
                dampingLayout.mLoadingView.b();
                break;
            case 5:
                super.onAnimationEnd(animation);
                g gVar = (g) this.f6853b;
                gVar.f9410h = false;
                gVar.getClass();
                gVar.f9408d.setText(R$string.os_dampingl_refresh_finish);
                gVar.f9407c.g();
                break;
            case 6:
                super.onAnimationEnd(animation);
                ((FootOperationBar) this.f6853b).f3373h = false;
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                OSMaskImageView oSMaskImageView = (OSMaskImageView) this.f6853b;
                zd.a aVar = oSMaskImageView.e;
                Path path = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maskDelegate");
                    aVar = null;
                }
                if (aVar.f11276b) {
                    zIsSelected = oSMaskImageView.isSelected();
                } else {
                    zIsSelected = !oSMaskImageView.isSelected();
                }
                oSMaskImageView.setSelected(zIsSelected);
                zd.a aVar2 = oSMaskImageView.e;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maskDelegate");
                    aVar2 = null;
                }
                aVar2.setReversed(false);
                Path path2 = oSMaskImageView.f3398b;
                if (path2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPath");
                } else {
                    path = path2;
                }
                path.reset();
                oSMaskImageView.invalidate();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        switch (this.f6852a) {
            case 6:
                super.onAnimationStart(animation);
                ((FootOperationBar) this.f6853b).setVisibility(0);
                break;
            case 7:
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                OSMaskImageView oSMaskImageView = (OSMaskImageView) this.f6853b;
                if (!oSMaskImageView.isSelected()) {
                    Paint mPaint = oSMaskImageView.getMPaint();
                    ColorStateList imageTintList = oSMaskImageView.getImageTintList();
                    mPaint.setColor(imageTintList != null ? imageTintList.getColorForState(new int[]{R.attr.state_selected}, -16776961) : -16776961);
                } else {
                    Paint mPaint2 = oSMaskImageView.getMPaint();
                    ColorStateList imageTintList2 = oSMaskImageView.getImageTintList();
                    mPaint2.setColor(imageTintList2 != null ? imageTintList2.getColorForState(new int[0], -7829368) : -7829368);
                }
                break;
            default:
                super.onAnimationStart(animation);
                break;
        }
    }
}
