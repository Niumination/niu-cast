package androidx.core.view;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import in.n;
import k4.f;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
final class Api16Impl {

    @l
    public static final Api16Impl INSTANCE = new Api16Impl();

    private Api16Impl() {
    }

    @n
    @DoNotInline
    public static final void postOnAnimationDelayed(@l View view, @l Runnable runnable, long j10) {
        l0.p(view, "view");
        l0.p(runnable, f.f8937e);
        view.postOnAnimationDelayed(runnable, j10);
    }
}
