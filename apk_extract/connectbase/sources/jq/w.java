package jq;

import java.io.IOException;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
public class w {
    @os.l
    public static final <T extends Appendable> T a(@os.l T t10, @os.l CharSequence... charSequenceArr) throws IOException {
        kn.l0.p(t10, "<this>");
        kn.l0.p(charSequenceArr, "value");
        for (CharSequence charSequence : charSequenceArr) {
            t10.append(charSequence);
        }
        return t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void b(@os.l Appendable appendable, T t10, @os.m jn.l<? super T, ? extends CharSequence> lVar) {
        kn.l0.p(appendable, "<this>");
        if (lVar != null) {
            appendable.append(lVar.invoke(t10));
            return;
        }
        if (t10 == 0 ? true : t10 instanceof CharSequence) {
            appendable.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendable.append(((Character) t10).charValue());
        } else {
            appendable.append(String.valueOf(t10));
        }
    }

    @f1(version = "1.4")
    @an.f
    public static final Appendable c(Appendable appendable) throws IOException {
        kn.l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append('\n');
        kn.l0.o(appendableAppend, "append(...)");
        return appendableAppend;
    }

    @f1(version = "1.4")
    @an.f
    public static final Appendable d(Appendable appendable, char c10) throws IOException {
        kn.l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(c10);
        kn.l0.o(appendableAppend, "append(...)");
        Appendable appendableAppend2 = appendableAppend.append('\n');
        kn.l0.o(appendableAppend2, "append(...)");
        return appendableAppend2;
    }

    @f1(version = "1.4")
    @an.f
    public static final Appendable e(Appendable appendable, CharSequence charSequence) throws IOException {
        kn.l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(charSequence);
        kn.l0.o(appendableAppend, "append(...)");
        Appendable appendableAppend2 = appendableAppend.append('\n');
        kn.l0.o(appendableAppend2, "append(...)");
        return appendableAppend2;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <T extends Appendable> T f(@os.l T t10, @os.l CharSequence charSequence, int i10, int i11) {
        kn.l0.p(t10, "<this>");
        kn.l0.p(charSequence, "value");
        T t11 = (T) t10.append(charSequence, i10, i11);
        kn.l0.n(t11, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t11;
    }
}
