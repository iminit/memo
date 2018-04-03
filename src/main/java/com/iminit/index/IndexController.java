package com.iminit.index;

import com.iminit.common.model.Num;
import com.iminit.common.model.WordSentence;
import com.iminit.word.WordService;
import com.jfinal.core.Controller;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import com.xiaoleilu.hutool.date.DateTime;
import com.xiaoleilu.hutool.date.DateUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * IndexController
 */
public class IndexController extends Controller {

    private static final Log log = Log.getLog(IndexController.class);

    static WordService wordService = WordService.me;
    static WordSentence wordSentenceDao = WordSentence.dao;

    public void index() {
    }

    /**
     * 阅读测试
     */
    public void read() {

    }

    /**
     * 组词游戏
     */
    public void word() {
    }

    /**
     * 组词数据
     */
    public void words() {
        Integer n = getParaToInt(0, 2);
        renderJson(wordService.findNByRandom(n));
    }

    /**
     * 数字关键词
     */
    public void nums() {
        List<Num> nums = Num.dao.find("select `num`,`name`,`desc` from num order by id");
        renderJson(nums);
    }

    /**
     * 组词数据
     */
    public void wordsSave() {
        String words = getPara();
        if (StrKit.isBlank(words)) {
            renderJson();
        } else {
            try {
                words = URLDecoder.decode(words, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            int[] ints = wordService.wordsSave(words);
            renderJson(ints);
        }
    }

    /**
     * 组词保存到数据库
     */
    public void wordsSentenceSave() {
        try {
            WordSentence model = getModel(WordSentence.class, "");
            boolean save = model.save();
            renderJson(Kv.by("c", save));
        } catch (Exception e) {
            e.printStackTrace();
            renderJson(Kv.by("c", "no").set("error", e.getMessage()));
        }
    }

    /**
     * 历史组词记录
     */
    public void wordsSentenceList() {
        String word = getPara();
        if (StrKit.isBlank(word)) {
            renderJson(wordSentenceDao.find());
        } else {
            try {
                word = URLDecoder.decode(word, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String[] ids = wordService.getIdByWord(word);
            String id = "";
            if (ids.length > 0) {
                id = ids[0];
            }
            renderJson(wordSentenceDao.wordsSentenceList(id, word));
        }
    }

    public static class DayCompare {
        private int year;
        private int month;
        private int day;

        public DayCompare(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        @Override
        public String toString() {
            return "DayCompare{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}';
        }
    }

    /**
     * 计算2个日期之间相差的  相差多少年月日
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     * <p>
     * 计算两时间 年数、月数、天数
     * ① 先从天数开始计算，
     * ② 再计算两个时间的月份数
     * ③ 根据月份计算有几年
     * 测试： System.out.println(dayComparePrecise(DateUtil.parse("2012/01/14", "yyyy/MM/dd"), DateUtil.parse("2015/02/15", "yyyy/MM/dd")););
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static DayCompare dayComparePrecise(Date fromDate, Date toDate) {
        // 如果截止时间小于开始时间，则调换一下位置
        if (fromDate.after(toDate)) {
            Date temp = fromDate;
            fromDate = toDate;
            toDate = temp;
        }
        Calendar from = Calendar.getInstance();
        from.setTime(fromDate);
        Calendar to = Calendar.getInstance();
        to.setTime(toDate);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);

        int _months = (to.get(Calendar.YEAR) - from.get(Calendar.YEAR)) * 12 + to.get(Calendar.MONTH) - from.get(Calendar.MONTH); // 计算出的月份
        int d = toDay - fromDay;
        if (_months > 0 && d < 0) {
            // 当截止日期天数比起始日期小，计算截止日期上一个月的天数
            int monthTemp = to.get(Calendar.MONTH);
            to.set(Calendar.MONTH, monthTemp - 1);
            int _lastMonthDays = getDaysOfMonth(to.getTime());
            d = toDay + _lastMonthDays - fromDay;
            _months--;
        }
        int y = _months / 12;
        int m = _months % 12;
        return new DayCompare(y, m, d);
    }

    /**
     * JDK接口 计算某年某月多少天
     *
     * @param date 需要解析的时间
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    public void time() {

    }

    public void timeDiff() {
        try {
            String from = getPara("from");
            String to = getPara("to");
            DateTime parseFrom = null;
            DateTime parseTo = null;
            try {
                parseFrom = DateUtil.parse(from, "yyyy/MM/dd");
                parseTo = DateUtil.parse(to, "yyyy/MM/dd");
            } catch (Exception e) {
//                e.printStackTrace();
                renderJson(e.getMessage());
                return;
            }
            DayCompare dayCompare = dayComparePrecise(parseFrom, parseTo);
            renderJson(dayCompare);
        } catch (Exception e) {
//            e.printStackTrace();
            renderJson(e.getMessage());
        }
    }

}



