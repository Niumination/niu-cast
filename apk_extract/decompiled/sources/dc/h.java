package dc;

import android.app.Application;
import android.util.Log;
import com.transsion.flamboyant.FoldableDeviceManager;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f4409a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FoldableDeviceManager f4410b;

    public final void a(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            f4410b = FoldableDeviceManager.get(context);
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter("FoldableDeviceManagerPr", "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat("FoldableDeviceManagerPr"), e.getMessage(), e);
        }
    }
}
