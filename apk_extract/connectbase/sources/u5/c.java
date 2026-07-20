package u5;

import android.provider.Settings;
import com.transsion.connectx.mirror.source.SourceApplication;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final c f16204a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f16205b = "connectx.extend.game.wifi.scan.service.enabled";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16206c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16207d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16208e = 100;

    public final void a(boolean z10) {
        Settings.Global.putInt(SourceApplication.b().getContentResolver(), f16205b, 100);
        Settings.Global.putInt(SourceApplication.f1881c.getContentResolver(), f16205b, !z10 ? 1 : 0);
    }
}
