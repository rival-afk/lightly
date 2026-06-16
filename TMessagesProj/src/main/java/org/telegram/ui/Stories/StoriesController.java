package org.telegram.ui.Stories;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;

import org.telegram.messenger.Utilities;
import org.telegram.tgnet.TLRPC;
import org.telegram.tgnet.tl.TL_stories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.telegram.messenger.MessageObject;
import org.telegram.ui.Stories.recorder.DraftsController;
import org.telegram.ui.Stories.recorder.StoryEntry;

public class StoriesController {

    public static final int STATE_READ = 0;
    public static final int STATE_UNREAD = 1;
    public static final int STATE_UNREAD_CLOSE_FRIEND = 2;
    public static final int STATE_LIVE = 3;

    public static final Comparator<TL_stories.StoryItem> storiesComparator = (a, b) -> 0;

    public final int currentAccount;
    public final LongSparseArray<Integer> dialogIdToMaxReadId = new LongSparseArray<>();
    public StoriesStorage storiesStorage;
    public int uploadedStories;
    public HashSet<Long> blocklist = new HashSet<>();
    public boolean blocklistFull;
    public List<TLRPC.InputPeer> sendAs = new ArrayList<>();
    public LongSparseArray<android.util.SparseArray<SelfStoryViewsPage.ViewsModel>> selfViewsModel = new LongSparseArray<>();
    public ArrayList<StoriesList> attachedSearchLists = new ArrayList<>();

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
    public void updateBlockUser(long id, boolean blocked) {}
    public void updateStoryReaction(long dialogId, int storyId, TLRPC.Reaction reaction) {}
    public void setStealthMode(TL_stories.TL_storiesStealthMode mode) {}
    public void updateStoriesFromFullPeer(long dialogId, TL_stories.PeerStories stories) {}
    public void putStories(long dialogId, TL_stories.PeerStories stories) {}
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
    public ArrayList<TL_stories.TL_peerStories> getHiddenList() { return new ArrayList<>(); }
    public ArrayList<TL_stories.TL_peerStories> getDialogListStories() { return new ArrayList<>(); }
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
    public void createAlbum(long dialogId, String name, Runnable callback) {}
    public void createAlbum(long dialogId, String name, java.util.function.Consumer<StoryAlbum> callback) {}
    public void removeAlbum(long dialogId, int albumId) {}
    public void renameAlbum(long dialogId, int albumId, String name) {}
    public String getAlbumName(long dialogId, int albumId) { return null; }
    public void deleteStories(long dialogId, ArrayList<TL_stories.StoryItem> storyItems) {}
    public void deleteStory(long dialogId, TL_stories.StoryItem storyItem) {}
    public StoriesList getStoriesList(long dialogId, int type) { return null; }
    public StoriesList getStoriesList(long dialogId, int type, int albumId) { return null; }
    public ArrayList<UploadingStory> getUploadingStories(long dialogId) { return new ArrayList<>(); }
    public void updateStoriesInLists(long dialogId, ArrayList<TL_stories.StoryItem> storyItems) {}
    public void updateStoriesPinned(long dialogId, ArrayList<TL_stories.StoryItem> storyItems, boolean pin, java.util.function.Consumer<Boolean> callback) {}
    public void toggleHidden(long dialogId, boolean hide, boolean request, boolean notify) {}
    public void removeContact(long dialogId) {}
    public void resolveStoryLink(long peerId, int storyId, Utilities.Callback<TL_stories.StoryItem> consumer) { if (consumer != null) consumer.run(null); }
    public void resolveStoryAlbumLink(long peerId, int albumId, Utilities.Callback<TL_stories.TL_storyAlbum> consumer) { if (consumer != null) consumer.run(null); }
    public void resolveLiveStoryLink(long peerId, Utilities.Callback<TL_stories.StoryItem> consumer) { if (consumer != null) consumer.run(null); }
    public void fillMessagesWithStories(ArrayList<Long> messages, Utilities.Callback<ArrayList<TL_stories.StoryItem>> callback) { if (callback != null) callback.run(new ArrayList<>()); }
    public void loadSendAs() {}
    public void pollViewsForSelfStories(long dialogId, int start) {}
    public void pollViewsForSelfStories(long dialogId, boolean start) {}
    public boolean isLoading(long dialogId) { return false; }
    public void setLoading(long dialogId, boolean loading) {}
    public TL_stories.PeerStories getStories(long dialogId) { return null; }
    public TL_stories.PeerStories getStoriesFromFullPeer(long dialogId) { return null; }
    public int hasUnreadStoriesLive(long dialogId) { return 0; }
    public boolean hasSelfStories() { return false; }
    public boolean hasUploadingStories(long dialogId) { return false; }
    public void loadNextStories(boolean hidden) {}
    public void checkExpiredStories() {}
    public void preloadUserStories(TL_stories.PeerStories stories) {}
    public boolean isLastUploadingFailed(long dialogId) { return false; }
    public TL_stories.StoryItem getEditingStory(long dialogId) { return null; }
    public ArrayList<UploadingStory> getUploadingAndEditingStories(long dialogId) { return new ArrayList<>(); }
    public void sortHiddenStories() {}
    public void uploadStory(StoryEntry entry, boolean asStory) {}
    public DraftsController getDraftsController() { return new DraftsController(currentAccount); }
    public boolean hasStoryLimit(int count) { return false; }
    public void loadBlocklistAtFirst() {}
    public void loadBlocklist(boolean force) {}
    public int getBlocklistCount() { return blocklist.size(); }
    public void scheduleSort() {}
    public int getMaxStoriesReadId(long dialogId) { return 0; }
    public void cancel() {}
    public static void closeGlobalInstances() {}
    public void updateBlockedUsers(HashSet<Long> users, Runnable callback) { if (callback != null) callback.run(); }
    public boolean canEditStories(TLRPC.Chat chat) { return false; }
    public void canSendStoryFor(long dialogId, Utilities.Callback<Boolean> callback, boolean param, Object resourcesProvider) { if (callback != null) callback.run(false); }
    public void fillMessagesWithStories(LongSparseArray<ArrayList<MessageObject>> messages, Runnable callback, int classGuid, Object logLogger) { if (callback != null) callback.run(); }
    public void putUploadingDrafts(ArrayList<StoryEntry> entries) {}
    public void setStoryReaction(long dialogId, TL_stories.StoryItem storyItem, Object reaction) {}
    public boolean canEditStory(TL_stories.StoryItem item) { return false; }
    public boolean canDeleteStory(TL_stories.StoryItem item) { return false; }
    public boolean canCreateNewAlbum(long dialogId) { return false; }
    public void loadSkippedStories(TL_stories.PeerStories stories, boolean value) {}
    public void loadSkippedStories(long dialogId) {}
    public boolean checkUnsupportedStory(long dialogId, int storyId) { return false; }
    public UploadingStory findEditingStory(long dialogId, TL_stories.StoryItem storyItem) { return null; }
    public boolean markStoryAsRead(TL_stories.PeerStories stories, TL_stories.StoryItem storyItem, boolean value) { return false; }
    public boolean markStoryAsRead(long dialogId, TL_stories.StoryItem storyItem) { return false; }
    public void updateStoryItem(long dialogId, TL_stories.StoryItem storyItem, boolean b1, boolean b2) {}
    public boolean isBlocked(TL_stories.StoryView view) { return false; }
    public void applyStoryViewsBlocked(TL_stories.StoryViewsList res) {}

