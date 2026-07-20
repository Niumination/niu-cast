package c1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class z {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0053b f1265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0053b f1266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1268e;

        public static final class a extends C0053b {
            public a() {
            }

            public a(a aVar) {
            }
        }

        /* JADX INFO: renamed from: c1.z$b$b, reason: collision with other inner class name */
        public static class C0053b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @gm.a
            public String f1269a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @gm.a
            public Object f1270b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @gm.a
            public C0053b f1271c;

            public C0053b() {
            }

            public C0053b(a aVar) {
            }
        }

        public static boolean u(Object value) {
            if (value instanceof CharSequence) {
                return ((CharSequence) value).length() == 0;
            }
            if (value instanceof Collection) {
                return ((Collection) value).isEmpty();
            }
            if (value instanceof Map) {
                return ((Map) value).isEmpty();
            }
            if (value instanceof c0) {
                return !((c0) value).isPresent();
            }
            return value.getClass().isArray() && Array.getLength(value) == 0;
        }

        @t1.a
        public b a(String name, char value) {
            return m(name, String.valueOf(value));
        }

        @t1.a
        public b b(String name, double value) {
            return m(name, String.valueOf(value));
        }

        @t1.a
        public b c(String name, float value) {
            return m(name, String.valueOf(value));
        }

        @t1.a
        public b d(String name, int value) {
            return m(name, String.valueOf(value));
        }

        @t1.a
        public b e(String name, long value) {
            return m(name, String.valueOf(value));
        }

        @t1.a
        public b f(String name, @gm.a Object value) {
            return j(name, value);
        }

        @t1.a
        public b g(String name, boolean value) {
            return m(name, String.valueOf(value));
        }

        public final C0053b h() {
            C0053b c0053b = new C0053b();
            this.f1266c.f1271c = c0053b;
            this.f1266c = c0053b;
            return c0053b;
        }

        @t1.a
        public final b i(@gm.a Object value) {
            h().f1270b = value;
            return this;
        }

        @t1.a
        public final b j(String name, @gm.a Object value) {
            C0053b c0053bH = h();
            c0053bH.f1270b = value;
            name.getClass();
            c0053bH.f1269a = name;
            return this;
        }

        public final a k() {
            a aVar = new a();
            this.f1266c.f1271c = aVar;
            this.f1266c = aVar;
            return aVar;
        }

        @t1.a
        public final b l(Object value) {
            k().f1270b = value;
            return this;
        }

        @t1.a
        public final b m(String name, Object value) {
            a aVarK = k();
            aVarK.f1270b = value;
            name.getClass();
            aVarK.f1269a = name;
            return this;
        }

        @t1.a
        public b n(char value) {
            k().f1270b = String.valueOf(value);
            return this;
        }

        @t1.a
        public b o(double value) {
            k().f1270b = String.valueOf(value);
            return this;
        }

        @t1.a
        public b p(float value) {
            k().f1270b = String.valueOf(value);
            return this;
        }

        @t1.a
        public b q(int value) {
            k().f1270b = String.valueOf(value);
            return this;
        }

        @t1.a
        public b r(long value) {
            k().f1270b = String.valueOf(value);
            return this;
        }

        @t1.a
        public b s(@gm.a Object value) {
            h().f1270b = value;
            return this;
        }

        @t1.a
        public b t(boolean value) {
            k().f1270b = String.valueOf(value);
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0030  */
        /* JADX WARN: Code duplicated, block: B:14:0x0037  */
        /* JADX WARN: Code duplicated, block: B:16:0x0041  */
        /* JADX WARN: Code duplicated, block: B:19:0x005d  */
        public String toString() {
            String str;
            boolean z10 = this.f1267d;
            boolean z11 = this.f1268e;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f1264a);
            sb2.append(rs.f.f14859a);
            String str2 = "";
            for (C0053b c0053b = this.f1265b.f1271c; c0053b != null; c0053b = c0053b.f1271c) {
                Object obj = c0053b.f1270b;
                if (c0053b instanceof a) {
                    sb2.append(str2);
                    str = c0053b.f1269a;
                    if (str != null) {
                        sb2.append(str);
                        sb2.append(fl.h.f6043c);
                    }
                    if (obj == null && obj.getClass().isArray()) {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    } else {
                        sb2.append(obj);
                    }
                    str2 = ", ";
                } else if (obj == null) {
                    if (!z10) {
                        sb2.append(str2);
                        str = c0053b.f1269a;
                        if (str != null) {
                            sb2.append(str);
                            sb2.append(fl.h.f6043c);
                        }
                        if (obj == null) {
                            sb2.append(obj);
                        } else {
                            sb2.append(obj);
                        }
                        str2 = ", ";
                    }
                } else if (!z11 || !u(obj)) {
                    sb2.append(str2);
                    str = c0053b.f1269a;
                    if (str != null) {
                        sb2.append(str);
                        sb2.append(fl.h.f6043c);
                    }
                    if (obj == null) {
                        sb2.append(obj);
                    } else {
                        sb2.append(obj);
                    }
                    str2 = ", ";
                }
            }
            sb2.append(rs.f.f14860b);
            return sb2.toString();
        }

        @t1.a
        public b v() {
            this.f1267d = true;
            return this;
        }

        public b(String className) {
            C0053b c0053b = new C0053b();
            this.f1265b = c0053b;
            this.f1266c = c0053b;
            this.f1267d = false;
            this.f1268e = false;
            className.getClass();
            this.f1264a = className;
        }
    }

    public static <T> T a(@gm.a T first, @gm.a T second) {
        if (first != null) {
            return first;
        }
        if (second != null) {
            return second;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Class<?> clazz) {
        return new b(clazz.getSimpleName());
    }

    public static b c(Object self) {
        return new b(self.getClass().getSimpleName());
    }

    public static b d(String className) {
        return new b(className);
    }
}
