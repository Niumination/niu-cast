package com.google.android.gms.common.server.converter;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1929b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f1930c = new SparseArray();

    public StringToIntConverter(int i8, ArrayList arrayList) {
        this.f1928a = i8;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            zac zacVar = (zac) arrayList.get(i9);
            String str = zacVar.f1934b;
            int i10 = zacVar.f1935c;
            this.f1929b.put(str, Integer.valueOf(i10));
            this.f1930c.put(i10, str);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1928a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f1929b;
        for (String str : map.keySet()) {
            arrayList.add(new zac(str, ((Integer) map.get(str)).intValue()));
        }
        qd.h(parcel, 2, arrayList);
        qd.j(parcel, i9);
    }
}
