package sj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import tj.z0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient o f15083a;

    public static class a extends d {
        private static final long serialVersionUID = 1;

        public a(String str, Throwable th2) {
            super(str, th2);
        }

        public a(String str) {
            this(str, null);
        }
    }

    public static class b extends c {
        private static final long serialVersionUID = 1;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(o oVar, String str, String str2, Throwable th2) {
            if (str != null) {
                str2 = "Invalid path '" + str + "': " + str2;
            }
            super(oVar, str2, th2);
        }

        public b(o oVar, String str, String str2) {
            this(oVar, str, str2, null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(String str, String str2, Throwable th2) {
            if (str != null) {
                str2 = "Invalid path '" + str + "': " + str2;
            }
            super(str2, th2);
        }

        public b(String str, String str2) {
            this(str, str2, (Throwable) null);
        }

        public b(o oVar, String str) {
            this(oVar, (String) null, str);
        }
    }

    /* JADX INFO: renamed from: sj.c$c, reason: collision with other inner class name */
    public static class C0371c extends c {
        private static final long serialVersionUID = 1;

        public C0371c(o oVar, String str, String str2, Throwable th2) {
            super(oVar, "Invalid value at '" + str + "': " + str2, th2);
        }

        public C0371c(o oVar, String str, String str2) {
            this(oVar, str, str2, null);
        }

        public C0371c(String str, String str2, Throwable th2) {
            super("Invalid value at '" + str + "': " + str2, th2);
        }

        public C0371c(String str, String str2) {
            this(str, str2, (Throwable) null);
        }
    }

    public static class d extends c {
        private static final long serialVersionUID = 1;

        public d(String str, Throwable th2) {
            super(str, th2);
        }

        public d(String str) {
            this(str, null);
        }
    }

    public static class e extends c {
        private static final long serialVersionUID = 1;

        public e(String str, Throwable th2) {
            super(str, th2);
        }

        public e(String str) {
            this(str, null);
        }
    }

    public static class f extends c {
        private static final long serialVersionUID = 1;

        public f(o oVar, String str, Throwable th2) {
            super(oVar, str, th2);
        }

        public f(o oVar, String str) {
            this(oVar, str, null);
        }
    }

    public static class h extends d {
        private static final long serialVersionUID = 1;

        public h(String str, Throwable th2) {
            super(str, th2);
        }

        public h(String str) {
            this(str, null);
        }
    }

    public static class i extends g {
        private static final long serialVersionUID = 1;

        public i(o oVar, String str, String str2, Throwable th2) {
            super(oVar, b(str, str2), th2);
        }

        public static String b(String str, String str2) {
            if (str2 == null) {
                return n.a.a("Configuration key '", str, "' is null");
            }
            return "Configuration key '" + str + "' is set to null but expected " + str2;
        }

        public i(o oVar, String str, String str2) {
            this(oVar, str, str2, null);
        }
    }

    public static class j extends c {
        private static final long serialVersionUID = 1;

        public j(o oVar, String str, Throwable th2) {
            super(oVar, str, th2);
        }

        public j(o oVar, String str) {
            this(oVar, str, null);
        }
    }

    public static class l extends c {
        private static final long serialVersionUID = 1;
        private final Iterable<m> problems;

        public l(Iterable<m> iterable) {
            super(b(iterable), (Throwable) null);
            this.problems = iterable;
        }

        public static String b(Iterable<m> iterable) {
            StringBuilder sb2 = new StringBuilder();
            for (m mVar : iterable) {
                sb2.append(mVar.origin().description());
                sb2.append(": ");
                sb2.append(mVar.path());
                sb2.append(": ");
                sb2.append(mVar.problem());
                sb2.append(", ");
            }
            if (sb2.length() == 0) {
                throw new d("ValidationFailed must have a non-empty list of problems");
            }
            sb2.setLength(sb2.length() - 2);
            return sb2.toString();
        }

        public Iterable<m> problems() {
            return this.problems;
        }
    }

    public static class m implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient o f15084a;
        private final String path;
        private final String problem;

        public m(String str, o oVar, String str2) {
            this.path = str;
            this.f15084a = oVar;
            this.problem = str2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            c.a(this, m.class, z0.readOrigin(objectInputStream, null));
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            tj.n.q(objectOutputStream, this.f15084a);
        }

        public o origin() {
            return this.f15084a;
        }

        public String path() {
            return this.path;
        }

        public String problem() {
            return this.problem;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("ValidationProblem(");
            sb2.append(this.path);
            sb2.append(ks.g.f9491d);
            sb2.append(this.f15084a);
            sb2.append(ks.g.f9491d);
            return j.c.a(sb2, this.problem, ")");
        }
    }

    public static class n extends c {
        private static final long serialVersionUID = 1;

        public n(o oVar, String str, String str2, String str3, Throwable th2) {
            super(oVar, str + " has type " + str3 + " rather than " + str2, th2);
        }

        public n(o oVar, String str, String str2, String str3) {
            this(oVar, str, str2, str3, null);
        }

        public n(o oVar, String str, Throwable th2) {
            super(oVar, str, th2);
        }

        public n(o oVar, String str) {
            super(oVar, str, null);
        }
    }

    public c(o oVar, String str, Throwable th2) {
        super(oVar.description() + ": " + str, th2);
        this.f15083a = oVar;
    }

    public static <T> void a(T t10, Class<T> cls, o oVar) throws IOException {
        try {
            Field declaredField = cls.getDeclaredField(n1.d.a.f11176d);
            declaredField.setAccessible(true);
            try {
                declaredField.set(t10, oVar);
            } catch (IllegalAccessException e10) {
                throw new IOException("unable to set origin field", e10);
            } catch (IllegalArgumentException e11) {
                throw new IOException("unable to set origin field", e11);
            }
        } catch (NoSuchFieldException e12) {
            throw new IOException(cls.getSimpleName().concat(" has no origin field?"), e12);
        } catch (SecurityException e13) {
            throw new IOException("unable to fill out origin field in ".concat(cls.getSimpleName()), e13);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a(this, c.class, z0.readOrigin(objectInputStream, null));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        tj.n.q(objectOutputStream, this.f15083a);
    }

    public o origin() {
        return this.f15083a;
    }

    public c(o oVar, String str) {
        this(oVar.description() + ": " + str, (Throwable) null);
    }

    public c(String str, Throwable th2) {
        super(str, th2);
        this.f15083a = null;
    }

    public c(String str) {
        this(str, (Throwable) null);
    }

    public static class g extends c {
        private static final long serialVersionUID = 1;

        public g(String str, Throwable th2) {
            super(n.a.a("No configuration setting found for key '", str, "'"), th2);
        }

        public g(o oVar, String str) {
            this(oVar, n.a.a("No configuration setting found for key '", str, "'"), null);
        }

        public g(String str) {
            this(str, (Throwable) null);
        }

        public g(o oVar, String str, Throwable th2) {
            super(oVar, str, th2);
        }
    }

    public static class k extends j {
        private static final long serialVersionUID = 1;
        private final String detail;

        public k(o oVar, String str, Throwable th2) {
            super(oVar, m.a.a("Could not resolve substitution to a value: ", str), th2);
            this.detail = str;
        }

        public k addExtraDetail(String str) {
            return new k(this, origin(), String.format(str, this.detail));
        }

        public k(o oVar, String str) {
            this(oVar, str, (Throwable) null);
        }

        public k(k kVar, o oVar, String str) {
            super(oVar, str, kVar);
            this.detail = kVar.detail;
        }
    }
}
