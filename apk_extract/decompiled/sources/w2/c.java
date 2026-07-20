package w2;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c2.k;
import com.google.android.gms.common.Feature;
import h3.d;
import r2.l;
import u2.f;

/* JADX INFO: loaded from: classes.dex */
public final class c extends com.google.android.gms.common.internal.a {
    public final f A;

    public c(Context context, Looper looper, k kVar, f fVar, l lVar, l lVar2) {
        super(context, looper, 270, kVar, lVar, lVar2);
        this.A = fVar;
    }

    @Override // q2.c
    public final int h() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 0);
    }

    @Override // com.google.android.gms.common.internal.a
    public final Feature[] m() {
        return d.f5239b;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle n() {
        f fVar = this.A;
        fVar.getClass();
        Bundle bundle = new Bundle();
        String str = fVar.f10336a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String p() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String q() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean r() {
        return true;
    }
}
