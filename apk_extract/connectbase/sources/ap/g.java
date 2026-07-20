package ap;

import java.util.ArrayList;
import java.util.List;
import kn.l0;
import nm.y;
import nm.z;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final List<yo.a.q> f671a;

    public g(@l yo.a.t tVar) {
        l0.p(tVar, "typeTable");
        List<yo.a.q> typeList = tVar.getTypeList();
        if (tVar.hasFirstNullable()) {
            int firstNullable = tVar.getFirstNullable();
            List<yo.a.q> typeList2 = tVar.getTypeList();
            l0.o(typeList2, "typeTable.typeList");
            List<yo.a.q> list = typeList2;
            ArrayList arrayList = new ArrayList(z.b0(list, 10));
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    y.Z();
                }
                yo.a.q qVarBuild = (yo.a.q) obj;
                if (i10 >= firstNullable) {
                    qVarBuild = qVarBuild.toBuilder().P(true).build();
                }
                arrayList.add(qVarBuild);
                i10 = i11;
            }
            typeList = arrayList;
        }
        l0.o(typeList, "run {\n        val origin… else originalTypes\n    }");
        this.f671a = typeList;
    }

    @l
    public final yo.a.q a(int i10) {
        return this.f671a.get(i10);
    }
}
