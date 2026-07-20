package androidx.window.layout;

import android.graphics.Point;
import android.view.Display;
import androidx.annotation.RequiresApi;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(17)
public final class DisplayCompatHelperApi17 {

    @l
    public static final DisplayCompatHelperApi17 INSTANCE = new DisplayCompatHelperApi17();

    private DisplayCompatHelperApi17() {
    }

    public final void getRealSize(@l Display display, @l Point point) {
        l0.p(display, "display");
        l0.p(point, "point");
        display.getRealSize(point);
    }
}
