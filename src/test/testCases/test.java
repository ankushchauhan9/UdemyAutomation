package test.testCases;

import java.util.ArrayList;

public class test {

    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]){

        System.out.println("hello");
        System.out.println("Goodbye");
        System.out.println("Good nyt");
        test t1 = new test();
        t1.setAge(20);
        t1.setName("john");

        test t2 = new test();
        t2.setAge(16);
        t2.setName("Alex");

        test t3 = new test();
        t3.setAge(18);
        t3.setName("johnny");

        test t4 = new test();
        t4.setName("Brad");
        t4.setAge(15);

        ArrayList<test> al = new ArrayList<test>();
        al.add(t1);
        al.add(t2);
        al.add(t3);
        al.add(t4);

       // al.stream().collect(Collectors.groupingBy(test::getAge)).values().stream().filter(s->);

      //  System.out.println("Before");
       // Map<Integer, List<test>> al2 =  al.stream().sorted().collect(Collectors.groupingBy(test::getAge));
      // al.stream().forEach(s->System.out.println(s.getName()));
        System.out.println(al);

    }

    public static test compare(test t){
        test tt = new test();
        int maxAge =0;

        if(t.getAge() > maxAge){
                tt.setAge(t.getAge());
                tt.setName(t.getName());
                maxAge = t.getAge();
        }
        return tt;
    }


}
