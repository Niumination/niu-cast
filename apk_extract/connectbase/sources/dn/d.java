package dn;

import java.io.InputStream;
import java.nio.charset.Charset;
import kn.l0;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "ConsoleKt")
public final class d {
    @an.f
    public static final void a(byte b10) {
        System.out.print(Byte.valueOf(b10));
    }

    @an.f
    public static final void b(char c10) {
        System.out.print(c10);
    }

    @an.f
    public static final void c(double d10) {
        System.out.print(d10);
    }

    @an.f
    public static final void d(float f10) {
        System.out.print(f10);
    }

    @an.f
    public static final void e(int i10) {
        System.out.print(i10);
    }

    @an.f
    public static final void f(long j10) {
        System.out.print(j10);
    }

    @an.f
    public static final void g(Object obj) {
        System.out.print(obj);
    }

    @an.f
    public static final void h(short s10) {
        System.out.print(Short.valueOf(s10));
    }

    @an.f
    public static final void i(boolean z10) {
        System.out.print(z10);
    }

    @an.f
    public static final void j(char[] cArr) {
        l0.p(cArr, "message");
        System.out.print(cArr);
    }

    @an.f
    public static final void k() {
        System.out.println();
    }

    @an.f
    public static final void l(byte b10) {
        System.out.println(Byte.valueOf(b10));
    }

    @an.f
    public static final void m(char c10) {
        System.out.println(c10);
    }

    @an.f
    public static final void n(double d10) {
        System.out.println(d10);
    }

    @an.f
    public static final void o(float f10) {
        System.out.println(f10);
    }

    @an.f
    public static final void p(int i10) {
        System.out.println(i10);
    }

    @an.f
    public static final void q(long j10) {
        System.out.println(j10);
    }

    @an.f
    public static final void r(Object obj) {
        System.out.println(obj);
    }

    @an.f
    public static final void s(short s10) {
        System.out.println(Short.valueOf(s10));
    }

    @an.f
    public static final void t(boolean z10) {
        System.out.println(z10);
    }

    @an.f
    public static final void u(char[] cArr) {
        l0.p(cArr, "message");
        System.out.println(cArr);
    }

    @os.m
    public static final String v() {
        r rVar = r.f3783a;
        InputStream inputStream = System.in;
        l0.o(inputStream, "in");
        Charset charsetDefaultCharset = Charset.defaultCharset();
        l0.o(charsetDefaultCharset, "defaultCharset(...)");
        return rVar.d(inputStream, charsetDefaultCharset);
    }

    @f1(version = "1.6")
    @os.l
    public static final String w() {
        String strV = v();
        if (strV != null) {
            return strV;
        }
        throw new v("EOF has already been reached");
    }

    @os.m
    @f1(version = "1.6")
    public static final String x() {
        return v();
    }
}
