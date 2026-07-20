package e7;

import android.content.Context;
import android.hardware.camera2.CameraManager;

/* JADX INFO: loaded from: classes2.dex */
public class a implements pf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4092c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f4093d = cc.a.a("android.hardware.camera2.CameraManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CameraManager f4094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f4095b;

    public a() {
        Context contextA = bc.a.a();
        this.f4095b = contextA;
        this.f4094a = (CameraManager) contextA.getSystemService("camera");
    }

    @Override // pf.a
    public void a(String str, String str2) {
        cc.a.j(cc.a.g(f4093d, "setCustomTorchMode", String.class, String.class), this.f4094a, str, str2);
    }
}
