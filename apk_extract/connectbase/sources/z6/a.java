package z6;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.UserHandle;
import dc.e;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements lf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21847a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f21848b = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f21849c = cc.a.a("android.app.admin.IDevicePolicyManager$Stub");

    @Override // lf.a
    public boolean a() throws ac.a {
        throw new ac.a("There is no such interface in AOSP, please implement it yourself. ");
    }

    @Override // lf.a
    public ComponentName b() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) bc.a.a().getSystemService("device_policy");
        return (ComponentName) cc.a.j(cc.a.g(devicePolicyManager.getClass(), "getDeviceOwnerComponentOnAnyUser", new Class[0]), devicePolicyManager, new Object[0]);
    }

    @Override // lf.a
    public void c(ComponentName componentName, int i10) {
        Object objJ = cc.a.j(cc.a.g(f21849c, "asInterface", IBinder.class), f21849c, (IBinder) cc.a.j(cc.a.g(f21848b, "getService", String.class), f21848b, "device_policy"));
        if (objJ != null) {
            cc.a.j(cc.a.g(objJ.getClass(), "setDualProfileEnabled", ComponentName.class, Integer.TYPE), objJ, componentName, Integer.valueOf(i10));
        }
    }

    @Override // lf.a
    public ComponentName d(UserHandle userHandle) {
        Method methodG;
        Object objJ = cc.a.j(cc.a.g(f21849c, "asInterface", IBinder.class), f21849c, (IBinder) cc.a.j(cc.a.g(f21848b, "getService", String.class), f21848b, "device_policy"));
        if (objJ == null || (methodG = cc.a.g(objJ.getClass(), "getProfileOwnerOrDeviceOwnerSupervisionComponent", UserHandle.class)) == null) {
            return null;
        }
        return (ComponentName) cc.a.j(methodG, objJ, userHandle);
    }

    @Override // lf.a
    public ComponentName e() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) bc.a.a().getSystemService("device_policy");
        return (ComponentName) cc.a.j(cc.a.g(devicePolicyManager.getClass(), "getProfileOwner", new Class[0]), devicePolicyManager, new Object[0]);
    }

    @Override // lf.a
    public long f(ComponentName componentName, int i10) {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) bc.a.a().getSystemService("device_policy");
        Method methodG = cc.a.g(devicePolicyManager.getClass(), "getMaximumTimeToLock", ComponentName.class, Integer.TYPE);
        if (methodG == null) {
            e.c(f21847a, "getMaximumTimeToLock not supported in AOSP.");
            return 0L;
        }
        Long l10 = (Long) cc.a.j(methodG, devicePolicyManager, componentName, Integer.valueOf(i10));
        if (l10 != null) {
            return l10.longValue();
        }
        e.c(f21847a, "getMaximumTimeToLock return null.");
        return 0L;
    }

    @Override // lf.a
    public ComponentName g(int i10) {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) bc.a.a().getSystemService("device_policy");
        Method methodG = cc.a.g(devicePolicyManager.getClass(), "getProfileOwnerAsUser", Integer.TYPE);
        if (methodG != null) {
            return (ComponentName) cc.a.j(methodG, devicePolicyManager, Integer.valueOf(i10));
        }
        e.c(f21847a, "getProfileOwnerAsUser not supported in AOSP.");
        return null;
    }

    @Override // lf.a
    public boolean h(String str) {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) bc.a.a().getSystemService("device_policy");
        Method methodG = cc.a.g(devicePolicyManager.getClass(), "isDeviceOwnerAppOnAnyUser", String.class);
        if (methodG != null) {
            return Boolean.TRUE.equals(cc.a.j(methodG, devicePolicyManager, str));
        }
        e.c(f21847a, "isDeviceOwnerAppOnAnyUser not supported in AOSP.");
        return false;
    }

    @Override // lf.a
    public Intent i(Intent intent) {
        if (fc.a.d()) {
            e.c(f21847a, "createProvisioningIntentFromNfcIntent not supported in low version.");
            return null;
        }
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) bc.a.a().getSystemService("device_policy");
        return (Intent) cc.a.j(cc.a.g(devicePolicyManager.getClass(), "createProvisioningIntentFromNfcIntent", Intent.class), devicePolicyManager, intent);
    }

    @Override // lf.a
    public ComponentName j(Context context) {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        Method methodG = cc.a.g(devicePolicyManager.getClass(), "getProfileOwner", new Class[0]);
        if (methodG != null) {
            return (ComponentName) cc.a.j(methodG, devicePolicyManager, new Object[0]);
        }
        return null;
    }
}
