package p6;

import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.SurfaceControl;
import android.window.IWindowContainerTransactionCallback;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12997b = "TranAospActivityTaskManagerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12998a;

    public class a implements IWindowContainerTransactionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12999a;

        public a(c cVar) {
            this.f12999a = cVar;
        }

        public IBinder a() {
            return null;
        }

        public void b(int i10, SurfaceControl.Transaction transaction) throws RemoteException {
            c cVar = this.f12999a;
            if (cVar != null) {
                cVar.a(i10, transaction);
            }
        }
    }

    public class b implements IWindowContainerTransactionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f13001a;

        public b(c cVar) {
            this.f13001a = cVar;
        }

        public IBinder a() {
            return null;
        }

        public void b(int i10, SurfaceControl.Transaction transaction) throws RemoteException {
            c cVar = this.f13001a;
            if (cVar != null) {
                cVar.a(i10, transaction);
            }
        }
    }

    public interface c {
        void a(int i10, SurfaceControl.Transaction transaction);
    }

    public l(Context context) {
        this.f12998a = context;
    }

    public void a(int i10, Rect rect, c cVar) {
        try {
            Object objInvoke = Class.forName("android.app.ActivityTaskManager").getDeclaredMethod("getService", null).invoke(null, null);
            Class<?> cls = Class.forName("android.app.IActivityTaskManager");
            Class cls2 = Integer.TYPE;
            Rect rect2 = (Rect) cls.getMethod("hookGetMultiWindowDefaultRect", cls2).invoke(objInvoke, 0);
            Method method = cls.getMethod("hookStartMultiWindow", cls2, Rect.class, IWindowContainerTransactionCallback.class);
            if (cVar != null) {
                method.invoke(objInvoke, Integer.valueOf(i10), rect2, new a(cVar));
            } else {
                method.invoke(objInvoke, Integer.valueOf(i10), rect2, null);
            }
        } catch (Exception e10) {
            dc.e.a(f12997b, "hookStartMultiWindow Exception " + e10.getMessage());
        }
    }

    public void b(int i10, int i11, int i12, Rect rect, c cVar) {
        try {
            Object objInvoke = Class.forName("android.app.ActivityTaskManager").getDeclaredMethod("getService", null).invoke(null, null);
            Class<?> cls = Class.forName("android.app.IActivityTaskManager");
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod("hookStartMultiWindowAndMakeOwnAnimation", cls2, cls2, cls2, Rect.class, IWindowContainerTransactionCallback.class);
            if (cVar != null) {
                method.invoke(objInvoke, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), rect, new b(cVar));
            } else {
                method.invoke(objInvoke, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), rect, null);
            }
        } catch (Exception e10) {
            dc.e.a(f12997b, "hookStartMultiWindowAndMakeOwnAnimation Exception " + e10.getMessage());
        }
        dc.e.f(f12997b, "hookStartMultiWindowAndMakeOwnAnimation success");
    }
}
