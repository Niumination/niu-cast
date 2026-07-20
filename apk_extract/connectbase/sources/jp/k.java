package jp;

import eo.h0;
import kn.l0;
import lm.l2;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends g<l2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f8778b = new a();

    public static final class a {
        public a() {
        }

        @os.l
        public final k a(@os.l String str) {
            l0.p(str, "message");
            return new b(str);
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final String f8779c;

        public b(@os.l String str) {
            l0.p(str, "message");
            this.f8779c = str;
        }

        @Override // jp.g
        @os.l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public n0 a(@os.l h0 h0Var) {
            l0.p(h0Var, "module");
            n0 n0VarJ = vp.x.j(this.f8779c);
            l0.o(n0VarJ, "createErrorType(message)");
            return n0VarJ;
        }

        @Override // jp.g
        @os.l
        public String toString() {
            return this.f8779c;
        }
    }

    public k() {
        super(l2.f10208a);
    }

    @Override // jp.g
    @os.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public l2 b() {
        throw new UnsupportedOperationException();
    }
}
