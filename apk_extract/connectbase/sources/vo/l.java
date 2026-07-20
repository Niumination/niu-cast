package vo;

import ik.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.l0;
import lm.l2;
import lm.t0;
import nm.c1;
import nm.s0;
import nm.z;
import wo.w;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<String, j> f17643a = new LinkedHashMap();

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final String f17644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f17645b;

        /* JADX INFO: renamed from: vo.l$a$a, reason: collision with other inner class name */
        public final class C0461a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final String f17646a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @os.l
            public final List<t0<String, q>> f17647b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @os.l
            public t0<String, q> f17648c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f17649d;

            public C0461a(@os.l a aVar, String str) {
                l0.p(aVar, "this$0");
                l0.p(str, "functionName");
                this.f17649d = aVar;
                this.f17646a = str;
                this.f17647b = new ArrayList();
                this.f17648c = new t0<>("V", null);
            }

            @os.l
            public final t0<String, j> a() {
                w wVar = w.f19826a;
                String str = this.f17649d.f17644a;
                String str2 = this.f17646a;
                List<t0<String, q>> list = this.f17647b;
                ArrayList arrayList = new ArrayList(z.b0(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((t0) it.next()).getFirst());
                }
                String strK = wVar.k(str, wVar.j(str2, arrayList, this.f17648c.getFirst()));
                q second = this.f17648c.getSecond();
                List<t0<String, q>> list2 = this.f17647b;
                ArrayList arrayList2 = new ArrayList(z.b0(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((q) ((t0) it2.next()).getSecond());
                }
                return new t0<>(strK, new j(second, arrayList2));
            }

            @os.l
            public final String b() {
                return this.f17646a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void c(@os.l String str, @os.l d... dVarArr) {
                q qVar;
                l0.p(str, y0.a.f8215h);
                l0.p(dVarArr, "qualifiers");
                List<t0<String, q>> list = this.f17647b;
                if (dVarArr.length == 0) {
                    qVar = null;
                } else {
                    Iterable<s0> iterableFz = nm.r.Fz(dVarArr);
                    int iJ = c1.j(z.b0(iterableFz, 10));
                    if (iJ < 16) {
                        iJ = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
                    for (s0 s0Var : iterableFz) {
                        linkedHashMap.put(Integer.valueOf(s0Var.f11691a), (d) s0Var.f11692b);
                    }
                    qVar = new q(linkedHashMap);
                }
                list.add(new t0<>(str, qVar));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void d(@os.l String str, @os.l d... dVarArr) {
                l0.p(str, y0.a.f8215h);
                l0.p(dVarArr, "qualifiers");
                Iterable<s0> iterableFz = nm.r.Fz(dVarArr);
                int iJ = c1.j(z.b0(iterableFz, 10));
                if (iJ < 16) {
                    iJ = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
                for (s0 s0Var : iterableFz) {
                    linkedHashMap.put(Integer.valueOf(s0Var.f11691a), (d) s0Var.f11692b);
                }
                this.f17648c = new t0<>(str, new q(linkedHashMap));
            }

            public final void e(@os.l mp.e eVar) {
                l0.p(eVar, y0.a.f8215h);
                String desc = eVar.getDesc();
                l0.o(desc, "type.desc");
                this.f17648c = new t0<>(desc, null);
            }
        }

        public a(@os.l l lVar, String str) {
            l0.p(lVar, "this$0");
            l0.p(str, cb.b.C0062b.f1395b);
            this.f17645b = lVar;
            this.f17644a = str;
        }

        public final void a(@os.l String str, @os.l jn.l<? super C0461a, l2> lVar) {
            l0.p(str, "name");
            l0.p(lVar, "block");
            Map<String, j> map = this.f17645b.f17643a;
            C0461a c0461a = new C0461a(this, str);
            lVar.invoke(c0461a);
            t0<String, j> t0VarA = c0461a.a();
            map.put(t0VarA.getFirst(), t0VarA.getSecond());
        }

        @os.l
        public final String b() {
            return this.f17644a;
        }
    }

    @os.l
    public final Map<String, j> b() {
        return this.f17643a;
    }
}
