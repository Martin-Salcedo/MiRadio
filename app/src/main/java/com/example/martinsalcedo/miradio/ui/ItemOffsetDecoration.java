package com.example.martinsalcedo.miradio.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by martinsalcedo on 11/08/16.
 */

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

    //Medida en pixeles del espacio entre elementos
    private int mItemOffset;

    public ItemOffsetDecoration(Context context, @IntegerRes int integerResId){

        int itemOffsetdp = context.getResources().getInteger(integerResId);

        mItemOffset = convertToPixels(itemOffsetdp, context.getResources().getDisplayMetrics());

    }

    public int convertToPixels(int offsetDp, DisplayMetrics metrics){

        return offsetDp * (metrics.densityDpi / 160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}
