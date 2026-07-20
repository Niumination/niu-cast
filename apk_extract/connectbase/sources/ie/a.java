package ie;

import android.content.Context;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.telecom.TranDefaultDialerManagerBridge;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ch.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7930b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7931a = bc.a.a();

    @Override // ch.a
    public boolean a(Context context, String str) {
        return TranDefaultDialerManagerBridge.setDefaultDialerApplication(context, str);
    }

    @VisibleForTesting
    public void b(Context context) {
        this.f7931a = context;
    }
}
