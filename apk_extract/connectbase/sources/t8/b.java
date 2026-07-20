package t8;

import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b implements dh.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15525c = "Calling this method is prohibited, please implement it yourself.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f15526a = cc.a.a("com.mediatek.internal.telephony.IMtkTelephonyEx$Stub");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f15527b;

    @Override // dh.b
    public boolean a(int i10) throws ac.a {
        if (this.f15527b == null) {
            this.f15527b = d();
        }
        Object obj = this.f15527b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "isPhbReady", Integer.TYPE);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15527b, Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // dh.b
    public String b(int i10) throws ac.a {
        if (this.f15527b == null) {
            this.f15527b = d();
        }
        Object obj = this.f15527b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getIccCardType", Integer.TYPE);
        if (methodG != null) {
            return (String) cc.a.j(methodG, this.f15527b, Integer.valueOf(i10));
        }
        return null;
    }

    @Override // dh.b
    public int[] c(int i10) throws ac.a {
        if (this.f15527b == null) {
            this.f15527b = d();
        }
        Object obj = this.f15527b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getAdnStorageInfo", Integer.TYPE);
        if (methodG != null) {
            return (int[]) cc.a.j(methodG, this.f15527b, Integer.valueOf(i10));
        }
        return null;
    }

    public final Object d() {
        Method methodG;
        Class clsA = cc.a.a("android.os.ServiceManager");
        Object objJ = cc.a.j(cc.a.g(clsA, "getService", String.class), clsA, "phoneEx");
        Class<?> cls = this.f15526a;
        if (cls == null || (methodG = cc.a.g(cls, "asInterface", IBinder.class)) == null || objJ == null) {
            return null;
        }
        return cc.a.j(methodG, null, objJ);
    }
}
