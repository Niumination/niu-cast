package vd;

import android.os.UserHandle;
import com.transsion.hubsdk.os.TranUserHandle;

/* JADX INFO: loaded from: classes2.dex */
public class m0 implements pg.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16958a = "m0";

    @Override // pg.p
    public int a() {
        return TranUserHandle.getIdentifier();
    }

    @Override // pg.p
    public int b(UserHandle userHandle) {
        return new TranUserHandle().getUserIdentifier(userHandle);
    }
}
