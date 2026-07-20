package a6;

import android.app.KeyguardManager;
import android.os.PowerManager;
import com.transsion.connectx.mirror.source.SourceApplication;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static boolean a() {
        return ((KeyguardManager) SourceApplication.b().getSystemService(KeyguardManager.class)).isKeyguardLocked();
    }

    public static boolean b() {
        return ((PowerManager) SourceApplication.b().getSystemService("power")).isScreenOn();
    }
}
