package wk;

import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;
import ik.b1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final v f19630a;

    public static final class a extends k0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final String f19631b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@os.l v vVar, @os.l String str) {
            super(vVar);
            kn.l0.p(vVar, "route");
            kn.l0.p(str, HomeKeyReceiver.f2161e);
            this.f19631b = str;
        }

        @Override // wk.k0
        public /* bridge */ /* synthetic */ b1 a() {
            return (b1) c();
        }

        @os.l
        public Void c() {
            throw new UnsupportedOperationException("Parameters are available only when routing resolve succeeds");
        }

        @os.l
        public final String d() {
            return this.f19631b;
        }

        @os.l
        public String toString() {
            return "FAILURE \"" + this.f19631b + "\" @ " + this.f19630a;
        }
    }

    public /* synthetic */ k0(v vVar, kn.w wVar) {
        this(vVar);
    }

    @os.l
    public abstract b1 a();

    @os.l
    public final v b() {
        return this.f19630a;
    }

    public k0(v vVar) {
        this.f19630a = vVar;
    }

    public static final class b extends k0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final b1 f19632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f19633c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@os.l v vVar, @os.l b1 b1Var, double d10) {
            super(vVar);
            kn.l0.p(vVar, "route");
            kn.l0.p(b1Var, "parameters");
            this.f19632b = b1Var;
            this.f19633c = d10;
        }

        @Override // wk.k0
        @os.l
        public b1 a() {
            return this.f19632b;
        }

        public final double c() {
            return this.f19633c;
        }

        @os.l
        public String toString() {
            StringBuilder sb2 = new StringBuilder("SUCCESS");
            sb2.append(this.f19632b.isEmpty() ? "" : kn.l0.C("; ", this.f19632b));
            sb2.append(" @ ");
            sb2.append(this.f19630a);
            return sb2.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @lm.k(message = "This is an implementation detail and will become internal in future releases.")
        public b(@os.l v vVar, @os.l b1 b1Var) {
            this(vVar, b1Var, 0.0d);
            kn.l0.p(vVar, "route");
            kn.l0.p(b1Var, "parameters");
        }
    }
}
