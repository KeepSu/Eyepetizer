package com.tzs.eyepetizer.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 关注页面作者详情实体类
 */
public class AuthorDetail implements Serializable{

    @Override
    public String toString() {
        return "AuthorDetail{" +
                "count=" + count +
                ", total=" + total +
                ", nextPageUrl='" + nextPageUrl + '\'' +
                ", pgcInfo=" + pgcInfo +
                ", itemList=" + itemList +
                '}';
    }

    /**
     * itemList : [{"type":"video","data":{"dataType":"VideoBeanForClient","id":12094,"title":"Omelette 煎蛋卷","description":"Omelet，西式煎蛋卷。睡眼惺忪，披着睡袍，把喜欢的（冰箱里有的）食材切碎，和蛋一起滚平底锅，嫩滑的蛋饼温柔地包裹食材，一口咬下去，你中有我我中有你。怎么搞定这个厉害的蛋呢！企鹅教你做！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"开胃","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/8c28f96127e8cb09536892605729d151.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/8c28f96127e8cb09536892605729d151.jpeg?imageMogr2/quality/60","blurred":"1","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=default","duration":98,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=12094","forWeibo":"http://wandou.im/3kto5r"},"releaseTime":1482932007000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=high"}],"consumption":{"collectionCount":425,"shareCount":131,"replyCount":3},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1482932007000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11942,"title":"这杯热红酒下肚 看谁都美","description":"天寒地冻的时候，最想一杯热红酒。钻进酒吧，肉桂、丁香和酒精扑鼻而来，馥郁浓烈；手里捂着满满一杯，喝一大口，滚热落胃，从舌头一直暖到胃里。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"开胃","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/70627e6633d9a3eb6d9cfb61023202ad.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/70627e6633d9a3eb6d9cfb61023202ad.jpeg?imageMogr2/quality/60","blurred":"","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11942&editionType=default","duration":65,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11942","forWeibo":"http://wandou.im/3jkgsw"},"releaseTime":1482492175000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11942&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11942&editionType=high"}],"consumption":{"collectionCount":1176,"shareCount":795,"replyCount":12},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":136,"name":"温情","actionUrl":"eyepetizer://tag/136/?title=%E6%B8%A9%E6%83%85","adTrack":null},{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null},{"id":254,"name":"饮品","actionUrl":"eyepetizer://tag/254/?title=%E9%A5%AE%E5%93%81","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1482492175000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11901,"title":"企鹅教你做 |DRINKS-热巧克力","description":"冷天的午后，没有什么比窝在沙发上喝一杯热巧克力更温暖而简单的快乐。企鹅君今天把最简单，最直接的热巧克力带给你。没有浮夸的装饰，厚重的奶油喧宾夺主，口感仍然是一流的。配上巧克力酱蘸草莓，温暖到不想说话。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"开胃","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/c9a86c0a034ef18a81a5aacfc3c2a0fb.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/c9a86c0a034ef18a81a5aacfc3c2a0fb.jpeg?imageMogr2/quality/60","blurred":"","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11901&editionType=default","duration":77,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11901","forWeibo":"http://wandou.im/3jawsq"},"releaseTime":1482396316000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11901&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11901&editionType=high"}],"consumption":{"collectionCount":1441,"shareCount":455,"replyCount":3},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null},{"id":254,"name":"饮品","actionUrl":"eyepetizer://tag/254/?title=%E9%A5%AE%E5%93%81","adTrack":null},{"id":136,"name":"温情","actionUrl":"eyepetizer://tag/136/?title=%E6%B8%A9%E6%83%85","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1482396316000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11712,"title":"企鹅教你做 |FOODIES-北非蛋","description":"没什么胃口，就该吃点酸酸的、开胃的东西，配合点淀粉下肚，一顿饭的时间，你就好了。啊，听起来，番茄炒蛋盖饭还挺合适的？其实，番茄和蛋，还可以烧出风靡欧美的Brunch\u201c解醉神器\u201d，Shakshuka。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"开胃","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/4db5de9485d7eb5be7369bff43334a59.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/4db5de9485d7eb5be7369bff43334a59.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/20f64554ec49aad9dd561566128d25b4.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11712&editionType=default","duration":91,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11712","forWeibo":"http://wandou.im/3i3jso"},"releaseTime":1481871316000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11712&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11712&editionType=high"}],"consumption":{"collectionCount":280,"shareCount":61,"replyCount":4},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481871316000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11690,"title":"企鹅爱测评：线下测评特辑","description":"贵的就是好的？企鹅愿意和你一起来探索！这一次，企鹅君邀请了粉丝们来线下测评！ 在盲品对比了两种巧克力、葡萄酒、西班牙火腿、啤酒、咖啡之后，结果是....?","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"开胃","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/3154b612eaf86aff99c8c09f95bb9dcb.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/3154b612eaf86aff99c8c09f95bb9dcb.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/1ab28a3e6ef9d812f2e0add607114b4a.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11690&editionType=default","duration":224,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11690","forWeibo":"http://wandou.im/3hxfbw"},"releaseTime":1481791388000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11690&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11690&editionType=high"}],"consumption":{"collectionCount":183,"shareCount":125,"replyCount":5},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":170,"name":"幽默","actionUrl":"eyepetizer://tag/170/?title=%E5%B9%BD%E9%BB%98","adTrack":null},{"id":28,"name":"综艺","actionUrl":"eyepetizer://tag/28/?title=%E7%BB%BC%E8%89%BA","adTrack":null},{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481791388000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11422,"title":"哈利波特的黄油啤酒，这个冬天不太冷","description":"我知道你一直在好奇，黄油啤酒到底是什么味道看完今天的视频，你就可以在家变出一杯颜值高又好喝的黄油啤酒，犒劳自己、招待小伙伴啦！ 我们希望，这款曾经温暖过哈利波特的酒，也能在这个冬天，温暖你的心和胃。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"开胃","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/fac0b909cbb9efa3734e15fce2acf2ec.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/fac0b909cbb9efa3734e15fce2acf2ec.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/dd2b6e41d18c1895f7d735b0fc7b72f5.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11422&editionType=default","duration":84,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11422","forWeibo":"http://wandou.im/3g2wqx"},"releaseTime":1480933982000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11422&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11422&editionType=high"}],"consumption":{"collectionCount":1103,"shareCount":694,"replyCount":30},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null},{"id":246,"name":"甜点","actionUrl":"eyepetizer://tag/246/?title=%E7%94%9C%E7%82%B9","adTrack":null},{"id":570,"name":"电影相关","actionUrl":"eyepetizer://tag/570/?title=%E7%94%B5%E5%BD%B1%E7%9B%B8%E5%85%B3","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1480933982000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11215,"title":"魔杖一挥：\u201c黄油啤酒，飞来！\u201d","description":"我们邀请了 10 位忠实哈迷（麻瓜，哦不，麻鸡），边吃边聊，共同回味魔法世界。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"综艺","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/cac5323336630eb84b2f171695a5d651.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/cac5323336630eb84b2f171695a5d651.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/f094208a9276e9c7f29c83b4804eca3e.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11215&editionType=default","duration":375,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11215","forWeibo":"http://wandou.im/3ea0hu"},"releaseTime":1480134031000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11215&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11215&editionType=high"}],"consumption":{"collectionCount":142,"shareCount":133,"replyCount":13},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1480134031000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11195,"title":"企鹅爱测评|高脚杯喝可乐会更好喝吗？","description":"饮料好不好喝，七分看饮料，三分看杯具。用高脚杯喝其他饮料会\u201c感觉\u201d更好喝吗？\n可乐杯里的可乐好喝，还是高脚杯里的可乐好喝？\n啤酒杯里的啤酒好喝，还是高脚杯里的啤酒好喝？\n用水杯喝酒，会有什么后果？\n","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"搞笑","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/c58bcbcdd4283ae13b852d63b2b8efe9.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/c58bcbcdd4283ae13b852d63b2b8efe9.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/1b3085ae47e15e732efdebcdd00de6b6.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11195&editionType=default","duration":281,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11195","forWeibo":"http://wandou.im/3e32bv"},"releaseTime":1480046880000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11195&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11195&editionType=high"}],"consumption":{"collectionCount":99,"shareCount":126,"replyCount":3},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1480046880000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11088,"title":"洋气指数超高的「班尼迪克蛋」","description":"周末的上午，就该美美的睡一觉，煮杯咖啡，阳台上一坐，笃笃定定地吃个 brunch。花个十来分钟，麦芬微焦，蔬菜水灵，培根滋滋，蛋还没坐稳，一勺酱汁铺铺满，温柔地激活你的一天。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"开胃","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/a353f027237a9e242f047746db480aee.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/a353f027237a9e242f047746db480aee.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/5e03da44c491e83b4a23b0b5b83be90b.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11088&editionType=default","duration":148,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11088","forWeibo":"http://wandou.im/3dajj7"},"releaseTime":1479700969000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11088&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11088&editionType=high"}],"consumption":{"collectionCount":1305,"shareCount":573,"replyCount":20},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null},{"id":240,"name":"西餐","actionUrl":"eyepetizer://tag/240/?title=%E8%A5%BF%E9%A4%90","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1479700969000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":10993,"title":"企鹅爱测评 | 大闸蟹盲品测评","description":"大闸蟹不止阳澄湖。那么，盛名在外的阳澄湖，还有近年来风头正劲的太湖蟹，和洪泽湖蟹相比，哪种更好吃？秉持企鹅测评公正公平的一贯原则，我们邀请了4组嘉宾进行盲测：不知道产地的情况下，这些蟹到底谁最好吃？","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"生活","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/0b25abaf0b54c0fd1aad71816c296af2.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/0b25abaf0b54c0fd1aad71816c296af2.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/4fee32902e024c6d4b4108639de4b379.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10993&editionType=default","duration":333,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=10993","forWeibo":"http://wandou.im/3cgpye"},"releaseTime":1479367080000,"playInfo":[{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10993&editionType=high"}],"consumption":{"collectionCount":199,"shareCount":316,"replyCount":17},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null},{"id":242,"name":"中餐","actionUrl":"eyepetizer://tag/242/?title=%E4%B8%AD%E9%A4%90","adTrack":null},{"id":28,"name":"综艺","actionUrl":"eyepetizer://tag/28/?title=%E7%BB%BC%E8%89%BA","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1479367080000,"promotion":null,"label":null,"collected":false,"played":false}}]
     * count : 10
     * total : 0
     * nextPageUrl : http://baobab.kaiyanapp.com/api/v3/pgc/videos?start=10&num=10&pgcId=176&strategy=date
     * pgcInfo : {"dataType":"PgcInfo","id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","brief":"37 个视频  /  43546 次收藏  /  42098 次分享","description":"你身边最懂吃喝的好朋友","actionUrl":"eyepetizer://pgc/detail/176/?title=%E4%BC%81%E9%B9%85%E5%90%83%E5%96%9D%E6%8C%87%E5%8D%97","follow":{"itemType":"author","itemId":176,"followed":false}}
     */

