package br;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import jn.p;
import lm.l2;
import nq.b2;
import nq.d1;
import nq.s0;
import nq.x3;
import os.l;
import os.m;
import sq.i;
import sq.r;
import um.d;
import yq.b;
import yq.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final long a(Duration duration) {
        if (duration.compareTo(Duration.ZERO) <= 0) {
            return 0L;
        }
        if (duration.compareTo(ChronoUnit.MILLIS.getDuration()) <= 0) {
            return 1L;
        }
        if (duration.getSeconds() < 9223372036854775L || (duration.getSeconds() == 9223372036854775L && duration.getNano() < 807000000)) {
            return duration.toMillis();
        }
        return Long.MAX_VALUE;
    }

    @b2
    @l
    public static final <T> i<T> b(@l i<? extends T> iVar, @l Duration duration) {
        return r.a(iVar, a(duration));
    }

    @m
    public static final Object c(@l Duration duration, @l d<? super l2> dVar) {
        Object objB = d1.b(a(duration), dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
    }

    public static final <R> void d(@l c<? super R> cVar, @l Duration duration, @l jn.l<? super d<? super R>, ? extends Object> lVar) {
        b.a(cVar, a(duration), lVar);
    }

    @b2
    @l
    public static final <T> i<T> e(@l i<? extends T> iVar, @l Duration duration) {
        return r.h(iVar, a(duration));
    }

    @m
    public static final <T> Object f(@l Duration duration, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return x3.c(a(duration), pVar, dVar);
    }

    @m
    public static final <T> Object g(@l Duration duration, @l p<? super s0, ? super d<? super T>, ? extends Object> pVar, @l d<? super T> dVar) {
        return x3.e(a(duration), pVar, dVar);
    }
}
