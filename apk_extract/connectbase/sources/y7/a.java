package y7;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements jg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20764b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20765a;

    public a() {
        if (this.f20765a == null) {
            this.f20765a = bc.a.a();
        }
    }

    @Override // jg.a
    public Intent a(int i10, String str, int i11, boolean z10) {
        try {
            Object objJ = cc.a.j(cc.a.g(Class.forName("android.app.role.IRoleManager$Stub"), "asInterface", IBinder.class), null, (IBinder) cc.a.j(cc.a.g(Class.forName("android.os.ServiceManager"), "getService", String.class), null, "media_projection"));
            Class<?> cls = objJ.getClass();
            Class cls2 = Integer.TYPE;
            Object objJ2 = cc.a.j(cc.a.g(cls, "createProjection", cls2, String.class, cls2, Boolean.TYPE), objJ, Integer.valueOf(i10), str, Integer.valueOf(i11), Boolean.valueOf(z10));
            IBinder iBinder = (IBinder) cc.a.j(cc.a.g(objJ2.getClass(), "asBinder", new Class[0]), objJ2, new Object[0]);
            Intent intent = new Intent();
            cc.a.j(cc.a.g(intent.getClass(), "putExtra", String.class, IBinder.class), intent, "android.media.projection.extra.EXTRA_MEDIA_PROJECTION", iBinder);
            return intent;
        } catch (Exception e10) {
            e.c(f20764b, "getPutIBindIntent fail: " + e10);
            return new Intent();
        }
    }
}
