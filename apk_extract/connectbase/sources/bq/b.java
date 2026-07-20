package bq;

import eo.y;
import kn.l0;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    public static final class a {
        @m
        public static String a(@os.l b bVar, @os.l y yVar) {
            l0.p(bVar, "this");
            l0.p(yVar, "functionDescriptor");
            if (bVar.b(yVar)) {
                return null;
            }
            return bVar.getDescription();
        }
    }

    @m
    String a(@os.l y yVar);

    boolean b(@os.l y yVar);

    @os.l
    String getDescription();
}
