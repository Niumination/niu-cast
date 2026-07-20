package ed;

import android.content.Intent;
import com.transsion.hubsdk.internal.app.TranUnlaunchableAppActivity;

/* JADX INFO: loaded from: classes2.dex */
public class i implements xf.e {
    @Override // xf.e
    public Intent a(int i10) {
        return TranUnlaunchableAppActivity.createInQuietModeDialogIntent(i10);
    }
}
