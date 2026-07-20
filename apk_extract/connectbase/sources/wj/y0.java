package wj;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y0 extends wj.a.c {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final vj.f1.a<Integer> f19566y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final vj.v1.i<Integer> f19567z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public vj.y2 f19568u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public vj.v1 f19569v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Charset f19570w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f19571x;

    public class a implements vj.f1.a<Integer> {
        @Override // vj.v1.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer b(byte[] bArr) {
            if (bArr.length < 3) {
                throw new NumberFormatException("Malformed status code ".concat(new String(bArr, vj.f1.f17136a)));
            }
            return Integer.valueOf((bArr[2] - 48) + ((bArr[1] - 48) * 10) + ((bArr[0] - 48) * 100));
        }

        @Override // vj.v1.m
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(Integer num) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        a aVar = new a();
        f19566y = aVar;
        f19567z = vj.f1.b(":status", aVar);
    }

    public y0(int i10, i3 i3Var, q3 q3Var, vj.e eVar) {
        super(i10, i3Var, q3Var, eVar);
        this.f19570w = c1.f.f1179c;
    }

    public static Charset S(vj.v1 v1Var) {
        String str = (String) v1Var.l(v0.f19364j);
        if (str != null) {
            String[] strArrSplit = str.split("charset=", 2);
            try {
                return Charset.forName(strArrSplit[strArrSplit.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return c1.f.f1179c;
    }

    public static void V(vj.v1 v1Var) {
        v1Var.j(f19567z);
        v1Var.j(vj.l1.f17168b);
        v1Var.j(vj.l1.f17167a);
    }

    public abstract void T(vj.y2 y2Var, boolean z10, vj.v1 v1Var);

    public final vj.y2 U(vj.v1 v1Var) {
        vj.y2 y2Var = (vj.y2) v1Var.l(vj.l1.f17168b);
        if (y2Var != null) {
            return y2Var.u((String) v1Var.l(vj.l1.f17167a));
        }
        if (this.f19571x) {
            return vj.y2.f17550g.u("missing GRPC status in response");
        }
        Integer num = (Integer) v1Var.l(f19567z);
        return (num != null ? v0.p(num.intValue()) : vj.y2.f17562s.u("missing HTTP status code")).g("missing GRPC status, inferred error from HTTP status code");
    }

    public void W(i2 i2Var, boolean z10) throws Throwable {
        vj.y2 y2Var = this.f19568u;
        if (y2Var != null) {
            this.f19568u = y2Var.g("DATA-----------------------------\n" + j2.e(i2Var, this.f19570w));
            i2Var.close();
            if (this.f19568u.f17569b.length() > 1000 || z10) {
                T(this.f19568u, false, this.f19569v);
                return;
            }
            return;
        }
        if (!this.f19571x) {
            T(vj.y2.f17562s.u("headers not received before payload"), false, new vj.v1());
            return;
        }
        int iE = i2Var.e();
        H(i2Var);
        if (z10) {
            if (iE > 0) {
                this.f19568u = vj.y2.f17562s.u("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.f19568u = vj.y2.f17562s.u("Received unexpected EOS on empty DATA frame from server");
            }
            vj.v1 v1Var = new vj.v1();
            this.f19569v = v1Var;
            R(this.f19568u, false, v1Var);
        }
    }

    public void X(vj.v1 v1Var) {
        c1.h0.F(v1Var, "headers");
        vj.y2 y2Var = this.f19568u;
        if (y2Var != null) {
            this.f19568u = y2Var.g("headers: " + v1Var);
            return;
        }
        try {
            if (this.f19571x) {
                vj.y2 y2VarU = vj.y2.f17562s.u("Received headers twice");
                this.f19568u = y2VarU;
                if (y2VarU != null) {
                    this.f19568u = y2VarU.g("headers: " + v1Var);
                    this.f19569v = v1Var;
                    this.f19570w = S(v1Var);
                    return;
                }
                return;
            }
            Integer num = (Integer) v1Var.l(f19567z);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                vj.y2 y2Var2 = this.f19568u;
                if (y2Var2 != null) {
                    this.f19568u = y2Var2.g("headers: " + v1Var);
                    this.f19569v = v1Var;
                    this.f19570w = S(v1Var);
                    return;
                }
                return;
            }
            this.f19571x = true;
            vj.y2 y2VarZ = Z(v1Var);
            this.f19568u = y2VarZ;
            if (y2VarZ != null) {
                if (y2VarZ != null) {
                    this.f19568u = y2VarZ.g("headers: " + v1Var);
                    this.f19569v = v1Var;
                    this.f19570w = S(v1Var);
                    return;
                }
                return;
            }
            V(v1Var);
            I(v1Var);
            vj.y2 y2Var3 = this.f19568u;
            if (y2Var3 != null) {
                this.f19568u = y2Var3.g("headers: " + v1Var);
                this.f19569v = v1Var;
                this.f19570w = S(v1Var);
            }
        } catch (Throwable th2) {
            vj.y2 y2Var4 = this.f19568u;
            if (y2Var4 != null) {
                this.f19568u = y2Var4.g("headers: " + v1Var);
                this.f19569v = v1Var;
                this.f19570w = S(v1Var);
            }
            throw th2;
        }
    }

    public void Y(vj.v1 v1Var) {
        c1.h0.F(v1Var, "trailers");
        if (this.f19568u == null && !this.f19571x) {
            vj.y2 y2VarZ = Z(v1Var);
            this.f19568u = y2VarZ;
            if (y2VarZ != null) {
                this.f19569v = v1Var;
            }
        }
        vj.y2 y2Var = this.f19568u;
        if (y2Var == null) {
            vj.y2 y2VarU = U(v1Var);
            V(v1Var);
            J(v1Var, y2VarU);
        } else {
            vj.y2 y2VarG = y2Var.g("trailers: " + v1Var);
            this.f19568u = y2VarG;
            T(y2VarG, false, this.f19569v);
        }
    }

    @gm.j
    public final vj.y2 Z(vj.v1 v1Var) {
        Integer num = (Integer) v1Var.l(f19567z);
        if (num == null) {
            return vj.y2.f17562s.u("Missing HTTP status code");
        }
        String str = (String) v1Var.l(v0.f19364j);
        if (v0.q(str)) {
            return null;
        }
        return v0.p(num.intValue()).g("invalid content-type: " + str);
    }

    @Override // wj.a.c, wj.t1.b
    public /* bridge */ /* synthetic */ void e(boolean z10) {
        super.e(z10);
    }
}
