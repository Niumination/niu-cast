package eo;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends eo.a, d0 {

    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    @Override // eo.a, eo.m
    @os.l
    b a();

    @Override // eo.a
    @os.l
    Collection<? extends b> d();

    @os.l
    a getKind();

    @os.l
    b h0(m mVar, e0 e0Var, u uVar, a aVar, boolean z10);

    void z0(@os.l Collection<? extends b> collection);
}
