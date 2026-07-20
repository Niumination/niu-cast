package k3;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class v1 {
    public static void a(String str) {
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if ('!' > cCharAt || '~' < cCharAt) {
                throw new IllegalArgumentException(ej.b.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i8), str).toString());
            }
        }
    }

    public static void b(String str, String str2) {
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt != '\t' && (' ' > cCharAt || '~' < cCharAt)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ej.b.i("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i8), str2));
                sb2.append(ej.b.q(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb2.toString().toString());
            }
        }
    }

    public static dj.s c(String... namesAndValues) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
        if (namesAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        Object objClone = namesAndValues.clone();
        if (objClone == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        String[] strArr = (String[]) objClone;
        int length = strArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            String str = strArr[i8];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            strArr[i8] = StringsKt__StringsKt.trim((CharSequence) str).toString();
        }
        IntProgression intProgressionStep = RangesKt.step(ArraysKt.getIndices(strArr), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (true) {
                String str2 = strArr[first];
                String str3 = strArr[first + 1];
                a(str2);
                b(str3, str2);
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        return new dj.s(strArr);
    }
}
