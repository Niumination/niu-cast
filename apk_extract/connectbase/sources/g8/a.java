package g8;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements rg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6436c = "TranAospFontManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6437d = -2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6438a = bc.a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f6439b;

    @Override // rg.a
    public void a() {
        e().e();
    }

    @Override // rg.a
    public boolean b() {
        return e().b();
    }

    @Override // rg.a
    public int c(ParcelFileDescriptor parcelFileDescriptor, String str) {
        return e().d(parcelFileDescriptor, str);
    }

    @Override // rg.a
    public int d(String str, String str2) {
        return e().c(str, str2);
    }

    public final b e() {
        if (this.f6439b == null) {
            this.f6439b = new b(this.f6438a, f(-2));
        }
        return this.f6439b;
    }

    public final UserHandle f(int i10) {
        try {
            Method methodG = cc.a.g(cc.a.a("android.os.UserHandle"), "of", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof UserHandle)) {
                return null;
            }
            return (UserHandle) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("of fail:", th2, f6436c);
            return null;
        }
    }
}
