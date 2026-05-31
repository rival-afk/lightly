package org.telegram.ui.Stories;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;

import org.telegram.messenger.Utilities;
import org.telegram.tgnet.TLRPC;
import org.telegram.tgnet.tl.TL_stories;

import java.util.ArrayList;
import java.util.Comparator;

public class StoriesController {

    public static final int STATE_READ = 0;
    public static final int STATE_UNREAD = 1;
    public static final int STATE_UNREAD_CLOSE_FRIEND = 2;
    public static final int STATE_LIVE = 3;

    public static final Comparator<TL_stories.StoryItem> storiesComparator = (a, b) -> 0;

    public final int currentAccount;

    public StoriesController(int currentAccount) {
        this.currentAccount = currentAccount;
    }

    public void cleanup() {}
    public void onPremiumChanged() {}
    public void loadAllStories() {}
    public void loadStories() {}
    public void loadHiddenStories() {}
    public void processUpdate(TL_stories.TL_updateStory update) {}
    public void markStoriesAsReadFromServer(long dialogId, int maxId) {}
    public void updateBlockUser(long id, boolean blocked, boolean value) {}
    public void updateStoryReaction(long dialogId, int storyId, TLRPC.Reaction reaction) {}
    public void setStealthMode(TLRPC.TL_storiesStealthMode mode) {}
    public void updateStoriesFromFullPeer(long dialogId, TL_stories.TL_peerStories stories) {}
    public void putStories(long dialogId, TL_stories.TL_peerStories stories) {}
    public boolean hasHiddenStories() { return false; }
    public boolean hasStories(long dialogId) { return false; }
    public boolean hasStories() { return false; }
    public boolean hasUnreadStories(long dialogId) { return false; }
    public boolean hasLiveStory(long dialogId) { return false; }
    public boolean hasLoadingStories() { return false; }
    public boolean hasOnlySelfStories() { return false; }
    public boolean canPostStories(long dialogId) { return false; }
    public boolean canPostStories(TLRPC.Chat chat) { return false; }
    public boolean canEditStories(long dialogId) { return false; }
    public boolean canEditStoryAlbums(long dialogId) { return false; }
    public void canSendStoryFor(long dialogId, Utilities.Callback<Boolean> callback) { if (callback != null) callback.run(false); }
    public int getSelfStoriesCount() { return 0; }
    public int getTotalStoriesCount(boolean hidden) { return 0; }
    public int getUnreadState(long dialogId) { return STATE_READ; }
    public int getUnreadState(long dialogId, int storyId) { return STATE_READ; }
    public TL_stories.StoryItem findStory(long dialogId, int storyId) { return null; }
    public ArrayList<TLRPC.TL_peerStories> getHiddenList() { return new ArrayList<>(); }
    public ArrayList<TLRPC.TL_peerStories> getDialogListStories() { return new ArrayList<>(); }
    public TL_stories.TL_storiesStealthMode getStealthMode() { return null; }
    public StoryLimit checkStoryLimit() { return null; }
    public void invalidateStoryLimit() {}
    public StoriesStorage getStoriesStorage() { return null; }
    public StoriesCollections getStoryAlbumsList(long dialogId) { return null; }
    public void addStoryToAlbum(long dialogId, int albumId, TL_stories.StoryItem storyItem) {}
    public void addStoriesToAlbum(long dialogId, int albumId, ArrayList<TL_stories.StoryItem> storyItems) {}
    public void removeStoryFromAlbum(long dialogId, int albumId, TL_stories.StoryItem storyItem) {}
    public void removeStoriesFromAlbum(long dialogId, int albumId, ArrayList<TL_stories.StoryItem> storyItems) {}
    public void createAlbum(long dialogId, String name) {}
    public void removeAlbum(long dialogId, int albumId) {}
    public void renameAlbum(long dialogId, int albumId, String name) {}
    public String getAlbumName(long dialogId, int albumId) { return null; }
    public void deleteStories(long dialogId, ArrayList<TL_stories.StoryItem> storyItems) {}
    public StoriesList getStoriesList(long dialogId, int type) { return null; }
    public void updateStoriesInLists(long dialogId, ArrayList<TL_stories.StoryItem> storyItems) {}
    public void updateStoriesPinned(long dialogId, ArrayList<TL_stories.StoryItem> storyItems, boolean pin, Runnable callback) {}
    public void toggleHidden(long dialogId, boolean hide, boolean request, boolean notify) {}
    public void removeContact(long dialogId) {}
    public void resolveStoryLink(long peerId, int storyId, Utilities.Callback<TL_stories.StoryItem> consumer) { if (consumer != null) consumer.run(null); }
    public void resolveStoryAlbumLink(long peerId, int albumId, Utilities.Callback<TLRPC.TL_storyAlbum> consumer) { if (consumer != null) consumer.run(null); }
    public void resolveLiveStoryLink(long peerId, Utilities.Callback<TLRPC.TL_peerStories> consumer) { if (consumer != null) consumer.run(null); }
    public void fillMessagesWithStories(ArrayList<Long> messages, Utilities.Callback<ArrayList<TL_stories.StoryItem>> callback) { if (callback != null) callback.run(new ArrayList<>()); }
    public void loadSendAs() {}
    public void pollViewsForSelfStories(long dialogId, int start) {}

    public static class StoryAlbum {
        public int id;
        public String title;
        public ArrayList<TL_stories.StoryItem> storyItems = new ArrayList<>();
        public int count;
        public boolean expanded;

        public StoryAlbum() {}
    }

    public static class StoryLimit {
        public int type;
    }

    public static class StoriesList {
        public static final int TYPE_PINNED = 0;
        public static final int TYPE_ARCHIVE = 1;
        public static final int TYPE_STATISTICS = 2;
        public static final int TYPE_SEARCH = 3;
        public static final int TYPE_BOTS = 4;
        public static final int TYPE_ALBUMS = TYPE_PINNED;

        public int type;
        public int currentAccount;

        public StoriesList(int account, int type) { this.currentAccount = account; this.type = type; }
        public StoriesList(int account, int type, boolean b) { this(account, type); }
        public StoriesList(int account, int type, boolean b, boolean b1) { this(account, type); }

        public static long day(TL_stories.StoryItem item) { return 0; }
        public TL_stories.StoryItem findMessageObject(long did) { return null; }
        public boolean isLoading() { return false; }
        public boolean isLoaded() { return false; }
        public int getCount() { return 0; }
        public TL_stories.StoryItem get(int pos) { return null; }

        public static final Comparator<TL_stories.StoryItem> storiesComparator = (a, b) -> 0;
    }

    public static class SearchStoriesList extends StoriesList {
        public SearchStoriesList(int account) { super(account, TYPE_SEARCH); }
        public SearchStoriesList(int account, int type) { super(account, type); }
    }

    public static class StoryRepostsList extends StoriesList {
        public StoryRepostsList(int account, ArrayList<TL_stories.StoryItem> items) { super(account, TYPE_PINNED); }
    }

    public static class BotPreviewsList extends StoriesList {
        public String lang_code;
        public BotPreviewsList(int account, long botId, String langCode, Boolean bool) { super(account, TYPE_BOTS); lang_code = langCode; }
    }

    public static class BotPreview extends TL_stories.StoryItem {
        public BotPreviewsList list;
    }

    public class UploadingStory {
        public TL_stories.StoryItem storyItem;
    }

    public class StoriesCollections {
    }
}
