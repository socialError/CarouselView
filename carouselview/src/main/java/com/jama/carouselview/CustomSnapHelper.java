package com.jama.carouselview;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class CustomSnapHelper extends LinearSnapHelper {

    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if(layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if(needToDoSnap(linearLayoutManager) == false) {
                return null;
            }
        }
        return super.findSnapView(layoutManager);
    }

    public View findSnapViewOriginalImplementation(RecyclerView.LayoutManager layoutManager) {
        return super.findSnapView(layoutManager);
    }

    public boolean needToDoSnap(LinearLayoutManager linearLayoutManager){
        boolean result = linearLayoutManager.findFirstCompletelyVisibleItemPosition() !=0 && linearLayoutManager.findLastCompletelyVisibleItemPosition() != linearLayoutManager.getItemCount() - 1;
        return result;
    }
}
