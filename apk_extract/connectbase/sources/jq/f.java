package jq;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final f f8799a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public static final Charset f8800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    @os.l
    public static final Charset f8801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @in.f
    @os.l
    public static final Charset f8802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @in.f
    @os.l
    public static final Charset f8803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @in.f
    @os.l
    public static final Charset f8804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @in.f
    @os.l
    public static final Charset f8805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.m
    public static volatile Charset f8806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public static volatile Charset f8807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.m
    public static volatile Charset f8808j;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kn.l0.o(charsetForName, "forName(...)");
        f8800b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        kn.l0.o(charsetForName2, "forName(...)");
        f8801c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        kn.l0.o(charsetForName3, "forName(...)");
        f8802d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        kn.l0.o(charsetForName4, "forName(...)");
        f8803e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        kn.l0.o(charsetForName5, "forName(...)");
        f8804f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        kn.l0.o(charsetForName6, "forName(...)");
        f8805g = charsetForName6;
    }

    @in.i(name = "UTF32")
    @os.l
    public final Charset a() {
        Charset charset = f8806h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32");
        kn.l0.o(charsetForName, "forName(...)");
        f8806h = charsetForName;
        return charsetForName;
    }

    @in.i(name = "UTF32_BE")
    @os.l
    public final Charset b() {
        Charset charset = f8808j;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        kn.l0.o(charsetForName, "forName(...)");
        f8808j = charsetForName;
        return charsetForName;
    }

    @in.i(name = "UTF32_LE")
    @os.l
    public final Charset c() {
        Charset charset = f8807i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        kn.l0.o(charsetForName, "forName(...)");
        f8807i = charsetForName;
        return charsetForName;
    }
}
