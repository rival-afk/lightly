package org.telegram.ui.Stories;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import org.telegram.messenger.NotificationCenter;
import org.telegram.tgnet.tl.TL_stories;
import org.telegram.ui.ActionBar.BaseFragment;

import java.util.ArrayList;

public class StoryViewer extends FrameLayout implements NotificationCenter.NotificationCenterDelegate, BaseFragment.AttachedSheet {

    public int currentAccount;
    public boolean fromBottomSheet;
    public StoriesController.StoriesList storiesList;

    public StoryViewer(BaseFragment fragment) {
        super(fragment.getParentActivity());
        setVisibility(GONE);
    }

    public void open(Context context, int startStoryId, StoriesController.StoriesList storiesList, PlaceProvider placeProvider) {}
    public void open(Context context, TL_stories.StoryItem storyItem, int startStoryId, StoriesController.StoriesList storiesList, boolean reversed, PlaceProvider placeProvider) {}
    public void open(Context context, TL_stories.StoryItem storyItem, ArrayList<Long> peerIds, int position, StoriesController.StoriesList storiesList, TL_stories.PeerStories userStories, PlaceProvider placeProvider, boolean reversed) {}
    public void open(int account, Context context, TL_stories.StoryItem storyItem, ArrayList<Long> peerIds, int position, StoriesController.StoriesList storiesList, TL_stories.PeerStories userStories, PlaceProvider placeProvider, boolean reversed) {}

    public void onResume() {}
    public void onPause() {}
    public void updatePlayingMode() {}
    public void close(boolean animated) {}
    public boolean isShown() { return false; }
    public View getWindowView() { return this; }
    public void setKeyboardHeightFromParent(int height) {}
    public void listenToAttachedSheet(BaseFragment.AttachedSheet sheet) {}
    public void destroy() {}

    @Override
    public void didReceivedNotification(int id, int account, Object... args) {}

    public interface PlaceProvider {
        View getView(int i, int i1, int i2);
        int getId(int i, int i1, int i2);
        Object getParentObject(int i);
        void cancel();
    }
}
