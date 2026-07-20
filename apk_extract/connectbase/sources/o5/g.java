package o5;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class g implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12092c = "AppNotificationManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<j> f12093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, o5.a> f12094b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f12095a = new g();
    }

    public static g j() {
        return a.f12095a;
    }

    public static /* synthetic */ boolean o(String str, o5.a aVar) {
        return !aVar.k().equals(str);
    }

    public static /* synthetic */ boolean p(o5.a aVar, o5.a aVar2) {
        return aVar2.k().equals(aVar.k());
    }

    public static /* synthetic */ boolean q(String str, Map.Entry entry) {
        return ((o5.a) entry.getValue()).k().equals(str);
    }

    public static /* synthetic */ boolean r(String str, Map.Entry entry) {
        return ((o5.a) entry.getValue()).k().equals(str);
    }

    @Override // o5.j
    public void a(o5.a aVar) {
        if (this.f12093a.isEmpty()) {
            return;
        }
        Iterator<j> it = this.f12093a.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    @Override // o5.j
    public void b(o5.a aVar) {
        if (this.f12093a.isEmpty() || m(aVar)) {
            k4.m.c(f12092c, "listener is empty or same notification");
            return;
        }
        g(aVar);
        Iterator<j> it = this.f12093a.iterator();
        while (it.hasNext()) {
            it.next().b(aVar);
        }
    }

    public final void g(o5.a aVar) {
        this.f12094b.put(Integer.valueOf(aVar.g()), aVar);
    }

    @b.a({"SoonBlockedPrivateApi"})
    public void h(Context context, String str, String str2) {
        m4.a.C0275a.f10375a.p(str, str2);
    }

    public List<o5.a> i() {
        return new ArrayList(this.f12094b.values());
    }

    @Nullable
    public o5.a k(int i10) {
        return this.f12094b.get(Integer.valueOf(i10));
    }

    public List<o5.a> l(final String str) {
        return (List) this.f12094b.values().stream().filter(new Predicate() { // from class: o5.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return g.o(str, (a) obj);
            }
        }).collect(Collectors.toList());
    }

    public final boolean m(final o5.a aVar) {
        if (this.f12094b.size() == 0) {
            return false;
        }
        List list = (List) this.f12094b.values().stream().filter(new Predicate() { // from class: o5.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return g.p(aVar, (a) obj);
            }
        }).sorted(Comparator.comparing(new c()).reversed()).collect(Collectors.toList());
        return list.size() != 0 && ((o5.a) list.get(0)).f().equals(aVar.f()) && aVar.m().longValue() - ((o5.a) list.get(0)).m().longValue() < 50;
    }

    public boolean n(Context context) {
        return NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.getPackageName());
    }

    public String s(int i10, Display display, Context context) {
        o5.a aVar = this.f12094b.get(Integer.valueOf(i10));
        if (aVar == null) {
            return null;
        }
        Context contextCreateDisplayContext = context.createDisplayContext(display);
        final String strK = aVar.k();
        this.f12094b.entrySet().removeIf(new Predicate() { // from class: o5.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return g.r(strK, (Map.Entry) obj);
            }
        });
        try {
            PendingIntent pendingIntentL = aVar.l();
            if (pendingIntentL == null) {
                return null;
            }
            pendingIntentL.send(contextCreateDisplayContext, 0, (Intent) null);
        } catch (PendingIntent.CanceledException e10) {
            k4.m.c(f12092c, "By notification pending intent to open page is failed");
            k4.m.d(f12092c, e10);
        }
        return aVar.k();
    }

    public void t(int i10) {
        o5.a aVar = this.f12094b.get(Integer.valueOf(i10));
        if (aVar == null) {
            return;
        }
        final String strK = aVar.k();
        this.f12094b.entrySet().removeIf(new Predicate() { // from class: o5.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return g.q(strK, (Map.Entry) obj);
            }
        });
        try {
            PendingIntent pendingIntentL = aVar.l();
            if (pendingIntentL == null) {
                return;
            }
            pendingIntentL.send();
        } catch (PendingIntent.CanceledException e10) {
            k4.m.c(f12092c, "By notification pending intent to open page is failed");
            k4.m.d(f12092c, e10);
        }
    }

    public void u(j jVar) {
        this.f12093a.add(jVar);
    }

    public void v() {
        this.f12094b.clear();
    }

    public void w(Activity activity, int i10) {
        if (n(activity)) {
            return;
        }
        activity.startActivityForResult(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"), i10);
    }

    public g() {
        this.f12093a = new ConcurrentLinkedQueue<>();
        this.f12094b = new ConcurrentHashMap();
    }
}
