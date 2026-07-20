package nd;

import android.view.animation.PathInterpolator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Lambda implements Function0 {
    public static final k INSTANCE = new k();

    public k() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final PathInterpolator invoke() {
        return new PathInterpolator(0.2f, 0.0f, 0.1f, 1.0f);
    }
}
