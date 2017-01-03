package com.tzs.eyepetizer.entity.select;

import java.io.Serializable;

/**
 * Created by h on 2016/12/29.
 */

public class TextHeader extends SelectItem implements Serializable{

    /**
     * type : textHeader
     * data : {"dataType":"TextHeader","text":"- Dec. 28, Supper -","font":"lobster","adTrack":null}
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
         * dataType : TextHeader
         * text : - Dec. 28, Supper -
         * font : lobster
         * adTrack : null
         */

        private String dataType;
        private String text;
        private String font;
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
                    ", adTrack=" + adTrack +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TextHeader{" +
                "data=" + data +
                '}';
    }
}
