package s8;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import com.android.internal.annotations.VisibleForTesting;
import dc.e;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ch.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15025c = "b";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f15026d = cc.a.a("android.telecom.TelecomManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15027a = bc.a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TelecomManager f15028b;

    @Override // ch.b
    public boolean a() {
        try {
            if (this.f15028b == null) {
                this.f15028b = (TelecomManager) this.f15027a.getSystemService("telecom");
            }
            Method methodG = cc.a.g(f15026d, "endCall", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15028b, null);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("endCall fail ", th2, f15025c);
            return false;
        }
    }

    @Override // ch.b
    public boolean b(String str) {
        try {
            if (this.f15028b == null) {
                this.f15028b = (TelecomManager) this.f15027a.getSystemService("telecom");
            }
            Method methodG = cc.a.g(f15026d, "setDefaultDialer", String.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15028b, str);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("setDefaultDialer fail ", th2, f15025c);
            return false;
        }
    }

    @Override // ch.b
    public List<PhoneAccountHandle> c() {
        try {
            if (this.f15028b == null) {
                this.f15028b = (TelecomManager) this.f15027a.getSystemService("telecom");
            }
            Method methodG = cc.a.g(f15026d, "getCallCapablePhoneAccounts", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15028b, null);
            if (objInvoke != null && (objInvoke instanceof List)) {
                return (List) objInvoke;
            }
        } catch (Throwable th2) {
            m7.a.a("getCallCapablePhoneAccounts fail ", th2, f15025c);
        }
        return null;
    }

    @Override // ch.b
    public void d(PhoneAccountHandle phoneAccountHandle) {
        try {
            if (this.f15028b == null) {
                this.f15028b = (TelecomManager) this.f15027a.getSystemService("telecom");
            }
            Method methodG = cc.a.g(f15026d, "setUserSelectedOutgoingPhoneAccount", PhoneAccountHandle.class);
            methodG.setAccessible(true);
            methodG.invoke(this.f15028b, null);
        } catch (Throwable th2) {
            m7.a.a("setUserSelectedOutgoingPhoneAccount fail ", th2, f15025c);
        }
    }

    @Override // ch.b
    public boolean e() {
        try {
            if (this.f15028b == null) {
                this.f15028b = (TelecomManager) this.f15027a.getSystemService("telecom");
            }
            Method methodG = cc.a.g(f15026d, "isRinging", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15028b, null);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("disable fail ", th2, f15025c);
            return false;
        }
    }

    @Override // ch.b
    public String f(int i10) {
        try {
            Class clsA = cc.a.a("transsion.telecom.TranTelecomHelper");
            return (String) cc.a.j(cc.a.g(clsA, "getPhoneNumberByIms", Integer.TYPE, Context.class), clsA.newInstance(), Integer.valueOf(i10), this.f15027a);
        } catch (Exception e10) {
            e.n(f15025c, "getPhoneNumberByIms = " + e10.getMessage());
            return null;
        }
    }

    @VisibleForTesting
    public void g(TelecomManager telecomManager) {
        this.f15028b = telecomManager;
    }
}
