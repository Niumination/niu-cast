package ik;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f8234c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<y> f8236b;

    public static final class a {
        public a() {
        }

        public final <R> R a(@os.l String str, @os.l jn.p<? super String, ? super List<y>, ? extends R> pVar) {
            kn.l0.p(str, "value");
            kn.l0.p(pVar, "init");
            x xVar = (x) nm.h0.h5(i0.e(str, false));
            return pVar.invoke(xVar.f8200a, xVar.f8201b);
        }

        public a(kn.w wVar) {
        }
    }

    public z(@os.l String str, @os.l List<y> list) {
        kn.l0.p(str, t2.a.f15437d);
        kn.l0.p(list, "parameters");
        this.f8235a = str;
        this.f8236b = list;
    }

    @os.l
    public final String a() {
        return this.f8235a;
    }

    @os.l
    public final List<y> b() {
        return this.f8236b;
    }

    @os.m
    public final String c(@os.l String str) {
        Object next;
        kn.l0.p(str, "name");
        Iterator<T> it = this.f8236b.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!jq.e0.K1(((y) next).f8206a, str, true));
        y yVar = (y) next;
        if (yVar == null) {
            return null;
        }
        return yVar.f8207b;
    }

    @os.l
    public String toString() {
        if (this.f8236b.isEmpty()) {
            return this.f8235a;
        }
        int length = this.f8235a.length();
        int i10 = 0;
        int length2 = 0;
        for (y yVar : this.f8236b) {
            length2 += yVar.f8207b.length() + yVar.f8206a.length() + 3;
        }
        StringBuilder sb2 = new StringBuilder(length + length2);
        sb2.append(this.f8235a);
        int size = this.f8236b.size();
        while (i10 < size) {
            int i11 = i10 + 1;
            y yVar2 = this.f8236b.get(i10);
            String str = yVar2.f8206a;
            String str2 = yVar2.f8207b;
            sb2.append("; ");
            sb2.append(str);
            sb2.append("=");
            if (a0.c(str2)) {
                sb2.append(a0.h(str2));
            } else {
                sb2.append(str2);
            }
            i10 = i11;
        }
        String string = sb2.toString();
        kn.l0.o(string, "{\n            val size =…   }.toString()\n        }");
        return string;
    }

    public z(String str, List list, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? nm.k0.INSTANCE : list);
    }
}
