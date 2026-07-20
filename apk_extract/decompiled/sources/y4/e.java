package y4;

import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements v4.q0 {
    @Override // v4.q0
    public final v4.p0 create(v4.q qVar, c5.a aVar) {
        if (aVar.getRawType() == Date.class) {
            return new h(g.DATE, 2, 2, 0);
        }
        return null;
    }

    public final String toString() {
        return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
    }
}
