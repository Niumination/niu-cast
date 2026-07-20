package com.google.android.gms.common.server.response;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new a(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FastJsonResponse$Field f1957c;

    public zam(int i8, String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f1955a = i8;
        this.f1956b = str;
        this.f1957c = fastJsonResponse$Field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1955a);
        qd.e(parcel, 2, this.f1956b);
        qd.d(parcel, 3, this.f1957c, i8);
        qd.j(parcel, i9);
    }

    public zam(String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f1955a = 1;
        this.f1956b = str;
        this.f1957c = fastJsonResponse$Field;
    }
}
