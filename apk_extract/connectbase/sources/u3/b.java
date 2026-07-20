package u3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.transsion.athena.data.AppIdData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import k6.i;
import org.json.JSONException;
import org.json.JSONObject;
import s3.e;
import s3.f;
import s3.g;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b.a({"StaticFieldLeak"})
    public static volatile b f16183c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f16184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f16185b;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16186a = new a("EVENTS", 0, "events");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f16187b = new a("COUNTER", 1, "counter");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f16188c = new a("TID_CONFIG", 2, "tidconfig");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f16189d = new a("APPID_CONFIG", 3, "appidconfig");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f16190e;

        public a(String str, int i10, String str2) {
            super(str, i10);
            this.f16190e = str2;
        }

        public String a() {
            return this.f16190e;
        }
    }

    public b(Context context) {
        try {
            this.f16185b = context;
            c cVar = new c(context, "athena.db");
            this.f16184a = cVar;
            cVar.setWriteAheadLoggingEnabled(true);
        } catch (Exception e10) {
            y3.b.d(e10.getMessage());
        }
    }

    public static synchronized b e(Context context) {
        try {
            if (f16183c == null) {
                synchronized (b.class) {
                    try {
                        if (f16183c == null) {
                            f16183c = new b(context);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return f16183c;
    }

    public int a(a aVar, int i10, d<String> dVar) throws i {
        String strA = aVar.a();
        LongSparseArray longSparseArray = new LongSparseArray();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return 0;
                }
                Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT _id,tid FROM " + strA + " ORDER BY _id LIMIT " + i10, null);
                long j10 = 0;
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    long j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("tid"));
                    longSparseArray.put(j11, Integer.valueOf(((Integer) longSparseArray.get(j11, 0)).intValue() + 1));
                    j10 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                int iDelete = sQLiteDatabaseS.delete(strA, "_id<=" + j10 + " AND CAST(tid AS TEXT) NOT LIKE ?", new String[]{"9999%"});
                if (dVar != null && longSparseArray.size() > 0) {
                    dVar.a(longSparseArray.toString());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return iDelete;
            } catch (SQLiteException e10) {
                y3.b.d(Log.getStackTraceString(e10));
                if (0 != 0) {
                    cursor.close();
                }
                g(e10);
                throw new i("cleanupEvents_oom_sql", e10);
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0211 A[Catch: all -> 0x0121, Exception -> 0x0169, SQLiteException -> 0x016e, TRY_LEAVE, TryCatch #1 {all -> 0x0121, blocks: (B:60:0x0104, B:63:0x0110, B:66:0x0126, B:71:0x0134, B:74:0x014d, B:75:0x0152, B:78:0x0160, B:85:0x0179, B:102:0x0211, B:116:0x023a, B:118:0x0257, B:120:0x0274, B:123:0x0287, B:124:0x028e, B:127:0x0296, B:129:0x02a3, B:130:0x02aa, B:131:0x02ae, B:83:0x0173, B:88:0x019d), top: B:171:0x0104 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:162:0x032d A[Catch: all -> 0x031c, TryCatch #19 {all -> 0x031c, blocks: (B:154:0x030d, B:155:0x031b, B:160:0x0324, B:162:0x032d, B:163:0x0330, B:164:0x033a), top: B:180:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x033d  */
    /* JADX WARN: Code duplicated, block: B:169:0x0348  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a3 A[Catch: all -> 0x008c, Exception -> 0x0093, SQLiteException -> 0x009a, TryCatch #9 {all -> 0x008c, blocks: (B:21:0x0081, B:52:0x00dc, B:35:0x00a3, B:37:0x00ac, B:36:0x00a6), top: B:178:0x0081 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a6 A[Catch: all -> 0x008c, Exception -> 0x0093, SQLiteException -> 0x009a, TryCatch #9 {all -> 0x008c, blocks: (B:21:0x0081, B:52:0x00dc, B:35:0x00a3, B:37:0x00ac, B:36:0x00a6), top: B:178:0x0081 }] */
    /* JADX WARN: Multi-variable type inference failed */
    public int b(a aVar, t3.a aVar2, int i10) throws Throwable {
        b bVar;
        String str;
        Cursor cursorRawQuery;
        b bVar2;
        Cursor cursorRawQuery2;
        String str2;
        int i11;
        boolean z10;
        String str3;
        String str4;
        String str5;
        b bVar3;
        String strC;
        byte[] bArr;
        byte[] bArr2;
        int i12;
        this = this;
        String str6 = "_eid";
        String str7 = "There is not enough space left";
        String strA = aVar.a();
        long jE = aVar2.e();
        JSONObject jSONObjectC = aVar2.c();
        List<byte[]> listO = n3.b.l().o();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    if (this.f16184a.c()) {
                        y3.b.d("There is not enough space left");
                    }
                    return -1;
                }
                String str8 = "pi";
                String str9 = "et";
                if (i10 == 1) {
                    try {
                        cursorRawQuery2 = sQLiteDatabaseS.rawQuery("SELECT * FROM " + strA + " WHERE tid=" + jE + " AND et=" + i10, null);
                        byte[] bArr3 = null;
                        String str10 = null;
                        String str11 = null;
                        while (true) {
                            if (cursorRawQuery2 != null) {
                                try {
                                    try {
                                        if (cursorRawQuery2.moveToNext()) {
                                            int i13 = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex(str8));
                                            byte[] bArr4 = bArr3;
                                            String string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex(NotificationCompat.CATEGORY_EVENT));
                                            str8 = str8;
                                            if (i13 != -1) {
                                                if (i13 != 0) {
                                                    try {
                                                        try {
                                                            if (e.m(listO)) {
                                                                if (i13 == 0) {
                                                                    bArr2 = g.f14981n;
                                                                } else {
                                                                    bArr2 = listO.get(i13);
                                                                }
                                                                byte[] bArr5 = bArr2;
                                                                strC = q3.b.c(string, bArr2, i13);
                                                                bArr = bArr5;
                                                            } else {
                                                                strC = string;
                                                                bArr = bArr4;
                                                            }
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            bVar3 = this;
                                                            str = str7;
                                                        }
                                                    } catch (SQLiteException e10) {
                                                        e = e10;
                                                        bVar2 = this;
                                                        cursorRawQuery = cursorRawQuery2;
                                                        y3.b.d(Log.getStackTraceString(e));
                                                        if (cursorRawQuery != null) {
                                                            cursorRawQuery.close();
                                                        }
                                                        bVar2.g(e);
                                                        throw new i("addJSON_sql", e);
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        y3.b.d(Log.getStackTraceString(e));
                                                        throw new i("addJSON", e);
                                                    }
                                                } else {
                                                    if (i13 == 0) {
                                                        bArr2 = g.f14981n;
                                                    } else {
                                                        bArr2 = listO.get(i13);
                                                    }
                                                    byte[] bArr6 = bArr2;
                                                    strC = q3.b.c(string, bArr2, i13);
                                                    bArr = bArr6;
                                                }
                                                if (bArr == null || strC == null) {
                                                    cursorRawQuery2.close();
                                                    if (!this.f16184a.c()) {
                                                        return -1;
                                                    }
                                                    y3.b.d(str7);
                                                    return -1;
                                                }
                                                String str12 = strC;
                                                bArr3 = bArr;
                                                string = str12;
                                            } else {
                                                bArr3 = bArr4;
                                            }
                                            if (str10 == null) {
                                                String str13 = str10;
                                                try {
                                                    str10 = String.format("\"%s\":\"%s\"", NotificationCompat.CATEGORY_EVENT, jSONObjectC.getString(NotificationCompat.CATEGORY_EVENT));
                                                } catch (Exception unused) {
                                                    str = str7;
                                                    str3 = str13;
                                                    str4 = str6;
                                                    str6 = str4;
                                                    str10 = str3;
                                                    str7 = str;
                                                }
                                            }
                                            try {
                                                boolean zContains = string.contains(str10);
                                                str3 = str10;
                                                str = str7;
                                                if (zContains) {
                                                    try {
                                                        try {
                                                            if ("ev_athena".equals(aVar2.b())) {
                                                                if (str11 == null) {
                                                                    str11 = String.format("\"%s\":\"%s\"", str6, jSONObjectC.getJSONObject("_eparam").optString(str6));
                                                                }
                                                                zContains = string.contains(str11);
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            bVar3 = this;
                                                            cursorRawQuery = cursorRawQuery2;
                                                            bVar = bVar3;
                                                            if (cursorRawQuery != null) {
                                                                cursorRawQuery.close();
                                                            }
                                                            if (bVar.f16184a.c()) {
                                                                y3.b.d(str);
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Exception unused2) {
                                                        str4 = str6;
                                                        str6 = str4;
                                                        str10 = str3;
                                                        str7 = str;
                                                    }
                                                }
                                                if (zContains) {
                                                    try {
                                                        String str14 = str6;
                                                        long j10 = cursorRawQuery2.getLong(cursorRawQuery2.getColumnIndex("_id"));
                                                        str5 = str14;
                                                        if (string.length() < 131072) {
                                                            JSONObject jSONObject = new JSONObject(string);
                                                            try {
                                                                e.i(jSONObjectC.getJSONObject("_eparam"), jSONObject.getJSONObject("_eparam"));
                                                                i11 = -1;
                                                                String strB = i13 != -1 ? q3.b.b(jSONObject.toString(), bArr3) : jSONObject.toString();
                                                                if (strB != null) {
                                                                    ContentValues contentValues = new ContentValues();
                                                                    contentValues.put(NotificationCompat.CATEGORY_EVENT, strB);
                                                                    sQLiteDatabaseS.update(strA, contentValues, "_id=" + j10, null);
                                                                }
                                                                str2 = str9;
                                                                z10 = false;
                                                            } catch (JSONException unused3) {
                                                                str6 = str5;
                                                                str10 = str3;
                                                                str7 = str;
                                                                str11 = str11;
                                                            }
                                                        } else {
                                                            i11 = -1;
                                                            ContentValues contentValues2 = new ContentValues();
                                                            str2 = str9;
                                                            contentValues2.put(str2, (Integer) 2);
                                                            sQLiteDatabaseS.update(strA, contentValues2, "_id=" + j10, null);
                                                            z10 = true;
                                                        }
                                                        if (cursorRawQuery2 != null) {
                                                            cursorRawQuery2.close();
                                                        }
                                                    } catch (SQLiteException e12) {
                                                        e = e12;
                                                        bVar2 = this;
                                                        cursorRawQuery = cursorRawQuery2;
                                                        y3.b.d(Log.getStackTraceString(e));
                                                        if (cursorRawQuery != null) {
                                                            cursorRawQuery.close();
                                                        }
                                                        bVar2.g(e);
                                                        throw new i("addJSON_sql", e);
                                                    } catch (Exception e13) {
                                                        e = e13;
                                                        y3.b.d(Log.getStackTraceString(e));
                                                        throw new i("addJSON", e);
                                                    }
                                                } else {
                                                    str5 = str6;
                                                }
                                                str6 = str5;
                                                str10 = str3;
                                                str7 = str;
                                                str11 = str11;
                                            } catch (Exception unused4) {
                                                str = str7;
                                                str3 = str10;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str = str7;
                                        bVar3 = this;
                                    }
                                } catch (SQLiteException e14) {
                                    e = e14;
                                    bVar2 = this;
                                    cursorRawQuery = cursorRawQuery2;
                                    y3.b.d(Log.getStackTraceString(e));
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    bVar2.g(e);
                                    throw new i("addJSON_sql", e);
                                } catch (Exception e15) {
                                    e = e15;
                                    y3.b.d(Log.getStackTraceString(e));
                                    throw new i("addJSON", e);
                                }
                                cursorRawQuery = cursorRawQuery2;
                                bVar = bVar3;
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                if (bVar.f16184a.c()) {
                                    y3.b.d(str);
                                }
                                throw th;
                            }
                            str = str7;
                            str8 = str8;
                            str2 = str9;
                            i11 = -1;
                            z10 = true;
                            if (cursorRawQuery2 != null) {
                                cursorRawQuery2.close();
                            }
                        }
                    } catch (SQLiteException e16) {
                        e = e16;
                        cursorRawQuery = null;
                        bVar2 = this;
                        y3.b.d(Log.getStackTraceString(e));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        bVar2.g(e);
                        throw new i("addJSON_sql", e);
                    } catch (Exception e17) {
                        e = e17;
                        y3.b.d(Log.getStackTraceString(e));
                        throw new i("addJSON", e);
                    } catch (Throwable th5) {
                        th = th5;
                        str = "There is not enough space left";
                        cursorRawQuery = null;
                        bVar = this;
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (bVar.f16184a.c()) {
                            y3.b.d(str);
                        }
                        throw th;
                    }
                } else {
                    str = "There is not enough space left";
                    str8 = "pi";
                    str2 = str9;
                    i11 = -1;
                    cursorRawQuery2 = null;
                    z10 = true;
                }
                if (z10) {
                    Pair<Integer, byte[]> pairU = n3.b.l().u();
                    Integer num = (Integer) pairU.first;
                    num.intValue();
                    String strB2 = q3.b.b(jSONObjectC.toString(), (byte[]) pairU.second);
                    if (strB2 != null) {
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("tid", Long.valueOf(jE));
                        contentValues3.put(NotificationCompat.CATEGORY_EVENT, strB2);
                        contentValues3.put(str2, Integer.valueOf(i10));
                        contentValues3.put(str8, num);
                        contentValues3.put("created_at", Long.valueOf(aVar2.i()));
                        if (y3.d.h(jE)) {
                            contentValues3.put("ext", aVar2.b());
                        }
                        if (aVar2.a() != null) {
                            contentValues3.put("er_ts", Long.valueOf(aVar2.g()));
                            contentValues3.put("boot_id", aVar2.a());
                        }
                        sQLiteDatabaseS.insert(strA, null, contentValues3);
                    }
                }
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT COUNT(*) FROM " + strA + " WHERE tid=" + jE, null);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.moveToNext()) {
                            i12 = cursorRawQuery.getInt(0);
                        } else {
                            i12 = i11;
                        }
                    } catch (SQLiteException e18) {
                        e = e18;
                        bVar2 = this;
                        y3.b.d(Log.getStackTraceString(e));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        bVar2.g(e);
                        throw new i("addJSON_sql", e);
                    } catch (Exception e19) {
                        e = e19;
                        y3.b.d(Log.getStackTraceString(e));
                        throw new i("addJSON", e);
                    } catch (Throwable th6) {
                        th = th6;
                        bVar = this;
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (bVar.f16184a.c()) {
                            y3.b.d(str);
                        }
                        throw th;
                    }
                } else {
                    i12 = i11;
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (!this.f16184a.c()) {
                    return i12;
                }
                y3.b.d(str);
                return -2;
            } catch (Throwable th7) {
                th = th7;
                bVar = "_eid";
            }
        } catch (SQLiteException e20) {
            e = e20;
            bVar2 = this;
            cursorRawQuery = null;
        } catch (Exception e21) {
            e = e21;
        } catch (Throwable th8) {
            th = th8;
            bVar = this;
            str = "There is not enough space left";
            cursorRawQuery = null;
        }
    }

    public List<AppIdData> c(a aVar) throws i {
        String strA = aVar.a();
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
                    appIdData.f1812a = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("appid"));
                    appIdData.f1813b = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("base"));
                    appIdData.f1814c = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("uid"));
                    appIdData.f1815d = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("try"));
                    arrayList.add(appIdData);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e10) {
                y3.b.d(Log.getStackTraceString(e10));
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                g(e10);
                throw new i("getAppIdList_sql", e10);
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:141:0x025f A[Catch: all -> 0x0254, TryCatch #14 {all -> 0x0254, blocks: (B:135:0x0245, B:136:0x0253, B:139:0x0256, B:141:0x025f, B:142:0x0262, B:143:0x026e), top: B:157:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0271  */
    public t3.c d(a aVar, long j10, long j11, String str, int i10, int i11) throws Throwable {
        String str2;
        Cursor cursor;
        Object obj;
        Cursor cursor2;
        int i12;
        int i13;
        String str3;
        String str4;
        String str5 = "_eparam";
        String str6 = "net";
        List<byte[]> listO = n3.b.l().o();
        Cursor cursor3 = null;
        if (e.j(listO)) {
            return null;
        }
        String strA = aVar.a();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return null;
                }
                if (TextUtils.isEmpty(str)) {
                    try {
                        str2 = "SELECT * FROM " + strA + " WHERE tid=" + j10 + " AND created_at<=" + j11 + " ORDER BY _id LIMIT " + i11;
                    } catch (SQLiteException e10) {
                        e = e10;
                        cursor3 = null;
                    } catch (Exception e11) {
                        e = e11;
                        y3.b.d(Log.getStackTraceString(e));
                        throw new i("queryEventList", e);
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
                        str2 = "SELECT * FROM " + strA + " WHERE tid=" + j10 + " AND uid='" + str + "' ORDER BY _id";
                    } catch (SQLiteException e12) {
                        e = e12;
                        cursor2 = null;
                        cursor3 = cursor2;
                        y3.b.d(Log.getStackTraceString(e));
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        g(e);
                        throw new i("queryEventList_sql", e);
                    } catch (Exception e13) {
                        e = e13;
                        obj = null;
                        y3.b.d(Log.getStackTraceString(e));
                        throw new i("queryEventList", e);
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
                                    ArrayList arrayList = new ArrayList();
                                    String str7 = "";
                                    int i14 = 0;
                                    long j12 = 0;
                                    int i15 = 0;
                                    int i16 = 0;
                                    long j13 = 0;
                                    while (true) {
                                        if (!cursorRawQuery.moveToNext()) {
                                            i12 = i15;
                                            i13 = i16;
                                            str3 = str7;
                                            break;
                                        }
                                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(NotificationCompat.CATEGORY_EVENT));
                                        long j14 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("created_at"));
                                        int i17 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("pi"));
                                        int i18 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("et"));
                                        if (i17 != -1) {
                                            string = q3.b.c(string, listO.get(i17), i17);
                                        }
                                        if (j12 == 0) {
                                            j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                        }
                                        if (string != null) {
                                            if (i18 != 0) {
                                                string = string.replace("&add", "").replace("&append", "");
                                            }
                                            try {
                                                JSONObject jSONObject = new JSONObject(string);
                                                String str8 = (String) jSONObject.remove(NotificationCompat.CATEGORY_EVENT);
                                                try {
                                                    int iIntValue = jSONObject.has(str6) ? ((Integer) jSONObject.remove(str6)).intValue() : 0;
                                                    Object objRemove = jSONObject.has(str5) ? jSONObject.remove(str5) : new JSONObject();
                                                    if (objRemove instanceof JSONObject) {
                                                        try {
                                                            if (jSONObject.length() > 0) {
                                                                Iterator<String> itKeys = jSONObject.keys();
                                                                while (itKeys.hasNext()) {
                                                                    itKeys = itKeys;
                                                                    String next = itKeys.next();
                                                                    str5 = str5;
                                                                    try {
                                                                        if (next.startsWith("_")) {
                                                                            str4 = str6;
                                                                            try {
                                                                                ((JSONObject) objRemove).put(next, jSONObject.get(next));
                                                                                str6 = str4;
                                                                            } catch (Exception e14) {
                                                                                e = e14;
                                                                                str7 = str8;
                                                                                e.printStackTrace();
                                                                                i14++;
                                                                                j13 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                                str5 = str5;
                                                                                str6 = str4;
                                                                            }
                                                                        }
                                                                    } catch (Exception e15) {
                                                                        e = e15;
                                                                        str4 = str6;
                                                                        str7 = str8;
                                                                        e.printStackTrace();
                                                                        i14++;
                                                                        j13 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                        str5 = str5;
                                                                        str6 = str4;
                                                                    }
                                                                }
                                                            }
                                                        } catch (Exception e16) {
                                                            e = e16;
                                                            str5 = str5;
                                                        }
                                                    }
                                                    str5 = str5;
                                                    str4 = str6;
                                                    arrayList.add(new t3.c.a(str8, j14, iIntValue, objRemove.toString()));
                                                    i15++;
                                                    int length = i16 + string.length();
                                                    if (length >= i10) {
                                                        try {
                                                            i13 = length;
                                                            j13 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                            str3 = str8;
                                                            i12 = i15;
                                                            break;
                                                        } catch (Exception e17) {
                                                            e = e17;
                                                            i16 = length;
                                                            str7 = str8;
                                                            e.printStackTrace();
                                                            i14++;
                                                            j13 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                            str5 = str5;
                                                            str6 = str4;
                                                        }
                                                    } else {
                                                        i16 = length;
                                                        str7 = str8;
                                                        j13 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                        str5 = str5;
                                                        str6 = str4;
                                                    }
                                                } catch (Exception e18) {
                                                    e = e18;
                                                    str5 = str5;
                                                    str4 = str6;
                                                }
                                            } catch (Exception e19) {
                                                e = e19;
                                                str5 = str5;
                                                str4 = str6;
                                            }
                                        } else {
                                            str5 = str5;
                                            str4 = str6;
                                        }
                                        i14++;
                                        j13 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                        str5 = str5;
                                        str6 = str4;
                                    }
                                    cursorRawQuery.close();
                                    if (i12 <= 0) {
                                        cursorRawQuery.close();
                                        return null;
                                    }
                                    int i19 = i14 + i12;
                                    t3.c cVar = new t3.c(j10, str3, arrayList, j12, j13, i12, i13, count <= i19 && !(count == i11 && count == i19));
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
                        } catch (SQLiteException e20) {
                            e = e20;
                            cursor3 = cursorRawQuery;
                        } catch (Exception e21) {
                            e = e21;
                            y3.b.d(Log.getStackTraceString(e));
                            throw new i("queryEventList", e);
                        }
                    }
                    if (cursorRawQuery == null) {
                        return null;
                    }
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e22) {
                    e = e22;
                    cursor2 = null;
                    cursor3 = cursor2;
                } catch (Exception e23) {
                    e = e23;
                    obj = null;
                    y3.b.d(Log.getStackTraceString(e));
                    throw new i("queryEventList", e);
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
        } catch (SQLiteException e24) {
            e = e24;
        } catch (Exception e25) {
            e = e25;
        } catch (Throwable th7) {
            th = th7;
        }
        y3.b.d(Log.getStackTraceString(e));
        if (cursor3 != null) {
            cursor3.close();
        }
        g(e);
        throw new i("queryEventList_sql", e);
    }

    public void f() {
        y3.b.b("deleteDB");
        try {
            this.f16184a.b();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void g(SQLiteException sQLiteException) {
        try {
            if (sQLiteException instanceof SQLiteFullException) {
                this.f16184a.close();
            } else {
                this.f16184a.close();
                this.f16184a.b();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void h(a aVar, AppIdData appIdData) throws i {
        String strA = aVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("appid", Integer.valueOf(appIdData.f1812a));
            contentValues.put("base", appIdData.f1813b);
            if (sQLiteDatabaseS.update(strA, contentValues, "appid=" + appIdData.f1812a, null) != 1) {
                sQLiteDatabaseS.insert(strA, null, contentValues);
            }
        } catch (SQLiteException e10) {
            y3.b.d(Log.getStackTraceString(e10));
            g(e10);
            throw new i("addAppId_sql", e10);
        }
    }

    public void i(a aVar, String str, long j10) throws i {
        String strA = aVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            sQLiteDatabaseS.execSQL("UPDATE " + strA + " SET created_at = er_ts + " + j10 + ", boot_id = '' WHERE boot_id = '" + str + "'");
        } catch (SQLiteException e10) {
            y3.b.d(Log.getStackTraceString(e10));
            g(e10);
            throw new i("updateEvents_sql", e10);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0064: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:16:0x0064 */
    public void j(a aVar, List<AppIdData> list) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabaseS;
        String strA = aVar.a();
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
                        sQLiteDatabaseS.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", "");
                        for (AppIdData appIdData : list) {
                            sQLiteDatabaseS.update(a.f16186a.a(), contentValues, "CAST(tid AS TEXT) LIKE ? AND uid=?", new String[]{appIdData.f1812a + "%", appIdData.f1814c});
                            e.h(sb2, Integer.valueOf(appIdData.f1812a));
                        }
                        contentValues.put("try", (Integer) 0);
                        sQLiteDatabaseS.update(strA, contentValues, "appid IN (" + sb2.toString() + ")", null);
                        sQLiteDatabaseS.setTransactionSuccessful();
                        sQLiteDatabaseS.endTransaction();
                    } catch (SQLiteException e10) {
                        e = e10;
                        y3.b.d(Log.getStackTraceString(e));
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        } else {
                            sQLiteDatabase2 = sQLiteDatabaseS;
                        }
                        g(e);
                        throw new i("updateAppIdList_sql", e);
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    sQLiteDatabaseS = null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.endTransaction();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase2 = sQLiteDatabase;
        }
    }

    public void k(a aVar, List<AppIdData> list, int i10) throws i {
        String strA = aVar.a();
        StringBuilder sb2 = new StringBuilder();
        try {
            for (AppIdData appIdData : list) {
                e.h(sb2, Integer.valueOf(appIdData.f1812a));
                appIdData.f1815d = i10;
            }
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("try", Integer.valueOf(i10));
            sQLiteDatabaseS.update(strA, contentValues, "appid IN (" + sb2.toString() + ")", null);
        } catch (SQLiteException e10) {
            y3.b.d(Log.getStackTraceString(e10));
            g(e10);
            throw new i("updateEvents_sql", e10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x026e A[Catch: all -> 0x00c4, TryCatch #5 {all -> 0x00c4, blocks: (B:20:0x0086, B:22:0x008c, B:29:0x00a1, B:31:0x00bf, B:41:0x00d3, B:37:0x00ca, B:43:0x00de, B:112:0x0265, B:114:0x026e, B:116:0x0273), top: B:134:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0273 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #5 {all -> 0x00c4, blocks: (B:20:0x0086, B:22:0x008c, B:29:0x00a1, B:31:0x00bf, B:41:0x00d3, B:37:0x00ca, B:43:0x00de, B:112:0x0265, B:114:0x026e, B:116:0x0273), top: B:134:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x027a  */
    /* JADX WARN: Code duplicated, block: B:124:0x028e  */
    /* JADX WARN: Code duplicated, block: B:126:0x0293  */
    public void l(a aVar, List<AppIdData> list, long j10, String str, d<SparseArray<t3.e>> dVar) throws Throwable {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabaseS;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabase;
        String str2;
        Cursor cursor2;
        String str3;
        int i10;
        String str4 = "_id";
        String str5 = " AND ";
        String strA = aVar.a();
        StringBuilder sb2 = new StringBuilder();
        SparseArray<t3.e> sparseArray = new SparseArray<>();
        Cursor cursor3 = null;
        try {
            Iterator<AppIdData> it = list.iterator();
            while (it.hasNext()) {
                try {
                    e.h(sb2, Integer.valueOf(it.next().f1812a));
                } catch (SQLiteException e10) {
                    e = e10;
                    sQLiteDatabaseS = null;
                    cursorRawQuery = null;
                    cursor = null;
                    y3.b.d(Log.getStackTraceString(e));
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
                        g(e);
                        throw new i("cleanupEvents_sql", e);
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
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT * FROM " + a.f16189d.a() + " WHERE appid IN (" + ((Object) sb2) + ")", null);
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
                            int i11 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("appid"));
                            if (i11 != 9999 && i11 != 1031 && i11 != 1041) {
                                int i12 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("cnt"));
                                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("date"));
                                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ext"));
                                if (TextUtils.isEmpty(string2)) {
                                    i10 = 0;
                                } else {
                                    try {
                                        i10 = Integer.parseInt(string2);
                                    } catch (Exception e11) {
                                        e11.printStackTrace();
                                        i10 = 0;
                                    }
                                }
                                sparseArray.put(i11, new t3.e(i11, string, i12, i10));
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
                    } catch (SQLiteException e12) {
                        e = e12;
                        cursor = null;
                        y3.b.d(Log.getStackTraceString(e));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                            sQLiteDatabase = cursor;
                        } else {
                            sQLiteDatabase = sQLiteDatabaseS;
                        }
                        g(e);
                        throw new i("cleanupEvents_sql", e);
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                try {
                    try {
                        Iterator<AppIdData> it2 = list.iterator();
                        while (it2.hasNext()) {
                            AppIdData next = it2.next();
                            int i13 = 0;
                            for (t3.c cVar : next.f1816e) {
                                try {
                                    Iterator<AppIdData> it3 = it2;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("tid=");
                                    cursor2 = cursorRawQuery;
                                    String str6 = str2;
                                    try {
                                        try {
                                            sb3.append(cVar.f15457a);
                                            sb3.append(str5);
                                            sb3.append(str4);
                                            sb3.append(">=");
                                            sb3.append(cVar.f15460d);
                                            sb3.append(str5);
                                            sb3.append(str4);
                                            sb3.append("<=");
                                            sb3.append(cVar.f15461e);
                                            sQLiteDatabaseS.delete(strA, sb3.toString(), null);
                                            if (cVar.f15464h) {
                                                ContentValues contentValues = new ContentValues();
                                                contentValues.put("pt", Long.valueOf(j10));
                                                sQLiteDatabaseS.update(a.f16188c.a(), contentValues, "tid=" + cVar.f15457a, null);
                                            }
                                            i13 += cVar.f15462f;
                                            it2 = it3;
                                            cursorRawQuery = cursor2;
                                            str2 = str6;
                                            str4 = str4;
                                            str5 = str5;
                                            cursor3 = null;
                                        } catch (SQLiteException e13) {
                                            e = e13;
                                            cursorRawQuery = cursor2;
                                            cursor = null;
                                            y3.b.d(Log.getStackTraceString(e));
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            if (sQLiteDatabaseS != null) {
                                                sQLiteDatabaseS.endTransaction();
                                                sQLiteDatabase = cursor;
                                            } else {
                                                sQLiteDatabase = sQLiteDatabaseS;
                                            }
                                            g(e);
                                            throw new i("cleanupEvents_sql", e);
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
                                } catch (SQLiteException e14) {
                                    e = e14;
                                }
                            }
                            String str7 = str4;
                            String str8 = str5;
                            Iterator<AppIdData> it4 = it2;
                            cursor2 = cursorRawQuery;
                            String str9 = str2;
                            try {
                                ContentValues contentValues2 = new ContentValues();
                                t3.e eVar = sparseArray.get(next.f1812a);
                                if (eVar != null) {
                                    String str10 = eVar.f15472b;
                                    if (str10 == null || str10.equals(str)) {
                                        sparseArray.remove(next.f1812a);
                                    }
                                    String str11 = eVar.f15472b;
                                    if (str11 == null || !str11.equals(str)) {
                                        str3 = str9;
                                        contentValues2.put("date", str);
                                        contentValues2.put("cnt", Integer.valueOf(i13));
                                        contentValues2.put(str3, "1");
                                    } else {
                                        contentValues2.put("cnt", Integer.valueOf(eVar.f15473c + i13));
                                        str3 = str9;
                                        contentValues2.put(str3, String.valueOf(eVar.f15474d + 1));
                                    }
                                } else {
                                    str3 = str9;
                                }
                                contentValues2.put("uid", "");
                                contentValues2.put("try", (Integer) 0);
                                cursor = null;
                                try {
                                    sQLiteDatabaseS.update(a.f16189d.a(), contentValues2, "appid=" + next.f1812a, null);
                                    cursor3 = null;
                                    cursorRawQuery = cursor2;
                                    str4 = str7;
                                    str5 = str8;
                                    str2 = str3;
                                    it2 = it4;
                                } catch (SQLiteException e15) {
                                    e = e15;
                                    cursorRawQuery = cursor2;
                                    y3.b.d(Log.getStackTraceString(e));
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseS != null) {
                                        sQLiteDatabaseS.endTransaction();
                                        sQLiteDatabase = cursor;
                                    } else {
                                        sQLiteDatabase = sQLiteDatabaseS;
                                    }
                                    g(e);
                                    throw new i("cleanupEvents_sql", e);
                                }
                            } catch (SQLiteException e16) {
                                e = e16;
                                cursor = null;
                                cursorRawQuery = cursor2;
                                y3.b.d(Log.getStackTraceString(e));
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                if (sQLiteDatabaseS != null) {
                                    sQLiteDatabaseS.endTransaction();
                                    sQLiteDatabase = cursor;
                                } else {
                                    sQLiteDatabase = sQLiteDatabaseS;
                                }
                                g(e);
                                throw new i("cleanupEvents_sql", e);
                            }
                        }
                        cursor = cursor3;
                        cursor2 = cursorRawQuery;
                        sQLiteDatabaseS.setTransactionSuccessful();
                        if (dVar != null) {
                            dVar.a(sparseArray);
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        sQLiteDatabaseS.endTransaction();
                    } catch (SQLiteException e17) {
                        e = e17;
                        cursor = cursor3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    cursor2 = cursorRawQuery;
                }
            } catch (SQLiteException e18) {
                e = e18;
                cursor = null;
                cursorRawQuery = null;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (SQLiteException e19) {
            e = e19;
            cursor = null;
            sQLiteDatabaseS = null;
            cursorRawQuery = null;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0081: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:16:0x0081 */
    public void m(a aVar, List<AppIdData> list, String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseS;
        SQLiteDatabase sQLiteDatabase;
        String strA = aVar.a();
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
                        for (AppIdData appIdData : list) {
                            for (t3.c cVar : appIdData.f1816e) {
                                sQLiteDatabaseS.update(strA, contentValues, "tid=" + cVar.f15457a + " AND _id>=" + cVar.f15460d + " AND _id<=" + cVar.f15461e, null);
                            }
                            e.h(sb2, Integer.valueOf(appIdData.f1812a));
                        }
                        contentValues.put("try", (Integer) 0);
                        sQLiteDatabaseS.update(a.f16189d.a(), contentValues, "appid IN (" + sb2.toString() + ")", null);
                        sQLiteDatabaseS.setTransactionSuccessful();
                        sQLiteDatabaseS.endTransaction();
                    } catch (SQLiteException e10) {
                        e = e10;
                        y3.b.d(Log.getStackTraceString(e));
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        }
                        g(e);
                        throw new i("updateEvents_sql", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase2 = sQLiteDatabase;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                    throw th;
                }
            } catch (SQLiteException e11) {
                e = e11;
                sQLiteDatabaseS = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void n(a aVar, List<Long> list, d<String> dVar) throws Throwable {
        String strA = aVar.a();
        String strE = e.e(list, ks.g.f9491d);
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return;
                }
                LongSparseArray longSparseArray = new LongSparseArray();
                Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT tid FROM " + strA + " WHERE tid IN (" + strE + ")", null);
                while (cursorRawQuery != null) {
                    try {
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        }
                        long j10 = cursorRawQuery.getLong(0);
                        longSparseArray.put(j10, Integer.valueOf(((Integer) longSparseArray.get(j10, 0)).intValue() + 1));
                    } catch (SQLiteException e10) {
                        e = e10;
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
                sQLiteDatabaseS.delete(strA, "tid IN (" + strE + ")", null);
                if (dVar != null && longSparseArray.size() > 0) {
                    dVar.a(longSparseArray.toString());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLiteException e11) {
            e = e11;
        }
        y3.b.d(Log.getStackTraceString(e));
        if (cursor != null) {
            cursor.close();
        }
        g(e);
        throw new i("cleanupEvents_off_sql", e);
    }

    /* JADX WARN: Code duplicated, block: B:68:0x019a  */
    /* JADX WARN: Code duplicated, block: B:70:0x019f  */
    public void o(a aVar, f fVar, boolean z10) throws Throwable {
        SQLiteDatabase sQLiteDatabaseS;
        Cursor cursor;
        Cursor cursorRawQuery;
        String strA = aVar.a();
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
                contentValues.put("cfg", fVar.B());
                sQLiteDatabaseS.update(strA, contentValues, "appid=" + fVar.g(), null);
                if (z10) {
                    sQLiteDatabaseS.delete(a.f16188c.a(), "CAST(tid AS TEXT) LIKE ?", new String[]{fVar.g() + "%"});
                    List<s3.a> listY = fVar.y();
                    HashMap map = new HashMap();
                    for (s3.a aVar2 : listY) {
                        s3.b bVarF = aVar2.f();
                        contentValues.clear();
                        contentValues.put("tid", Long.valueOf(aVar2.e()));
                        contentValues.put("ev", aVar2.d());
                        contentValues.put("pt", Long.valueOf(bVarF.y()));
                        contentValues.put("cf", bVarF.E());
                        sQLiteDatabaseS.insert(a.f16188c.a(), null, contentValues);
                        if (aVar2.d() != null) {
                            map.put(aVar2.d(), Long.valueOf(aVar2.e()));
                        }
                    }
                    cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT DISTINCT ext FROM " + a.f16186a.a() + " WHERE tid=" + fVar.g(), null);
                    while (cursorRawQuery != null) {
                        try {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ext"));
                            if (map.containsKey(string)) {
                                contentValues.clear();
                                contentValues.put("tid", (Long) map.get(string));
                                sQLiteDatabaseS.update(a.f16186a.a(), contentValues, "tid=" + fVar.g() + " AND ext=?", new String[]{string});
                            }
                        } catch (SQLiteException e10) {
                            cursor = cursorRawQuery;
                            e = e10;
                            try {
                                y3.b.d(Log.getStackTraceString(e));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseS != null) {
                                    sQLiteDatabaseS.endTransaction();
                                } else {
                                    sQLiteDatabase = sQLiteDatabaseS;
                                }
                                try {
                                    g(e);
                                    throw new i("updateAppConfig_sql", e);
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
            } catch (SQLiteException e11) {
                e = e11;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursor = null;
            sQLiteDatabaseS = null;
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabaseS = null;
        }
    }

    public void p(d<SparseArray<f>> dVar) throws Throwable {
        f fVarB;
        SparseArray<f> sparseArray = new SparseArray<>();
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return;
                }
                Cursor cursorRawQuery2 = sQLiteDatabaseS.rawQuery("SELECT * FROM " + a.f16189d.a(), null);
                while (cursorRawQuery2 != null) {
                    try {
                        if (!cursorRawQuery2.moveToNext()) {
                            break;
                        }
                        String string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("cfg"));
                        if (!TextUtils.isEmpty(string) && (fVarB = f.b(string)) != null) {
                            fVarB.c(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex("appid")));
                            sparseArray.put(fVarB.g(), fVarB);
                        }
                    } catch (SQLiteException e10) {
                        e = e10;
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
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT * FROM " + a.f16188c.a(), null);
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    long j10 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("tid"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ev"));
                    s3.b bVar = new s3.b();
                    bVar.f14946i = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pt"));
                    bVar.e(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("cf")));
                    f fVar = sparseArray.get(y3.d.a(j10));
                    if (fVar != null) {
                        fVar.d(new s3.a(j10, string2, bVar));
                    }
                }
                if (dVar != null) {
                    dVar.a(sparseArray);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            } catch (SQLiteException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        y3.b.d(Log.getStackTraceString(e));
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        g(e);
        throw new i("getAPPIDApp_sql", e);
    }

    public boolean q(a aVar, int i10) throws i {
        String strA = aVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return false;
            }
            sQLiteDatabaseS.delete(strA, "CAST(tid AS TEXT) LIKE ?", new String[]{i10 + "%"});
            return true;
        } catch (SQLiteException e10) {
            y3.b.d(Log.getStackTraceString(e10));
            g(e10);
            throw new i("cleanupEvents_del_sql", e10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0192  */
    /* JADX WARN: Code duplicated, block: B:88:0x0197  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.StringBuilder] */
    public int r(a aVar, List<t3.a> list, d<LongSparseArray<Integer>> dVar) throws Throwable {
        ?? r10;
        ?? r11;
        Cursor cursorRawQuery;
        ?? A = aVar.a();
        HashSet hashSet = new HashSet();
        ?? r12 = 0;
        ?? r13 = 0;
        r12 = 0;
        try {
            try {
                try {
                    ?? S = s();
                    int i10 = 0;
                    if (S == 0) {
                        if (S != 0) {
                            S.endTransaction();
                        }
                        if (this.f16184a.c()) {
                            y3.b.d("There is not enough space left");
                        }
                        return 0;
                    }
                    try {
                        S.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (t3.a aVar2 : list) {
                            JSONObject jSONObjectC = aVar2.c();
                            Pair<Integer, byte[]> pairU = n3.b.l().u();
                            Integer num = (Integer) pairU.first;
                            num.intValue();
                            String strB = q3.b.b(jSONObjectC.toString(), (byte[]) pairU.second);
                            if (strB != null) {
                                contentValues.clear();
                                contentValues.put("tid", Long.valueOf(aVar2.e()));
                                contentValues.put(NotificationCompat.CATEGORY_EVENT, strB);
                                contentValues.put("et", (Integer) 0);
                                contentValues.put("pi", num);
                                contentValues.put("created_at", Long.valueOf(aVar2.i()));
                                if (aVar2.a() != null) {
                                    contentValues.put("er_ts", Long.valueOf(aVar2.g()));
                                    contentValues.put("boot_id", aVar2.a());
                                }
                                if (S.insert(A, null, contentValues) > 0) {
                                    hashSet.add(Long.valueOf(aVar2.e()));
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
                            cursorRawQuery = S.rawQuery("SELECT tid,COUNT(*) FROM " + A + " WHERE tid IN (" + e.e(hashSet, ks.g.f9491d) + ") GROUP BY tid", null);
                            int i11 = 0;
                            while (cursorRawQuery != null) {
                                try {
                                    if (!cursorRawQuery.moveToNext()) {
                                        break;
                                    }
                                    longSparseArray.put(cursorRawQuery.getLong(0), Integer.valueOf(cursorRawQuery.getInt(1)));
                                    i11++;
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    A = cursorRawQuery;
                                    r11 = S;
                                    y3.b.d(Log.getStackTraceString(e));
                                    if (A != 0) {
                                        A.close();
                                    }
                                    if (r11 != 0) {
                                        r11.endTransaction();
                                    } else {
                                        r13 = r11;
                                    }
                                    try {
                                        g(e);
                                        throw new i("addJSON_sql", e);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r10 = r13;
                                        r12 = A;
                                        if (r12 != 0) {
                                            r12.close();
                                        }
                                        if (r10 != 0) {
                                            r10.endTransaction();
                                        }
                                        if (this.f16184a.c()) {
                                            y3.b.d("There is not enough space left");
                                        }
                                        throw th;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    y3.b.d(Log.getStackTraceString(e));
                                    throw new i("addJSON", e);
                                }
                            }
                            if (dVar != null && longSparseArray.size() > 0) {
                                dVar.a(longSparseArray);
                            }
                            i10 = i11;
                            cursorRawQuery = cursorRawQuery;
                        } else {
                            cursorRawQuery = null;
                        }
                        S.setTransactionSuccessful();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        S.endTransaction();
                        if (!this.f16184a.c()) {
                            return i10;
                        }
                        y3.b.d("There is not enough space left");
                        return -2;
                    } catch (SQLiteException e12) {
                        e = e12;
                        A = 0;
                        r11 = S;
                    } catch (Exception e13) {
                        e = e13;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r12 = A;
                    if (r12 != 0) {
                        r12.close();
                    }
                    if (r10 != 0) {
                        r10.endTransaction();
                    }
                    if (this.f16184a.c()) {
                        y3.b.d("There is not enough space left");
                    }
                    throw th;
                }
            } catch (SQLiteException e14) {
                e = e14;
                A = 0;
                r11 = 0;
            } catch (Exception e15) {
                e = e15;
            } catch (Throwable th4) {
                th = th4;
                r10 = 0;
                if (r12 != 0) {
                    r12.close();
                }
                if (r10 != 0) {
                    r10.endTransaction();
                }
                if (this.f16184a.c()) {
                    y3.b.d("There is not enough space left");
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final SQLiteDatabase s() {
        try {
            if (!this.f16185b.getDatabasePath("athena.db").exists()) {
                this.f16184a.close();
            }
            return this.f16184a.getWritableDatabase();
        } catch (SQLiteException e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }
}
