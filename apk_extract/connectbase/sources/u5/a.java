package u5;

import android.provider.Settings;
import com.transsion.connectx.mirror.source.SourceApplication;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16201a = "connectx.cast.status.service.enabled";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16202b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16203c = 0;

    public static void a() {
        Settings.Global.putInt(SourceApplication.b().getContentResolver(), "connectx.cast.status.service.enabled", 0);
    }

    public static void b() {
        Settings.Global.putInt(SourceApplication.b().getContentResolver(), "connectx.cast.status.service.enabled", 1);
    }
}
