package w5;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f18180b = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f18181a = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public x5.a f18184c;

        public a(int i10, int i11) {
            this.f18182a = i11;
            this.f18183b = i10;
        }

        public int a() {
            return this.f18183b;
        }

        public int b() {
            return this.f18182a;
        }

        public x5.a c() {
            return this.f18184c;
        }

        public void d(int i10) {
            this.f18183b = i10;
        }

        public void e(int i10) {
            this.f18182a = i10;
        }

        public void f(x5.a aVar) {
            this.f18184c = aVar;
        }
    }

    public final void a() {
        for (int size = this.f18181a.size() - 1; size >= 0; size--) {
            if (this.f18181a.get(size).c().a() == 1) {
                this.f18181a.remove(size);
            }
        }
    }

    public a b(int i10) {
        return this.f18181a.get(i10);
    }

    public int c(int i10) {
        int iF;
        int iD = d(i10);
        if (iD != -1) {
            return iD;
        }
        if (this.f18181a.size() >= 10 || (iF = f()) == -1) {
            return -1;
        }
        this.f18181a.add(new a(i10, iF));
        return this.f18181a.size() - 1;
    }

    public final int d(long j10) {
        for (int i10 = 0; i10 < this.f18181a.size(); i10++) {
            if (this.f18181a.get(i10).a() == j10) {
                return i10;
            }
        }
        return -1;
    }

    public final boolean e(int i10) {
        for (int i11 = 0; i11 < this.f18181a.size(); i11++) {
            if (this.f18181a.get(i11).b() == i10) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        for (int i10 = 0; i10 < 10; i10++) {
            if (e(i10)) {
                return i10;
            }
        }
        return -1;
    }

    public int g(MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr) {
        int size = this.f18181a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = this.f18181a.get(i10);
            pointerPropertiesArr[i10].id = aVar.b();
            x5.a aVarC = aVar.c();
            pointerCoordsArr[i10].x = aVarC.d();
            pointerCoordsArr[i10].y = aVarC.e();
        }
        a();
        return size;
    }
}
