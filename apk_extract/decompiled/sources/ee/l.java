package ee;

import android.animation.Animator;
import com.transsion.widgetslib.widget.seekbar.OSSeekbar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSSeekbar f4902b;

    public /* synthetic */ l(OSSeekbar oSSeekbar, int i8) {
        this.f4901a = i8;
        this.f4902b = oSSeekbar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animation) {
        switch (this.f4901a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f4902b.f3582e0 = false;
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f4902b.f3582e0 = false;
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animation) {
        switch (this.f4901a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f4902b.f3582e0 = false;
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f4902b.f3582e0 = false;
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animation) {
        switch (this.f4901a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f4902b.f3582e0 = true;
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f4902b.f3582e0 = true;
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animation) {
        switch (this.f4901a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f4902b.f3582e0 = true;
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f4902b.f3582e0 = true;
                break;
        }
    }
}
