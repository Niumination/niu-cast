package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
class ViewPumpLayoutInflater extends LayoutInflater implements ViewPumpActivityFactory {
    private static final String[] sClassPrefixList = {"android.widget.", "android.webkit."};
    private Field mConstructorArgs;
    private boolean mSetPrivateFactory;
    private FallbackViewCreator nameAndAttrsViewCreator;
    private FallbackViewCreator parentAndNameAndAttrsViewCreator;

    public static class ActivityViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;
        private final View view;

        public ActivityViewCreator(ViewPumpLayoutInflater viewPumpLayoutInflater, View view) {
            this.inflater = viewPumpLayoutInflater;
            this.view = view;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.inflater.createCustomViewInternal(view, this.view, str, context, attributeSet);
        }
    }

    public static class NameAndAttrsViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;

        public NameAndAttrsViewCreator(ViewPumpLayoutInflater viewPumpLayoutInflater) {
            this.inflater = viewPumpLayoutInflater;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            View viewCreateView = null;
            for (String str2 : ViewPumpLayoutInflater.sClassPrefixList) {
                try {
                    viewCreateView = this.inflater.createView(str, str2, attributeSet);
                    if (viewCreateView != null) {
                        break;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            return viewCreateView == null ? this.inflater.superOnCreateView(str, attributeSet) : viewCreateView;
        }
    }

    public static class ParentAndNameAndAttrsViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;

        public ParentAndNameAndAttrsViewCreator(ViewPumpLayoutInflater viewPumpLayoutInflater) {
            this.inflater = viewPumpLayoutInflater;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.inflater.superOnCreateView(view, str, attributeSet);
        }
    }

    public static class PrivateWrapperFactory2 extends WrapperFactory2 {
        private final PrivateWrapperFactory2ViewCreator mViewCreator;

        public PrivateWrapperFactory2(LayoutInflater.Factory2 factory2, ViewPumpLayoutInflater viewPumpLayoutInflater) {
            super(factory2);
            this.mViewCreator = new PrivateWrapperFactory2ViewCreator(factory2, viewPumpLayoutInflater);
        }

        @Override // io.github.inflationx.viewpump.ViewPumpLayoutInflater.WrapperFactory2, android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return ViewPump.get().inflate(InflateRequest.builder().name(str).context(context).attrs(attributeSet).parent(view).fallbackViewCreator(this.mViewCreator).build()).view();
        }
    }

    public static class PrivateWrapperFactory2ViewCreator extends WrapperFactory2ViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater mInflater;

        public PrivateWrapperFactory2ViewCreator(LayoutInflater.Factory2 factory2, ViewPumpLayoutInflater viewPumpLayoutInflater) {
            super(factory2);
            this.mInflater = viewPumpLayoutInflater;
        }

        @Override // io.github.inflationx.viewpump.ViewPumpLayoutInflater.WrapperFactory2ViewCreator, io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.mInflater.createCustomViewInternal(view, this.mFactory2.onCreateView(view, str, context, attributeSet), str, context, attributeSet);
        }
    }

    public static class WrapperFactory implements LayoutInflater.Factory {
        private final FallbackViewCreator mViewCreator;

        public WrapperFactory(LayoutInflater.Factory factory) {
            this.mViewCreator = new WrapperFactoryViewCreator(factory);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return ViewPump.get().inflate(InflateRequest.builder().name(str).context(context).attrs(attributeSet).fallbackViewCreator(this.mViewCreator).build()).view();
        }
    }

    public static class WrapperFactory2 implements LayoutInflater.Factory2 {
        protected final LayoutInflater.Factory2 mFactory2;
        private final WrapperFactory2ViewCreator mViewCreator;

        public WrapperFactory2(LayoutInflater.Factory2 factory2) {
            this.mFactory2 = factory2;
            this.mViewCreator = new WrapperFactory2ViewCreator(factory2);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return onCreateView(null, str, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return ViewPump.get().inflate(InflateRequest.builder().name(str).context(context).attrs(attributeSet).parent(view).fallbackViewCreator(this.mViewCreator).build()).view();
        }
    }

    public static class WrapperFactory2ViewCreator implements FallbackViewCreator {
        protected final LayoutInflater.Factory2 mFactory2;

        public WrapperFactory2ViewCreator(LayoutInflater.Factory2 factory2) {
            this.mFactory2 = factory2;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.mFactory2.onCreateView(view, str, context, attributeSet);
        }
    }

    public static class WrapperFactoryViewCreator implements FallbackViewCreator {
        protected final LayoutInflater.Factory mFactory;

        public WrapperFactoryViewCreator(LayoutInflater.Factory factory) {
            this.mFactory = factory;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.mFactory.onCreateView(str, context, attributeSet);
        }
    }

    public ViewPumpLayoutInflater(Context context) {
        super(context);
        this.mSetPrivateFactory = false;
        this.mConstructorArgs = null;
        this.nameAndAttrsViewCreator = new NameAndAttrsViewCreator(this);
        this.parentAndNameAndAttrsViewCreator = new ParentAndNameAndAttrsViewCreator(this);
        setUpLayoutFactories(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View createCustomViewInternal(View view, View view2, String str, Context context, AttributeSet attributeSet) {
        if (!ViewPump.get().isCustomViewCreation()) {
            return view2;
        }
        if (view2 == null && str.indexOf(46) > -1) {
            if (this.mConstructorArgs == null) {
                this.mConstructorArgs = ReflectionUtils.getField(LayoutInflater.class, "mConstructorArgs");
            }
            Object[] objArr = (Object[]) ReflectionUtils.getValue(this.mConstructorArgs, this);
            Object obj = objArr[0];
            objArr[0] = context;
            ReflectionUtils.setValue(this.mConstructorArgs, this, objArr);
            try {
                view2 = createView(str, null, attributeSet);
                objArr[0] = obj;
            } catch (ClassNotFoundException unused) {
                objArr[0] = obj;
            } finally {
                objArr[0] = obj;
                ReflectionUtils.setValue(this.mConstructorArgs, this, objArr);
            }
        }
        return view2;
    }

    private void setPrivateFactoryInternal() {
        if (!this.mSetPrivateFactory && ViewPump.get().isReflection()) {
            if (!(getContext() instanceof LayoutInflater.Factory2)) {
                this.mSetPrivateFactory = true;
                return;
            }
            Method method = ReflectionUtils.getMethod(LayoutInflater.class, "setPrivateFactory");
            if (method != null) {
                ReflectionUtils.invokeMethod(this, method, new PrivateWrapperFactory2((LayoutInflater.Factory2) getContext(), this));
            }
            this.mSetPrivateFactory = true;
        }
    }

    private void setUpLayoutFactories(boolean z2) {
        if (z2) {
            return;
        }
        if (getFactory2() != null && !(getFactory2() instanceof WrapperFactory2)) {
            setFactory2(getFactory2());
        }
        if (getFactory() == null || (getFactory() instanceof WrapperFactory)) {
            return;
        }
        setFactory(getFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View superOnCreateView(View view, String str, AttributeSet attributeSet) {
        try {
            return super.onCreateView(view, str, attributeSet);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return new ViewPumpLayoutInflater(this, context, true);
    }

    @Override // android.view.LayoutInflater
    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z2) {
        setPrivateFactoryInternal();
        return super.inflate(xmlPullParser, viewGroup, z2);
    }

    @Override // io.github.inflationx.viewpump.ViewPumpActivityFactory
    public View onActivityCreateView(View view, View view2, String str, Context context, AttributeSet attributeSet) {
        return ViewPump.get().inflate(InflateRequest.builder().name(str).context(context).attrs(attributeSet).parent(view).fallbackViewCreator(new ActivityViewCreator(this, view2)).build()).view();
    }

    @Override // android.view.LayoutInflater
    public View onCreateView(View view, String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return ViewPump.get().inflate(InflateRequest.builder().name(str).context(getContext()).attrs(attributeSet).parent(view).fallbackViewCreator(this.parentAndNameAndAttrsViewCreator).build()).view();
    }

    @Override // android.view.LayoutInflater
    public void setFactory(LayoutInflater.Factory factory) {
        if (factory instanceof WrapperFactory) {
            super.setFactory(factory);
        } else {
            super.setFactory(new WrapperFactory(factory));
        }
    }

    @Override // android.view.LayoutInflater
    public void setFactory2(LayoutInflater.Factory2 factory2) {
        if (factory2 instanceof WrapperFactory2) {
            super.setFactory2(factory2);
        } else {
            super.setFactory2(new WrapperFactory2(factory2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View superOnCreateView(String str, AttributeSet attributeSet) {
        try {
            return super.onCreateView(str, attributeSet);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public ViewPumpLayoutInflater(LayoutInflater layoutInflater, Context context, boolean z2) {
        super(layoutInflater, context);
        this.mSetPrivateFactory = false;
        this.mConstructorArgs = null;
        this.nameAndAttrsViewCreator = new NameAndAttrsViewCreator(this);
        this.parentAndNameAndAttrsViewCreator = new ParentAndNameAndAttrsViewCreator(this);
        setUpLayoutFactories(z2);
    }

    @Override // android.view.LayoutInflater
    public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return ViewPump.get().inflate(InflateRequest.builder().name(str).context(getContext()).attrs(attributeSet).fallbackViewCreator(this.nameAndAttrsViewCreator).build()).view();
    }
}
