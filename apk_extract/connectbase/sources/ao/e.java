package ao;

import kn.w;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final a f521i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final e f522j = new e(false, 1, null);

    public static final class a {
        public a() {
        }

        @os.l
        public final e a() {
            return e.f522j;
        }

        public a(w wVar) {
        }
    }

    public e() {
        this(false, 1, null);
    }

    @os.l
    public static final e E0() {
        f521i.getClass();
        return f522j;
    }

    public e(boolean z10) {
        super(new up.f("DefaultBuiltIns", (Runnable) null, (jn.l<InterruptedException, l2>) null));
        if (z10) {
            f(false);
        }
    }

    public /* synthetic */ e(boolean z10, int i10, w wVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
