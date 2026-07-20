package f8;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.util.ArrayMap;
import com.android.internal.annotations.VisibleForTesting;
import dc.e;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wa.d;

/* JADX INFO: loaded from: classes2.dex */
public class a implements qg.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5913f = "a";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f5914g = cc.a.a("android.os.storage.StorageManager");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Class<?> f5915h = cc.a.a("android.os.storage.VolumeInfo");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Class<?> f5916i = cc.a.a("android.os.storage.DiskInfo");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f5918b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f5920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public StorageManager f5921e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f5917a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayMap<wa.b.a, C0140a> f5919c = new ArrayMap<>();

    /* JADX INFO: renamed from: f8.a$a, reason: collision with other inner class name */
    public class C0140a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wa.b.a f5922a;

        public C0140a(wa.b.a aVar) {
            this.f5922a = aVar;
        }

        @Override // f8.b.a
        public void a(String str, String str2, String str3) {
            this.f5922a.a(str, str2, str3);
        }

        @Override // f8.b.a
        public void b(b.c cVar, int i10, int i11) {
            d dVar = new d(cVar.c(), cVar.d(), cVar.b(), cVar.f5932d);
            dVar.f18253f = cVar.a();
            dVar.f18250c = cVar.f5934f;
            this.f5922a.b(dVar, i10, i11);
        }
    }

    public a() {
        Context contextA = bc.a.a();
        this.f5918b = contextA;
        this.f5920d = new b(contextA);
    }

    @Override // qg.a
    public String a(String str) {
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        try {
            Method methodG = cc.a.g(f5914g, "getVolumeState", String.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageManager, str);
            if (objInvoke == null || !(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e.c(f5913f, "getVolumeState: " + e10);
            return null;
        }
    }

    @Override // qg.a
    public long b() {
        if (this.f5921e == null) {
            this.f5921e = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        }
        Object objJ = cc.a.j(cc.a.g(f5914g, "getStorageLowBytes", File.class), this.f5921e, Environment.getDataDirectory());
        if (objJ == null || !(objJ instanceof Long)) {
            return 0L;
        }
        return ((Long) objJ).longValue();
    }

    @Override // qg.a
    public void c(wa.b.a aVar) {
        C0140a c0140a = this.f5919c.get(aVar);
        if (c0140a != null) {
            this.f5920d.b(c0140a);
        }
        this.f5919c.remove(aVar);
    }

    @Override // qg.a
    public List<d> d() {
        boolean z10;
        wa.a aVar;
        String str;
        if (this.f5917a == null) {
            this.f5917a = cc.a.g(f5914g, "getVolumes", new Class[0]);
        }
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        ArrayList arrayList = new ArrayList();
        try {
            boolean z11 = true;
            this.f5917a.setAccessible(true);
            Object objInvoke = this.f5917a.invoke(storageManager, null);
            List list = (objInvoke == null || !(objInvoke instanceof List)) ? null : (List) objInvoke;
            Method methodG = cc.a.g(f5915h, "getId", new Class[0]);
            Method methodG2 = cc.a.g(f5915h, "getType", new Class[0]);
            Method methodG3 = cc.a.g(f5915h, "getState", new Class[0]);
            Method methodG4 = cc.a.g(f5915h, "getFsUuid", new Class[0]);
            Method methodG5 = cc.a.g(f5915h, "getPath", new Class[0]);
            Method methodG6 = cc.a.g(f5915h, "getDescription", new Class[0]);
            Method methodG7 = cc.a.g(f5915h, "getDisk", new Class[0]);
            Method methodG8 = cc.a.g(f5916i, "getId", new Class[0]);
            Field fieldD = cc.a.d(f5916i, "flags");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (f5915h.isInstance(next)) {
                    e.f(f5913f, "tranVolumeInfo object :" + next);
                }
                methodG.setAccessible(z11);
                Object objInvoke2 = methodG.invoke(next, null);
                String str2 = (objInvoke2 == null || !(objInvoke2 instanceof String)) ? null : (String) objInvoke2;
                methodG2.setAccessible(z11);
                Object objInvoke3 = methodG2.invoke(next, null);
                int iIntValue = (objInvoke3 == null || !(objInvoke3 instanceof Integer)) ? 0 : ((Integer) objInvoke3).intValue();
                methodG3.setAccessible(z11);
                Object objInvoke4 = methodG3.invoke(next, null);
                int iIntValue2 = (objInvoke4 == null || !(objInvoke4 instanceof Integer)) ? 0 : ((Integer) objInvoke4).intValue();
                methodG4.setAccessible(true);
                Iterator it2 = it;
                Object objInvoke5 = methodG4.invoke(next, null);
                String str3 = (objInvoke5 == null || !(objInvoke5 instanceof String)) ? null : (String) objInvoke5;
                methodG5.setAccessible(true);
                Method method = methodG;
                Object objInvoke6 = methodG5.invoke(next, null);
                File file = (objInvoke6 == null || !(objInvoke6 instanceof File)) ? null : (File) objInvoke6;
                methodG6.setAccessible(true);
                Method method2 = methodG2;
                Object objInvoke7 = methodG6.invoke(next, null);
                String str4 = (objInvoke7 == null || !(objInvoke7 instanceof String)) ? null : (String) objInvoke7;
                methodG7.setAccessible(true);
                Object objInvoke8 = methodG7.invoke(next, null);
                d dVar = new d(str2, iIntValue, str3, file != null ? file.getPath() : null);
                dVar.f18250c = iIntValue2;
                dVar.f18253f = str4;
                if (objInvoke8 != null) {
                    methodG8.setAccessible(true);
                    Object objInvoke9 = methodG8.invoke(objInvoke8, null);
                    if (objInvoke9 == null || !(objInvoke9 instanceof String)) {
                        z10 = true;
                        str = null;
                    } else {
                        str = (String) objInvoke9;
                        z10 = true;
                    }
                    fieldD.setAccessible(z10);
                    Object obj = fieldD.get(objInvoke8);
                    aVar = new wa.a(str, (obj == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue());
                } else {
                    z10 = true;
                    aVar = null;
                }
                dVar.f18254g = aVar;
                arrayList.add(dVar);
                z11 = z10;
                methodG = method;
                methodG2 = method2;
                it = it2;
            }
            return arrayList;
        } catch (Throwable th2) {
            m7.a.a("getVolumes: ", th2, f5913f);
            return null;
        }
    }

    @Override // qg.a
    public void e(wa.b.a aVar) {
        C0140a c0140a = new C0140a(aVar);
        this.f5919c.put(aVar, c0140a);
        this.f5920d.a(c0140a);
    }

    @Override // qg.a
    public List<d> f() {
        if (this.f5917a == null) {
            this.f5917a = cc.a.g(f5914g, "getVolumes", new Class[0]);
        }
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        ArrayList arrayList = new ArrayList();
        try {
            Object objJ = cc.a.j(this.f5917a, storageManager, new Object[0]);
            List list = (objJ == null || !(objJ instanceof List)) ? null : (List) objJ;
            Method methodG = cc.a.g(f5915h, "getId", new Class[0]);
            Method methodG2 = cc.a.g(f5915h, "getType", new Class[0]);
            Field fieldD = cc.a.d(f5915h, "mountFlags");
            for (Object obj : list) {
                if (f5915h.isInstance(obj)) {
                    e.f(f5913f, "tranVolumeInfo object :" + obj);
                }
                Object objJ2 = cc.a.j(methodG, obj, new Object[0]);
                String str = (objJ2 == null || !(objJ2 instanceof String)) ? null : (String) objJ2;
                Object objJ3 = cc.a.j(methodG2, obj, new Object[0]);
                arrayList.add(new d(str, (objJ3 == null || !(objJ3 instanceof Integer)) ? 0 : ((Integer) objJ3).intValue(), ((Integer) cc.a.f(fieldD, obj)).intValue()));
            }
            return arrayList;
        } catch (Throwable th2) {
            m7.a.a("getVolumesExt fail: ", th2, f5913f);
            return null;
        }
    }

    @Override // qg.a
    public StorageVolume[] g(int i10) {
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        try {
            Method methodG = cc.a.g(f5914g, "getVolumeList", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageManager, null);
            if (objInvoke != null && (objInvoke instanceof StorageVolume[])) {
                return (StorageVolume[]) objInvoke;
            }
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e.c(f5913f, "getVolumeList: " + e10);
        }
        return null;
    }

    @Override // qg.a
    public d h(String str) {
        wa.a aVar;
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        try {
            Method methodG = cc.a.g(f5914g, "findVolumeByUuid", String.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageManager, str);
            int iIntValue = 0;
            Method methodG2 = cc.a.g(f5915h, "getId", new Class[0]);
            Method methodG3 = cc.a.g(f5915h, "getType", new Class[0]);
            Method methodG4 = cc.a.g(f5915h, "getState", new Class[0]);
            Method methodG5 = cc.a.g(f5915h, "getFsUuid", new Class[0]);
            Method methodG6 = cc.a.g(f5915h, "getPath", new Class[0]);
            Method methodG7 = cc.a.g(f5915h, "getDescription", new Class[0]);
            Method methodG8 = cc.a.g(f5915h, "getDisk", new Class[0]);
            Method methodG9 = cc.a.g(f5916i, "getId", new Class[0]);
            Field fieldD = cc.a.d(f5916i, "flags");
            if (f5915h.isInstance(objInvoke)) {
                e.f(f5913f, "tranVolumeInfo object :" + objInvoke);
            }
            methodG2.setAccessible(true);
            Object objInvoke2 = methodG2.invoke(objInvoke, null);
            String str2 = (objInvoke2 == null || !(objInvoke2 instanceof String)) ? null : (String) objInvoke2;
            methodG3.setAccessible(true);
            Object objInvoke3 = methodG3.invoke(objInvoke, null);
            int iIntValue2 = (objInvoke3 == null || !(objInvoke3 instanceof Integer)) ? 0 : ((Integer) objInvoke3).intValue();
            methodG4.setAccessible(true);
            Object objInvoke4 = methodG4.invoke(objInvoke, null);
            int iIntValue3 = (objInvoke4 == null || !(objInvoke4 instanceof Integer)) ? 0 : ((Integer) objInvoke4).intValue();
            methodG5.setAccessible(true);
            Object objInvoke5 = methodG5.invoke(objInvoke, null);
            String str3 = (objInvoke5 == null || !(objInvoke5 instanceof String)) ? null : (String) objInvoke5;
            methodG6.setAccessible(true);
            Object objInvoke6 = methodG6.invoke(objInvoke, null);
            File file = (objInvoke6 == null || !(objInvoke6 instanceof File)) ? null : (File) objInvoke6;
            methodG7.setAccessible(true);
            Object objInvoke7 = methodG7.invoke(objInvoke, null);
            String str4 = (objInvoke7 == null || !(objInvoke7 instanceof String)) ? null : (String) objInvoke7;
            methodG8.setAccessible(true);
            Object objInvoke8 = methodG8.invoke(objInvoke, null);
            d dVar = new d(str2, iIntValue2, str3, file != null ? file.getPath() : null);
            dVar.f18250c = iIntValue3;
            dVar.f18253f = str4;
            if (objInvoke8 != null) {
                methodG9.setAccessible(true);
                Object objInvoke9 = methodG9.invoke(objInvoke8, null);
                String str5 = (objInvoke9 == null || !(objInvoke9 instanceof String)) ? null : (String) objInvoke9;
                fieldD.setAccessible(true);
                Object obj = fieldD.get(objInvoke8);
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
                aVar = new wa.a(str5, iIntValue);
            } else {
                aVar = null;
            }
            dVar.f18254g = aVar;
            return dVar;
        } catch (Throwable th2) {
            m7.a.a("findVolumeByUuid fail ", th2, f5913f);
            return null;
        }
    }

    @Override // qg.a
    public String i(d dVar) {
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        try {
            Method methodG = cc.a.g(f5914g, "getBestVolumeDescription", d.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageManager, dVar);
            if (objInvoke == null || !(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getBestVolumeDescription fail ", th2, f5913f);
            return null;
        }
    }

    @Override // qg.a
    public String[] j() {
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        try {
            Method methodG = cc.a.g(f5914g, "getVolumePaths", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageManager, null);
            if (objInvoke != null && (objInvoke instanceof String[])) {
                return (String[]) objInvoke;
            }
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e.c(f5913f, "getVolumePaths: " + e10);
        }
        return null;
    }

    @Override // qg.a
    public boolean k() {
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        try {
            Method methodG = !fc.a.g() ? cc.a.g(f5914g, "isFileEncryptedNativeOrEmulated", new Class[0]) : cc.a.g(f5914g, "isFileEncrypted", new Class[0]);
            if (methodG != null) {
                return Boolean.TRUE.equals(cc.a.j(methodG, storageManager, new Object[0]));
            }
        } catch (Throwable th2) {
            m7.a.a("isFileEncryptedNativeOrEmulated fail ", th2, f5913f);
        }
        return false;
    }

    @Override // qg.a
    public long l() {
        StorageManager storageManager = (StorageManager) this.f5918b.getSystemService(StorageManager.class);
        try {
            Method methodG = cc.a.g(f5914g, "getPrimaryStorageSize", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(storageManager, null);
            if (objInvoke == null || !(objInvoke instanceof Long)) {
                return 0L;
            }
            return ((Long) objInvoke).longValue();
        } catch (Throwable th2) {
            m7.a.a("getPrimaryStorageSize fail ", th2, f5913f);
            return 0L;
        }
    }

    @VisibleForTesting
    public void m(Context context) {
        this.f5918b = context;
    }
}
