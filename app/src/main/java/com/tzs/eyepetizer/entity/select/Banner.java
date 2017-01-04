package com.tzs.eyepetizer.entity.select;

import java.io.Serializable;

/**
 * Created by h on 2017/1/4.
 */

public class Banner extends SelectItem implements Serializable {

    /**
     * type : banner
     * data : {"dataType":"Banner","id":1,"title":"","description":null,"image":"http://img.kaiyanapp.com/411c5cee905f328a14d96096a163d331.jpeg?imageMogr2/quality/60","actionUrl":"eyepetizer://homepage/discovery/","adTrack":null,"shade":false,"label":null}
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
         * dataType : Banner
         * id : 1
         * title :
         * description : null
         * image : http://img.kaiyanapp.com/411c5cee905f328a14d96096a163d331.jpeg?imageMogr2/quality/60
         * actionUrl : eyepetizer://homepage/discovery/
         * adTrack : null
         * shade : false
         * label : null
         */

        private String dataType;
        private int id;
        private String title;
        private Object description;
        private String image;
        private String actionUrl;
        private Object adTrack;
        private boolean shade;
        private Object label;

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

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public boolean isShade() {
            return shade;
        }

        public void setShade(boolean shade) {
            this.shade = shade;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "dataType='" + dataType + '\'' +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", description=" + description +
                    ", image='" + image + '\'' +
                    ", actionUrl='" + actionUrl + '\'' +
                    ", adTrack=" + adTrack +
                    ", shade=" + shade +
                    ", label=" + label +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Banner{" + '\'' +
                ", data=" + data +
                '}';
    }
}
