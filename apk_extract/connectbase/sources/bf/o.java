package bf;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes2.dex */
public interface o {
    Intent a(PendingIntent pendingIntent);

    PendingIntent b(Context context, int i10, Intent intent, int i11, Bundle bundle, UserHandle userHandle);

    PendingIntent c(Context context, int i10, Intent intent, int i11, UserHandle userHandle);
}
