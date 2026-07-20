package dc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Locale;
import k3.gc;
import k3.vb;
import kotlin.jvm.internal.Intrinsics;
import v4.a0;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4399a = new b();

    public static void a(int i8) {
        String strH = o.d.h(i8, "sp_function_guide_cache", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(strH);
        editorEdit.apply();
        Intrinsics.checkNotNullParameter("sp_function_guide_cache_version", "key");
        SharedPreferences sharedPreferences3 = vb.f6684a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
        editorEdit2.remove("sp_function_guide_cache_version");
        editorEdit2.apply();
    }

    public static void b(int i8) {
        String strH = o.d.h(i8, "sp_search_page_cache", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(strH);
        editorEdit.apply();
        Intrinsics.checkNotNullParameter("sp_search_cache_version", "key");
        SharedPreferences sharedPreferences3 = vb.f6684a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
        editorEdit2.remove("sp_search_cache_version");
        editorEdit2.apply();
    }

    public static int c(int i8) {
        String strH = o.d.h(i8, "sp_function_guide_already_remind_count", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt(strH, 0);
    }

    public static HashMap d() {
        q qVar = na.b.f8132a;
        Intrinsics.checkNotNullParameter("connected_device", "key");
        Intrinsics.checkNotNullParameter("", "defaultVal");
        SharedPreferences sharedPreferences = vb.f6684a;
        Object objFromJson = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("connected_device", "");
        try {
            objFromJson = na.b.f8132a.fromJson(string != null ? string : "", new a().getType());
        } catch (a0 e) {
            e.printStackTrace();
        }
        HashMap map = (HashMap) objFromJson;
        return map == null ? new HashMap() : map;
    }

    public static int e() {
        Intrinsics.checkNotNullParameter("sp_function_guide_cache_version", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt("sp_function_guide_cache_version", -1);
    }

    public static int f() {
        Intrinsics.checkNotNullParameter("sp_search_cache_version", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt("sp_search_cache_version", -1);
    }

    public static void g(String deviceMac, boolean z2) {
        Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
        if (TextUtils.isEmpty(deviceMac)) {
            String strO = o.d.o("putConnectedDevice cacheMac is empty cacheMac:", z2, "AppSharedPreference", "tag", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("AppSharedPreference"), strO);
                return;
            }
            return;
        }
        HashMap mapD = d();
        gc.c("AppSharedPreference", "本地记录记住过的pc设备 connectDeviceMap: " + mapD);
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String upperCase = deviceMac.toUpperCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        mapD.put(upperCase, Boolean.valueOf(z2));
        gc.a("AppSharedPreference", "cacheMac :" + upperCase + " :" + z2);
        String value = na.b.b(mapD);
        Intrinsics.checkNotNullParameter("connected_device", "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("connected_device", value);
        editorEdit.apply();
    }
}
