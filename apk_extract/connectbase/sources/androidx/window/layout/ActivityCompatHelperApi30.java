package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public final class ActivityCompatHelperApi30 {

    @l
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    @l
    public final Rect currentWindowBounds(@l Activity activity) {
        l0.p(activity, "activity");
        Rect bounds = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        l0.o(bounds, "activity.windowManager.currentWindowMetrics.bounds");
        return bounds;
    }

    @l
    public final Rect maximumWindowBounds(@l Activity activity) {
        l0.p(activity, "activity");
        Rect bounds = activity.getWindowManager().getMaximumWindowMetrics().getBounds();
        l0.o(bounds, "activity.windowManager.maximumWindowMetrics.bounds");
        return bounds;
    }
}
