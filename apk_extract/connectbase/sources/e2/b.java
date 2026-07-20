package e2;

import io.netty.util.internal.StringUtil;
import n1.e;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@b1.a
public enum b {
    PRIVATE(e.f11184d, StringUtil.COMMA),
    REGISTRY('!', '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    b(char innerNodeCode, char leafNodeCode) {
        this.innerNodeCode = innerNodeCode;
        this.leafNodeCode = leafNodeCode;
    }

    public static b fromCode(char code) {
        for (b bVar : values()) {
            if (bVar.getInnerNodeCode() == code || bVar.getLeafNodeCode() == code) {
                return bVar;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + code);
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
