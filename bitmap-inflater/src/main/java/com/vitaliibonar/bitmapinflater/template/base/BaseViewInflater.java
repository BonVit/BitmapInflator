package com.vitaliibonar.bitmapinflater.template.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.vitaliibonar.bitmapinflater.BitmapInflater;
import com.vitaliibonar.bitmapinflater.ViewSettings;

/**
 * Created by vitaliibonar on 1/12/18.
 */

public abstract class BaseViewInflater {
    protected ViewSettings viewSettings;

    public BaseViewInflater(Context context) {
        viewSettings = ViewSettings.newSettings();
        viewSettings.setContext(context);
        viewSettings.setLayoutRes(getLayoutRes());
        viewSettings.setCallbacks(callbacks());
        viewSettings.setWidth(ViewSettings.WRAP_CONTENT);
        viewSettings.setHeight(ViewSettings.WRAP_CONTENT);
        viewSettings.setBitmapConfig(Bitmap.Config.ARGB_8888);
    }

    public void setWidth(int width) {
        viewSettings.setWidth(width);
    }

    public int getWidth() {
        return viewSettings.getWidth();
    }

    public void setHeight(int height) {
        viewSettings.setHeight(height);
    }

    public int getHeight() {
        return viewSettings.getHeight();
    }

    public void setBitmapConfig(Bitmap.Config bitmapConfig) {
        viewSettings.setBitmapConfig(bitmapConfig);
    }

    public Bitmap.Config getBitmapConfig() {
        return viewSettings.getBitmapConfig();
    }

    public Bitmap makeBitmap() {
        return BitmapInflater.createBitmapFromSettings(viewSettings);
    }

    protected abstract ViewSettings.Callbacks callbacks();
    protected abstract @LayoutRes int getLayoutRes();
}
