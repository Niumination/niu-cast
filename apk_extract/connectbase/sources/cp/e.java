package cp;

import java.util.Arrays;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends ap.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final a f3369h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @in.f
    @l
    public static final e f3370i = new e(1, 6, 0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @in.f
    @l
    public static final e f3371j = new e(new int[0]);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f3372g;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@l int[] iArr, boolean z10) {
        super(Arrays.copyOf(iArr, iArr.length));
        l0.p(iArr, "versionArray");
        this.f3372g = z10;
    }

    public boolean h() {
        boolean zF;
        int i10 = this.f635b;
        if (i10 == 1 && this.f636c == 0) {
            return false;
        }
        if (this.f3372g) {
            zF = f(f3370i);
        } else {
            e eVar = f3370i;
            zF = i10 == eVar.f635b && this.f636c <= eVar.f636c + 1;
        }
        return zF;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@l int... iArr) {
        this(iArr, false);
        l0.p(iArr, "numbers");
    }
}
