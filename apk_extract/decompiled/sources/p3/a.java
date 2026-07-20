package p3;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c2.k;
import q2.g;
import q2.h;

/* JADX INFO: loaded from: classes.dex */
public final class a extends com.google.android.gms.common.internal.a implements q2.c {
    public static final /* synthetic */ int E = 0;
    public final boolean A;
    public final k B;
    public final Bundle C;
    public final Integer D;

    public a(Context context, Looper looper, k kVar, Bundle bundle, g gVar, h hVar) {
        super(context, looper, 44, kVar, gVar, hVar);
        this.A = true;
        this.B = kVar;
        this.C = bundle;
        this.D = kVar.f1408b;
    }

    @Override // com.google.android.gms.common.internal.a, q2.c
    public final boolean e() {
        return this.A;
    }

    @Override // q2.c
    public final int h() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new c(iBinder, "com.google.android.gms.signin.internal.ISignInService", 0);
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle n() {
        k kVar = this.B;
        boolean zEquals = this.f1878c.getPackageName().equals((String) kVar.f);
        Bundle bundle = this.C;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) kVar.f);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String p() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String q() {
        return "com.google.android.gms.signin.service.START";
    }
}
