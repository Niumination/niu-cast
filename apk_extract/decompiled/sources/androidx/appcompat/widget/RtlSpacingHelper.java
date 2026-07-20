package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRtl = false;
    private boolean mIsRelative = false;

    public int getEnd() {
        return this.mIsRtl ? this.mLeft : this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mIsRtl ? this.mRight : this.mLeft;
    }

    public void setAbsolute(int i8, int i9) {
        this.mIsRelative = false;
        if (i8 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i8;
            this.mLeft = i8;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.mExplicitRight = i9;
            this.mRight = i9;
        }
    }

    public void setDirection(boolean z2) {
        if (z2 == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z2;
        if (!this.mIsRelative) {
            this.mLeft = this.mExplicitLeft;
            this.mRight = this.mExplicitRight;
            return;
        }
        if (z2) {
            int i8 = this.mEnd;
            if (i8 == Integer.MIN_VALUE) {
                i8 = this.mExplicitLeft;
            }
            this.mLeft = i8;
            int i9 = this.mStart;
            if (i9 == Integer.MIN_VALUE) {
                i9 = this.mExplicitRight;
            }
            this.mRight = i9;
            return;
        }
        int i10 = this.mStart;
        if (i10 == Integer.MIN_VALUE) {
            i10 = this.mExplicitLeft;
        }
        this.mLeft = i10;
        int i11 = this.mEnd;
        if (i11 == Integer.MIN_VALUE) {
            i11 = this.mExplicitRight;
        }
        this.mRight = i11;
    }

    public void setRelative(int i8, int i9) {
        this.mStart = i8;
        this.mEnd = i9;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i9 != Integer.MIN_VALUE) {
                this.mLeft = i9;
            }
            if (i8 != Integer.MIN_VALUE) {
                this.mRight = i8;
                return;
            }
            return;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.mLeft = i8;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.mRight = i9;
        }
    }
}
