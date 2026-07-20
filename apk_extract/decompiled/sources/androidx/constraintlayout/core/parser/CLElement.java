package androidx.constraintlayout.core.parser;

import o.d;

/* JADX INFO: loaded from: classes.dex */
public class CLElement {
    protected static int BASE_INDENT = 2;
    protected static int MAX_LINE = 80;
    private int line;
    protected CLContainer mContainer;
    private final char[] mContent;
    protected long start = -1;
    protected long end = Long.MAX_VALUE;

    public CLElement(char[] cArr) {
        this.mContent = cArr;
    }

    public void addIndent(StringBuilder sb2, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            sb2.append(' ');
        }
    }

    public String content() {
        String str = new String(this.mContent);
        long j8 = this.end;
        if (j8 != Long.MAX_VALUE) {
            long j10 = this.start;
            if (j8 >= j10) {
                return str.substring((int) j10, ((int) j8) + 1);
            }
        }
        long j11 = this.start;
        return str.substring((int) j11, ((int) j11) + 1);
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    public String getDebugName() {
        if (!CLParser.DEBUG) {
            return "";
        }
        return getStrClass() + " -> ";
    }

    public long getEnd() {
        return this.end;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public int getLine() {
        return this.line;
    }

    public long getStart() {
        return this.start;
    }

    public String getStrClass() {
        String string = getClass().toString();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    public boolean isDone() {
        return this.end != Long.MAX_VALUE;
    }

    public boolean isStarted() {
        return this.start > -1;
    }

    public boolean notStarted() {
        return this.start == -1;
    }

    public void setContainer(CLContainer cLContainer) {
        this.mContainer = cLContainer;
    }

    public void setEnd(long j8) {
        if (this.end != Long.MAX_VALUE) {
            return;
        }
        this.end = j8;
        if (CLParser.DEBUG) {
            System.out.println("closing " + hashCode() + " -> " + this);
        }
        CLContainer cLContainer = this.mContainer;
        if (cLContainer != null) {
            cLContainer.add(this);
        }
    }

    public void setLine(int i8) {
        this.line = i8;
    }

    public void setStart(long j8) {
        this.start = j8;
    }

    public String toFormattedJSON(int i8, int i9) {
        return "";
    }

    public String toJSON() {
        return "";
    }

    public String toString() {
        long j8 = this.start;
        long j10 = this.end;
        if (j8 > j10 || j10 == Long.MAX_VALUE) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getClass());
            sb2.append(" (INVALID, ");
            sb2.append(this.start);
            sb2.append("-");
            return d.p(sb2, this.end, ")");
        }
        return getStrClass() + " (" + this.start + " : " + this.end + ") <<" + new String(this.mContent).substring((int) this.start, ((int) this.end) + 1) + ">>";
    }
}
