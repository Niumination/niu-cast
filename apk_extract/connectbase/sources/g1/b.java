package g1;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[][] f6351b = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[][] f6352a;

    public b(char[][] replacementArray) {
        this.f6352a = replacementArray;
    }

    public static b a(Map<Character, String> replacements) {
        return new b(b(replacements));
    }

    @b1.e
    public static char[][] b(Map<Character, String> map) {
        map.getClass();
        if (map.isEmpty()) {
            return f6351b;
        }
        char[][] cArr = new char[((Character) Collections.max(map.keySet())).charValue() + 1][];
        for (Character ch2 : map.keySet()) {
            cArr[ch2.charValue()] = map.get(ch2).toCharArray();
        }
        return cArr;
    }

    public char[][] c() {
        return this.f6352a;
    }
}
