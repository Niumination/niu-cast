package qi;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences(context.getPackageName(), 0);
    }

    public static Map<String, ?> b(Context context) {
        return a(context).getAll();
    }

    public static boolean c(Context context, String str, boolean z10) {
        return a(context).getBoolean(str, z10);
    }

    public static int d(Context context, String str, int i10) {
        return a(context).getInt(str, i10);
    }

    public static long e(Context context, String str, long j10) {
        return a(context).getLong(str, j10);
    }

    public static String f(Context context, String str, String str2) {
        return a(context).getString(str, str2);
    }

    public static Set<String> g(Context context, String str, Set<String> set) {
        return a(context).getStringSet(str, set);
    }

    public static void h(Context context, String str, boolean z10) {
        a(context).edit().putBoolean(str, z10).apply();
    }

    public static void i(Context context, String str, int i10) {
        a(context).edit().putInt(str, i10).apply();
    }

    public static void j(Context context, String str, long j10) {
        a(context).edit().putLong(str, j10).apply();
    }

    public static void k(Context context, String str, String str2) {
        a(context).edit().putString(str, str2).apply();
    }

    public static void l(Context context, String str, Set<String> set) {
        a(context).edit().putStringSet(str, set).apply();
    }

    public static void m(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        a(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static void n(Context context, String str) {
        a(context).edit().remove(str).apply();
    }

    public static void o(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        a(context).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
