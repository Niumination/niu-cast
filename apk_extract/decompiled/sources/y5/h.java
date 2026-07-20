package y5;

import l3.u0;
import m3.b0;
import m3.c0;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f11075b = new h(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f11076c = new h(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f11077d = new h(2);
    public static final h e = new h(3);
    public static final h f = new h(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11078a;

    public /* synthetic */ h(int i8) {
        this.f11078a = i8;
    }

    @Override // l3.u0
    public final boolean a(int i8) {
        switch (this.f11078a) {
            case 0:
                return i8 == 0 || i8 == 1 || i8 == 2;
            case 1:
                return i8 == 0 || i8 == 1 || i8 == 2 || i8 == 3;
            case 2:
                return b0.a(i8) != 0;
            case 3:
                return c0.a(i8) != 0;
            default:
                return i8 == 0 || i8 == 1 || i8 == 2;
        }
    }
}
