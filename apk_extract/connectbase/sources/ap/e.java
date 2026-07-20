package ap;

import java.util.List;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @m
    public static final <M extends fp.i.d<M>, T> T a(@l fp.i.d<M> dVar, @l fp.i.g<M, T> gVar) {
        l0.p(dVar, "<this>");
        l0.p(gVar, "extension");
        if (dVar.hasExtension(gVar)) {
            return (T) dVar.getExtension(gVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    public static final <M extends fp.i.d<M>, T> T b(@l fp.i.d<M> dVar, @l fp.i.g<M, List<T>> gVar, int i10) {
        l0.p(dVar, "<this>");
        l0.p(gVar, "extension");
        if (i10 < dVar.getExtensionCount(gVar)) {
            return (T) dVar.getExtension(gVar, i10);
        }
        return null;
    }
}
