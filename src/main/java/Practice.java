import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Practice {

    public static void main(String[] args) {
//        long l = System.currentTimeMillis();
//
//        long last=1557222899109L;
//
//        long hour = (l - last) / 1000 / 60 / 60;
//        long minute = (l - last) / 1000 / 60;
//        long second = (l - last) / 1000 % 60;
//
//        //格式化时间
//        String hour_str = String.format("%0"+2+"d", hour);
//        String minute_str = String.format("%0"+2+"d", minute);
//        String second_str = String.format("%0"+2+"d", second);
//
//        System.out.println(hour_str+":"+minute_str+":"+second_str);

//        float f=229.48175F;
//        float final_distance = ((int) (f / 1000 * 100)) / 100;
//        System.out.println(final_distance);
//
//        DecimalFormat df = new DecimalFormat("#.00");
//         System.out.println(df.format(f/1000));
//
//        System.out.println(String.format("%.2f", f/1000));

        float a=0.127f;
        float b=5.81321f;

        float v = b / a;
        int c= (int) a;
        int d= (int) b;
//        System.out.println("c:"+c+"    d:"+d);

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(a));
        System.out.println(df.format(b));
        System.out.println(String.format("%.2f", a));
        System.out.println(String.format("%.2f", b));
    }
}
