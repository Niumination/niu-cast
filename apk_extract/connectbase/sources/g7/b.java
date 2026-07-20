package g7;

import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import dc.e;
import gm.i;
import gm.j;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class b implements rf.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6430e = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DisplayManager f6431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f6432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class<?> f6433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f6434d = null;

    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x9.b.a f6435a;

        public a(x9.b.a aVar) {
            this.f6435a = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            e.c(b.f6430e, "invoke, methodName:" + name + ", args:" + objArr);
            if ("onDisplayAdded".equals(name)) {
                this.f6435a.onDisplayAdded(((Integer) objArr[0]).intValue());
                return null;
            }
            if (!"onDisplayRemoved".equals(name)) {
                return null;
            }
            this.f6435a.onDisplayRemoved(((Integer) objArr[0]).intValue());
            return null;
        }
    }

    public b() {
        this.f6432b = null;
        this.f6433c = null;
        if (this.f6431a == null) {
            DisplayManager displayManager = (DisplayManager) bc.a.a().getSystemService("display");
            this.f6431a = displayManager;
            Class<?> cls = displayManager.getClass();
            this.f6432b = cls;
            for (Class<?> cls2 : cls.getClasses()) {
                if (cls2.getName().contains("DualDisplayListener")) {
                    this.f6433c = cls2;
                    e.a(f6430e, "mDisplayLister:" + cls2);
                    return;
                }
            }
        }
    }

    @Override // rf.b
    public void a(int i10, x9.b.InterfaceC0500b interfaceC0500b) throws ac.a {
        throw new ac.a("can not find method registerFlexButtonCallback");
    }

    @Override // rf.b
    public boolean b() throws ac.a {
        throw new ac.a("can not find method isTentMode");
    }

    @Override // rf.b
    public void c() {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "display");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.hardware.display.ITranDisplayManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return;
        }
        cc.a.j(cc.a.g(objJ.getClass(), "closeDualDisplayForSelfie", new Class[0]), objJ, new Object[0]);
    }

    @Override // rf.b
    public void d(int i10, x9.b.d dVar) throws ac.a {
        throw new ac.a("can not find method registerTentModeCallback");
    }

    @Override // rf.b
    public void e(int i10, boolean z10, String str) {
        Method methodG;
        Object objJ;
        Method methodG2;
        Class clsA = cc.a.a("android.hardware.display.DisplayManagerGlobal");
        if (clsA == null || (methodG = cc.a.g(clsA, "getInstance", new Class[0])) == null || (objJ = cc.a.j(methodG, null, new Object[0])) == null || (methodG2 = cc.a.g(objJ.getClass(), "setTranAutoBrightnessTemporarily", Integer.TYPE, Boolean.TYPE, String.class)) == null) {
            return;
        }
        cc.a.j(methodG2, objJ, Integer.valueOf(i10), Boolean.valueOf(z10), str);
    }

    @Override // rf.b
    public void f(int i10) throws ac.a {
        throw new ac.a("can not find method unregisterFlexButtonCallback");
    }

    @Override // rf.b
    public void g(int i10, float f10) {
        cc.a.j(cc.a.g(this.f6431a.getClass(), "setBrightness", Integer.TYPE, Float.TYPE), this.f6431a, Integer.valueOf(i10), Float.valueOf(f10));
    }

    @Override // rf.b
    public int h() {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return -1;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "display");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.hardware.display.ITranDisplayManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return -1;
        }
        return ((Integer) cc.a.j(cc.a.g(objJ.getClass(), "getCurSelfieDisplayId", new Class[0]), objJ, new Object[0])).intValue();
    }

    @Override // rf.b
    public void i() {
        if (fc.a.b()) {
            cc.a.j(cc.a.g(this.f6431a.getClass(), "closeDualDisplay", new Class[0]), this.f6431a, new Object[0]);
        } else {
            e.a(f6430e, "can not find method closeDualDisplay.");
        }
    }

    @Override // rf.b
    public void j(@i x9.b.a aVar, @j Handler handler) {
        if (!fc.a.b()) {
            e.a(f6430e, "can not find method registerDualDisplayListener.");
            return;
        }
        Method methodG = cc.a.g(this.f6431a.getClass(), "registerDualDisplayListener", this.f6433c, Handler.class);
        Object objNewProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f6433c}, new a(aVar));
        this.f6434d = objNewProxyInstance;
        cc.a.j(methodG, this.f6431a, objNewProxyInstance, handler);
    }

    @Override // rf.b
    public int k() {
        Object objJ = cc.a.j(cc.a.g(this.f6431a.getClass(), "getForcedUsingDisplayMode", new Class[0]), this.f6431a, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // rf.b
    public void l(int i10, float f10) {
        cc.a.j(cc.a.g(this.f6431a.getClass(), "setTemporaryBrightness", Integer.TYPE, Float.TYPE), this.f6431a, Integer.valueOf(i10), Float.valueOf(f10));
    }

    @Override // rf.b
    public void m(int i10) throws ac.a {
        throw new ac.a("can not find method unregisterTentModeCallback");
    }

    @Override // rf.b
    public int n() {
        Object objJ = cc.a.j(cc.a.g(this.f6431a.getClass(), "getSourceConnectFlag", new Class[0]), this.f6431a, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // rf.b
    public void o(int i10) throws ac.a {
        throw new ac.a("can not find method unregisterSmartButtonCallback");
    }

    @Override // rf.b
    public void p(int i10, x9.b.c cVar) throws ac.a {
        throw new ac.a("can not find method registerSmartButtonCallback");
    }

    @Override // rf.b
    public int q() {
        return -1;
    }

    @Override // rf.b
    public boolean r(String str) throws ac.a {
        throw new ac.a("can not find method unRegisterPowerStateChangedListener");
    }

    @Override // rf.b
    public void s() {
        if (fc.a.b()) {
            cc.a.j(cc.a.g(this.f6431a.getClass(), "openDualDisplay", new Class[0]), this.f6431a, new Object[0]);
        } else {
            e.a(f6430e, "can not find method openDualDisplay.");
        }
    }

    @Override // rf.b
    public boolean t() {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA != null && (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) != null) {
            IBinder iBinder = (IBinder) cc.a.j(methodG, null, "display");
            Class clsA2 = cc.a.a("com.transsion.hubsdk.hardware.display.ITranDisplayManager$Stub");
            if (iBinder != null && clsA2 != null && (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) != null) {
                return ((Boolean) cc.a.j(cc.a.g(objJ.getClass(), "isDualDisplayForSelfie", new Class[0]), objJ, new Object[0])).booleanValue();
            }
        }
        return false;
    }

    @Override // rf.b
    public void u(String str, String str2) throws ac.a {
        throw new ac.a("can not find method addShowInDualDisplay");
    }

    @Override // rf.b
    public void v(Bundle bundle) {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "display");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.hardware.display.ITranDisplayManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return;
        }
        cc.a.j(cc.a.g(objJ.getClass(), "openDualDisplayForSelfie", Bundle.class), objJ, bundle);
    }

    @Override // rf.b
    public boolean w(x9.b.e eVar, String str) throws ac.a {
        throw new ac.a("can not find method registerPowerStateChangedCallback");
    }

    @Override // rf.b
    public void x(x9.b.a aVar) {
        if (fc.a.b()) {
            cc.a.j(cc.a.g(this.f6431a.getClass(), "unregisterDualDisplayListener", this.f6433c), this.f6431a, this.f6434d);
        } else {
            e.a(f6430e, "can not find method unregisterDualDisplayListener.");
        }
    }
}
