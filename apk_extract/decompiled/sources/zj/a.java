package zj;

import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11610b = new a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11611c = new a(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11612d = new a(2);
    public static final a e = new a(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f11613h = new a(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f11614i = new a(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11615a;

    public /* synthetic */ a(int i8) {
        this.f11615a = i8;
    }

    @Override // zj.j
    public final Object convert(Object obj) {
        switch (this.f11615a) {
            case 0:
                return obj.toString();
            case 1:
                dj.m0 m0Var = (dj.m0) obj;
                try {
                    return s.b(m0Var);
                } finally {
                    m0Var.close();
                }
            case 2:
                return (dj.h0) obj;
            case 3:
                return (dj.m0) obj;
            case 4:
                ((dj.m0) obj).close();
                return Unit.INSTANCE;
            default:
                ((dj.m0) obj).close();
                return null;
        }
    }
}
