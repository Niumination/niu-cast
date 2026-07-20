package lj;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static void a(TileService tileService, Intent intent) {
        if (Build.VERSION.SDK_INT >= 34) {
            tileService.startActivityAndCollapse(PendingIntent.getActivity(tileService, 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
        }
    }
}
