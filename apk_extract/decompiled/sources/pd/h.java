package pd;

import android.content.Context;
import android.graphics.Insets;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f8760a;

    public h(Context context) {
        this.f8760a = context;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        Context context = this.f8760a;
        if (context == null) {
            return windowInsets;
        }
        Insets insets = windowInsets.getInsets(WindowInsets.Side.all());
        Display display = context.getDisplay();
        boolean zQ = j.q(context);
        if (display != null) {
            if (display.getRotation() == 1) {
                windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout(), Insets.of(0, insets.top, zQ ? 0 : insets.right, 0)).build();
            } else if (display.getRotation() == 3) {
                windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout(), Insets.of(zQ ? 0 : insets.left, insets.top, 0, 0)).build();
            } else {
                windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Side.all(), Insets.of(0, insets.top, 0, insets.bottom)).build();
            }
        }
        return view.onApplyWindowInsets(windowInsets);
    }
}
