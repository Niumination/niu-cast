package d2;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import tj.w;

/* JADX INFO: loaded from: classes.dex */
public final class a implements f2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4260d;
    public Object e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f4261h;

    public void a(String str, String str2) {
        HashMap map = (HashMap) this.f4261h;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public b b() {
        String strB = ((String) this.f4257a) == null ? " transportName" : "";
        if (((f) this.f4259c) == null) {
            strB = strB.concat(" encodedPayload");
        }
        if (((Long) this.f4260d) == null) {
            strB = h0.a.B(strB, " eventMillis");
        }
        if (((Long) this.e) == null) {
            strB = h0.a.B(strB, " uptimeMillis");
        }
        if (((HashMap) this.f4261h) == null) {
            strB = h0.a.B(strB, " autoMetadata");
        }
        if (strB.isEmpty()) {
            return new b((String) this.f4257a, (Integer) this.f4258b, (f) this.f4259c, ((Long) this.f4260d).longValue(), ((Long) this.e).longValue(), (HashMap) this.f4261h);
        }
        throw new IllegalStateException("Missing required properties:".concat(strB));
    }

    public void c() {
        EGLSurface eGLSurface;
        EGL10 egl10;
        EGLDisplay eGLDisplay = (EGLDisplay) this.f4258b;
        if (eGLDisplay == null || (eGLSurface = (EGLSurface) this.f4259c) == null || (egl10 = (EGL10) this.f4257a) == null) {
            return;
        }
        egl10.eglSwapBuffers(eGLDisplay, eGLSurface);
    }

    @Override // yh.a
    public Object get() {
        return new i2.i((Context) ((w) this.f4257a).f10262b, (e2.f) ((yh.a) this.f4258b).get(), (j2.c) ((yh.a) this.f4259c).get(), (i2.d) ((u6.a) this.f4260d).get(), (Executor) ((yh.a) this.e).get(), (k2.c) ((yh.a) this.f4261h).get(), new n5.a());
    }
}
