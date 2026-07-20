package yk;

import java.util.ArrayList;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends ClassLoader {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@os.l ClassLoader classLoader) {
        super(classLoader);
        l0.p(classLoader, "delegate");
    }

    @os.l
    public final List<String> a() {
        Package[] packages = getPackages();
        l0.o(packages, "getPackages()");
        ArrayList arrayList = new ArrayList(packages.length);
        int length = packages.length;
        int i10 = 0;
        while (i10 < length) {
            Package r10 = packages[i10];
            i10++;
            arrayList.add(r10.getName());
        }
        return arrayList;
    }
}
