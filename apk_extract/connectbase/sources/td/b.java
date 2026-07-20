package td;

import android.app.NotificationManager;
import com.transsion.hubsdk.notification.TranZenModeConfig;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ng.b {
    @Override // ng.b
    public boolean a(NotificationManager.Policy policy) {
        return TranZenModeConfig.areAllPriorityOnlyRingerSoundsMuted(policy);
    }
}
