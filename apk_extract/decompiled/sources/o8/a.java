package o8;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ea.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f8412c = o9.a("android.app.StatusBarManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f8413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8414b;

    @Override // ea.a
    public final void a() {
        try {
            if (this.f8414b == null) {
                this.f8414b = o9.b(new Class[]{Context.class}).newInstance(this.f8413a);
            }
            Method methodD = o9.d(this.f8414b.getClass(), "setIconVisibility", String.class, Boolean.TYPE);
            methodD.setAccessible(true);
            methodD.invoke(this.f8414b, "STATUSBARICONSLOT", Boolean.FALSE);
        } catch (Throwable th2) {
            boolean z2 = j9.a.f6132a;
            Log.e("a", "setIconVisibility fail " + th2);
        }
    }

    @Override // ea.a
    public final void setIcon(int i8) {
        try {
            if (this.f8414b == null) {
                this.f8414b = o9.b(new Class[]{Context.class}).newInstance(this.f8413a);
            }
            Class<?> cls = this.f8414b.getClass();
            Class cls2 = Integer.TYPE;
            Method methodD = o9.d(cls, "setIcon", String.class, cls2, cls2, String.class);
            methodD.setAccessible(true);
            methodD.invoke(this.f8414b, "STATUSBARICONSLOT", Integer.valueOf(i8), 0, "STATUSBARICONSLOT");
        } catch (Throwable th2) {
            boolean z2 = j9.a.f6132a;
            Log.e("a", "setIcon fail " + th2);
        }
    }
}
