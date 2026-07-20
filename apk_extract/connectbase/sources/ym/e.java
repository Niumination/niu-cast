package ym;

import java.io.Serializable;
import java.lang.Enum;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class e<E extends Enum<E>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f21462a = new a();
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    private final Class<E> f21463c;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public e(@l E[] eArr) {
        l0.p(eArr, cb.b.c.f1405l);
        Class<E> cls = (Class<E>) eArr.getClass().getComponentType();
        l0.m(cls);
        this.f21463c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.f21463c.getEnumConstants();
        l0.o(enumConstants, "getEnumConstants(...)");
        return c.c(enumConstants);
    }
}
