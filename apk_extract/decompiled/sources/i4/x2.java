package i4;

/* JADX INFO: loaded from: classes.dex */
public final class x2 implements q2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x2 f5705b = new x2(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x2 f5706c = new x2(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x2 f5707d = new x2(2);
    public static final x2 e = new x2(3);
    public static final x2 f = new x2(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x2 f5708g = new x2(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5709a;

    public /* synthetic */ x2(int i8) {
        this.f5709a = i8;
    }

    @Override // i4.q2
    public final w2 a() {
        switch (this.f5709a) {
            case 0:
                return w2.STRONG;
            case 1:
                return w2.STRONG;
            case 2:
                return w2.WEAK;
            case 3:
                return w2.STRONG;
            case 4:
                return w2.STRONG;
            default:
                return w2.WEAK;
        }
    }

    @Override // i4.q2
    public final s2 b(u3 u3Var, int i8) {
        switch (this.f5709a) {
            case 0:
                return new a3(u3Var, i8);
            case 1:
                return new d3(u3Var, i8);
            case 2:
                return new g3(u3Var, i8);
            case 3:
                return new j3(u3Var, i8);
            case 4:
                return new m3(u3Var, i8);
            default:
                return new p3(u3Var, i8);
        }
    }

    @Override // i4.q2
    public final p2 c(s2 s2Var, Object obj, int i8, p2 p2Var) {
        switch (this.f5709a) {
            case 0:
                z2 z2Var = (z2) p2Var;
                return z2Var == null ? new z2(obj, i8) : new y2(obj, i8, z2Var);
            case 1:
                c3 c3Var = (c3) p2Var;
                return c3Var == null ? new c3(obj, i8) : new b3(obj, i8, c3Var);
            case 2:
                f3 f3Var = (f3) p2Var;
                return f3Var == null ? new f3(obj, i8) : new e3(obj, i8, f3Var);
            case 3:
                j3 j3Var = (j3) s2Var;
                i3 i3Var = (i3) p2Var;
                return i3Var == null ? new i3(j3Var.queueForKeys, obj, i8) : new h3(j3Var.queueForKeys, obj, i8, i3Var);
            case 4:
                m3 m3Var = (m3) s2Var;
                l3 l3Var = (l3) p2Var;
                return l3Var == null ? new l3(m3Var.queueForKeys, obj, i8) : new k3(m3Var.queueForKeys, obj, i8, l3Var);
            default:
                p3 p3Var = (p3) s2Var;
                o3 o3Var = (o3) p2Var;
                return o3Var == null ? new o3(p3Var.queueForKeys, obj, i8) : new n3(p3Var.queueForKeys, obj, i8, o3Var);
        }
    }

    @Override // i4.q2
    public final w2 d() {
        switch (this.f5709a) {
            case 0:
                return w2.STRONG;
            case 1:
                return w2.STRONG;
            case 2:
                return w2.STRONG;
            case 3:
                return w2.WEAK;
            case 4:
                return w2.WEAK;
            default:
                return w2.WEAK;
        }
    }

    @Override // i4.q2
    public final void e(s2 s2Var, p2 p2Var, Object obj) {
        switch (this.f5709a) {
            case 0:
                break;
            case 1:
                ((c3) p2Var).f5573c = obj;
                break;
            case 2:
                f3 f3Var = (f3) p2Var;
                r3 r3Var = f3Var.f5586c;
                f3Var.f5586c = new s3(((g3) s2Var).queueForValues, obj, f3Var);
                r3Var.clear();
                break;
            case 3:
                break;
            case 4:
                ((l3) p2Var).f5637b = obj;
                break;
            default:
                o3 o3Var = (o3) p2Var;
                r3 r3Var2 = o3Var.f5669b;
                o3Var.f5669b = new s3(((p3) s2Var).queueForValues, obj, o3Var);
                r3Var2.clear();
                break;
        }
    }

    @Override // i4.q2
    public final p2 f(s2 s2Var, p2 p2Var, p2 p2Var2) {
        switch (this.f5709a) {
            case 0:
                z2 z2Var = (z2) p2Var;
                z2 z2Var2 = (z2) p2Var2;
                Object obj = z2Var.f5635a;
                int i8 = z2Var.f5636b;
                return z2Var2 == null ? new z2(obj, i8) : new y2(obj, i8, z2Var2);
            case 1:
                c3 c3Var = (c3) p2Var;
                c3 c3Var2 = (c3) p2Var2;
                Object obj2 = c3Var.f5635a;
                int i9 = c3Var.f5636b;
                c3 c3Var3 = c3Var2 == null ? new c3(obj2, i9) : new b3(obj2, i9, c3Var2);
                c3Var3.f5573c = c3Var.f5573c;
                return c3Var3;
            case 2:
                g3 g3Var = (g3) s2Var;
                f3 f3Var = (f3) p2Var;
                f3 f3Var2 = (f3) p2Var2;
                if (s2.isCollected(f3Var)) {
                    return null;
                }
                Object obj3 = f3Var.f5635a;
                int i10 = f3Var.f5636b;
                f3 f3Var3 = f3Var2 == null ? new f3(obj3, i10) : new e3(obj3, i10, f3Var2);
                f3Var3.f5586c = f3Var.f5586c.a(g3Var.queueForValues, f3Var3);
                return f3Var3;
            case 3:
                j3 j3Var = (j3) s2Var;
                i3 i3Var = (i3) p2Var;
                i3 i3Var2 = (i3) p2Var2;
                T t3 = i3Var.get();
                if (t3 == 0) {
                    return null;
                }
                int i11 = i3Var.f5646a;
                return i3Var2 == null ? new i3(j3Var.queueForKeys, t3, i11) : new h3(j3Var.queueForKeys, t3, i11, i3Var2);
            case 4:
                m3 m3Var = (m3) s2Var;
                l3 l3Var = (l3) p2Var;
                l3 l3Var2 = (l3) p2Var2;
                T t8 = l3Var.get();
                if (t8 == 0) {
                    return null;
                }
                int i12 = l3Var.f5646a;
                l3 l3Var3 = l3Var2 == null ? new l3(m3Var.queueForKeys, t8, i12) : new k3(m3Var.queueForKeys, t8, i12, l3Var2);
                l3Var3.f5637b = l3Var.f5637b;
                return l3Var3;
            default:
                p3 p3Var = (p3) s2Var;
                o3 o3Var = (o3) p2Var;
                o3 o3Var2 = (o3) p2Var2;
                T t10 = o3Var.get();
                o3 o3Var3 = null;
                if (t10 != 0 && !s2.isCollected(o3Var)) {
                    int i13 = o3Var.f5646a;
                    o3Var3 = o3Var2 == null ? new o3(p3Var.queueForKeys, t10, i13) : new n3(p3Var.queueForKeys, t10, i13, o3Var2);
                    o3Var3.f5669b = o3Var.f5669b.a(p3Var.queueForValues, o3Var3);
                }
                return o3Var3;
        }
    }
}
