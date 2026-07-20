package i2;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.transsion.widgetslib.widget.FootOperationBar;
import df.m;
import k3.z8;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5541a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5544d;
    public final Object e;

    public g(i iVar, d2.d dVar, int i8, Runnable runnable) {
        this.f5543c = iVar;
        this.f5544d = dVar;
        this.f5542b = i8;
        this.e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f5544d;
        Object obj2 = this.f5543c;
        Object obj3 = this.e;
        switch (this.f5541a) {
            case 0:
                i iVar = (i) obj2;
                d2.d dVar = (d2.d) obj;
                int i8 = this.f5542b;
                Runnable runnable = (Runnable) obj3;
                try {
                    try {
                        k2.c cVar = iVar.f;
                        j2.c cVar2 = iVar.f5551c;
                        cVar2.getClass();
                        ((j2.h) cVar).h(new o5.c(cVar2));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) iVar.f5549a.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            ((j2.h) iVar.f).h(new m(iVar, dVar, i8));
                        } else {
                            iVar.a(dVar, i8);
                        }
                        break;
                    } catch (k2.a unused) {
                        iVar.f5552d.a(dVar, i8 + 1, false);
                    }
                    return;
                } finally {
                    runnable.run();
                }
            default:
                FootOperationBar footOperationBar = (FootOperationBar) obj3;
                int measuredHeight = footOperationBar.getMeasuredHeight();
                int i9 = FootOperationBar.H;
                z8.f("FootOperationBar", "setContainerBgColor, gesture navigation off, fob height: " + measuredHeight);
                ((Paint) obj2).setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) measuredHeight, this.f5542b, footOperationBar.f3386x, Shader.TileMode.CLAMP));
                footOperationBar.f3369a.setBackground((ShapeDrawable) obj);
                return;
        }
    }

    public g(FootOperationBar footOperationBar, Paint paint, int i8, ShapeDrawable shapeDrawable) {
        this.e = footOperationBar;
        this.f5543c = paint;
        this.f5542b = i8;
        this.f5544d = shapeDrawable;
    }
}
