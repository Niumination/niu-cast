package w2;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.TelemetryData;
import h3.d;
import q2.f;
import q3.k;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u6.c f10651i = new u6.c("ClientTelemetry.API", new o3.b(2), new n5.a());

    public final k c(TelemetryData telemetryData) {
        i iVar = new i();
        iVar.f9337c = 0;
        iVar.f9335a = new Feature[]{d.f5238a};
        iVar.f9336b = false;
        iVar.f9338d = new a8.a(telemetryData, 19);
        return b(2, iVar.a());
    }
}
