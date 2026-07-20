package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kn.l0;
import nm.r;
import nm.x;
import nm.y;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SavedStateViewModelFactoryKt {

    @l
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = y.O(Application.class, SavedStateHandle.class);

    @l
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = x.k(SavedStateHandle.class);

    @m
    public static final <T> Constructor<T> findMatchingConstructor(@l Class<T> cls, @l List<? extends Class<?>> list) {
        l0.p(cls, "modelClass");
        l0.p(list, "signature");
        Object[] constructors = cls.getConstructors();
        l0.o(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            l0.o(parameterTypes, "constructor.parameterTypes");
            List listKy = r.Ky(parameterTypes);
            if (l0.g(list, listKy)) {
                l0.n(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (list.size() == listKy.size() && listKy.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(@l Class<T> cls, @l Constructor<T> constructor, @l Object... objArr) {
        l0.p(cls, "modelClass");
        l0.p(constructor, "constructor");
        l0.p(objArr, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
        }
    }
}
