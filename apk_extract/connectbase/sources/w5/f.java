package w5;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.transsion.connectx.mirror.source.SourceApplication;
import java.util.concurrent.ConcurrentHashMap;
import k4.m;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f18164e = "InjectEventHelper";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f18165f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f18166g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f18167h = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f18168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f18169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, b> f18170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m4.c f18171d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f18172a = new f();
    }

    public static f c() {
        return a.f18172a;
    }

    public void d() {
        this.f18169b = new Handler(this.f18168a.getLooper());
    }

    public void e(final x5.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f18169b.post(new Runnable() { // from class: w5.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f18162a.h(aVar);
            }
        });
    }

    public void f(final InputEvent inputEvent) {
        if (inputEvent == null) {
            return;
        }
        m.b(f18164e, "injectInputEvent, event: " + inputEvent);
        this.f18169b.post(new Runnable() { // from class: w5.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f18160a.i(inputEvent);
            }
        });
        if (inputEvent instanceof MotionEvent) {
            MotionEvent motionEvent = (MotionEvent) inputEvent;
            if (motionEvent.getAction() == 2) {
                o1.a.f18113a.G("ACTION_MOVE");
            } else {
                o1.a.f18113a.F(MotionEvent.actionToString(motionEvent.getAction()));
            }
        }
    }

    public void g(String str, KeyEvent keyEvent) {
        this.f18171d.B(str, keyEvent);
    }

    public final /* synthetic */ void h(x5.a aVar) {
        b bVar = this.f18170c.get(Integer.valueOf(aVar.b()));
        if (bVar == null) {
            bVar = new b(SourceApplication.b(), aVar.b());
            this.f18170c.put(Integer.valueOf(aVar.b()), bVar);
        }
        bVar.a(aVar);
    }

    public final /* synthetic */ void i(InputEvent inputEvent) {
        this.f18171d.c(inputEvent, 0);
    }

    public void j() {
        this.f18170c.clear();
        Handler handler = this.f18169b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f18169b = null;
        }
    }

    public void k(int i10) {
        this.f18170c.remove(Integer.valueOf(i10));
    }

    public f() {
        HandlerThread handlerThread = new HandlerThread("inject event");
        this.f18168a = handlerThread;
        this.f18170c = new ConcurrentHashMap<>();
        this.f18171d = m4.a.C0275a.f10375a;
        handlerThread.start();
    }
}
