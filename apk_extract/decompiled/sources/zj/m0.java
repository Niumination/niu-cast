package zj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f11656x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f11657y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f11658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f11659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Annotation[] f11660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Annotation[][] f11661d;
    public final Type[] e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11667l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11668m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f11669n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f11670o;
    public boolean p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f11671r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public dj.s f11672s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public dj.x f11673t;
    public LinkedHashSet u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public s[] f11674v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11675w;

    public m0(q0 q0Var, Method method) {
        this.f11658a = q0Var;
        this.f11659b = method;
        this.f11660c = method.getAnnotations();
        this.e = method.getGenericParameterTypes();
        this.f11661d = method.getParameterAnnotations();
    }

    public static Class a(Class cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }

    public final void b(String str, String str2, boolean z2) {
        String str3 = this.f11669n;
        Method method = this.f11659b;
        if (str3 != null) {
            throw s.k(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }
        this.f11669n = str;
        this.f11670o = z2;
        if (str2.isEmpty()) {
            return;
        }
        int iIndexOf = str2.indexOf(63);
        Pattern pattern = f11656x;
        if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
            String strSubstring = str2.substring(iIndexOf + 1);
            if (pattern.matcher(strSubstring).find()) {
                throw s.k(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
            }
        }
        this.f11671r = str2;
        Matcher matcher = pattern.matcher(str2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        this.u = linkedHashSet;
    }

    public final void c(int i8, Type type) {
        if (s.i(type)) {
            throw s.l(this.f11659b, i8, "Parameter type must not include a type variable or wildcard: %s", type);
        }
    }
}
