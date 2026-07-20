package b8;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.dynamicanimation.animation.SpringAnimation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import jd.i;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1218a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f1219b;

    public /* synthetic */ c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1218a) {
            case 0:
                Context context = (Context) this.f1219b.get();
                if (context != null) {
                    try {
                        Object obj = vk.b.f;
                        if (obj != null) {
                            Bundle bundle = vk.b.f10618g;
                            bundle.clear();
                            bundle.putString("tran_vibrate_package", context.getPackageName());
                            Method method = vk.b.e;
                            if (method != null) {
                                Log.d("Utils", "vibrateV2: inner vibratorName = list_edge.he");
                                method.invoke(obj, "list_edge.he", bundle);
                            }
                        }
                    } catch (Exception e) {
                        Log.e("Utils", "Failed to invoke vibrate " + e.getMessage());
                        return;
                    }
                }
                break;
            default:
                WeakReference weakReference = this.f1219b;
                if (weakReference.get() != null) {
                    i iVar = (i) weakReference.get();
                    SpringAnimation springAnimation = iVar.u;
                    if (springAnimation != null && springAnimation.isRunning()) {
                        iVar.u.cancel();
                    }
                    float f = iVar.f6165b;
                    if (f == iVar.f6166c) {
                        iVar.f6166c = iVar.f6164a;
                    }
                    SpringAnimation springAnimationB = iVar.b(f, iVar.f6166c);
                    iVar.f6178t = springAnimationB;
                    springAnimationB.start();
                }
                break;
        }
    }

    public c(Context context) {
        this.f1219b = new WeakReference(context);
    }
}
