package rp;

import eo.h0;
import ik.y0;
import java.util.List;
import kn.l0;
import kn.n0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends jp.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final f0 f14757c;

    public static final class a extends n0 implements jn.l<h0, f0> {
        final /* synthetic */ f0 $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f0 f0Var) {
            super(1);
            this.$type = f0Var;
        }

        @Override // jn.l
        @os.l
        public final f0 invoke(@os.l h0 h0Var) {
            l0.p(h0Var, "it");
            return this.$type;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@os.l List<? extends jp.g<?>> list, @os.l f0 f0Var) {
        super(list, new a(f0Var));
        l0.p(list, "value");
        l0.p(f0Var, y0.a.f8215h);
        this.f14757c = f0Var;
    }

    @os.l
    public final f0 c() {
        return this.f14757c;
    }
}
