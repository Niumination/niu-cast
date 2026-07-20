package ap;

import java.util.List;
import kn.l0;
import kn.w;
import nm.k0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f672b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final h f673c = new h(k0.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final List<yo.a.v> f674a;

    public static final class a {
        public a() {
        }

        @l
        public final h a(@l yo.a.w wVar) {
            l0.p(wVar, "table");
            if (wVar.getRequirementCount() == 0) {
                return h.f673c;
            }
            List<yo.a.v> requirementList = wVar.getRequirementList();
            l0.o(requirementList, "table.requirementList");
            return new h(requirementList);
        }

        @l
        public final h b() {
            return h.f673c;
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ h(List list, w wVar) {
        this(list);
    }

    public h(List<yo.a.v> list) {
        this.f674a = list;
    }
}
