package e5;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends h {
    public h build() {
        return this;
    }

    public g mergeFrom(h hVar) {
        if (hVar.hasPattern()) {
            setPattern(hVar.getPattern());
        }
        if (hVar.hasFormat()) {
            setFormat(hVar.getFormat());
        }
        for (int i8 = 0; i8 < hVar.leadingDigitsPatternSize(); i8++) {
            addLeadingDigitsPattern(hVar.getLeadingDigitsPattern(i8));
        }
        if (hVar.hasNationalPrefixFormattingRule()) {
            setNationalPrefixFormattingRule(hVar.getNationalPrefixFormattingRule());
        }
        if (hVar.hasDomesticCarrierCodeFormattingRule()) {
            setDomesticCarrierCodeFormattingRule(hVar.getDomesticCarrierCodeFormattingRule());
        }
        if (hVar.hasNationalPrefixOptionalWhenFormatting()) {
            setNationalPrefixOptionalWhenFormatting(hVar.getNationalPrefixOptionalWhenFormatting());
        }
        return this;
    }
}
