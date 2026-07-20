package ld;

import android.content.Context;
import com.transsion.hubsdk.internal.view.TranRotationPolicyBridge;

/* JADX INFO: loaded from: classes2.dex */
public class a implements fg.a {
    @Override // fg.a
    public boolean a(Context context) {
        return TranRotationPolicyBridge.isRotationLocked(context);
    }
}
