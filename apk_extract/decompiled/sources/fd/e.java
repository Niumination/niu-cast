package fd;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import ee.k;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f5027a = new LinearInterpolator();

    public static ValueAnimator a(long j8, d... floatProp) {
        Intrinsics.checkNotNullParameter(floatProp, "floatProp");
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setDuration(j8);
        animator.setInterpolator(f5027a);
        animator.addUpdateListener(new k((d[]) Arrays.copyOf(floatProp, floatProp.length)));
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }
}
