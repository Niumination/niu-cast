package l7;

import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements wf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9745a = "TP cannot implement, please implement yourself";

    @Override // wf.a
    public void a(ca.a.InterfaceC0061a interfaceC0061a) throws ac.a {
        throw new ac.a(f9745a);
    }

    @Override // wf.a
    public void b(int i10, ca.a.InterfaceC0061a interfaceC0061a) throws ac.a {
        throw new ac.a(f9745a);
    }

    public final Object c() {
        Method methodG;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA != null && (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) != null) {
            IBinder iBinder = (IBinder) cc.a.j(methodG, null, "trantp");
            Class clsA2 = cc.a.a("com.transsion.hubsdk.hardware.tp.ITranTpManager$Stub");
            if (iBinder != null && clsA2 != null) {
                return cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder);
            }
        }
        return null;
    }

    @Override // wf.a
    public String getValue(int i10) throws ac.a {
        Method methodG;
        Object objC = c();
        if (objC == null || (methodG = cc.a.g(objC.getClass(), "getValue", Integer.TYPE)) == null) {
            return null;
        }
        return (String) cc.a.j(methodG, objC, Integer.valueOf(i10));
    }

    @Override // wf.a
    public boolean setValue(int i10, String str) throws ac.a {
        Method methodG;
        Object objC = c();
        if (objC == null || (methodG = cc.a.g(objC.getClass(), "setValue", Integer.TYPE, String.class)) == null) {
            return false;
        }
        return Boolean.TRUE.equals(cc.a.j(methodG, objC, Integer.valueOf(i10), str));
    }
}
