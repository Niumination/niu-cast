package e8;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.transsion.athena.data.TrackData;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;
import m3.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4726b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public af.f f4728d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4731j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4734m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f4725a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4727c = true;
    public long e = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4729h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4730i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4732k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedList f4733l = new LinkedList();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        g0.f7680b = new WeakReference(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        WeakReference weakReference = g0.f7680b;
        if (weakReference != null) {
            weakReference.clear();
            g0.f7680b = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Window window;
        String strValueOf;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i8 = 1;
        if (attributes.width == 1 && attributes.height == 1) {
            return;
        }
        try {
            String simpleName = activity.getClass().getSimpleName();
            if (s6.d.u) {
                int i9 = this.f4732k + 1;
                this.f4732k = i9;
                LinkedList linkedList = this.f4733l;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                e eVar = new e();
                eVar.f4722a = i9;
                eVar.f4723b = simpleName;
                eVar.f4724c = jElapsedRealtime;
                linkedList.addLast(eVar);
            }
            int i10 = this.f4726b + 1;
            this.f4726b = i10;
            if (i10 <= 1) {
                this.f4731j = SystemClock.elapsedRealtime();
                if (this.f4727c) {
                    try {
                        strValueOf = UUID.randomUUID().toString();
                    } catch (Exception unused) {
                        strValueOf = String.valueOf(System.currentTimeMillis());
                    }
                    s6.d.f9552s = strValueOf;
                    this.e = System.currentTimeMillis();
                    try {
                        Uri referrer = activity.getReferrer();
                        if (referrer != null) {
                            this.f4730i = referrer.getAuthority();
                        }
                        Intent intent = activity.getIntent();
                        String str = this.f4730i;
                        String str2 = z6.b.f11259a;
                        if (intent != null) {
                            Set<String> categories = intent.getCategories();
                            if (!"android.intent.action.MAIN".equals(intent.getAction()) || categories == null || !categories.contains("android.intent.category.LAUNCHER")) {
                                i8 = TextUtils.isEmpty(str) ? 0 : 2;
                            }
                        }
                        this.f4729h = i8;
                        if (TextUtils.equals(this.f4730i, activity.getPackageName())) {
                            this.f4729h = 3;
                        }
                    } catch (Exception e) {
                        z6.a.c(Log.getStackTraceString(e));
                    }
                    for (Integer num : t6.d.f10185b) {
                        if (num.intValue() != 9999) {
                            TrackData trackData = new TrackData();
                            trackData.e(0, "purl", simpleName);
                            b.n(num.intValue()).o("page_enter", trackData, num.intValue());
                        }
                    }
                }
            }
            this.f4727c = false;
            af.f fVar = this.f4728d;
            if (fVar != null) {
                this.f4725a.removeCallbacks(fVar);
                this.f4728d = null;
            }
        } catch (Exception e4) {
            z6.a.c(Log.getStackTraceString(e4));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Window window;
        Bundle bundleExtra;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes.width == 1 && attributes.height == 1) {
            return;
        }
        try {
            if (s6.d.u && this.f4733l.size() > 0) {
                String simpleName = activity.getClass().getSimpleName();
                for (e eVar : this.f4733l) {
                    if (simpleName.equals(eVar.f4723b)) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - eVar.f4724c;
                        TrackData trackData = new TrackData();
                        trackData.g("s_id", s6.d.f9552s);
                        trackData.g("url", eVar.f4723b);
                        trackData.b(eVar.f4722a, 0, "no");
                        if (jElapsedRealtime <= 0) {
                            jElapsedRealtime = 0;
                        }
                        trackData.f("t", jElapsedRealtime);
                        trackData.e(0, "ext", "");
                        if (activity.getIntent() != null && (bundleExtra = activity.getIntent().getBundleExtra("athena")) != null) {
                            trackData.d(0, "ext", bundleExtra);
                        }
                        b.n(this.f4734m).o("page_view", trackData, this.f4734m);
                        this.f4733l.remove(eVar);
                        break;
                    }
                }
            }
            int i8 = this.f4726b - 1;
            this.f4726b = i8;
            if (i8 == 0) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.f4731j;
                if (jElapsedRealtime2 > 1000 && jElapsedRealtime2 < 86400000) {
                    for (Integer num : t6.d.f10185b) {
                        if (num.intValue() != 9999) {
                            TrackData trackData2 = new TrackData();
                            trackData2.g("s_id", s6.d.f9552s);
                            trackData2.b(this.f4729h, 0, "s_t");
                            trackData2.g("pkg", this.f4729h == 2 ? this.f4730i : "");
                            trackData2.f("s_s", this.e);
                            trackData2.f("t", jElapsedRealtime2);
                            b.n(num.intValue()).o("app_active", trackData2, num.intValue());
                        }
                    }
                }
                af.f fVar = this.f4728d;
                if (fVar != null) {
                    this.f4725a.removeCallbacks(fVar);
                }
                Handler handler = this.f4725a;
                af.f fVar2 = new af.f(this, 17);
                this.f4728d = fVar2;
                handler.postDelayed(fVar2, s6.d.f9551r);
                if (b.f4710g == 0 && b.f != null && b.f.k() != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 600;
                    b.f.k().b(messageObtain, 100L);
                }
            }
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }
}
