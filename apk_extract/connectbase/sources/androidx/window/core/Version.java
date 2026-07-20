package androidx.window.core;

import c.a;
import in.n;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jq.e0;
import kn.l0;
import kn.w;
import lm.d0;
import lm.f0;
import n1.e;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class Version implements Comparable<Version> {

    @l
    private static final Version CURRENT;

    @l
    public static final Companion Companion = new Companion(null);

    @l
    private static final Version UNKNOWN = new Version(0, 0, 0, "");

    @l
    private static final Version VERSION_0_1 = new Version(0, 1, 0, "");

    @l
    private static final Version VERSION_1_0;

    @l
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";

    @l
    private final d0 bigInteger$delegate;

    @l
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        @l
        public final Version getCURRENT() {
            return Version.CURRENT;
        }

        @l
        public final Version getUNKNOWN() {
            return Version.UNKNOWN;
        }

        @l
        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        @l
        public final Version getVERSION_1_0() {
            return Version.VERSION_1_0;
        }

        @m
        @n
        public final Version parse(@m String str) {
            String strGroup;
            if (str == null || e0.S1(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile(Version.VERSION_PATTERN_STRING).matcher(str);
            if (!matcher.matches() || (strGroup = matcher.group(1)) == null) {
                return null;
            }
            int i10 = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            if (strGroup2 == null) {
                return null;
            }
            int i11 = Integer.parseInt(strGroup2);
            String strGroup3 = matcher.group(3);
            if (strGroup3 == null) {
                return null;
            }
            int i12 = Integer.parseInt(strGroup3);
            String strGroup4 = matcher.group(4) != null ? matcher.group(4) : "";
            l0.o(strGroup4, "description");
            return new Version(i10, i11, i12, strGroup4, null);
        }

        private Companion() {
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        VERSION_1_0 = version;
        CURRENT = version;
    }

    public /* synthetic */ Version(int i10, int i11, int i12, String str, w wVar) {
        this(i10, i11, i12, str);
    }

    private final BigInteger getBigInteger() {
        Object value = this.bigInteger$delegate.getValue();
        l0.o(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    @m
    @n
    public static final Version parse(@m String str) {
        return Companion.parse(str);
    }

    public boolean equals(@m Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
    }

    @l
    public final String getDescription() {
        return this.description;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return ((((527 + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    @l
    public String toString() {
        String str;
        if (e0.S1(this.description)) {
            str = "";
        } else {
            str = "-" + this.description;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.major);
        sb2.append(e.f11183c);
        sb2.append(this.minor);
        sb2.append(e.f11183c);
        return a.a(sb2, this.patch, str);
    }

    private Version(int i10, int i11, int i12, String str) {
        this.major = i10;
        this.minor = i11;
        this.patch = i12;
        this.description = str;
        this.bigInteger$delegate = f0.b(new Version$bigInteger$2(this));
    }

    @Override // java.lang.Comparable
    public int compareTo(@l Version version) {
        l0.p(version, "other");
        return getBigInteger().compareTo(version.getBigInteger());
    }
}
