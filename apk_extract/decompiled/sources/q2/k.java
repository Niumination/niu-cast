package q2;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class k extends d {
    public k(@NonNull Status status) {
        super(status);
    }

    @NonNull
    public PendingIntent getResolution() {
        return getStatus().f1821d;
    }

    public void startResolutionForResult(@NonNull Activity activity, int i8) throws IntentSender.SendIntentException {
        PendingIntent pendingIntent = getStatus().f1821d;
        if (pendingIntent != null) {
            u2.l.e(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i8, null, 0, 0, 0);
        }
    }
}
