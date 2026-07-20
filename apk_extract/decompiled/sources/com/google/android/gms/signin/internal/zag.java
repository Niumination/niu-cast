package com.google.android.gms.signin.internal;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zag> CREATOR = new a(21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2208b;

    public zag(String str, ArrayList arrayList) {
        this.f2207a = arrayList;
        this.f2208b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        ArrayList arrayList = this.f2207a;
        if (arrayList != null) {
            int i10 = qd.i(parcel, 1);
            parcel.writeStringList(arrayList);
            qd.j(parcel, i10);
        }
        qd.e(parcel, 2, this.f2208b);
        qd.j(parcel, i9);
    }
}
