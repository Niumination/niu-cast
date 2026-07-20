package com.google.android.gms.auth.api.signin;

import a3.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import k3.qd;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a(12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1776d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f1777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f1779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f1781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f1782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f1783n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashSet f1784o = new HashSet();

    public GoogleSignInAccount(int i8, String str, String str2, String str3, String str4, Uri uri, String str5, long j8, String str6, ArrayList arrayList, String str7, String str8) {
        this.f1773a = i8;
        this.f1774b = str;
        this.f1775c = str2;
        this.f1776d = str3;
        this.e = str4;
        this.f1777h = uri;
        this.f1778i = str5;
        this.f1779j = j8;
        this.f1780k = str6;
        this.f1781l = arrayList;
        this.f1782m = str7;
        this.f1783n = str8;
    }

    public static GoogleSignInAccount g(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j8 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i8 = 0; i8 < length; i8++) {
            hashSet.add(new Scope(1, jSONArray.getString(i8)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has(NotificationCompat.CATEGORY_EMAIL) ? jSONObject.optString(NotificationCompat.CATEGORY_EMAIL) : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        l.c(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j8, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.f1778i = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (googleSignInAccount.f1780k.equals(this.f1780k)) {
            HashSet hashSet = new HashSet(googleSignInAccount.f1781l);
            hashSet.addAll(googleSignInAccount.f1784o);
            HashSet hashSet2 = new HashSet(this.f1781l);
            hashSet2.addAll(this.f1784o);
            if (hashSet.equals(hashSet2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iE = a1.a.e(527, 31, this.f1780k);
        HashSet hashSet = new HashSet(this.f1781l);
        hashSet.addAll(this.f1784o);
        return hashSet.hashCode() + iE;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1773a);
        qd.e(parcel, 2, this.f1774b);
        qd.e(parcel, 3, this.f1775c);
        qd.e(parcel, 4, this.f1776d);
        qd.e(parcel, 5, this.e);
        qd.d(parcel, 6, this.f1777h, i8);
        qd.e(parcel, 7, this.f1778i);
        qd.k(parcel, 8, 8);
        parcel.writeLong(this.f1779j);
        qd.e(parcel, 9, this.f1780k);
        qd.h(parcel, 10, this.f1781l);
        qd.e(parcel, 11, this.f1782m);
        qd.e(parcel, 12, this.f1783n);
        qd.j(parcel, i9);
    }
}
