package com.tzs.eyepetizer.entity.select;

import java.io.Serializable;
import java.util.List;

/**
 * 视屏信息
 */

public class VideoBeanForClient extends SelectItem implements Serializable {

    /**
     * type : video
     * data : {"dataType":"VideoBeanForClient","id":11252,"title":"对抗失恋的 N 种方法","description":"这是泰国线上音乐与创作平台 Fungja 的广告之失恋篇。世界上所有的事物，都有保质期。丢掉过期的那个人，那些回忆，和孤单作战重新开始，也许一切都没有你想的那么糟。From 泰國清邁象","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"广告","author":null,"cover":{"feed":"http://img.kaiyanapp.com/40fb4f6be9a113ba6dee3e9953e33a41.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/40fb4f6be9a113ba6dee3e9953e33a41.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/7f62908b3624e5965115884ff627ae22.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11252&editionType=default","duration":186,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11252","forWeibo":"http://wandou.im/3eo8nm"},"releaseTime":1482973200000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11252&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11252&editionType=high"}],"consumption":{"collectionCount":837,"shareCount":783,"replyCount":27},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":108,"name":"爱情","actionUrl":"eyepetizer://tag/108/?title=%E7%88%B1%E6%83%85","adTrack":null},{"id":530,"name":"人生","actionUrl":"eyepetizer://tag/530/?title=%E4%BA%BA%E7%94%9F","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":386,"name":"泰国广告","actionUrl":"eyepetizer://tag/386/?title=%E6%B3%B0%E5%9B%BD%E5%B9%BF%E5%91%8A","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1482973200000,"promotion":null,"label":null,"collected":false,"played":false}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * dataType : VideoBeanForClient
         * id : 11252
         * title : 对抗失恋的 N 种方法
         * description : 这是泰国线上音乐与创作平台 Fungja 的广告之失恋篇。世界上所有的事物，都有保质期。丢掉过期的那个人，那些回忆，和孤单作战重新开始，也许一切都没有你想的那么糟。From 泰國清邁象
         * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"}
         * category : 广告
         * author : null
         * cover : {"feed":"http://img.kaiyanapp.com/40fb4f6be9a113ba6dee3e9953e33a41.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/40fb4f6be9a113ba6dee3e9953e33a41.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/7f62908b3624e5965115884ff627ae22.jpeg?imageMogr2/quality/60","sharing":null}
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11252&editionType=default
         * duration : 186
         * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=11252","forWeibo":"http://wandou.im/3eo8nm"}
         * releaseTime : 1482973200000
         * playInfo : [{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11252&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11252&editionType=high"}]
         * consumption : {"collectionCount":837,"shareCount":783,"replyCount":27}
         * campaign : null
         * waterMarks : null
         * adTrack : null
         * tags : [{"id":108,"name":"爱情","actionUrl":"eyepetizer://tag/108/?title=%E7%88%B1%E6%83%85","adTrack":null},{"id":530,"name":"人生","actionUrl":"eyepetizer://tag/530/?title=%E4%BA%BA%E7%94%9F","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":386,"name":"泰国广告","actionUrl":"eyepetizer://tag/386/?title=%E6%B3%B0%E5%9B%BD%E5%B9%BF%E5%91%8A","adTrack":null}]
         * type : NORMAL
         * idx : 0
         * shareAdTrack : null
         * favoriteAdTrack : null
         * webAdTrack : null
         * date : 1482973200000
         * promotion : null
         * label : null
         * collected : false
         * played : false
         */

        private String dataType;
        private int id;
        private String title;
        private String description;
        private ProviderBean provider;
        private String category;
        private Object author;
        private CoverBean cover;
        private String playUrl;
        private int duration;
        private WebUrlBean webUrl;
        private long releaseTime;
        private ConsumptionBean consumption;
        private Object campaign;
        private Object waterMarks;
        private Object adTrack;
        private String type;
        private int idx;
        private Object shareAdTrack;
        private Object favoriteAdTrack;
        private Object webAdTrack;
        private long date;
        private Object promotion;
        private Object label;
        private boolean collected;
        private boolean played;
        private List<PlayInfoBean> playInfo;
        private List<TagsBean> tags;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ProviderBean getProvider() {
            return provider;
        }

