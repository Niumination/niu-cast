package w7;

import android.content.Context;
import android.location.LocationManager;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes2.dex */
public class a implements hg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f18188c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LocationManager f18190b;

    public a() {
        Context contextA = bc.a.a();
        this.f18189a = contextA;
        this.f18190b = (LocationManager) contextA.getSystemService("location");
    }

    @Override // hg.a
    public void a(boolean z10, UserHandle userHandle) {
        cc.a.j(cc.a.g(this.f18190b.getClass(), "setLocationEnabledForUser", Boolean.TYPE, UserHandle.class), this.f18190b, Boolean.valueOf(z10), userHandle);
    }
}
