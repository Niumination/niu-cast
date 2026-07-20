package zj;

import com.transsion.iotservice.multiscreen.pc.http.CloudInterface;
import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f11696a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.d f11697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.u f11698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11699d;
    public final List e;
    public final Executor f;

    public q0(dj.d dVar, dj.u uVar, List list, List list2, Executor executor) {
        this.f11697b = dVar;
        this.f11698c = uVar;
        this.f11699d = list;
        this.e = list2;
        this.f = executor;
    }

    public final e a(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.e;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i8 = iIndexOf; i8 < size; i8++) {
            e eVarA = ((d) list.get(i8)).a(type, annotationArr);
            if (eVarA != null) {
                return eVarA;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append(type);
        sb2.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(((d) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public final Object b() {
        if (!CloudInterface.class.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(CloudInterface.class);
        while (!arrayDeque.isEmpty()) {
            Class cls = (Class) arrayDeque.removeFirst();
            if (cls.getTypeParameters().length != 0) {
                StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                sb2.append(cls.getName());
                if (cls != CloudInterface.class) {
                    sb2.append(" which is an interface of ");
                    sb2.append(CloudInterface.class.getName());
                }
                throw new IllegalArgumentException(sb2.toString());
            }
            Collections.addAll(arrayDeque, cls.getInterfaces());
        }
        return Proxy.newProxyInstance(CloudInterface.class.getClassLoader(), new Class[]{CloudInterface.class}, new p0(this));
    }

    public final j c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        List list = this.f11699d;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i8 = iIndexOf; i8 < size; i8++) {
            j jVarA = ((i) list.get(i8)).a(type);
            if (jVarA != null) {
                return jVarA;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append(type);
        sb2.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(((i) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public final j d(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.f11699d;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i8 = iIndexOf; i8 < size; i8++) {
            j jVarB = ((i) list.get(i8)).b(type, annotationArr, this);
            if (jVarB != null) {
                return jVarB;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        sb2.append("  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(((i) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public final void e(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        List list = this.f11699d;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((i) list.get(i8)).getClass();
        }
    }
}
