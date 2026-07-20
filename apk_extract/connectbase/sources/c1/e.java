package c1;

import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@c1.k
public abstract class e implements i0<Character> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1137a = 65536;

    public class a extends x {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f1138c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(final e this$0, e original, final String val$description) {
            super(original);
            this.f1138c = val$description;
        }

        @Override // c1.e.w, c1.e
        public String toString() {
            return this.f1138c;
        }
    }

    public static class a0 extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final char[] f1140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final char[] f1141d;

        public a0(String description, char[] rangeStarts, char[] rangeEnds) {
            this.f1139b = description;
            this.f1140c = rangeStarts;
            this.f1141d = rangeEnds;
            h0.d(rangeStarts.length == rangeEnds.length);
            int i10 = 0;
            while (i10 < rangeStarts.length) {
                h0.d(rangeStarts[i10] <= rangeEnds[i10]);
                int i11 = i10 + 1;
                if (i11 < rangeStarts.length) {
                    h0.d(rangeEnds[i10] < rangeStarts[i11]);
                }
                i10 = i11;
            }
        }

        @Override // c1.e
        public boolean B(char c10) {
            int iBinarySearch = Arrays.binarySearch(this.f1140c, c10);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i10 = (~iBinarySearch) - 1;
            return i10 >= 0 && c10 <= this.f1141d[i10];
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return super.apply(character);
        }

        @Override // c1.e
        public String toString() {
            return this.f1139b;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f1142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f1143c;

        public b(e a10, e b10) {
            a10.getClass();
            this.f1142b = a10;
            b10.getClass();
            this.f1143c = b10;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return this.f1142b.B(c10) && this.f1143c.B(c10);
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            BitSet bitSet = new BitSet();
            this.f1142b.Q(bitSet);
            BitSet bitSet2 = new BitSet();
            this.f1143c.Q(bitSet2);
            bitSet.and(bitSet2);
            table.or(bitSet);
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.and(" + this.f1142b + ", " + this.f1143c + ")";
        }
    }

    public static final class b0 extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b0 f1144e = new b0();

        public b0() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    public static final class c extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f1145c = new c();

        public c() {
            super("CharMatcher.any()");
        }

        @Override // c1.e
        public int A(CharSequence sequence) {
            return sequence.length() - 1;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return true;
        }

        @Override // c1.e
        public boolean C(CharSequence sequence) {
            sequence.getClass();
            return true;
        }

        @Override // c1.e
        public boolean E(CharSequence sequence) {
            return sequence.length() == 0;
        }

        @Override // c1.e.i, c1.e
        public e F() {
            return y.f1174c;
        }

        @Override // c1.e
        public e I(e other) {
            other.getClass();
            return this;
        }

        @Override // c1.e
        public String M(CharSequence sequence) {
            sequence.getClass();
            return "";
        }

        @Override // c1.e
        public String N(CharSequence sequence, char replacement) {
            char[] cArr = new char[sequence.length()];
            Arrays.fill(cArr, replacement);
            return new String(cArr);
        }

        @Override // c1.e
        public String O(CharSequence sequence, CharSequence replacement) {
            StringBuilder sb2 = new StringBuilder(replacement.length() * sequence.length());
            for (int i10 = 0; i10 < sequence.length(); i10++) {
                sb2.append(replacement);
            }
            return sb2.toString();
        }

        @Override // c1.e
        public String U(CharSequence sequence) {
            sequence.getClass();
            return "";
        }

        @Override // c1.e
        public e b(e other) {
            other.getClass();
            return other;
        }

        @Override // c1.e
        public String h(CharSequence sequence, char replacement) {
            return sequence.length() == 0 ? "" : String.valueOf(replacement);
        }

        @Override // c1.e
        public int i(CharSequence sequence) {
            return sequence.length();
        }

        @Override // c1.e
        public int n(CharSequence sequence) {
            return sequence.length() == 0 ? -1 : 0;
        }

        @Override // c1.e
        public int o(CharSequence sequence, int start) {
            int length = sequence.length();
            h0.d0(start, length);
            if (start == length) {
                return -1;
            }
            return start;
        }
    }

    @b1.e
    public static final class c0 extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f1146c = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f1147d = 1682554634;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f1148e = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c0 f1149f = new c0();

        public c0() {
            super("CharMatcher.whitespace()");
        }

        @Override // c1.e
        public boolean B(char c10) {
            return f1146c.charAt((f1147d * c10) >>> f1148e) == c10;
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            for (int i10 = 0; i10 < 32; i10++) {
                table.set(f1146c.charAt(i10));
            }
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f1150b;

        public d(CharSequence chars) {
            char[] charArray = chars.toString().toCharArray();
            this.f1150b = charArray;
            Arrays.sort(charArray);
        }

        @Override // c1.e
        public boolean B(char c10) {
            return Arrays.binarySearch(this.f1150b, c10) >= 0;
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            for (char c10 : this.f1150b) {
                table.set(c10);
            }
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            StringBuilder sb2 = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c10 : this.f1150b) {
                sb2.append(e.R(c10));
            }
            sb2.append("\")");
            return sb2.toString();
        }
    }

    /* JADX INFO: renamed from: c1.e$e, reason: collision with other inner class name */
    public static final class C0050e extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0050e f1151c = new C0050e();

        public C0050e() {
            super("CharMatcher.ascii()");
        }

        @Override // c1.e
        public boolean B(char c10) {
            return c10 <= 127;
        }
    }

    @b1.c
    @b1.d
    public static final class f extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BitSet f1152c;

        public /* synthetic */ f(BitSet bitSet, String str, a aVar) {
            this(bitSet, str);
        }

        @Override // c1.e
        public boolean B(char c10) {
            return this.f1152c.get(c10);
        }

        @Override // c1.e
        public void Q(BitSet bitSet) {
            bitSet.or(this.f1152c);
        }

        public f(BitSet table, String description) {
            super(description);
            this.f1152c = table.length() + 64 < table.size() ? (BitSet) table.clone() : table;
        }
    }

    public static final class g extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f1153b = new g();

        @Override // c1.e
        public boolean B(char c10) {
            if (c10 != ' ' && c10 != 133 && c10 != 5760) {
                if (c10 == 8199) {
                    return false;
                }
                if (c10 != 8287 && c10 != 12288 && c10 != 8232 && c10 != 8233) {
                    switch (c10) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c10 >= 8192 && c10 <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    public static final class h extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f1154e = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f1155f = new h();

        public h() {
            super("CharMatcher.digit()", f1154e.toCharArray(), Y());
        }

        public static char[] Y() {
            char[] cArr = new char[37];
            for (int i10 = 0; i10 < 37; i10++) {
                cArr[i10] = (char) (f1154e.charAt(i10) + '\t');
            }
            return cArr;
        }

        public static char[] Z() {
            return f1154e.toCharArray();
        }
    }

    public static abstract class i extends e {
        @Override // c1.e
        public e F() {
            return new x(this);
        }

        @Override // c1.e
        public final e J() {
            return this;
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return super.apply(character);
        }
    }

    public static final class j extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i0<? super Character> f1156b;

        public j(i0<? super Character> predicate) {
            predicate.getClass();
            this.f1156b = predicate;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return this.f1156b.apply(Character.valueOf(c10));
        }

        @Override // c1.e, c1.i0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean apply(Character character) {
            i0<? super Character> i0Var = this.f1156b;
            character.getClass();
            return i0Var.apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.forPredicate(" + this.f1156b + ")";
        }
    }

    public static final class k extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char f1157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final char f1158c;

        public k(char startInclusive, char endInclusive) {
            h0.d(endInclusive >= startInclusive);
            this.f1157b = startInclusive;
            this.f1158c = endInclusive;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return this.f1157b <= c10 && c10 <= this.f1158c;
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            table.set(this.f1157b, this.f1158c + 1);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.inRange('" + e.R(this.f1157b) + "', '" + e.R(this.f1158c) + "')";
        }
    }

    public static final class l extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f1159e = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u0890\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f1160f = "  \u00ad\u0605\u061c\u06dd\u070f\u0891\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final l f1161g = new l();

        public l() {
            super("CharMatcher.invisible()", f1159e.toCharArray(), f1160f.toCharArray());
        }
    }

    public static final class m extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char f1162b;

        public m(char match) {
            this.f1162b = match;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return c10 == this.f1162b;
        }

        @Override // c1.e.i, c1.e
        public e F() {
            return new o(this.f1162b);
        }

        @Override // c1.e
        public e I(e other) {
            return other.B(this.f1162b) ? other : new z(this, other);
        }

        @Override // c1.e
        public String N(CharSequence sequence, char replacement) {
            return sequence.toString().replace(this.f1162b, replacement);
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            table.set(this.f1162b);
        }

        @Override // c1.e
        public e b(e other) {
            return other.B(this.f1162b) ? this : y.f1174c;
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.is('" + e.R(this.f1162b) + "')";
        }
    }

    public static final class n extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char f1163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final char f1164c;

        public n(char match1, char match2) {
            this.f1163b = match1;
            this.f1164c = match2;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return c10 == this.f1163b || c10 == this.f1164c;
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            table.set(this.f1163b);
            table.set(this.f1164c);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.anyOf(\"" + e.R(this.f1163b) + e.R(this.f1164c) + "\")";
        }
    }

    public static final class o extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char f1165b;

        public o(char match) {
            this.f1165b = match;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return c10 != this.f1165b;
        }

        @Override // c1.e.i, c1.e
        public e F() {
            return new m(this.f1165b);
        }

        @Override // c1.e
        public e I(e other) {
            return other.B(this.f1165b) ? c.f1145c : this;
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            table.set(0, this.f1165b);
            table.set(this.f1165b + 1, 65536);
        }

        @Override // c1.e
        public e b(e other) {
            return other.B(this.f1165b) ? new b(this, other) : other;
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.isNot('" + e.R(this.f1165b) + "')";
        }
    }

    public static final class p extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final p f1166b = new p();

        @Override // c1.e
        public boolean B(char c10) {
            return Character.isDigit(c10);
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    public static final class q extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final q f1167c = new q();

        public q() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // c1.e
        public boolean B(char c10) {
            return c10 <= 31 || (c10 >= 127 && c10 <= 159);
        }
    }

    public static final class r extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r f1168b = new r();

        @Override // c1.e
        public boolean B(char c10) {
            return Character.isLetter(c10);
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    public static final class s extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final s f1169b = new s();

        @Override // c1.e
        public boolean B(char c10) {
            return Character.isLetterOrDigit(c10);
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    public static final class t extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final t f1170b = new t();

        @Override // c1.e
        public boolean B(char c10) {
            return Character.isLowerCase(c10);
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    public static final class u extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final u f1171b = new u();

        @Override // c1.e
        public boolean B(char c10) {
            return Character.isUpperCase(c10);
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    public static abstract class v extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1172b;

        public v(String description) {
            description.getClass();
            this.f1172b = description;
        }

        @Override // c1.e
        public final String toString() {
            return this.f1172b;
        }
    }

    public static class w extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f1173b;

        public w(e original) {
            original.getClass();
            this.f1173b = original;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return !this.f1173b.B(c10);
        }

        @Override // c1.e
        public boolean C(CharSequence sequence) {
            return this.f1173b.E(sequence);
        }

        @Override // c1.e
        public boolean E(CharSequence sequence) {
            return this.f1173b.C(sequence);
        }

        @Override // c1.e
        public e F() {
            return this.f1173b;
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            BitSet bitSet = new BitSet();
            this.f1173b.Q(bitSet);
            bitSet.flip(0, 65536);
            table.or(bitSet);
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return super.apply(character);
        }

        @Override // c1.e
        public int i(CharSequence sequence) {
            return sequence.length() - this.f1173b.i(sequence);
        }

        @Override // c1.e
        public String toString() {
            return this.f1173b + ".negate()";
        }
    }

    public static class x extends w {
        public x(e original) {
            super(original);
        }

        @Override // c1.e
        public final e J() {
            return this;
        }
    }

    public static final class y extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final y f1174c = new y();

        public y() {
            super("CharMatcher.none()");
        }

        @Override // c1.e
        public int A(CharSequence sequence) {
            sequence.getClass();
            return -1;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return false;
        }

        @Override // c1.e
        public boolean C(CharSequence sequence) {
            return sequence.length() == 0;
        }

        @Override // c1.e
        public boolean E(CharSequence sequence) {
            sequence.getClass();
            return true;
        }

        @Override // c1.e.i, c1.e
        public e F() {
            return c.f1145c;
        }

        @Override // c1.e
        public e I(e other) {
            other.getClass();
            return other;
        }

        @Override // c1.e
        public String M(CharSequence sequence) {
            return sequence.toString();
        }

        @Override // c1.e
        public String N(CharSequence sequence, char replacement) {
            return sequence.toString();
        }

        @Override // c1.e
        public String O(CharSequence sequence, CharSequence replacement) {
            replacement.getClass();
            return sequence.toString();
        }

        @Override // c1.e
        public String U(CharSequence sequence) {
            return sequence.toString();
        }

        @Override // c1.e
        public String V(CharSequence sequence) {
            return sequence.toString();
        }

        @Override // c1.e
        public String W(CharSequence sequence) {
            return sequence.toString();
        }

        @Override // c1.e
        public e b(e other) {
            other.getClass();
            return this;
        }

        @Override // c1.e
        public String h(CharSequence sequence, char replacement) {
            return sequence.toString();
        }

        @Override // c1.e
        public int i(CharSequence sequence) {
            sequence.getClass();
            return 0;
        }

        @Override // c1.e
        public int n(CharSequence sequence) {
            sequence.getClass();
            return -1;
        }

        @Override // c1.e
        public int o(CharSequence sequence, int start) {
            h0.d0(start, sequence.length());
            return -1;
        }
    }

    public static final class z extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f1175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f1176c;

        public z(e a10, e b10) {
            a10.getClass();
            this.f1175b = a10;
            b10.getClass();
            this.f1176c = b10;
        }

        @Override // c1.e
        public boolean B(char c10) {
            return this.f1175b.B(c10) || this.f1176c.B(c10);
        }

        @Override // c1.e
        @b1.c
        @b1.d
        public void Q(BitSet table) {
            this.f1175b.Q(table);
            this.f1176c.Q(table);
        }

        @Override // c1.e, c1.i0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character character) {
            return apply(character);
        }

        @Override // c1.e
        public String toString() {
            return "CharMatcher.or(" + this.f1175b + ", " + this.f1176c + ")";
        }
    }

    public static e G() {
        return y.f1174c;
    }

    public static e H(CharSequence sequence) {
        return d(sequence).F();
    }

    @b1.c
    @b1.d
    public static e L(int totalCharacters, BitSet table, String description) {
        if (totalCharacters == 0) {
            return y.f1174c;
        }
        if (totalCharacters == 1) {
            return new m((char) table.nextSetBit(0));
        }
        if (totalCharacters != 2) {
            return t(totalCharacters, table.length()) ? l0.a0(table, description) : new f(table, description);
        }
        char cNextSetBit = (char) table.nextSetBit(0);
        return new n(cNextSetBit, (char) table.nextSetBit(cNextSetBit + 1));
    }

    public static String R(char c10) {
        char[] cArr = new char[6];
        cArr[0] = rs.f.f14862d;
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = jq.j.f8822b.charAt(c10 & 15);
            c10 = (char) (c10 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static e S() {
        return b0.f1144e;
    }

    public static e X() {
        return c0.f1149f;
    }

    public static e c() {
        return c.f1145c;
    }

    public static e d(final CharSequence sequence) {
        int length = sequence.length();
        if (length == 0) {
            return y.f1174c;
        }
        if (length != 1) {
            return length != 2 ? new d(sequence) : new n(sequence.charAt(0), sequence.charAt(1));
        }
        return new m(sequence.charAt(0));
    }

    public static e f() {
        return C0050e.f1151c;
    }

    public static e g() {
        return g.f1153b;
    }

    @Deprecated
    public static e j() {
        return h.f1155f;
    }

    public static e l(final i0<? super Character> predicate) {
        return predicate instanceof e ? (e) predicate : new j(predicate);
    }

    public static e m(final char startInclusive, final char endInclusive) {
        return new k(startInclusive, endInclusive);
    }

    @Deprecated
    public static e p() {
        return l.f1161g;
    }

    public static e q(final char match) {
        return new m(match);
    }

    public static n r(char c10, char c11) {
        return new n(c10, c11);
    }

    public static e s(final char match) {
        return new o(match);
    }

    @b1.c
    @b1.d
    public static boolean t(int totalCharacters, int tableLength) {
        return totalCharacters <= 1023 && tableLength > totalCharacters * 64;
    }

    @Deprecated
    public static e u() {
        return p.f1166b;
    }

    public static e v() {
        return q.f1167c;
    }

    @Deprecated
    public static e w() {
        return r.f1168b;
    }

    @Deprecated
    public static e x() {
        return s.f1169b;
    }

    @Deprecated
    public static e y() {
        return t.f1170b;
    }

    @Deprecated
    public static e z() {
        return u.f1171b;
    }

    public int A(CharSequence sequence) {
        for (int length = sequence.length() - 1; length >= 0; length--) {
            if (B(sequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean B(char c10);

    public boolean C(CharSequence sequence) {
        for (int length = sequence.length() - 1; length >= 0; length--) {
            if (!B(sequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean D(CharSequence sequence) {
        return !E(sequence);
    }

    public boolean E(CharSequence sequence) {
        return n(sequence) == -1;
    }

    public e F() {
        return new w(this);
    }

    public e I(e other) {
        return new z(this, other);
    }

    public e J() {
        return g0.i(this);
    }

    @b1.c
    @b1.d
    public e K() {
        BitSet bitSet = new BitSet();
        Q(bitSet);
        int iCardinality = bitSet.cardinality();
        if (iCardinality * 2 <= 65536) {
            return L(iCardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i10 = 65536 - iCardinality;
        String string = toString();
        return new a(this, L(i10, bitSet, string.endsWith(".negate()") ? c0.b.a(string, 9, 0) : string.concat(".negate()")), string);
    }

    public String M(CharSequence sequence) {
        String string = sequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        int i10 = 1;
        while (true) {
            iN++;
            while (iN != charArray.length) {
                if (B(charArray[iN])) {
                    i10++;
                } else {
                    charArray[iN - i10] = charArray[iN];
                    iN++;
                }
            }
            return new String(charArray, 0, iN - i10);
        }
    }

    public String N(CharSequence sequence, char replacement) {
        String string = sequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        charArray[iN] = replacement;
        while (true) {
            iN++;
            if (iN >= charArray.length) {
                return new String(charArray);
            }
            if (B(charArray[iN])) {
                charArray[iN] = replacement;
            }
        }
    }

    public String O(CharSequence sequence, CharSequence replacement) {
        int length = replacement.length();
        if (length == 0) {
            return M(sequence);
        }
        int i10 = 0;
        if (length == 1) {
            return N(sequence, replacement.charAt(0));
        }
        String string = sequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        int length2 = string.length();
        StringBuilder sb2 = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb2.append((CharSequence) string, i10, iN);
            sb2.append(replacement);
            i10 = iN + 1;
            iN = o(string, i10);
        } while (iN != -1);
        sb2.append((CharSequence) string, i10, length2);
        return sb2.toString();
    }

    public String P(CharSequence sequence) {
        return F().M(sequence);
    }

    @b1.c
    @b1.d
    public void Q(BitSet table) {
        for (int i10 = 65535; i10 >= 0; i10--) {
            if (B((char) i10)) {
                table.set(i10);
            }
        }
    }

    public String T(CharSequence sequence, char replacement) {
        int length = sequence.length();
        int i10 = length - 1;
        int i11 = 0;
        while (i11 < length && B(sequence.charAt(i11))) {
            i11++;
        }
        int i12 = i10;
        while (i12 > i11 && B(sequence.charAt(i12))) {
            i12--;
        }
        if (i11 == 0 && i12 == i10) {
            return h(sequence, replacement);
        }
        int i13 = i12 + 1;
        return k(sequence, i11, i13, replacement, new StringBuilder(i13 - i11), false);
    }

    public String U(CharSequence sequence) {
        int length = sequence.length();
        int i10 = 0;
        while (i10 < length && B(sequence.charAt(i10))) {
            i10++;
        }
        int i11 = length - 1;
        while (i11 > i10 && B(sequence.charAt(i11))) {
            i11--;
        }
        return sequence.subSequence(i10, i11 + 1).toString();
    }

    public String V(CharSequence sequence) {
        int length = sequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!B(sequence.charAt(i10))) {
                return sequence.subSequence(i10, length).toString();
            }
        }
        return "";
    }

    public String W(CharSequence sequence) {
        for (int length = sequence.length() - 1; length >= 0; length--) {
            if (!B(sequence.charAt(length))) {
                return sequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public e b(e other) {
        return new b(this, other);
    }

    @Override // c1.i0
    @Deprecated
    /* JADX INFO: renamed from: e */
    public boolean apply(Character character) {
        return B(character.charValue());
    }

    public String h(CharSequence sequence, char replacement) {
        int length = sequence.length();
        int i10 = 0;
        while (i10 < length) {
            char cCharAt = sequence.charAt(i10);
            if (B(cCharAt)) {
                if (cCharAt != replacement || (i10 != length - 1 && B(sequence.charAt(i10 + 1)))) {
                    StringBuilder sb2 = new StringBuilder(length);
                    sb2.append(sequence, 0, i10);
                    sb2.append(replacement);
                    return k(sequence, i10 + 1, length, replacement, sb2, true);
                }
                i10++;
            }
            i10++;
        }
        return sequence.toString();
    }

    public int i(CharSequence sequence) {
        int i10 = 0;
        for (int i11 = 0; i11 < sequence.length(); i11++) {
            if (B(sequence.charAt(i11))) {
                i10++;
            }
        }
        return i10;
    }

    public final String k(CharSequence sequence, int start, int end, char replacement, StringBuilder builder, boolean inMatchingGroup) {
        while (start < end) {
            char cCharAt = sequence.charAt(start);
            if (!B(cCharAt)) {
                builder.append(cCharAt);
                inMatchingGroup = false;
            } else if (!inMatchingGroup) {
                builder.append(replacement);
                inMatchingGroup = true;
            }
            start++;
        }
        return builder.toString();
    }

    public int n(CharSequence sequence) {
        return o(sequence, 0);
    }

    public int o(CharSequence sequence, int start) {
        int length = sequence.length();
        h0.d0(start, length);
        while (start < length) {
            if (B(sequence.charAt(start))) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public String toString() {
        return super.toString();
    }
}
