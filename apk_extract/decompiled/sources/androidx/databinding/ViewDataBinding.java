package androidx.databinding;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.databinding.library.R;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewDataBinding extends BaseObservable implements ViewBinding {
    private static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final int REBOUND = 3;
    protected final DataBindingComponent mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mInStateFlowRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private LifecycleOwner mLifecycleOwner;
    private WeakListener[] mLocalFieldObservers;
    private OnStartListener mOnStartListener;
    private boolean mPendingRebind;
    private CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> mRebindCallbacks;
    private boolean mRebindHalted;
    private final Runnable mRebindRunnable;
    private final View mRoot;
    private Handler mUIThreadHandler;
    static int SDK_INT = Build.VERSION.SDK_INT;
    private static final boolean USE_CHOREOGRAPHER = true;
    private static final CreateWeakListener CREATE_PROPERTY_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.1
        @Override // androidx.databinding.CreateWeakListener
        public WeakListener create(ViewDataBinding viewDataBinding, int i8, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new WeakPropertyListener(viewDataBinding, i8, referenceQueue).getListener();
        }
    };
    private static final CreateWeakListener CREATE_LIST_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.2
        @Override // androidx.databinding.CreateWeakListener
        public WeakListener create(ViewDataBinding viewDataBinding, int i8, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new WeakListListener(viewDataBinding, i8, referenceQueue).getListener();
        }
    };
    private static final CreateWeakListener CREATE_MAP_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.3
        @Override // androidx.databinding.CreateWeakListener
        public WeakListener create(ViewDataBinding viewDataBinding, int i8, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new WeakMapListener(viewDataBinding, i8, referenceQueue).getListener();
        }
    };
    private static final CreateWeakListener CREATE_LIVE_DATA_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.4
        @Override // androidx.databinding.CreateWeakListener
        public WeakListener create(ViewDataBinding viewDataBinding, int i8, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new LiveDataListener(viewDataBinding, i8, referenceQueue).getListener();
        }
    };
    private static final CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void> REBIND_NOTIFIER = new CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void>() { // from class: androidx.databinding.ViewDataBinding.5
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(OnRebindCallback onRebindCallback, ViewDataBinding viewDataBinding, int i8, Void r7) {
            if (i8 == 1) {
                if (onRebindCallback.onPreBind(viewDataBinding)) {
                    return;
                }
                viewDataBinding.mRebindHalted = true;
            } else if (i8 == 2) {
                onRebindCallback.onCanceled(viewDataBinding);
            } else {
                if (i8 != 3) {
                    return;
                }
                onRebindCallback.onBound(viewDataBinding);
            }
        }
    };
    private static final ReferenceQueue<ViewDataBinding> sReferenceQueue = new ReferenceQueue<>();
    private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER = new View.OnAttachStateChangeListener() { // from class: androidx.databinding.ViewDataBinding.6
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.getBinding(view).mRebindRunnable.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    };

    public static class IncludedLayouts {
        public final int[][] indexes;
        public final int[][] layoutIds;
        public final String[][] layouts;

        public IncludedLayouts(int i8) {
            this.layouts = new String[i8][];
            this.indexes = new int[i8][];
            this.layoutIds = new int[i8][];
        }

        public void setIncludes(int i8, String[] strArr, int[] iArr, int[] iArr2) {
            this.layouts[i8] = strArr;
            this.indexes[i8] = iArr;
            this.layoutIds[i8] = iArr2;
        }
    }

    public static class LiveDataListener implements Observer, ObservableReference<LiveData<?>> {

        @Nullable
        WeakReference<LifecycleOwner> mLifecycleOwnerRef = null;
        final WeakListener<LiveData<?>> mListener;

        public LiveDataListener(ViewDataBinding viewDataBinding, int i8, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.mListener = new WeakListener<>(viewDataBinding, i8, this, referenceQueue);
        }

        @Nullable
        private LifecycleOwner getLifecycleOwner() {
            WeakReference<LifecycleOwner> weakReference = this.mLifecycleOwnerRef;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<LiveData<?>> getListener() {
            return this.mListener;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null) {
                WeakListener<LiveData<?>> weakListener = this.mListener;
                binder.handleFieldChange(weakListener.mLocalFieldId, weakListener.getTarget(), 0);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
            LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
            LiveData<?> target = this.mListener.getTarget();
            if (target != null) {
                if (lifecycleOwner2 != null) {
                    target.removeObserver(this);
                }
                if (lifecycleOwner != null) {
                    target.observe(lifecycleOwner, this);
                }
            }
            if (lifecycleOwner != null) {
                this.mLifecycleOwnerRef = new WeakReference<>(lifecycleOwner);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(LiveData<?> liveData) {
            LifecycleOwner lifecycleOwner = getLifecycleOwner();
            if (lifecycleOwner != null) {
                liveData.observe(lifecycleOwner, this);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(LiveData<?> liveData) {
            liveData.removeObserver(this);
        }
    }

    public static class OnStartListener implements LifecycleObserver {
        final WeakReference<ViewDataBinding> mBinding;

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.mBinding.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.mBinding = new WeakReference<>(viewDataBinding);
        }
    }

    public static abstract class PropertyChangedInverseListener extends Observable.OnPropertyChangedCallback implements InverseBindingListener {
        final int mPropertyId;

        public PropertyChangedInverseListener(int i8) {
            this.mPropertyId = i8;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i8) {
            if (i8 == this.mPropertyId || i8 == 0) {
                onChange();
            }
        }
    }

    public static class WeakListListener extends ObservableList.OnListChangedCallback implements ObservableReference<ObservableList> {
        final WeakListener<ObservableList> mListener;

        public WeakListListener(ViewDataBinding viewDataBinding, int i8, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.mListener = new WeakListener<>(viewDataBinding, i8, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<ObservableList> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onChanged(ObservableList observableList) {
            ObservableList target;
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && (target = this.mListener.getTarget()) == observableList) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, target, 0);
            }
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeChanged(ObservableList observableList, int i8, int i9) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeInserted(ObservableList observableList, int i8, int i9) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeMoved(ObservableList observableList, int i8, int i9, int i10) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeRemoved(ObservableList observableList, int i8, int i9) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(ObservableList observableList) {
            observableList.addOnListChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }
    }

    public static class WeakMapListener extends ObservableMap.OnMapChangedCallback implements ObservableReference<ObservableMap> {
        final WeakListener<ObservableMap> mListener;

        public WeakMapListener(ViewDataBinding viewDataBinding, int i8, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.mListener = new WeakListener<>(viewDataBinding, i8, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<ObservableMap> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableMap.OnMapChangedCallback
        public void onMapChanged(ObservableMap observableMap, Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder == null || observableMap != this.mListener.getTarget()) {
                return;
            }
            binder.handleFieldChange(this.mListener.mLocalFieldId, observableMap, 0);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(ObservableMap observableMap) {
            observableMap.addOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(ObservableMap observableMap) {
            observableMap.removeOnMapChangedCallback(this);
        }
    }

    public static class WeakPropertyListener extends Observable.OnPropertyChangedCallback implements ObservableReference<Observable> {
        final WeakListener<Observable> mListener;

        public WeakPropertyListener(ViewDataBinding viewDataBinding, int i8, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.mListener = new WeakListener<>(viewDataBinding, i8, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<Observable> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i8) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && this.mListener.getTarget() == observable) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, observable, i8);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(Observable observable) {
            observable.addOnPropertyChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }
    }

    public ViewDataBinding(DataBindingComponent dataBindingComponent, View view, int i8) {
        this.mRebindRunnable = new Runnable() { // from class: androidx.databinding.ViewDataBinding.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    ViewDataBinding.this.mPendingRebind = false;
                }
                ViewDataBinding.processReferenceQueue();
                if (ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                    ViewDataBinding.this.executePendingBindings();
                } else {
                    ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                    ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                }
            }
        };
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = dataBindingComponent;
        this.mLocalFieldObservers = new WeakListener[i8];
        this.mRoot = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (USE_CHOREOGRAPHER) {
            this.mChoreographer = Choreographer.getInstance();
            this.mFrameCallback = new Choreographer.FrameCallback() { // from class: androidx.databinding.ViewDataBinding.8
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j8) {
                    ViewDataBinding.this.mRebindRunnable.run();
                }
            };
        } else {
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
        }
    }

    public static ViewDataBinding bind(Object obj, View view, int i8) {
        return DataBindingUtil.bind(checkAndCastToBindingComponent(obj), view, i8);
    }

    private static DataBindingComponent checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof DataBindingComponent) {
            return (DataBindingComponent) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
            return;
        }
        if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
            if (callbackRegistry != null) {
                callbackRegistry.notifyCallbacks(this, 1, null);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.notifyCallbacks(this, 2, null);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry2 = this.mRebindCallbacks;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.notifyCallbacks(this, 3, null);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    public static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findIncludeIndex(String str, int i8, IncludedLayouts includedLayouts, int i9) {
        CharSequence charSequenceSubSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = includedLayouts.layouts[i9];
        int length = strArr.length;
        while (i8 < length) {
            if (TextUtils.equals(charSequenceSubSequence, strArr[i8])) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    private static int findLastMatching(ViewGroup viewGroup, int i8) {
        String str = (String) viewGroup.getChildAt(i8).getTag();
        String strSubstring = str.substring(0, str.length() - 1);
        int length = strSubstring.length();
        int childCount = viewGroup.getChildCount();
        for (int i9 = i8 + 1; i9 < childCount; i9++) {
            View childAt = viewGroup.getChildAt(i9);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(strSubstring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i8;
                }
                if (isNumeric(str2, length)) {
                    i8 = i9;
                }
            }
        }
        return i8;
    }

    public static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    public static int getColorFromResource(View view, int i8) {
        return view.getContext().getColor(i8);
    }

    public static ColorStateList getColorStateListFromResource(View view, int i8) {
        return view.getContext().getColorStateList(i8);
    }

    public static Drawable getDrawableFromResource(View view, int i8) {
        return view.getContext().getDrawable(i8);
    }

    public static <K, T> T getFrom(Map<K, T> map, K k8) {
        if (map == null) {
            return null;
        }
        return map.get(k8);
    }

    public static <T> T getFromArray(T[] tArr, int i8) {
        if (tArr == null || i8 < 0 || i8 >= tArr.length) {
            return null;
        }
        return tArr[i8];
    }

    public static <T> T getFromList(List<T> list, int i8) {
        if (list == null || i8 < 0 || i8 >= list.size()) {
            return null;
        }
        return list.get(i8);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <T extends ViewDataBinding> T inflateInternal(@NonNull LayoutInflater layoutInflater, int i8, @Nullable ViewGroup viewGroup, boolean z2, @Nullable Object obj) {
        return (T) DataBindingUtil.inflate(layoutInflater, i8, viewGroup, z2, checkAndCastToBindingComponent(obj));
    }

    private static boolean isNumeric(String str, int i8) {
        int length = str.length();
        if (length == i8) {
            return false;
        }
        while (i8 < length) {
            if (!Character.isDigit(str.charAt(i8))) {
                return false;
            }
            i8++;
        }
        return true;
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View view, int i8, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i8];
        mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        return objArr;
    }

    public static boolean parse(String str, boolean z2) {
        return str == null ? z2 : Boolean.parseBoolean(str);
    }

    private static int parseTagInt(String str, int i8) {
        int length = str.length();
        int iCharAt = 0;
        while (i8 < length) {
            iCharAt = (iCharAt * 10) + (str.charAt(i8) - '0');
            i8++;
        }
        return iCharAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> referencePoll = sReferenceQueue.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof WeakListener) {
                ((WeakListener) referencePoll).unregister();
            }
        }
    }

    public static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static void setBindingInverseListener(ViewDataBinding viewDataBinding, InverseBindingListener inverseBindingListener, PropertyChangedInverseListener propertyChangedInverseListener) {
        if (inverseBindingListener != propertyChangedInverseListener) {
            if (inverseBindingListener != null) {
                viewDataBinding.removeOnPropertyChangedCallback((PropertyChangedInverseListener) inverseBindingListener);
            }
            if (propertyChangedInverseListener != null) {
                viewDataBinding.addOnPropertyChangedCallback(propertyChangedInverseListener);
            }
        }
    }

    public static <T> void setTo(T[] tArr, int i8, T t3) {
        if (tArr == null || i8 < 0 || i8 >= tArr.length) {
            return;
        }
        tArr[i8] = t3;
    }

    public void addOnRebindCallback(@NonNull OnRebindCallback onRebindCallback) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new CallbackRegistry<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.add(onRebindCallback);
    }

    public void ensureBindingComponentIsNotNull(Class<?> cls) {
        if (this.mBindingComponent != null) {
            return;
        }
        throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
    }

    public abstract void executeBindings();

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    public void forceExecuteBindings() {
        executeBindings();
    }

    @Nullable
    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public Object getObservedField(int i8) {
        WeakListener weakListener = this.mLocalFieldObservers[i8];
        if (weakListener == null) {
            return null;
        }
        return weakListener.getTarget();
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.mRoot;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void handleFieldChange(int i8, Object obj, int i9) {
        if (this.mInLiveDataRegisterObserver || this.mInStateFlowRegisterObserver || !onFieldChange(i8, obj, i9)) {
            return;
        }
        requestRebind();
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    public abstract boolean onFieldChange(int i8, Object obj, int i9);

    public void registerTo(int i8, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return;
        }
        WeakListener weakListenerCreate = this.mLocalFieldObservers[i8];
        if (weakListenerCreate == null) {
            weakListenerCreate = createWeakListener.create(this, i8, sReferenceQueue);
            this.mLocalFieldObservers[i8] = weakListenerCreate;
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            if (lifecycleOwner != null) {
                weakListenerCreate.setLifecycleOwner(lifecycleOwner);
            }
        }
        weakListenerCreate.setTarget(obj);
    }

    public void removeOnRebindCallback(@NonNull OnRebindCallback onRebindCallback) {
        CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry != null) {
            callbackRegistry.remove(onRebindCallback);
        }
    }

    public void requestRebind() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding != null) {
            viewDataBinding.requestRebind();
            return;
        }
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner == null || lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                try {
                    if (this.mPendingRebind) {
                        return;
                    }
                    this.mPendingRebind = true;
                    if (USE_CHOREOGRAPHER) {
                        this.mChoreographer.postFrameCallback(this.mFrameCallback);
                    } else {
                        this.mUIThreadHandler.post(this.mRebindRunnable);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    @MainThread
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner instanceof Fragment) {
            Log.w("DataBinding", "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment's view lifecycle");
        }
        LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
        if (lifecycleOwner2 == lifecycleOwner) {
            return;
        }
        if (lifecycleOwner2 != null) {
            lifecycleOwner2.getLifecycle().removeObserver(this.mOnStartListener);
        }
        this.mLifecycleOwner = lifecycleOwner;
        if (lifecycleOwner != null) {
            if (this.mOnStartListener == null) {
                this.mOnStartListener = new OnStartListener();
            }
            lifecycleOwner.getLifecycle().addObserver(this.mOnStartListener);
        }
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.setLifecycleOwner(lifecycleOwner);
            }
        }
    }

    public void setRootTag(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    public abstract boolean setVariable(int i8, @Nullable Object obj);

    public void unbind() {
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.unregister();
            }
        }
    }

    public boolean unregisterFrom(int i8) {
        WeakListener weakListener = this.mLocalFieldObservers[i8];
        if (weakListener != null) {
            return weakListener.unregister();
        }
        return false;
    }

    public boolean updateLiveDataRegistration(int i8, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i8, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean updateRegistration(int i8, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return unregisterFrom(i8);
        }
        WeakListener weakListener = this.mLocalFieldObservers[i8];
        if (weakListener == null) {
            registerTo(i8, obj, createWeakListener);
            return true;
        }
        if (weakListener.getTarget() == obj) {
            return false;
        }
        unregisterFrom(i8);
        registerTo(i8, obj, createWeakListener);
        return true;
    }

    public static byte parse(String str, byte b9) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b9;
        }
    }

    public static long safeUnbox(Long l4) {
        if (l4 == null) {
            return 0L;
        }
        return l4.longValue();
    }

    public void setRootTag(View[] viewArr) {
        for (View view : viewArr) {
            view.setTag(R.id.dataBinding, this);
        }
    }

    public static boolean getFromArray(boolean[] zArr, int i8) {
        if (zArr == null || i8 < 0 || i8 >= zArr.length) {
            return false;
        }
        return zArr[i8];
    }

    public static <T> T getFromList(SparseArray<T> sparseArray, int i8) {
        if (sparseArray == null || i8 < 0) {
            return null;
        }
        return sparseArray.get(i8);
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View[] viewArr, int i8, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i8];
        for (View view : viewArr) {
            mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        }
        return objArr;
    }

    public static short parse(String str, short s2) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s2;
        }
    }

    public static short safeUnbox(Short sh2) {
        if (sh2 == null) {
            return (short) 0;
        }
        return sh2.shortValue();
    }

    public static void setTo(boolean[] zArr, int i8, boolean z2) {
        if (zArr == null || i8 < 0 || i8 >= zArr.length) {
            return;
        }
        zArr[i8] = z2;
    }

    public static <T> T getFromList(LongSparseArray<T> longSparseArray, int i8) {
        if (longSparseArray == null || i8 < 0) {
            return null;
        }
        return longSparseArray.get(i8);
    }

    public static int parse(String str, int i8) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i8;
        }
    }

    public static byte safeUnbox(Byte b9) {
        if (b9 == null) {
            return (byte) 0;
        }
        return b9.byteValue();
    }

    public static byte getFromArray(byte[] bArr, int i8) {
        if (bArr == null || i8 < 0 || i8 >= bArr.length) {
            return (byte) 0;
        }
        return bArr[i8];
    }

    public static <T> T getFromList(androidx.collection.LongSparseArray<T> longSparseArray, int i8) {
        if (longSparseArray == null || i8 < 0) {
            return null;
        }
        return longSparseArray.get(i8);
    }

    public static long parse(String str, long j8) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j8;
        }
    }

    public static char safeUnbox(Character ch2) {
        if (ch2 == null) {
            return (char) 0;
        }
        return ch2.charValue();
    }

    public static void setTo(byte[] bArr, int i8, byte b9) {
        if (bArr == null || i8 < 0 || i8 >= bArr.length) {
            return;
        }
        bArr[i8] = b9;
    }

    public static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i8) {
        if (sparseBooleanArray == null || i8 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i8);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:68:0x0101  */
    private static void mapBindings(DataBindingComponent dataBindingComponent, View view, Object[] objArr, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray, boolean z2) {
        int i8;
        boolean z3;
        int i9;
        int i10;
        boolean z5;
        int iFindIncludeIndex;
        int id2;
        int i11;
        int tagInt;
        if (getBinding(view) != null) {
            return;
        }
        Object tag = view.getTag();
        String str = tag instanceof String ? (String) tag : null;
        boolean z10 = true;
        if (z2 && str != null && str.startsWith("layout")) {
            int iLastIndexOf = str.lastIndexOf(95);
            if (iLastIndexOf > 0) {
                int i12 = iLastIndexOf + 1;
                if (isNumeric(str, i12)) {
                    tagInt = parseTagInt(str, i12);
                    if (objArr[tagInt] == null) {
                        objArr[tagInt] = view;
                    }
                    if (includedLayouts == null) {
                        tagInt = -1;
                    }
                    z3 = true;
                } else {
                    tagInt = -1;
                    z3 = false;
                }
            } else {
                tagInt = -1;
                z3 = false;
            }
            i8 = tagInt;
        } else if (str == null || !str.startsWith(BINDING_TAG_PREFIX)) {
            i8 = -1;
            z3 = false;
        } else {
            int tagInt2 = parseTagInt(str, BINDING_NUMBER_START);
            if (objArr[tagInt2] == null) {
                objArr[tagInt2] = view;
            }
            if (includedLayouts == null) {
                tagInt2 = -1;
            }
            i8 = tagInt2;
            z3 = true;
        }
        if (!z3 && (id2 = view.getId()) > 0 && sparseIntArray != null && (i11 = sparseIntArray.get(id2, -1)) >= 0 && objArr[i11] == null) {
            objArr[i11] = view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i13 = 0;
            int i14 = 0;
            while (i13 < childCount) {
                View childAt = viewGroup.getChildAt(i13);
                if (i8 < 0 || !(childAt.getTag() instanceof String)) {
                    i9 = i13;
                    i10 = i14;
                    z5 = false;
                } else {
                    String str2 = (String) childAt.getTag();
                    if (!str2.endsWith("_0") || !str2.startsWith("layout") || str2.indexOf(47) <= 0 || (iFindIncludeIndex = findIncludeIndex(str2, i14, includedLayouts, i8)) < 0) {
                        i9 = i13;
                        i10 = i14;
                        z5 = false;
                    } else {
                        int i15 = iFindIncludeIndex + 1;
                        int i16 = includedLayouts.indexes[i8][iFindIncludeIndex];
                        int i17 = includedLayouts.layoutIds[i8][iFindIncludeIndex];
                        int iFindLastMatching = findLastMatching(viewGroup, i13);
                        if (iFindLastMatching == i13) {
                            objArr[i16] = DataBindingUtil.bind(dataBindingComponent, childAt, i17);
                            i9 = i13;
                            z5 = z10;
                            i10 = i15;
                        } else {
                            int i18 = iFindLastMatching - i13;
                            int i19 = i18 + 1;
                            View[] viewArr = new View[i19];
                            int i20 = 0;
                            while (i20 < i19) {
                                viewArr[i20] = viewGroup.getChildAt(i13 + i20);
                                i20++;
                                i15 = i15;
                            }
                            objArr[i16] = DataBindingUtil.bind(dataBindingComponent, viewArr, i17);
                            i10 = i15;
                            i9 = i13 + i18;
                            z5 = true;
                        }
                    }
                }
                if (!z5) {
                    mapBindings(dataBindingComponent, childAt, objArr, includedLayouts, sparseIntArray, false);
                }
                int i21 = i10;
                z10 = true;
                i13 = i9 + 1;
                i14 = i21;
            }
        }
    }

    public static float parse(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static double safeUnbox(Double d7) {
        if (d7 == null) {
            return 0.0d;
        }
        return d7.doubleValue();
    }

    public static short getFromArray(short[] sArr, int i8) {
        if (sArr == null || i8 < 0 || i8 >= sArr.length) {
            return (short) 0;
        }
        return sArr[i8];
    }

    public static int getFromList(SparseIntArray sparseIntArray, int i8) {
        if (sparseIntArray == null || i8 < 0) {
            return 0;
        }
        return sparseIntArray.get(i8);
    }

    public static double parse(String str, double d7) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d7;
        }
    }

    public static float safeUnbox(Float f) {
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public static void setTo(short[] sArr, int i8, short s2) {
        if (sArr == null || i8 < 0 || i8 >= sArr.length) {
            return;
        }
        sArr[i8] = s2;
    }

    public boolean updateRegistration(int i8, Observable observable) {
        return updateRegistration(i8, observable, CREATE_PROPERTY_LISTENER);
    }

    public static long getFromList(SparseLongArray sparseLongArray, int i8) {
        if (sparseLongArray == null || i8 < 0) {
            return 0L;
        }
        return sparseLongArray.get(i8);
    }

    public static char parse(String str, char c9) {
        return (str == null || str.isEmpty()) ? c9 : str.charAt(0);
    }

    public static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean updateRegistration(int i8, ObservableList observableList) {
        return updateRegistration(i8, observableList, CREATE_LIST_LISTENER);
    }

    public static char getFromArray(char[] cArr, int i8) {
        if (cArr == null || i8 < 0 || i8 >= cArr.length) {
            return (char) 0;
        }
        return cArr[i8];
    }

    public static void setTo(char[] cArr, int i8, char c9) {
        if (cArr == null || i8 < 0 || i8 >= cArr.length) {
            return;
        }
        cArr[i8] = c9;
    }

    public boolean updateRegistration(int i8, ObservableMap observableMap) {
        return updateRegistration(i8, observableMap, CREATE_MAP_LISTENER);
    }

    public static int getFromArray(int[] iArr, int i8) {
        if (iArr == null || i8 < 0 || i8 >= iArr.length) {
            return 0;
        }
        return iArr[i8];
    }

    public static void setTo(int[] iArr, int i8, int i9) {
        if (iArr == null || i8 < 0 || i8 >= iArr.length) {
            return;
        }
        iArr[i8] = i9;
    }

    public static long getFromArray(long[] jArr, int i8) {
        if (jArr == null || i8 < 0 || i8 >= jArr.length) {
            return 0L;
        }
        return jArr[i8];
    }

    public static void setTo(long[] jArr, int i8, long j8) {
        if (jArr == null || i8 < 0 || i8 >= jArr.length) {
            return;
        }
        jArr[i8] = j8;
    }

    public ViewDataBinding(Object obj, View view, int i8) {
        this(checkAndCastToBindingComponent(obj), view, i8);
    }

    public static float getFromArray(float[] fArr, int i8) {
        if (fArr == null || i8 < 0 || i8 >= fArr.length) {
            return 0.0f;
        }
        return fArr[i8];
    }

    public static void setTo(float[] fArr, int i8, float f) {
        if (fArr == null || i8 < 0 || i8 >= fArr.length) {
            return;
        }
        fArr[i8] = f;
    }

    public static double getFromArray(double[] dArr, int i8) {
        if (dArr == null || i8 < 0 || i8 >= dArr.length) {
            return 0.0d;
        }
        return dArr[i8];
    }

    public static void setTo(double[] dArr, int i8, double d7) {
        if (dArr == null || i8 < 0 || i8 >= dArr.length) {
            return;
        }
        dArr[i8] = d7;
    }

    public static <T> void setTo(List<T> list, int i8, T t3) {
        if (list == null || i8 < 0 || i8 >= list.size()) {
            return;
        }
        list.set(i8, t3);
    }

    public static <T> void setTo(SparseArray<T> sparseArray, int i8, T t3) {
        if (sparseArray == null || i8 < 0 || i8 >= sparseArray.size()) {
            return;
        }
        sparseArray.put(i8, t3);
    }

    public static <T> void setTo(LongSparseArray<T> longSparseArray, int i8, T t3) {
        if (longSparseArray == null || i8 < 0 || i8 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i8, t3);
    }

    public static <T> void setTo(androidx.collection.LongSparseArray<T> longSparseArray, int i8, T t3) {
        if (longSparseArray == null || i8 < 0 || i8 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i8, t3);
    }

    public static void setTo(SparseBooleanArray sparseBooleanArray, int i8, boolean z2) {
        if (sparseBooleanArray == null || i8 < 0 || i8 >= sparseBooleanArray.size()) {
            return;
        }
        sparseBooleanArray.put(i8, z2);
    }

    public static void setTo(SparseIntArray sparseIntArray, int i8, int i9) {
        if (sparseIntArray == null || i8 < 0 || i8 >= sparseIntArray.size()) {
            return;
        }
        sparseIntArray.put(i8, i9);
    }

    public static void setTo(SparseLongArray sparseLongArray, int i8, long j8) {
        if (sparseLongArray == null || i8 < 0 || i8 >= sparseLongArray.size()) {
            return;
        }
        sparseLongArray.put(i8, j8);
    }

    public static <K, T> void setTo(Map<K, T> map, K k8, T t3) {
        if (map == null) {
            return;
        }
        map.put(k8, t3);
    }
}
