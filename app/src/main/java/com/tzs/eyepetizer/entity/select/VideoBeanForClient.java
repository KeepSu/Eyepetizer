package com.tzs.eyepetizer.entity.select;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 视屏信息
 */

public class VideoBeanForClient extends SelectItem implements Serializable {

    /**
     * data : {"dataType":"VideoBeanForClient","id":11956,"title":"4 款暗黑系方便面大测评","description":"香菜料理，国际大品牌，果然不一般。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"生活","author":{"id":82,"icon":"http://img.kaiyanapp.com/831c82506f6f1abfb4dc0745c0e6784f.png","name":"微在涨姿势","description":"国内首个生产神技能的原创视频基地；擅长脑洞大开，盛产闻所未闻。一日一姿势\u2014\u2014有知识，才性感。","link":"","latestReleaseTime":1483424391000,"videoNum":94,"adTrack":null,"follow":{"itemType":"author","itemId":82,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/a8933d70321c7b69f02945853d2eaa58.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/a8933d70321c7b69f02945853d2eaa58.jpeg?imageMogr2/quality/60","blurred":"s","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11956&editionType=default","duration":289,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11956","forWeibo":"http://wandou.im/3jxp1h"},"releaseTime":1482637288000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11956&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11956&editionType=high"}],"consumption":{"collectionCount":47,"shareCount":75,"replyCount":7},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null},{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null},{"id":36,"name":"集锦","actionUrl":"eyepetizer://tag/36/?title=%E9%9B%86%E9%94%A6","adTrack":null},{"id":28,"name":"综艺","actionUrl":"eyepetizer://tag/28/?title=%E7%BB%BC%E8%89%BA","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1483491600000,"promotion":null,"label":null,"collected":false,"played":false}
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
         * id : 11956
         * title : 4 款暗黑系方便面大测评
         * description : 香菜料理，国际大品牌，果然不一般。
         * provider : {"name":"PGC","alias":"PGC","icon":""}
         * category : 生活
         * author : {"id":82,"icon":"http://img.kaiyanapp.com/831c82506f6f1abfb4dc0745c0e6784f.png","name":"微在涨姿势","description":"国内首个生产神技能的原创视频基地；擅长脑洞大开，盛产闻所未闻。一日一姿势\u2014\u2014有知识，才性感。","link":"","latestReleaseTime":1483424391000,"videoNum":94,"adTrack":null,"follow":{"itemType":"author","itemId":82,"followed":false}}
         * cover : {"feed":"http://img.kaiyanapp.com/a8933d70321c7b69f02945853d2eaa58.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/a8933d70321c7b69f02945853d2eaa58.jpeg?imageMogr2/quality/60","blurred":"s","sharing":null}
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11956&editionType=default
         * duration : 289
         * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=11956","forWeibo":"http://wandou.im/3jxp1h"}
         * releaseTime : 1482637288000
         * playInfo : [{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11956&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11956&editionType=high"}]
         * consumption : {"collectionCount":47,"shareCount":75,"replyCount":7}
         * campaign : null
         * waterMarks : null
         * adTrack : null
         * tags : [{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null},{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null},{"id":36,"name":"集锦","actionUrl":"eyepetizer://tag/36/?title=%E9%9B%86%E9%94%A6","adTrack":null},{"id":28,"name":"综艺","actionUrl":"eyepetizer://tag/28/?title=%E7%BB%BC%E8%89%BA","adTrack":null}]
         * type : NORMAL
         * idx : 0
         * shareAdTrack : null
         * favoriteAdTrack : null
         * webAdTrack : null
         * date : 1483491600000
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
        private AuthorBean author;
        private CoverBean cover;
        private String playUrl;
        private int duration;
        private WebUrlBean webUrl;
        private long releaseTime;
        private ConsumptionBean consumption;
        private Object campaign;
        private Object waterMarks;
        private Object adTrack;
        @SerializedName("type")
        private String typeX;
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

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
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

        public String getTypeX() {
            return typeX;
        }

        public void setTypeX(String typeX) {
            this.typeX = typeX;
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
             * name : PGC
             * alias : PGC
             * icon :
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

        public static class AuthorBean implements Serializable {
            /**
             * id : 82
             * icon : http://img.kaiyanapp.com/831c82506f6f1abfb4dc0745c0e6784f.png
             * name : 微在涨姿势
             * description : 国内首个生产神技能的原创视频基地；擅长脑洞大开，盛产闻所未闻。一日一姿势——有知识，才性感。
             * link :
             * latestReleaseTime : 1483424391000
             * videoNum : 94
             * adTrack : null
             * follow : {"itemType":"author","itemId":82,"followed":false}
             */

