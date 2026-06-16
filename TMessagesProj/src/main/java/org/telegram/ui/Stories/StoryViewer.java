package org.telegram.ui.Stories;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.Editable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.collection.LongSparseArray;

import org.telegram.messenger.MessageObject;
import org.telegram.messenger.NotificationCenter;
import org.telegram.tgnet.tl.TL_stories;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Stories.LivePlayer;
import org.telegram.ui.Cells.ChatActionCell;
import org.telegram.ui.Cells.ChatMessageCell;
import org.telegram.ui.Components.RLottieImageView;

import java.util.ArrayList;

public class StoryViewer extends FrameLayout implements NotificationCenter.NotificationCenterDelegate, BaseFragment.AttachedSheet {

    public int currentAccount;
    public boolean fromBottomSheet;
    public StoriesController.StoriesList storiesList;
    public static boolean animationInProgress;
    public static float currentSpeed = 1f;
    public boolean inSeekingMode;
    public boolean USE_SURFACE_VIEW;
    public Theme.ResourcesProvider resourcesProvider;
    public BaseFragment fragment;
    public FrameLayout containerView;
    public FrameLayout windowView;
    public android.app.Activity parentActivity;
    public LivePlayer livePlayer;
    public boolean isShowing;
    public boolean isLongpressed;
    public TL_stories.PeerStories overrideUserStories;
    public LongSparseArray<Integer> savedPositions = new LongSparseArray<>();
    public boolean isSingleStory;
    public boolean singleStoryDeleted;
    public TL_stories.StoryItem singleStory;
    public boolean isTranslating;
    public boolean reversed;
    public boolean unreadStateChanged;
    public boolean ATTACH_TO_FRAGMENT;
    public float swipeToReplyProgress;
    public PlaceProvider placeProvider;
    public float selfStoriesViewsOffset;
    public StoriesViewPager storiesViewPager;
    public int dayStoryId;
    public org.telegram.ui.Stories.recorder.LivePlayerView liveView;

    @Override
    public boolean isAttachedLightStatusBar() { return false; }
    @Override
    public boolean showDialog(android.app.Dialog dialog) { return false; }
    @Override
    public void dismiss() {}
    @Override
    public void release() {}
    @Override
    public boolean attachedToParent() { return false; }
    @Override
    public boolean onAttachedBackPressed() { return false; }

    public android.app.Dialog getVisibleDialog() { return null; }

    public void startActivityForResult(Intent intent, int requestCode) {}
    public void checkSelfStoriesView() {}
    public void openViews() {}
    public float getProgressToSelfViews() { return 0; }
    public Editable getDraft(long dialogId, TL_stories.StoryItem storyItem) { return null; }
    public void saveDraft(long dialogId, TL_stories.StoryItem storyItem, Editable text) {}
    public void clearDraft(long dialogId, TL_stories.StoryItem storyItem) {}
    public void cancelSwipeToReply() {}
    public void cancelSwipeToViews(boolean animated) {}
    public void closeKeyboardOrEmoji() {}
    public void setSelfStoriesViewsOffset(float offset) {}
    public void dismissVisibleDialogs() {}
    public void allowScreenshots(boolean allow) {}

    public StoryViewer(BaseFragment fragment) {
        super(fragment.getParentActivity());
        this.fragment = fragment;
        this.parentActivity = fragment.getParentActivity();
        setVisibility(GONE);
    }

    public static void closeGlobalInstances() {}
    public TransitionViewHolder transitionViewHolder;

    public void open(Context context, int startStoryId, StoriesController.StoriesList storiesList, PlaceProvider placeProvider) {}
    public void open(Context context, TL_stories.StoryItem storyItem, int startStoryId, StoriesController.StoriesList storiesList, boolean reversed, PlaceProvider placeProvider) {}
    public void open(Context context, TL_stories.StoryItem storyItem, ArrayList<Long> peerIds, int position, StoriesController.StoriesList storiesList, TL_stories.PeerStories userStories, PlaceProvider placeProvider, boolean reversed) {}
    public void open(int account, Context context, TL_stories.StoryItem storyItem, ArrayList<Long> peerIds, int position, StoriesController.StoriesList storiesList, TL_stories.PeerStories userStories, PlaceProvider placeProvider, boolean reversed) {}
    public void open(Context context, long dialogId, StoriesListPlaceProvider placeProvider) {}
    public void open(Context context, TL_stories.StoryItem storyItem, StoriesListPlaceProvider placeProvider) {}
    public void open(Context context, long dialogId, PlaceProvider placeProvider) {}
    public void open(Context context, long dialogId, OnStoryOpenListener listener) {}
    public void open(Context context, TL_stories.PeerStories stories, PlaceProvider placeProvider) {}
    public void open(Context context, TL_stories.StoryItem storyItem, PlaceProvider placeProvider) {}
    public void openFor(BaseFragment fragment, View listView, ChatActionCell cell) {}
    public void open(int account, Context context, TL_stories.StoryItem storyItem, StoriesListPlaceProvider placeProvider) {}
    public void open(int account, Context context, long dialogId, StoriesListPlaceProvider placeProvider) {}

