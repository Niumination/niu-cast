package u2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zax;

/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f10331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RootTelemetryConfiguration f10332c = new RootTelemetryConfiguration(0, 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f10333d = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f10334a;

    public /* synthetic */ e(Object obj) {
        this.f10334a = obj;
    }

    public static synchronized e b() {
        try {
            if (f10331b == null) {
                f10331b = new e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f10331b;
    }

    public static View e(int i8, int i9, Context context) throws f3.c {
        e eVar = f10333d;
        try {
            zax zaxVar = new zax(1, i8, i9, null);
            return (View) f3.b.l(((i) eVar.d(context)).l(new f3.b(context), zaxVar));
        } catch (Exception e) {
            throw new f3.c(o.d.f(i8, i9, "Could not get button with size ", " and color "), e);
        }
    }

    @Override // u2.b
    public void a(ConnectionResult connectionResult) {
        boolean z2 = connectionResult.f1798b == 0;
        p3.a aVar = (p3.a) this.f10334a;
        if (z2) {
            aVar.d(null, aVar.f1894y);
            return;
        }
        e eVar = aVar.q;
        if (eVar != null) {
            ((q2.h) eVar.f10334a).g(connectionResult);
        }
    }

    public i c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof i ? (i) iInterfaceQueryLocalInterface : new i(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator", 0);
    }

    public Object d(Context context) throws f3.c {
        Context contextCreatePackageContext;
        if (((i) this.f10334a) == null) {
            l.e(context);
            int i8 = p2.c.f8653c;
            try {
                contextCreatePackageContext = context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                contextCreatePackageContext = null;
            }
            if (contextCreatePackageContext == null) {
                throw new f3.c("Could not get remote context.");
            }
            try {
                this.f10334a = c((IBinder) contextCreatePackageContext.getClassLoader().loadClass("com.google.android.gms.common.ui.SignInButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new f3.c("Could not load creator class.", e);
            } catch (IllegalAccessException e4) {
                throw new f3.c("Could not access creator.", e4);
            } catch (InstantiationException e10) {
                throw new f3.c("Could not instantiate creator.", e10);
            }
        }
        return (i) this.f10334a;
    }
}
