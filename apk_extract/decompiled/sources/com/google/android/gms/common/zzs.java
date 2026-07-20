package com.google.android.gms.common;

import a3.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import f3.b;
import k3.qd;
import p2.g;
import p2.h;
import u2.x;
import u2.y;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new a(19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f1983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1985d;

    public zzs(String str, IBinder iBinder, boolean z2, boolean z3) {
        this.f1982a = str;
        h hVar = null;
        if (iBinder != null) {
            try {
                int i8 = g.f8658d;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                f3.a aVarD = (iInterfaceQueryLocalInterface instanceof y ? (y) iInterfaceQueryLocalInterface : new x(iBinder, "com.google.android.gms.common.internal.ICertData", 1)).d();
                byte[] bArr = aVarD == null ? null : (byte[]) b.l(aVarD);
                if (bArr != null) {
                    hVar = new h(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.f1983b = hVar;
        this.f1984c = z2;
        this.f1985d = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f1982a);
        h hVar = this.f1983b;
        if (hVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            hVar = null;
        }
        qd.c(parcel, 2, hVar);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1984c ? 1 : 0);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1985d ? 1 : 0);
        qd.j(parcel, i9);
    }
}
