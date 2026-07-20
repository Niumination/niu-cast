package bc;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesViewModel;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1268b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Object obj, Handler handler, int i8) {
        super(handler);
        this.f1267a = i8;
        this.f1268b = obj;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2, Uri uri) {
        switch (this.f1267a) {
            case 0:
                Intrinsics.checkNotNullParameter("TrustDevicesViewModel", "tag");
                Intrinsics.checkNotNullParameter(" TrustDevices Settings changed", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TrustDevicesViewModel"), " TrustDevices Settings changed");
                }
                ((TrustDevicesViewModel) this.f1268b).a();
                break;
            default:
                super.onChange(z2, uri);
                break;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        switch (this.f1267a) {
            case 1:
                ((w) this.f1268b).getClass();
                boolean z3 = Settings.System.getInt(pb.a().getContentResolver(), "user_experience", 0) == 1;
                String strO = o.d.o("user_experience : ", z3, "AthenaImpl", "tag", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("AthenaImpl"), strO);
                }
                try {
                    e8.b.l(z3);
                } catch (Exception e) {
                    Intrinsics.checkNotNullParameter("AthenaImpl", "tag");
                    Intrinsics.checkNotNullParameter(e, "e");
                    Log.e(gc.f6463b.concat("AthenaImpl"), e.getMessage(), e);
                    return;
                }
                break;
            default:
                super.onChange(z2);
                break;
        }
    }
}
