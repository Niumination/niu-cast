package i2;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideResponse;
import com.transsion.iotservice.multiscreen.pc.http.RequestCallback;
import java.util.Collections;
import java.util.HashSet;
import k3.fc;
import k3.vb;
import kotlin.jvm.internal.Intrinsics;
import li.l0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements k2.b, RequestCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5548d;
    public final Object e;

    public h(i iVar, e2.a aVar, Iterable iterable, d2.d dVar, int i8) {
        this.f5546b = iVar;
        this.f5547c = aVar;
        this.f5548d = iterable;
        this.e = dVar;
        this.f5545a = i8;
    }

    public void a(o4.j jVar) {
        if (((HashSet) this.f5546b).contains(jVar.f8388a)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        ((HashSet) this.f5547c).add(jVar);
    }

    public o4.b b() {
        if (((o4.c) this.f5548d) != null) {
            return new o4.b(new HashSet((HashSet) this.f5546b), new HashSet((HashSet) this.f5547c), this.f5545a, (o4.c) this.f5548d, (HashSet) this.e);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    @Override // k2.b
    public Object execute() {
        Boolean bool;
        e2.a aVar = (e2.a) this.f5547c;
        e2.c cVar = e2.c.TRANSIENT_ERROR;
        Iterable iterable = (Iterable) this.f5548d;
        d2.d dVar = (d2.d) this.e;
        e2.c cVar2 = aVar.f4660a;
        i iVar = (i) this.f5546b;
        if (cVar2 == cVar) {
            j2.h hVar = (j2.h) iVar.f5551c;
            hVar.getClass();
            if (iterable.iterator().hasNext()) {
                String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + j2.h.i(iterable);
                SQLiteDatabase sQLiteDatabaseA = hVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    sQLiteDatabaseA.compileStatement(str).execute();
                    sQLiteDatabaseA.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable th2) {
                    sQLiteDatabaseA.endTransaction();
                    throw th2;
                }
            }
            iVar.f5552d.a(dVar, this.f5545a + 1, false);
            return null;
        }
        j2.h hVar2 = (j2.h) iVar.f5551c;
        hVar2.getClass();
        if (iterable.iterator().hasNext()) {
            hVar2.a().compileStatement("DELETE FROM events WHERE _id in " + j2.h.i(iterable)).execute();
        }
        e2.c cVar3 = e2.c.OK;
        j2.c cVar4 = iVar.f5551c;
        if (cVar2 == cVar3) {
            long jA = iVar.f5553g.a() + aVar.f4661b;
            j2.h hVar3 = (j2.h) cVar4;
            hVar3.getClass();
            hVar3.g(new af.i(jA, dVar));
        }
        j2.h hVar4 = (j2.h) cVar4;
        SQLiteDatabase sQLiteDatabaseA2 = hVar4.a();
        sQLiteDatabaseA2.beginTransaction();
        try {
            Long lC = j2.h.c(sQLiteDatabaseA2, dVar);
            if (lC == null) {
                bool = Boolean.FALSE;
            } else {
                Cursor cursorRawQuery = hVar4.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lC.toString()});
                try {
                    Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                    cursorRawQuery.close();
                    bool = boolValueOf;
                } catch (Throwable th3) {
                    cursorRawQuery.close();
                    throw th3;
                }
            }
            sQLiteDatabaseA2.setTransactionSuccessful();
            sQLiteDatabaseA2.endTransaction();
            if (!bool.booleanValue()) {
                return null;
            }
            iVar.f5552d.a(dVar, 1, true);
            return null;
        } catch (Throwable th4) {
            sQLiteDatabaseA2.endTransaction();
            throw th4;
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.http.RequestCallback
    public void onResult(int i8, Object obj, String str) {
        FunctionGuideResponse functionGuideResponse = (FunctionGuideResponse) obj;
        if (i8 != 0 || functionGuideResponse == null) {
            Log.e("CacheDataSource", "checkFunctionGuideResourceUpdate failed, code: " + i8 + ", msg: " + str);
            return;
        }
        jb.e eVar = (jb.e) this.f5546b;
        eVar.f6134b.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter("sp_check_update_time", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("sp_check_update_time", jCurrentTimeMillis);
        editorEdit.apply();
        Log.d("CacheDataSource", "checkFunctionGuideResourceUpdate success");
        l0.p(eVar, null, null, new jb.c(functionGuideResponse, this.f5545a, eVar, (String) this.e, (String) this.f5547c, (String) this.f5548d, null), 3);
    }

    public h(jb.e eVar, int i8, String str, String str2, String str3) {
        this.f5546b = eVar;
        this.f5545a = i8;
        this.f5547c = str;
        this.f5548d = str2;
        this.e = str3;
    }

    public h(Class cls, Class[] clsArr) {
        HashSet hashSet = new HashSet();
        this.f5546b = hashSet;
        this.f5547c = new HashSet();
        this.f5545a = 0;
        this.e = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            fc.a(cls2, "Null interface");
        }
        Collections.addAll((HashSet) this.f5546b, clsArr);
    }
}
