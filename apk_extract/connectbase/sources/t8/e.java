package t8;

import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e implements dh.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15528b = "e";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f15529c = cc.a.a("android.telephony.SubscriptionManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15530a = bc.a.a();

    @Override // dh.e
    public int a(int i10) {
        try {
            return ((Integer) cc.a.j(cc.a.g(f15529c, "getSlotIndex", Integer.TYPE), null, Integer.valueOf(i10))).intValue();
        } catch (Exception e10) {
            p6.b.a("getSlotIndex fail: ", e10, f15528b);
            return 0;
        }
    }

    @Override // dh.e
    public void b(int i10) {
        SubscriptionManager subscriptionManagerFrom = SubscriptionManager.from(this.f15530a);
        cc.a.j(cc.a.g(subscriptionManagerFrom.getClass(), "setDefaultDataSubId", Integer.TYPE), subscriptionManagerFrom, Integer.valueOf(i10));
    }

    @Override // dh.e
    public int[] c() {
        try {
            Object objInvoke = cc.a.g(f15529c, "getActiveSubscriptionIdList", new Class[0]).invoke(SubscriptionManager.from(this.f15530a), null);
            if (objInvoke == null || !(objInvoke instanceof int[])) {
                return null;
            }
            return (int[]) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getActiveSubscriptionIdList fail ", th2, f15528b);
            return new int[0];
        }
    }

    @Override // dh.e
    public void d(int i10) {
        SubscriptionManager subscriptionManagerFrom = SubscriptionManager.from(this.f15530a);
        cc.a.j(cc.a.g(subscriptionManagerFrom.getClass(), "setDefaultSmsSubId", Integer.TYPE), subscriptionManagerFrom, Integer.valueOf(i10));
    }

    @Override // dh.e
    public SubscriptionInfo e() {
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.f15530a.getSystemService("telephony_subscription_service");
        Object objJ = cc.a.j(cc.a.g(subscriptionManager.getClass(), "getDefaultDataSubscriptionInfo", new Class[0]), subscriptionManager, new Object[0]);
        if (objJ instanceof SubscriptionInfo) {
            return (SubscriptionInfo) objJ;
        }
        return null;
    }

    @Override // dh.e
    public int[] f(int i10) {
        try {
            return (int[]) cc.a.j(cc.a.g(f15529c, "getSubId", Integer.TYPE), null, Integer.valueOf(i10));
        } catch (Exception e10) {
            p6.b.a("getSubId fail: ", e10, f15528b);
            return new int[0];
        }
    }

    @Override // dh.e
    public boolean g(int i10) {
        Object objJ = cc.a.j(cc.a.g(SubscriptionManager.from(this.f15530a).getClass(), "isValidPhoneId", Integer.TYPE), null, Integer.valueOf(i10));
        if (objJ == null || !(objJ instanceof Boolean)) {
            return false;
        }
        return ((Boolean) objJ).booleanValue();
    }

    @Override // dh.e
    public List<SubscriptionInfo> h() {
        try {
            SubscriptionManager subscriptionManager = (SubscriptionManager) this.f15530a.getSystemService("telephony_subscription_service");
            Method methodG = cc.a.g(subscriptionManager.getClass(), "getActiveSubscriptionInfoList", new Class[0]);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, subscriptionManager, new Object[0]);
            if (objJ == null || !(objJ instanceof List)) {
                return null;
            }
            return (List) objJ;
        } catch (Throwable th2) {
            m7.a.a("getActiveSubscriptionInfoList fail ", th2, f15528b);
            return null;
        }
    }

    @Override // dh.e
    public int i() {
        try {
            SubscriptionManager subscriptionManager = (SubscriptionManager) this.f15530a.getSystemService("telephony_subscription_service");
            Method methodG = cc.a.g(subscriptionManager.getClass(), "getActiveSubscriptionInfoCount", new Class[0]);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, subscriptionManager, new Object[0]);
            if (objJ != null && (objJ instanceof Integer)) {
                return ((Integer) objJ).intValue();
            }
        } catch (Throwable th2) {
            m7.a.a("getActiveSubscriptionInfoCount fail ", th2, f15528b);
        }
        return 0;
    }

    @Override // dh.e
    public void j(int i10, int i11) {
        SubscriptionManager subscriptionManagerFrom = SubscriptionManager.from(this.f15530a);
        Class<?> cls = subscriptionManagerFrom.getClass();
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "setDefaultDataSubIdWithReason", cls2, cls2), subscriptionManagerFrom, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // dh.e
    public int k(int i10) {
        Object objJ = cc.a.j(cc.a.g(SubscriptionManager.from(this.f15530a).getClass(), "getPhoneId", Integer.TYPE), null, Integer.valueOf(i10));
        if (objJ == null || !(objJ instanceof Integer)) {
            return -1;
        }
        return ((Integer) objJ).intValue();
    }
}
