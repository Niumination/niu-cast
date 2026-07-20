package h7;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import k3.gc;
import k3.k1;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import o.d;
import t7.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5267a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Handler handler, int i8) {
        super(handler);
        this.f5267a = i8;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        switch (this.f5267a) {
            case 0:
                super.onChange(z2);
                Context context = b.f5268a;
                int i8 = Settings.Secure.getInt(context != null ? context.getContentResolver() : null, "os_reboot_to_repair_mode", 0);
                if (b.f5270c != (i8 == 1)) {
                    boolean z3 = i8 == 1;
                    b.f5270c = z3;
                    k1.a("TransAtomicSDKManager", "isRepairMode changed to " + z3);
                }
                break;
            case 1:
                super.onChange(z2);
                Context context2 = b.f5268a;
                int i9 = Settings.Secure.getInt(context2 != null ? context2.getContentResolver() : null, "super_power_saving_mode", 0);
                if (b.f5269b != (i9 == 1)) {
                    boolean z5 = i9 == 1;
                    b.f5269b = z5;
                    k1.a("TransAtomicSDKManager", "super_power_saving_mode changed to " + z5);
                }
                break;
            case 2:
            default:
                super.onChange(z2);
                break;
            case 3:
                super.onChange(z2);
                Intrinsics.checkNotNullParameter("GalleryChangeMonitorHelper", "tag");
                Intrinsics.checkNotNullParameter("onChange", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("GalleryChangeMonitorHelper"), "onChange");
                }
                c cVar = t7.a.f10193d;
                cVar.getClass();
                l0.p(cVar, null, null, new t7.b(cVar, null), 3);
                break;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2, Uri uri) {
        switch (this.f5267a) {
            case 2:
                boolean zA = lb.a.a("multi_device_connection.share_call_phone");
                lb.a.f7357c = zA;
                String strO = d.o("phone call share changed:", zA, "GlobalSettingsStore", "tag", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("GlobalSettingsStore"), strO);
                }
                break;
            default:
                super.onChange(z2, uri);
                break;
        }
    }
}
