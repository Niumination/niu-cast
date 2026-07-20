package e5;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends n {
    public n build() {
        return this;
    }

    public m mergeFrom(n nVar) {
        if (nVar.hasNationalNumberPattern()) {
            setNationalNumberPattern(nVar.getNationalNumberPattern());
        }
        for (int i8 = 0; i8 < nVar.getPossibleLengthCount(); i8++) {
            addPossibleLength(nVar.getPossibleLength(i8));
        }
        for (int i9 = 0; i9 < nVar.getPossibleLengthLocalOnlyCount(); i9++) {
            addPossibleLengthLocalOnly(nVar.getPossibleLengthLocalOnly(i9));
        }
        if (nVar.hasExampleNumber()) {
            setExampleNumber(nVar.getExampleNumber());
        }
        return this;
    }
}
