package k7;

import android.content.Context;
import android.hardware.SensorPrivacyManager;

/* JADX INFO: loaded from: classes2.dex */
public class a implements vf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9152c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorPrivacyManager f9153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f9154b;

    public a() {
        Context contextA = bc.a.a();
        this.f9154b = contextA;
        this.f9153a = (SensorPrivacyManager) contextA.getSystemService(SensorPrivacyManager.class);
    }

    @Override // vf.a
    public boolean a(int i10, int i11) {
        Class<?> cls = this.f9153a.getClass();
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "isSensorPrivacyEnabled", cls2, cls2), this.f9153a, Integer.valueOf(i10), Integer.valueOf(i11));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // vf.a
    public void b(int i10, boolean z10) {
        cc.a.j(cc.a.g(this.f9153a.getClass(), "setSensorPrivacy", Integer.TYPE, Boolean.TYPE), this.f9153a, Integer.valueOf(i10), Boolean.valueOf(z10));
    }
}
