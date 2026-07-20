package com.google.android.gms.common.server.response;

import android.os.Parcel;
import b3.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import k3.qd;
import u6.c;

/* JADX INFO: loaded from: classes.dex */
public class FastJsonResponse$Field<I, O> extends AbstractSafeParcelable {
    public static final a CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1939d;
    public final boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Class f1942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public zan f1944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StringToIntConverter f1945m;

    public FastJsonResponse$Field(int i8, int i9, boolean z2, int i10, boolean z3, String str, int i11, String str2, zaa zaaVar) {
        this.f1936a = i8;
        this.f1937b = i9;
        this.f1938c = z2;
        this.f1939d = i10;
        this.e = z3;
        this.f1940h = str;
        this.f1941i = i11;
        if (str2 == null) {
            this.f1942j = null;
            this.f1943k = null;
        } else {
            this.f1942j = SafeParcelResponse.class;
            this.f1943k = str2;
        }
        if (zaaVar == null) {
            this.f1945m = null;
            return;
        }
        StringToIntConverter stringToIntConverter = zaaVar.f1932b;
        if (stringToIntConverter == null) {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
        this.f1945m = stringToIntConverter;
    }

    public final String toString() {
        c cVar = new c(this);
        cVar.q(Integer.valueOf(this.f1936a), "versionCode");
        cVar.q(Integer.valueOf(this.f1937b), "typeIn");
        cVar.q(Boolean.valueOf(this.f1938c), "typeInArray");
        cVar.q(Integer.valueOf(this.f1939d), "typeOut");
        cVar.q(Boolean.valueOf(this.e), "typeOutArray");
        cVar.q(this.f1940h, "outputFieldName");
        cVar.q(Integer.valueOf(this.f1941i), "safeParcelFieldId");
        String str = this.f1943k;
        if (str == null) {
            str = null;
        }
        cVar.q(str, "concreteTypeName");
        Class cls = this.f1942j;
        if (cls != null) {
            cVar.q(cls.getCanonicalName(), "concreteType.class");
        }
        if (this.f1945m != null) {
            cVar.q(StringToIntConverter.class.getCanonicalName(), "converterName");
        }
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1936a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1937b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1938c ? 1 : 0);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1939d);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        qd.e(parcel, 6, this.f1940h);
        qd.k(parcel, 7, 4);
        parcel.writeInt(this.f1941i);
        String str = this.f1943k;
        if (str == null) {
            str = null;
        }
        qd.e(parcel, 8, str);
        StringToIntConverter stringToIntConverter = this.f1945m;
        qd.d(parcel, 9, stringToIntConverter != null ? new zaa(stringToIntConverter) : null, i8);
        qd.j(parcel, i9);
    }
}