    private int count;
    private int total;
    private String nextPageUrl;
    private PgcInfoBean pgcInfo;
    private List<ItemListBean> itemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public PgcInfoBean getPgcInfo() {
        return pgcInfo;
    }

    public void setPgcInfo(PgcInfoBean pgcInfo) {
        this.pgcInfo = pgcInfo;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class PgcInfoBean implements Serializable{
        @Override
        public String toString() {
            return "PgcInfoBean{" +
                    "actionUrl='" + actionUrl + '\'' +
                    ", dataType='" + dataType + '\'' +
                    ", id=" + id +
                    ", icon='" + icon + '\'' +
                    ", name='" + name + '\'' +
                    ", brief='" + brief + '\'' +
                    ", description='" + description + '\'' +
                    ", follow=" + follow +
                    '}';
        }

        /**
         * dataType : PgcInfo
         * id : 176
         * icon : http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg
         * name : 企鹅吃喝指南
         * brief : 37 个视频  /  43546 次收藏  /  42098 次分享
         * description : 你身边最懂吃喝的好朋友
         * actionUrl : eyepetizer://pgc/detail/176/?title=%E4%BC%81%E9%B9%85%E5%90%83%E5%96%9D%E6%8C%87%E5%8D%97
         * follow : {"itemType":"author","itemId":176,"followed":false}
         */

        private String dataType;
        private int id;
        private String icon;
        private String name;
        private String brief;
        private String description;
        private String actionUrl;
        private FollowBean follow;

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

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public FollowBean getFollow() {
            return follow;
        }

        public void setFollow(FollowBean follow) {
            this.follow = follow;
        }

        public static class FollowBean implements Serializable{
            @Override
            public String toString() {
                return "FollowBean{" +
                        "followed=" + followed +
                        ", itemType='" + itemType + '\'' +
                        ", itemId=" + itemId +
                        '}';
            }

            /**
             * itemType : author
             * itemId : 176
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
        }
    }

    public static class ItemListBean implements Serializable{
        @Override
        public String toString() {
            return "ItemListBean{" +
                    "data=" + data +
                    ", type='" + type + '\'' +
                    '}';
        }

        /**
         * type : video
         * data : {"dataType":"VideoBeanForClient","id":12094,"title":"Omelette 煎蛋卷","description":"Omelet，西式煎蛋卷。睡眼惺忪，披着睡袍，把喜欢的（冰箱里有的）食材切碎，和蛋一起滚平底锅，嫩滑的蛋饼温柔地包裹食材，一口咬下去，你中有我我中有你。怎么搞定这个厉害的蛋呢！企鹅教你做！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"开胃","author":{"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/8c28f96127e8cb09536892605729d151.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/8c28f96127e8cb09536892605729d151.jpeg?imageMogr2/quality/60","blurred":"1","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=default","duration":98,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=12094","forWeibo":"http://wandou.im/3kto5r"},"releaseTime":1482932007000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=high"}],"consumption":{"collectionCount":425,"shareCount":131,"replyCount":3},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1482932007000,"promotion":null,"label":null,"collected":false,"played":false}
         */

        private String type;
        private DataBean data;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean implements Serializable{
            @Override
            public String toString() {
                return "DataBean{" +
                        "adTrack=" + adTrack +
                        ", dataType='" + dataType + '\'' +
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

            /**
             * dataType : VideoBeanForClient
             * id : 12094
             * title : Omelette 煎蛋卷
             * description : Omelet，西式煎蛋卷。睡眼惺忪，披着睡袍，把喜欢的（冰箱里有的）食材切碎，和蛋一起滚平底锅，嫩滑的蛋饼温柔地包裹食材，一口咬下去，你中有我我中有你。怎么搞定这个厉害的蛋呢！企鹅教你做！
             * provider : {"name":"PGC","alias":"PGC","icon":""}
             * category : 开胃
             * author : {"id":176,"icon":"http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg","name":"企鹅吃喝指南","description":"你身边最懂吃喝的好朋友","link":"","latestReleaseTime":1482932007000,"videoNum":37,"adTrack":null,"follow":{"itemType":"author","itemId":176,"followed":false}}
             * cover : {"feed":"http://img.kaiyanapp.com/8c28f96127e8cb09536892605729d151.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/8c28f96127e8cb09536892605729d151.jpeg?imageMogr2/quality/60","blurred":"1","sharing":null}
             * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=default
             * duration : 98
             * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=12094","forWeibo":"http://wandou.im/3kto5r"}
             * releaseTime : 1482932007000
             * playInfo : [{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=high"}]
             * consumption : {"collectionCount":425,"shareCount":131,"replyCount":3}
             * campaign : null
             * waterMarks : null
             * adTrack : null
             * tags : []
             * type : NORMAL
             * idx : 0
             * shareAdTrack : null
             * favoriteAdTrack : null
             * webAdTrack : null
             * date : 1482932007000
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
            private List<?> tags;

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

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }

            public static class ProviderBean implements Serializable{
                @Override
                public String toString() {
                    return "ProviderBean{" +
                            "alias='" + alias + '\'' +
                            ", name='" + name + '\'' +
                            ", icon='" + icon + '\'' +
                            '}';
                }

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

            public static class AuthorBean implements Serializable{

                @Override
                public String toString() {
                    return "AuthorBean{" +
                            "adTrack=" + adTrack +
                            ", id=" + id +
                            ", icon='" + icon + '\'' +
                            ", name='" + name + '\'' +
                            ", description='" + description + '\'' +
                            ", link='" + link + '\'' +
                            ", latestReleaseTime=" + latestReleaseTime +
                            ", videoNum=" + videoNum +
                            ", follow=" + follow +
                            '}';
                }

                /**
                 * id : 176
                 * icon : http://img.kaiyanapp.com/c2e2a3647e1d62a7f383f9ab25d08f8d.jpeg
                 * name : 企鹅吃喝指南
                 * description : 你身边最懂吃喝的好朋友
                 * link :
                 * latestReleaseTime : 1482932007000
                 * videoNum : 37
                 * adTrack : null
                 * follow : {"itemType":"author","itemId":176,"followed":false}
                 */

                private int id;
                private String icon;
                private String name;
                private String description;
                private String link;
                private long latestReleaseTime;
                private int videoNum;
                private Object adTrack;
                private FollowBeanX follow;

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

                public FollowBeanX getFollow() {
                    return follow;
                }

                public void setFollow(FollowBeanX follow) {
                    this.follow = follow;
                }

                public static class FollowBeanX implements Serializable{
                    /**
                     * itemType : author
                     * itemId : 176
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
                }
            }

            public static class CoverBean implements Serializable{
                /**
                 * feed : http://img.kaiyanapp.com/8c28f96127e8cb09536892605729d151.jpeg?imageMogr2/quality/60
                 * detail : http://img.kaiyanapp.com/8c28f96127e8cb09536892605729d151.jpeg?imageMogr2/quality/60
                 * blurred : 1
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

            public static class WebUrlBean implements Serializable{
                /**
                 * raw : http://www.eyepetizer.net/detail.html?vid=12094
                 * forWeibo : http://wandou.im/3kto5r
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

            public static class ConsumptionBean implements Serializable{
                /**
                 * collectionCount : 425
                 * shareCount : 131
                 * replyCount : 3
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

            public static class PlayInfoBean implements Serializable{
                /**
                 * height : 480
                 * width : 854
                 * name : 标清
                 * type : normal
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=12094&editionType=normal
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
        }
    }
}
