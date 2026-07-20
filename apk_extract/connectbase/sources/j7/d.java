package j7;

import android.os.Handler;
import android.os.Looper;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import com.transsion.hubsdk.util.TranLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8602e = "TranInputMonitorImplExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f8603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f8604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f8605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f8606d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (d.this.f8603a != null) {
                    Object objInvoke = null;
                    try {
                        Method declaredMethod = d.this.f8603a.getClass().getDeclaredMethod("getInputChannel", null);
                        declaredMethod.setAccessible(true);
                        objInvoke = declaredMethod.invoke(d.this.f8603a, null);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                        TranLog.d(d.f8602e, "getInputChannel fail :" + e10);
                    }
                    d.this.f8605c = d.this.new c((InputChannel) objInvoke, Looper.getMainLooper());
                }
            }
        }
    }

    public interface b {
        void m(InputEvent inputEvent);
    }

    public class c extends InputEventReceiver {
        public c(InputChannel inputChannel, Looper looper) {
            super(inputChannel, looper);
        }

        public void a(InputEvent inputEvent) {
            if (d.this.f8604b != null) {
                d.this.f8604b.m(inputEvent);
            }
            finishInputEvent(inputEvent, true);
        }
    }

    public d(Object obj, b bVar) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f8606d = handler;
        this.f8604b = bVar;
        this.f8603a = obj;
        handler.post(new a());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036 A[Catch: all -> 0x001c, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0008, B:13:0x0030, B:14:0x0032, B:16:0x0036, B:17:0x003b, B:12:0x001f), top: B:23:0x0003, inners: #0 }] */
    public void d() {
        c cVar;
        synchronized (this) {
            Object obj = this.f8603a;
            if (obj != null) {
                try {
                    Method declaredMethod = obj.getClass().getDeclaredMethod("dispose", null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f8603a, null);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                    TranLog.d(f8602e, "dispose fail :" + e10);
                }
                this.f8603a = null;
                cVar = this.f8605c;
                if (cVar != null) {
                    cVar.dispose();
                    this.f8605c = null;
                }
            } else {
                cVar = this.f8605c;
                if (cVar != null) {
                    cVar.dispose();
                    this.f8605c = null;
                }
            }
            throw th;
        }
    }

    public void e() {
        Object obj = this.f8603a;
        if (obj != null) {
            try {
                Method declaredMethod = obj.getClass().getDeclaredMethod("pilferPointers", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.f8603a, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                TranLog.d(f8602e, "pilferPointers fail :" + e10);
            }
        }
    }
}
