package j7;

import android.graphics.Region;
import android.hardware.input.InputManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.InputEvent;
import android.view.KeyEvent;
import dc.e;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements uf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8598c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputManager f8599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f8600b;

    public class a extends rb.a.b {
        public a() {
        }

        @Override // rb.a
        public void dispose() {
            if (c.this.f8600b != null) {
                c.this.f8600b.d();
            }
        }

        @Override // rb.a
        public void z() {
            if (c.this.f8600b != null) {
                c.this.f8600b.e();
            }
        }
    }

    public c() {
        if (this.f8599a == null) {
            this.f8599a = (InputManager) bc.a.a().getSystemService(InputManager.class);
        }
    }

    public static /* synthetic */ void k(rb.b bVar, InputEvent inputEvent) {
        try {
            bVar.m(inputEvent);
        } catch (RemoteException e10) {
            b.a("handleInputEvent fail:", e10, f8598c);
        }
    }

    @Override // uf.a
    public void a(KeyEvent keyEvent) {
        Method methodG;
        try {
            InputManager inputManager = this.f8599a;
            if (inputManager == null || (methodG = cc.a.g(inputManager.getClass(), "singleKeyPanicBehaviorCheck", KeyEvent.class)) == null) {
                return;
            }
            cc.a.j(methodG, this.f8599a, keyEvent);
        } catch (Exception unused) {
            e.a(f8598c, "singleKeyPanicBehaviorCheck not exist.");
        }
    }

    @Override // uf.a
    public void b(sb.b bVar) {
    }

    @Override // uf.a
    public boolean c(InputEvent inputEvent, int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f8599a.getClass(), "injectInputEvent", InputEvent.class, Integer.TYPE), this.f8599a, inputEvent, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // uf.a
    public rb.a d(String str, int i10, final rb.b bVar) {
        Object objJ = cc.a.j(cc.a.g(this.f8599a.getClass(), "monitorGestureInput", String.class, Integer.TYPE), this.f8599a, str, Integer.valueOf(i10));
        if (objJ == null) {
            return null;
        }
        this.f8600b = new d(objJ, new d.b() { // from class: j7.a
            @Override // j7.d.b
            public final void m(InputEvent inputEvent) {
                c.k(bVar, inputEvent);
            }
        });
        return new a();
    }

    @Override // uf.a
    public void e(IBinder iBinder, Region region) {
        Method methodG;
        InputManager inputManager = this.f8599a;
        if (inputManager == null || (methodG = cc.a.g(inputManager.getClass(), "updateBackGestureRegion", IBinder.class, Region.class)) == null) {
            return;
        }
        cc.a.j(methodG, this.f8599a, iBinder, region);
    }

    @Override // uf.a
    public void f(sb.b bVar) {
    }

    @Override // uf.a
    public void g(IBinder iBinder, boolean z10) {
        Method methodG;
        InputManager inputManager = this.f8599a;
        if (inputManager == null || (methodG = cc.a.g(inputManager.getClass(), "setBackGestureResult", IBinder.class, Boolean.TYPE)) == null) {
            return;
        }
        cc.a.j(methodG, this.f8599a, iBinder, Boolean.valueOf(z10));
    }

    @Override // uf.a
    public void h(boolean z10) {
        Method methodG;
        InputManager inputManager = this.f8599a;
        if (inputManager == null || (methodG = cc.a.g(inputManager.getClass(), "setBackGestureMode", Boolean.TYPE)) == null) {
            return;
        }
        cc.a.j(methodG, this.f8599a, Boolean.valueOf(z10));
    }
}
