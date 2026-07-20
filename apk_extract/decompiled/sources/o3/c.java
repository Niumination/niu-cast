package o3;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8368a = new b(0);

    static {
        new Scope(1, "profile");
        new Scope(1, NotificationCompat.CATEGORY_EMAIL);
    }
}
