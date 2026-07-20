package p7;

import android.content.Context;
import android.view.SurfaceControl;
import android.view.View;
import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ag.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f13022a = cc.a.a("com.android.internal.jank.InteractionJankMonitor");

    @Override // ag.a
    public boolean a(int i10, SurfaceControl surfaceControl, long j10, String str) {
        Class clsA = cc.a.a("com.android.internal.jank.InteractionJankMonitor$Configuration$Builder");
        Class clsA2 = cc.a.a("com.android.internal.jank.InteractionJankMonitor");
        Object objJ = cc.a.j(cc.a.g(clsA, "withSurface", Integer.TYPE, Context.class, SurfaceControl.class), null, Integer.valueOf(i10), bc.a.a(), surfaceControl);
        cc.a.j(cc.a.g(objJ.getClass(), "setTimeout", Long.TYPE), objJ, Long.valueOf(j10));
        cc.a.j(cc.a.g(objJ.getClass(), "setTag", String.class), objJ, str);
        Object objJ2 = cc.a.j(cc.a.g(clsA2, "getInstance", new Class[0]), null, new Object[0]);
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(clsA2, "begin", clsA), objJ2, objJ));
    }

    @Override // ag.a
    public boolean b(int i10, int i11) {
        Boolean bool;
        Method methodG = cc.a.g(this.f13022a, "getInstance", new Class[0]);
        if (methodG == null) {
            return false;
        }
        Object objJ = cc.a.j(methodG, null, new Object[0]);
        Class cls = this.f13022a;
        Class cls2 = Integer.TYPE;
        Method methodG2 = cc.a.g(cls, "cancel", cls2, cls2);
        return (objJ == null || methodG2 == null || (bool = (Boolean) cc.a.j(methodG2, objJ, Integer.valueOf(i10), Integer.valueOf(i11))) == null || !bool.booleanValue()) ? false : true;
    }

    @Override // ag.a
    public boolean c(View view, int i10) {
        Boolean bool;
        Method methodG = cc.a.g(this.f13022a, "getInstance", new Class[0]);
        if (methodG == null) {
            return false;
        }
        Object objJ = cc.a.j(methodG, null, new Object[0]);
        Method methodG2 = cc.a.g(this.f13022a, "begin", View.class, Integer.TYPE);
        return (objJ == null || methodG2 == null || (bool = (Boolean) cc.a.j(methodG2, objJ, view, Integer.valueOf(i10))) == null || !bool.booleanValue()) ? false : true;
    }

    @Override // ag.a
    public boolean d(int i10, View view, long j10, String str) {
        Class clsA = cc.a.a("com.android.internal.jank.InteractionJankMonitor$Configuration$Builder");
        Class clsA2 = cc.a.a("com.android.internal.jank.InteractionJankMonitor");
        Object objJ = cc.a.j(cc.a.g(clsA, "withView", Integer.TYPE, View.class), null, Integer.valueOf(i10), view);
        cc.a.j(cc.a.g(objJ.getClass(), "setTimeout", Long.TYPE), objJ, Long.valueOf(j10));
        cc.a.j(cc.a.g(objJ.getClass(), "setTag", String.class), objJ, str);
        Object objJ2 = cc.a.j(cc.a.g(clsA2, "getInstance", new Class[0]), null, new Object[0]);
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(clsA2, "begin", clsA), objJ2, objJ));
    }

    @Override // ag.a
    public boolean e(int i10) {
        Boolean bool;
        Method methodG = cc.a.g(this.f13022a, "getInstance", new Class[0]);
        if (methodG == null) {
            return false;
        }
        Object objJ = cc.a.j(methodG, null, new Object[0]);
        Method methodG2 = cc.a.g(this.f13022a, FloatingWindow.f2049c0, Integer.TYPE);
        return (objJ == null || methodG2 == null || (bool = (Boolean) cc.a.j(methodG2, objJ, Integer.valueOf(i10))) == null || !bool.booleanValue()) ? false : true;
    }
}
