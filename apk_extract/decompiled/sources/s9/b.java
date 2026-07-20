package s9;

import android.os.UserHandle;
import com.transsion.hubsdk.os.TranUserHandle;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static void a() {
        UserHandle userHandle = TranUserHandle.ALL;
    }

    public static UserHandle b() {
        return TranUserHandle.CURRENT;
    }
}
