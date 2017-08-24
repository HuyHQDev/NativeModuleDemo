package com.nativemoduledemo.viewmanager;

import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;

import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;

/**
 * Created by bapvn on 8/24/17.
 */

public class CardViewManager extends ViewGroupManager<CardView> {

    public static final String REACT_CLASS = "RCTCardView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected CardView createViewInstance(ThemedReactContext reactContext) {
        CardView cardView = new CardView(reactContext);
        cardView.setUseCompatPadding(true);
        ReactViewGroup reactViewGroup = new ReactViewGroup(reactContext);
        cardView.addView(reactViewGroup);
        return cardView;
    }

    @ReactProp(name = "cardElevation", defaultFloat = 0f)
    public void setCardElevation(CardView view, float elevation) {
        view.setCardElevation(PixelUtil.toPixelFromDIP(elevation));

    }

    @ReactProp(name = "cardCornerRadius", defaultFloat = 0f)
    public void setCardCornerRadius(CardView view, float cornerRadius) {
        view.setRadius(PixelUtil.toPixelFromDIP(cornerRadius));
    }

    @ReactProp(name = "backgroundColor")
    public void setCardBackgroundColor(CardView view, int color) {
        view.setBackgroundColor(color);
    }

    @Override
    public View getChildAt(CardView parent, int index) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            return ((ReactViewGroup) content).getChildAt(index);
        }
        return null;
    }

    @Override
    public int getChildCount(CardView parent) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            return ((ReactViewGroup) content).getChildCount();
        }
        return 0;
    }


    @Override
    public void addView(CardView parent, View child, int index) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            ((ReactViewGroup) content).addView(child, index);
        }
    }

    @Override
    public void removeViewAt(CardView parent, int index) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            ((ReactViewGroup) content).removeViewAt(index);
        }
    }

    @Override
    public void removeAllViews(CardView parent) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            ((ReactViewGroup) content).removeAllViews();
        }
    }

}
