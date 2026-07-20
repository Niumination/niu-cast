package we;

import android.os.Message;
import androidx.fragment.app.FragmentTransaction;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f10734a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f10735b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f10736c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f10737d = new ConcurrentHashMap();

    public static void a(int i8, long j8, f notifyHandler, Runnable runnable) {
        Intrinsics.checkNotNullParameter(notifyHandler, "notifyHandler");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ConcurrentHashMap concurrentHashMap = f10736c;
        l lVar = (l) concurrentHashMap.get(Integer.valueOf(i8));
        if (lVar == null) {
            lVar = new l(Integer.valueOf(i8), notifyHandler);
            concurrentHashMap.put(Integer.valueOf(i8), lVar);
        }
        f10737d.put(Integer.valueOf(i8), runnable);
        lVar.a().removeMessages(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        lVar.a().sendMessageDelayed(lVar.a().obtainMessage(FragmentTransaction.TRANSIT_FRAGMENT_OPEN), j8);
    }

    public static void b(Integer token) {
        Intrinsics.checkNotNullParameter(token, "token");
        ConcurrentHashMap concurrentHashMap = f10734a;
        if (!concurrentHashMap.containsKey(token)) {
            h.j("TimeoutMonitor", "cancel aging timeout: token not found");
            return;
        }
        f10735b.remove(token);
        l lVar = (l) concurrentHashMap.remove(token);
        if (lVar != null) {
            lVar.a().removeMessages(4096);
        }
    }

    public static void c(int i8) {
        ConcurrentHashMap concurrentHashMap = f10736c;
        if (!concurrentHashMap.containsKey(Integer.valueOf(i8))) {
            h.j("TimeoutMonitor", "cancelTimer of connection timeout: key not found");
            return;
        }
        f10737d.remove(Integer.valueOf(i8));
        l lVar = (l) concurrentHashMap.remove(Integer.valueOf(i8));
        if (lVar != null) {
            lVar.a().removeMessages(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
    }

    public static boolean d(Integer token) {
        Intrinsics.checkNotNullParameter(token, "token");
        l lVar = (l) f10734a.get(token);
        if (lVar != null) {
            return lVar.a().hasMessages(4096);
        }
        return false;
    }

    public static boolean e(int i8) {
        l lVar = (l) f10736c.get(Integer.valueOf(i8));
        if (lVar != null) {
            return lVar.a().hasMessages(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
        return false;
    }

    public static void f(Integer token, long j8, f notifyHandler, Runnable runnable) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(notifyHandler, "notifyHandler");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ConcurrentHashMap concurrentHashMap = f10734a;
        l lVar = (l) concurrentHashMap.get(token);
        if (lVar == null) {
            lVar = new l(token, notifyHandler);
            concurrentHashMap.put(token, lVar);
        }
        f10735b.put(token, runnable);
        lVar.a().removeMessages(4096);
        lVar.a().sendMessageDelayed(lVar.a().obtainMessage(4096), j8);
    }

    public static void g(int i8) {
        l lVar = (l) f10736c.get(Integer.valueOf(i8));
        if (lVar != null) {
            lVar.a().removeMessages(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            Message messageObtainMessage = lVar.a().obtainMessage(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
            lVar.a().handleMessage(messageObtainMessage);
        }
    }

    public static void h(int i8, long j8, f notifyHandler, Runnable runnable) {
        Intrinsics.checkNotNullParameter(notifyHandler, "notifyHandler");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        c(i8);
        a(i8, j8, notifyHandler, runnable);
    }
}
