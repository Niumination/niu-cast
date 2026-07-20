package androidx.window.layout;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@RestrictTo({RestrictTo.Scope.TESTS})
public interface WindowMetricsCalculatorDecorator {
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    @l
    WindowMetricsCalculator decorate(@l WindowMetricsCalculator windowMetricsCalculator);
}
