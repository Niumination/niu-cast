package q8;

import android.content.Context;
import com.android.internal.annotations.VisibleForTesting;
import dc.e;
import h9.c;
import java.lang.reflect.Method;
import p6.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ah.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13866c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f13867d = cc.a.a("android.app.StatusBarManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13868a = bc.a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f13869b;

    @Override // ah.a
    public void a(String str, boolean z10, String str2) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "autoStartFullIntent", String.class, Boolean.TYPE, String.class);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str, Boolean.valueOf(z10), str2);
            }
        } catch (Exception e10) {
            b.a("autoStartFullIntent fail ", e10, f13866c);
        }
    }

    @VisibleForTesting
    public void b(Object obj) {
        this.f13869b = obj;
    }

    @Override // ah.a
    public void d(String str, boolean z10) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "customNotificationStyle", String.class, Boolean.TYPE);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str, Boolean.valueOf(z10));
            }
        } catch (Exception e10) {
            b.a("customNotificationStyle fail ", e10, f13866c);
        }
    }

    @Override // ah.a
    public void e() {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "expandNotificationsPanel", new Class[0]);
            methodG.setAccessible(true);
            methodG.invoke(this.f13869b, null);
        } catch (Throwable th2) {
            m7.a.a("expandNotificationsPanel fail ", th2, f13866c);
        }
    }

    @Override // ah.a
    public void h(String str, boolean z10) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "customPanelEnable", String.class, Boolean.TYPE);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str, Boolean.valueOf(z10));
            }
        } catch (Exception e10) {
            b.a("customPanelEnable fail ", e10, f13866c);
        }
    }

    @Override // ah.a
    public void j(String str, boolean z10) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "customGesturesEnable", String.class, Boolean.TYPE);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str, Boolean.valueOf(z10));
            }
        } catch (Exception e10) {
            b.a("customGesturesEnable fail ", e10, f13866c);
        }
    }

    @Override // ah.a
    public void k(String str, String str2, boolean z10, String str3) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "enableActionWithUrl", String.class, String.class, Boolean.TYPE, String.class);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str, str2, Boolean.valueOf(z10), str3);
            }
        } catch (Exception e10) {
            b.a("enableActionWithUrl fail ", e10, f13866c);
        }
    }

    @Override // ah.a
    public void l(String str, boolean z10, String str2) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "customHeadsUp", String.class, Boolean.TYPE, String.class);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str, Boolean.valueOf(z10), str2);
            }
        } catch (Exception e10) {
            b.a("customHeadsUp fail ", e10, f13866c);
        }
    }

    @Override // ah.a
    public void m() {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "expandSettingsPanel", new Class[0]);
            methodG.setAccessible(true);
            methodG.invoke(this.f13869b, null);
        } catch (Throwable th2) {
            m7.a.a("expandSettingsPanel fail ", th2, f13866c);
        }
    }

    @Override // ah.a
    public void n(String str) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "onDestoryCallback", String.class);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str);
            }
        } catch (Exception e10) {
            b.a("onDestoryCallback fail ", e10, f13866c);
        }
    }

    @Override // ah.a
    public void p(String str, boolean z10, String str2) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "updateCloseHeadsUp", String.class, Boolean.TYPE, String.class);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str, Boolean.valueOf(z10), str2);
            }
        } catch (Exception e10) {
            b.a("updateCloseHeadsUp fail ", e10, f13866c);
        }
    }

    @Override // ah.a
    public void q(String str, String str2, boolean z10) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "enableAction", String.class, String.class, Boolean.TYPE);
            if (methodG != null) {
                cc.a.j(methodG, this.f13869b, str, str2, Boolean.valueOf(z10));
            }
        } catch (Exception e10) {
            b.a("enableAction fail ", e10, f13866c);
        }
    }

    @Override // ah.a
    public void r(String str, int i10, int i11, String str2) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Class<?> cls = this.f13869b.getClass();
            Class cls2 = Integer.TYPE;
            Method methodG = cc.a.g(cls, "setIcon", String.class, cls2, cls2, String.class);
            methodG.setAccessible(true);
            methodG.invoke(this.f13869b, str, Integer.valueOf(i10), Integer.valueOf(i11), str2);
        } catch (Throwable th2) {
            m7.a.a("setIcon fail ", th2, f13866c);
        }
    }

    @Override // ah.a
    public void s() {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "collapsePanels", new Class[0]);
            methodG.setAccessible(true);
            methodG.invoke(this.f13869b, null);
        } catch (Throwable th2) {
            m7.a.a("collapsePanels fail ", th2, f13866c);
        }
    }

    @Override // ah.a
    public void t() {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "showPinningEscapeToast", new Class[0]);
            methodG.setAccessible(true);
            methodG.invoke(this.f13869b, null);
        } catch (Throwable th2) {
            m7.a.a("showPinningEscapeToast fail ", th2, f13866c);
        }
    }

    @Override // ah.a
    public void u(String str, boolean z10) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "setIconVisibility", String.class, Boolean.TYPE);
            methodG.setAccessible(true);
            methodG.invoke(this.f13869b, str, Boolean.valueOf(z10));
        } catch (Throwable th2) {
            m7.a.a("setIconVisibility fail ", th2, f13866c);
        }
    }

    @Override // ah.a
    public void v(int i10) {
        try {
            if (this.f13869b == null) {
                this.f13869b = cc.a.c(f13867d, new Class[]{Context.class}).newInstance(this.f13868a);
            }
            Method methodG = cc.a.g(this.f13869b.getClass(), "disable", Integer.TYPE);
            methodG.setAccessible(true);
            methodG.invoke(this.f13869b, Integer.valueOf(i10));
        } catch (Throwable th2) {
            m7.a.a("disable fail ", th2, f13866c);
        }
    }

    @Override // ah.a
    public void w(c cVar) {
        e.n(f13866c, "can not find method registerTranStatusBar");
    }
}
