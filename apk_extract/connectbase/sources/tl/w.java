package tl;

/* JADX INFO: loaded from: classes2.dex */
@ul.d
@lm.k(message = "Will be removed in the future releases. Use Input or AbstractInput instead.", replaceWith = @lm.a1(expression = "AbstractInput", imports = {"io.ktor.utils.io.core.AbstractInput"}))
public abstract class w extends tl.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f15886e = new a();

    public static final class a {
        public a() {
        }

        @lm.k(level = lm.m.ERROR, message = "Use ByteReadPacket.Empty instead", replaceWith = @lm.a1(expression = "ByteReadPacket.Empty", imports = {}))
        public static /* synthetic */ void b() {
        }

        @os.l
        public final v a() {
            v.f15884f.getClass();
            return v.f15885g;
        }

        public a(kn.w wVar) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(@os.l ul.b bVar, long j10, @os.l bm.h<ul.b> hVar) {
        super(bVar, j10, hVar);
        kn.l0.p(bVar, "head");
        kn.l0.p(hVar, "pool");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ w(o0 o0Var, long j10, bm.h hVar) {
        this((ul.b) o0Var, j10, (bm.h<ul.b>) hVar);
        kn.l0.p(o0Var, "head");
        kn.l0.p(hVar, "pool");
    }
}
