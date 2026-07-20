package rn;

import java.util.Random;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends rn.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final a f14588b = new a();

    public static final class a extends ThreadLocal<Random> {
        @l
        public Random a() {
            return new Random();
        }

        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // rn.a
    @l
    public Random getImpl() {
        Random random = this.f14588b.get();
        l0.o(random, "get(...)");
        return random;
    }
}
