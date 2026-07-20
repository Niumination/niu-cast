package w2;

import java.lang.reflect.Type;
import lm.l2;
import os.l;
import os.m;
import um.d;

/* JADX INFO: loaded from: classes2.dex */
public interface a<T> {

    /* JADX INFO: renamed from: w2.a$a, reason: collision with other inner class name */
    public static final class C0465a {
        public static /* synthetic */ Object a(a aVar, Integer num, d dVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveData");
            }
            if ((i10 & 1) != 0) {
                num = null;
            }
            return aVar.b(num, dVar);
        }

        public static /* synthetic */ Object b(a aVar, Object obj, Integer num, d dVar, int i10, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendData");
            }
            if ((i10 & 2) != 0) {
                num = null;
            }
            return aVar.a(obj, num, dVar);
        }
    }

    @m
    Object a(T t10, @m Integer num, @l d<? super l2> dVar);

    @m
    Object b(@m Integer num, @l d<? super T> dVar);

    void clear();

    @l
    Type getType();
}
