package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import dc.d;
import in.n;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
final class Api19Impl {

    @l
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    @n
    @DoNotInline
    public static final void addPauseListener(@l Animator animator, @l Animator.AnimatorPauseListener animatorPauseListener) {
        l0.p(animator, d.f3684o);
        l0.p(animatorPauseListener, "listener");
        animator.addPauseListener(animatorPauseListener);
    }
}
