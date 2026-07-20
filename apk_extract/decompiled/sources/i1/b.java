package i1;

import af.r5;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.transsion.core.log.ObjectLogUtils;
import j2.f;
import j2.g;
import j2.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.dd;
import nc.d;
import org.json.JSONObject;
import s6.c;
import s6.e;

/* JADX INFO: loaded from: classes.dex */
public final class b implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f5526c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f5527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5528b;

    public /* synthetic */ b(Object obj, Object obj2) {
        this.f5527a = obj;
        this.f5528b = obj2;
    }

    public Object a(Class cls, String str) {
        r5 r5Var = new r5(7);
        HashMap map = (HashMap) this.f5527a;
        for (Class cls2 : map.keySet()) {
            ((HashMap) r5Var.e).put(cls2, (oc.a) map.get(cls2));
        }
        HashMap map2 = (HashMap) this.f5528b;
        for (nc.f fVar : map2.keySet()) {
            ((HashMap) r5Var.f560h).put(fVar, (oc.a) map2.get(fVar));
        }
        return r5Var.b(new d(str).f(), cls);
    }

    @Override // j2.f
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        a2.b bVar = h.e;
        h hVar = (h) this.f5527a;
        hVar.getClass();
        ArrayList arrayList = new ArrayList();
        d2.d dVar = (d2.d) this.f5528b;
        Long lC = h.c(sQLiteDatabase, dVar);
        if (lC != null) {
            h.k(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lC.toString()}, null, null, null, String.valueOf(hVar.f6051d.f6036b)), new u6.a(hVar, 7, arrayList, dVar));
        }
        HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            sb2.append(((j2.b) arrayList.get(i8)).f6039a);
            if (i8 < arrayList.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        h.k(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null), new a8.a(map, 10));
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            j2.b bVar2 = (j2.b) listIterator.next();
            if (map.containsKey(Long.valueOf(bVar2.f6039a))) {
                d2.a aVarC = bVar2.f6041c.c();
                long j8 = bVar2.f6039a;
                for (g gVar : (Set) map.get(Long.valueOf(j8))) {
                    aVarC.a(gVar.f6046a, gVar.f6047b);
                }
                listIterator.set(new j2.b(j8, bVar2.f6040b, aVarC.b()));
            }
        }
        return arrayList;
    }

    public String b(String str) {
        String processName;
        boolean z2 = false;
        Context context = (Context) this.f5528b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (((SharedPreferences) this.f5527a) == null) {
            SharedPreferences sharedPreferences = null;
            try {
                try {
                    processName = Application.getProcessName();
                } catch (Exception e) {
                    ObjectLogUtils objectLogUtils = z6.a.f11258a;
                    z6.a.c(Log.getStackTraceString(e));
                    processName = null;
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(processName + "_tcrypto", 0);
                this.f5527a = sharedPreferences2;
                sharedPreferences = sharedPreferences2;
            } catch (Exception e4) {
                z6.a.c(Log.getStackTraceString(e4));
            }
            this.f5527a = sharedPreferences;
        }
        if (((SharedPreferences) this.f5527a) == null) {
            throw new Exception("sp is null");
        }
        synchronized (bd.b.class) {
        }
        if (!bd.a.f1269a.e()) {
            throw new Exception("keystore decrypt error");
        }
        String string = ((SharedPreferences) this.f5527a).getString(str, "");
        if (TextUtils.isEmpty(string) || string.contains("_")) {
            return "";
        }
        String str2 = new String(new u6.a(3, z2).y(Base64.decode(string, 2)));
        if (TextUtils.isEmpty(str2)) {
            throw new Exception("rsaCrypter decrypt error");
        }
        return str2;
    }

    public c c(int i8) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = (CopyOnWriteArrayList) this.f5528b;
        if (!dd.i(copyOnWriteArrayList)) {
            return null;
        }
        for (c cVar : copyOnWriteArrayList) {
            if (cVar.f9529a == i8) {
                return cVar;
            }
        }
        return null;
    }

    public String d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("global_config", ((e) this.f5527a).c());
            return jSONObject.toString();
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            e8.d.a("toJSON", e);
            return "";
        }
    }

    public b(int i8) {
        switch (i8) {
            case 5:
                this.f5527a = new e();
                this.f5528b = new CopyOnWriteArrayList();
                break;
            default:
                this.f5527a = new HashMap();
                this.f5528b = new HashMap();
                break;
        }
    }
}
