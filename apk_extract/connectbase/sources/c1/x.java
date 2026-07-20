package c1;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@k
public final class x extends h implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matcher f1254a;

        public a(Matcher matcher) {
            matcher.getClass();
            this.f1254a = matcher;
        }

        @Override // c1.g
        public int a() {
            return this.f1254a.end();
        }

        @Override // c1.g
        public boolean b() {
            return this.f1254a.find();
        }

        @Override // c1.g
        public boolean c(int index) {
            return this.f1254a.find(index);
        }

        @Override // c1.g
        public boolean d() {
            return this.f1254a.matches();
        }

        @Override // c1.g
        public String e(String replacement) {
            return this.f1254a.replaceAll(replacement);
        }

        @Override // c1.g
        public int f() {
            return this.f1254a.start();
        }
    }

    public x(Pattern pattern) {
        pattern.getClass();
        this.pattern = pattern;
    }

    @Override // c1.h
    public int flags() {
        return this.pattern.flags();
    }

    @Override // c1.h
    public g matcher(CharSequence t10) {
        return new a(this.pattern.matcher(t10));
    }

    @Override // c1.h
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // c1.h
    public String toString() {
        return this.pattern.toString();
    }
}
