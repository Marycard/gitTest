package future;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        UserCondition condition = new UserCondition("John", "30", "Male");
        List<TripMethods> methods;



// 不同出行方案
        Future<List<TripMethods>> tripMethodsFuture =  executor.submit(() -> searchMethods(condition));

        methods = tripMethodsFuture.get();

        List<Future<List<HotelChoose>>> hotelsFutureList= new ArrayList<>();
        //根据方案选择酒店
        for (TripMethods method : methods) {
            Future<List<HotelChoose>> hotelsListsFuture = executor.submit(() -> searchHotel(new HotelChoose("100","200")));
            hotelsFutureList.add(hotelsListsFuture);
        }

        for (Future<List<HotelChoose>> hotelFuture: hotelsFutureList) {

            List<HotelChoose> hotles = hotelFuture.get();
            for (HotelChoose hotel: hotles) {
                //计算每个交通方案对应酒店的价格
            }

        }


    }

    public static class UserCondition {
        private String name;
        private String age;
        private String sex;

        public UserCondition(String name, String age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String toString() {
            return "name:" + name + ",age:" + age + ",sex:" + sex;
        }
    }
    public static class TripMethods {
        private String tripMethod;

        public TripMethods(String tripMethod) {
            this.tripMethod = tripMethod;
        }

        public String toString() {
            return tripMethod;
        }
    }
    public static class HotelChoose {
        private String price;
        private String area;

        public HotelChoose(String price, String area) {
            this.area = area;
            this.price = price;
        }
    }

    private static List<TripMethods> searchMethods(UserCondition condition) {
        System.out.println("Searching methods for " + condition);

        List<TripMethods> tripMethodsList = new ArrayList<>();


        tripMethodsList.add(new TripMethods("Car"));
        tripMethodsList.add(new TripMethods("Bus"));
        tripMethodsList.add(new TripMethods("Train"));

        return tripMethodsList;
    }

    private static List<HotelChoose> searchHotel(HotelChoose hotelCondition) {
        List<HotelChoose> hotelChooseList = new ArrayList<>();

        hotelChooseList.add(new HotelChoose("100", "300"));
        hotelChooseList.add(new HotelChoose("200", "500"));
        hotelChooseList.add(new HotelChoose("300", "600"));

        return hotelChooseList;
    }

}
