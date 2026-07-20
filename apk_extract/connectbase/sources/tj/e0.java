package tj;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15588a;

        static {
            int[] iArr = new int[o.values().length];
            f15588a = iArr;
            try {
                iArr[o.URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15588a[o.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15588a[o.CLASSPATH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15588a[o.HEURISTIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z f15590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k0 f15591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final sj.e f15592d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final sj.v f15593e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final sj.o f15594f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15589a = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final LinkedList<p0> f15595g = new LinkedList<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15596h = 0;

        public b(sj.v vVar, sj.o oVar, z zVar, k0 k0Var, sj.e eVar) {
            this.f15590b = zVar;
            this.f15593e = vVar;
            this.f15594f = oVar;
            this.f15591c = k0Var;
            this.f15592d = eVar;
        }

        public static c a(p0 p0Var, d dVar) {
            ArrayList arrayList = new ArrayList();
            String str = p0Var.f15726a;
            p0 p0Var2 = p0Var.f15727b;
            while (str != null) {
                arrayList.add(str);
                if (p0Var2 == null) {
                    break;
                }
                str = p0Var2.f15726a;
                p0Var2 = p0Var2.f15727b;
            }
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            f1 f1Var = new f1(dVar.origin().c(null), Collections.singletonMap((String) listIterator.previous(), dVar));
            while (listIterator.hasPrevious()) {
                f1Var = new f1(dVar.origin().c(null), Collections.singletonMap(listIterator.previous(), f1Var));
            }
            return f1Var;
        }

        public final p0 b() {
            if (this.f15595g.isEmpty()) {
                throw new sj.c.d("Bug in parser; tried to get current path when at root");
            }
            return new p0(this.f15595g.descendingIterator());
        }

        public final g1 c() {
            return ((g1) this.f15594f).d(this.f15589a);
        }

        public d d() {
            ArrayList arrayList = new ArrayList();
            d dVarK = null;
            while (true) {
                boolean z10 = false;
                for (tj.a aVar : this.f15590b.f15733a) {
                    if (aVar instanceof s) {
                        arrayList.add(n1.a(((s) aVar).f15573a));
                    } else if (aVar instanceof b0) {
                        if (n1.l(((b0) aVar).b())) {
                            this.f15589a++;
                            if (z10 && dVarK == null) {
                                arrayList.clear();
                            } else if (dVarK != null) {
                                d dVarWithOrigin = dVarK.withOrigin((sj.o) dVarK.origin().g(new ArrayList<>(arrayList)));
                                arrayList.clear();
                                return dVarWithOrigin;
                            }
                            z10 = true;
                        } else {
                            continue;
                        }
                    } else if (aVar instanceof t) {
                        dVarK = k((t) aVar, arrayList);
                    }
                }
                return dVarK;
            }
        }

        public final e1 e(r rVar) {
            this.f15596h++;
            g1 g1VarC = c();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z10 = false;
            d dVarK = null;
            for (tj.a aVar : rVar.f15733a) {
                if (aVar instanceof s) {
                    arrayList2.add(n1.a(((s) aVar).f15573a));
                } else if ((aVar instanceof b0) && n1.l(((b0) aVar).b())) {
                    this.f15589a++;
                    if (z10 && dVarK == null) {
                        arrayList2.clear();
                    } else if (dVarK != null) {
                        arrayList.add(dVarK.withOrigin((sj.o) dVarK.origin().g(new ArrayList<>(arrayList2))));
                        arrayList2.clear();
                        dVarK = null;
                    }
                    z10 = true;
                } else if (aVar instanceof tj.b) {
                    if (dVarK != null) {
                        arrayList.add(dVarK.withOrigin((sj.o) dVarK.origin().g(new ArrayList<>(arrayList2))));
                        arrayList2.clear();
                    }
                    dVarK = k((tj.b) aVar, arrayList2);
                }
                z10 = false;
            }
            if (dVarK != null) {
                arrayList.add(dVarK.withOrigin((sj.o) dVarK.origin().g(new ArrayList<>(arrayList2))));
            }
            this.f15596h--;
            return new e1(g1VarC, arrayList);
        }

        public final d f(u uVar) {
            if (this.f15593e == sj.v.JSON) {
                throw new sj.c.d("Found a concatenation node in JSON");
            }
            ArrayList arrayList = new ArrayList(uVar.f15733a.size());
            for (tj.a aVar : uVar.f15733a) {
                if (aVar instanceof tj.b) {
                    arrayList.add(k((tj.b) aVar, null));
                }
            }
            return h.f(arrayList);
        }

        public final sj.c g(String str) {
            return h(str, null);
        }

        public final sj.c h(String str, Throwable th2) {
            return new sj.c.j(c(), str, th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void i(Map<String, d> map, w wVar) {
            c cVar;
            boolean z10 = wVar.f15743c;
            sj.e eVar = this.f15592d;
            sj.e eVarC = eVar.c(eVar.b().i(!z10));
            int i10 = a.f15588a[wVar.f15742b.ordinal()];
            if (i10 == 1) {
                try {
                    cVar = (c) this.f15591c.a(eVarC, new URL(wVar.e()));
                } catch (MalformedURLException e10) {
                    throw h("include url() specifies an invalid URL: " + wVar.e(), e10);
                }
            } else if (i10 == 2) {
                cVar = (c) this.f15591c.b(eVarC, new File(wVar.e()));
            } else if (i10 == 3) {
                cVar = (c) this.f15591c.d(eVarC, wVar.e());
            } else {
                if (i10 != 4) {
                    throw new sj.c.d("should not be reached");
                }
                cVar = (c) this.f15591c.c(eVarC, wVar.e());
            }
            if (this.f15596h > 0 && cVar.resolveStatus() != y0.RESOLVED) {
                throw h("Due to current limitations of the config parser, when an include statement is nested inside a list value, ${} substitutions inside the included file cannot be resolved correctly. Either move the include outside of the list value or remove the ${} statements from the included file.", null);
            }
            Map mapRelativized = cVar;
            if (!this.f15595g.isEmpty()) {
                mapRelativized = cVar.relativized(b());
            }
            for (String str : mapRelativized.keySet()) {
                d dVar = mapRelativized.get((Object) str);
                d dVar2 = map.get(str);
                if (dVar2 != null) {
                    map.put(str, dVar.withFallback((sj.m) dVar2));
                } else {
                    map.put(str, dVar);
                }
            }
        }

        public final c j(x xVar) {
            HashMap map = new HashMap();
            g1 g1VarC = c();
            ArrayList arrayList = new ArrayList(xVar.f15733a);
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < arrayList.size()) {
                tj.a aVar = (tj.a) arrayList.get(i10);
                if (aVar instanceof s) {
                    arrayList2.add(n1.a(((s) aVar).f15573a));
                } else {
                    if ((aVar instanceof b0) && n1.l(((b0) aVar).b())) {
                        this.f15589a++;
                        if (z10) {
                            arrayList2.clear();
                        }
                        z10 = true;
                    } else if (this.f15593e != sj.v.JSON && (aVar instanceof w)) {
                        i(map, (w) aVar);
                    } else if (aVar instanceof v) {
                        v vVar = (v) aVar;
                        p0 p0Var = vVar.c().f15754a;
                        arrayList2.addAll(vVar.b());
                        this.f15595g.push(p0Var);
                        k1 k1VarE = vVar.e();
                        k1 k1Var = n1.f15694j;
                        if (k1VarE == k1Var) {
                            int i11 = this.f15596h;
                            if (i11 > 0) {
                                throw h("Due to current limitations of the config parser, += does not work nested inside a list. += expands to a ${} substitution and the path in ${} cannot currently refer to list elements. You might be able to move the += outside of the list and then refer to it from inside the list with ${}.", null);
                            }
                            this.f15596h = i11 + 1;
                        }
                        d dVarK = k(vVar.f(), arrayList2);
                        if (vVar.e() == k1Var) {
                            this.f15596h--;
                            ArrayList arrayList3 = new ArrayList(2);
                            f0 f0Var = new f0(dVarK.origin(), new j1(b(), true), 0);
                            e1 e1Var = new e1(dVarK.origin(), Collections.singletonList(dVarK));
                            arrayList3.add(f0Var);
                            arrayList3.add(e1Var);
                            dVarK = h.f(arrayList3);
                        }
                        if (i10 < arrayList.size() - 1) {
                            while (true) {
                                i10++;
                                if (i10 < arrayList.size()) {
                                    if (!(arrayList.get(i10) instanceof s)) {
                                        if (arrayList.get(i10) instanceof b0) {
                                            b0 b0Var = (b0) arrayList.get(i10);
                                            if (b0Var.b() == n1.f15687c || (b0Var.b() instanceof n1.b)) {
                                            }
                                        }
                                        i10--;
                                        break;
                                    }
                                    dVarK = dVarK.withOrigin((sj.o) dVarK.origin().g(Collections.singletonList(n1.a(((s) arrayList.get(i10)).f15573a))));
                                    break;
                                }
                                break;
                            }
                        }
                        this.f15595g.pop();
                        String str = p0Var.f15726a;
                        p0 p0Var2 = p0Var.f15727b;
                        if (p0Var2 == null) {
                            d dVar = (d) map.get(str);
                            if (dVar != null) {
                                if (this.f15593e == sj.v.JSON) {
                                    StringBuilder sbA = e.a.a("JSON does not allow duplicate fields: '", str, "' was already seen at ");
                                    sbA.append(dVar.origin().description());
                                    throw h(sbA.toString(), null);
                                }
                                dVarK = dVarK.withFallback((sj.m) dVar);
                            }
                            map.put(str, dVarK);
                        } else {
                            if (this.f15593e == sj.v.JSON) {
                                throw new sj.c.d("somehow got multi-element path in JSON mode");
                            }
                            c cVarA = a(p0Var2, dVarK);
                            d dVar2 = (d) map.get(str);
                            if (dVar2 != null) {
                                cVarA = cVarA.withFallback((sj.m) dVar2);
                            }
                            map.put(str, cVarA);
                        }
                    } else {
                        continue;
                    }
                    i10++;
                }
                z10 = false;
                i10++;
            }
            return new f1(g1VarC, map);
        }

        public final d k(tj.b bVar, List<String> list) {
            d dVarF;
            int i10 = this.f15596h;
            if (bVar instanceof a0) {
                dVarF = ((a0) bVar).c();
            } else if (bVar instanceof x) {
                dVarF = j((x) bVar);
            } else if (bVar instanceof r) {
                dVarF = e((r) bVar);
            } else {
                if (!(bVar instanceof u)) {
                    throw h("Expecting a value but got wrong node type: " + bVar.getClass(), null);
                }
                dVarF = f((u) bVar);
            }
            if (list != null && !list.isEmpty()) {
                dVarF = dVarF.withOrigin((sj.o) dVarF.origin().v(new ArrayList(list)));
                list.clear();
            }
            if (this.f15596h == i10) {
                return dVarF;
            }
            throw new sj.c.d("Bug in config parser: unbalanced array count");
        }
    }

    public static d a(z zVar, sj.o oVar, sj.q qVar, sj.e eVar) {
        return new b(qVar.f15090a, oVar, zVar, i1.l(qVar.f15093d), eVar).d();
    }
}
