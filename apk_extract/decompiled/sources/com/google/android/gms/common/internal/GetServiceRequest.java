package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import s8.b;
import u2.c;
import u2.w;

/* JADX INFO: loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new b(22);
    public static final Scope[] q = new Scope[0];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Feature[] f1848r = new Feature[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1852d;
    public IBinder e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Scope[] f1853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bundle f1854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Account f1855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Feature[] f1856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Feature[] f1857l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f1858m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f1859n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1860o;
    public final String p;

    public GetServiceRequest(int i8, int i9, int i10, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z2, int i11, boolean z3, String str2) {
        Account account2;
        Scope[] scopeArr2 = scopeArr == null ? q : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = f1848r;
        Feature[] featureArr4 = featureArr == null ? featureArr3 : featureArr;
        featureArr3 = featureArr2 != null ? featureArr2 : featureArr3;
        this.f1849a = i8;
        this.f1850b = i9;
        this.f1851c = i10;
        if ("com.google.android.gms".equals(str)) {
            this.f1852d = "com.google.android.gms";
        } else {
            this.f1852d = str;
        }
        if (i8 < 2) {
            account2 = null;
            if (iBinder != null) {
                int i12 = u2.a.f10327c;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface wVar = iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new w(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                if (wVar != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            w wVar2 = (w) wVar;
                            Parcel parcelG = wVar2.g(wVar2.i(), 2);
                            Account account3 = (Account) i3.a.a(parcelG, Account.CREATOR);
                            parcelG.recycle();
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                            account2 = account3;
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                        }
                    } catch (Throwable th2) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        throw th2;
                    }
                }
            }
        } else {
            this.e = iBinder;
            account2 = account;
        }
        this.f1855j = account2;
        this.f1853h = scopeArr2;
        this.f1854i = bundle2;
        this.f1856k = featureArr4;
        this.f1857l = featureArr3;
        this.f1858m = z2;
        this.f1859n = i11;
        this.f1860o = z3;
        this.p = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        b.a(this, parcel, i8);
    }
}
