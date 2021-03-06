package com.mylody.myone.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.mylody.myone.application.MyOneApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * User:Shine
 * Date:2015-08-10
 * Description:
 */
public class Utils {

    private static int screenWidth = 0;
    private static int screenHeight = 0;

    /**
     * dp转px
     */
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * dp转px
     */
    public static float dpToPxF(float dp) {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * 得到屏幕高度
     */
    public static int getScreenHeight() {
        if (screenHeight == 0) {
            WindowManager wm = (WindowManager) MyOneApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }

        return screenHeight;
    }

    /**
     * 得到屏幕宽度
     */
    public static int getScreenWidth() {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) MyOneApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }
        return screenWidth;
    }

    /**
     * 根据string资源返回文本
     */
    public static String getString(int resId) {
        Context context = MyOneApplication.getContext();
        return context.getString(resId);
    }

    public static String convertMarketTimeForHome(String marketTime) {
        try {
            SimpleDateFormat formatString = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            Date marketDate = formatString.parse(marketTime);
            SimpleDateFormat formatDate = new SimpleDateFormat("dd MMM,yyyy", Locale.US);
            String convertedMarketTime = formatDate.format(marketDate);

            return convertedMarketTime;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String convertMarketTimeForHomeElse(String marketTime) {
        try {
            SimpleDateFormat formatString = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            Date marketDate = formatString.parse(marketTime);
            SimpleDateFormat formatDate = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
            String convertedMarketTime = formatDate.format(marketDate);

            return convertedMarketTime;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

}
