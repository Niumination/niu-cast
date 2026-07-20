package ee;

import android.content.Context;
import com.transsion.widgetslib.widget.seekbar.OSSeekbar;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSSeekbar f4877b;

    public /* synthetic */ h(OSSeekbar oSSeekbar, int i8) {
        this.f4876a = i8;
        this.f4877b = oSSeekbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OSSeekbar this$0 = this.f4877b;
        switch (this.f4876a) {
            case 0:
                int i8 = OSSeekbar.D0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.requestLayout();
                break;
            default:
                int i9 = OSSeekbar.D0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Context context = this$0.f3576a;
                Method method = pd.k.f8783a;
                Intrinsics.checkNotNullParameter(context, "context");
                pd.k.a(context, "Cam_mode_sw.he");
                break;
        }
    }
}