    public static class StoryAlbum {
        public int id;
        public int album_id;
        public String title;
        public ArrayList<TL_stories.StoryItem> storyItems = new ArrayList<>();
        public int count;
        public boolean expanded;
        public TLRPC.Photo icon_photo;

        public StoryAlbum() {}
        public TL_stories.TL_storyAlbum toTl() { return null; }
        public static StoryAlbum from(TL_stories.TL_storyAlbum tl) { return new StoryAlbum(); }
    }

    public static class StoryLimit {
        public int type;
        public boolean active(int currentAccount) { return false; }
        public boolean active(int currentAccount, int count) { return false; }
        public int getLimitReachedType() { return 0; }
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
        public int albumId;
        public long dialogId;
        public final ArrayList<MessageObject> messageObjects = new ArrayList<>();
        public ArrayList<Integer> pinnedIds = new ArrayList<>();

        public StoriesList(int account, int type) { this.currentAccount = account; this.type = type; }
        public StoriesList(int account, int type, boolean b) { this(account, type); }
        public StoriesList(int account, int type, boolean b, boolean b1) { this(account, type); }

        public static long day(TL_stories.StoryItem item) { return 0; }
        public static long day(MessageObject msg) { return 0; }
        public boolean markAsRead(int storyId) { return false; }
        public MessageObject findMessageObject(long did) { return null; }
        public boolean isLoading() { return false; }
        public boolean isLoaded() { return false; }
        public boolean isFull() { return false; }
        public int getCount() { return 0; }
        public int getLoadedCount() { return 0; }
        public MessageObject get(int pos) { return null; }
        public boolean showPhotos() { return true; }
        public boolean showVideos() { return true; }
        public void updateFilters(boolean photos, boolean videos) {}
        public boolean isOnlyCache() { return false; }
        public int link() { return 0; }
        public void unlink(int id) {}
        public void updateStoryViews(ArrayList<Integer> ids, ArrayList<TL_stories.StoryViews> views) {}
        public boolean isPinned(int id) { return false; }
        public void load(boolean force, int count) {}
        public void load(boolean force) {}
        public void load(boolean force, int count, Object callback) {}
        public void cancel() {}
        public boolean updatePinned(ArrayList<Integer> ids, boolean pin) { return false; }
        public boolean load(java.util.List<Integer> ids) { return false; }
        public void updatePinnedOrder(ArrayList<Integer> ids, boolean pin) {}
        public void updatePinnedOrder(ArrayList<Integer> ids, boolean pin, Runnable callback) {}

