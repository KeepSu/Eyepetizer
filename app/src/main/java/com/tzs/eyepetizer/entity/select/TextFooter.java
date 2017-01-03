package com.tzs.eyepetizer.entity.select;

import java.io.Serializable;

/**
 * Created by h on 2016/12/29.
 */

public class TextFooter extends SelectItem implements Serializable{

    /**
     * type : textFooter
     * data : {"dataType":"TextFooter","text":"查看往期编辑精选","font":"normal","actionUrl":"eyepetizer://feed?issueIndex=1","adTrack":null}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * dataType : TextFooter
         * text : 查看往期编辑精选
         * font : normal
         * actionUrl : eyepetizer://feed?issueIndex=1
         * adTrack : null
         */

        private String dataType;
        private String text;
        private String font;
        private String actionUrl;
        private Object adTrack;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFont() {
            return font;
        }

        public void setFont(String font) {
            this.font = font;
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
            return "DataBean{" +
                    "dataType='" + dataType + '\'' +
                    ", text='" + text + '\'' +
                    ", font='" + font + '\'' +
                    ", actionUrl='" + actionUrl + '\'' +
                    ", adTrack=" + adTrack +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TextFooter{" +
                "data=" + data +
                '}';
    }
}
