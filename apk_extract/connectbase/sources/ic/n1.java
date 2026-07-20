package ic;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import com.transsion.hubsdk.app.TranPendingIntentBridge;

/* JADX INFO: loaded from: classes2.dex */
public class n1 implements bf.o {
    @Override // bf.o
    public Intent a(PendingIntent pendingIntent) {
        return new TranPendingIntentBridge().getIntent(pendingIntent);
    }

    @Override // bf.o
    public PendingIntent b(Context context, int i10, Intent intent, int i11, Bundle bundle, UserHandle userHandle) {
        return new TranPendingIntentBridge().getActivityAsUser(context, i10, intent, i11, bundle, userHandle);
    }

    @Override // bf.o
    public PendingIntent c(Context context, int i10, Intent intent, int i11, UserHandle userHandle) {
        return new TranPendingIntentBridge().getBroadcastAsUser(context, i10, intent, i11, userHandle);
    }
}
