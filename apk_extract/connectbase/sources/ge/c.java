package ge;

import android.content.Context;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.internal.statusbar.ITranStatusBar;
import com.transsion.hubsdk.internal.statusbar.ITranStatusBarService;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ah.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6469c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranStatusBarService f6470a = ITranStatusBarService.Stub.asInterface(TranServiceManager.getServiceIBinder("statusbar"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f6471b = bc.a.a();

    public class a extends ITranStatusBar.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.c f6472a;

        public a(h9.c cVar) {
            this.f6472a = cVar;
        }

        public void a(String str, boolean z10, String str2) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.a(str, z10, str2);
                } catch (Exception e10) {
                    p6.b.a("autoStartFullIntent: ", e10, c.f6469c);
                }
            }
        }

        public void b(String str, boolean z10) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.j(str, z10);
                } catch (Exception e10) {
                    p6.b.a("customGesturesEnable: ", e10, c.f6469c);
                }
            }
        }

        public void c(String str, boolean z10, String str2) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.l(str, z10, str2);
                } catch (Exception e10) {
                    p6.b.a("customHeadsUp: ", e10, c.f6469c);
                }
            }
        }

        public void d(String str, boolean z10) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.d(str, z10);
                } catch (Exception e10) {
                    p6.b.a("customNotificationStyle: ", e10, c.f6469c);
                }
            }
        }

        public void e(String str, boolean z10) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.h(str, z10);
                } catch (Exception e10) {
                    p6.b.a("customPanelEnable: ", e10, c.f6469c);
                }
            }
        }

        public void f(String str, String str2, boolean z10) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.q(str, str2, z10);
                } catch (Exception e10) {
                    p6.b.a("enableAction: ", e10, c.f6469c);
                }
            }
        }

        public void g(String str, String str2, boolean z10, String str3) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.k(str, str2, z10, str3);
                } catch (Exception e10) {
                    p6.b.a("enableActionWithUrl: ", e10, c.f6469c);
                }
            }
        }

        public void h(String str) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.n(str);
                } catch (Exception e10) {
                    p6.b.a("onDestoryCallback: ", e10, c.f6469c);
                }
            }
        }

        public void i(String str, boolean z10, String str2) {
            h9.c cVar = this.f6472a;
            if (cVar != null) {
                try {
                    cVar.p(str, z10, str2);
                } catch (Exception e10) {
                    p6.b.a("updateCloseHeadsUp: ", e10, c.f6469c);
                }
            }
        }
    }

    @Override // ah.a
    public void a(String str, boolean z10, String str2) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.autoStartFullIntent(str, z10, str2);
            }
        } catch (RemoteException e10) {
            j7.b.a("autoStartFullIntent:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void d(String str, boolean z10) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.customNotificationStyle(str, z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("customNotificationStyle:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void e() {
        new f().c(new f.b() { // from class: ge.a
            @Override // zb.f.b
            public final Object run() {
                return this.f6467a.g();
            }
        }, "statusbar");
        e.f(f6469c, "expandNotificationsPanel");
    }

    public final /* synthetic */ Object g() throws RemoteException {
        ITranStatusBarService iTranStatusBarService = this.f6470a;
        if (iTranStatusBarService == null) {
            return null;
        }
        iTranStatusBarService.expandNotificationsPanel();
        return null;
    }

    @Override // ah.a
    public void h(String str, boolean z10) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.customPanelEnable(str, z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("customPanelEnable:", e10, f6469c);
        }
    }

    public final /* synthetic */ Object i() throws RemoteException {
        ITranStatusBarService iTranStatusBarService = this.f6470a;
        if (iTranStatusBarService == null) {
            return null;
        }
        iTranStatusBarService.expandSettingsPanel();
        return null;
    }

    @Override // ah.a
    public void j(String str, boolean z10) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.customGesturesEnable(str, z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("customGesturesEnable:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void k(String str, String str2, boolean z10, String str3) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.enableActionWithUrl(str, str2, z10, str3);
            }
        } catch (RemoteException e10) {
            j7.b.a("enableActionWithUrl:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void l(String str, boolean z10, String str2) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.customHeadsUp(str, z10, str2);
            }
        } catch (RemoteException e10) {
            j7.b.a("customHeadsUp:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void m() {
        new f().c(new f.b() { // from class: ge.b
            @Override // zb.f.b
            public final Object run() {
                return this.f6468a.i();
            }
        }, "statusbar");
        e.f(f6469c, "expandSettingsPanel");
    }

    @Override // ah.a
    public void n(String str) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.onDestoryCallback(str);
            }
        } catch (RemoteException e10) {
            j7.b.a("onDestoryCallback:", e10, f6469c);
        }
    }

    @VisibleForTesting
    public void o(ITranStatusBarService iTranStatusBarService) {
        this.f6470a = iTranStatusBarService;
    }

    @Override // ah.a
    public void p(String str, boolean z10, String str2) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.updateCloseHeadsUp(str, z10, str2);
            }
        } catch (RemoteException e10) {
            j7.b.a("updateCloseHeadsUp:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void q(String str, String str2, boolean z10) {
        try {
            ITranStatusBarService iTranStatusBarService = this.f6470a;
            if (iTranStatusBarService != null) {
                iTranStatusBarService.enableAction(str, str2, z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("enableAction:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void r(String str, int i10, int i11, String str2) {
        ITranStatusBarService iTranStatusBarService = this.f6470a;
        if (iTranStatusBarService == null) {
            return;
        }
        try {
            iTranStatusBarService.setIcon(str, this.f6471b.getPackageName(), i10, i11, str2);
        } catch (RemoteException e10) {
            j7.b.a("setIcon:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void s() {
        ITranStatusBarService iTranStatusBarService = this.f6470a;
        if (iTranStatusBarService == null) {
            return;
        }
        try {
            iTranStatusBarService.collapsePanels();
        } catch (RemoteException e10) {
            j7.b.a("collapsePanels:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void t() {
        try {
            this.f6470a.showPinningEscapeToast();
        } catch (RemoteException e10) {
            j7.b.a("showPinningEscapeToast:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void u(String str, boolean z10) {
        ITranStatusBarService iTranStatusBarService = this.f6470a;
        if (iTranStatusBarService == null) {
            return;
        }
        try {
            iTranStatusBarService.setIconVisibility(str, z10);
        } catch (RemoteException e10) {
            j7.b.a("setIconVisibility:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void v(int i10) {
        ITranStatusBarService iTranStatusBarService = this.f6470a;
        if (iTranStatusBarService == null) {
            return;
        }
        try {
            iTranStatusBarService.disable(i10);
        } catch (RemoteException e10) {
            j7.b.a("disable:", e10, f6469c);
        }
    }

    @Override // ah.a
    public void w(h9.c cVar) {
        if (this.f6470a == null || cVar == null) {
            return;
        }
        try {
            this.f6470a.registerTranStatusBar(new a(cVar));
        } catch (RemoteException e10) {
            j7.b.a("registerTranStatusBar e:", e10, f6469c);
        }
    }
}
