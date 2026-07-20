package tl;

import java.io.EOFException;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final boolean a(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        m mVar = eVar.f15821b;
        return mVar.f15874c > mVar.f15873b;
    }

    public static final boolean b(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        m mVar = eVar.f15821b;
        return mVar.f15872a > mVar.f15874c;
    }

    @os.l
    public static final Void c(int i10, int i11) {
        throw new EOFException("Unable to discard " + i10 + " bytes: only " + i11 + " available for writing");
    }

    @os.l
    public static final Void d(int i10, int i11) {
        throw new EOFException("Unable to discard " + i10 + " bytes: only " + i11 + " available for reading");
    }

    public static final void e(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        StringBuilder sbA = h.b.a("End gap ", i10, " is too big: capacity is ");
        sbA.append(eVar.f15822c);
        throw new IllegalArgumentException(sbA.toString());
    }

    public static final void f(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        StringBuilder sbA = h.b.a("Unable to reserve end gap ", i10, ": there are already ");
        m mVar = eVar.f15821b;
        sbA.append(mVar.f15874c - mVar.f15873b);
        sbA.append(" content bytes at offset ");
        sbA.append(eVar.f15821b.f15873b);
        throw new IllegalArgumentException(sbA.toString());
    }

    public static final void g(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        throw new IllegalArgumentException(c.a.a(h.b.a("End gap ", i10, " is too big: there are already "), eVar.f15821b.f15875d, " bytes reserved in the beginning"));
    }

    @ul.d
    public static final int h(@os.l e eVar, @os.l jn.q<? super ql.f, ? super Integer, ? super Integer, Integer> qVar) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(qVar, "block");
        int iIntValue = qVar.invoke(ql.f.b(eVar.f15820a), Integer.valueOf(eVar.f15821b.f15873b), Integer.valueOf(eVar.f15821b.f15874c)).intValue();
        eVar.h(iIntValue);
        return iIntValue;
    }

    public static final void i(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        eVar.l0(eVar.f15821b.f15873b - i10);
    }

    @os.l
    public static final Void j(int i10, int i11) {
        throw new IllegalArgumentException("Unable to rewind " + i10 + " bytes: only " + i11 + " could be rewinded");
    }

    @os.l
    public static final Void k(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        StringBuilder sbA = h.b.a("Unable to reserve ", i10, " start gap: there are already ");
        m mVar = eVar.f15821b;
        sbA.append(mVar.f15874c - mVar.f15873b);
        sbA.append(" content bytes starting at offset ");
        sbA.append(eVar.f15821b.f15873b);
        throw new IllegalStateException(sbA.toString());
    }

    @os.l
    public static final Void l(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        if (i10 > eVar.f15822c) {
            StringBuilder sbA = h.b.a("Start gap ", i10, " is bigger than the capacity ");
            sbA.append(eVar.f15822c);
            throw new IllegalArgumentException(sbA.toString());
        }
        StringBuilder sbA2 = h.b.a("Unable to reserve ", i10, " start gap: there are already ");
        sbA2.append(eVar.f15822c - eVar.f15821b.f15872a);
        sbA2.append(" bytes reserved in the end");
        throw new IllegalStateException(sbA2.toString());
    }

    @ul.d
    public static final int m(@os.l e eVar, @os.l jn.q<? super ql.f, ? super Integer, ? super Integer, Integer> qVar) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(qVar, "block");
        int iIntValue = qVar.invoke(ql.f.b(eVar.f15820a), Integer.valueOf(eVar.f15821b.f15874c), Integer.valueOf(eVar.f15821b.f15872a)).intValue();
        eVar.b(iIntValue);
        return iIntValue;
    }
}
