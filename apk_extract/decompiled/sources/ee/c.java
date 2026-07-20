package ee;

import android.content.Context;
import com.transsion.widgetslib.widget.seekbar.OSSectionSeekbar;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSSectionSeekbar f4850b;

    public /* synthetic */ c(OSSectionSeekbar oSSectionSeekbar, int i8) {
        this.f4849a = i8;
        this.f4850b = oSSectionSeekbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OSSectionSeekbar this$0 = this.f4850b;
        switch (this.f4849a) {
            case 0:
                int i8 = OSSectionSeekbar.p0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.requestLayout();
                break;
            default:
                int i9 = OSSectionSeekbar.p0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Context context = this$0.f3547a;
                Method method = pd.k.f8783a;
                Intrinsics.checkNotNullParameter(context, "context");
                pd.k.a(context, "Cam_mode_sw.he");
                break;
        }
    }
}
