package uk;

import kn.w;
import nl.j;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public class b extends nl.e<c, dk.b> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public static final a f16289n = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public static final j f16290p = new j("Before");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @l
    public static final j f16291v = new j("Transform");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @l
    public static final j f16292w = new j("After");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f16293i;

    public static final class a {
        public a() {
        }

        @l
        public final j a() {
            return b.f16292w;
        }

        @l
        public final j b() {
            return b.f16290p;
        }

        @l
        public final j c() {
            return b.f16291v;
        }

        public a(w wVar) {
        }
    }

    public b() {
        this(false, 1, null);
    }

    @Override // nl.e
    public boolean m() {
        return this.f16293i;
    }

    public /* synthetic */ b(boolean z10, int i10, w wVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public b(boolean z10) {
        super(f16290p, f16291v, f16292w);
        this.f16293i = z10;
    }
}
