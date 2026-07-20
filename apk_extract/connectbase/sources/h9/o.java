package h9;

import android.app.NotificationChannel;
import ic.k1;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7058c = "o";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7059d = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k1 f7060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.q f7061b;

    public int a(NotificationChannel notificationChannel) {
        if (notificationChannel != null) {
            return b(fc.b.a.C).a(notificationChannel);
        }
        throw new IllegalArgumentException("param cannot be null");
    }

    public bf.m b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7058c, "TranThubNotificationChannel");
            k1 k1Var = this.f7060a;
            if (k1Var != null) {
                return k1Var;
            }
            k1 k1Var2 = new k1();
            this.f7060a = k1Var2;
            return k1Var2;
        }
        dc.e.f(f7058c, "TranAospNotificationChannel");
        p6.q qVar = this.f7061b;
        if (qVar != null) {
            return qVar;
        }
        p6.q qVar2 = new p6.q();
        this.f7061b = qVar2;
        return qVar2;
    }

    public void c(NotificationChannel notificationChannel, int i10) {
        if (notificationChannel == null) {
            throw new IllegalArgumentException("channel cannot be null");
        }
        b(fc.b.a.f5987g).b(notificationChannel, i10);
    }
}
