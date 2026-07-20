package com.google.android.gms.common.server.response;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Map;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new a(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1954c;

    public zal(int i8, ArrayList arrayList, String str) {
        this.f1952a = i8;
        this.f1953b = str;
        this.f1954c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1952a);
        qd.e(parcel, 2, this.f1953b);
        qd.h(parcel, 3, this.f1954c);
        qd.j(parcel, i9);
    }

    public zal(String str, Map map) {
        ArrayList arrayList;
        this.f1952a = 1;
        this.f1953b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse$Field) map.get(str2)));
            }
        }
        this.f1954c = arrayList;
    }
}