            private int id;
            private String icon;
            private String name;
            private String description;
            private String link;
            private long latestReleaseTime;
            private int videoNum;
            private Object adTrack;
            private FollowBean follow;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public long getLatestReleaseTime() {
                return latestReleaseTime;
            }

            public void setLatestReleaseTime(long latestReleaseTime) {
                this.latestReleaseTime = latestReleaseTime;
            }

            public int getVideoNum() {
                return videoNum;
            }

            public void setVideoNum(int videoNum) {
                this.videoNum = videoNum;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public FollowBean getFollow() {
                return follow;
            }

            public void setFollow(FollowBean follow) {
                this.follow = follow;
            }

            public static class FollowBean implements Serializable {
                /**
                 * itemType : author
                 * itemId : 82
                 * followed : false
                 */

                private String itemType;
                private int itemId;
                private boolean followed;

                public String getItemType() {
                    return itemType;
                }

                public void setItemType(String itemType) {
                    this.itemType = itemType;
                }

                public int getItemId() {
                    return itemId;
                }

                public void setItemId(int itemId) {
                    this.itemId = itemId;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }

                @Override
                public String toString() {
                    return "FollowBean{" +
                            "itemType='" + itemType + '\'' +
                            ", itemId=" + itemId +
                            ", followed=" + followed +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "AuthorBean{" +
                        "id=" + id +
                        ", icon='" + icon + '\'' +
                        ", name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        ", link='" + link + '\'' +
                        ", latestReleaseTime=" + latestReleaseTime +
                        ", videoNum=" + videoNum +
                        ", adTrack=" + adTrack +
                        ", follow=" + follow +
                        '}';
            }
        }

        public static class CoverBean implements Serializable {
            /**
             * feed : http://img.kaiyanapp.com/a8933d70321c7b69f02945853d2eaa58.jpeg?imageMogr2/quality/60
             * detail : http://img.kaiyanapp.com/a8933d70321c7b69f02945853d2eaa58.jpeg?imageMogr2/quality/60
             * blurred : s
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

            @Override
            public String toString() {
                return "CoverBean{" +
                        "feed='" + feed + '\'' +
                        ", detail='" + detail + '\'' +
                        ", blurred='" + blurred + '\'' +
                        ", sharing=" + sharing +
                        '}';
            }
        }

        public static class WebUrlBean implements Serializable {
            /**
             * raw : http://www.eyepetizer.net/detail.html?vid=11956
             * forWeibo : http://wandou.im/3jxp1h
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

            @Override
            public String toString() {
                return "WebUrlBean{" +
                        "raw='" + raw + '\'' +
                        ", forWeibo='" + forWeibo + '\'' +
                        '}';
            }
        }

        public static class ConsumptionBean implements Serializable {
            /**
             * collectionCount : 47
             * shareCount : 75
             * replyCount : 7
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

            @Override
            public String toString() {
                return "ConsumptionBean{" +
                        "collectionCount=" + collectionCount +
                        ", shareCount=" + shareCount +
                        ", replyCount=" + replyCount +
                        '}';
            }
        }

        public static class PlayInfoBean implements Serializable {
            /**
             * height : 480
             * width : 854
             * name : 标清
             * type : normal
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11956&editionType=normal
             */

            private int height;
            private int width;
            private String name;
            @SerializedName("type")
            private String typeX;
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

            public String getTypeX() {
                return typeX;
            }

            public void setTypeX(String typeX) {
                this.typeX = typeX;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "PlayInfoBean{" +
                        "height=" + height +
                        ", width=" + width +
                        ", name='" + name + '\'' +
                        ", typeX='" + typeX + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        public static class TagsBean implements Serializable {
            /**
             * id : 666
             * name : 生活
             * actionUrl : eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB
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

            @Override
            public String toString() {
                return "TagsBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", actionUrl='" + actionUrl + '\'' +
                        ", adTrack=" + adTrack +
                        '}';
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
                    ", typeX='" + typeX + '\'' +
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
