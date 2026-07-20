package zd;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator f11275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11276b;

    public a(ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.f11275a = animator;
        animator.setDuration(250L);
    }

    public final ValueAnimator getAnimator() {
        return this.f11275a;
    }

    public final void setReversed(boolean z2) {
        this.f11276b = z2;
    }
}
