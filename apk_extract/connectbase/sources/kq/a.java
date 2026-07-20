package kq;

import in.i;
import jq.n;
import jq.o;
import kn.l0;
import lm.f1;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "RegexExtensionsJDK8Kt")
public final class a {
    @m
    @f1(version = "1.2")
    public static final jq.m a(@l n nVar, @l String str) {
        l0.p(nVar, "<this>");
        l0.p(str, "name");
        o oVar = nVar instanceof o ? (o) nVar : null;
        if (oVar != null) {
            return oVar.get(str);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
