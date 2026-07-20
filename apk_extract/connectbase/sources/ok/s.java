package ok;

import java.util.ArrayList;
import java.util.List;
import kn.l0;
import nm.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<e> f12300a;

    public s(@os.l List<? extends e> list) {
        l0.p(list, "sourceGrammars");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof s) {
                d0.r0(arrayList, ((c) obj).a());
            } else {
                arrayList.add(obj);
            }
        }
        this.f12300a = arrayList;
    }

    @Override // ok.c
    @os.l
    public List<e> a() {
        return this.f12300a;
    }
}
