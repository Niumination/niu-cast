package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CallbackRegistry<C, T, A> implements Cloneable {
    private static final String TAG = "CallbackRegistry";
    private List<C> mCallbacks = new ArrayList();
    private long mFirst64Removed = 0;
    private int mNotificationLevel;
    private final NotifierCallback<C, T, A> mNotifier;
    private long[] mRemainderRemoved;

    public static abstract class NotifierCallback<C, T, A> {
        public abstract void onNotifyCallback(C c9, T t3, int i8, A a6);
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifierCallback) {
        this.mNotifier = notifierCallback;
    }

    private boolean isRemoved(int i8) {
        int i9;
        if (i8 < 64) {
            return (this.mFirst64Removed & (1 << i8)) != 0;
        }
        long[] jArr = this.mRemainderRemoved;
        if (jArr != null && (i9 = (i8 / 64) - 1) < jArr.length) {
            return ((1 << (i8 % 64)) & jArr[i9]) != 0;
        }
        return false;
    }

    private void notifyFirst64(T t3, int i8, A a6) {
        notifyCallbacks(t3, i8, a6, 0, Math.min(64, this.mCallbacks.size()), this.mFirst64Removed);
    }

    private void notifyRecurse(T t3, int i8, A a6) {
        int size = this.mCallbacks.size();
        long[] jArr = this.mRemainderRemoved;
        int length = jArr == null ? -1 : jArr.length - 1;
        notifyRemainder(t3, i8, a6, length);
        notifyCallbacks(t3, i8, a6, (length + 2) * 64, size, 0L);
    }

    private void notifyRemainder(T t3, int i8, A a6, int i9) {
        if (i9 < 0) {
            notifyFirst64(t3, i8, a6);
            return;
        }
        long j8 = this.mRemainderRemoved[i9];
        int i10 = (i9 + 1) * 64;
        int iMin = Math.min(this.mCallbacks.size(), i10 + 64);
        notifyRemainder(t3, i8, a6, i9 - 1);
        notifyCallbacks(t3, i8, a6, i10, iMin, j8);
    }

    private void removeRemovedCallbacks(int i8, long j8) {
        long j10 = Long.MIN_VALUE;
        for (int i9 = i8 + 63; i9 >= i8; i9--) {
            if ((j8 & j10) != 0) {
                this.mCallbacks.remove(i9);
            }
            j10 >>>= 1;
        }
    }

    private void setRemovalBit(int i8) {
        if (i8 < 64) {
            this.mFirst64Removed = (1 << i8) | this.mFirst64Removed;
            return;
        }
        int i9 = (i8 / 64) - 1;
        long[] jArr = this.mRemainderRemoved;
        if (jArr == null) {
            this.mRemainderRemoved = new long[this.mCallbacks.size() / 64];
        } else if (jArr.length <= i9) {
            long[] jArr2 = new long[this.mCallbacks.size() / 64];
            long[] jArr3 = this.mRemainderRemoved;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.mRemainderRemoved = jArr2;
        }
        long[] jArr4 = this.mRemainderRemoved;
        jArr4[i9] = (1 << (i8 % 64)) | jArr4[i9];
    }

    public synchronized void add(C c9) {
        try {
            if (c9 == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            int iLastIndexOf = this.mCallbacks.lastIndexOf(c9);
            if (iLastIndexOf < 0 || isRemoved(iLastIndexOf)) {
                this.mCallbacks.add(c9);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void clear() {
        try {
            if (this.mNotificationLevel == 0) {
                this.mCallbacks.clear();
            } else if (!this.mCallbacks.isEmpty()) {
                for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                    setRemovalBit(size);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized ArrayList<C> copyCallbacks() {
        ArrayList<C> arrayList;
        arrayList = new ArrayList<>(this.mCallbacks.size());
        int size = this.mCallbacks.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!isRemoved(i8)) {
                arrayList.add(this.mCallbacks.get(i8));
            }
        }
        return arrayList;
    }

    public synchronized boolean isEmpty() {
        if (this.mCallbacks.isEmpty()) {
            return true;
        }
        if (this.mNotificationLevel == 0) {
            return false;
        }
        int size = this.mCallbacks.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!isRemoved(i8)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void notifyCallbacks(T t3, int i8, A a6) {
        try {
            this.mNotificationLevel++;
            notifyRecurse(t3, i8, a6);
            int i9 = this.mNotificationLevel - 1;
            this.mNotificationLevel = i9;
            if (i9 == 0) {
                long[] jArr = this.mRemainderRemoved;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j8 = this.mRemainderRemoved[length];
                        if (j8 != 0) {
                            removeRemovedCallbacks((length + 1) * 64, j8);
                            this.mRemainderRemoved[length] = 0;
                        }
                    }
                }
                long j10 = this.mFirst64Removed;
                if (j10 != 0) {
                    removeRemovedCallbacks(0, j10);
                    this.mFirst64Removed = 0L;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void remove(C c9) {
        try {
            if (this.mNotificationLevel == 0) {
                this.mCallbacks.remove(c9);
            } else {
                int iLastIndexOf = this.mCallbacks.lastIndexOf(c9);
                if (iLastIndexOf >= 0) {
                    setRemovalBit(iLastIndexOf);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public synchronized CallbackRegistry<C, T, A> m35clone() {
        CallbackRegistry<C, T, A> callbackRegistry;
        CloneNotSupportedException e;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
            try {
                callbackRegistry.mFirst64Removed = 0L;
                callbackRegistry.mRemainderRemoved = null;
                callbackRegistry.mNotificationLevel = 0;
                callbackRegistry.mCallbacks = new ArrayList();
                int size = this.mCallbacks.size();
                for (int i8 = 0; i8 < size; i8++) {
                    if (!isRemoved(i8)) {
                        callbackRegistry.mCallbacks.add(this.mCallbacks.get(i8));
                    }
                }
            } catch (CloneNotSupportedException e4) {
                e = e4;
                e.printStackTrace();
            }
        } catch (CloneNotSupportedException e10) {
            callbackRegistry = null;
            e = e10;
        }
        return callbackRegistry;
    }

    public synchronized void copyCallbacks(List<C> list) {
        list.clear();
        int size = this.mCallbacks.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!isRemoved(i8)) {
                list.add(this.mCallbacks.get(i8));
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void notifyCallbacks(T t3, int i8, A a6, int i9, int i10, long j8) {
        long j10 = 1;
        while (i9 < i10) {
            if ((j8 & j10) == 0) {
                this.mNotifier.onNotifyCallback(this.mCallbacks.get(i9), t3, i8, a6);
            }
            j10 <<= 1;
            i9++;
        }
    }
}
