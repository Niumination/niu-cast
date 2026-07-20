package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i8, int i9) {
        StringBuilder sb2 = new StringBuilder();
        String json = toJSON();
        if (i9 > 0 || json.length() + i8 >= CLElement.MAX_LINE) {
            sb2.append("[\n");
            boolean z2 = true;
            for (CLElement cLElement : this.mElements) {
                if (z2) {
                    z2 = false;
                } else {
                    sb2.append(",\n");
                }
                addIndent(sb2, CLElement.BASE_INDENT + i8);
                sb2.append(cLElement.toFormattedJSON(CLElement.BASE_INDENT + i8, i9 - 1));
            }
            sb2.append("\n");
            addIndent(sb2, i8);
            sb2.append("]");
        } else {
            sb2.append(json);
        }
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb2 = new StringBuilder(getDebugName() + "[");
        boolean z2 = true;
        for (int i8 = 0; i8 < this.mElements.size(); i8++) {
            if (z2) {
                z2 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(this.mElements.get(i8).toJSON());
        }
        return ((Object) sb2) + "]";
    }
}
