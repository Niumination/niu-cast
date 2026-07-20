package fd;

import android.util.Property;
import android.view.View;
import android.view.animation.PathInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Property f5024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f5025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f5026d;
    public final float e;
    public final PathInterpolator f;

    public d(View mTarget, Property mProperty, float f, float f4, float f10, PathInterpolator i8) {
        Intrinsics.checkNotNullParameter(mTarget, "mTarget");
        Intrinsics.checkNotNullParameter(mProperty, "mProperty");
        Intrinsics.checkNotNullParameter(i8, "i");
        this.f5023a = mTarget;
        this.f5024b = mProperty;
        this.f5025c = f;
        this.f5026d = f4;
        this.e = f10;
        this.f = i8;
    }
}
