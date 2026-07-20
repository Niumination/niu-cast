package vk;

import fl.t0;
import kn.l0;
import os.l;
import os.m;
import un.s;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final fl.b<s> f17595a = new fl.b<>("ResponseTypeAttributeKey");

    @m
    public static final s a(@l a aVar) {
        l0.p(aVar, "<this>");
        return (s) aVar.f().c().b(f17595a);
    }

    @t0
    public static final void b(@l a aVar, @m s sVar) {
        l0.p(aVar, "<this>");
        if (sVar != null) {
            aVar.f().c().g(f17595a, sVar);
        } else {
            aVar.f().c().c(f17595a);
        }
    }
}
