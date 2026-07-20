package lk;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final int a(@l CharSequence charSequence, @l h hVar) {
        l0.p(charSequence, "text");
        l0.p(hVar, "range");
        int i10 = hVar.f10126a;
        int i11 = hVar.f10127b;
        if (i10 < i11 && !jq.d.r(charSequence.charAt(i10))) {
            do {
                i10++;
                if (i10 >= i11) {
                    break;
                }
            } while (!jq.d.r(charSequence.charAt(i10)));
        }
        return i10;
    }

    @l
    public static final CharSequence b(@l CharSequence charSequence, @l h hVar) {
        l0.p(charSequence, "text");
        l0.p(hVar, "range");
        int iA = a(charSequence, hVar);
        CharSequence charSequenceSubSequence = charSequence.subSequence(hVar.f10126a, iA);
        hVar.f10126a = iA;
        return charSequenceSubSequence;
    }

    public static final void c(@l CharSequence charSequence, @l h hVar) {
        l0.p(charSequence, "text");
        l0.p(hVar, "range");
        int i10 = hVar.f10126a;
        int i11 = hVar.f10127b;
        if (i10 >= i11 || !jq.d.r(charSequence.charAt(i10))) {
            return;
        }
        do {
            i10++;
            if (i10 >= i11) {
                break;
            }
        } while (jq.d.r(charSequence.charAt(i10)));
        hVar.f10126a = i10;
    }

    public static final int d(@l c cVar, int i10, int i11) {
        l0.p(cVar, "text");
        while (i10 < i11) {
            char cK = cVar.k(i10);
            if (!jq.d.r(cK) && cK != '\t') {
                break;
            }
            i10++;
        }
        return i10;
    }
}
