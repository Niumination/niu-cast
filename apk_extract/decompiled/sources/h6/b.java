package h6;

import android.opengl.GLES20;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import d6.d;
import java.util.ArrayList;
import k3.ba;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements i6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f5264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f5265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5266c;

    public b(d player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.f5264a = player;
        this.f5265b = LazyKt.lazy(new a(this));
        this.f5266c = new Object();
    }

    @Override // i6.a
    public final void a(int i8) {
        Object obj = this.f5264a.f4323o.f10138c;
    }

    @Override // i6.a
    public final void b() {
        g();
    }

    @Override // i6.a
    public final void c(d6.a config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.f4299h) {
            Intrinsics.checkNotNullParameter("AnimPlayer.MixAnimPlugin", "tag");
            Intrinsics.checkNotNullParameter("IFetchResource is empty", NotificationCompat.CATEGORY_MESSAGE);
        }
    }

    @Override // i6.a
    public final void d(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        d6.a aVar = (d6.a) this.f5264a.f4323o.f10138c;
        if (aVar != null) {
            boolean z2 = aVar.f4299h;
        }
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(ev, "ev");
    }

    @Override // i6.a
    public final void e() {
        g();
    }

    @Override // i6.a
    public final void f() {
        d6.a aVar = (d6.a) this.f5264a.f4323o.f10138c;
        if (aVar == null || aVar.f4299h) {
            Intrinsics.checkNotNullParameter("AnimPlayer.MixAnimPlugin", "tag");
            Intrinsics.checkNotNullParameter("mix render init", NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(this, "mixAnimPlugin");
            new sj.a();
            new sj.a();
            new sj.a();
            int iB = ba.b("attribute vec4 a_Position;  \nattribute vec2 a_TextureSrcCoordinates;\nattribute vec2 a_TextureMaskCoordinates;\nvarying vec2 v_TextureSrcCoordinates;\nvarying vec2 v_TextureMaskCoordinates;\nvoid main()\n{\n    v_TextureSrcCoordinates = a_TextureSrcCoordinates;\n    v_TextureMaskCoordinates = a_TextureMaskCoordinates;\n    gl_Position = a_Position;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float; \nuniform sampler2D u_TextureSrcUnit;\nuniform samplerExternalOES u_TextureMaskUnit;\nuniform int u_isFill;\nuniform vec4 u_Color;\nvarying vec2 v_TextureSrcCoordinates;\nvarying vec2 v_TextureMaskCoordinates;\nvoid main()\n{\n    vec4 srcRgba = texture2D(u_TextureSrcUnit, v_TextureSrcCoordinates);\n    vec4 maskRgba = texture2D(u_TextureMaskUnit, v_TextureMaskCoordinates);\n    float isFill = step(0.5, float(u_isFill));\n    vec4 srcRgbaCal = isFill * vec4(u_Color.r, u_Color.g, u_Color.b, srcRgba.a) + (1.0 - isFill) * srcRgba;\n    gl_FragColor = vec4(srcRgbaCal.r, srcRgbaCal.g, srcRgbaCal.b, srcRgba.a * maskRgba.r);\n}");
            GLES20.glGetUniformLocation(iB, "u_TextureSrcUnit");
            GLES20.glGetUniformLocation(iB, "u_TextureMaskUnit");
            GLES20.glGetUniformLocation(iB, "u_isFill");
            GLES20.glGetUniformLocation(iB, "u_Color");
            GLES20.glGetAttribLocation(iB, "a_Position");
            GLES20.glGetAttribLocation(iB, "a_TextureSrcCoordinates");
            GLES20.glGetAttribLocation(iB, "a_TextureMaskCoordinates");
            GLES20.glDisable(2929);
        }
    }

    public final void g() {
        synchronized (this.f5266c) {
            this.f5266c.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
        d6.a aVar = (d6.a) this.f5264a.f4323o.f10138c;
        if (aVar == null || aVar.f4299h) {
            new ArrayList();
        }
    }
}
