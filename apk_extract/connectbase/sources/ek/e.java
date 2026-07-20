package ek;

import java.util.List;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    @m
    public static final String a(@l sj.a aVar, @l String str) {
        l0.p(aVar, "<this>");
        l0.p(str, "path");
        if (aVar.hasPath(str)) {
            return aVar.getString(str);
        }
        return null;
    }

    @m
    public static final List<String> b(@l sj.a aVar, @l String str) {
        l0.p(aVar, "<this>");
        l0.p(str, "path");
        if (aVar.hasPath(str)) {
            return aVar.getStringList(str);
        }
        return null;
    }
}