        public static final Comparator<TL_stories.StoryItem> storiesComparator = (a, b) -> 0;
    }

    public static class SearchStoriesList extends StoriesList {
        public String query;
        public String username;
        public SearchStoriesList(int account) { super(account, TYPE_SEARCH); }
        public SearchStoriesList(int account, int type) { super(account, type); }
        public SearchStoriesList(int account, String username, String query) { super(account, TYPE_SEARCH); this.username = username; this.query = query; }
        public SearchStoriesList(int account, TL_stories.MediaArea area) { super(account, TYPE_SEARCH); }
    }

    public static class StoryRepostsList extends StoriesList {
        public StoryRepostsList(int account, ArrayList<TL_stories.StoryItem> items) { super(account, TYPE_PINNED); }
        public void append(ArrayList<TL_stories.StoryItem> items) {}
    }

    public static class BotPreviewsList extends StoriesList {
        public String lang_code;
        public ArrayList<String> lang_codes = new ArrayList<>();
        public BotPreviewsList(int account, long botId, String langCode, Boolean bool) { super(account, TYPE_BOTS); lang_code = langCode; }

        public void push(Object media) {}
        public void edit(TLRPC.InputMedia oldMedia, Object newMedia) {}
        public void notifyUpdate() {}
        public void delete(ArrayList<TLRPC.MessageMedia> medias) {}
        public void delete(TLRPC.MessageMedia media) {}
        public void requestReference(BotPreview storyItem, java.util.function.Consumer<TL_stories.StoryItem> callback) {}
        public void reload(Runnable callback) {}
    }

    public static class BotPreview extends TL_stories.StoryItem {
        public BotPreviewsList list;
    }

    public class UploadingStory {
        public TL_stories.StoryItem storyItem;
        public StoryEntry entry;
        public String firstFramePath;
        public String path;
        public MessageObject sharedMessageObject;
        public long random_id;
        public float progress;
        public boolean isVideo;
        public boolean canceled;
        public boolean failed;
        public boolean hadFailed;
        public boolean isCloseFriends() { return false; }
        public void cancel() {}
        public void tryAgain() {}
    }

    public class StoriesCollections {
        public long dialogId;
        public int currentAccount;
        public ArrayList<StoryAlbum> collections = new ArrayList<>();
        public void sendOrder() {}
        public boolean canCreateNewAlbum() { return false; }
        public int indexOf(int albumId) {
            for (int i = 0; i < collections.size(); i++) {
                if (collections.get(i).album_id == albumId) return i;
            }
            return -1;
        }
        public StoryAlbum findById(int id) {
            for (StoryAlbum a : collections) {
                if (a.album_id == id) return a;
            }
            return null;
        }
        public void reorderComplete(boolean b) {}
        public void reorderStep(ArrayList<Integer> ids) {}
    }
}
