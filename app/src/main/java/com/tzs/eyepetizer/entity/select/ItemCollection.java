package com.tzs.eyepetizer.entity.select;

import java.io.Serializable;
import java.util.List;

/**
 * Created by h on 2016/12/29.
 */

public class ItemCollection extends SelectItem implements Serializable {

    /**
     * type : videoCollectionWithCover
     * data : {"dataType":"ItemCollection","header":{"id":107,"title":null,"font":"normal","cover":"http://img.kaiyanapp.com/207c0c401d940ceb42ac5f90a53e9325.jpegVideoBeanForClientimageMogr2/quality/60","label":{"text":null,"card":null,"detail":null},"actionUrl":"eyepetizer://webview/VideoBeanForClienttitle=%E7%BD%91%E6%98%93%E6%96%B0%E9%97%BB%E5%B9%B4%E5%BA%A6%E6%80%81%E5%BA%A6%EF%BC%9A%E8%B6%8A%E5%AD%A4%E7%8B%AC%EF%BC%8C%E8%B6%8A%E7%83%AD%E9%97%B9&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D107%26shareable%3Dtrue"},"itemList":[],"count":4,"adTrack":null}
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
         * dataType : ItemCollection
         * header : {"id":107,"title":null,"font":"normal","cover":"http://img.kaiyanapp.com/207c0c401d940ceb42ac5f90a53e9325.jpegVideoBeanForClientimageMogr2/quality/60","label":{"text":null,"card":null,"detail":null},"actionUrl":"eyepetizer://webview/VideoBeanForClienttitle=%E7%BD%91%E6%98%93%E6%96%B0%E9%97%BB%E5%B9%B4%E5%BA%A6%E6%80%81%E5%BA%A6%EF%BC%9A%E8%B6%8A%E5%AD%A4%E7%8B%AC%EF%BC%8C%E8%B6%8A%E7%83%AD%E9%97%B9&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D107%26shareable%3Dtrue"}
         * itemList : []
         * count : 4
         * adTrack : null
         */

        private String dataType;
        private HeaderBean header;
        private int count;
        private Object adTrack;
        private List<VideoBeanForClient> itemList;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public List<VideoBeanForClient> getItemList() {
            return itemList;
        }

        public void setItemList(List<VideoBeanForClient> itemList) {
            this.itemList = itemList;
        }

        public static class HeaderBean implements Serializable {
            /**
             * id : 107
             * title : null
             * font : normal
             * cover : http://img.kaiyanapp.com/207c0c401d940ceb42ac5f90a53e9325.jpegVideoBeanForClientimageMogr2/quality/60
             * label : {"text":null,"card":null,"detail":null}
             * actionUrl : eyepetizer://webview/VideoBeanForClienttitle=%E7%BD%91%E6%98%93%E6%96%B0%E9%97%BB%E5%B9%B4%E5%BA%A6%E6%80%81%E5%BA%A6%EF%BC%9A%E8%B6%8A%E5%AD%A4%E7%8B%AC%EF%BC%8C%E8%B6%8A%E7%83%AD%E9%97%B9&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D107%26shareable%3Dtrue
             */

            private int id;
            private String title;
            private String font;
            private String cover;
            private LabelBean label;
            private String actionUrl;
            private String icon;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public List<String> getIconList() {
                return iconList;
            }

            public void setIconList(List<String> iconList) {
                this.iconList = iconList;
            }

            private String description;
            private List<String> iconList;

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

            public String getFont() {
                return font;
            }

            public void setFont(String font) {
                this.font = font;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public LabelBean getLabel() {
                return label;
            }

            public void setLabel(LabelBean label) {
                this.label = label;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public static class LabelBean implements Serializable {
                /**
                 * text : null
                 * card : null
                 * detail : null
                 */

                private Object text;
                private Object card;
                private Object detail;

                public Object getText() {
                    return text;
                }

                public void setText(Object text) {
                    this.text = text;
                }

                public Object getCard() {
                    return card;
                }

                public void setCard(Object card) {
                    this.card = card;
                }

                public Object getDetail() {
                    return detail;
                }

                public void setDetail(Object detail) {
                    this.detail = detail;
                }

                @Override
                public String toString() {
                    return "LabelBean{" +
                            "text=" + text +
                            ", card=" + card +
                            ", detail=" + detail +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "HeaderBean{" +
                        "id=" + id +
                        ", title=" + title +
                        ", font='" + font + '\'' +
                        ", cover='" + cover + '\'' +
                        ", label=" + label +
                        ", actionUrl='" + actionUrl + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "dataType='" + dataType + '\'' +
                    ", header=" + header +
                    ", count=" + count +
                    ", adTrack=" + adTrack +
                    ", itemList=" + itemList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "\nItemCollection{" +
                "type='" + '\'' +
                ", data=" + data +
                '}';
    }
}
