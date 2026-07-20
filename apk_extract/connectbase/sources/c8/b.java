package c8;

import android.app.NotificationManager;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ng.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f1380a = cc.a.a("android.service.notification.ZenModeConfig");

    @Override // ng.b
    public boolean a(NotificationManager.Policy policy) {
        Object objJ = cc.a.j(cc.a.g(f1380a, "areAllPriorityOnlyRingerSoundsMuted", NotificationManager.Policy.class), null, policy);
        if (objJ == null || !(objJ instanceof Boolean)) {
            return false;
        }
        return ((Boolean) objJ).booleanValue();
    }
}