        public void setProvider(ProviderBean provider) {
            this.provider = provider;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Object getAuthor() {
            return author;
        }

        public void setAuthor(Object author) {
            this.author = author;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public WebUrlBean getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(WebUrlBean webUrl) {
            this.webUrl = webUrl;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public ConsumptionBean getConsumption() {
            return consumption;
        }

        public void setConsumption(ConsumptionBean consumption) {
            this.consumption = consumption;
        }

        public Object getCampaign() {
            return campaign;
        }

        public void setCampaign(Object campaign) {
            this.campaign = campaign;
        }

        public Object getWaterMarks() {
            return waterMarks;
        }

        public void setWaterMarks(Object waterMarks) {
            this.waterMarks = waterMarks;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public Object getShareAdTrack() {
            return shareAdTrack;
        }

        public void setShareAdTrack(Object shareAdTrack) {
            this.shareAdTrack = shareAdTrack;
        }

        public Object getFavoriteAdTrack() {
            return favoriteAdTrack;
        }

        public void setFavoriteAdTrack(Object favoriteAdTrack) {
            this.favoriteAdTrack = favoriteAdTrack;
        }

        public Object getWebAdTrack() {
            return webAdTrack;
        }

        public void setWebAdTrack(Object webAdTrack) {
            this.webAdTrack = webAdTrack;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public Object getPromotion() {
            return promotion;
        }

        public void setPromotion(Object promotion) {
            this.promotion = promotion;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public boolean isPlayed() {
            return played;
        }

        public void setPlayed(boolean played) {
            this.played = played;
        }

        public List<PlayInfoBean> getPlayInfo() {
            return playInfo;
        }

        public void setPlayInfo(List<PlayInfoBean> playInfo) {
            this.playInfo = playInfo;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class ProviderBean implements Serializable {
            /**
             * name : YouTube
             * alias : youtube
             * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
             */

            private String name;
            private String alias;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class CoverBean implements Serializable {
            /**
             * feed : http://img.kaiyanapp.com/40fb4f6be9a113ba6dee3e9953e33a41.jpeg?imageMogr2/quality/60
             * detail : http://img.kaiyanapp.com/40fb4f6be9a113ba6dee3e9953e33a41.jpeg?imageMogr2/quality/60
             * blurred : http://img.kaiyanapp.com/7f62908b3624e5965115884ff627ae22.jpeg?imageMogr2/quality/60
             * sharing : null
             */

            private String feed;
            private String detail;
            private String blurred;
            private Object sharing;

            public String getFeed() {
                return feed;
            }

            public void setFeed(String feed) {
                this.feed = feed;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getBlurred() {
                return blurred;
            }

            public void setBlurred(String blurred) {
                this.blurred = blurred;
            }

            public Object getSharing() {
                return sharing;
            }

            public void setSharing(Object sharing) {
                this.sharing = sharing;
            }
        }

        public static class WebUrlBean implements Serializable {
            /**
             * raw : http://www.eyepetizer.net/detail.html?vid=11252
             * forWeibo : http://wandou.im/3eo8nm
             */

            private String raw;
            private String forWeibo;

            public String getRaw() {
                return raw;
            }

            public void setRaw(String raw) {
                this.raw = raw;
            }

            public String getForWeibo() {
                return forWeibo;
            }

            public void setForWeibo(String forWeibo) {
                this.forWeibo = forWeibo;
            }
        }

        public static class ConsumptionBean implements Serializable {
            /**
             * collectionCount : 837
             * shareCount : 783
             * replyCount : 27
             */

            private int collectionCount;
            private int shareCount;
            private int replyCount;

            public int getCollectionCount() {
                return collectionCount;
            }

            public void setCollectionCount(int collectionCount) {
                this.collectionCount = collectionCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }
        }

        public static class PlayInfoBean implements Serializable {
            /**
             * height : 480
             * width : 854
             * name : 标清
             * type : normal
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11252&editionType=normal
             */

            private int height;
            private int width;
            private String name;
            private String type;
            private String url;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TagsBean implements Serializable {
            /**
             * id : 108
             * name : 爱情
             * actionUrl : eyepetizer://tag/108/?title=%E7%88%B1%E6%83%85
             * adTrack : null
             */

            private int id;
            private String name;
            private String actionUrl;
            private Object adTrack;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "dataType='" + dataType + '\'' +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", provider=" + provider +
                    ", category='" + category + '\'' +
                    ", author=" + author +
                    ", cover=" + cover +
                    ", playUrl='" + playUrl + '\'' +
                    ", duration=" + duration +
                    ", webUrl=" + webUrl +
                    ", releaseTime=" + releaseTime +
                    ", consumption=" + consumption +
                    ", campaign=" + campaign +
                    ", waterMarks=" + waterMarks +
                    ", adTrack=" + adTrack +
                    ", type='" + type + '\'' +
                    ", idx=" + idx +
                    ", shareAdTrack=" + shareAdTrack +
                    ", favoriteAdTrack=" + favoriteAdTrack +
                    ", webAdTrack=" + webAdTrack +
                    ", date=" + date +
                    ", promotion=" + promotion +
                    ", label=" + label +
                    ", collected=" + collected +
                    ", played=" + played +
                    ", playInfo=" + playInfo +
                    ", tags=" + tags +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VideoBeanForClient{" +
                "data=" + data +
                '}';
    }
}
