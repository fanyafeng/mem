package cn.edu.bjtu.gs.view.quicksliderbar.listener;

public interface OnQuickSideBarTouchListener {
    void onLetterChanged(String letter, int position, float y);

    void onLetterTouching(boolean touching);
}
