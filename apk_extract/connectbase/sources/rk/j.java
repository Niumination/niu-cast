package rk;

import java.io.Closeable;
import java.nio.channels.spi.SelectorProvider;
import lm.l2;
import nq.s0;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public interface j extends s0, Closeable {

    @os.l
    public static final a A = a.f14548a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f14548a = new a();
    }

    @m
    Object K(@os.l h hVar, @os.l g gVar, @os.l um.d<? super l2> dVar);

    void R1(@os.l h hVar);

    @os.l
    SelectorProvider z();
}
