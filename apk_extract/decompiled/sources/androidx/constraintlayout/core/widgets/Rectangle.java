package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1085x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1086y;

    public boolean contains(int i8, int i9) {
        int i10;
        int i11 = this.f1085x;
        return i8 >= i11 && i8 < i11 + this.width && i9 >= (i10 = this.f1086y) && i9 < i10 + this.height;
    }

    public int getCenterX() {
        return (this.f1085x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f1086y + this.height) / 2;
    }

    public void grow(int i8, int i9) {
        this.f1085x -= i8;
        this.f1086y -= i9;
        this.width = (i8 * 2) + this.width;
        this.height = (i9 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i8;
        int i9;
        int i10 = this.f1085x;
        int i11 = rectangle.f1085x;
        return i10 >= i11 && i10 < i11 + rectangle.width && (i8 = this.f1086y) >= (i9 = rectangle.f1086y) && i8 < i9 + rectangle.height;
    }

    public void setBounds(int i8, int i9, int i10, int i11) {
        this.f1085x = i8;
        this.f1086y = i9;
        this.width = i10;
        this.height = i11;
    }
}
