package com.transsion.hubsdk.api.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;
import j9.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TranSearchIndexablesProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UriMatcher f2366b;

    public abstract MatrixCursor a();

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        this.f2365a = providerInfo.authority;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f2366b = uriMatcher;
        uriMatcher.addURI(this.f2365a, "settings/indexables_xml_res", 1);
        this.f2366b.addURI(this.f2365a, "settings/indexables_raw", 2);
        this.f2366b.addURI(this.f2365a, "settings/non_indexables_key", 3);
        this.f2366b.addURI(this.f2365a, "settings/site_map_pairs", 4);
        this.f2366b.addURI(this.f2365a, "settings/slice_uri_pairs", 5);
        this.f2366b.addURI(this.f2365a, "settings/dynamic_indexables_raw", 6);
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

    public abstract MatrixCursor b();

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Delete not supported");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        int iMatch = this.f2366b.match(uri);
        if (iMatch == 1) {
            return "vnd.android.cursor.dir/indexables_xml_res";
        }
        if (iMatch == 2) {
            return "vnd.android.cursor.dir/indexables_raw";
        }
        if (iMatch == 3) {
            return "vnd.android.cursor.dir/non_indexables_key";
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
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            switch (this.f2366b.match(uri)) {
                case 1:
                    return null;
                case 2:
                    return b();
                case 3:
                    return a();
                case 4:
                case 5:
                case 6:
                    return null;
                default:
                    throw new UnsupportedOperationException("Unknown Uri " + uri);
            }
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e4) {
            boolean z2 = a.f6132a;
            Log.e("IndexablesProvider", "Provider querying exception:", e4);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Update not supported");
    }
}
