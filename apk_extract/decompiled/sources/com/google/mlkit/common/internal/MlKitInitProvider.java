package com.google.mlkit.common.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import d2.h;
import java.util.ArrayList;
import java.util.HashMap;
import o4.b;
import o4.g;
import o4.r;
import p5.f;
import se.e;
import u2.l;

/* JADX INFO: loaded from: classes2.dex */
public class MlKitInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        l.g(!providerInfo.authority.equals("com.google.mlkit.common.mlkitinitprovider"), "Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        HashMap map;
        Context context = getContext();
        if (context == null) {
            Log.i("MlKitInitProvider", "No context available. Manually call MlKit.initialize(), otherwise ML Kit will not be functional.");
            return false;
        }
        synchronized (f.f8675b) {
            l.g(f.f8676c == null, "MlKitContext is already initialized");
            f fVar = new f();
            f.f8676c = fVar;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            ArrayList arrayListC = new e(context, new r()).c();
            h hVar = q3.h.f8951a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(arrayListC);
            arrayList2.add(b.b(context, Context.class, new Class[0]));
            arrayList2.add(b.b(fVar, f.class, new Class[0]));
            g gVar = new g(hVar, arrayList, arrayList2);
            fVar.f8677a = gVar;
            if (gVar.e.compareAndSet(null, Boolean.TRUE)) {
                synchronized (gVar) {
                    map = new HashMap(gVar.f8379a);
                }
                gVar.e(map, true);
            }
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
