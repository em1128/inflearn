
import java.util.Scanner;

/* 

hw2_자판기를 만들어보세요.

자판기의 상품은 음료수1 1000원, 음료수2 500원, 음료수3 400원 입니다. 

자판기에 투입할 수 있는 화폐는  1000원, 500원, 100원 입니다.

자판기는 최대 5000원까지 화폐를 입력할 수 있습니다. 

1을 누르면 음료수1, 2를 누르면 음료수2, 3을 누르면 음료수3을 판매하고 0을  누르면 거스름을 반환하고 판매를 종료합니다.

거스름은 큰 화폐순으로 개수를 계산해서 출력합니다. 

 

* 거스름 예

5000원 입금, 음료수1 1개, 음료수2 2개, 음료수3 1개 샀을 때, 

1000원 2개, 500월 1개, 100원 1개

 

 

* 메뉴의 예

======================================

선택메뉴:

--------------------------------------

0) 입금

1) 음료수1 1000원 

2) 음료수2 500원 

3) 음료수3 400원

9) 거스름(종료)

현재 투입금액:  4000 원

--------------------------------------

선택된 메뉴항목

1) 음료수1 개수:  1 개 

2) 음료수2 개수:  1 개 

3) 음료수3 개수:  1 개 

======================================

*/

public class hw2 {

 

	public static void main(String[] args) {

		System.out.println("======================================");

		System.out.println("맛있는 자판기 v1.0 - 한국it 5F");

		System.out.println("======================================");

		System.out.println(">>  동전을 넣어주세요! ");

		Scanner sc1 = new Scanner(System.in);

		System.out.print("> ");

		int m = sc1.nextInt();

		if(m<0) {

			System.out.println("잘못 입력했습니다. 종료합니다!!");

			System.exit(0);

		}

		int s=9;

		int m1000=0;

		int m500=0;

		int m100=0;

		int m50=0;

		int m10=0;

		do {

			 s = menu(m);

			 if(s==0) {

				 System.out.println("동전을 투입하세요");

				 System.out.print("> ");

				 m += sc1.nextInt();

			 }

			 if(s==1) {

				 if(m>1000) {

					 m-=1000;

					 System.out.println("뜨르륵~ 음료수1 !! (1000원)");

				 }else {

					 System.out.println("돈이 모잘라요!!");

				 }

			 }

			 if(s==2) {

				 if(m>500) {

					 m-=500;

					 System.out.println("뜨르륵~ 음료수2 !! (500원)");

				 }else {

					 System.out.println("돈이 모잘라요!!");

				 }

			 }

			 if(s==3) {

				 if(m>400) {

					 m-=400;

					 System.out.println("뜨르륵~ 음료수3 !! (400원)");

				 }else {

					 System.out.println("돈이 모잘라요!!");

				 }

			 }

			 if(s==9) {

				 System.out.println("거스름돈 받으세요!!");

				 System.out.println(m+"원");

				 //2660

				 m1000=m/1000;//2

				 //m-=m1000*1000;

				 m=m%1000;

				 System.out.println("1000원 개수:" + m1000);

				 m500=m/500;//2

				 m-=m500*500;

				 System.out.println("500원 개수:" + m500);

				 m100=m/100;//2

				 m-=m100*100;

				 System.out.println("100원 개수:" + m100);

				 m50=m/50;//2

				 m-=m50*50;

				 System.out.println("50원 개수:" + m50);

				 m10=m/10;//2

				 m-=m10*10;

				 System.out.println("10원 개수:" + m10);

				 break;

			 }

			 if(s!=0||s!=1||s!=2||s!=3||s!=9) {

				 continue;

			 }

			

		}while(s<9);

		System.out.println("자판기 사용이 끝났습니다.");

		System.exit(0);

	}

 

	private static int menu(int m) {

		Scanner sc2=  new Scanner(System.in);

		// TODO Auto-generated method stub

		System.out.println("======================================");

		System.out.println("선택메뉴:");

		System.out.println("--------------------------------------");

		System.out.println(" 0) 입금");

		System.out.println(" 1) 음료수1 1000원"); 

		System.out.println(" 2) 음료수2 500원"); 

		System.out.println(" 3) 음료수3 400원");

		System.out.println(" 9) 거스름(종료)");

		System.out.println(" 현재 투입금액:  "+ m +"원");

		System.out.println("--------------------------------------");

		

		System.out.println("메뉴를 선택해주세요");

		System.out.print("> ");

		

		int s= sc2.nextInt();

		

		return s;

	}

}