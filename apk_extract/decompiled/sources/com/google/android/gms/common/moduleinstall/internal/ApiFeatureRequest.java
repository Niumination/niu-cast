package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import k3.qd;
import q2.j;
import u2.l;
import y2.a;
import y2.b;

/* JADX INFO: loaded from: classes.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1924d;

    public ApiFeatureRequest(ArrayList arrayList, boolean z2, String str, String str2) {
        l.e(arrayList);
        this.f1921a = arrayList;
        this.f1922b = z2;
        this.f1923c = str;
        this.f1924d = str2;
    }

    public static ApiFeatureRequest g(List list, boolean z2) {
        TreeSet treeSet = new TreeSet(a.f11026a);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((j) it.next()).a());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet), z2, null, null);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.f1922b == apiFeatureRequest.f1922b && l.h(this.f1921a, apiFeatureRequest.f1921a) && l.h(this.f1923c, apiFeatureRequest.f1923c) && l.h(this.f1924d, apiFeatureRequest.f1924d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f1922b), this.f1921a, this.f1923c, this.f1924d});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.h(parcel, 1, this.f1921a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1922b ? 1 : 0);
        qd.e(parcel, 3, this.f1923c);
        qd.e(parcel, 4, this.f1924d);
        qd.j(parcel, i9);
    }
}
