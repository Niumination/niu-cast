package jb;

import android.app.Application;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.provider.Settings;
import bb.s;
import com.transsion.core.log.LogUtils;
import k3.pb;
import k3.vb;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f6136b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f6135a = new f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f6137c = LazyKt.lazy(new s(17));

    public static e a() {
        return (e) f6137c.getValue();
    }

    public final boolean b() {
        Application context = pb.a();
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        SharedPreferences sharedPreferences = null;
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if ((audioManager == null || audioManager.getMode() != 2) && (audioManager == null || audioManager.getMode() != 3)) {
            Application context2 = pb.a();
            Intrinsics.checkNotNullParameter(context2, "context");
            if (!Intrinsics.areEqual(Settings.Global.getString(context2.getContentResolver(), "transsion_game_mode"), "1")) {
                g gVar = f6136b;
                if (gVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
                    gVar = null;
                }
                gVar.getClass();
                a().f6134b.getClass();
                if (dc.b.e() < 0) {
                    g gVar2 = f6136b;
                    if (gVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
                        gVar2 = null;
                    }
                    gVar2.getClass();
                    int iC = dc.b.c(0);
                    Intrinsics.checkNotNullParameter("connected_count", "key");
                    SharedPreferences sharedPreferences2 = vb.f6684a;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        sharedPreferences2 = null;
                    }
                    if (!(sharedPreferences2.getInt("connected_count", 0) == 0 || iC == 0) || iC >= 2) {
                        return false;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Intrinsics.checkNotNullParameter("sp_function_guide_last_show_time", "key");
                    SharedPreferences sharedPreferences3 = vb.f6684a;
                    if (sharedPreferences3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    } else {
                        sharedPreferences = sharedPreferences3;
                    }
                    return jCurrentTimeMillis - sharedPreferences.getLong("sp_function_guide_last_show_time", 0L) > 2592000000L;
                }
                a().f6134b.getClass();
                int iC2 = dc.b.c(dc.b.e());
                Intrinsics.checkNotNullParameter("connected_count", "key");
                SharedPreferences sharedPreferences4 = vb.f6684a;
                SharedPreferences sharedPreferences5 = null;
                if (sharedPreferences4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences4 = null;
                }
                if (sharedPreferences4.getInt("connected_count", 0) != 0 && iC2 != 0) {
                    return false;
                }
                Intrinsics.checkNotNullParameter("sp_function_guide_count", "key");
                SharedPreferences sharedPreferences6 = vb.f6684a;
                if (sharedPreferences6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences6 = null;
                }
                if (iC2 >= sharedPreferences6.getInt("sp_function_guide_count", 1)) {
                    return false;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                Intrinsics.checkNotNullParameter("sp_function_guide_last_show_time", "key");
                SharedPreferences sharedPreferences7 = vb.f6684a;
                if (sharedPreferences7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                } else {
                    sharedPreferences5 = sharedPreferences7;
                }
                return jCurrentTimeMillis2 - sharedPreferences5.getLong("sp_function_guide_last_show_time", 0L) > 2592000000L;
            }
        }
        LogUtils.i("DataSourceRepository", "isCalling Or Game Mode On");
        return false;
    }
}
