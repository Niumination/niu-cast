package c1;

import java.io.Serializable;
import java.util.Objects;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public abstract class d {
    public static final d LOWER_CAMEL;
    public static final d LOWER_UNDERSCORE;
    public static final d UPPER_CAMEL;
    public static final d UPPER_UNDERSCORE;
    private final c1.e wordBoundary;
    private final String wordSeparator;
    public static final d LOWER_HYPHEN = new a("LOWER_HYPHEN", 0, new c1.e.m('-'), "-");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ d[] f1136a = a();

    public final enum a extends d {
        public a(String $enum$name, int $enum$ordinal, c1.e wordBoundary, String wordSeparator) {
            super($enum$name, $enum$ordinal, wordBoundary, wordSeparator, null);
        }

        @Override // c1.d
        public String convert(d format, String s10) {
            if (format == d.LOWER_UNDERSCORE) {
                return s10.replace('-', '_');
            }
            return format == d.UPPER_UNDERSCORE ? c1.c.j(s10.replace('-', '_')) : super.convert(format, s10);
        }

        @Override // c1.d
        public String normalizeWord(String word) {
            return c1.c.g(word);
        }
    }

    public static final class f extends i<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final d sourceFormat;
        private final d targetFormat;

        public f(d sourceFormat, d targetFormat) {
            sourceFormat.getClass();
            this.sourceFormat = sourceFormat;
            targetFormat.getClass();
            this.targetFormat = targetFormat;
        }

        @Override // c1.i, c1.t
        public boolean equals(@gm.a Object object) {
            if (!(object instanceof f)) {
                return false;
            }
            f fVar = (f) object;
            return this.sourceFormat.equals(fVar.sourceFormat) && this.targetFormat.equals(fVar.targetFormat);
        }

        public int hashCode() {
            return this.targetFormat.hashCode() ^ this.sourceFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }

        @Override // c1.i
        public String doBackward(String s10) {
            return this.targetFormat.to(this.sourceFormat, s10);
        }

        @Override // c1.i
        public String doForward(String s10) {
            return this.sourceFormat.to(this.targetFormat, s10);
        }
    }

    static {
        String str = "_";
        LOWER_UNDERSCORE = new d("LOWER_UNDERSCORE", 1, new c1.e.m('_'), str) { // from class: c1.d.b
            {
                a aVar = null;
            }

            @Override // c1.d
            public String convert(d format, String s10) {
                if (format == d.LOWER_HYPHEN) {
                    return s10.replace('_', '-');
                }
                return format == d.UPPER_UNDERSCORE ? c1.c.j(s10) : super.convert(format, s10);
            }

            @Override // c1.d
            public String normalizeWord(String word) {
                return c1.c.g(word);
            }
        };
        String str2 = "";
        LOWER_CAMEL = new d("LOWER_CAMEL", 2, new c1.e.k(y5.a.G, y5.a.O), str2) { // from class: c1.d.c
            {
                a aVar = null;
            }

            @Override // c1.d
            public String normalizeFirstWord(String word) {
                return c1.c.g(word);
            }

            @Override // c1.d
            public String normalizeWord(String word) {
                return d.b(word);
            }
        };
        UPPER_CAMEL = new d("UPPER_CAMEL", 3, new c1.e.k(y5.a.G, y5.a.O), str2) { // from class: c1.d.d
            {
                a aVar = null;
            }

            @Override // c1.d
            public String normalizeWord(String word) {
                return d.b(word);
            }
        };
        UPPER_UNDERSCORE = new d("UPPER_UNDERSCORE", 4, new c1.e.m('_'), str) { // from class: c1.d.e
            {
                a aVar = null;
            }

            @Override // c1.d
            public String convert(d format, String s10) {
                if (format == d.LOWER_HYPHEN) {
                    return c1.c.g(s10.replace('_', '-'));
                }
                return format == d.LOWER_UNDERSCORE ? c1.c.g(s10) : super.convert(format, s10);
            }

            @Override // c1.d
            public String normalizeWord(String word) {
                return c1.c.j(word);
            }
        };
    }

    public /* synthetic */ d(String str, int i10, c1.e eVar, String str2, a aVar) {
        this(str, i10, eVar, str2);
    }

    public static /* synthetic */ d[] a() {
        return new d[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};
    }

    public static String b(String word) {
        if (word.isEmpty()) {
            return word;
        }
        return c1.c.h(word.charAt(0)) + c1.c.g(word.substring(1));
    }

    public static d valueOf(String name) {
        return (d) Enum.valueOf(d.class, name);
    }

    public static d[] values() {
        return (d[]) f1136a.clone();
    }

    public String convert(d format, String s10) {
        StringBuilder sb2 = null;
        int length = 0;
        int iO = -1;
        while (true) {
            iO = this.wordBoundary.o(s10, iO + 1);
            if (iO == -1) {
                break;
            }
            if (length == 0) {
                sb2 = new StringBuilder((format.wordSeparator.length() * 4) + s10.length());
                sb2.append(format.normalizeFirstWord(s10.substring(length, iO)));
            } else {
                Objects.requireNonNull(sb2);
                sb2.append(format.normalizeWord(s10.substring(length, iO)));
            }
            sb2.append(format.wordSeparator);
            length = this.wordSeparator.length() + iO;
        }
        if (length == 0) {
            return format.normalizeFirstWord(s10);
        }
        Objects.requireNonNull(sb2);
        sb2.append(format.normalizeWord(s10.substring(length)));
        return sb2.toString();
    }

    public i<String, String> converterTo(d targetFormat) {
        return new f(this, targetFormat);
    }

    public String normalizeFirstWord(String word) {
        return normalizeWord(word);
    }

    public abstract String normalizeWord(String word);

    public final String to(d format, String str) {
        format.getClass();
        str.getClass();
        return format == this ? str : convert(format, str);
    }

    public d(String $enum$name, int $enum$ordinal, c1.e wordBoundary, String wordSeparator) {
        super($enum$name, $enum$ordinal);
        this.wordBoundary = wordBoundary;
        this.wordSeparator = wordSeparator;
    }
}
