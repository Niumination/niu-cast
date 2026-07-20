package rn;

import java.io.Serializable;
import java.util.Random;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends rn.a implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f14590b = new a();
    private static final long serialVersionUID = 0;

    @l
    private final Random impl;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public d(@l Random random) {
        l0.p(random, "impl");
        this.impl = random;
    }

    @Override // rn.a
    @l
    public Random getImpl() {
        return this.impl;
    }
}
