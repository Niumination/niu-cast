package ym;

import kn.l0;
import kn.r1;
import lm.f1;
import lm.r;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nEnumEntries.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumEntries.kt\nkotlin/enums/EnumEntriesKt\n+ 2 EnumEntriesJVM.kt\nkotlin/enums/EnumEntriesJVMKt\n*L\n1#1,91:1\n16#2:92\n*S KotlinDebug\n*F\n+ 1 EnumEntries.kt\nkotlin/enums/EnumEntriesKt\n*L\n31#1:92\n*E\n"})
public final class c {
    @f1(version = "1.9")
    @r
    public static final <T extends Enum<T>> a<T> a() {
        l0.P();
        return c(new Enum[0]);
    }

    @f1(version = "1.8")
    @z0
    @l
    public static final <E extends Enum<E>> a<E> b(@l jn.a<E[]> aVar) {
        l0.p(aVar, "entriesProvider");
        return new d(aVar.invoke());
    }

    @f1(version = "1.8")
    @z0
    @l
    public static final <E extends Enum<E>> a<E> c(@l E[] eArr) {
        l0.p(eArr, cb.b.c.f1405l);
        return new d(eArr);
    }
}
