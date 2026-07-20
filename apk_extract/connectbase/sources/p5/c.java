package p5;

import android.content.Context;
import android.provider.Settings;
import com.transsion.connectx.mirror.source.SourceApplication;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final c f12806a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f12807b = "BridgeSdkProvider";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f12808c = "com.transsion.launcher3";

    public final void a(@os.l Context context) {
        kn.l0.p(context, "context");
        k4.m.e(f12807b, "init");
        hi.l.i(context, new hi.a(f12808c, hi.f.PUBLISHER));
        hi.l.F(false);
    }

    public final void b(hi.j jVar) {
        k4.m.e(f12807b, "registerClickListener");
        hi.l.E(jVar);
    }

    public final void c(hi.j jVar) {
        k4.m.e(f12807b, "removeClickListener");
        hi.l.A(jVar);
    }

    public final void d(boolean z10, @os.l hi.j jVar) {
        kn.l0.p(jVar, "listener");
        k4.m.e(f12807b, "setIconVisible: " + z10);
        hi.l.F(z10);
        if (z10) {
            b(jVar);
        } else {
            c(jVar);
        }
    }

    public final void e(boolean z10) {
        k4.m.e(f12807b, "setMirrorVisible: " + z10);
        Settings.Global.putString(SourceApplication.b().getContentResolver(), hi.b.f7117f, z10 ? "1" : hi.b.f7118g);
    }
}