    public void onResume() {}
    public void onPause() {}
    public void updatePlayingMode() {}
    public void close(boolean animated) {}
    public boolean isShown() { return false; }
    public View getWindowView() { return this; }
    public void setKeyboardHeightFromParent(int height) {}
    public void listenToAttachedSheet(BaseFragment.AttachedSheet sheet) {}
    public void destroy() {}
    public void doOnAnimationReady(Runnable r) { if (r != null) r.run(); }

    public static boolean isShowingImage(MessageObject messageObject) { return false; }
    public PeerStoriesView getCurrentPeerView() { return null; }
    public boolean getStoryRect(RectF rect) { return false; }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {}
    public void instantClose() {}
    public void showViewsAfterOpening() {}
    public boolean isFullyVisible() { return false; }
    public Theme.ResourcesProvider getResourceProvider() { return null; }
    public void setOnDismissListener(Runnable r) {}
    public int getNavigationBarColor(int color) { return color; }

    public void presentFragment(BaseFragment fragment) {}
    public void switchToPip() {}
    public void setSpeed(float speed) {}
    public void setOverlayVisible(boolean visible) {}
    public void toggleSilentMode() {}
    public boolean soundEnabled() { return false; }
    public void setOnCloseListener(Runnable r) {}
    public FrameLayout getContainerForBulletin() { return this; }

    @Override
    public void didReceivedNotification(int id, int account, Object... args) {}

    public interface OnStoryOpenListener {
        boolean onOpen(long dialogId, int messageId, int storyId, int type, TransitionViewHolder holder);
    }

    public interface PlaceProvider {
        default View getView(int i, int i1, int i2) { return null; }
        default int getId(int i, int i1, int i2) { return 0; }
        default Object getParentObject(int i) { return null; }
        default void cancel() {}
        default void preLayout(long currentDialogId, int messageId, Runnable r) { r.run(); }
        default void loadNext(boolean forward) {}
        default boolean findView(long dialogId, int messageId, int storyId, int type, TransitionViewHolder holder) { return false; }
    }

    public static class TransitionViewHolder {
        public View view;
        public org.telegram.messenger.ImageReceiver storyImage;
        public org.telegram.messenger.ImageReceiver avatarImage;
        public org.telegram.messenger.ImageReceiver crossfadeToAvatarImage;
        public Object params;
        public View clipParent;
        public int clipTop;
        public int clipBottom;
        public float alpha = 1;
        public boolean isLive;
        public boolean checkParentScale;
        public DrawAbove drawAbove;
        public DrawClip drawClip;
        public android.graphics.Paint bgPaint;
        public org.telegram.ui.Components.RadialProgress radialProgressUpload;
        public int storyId;
    }

    public static class VideoPlayerHolder {
        public RLottieImageView storyImageView;
        public boolean paused;
        public Bitmap playerStubBitmap;
        public boolean stubAvailable;
        public android.graphics.Paint playerStubPaint;
        public float progress;
        public int currentSeek;
        public long currentPosition;
        public boolean firstFrameRendered;
        public float getPlaybackProgress(long duration) { return 0; }
        public void loopBack() {}
        public void setOnReadyListener(Runnable r) {}
        public boolean isBuffering() { return false; }
    }

    public interface HolderDrawAbove extends DrawAbove {
    }

    public interface DrawAbove {
        void drawAbove(Canvas canvas, RectF bounds, float alpha, boolean opening);
    }

    public interface DrawClip {
        void drawClip(Canvas canvas, RectF bounds, float alpha, boolean opening);
    }

    public static class RadialProgress {
        public float progress;
    }

    public static class ImageReceiver {
        public android.graphics.drawable.Drawable getImageDrawable() { return null; }
    }

    public static class Paint {
        public Paint() {}
        public Paint(int flags) {}
        public void setColor(int color) {}
    }
}
