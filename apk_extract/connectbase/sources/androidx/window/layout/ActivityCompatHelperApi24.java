package androidx.window.layout;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class ActivityCompatHelperApi24 {

    @l
    public static final ActivityCompatHelperApi24 INSTANCE = new ActivityCompatHelperApi24();

    private ActivityCompatHelperApi24() {
    }

    public final boolean isInMultiWindowMode(@l Activity activity) {
        l0.p(activity, "activity");
        return activity.isInMultiWindowMode();
    }
}
