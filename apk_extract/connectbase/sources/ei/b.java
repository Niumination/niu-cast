package ei;

import bi.x;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {
    @Override // ei.n
    public void a(Object obj) {
        x xVarG = c().G();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            if (xVarG.e()) {
                c().E();
            }
            xVarG.d();
            c().j(Array.get(obj, i10));
        }
        c().C();
    }
}
