package q1;

import com.google.j2objc.annotations.Weak;
import f1.k6;
import f1.p4;
import f1.r4;
import f1.s4;
import f1.t3;
import f1.t4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public class m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, h>> f13619b = new r4().j(s4.q.WEAK).i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f13620c = Logger.getLogger(m0.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<h>> f13621d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f13622a;

    public class a extends ThreadLocal<ArrayList<h>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<h> initialValue() {
            return p4.u(3);
        }
    }

    public interface b {
        h getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    public final class c extends ReentrantLock implements b {
        private final h lockGraphNode;

        public /* synthetic */ c(m0 m0Var, h hVar, boolean z10, a aVar) {
            this(hVar, z10);
        }

        @Override // q1.m0.b
        public h getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // q1.m0.b
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            m0.this.a(this);
            try {
                super.lock();
            } finally {
                m0.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            m0.this.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                m0.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            m0.this.a(this);
            try {
                return super.tryLock();
            } finally {
                m0.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                m0.h(this);
            }
        }

        public c(h lockGraphNode, boolean fair) {
            super(fair);
            lockGraphNode.getClass();
            this.lockGraphNode = lockGraphNode;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            m0.this.a(this);
            try {
                return super.tryLock(timeout, unit);
            } finally {
                m0.h(this);
            }
        }
    }

    public final class e extends ReentrantReadWriteLock implements b {
        private final h lockGraphNode;
        private final d readLock;
        private final f writeLock;

        public /* synthetic */ e(m0 m0Var, h hVar, boolean z10, a aVar) {
            this(m0Var, hVar, z10);
        }

        @Override // q1.m0.b
        public h getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // q1.m0.b
        public boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        public e(final m0 this$0, h lockGraphNode, boolean fair) {
            super(fair);
            this.readLock = this$0.new d(this);
            this.writeLock = this$0.new f(this);
            lockGraphNode.getClass();
            this.lockGraphNode = lockGraphNode;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    public static class g extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final t3<String> EXCLUDED_CLASS_NAMES = t3.of(m0.class.getName(), g.class.getName(), h.class.getName());

        public g(h node1, h node2) {
            super(node1.d() + " -> " + node2.d());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (l.class.getName().equals(stackTrace[i10].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else {
                    if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i10].getClassName())) {
                        setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10, length));
                        return;
                    }
                }
            }
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<h, g> f13623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<h, k> f13624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f13625c;

        public h(String lockName) {
            r4 r4Var = new r4();
            s4.q qVar = s4.q.WEAK;
            this.f13623a = r4Var.j(qVar).i();
            this.f13624b = new r4().j(qVar).i();
            lockName.getClass();
            this.f13625c = lockName;
        }

        public void a(j policy, h acquiredLock) {
            c1.h0.x0(this != acquiredLock, "Attempted to acquire multiple locks with the same rank %s", acquiredLock.d());
            if (this.f13623a.containsKey(acquiredLock)) {
                return;
            }
            k kVar = this.f13624b.get(acquiredLock);
            a aVar = null;
            if (kVar != null) {
                policy.handlePotentialDeadlock(new k(acquiredLock, this, kVar.getConflictingStackTrace(), aVar));
                return;
            }
            g gVarC = acquiredLock.c(this, k6.z());
            if (gVarC == null) {
                this.f13623a.put(acquiredLock, new g(acquiredLock, this));
                return;
            }
            k kVar2 = new k(acquiredLock, this, gVarC, aVar);
            this.f13624b.put(acquiredLock, kVar2);
            policy.handlePotentialDeadlock(kVar2);
        }

        public void b(j policy, List<h> acquiredLocks) {
            Iterator<h> it = acquiredLocks.iterator();
            while (it.hasNext()) {
                a(policy, it.next());
            }
        }

        @gm.a
        public final g c(h node, Set<h> seen) {
            if (!seen.add(this)) {
                return null;
            }
            g gVar = this.f13623a.get(node);
            if (gVar != null) {
                return gVar;
            }
            for (Map.Entry<h, g> entry : this.f13623a.entrySet()) {
                h key = entry.getKey();
                g gVarC = key.c(node, seen);
                if (gVarC != null) {
                    g gVar2 = new g(key, this);
                    gVar2.setStackTrace(entry.getValue().getStackTrace());
                    gVar2.initCause(gVarC);
                    return gVar2;
                }
            }
            return null;
        }

        public String d() {
            return this.f13625c;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class i implements j {
        public static final i THROW = new a("THROW", 0);
        public static final i WARN = new b("WARN", 1);
        public static final i DISABLED = new c("DISABLED", 2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ i[] f13626a = a();

        public final enum a extends i {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // q1.m0.j
            public void handlePotentialDeadlock(k e10) {
                throw e10;
            }
        }

        public final enum b extends i {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // q1.m0.j
            public void handlePotentialDeadlock(k e10) {
                m0.f13620c.log(Level.SEVERE, "Detected potential deadlock", (Throwable) e10);
            }
        }

        public final enum c extends i {
            public c(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // q1.m0.j
            public void handlePotentialDeadlock(k e10) {
            }
        }

        public i(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ i[] a() {
            return new i[]{THROW, WARN, DISABLED};
        }

        public static i valueOf(String name) {
            return (i) Enum.valueOf(i.class, name);
        }

        public static i[] values() {
            return (i[]) f13626a.clone();
        }

        public i(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public interface j {
        void handlePotentialDeadlock(k exception);
    }

    public static final class k extends g {
        private final g conflictingStackTrace;

        public /* synthetic */ k(h hVar, h hVar2, g gVar, a aVar) {
            this(hVar, hVar2, gVar);
        }

        public g getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb2 = new StringBuilder(message);
            for (Throwable cause = this.conflictingStackTrace; cause != null; cause = cause.getCause()) {
                sb2.append(", ");
                sb2.append(cause.getMessage());
            }
            return sb2.toString();
        }

        public k(h node1, h node2, g conflictingStackTrace) {
            super(node1, node2);
            this.conflictingStackTrace = conflictingStackTrace;
            initCause(conflictingStackTrace);
        }
    }

    public static final class l<E extends Enum<E>> extends m0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<E, h> f13627e;

        @b1.e
        public l(j policy, Map<E, h> lockGraphNodes) {
            super(policy);
            this.f13627e = lockGraphNodes;
        }

        public ReentrantLock o(E rank) {
            return p(rank, false);
        }

        public ReentrantLock p(E rank, boolean fair) {
            if (this.f13622a == i.DISABLED) {
                return new ReentrantLock(fair);
            }
            h hVar = this.f13627e.get(rank);
            Objects.requireNonNull(hVar);
            return new c(this, hVar, fair, null);
        }

        public ReentrantReadWriteLock q(E rank) {
            return r(rank, false);
        }

        public ReentrantReadWriteLock r(E rank, boolean fair) {
            if (this.f13622a == i.DISABLED) {
                return new ReentrantReadWriteLock(fair);
            }
            h hVar = this.f13627e.get(rank);
            Objects.requireNonNull(hVar);
            return new e(this, hVar, fair, null);
        }
    }

    public /* synthetic */ m0(j jVar, a aVar) {
        this(jVar);
    }

    @b1.e
    public static <E extends Enum<E>> Map<E, h> e(Class<E> clazz) {
        EnumMap enumMapW = t4.W(clazz);
        E[] enumConstants = clazz.getEnumConstants();
        int length = enumConstants.length;
        ArrayList arrayListU = p4.u(length);
        int i10 = 0;
        for (E e10 : enumConstants) {
            h hVar = new h(f(e10));
            arrayListU.add(hVar);
            enumMapW.put(e10, hVar);
        }
        for (int i11 = 1; i11 < length; i11++) {
            ((h) arrayListU.get(i11)).b(i.THROW, arrayListU.subList(0, i11));
        }
        while (i10 < length - 1) {
            i10++;
            ((h) arrayListU.get(i10)).b(i.DISABLED, arrayListU.subList(i10, length));
        }
        return Collections.unmodifiableMap(enumMapW);
    }

    public static String f(Enum<?> rank) {
        return rank.getDeclaringClass().getSimpleName() + "." + rank.name();
    }

    public static <E extends Enum<E>> Map<? extends E, h> g(Class<E> clazz) {
        ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, h>> concurrentMap = f13619b;
        Map<? extends E, h> map = (Map) concurrentMap.get(clazz);
        if (map != null) {
            return map;
        }
        Map<? extends Enum<?>, h> mapE = e(clazz);
        return (Map) c1.z.a(concurrentMap.putIfAbsent(clazz, mapE), mapE);
    }

    public static void h(b lock) {
        if (lock.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<h> arrayList = f13621d.get();
        h lockGraphNode = lock.getLockGraphNode();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == lockGraphNode) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public static m0 i(j policy) {
        return new m0(policy);
    }

    public static <E extends Enum<E>> l<E> j(Class<E> enumClass, j policy) {
        enumClass.getClass();
        policy.getClass();
        return new l<>(policy, g(enumClass));
    }

    public final void a(b lock) {
        if (lock.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<h> arrayList = f13621d.get();
        h lockGraphNode = lock.getLockGraphNode();
        lockGraphNode.b(this.f13622a, arrayList);
        arrayList.add(lockGraphNode);
    }

    public ReentrantLock k(String lockName) {
        return l(lockName, false);
    }

    public ReentrantLock l(String lockName, boolean fair) {
        return this.f13622a == i.DISABLED ? new ReentrantLock(fair) : new c(this, new h(lockName), fair, null);
    }

    public ReentrantReadWriteLock m(String lockName) {
        return n(lockName, false);
    }

    public ReentrantReadWriteLock n(String lockName, boolean fair) {
        return this.f13622a == i.DISABLED ? new ReentrantReadWriteLock(fair) : new e(this, new h(lockName), fair, null);
    }

    public m0(j policy) {
        policy.getClass();
        this.f13622a = policy;
    }

    public class d extends ReentrantReadWriteLock.ReadLock {

        @Weak
        final e readWriteLock;

        public d(e readWriteLock) {
            super(readWriteLock);
            this.readWriteLock = readWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            m0.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                m0.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            m0.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                m0.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            m0.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                m0.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                m0.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            m0.this.a(this.readWriteLock);
            try {
                return super.tryLock(timeout, unit);
            } finally {
                m0.h(this.readWriteLock);
            }
        }
    }

    public class f extends ReentrantReadWriteLock.WriteLock {

        @Weak
        final e readWriteLock;

        public f(e readWriteLock) {
            super(readWriteLock);
            this.readWriteLock = readWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            m0.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                m0.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            m0.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                m0.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            m0.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                m0.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                m0.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            m0.this.a(this.readWriteLock);
            try {
                return super.tryLock(timeout, unit);
            } finally {
                m0.h(this.readWriteLock);
            }
        }
    }
}
