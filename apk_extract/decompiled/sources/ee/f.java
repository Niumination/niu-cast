package ee;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.transsion.widgetslib.widget.seekbar.OSSectionSeekbar;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4873b;

    public /* synthetic */ f(Object obj, int i8) {
        this.f4872a = i8;
        this.f4873b = obj;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animation) {
        Object obj = this.f4873b;
        int i8 = this.f4872a;
        Intrinsics.checkNotNullParameter(animation, "animation");
        switch (i8) {
            case 0:
                ((OSSectionSeekbar) obj).W = false;
                break;
            default:
                AnimatorSet animatorSet = fd.c.f5021a;
                fd.c.a((WeakReference) obj, 0, null);
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animation) {
        Object obj = this.f4873b;
        int i8 = this.f4872a;
        Intrinsics.checkNotNullParameter(animation, "animation");
        switch (i8) {
            case 0:
                ((OSSectionSeekbar) obj).W = false;
                break;
            default:
                AnimatorSet animatorSet = fd.c.f5021a;
                fd.c.a((WeakReference) obj, 0, null);
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animation) {
        switch (this.f4872a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                ((OSSectionSeekbar) this.f4873b).W = true;
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animation) {
        switch (this.f4872a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                ((OSSectionSeekbar) this.f4873b).W = true;
                break;
            default:
                Intrinsics.checkNotNullParameter(animation, "animation");
                break;
        }
    }
}
