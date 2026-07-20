package com.transsion.hubsdk.api.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TranSearchIndexablesProvider extends ContentProvider {
    public static final String H = "non_indexables_key";
    public static final String I = "site_map_pairs";
    public static final String J = "settings/non_indexables_key";
    public static final String K = "settings/site_map_pairs";
    public static final String L = "slice_uri_pairs";
    public static final String M = "settings/slice_uri_pairs";
    public static final String N = "dynamic_indexables_raw";
    public static final String O = "settings/dynamic_indexables_raw";
    public static final String P = "vnd.android.cursor.dir/indexables_xml_res";
    public static final String Q = "vnd.android.cursor.dir/indexables_raw";
    public static final String R = "vnd.android.cursor.dir/non_indexables_key";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f2235c = "IndexablesProvider";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f2236d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f2237e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f2238f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2239g = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2240i = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2241n = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f2242p = "android.content.action.SEARCH_INDEXABLES_PROVIDER";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f2243v = "settings";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f2244w = "indexables_xml_res";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f2245x = "settings/indexables_xml_res";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f2246y = "indexables_raw";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f2247z = "settings/indexables_raw";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UriMatcher f2249b;

    public Cursor a(String[] strArr) {
        return null;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.f2248a = providerInfo.authority;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f2249b = uriMatcher;
        uriMatcher.addURI(this.f2248a, f2245x, 1);
        this.f2249b.addURI(this.f2248a, f2247z, 2);
        this.f2249b.addURI(this.f2248a, J, 3);
        this.f2249b.addURI(this.f2248a, K, 4);
        this.f2249b.addURI(this.f2248a, M, 5);
        this.f2249b.addURI(this.f2248a, O, 6);
        if (!providerInfo.exported) {
            throw new SecurityException("Provider must be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grantUriPermissions");
        }
        if (!"android.permission.READ_SEARCH_INDEXABLES".equals(providerInfo.readPermission)) {
            throw new SecurityException("Provider must be protected by READ_SEARCH_INDEXABLES");
        }
        super.attachInfo(context, providerInfo);
    }

    public abstract Cursor b(String[] strArr);

    public abstract Cursor c(String[] strArr);

    public Cursor d() {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Delete not supported");
    }

    public Cursor e() {
        return null;
    }

    public abstract Cursor f(String[] strArr);

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int iMatch = this.f2249b.match(uri);
        if (iMatch == 1) {
            return P;
        }
        if (iMatch == 2) {
            return "vnd.android.cursor.dir/indexables_raw";
        }
        if (iMatch == 3) {
            return R;
        }
        if (iMatch == 6) {
            return "vnd.android.cursor.dir/indexables_raw";
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert not supported");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            switch (this.f2249b.match(uri)) {
                case 1:
                    return f(null);
                case 2:
                    return c(null);
                case 3:
                    return b(null);
                case 4:
                    return d();
                case 5:
                    return e();
                case 6:
                    return a(null);
                default:
                    throw new UnsupportedOperationException("Unknown Uri " + uri);
            }
        } catch (UnsupportedOperationException e10) {
            throw e10;
        } catch (Exception e11) {
            e.d(f2235c, "Provider querying exception:", e11);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Update not supported");
    }
}
