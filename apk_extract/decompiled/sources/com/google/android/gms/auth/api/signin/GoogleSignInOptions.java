package com.google.android.gms.auth.api.signin;

import a3.a;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import k3.qd;
import q2.b;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements b, ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Account f1787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1788d;
    public final boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f1791j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f1792k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f1793l;

    static {
        Scope scope = new Scope(1, "profile");
        new Scope(1, NotificationCompat.CATEGORY_EMAIL);
        Scope scope2 = new Scope(1, "openid");
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        Scope scope4 = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new a(13);
    }

    public GoogleSignInOptions(int i8, ArrayList arrayList, Account account, boolean z2, boolean z3, boolean z5, String str, String str2, HashMap map, String str3) {
        this.f1785a = i8;
        this.f1786b = arrayList;
        this.f1787c = account;
        this.f1788d = z2;
        this.e = z3;
        this.f1789h = z5;
        this.f1790i = str;
        this.f1791j = str2;
        this.f1792k = new ArrayList(map.values());
        this.f1793l = str3;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004f A[Catch: ClassCastException -> 0x007b, TryCatch #0 {ClassCastException -> 0x007b, blocks: (B:5:0x0008, B:7:0x0018, B:10:0x0021, B:12:0x0030, B:15:0x003c, B:21:0x0049, B:23:0x004f, B:29:0x005d, B:31:0x0063, B:33:0x0069, B:35:0x006f, B:26:0x0056, B:19:0x0043), top: B:41:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:26:0x0056 A[Catch: ClassCastException -> 0x007b, TryCatch #0 {ClassCastException -> 0x007b, blocks: (B:5:0x0008, B:7:0x0018, B:10:0x0021, B:12:0x0030, B:15:0x003c, B:21:0x0049, B:23:0x004f, B:29:0x005d, B:31:0x0063, B:33:0x0069, B:35:0x006f, B:26:0x0056, B:19:0x0043), top: B:41:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d A[Catch: ClassCastException -> 0x007b, TryCatch #0 {ClassCastException -> 0x007b, blocks: (B:5:0x0008, B:7:0x0018, B:10:0x0021, B:12:0x0030, B:15:0x003c, B:21:0x0049, B:23:0x004f, B:29:0x005d, B:31:0x0063, B:33:0x0069, B:35:0x006f, B:26:0x0056, B:19:0x0043), top: B:41:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0063 A[Catch: ClassCastException -> 0x007b, TryCatch #0 {ClassCastException -> 0x007b, blocks: (B:5:0x0008, B:7:0x0018, B:10:0x0021, B:12:0x0030, B:15:0x003c, B:21:0x0049, B:23:0x004f, B:29:0x005d, B:31:0x0063, B:33:0x0069, B:35:0x006f, B:26:0x0056, B:19:0x0043), top: B:41:0x0008 }] */
    public final boolean equals(Object obj) {
        String str = this.f1790i;
        ArrayList arrayList = this.f1786b;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            ArrayList arrayList2 = googleSignInOptions.f1786b;
            String str2 = googleSignInOptions.f1790i;
            Account account = googleSignInOptions.f1787c;
            if (this.f1792k.size() <= 0 && googleSignInOptions.f1792k.size() <= 0 && arrayList.size() == new ArrayList(arrayList2).size() && arrayList.containsAll(new ArrayList(arrayList2))) {
                Account account2 = this.f1787c;
                if (account2 == null) {
                    if (account == null) {
                        if (TextUtils.isEmpty(str)) {
                            if (TextUtils.isEmpty(str2)) {
                                if (this.f1789h != googleSignInOptions.f1789h && this.f1788d == googleSignInOptions.f1788d && this.e == googleSignInOptions.e && TextUtils.equals(this.f1793l, googleSignInOptions.f1793l)) {
                                    return true;
                                }
                            }
                        } else if (!str.equals(str2)) {
                            if (this.f1789h != googleSignInOptions.f1789h) {
                            }
                        }
                    }
                } else if (account2.equals(account)) {
                    if (TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str2)) {
                            if (this.f1789h != googleSignInOptions.f1789h) {
                            }
                        }
                    } else if (!str.equals(str2)) {
                        if (this.f1789h != googleSignInOptions.f1789h) {
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f1786b;
        int size = arrayList2.size();
        for (int i8 = 0; i8 < size; i8++) {
            arrayList.add(((Scope) arrayList2.get(i8)).f1817b);
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + (31 * 1);
        Account account = this.f1787c;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.f1790i;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.f1789h ? 1 : 0)) * 31) + (this.f1788d ? 1 : 0)) * 31) + (this.e ? 1 : 0);
        String str2 = this.f1793l;
        return (31 * iHashCode3) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1785a);
        qd.h(parcel, 2, new ArrayList(this.f1786b));
        qd.d(parcel, 3, this.f1787c, i8);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1788d ? 1 : 0);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        qd.k(parcel, 6, 4);
        parcel.writeInt(this.f1789h ? 1 : 0);
        qd.e(parcel, 7, this.f1790i);
        qd.e(parcel, 8, this.f1791j);
        qd.h(parcel, 9, this.f1792k);
        qd.e(parcel, 10, this.f1793l);
        qd.j(parcel, i9);
    }
}
