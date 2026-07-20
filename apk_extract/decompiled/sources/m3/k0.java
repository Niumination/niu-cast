package m3;

import android.util.Log;
import com.transsion.pcconnect.service.FileService;
import k3.gc;

/* JADX INFO: loaded from: classes.dex */
public abstract class k0 {
    public static void a(boolean z2) {
        String strO = o.d.o("setEnable: ", z2, "FileService", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("FileService"), strO);
        }
        FileService.f2953b = !z2 ? 1 : 0;
    }
}
