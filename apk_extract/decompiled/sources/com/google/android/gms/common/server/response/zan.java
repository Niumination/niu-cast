package com.google.android.gms.common.server.response;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k3.qd;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new a(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1960c;

    public zan(int i8, ArrayList arrayList, String str) {
        this.f1958a = i8;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            zal zalVar = (zal) arrayList.get(i9);
            String str2 = zalVar.f1953b;
            HashMap map2 = new HashMap();
            ArrayList arrayList2 = zalVar.f1954c;
            l.e(arrayList2);
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                zam zamVar = (zam) arrayList2.get(i10);
                map2.put(zamVar.f1956b, zamVar.f1957c);
            }
            map.put(str2, map2);
        }
        this.f1959b = map;
        l.e(str);
        this.f1960c = str;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Map map3 = (Map) map.get((String) it.next());
            Iterator it2 = map3.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse$Field) map3.get((String) it2.next())).f1944l = this;
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        HashMap map = this.f1959b;
        for (String str : map.keySet()) {
            sb2.append(str);
            sb2.append(":\n");
            Map map2 = (Map) map.get(str);
            for (String str2 : map2.keySet()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(map2.get(str2));
            }
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1958a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f1959b;
        for (String str : map.keySet()) {
            arrayList.add(new zal(str, (Map) map.get(str)));
        }
        qd.h(parcel, 2, arrayList);
        qd.e(parcel, 3, this.f1960c);
        qd.j(parcel, i9);
    }
}
