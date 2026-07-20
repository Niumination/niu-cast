package ks;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public class f extends PrintStream {
    public f(ms.a aVar, boolean z10) {
        super(aVar, z10);
    }

    public b b() {
        return d().b();
    }

    public e c() {
        return d().c();
    }

    public ms.a d() {
        return (ms.a) ((PrintStream) this).out;
    }

    public int h() {
        return d().d();
    }

    public h k() {
        return d().h();
    }

    public void n() throws IOException {
        d().k();
    }

    public boolean o() {
        return d().n();
    }

    public void p(e eVar) {
        d().y(eVar);
    }

    public void q(boolean z10) {
        d().A(z10);
    }

    public void t() throws IOException {
        ms.a aVarD = d();
        if (aVarD != null) {
            aVarD.E();
        }
    }

    public String toString() {
        return "AnsiPrintStream{type=" + k() + ", colors=" + b() + ", mode=" + c() + ", resetAtUninstall=" + o() + "}";
    }

    public f(ms.a aVar, boolean z10, String str) throws UnsupportedEncodingException {
        super(aVar, z10, str);
    }
}
