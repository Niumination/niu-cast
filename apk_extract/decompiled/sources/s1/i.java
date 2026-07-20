package s1;

import af.r5;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j1.j f9473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9475d;
    public final g e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f9477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q1.d f9478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f9479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f9480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f9481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f9482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f9483n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f9484o;
    public final float p;
    public final q1.a q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final tc.d f9485r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final q1.b f9486s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List f9487t;
    public final h u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f9488v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final o5.c f9489w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final r5 f9490x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r1.h f9491y;

    public i(List list, j1.j jVar, String str, long j8, g gVar, long j10, String str2, List list2, q1.d dVar, int i8, int i9, int i10, float f, float f4, float f10, float f11, q1.a aVar, tc.d dVar2, List list3, h hVar, q1.b bVar, boolean z2, o5.c cVar, r5 r5Var, r1.h hVar2) {
        this.f9472a = list;
        this.f9473b = jVar;
        this.f9474c = str;
        this.f9475d = j8;
        this.e = gVar;
        this.f = j10;
        this.f9476g = str2;
        this.f9477h = list2;
        this.f9478i = dVar;
        this.f9479j = i8;
        this.f9480k = i9;
        this.f9481l = i10;
        this.f9482m = f;
        this.f9483n = f4;
        this.f9484o = f10;
        this.p = f11;
        this.q = aVar;
        this.f9485r = dVar2;
        this.f9487t = list3;
        this.u = hVar;
        this.f9486s = bVar;
        this.f9488v = z2;
        this.f9489w = cVar;
        this.f9490x = r5Var;
        this.f9491y = hVar2;
    }

    public final String a(String str) {
        int i8;
        StringBuilder sbS = o.d.s(str);
        sbS.append(this.f9474c);
        sbS.append("\n");
        j1.j jVar = this.f9473b;
        i iVar = (i) jVar.f5970i.get(this.f);
        if (iVar != null) {
            sbS.append("\t\tParents: ");
            sbS.append(iVar.f9474c);
            for (i iVar2 = (i) jVar.f5970i.get(iVar.f); iVar2 != null; iVar2 = (i) jVar.f5970i.get(iVar2.f)) {
                sbS.append("->");
                sbS.append(iVar2.f9474c);
            }
            sbS.append(str);
            sbS.append("\n");
        }
        List list = this.f9477h;
        if (!list.isEmpty()) {
            sbS.append(str);
            sbS.append("\tMasks: ");
            sbS.append(list.size());
            sbS.append("\n");
        }
        int i9 = this.f9479j;
        if (i9 != 0 && (i8 = this.f9480k) != 0) {
            sbS.append(str);
            sbS.append("\tBackground: ");
            sbS.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(i9), Integer.valueOf(i8), Integer.valueOf(this.f9481l)));
        }
        List list2 = this.f9472a;
        if (!list2.isEmpty()) {
            sbS.append(str);
            sbS.append("\tShapes:\n");
            for (Object obj : list2) {
                sbS.append(str);
                sbS.append("\t\t");
                sbS.append(obj);
                sbS.append("\n");
            }
        }
        return sbS.toString();
    }

    public final String toString() {
        return a("");
    }
}
