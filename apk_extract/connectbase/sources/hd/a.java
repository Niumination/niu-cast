package hd;

import android.content.Context;
import android.view.SurfaceControl;
import android.view.View;
import com.transsion.hubsdk.internal.jank.TranInteractionJankMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ag.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f7107b = bc.a.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranInteractionJankMonitor f7106a = new TranInteractionJankMonitor();

    @Override // ag.a
    public boolean a(int i10, SurfaceControl surfaceControl, long j10, String str) {
        Context context;
        TranInteractionJankMonitor tranInteractionJankMonitor = this.f7106a;
        if (tranInteractionJankMonitor == null || (context = this.f7107b) == null) {
            return false;
        }
        return tranInteractionJankMonitor.beginWithSurface(i10, context, surfaceControl, j10, str);
    }

    @Override // ag.a
    public boolean b(int i10, int i11) {
        TranInteractionJankMonitor tranInteractionJankMonitor = this.f7106a;
        if (tranInteractionJankMonitor != null) {
            return tranInteractionJankMonitor.cancel(i10, i11);
        }
        return false;
    }

    @Override // ag.a
    public boolean c(View view, int i10) {
        TranInteractionJankMonitor tranInteractionJankMonitor = this.f7106a;
        if (tranInteractionJankMonitor != null) {
            return tranInteractionJankMonitor.begin(view, i10);
        }
        return false;
    }

    @Override // ag.a
    public boolean d(int i10, View view, long j10, String str) {
        TranInteractionJankMonitor tranInteractionJankMonitor = this.f7106a;
        if (tranInteractionJankMonitor != null) {
            return tranInteractionJankMonitor.beginWithView(i10, view, j10, str);
        }
        return false;
    }

    @Override // ag.a
    public boolean e(int i10) {
        TranInteractionJankMonitor tranInteractionJankMonitor = this.f7106a;
        if (tranInteractionJankMonitor != null) {
            return tranInteractionJankMonitor.end(i10);
        }
        return false;
    }
}
