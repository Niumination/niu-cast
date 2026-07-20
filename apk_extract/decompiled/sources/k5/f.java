package k5;

import e5.p;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final Logger e = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f6776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f6777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i5.a f6778d;

    public f() throws Throwable {
        c cVar = new c();
        this.f6776b = cVar;
        this.f6777c = new HashMap();
        this.f6775a = "/com/google/i18n/phonenumbers/geocoding/data/";
        i5.a aVar = h5.a.f5260d.f5262b;
        this.f6778d = aVar;
        InputStream inputStreamA = aVar.a("/com/google/i18n/phonenumbers/geocoding/data/config");
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(inputStreamA);
                try {
                    cVar.readExternal(objectInputStream2);
                    a(objectInputStream2);
                } catch (IOException e4) {
                    e = e4;
                    objectInputStream = objectInputStream2;
                    e.log(Level.WARNING, e.toString());
                    a(objectInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    a(objectInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e10) {
            e = e10;
        }
    }

    public static void a(ObjectInputStream objectInputStream) {
        if (objectInputStream != null) {
            try {
                objectInputStream.close();
            } catch (IOException e4) {
                e.log(Level.WARNING, e4.toString());
            }
        }
    }

    public final String b(p pVar, String str, String str2) throws Throwable {
        int countryCode = pVar.getCountryCode();
        if (countryCode == 1) {
            countryCode = ((int) (pVar.getNationalNumber() / 10000000)) + 1000;
        }
        d dVarC = c(countryCode, str, str2);
        String strLookup = dVarC != null ? dVarC.lookup(pVar) : null;
        if ((strLookup == null || strLookup.length() == 0) && !str.equals("zh") && !str.equals("ja") && !str.equals("ko")) {
            d dVarC2 = c(countryCode, "en", "");
            if (dVarC2 == null) {
                return "";
            }
            strLookup = dVarC2.lookup(pVar);
        }
        return strLookup != null ? strLookup : "";
    }

    public final d c(int i8, String str, String str2) throws Throwable {
        String fileName = this.f6776b.getFileName(i8, str, "", str2);
        ObjectInputStream objectInputStream = null;
        if (fileName.length() == 0) {
            return null;
        }
        HashMap map = this.f6777c;
        if (!map.containsKey(fileName)) {
            try {
                try {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(this.f6778d.a(this.f6775a + fileName));
                    try {
                        d dVar = new d();
                        dVar.readExternal(objectInputStream2);
                        map.put(fileName, dVar);
                        a(objectInputStream2);
                    } catch (IOException e4) {
                        e = e4;
                        objectInputStream = objectInputStream2;
                        e.log(Level.WARNING, e.toString());
                        a(objectInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = objectInputStream2;
                        a(objectInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e10) {
                e = e10;
            }
        }
        return (d) map.get(fileName);
    }
}
