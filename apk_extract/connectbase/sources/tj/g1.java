package tj;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 implements sj.o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f15613h = "merge of ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0 f15617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f15619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f15620g;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15621a;

        static {
            int[] iArr = new int[z0.c.values().length];
            f15621a = iArr;
            try {
                iArr[z0.c.ORIGIN_DESCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15621a[z0.c.ORIGIN_LINE_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15621a[z0.c.ORIGIN_END_LINE_NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15621a[z0.c.ORIGIN_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15621a[z0.c.ORIGIN_URL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15621a[z0.c.ORIGIN_RESOURCE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15621a[z0.c.ORIGIN_COMMENTS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15621a[z0.c.ORIGIN_NULL_URL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15621a[z0.c.ORIGIN_NULL_RESOURCE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15621a[z0.c.ORIGIN_NULL_COMMENTS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15621a[z0.c.END_MARKER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15621a[z0.c.ROOT_VALUE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f15621a[z0.c.ROOT_WAS_CONFIG.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f15621a[z0.c.UNKNOWN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f15621a[z0.c.VALUE_DATA.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f15621a[z0.c.VALUE_ORIGIN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public g1(String str, int i10, int i11, n0 n0Var, String str2, String str3, List<String> list) {
        if (str == null) {
            throw new sj.c.d("description may not be null");
        }
        this.f15614a = str;
        this.f15615b = i10;
        this.f15616c = i11;
        this.f15617d = n0Var;
        this.f15618e = str2;
        this.f15619f = str3;
        this.f15620g = list;
    }

    public static Map<z0.c, Object> h(Map<z0.c, Object> map, Map<z0.c, Object> map2) throws IOException {
        EnumMap enumMap = new EnumMap(map2);
        Iterator<Map.Entry<z0.c, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            z0.c key = it.next().getKey();
            if (!map2.containsKey(key)) {
                switch (a.f15621a[key.ordinal()]) {
                    case 1:
                        enumMap.put(key, map.get(key));
                        break;
                    case 2:
                    case 3:
                    case 4:
                        enumMap.put(key, map.get(key));
                        break;
                    case 5:
                        z0.c cVar = z0.c.ORIGIN_NULL_URL;
                        if (!map2.containsKey(cVar)) {
                            enumMap.put(key, map.get(key));
                        } else {
                            enumMap.remove(cVar);
                        }
                        break;
                    case 6:
                        z0.c cVar2 = z0.c.ORIGIN_NULL_RESOURCE;
                        if (!map2.containsKey(cVar2)) {
                            enumMap.put(key, map.get(key));
                        } else {
                            enumMap.remove(cVar2);
                        }
                        break;
                    case 7:
                        z0.c cVar3 = z0.c.ORIGIN_NULL_COMMENTS;
                        if (!map2.containsKey(cVar3)) {
                            enumMap.put(key, map.get(key));
                        } else {
                            enumMap.remove(cVar3);
                        }
                        break;
                    case 8:
                    case 9:
                    case 10:
                        throw new sj.c.d("applying fields, base object should not contain " + key + " " + map);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        throw new sj.c.d("should not appear here: " + key);
                }
            }
        }
        return enumMap;
    }

    public static Map<z0.c, Object> i(Map<z0.c, Object> map, Map<z0.c, Object> map2) {
        EnumMap enumMap = new EnumMap(map2);
        for (Map.Entry<z0.c, Object> entry : map.entrySet()) {
            z0.c key = entry.getKey();
            if (enumMap.containsKey(key) && n.b(entry.getValue(), enumMap.get(key))) {
                enumMap.remove(key);
            } else if (enumMap.containsKey(key)) {
                continue;
            } else {
                switch (a.f15621a[key.ordinal()]) {
                    case 1:
                        throw new sj.c.d("origin missing description field? " + map2);
                    case 2:
                        enumMap.put(z0.c.ORIGIN_LINE_NUMBER, -1);
                        break;
                    case 3:
                        enumMap.put(z0.c.ORIGIN_END_LINE_NUMBER, -1);
                        break;
                    case 4:
                        throw new sj.c.d("should always be an ORIGIN_TYPE field");
                    case 5:
                        enumMap.put(z0.c.ORIGIN_NULL_URL, "");
                        break;
                    case 6:
                        enumMap.put(z0.c.ORIGIN_NULL_RESOURCE, "");
                        break;
                    case 7:
                        enumMap.put(z0.c.ORIGIN_NULL_COMMENTS, "");
                        break;
                    case 8:
                    case 9:
                    case 10:
                        throw new sj.c.d("computing delta, base object should not contain " + key + " " + map);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        throw new sj.c.d("should not appear here: " + key);
                }
            }
        }
        return enumMap;
    }

    public static g1 j(g1 g1Var, Map<z0.c, Object> map) throws IOException {
        return k(h(g1Var != null ? g1Var.x() : Collections.emptyMap(), map));
    }

    public static g1 k(Map<z0.c, Object> map) throws IOException {
        if (map.isEmpty()) {
            return null;
        }
        String str = (String) map.get(z0.c.ORIGIN_DESCRIPTION);
        Integer num = (Integer) map.get(z0.c.ORIGIN_LINE_NUMBER);
        Integer num2 = (Integer) map.get(z0.c.ORIGIN_END_LINE_NUMBER);
        Number number = (Number) map.get(z0.c.ORIGIN_TYPE);
        if (number == null) {
            throw new IOException("Missing ORIGIN_TYPE field");
        }
        n0 n0Var = n0.values()[number.byteValue()];
        String str2 = (String) map.get(z0.c.ORIGIN_URL);
        String str3 = (String) map.get(z0.c.ORIGIN_RESOURCE);
        List list = (List) map.get(z0.c.ORIGIN_COMMENTS);
        return new g1(str, num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1, n0Var, str2, (n0Var == n0.RESOURCE && str3 == null) ? str : str3, list);
    }

    public static sj.o l(Collection<? extends sj.o> collection) {
        if (collection.isEmpty()) {
            throw new sj.c.d("can't merge empty list of origins");
        }
        if (collection.size() == 1) {
            return collection.iterator().next();
        }
        if (collection.size() == 2) {
            Iterator<? extends sj.o> it = collection.iterator();
            return p((g1) it.next(), (g1) it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<? extends sj.o> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add((g1) it2.next());
        }
        while (arrayList.size() > 2) {
            g1 g1Var = (g1) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            g1 g1Var2 = (g1) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            g1 g1Var3 = (g1) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            arrayList.add(o(g1Var3, g1Var2, g1Var));
        }
        return l(arrayList);
    }

    public static sj.o m(List<? extends d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<? extends d> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().origin());
        }
        return l(arrayList);
    }

    public static sj.o n(sj.o oVar, sj.o oVar2) {
        return p((g1) oVar, (g1) oVar2);
    }

    public static g1 o(g1 g1Var, g1 g1Var2, g1 g1Var3) {
        return w(g1Var, g1Var2) >= w(g1Var2, g1Var3) ? p(p(g1Var, g1Var2), g1Var3) : p(g1Var, p(g1Var2, g1Var3));
    }

    public static g1 p(g1 g1Var, g1 g1Var2) {
        String str;
        int i10;
        int iMax;
        List<String> list;
        n0 n0Var = g1Var.f15617d;
        if (n0Var != g1Var2.f15617d) {
            n0Var = n0.GENERIC;
        }
        n0 n0Var2 = n0Var;
        String strSubstring = g1Var.f15614a;
        String strSubstring2 = g1Var2.f15614a;
        if (strSubstring.startsWith(f15613h)) {
            strSubstring = strSubstring.substring(9);
        }
        if (strSubstring2.startsWith(f15613h)) {
            strSubstring2 = strSubstring2.substring(9);
        }
        if (strSubstring.equals(strSubstring2)) {
            int iMin = g1Var.f15615b;
            if (iMin < 0) {
                iMin = g1Var2.f15615b;
            } else {
                int i11 = g1Var2.f15615b;
                if (i11 >= 0) {
                    iMin = Math.min(iMin, i11);
                }
            }
            i10 = iMin;
            iMax = Math.max(g1Var.f15616c, g1Var2.f15616c);
            str = strSubstring;
        } else {
            String strDescription = g1Var.description();
            String strDescription2 = g1Var2.description();
            if (strDescription.startsWith(f15613h)) {
                strDescription = strDescription.substring(9);
            }
            if (strDescription2.startsWith(f15613h)) {
                strDescription2 = strDescription2.substring(9);
            }
            str = f15613h + strDescription + ks.g.f9491d + strDescription2;
            i10 = -1;
            iMax = -1;
        }
        String str2 = n.b(g1Var.f15618e, g1Var2.f15618e) ? g1Var.f15618e : null;
        String str3 = n.b(g1Var.f15619f, g1Var2.f15619f) ? g1Var.f15619f : null;
        if (n.b(g1Var.f15620g, g1Var2.f15620g)) {
            list = g1Var.f15620g;
        } else {
            ArrayList arrayList = new ArrayList();
            List<String> list2 = g1Var.f15620g;
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            List<String> list3 = g1Var2.f15620g;
            if (list3 != null) {
                arrayList.addAll(list3);
            }
            list = arrayList;
        }
        return new g1(str, i10, iMax, n0Var2, str2, str3, list);
    }

    public static g1 q(String str) {
        String externalForm;
        try {
            externalForm = new File(str).toURI().toURL().toExternalForm();
        } catch (MalformedURLException unused) {
            externalForm = null;
        }
        return new g1(str, -1, -1, n0.FILE, externalForm, null, null);
    }

    public static g1 r(String str) {
        return s(str, null);
    }

    public static g1 s(String str, URL url) {
        String string;
        if (url != null) {
            StringBuilder sbA = k.c.a(str, " @ ");
            sbA.append(url.toExternalForm());
            string = sbA.toString();
        } else {
            string = str;
        }
        return new g1(string, -1, -1, n0.RESOURCE, url != null ? url.toExternalForm() : null, str, null);
    }

    public static g1 t(String str) {
        return new g1(str, -1, -1, n0.GENERIC, null, null, null);
    }

    public static g1 u(URL url) {
        String externalForm = url.toExternalForm();
        return new g1(externalForm, -1, -1, n0.URL, externalForm, null, null);
    }

    public static int w(g1 g1Var, g1 g1Var2) {
        int i10 = g1Var.f15617d == g1Var2.f15617d ? 1 : 0;
        if (!g1Var.f15614a.equals(g1Var2.f15614a)) {
            return i10;
        }
        int i11 = i10 + 1;
        if (g1Var.f15615b == g1Var2.f15615b) {
            i11 = i10 + 2;
        }
        if (g1Var.f15616c == g1Var2.f15616c) {
            i11++;
        }
        if (n.b(g1Var.f15618e, g1Var2.f15618e)) {
            i11++;
        }
        int i12 = i11;
        return n.b(g1Var.f15619f, g1Var2.f15619f) ? i12 + 1 : i12;
    }

    @Override // sj.o
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public g1 d(int i10) {
        return (i10 == this.f15615b && i10 == this.f15616c) ? this : new g1(this.f15614a, i10, i10, this.f15617d, this.f15618e, this.f15619f, this.f15620g);
    }

    @Override // sj.o
    public String a() {
        if (this.f15617d == n0.FILE) {
            return this.f15614a;
        }
        if (this.f15618e != null) {
            try {
                URL url = new URL(this.f15618e);
                if (url.getProtocol().equals("file")) {
                    return url.getFile();
                }
            } catch (MalformedURLException unused) {
            }
        }
        return null;
    }

    @Override // sj.o
    public int b() {
        return this.f15615b;
    }

    @Override // sj.o
    public List<String> comments() {
        List<String> list = this.f15620g;
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    @Override // sj.o
    public String description() {
        int i10 = this.f15615b;
        if (i10 < 0) {
            return this.f15614a;
        }
        if (this.f15616c == i10) {
            return this.f15614a + ": " + this.f15615b;
        }
        return this.f15614a + ": " + this.f15615b + "-" + this.f15616c;
    }

    @Override // sj.o
    public String e() {
        return this.f15619f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return this.f15614a.equals(g1Var.f15614a) && this.f15615b == g1Var.f15615b && this.f15616c == g1Var.f15616c && this.f15617d == g1Var.f15617d && n.b(this.f15618e, g1Var.f15618e) && n.b(this.f15619f, g1Var.f15619f);
    }

    public g1 f(URL url) {
        return new g1(this.f15614a, this.f15615b, this.f15616c, this.f15617d, url != null ? url.toExternalForm() : null, this.f15619f, this.f15620g);
    }

    public g1 g(List<String> list) {
        if (n.b(list, this.f15620g) || list == null) {
            return this;
        }
        if (this.f15620g == null) {
            return c(list);
        }
        ArrayList arrayList = new ArrayList(this.f15620g.size() + list.size());
        arrayList.addAll(this.f15620g);
        arrayList.addAll(list);
        return c(arrayList);
    }

    public int hashCode() {
        int iHashCode = (this.f15617d.hashCode() + ((((s0.b.a(this.f15614a, 41, 41) + this.f15615b) * 41) + this.f15616c) * 41)) * 41;
        String str = this.f15618e;
        if (str != null) {
            iHashCode = s0.b.a(str, iHashCode, 41);
        }
        String str2 = this.f15619f;
        return str2 != null ? s0.b.a(str2, iHashCode, 41) : iHashCode;
    }

    public String toString() {
        return j.c.a(new StringBuilder("ConfigOrigin("), this.f15614a, ")");
    }

    @Override // sj.o
    public URL url() {
        if (this.f15618e == null) {
            return null;
        }
        try {
            return new URL(this.f15618e);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public g1 v(List<String> list) {
        if (n.b(list, this.f15620g) || list == null) {
            return this;
        }
        if (this.f15620g == null) {
            return c(list);
        }
        ArrayList arrayList = new ArrayList(this.f15620g.size() + list.size());
        arrayList.addAll(list);
        arrayList.addAll(this.f15620g);
        return c(arrayList);
    }

    public Map<z0.c, Object> x() {
        EnumMap enumMap = new EnumMap(z0.c.class);
        enumMap.put(z0.c.ORIGIN_DESCRIPTION, this.f15614a);
        int i10 = this.f15615b;
        if (i10 >= 0) {
            enumMap.put(z0.c.ORIGIN_LINE_NUMBER, Integer.valueOf(i10));
        }
        int i11 = this.f15616c;
        if (i11 >= 0) {
            enumMap.put(z0.c.ORIGIN_END_LINE_NUMBER, Integer.valueOf(i11));
        }
        enumMap.put(z0.c.ORIGIN_TYPE, Integer.valueOf(this.f15617d.ordinal()));
        String str = this.f15618e;
        if (str != null) {
            enumMap.put(z0.c.ORIGIN_URL, str);
        }
        String str2 = this.f15619f;
        if (str2 != null) {
            enumMap.put(z0.c.ORIGIN_RESOURCE, str2);
        }
        List<String> list = this.f15620g;
        if (list != null) {
            enumMap.put(z0.c.ORIGIN_COMMENTS, list);
        }
        return enumMap;
    }

    public Map<z0.c, Object> y(g1 g1Var) {
        return i(g1Var != null ? g1Var.x() : Collections.emptyMap(), x());
    }

    @Override // sj.o
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public g1 c(List<String> list) {
        return n.b(list, this.f15620g) ? this : new g1(this.f15614a, this.f15615b, this.f15616c, this.f15617d, this.f15618e, this.f15619f, list);
    }
}
