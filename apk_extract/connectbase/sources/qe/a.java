package qe;

import android.content.Context;
import com.transsion.hubsdk.util.TranFeatureFlagUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a implements kh.a {
    @Override // kh.a
    public boolean a(Context context, String str) {
        return TranFeatureFlagUtils.isEnabled(context, str);
    }
}
