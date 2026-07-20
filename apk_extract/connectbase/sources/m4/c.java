package m4;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    int A(int i10);

    void B(String str, KeyEvent keyEvent);

    void C(InputEvent inputEvent);

    l4.a a();

    void b(WindowManager.LayoutParams layoutParams);

    boolean c(InputEvent inputEvent, int i10);

    boolean d();

    void e();

    void f(int i10);

    void g(boolean z10);

    void h(boolean z10, int i10);

    AudioRecord i();

    void j(List<Integer> list, int i10);

    void k(int i10, int i11, boolean z10);

    boolean l();

    void m();

    int n();

    KeyEvent o(long j10, long j11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, String str);

    void p(String str, String str2);

    int q();

    void r(Context context, int i10, AudioFormat audioFormat);

    MotionEvent s(long j10, long j11, int i10, int i11, MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr, int i12, int i13, float f10, float f11, int i14, int i15, int i16, int i17, int i18);

    String t(String str, String str2);

    void u(int i10, boolean z10, d dVar);

    void v(List<String> list);

    String w(String str, String str2);

    int x();

    void y();

    String z(String str);
}
