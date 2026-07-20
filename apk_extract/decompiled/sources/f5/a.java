package f5;

import af.t1;
import com.google.android.gms.common.api.Status;
import dj.j0;
import j3.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import k3.tc;
import l9.b;
import p001if.q;
import q3.g;
import qj.f;
import qj.j;
import qj.p;
import v1.d;
import ze.a1;
import ze.r;
import zj.s;
import zj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements a1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f4983c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4985b;

    public /* synthetic */ a(Object obj, Object obj2) {
        this.f4985b = obj;
        this.f4984a = obj2;
    }

    public static String d(String str, Locale locale) {
        return (str == null || str.equals("ZZ") || str.equals("001")) ? "" : new Locale("", str).getDisplayCountry(locale);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003a A[Catch: IOException -> 0x005b, TryCatch #0 {IOException -> 0x005b, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:27:0x005d), top: B:31:0x0000 }] */
    public static a g(String... strArr) {
        String str;
        try {
            j[] jVarArr = new j[strArr.length];
            f fVar = new f();
            for (int i8 = 0; i8 < strArr.length; i8++) {
                String str2 = strArr[i8];
                String[] strArr2 = d.e;
                fVar.S(34);
                int length = str2.length();
                int i9 = 0;
                for (int i10 = 0; i10 < length; i10++) {
                    char cCharAt = str2.charAt(i10);
                    if (cCharAt < 128) {
                        str = strArr2[cCharAt];
                        if (str != null) {
                            if (i9 < i10) {
                                fVar.l0(i9, i10, str2);
                            }
                            fVar.m0(str);
                            i9 = i10 + 1;
                        }
                    } else {
                        if (cCharAt == 8232) {
                            str = "\\u2028";
                        } else if (cCharAt == 8233) {
                            str = "\\u2029";
                        }
                        if (i9 < i10) {
                            fVar.l0(i9, i10, str2);
                        }
                        fVar.m0(str);
                        i9 = i10 + 1;
                    }
                }
                if (i9 < length) {
                    fVar.l0(i9, length, str2);
                }
                fVar.S(34);
                fVar.readByte();
                jVarArr[i8] = fVar.o(fVar.f9195b);
            }
            String[] strArr3 = (String[]) strArr.clone();
            int i11 = p.f9208c;
            p pVarB = tc.b(jVarArr);
            a aVar = new a();
            aVar.f4984a = strArr3;
            aVar.f4985b = pVarB;
            return aVar;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // ze.a1
    public void a(r rVar) {
        q qVar = (q) this.f4985b;
        qVar.f5837g = rVar;
        if (qVar.f) {
            return;
        }
        ((a1) this.f4984a).a(rVar);
    }

    public void b(Throwable th2) {
        try {
            ((zj.f) this.f4984a).onFailure(th2);
        } catch (Throwable th3) {
            s.p(th3);
            th3.printStackTrace();
        }
    }

    public String c(e5.p pVar, Locale locale) {
        Integer numValueOf = Integer.valueOf(pVar.getCountryCode());
        e5.f fVar = (e5.f) this.f4985b;
        List arrayList = (List) fVar.f4690b.get(numValueOf);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        if (listUnmodifiableList.size() == 1) {
            return d((String) listUnmodifiableList.get(0), locale);
        }
        String str = "ZZ";
        for (String str2 : listUnmodifiableList) {
            int countryCode = pVar.getCountryCode();
            e5.j jVarE = fVar.e(countryCode, str2);
            if (jVarE != null) {
                if (!"001".equals(str2)) {
                    e5.j jVarD = fVar.d(str2);
                    if (jVarD == null) {
                        throw new IllegalArgumentException(h0.a.i("Invalid region code: ", str2));
                    }
                    if (countryCode != jVarD.getCountryCode()) {
                        continue;
                    }
                }
                if (fVar.h(e5.f.f(pVar), jVarE) == e5.d.UNKNOWN) {
                    continue;
                } else {
                    if (!str.equals("ZZ")) {
                        return "";
                    }
                    str = str2;
                }
            }
        }
        return d(str, locale);
    }

    public ea.a e() {
        if (b.a(l9.a.f7345d)) {
            t9.a aVar = (t9.a) this.f4984a;
            if (aVar != null) {
                return aVar;
            }
            t9.a aVar2 = new t9.a();
            this.f4984a = aVar2;
            return aVar2;
        }
        j9.a.c("a", "TranAospStatusBarManager");
        o8.a aVar3 = (o8.a) this.f4985b;
        if (aVar3 != null) {
            return aVar3;
        }
        o8.a aVar4 = new o8.a();
        aVar4.f8413a = z.f6093b;
        this.f4985b = aVar4;
        return aVar4;
    }

    public void f(String str, String str2) {
        t1 t1Var = (t1) this.f4985b;
        t1Var.getClass();
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt <= 31 || cCharAt >= 127) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i9), str));
            }
        }
        if (str2 == null) {
            throw new IllegalArgumentException("value == null");
        }
        int length2 = str2.length();
        for (int i10 = 0; i10 < length2; i10++) {
            char cCharAt2 = str2.charAt(i10);
            if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i10), str2));
            }
        }
        while (true) {
            ArrayList arrayList = t1Var.f594b;
            if (i8 >= arrayList.size()) {
                arrayList.add(str);
                arrayList.add(str2.trim());
                return;
            } else {
                if (str.equalsIgnoreCase((String) arrayList.get(i8))) {
                    arrayList.remove(i8);
                    arrayList.remove(i8);
                    i8 -= 2;
                }
                i8 += 2;
            }
        }
    }

    public void h(j0 j0Var) {
        w wVar = (w) this.f4985b;
        try {
            try {
                ((zj.f) this.f4984a).d(wVar, wVar.c(j0Var));
            } catch (Throwable th2) {
                s.p(th2);
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            s.p(th3);
            b(th3);
        }
    }

    public void i(boolean z2, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f4984a)) {
            map = new HashMap((Map) this.f4984a);
        }
        synchronized (((Map) this.f4985b)) {
            map2 = new HashMap((Map) this.f4985b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((g) entry2.getKey()).a(new q2.d(status));
            }
        }
    }

    public a(int i8) {
        switch (i8) {
            case 5:
                this.f4984a = Collections.synchronizedMap(new WeakHashMap());
                this.f4985b = Collections.synchronizedMap(new WeakHashMap());
                break;
            default:
                this.f4985b = e5.f.c();
                this.f4984a = new k5.f();
                break;
        }
    }
}
