package l2;

import androidx.core.app.NotificationCompat;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f9640a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f9641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public static d f9642c;

    public final void a(@os.l String str, @os.l String str2) {
        d dVar;
        l0.p(str, "tag");
        l0.p(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (!f9641b || (dVar = f9642c) == null) {
            return;
        }
        dVar.b(str, str2);
    }

    public final void b(@os.l String str, @os.l String str2) {
        l0.p(str, "tag");
        l0.p(str2, NotificationCompat.CATEGORY_MESSAGE);
        d dVar = f9642c;
        if (dVar == null) {
            return;
        }
        dVar.a(str, str2);
    }

    public final void c(@os.l String str, @os.l String str2, @os.l Throwable th2) {
        l0.p(str, "tag");
        l0.p(str2, NotificationCompat.CATEGORY_MESSAGE);
        l0.p(th2, "tr");
        d dVar = f9642c;
        if (dVar == null) {
            return;
        }
        dVar.c(str, str2, th2);
    }

    @os.m
    public final d d() {
        return f9642c;
    }

    public final void e(@os.l String str, @os.l String str2) {
        l0.p(str, "tag");
        l0.p(str2, NotificationCompat.CATEGORY_MESSAGE);
        d dVar = f9642c;
        if (dVar == null) {
            return;
        }
        dVar.d(str, str2);
    }

    public final boolean f() {
        return f9641b;
    }

    public final void g(boolean z10) {
        f9641b = z10;
    }

    public final void h(@os.m d dVar) {
        f9642c = dVar;
    }
}
