package ek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.l0;
import lm.t0;
import nm.d1;
import nm.v0;
import nm.y;
import nm.z;
import os.l;
import os.m;
import tn.u;

/* JADX INFO: loaded from: classes2.dex */
public class f implements ek.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Map<String, String> f4488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final String f4489b;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final Map<String, String> f4490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final String f4491b;

        public a(@l Map<String, String> map, @l String str) {
            l0.p(map, "map");
            l0.p(str, "path");
            this.f4490a = map;
            this.f4491b = str;
        }

        @l
        public final Map<String, String> a() {
            return this.f4490a;
        }

        @Override // ek.b
        @l
        public List<String> b() throws c {
            String str = this.f4490a.get(g.b(this.f4491b, ik.f.b.f7973h));
            if (str == null) {
                throw new c(j.c.a(new StringBuilder("Property "), this.f4491b, ".size not found."));
            }
            tn.l lVarW1 = u.W1(0, Integer.parseInt(str));
            ArrayList arrayList = new ArrayList(z.b0(lVarW1, 10));
            Iterator<Integer> it = lVarW1.iterator();
            while (it.hasNext()) {
                String str2 = this.f4490a.get(g.b(this.f4491b, String.valueOf(((v0) it).nextInt())));
                l0.m(str2);
                arrayList.add(str2);
            }
            return arrayList;
        }

        @l
        public final String c() {
            return this.f4491b;
        }

        @Override // ek.b
        @l
        public String getString() {
            String str = this.f4490a.get(this.f4491b);
            l0.m(str);
            return str;
        }
    }

    public f(Map<String, String> map, String str) {
        this.f4488a = map;
        this.f4489b = str;
    }

    @Override // ek.a
    @l
    public List<ek.a> a(@l String str) throws c {
        l0.p(str, "path");
        String strB = g.b(this.f4489b, str);
        String str2 = this.f4488a.get(g.b(strB, ik.f.b.f7973h));
        if (str2 == null) {
            throw new c(n.a.a("Property ", strB, ".size not found."));
        }
        tn.l lVarW1 = u.W1(0, Integer.parseInt(str2));
        ArrayList arrayList = new ArrayList(z.b0(lVarW1, 10));
        Iterator<Integer> it = lVarW1.iterator();
        while (it.hasNext()) {
            arrayList.add(new f(this.f4488a, g.b(strB, String.valueOf(((v0) it).nextInt()))));
        }
        return arrayList;
    }

    @Override // ek.a
    @l
    public ek.a b(@l String str) {
        l0.p(str, "path");
        return new f(this.f4488a, g.b(this.f4489b, str));
    }

    @Override // ek.a
    @m
    public b c(@l String str) {
        l0.p(str, "path");
        String strB = g.b(this.f4489b, str);
        if (this.f4488a.containsKey(strB) || this.f4488a.containsKey(g.b(strB, ik.f.b.f7973h))) {
            return new a(this.f4488a, strB);
        }
        return null;
    }

    @Override // ek.a
    @l
    public b d(@l String str) throws c {
        l0.p(str, "path");
        b bVarC = c(str);
        if (bVarC != null) {
            return bVarC;
        }
        throw new c("Property " + g.b(this.f4489b, str) + " not found.");
    }

    @l
    public final Map<String, String> e() {
        return this.f4488a;
    }

    @l
    public final String f() {
        return this.f4489b;
    }

    public final void g(@l String str, @l Iterable<String> iterable) {
        l0.p(str, "path");
        l0.p(iterable, "values");
        int i10 = 0;
        int i11 = 0;
        for (String str2 : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                y.Z();
            }
            h(g.b(str, String.valueOf(i11)), str2);
            i10++;
            i11 = i12;
        }
        h(g.b(str, ik.f.b.f7973h), String.valueOf(i10));
    }

    public final void h(@l String str, @l String str2) {
        l0.p(str, "path");
        l0.p(str2, "value");
        this.f4488a.put(str, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@l t0<String, String>... t0VarArr) {
        this(d1.j0((t0[]) Arrays.copyOf(t0VarArr, t0VarArr.length)), "");
        l0.p(t0VarArr, "values");
    }

    public f() {
        this(new LinkedHashMap(), "");
    }
}
