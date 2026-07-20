package fd;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSPageView f5018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WeakReference f5019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f5020c;

    public b(OSPageView oSPageView, WeakReference weakReference, a aVar) {
        this.f5018a = oSPageView;
        this.f5019b = weakReference;
        this.f5020c = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        AnimatorSet animatorSet = c.f5021a;
        c.a(this.f5019b, 1, this.f5020c);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        AnimatorSet animatorSet = c.f5021a;
        c.a(this.f5019b, 1, this.f5020c);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        OSPageView oSPageView = this.f5018a;
        oSPageView.setVisibility(0);
        oSPageView.setAlpha(0.0f);
    }
}
