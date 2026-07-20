package o5;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import com.transsion.connectx.mirror.source.R;
import java.util.Base64;
import k4.n;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12075l = "a";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Integer f12076m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f12082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f12083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f12084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f12085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PendingIntent f12086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12087k;

    public static a a(StatusBarNotification statusBarNotification, Context context) {
        PendingIntent pendingIntent;
        Notification notification = statusBarNotification.getNotification();
        a aVar = null;
        if (q(context, notification) != null || (pendingIntent = notification.contentIntent) == null || !pendingIntent.isActivity()) {
            k4.m.b(f12075l, "notification contentIntent type error");
            return null;
        }
        if (notification.contentView != null || notification.bigContentView != null) {
            k4.m.b(f12075l, "notification style is not null filter");
            return null;
        }
        Bundle bundle = notification.extras;
        String string = bundle.getString(NotificationCompat.EXTRA_TITLE);
        String string2 = bundle.getString(NotificationCompat.EXTRA_TEXT);
        if (string == null || string2 == null || notification.contentIntent == null) {
            k4.m.b(f12075l, "notification title or content is null");
            return null;
        }
        try {
            Icon smallIcon = notification.getSmallIcon();
            Icon largeIcon = notification.getLargeIcon();
            String packageName = statusBarNotification.getPackageName();
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(packageName, 0).applicationInfo;
            a aVar2 = new a();
            aVar2.f12087k = statusBarNotification.getId();
            aVar2.f12082f = k4.l.g(smallIcon, context);
            aVar2.f12083g = k4.l.g(largeIcon, context);
            aVar2.f12081e = c().intValue();
            aVar2.f12085i = notification.getChannelId();
            aVar2.f12084h = Long.valueOf(statusBarNotification.getPostTime());
            aVar2.f12080d = packageName;
            aVar2.f12077a = context.getPackageManager().getApplicationLabel(applicationInfo).toString();
            aVar2.f12086j = notification.contentIntent;
            aVar2.f12078b = string;
            aVar2.f12079c = string2;
            aVar = aVar2;
        } catch (PackageManager.NameNotFoundException e10) {
            k4.m.d(f12075l, e10);
        }
        k4.m.b(f12075l, "new notification is " + aVar);
        return aVar;
    }

    public static a b(String str, String str2, long j10, String str3, PendingIntent pendingIntent) {
        a aVar = new a();
        aVar.f12078b = str;
        if (str == null) {
            aVar.f12078b = str2;
        }
        aVar.f12079c = k4.e.f8931b.getString(R.string.receive_call);
        aVar.f12084h = Long.valueOf(j10);
        aVar.f12081e = c().intValue();
        aVar.f12080d = str3;
        aVar.f12086j = pendingIntent;
        aVar.f12087k = c().intValue();
        aVar.f12082f = k4.l.d(n.c(k4.e.f8930a).a(str3), 100);
        return aVar;
    }

    public static synchronized Integer c() {
        Integer numValueOf;
        numValueOf = Integer.valueOf(f12076m.intValue() + 1);
        f12076m = numValueOf;
        return numValueOf;
    }

    public static Integer j() {
        return f12076m;
    }

    public static Notification.Style q(Context context, Notification notification) {
        return Notification.Builder.recoverBuilder(context, notification).getStyle();
    }

    public static void x(Integer num) {
        f12076m = num;
    }

    public void A(Long l10) {
        this.f12084h = l10;
    }

    public void B(int i10) {
        this.f12087k = i10;
    }

    public void C(byte[] bArr) {
        this.f12082f = bArr;
    }

    public void D(String str) {
        this.f12078b = str;
    }

    public String d() {
        return this.f12077a;
    }

    public String e() {
        return this.f12085i;
    }

    public String f() {
        return this.f12079c;
    }

    public int g() {
        return this.f12081e;
    }

    public String h() {
        return this.f12083g == null ? "" : Base64.getEncoder().encodeToString(this.f12083g);
    }

    public byte[] i() {
        return this.f12083g;
    }

    public String k() {
        return this.f12080d;
    }

    public PendingIntent l() {
        return this.f12086j;
    }

    public Long m() {
        return this.f12084h;
    }

    public int n() {
        return this.f12087k;
    }

    public String o() {
        return this.f12082f == null ? "" : Base64.getEncoder().encodeToString(this.f12082f);
    }

    public byte[] p() {
        return this.f12082f;
    }

    public String r() {
        return this.f12078b;
    }

    public void s(String str) {
        this.f12077a = str;
    }

    public void t(String str) {
        this.f12085i = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AppNotification{appName='");
        sb2.append(this.f12077a);
        sb2.append("', title='");
        sb2.append(this.f12078b);
        sb2.append("', content='");
        sb2.append(this.f12079c);
        sb2.append("', packageName='");
        sb2.append(this.f12080d);
        sb2.append("', id=");
        sb2.append(this.f12081e);
        sb2.append(", receiveTime=");
        sb2.append(this.f12084h);
        sb2.append(", channelId='");
        sb2.append(this.f12085i);
        sb2.append("', pendingIntent=");
        sb2.append(this.f12086j);
        sb2.append(", selfId=");
        return u.a.a(sb2, this.f12087k, rs.f.f14860b);
    }

    public void u(String str) {
        this.f12079c = str;
    }

    public void v(int i10) {
        this.f12081e = i10;
    }

    public void w(byte[] bArr) {
        this.f12083g = bArr;
    }

    public void y(String str) {
        this.f12080d = str;
    }

    public void z(PendingIntent pendingIntent) {
        this.f12086j = pendingIntent;
    }
}
