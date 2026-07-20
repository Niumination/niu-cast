package o9;

import android.graphics.Outline;
import com.transsion.hubsdk.graphics.TranOutline;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements z9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TranOutline f8416a = new TranOutline();

    @Override // z9.b
    public final void a(Outline outline, int i8, int i9, float f, int i10) {
        TranOutline tranOutline = this.f8416a;
        if (tranOutline != null) {
            tranOutline.setSmoothRoundRect(outline, 0, 0, i8, i9, f, i10);
        } else {
            j9.a.b("b", "cannot get core");
        }
    }
}
