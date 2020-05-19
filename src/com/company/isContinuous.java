package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,
 * 他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,
 * 然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * 思路：
 * 我们可以将大小王看成数字0
 * 第一步：先统计数组中0的个数  例如  1 3 0 0 5
 * 第二步：将数组排序后 然后统计数组中数字的间隔 例如 1 3 0 0 5中间隔数为（3-1-1）+（5-3-1）个
 * 第三步：判断0的个数是否大于等于间隔数，如果等于，则可以填补空缺，否则不行
 *
 * 注意数组中不能有重复的非0数字，否则构成不了顺子
 */
public class isContinuous {
    public boolean isContinuous(int[] numbers){
        if(numbers==null||numbers.length<5)
            return false;
        //统计0的个数
        int numberOfZero=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0)
                numberOfZero++;
        }
        //统计间隔的个数
        Arrays.sort(numbers);
        int numberOfSpace=0;
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==0)
                continue;
            if(numbers[i]==numbers[i+1])
                return false;
            numberOfSpace+=numbers[i+1]-numbers[i]-1;
        }
        return numberOfZero>=numberOfSpace?true:false;
    }
}
