package k6;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.transsion.athena.data.TrackData;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class k implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9136b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f9138d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9142h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f9145k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f9135a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9137c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9139e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9140f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9141g = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9143i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedList<a> f9144j = new LinkedList<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9148c;

        public a(int i10, String str, long j10) {
            this.f9146a = i10;
            this.f9147b = str;
            this.f9148c = j10;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k kVar = k.this;
                kVar.f9143i = 0;
                kVar.f9144j.clear();
                k kVar2 = k.this;
                kVar2.f9137c = true;
                kVar2.f9139e = 0L;
                s3.g.v("");
            } catch (Exception unused) {
            }
        }
    }

    public void d(long j10) {
        this.f9145k = j10;
    }

    public final boolean e(Activity activity) {
        Window window;
        if (activity == null || g.p(activity.getClass()) || (window = activity.getWindow()) == null) {
            return false;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        return (attributes.width == 1 && attributes.height == 1) ? false : true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        y3.e.l(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        y3.e.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        String strValueOf;
        if (e(activity)) {
            try {
                String simpleName = activity.getClass().getSimpleName();
                int i10 = 1;
                if (s3.g.P()) {
                    int i11 = this.f9143i + 1;
                    this.f9143i = i11;
                    this.f9144j.addLast(new a(i11, simpleName, SystemClock.elapsedRealtime()));
                }
                int i12 = this.f9136b + 1;
                this.f9136b = i12;
                if (i12 <= 1) {
                    this.f9142h = SystemClock.elapsedRealtime();
                    if (this.f9137c) {
                        try {
                            strValueOf = UUID.randomUUID().toString();
                        } catch (Exception unused) {
                            strValueOf = String.valueOf(System.currentTimeMillis());
                        }
                        s3.g.f14987t = strValueOf;
                        this.f9139e = System.currentTimeMillis();
                        try {
                            Uri referrer = activity.getReferrer();
                            if (referrer != null) {
                                this.f9141g = referrer.getAuthority();
                            }
                            Intent intent = activity.getIntent();
                            String str = this.f9141g;
                            int i13 = y3.d.f20693e;
                            if (intent != null) {
                                Set<String> categories = intent.getCategories();
                                if (!"android.intent.action.MAIN".equals(intent.getAction()) || categories == null || !categories.contains("android.intent.category.LAUNCHER")) {
                                    i10 = TextUtils.isEmpty(str) ? 0 : 2;
                                }
                            }
                            this.f9140f = i10;
                            if (TextUtils.equals(this.f9141g, activity.getPackageName())) {
                                this.f9140f = 3;
                            }
                        } catch (Exception e10) {
                            y3.b.d(Log.getStackTraceString(e10));
                        }
                        for (Integer num : t3.d.a()) {
                            if (num.intValue() != 9999) {
                                g.i0(num.intValue()).c1("page_enter", new TrackData().m("purl", simpleName), num.intValue());
                            }
                        }
                    }
                }
                this.f9137c = false;
                Runnable runnable = this.f9138d;
                if (runnable != null) {
                    this.f9135a.removeCallbacks(runnable);
                    this.f9138d = null;
                }
            } catch (Exception e11) {
                y3.b.d(Log.getStackTraceString(e11));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Bundle bundleExtra;
        if (e(activity)) {
            try {
                if (s3.g.P() && this.f9144j.size() > 0) {
                    String simpleName = activity.getClass().getSimpleName();
                    for (a aVar : this.f9144j) {
                        if (simpleName.equals(aVar.f9147b)) {
                            long jElapsedRealtime = SystemClock.elapsedRealtime() - aVar.f9148c;
                            TrackData trackDataE = new TrackData().m("s_id", s3.g.f14987t).m(RtspHeaders.Values.URL, aVar.f9147b).e("no", aVar.f9146a);
                            if (jElapsedRealtime <= 0) {
                                jElapsedRealtime = 0;
                            }
                            TrackData trackDataM = trackDataE.g("t", jElapsedRealtime).m("ext", "");
                            if (activity.getIntent() != null && (bundleExtra = activity.getIntent().getBundleExtra("athena")) != null) {
                                trackDataM.i("ext", bundleExtra);
                            }
                            g.j0(this.f9145k).d1("page_view", trackDataM, this.f9145k);
                            this.f9144j.remove(aVar);
                            break;
                        }
                    }
                }
                int i10 = this.f9136b - 1;
                this.f9136b = i10;
                if (i10 == 0) {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.f9142h;
                    if (jElapsedRealtime2 > 1000 && jElapsedRealtime2 < 86400000) {
                        for (Integer num : t3.d.a()) {
                            if (num.intValue() != 9999) {
                                g.i0(num.intValue()).c1("app_active", new TrackData().m("s_id", s3.g.f14987t).e(zb.e.f21901l, this.f9140f).m("pkg", this.f9140f == 2 ? this.f9141g : "").g("s_s", this.f9139e).g("t", jElapsedRealtime2), num.intValue());
                            }
                        }
                    }
                    Runnable runnable = this.f9138d;
                    if (runnable != null) {
                        this.f9135a.removeCallbacks(runnable);
                    }
                    Handler handler = this.f9135a;
                    b bVar = new b();
                    this.f9138d = bVar;
                    handler.postDelayed(bVar, s3.g.f14985r);
                    g.G0();
                }
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        }
    }
}
