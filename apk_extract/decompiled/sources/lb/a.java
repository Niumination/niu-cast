package lb;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import java.util.LinkedHashMap;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h7.a f7356b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f7355a = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f7357c = true;

    public static boolean a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return Settings.Global.getInt(pb.a().getContentResolver(), key, 1) == 1;
        } catch (Exception e) {
            String log = h0.a.k("getBoolean error: ", key, ", ", e.getMessage());
            Intrinsics.checkNotNullParameter("GlobalSettingsStore", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a > 6) {
                return true;
            }
            Log.e(gc.f6463b.concat("GlobalSettingsStore"), log);
            return true;
        }
    }

    public static MutableLiveData b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        LinkedHashMap linkedHashMap = f7355a;
        MutableLiveData mutableLiveData = (MutableLiveData) linkedHashMap.get(key);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        linkedHashMap.put(key, mutableLiveData2);
        try {
            ContentResolver contentResolver = pb.a().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            Uri uriFor = Settings.Global.getUriFor(key);
            Intrinsics.checkNotNullExpressionValue(uriFor, "getUriFor(...)");
            contentResolver.registerContentObserver(uriFor, false, new i7.a(key, mutableLiveData2, new Handler(Looper.getMainLooper()), 1));
            mutableLiveData2.postValue(Boolean.valueOf(a(key)));
        } catch (Exception e) {
            String strN = d.n("init observer failed: ", e.getMessage(), "GlobalSettingsStore", "tag", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("GlobalSettingsStore"), strN);
            }
            mutableLiveData2.postValue(Boolean.TRUE);
        }
        return mutableLiveData2;
    }

    public static int c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return Settings.Global.getInt(pb.a().getContentResolver(), key, 0);
        } catch (Exception e) {
            String log = h0.a.k("getInt error: ", key, ", ", e.getMessage());
            Intrinsics.checkNotNullParameter("GlobalSettingsStore", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a > 6) {
                return 0;
            }
            Log.e(gc.f6463b.concat("GlobalSettingsStore"), log);
            return 0;
        }
    }

    public static void d(int i8, String str) {
        try {
            int i9 = Settings.Global.getInt(pb.a().getContentResolver(), str, -1);
            gc.c("GlobalSettingsStore", "currentValue " + str + "=" + i9);
            if (i9 == -1) {
                f(i8, str);
                gc.c("GlobalSettingsStore", "Initialized " + str + " to " + i8);
            }
        } catch (Exception e) {
            String log = h0.a.k("Failed to init ", str, ": ", e.getMessage());
            Intrinsics.checkNotNullParameter("GlobalSettingsStore", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("GlobalSettingsStore"), log);
            }
        }
    }

    public static void e(String key, boolean z2) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Settings.Global.putInt(pb.a().getContentResolver(), key, z2 ? 1 : 0);
            MutableLiveData mutableLiveData = (MutableLiveData) f7355a.get(key);
            if (mutableLiveData != null) {
                mutableLiveData.postValue(Boolean.valueOf(z2));
            }
            String log = "setBoolean: " + key + "=" + z2;
            Intrinsics.checkNotNullParameter("GlobalSettingsStore", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("GlobalSettingsStore"), log);
            }
        } catch (Exception e) {
            String log2 = h0.a.k("setBoolean error: ", key, ", ", e.getMessage());
            Intrinsics.checkNotNullParameter("GlobalSettingsStore", "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("GlobalSettingsStore"), log2);
            }
        }
    }

    public static void f(int i8, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Settings.Global.putInt(pb.a().getContentResolver(), key, i8);
            String log = "setInt: " + key + "=" + i8;
            Intrinsics.checkNotNullParameter("GlobalSettingsStore", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("GlobalSettingsStore"), log);
            }
        } catch (Exception e) {
            String log2 = h0.a.k("setInt error: ", key, ", ", e.getMessage());
            Intrinsics.checkNotNullParameter("GlobalSettingsStore", "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("GlobalSettingsStore"), log2);
            }
        }
    }
}
