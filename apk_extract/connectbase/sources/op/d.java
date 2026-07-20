package op;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.w;
import nm.h0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f12368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f12369d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f12374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f12376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f12378m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f12379n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12380o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12381p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12382q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12383r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12384s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12385t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12386u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12387v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12388w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @in.f
    @os.l
    public static final d f12389x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final List<a.C0316a> f12390y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public static final List<a.C0316a> f12391z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<c> f12392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12393b;

    public static final class a {

        /* JADX INFO: renamed from: op.d$a$a, reason: collision with other inner class name */
        public static final class C0316a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f12394a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @os.l
            public final String f12395b;

            public C0316a(int i10, @os.l String str) {
                l0.p(str, "name");
                this.f12394a = i10;
                this.f12395b = str;
            }

            public final int a() {
                return this.f12394a;
            }

            @os.l
            public final String b() {
                return this.f12395b;
            }
        }

        public a() {
        }

        public final int b() {
            return d.f12376k;
        }

        public final int c() {
            return d.f12377l;
        }

        public final int d() {
            return d.f12374i;
        }

        public final int e() {
            return d.f12370e;
        }

        public final int f() {
            return d.f12373h;
        }

        public final int g() {
            return d.f12371f;
        }

        public final int h() {
            return d.f12372g;
        }

        public final int i() {
            return d.f12375j;
        }

        public final int j() {
            int i10 = d.f12369d;
            a aVar = d.f12368c;
            d.f12369d <<= 1;
            return i10;
        }

        public a(w wVar) {
        }
    }

    static {
        a.C0316a c0316a;
        a.C0316a c0316a2;
        a aVar = new a();
        f12368c = aVar;
        int iJ = aVar.j();
        f12370e = iJ;
        int iJ2 = aVar.j();
        f12371f = iJ2;
        int iJ3 = aVar.j();
        f12372g = iJ3;
        int iJ4 = aVar.j();
        f12373h = iJ4;
        int iJ5 = aVar.j();
        f12374i = iJ5;
        int iJ6 = aVar.j();
        f12375j = iJ6;
        int iJ7 = aVar.j() - 1;
        f12376k = iJ7;
        int i10 = iJ | iJ2 | iJ3;
        f12377l = i10;
        int i11 = iJ2 | iJ5 | iJ6;
        f12378m = i11;
        int i12 = iJ5 | iJ6;
        f12379n = i12;
        f12380o = new d(iJ7, null, 2, null);
        f12381p = new d(i12, null, 2, null);
        f12382q = new d(iJ, null, 2, null);
        f12383r = new d(iJ2, null, 2, null);
        f12384s = new d(iJ3, null, 2, null);
        f12385t = new d(i10, null, 2, null);
        f12386u = new d(iJ4, null, 2, null);
        f12387v = new d(iJ5, null, 2, null);
        f12388w = new d(iJ6, null, 2, null);
        f12389x = new d(i11, null, 2, null);
        Field[] fields = d.class.getFields();
        l0.o(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        int length = fields.length;
        int i13 = 0;
        int i14 = 0;
        while (i14 < length) {
            Field field = fields[i14];
            i14++;
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int i15 = dVar.f12393b;
                String name = field2.getName();
                l0.o(name, "field.name");
                c0316a2 = new a.C0316a(i15, name);
            } else {
                c0316a2 = null;
            }
            if (c0316a2 != null) {
                arrayList2.add(c0316a2);
            }
        }
        f12390y = arrayList2;
        Field[] fields2 = d.class.getFields();
        l0.o(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        int length2 = fields2.length;
        while (i13 < length2) {
            Field field3 = fields2[i13];
            i13++;
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (l0.g(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                l0.o(name2, "field.name");
                c0316a = new a.C0316a(iIntValue, name2);
            } else {
                c0316a = null;
            }
            if (c0316a != null) {
                arrayList5.add(c0316a);
            }
        }
        f12391z = arrayList5;
    }

    public d(int i10, List list, int i11, w wVar) {
        this(i10, (i11 & 2) != 0 ? k0.INSTANCE : list);
    }

    public final boolean a(int i10) {
        return (this.f12393b & i10) != 0;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!l0.g(d.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        }
        d dVar = (d) obj;
        return l0.g(this.f12392a, dVar.f12392a) && this.f12393b == dVar.f12393b;
    }

    public int hashCode() {
        return (this.f12392a.hashCode() * 31) + this.f12393b;
    }

    @os.l
    public final List<c> l() {
        return this.f12392a;
    }

    public final int m() {
        return this.f12393b;
    }

    @os.m
    public final d n(int i10) {
        int i11 = i10 & this.f12393b;
        if (i11 == 0) {
            return null;
        }
        return new d(i11, this.f12392a);
    }

    @os.l
    public String toString() {
        Object next;
        Iterator<T> it = f12390y.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((a.C0316a) next).f12394a != this.f12393b);
        a.C0316a c0316a = (a.C0316a) next;
        String strM3 = c0316a == null ? null : c0316a.f12395b;
        if (strM3 == null) {
            List<a.C0316a> list = f12391z;
            ArrayList arrayList = new ArrayList();
            for (a.C0316a c0316a2 : list) {
                String str = a(c0316a2.f12394a) ? c0316a2.f12395b : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
            strM3 = h0.m3(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder sbA = e.a.a("DescriptorKindFilter(", strM3, ", ");
        sbA.append(this.f12392a);
        sbA.append(')');
        return sbA.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i10, @os.l List<? extends c> list) {
        l0.p(list, "excludes");
        this.f12392a = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i10 &= ~((c) it.next()).a();
        }
        this.f12393b = i10;
    }
}
