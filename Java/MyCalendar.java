package Java;

import java.io.IOException;
import java.util.Scanner;

public class MyCalendar{
    public static void main(String[] args) throws IOException{
        System.out.println("HEllo Java World!");

        int year=1900, month=1; // default

        Scanner sc1 = new Scanner(System.in);
        do{
        System.out.println("년>");
        year=sc1.nextInt();
        System.out.println("월>");
        month=sc1.nextInt();
        if(1>month||month>12) System.out.println("Error : 정확한 월(1~12)을 입력하세요!!!");
        }while(1>month||month>12);

        sc1.close();
        print_calendar(year, month-1);
        print_calendar(year, month);
        print_calendar(year, month+1);
        

    } // main end
    private static void print_calendar(int year, int month){
        char dow[]={'일','월','화','수','목','금','토'};
        char m_first;
        if(month==0) {
            month=12;
            year-=1;
        }
        if(month==13) {
            month=1;
            year+=1;
        }
        System.out.println(year+"년 "+month+"월");
        for (char c : dow) {
            System.out.print(c+"\t");
        }
        System.out.println();
        m_first=dow[calculate_first(year, month)];
        switch(m_first){

            case '일':
            for(int i =1 ; i<=28; i++){
                System.out.printf("%d\t",i);
                if(i%7==0) System.out.println();
            }
            print_after_28(year,month);
            break;

            case '월':
            System.out.println("\t1\t2\t3\t4\t5\t6");
            for(int i =7 ; i<=28; i++){
                System.out.printf("%d\t",i);
                if(i%7==6) System.out.println();
            }
            print_after_28(year,month);
            break;

            case '화':
            System.out.println("\t\t1\t2\t3\t4\t5");
            for(int i =6 ; i<=28; i++){
                System.out.printf("%d\t",i);
                if(i%7==5) System.out.println();
            }
            print_after_28(year,month);
            break;

            case '수':
            System.out.println("\t\t\t1\t2\t3\t4");
            for(int i =5 ; i<=28; i++){
                System.out.printf("%d\t",i);
                if(i%7==4) System.out.println();
            }
            print_after_28(year,month);
            break;

            case '목':
            System.out.println("\t\t\t\t1\t2\t3");
            for(int i =4 ; i<=28; i++){
                System.out.printf("%d\t",i);
                if(i%7==3) System.out.println();
            }
            print_after_28(year,month);
            break;

            case '금':
            System.out.println("\t\t\t\t\t1\t2");
            for(int i =3 ; i<=28; i++){
                System.out.printf("%d\t",i);
                if(i%7==2) System.out.println();
            }
            print_after_28('금',year,month);
            break;

            case '토':
            System.out.println("\t\t\t\t\t\t1");
            for(int i =2 ; i<=28; i++){
                System.out.printf("%d\t",i);
                if(i%7==1) System.out.println();
            }
            print_after_28('토',year,month);
            break;
            default:
            System.out.println("Error : 잘못된 요일!!!");
    }
    
    }
    private static int calculate_first(int year,int month){
        int m_first=1;
        int sub_m=0;
        if(year>=1900){
            for(int i=1900;i<year;i++){
                m_first++;
                if(i%4==0&&(i%100!=0||i%400==0))
                    m_first++;
            }
            sub_m=month-1;
            if(sub_m>=1) m_first+=31;
            if(sub_m>=2) {
                if(year%4==0&&(year%100!=0||year%400==0))
                    m_first+=29;
                else
                    m_first+=28;
            }
            if(sub_m>=3) m_first+=31;
            if(sub_m>=4) m_first+=30;
            if(sub_m>=5) m_first+=31;
            if(sub_m>=6) m_first+=30;
            if(sub_m>=7) m_first+=31;
            if(sub_m>=8) m_first+=31;
            if(sub_m>=9) m_first+=30;
            if(sub_m>=10) m_first+=31;
            if(sub_m>=11) m_first+=30;

            m_first%=7;
            
        } else if(year<1900){
            for(int i=1900;i<year;i--){
                m_first--;
                if(i%4==0&&(i%100!=0||i%400==0))
                    m_first--;
            }
            sub_m=12-month;
            if(sub_m>=0) m_first-=31;
            if(sub_m>=1) m_first-=30;
            if(sub_m>=2) m_first-=31;
            if(sub_m>=3) m_first-=30;
            if(sub_m>=4) m_first-=31;
            if(sub_m>=5) m_first-=31;
            if(sub_m>=6) m_first-=30;
            if(sub_m>=7) m_first-=31;
            if(sub_m>=8) m_first-=30;
            if(sub_m>=9) m_first-=31;
            if(sub_m>=10) {
                if(year%4==0&&(year%100!=0||year%400==0))
                    m_first-=29;
                else
                    m_first-=28;
            }

            m_first=(m_first%7)+7;
        }

        return m_first;
    }
    private static void print_after_28(int year,int month){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            System.out.println("29\t30\t31");
        else if(month==4||month==6||month==9||month==11)
            System.out.println("29\t30");
        else if(month==2&&year%4==0&&(year%100!=0||year%400==0))
            System.out.println("29");
    }
    private static void print_after_28(char dow,int year,int month){
        if(dow=='금'){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            System.out.println("29\t30\n31");
        else if(month==4||month==6||month==9||month==11)
            System.out.println("29\t30");
        else if(month==2&&year%4==0&&(year%100!=0||year%400==0))
            System.out.println("29");
        }
        else if(dow=='토'){
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            System.out.println("29\n30\t31");
        else if(month==4||month==6||month==9||month==11)
            System.out.println("29\n30");
        else if(month==2&&year%4==0&&(year%100!=0||year%400==0))
            System.out.println("29");
        }
    }
}