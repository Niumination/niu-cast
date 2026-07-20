package h7;

import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements sf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6977b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f6978c = cc.a.a("android.hardware.face.FaceManager");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6979d = "face";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6980a = bc.a.a().getSystemService("face");

    @b.a({"WrongConstant"})
    public a() {
    }

    @Override // sf.a
    public void a(int i10, int i11, int i12) {
        e.f(f6977b, "AOSP FaceManager has no setConfig method.");
    }

    @Override // sf.a
    public boolean b() {
        Object objJ = cc.a.j(cc.a.g(f6978c, "isHardwareDetected", new Class[0]), this.f6980a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }
}
