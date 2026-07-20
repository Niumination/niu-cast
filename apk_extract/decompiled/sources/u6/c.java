package u6;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.transsion.athena.data.AppIdData;
import i2.i;
import j2.h;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicLong;
import k3.dd;
import k3.nc;
import k3.v8;
import org.json.JSONException;
import org.json.JSONObject;
import u2.f;
import ze.u2;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements k2.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile c f10385d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f10387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10388c;

    public /* synthetic */ c() {
        this.f10386a = 0;
    }

    public static synchronized c e(Context context) {
        try {
            if (f10385d == null) {
                synchronized (c.class) {
                    try {
                        if (f10385d == null) {
                            c cVar = new c();
                            try {
                                cVar.f10387b = context;
                                d dVar = new d(context);
                                cVar.f10388c = dVar;
                                dVar.setWriteAheadLoggingEnabled(true);
                            } catch (Exception e) {
                                z6.a.c(e.getMessage());
                            }
                            f10385d = cVar;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return f10385d;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0201  */
    /* JADX WARN: Code duplicated, block: B:116:0x0254 A[Catch: all -> 0x0160, Exception -> 0x01ab, SQLiteException -> 0x01af, TRY_LEAVE, TryCatch #0 {all -> 0x0160, blocks: (B:54:0x00f4, B:63:0x0123, B:67:0x0133, B:70:0x013d, B:72:0x0143, B:77:0x0167, B:84:0x0179, B:87:0x018f, B:88:0x0194, B:91:0x01a2, B:98:0x01b9, B:116:0x0254, B:127:0x0281, B:129:0x02a0, B:131:0x02bd, B:140:0x02db, B:141:0x02e0, B:144:0x02e6, B:146:0x02f1, B:147:0x02f6, B:148:0x02fa, B:96:0x01b3, B:101:0x01dd), top: B:188:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x0336  */
    /* JADX WARN: Code duplicated, block: B:181:0x0387  */
    /* JADX WARN: Code duplicated, block: B:184:0x0390  */
    /* JADX WARN: Code duplicated, block: B:200:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x01dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ad A[Catch: all -> 0x00b0, Exception -> 0x00b2, SQLiteException -> 0x00b4, TryCatch #19 {SQLiteException -> 0x00b4, Exception -> 0x00b2, all -> 0x00b0, blocks: (B:21:0x008b, B:29:0x00ad, B:37:0x00bc, B:36:0x00b6), top: B:203:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b6 A[Catch: all -> 0x00b0, Exception -> 0x00b2, SQLiteException -> 0x00b4, TryCatch #19 {SQLiteException -> 0x00b4, Exception -> 0x00b2, all -> 0x00b0, blocks: (B:21:0x008b, B:29:0x00ad, B:37:0x00bc, B:36:0x00b6), top: B:203:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:87:0x018f A[Catch: all -> 0x0160, Exception -> 0x01ab, SQLiteException -> 0x01af, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0160, blocks: (B:54:0x00f4, B:63:0x0123, B:67:0x0133, B:70:0x013d, B:72:0x0143, B:77:0x0167, B:84:0x0179, B:87:0x018f, B:88:0x0194, B:91:0x01a2, B:98:0x01b9, B:116:0x0254, B:127:0x0281, B:129:0x02a0, B:131:0x02bd, B:140:0x02db, B:141:0x02e0, B:144:0x02e6, B:146:0x02f1, B:147:0x02f6, B:148:0x02fa, B:96:0x01b3, B:101:0x01dd), top: B:188:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01a2 A[Catch: all -> 0x0160, Exception -> 0x01ab, SQLiteException -> 0x01af, TRY_ENTER, TryCatch #0 {all -> 0x0160, blocks: (B:54:0x00f4, B:63:0x0123, B:67:0x0133, B:70:0x013d, B:72:0x0143, B:77:0x0167, B:84:0x0179, B:87:0x018f, B:88:0x0194, B:91:0x01a2, B:98:0x01b9, B:116:0x0254, B:127:0x0281, B:129:0x02a0, B:131:0x02bd, B:140:0x02db, B:141:0x02e0, B:144:0x02e6, B:146:0x02f1, B:147:0x02f6, B:148:0x02fa, B:96:0x01b3, B:101:0x01dd), top: B:188:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01b3 A[Catch: all -> 0x0160, Exception -> 0x01ab, SQLiteException -> 0x01af, TryCatch #0 {all -> 0x0160, blocks: (B:54:0x00f4, B:63:0x0123, B:67:0x0133, B:70:0x013d, B:72:0x0143, B:77:0x0167, B:84:0x0179, B:87:0x018f, B:88:0x0194, B:91:0x01a2, B:98:0x01b9, B:116:0x0254, B:127:0x0281, B:129:0x02a0, B:131:0x02bd, B:140:0x02db, B:141:0x02e0, B:144:0x02e6, B:146:0x02f1, B:147:0x02f6, B:148:0x02fa, B:96:0x01b3, B:101:0x01dd), top: B:188:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01b9 A[Catch: all -> 0x0160, Exception -> 0x01ab, SQLiteException -> 0x01af, TryCatch #0 {all -> 0x0160, blocks: (B:54:0x00f4, B:63:0x0123, B:67:0x0133, B:70:0x013d, B:72:0x0143, B:77:0x0167, B:84:0x0179, B:87:0x018f, B:88:0x0194, B:91:0x01a2, B:98:0x01b9, B:116:0x0254, B:127:0x0281, B:129:0x02a0, B:131:0x02bd, B:140:0x02db, B:141:0x02e0, B:144:0x02e6, B:146:0x02f1, B:147:0x02f6, B:148:0x02fa, B:96:0x01b3, B:101:0x01dd), top: B:188:0x00f4 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:98:0x01b9, please report this as an issue */
    public int a(b bVar, t6.a aVar, int i8) throws Throwable {
        d dVar;
        Cursor cursor;
        Cursor cursorRawQuery;
        Cursor cursorRawQuery2;
        long j8;
        String str;
        int i9;
        boolean z2;
        String str2;
        String str3;
        boolean zContains;
        long j10;
        JSONObject jSONObject;
        String string;
        String str4;
        byte[] bArr;
        byte[] bArr2;
        int i10;
        String str5 = "There is not enough space left";
        d dVar2 = (d) this.f10388c;
        String strA = bVar.a();
        long j11 = aVar.f10170d;
        JSONObject jSONObject2 = aVar.f10168b;
        ArrayList arrayList = ((s6.e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a).f9568l;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    if (dVar2.a()) {
                        z6.a.c("There is not enough space left");
                    }
                    return -1;
                }
                String str6 = "pi";
                String str7 = "et";
                String str8 = "_eid";
                if (i8 == 1) {
                    try {
                        cursorRawQuery2 = sQLiteDatabaseS.rawQuery("SELECT * FROM " + strA + " WHERE tid=" + j11 + " AND et=" + i8, null);
                        byte[] bArr3 = null;
                        String str9 = null;
                        String str10 = null;
                        while (true) {
                            if (cursorRawQuery2 != null) {
                                try {
                                    if (cursorRawQuery2.moveToNext()) {
                                        int i11 = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex(str6));
                                        byte[] bArr4 = bArr3;
                                        String string2 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(NotificationCompat.CATEGORY_EVENT));
                                        str6 = str6;
                                        if (i11 != -1) {
                                            if (i11 != 0) {
                                                try {
                                                    if (dd.i(arrayList)) {
                                                        if (i11 == 0) {
                                                            bArr2 = s6.d.f9549n;
                                                        } else {
                                                            bArr2 = (byte[]) arrayList.get(i11);
                                                        }
                                                        String strF = nc.f(string2, bArr2);
                                                        bArr = bArr2;
                                                        str4 = strF;
                                                    } else {
                                                        str4 = string2;
                                                        bArr = bArr4;
                                                    }
                                                } catch (SQLiteException e) {
                                                    e = e;
                                                    cursorRawQuery = cursorRawQuery2;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    z6.a.c(Log.getStackTraceString(e));
                                                    throw new e8.d("addJSON", e);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    cursor = cursorRawQuery2;
                                                    str5 = str5;
                                                    dVar = dVar2;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    if (dVar.a()) {
                                                        z6.a.c(str5);
                                                    }
                                                    throw th;
                                                }
                                            } else {
                                                if (i11 == 0) {
                                                    bArr2 = s6.d.f9549n;
                                                } else {
                                                    bArr2 = (byte[]) arrayList.get(i11);
                                                }
                                                String strF2 = nc.f(string2, bArr2);
                                                bArr = bArr2;
                                                str4 = strF2;
                                            }
                                            if (bArr == null || str4 == null) {
                                                cursorRawQuery2.close();
                                                if (!dVar2.a()) {
                                                    return -1;
                                                }
                                                z6.a.c(str5);
                                                return -1;
                                            }
                                            byte[] bArr5 = bArr;
                                            string2 = str4;
                                            bArr3 = bArr5;
                                        } else {
                                            bArr3 = bArr4;
                                        }
                                        str5 = str5;
                                        if (str9 == null) {
                                            str2 = str9;
                                            try {
                                                dVar = dVar2;
                                                try {
                                                    try {
                                                        str9 = "\"" + NotificationCompat.CATEGORY_EVENT + "\":\"" + jSONObject2.getString(NotificationCompat.CATEGORY_EVENT) + "\"";
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        cursor = cursorRawQuery2;
                                                        if (cursor != null) {
                                                            cursor.close();
                                                        }
                                                        if (dVar.a()) {
                                                            z6.a.c(str5);
                                                        }
                                                        throw th;
                                                    }
                                                } catch (Exception unused) {
                                                    j8 = j11;
                                                    str3 = str8;
                                                    str8 = str3;
                                                    str9 = str2;
                                                    dVar2 = dVar;
                                                    j11 = j8;
                                                }
                                            } catch (Exception unused2) {
                                                dVar = dVar2;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                dVar = dVar2;
                                                cursor = cursorRawQuery2;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (dVar.a()) {
                                                    z6.a.c(str5);
                                                }
                                                throw th;
                                            }
                                        } else {
                                            dVar = dVar2;
                                        }
                                        try {
                                            boolean zContains2 = string2.contains(str9);
                                            str2 = str9;
                                            if (zContains2) {
                                                j8 = j11;
                                                try {
                                                    if ("ev_athena".equals(aVar.f10167a)) {
                                                        if (str10 == null) {
                                                            str3 = str8;
                                                            try {
                                                                str10 = "\"" + str3 + "\":\"" + jSONObject2.getJSONObject("_eparam").optString(str3) + "\"";
                                                            } catch (Exception unused3) {
                                                                str8 = str3;
                                                                str9 = str2;
                                                                dVar2 = dVar;
                                                            }
                                                        } else {
                                                            str3 = str8;
                                                        }
                                                        zContains = string2.contains(str10);
                                                    }
                                                    if (zContains) {
                                                        try {
                                                            j10 = cursorRawQuery2.getLong(cursorRawQuery2.getColumnIndex("_id"));
                                                            if (string2.length() < 131072) {
                                                                jSONObject = new JSONObject(string2);
                                                                try {
                                                                    dd.f(jSONObject2.getJSONObject("_eparam"), jSONObject.getJSONObject("_eparam"));
                                                                    i9 = -1;
                                                                    if (i11 != -1) {
                                                                        string = nc.b(jSONObject.toString(), bArr3);
                                                                    } else {
                                                                        string = jSONObject.toString();
                                                                    }
                                                                    if (string != null) {
                                                                        ContentValues contentValues = new ContentValues();
                                                                        contentValues.put(NotificationCompat.CATEGORY_EVENT, string);
                                                                        sQLiteDatabaseS.update(strA, contentValues, "_id=" + j10, null);
                                                                    }
                                                                    str = str7;
                                                                    z2 = false;
                                                                } catch (JSONException unused4) {
                                                                    str10 = str10;
                                                                    str9 = str2;
                                                                    dVar2 = dVar;
                                                                    str8 = str3;
                                                                    j11 = j8;
                                                                }
                                                            } else {
                                                                i9 = -1;
                                                                ContentValues contentValues2 = new ContentValues();
                                                                str = str7;
                                                                contentValues2.put(str, (Integer) 2);
                                                                sQLiteDatabaseS.update(strA, contentValues2, "_id=" + j10, null);
                                                                z2 = true;
                                                            }
                                                            if (cursorRawQuery2 != null) {
                                                                cursorRawQuery2.close();
                                                            }
                                                        } catch (SQLiteException e10) {
                                                            e = e10;
                                                            cursorRawQuery = cursorRawQuery2;
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            z6.a.c(Log.getStackTraceString(e));
                                                            throw new e8.d("addJSON", e);
                                                        }
                                                    }
                                                    str10 = str10;
                                                    str9 = str2;
                                                    dVar2 = dVar;
                                                    str8 = str3;
                                                } catch (Exception unused5) {
                                                    str3 = str8;
                                                }
                                                j11 = j8;
                                            } else {
                                                j8 = j11;
                                            }
                                            str3 = str8;
                                            zContains = zContains2;
                                            if (zContains) {
                                                j10 = cursorRawQuery2.getLong(cursorRawQuery2.getColumnIndex("_id"));
                                                if (string2.length() < 131072) {
                                                    jSONObject = new JSONObject(string2);
                                                    dd.f(jSONObject2.getJSONObject("_eparam"), jSONObject.getJSONObject("_eparam"));
                                                    i9 = -1;
                                                    if (i11 != -1) {
                                                        string = nc.b(jSONObject.toString(), bArr3);
                                                    } else {
                                                        string = jSONObject.toString();
                                                    }
                                                    if (string != null) {
                                                        ContentValues contentValues3 = new ContentValues();
                                                        contentValues3.put(NotificationCompat.CATEGORY_EVENT, string);
                                                        sQLiteDatabaseS.update(strA, contentValues3, "_id=" + j10, null);
                                                    }
                                                    str = str7;
                                                    z2 = false;
                                                } else {
                                                    i9 = -1;
                                                    ContentValues contentValues4 = new ContentValues();
                                                    str = str7;
                                                    contentValues4.put(str, (Integer) 2);
                                                    sQLiteDatabaseS.update(strA, contentValues4, "_id=" + j10, null);
                                                    z2 = true;
                                                }
                                                if (cursorRawQuery2 != null) {
                                                    cursorRawQuery2.close();
                                                }
                                            }
                                            str10 = str10;
                                            str9 = str2;
                                            dVar2 = dVar;
                                            str8 = str3;
                                        } catch (Exception unused6) {
                                            str2 = str9;
                                            j8 = j11;
                                            str3 = str8;
                                            str8 = str3;
                                            str9 = str2;
                                            dVar2 = dVar;
                                            j11 = j8;
                                        }
                                        j11 = j8;
                                    }
                                } catch (SQLiteException e12) {
                                    e = e12;
                                    cursorRawQuery = cursorRawQuery2;
                                } catch (Exception e13) {
                                    e = e13;
                                    z6.a.c(Log.getStackTraceString(e));
                                    throw new e8.d("addJSON", e);
                                } catch (Throwable th5) {
                                    th = th5;
                                    str5 = str5;
                                }
                                z6.a.c(Log.getStackTraceString(e));
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                f(e);
                                throw new e8.d("addJSON_sql", e);
                            }
                            str6 = str6;
                            str5 = str5;
                            dVar = dVar2;
                            j8 = j11;
                            str = str7;
                            i9 = -1;
                            z2 = true;
                            if (cursorRawQuery2 != null) {
                                cursorRawQuery2.close();
                            }
                        }
                    } catch (SQLiteException e14) {
                        e = e14;
                        cursorRawQuery = null;
                    } catch (Exception e15) {
                        e = e15;
                    } catch (Throwable th6) {
                        th = th6;
                        str5 = "There is not enough space left";
                        dVar = dVar2;
                        cursor = null;
                    }
                } else {
                    str6 = "pi";
                    str5 = "There is not enough space left";
                    dVar = dVar2;
                    j8 = j11;
                    str = str7;
                    i9 = -1;
                    z2 = true;
                    cursorRawQuery2 = null;
                }
                if (z2) {
                    Pair pairI = m6.a.f().f7948a.i();
                    Integer num = (Integer) pairI.first;
                    num.getClass();
                    String strB = nc.b(jSONObject2.toString(), (byte[]) pairI.second);
                    if (strB != null) {
                        ContentValues contentValues5 = new ContentValues();
                        contentValues5.put("tid", Long.valueOf(j8));
                        contentValues5.put(NotificationCompat.CATEGORY_EVENT, strB);
                        contentValues5.put(str, Integer.valueOf(i8));
                        contentValues5.put(str6, num);
                        contentValues5.put("created_at", Long.valueOf(aVar.f));
                        String str11 = z6.b.f11259a;
                        if (j8 > 999 && j8 <= 9999) {
                            contentValues5.put("ext", aVar.f10167a);
                        }
                        if (aVar.f10172h != null) {
                            contentValues5.put("er_ts", Long.valueOf(aVar.f10171g));
                            contentValues5.put("boot_id", aVar.f10172h);
                        }
                        sQLiteDatabaseS.insert(strA, null, contentValues5);
                    }
                }
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT COUNT(*) FROM " + strA + " WHERE tid=" + j8, null);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.moveToNext()) {
                            i10 = cursorRawQuery.getInt(0);
                        } else {
                            i10 = i9;
                        }
                    } catch (SQLiteException e16) {
                        e = e16;
                    } catch (Exception e17) {
                        e = e17;
                        z6.a.c(Log.getStackTraceString(e));
                        throw new e8.d("addJSON", e);
                    }
                } else {
                    i10 = i9;
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (!dVar.a()) {
                    return i10;
                }
                z6.a.c(str5);
                return -2;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (SQLiteException e18) {
            e = e18;
            cursorRawQuery = null;
        } catch (Exception e19) {
            e = e19;
        } catch (Throwable th8) {
            th = th8;
            str5 = "There is not enough space left";
            dVar = dVar2;
            cursor = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
    public int b(b bVar, e eVar) {
        String strA = bVar.a();
        LongSparseArray longSparseArray = new LongSparseArray();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return 0;
                }
                Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT _id,tid FROM " + strA + " ORDER BY _id LIMIT 1000", null);
                long j8 = 0;
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    long j10 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("tid"));
                    longSparseArray.put(j10, Integer.valueOf(((Integer) longSparseArray.get(j10, 0)).intValue() + 1));
                    j8 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                int iDelete = sQLiteDatabaseS.delete(strA, "_id<=" + j8 + " AND CAST(tid AS TEXT) NOT LIKE ?", new String[]{"9999%"});
                if (longSparseArray.size() > 0) {
                    eVar.e(longSparseArray.toString());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return iDelete;
            } catch (SQLiteException e) {
                z6.a.c(Log.getStackTraceString(e));
                if (0 != 0) {
                    cursor.close();
                }
                f(e);
                throw new e8.d("cleanupEvents_oom_sql", e);
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
        if (0 != 0) {
            cursor.close();
        }
        throw th2;
    }

    public ArrayList c(b bVar) {
        String strA = bVar.a();
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return arrayList;
                }
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT * FROM " + strA, null);
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    AppIdData appIdData = new AppIdData();
                    appIdData.f2313a = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("appid"));
                    appIdData.f2314b = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("base"));
                    appIdData.f2315c = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("uid"));
                    appIdData.f2316d = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("try"));
                    arrayList.add(appIdData);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                z6.a.c(Log.getStackTraceString(e));
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                f(e);
                throw new e8.d("getAppIdList_sql", e);
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:158:0x02a0 A[Catch: all -> 0x0295, TryCatch #22 {all -> 0x0295, blocks: (B:152:0x0286, B:153:0x0294, B:156:0x0297, B:158:0x02a0, B:159:0x02a3, B:160:0x02af), top: B:182:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:162:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:176:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x01b5 A[Catch: all -> 0x00eb, Exception -> 0x01a1, PHI: r9 r10
      0x01b5: PHI (r9v14 java.lang.String) = (r9v2 java.lang.String), (r9v2 java.lang.String), (r9v6 java.lang.String) binds: [B:66:0x0168, B:68:0x016e, B:200:0x01b5] A[DONT_GENERATE, DONT_INLINE]
      0x01b5: PHI (r10v18 java.util.ArrayList) = (r10v7 java.util.ArrayList), (r10v7 java.util.ArrayList), (r10v14 java.util.ArrayList) binds: [B:66:0x0168, B:68:0x016e, B:200:0x01b5] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #6 {all -> 0x00eb, blocks: (B:24:0x0091, B:27:0x0099, B:29:0x00af, B:31:0x00b5, B:33:0x00de, B:43:0x00fd, B:46:0x0109, B:47:0x0115, B:48:0x0120, B:50:0x0126, B:57:0x0149, B:59:0x014f, B:65:0x0166, B:67:0x016a, B:69:0x0170, B:70:0x0174, B:72:0x017a, B:74:0x0186, B:76:0x018e, B:78:0x0193, B:108:0x020a, B:110:0x021a, B:111:0x021c, B:87:0x01b5, B:88:0x01bf, B:89:0x01ca, B:92:0x01d9, B:113:0x023a, B:115:0x023f, B:122:0x024b, B:63:0x0160), top: B:166:0x0091 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01ec  */
    public t6.c d(b bVar, long j8, long j10, String str, int i8, int i9) throws Throwable {
        Cursor cursor;
        Object obj;
        Cursor cursor2;
        String str2;
        int i10;
        int i11;
        String str3;
        String str4;
        ArrayList arrayList;
        int iIntValue;
        Object objRemove;
        int length;
        String str5 = "_eparam";
        String str6 = "net";
        String str7 = NotificationCompat.CATEGORY_EVENT;
        ArrayList arrayList2 = ((s6.e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a).f9568l;
        Cursor cursor3 = null;
        if (dd.g(arrayList2)) {
            return null;
        }
        String strA = bVar.a();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return null;
                }
                if (TextUtils.isEmpty(str)) {
                    try {
                        str2 = "SELECT * FROM " + strA + " WHERE tid=" + j8 + " AND created_at<=" + j10 + " ORDER BY _id LIMIT " + i9;
                    } catch (SQLiteException e) {
                        e = e;
                        cursor3 = null;
                    } catch (Exception e4) {
                        e = e4;
                        z6.a.c(Log.getStackTraceString(e));
                        throw new e8.d("queryEventList", e);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor3 = null;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } else {
                    try {
                        str2 = "SELECT * FROM " + strA + " WHERE tid=" + j8 + " AND uid='" + str + "' ORDER BY _id";
                    } catch (SQLiteException e10) {
                        e = e10;
                        cursor2 = null;
                        cursor3 = cursor2;
                        z6.a.c(Log.getStackTraceString(e));
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        f(e);
                        throw new e8.d("queryEventList_sql", e);
                    } catch (Exception e11) {
                        e = e11;
                        obj = null;
                        z6.a.c(Log.getStackTraceString(e));
                        throw new e8.d("queryEventList", e);
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        cursor3 = cursor;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                }
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery(str2, null);
                    if (cursorRawQuery != null) {
                        try {
                            try {
                                if (cursorRawQuery.getCount() != 0) {
                                    int count = cursorRawQuery.getCount();
                                    ArrayList arrayList3 = new ArrayList();
                                    String str8 = "";
                                    String str9 = "";
                                    int i12 = 0;
                                    long j11 = 0;
                                    int i13 = 0;
                                    int i14 = 0;
                                    long j12 = 0;
                                    while (true) {
                                        if (!cursorRawQuery.moveToNext()) {
                                            i10 = i13;
                                            i11 = i14;
                                            str3 = str9;
                                            break;
                                        }
                                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str7));
                                        long j13 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("created_at"));
                                        int i15 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("pi"));
                                        int i16 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("et"));
                                        if (i15 != -1) {
                                            string = nc.f(string, (byte[]) arrayList2.get(i15));
                                        }
                                        if (j11 == 0) {
                                            j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                        }
                                        if (string != null) {
                                            if (i16 != 0) {
                                                string = string.replace("&add", str8).replace("&append", str8);
                                            }
                                            try {
                                                JSONObject jSONObject = new JSONObject(string);
                                                String str10 = (String) jSONObject.remove(str7);
                                                try {
                                                    if (jSONObject.has(str6)) {
                                                        try {
                                                            iIntValue = ((Integer) jSONObject.remove(str6)).intValue();
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            str9 = str10;
                                                            str6 = str6;
                                                            str4 = str7;
                                                            str8 = str8;
                                                            arrayList = arrayList2;
                                                            e.printStackTrace();
                                                            i12++;
                                                            str8 = str8;
                                                            j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                            str6 = str6;
                                                            str5 = str5;
                                                            str7 = str4;
                                                            arrayList2 = arrayList;
                                                        }
                                                    } else {
                                                        iIntValue = 0;
                                                    }
                                                    try {
                                                        if (jSONObject.has(str5)) {
                                                            try {
                                                                objRemove = jSONObject.remove(str5);
                                                            } catch (Exception e13) {
                                                                e = e13;
                                                                str9 = str10;
                                                                str4 = str7;
                                                                str8 = str8;
                                                                arrayList = arrayList2;
                                                                e.printStackTrace();
                                                                i12++;
                                                            }
                                                        } else {
                                                            objRemove = new JSONObject();
                                                        }
                                                        str5 = str5;
                                                        str4 = str7;
                                                        Object obj2 = objRemove;
                                                        try {
                                                            if (obj2 instanceof JSONObject) {
                                                                try {
                                                                    if (jSONObject.length() > 0) {
                                                                        Iterator<String> itKeys = jSONObject.keys();
                                                                        while (itKeys.hasNext()) {
                                                                            itKeys = itKeys;
                                                                            String next = itKeys.next();
                                                                            str8 = str8;
                                                                            try {
                                                                                if (next.startsWith("_")) {
                                                                                    arrayList = arrayList2;
                                                                                    try {
                                                                                        ((JSONObject) obj2).put(next, jSONObject.get(next));
                                                                                        arrayList2 = arrayList;
                                                                                    } catch (Exception e14) {
                                                                                        e = e14;
                                                                                        str9 = str10;
                                                                                        e.printStackTrace();
                                                                                        i12++;
                                                                                        str8 = str8;
                                                                                        j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                                        str6 = str6;
                                                                                        str5 = str5;
                                                                                        str7 = str4;
                                                                                        arrayList2 = arrayList;
                                                                                    }
                                                                                }
                                                                            } catch (Exception e15) {
                                                                                e = e15;
                                                                                arrayList = arrayList2;
                                                                                str9 = str10;
                                                                                e.printStackTrace();
                                                                                i12++;
                                                                                str8 = str8;
                                                                                j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                                str6 = str6;
                                                                                str5 = str5;
                                                                                str7 = str4;
                                                                                arrayList2 = arrayList;
                                                                            }
                                                                        }
                                                                        str8 = str8;
                                                                        arrayList = arrayList2;
                                                                        String string2 = obj2.toString();
                                                                        try {
                                                                            t6.b bVar2 = new t6.b();
                                                                            bVar2.f10174a = str10;
                                                                            bVar2.f10175b = j13;
                                                                            bVar2.f10177d = iIntValue;
                                                                            bVar2.f10176c = string2;
                                                                            arrayList3.add(bVar2);
                                                                            i13++;
                                                                            length = i14 + string.length();
                                                                            if (length >= i8) {
                                                                                try {
                                                                                    i11 = length;
                                                                                    j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                                    i10 = i13;
                                                                                    str3 = str10;
                                                                                    break;
                                                                                } catch (Exception e16) {
                                                                                    e = e16;
                                                                                    i14 = length;
                                                                                    str9 = str10;
                                                                                    e.printStackTrace();
                                                                                    i12++;
                                                                                    str8 = str8;
                                                                                    j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                                    str6 = str6;
                                                                                    str5 = str5;
                                                                                    str7 = str4;
                                                                                    arrayList2 = arrayList;
                                                                                }
                                                                            } else {
                                                                                i14 = length;
                                                                                str9 = str10;
                                                                            }
                                                                        } catch (Exception e17) {
                                                                            e = e17;
                                                                            str9 = str10;
                                                                            e.printStackTrace();
                                                                            i12++;
                                                                            str8 = str8;
                                                                            j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                            str6 = str6;
                                                                            str5 = str5;
                                                                            str7 = str4;
                                                                            arrayList2 = arrayList;
                                                                        }
                                                                    } else {
                                                                        str8 = str8;
                                                                        arrayList = arrayList2;
                                                                        String string3 = obj2.toString();
                                                                        t6.b bVar3 = new t6.b();
                                                                        bVar3.f10174a = str10;
                                                                        bVar3.f10175b = j13;
                                                                        bVar3.f10177d = iIntValue;
                                                                        bVar3.f10176c = string3;
                                                                        arrayList3.add(bVar3);
                                                                        i13++;
                                                                        length = i14 + string.length();
                                                                        if (length >= i8) {
                                                                            i11 = length;
                                                                            j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                            i10 = i13;
                                                                            str3 = str10;
                                                                            break;
                                                                        }
                                                                        i14 = length;
                                                                        str9 = str10;
                                                                    }
                                                                } catch (Exception e18) {
                                                                    e = e18;
                                                                    str8 = str8;
                                                                    arrayList = arrayList2;
                                                                    str9 = str10;
                                                                    e.printStackTrace();
                                                                    i12++;
                                                                    str8 = str8;
                                                                    j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                    str6 = str6;
                                                                    str5 = str5;
                                                                    str7 = str4;
                                                                    arrayList2 = arrayList;
                                                                }
                                                            } else {
                                                                str8 = str8;
                                                                arrayList = arrayList2;
                                                                String string4 = obj2.toString();
                                                                t6.b bVar4 = new t6.b();
                                                                bVar4.f10174a = str10;
                                                                bVar4.f10175b = j13;
                                                                bVar4.f10177d = iIntValue;
                                                                bVar4.f10176c = string4;
                                                                arrayList3.add(bVar4);
                                                                i13++;
                                                                length = i14 + string.length();
                                                                if (length >= i8) {
                                                                    i11 = length;
                                                                    j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                    i10 = i13;
                                                                    str3 = str10;
                                                                    break;
                                                                }
                                                                i14 = length;
                                                                str9 = str10;
                                                            }
                                                        } catch (Exception e19) {
                                                            e = e19;
                                                            str8 = str8;
                                                            arrayList = arrayList2;
                                                        }
                                                    } catch (Exception e20) {
                                                        e = e20;
                                                        str4 = str7;
                                                        str8 = str8;
                                                        arrayList = arrayList2;
                                                        str9 = str10;
                                                        e.printStackTrace();
                                                        i12++;
                                                        str8 = str8;
                                                        j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                        str6 = str6;
                                                        str5 = str5;
                                                        str7 = str4;
                                                        arrayList2 = arrayList;
                                                    }
                                                } catch (Exception e21) {
                                                    e = e21;
                                                    str6 = str6;
                                                }
                                            } catch (Exception e22) {
                                                e = e22;
                                            }
                                            str8 = str8;
                                            j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                            str6 = str6;
                                            str5 = str5;
                                            str7 = str4;
                                            arrayList2 = arrayList;
                                        } else {
                                            str5 = str5;
                                            str6 = str6;
                                            str4 = str7;
                                            str8 = str8;
                                            arrayList = arrayList2;
                                        }
                                        i12++;
                                        str8 = str8;
                                        j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                        str6 = str6;
                                        str5 = str5;
                                        str7 = str4;
                                        arrayList2 = arrayList;
                                    }
                                    cursorRawQuery.close();
                                    if (i10 <= 0) {
                                        cursorRawQuery.close();
                                        return null;
                                    }
                                    int i17 = i12 + i10;
                                    t6.c cVar = new t6.c(j8, str3, arrayList3, j11, j12, i10, i11, count <= i17 && !(count == i9 && count == i17));
                                    cursorRawQuery.close();
                                    return cVar;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                cursor3 = cursorRawQuery;
                                if (cursor3 != null) {
                                    cursor3.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e23) {
                            e = e23;
                            cursor3 = cursorRawQuery;
                        } catch (Exception e24) {
                            e = e24;
                            z6.a.c(Log.getStackTraceString(e));
                            throw new e8.d("queryEventList", e);
                        }
                    }
                    if (cursorRawQuery == null) {
                        return null;
                    }
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e25) {
                    e = e25;
                    cursor2 = null;
                    cursor3 = cursor2;
                } catch (Exception e26) {
                    e = e26;
                    obj = null;
                    z6.a.c(Log.getStackTraceString(e));
                    throw new e8.d("queryEventList", e);
                } catch (Throwable th5) {
                    th = th5;
                    cursor = null;
                    cursor3 = cursor;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (SQLiteException e27) {
            e = e27;
        } catch (Exception e28) {
            e = e28;
        } catch (Throwable th7) {
            th = th7;
        }
        z6.a.c(Log.getStackTraceString(e));
        if (cursor3 != null) {
            cursor3.close();
        }
        f(e);
        throw new e8.d("queryEventList_sql", e);
    }

    @Override // k2.b
    public Object execute() {
        h hVar = (h) ((i) this.f10388c).f5551c;
        hVar.getClass();
        return (Iterable) hVar.g(new i1.b(hVar, (d2.d) this.f10387b));
    }

    public void f(SQLiteException sQLiteException) {
        try {
            boolean z2 = sQLiteException instanceof SQLiteFullException;
            d dVar = (d) this.f10388c;
            if (z2) {
                dVar.close();
            } else {
                dVar.close();
                dVar.close();
                if (dVar.f10397a.delete()) {
                    z6.a.a("mDatabaseFile deleted");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g(e0.b bVar) throws Throwable {
        s6.c cVarA;
        SparseArray sparseArray = new SparseArray();
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return;
                }
                Cursor cursorRawQuery2 = sQLiteDatabaseS.rawQuery("SELECT * FROM " + b.f10384d.a(), null);
                while (cursorRawQuery2 != null) {
                    try {
                        if (!cursorRawQuery2.moveToNext()) {
                            break;
                        }
                        String string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("cfg"));
                        if (!TextUtils.isEmpty(string) && (cVarA = s6.c.a(string)) != null) {
                            int i8 = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex("appid"));
                            cVarA.f9529a = i8;
                            sparseArray.put(i8, cVarA);
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        cursorRawQuery = cursorRawQuery2;
                    } catch (Throwable th2) {
                        th = th2;
                        cursorRawQuery = cursorRawQuery2;
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery2 != null) {
                    cursorRawQuery2.close();
                }
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT * FROM " + b.f10383c.a(), null);
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    long j8 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("tid"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ev"));
                    s6.b bVar2 = new s6.b();
                    bVar2.f9523i = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pt"));
                    bVar2.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("cf")));
                    s6.c cVar = (s6.c) sparseArray.get(z6.b.a(j8));
                    if (cVar != null) {
                        s6.a aVar = new s6.a();
                        aVar.f9513a = j8;
                        aVar.f9514b = string2;
                        aVar.f9515c = bVar2;
                        cVar.f.add(aVar);
                    }
                }
                bVar.e(sparseArray);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLiteException e4) {
            e = e4;
        }
        z6.a.c(Log.getStackTraceString(e));
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        f(e);
        throw new e8.d("getAPPIDApp_sql", e);
    }

    public void h(b bVar, AppIdData appIdData) throws e8.d {
        String strA = bVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("appid", Integer.valueOf(appIdData.f2313a));
            contentValues.put("base", appIdData.f2314b);
            if (sQLiteDatabaseS.update(strA, contentValues, "appid=" + appIdData.f2313a, null) != 1) {
                sQLiteDatabaseS.insert(strA, null, contentValues);
            }
        } catch (SQLiteException e) {
            z6.a.c(Log.getStackTraceString(e));
            f(e);
            throw new e8.d("addAppId_sql", e);
        }
    }

    public void i(b bVar, String str, long j8) throws e8.d {
        String strA = bVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            sQLiteDatabaseS.execSQL("UPDATE " + strA + " SET created_at = er_ts + " + j8 + ", boot_id = '' WHERE boot_id = '" + str + "'");
        } catch (SQLiteException e) {
            z6.a.c(Log.getStackTraceString(e));
            f(e);
            throw new e8.d("updateEvents_sql", e);
        }
    }

    public void j(b bVar, ArrayList arrayList, e0.b bVar2) throws Throwable {
        String strA = bVar.a();
        String strB = dd.b(",", arrayList);
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return;
                }
                LongSparseArray longSparseArray = new LongSparseArray();
                Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT tid FROM " + strA + " WHERE tid IN (" + strB + ")", null);
                while (cursorRawQuery != null) {
                    try {
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        }
                        long j8 = cursorRawQuery.getLong(0);
                        longSparseArray.put(j8, Integer.valueOf(((Integer) longSparseArray.get(j8, 0)).intValue() + 1));
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = cursorRawQuery;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabaseS.delete(strA, "tid IN (" + strB + ")", null);
                if (longSparseArray.size() > 0) {
                    bVar2.e(longSparseArray.toString());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLiteException e4) {
            e = e4;
        }
        z6.a.c(Log.getStackTraceString(e));
        if (cursor != null) {
            cursor.close();
        }
        f(e);
        throw new e8.d("cleanupEvents_off_sql", e);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0081: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:16:0x0081 */
    public void k(b bVar, LinkedList linkedList, String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseS;
        SQLiteDatabase sQLiteDatabase;
        String strA = bVar.a();
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                try {
                    sQLiteDatabaseS = s();
                    if (sQLiteDatabaseS == null) {
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                            return;
                        }
                        return;
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", str);
                        sQLiteDatabaseS.beginTransaction();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            AppIdData appIdData = (AppIdData) it.next();
                            for (t6.c cVar : appIdData.e) {
                                sQLiteDatabaseS.update(strA, contentValues, "tid=" + cVar.f10178a + " AND _id>=" + cVar.f10181d + " AND _id<=" + cVar.e, null);
                            }
                            dd.e(sb2, Integer.valueOf(appIdData.f2313a));
                        }
                        contentValues.put("try", (Integer) 0);
                        sQLiteDatabaseS.update(b.f10384d.a(), contentValues, "appid IN (" + sb2.toString() + ")", null);
                        sQLiteDatabaseS.setTransactionSuccessful();
                        sQLiteDatabaseS.endTransaction();
                    } catch (SQLiteException e) {
                        e = e;
                        z6.a.c(Log.getStackTraceString(e));
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        }
                        f(e);
                        throw new e8.d("updateEvents_sql", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase2 = sQLiteDatabase;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                sQLiteDatabaseS = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b6  */
    public void l(b bVar, List list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseS;
        String strA = bVar.a();
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    if (sQLiteDatabaseS != null) {
                        sQLiteDatabaseS.endTransaction();
                        return;
                    }
                    return;
                }
                try {
                    try {
                        sQLiteDatabaseS.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", "");
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            AppIdData appIdData = (AppIdData) it.next();
                            sQLiteDatabaseS.update(b.f10381a.a(), contentValues, "CAST(tid AS TEXT) LIKE ? AND uid=?", new String[]{appIdData.f2313a + "%", appIdData.f2315c});
                            dd.e(sb2, Integer.valueOf(appIdData.f2313a));
                        }
                        contentValues.put("try", (Integer) 0);
                        sQLiteDatabaseS.update(strA, contentValues, "appid IN (" + sb2.toString() + ")", null);
                        sQLiteDatabaseS.setTransactionSuccessful();
                        sQLiteDatabaseS.endTransaction();
                    } catch (SQLiteException e) {
                        e = e;
                        z6.a.c(Log.getStackTraceString(e));
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        } else {
                            sQLiteDatabase = sQLiteDatabaseS;
                        }
                        f(e);
                        throw new e8.d("updateAppIdList_sql", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = sQLiteDatabaseS;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                sQLiteDatabaseS = null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    public void m(b bVar, List list, int i8) throws e8.d {
        String strA = bVar.a();
        StringBuilder sb2 = new StringBuilder();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AppIdData appIdData = (AppIdData) it.next();
                dd.e(sb2, Integer.valueOf(appIdData.f2313a));
                appIdData.f2316d = i8;
            }
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("try", Integer.valueOf(i8));
            sQLiteDatabaseS.update(strA, contentValues, "appid IN (" + sb2.toString() + ")", null);
        } catch (SQLiteException e) {
            z6.a.c(Log.getStackTraceString(e));
            f(e);
            throw new e8.d("updateEvents_sql", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x0273 A[Catch: all -> 0x00c4, TryCatch #2 {all -> 0x00c4, blocks: (B:22:0x0086, B:24:0x008c, B:31:0x00a1, B:33:0x00bf, B:43:0x00d3, B:39:0x00ca, B:45:0x00e6, B:116:0x026a, B:118:0x0273, B:120:0x0278), top: B:134:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0278 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #2 {all -> 0x00c4, blocks: (B:22:0x0086, B:24:0x008c, B:31:0x00a1, B:33:0x00bf, B:43:0x00d3, B:39:0x00ca, B:45:0x00e6, B:116:0x026a, B:118:0x0273, B:120:0x0278), top: B:134:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x027f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0293  */
    /* JADX WARN: Code duplicated, block: B:130:0x0298  */
    public void n(b bVar, List list, long j8, String str, e0.b bVar2) throws Throwable {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabaseS;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabase;
        String str2;
        Cursor cursor2;
        String str3;
        int i8;
        String str4 = "_id";
        String str5 = " AND ";
        String strA = bVar.a();
        StringBuilder sb2 = new StringBuilder();
        SparseArray sparseArray = new SparseArray();
        Cursor cursor3 = null;
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    dd.e(sb2, Integer.valueOf(((AppIdData) it.next()).f2313a));
                } catch (SQLiteException e) {
                    e = e;
                    sQLiteDatabaseS = null;
                    cursorRawQuery = null;
                    cursor = null;
                    z6.a.c(Log.getStackTraceString(e));
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    if (sQLiteDatabaseS != null) {
                        sQLiteDatabaseS.endTransaction();
                        sQLiteDatabase = cursor;
                    } else {
                        sQLiteDatabase = sQLiteDatabaseS;
                    }
                    try {
                        f(e);
                        throw new e8.d("cleanupEvents_sql", e);
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabaseS = sQLiteDatabase;
                        cursor3 = cursorRawQuery;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabaseS = null;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    if (sQLiteDatabaseS != null) {
                        sQLiteDatabaseS.endTransaction();
                    }
                    throw th;
                }
            }
            sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                if (sQLiteDatabaseS != null) {
                    sQLiteDatabaseS.endTransaction();
                    return;
                }
                return;
            }
            try {
                sQLiteDatabaseS.beginTransaction();
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT * FROM " + b.f10384d.a() + " WHERE appid IN (" + ((Object) sb2) + ")", null);
                while (true) {
                    str2 = "ext";
                    if (cursorRawQuery == null) {
                        break;
                    }
                    try {
                        try {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            int i9 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("appid"));
                            if (i9 != 9999 && i9 != 1031 && i9 != 1041) {
                                int i10 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("cnt"));
                                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("date"));
                                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ext"));
                                if (TextUtils.isEmpty(string2)) {
                                    i8 = 0;
                                } else {
                                    try {
                                        i8 = Integer.parseInt(string2);
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                        i8 = 0;
                                    }
                                }
                                t6.e eVar = new t6.e();
                                eVar.f10186a = i9;
                                eVar.f10187b = string;
                                eVar.f10188c = i10;
                                eVar.f10189d = i8;
                                sparseArray.put(i9, eVar);
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cursor3 = cursorRawQuery;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (sQLiteDatabaseS != null) {
                                sQLiteDatabaseS.endTransaction();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e10) {
                        e = e10;
                        cursor = null;
                        z6.a.c(Log.getStackTraceString(e));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                            sQLiteDatabase = cursor;
                        } else {
                            sQLiteDatabase = sQLiteDatabaseS;
                        }
                        f(e);
                        throw new e8.d("cleanupEvents_sql", e);
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                try {
                    try {
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            AppIdData appIdData = (AppIdData) it2.next();
                            try {
                                int i11 = 0;
                                for (t6.c cVar : appIdData.e) {
                                    try {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("tid=");
                                        cursor2 = cursorRawQuery;
                                        String str6 = str2;
                                        try {
                                            try {
                                                sb3.append(cVar.f10178a);
                                                sb3.append(str5);
                                                sb3.append(str4);
                                                sb3.append(">=");
                                                sb3.append(cVar.f10181d);
                                                sb3.append(str5);
                                                sb3.append(str4);
                                                sb3.append("<=");
                                                sb3.append(cVar.e);
                                                sQLiteDatabaseS.delete(strA, sb3.toString(), null);
                                                if (cVar.f10183h) {
                                                    ContentValues contentValues = new ContentValues();
                                                    contentValues.put("pt", Long.valueOf(j8));
                                                    sQLiteDatabaseS.update(b.f10383c.a(), contentValues, "tid=" + cVar.f10178a, null);
                                                }
                                                i11 += cVar.f;
                                                cursorRawQuery = cursor2;
                                                str2 = str6;
                                                str4 = str4;
                                                str5 = str5;
                                                cursor3 = null;
                                            } catch (SQLiteException e11) {
                                                e = e11;
                                                cursorRawQuery = cursor2;
                                                cursor = null;
                                                z6.a.c(Log.getStackTraceString(e));
                                                if (cursorRawQuery != null) {
                                                    cursorRawQuery.close();
                                                }
                                                if (sQLiteDatabaseS != null) {
                                                    sQLiteDatabaseS.endTransaction();
                                                    sQLiteDatabase = cursor;
                                                } else {
                                                    sQLiteDatabase = sQLiteDatabaseS;
                                                }
                                                f(e);
                                                throw new e8.d("cleanupEvents_sql", e);
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            cursor3 = cursor2;
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                            if (sQLiteDatabaseS != null) {
                                                sQLiteDatabaseS.endTransaction();
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                    }
                                }
                                String str7 = str4;
                                String str8 = str5;
                                cursor2 = cursorRawQuery;
                                String str9 = str2;
                                try {
                                    ContentValues contentValues2 = new ContentValues();
                                    t6.e eVar2 = (t6.e) sparseArray.get(appIdData.f2313a);
                                    if (eVar2 != null) {
                                        String str10 = eVar2.f10187b;
                                        if (str10 == null || str10.equals(str)) {
                                            sparseArray.remove(appIdData.f2313a);
                                        }
                                        String str11 = eVar2.f10187b;
                                        if (str11 == null || !str11.equals(str)) {
                                            str3 = str9;
                                            contentValues2.put("date", str);
                                            contentValues2.put("cnt", Integer.valueOf(i11));
                                            contentValues2.put(str3, "1");
                                        } else {
                                            contentValues2.put("cnt", Integer.valueOf(eVar2.f10188c + i11));
                                            str3 = str9;
                                            contentValues2.put(str3, String.valueOf(eVar2.f10189d + 1));
                                        }
                                    } else {
                                        str3 = str9;
                                    }
                                    contentValues2.put("uid", "");
                                    contentValues2.put("try", (Integer) 0);
                                    cursor = null;
                                    try {
                                        sQLiteDatabaseS.update(b.f10384d.a(), contentValues2, "appid=" + appIdData.f2313a, null);
                                        str2 = str3;
                                        cursor3 = null;
                                        cursorRawQuery = cursor2;
                                        str4 = str7;
                                        str5 = str8;
                                    } catch (SQLiteException e13) {
                                        e = e13;
                                        cursorRawQuery = cursor2;
                                        z6.a.c(Log.getStackTraceString(e));
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                        if (sQLiteDatabaseS != null) {
                                            sQLiteDatabaseS.endTransaction();
                                            sQLiteDatabase = cursor;
                                        } else {
                                            sQLiteDatabase = sQLiteDatabaseS;
                                        }
                                        f(e);
                                        throw new e8.d("cleanupEvents_sql", e);
                                    }
                                } catch (SQLiteException e14) {
                                    e = e14;
                                    cursor = null;
                                    cursorRawQuery = cursor2;
                                    z6.a.c(Log.getStackTraceString(e));
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseS != null) {
                                        sQLiteDatabaseS.endTransaction();
                                        sQLiteDatabase = cursor;
                                    } else {
                                        sQLiteDatabase = sQLiteDatabaseS;
                                    }
                                    f(e);
                                    throw new e8.d("cleanupEvents_sql", e);
                                }
                            } catch (SQLiteException e15) {
                                e = e15;
                                cursor = cursor3;
                                cursor2 = cursorRawQuery;
                            }
                        }
                        cursor = cursor3;
                        cursor2 = cursorRawQuery;
                        sQLiteDatabaseS.setTransactionSuccessful();
                        bVar2.e(sparseArray);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        sQLiteDatabaseS.endTransaction();
                    } catch (SQLiteException e16) {
                        e = e16;
                        cursor = cursor3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    cursor2 = cursorRawQuery;
                }
            } catch (SQLiteException e17) {
                e = e17;
                cursor = null;
                cursorRawQuery = null;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (SQLiteException e18) {
            e = e18;
            cursor = null;
            sQLiteDatabaseS = null;
            cursorRawQuery = null;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0180  */
    /* JADX WARN: Code duplicated, block: B:70:0x0185  */
    public void o(b bVar, s6.c cVar, boolean z2) throws Throwable {
        SQLiteDatabase sQLiteDatabaseS;
        Cursor cursor;
        Cursor cursorRawQuery;
        String strA = bVar.a();
        Cursor cursor2 = null;
        cursor2 = null;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                if (sQLiteDatabaseS != null) {
                    sQLiteDatabaseS.endTransaction();
                    return;
                }
                return;
            }
            try {
                sQLiteDatabaseS.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("cfg", cVar.d());
                sQLiteDatabaseS.update(strA, contentValues, "appid=" + cVar.f9529a, null);
                if (z2) {
                    sQLiteDatabaseS.delete(b.f10383c.a(), "CAST(tid AS TEXT) LIKE ?", new String[]{cVar.f9529a + "%"});
                    CopyOnWriteArrayList<s6.a> copyOnWriteArrayList = cVar.f;
                    HashMap map = new HashMap();
                    for (s6.a aVar : copyOnWriteArrayList) {
                        s6.b bVar2 = aVar.f9515c;
                        contentValues.clear();
                        contentValues.put("tid", Long.valueOf(aVar.f9513a));
                        contentValues.put("ev", aVar.f9514b);
                        contentValues.put("pt", Long.valueOf(bVar2.f9523i));
                        contentValues.put("cf", bVar2.c());
                        sQLiteDatabaseS.insert(b.f10383c.a(), null, contentValues);
                        String str = aVar.f9514b;
                        if (str != null) {
                            map.put(str, Long.valueOf(aVar.f9513a));
                        }
                    }
                    cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT DISTINCT ext FROM " + b.f10381a.a() + " WHERE tid=" + cVar.f9529a, null);
                    while (cursorRawQuery != null) {
                        try {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ext"));
                            if (map.containsKey(string)) {
                                contentValues.clear();
                                contentValues.put("tid", (Long) map.get(string));
                                sQLiteDatabaseS.update(b.f10381a.a(), contentValues, "tid=" + cVar.f9529a + " AND ext=?", new String[]{string});
                            }
                        } catch (SQLiteException e) {
                            cursor = cursorRawQuery;
                            e = e;
                            try {
                                z6.a.c(Log.getStackTraceString(e));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseS != null) {
                                    sQLiteDatabaseS.endTransaction();
                                } else {
                                    sQLiteDatabase = sQLiteDatabaseS;
                                }
                                try {
                                    f(e);
                                    throw new e8.d("updateAppConfig_sql", e);
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabaseS = sQLiteDatabase;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseS != null) {
                                        sQLiteDatabaseS.endTransaction();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cursor2 = cursorRawQuery;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabaseS != null) {
                                sQLiteDatabaseS.endTransaction();
                            }
                            throw th;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else {
                    cursorRawQuery = null;
                }
                sQLiteDatabaseS.setTransactionSuccessful();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabaseS.endTransaction();
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (SQLiteException e10) {
            e = e10;
            cursor = null;
            sQLiteDatabaseS = null;
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabaseS = null;
        }
    }

    public boolean p(b bVar, int i8) throws e8.d {
        String strA = bVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return false;
            }
            sQLiteDatabaseS.delete(strA, "CAST(tid AS TEXT) LIKE ?", new String[]{i8 + "%"});
            return true;
        } catch (SQLiteException e) {
            z6.a.c(Log.getStackTraceString(e));
            f(e);
            throw new e8.d("cleanupEvents_del_sql", e);
        }
    }

    public void q(Object obj, String str) {
        ((ArrayList) this.f10388c).add(str + "=" + String.valueOf(obj));
    }

    /* JADX WARN: Code duplicated, block: B:117:0x01a1 A[Catch: all -> 0x0176, TryCatch #19 {all -> 0x0176, blocks: (B:111:0x0185, B:112:0x0193, B:115:0x0198, B:117:0x01a1, B:119:0x01a6, B:94:0x0160), top: B:136:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x01a6 A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #19 {all -> 0x0176, blocks: (B:111:0x0185, B:112:0x0193, B:115:0x0198, B:117:0x01a1, B:119:0x01a6, B:94:0x0160), top: B:136:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:127:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:129:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c8  */
    public int r(b bVar, ArrayList arrayList, a4.b bVar2) throws Throwable {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabaseS;
        SQLiteDatabase sQLiteDatabase;
        d dVar = (d) this.f10388c;
        String strA = bVar.a();
        HashSet hashSet = new HashSet();
        try {
            try {
                sQLiteDatabaseS = s();
                int i8 = 0;
                if (sQLiteDatabaseS == null) {
                    if (sQLiteDatabaseS != null) {
                        sQLiteDatabaseS.endTransaction();
                    }
                    if (dVar.a()) {
                        z6.a.c("There is not enough space left");
                    }
                    return 0;
                }
                try {
                    sQLiteDatabaseS.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            t6.a aVar = (t6.a) it.next();
                            JSONObject jSONObject = aVar.f10168b;
                            Pair pairI = m6.a.f().f7948a.i();
                            Integer num = (Integer) pairI.first;
                            num.getClass();
                            String strB = nc.b(jSONObject.toString(), (byte[]) pairI.second);
                            if (strB != null) {
                                contentValues.clear();
                                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabaseS;
                                try {
                                    try {
                                        contentValues.put("tid", Long.valueOf(aVar.f10170d));
                                        contentValues.put(NotificationCompat.CATEGORY_EVENT, strB);
                                        contentValues.put("et", (Integer) 0);
                                        contentValues.put("pi", num);
                                        contentValues.put("created_at", Long.valueOf(aVar.f));
                                        if (aVar.f10172h != null) {
                                            contentValues.put("er_ts", Long.valueOf(aVar.f10171g));
                                            contentValues.put("boot_id", aVar.f10172h);
                                        }
                                        sQLiteDatabaseS = sQLiteDatabase2;
                                        if (sQLiteDatabaseS.insert(strA, null, contentValues) > 0) {
                                            hashSet.add(Long.valueOf(aVar.f10170d));
                                        } else {
                                            continue;
                                        }
                                    } catch (SQLiteException e) {
                                        e = e;
                                        sQLiteDatabaseS = sQLiteDatabase2;
                                        sQLiteDatabase = null;
                                        cursor = null;
                                        z6.a.c(Log.getStackTraceString(e));
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabaseS != null) {
                                            sQLiteDatabaseS.endTransaction();
                                        } else {
                                            sQLiteDatabase = sQLiteDatabaseS;
                                        }
                                        try {
                                            f(e);
                                            throw new e8.d("addJSON_sql", e);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            sQLiteDatabaseS = sQLiteDatabase;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabaseS != null) {
                                                sQLiteDatabaseS.endTransaction();
                                            }
                                            if (dVar.a()) {
                                                z6.a.c("There is not enough space left");
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        z6.a.c(Log.getStackTraceString(e));
                                        throw new e8.d("addJSON", e);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteDatabaseS = sQLiteDatabase2;
                                        cursor = null;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabaseS != null) {
                                            sQLiteDatabaseS.endTransaction();
                                        }
                                        if (dVar.a()) {
                                            z6.a.c("There is not enough space left");
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteException e10) {
                                    e = e10;
                                } catch (Exception e11) {
                                    e = e11;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                        } catch (SQLiteException e12) {
                            e = e12;
                        } catch (Exception e13) {
                            e = e13;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    if (hashSet.size() > 0) {
                        LongSparseArray longSparseArray = new LongSparseArray();
                        sQLiteDatabase = null;
                        try {
                            Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT tid,COUNT(*) FROM " + strA + " WHERE tid IN (" + dd.b(",", hashSet) + ") GROUP BY tid", null);
                            int i9 = 0;
                            while (cursorRawQuery != null) {
                                try {
                                    if (!cursorRawQuery.moveToNext()) {
                                        break;
                                    }
                                    longSparseArray.put(cursorRawQuery.getLong(0), Integer.valueOf(cursorRawQuery.getInt(1)));
                                    i9++;
                                } catch (SQLiteException e14) {
                                    e = e14;
                                    cursor = cursorRawQuery;
                                    z6.a.c(Log.getStackTraceString(e));
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabaseS != null) {
                                        sQLiteDatabaseS.endTransaction();
                                    } else {
                                        sQLiteDatabase = sQLiteDatabaseS;
                                    }
                                    f(e);
                                    throw new e8.d("addJSON_sql", e);
                                } catch (Exception e15) {
                                    e = e15;
                                    z6.a.c(Log.getStackTraceString(e));
                                    throw new e8.d("addJSON", e);
                                } catch (Throwable th6) {
                                    th = th6;
                                    cursor = cursorRawQuery;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabaseS != null) {
                                        sQLiteDatabaseS.endTransaction();
                                    }
                                    if (dVar.a()) {
                                        z6.a.c("There is not enough space left");
                                    }
                                    throw th;
                                }
                            }
                            if (longSparseArray.size() > 0) {
                                bVar2.e(longSparseArray);
                            }
                            i8 = i9;
                            cursor = cursorRawQuery;
                        } catch (SQLiteException e16) {
                            e = e16;
                            cursor = sQLiteDatabase;
                            z6.a.c(Log.getStackTraceString(e));
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabaseS != null) {
                                sQLiteDatabaseS.endTransaction();
                            } else {
                                sQLiteDatabase = sQLiteDatabaseS;
                            }
                            f(e);
                            throw new e8.d("addJSON_sql", e);
                        } catch (Exception e17) {
                            e = e17;
                            z6.a.c(Log.getStackTraceString(e));
                            throw new e8.d("addJSON", e);
                        } catch (Throwable th7) {
                            th = th7;
                            cursor = sQLiteDatabase;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabaseS != null) {
                                sQLiteDatabaseS.endTransaction();
                            }
                            if (dVar.a()) {
                                z6.a.c("There is not enough space left");
                            }
                            throw th;
                        }
                    } else {
                        sQLiteDatabase = null;
                        cursor = null;
                    }
                    try {
                        sQLiteDatabaseS.setTransactionSuccessful();
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabaseS.endTransaction();
                        if (!dVar.a()) {
                            return i8;
                        }
                        z6.a.c("There is not enough space left");
                        return -2;
                    } catch (SQLiteException e18) {
                        e = e18;
                        z6.a.c(Log.getStackTraceString(e));
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        } else {
                            sQLiteDatabase = sQLiteDatabaseS;
                        }
                        f(e);
                        throw new e8.d("addJSON_sql", e);
                    } catch (Exception e19) {
                        e = e19;
                        z6.a.c(Log.getStackTraceString(e));
                        throw new e8.d("addJSON", e);
                    }
                } catch (SQLiteException e20) {
                    e = e20;
                    sQLiteDatabase = null;
                } catch (Exception e21) {
                    e = e21;
                    sQLiteDatabase = null;
                } catch (Throwable th8) {
                    th = th8;
                    sQLiteDatabase = null;
                }
            } catch (Throwable th9) {
                th = th9;
            }
        } catch (SQLiteException e22) {
            e = e22;
            sQLiteDatabase = null;
            cursor = null;
            sQLiteDatabaseS = null;
        } catch (Exception e23) {
            e = e23;
        } catch (Throwable th10) {
            th = th10;
            cursor = null;
            sQLiteDatabaseS = null;
        }
    }

    public SQLiteDatabase s() {
        try {
            boolean zExists = ((Context) this.f10387b).getDatabasePath("athena.db").exists();
            d dVar = (d) this.f10388c;
            if (!zExists) {
                dVar.close();
            }
            return dVar.getWritableDatabase();
        } catch (SQLiteException e) {
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }

    public void t() {
        ((u2) this.f10388c).f11446b = true;
        ((ScheduledFuture) this.f10387b).cancel(false);
    }

    public String toString() {
        switch (this.f10386a) {
            case 5:
                StringBuilder sb2 = new StringBuilder(100);
                sb2.append(this.f10387b.getClass().getSimpleName());
                sb2.append('{');
                ArrayList arrayList = (ArrayList) this.f10388c;
                int size = arrayList.size();
                for (int i8 = 0; i8 < size; i8++) {
                    sb2.append((String) arrayList.get(i8));
                    if (i8 < size - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append('}');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    public CctBackendFactory u(String str) {
        Bundle bundle;
        Map mapEmptyMap;
        Object obj;
        if (((Map) this.f10388c) == null) {
            Context context = (Context) this.f10387b;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                    if (bundle == null) {
                        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                        mapEmptyMap = Collections.emptyMap();
                    } else {
                        HashMap map = new HashMap();
                        for (String str2 : bundle.keySet()) {
                            obj = bundle.get(str2);
                            if (!(obj instanceof String) && str2.startsWith("backend:")) {
                                for (String str3 : ((String) obj).split(",", -1)) {
                                    String strTrim = str3.trim();
                                    if (!strTrim.isEmpty()) {
                                        map.put(strTrim, str2.substring(8));
                                    }
                                }
                            }
                        }
                        mapEmptyMap = map;
                    }
                    this.f10388c = mapEmptyMap;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
            }
            bundle = null;
            if (bundle == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                mapEmptyMap = Collections.emptyMap();
            } else {
                HashMap map2 = new HashMap();
                while (r6.hasNext()) {
                    obj = bundle.get(str2);
                    if (!(obj instanceof String)) {
                    }
                }
                mapEmptyMap = map2;
            }
            this.f10388c = mapEmptyMap;
        }
        String str4 = (String) ((Map) this.f10388c).get(str);
        if (str4 == null) {
            return null;
        }
        try {
            return (CctBackendFactory) Class.forName(str4).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            Log.w("BackendRegistry", "Class " + str4 + " is not found.", e);
            return null;
        } catch (IllegalAccessException e4) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e4);
            return null;
        } catch (InstantiationException e10) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e11);
            return null;
        } catch (InvocationTargetException e12) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e12);
            return null;
        }
    }

    public c(i iVar, d2.d dVar) {
        this.f10386a = 2;
        this.f10388c = iVar;
        this.f10387b = dVar;
    }

    public /* synthetic */ c(Object obj) {
        this.f10386a = 5;
        this.f10387b = obj;
        this.f10388c = new ArrayList();
    }

    public c(String str, o3.b bVar, n5.a aVar) {
        this.f10386a = 4;
        this.f10387b = str;
        this.f10388c = bVar;
    }

    public c(Context context, int i8) {
        this.f10386a = i8;
        switch (i8) {
            case 3:
                this.f10387b = new AtomicLong(-1L);
                this.f10388c = new w2.b(context, w2.b.f10651i, new f("mlkit:vision"), q2.e.f8942b);
                break;
            default:
                this.f10388c = null;
                this.f10387b = context;
                break;
        }
    }

    public c(u2 u2Var, ScheduledFuture scheduledFuture) {
        this.f10386a = 6;
        this.f10388c = u2Var;
        v8.i(scheduledFuture, "future");
        this.f10387b = scheduledFuture;
    }
}
