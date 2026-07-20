package dk;

import kn.w;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public class c extends nl.e<l2, b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f3711i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final uk.b f3712n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final vk.d f3713p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final a f3706v = new a();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final nl.j f3707w = new nl.j("Setup");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final nl.j f3708x = new nl.j("Monitoring");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final nl.j f3709y = new nl.j("Features");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public static final nl.j f3710z = new nl.j("Call");

    @os.l
    public static final nl.j H = new nl.j("Fallback");

    public static final class a {
        public a() {
        }

        @os.l
        public final nl.j a() {
            return c.f3710z;
        }

        @os.l
        public final nl.j b() {
            return c.H;
        }

        @os.l
        public final nl.j c() {
            return c.f3709y;
        }

        @os.l
        public final nl.j d() {
            return c.f3708x;
        }

        @os.l
        public final nl.j e() {
            return c.f3707w;
        }

        public a(w wVar) {
        }
    }

    public c() {
        this(false, 1, null);
    }

    @os.l
    public final uk.b V() {
        return this.f3712n;
    }

    @os.l
    public final vk.d W() {
        return this.f3713p;
    }

    @Override // nl.e
    public final boolean m() {
        return this.f3711i;
    }

    public /* synthetic */ c(boolean z10, int i10, w wVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public c(boolean z10) {
        super(f3707w, f3708x, f3709y, f3710z, H);
        this.f3711i = z10;
        this.f3712n = new uk.b(z10);
        this.f3713p = new vk.d(z10);
    }
}
